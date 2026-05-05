/*     */ package net.minecraft.nbt;
/*     */ import java.io.DataInput;
/*     */ import java.io.DataOutput;
/*     */ import java.io.IOException;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.Callable;
/*     */ import net.minecraft.crash.CrashReport;
/*     */ import net.minecraft.crash.CrashReportCategory;
/*     */ import net.minecraft.util.ReportedException;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ 
/*     */ public class NBTTagCompound extends NBTBase {
/*  14 */   private static final Logger field_150301_b = LogManager.getLogger();
/*     */   
/*  16 */   private Map field_74784_a = new HashMap<Object, Object>();
/*     */ 
/*     */   
/*     */   private static final String __OBFID = "CL_00001215";
/*     */ 
/*     */   
/*     */   void func_74734_a(DataOutput p_74734_1_) throws IOException {
/*  23 */     for (String str : this.field_74784_a.keySet()) {
/*  24 */       NBTBase nBTBase = (NBTBase)this.field_74784_a.get(str);
/*  25 */       func_150298_a(str, nBTBase, p_74734_1_);
/*     */     } 
/*  27 */     p_74734_1_.writeByte(0);
/*     */   }
/*     */ 
/*     */   
/*     */   void func_152446_a(DataInput p_152446_1_, int p_152446_2_, NBTSizeTracker p_152446_3_) throws IOException {
/*  32 */     if (p_152446_2_ > 512) {
/*  33 */       throw new RuntimeException("Tried to read NBT tag with too high complexity, depth > 512");
/*     */     }
/*  35 */     this.field_74784_a.clear();
/*     */     byte b;
/*  37 */     while ((b = func_152447_a(p_152446_1_, p_152446_3_)) != 0) {
/*  38 */       String str = func_152448_b(p_152446_1_, p_152446_3_);
/*     */       
/*  40 */       p_152446_3_.func_152450_a((16 * str.length()));
/*  41 */       NBTBase nBTBase = func_152449_a(b, str, p_152446_1_, p_152446_2_ + 1, p_152446_3_);
/*  42 */       this.field_74784_a.put(str, nBTBase);
/*     */     } 
/*     */   }
/*     */   
/*     */   public Set func_150296_c() {
/*  47 */     return this.field_74784_a.keySet();
/*     */   }
/*     */ 
/*     */   
/*     */   public byte func_74732_a() {
/*  52 */     return 10;
/*     */   }
/*     */   
/*     */   public void func_74782_a(String p_74782_1_, NBTBase p_74782_2_) {
/*  56 */     this.field_74784_a.put(p_74782_1_, p_74782_2_);
/*     */   }
/*     */   
/*     */   public void func_74774_a(String p_74774_1_, byte p_74774_2_) {
/*  60 */     this.field_74784_a.put(p_74774_1_, new NBTTagByte(p_74774_2_));
/*     */   }
/*     */   
/*     */   public void func_74777_a(String p_74777_1_, short p_74777_2_) {
/*  64 */     this.field_74784_a.put(p_74777_1_, new NBTTagShort(p_74777_2_));
/*     */   }
/*     */   
/*     */   public void func_74768_a(String p_74768_1_, int p_74768_2_) {
/*  68 */     this.field_74784_a.put(p_74768_1_, new NBTTagInt(p_74768_2_));
/*     */   }
/*     */   
/*     */   public void func_74772_a(String p_74772_1_, long p_74772_2_) {
/*  72 */     this.field_74784_a.put(p_74772_1_, new NBTTagLong(p_74772_2_));
/*     */   }
/*     */   
/*     */   public void func_74776_a(String p_74776_1_, float p_74776_2_) {
/*  76 */     this.field_74784_a.put(p_74776_1_, new NBTTagFloat(p_74776_2_));
/*     */   }
/*     */   
/*     */   public void func_74780_a(String p_74780_1_, double p_74780_2_) {
/*  80 */     this.field_74784_a.put(p_74780_1_, new NBTTagDouble(p_74780_2_));
/*     */   }
/*     */   
/*     */   public void func_74778_a(String p_74778_1_, String p_74778_2_) {
/*  84 */     this.field_74784_a.put(p_74778_1_, new NBTTagString(p_74778_2_));
/*     */   }
/*     */   
/*     */   public void func_74773_a(String p_74773_1_, byte[] p_74773_2_) {
/*  88 */     this.field_74784_a.put(p_74773_1_, new NBTTagByteArray(p_74773_2_));
/*     */   }
/*     */   
/*     */   public void func_74783_a(String p_74783_1_, int[] p_74783_2_) {
/*  92 */     this.field_74784_a.put(p_74783_1_, new NBTTagIntArray(p_74783_2_));
/*     */   }
/*     */   
/*     */   public void func_74757_a(String p_74757_1_, boolean p_74757_2_) {
/*  96 */     func_74774_a(p_74757_1_, p_74757_2_ ? 1 : 0);
/*     */   }
/*     */   
/*     */   public NBTBase func_74781_a(String p_74781_1_) {
/* 100 */     return (NBTBase)this.field_74784_a.get(p_74781_1_);
/*     */   }
/*     */   
/*     */   public byte func_150299_b(String p_150299_1_) {
/* 104 */     NBTBase nBTBase = (NBTBase)this.field_74784_a.get(p_150299_1_);
/* 105 */     if (nBTBase != null) {
/* 106 */       return nBTBase.func_74732_a();
/*     */     }
/* 108 */     return 0;
/*     */   }
/*     */   
/*     */   public boolean func_74764_b(String p_74764_1_) {
/* 112 */     return this.field_74784_a.containsKey(p_74764_1_);
/*     */   }
/*     */   
/*     */   public boolean func_150297_b(String p_150297_1_, int p_150297_2_) {
/* 116 */     byte b = func_150299_b(p_150297_1_);
/* 117 */     if (b == p_150297_2_) {
/* 118 */       return true;
/*     */     }
/* 120 */     if (p_150297_2_ == 99) {
/* 121 */       return (b == 1 || b == 2 || b == 3 || b == 4 || b == 5 || b == 6);
/*     */     }
/*     */     
/* 124 */     return false;
/*     */   }
/*     */   
/*     */   public byte func_74771_c(String p_74771_1_) {
/*     */     try {
/* 129 */       if (!this.field_74784_a.containsKey(p_74771_1_)) return 0; 
/* 130 */       return ((NBTBase.NBTPrimitive)this.field_74784_a.get(p_74771_1_)).func_150290_f();
/* 131 */     } catch (ClassCastException classCastException) {
/* 132 */       return 0;
/*     */     } 
/*     */   }
/*     */   
/*     */   public short func_74765_d(String p_74765_1_) {
/*     */     try {
/* 138 */       if (!this.field_74784_a.containsKey(p_74765_1_)) return 0; 
/* 139 */       return ((NBTBase.NBTPrimitive)this.field_74784_a.get(p_74765_1_)).func_150289_e();
/* 140 */     } catch (ClassCastException classCastException) {
/* 141 */       return 0;
/*     */     } 
/*     */   }
/*     */   
/*     */   public int func_74762_e(String p_74762_1_) {
/*     */     try {
/* 147 */       if (!this.field_74784_a.containsKey(p_74762_1_)) return 0; 
/* 148 */       return ((NBTBase.NBTPrimitive)this.field_74784_a.get(p_74762_1_)).func_150287_d();
/* 149 */     } catch (ClassCastException classCastException) {
/* 150 */       return 0;
/*     */     } 
/*     */   }
/*     */   
/*     */   public long func_74763_f(String p_74763_1_) {
/*     */     try {
/* 156 */       if (!this.field_74784_a.containsKey(p_74763_1_)) return 0L; 
/* 157 */       return ((NBTBase.NBTPrimitive)this.field_74784_a.get(p_74763_1_)).func_150291_c();
/* 158 */     } catch (ClassCastException classCastException) {
/* 159 */       return 0L;
/*     */     } 
/*     */   }
/*     */   
/*     */   public float func_74760_g(String p_74760_1_) {
/*     */     try {
/* 165 */       if (!this.field_74784_a.containsKey(p_74760_1_)) return 0.0F; 
/* 166 */       return ((NBTBase.NBTPrimitive)this.field_74784_a.get(p_74760_1_)).func_150288_h();
/* 167 */     } catch (ClassCastException classCastException) {
/* 168 */       return 0.0F;
/*     */     } 
/*     */   }
/*     */   
/*     */   public double func_74769_h(String p_74769_1_) {
/*     */     try {
/* 174 */       if (!this.field_74784_a.containsKey(p_74769_1_)) return 0.0D; 
/* 175 */       return ((NBTBase.NBTPrimitive)this.field_74784_a.get(p_74769_1_)).func_150286_g();
/* 176 */     } catch (ClassCastException classCastException) {
/* 177 */       return 0.0D;
/*     */     } 
/*     */   }
/*     */   
/*     */   public String func_74779_i(String p_74779_1_) {
/*     */     try {
/* 183 */       if (!this.field_74784_a.containsKey(p_74779_1_)) return ""; 
/* 184 */       return ((NBTBase)this.field_74784_a.get(p_74779_1_)).func_150285_a_();
/* 185 */     } catch (ClassCastException classCastException) {
/* 186 */       return "";
/*     */     } 
/*     */   }
/*     */   
/*     */   public byte[] func_74770_j(String p_74770_1_) {
/*     */     try {
/* 192 */       if (!this.field_74784_a.containsKey(p_74770_1_)) return new byte[0]; 
/* 193 */       return ((NBTTagByteArray)this.field_74784_a.get(p_74770_1_)).func_150292_c();
/* 194 */     } catch (ClassCastException classCastException) {
/* 195 */       throw new ReportedException(func_82581_a(p_74770_1_, 7, classCastException));
/*     */     } 
/*     */   }
/*     */   
/*     */   public int[] func_74759_k(String p_74759_1_) {
/*     */     try {
/* 201 */       if (!this.field_74784_a.containsKey(p_74759_1_)) return new int[0]; 
/* 202 */       return ((NBTTagIntArray)this.field_74784_a.get(p_74759_1_)).func_150302_c();
/* 203 */     } catch (ClassCastException classCastException) {
/* 204 */       throw new ReportedException(func_82581_a(p_74759_1_, 11, classCastException));
/*     */     } 
/*     */   }
/*     */   
/*     */   public NBTTagCompound func_74775_l(String p_74775_1_) {
/*     */     try {
/* 210 */       if (!this.field_74784_a.containsKey(p_74775_1_)) return new NBTTagCompound(); 
/* 211 */       return (NBTTagCompound)this.field_74784_a.get(p_74775_1_);
/* 212 */     } catch (ClassCastException classCastException) {
/* 213 */       throw new ReportedException(func_82581_a(p_74775_1_, 10, classCastException));
/*     */     } 
/*     */   }
/*     */   
/*     */   public NBTTagList func_150295_c(String p_150295_1_, int p_150295_2_) {
/*     */     try {
/* 219 */       if (func_150299_b(p_150295_1_) != 9) return new NBTTagList(); 
/* 220 */       NBTTagList nBTTagList = (NBTTagList)this.field_74784_a.get(p_150295_1_);
/* 221 */       if (nBTTagList.func_74745_c() > 0 && nBTTagList.func_150303_d() != p_150295_2_) {
/* 222 */         return new NBTTagList();
/*     */       }
/* 224 */       return nBTTagList;
/* 225 */     } catch (ClassCastException classCastException) {
/* 226 */       throw new ReportedException(func_82581_a(p_150295_1_, 9, classCastException));
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean func_74767_n(String p_74767_1_) {
/* 231 */     return (func_74771_c(p_74767_1_) != 0);
/*     */   }
/*     */   
/*     */   public void func_82580_o(String p_82580_1_) {
/* 235 */     this.field_74784_a.remove(p_82580_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 240 */     String str = "{";
/* 241 */     for (String str1 : this.field_74784_a.keySet()) {
/* 242 */       str = str + str1 + ':' + this.field_74784_a.get(str1) + ',';
/*     */     }
/* 244 */     return str + "}";
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
/*     */   public boolean func_82582_d() {
/* 261 */     return this.field_74784_a.isEmpty();
/*     */   }
/*     */   
/*     */   private CrashReport func_82581_a(String p_82581_1_, int p_82581_2_, ClassCastException p_82581_3_) {
/* 265 */     CrashReport crashReport = CrashReport.func_85055_a(p_82581_3_, "Reading NBT data");
/* 266 */     CrashReportCategory crashReportCategory = crashReport.func_85057_a("Corrupt NBT tag", 1);
/*     */     
/* 268 */     crashReportCategory.func_71500_a("Tag type found", new Callable(this, p_82581_1_) { private static final String __OBFID = "CL_00001216";
/*     */           
/*     */           public String call() {
/* 271 */             return NBTBase.field_82578_b[((NBTBase)this.field_82584_b.field_74784_a.get(this.field_82585_a)).func_74732_a()];
/*     */           } }
/*     */       );
/* 274 */     crashReportCategory.func_71500_a("Tag type expected", new Callable(this, p_82581_2_) { private static final String __OBFID = "CL_00001217";
/*     */           
/*     */           public String call() {
/* 277 */             return NBTBase.field_82578_b[this.field_82588_a];
/*     */           } }
/*     */       );
/* 280 */     crashReportCategory.func_71507_a("Tag name", p_82581_1_);
/*     */     
/* 282 */     return crashReport;
/*     */   }
/*     */ 
/*     */   
/*     */   public NBTBase func_74737_b() {
/* 287 */     NBTTagCompound nBTTagCompound = new NBTTagCompound();
/* 288 */     for (String str : this.field_74784_a.keySet()) {
/* 289 */       nBTTagCompound.func_74782_a(str, ((NBTBase)this.field_74784_a.get(str)).func_74737_b());
/*     */     }
/* 291 */     return nBTTagCompound;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object p_equals_1_) {
/* 296 */     if (super.equals(p_equals_1_)) {
/* 297 */       NBTTagCompound nBTTagCompound = (NBTTagCompound)p_equals_1_;
/* 298 */       return this.field_74784_a.entrySet().equals(nBTTagCompound.field_74784_a.entrySet());
/*     */     } 
/* 300 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 305 */     return super.hashCode() ^ this.field_74784_a.hashCode();
/*     */   }
/*     */   
/*     */   private static void func_150298_a(String p_150298_0_, NBTBase p_150298_1_, DataOutput p_150298_2_) throws IOException {
/* 309 */     p_150298_2_.writeByte(p_150298_1_.func_74732_a());
/* 310 */     if (p_150298_1_.func_74732_a() == 0)
/*     */       return; 
/* 312 */     p_150298_2_.writeUTF(p_150298_0_);
/*     */     
/* 314 */     p_150298_1_.func_74734_a(p_150298_2_);
/*     */   }
/*     */   
/*     */   private static byte func_152447_a(DataInput p_152447_0_, NBTSizeTracker p_152447_1_) throws IOException {
/* 318 */     return p_152447_0_.readByte();
/*     */   }
/*     */   
/*     */   private static String func_152448_b(DataInput p_152448_0_, NBTSizeTracker p_152448_1_) throws IOException {
/* 322 */     return p_152448_0_.readUTF();
/*     */   }
/*     */   
/*     */   static NBTBase func_152449_a(byte p_152449_0_, String p_152449_1_, DataInput p_152449_2_, int p_152449_3_, NBTSizeTracker p_152449_4_) {
/* 326 */     NBTBase nBTBase = NBTBase.func_150284_a(p_152449_0_);
/*     */     
/*     */     try {
/* 329 */       nBTBase.func_152446_a(p_152449_2_, p_152449_3_, p_152449_4_);
/* 330 */     } catch (IOException iOException) {
/* 331 */       CrashReport crashReport = CrashReport.func_85055_a(iOException, "Loading NBT data");
/* 332 */       CrashReportCategory crashReportCategory = crashReport.func_85058_a("NBT Tag");
/* 333 */       crashReportCategory.func_71507_a("Tag name", p_152449_1_);
/* 334 */       crashReportCategory.func_71507_a("Tag type", Byte.valueOf(p_152449_0_));
/* 335 */       throw new ReportedException(crashReport);
/*     */     } 
/*     */     
/* 338 */     return nBTBase;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\nbt\NBTTagCompound.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */