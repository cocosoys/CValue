/*    */ package JinRyuu.DragonBC.common.Npcs;
/*    */ 
/*    */ import JinRyuu.DragonBC.common.mod_DragonBC;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.entity.SharedMonsterAttributes;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class EntityMasterBabidi
/*    */   extends EntityDBCKami {
/* 13 */   public final int AttPow = 300;
/* 14 */   public final int HePo = 1120;
/*    */ 
/*    */   
/*    */   public EntityMasterBabidi(World par1World) {
/* 18 */     super(par1World);
/* 19 */     this.name = "Master Babidi";
/*    */     
/* 21 */     if (this.field_71093_bK != 22 && this.field_71093_bK != 24) {
/*    */       
/* 23 */       this.safezoneRadiusXZ = 20;
/* 24 */       this.safezoneRadiusY = 20;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_110147_ax() {
/* 30 */     super.func_110147_ax();
/* 31 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(1120.0D);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_70085_c(EntityPlayer par1EntityPlayer) {
/* 36 */     ItemStack var2 = par1EntityPlayer.field_71071_by.func_70448_g();
/* 37 */     boolean var3 = (var2 != null);
/*    */     
/* 39 */     if (func_70089_S()) {
/*    */       
/* 41 */       par1EntityPlayer.openGui(mod_DragonBC.instance, 19, par1EntityPlayer.field_70170_p, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v);
/* 42 */       return true;
/*    */     } 
/*    */ 
/*    */     
/* 46 */     return super.func_70085_c(par1EntityPlayer);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public String getTexture() {
/* 53 */     return "jinryuudragonbc:npcs/babidi.png";
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\EntityMasterBabidi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */