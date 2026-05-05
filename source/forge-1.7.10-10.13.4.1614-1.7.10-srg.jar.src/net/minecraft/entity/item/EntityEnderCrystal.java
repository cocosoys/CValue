/*    */ package net.minecraft.entity.item;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ import net.minecraft.util.DamageSource;
/*    */ import net.minecraft.util.MathHelper;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EntityEnderCrystal
/*    */   extends Entity
/*    */ {
/*    */   public int field_70261_a;
/*    */   public int field_70260_b;
/*    */   private static final String __OBFID = "CL_00001658";
/*    */   
/*    */   public EntityEnderCrystal(World p_i1698_1_) {
/* 23 */     super(p_i1698_1_);
/* 24 */     this.field_70156_m = true;
/* 25 */     func_70105_a(2.0F, 2.0F);
/* 26 */     this.field_70129_M = this.field_70131_O / 2.0F;
/* 27 */     this.field_70260_b = 5;
/*    */     
/* 29 */     this.field_70261_a = this.field_70146_Z.nextInt(100000);
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public EntityEnderCrystal(World p_i1699_1_, double p_i1699_2_, double p_i1699_4_, double p_i1699_6_) {
/* 33 */     this(p_i1699_1_);
/* 34 */     func_70107_b(p_i1699_2_, p_i1699_4_, p_i1699_6_);
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean func_70041_e_() {
/* 39 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_70088_a() {
/* 44 */     this.field_70180_af.func_75682_a(8, Integer.valueOf(this.field_70260_b));
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_70071_h_() {
/* 49 */     this.field_70169_q = this.field_70165_t;
/* 50 */     this.field_70167_r = this.field_70163_u;
/* 51 */     this.field_70166_s = this.field_70161_v;
/* 52 */     this.field_70261_a++;
/*    */     
/* 54 */     this.field_70180_af.func_75692_b(8, Integer.valueOf(this.field_70260_b));
/*    */     
/* 56 */     int i = MathHelper.func_76128_c(this.field_70165_t);
/* 57 */     int j = MathHelper.func_76128_c(this.field_70163_u);
/* 58 */     int k = MathHelper.func_76128_c(this.field_70161_v);
/* 59 */     if (this.field_70170_p.field_73011_w instanceof net.minecraft.world.WorldProviderEnd && this.field_70170_p.func_147439_a(i, j, k) != Blocks.field_150480_ab) {
/* 60 */       this.field_70170_p.func_147449_b(i, j, k, (Block)Blocks.field_150480_ab);
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void func_70014_b(NBTTagCompound p_70014_1_) {}
/*    */ 
/*    */   
/*    */   protected void func_70037_a(NBTTagCompound p_70037_1_) {}
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public float func_70053_R() {
/* 74 */     return 0.0F;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_70067_L() {
/* 79 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_70097_a(DamageSource p_70097_1_, float p_70097_2_) {
/* 84 */     if (func_85032_ar()) return false; 
/* 85 */     if (!this.field_70128_L && !this.field_70170_p.field_72995_K) {
/* 86 */       this.field_70260_b = 0;
/* 87 */       if (this.field_70260_b <= 0) {
/* 88 */         func_70106_y();
/* 89 */         if (!this.field_70170_p.field_72995_K) {
/* 90 */           this.field_70170_p.func_72876_a(null, this.field_70165_t, this.field_70163_u, this.field_70161_v, 6.0F, true);
/*    */         }
/*    */       } 
/*    */     } 
/* 94 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\item\EntityEnderCrystal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */