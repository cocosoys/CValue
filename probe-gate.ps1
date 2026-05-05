$ErrorActionPreference = "Stop"

$root = Split-Path -Parent $MyInvocation.MyCommand.Path
$buildDir = Join-Path $root ".build-recvalue"
$jarPath = Join-Path $buildDir "dist\ReCValue.jar"
$reportPath = Join-Path $root ".omx\plans\rebuild-verification-recvalue.md"

& (Join-Path $root "build.ps1")
if ($LASTEXITCODE -ne 0) {
    throw "Build step failed"
}

if (-not (Test-Path -LiteralPath $jarPath)) {
    throw "Missing build artifact: $jarPath"
}

$javaHome8 = $env:JAVA_HOME8
if ([string]::IsNullOrWhiteSpace($javaHome8)) {
    throw "JAVA_HOME8 is not set. This probe requires the system variable %JAVA_HOME8%."
}

$jarExe = Join-Path $javaHome8 "bin\jar.exe"
if (-not (Test-Path -LiteralPath $jarExe)) {
    throw "Missing JDK8 jar tool: $jarExe"
}

$jarListing = & $jarExe tf $jarPath
if ($LASTEXITCODE -ne 0) {
    throw "Unable to inspect jar contents"
}

$requiredEntries = @(
    "com/cvalue/ReCValue.class",
    "com/cvalue/base/Base.class",
    "com/cvalue/api/CValueAPI.class",
    "modid.info"
)

$missingEntries = @(
    foreach ($entry in $requiredEntries) {
        if (-not ($jarListing -contains $entry)) {
            $entry
        }
    }
)

$lines = @(
    "# ReCValue Rebuild Verification",
    "",
    "- Artifact: $jarPath",
    "- Build JDK8: $javaHome8",
    "- Verification mode: jar content inspection after build",
    ""
)

if ($missingEntries.Count -eq 0) {
    $lines += "- Result: PASS"
} else {
    $lines += "- Result: FAIL"
}

$lines += ""
$lines += "## Required Entries"
$lines += ""

foreach ($entry in $requiredEntries) {
    if ($missingEntries -contains $entry) {
        $lines += "- FAIL: $entry"
    } else {
        $lines += "- PASS: $entry"
    }
}

$lines += ""
$lines += "## Notes"
$lines += ""
$lines += "- This verification checks that the reconstructed legacy source tree builds and is packaged."
$lines += "- It does not claim a live runtime bridge proof."

[System.IO.File]::WriteAllLines($reportPath, $lines, [System.Text.Encoding]::UTF8)

Write-Output "Rebuild verification finished."
Write-Output "Verification report written: $reportPath"
