package net.minecraft.entity.ai.attributes;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Collection;
import java.util.UUID;

public interface IAttributeInstance {
  IAttribute func_111123_a();
  
  double func_111125_b();
  
  void func_111128_a(double paramDouble);
  
  Collection func_111122_c();
  
  AttributeModifier func_111127_a(UUID paramUUID);
  
  void func_111121_a(AttributeModifier paramAttributeModifier);
  
  void func_111124_b(AttributeModifier paramAttributeModifier);
  
  @SideOnly(Side.CLIENT)
  void func_142049_d();
  
  double func_111126_e();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\ai\attributes\IAttributeInstance.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */