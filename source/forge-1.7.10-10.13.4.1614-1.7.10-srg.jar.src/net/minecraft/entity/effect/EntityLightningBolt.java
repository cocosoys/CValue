/*    */ package net.minecraft.entity.effect;
/*    */ 
/*    */ import java.util.List;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ import net.minecraft.util.AxisAlignedBB;
/*    */ import net.minecraft.util.MathHelper;
/*    */ import net.minecraft.world.EnumDifficulty;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EntityLightningBolt
/*    */   extends EntityWeatherEffect
/*    */ {
/*    */   private int field_70262_b;
/*    */   public long field_70264_a;
/*    */   private int field_70263_c;
/*    */   private static final String __OBFID = "CL_00001666";
/*    */   
/*    */   public EntityLightningBolt(World p_i1703_1_, double p_i1703_2_, double p_i1703_4_, double p_i1703_6_) {
/* 26 */     super(p_i1703_1_);
/* 27 */     func_70012_b(p_i1703_2_, p_i1703_4_, p_i1703_6_, 0.0F, 0.0F);
/* 28 */     this.field_70262_b = 2;
/* 29 */     this.field_70264_a = this.field_70146_Z.nextLong();
/* 30 */     this.field_70263_c = this.field_70146_Z.nextInt(3) + 1;
/*    */     
/* 32 */     if (!p_i1703_1_.field_72995_K && p_i1703_1_.func_82736_K().func_82766_b("doFireTick") && (p_i1703_1_.field_73013_u == EnumDifficulty.NORMAL || p_i1703_1_.field_73013_u == EnumDifficulty.HARD) && p_i1703_1_.func_72873_a(MathHelper.func_76128_c(p_i1703_2_), MathHelper.func_76128_c(p_i1703_4_), MathHelper.func_76128_c(p_i1703_6_), 10)) {
/*    */       
/* 34 */       int i = MathHelper.func_76128_c(p_i1703_2_);
/* 35 */       int j = MathHelper.func_76128_c(p_i1703_4_);
/* 36 */       int k = MathHelper.func_76128_c(p_i1703_6_);
/* 37 */       if (p_i1703_1_.func_147439_a(i, j, k).func_149688_o() == Material.field_151579_a && Blocks.field_150480_ab.func_149742_c(p_i1703_1_, i, j, k)) p_i1703_1_.func_147449_b(i, j, k, (Block)Blocks.field_150480_ab);
/*    */ 
/*    */       
/* 40 */       for (i = 0; i < 4; i++) {
/* 41 */         j = MathHelper.func_76128_c(p_i1703_2_) + this.field_70146_Z.nextInt(3) - 1;
/* 42 */         k = MathHelper.func_76128_c(p_i1703_4_) + this.field_70146_Z.nextInt(3) - 1;
/* 43 */         int m = MathHelper.func_76128_c(p_i1703_6_) + this.field_70146_Z.nextInt(3) - 1;
/* 44 */         if (p_i1703_1_.func_147439_a(j, k, m).func_149688_o() == Material.field_151579_a && Blocks.field_150480_ab.func_149742_c(p_i1703_1_, j, k, m)) p_i1703_1_.func_147449_b(j, k, m, (Block)Blocks.field_150480_ab);
/*    */       
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   public void func_70071_h_() {
/* 51 */     super.func_70071_h_();
/*    */     
/* 53 */     if (this.field_70262_b == 2) {
/* 54 */       this.field_70170_p.func_72908_a(this.field_70165_t, this.field_70163_u, this.field_70161_v, "ambient.weather.thunder", 10000.0F, 0.8F + this.field_70146_Z.nextFloat() * 0.2F);
/* 55 */       this.field_70170_p.func_72908_a(this.field_70165_t, this.field_70163_u, this.field_70161_v, "random.explode", 2.0F, 0.5F + this.field_70146_Z.nextFloat() * 0.2F);
/*    */     } 
/*    */     
/* 58 */     this.field_70262_b--;
/* 59 */     if (this.field_70262_b < 0) {
/* 60 */       if (this.field_70263_c == 0) {
/* 61 */         func_70106_y();
/* 62 */       } else if (this.field_70262_b < -this.field_70146_Z.nextInt(10)) {
/* 63 */         this.field_70263_c--;
/* 64 */         this.field_70262_b = 1;
/* 65 */         this.field_70264_a = this.field_70146_Z.nextLong();
/* 66 */         if (!this.field_70170_p.field_72995_K && this.field_70170_p.func_82736_K().func_82766_b("doFireTick") && this.field_70170_p.func_72873_a(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70163_u), MathHelper.func_76128_c(this.field_70161_v), 10)) {
/* 67 */           int i = MathHelper.func_76128_c(this.field_70165_t);
/* 68 */           int j = MathHelper.func_76128_c(this.field_70163_u);
/* 69 */           int k = MathHelper.func_76128_c(this.field_70161_v);
/* 70 */           if (this.field_70170_p.func_147439_a(i, j, k).func_149688_o() == Material.field_151579_a && Blocks.field_150480_ab.func_149742_c(this.field_70170_p, i, j, k)) this.field_70170_p.func_147449_b(i, j, k, (Block)Blocks.field_150480_ab);
/*    */         
/*    */         } 
/*    */       } 
/*    */     }
/* 75 */     if (this.field_70262_b >= 0)
/* 76 */       if (this.field_70170_p.field_72995_K) {
/* 77 */         this.field_70170_p.field_73016_r = 2;
/*    */       } else {
/* 79 */         double d = 3.0D;
/* 80 */         List<Entity> list = this.field_70170_p.func_72839_b(this, AxisAlignedBB.func_72330_a(this.field_70165_t - d, this.field_70163_u - d, this.field_70161_v - d, this.field_70165_t + d, this.field_70163_u + 6.0D + d, this.field_70161_v + d));
/* 81 */         for (byte b = 0; b < list.size(); b++) {
/* 82 */           Entity entity = list.get(b);
/* 83 */           entity.func_70077_a(this);
/*    */         } 
/*    */       }  
/*    */   }
/*    */   
/*    */   protected void func_70088_a() {}
/*    */   
/*    */   protected void func_70037_a(NBTTagCompound p_70037_1_) {}
/*    */   
/*    */   protected void func_70014_b(NBTTagCompound p_70014_1_) {}
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\effect\EntityLightningBolt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */