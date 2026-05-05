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
/*    */ 
/*    */ public class EntityMasterKami
/*    */   extends EntityDBCKami
/*    */ {
/* 15 */   public int randomSoundDelay = 0;
/*    */ 
/*    */ 
/*    */   
/*    */   public EntityMasterKami(World par1World) {
/* 20 */     super(par1World);
/* 21 */     this.field_70728_aV = 5;
/* 22 */     this.name = "Master Kami";
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void func_110147_ax() {
/* 33 */     super.func_110147_ax();
/* 34 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(1000.0D);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_70085_c(EntityPlayer par1EntityPlayer) {
/* 42 */     ItemStack var2 = par1EntityPlayer.field_71071_by.func_70448_g();
/* 43 */     boolean var3 = (var2 != null);
/*    */     
/* 45 */     if (func_70089_S()) {
/*    */ 
/*    */       
/* 48 */       par1EntityPlayer.openGui(mod_DragonBC.instance, 11, par1EntityPlayer.field_70170_p, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v);
/*    */ 
/*    */ 
/*    */       
/* 52 */       return true;
/*    */     } 
/*    */ 
/*    */     
/* 56 */     return super.func_70085_c(par1EntityPlayer);
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
/* 67 */     return "jinryuudragonbc:npcs/kami.png";
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\EntityMasterKami.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */