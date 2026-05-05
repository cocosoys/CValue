/*    */ package JinRyuu.DragonBC.common.Npcs;
/*    */ 
/*    */ import JinRyuu.DragonBC.common.DBCConfig;
/*    */ import JinRyuu.DragonBC.common.mod_DragonBC;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.entity.SharedMonsterAttributes;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ public class EntityMasterEnma
/*    */   extends EntityDBCKami
/*    */ {
/* 16 */   public int randomSoundDelay = 0;
/*    */ 
/*    */ 
/*    */   
/*    */   public EntityMasterEnma(World par1World) {
/* 21 */     super(par1World);
/*    */     
/* 23 */     this.field_70728_aV = 0;
/* 24 */     this.field_70130_N = 2.0F * DBCConfig.EnmaScale;
/* 25 */     this.field_70131_O = 4.0F * DBCConfig.EnmaScale;
/* 26 */     this.name = "Master Enma";
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void func_110147_ax() {
/* 36 */     super.func_110147_ax();
/* 37 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(10000.0D);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_70085_c(EntityPlayer par1EntityPlayer) {
/* 44 */     ItemStack var2 = par1EntityPlayer.field_71071_by.func_70448_g();
/* 45 */     boolean var3 = (var2 != null);
/*    */     
/* 47 */     if (func_70089_S()) {
/*    */ 
/*    */       
/* 50 */       par1EntityPlayer.openGui(mod_DragonBC.instance, 10, par1EntityPlayer.field_70170_p, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v);
/*    */ 
/*    */ 
/*    */       
/* 54 */       return true;
/*    */     } 
/*    */ 
/*    */     
/* 58 */     return super.func_70085_c(par1EntityPlayer);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public String getTexture() {
/* 69 */     return "jinryuudragonbc:npcs/enma.png";
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\EntityMasterEnma.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */