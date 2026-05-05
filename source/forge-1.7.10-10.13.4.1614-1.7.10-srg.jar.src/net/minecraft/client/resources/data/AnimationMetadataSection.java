/*    */ package net.minecraft.client.resources.data;
/*    */ 
/*    */ import com.google.common.collect.Sets;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.HashSet;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class AnimationMetadataSection
/*    */   implements IMetadataSection
/*    */ {
/*    */   private final List field_110478_a;
/*    */   private final int field_110476_b;
/*    */   private final int field_110477_c;
/*    */   private final int field_110475_d;
/*    */   private static final String __OBFID = "CL_00001106";
/*    */   
/*    */   public AnimationMetadataSection(List p_i1309_1_, int p_i1309_2_, int p_i1309_3_, int p_i1309_4_) {
/* 21 */     this.field_110478_a = p_i1309_1_;
/* 22 */     this.field_110476_b = p_i1309_2_;
/* 23 */     this.field_110477_c = p_i1309_3_;
/* 24 */     this.field_110475_d = p_i1309_4_;
/*    */   }
/*    */   
/*    */   public int func_110471_a() {
/* 28 */     return this.field_110477_c;
/*    */   }
/*    */   
/*    */   public int func_110474_b() {
/* 32 */     return this.field_110476_b;
/*    */   }
/*    */   
/*    */   public int func_110473_c() {
/* 36 */     return this.field_110478_a.size();
/*    */   }
/*    */   
/*    */   public int func_110469_d() {
/* 40 */     return this.field_110475_d;
/*    */   }
/*    */   
/*    */   private AnimationFrame func_130072_d(int p_130072_1_) {
/* 44 */     return this.field_110478_a.get(p_130072_1_);
/*    */   }
/*    */   
/*    */   public int func_110472_a(int p_110472_1_) {
/* 48 */     AnimationFrame animationFrame = func_130072_d(p_110472_1_);
/*    */     
/* 50 */     if (animationFrame.func_110495_a()) {
/* 51 */       return this.field_110475_d;
/*    */     }
/* 53 */     return animationFrame.func_110497_b();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_110470_b(int p_110470_1_) {
/* 58 */     return !((AnimationFrame)this.field_110478_a.get(p_110470_1_)).func_110495_a();
/*    */   }
/*    */   
/*    */   public int func_110468_c(int p_110468_1_) {
/* 62 */     return ((AnimationFrame)this.field_110478_a.get(p_110468_1_)).func_110496_c();
/*    */   }
/*    */   
/*    */   public Set func_130073_e() {
/* 66 */     HashSet<Integer> hashSet = Sets.newHashSet();
/* 67 */     for (AnimationFrame animationFrame : this.field_110478_a) {
/* 68 */       hashSet.add(Integer.valueOf(animationFrame.func_110496_c()));
/*    */     }
/*    */     
/* 71 */     return hashSet;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\resources\data\AnimationMetadataSection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */