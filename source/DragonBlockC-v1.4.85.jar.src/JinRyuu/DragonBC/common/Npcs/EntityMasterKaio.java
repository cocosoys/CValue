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
/*    */ public class EntityMasterKaio
/*    */   extends EntityDBCKami
/*    */ {
/*    */   public EntityMasterKaio(World par1World) {
/* 16 */     super(par1World);
/* 17 */     this.field_70728_aV = 0;
/* 18 */     this.name = "Master Kaio";
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void func_110147_ax() {
/* 28 */     super.func_110147_ax();
/* 29 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(6000.0D);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_70085_c(EntityPlayer par1EntityPlayer) {
/* 36 */     ItemStack var2 = par1EntityPlayer.field_71071_by.func_70448_g();
/* 37 */     boolean var3 = (var2 != null);
/* 38 */     if (func_70089_S()) {
/* 39 */       par1EntityPlayer.openGui(mod_DragonBC.instance, 12, par1EntityPlayer.field_70170_p, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v);
/* 40 */       return true;
/*    */     } 
/* 42 */     return super.func_70085_c(par1EntityPlayer);
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public String getTexture() {
/* 46 */     return "jinryuudragonbc:npcs/kaionorth.png";
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\EntityMasterKaio.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */