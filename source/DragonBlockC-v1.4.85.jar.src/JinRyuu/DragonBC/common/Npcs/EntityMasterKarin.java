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
/*    */ public class EntityMasterKarin
/*    */   extends EntityDBCKami
/*    */ {
/*    */   public EntityMasterKarin(World par1World) {
/* 15 */     super(par1World);
/* 16 */     this.name = "Master Karin";
/*    */   }
/*    */   
/*    */   protected void func_110147_ax() {
/* 20 */     super.func_110147_ax();
/* 21 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(400.0D);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_70085_c(EntityPlayer par1EntityPlayer) {
/* 26 */     ItemStack var2 = par1EntityPlayer.field_71071_by.func_70448_g();
/* 27 */     boolean var3 = (var2 != null);
/*    */     
/* 29 */     if (func_70089_S()) {
/*    */       
/* 31 */       par1EntityPlayer.openGui(mod_DragonBC.instance, 13, par1EntityPlayer.field_70170_p, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v);
/* 32 */       return true;
/*    */     } 
/*    */ 
/*    */     
/* 36 */     return super.func_70085_c(par1EntityPlayer);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public String getTexture() {
/* 45 */     return "jinryuudragonbc:npcs/karin.png";
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\EntityMasterKarin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */