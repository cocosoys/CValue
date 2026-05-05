/*    */ package JinRyuu.DragonBC.common.Npcs.dbredribbon;
/*    */ 
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
/*    */ public class EntityRedRibbon2 extends EntityDBCWildlifeA implements IMob, IEntityAdditionalSpawnData {
/* 16 */   public final int AttPow = 5;
/* 17 */   public final int HePo = 20;
/*    */   
/*    */   public String texture;
/*    */   
/*    */   public EntityRedRibbon2(World world) {
/* 22 */     super(world);
/* 23 */     this.field_70728_aV = 10;
/* 24 */     func_70105_a(0.6F, 2.0F);
/* 25 */     this.texture = "";
/* 26 */     this.canFly = false;
/* 27 */     this.canFireKiAttacks = false;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setAttributes(int damage, int health) {
/* 32 */     if (damage != 5 || health != 20) {
/*    */       
/* 34 */       getEntityData().func_74780_a("jrmcSpawnInitiatedCAT", damage);
/* 35 */       getEntityData().func_74780_a("jrmcSpawnInitiatedCHP", health);
/*    */     } 
/*    */   }
/*    */   
/*    */   protected void func_110147_ax() {
/* 40 */     super.func_110147_ax();
/* 41 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(20.0D);
/* 42 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(5.0D);
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
/* 53 */     return "jinryuudragonbc:npcs/" + this.texture + ".png";
/*    */   }
/*    */   public boolean func_70601_bi() {
/* 56 */     return (this.field_70170_p.func_72855_b(this.field_70121_D) && this.field_70170_p.func_72945_a((Entity)this, this.field_70121_D).isEmpty() && !this.field_70170_p.func_72953_d(this.field_70121_D));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void func_70628_a(boolean par1, int par2) {}
/*    */ 
/*    */   
/*    */   public boolean func_70085_c(EntityPlayer par1EntityPlayer) {
/* 65 */     return false; } protected boolean func_70692_ba() {
/* 66 */     return true;
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


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\dbredribbon\EntityRedRibbon2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */