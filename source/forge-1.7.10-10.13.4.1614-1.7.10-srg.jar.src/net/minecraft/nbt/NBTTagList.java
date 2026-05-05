/*     */ package net.minecraft.nbt;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import java.io.DataInput;
/*     */ import java.io.DataOutput;
/*     */ import java.io.IOException;
/*     */ 
/*     */ public class NBTTagList extends NBTBase {
/*   8 */   private List field_74747_a = new ArrayList();
/*   9 */   private byte field_74746_b = 0;
/*     */ 
/*     */   
/*     */   private static final String __OBFID = "CL_00001224";
/*     */ 
/*     */   
/*     */   void func_74734_a(DataOutput p_74734_1_) throws IOException {
/*  16 */     if (!this.field_74747_a.isEmpty()) { this.field_74746_b = ((NBTBase)this.field_74747_a.get(0)).func_74732_a(); }
/*  17 */     else { this.field_74746_b = 0; }
/*     */     
/*  19 */     p_74734_1_.writeByte(this.field_74746_b);
/*  20 */     p_74734_1_.writeInt(this.field_74747_a.size());
/*  21 */     for (byte b = 0; b < this.field_74747_a.size(); b++) {
/*  22 */       ((NBTBase)this.field_74747_a.get(b)).func_74734_a(p_74734_1_);
/*     */     }
/*     */   }
/*     */   
/*     */   void func_152446_a(DataInput p_152446_1_, int p_152446_2_, NBTSizeTracker p_152446_3_) throws IOException {
/*  27 */     if (p_152446_2_ > 512) {
/*  28 */       throw new RuntimeException("Tried to read NBT tag with too high complexity, depth > 512");
/*     */     }
/*  30 */     p_152446_3_.func_152450_a(8L);
/*  31 */     this.field_74746_b = p_152446_1_.readByte();
/*  32 */     int i = p_152446_1_.readInt();
/*     */     
/*  34 */     this.field_74747_a = new ArrayList();
/*  35 */     for (byte b = 0; b < i; b++) {
/*  36 */       NBTBase nBTBase = NBTBase.func_150284_a(this.field_74746_b);
/*  37 */       nBTBase.func_152446_a(p_152446_1_, p_152446_2_ + 1, p_152446_3_);
/*  38 */       this.field_74747_a.add(nBTBase);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public byte func_74732_a() {
/*  44 */     return 9;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  49 */     String str = "[";
/*  50 */     byte b = 0;
/*  51 */     for (NBTBase nBTBase : this.field_74747_a) {
/*  52 */       str = str + "" + b + ':' + nBTBase + ',';
/*  53 */       b++;
/*     */     } 
/*  55 */     return str + "]";
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
/*     */   public void func_74742_a(NBTBase p_74742_1_) {
/*  71 */     if (this.field_74746_b == 0) {
/*  72 */       this.field_74746_b = p_74742_1_.func_74732_a();
/*  73 */     } else if (this.field_74746_b != p_74742_1_.func_74732_a()) {
/*  74 */       System.err.println("WARNING: Adding mismatching tag types to tag list");
/*     */       return;
/*     */     } 
/*  77 */     this.field_74747_a.add(p_74742_1_);
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_150304_a(int p_150304_1_, NBTBase p_150304_2_) {
/*  81 */     if (p_150304_1_ < 0 || p_150304_1_ >= this.field_74747_a.size()) {
/*  82 */       System.err.println("WARNING: index out of bounds to set tag in tag list");
/*     */       return;
/*     */     } 
/*  85 */     if (this.field_74746_b == 0) {
/*  86 */       this.field_74746_b = p_150304_2_.func_74732_a();
/*  87 */     } else if (this.field_74746_b != p_150304_2_.func_74732_a()) {
/*  88 */       System.err.println("WARNING: Adding mismatching tag types to tag list");
/*     */       return;
/*     */     } 
/*  91 */     this.field_74747_a.set(p_150304_1_, p_150304_2_);
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public NBTBase func_74744_a(int p_74744_1_) {
/*  95 */     return this.field_74747_a.remove(p_74744_1_);
/*     */   }
/*     */   
/*     */   public NBTTagCompound func_150305_b(int p_150305_1_) {
/*  99 */     if (p_150305_1_ < 0 || p_150305_1_ >= this.field_74747_a.size()) {
/* 100 */       return new NBTTagCompound();
/*     */     }
/* 102 */     NBTBase nBTBase = this.field_74747_a.get(p_150305_1_);
/* 103 */     if (nBTBase.func_74732_a() == 10) {
/* 104 */       return (NBTTagCompound)nBTBase;
/*     */     }
/* 106 */     return new NBTTagCompound();
/*     */   }
/*     */   
/*     */   public int[] func_150306_c(int p_150306_1_) {
/* 110 */     if (p_150306_1_ < 0 || p_150306_1_ >= this.field_74747_a.size()) {
/* 111 */       return new int[0];
/*     */     }
/* 113 */     NBTBase nBTBase = this.field_74747_a.get(p_150306_1_);
/* 114 */     if (nBTBase.func_74732_a() == 11) {
/* 115 */       return ((NBTTagIntArray)nBTBase).func_150302_c();
/*     */     }
/* 117 */     return new int[0];
/*     */   }
/*     */   
/*     */   public double func_150309_d(int p_150309_1_) {
/* 121 */     if (p_150309_1_ < 0 || p_150309_1_ >= this.field_74747_a.size()) {
/* 122 */       return 0.0D;
/*     */     }
/* 124 */     NBTBase nBTBase = this.field_74747_a.get(p_150309_1_);
/* 125 */     if (nBTBase.func_74732_a() == 6) {
/* 126 */       return ((NBTTagDouble)nBTBase).func_150286_g();
/*     */     }
/* 128 */     return 0.0D;
/*     */   }
/*     */   
/*     */   public float func_150308_e(int p_150308_1_) {
/* 132 */     if (p_150308_1_ < 0 || p_150308_1_ >= this.field_74747_a.size()) {
/* 133 */       return 0.0F;
/*     */     }
/* 135 */     NBTBase nBTBase = this.field_74747_a.get(p_150308_1_);
/* 136 */     if (nBTBase.func_74732_a() == 5) {
/* 137 */       return ((NBTTagFloat)nBTBase).func_150288_h();
/*     */     }
/* 139 */     return 0.0F;
/*     */   }
/*     */   
/*     */   public String func_150307_f(int p_150307_1_) {
/* 143 */     if (p_150307_1_ < 0 || p_150307_1_ >= this.field_74747_a.size()) {
/* 144 */       return "";
/*     */     }
/* 146 */     NBTBase nBTBase = this.field_74747_a.get(p_150307_1_);
/* 147 */     if (nBTBase.func_74732_a() == 8) {
/* 148 */       return nBTBase.func_150285_a_();
/*     */     }
/* 150 */     return nBTBase.toString();
/*     */   }
/*     */   
/*     */   public int func_74745_c() {
/* 154 */     return this.field_74747_a.size();
/*     */   }
/*     */ 
/*     */   
/*     */   public NBTBase func_74737_b() {
/* 159 */     NBTTagList nBTTagList = new NBTTagList();
/* 160 */     nBTTagList.field_74746_b = this.field_74746_b;
/* 161 */     for (NBTBase nBTBase1 : this.field_74747_a) {
/* 162 */       NBTBase nBTBase2 = nBTBase1.func_74737_b();
/* 163 */       nBTTagList.field_74747_a.add(nBTBase2);
/*     */     } 
/* 165 */     return nBTTagList;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object p_equals_1_) {
/* 170 */     if (super.equals(p_equals_1_)) {
/* 171 */       NBTTagList nBTTagList = (NBTTagList)p_equals_1_;
/* 172 */       if (this.field_74746_b == nBTTagList.field_74746_b) {
/* 173 */         return this.field_74747_a.equals(nBTTagList.field_74747_a);
/*     */       }
/*     */     } 
/* 176 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 181 */     return super.hashCode() ^ this.field_74747_a.hashCode();
/*     */   }
/*     */   
/*     */   public int func_150303_d() {
/* 185 */     return this.field_74746_b;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\nbt\NBTTagList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */