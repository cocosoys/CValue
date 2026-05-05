/*    */ package JinRyuu.DragonBC.common.Items;
/*    */ 
/*    */ import JinRyuu.DragonBC.common.mod_DragonBC;
/*    */ import com.google.common.collect.Multimap;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.SharedMonsterAttributes;
/*    */ import net.minecraft.entity.ai.attributes.AttributeModifier;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.item.ItemSword;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ItemBraveSword
/*    */   extends ItemSword
/*    */ {
/*    */   private float weaponDamage;
/*    */   
/*    */   public ItemBraveSword(Item.ToolMaterial tm) {
/* 24 */     super(tm);
/* 25 */     func_77656_e(600);
/* 26 */     func_77637_a(mod_DragonBC.DragonBlockC);
/* 27 */     this.weaponDamage = 1.0F;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_77663_a(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5) {}
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getTextureFile() {
/* 42 */     return "jinryuudragonbc:";
/*    */   }
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_94581_a(IIconRegister par1IconRegister) {
/* 48 */     this.field_77791_bV = par1IconRegister.func_94245_a("jinryuudragonbc:" + func_77658_a());
/*    */   }
/*    */ 
/*    */   
/*    */   public Multimap func_111205_h() {
/* 53 */     Multimap multimap = super.func_111205_h();
/* 54 */     multimap.put(SharedMonsterAttributes.field_111264_e.func_111108_a(), new AttributeModifier(field_111210_e, "Weapon modifier", this.weaponDamage, 0));
/* 55 */     return multimap;
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Items\ItemBraveSword.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */