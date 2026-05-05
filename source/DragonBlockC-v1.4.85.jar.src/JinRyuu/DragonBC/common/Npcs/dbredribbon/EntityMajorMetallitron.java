/*    */ package JinRyuu.DragonBC.common.Npcs.dbredribbon;
/*    */ import JinRyuu.DragonBC.common.DBCConfig;
/*    */ import JinRyuu.JRMCore.entity.EntityPrjtls_1;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.SharedMonsterAttributes;
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class EntityMajorMetallitron extends EntityRedRibbon2 {
/* 13 */   public final int AttPow = 50;
/* 14 */   public final int HePo = 200;
/*    */   private byte damageCategory;
/*    */   
/*    */   public EntityMajorMetallitron(World world) {
/* 18 */     super(world);
/* 19 */     func_70105_a(1.2F, 5.0F);
/* 20 */     this.texture = "major_metallitron";
/* 21 */     setAttributes(DBCConfig.RRMajorDAM, DBCConfig.RRMajorHP, 50, 200);
/* 22 */     this.damageCategory = 0;
/*    */   }
/*    */   
/*    */   protected void func_110147_ax() {
/* 26 */     super.func_110147_ax();
/* 27 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(200.0D);
/* 28 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(50.0D);
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public String getTexture() {
/* 32 */     return "jinryuudragonbc:npcs/major_metallitron" + ((this.damageCategory > 0) ? (String)Integer.valueOf(this.damageCategory + 1) : "") + ".png";
/*    */   }
/*    */   public void writeSpawnData(ByteBuf additionalData) {
/* 35 */     additionalData.writeByte(this.damageCategory);
/*    */   }
/*    */   
/*    */   public void readSpawnData(ByteBuf additionalData) {
/* 39 */     this.damageCategory = additionalData.readByte();
/*    */   }
/*    */   
/*    */   public void func_70014_b(NBTTagCompound par1NBTTagCompound) {
/* 43 */     par1NBTTagCompound.func_74774_a("damageCategory", this.damageCategory);
/*    */   }
/*    */   
/*    */   public void func_70037_a(NBTTagCompound par1NBTTagCompound) {
/* 47 */     this.damageCategory = (byte)(par1NBTTagCompound.func_74771_c("damageCategory") & 0xFF);
/*    */   }
/*    */   
/*    */   public void func_70071_h_() {
/* 51 */     super.func_70071_h_();
/*    */     
/* 53 */     int currentHealth = (int)func_110143_aJ();
/* 54 */     int maxHealth = (int)func_110148_a(SharedMonsterAttributes.field_111267_a).func_111126_e();
/* 55 */     this.damageCategory = (byte)((maxHealth - currentHealth) / maxHealth / 3);
/* 56 */     if (this.damageCategory < 0) { this.damageCategory = 0; }
/* 57 */     else if (this.damageCategory > 2) { this.damageCategory = 2; }
/*    */     
/* 59 */     if (!this.field_70170_p.field_72995_K && !this.field_70128_L && this.field_70789_a != null && this.field_70789_a.func_70089_S() && this.field_70789_a.func_70032_d((Entity)this) < 25.0F)
/*    */     {
/* 61 */       if ((this.field_70173_aa + 200) % 400 < 30) {
/*    */         
/* 63 */         EntityPrjtls_1 var8 = new EntityPrjtls_1(this.field_70170_p, (Entity)this, this.field_70789_a, 1.8F, 1.0F, 6);
/* 64 */         this.field_70170_p.func_72956_a((Entity)this, "jinryuudragonbc:DBC5.gun_shot_single", 0.2F, this.field_70170_p.field_73012_v.nextFloat() * 0.1F + 0.9F);
/* 65 */         this.field_70170_p.func_72838_d((Entity)var8);
/*    */       } 
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\dbredribbon\EntityMajorMetallitron.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */