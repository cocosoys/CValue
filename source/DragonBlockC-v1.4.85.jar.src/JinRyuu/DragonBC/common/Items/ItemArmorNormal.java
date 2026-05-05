/*    */ package JinRyuu.DragonBC.common.Items;
/*    */ 
/*    */ import JinRyuu.DragonBC.common.mod_DragonBC;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.item.ItemArmor;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.IIcon;
/*    */ 
/*    */ public class ItemArmorNormal
/*    */   extends ItemArmor
/*    */ {
/*    */   public String armorNamePrefix;
/*    */   public ItemArmor.ArmorMaterial field_77878_bZ;
/*    */   
/*    */   public ItemArmorNormal(ItemArmor.ArmorMaterial par2ArmorMaterial, int par3, int par4, String armornamePrefix) {
/* 19 */     super(par2ArmorMaterial, par3, par4);
/* 20 */     this.field_77878_bZ = par2ArmorMaterial;
/* 21 */     par2ArmorMaterial.func_78044_b(par4);
/* 22 */     func_77656_e(par2ArmorMaterial.func_78046_a(par4));
/* 23 */     this.field_77777_bU = 1;
/* 24 */     this.armorNamePrefix = armornamePrefix;
/* 25 */     func_77637_a(mod_DragonBC.DragonBlockC);
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public IIcon field_94604_cx1;
/*    */   private IIcon overlayIcon;
/*    */   private IIcon emptySlotIcon;
/* 32 */   private static final String[] CLOTH_OVERLAY_NAMES = new String[] { "leather_helmet_overlay", "leather_chestplate_overlay", "leather_leggings_overlay", "leather_boots_overlay" };
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_94581_a(IIconRegister par1IconRegister) {
/* 36 */     this.field_77791_bV = par1IconRegister.func_94245_a("jinryuudragonbc:" + func_77658_a().replaceAll("item.", "").toLowerCase());
/* 37 */     this.field_94604_cx1 = par1IconRegister.func_94245_a(field_94603_a[this.field_77881_a]);
/*    */     
/* 39 */     if (this.field_77878_bZ == ItemArmor.ArmorMaterial.CLOTH)
/*    */     {
/* 41 */       this.overlayIcon = par1IconRegister.func_94245_a(CLOTH_OVERLAY_NAMES[this.field_77881_a]);
/*    */     }
/* 43 */     this.emptySlotIcon = par1IconRegister.func_94245_a(field_94603_a[this.field_77881_a]);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
/* 66 */     String armor = "";
/* 67 */     if (stack.toString().toLowerCase().contains("pants") || stack.toString().toLowerCase().contains("leg"))
/* 68 */     { armor = "jinryuudragonbc:armor/" + this.armorNamePrefix + "_2.png"; }
/* 69 */     else { armor = "jinryuudragonbc:armor/" + this.armorNamePrefix + "_1.png"; }
/* 70 */      return armor;
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Items\ItemArmorNormal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */