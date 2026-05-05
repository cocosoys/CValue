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
/*    */ public class EntityMasterWhis
/*    */   extends EntityDBCKami {
/* 13 */   public int randomSoundDelay = 0;
/*    */   
/*    */   public EntityMasterWhis(World par1World) {
/* 16 */     super(par1World);
/* 17 */     this.field_70728_aV = 0;
/* 18 */     this.name = "Master Whis";
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_110147_ax() {
/* 23 */     super.func_110147_ax();
/* 24 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(6000.0D);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_70085_c(EntityPlayer par1EntityPlayer) {
/* 31 */     ItemStack var2 = par1EntityPlayer.field_71071_by.func_70448_g();
/* 32 */     boolean var3 = (var2 != null);
/* 33 */     if (func_70089_S()) {
/* 34 */       par1EntityPlayer.openGui(mod_DragonBC.instance, 9002, par1EntityPlayer.field_70170_p, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v);
/* 35 */       return true;
/*    */     } 
/* 37 */     return super.func_70085_c(par1EntityPlayer);
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public String getTexture() {
/* 41 */     return "jinryuudragonbc:npcs/whis.png";
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\EntityMasterWhis.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */