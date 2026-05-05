/*    */ package net.minecraft.tileentity;
/*    */ 
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ import net.minecraft.network.Packet;
/*    */ import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class TileEntityMobSpawner
/*    */   extends TileEntity {
/* 11 */   private final MobSpawnerBaseLogic field_145882_a = new MobSpawnerBaseLogic(this)
/*    */     {
/*    */       public void func_98267_a(int p_98267_1_) {
/* 14 */         this.field_150825_a.field_145850_b.func_147452_c(this.field_150825_a.field_145851_c, this.field_150825_a.field_145848_d, this.field_150825_a.field_145849_e, Blocks.field_150474_ac, p_98267_1_, 0);
/*    */       }
/*    */       private static final String __OBFID = "CL_00000361";
/*    */       
/*    */       public World func_98271_a() {
/* 19 */         return this.field_150825_a.field_145850_b;
/*    */       }
/*    */ 
/*    */       
/*    */       public int func_98275_b() {
/* 24 */         return this.field_150825_a.field_145851_c;
/*    */       }
/*    */ 
/*    */       
/*    */       public int func_98274_c() {
/* 29 */         return this.field_150825_a.field_145848_d;
/*    */       }
/*    */ 
/*    */       
/*    */       public int func_98266_d() {
/* 34 */         return this.field_150825_a.field_145849_e;
/*    */       }
/*    */ 
/*    */       
/*    */       public void func_98277_a(MobSpawnerBaseLogic.WeightedRandomMinecart p_98277_1_) {
/* 39 */         super.func_98277_a(p_98277_1_);
/* 40 */         if (func_98271_a() != null) func_98271_a().func_147471_g(this.field_150825_a.field_145851_c, this.field_150825_a.field_145848_d, this.field_150825_a.field_145849_e);
/*    */       
/*    */       }
/*    */     };
/*    */ 
/*    */   
/*    */   private static final String __OBFID = "CL_00000360";
/*    */   
/*    */   public void func_145839_a(NBTTagCompound p_145839_1_) {
/* 49 */     super.func_145839_a(p_145839_1_);
/* 50 */     this.field_145882_a.func_98270_a(p_145839_1_);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_145841_b(NBTTagCompound p_145841_1_) {
/* 55 */     super.func_145841_b(p_145841_1_);
/* 56 */     this.field_145882_a.func_98280_b(p_145841_1_);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_145845_h() {
/* 61 */     this.field_145882_a.func_98278_g();
/* 62 */     super.func_145845_h();
/*    */   }
/*    */ 
/*    */   
/*    */   public Packet func_145844_m() {
/* 67 */     NBTTagCompound nBTTagCompound = new NBTTagCompound();
/* 68 */     func_145841_b(nBTTagCompound);
/* 69 */     nBTTagCompound.func_82580_o("SpawnPotentials");
/* 70 */     return (Packet)new S35PacketUpdateTileEntity(this.field_145851_c, this.field_145848_d, this.field_145849_e, 1, nBTTagCompound);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_145842_c(int p_145842_1_, int p_145842_2_) {
/* 75 */     if (this.field_145882_a.func_98268_b(p_145842_1_)) return true; 
/* 76 */     return super.func_145842_c(p_145842_1_, p_145842_2_);
/*    */   }
/*    */   
/*    */   public MobSpawnerBaseLogic func_145881_a() {
/* 80 */     return this.field_145882_a;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\tileentity\TileEntityMobSpawner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */