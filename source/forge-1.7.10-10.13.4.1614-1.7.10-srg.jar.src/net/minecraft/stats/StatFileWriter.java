/*    */ package net.minecraft.stats;
/*    */ import com.google.common.collect.Maps;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.util.IJsonSerializable;
/*    */ import net.minecraft.util.TupleIntJsonSerializable;
/*    */ 
/*    */ public class StatFileWriter {
/*  9 */   protected final Map field_150875_a = Maps.newConcurrentMap(); private static final String __OBFID = "CL_00001481";
/*    */   
/*    */   public boolean func_77443_a(Achievement p_77443_1_) {
/* 12 */     return (func_77444_a(p_77443_1_) > 0);
/*    */   }
/*    */   
/*    */   public boolean func_77442_b(Achievement p_77442_1_) {
/* 16 */     return (p_77442_1_.field_75992_c == null || func_77443_a(p_77442_1_.field_75992_c));
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_150874_c(Achievement p_150874_1_) {
/* 20 */     if (func_77443_a(p_150874_1_)) return 0; 
/* 21 */     byte b = 0;
/* 22 */     Achievement achievement = p_150874_1_.field_75992_c;
/*    */     
/* 24 */     while (achievement != null && !func_77443_a(achievement)) {
/* 25 */       achievement = achievement.field_75992_c;
/* 26 */       b++;
/*    */     } 
/*    */     
/* 29 */     return b;
/*    */   }
/*    */   
/*    */   public void func_150871_b(EntityPlayer p_150871_1_, StatBase p_150871_2_, int p_150871_3_) {
/* 33 */     if (p_150871_2_.func_75967_d() && !func_77442_b((Achievement)p_150871_2_))
/* 34 */       return;  func_150873_a(p_150871_1_, p_150871_2_, func_77444_a(p_150871_2_) + p_150871_3_);
/*    */   }
/*    */   
/*    */   public void func_150873_a(EntityPlayer p_150873_1_, StatBase p_150873_2_, int p_150873_3_) {
/* 38 */     TupleIntJsonSerializable tupleIntJsonSerializable = (TupleIntJsonSerializable)this.field_150875_a.get(p_150873_2_);
/*    */     
/* 40 */     if (tupleIntJsonSerializable == null) {
/* 41 */       tupleIntJsonSerializable = new TupleIntJsonSerializable();
/* 42 */       this.field_150875_a.put(p_150873_2_, tupleIntJsonSerializable);
/*    */     } 
/*    */     
/* 45 */     tupleIntJsonSerializable.func_151188_a(p_150873_3_);
/*    */   }
/*    */   
/*    */   public int func_77444_a(StatBase p_77444_1_) {
/* 49 */     TupleIntJsonSerializable tupleIntJsonSerializable = (TupleIntJsonSerializable)this.field_150875_a.get(p_77444_1_);
/* 50 */     return (tupleIntJsonSerializable == null) ? 0 : tupleIntJsonSerializable.func_151189_a();
/*    */   }
/*    */   
/*    */   public IJsonSerializable func_150870_b(StatBase p_150870_1_) {
/* 54 */     TupleIntJsonSerializable tupleIntJsonSerializable = (TupleIntJsonSerializable)this.field_150875_a.get(p_150870_1_);
/*    */     
/* 56 */     if (tupleIntJsonSerializable != null) {
/* 57 */       return tupleIntJsonSerializable.func_151187_b();
/*    */     }
/* 59 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public IJsonSerializable func_150872_a(StatBase p_150872_1_, IJsonSerializable p_150872_2_) {
/* 64 */     TupleIntJsonSerializable tupleIntJsonSerializable = (TupleIntJsonSerializable)this.field_150875_a.get(p_150872_1_);
/*    */     
/* 66 */     if (tupleIntJsonSerializable == null) {
/* 67 */       tupleIntJsonSerializable = new TupleIntJsonSerializable();
/* 68 */       this.field_150875_a.put(p_150872_1_, tupleIntJsonSerializable);
/*    */     } 
/*    */     
/* 71 */     tupleIntJsonSerializable.func_151190_a(p_150872_2_);
/*    */     
/* 73 */     return p_150872_2_;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\stats\StatFileWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */