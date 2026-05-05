$ErrorActionPreference = "Stop"

function New-Directory {
    param(
        [Parameter(Mandatory = $true)]
        [string]$Path
    )

    if (-not (Test-Path -LiteralPath $Path)) {
        New-Item -ItemType Directory -Path $Path | Out-Null
    }
}

$root = Split-Path -Parent $MyInvocation.MyCommand.Path
$srcDir = Join-Path $root "src"
$resDir = Join-Path $root "resources"
$buildDir = Join-Path $root ".build-recvalue"
$classesRootDir = Join-Path $buildDir "classes"
$classesDir = Join-Path $classesRootDir ([Guid]::NewGuid().ToString("N"))
$distDir = Join-Path $buildDir "dist"
$jarPath = Join-Path $distDir "ReCValue.jar"

$javaHome8 = $env:JAVA_HOME8
if ([string]::IsNullOrWhiteSpace($javaHome8)) {
    throw "JAVA_HOME8 is not set. This build requires the system variable %JAVA_HOME8%."
}

$javacExe = Join-Path $javaHome8 "bin\javac.exe"
$jarExe = Join-Path $javaHome8 "bin\jar.exe"

foreach ($tool in @($javacExe, $jarExe)) {
    if (-not (Test-Path -LiteralPath $tool)) {
        throw "Missing JDK8 tool: $tool"
    }
}

$dependencies = [ordered]@{
    craftbukkit = Join-Path $root "libs\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar"
    forge       = Join-Path $root "libs\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar"
    jrmcore     = Join-Path $root "libs\JRMCore-v1.3.51.jar"
    dragonbc    = Join-Path $root "libs\DragonBlockC-v1.4.85.jar"
    jbra        = Join-Path $root "libs\JBRA-Client-v1.6.52.jar"
    jfamily     = Join-Path $root "libs\JFamilyC-v1.2.18.jar"
    jyears      = Join-Path $root "libs\JYearsC-v1.2.5.jar"
}

$missingDependencies = @(
    foreach ($entry in $dependencies.GetEnumerator()) {
        if (-not (Test-Path -LiteralPath $entry.Value)) {
            $entry.Value
        }
    }
)

if ($missingDependencies.Count -gt 0) {
    throw ("Missing repo-local dependency jar(s):`n - " + ($missingDependencies -join "`n - "))
}

$compileClasspath = ($dependencies.Values) -join ";"

New-Directory -Path $classesRootDir
New-Directory -Path $classesDir
New-Directory -Path $distDir

$javaFiles = Get-ChildItem -LiteralPath $srcDir -Recurse -Filter *.java | Select-Object -ExpandProperty FullName
if (-not $javaFiles) {
    throw "No Java sources found under $srcDir"
}

& $javacExe -encoding UTF-8 -source 8 -target 8 -cp $compileClasspath -d $classesDir $javaFiles
if ($LASTEXITCODE -ne 0) {
    throw "javac failed"
}

if (Test-Path -LiteralPath $resDir) {
    Copy-Item -Path (Join-Path $resDir "*") -Destination $classesDir -Recurse -Force
}

$modMetadata = Join-Path $srcDir "modid.info"
if (Test-Path -LiteralPath $modMetadata) {
    Copy-Item -LiteralPath $modMetadata -Destination (Join-Path $classesDir "modid.info") -Force
}

& $jarExe cf $jarPath -C $classesDir .
if ($LASTEXITCODE -ne 0) {
    throw "jar packaging failed"
}

Write-Output "Build succeeded: $jarPath"
Write-Output "Build JDK8: $javaHome8"
