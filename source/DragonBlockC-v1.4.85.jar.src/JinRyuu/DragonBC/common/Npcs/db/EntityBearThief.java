/*    */ package JinRyuu.DragonBC.common.Npcs.db;
/*    */ 
/*    */ import JinRyuu.DragonBC.common.DBCConfig;
/*    */ import JinRyuu.DragonBC.common.Npcs.EntityDBCWildlifeA;
/*    */ import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.SharedMonsterAttributes;
/*    */ import net.minecraft.entity.monster.IMob;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class EntityBearThief extends EntityDBCWildlifeA implements IMob, IEntityAdditionalSpawnData {
/* 17 */   public final int AttPow = 35;
/* 18 */   public final int HePo = 200;
/*    */ 
/*    */ 
/*    */   
/*    */   public EntityBearThief(World par1World) {
/* 23 */     super(par1World);
/* 24 */     this.field_70728_aV = 10;
/*    */ 
/*    */     
/* 27 */     func_70105_a(0.90000004F, 3.3000002F);
/* 28 */     setAttributes(DBCConfig.BearThiefHP, DBCConfig.BearThiefHP, 35, 200);
/*    */   }
/*    */   
/*    */   protected void func_110147_ax() {
/* 32 */     super.func_110147_ax();
/* 33 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(200.0D);
/* 34 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(35.0D);
/*    */   }
/*    */   public void func_70071_h_() {
/* 37 */     super.func_70071_h_();
/*    */   } @SideOnly(Side.CLIENT)
/*    */   public String getTexture() {
/* 40 */     return "jinryuudragonbc:npcs/bear_thief.png";
/*    */   }
/*    */   public boolean func_70601_bi() {
/* 43 */     return (this.field_70170_p.func_72855_b(this.field_70121_D) && this.field_70170_p.func_72945_a((Entity)this, this.field_70121_D).isEmpty() && !this.field_70170_p.func_72953_d(this.field_70121_D));
/*    */   }
/*    */   protected Entity func_70782_k() {
/* 46 */     return super.func_70782_k();
/*    */   } public void func_70636_d() {
/* 48 */     super.func_70636_d();
/*    */   }
/*    */   
/*    */   protected void func_70628_a(boolean par1, int par2) {}
/* 52 */   public boolean func_70085_c(EntityPlayer par1EntityPlayer) { return false; } protected boolean func_70692_ba() {
/* 53 */     return true;
/*    */   }
/*    */   
/*    */   public void writeSpawnData(ByteBuf additionalData) {}
/*    */   
/*    */   public void readSpawnData(ByteBuf additionalData) {}
/*    */   
/*    */   public void func_70014_b(NBTTagCompound par1NBTTagCompound) {}
/*    */   
/*    */   public void func_70037_a(NBTTagCompound par1NBTTagCompound) {}
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\db\EntityBearThief.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */