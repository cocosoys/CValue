/*    */ package net.minecraft.block;
/*    */ 
/*    */ import net.minecraft.dispenser.IBlockSource;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class BlockSourceImpl implements IBlockSource {
/*    */   private final World field_82627_a;
/*    */   private final int field_82625_b;
/*    */   private final int field_82626_c;
/*    */   private final int field_82624_d;
/*    */   private static final String __OBFID = "CL_00001194";
/*    */   
/*    */   public BlockSourceImpl(World p_i1365_1_, int p_i1365_2_, int p_i1365_3_, int p_i1365_4_) {
/* 15 */     this.field_82627_a = p_i1365_1_;
/* 16 */     this.field_82625_b = p_i1365_2_;
/* 17 */     this.field_82626_c = p_i1365_3_;
/* 18 */     this.field_82624_d = p_i1365_4_;
/*    */   }
/*    */ 
/*    */   
/*    */   public World func_82618_k() {
/* 23 */     return this.field_82627_a;
/*    */   }
/*    */ 
/*    */   
/*    */   public double func_82615_a() {
/* 28 */     return this.field_82625_b + 0.5D;
/*    */   }
/*    */ 
/*    */   
/*    */   public double func_82617_b() {
/* 33 */     return this.field_82626_c + 0.5D;
/*    */   }
/*    */ 
/*    */   
/*    */   public double func_82616_c() {
/* 38 */     return this.field_82624_d + 0.5D;
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_82623_d() {
/* 43 */     return this.field_82625_b;
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_82622_e() {
/* 48 */     return this.field_82626_c;
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_82621_f() {
/* 53 */     return this.field_82624_d;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int func_82620_h() {
/* 63 */     return this.field_82627_a.func_72805_g(this.field_82625_b, this.field_82626_c, this.field_82624_d);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public TileEntity func_150835_j() {
/* 73 */     return this.field_82627_a.func_147438_o(this.field_82625_b, this.field_82626_c, this.field_82624_d);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockSourceImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */