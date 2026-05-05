/*     */ package net.minecraft.client.renderer;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.ByteOrder;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.nio.ShortBuffer;
/*     */ import java.util.Comparator;
/*     */ import java.util.PriorityQueue;
/*     */ import net.minecraft.client.shader.TesselatorVertexState;
/*     */ import net.minecraft.client.util.QuadComparator;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class Tessellator
/*     */ {
/*     */   private ByteBuffer field_78394_d;
/*     */   private IntBuffer field_147568_c;
/*     */   private FloatBuffer field_147566_d;
/*     */   private ShortBuffer field_147567_e;
/*     */   private int[] field_78405_h;
/*     */   private int field_78406_i;
/*     */   private double field_78403_j;
/*     */   private double field_78404_k;
/*     */   private int field_78401_l;
/*     */   private int field_78402_m;
/*     */   private boolean field_78399_n;
/*  36 */   public static final Tessellator field_78398_a = new Tessellator(2097152); private boolean field_78400_o; private boolean field_78414_p; private boolean field_78413_q; private int field_147569_p; private int field_78411_s; private boolean field_78410_t; private int field_78409_u; private double field_78408_v; private double field_78407_w; private double field_78417_x;
/*     */   private int field_78416_y;
/*     */   private boolean field_78415_z;
/*     */   private int field_78388_E;
/*     */   private static final String __OBFID = "CL_00000960";
/*     */   
/*     */   private Tessellator(int p_i1250_1_) {
/*  43 */     this.field_78388_E = p_i1250_1_;
/*     */     
/*  45 */     this.field_78394_d = GLAllocation.func_74524_c(p_i1250_1_ * 4);
/*  46 */     this.field_147568_c = this.field_78394_d.asIntBuffer();
/*  47 */     this.field_147566_d = this.field_78394_d.asFloatBuffer();
/*  48 */     this.field_147567_e = this.field_78394_d.asShortBuffer();
/*  49 */     this.field_78405_h = new int[p_i1250_1_];
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_78381_a() {
/*  54 */     if (!this.field_78415_z) throw new IllegalStateException("Not tesselating!"); 
/*  55 */     this.field_78415_z = false;
/*  56 */     if (this.field_78406_i > 0) {
/*  57 */       this.field_147568_c.clear();
/*  58 */       this.field_147568_c.put(this.field_78405_h, 0, this.field_147569_p);
/*     */       
/*  60 */       this.field_78394_d.position(0);
/*  61 */       this.field_78394_d.limit(this.field_147569_p * 4);
/*     */ 
/*     */ 
/*     */       
/*  65 */       if (this.field_78400_o) {
/*  66 */         this.field_147566_d.position(3);
/*  67 */         GL11.glTexCoordPointer(2, 32, this.field_147566_d);
/*  68 */         GL11.glEnableClientState(32888);
/*     */       } 
/*  70 */       if (this.field_78414_p) {
/*  71 */         OpenGlHelper.func_77472_b(OpenGlHelper.field_77476_b);
/*     */         
/*  73 */         this.field_147567_e.position(14);
/*  74 */         GL11.glTexCoordPointer(2, 32, this.field_147567_e);
/*  75 */         GL11.glEnableClientState(32888);
/*  76 */         OpenGlHelper.func_77472_b(OpenGlHelper.field_77478_a);
/*     */       } 
/*  78 */       if (this.field_78399_n) {
/*  79 */         this.field_78394_d.position(20);
/*  80 */         GL11.glColorPointer(4, true, 32, this.field_78394_d);
/*  81 */         GL11.glEnableClientState(32886);
/*     */       } 
/*  83 */       if (this.field_78413_q) {
/*  84 */         this.field_78394_d.position(24);
/*  85 */         GL11.glNormalPointer(32, this.field_78394_d);
/*  86 */         GL11.glEnableClientState(32885);
/*     */       } 
/*  88 */       this.field_147566_d.position(0);
/*  89 */       GL11.glVertexPointer(3, 32, this.field_147566_d);
/*  90 */       GL11.glEnableClientState(32884);
/*  91 */       GL11.glDrawArrays(this.field_78409_u, 0, this.field_78406_i);
/*     */       
/*  93 */       GL11.glDisableClientState(32884);
/*  94 */       if (this.field_78400_o) GL11.glDisableClientState(32888); 
/*  95 */       if (this.field_78414_p) {
/*  96 */         OpenGlHelper.func_77472_b(OpenGlHelper.field_77476_b);
/*  97 */         GL11.glDisableClientState(32888);
/*  98 */         OpenGlHelper.func_77472_b(OpenGlHelper.field_77478_a);
/*     */       } 
/* 100 */       if (this.field_78399_n) GL11.glDisableClientState(32886); 
/* 101 */       if (this.field_78413_q) GL11.glDisableClientState(32885);
/*     */     
/*     */     } 
/* 104 */     int i = this.field_147569_p * 4;
/* 105 */     func_78379_d();
/*     */     
/* 107 */     return i;
/*     */   }
/*     */   
/*     */   public TesselatorVertexState func_147564_a(float p_147564_1_, float p_147564_2_, float p_147564_3_) {
/* 111 */     int[] arrayOfInt = new int[this.field_147569_p];
/* 112 */     PriorityQueue<Integer> priorityQueue = new PriorityQueue(this.field_147569_p, (Comparator<?>)new QuadComparator(this.field_78405_h, p_147564_1_ + (float)this.field_78408_v, p_147564_2_ + (float)this.field_78407_w, p_147564_3_ + (float)this.field_78417_x));
/*     */     
/* 114 */     byte b = 32;
/*     */     int i;
/* 116 */     for (i = 0; i < this.field_147569_p; i += b) {
/* 117 */       priorityQueue.add(Integer.valueOf(i));
/*     */     }
/*     */     
/* 120 */     i = 0;
/* 121 */     while (!priorityQueue.isEmpty()) {
/* 122 */       int j = ((Integer)priorityQueue.remove()).intValue();
/* 123 */       for (byte b1 = 0; b1 < b; b1++) {
/* 124 */         arrayOfInt[i + b1] = this.field_78405_h[j + b1];
/*     */       }
/* 126 */       i += b;
/*     */     } 
/*     */     
/* 129 */     System.arraycopy(arrayOfInt, 0, this.field_78405_h, 0, arrayOfInt.length);
/*     */     
/* 131 */     return new TesselatorVertexState(arrayOfInt, this.field_147569_p, this.field_78406_i, this.field_78400_o, this.field_78414_p, this.field_78413_q, this.field_78399_n);
/*     */   }
/*     */   
/*     */   public void func_147565_a(TesselatorVertexState p_147565_1_) {
/* 135 */     System.arraycopy(p_147565_1_.func_147572_a(), 0, this.field_78405_h, 0, (p_147565_1_.func_147572_a()).length);
/*     */     
/* 137 */     this.field_147569_p = p_147565_1_.func_147576_b();
/* 138 */     this.field_78406_i = p_147565_1_.func_147575_c();
/* 139 */     this.field_78400_o = p_147565_1_.func_147573_d();
/* 140 */     this.field_78414_p = p_147565_1_.func_147571_e();
/* 141 */     this.field_78399_n = p_147565_1_.func_147574_g();
/* 142 */     this.field_78413_q = p_147565_1_.func_147570_f();
/*     */   }
/*     */   
/*     */   private void func_78379_d() {
/* 146 */     this.field_78406_i = 0;
/*     */     
/* 148 */     this.field_78394_d.clear();
/* 149 */     this.field_147569_p = 0;
/* 150 */     this.field_78411_s = 0;
/*     */   }
/*     */   
/*     */   public void func_78382_b() {
/* 154 */     func_78371_b(7);
/*     */   }
/*     */   
/*     */   public void func_78371_b(int p_78371_1_) {
/* 158 */     if (this.field_78415_z) {
/* 159 */       throw new IllegalStateException("Already tesselating!");
/*     */     }
/* 161 */     this.field_78415_z = true;
/*     */     
/* 163 */     func_78379_d();
/* 164 */     this.field_78409_u = p_78371_1_;
/* 165 */     this.field_78413_q = false;
/* 166 */     this.field_78399_n = false;
/* 167 */     this.field_78400_o = false;
/* 168 */     this.field_78414_p = false;
/* 169 */     this.field_78410_t = false;
/*     */   }
/*     */   
/*     */   public void func_78385_a(double p_78385_1_, double p_78385_3_) {
/* 173 */     this.field_78400_o = true;
/* 174 */     this.field_78403_j = p_78385_1_;
/* 175 */     this.field_78404_k = p_78385_3_;
/*     */   }
/*     */   
/*     */   public void func_78380_c(int p_78380_1_) {
/* 179 */     this.field_78414_p = true;
/* 180 */     this.field_78401_l = p_78380_1_;
/*     */   }
/*     */   
/*     */   public void func_78386_a(float p_78386_1_, float p_78386_2_, float p_78386_3_) {
/* 184 */     func_78376_a((int)(p_78386_1_ * 255.0F), (int)(p_78386_2_ * 255.0F), (int)(p_78386_3_ * 255.0F));
/*     */   }
/*     */   
/*     */   public void func_78369_a(float p_78369_1_, float p_78369_2_, float p_78369_3_, float p_78369_4_) {
/* 188 */     func_78370_a((int)(p_78369_1_ * 255.0F), (int)(p_78369_2_ * 255.0F), (int)(p_78369_3_ * 255.0F), (int)(p_78369_4_ * 255.0F));
/*     */   }
/*     */   
/*     */   public void func_78376_a(int p_78376_1_, int p_78376_2_, int p_78376_3_) {
/* 192 */     func_78370_a(p_78376_1_, p_78376_2_, p_78376_3_, 255);
/*     */   }
/*     */   
/*     */   public void func_78370_a(int p_78370_1_, int p_78370_2_, int p_78370_3_, int p_78370_4_) {
/* 196 */     if (this.field_78410_t)
/*     */       return; 
/* 198 */     if (p_78370_1_ > 255) p_78370_1_ = 255; 
/* 199 */     if (p_78370_2_ > 255) p_78370_2_ = 255; 
/* 200 */     if (p_78370_3_ > 255) p_78370_3_ = 255; 
/* 201 */     if (p_78370_4_ > 255) p_78370_4_ = 255; 
/* 202 */     if (p_78370_1_ < 0) p_78370_1_ = 0; 
/* 203 */     if (p_78370_2_ < 0) p_78370_2_ = 0; 
/* 204 */     if (p_78370_3_ < 0) p_78370_3_ = 0; 
/* 205 */     if (p_78370_4_ < 0) p_78370_4_ = 0;
/*     */     
/* 207 */     this.field_78399_n = true;
/* 208 */     if (ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN) {
/* 209 */       this.field_78402_m = p_78370_4_ << 24 | p_78370_3_ << 16 | p_78370_2_ << 8 | p_78370_1_;
/*     */     } else {
/* 211 */       this.field_78402_m = p_78370_1_ << 24 | p_78370_2_ << 16 | p_78370_3_ << 8 | p_78370_4_;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_154352_a(byte p_154352_1_, byte p_154352_2_, byte p_154352_3_) {
/* 216 */     func_78376_a(p_154352_1_ & 0xFF, p_154352_2_ & 0xFF, p_154352_3_ & 0xFF);
/*     */   }
/*     */   
/*     */   public void func_78374_a(double p_78374_1_, double p_78374_3_, double p_78374_5_, double p_78374_7_, double p_78374_9_) {
/* 220 */     func_78385_a(p_78374_7_, p_78374_9_);
/* 221 */     func_78377_a(p_78374_1_, p_78374_3_, p_78374_5_);
/*     */   }
/*     */   
/*     */   public void func_78377_a(double p_78377_1_, double p_78377_3_, double p_78377_5_) {
/* 225 */     this.field_78411_s++;
/*     */     
/* 227 */     if (this.field_78400_o) {
/* 228 */       this.field_78405_h[this.field_147569_p + 3] = Float.floatToRawIntBits((float)this.field_78403_j);
/* 229 */       this.field_78405_h[this.field_147569_p + 4] = Float.floatToRawIntBits((float)this.field_78404_k);
/*     */     } 
/* 231 */     if (this.field_78414_p) {
/* 232 */       this.field_78405_h[this.field_147569_p + 7] = this.field_78401_l;
/*     */     }
/* 234 */     if (this.field_78399_n) {
/* 235 */       this.field_78405_h[this.field_147569_p + 5] = this.field_78402_m;
/*     */     }
/* 237 */     if (this.field_78413_q) {
/* 238 */       this.field_78405_h[this.field_147569_p + 6] = this.field_78416_y;
/*     */     }
/*     */     
/* 241 */     this.field_78405_h[this.field_147569_p + 0] = Float.floatToRawIntBits((float)(p_78377_1_ + this.field_78408_v));
/* 242 */     this.field_78405_h[this.field_147569_p + 1] = Float.floatToRawIntBits((float)(p_78377_3_ + this.field_78407_w));
/* 243 */     this.field_78405_h[this.field_147569_p + 2] = Float.floatToRawIntBits((float)(p_78377_5_ + this.field_78417_x));
/*     */     
/* 245 */     this.field_147569_p += 8;
/*     */     
/* 247 */     this.field_78406_i++;
/* 248 */     if (this.field_78406_i % 4 == 0 && this.field_147569_p >= this.field_78388_E - 32) {
/* 249 */       func_78381_a();
/* 250 */       this.field_78415_z = true;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_78378_d(int p_78378_1_) {
/* 255 */     int i = p_78378_1_ >> 16 & 0xFF;
/* 256 */     int j = p_78378_1_ >> 8 & 0xFF;
/* 257 */     int k = p_78378_1_ & 0xFF;
/* 258 */     func_78376_a(i, j, k);
/*     */   }
/*     */   
/*     */   public void func_78384_a(int p_78384_1_, int p_78384_2_) {
/* 262 */     int i = p_78384_1_ >> 16 & 0xFF;
/* 263 */     int j = p_78384_1_ >> 8 & 0xFF;
/* 264 */     int k = p_78384_1_ & 0xFF;
/* 265 */     func_78370_a(i, j, k, p_78384_2_);
/*     */   }
/*     */   
/*     */   public void func_78383_c() {
/* 269 */     this.field_78410_t = true;
/*     */   }
/*     */   
/*     */   public void func_78375_b(float p_78375_1_, float p_78375_2_, float p_78375_3_) {
/* 273 */     this.field_78413_q = true;
/* 274 */     byte b1 = (byte)(int)(p_78375_1_ * 127.0F);
/* 275 */     byte b2 = (byte)(int)(p_78375_2_ * 127.0F);
/* 276 */     byte b3 = (byte)(int)(p_78375_3_ * 127.0F);
/*     */     
/* 278 */     this.field_78416_y = b1 & 0xFF | (b2 & 0xFF) << 8 | (b3 & 0xFF) << 16;
/*     */   }
/*     */   
/*     */   public void func_78373_b(double p_78373_1_, double p_78373_3_, double p_78373_5_) {
/* 282 */     this.field_78408_v = p_78373_1_;
/* 283 */     this.field_78407_w = p_78373_3_;
/* 284 */     this.field_78417_x = p_78373_5_;
/*     */   }
/*     */   
/*     */   public void func_78372_c(float p_78372_1_, float p_78372_2_, float p_78372_3_) {
/* 288 */     this.field_78408_v += p_78372_1_;
/* 289 */     this.field_78407_w += p_78372_2_;
/* 290 */     this.field_78417_x += p_78372_3_;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\Tessellator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */