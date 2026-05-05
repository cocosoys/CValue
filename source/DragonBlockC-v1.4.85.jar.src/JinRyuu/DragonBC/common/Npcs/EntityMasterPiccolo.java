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
/*    */ public class EntityMasterPiccolo extends EntityDBCKami {
/* 12 */   public int randomSoundDelay = 0;
/*    */ 
/*    */   
/*    */   public EntityMasterPiccolo(World par1World) {
/* 16 */     super(par1World);
/* 17 */     this.field_70728_aV = 5;
/* 18 */     this.name = "Master Piccolo";
/*    */   }
/*    */   
/*    */   protected void func_110147_ax() {
/* 22 */     super.func_110147_ax();
/* 23 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(1000.0D);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_70085_c(EntityPlayer par1EntityPlayer) {
/* 31 */     ItemStack var2 = par1EntityPlayer.field_71071_by.func_70448_g();
/* 32 */     boolean var3 = (var2 != null);
/*    */     
/* 34 */     if (func_70089_S()) {
/*    */       
/* 36 */       par1EntityPlayer.openGui(mod_DragonBC.instance, 20, par1EntityPlayer.field_70170_p, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v);
/* 37 */       return true;
/*    */     } 
/*    */ 
/*    */     
/* 41 */     return super.func_70085_c(par1EntityPlayer);
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
/* 52 */     return "jinryuudragonbc:npcs/piccolo1.png";
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\EntityMasterPiccolo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */