/*     */ package net.minecraft.world.storage;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.Map;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.WorldSavedData;
/*     */ 
/*     */ public class MapData extends WorldSavedData {
/*     */   public int field_76201_a;
/*     */   public int field_76199_b;
/*     */   public byte field_76200_c;
/*     */   public byte field_76197_d;
/*     */   
/*     */   public class MapCoord { public byte field_76216_a;
/*     */     public byte field_76214_b;
/*     */     
/*     */     public MapCoord(MapData p_i2139_1_, byte p_i2139_2_, byte p_i2139_3_, byte p_i2139_4_, byte p_i2139_5_) {
/*  25 */       this.field_76216_a = p_i2139_2_;
/*  26 */       this.field_76214_b = p_i2139_3_;
/*  27 */       this.field_76215_c = p_i2139_4_;
/*  28 */       this.field_76212_d = p_i2139_5_;
/*     */     }
/*     */     public byte field_76215_c; public byte field_76212_d;
/*     */     private static final String __OBFID = "CL_00000579"; }
/*     */   
/*     */   public class MapInfo { public final EntityPlayer field_76211_a;
/*  34 */     public int[] field_76209_b = new int[128];
/*  35 */     public int[] field_76210_c = new int[128]; private int field_76208_e;
/*     */     private int field_76205_f;
/*     */     private byte[] field_76206_g;
/*     */     public int field_82569_d;
/*     */     private boolean field_82570_i;
/*     */     private static final String __OBFID = "CL_00000578";
/*     */     
/*     */     public MapInfo(MapData p_i2138_1_, EntityPlayer p_i2138_2_) {
/*  43 */       this.field_76211_a = p_i2138_2_;
/*  44 */       for (byte b = 0; b < this.field_76209_b.length; b++) {
/*  45 */         this.field_76209_b[b] = 0;
/*  46 */         this.field_76210_c[b] = 127;
/*     */       } 
/*     */     }
/*     */     
/*     */     public byte[] func_76204_a(ItemStack p_76204_1_) {
/*  51 */       if (!this.field_82570_i) {
/*  52 */         byte[] arrayOfByte = new byte[2];
/*  53 */         arrayOfByte[0] = 2;
/*  54 */         arrayOfByte[1] = this.field_76207_d.field_76197_d;
/*     */         
/*  56 */         this.field_82570_i = true;
/*  57 */         return arrayOfByte;
/*     */       } 
/*     */       
/*  60 */       if (--this.field_76205_f < 0) {
/*  61 */         this.field_76205_f = 4;
/*     */         
/*  63 */         byte[] arrayOfByte = new byte[this.field_76207_d.field_76203_h.size() * 3 + 1];
/*  64 */         arrayOfByte[0] = 1;
/*  65 */         byte b1 = 0;
/*  66 */         for (MapData.MapCoord mapCoord : this.field_76207_d.field_76203_h.values()) {
/*  67 */           arrayOfByte[b1 * 3 + 1] = (byte)(mapCoord.field_76216_a << 4 | mapCoord.field_76212_d & 0xF);
/*  68 */           arrayOfByte[b1 * 3 + 2] = mapCoord.field_76214_b;
/*  69 */           arrayOfByte[b1 * 3 + 3] = mapCoord.field_76215_c;
/*  70 */           b1++;
/*     */         } 
/*  72 */         boolean bool = !p_76204_1_.func_82839_y() ? true : false;
/*  73 */         if (this.field_76206_g == null || this.field_76206_g.length != arrayOfByte.length) {
/*  74 */           bool = false;
/*     */         } else {
/*  76 */           for (byte b2 = 0; b2 < arrayOfByte.length; b2++) {
/*  77 */             if (arrayOfByte[b2] != this.field_76206_g[b2]) {
/*  78 */               bool = false;
/*     */               
/*     */               break;
/*     */             } 
/*     */           } 
/*     */         } 
/*  84 */         if (!bool) {
/*  85 */           this.field_76206_g = arrayOfByte;
/*  86 */           return arrayOfByte;
/*     */         } 
/*     */       } 
/*  89 */       for (byte b = 0; b < 1; b++) {
/*  90 */         int i = this.field_76208_e++ * 11 % 128;
/*     */         
/*  92 */         if (this.field_76209_b[i] >= 0) {
/*  93 */           int j = this.field_76210_c[i] - this.field_76209_b[i] + 1;
/*  94 */           int k = this.field_76209_b[i];
/*     */           
/*  96 */           byte[] arrayOfByte = new byte[j + 3];
/*  97 */           arrayOfByte[0] = 0;
/*  98 */           arrayOfByte[1] = (byte)i;
/*  99 */           arrayOfByte[2] = (byte)k;
/* 100 */           for (byte b1 = 0; b1 < arrayOfByte.length - 3; b1++) {
/* 101 */             arrayOfByte[b1 + 3] = this.field_76207_d.field_76198_e[(b1 + k) * 128 + i];
/*     */           }
/* 103 */           this.field_76210_c[i] = -1;
/* 104 */           this.field_76209_b[i] = -1;
/* 105 */           return arrayOfByte;
/*     */         } 
/*     */       } 
/* 108 */       return null;
/*     */     } }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 115 */   public byte[] field_76198_e = new byte[16384];
/* 116 */   public List field_76196_g = new ArrayList();
/* 117 */   private Map field_76202_j = new HashMap<Object, Object>();
/* 118 */   public Map field_76203_h = new LinkedHashMap<Object, Object>(); private static final String __OBFID = "CL_00000577";
/*     */   
/*     */   public MapData(String p_i2140_1_) {
/* 121 */     super(p_i2140_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_76184_a(NBTTagCompound p_76184_1_) {
/* 126 */     this.field_76200_c = p_76184_1_.func_74771_c("dimension");
/* 127 */     this.field_76201_a = p_76184_1_.func_74762_e("xCenter");
/* 128 */     this.field_76199_b = p_76184_1_.func_74762_e("zCenter");
/* 129 */     this.field_76197_d = p_76184_1_.func_74771_c("scale");
/* 130 */     if (this.field_76197_d < 0) this.field_76197_d = 0; 
/* 131 */     if (this.field_76197_d > 4) this.field_76197_d = 4;
/*     */     
/* 133 */     short s1 = p_76184_1_.func_74765_d("width");
/* 134 */     short s2 = p_76184_1_.func_74765_d("height");
/* 135 */     if (s1 == 128 && s2 == 128) {
/* 136 */       this.field_76198_e = p_76184_1_.func_74770_j("colors");
/*     */     } else {
/* 138 */       byte[] arrayOfByte = p_76184_1_.func_74770_j("colors");
/* 139 */       this.field_76198_e = new byte[16384];
/* 140 */       int i = (128 - s1) / 2;
/* 141 */       int j = (128 - s2) / 2;
/* 142 */       for (byte b = 0; b < s2; b++) {
/* 143 */         int k = b + j;
/* 144 */         if (k >= 0 || k < 128)
/* 145 */           for (byte b1 = 0; b1 < s1; b1++) {
/* 146 */             int m = b1 + i;
/* 147 */             if (m >= 0 || m < 128) {
/* 148 */               this.field_76198_e[m + k * 128] = arrayOfByte[b1 + b * s1];
/*     */             }
/*     */           }  
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_76187_b(NBTTagCompound p_76187_1_) {
/* 156 */     p_76187_1_.func_74774_a("dimension", this.field_76200_c);
/* 157 */     p_76187_1_.func_74768_a("xCenter", this.field_76201_a);
/* 158 */     p_76187_1_.func_74768_a("zCenter", this.field_76199_b);
/* 159 */     p_76187_1_.func_74774_a("scale", this.field_76197_d);
/* 160 */     p_76187_1_.func_74777_a("width", (short)128);
/* 161 */     p_76187_1_.func_74777_a("height", (short)128);
/* 162 */     p_76187_1_.func_74773_a("colors", this.field_76198_e);
/*     */   }
/*     */   
/*     */   public void func_76191_a(EntityPlayer p_76191_1_, ItemStack p_76191_2_) {
/* 166 */     if (!this.field_76202_j.containsKey(p_76191_1_)) {
/* 167 */       MapInfo mapInfo = new MapInfo(this, p_76191_1_);
/* 168 */       this.field_76202_j.put(p_76191_1_, mapInfo);
/* 169 */       this.field_76196_g.add(mapInfo);
/*     */     } 
/*     */     
/* 172 */     if (!p_76191_1_.field_71071_by.func_70431_c(p_76191_2_)) {
/* 173 */       this.field_76203_h.remove(p_76191_1_.func_70005_c_());
/*     */     }
/*     */     
/* 176 */     for (byte b = 0; b < this.field_76196_g.size(); b++) {
/* 177 */       MapInfo mapInfo = this.field_76196_g.get(b);
/*     */       
/* 179 */       if (mapInfo.field_76211_a.field_70128_L || (!mapInfo.field_76211_a.field_71071_by.func_70431_c(p_76191_2_) && !p_76191_2_.func_82839_y())) {
/* 180 */         this.field_76202_j.remove(mapInfo.field_76211_a);
/* 181 */         this.field_76196_g.remove(mapInfo);
/* 182 */       } else if (!p_76191_2_.func_82839_y() && mapInfo.field_76211_a.field_71093_bK == this.field_76200_c) {
/* 183 */         func_82567_a(0, mapInfo.field_76211_a.field_70170_p, mapInfo.field_76211_a.func_70005_c_(), mapInfo.field_76211_a.field_70165_t, mapInfo.field_76211_a.field_70161_v, mapInfo.field_76211_a.field_70177_z);
/*     */       } 
/*     */     } 
/*     */     
/* 187 */     if (p_76191_2_.func_82839_y())
/* 188 */       func_82567_a(1, p_76191_1_.field_70170_p, "frame-" + p_76191_2_.func_82836_z().func_145782_y(), (p_76191_2_.func_82836_z()).field_146063_b, (p_76191_2_.func_82836_z()).field_146062_d, ((p_76191_2_.func_82836_z()).field_82332_a * 90)); 
/*     */   }
/*     */   
/*     */   private void func_82567_a(int p_82567_1_, World p_82567_2_, String p_82567_3_, double p_82567_4_, double p_82567_6_, double p_82567_8_) {
/*     */     boolean bool;
/* 193 */     int i = 1 << this.field_76197_d;
/* 194 */     float f1 = (float)(p_82567_4_ - this.field_76201_a) / i;
/* 195 */     float f2 = (float)(p_82567_6_ - this.field_76199_b) / i;
/* 196 */     byte b1 = (byte)(int)((f1 * 2.0F) + 0.5D);
/* 197 */     byte b2 = (byte)(int)((f2 * 2.0F) + 0.5D);
/*     */     
/* 199 */     byte b = 63;
/*     */     
/* 201 */     if (f1 >= -b && f2 >= -b && f1 <= b && f2 <= b) {
/* 202 */       p_82567_8_ += (p_82567_8_ < 0.0D) ? -8.0D : 8.0D;
/* 203 */       bool = (byte)(int)(p_82567_8_ * 16.0D / 360.0D);
/*     */       
/* 205 */       if (this.field_76200_c < 0) {
/* 206 */         int j = (int)(p_82567_2_.func_72912_H().func_76073_f() / 10L);
/* 207 */         bool = (byte)(j * j * 34187121 + j * 121 >> 15 & 0xF);
/*     */       } 
/* 209 */     } else if (Math.abs(f1) < 320.0F && Math.abs(f2) < 320.0F) {
/* 210 */       p_82567_1_ = 6;
/* 211 */       bool = false;
/* 212 */       if (f1 <= -b) b1 = (byte)(int)((b * 2) + 2.5D); 
/* 213 */       if (f2 <= -b) b2 = (byte)(int)((b * 2) + 2.5D); 
/* 214 */       if (f1 >= b) b1 = (byte)(b * 2 + 1); 
/* 215 */       if (f2 >= b) b2 = (byte)(b * 2 + 1); 
/*     */     } else {
/* 217 */       this.field_76203_h.remove(p_82567_3_);
/*     */       
/*     */       return;
/*     */     } 
/* 221 */     this.field_76203_h.put(p_82567_3_, new MapCoord(this, (byte)p_82567_1_, b1, b2, bool));
/*     */   }
/*     */   
/*     */   public byte[] func_76193_a(ItemStack p_76193_1_, World p_76193_2_, EntityPlayer p_76193_3_) {
/* 225 */     MapInfo mapInfo = (MapInfo)this.field_76202_j.get(p_76193_3_);
/* 226 */     if (mapInfo == null) return null;
/*     */     
/* 228 */     return mapInfo.func_76204_a(p_76193_1_);
/*     */   }
/*     */   
/*     */   public void func_76194_a(int p_76194_1_, int p_76194_2_, int p_76194_3_) {
/* 232 */     func_76185_a();
/* 233 */     for (byte b = 0; b < this.field_76196_g.size(); b++) {
/* 234 */       MapInfo mapInfo = this.field_76196_g.get(b);
/* 235 */       if (mapInfo.field_76209_b[p_76194_1_] < 0 || mapInfo.field_76209_b[p_76194_1_] > p_76194_2_) mapInfo.field_76209_b[p_76194_1_] = p_76194_2_; 
/* 236 */       if (mapInfo.field_76210_c[p_76194_1_] < 0 || mapInfo.field_76210_c[p_76194_1_] < p_76194_3_) mapInfo.field_76210_c[p_76194_1_] = p_76194_3_; 
/*     */     } 
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_76192_a(byte[] p_76192_1_) {
/* 241 */     if (p_76192_1_[0] == 0) {
/* 242 */       int i = p_76192_1_[1] & 0xFF;
/* 243 */       int j = p_76192_1_[2] & 0xFF;
/* 244 */       for (byte b = 0; b < p_76192_1_.length - 3; b++) {
/* 245 */         this.field_76198_e[(b + j) * 128 + i] = p_76192_1_[b + 3];
/*     */       }
/* 247 */       func_76185_a();
/* 248 */     } else if (p_76192_1_[0] == 1) {
/* 249 */       this.field_76203_h.clear();
/* 250 */       for (byte b = 0; b < (p_76192_1_.length - 1) / 3; b++) {
/* 251 */         byte b1 = (byte)(p_76192_1_[b * 3 + 1] >> 4);
/* 252 */         byte b2 = p_76192_1_[b * 3 + 2];
/* 253 */         byte b3 = p_76192_1_[b * 3 + 3];
/* 254 */         byte b4 = (byte)(p_76192_1_[b * 3 + 1] & 0xF);
/* 255 */         this.field_76203_h.put("icon-" + b, new MapCoord(this, b1, b2, b3, b4));
/*     */       } 
/* 257 */     } else if (p_76192_1_[0] == 2) {
/* 258 */       this.field_76197_d = p_76192_1_[1];
/*     */     } 
/*     */   }
/*     */   
/*     */   public MapInfo func_82568_a(EntityPlayer p_82568_1_) {
/* 263 */     MapInfo mapInfo = (MapInfo)this.field_76202_j.get(p_82568_1_);
/*     */     
/* 265 */     if (mapInfo == null) {
/* 266 */       mapInfo = new MapInfo(this, p_82568_1_);
/* 267 */       this.field_76202_j.put(p_82568_1_, mapInfo);
/* 268 */       this.field_76196_g.add(mapInfo);
/*     */     } 
/*     */     
/* 271 */     return mapInfo;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\storage\MapData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */