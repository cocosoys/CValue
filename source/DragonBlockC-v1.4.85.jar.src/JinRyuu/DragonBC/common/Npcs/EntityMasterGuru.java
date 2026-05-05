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
/*    */ public class EntityMasterGuru
/*    */   extends EntityDBCKami {
/* 14 */   public int randomSoundDelay = 0;
/*    */   
/*    */   public EntityMasterGuru(World par1World) {
/* 17 */     super(par1World);
/* 18 */     this.field_70728_aV = 0;
/*    */ 
/*    */     
/* 21 */     func_70105_a(2.2F * DBCConfig.GuruScale, 2.1F * DBCConfig.GuruScale);
/* 22 */     this.name = "Master Guru";
/*    */   }
/*    */   public EntityMasterGuru(World par1World, int rot) {
/* 25 */     super(par1World);
/* 26 */     this.field_70728_aV = 0;
/*    */     
/* 28 */     this.holdRotation = rot;
/* 29 */     func_70105_a(2.2F * DBCConfig.GuruScale, 2.1F * DBCConfig.GuruScale);
/*    */   }
/*    */   
/*    */   protected void func_110147_ax() {
/* 33 */     super.func_110147_ax();
/* 34 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(6000.0D);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_70085_c(EntityPlayer par1EntityPlayer) {
/* 41 */     ItemStack var2 = par1EntityPlayer.field_71071_by.func_70448_g();
/* 42 */     boolean var3 = (var2 != null);
/* 43 */     if (func_70089_S()) {
/* 44 */       par1EntityPlayer.openGui(mod_DragonBC.instance, 9001, par1EntityPlayer.field_70170_p, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v);
/* 45 */       return true;
/*    */     } 
/* 47 */     return super.func_70085_c(par1EntityPlayer);
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public String getTexture() {
/* 51 */     return "jinryuudragonbc:npcs/guru.png";
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\EntityMasterGuru.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */