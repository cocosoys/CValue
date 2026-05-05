/*     */ package net.minecraft.client.renderer;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.renderer.culling.ICamera;
/*     */ import net.minecraft.client.renderer.entity.RenderItem;
/*     */ import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
/*     */ import net.minecraft.client.shader.TesselatorVertexState;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.ChunkCache;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.chunk.Chunk;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class WorldRenderer {
/*     */   private TesselatorVertexState field_147894_y;
/*  27 */   private int field_78942_y = -1; public World field_78924_a; public static int field_78922_b; public int field_78923_c; public int field_78920_d; public int field_78921_e; public int field_78918_f;
/*     */   public int field_78919_g;
/*  29 */   private static Tessellator field_78941_z = Tessellator.field_78398_a;
/*     */   
/*     */   public int field_78931_h;
/*     */   
/*     */   public int field_78932_i;
/*     */   
/*     */   public int field_78929_j;
/*     */   public int field_78930_k;
/*     */   public boolean field_78927_l;
/*  38 */   public boolean[] field_78928_m = new boolean[2]; public int field_78925_n;
/*     */   public int field_78926_o;
/*     */   public int field_78940_p;
/*     */   public boolean field_78939_q;
/*     */   public AxisAlignedBB field_78938_r;
/*     */   public int field_78937_s;
/*     */   public boolean field_78936_t = true;
/*     */   public boolean field_78935_u;
/*     */   public int field_78934_v;
/*     */   public boolean field_78933_w;
/*     */   private boolean field_78915_A;
/*  49 */   public List field_147895_x = new ArrayList();
/*     */   
/*     */   private List field_147893_C;
/*     */   private int field_78917_C;
/*     */   private static final String __OBFID = "CL_00000942";
/*     */   
/*     */   public WorldRenderer(World p_i1240_1_, List p_i1240_2_, int p_i1240_3_, int p_i1240_4_, int p_i1240_5_, int p_i1240_6_) {
/*  56 */     this.field_78924_a = p_i1240_1_;
/*  57 */     this.field_147894_y = null;
/*  58 */     this.field_147893_C = p_i1240_2_;
/*     */     
/*  60 */     this.field_78942_y = p_i1240_6_;
/*     */     
/*  62 */     this.field_78923_c = -999;
/*  63 */     func_78913_a(p_i1240_3_, p_i1240_4_, p_i1240_5_);
/*     */     
/*  65 */     this.field_78939_q = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_78913_a(int p_78913_1_, int p_78913_2_, int p_78913_3_) {
/*  70 */     if (p_78913_1_ == this.field_78923_c && p_78913_2_ == this.field_78920_d && p_78913_3_ == this.field_78921_e)
/*     */       return; 
/*  72 */     func_78910_b();
/*  73 */     this.field_78923_c = p_78913_1_;
/*  74 */     this.field_78920_d = p_78913_2_;
/*  75 */     this.field_78921_e = p_78913_3_;
/*  76 */     this.field_78925_n = p_78913_1_ + 8;
/*  77 */     this.field_78926_o = p_78913_2_ + 8;
/*  78 */     this.field_78940_p = p_78913_3_ + 8;
/*     */     
/*  80 */     this.field_78932_i = p_78913_1_ & 0x3FF;
/*  81 */     this.field_78929_j = p_78913_2_;
/*  82 */     this.field_78930_k = p_78913_3_ & 0x3FF;
/*  83 */     this.field_78918_f = p_78913_1_ - this.field_78932_i;
/*  84 */     this.field_78919_g = p_78913_2_ - this.field_78929_j;
/*  85 */     this.field_78931_h = p_78913_3_ - this.field_78930_k;
/*     */     
/*  87 */     float f = 6.0F;
/*  88 */     this.field_78938_r = AxisAlignedBB.func_72330_a((p_78913_1_ - f), (p_78913_2_ - f), (p_78913_3_ - f), ((p_78913_1_ + 16) + f), ((p_78913_2_ + 16) + f), ((p_78913_3_ + 16) + f));
/*     */     
/*  90 */     GL11.glNewList(this.field_78942_y + 2, 4864);
/*  91 */     RenderItem.func_76980_a(AxisAlignedBB.func_72330_a((this.field_78932_i - f), (this.field_78929_j - f), (this.field_78930_k - f), ((this.field_78932_i + 16) + f), ((this.field_78929_j + 16) + f), ((this.field_78930_k + 16) + f)));
/*  92 */     GL11.glEndList();
/*  93 */     func_78914_f();
/*     */   }
/*     */   
/*     */   private void func_78905_g() {
/*  97 */     GL11.glTranslatef(this.field_78932_i, this.field_78929_j, this.field_78930_k);
/*     */   }
/*     */   
/*     */   public void func_147892_a(EntityLivingBase p_147892_1_) {
/* 101 */     if (!this.field_78939_q)
/* 102 */       return;  this.field_78939_q = false;
/*     */     
/* 104 */     int i = this.field_78923_c;
/* 105 */     int j = this.field_78920_d;
/* 106 */     int k = this.field_78921_e;
/* 107 */     int m = this.field_78923_c + 16;
/* 108 */     int n = this.field_78920_d + 16;
/* 109 */     int i1 = this.field_78921_e + 16;
/* 110 */     for (byte b1 = 0; b1 < 2; b1++) {
/* 111 */       this.field_78928_m[b1] = true;
/*     */     }
/*     */     
/* 114 */     Chunk.field_76640_a = false;
/*     */     
/* 116 */     HashSet<?> hashSet = new HashSet();
/* 117 */     hashSet.addAll(this.field_147895_x);
/* 118 */     this.field_147895_x.clear();
/*     */     
/* 120 */     Minecraft minecraft = Minecraft.func_71410_x();
/* 121 */     EntityLivingBase entityLivingBase = minecraft.field_71451_h;
/* 122 */     int i2 = MathHelper.func_76128_c(entityLivingBase.field_70165_t);
/* 123 */     int i3 = MathHelper.func_76128_c(entityLivingBase.field_70163_u);
/* 124 */     int i4 = MathHelper.func_76128_c(entityLivingBase.field_70161_v);
/* 125 */     byte b2 = 1;
/* 126 */     ChunkCache chunkCache = new ChunkCache(this.field_78924_a, i - b2, j - b2, k - b2, m + b2, n + b2, i1 + b2, b2);
/* 127 */     if (!chunkCache.func_72806_N()) {
/* 128 */       field_78922_b++;
/*     */       
/* 130 */       RenderBlocks renderBlocks = new RenderBlocks((IBlockAccess)chunkCache);
/*     */       
/* 132 */       this.field_78917_C = 0;
/* 133 */       this.field_147894_y = null;
/*     */       
/* 135 */       for (byte b = 0; b < 2; b++) {
/* 136 */         boolean bool1 = false;
/* 137 */         boolean bool = false;
/*     */         
/* 139 */         boolean bool2 = false;
/*     */         
/* 141 */         for (int i5 = j; i5 < n; i5++) {
/* 142 */           for (int i6 = k; i6 < i1; i6++) {
/* 143 */             for (int i7 = i; i7 < m; i7++) {
/* 144 */               Block block = chunkCache.func_147439_a(i7, i5, i6);
/*     */               
/* 146 */               if (block.func_149688_o() != Material.field_151579_a) {
/* 147 */                 if (!bool2) {
/* 148 */                   bool2 = true;
/* 149 */                   func_147890_b(b);
/*     */                 } 
/*     */                 
/* 152 */                 if (b == 0 && block.func_149716_u()) {
/* 153 */                   TileEntity tileEntity = chunkCache.func_147438_o(i7, i5, i6);
/* 154 */                   if (TileEntityRendererDispatcher.field_147556_a.func_147545_a(tileEntity)) {
/* 155 */                     this.field_147895_x.add(tileEntity);
/*     */                   }
/*     */                 } 
/* 158 */                 int i8 = block.func_149701_w();
/*     */                 
/* 160 */                 if (i8 > b) {
/* 161 */                   bool1 = true;
/* 162 */                 } else if (i8 == b) {
/* 163 */                   bool |= renderBlocks.func_147805_b(block, i7, i5, i6);
/* 164 */                   if (block.func_149645_b() == 0 && i7 == i2 && i5 == i3 && i6 == i4) {
/* 165 */                     renderBlocks.func_147786_a(true);
/* 166 */                     renderBlocks.func_147753_b(true);
/* 167 */                     renderBlocks.func_147805_b(block, i7, i5, i6);
/* 168 */                     renderBlocks.func_147786_a(false);
/* 169 */                     renderBlocks.func_147753_b(false);
/*     */                   } 
/*     */                 } 
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/* 176 */         if (bool) this.field_78928_m[b] = false; 
/* 177 */         if (bool2) {
/* 178 */           func_147891_a(b, p_147892_1_);
/*     */         } else {
/* 180 */           bool = false;
/*     */         } 
/* 182 */         if (!bool1) {
/*     */           break;
/*     */         }
/*     */       } 
/*     */     } 
/* 187 */     HashSet hashSet1 = new HashSet();
/* 188 */     hashSet1.addAll(this.field_147895_x);
/* 189 */     hashSet1.removeAll(hashSet);
/* 190 */     this.field_147893_C.addAll(hashSet1);
/*     */     
/* 192 */     hashSet.removeAll(this.field_147895_x);
/* 193 */     this.field_147893_C.removeAll(hashSet);
/*     */     
/* 195 */     this.field_78933_w = Chunk.field_76640_a;
/* 196 */     this.field_78915_A = true;
/*     */   }
/*     */   
/*     */   private void func_147890_b(int p_147890_1_) {
/* 200 */     GL11.glNewList(this.field_78942_y + p_147890_1_, 4864);
/* 201 */     GL11.glPushMatrix();
/* 202 */     func_78905_g();
/* 203 */     float f = 1.000001F;
/* 204 */     GL11.glTranslatef(-8.0F, -8.0F, -8.0F);
/* 205 */     GL11.glScalef(f, f, f);
/* 206 */     GL11.glTranslatef(8.0F, 8.0F, 8.0F);
/* 207 */     field_78941_z.func_78382_b();
/* 208 */     field_78941_z.func_78373_b(-this.field_78923_c, -this.field_78920_d, -this.field_78921_e);
/*     */   }
/*     */   
/*     */   private void func_147891_a(int p_147891_1_, EntityLivingBase p_147891_2_) {
/* 212 */     if (p_147891_1_ == 1 && !this.field_78928_m[p_147891_1_]) {
/* 213 */       this.field_147894_y = field_78941_z.func_147564_a((float)p_147891_2_.field_70165_t, (float)p_147891_2_.field_70163_u, (float)p_147891_2_.field_70161_v);
/*     */     }
/* 215 */     this.field_78917_C += field_78941_z.func_78381_a();
/* 216 */     GL11.glPopMatrix();
/* 217 */     GL11.glEndList();
/* 218 */     field_78941_z.func_78373_b(0.0D, 0.0D, 0.0D);
/*     */   }
/*     */   
/*     */   public void func_147889_b(EntityLivingBase p_147889_1_) {
/* 222 */     if (this.field_147894_y == null || this.field_78928_m[1]) {
/*     */       return;
/*     */     }
/*     */     
/* 226 */     func_147890_b(1);
/*     */     
/* 228 */     field_78941_z.func_147565_a(this.field_147894_y);
/*     */     
/* 230 */     func_147891_a(1, p_147889_1_);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float func_78912_a(Entity p_78912_1_) {
/* 236 */     float f1 = (float)(p_78912_1_.field_70165_t - this.field_78925_n);
/* 237 */     float f2 = (float)(p_78912_1_.field_70163_u - this.field_78926_o);
/* 238 */     float f3 = (float)(p_78912_1_.field_70161_v - this.field_78940_p);
/*     */     
/* 240 */     return f1 * f1 + f2 * f2 + f3 * f3;
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
/*     */   public void func_78910_b() {
/* 253 */     for (byte b = 0; b < 2; b++) {
/* 254 */       this.field_78928_m[b] = true;
/*     */     }
/*     */     
/* 257 */     this.field_78927_l = false;
/* 258 */     this.field_78915_A = false;
/* 259 */     this.field_147894_y = null;
/*     */   }
/*     */   
/*     */   public void func_78911_c() {
/* 263 */     func_78910_b();
/* 264 */     this.field_78924_a = null;
/*     */   }
/*     */   
/*     */   public int func_78909_a(int p_78909_1_) {
/* 268 */     if (!this.field_78927_l) return -1; 
/* 269 */     if (!this.field_78928_m[p_78909_1_]) return this.field_78942_y + p_78909_1_; 
/* 270 */     return -1;
/*     */   }
/*     */   
/*     */   public void func_78908_a(ICamera p_78908_1_) {
/* 274 */     this.field_78927_l = p_78908_1_.func_78546_a(this.field_78938_r);
/*     */   }
/*     */   
/*     */   public void func_78904_d() {
/* 278 */     GL11.glCallList(this.field_78942_y + 2);
/*     */   }
/*     */   
/*     */   public boolean func_78906_e() {
/* 282 */     if (!this.field_78915_A) return false; 
/* 283 */     return (this.field_78928_m[0] && this.field_78928_m[1]);
/*     */   }
/*     */   
/*     */   public void func_78914_f() {
/* 287 */     this.field_78939_q = true;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\WorldRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */