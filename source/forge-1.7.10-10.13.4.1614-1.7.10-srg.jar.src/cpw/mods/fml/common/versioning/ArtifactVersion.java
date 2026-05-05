package cpw.mods.fml.common.versioning;

public interface ArtifactVersion extends Comparable<ArtifactVersion> {
  String getLabel();
  
  String getVersionString();
  
  boolean containsVersion(ArtifactVersion paramArtifactVersion);
  
  String getRangeString();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\versioning\ArtifactVersion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */