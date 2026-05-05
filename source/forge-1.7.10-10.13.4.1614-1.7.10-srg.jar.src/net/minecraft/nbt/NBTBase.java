/*     */ package net.minecraft.nbt;
/*     */ 
/*     */ import java.io.DataInput;
/*     */ import java.io.DataOutput;
/*     */ import java.io.IOException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class NBTBase
/*     */ {
/*  19 */   public static final String[] field_82578_b = new String[] { "END", "BYTE", "SHORT", "INT", "LONG", "FLOAT", "DOUBLE", "BYTE[]", "STRING", "LIST", "COMPOUND", "INT[]" };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final String __OBFID = "CL_00001229";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   abstract void func_74734_a(DataOutput paramDataOutput) throws IOException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   abstract void func_152446_a(DataInput paramDataInput, int paramInt, NBTSizeTracker paramNBTSizeTracker) throws IOException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract String toString();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract byte func_74732_a();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static NBTBase func_150284_a(byte p_150284_0_) {
/*  53 */     switch (p_150284_0_) {
/*     */       case 0:
/*  55 */         return new NBTTagEnd();
/*     */       case 1:
/*  57 */         return new NBTTagByte();
/*     */       case 2:
/*  59 */         return new NBTTagShort();
/*     */       case 3:
/*  61 */         return new NBTTagInt();
/*     */       case 4:
/*  63 */         return new NBTTagLong();
/*     */       case 5:
/*  65 */         return new NBTTagFloat();
/*     */       case 6:
/*  67 */         return new NBTTagDouble();
/*     */       case 7:
/*  69 */         return new NBTTagByteArray();
/*     */       case 11:
/*  71 */         return new NBTTagIntArray();
/*     */       case 8:
/*  73 */         return new NBTTagString();
/*     */       case 9:
/*  75 */         return new NBTTagList();
/*     */       case 10:
/*  77 */         return new NBTTagCompound();
/*     */     } 
/*  79 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract NBTBase func_74737_b();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object p_equals_1_) {
/* 118 */     if (!(p_equals_1_ instanceof NBTBase)) {
/* 119 */       return false;
/*     */     }
/* 121 */     NBTBase nBTBase = (NBTBase)p_equals_1_;
/* 122 */     if (func_74732_a() != nBTBase.func_74732_a()) {
/* 123 */       return false;
/*     */     }
/* 125 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 130 */     return func_74732_a();
/*     */   }
/*     */   
/*     */   protected String func_150285_a_() {
/* 134 */     return toString();
/*     */   }
/*     */   
/*     */   public static abstract class NBTPrimitive extends NBTBase {
/*     */     private static final String __OBFID = "CL_00001230";
/*     */     
/*     */     public abstract long func_150291_c();
/*     */     
/*     */     public abstract int func_150287_d();
/*     */     
/*     */     public abstract short func_150289_e();
/*     */     
/*     */     public abstract byte func_150290_f();
/*     */     
/*     */     public abstract double func_150286_g();
/*     */     
/*     */     public abstract float func_150288_h();
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\nbt\NBTBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */