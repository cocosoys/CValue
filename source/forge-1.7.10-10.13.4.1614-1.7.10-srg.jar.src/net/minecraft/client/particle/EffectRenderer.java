/*     */ package net.minecraft.client.particle;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import java.util.concurrent.Callable;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.ActiveRenderInfo;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.texture.TextureManager;
/*     */ import net.minecraft.client.renderer.texture.TextureMap;
/*     */ import net.minecraft.crash.CrashReport;
/*     */ import net.minecraft.crash.CrashReportCategory;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.ReportedException;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.world.World;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class EffectRenderer
/*     */ {
/*  27 */   private static final ResourceLocation field_110737_b = new ResourceLocation("textures/particle/particles.png");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected World field_78878_a;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  38 */   private List[] field_78876_b = new List[4];
/*     */   private TextureManager field_78877_c;
/*  40 */   private Random field_78875_d = new Random();
/*     */   
/*     */   public EffectRenderer(World p_i1220_1_, TextureManager p_i1220_2_) {
/*  43 */     if (p_i1220_1_ != null) {
/*  44 */       this.field_78878_a = p_i1220_1_;
/*     */     }
/*  46 */     this.field_78877_c = p_i1220_2_;
/*  47 */     for (byte b = 0; b < 4; b++)
/*  48 */       this.field_78876_b[b] = new ArrayList(); 
/*     */   }
/*     */   private static final String __OBFID = "CL_00000915";
/*     */   
/*     */   public void func_78873_a(EntityFX p_78873_1_) {
/*  53 */     int i = p_78873_1_.func_70537_b();
/*  54 */     if (this.field_78876_b[i].size() >= 4000) this.field_78876_b[i].remove(0); 
/*  55 */     this.field_78876_b[i].add(p_78873_1_);
/*     */   }
/*     */   
/*     */   public void func_78868_a() {
/*  59 */     for (byte b = 0; b < 4; b++) {
/*  60 */       for (byte b1 = 0; b1 < this.field_78876_b[b].size(); b1++) {
/*  61 */         EntityFX entityFX = this.field_78876_b[b].get(b1);
/*     */         
/*     */         try {
/*  64 */           entityFX.func_70071_h_();
/*  65 */         } catch (Throwable throwable) {
/*  66 */           CrashReport crashReport = CrashReport.func_85055_a(throwable, "Ticking Particle");
/*  67 */           CrashReportCategory crashReportCategory = crashReport.func_85058_a("Particle being ticked");
/*  68 */           byte b2 = b;
/*     */           
/*  70 */           crashReportCategory.func_71500_a("Particle", new Callable(this, entityFX) { private static final String __OBFID = "CL_00000916";
/*     */                 
/*     */                 public String call() {
/*  73 */                   return this.field_147214_a.toString();
/*     */                 } }
/*     */             );
/*     */           
/*  77 */           crashReportCategory.func_71500_a("Particle Type", new Callable(this, b2) { private static final String __OBFID = "CL_00000917";
/*     */                 
/*     */                 public String call() {
/*  80 */                   if (this.field_147898_a == 0)
/*  81 */                     return "MISC_TEXTURE"; 
/*  82 */                   if (this.field_147898_a == 1)
/*  83 */                     return "TERRAIN_TEXTURE"; 
/*  84 */                   if (this.field_147898_a == 2)
/*  85 */                     return "ITEM_TEXTURE"; 
/*  86 */                   if (this.field_147898_a == 3) {
/*  87 */                     return "ENTITY_PARTICLE_TEXTURE";
/*     */                   }
/*  89 */                   return "Unknown - " + this.field_147898_a;
/*     */                 } }
/*     */             );
/*     */ 
/*     */           
/*  94 */           throw new ReportedException(crashReport);
/*     */         } 
/*     */         
/*  97 */         if (entityFX.field_70128_L) {
/*  98 */           this.field_78876_b[b].remove(b1--);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_78874_a(Entity p_78874_1_, float p_78874_2_) {
/* 105 */     float f1 = ActiveRenderInfo.field_74588_d;
/* 106 */     float f2 = ActiveRenderInfo.field_74586_f;
/*     */     
/* 108 */     float f3 = ActiveRenderInfo.field_74587_g;
/* 109 */     float f4 = ActiveRenderInfo.field_74596_h;
/* 110 */     float f5 = ActiveRenderInfo.field_74589_e;
/*     */     
/* 112 */     EntityFX.field_70556_an = p_78874_1_.field_70142_S + (p_78874_1_.field_70165_t - p_78874_1_.field_70142_S) * p_78874_2_;
/* 113 */     EntityFX.field_70554_ao = p_78874_1_.field_70137_T + (p_78874_1_.field_70163_u - p_78874_1_.field_70137_T) * p_78874_2_;
/* 114 */     EntityFX.field_70555_ap = p_78874_1_.field_70136_U + (p_78874_1_.field_70161_v - p_78874_1_.field_70136_U) * p_78874_2_;
/* 115 */     for (byte b = 0; b < 3; b++) {
/* 116 */       if (!this.field_78876_b[b].isEmpty()) {
/*     */         
/* 118 */         switch (b) {
/*     */           
/*     */           default:
/* 121 */             this.field_78877_c.func_110577_a(field_110737_b);
/*     */             break;
/*     */           case 1:
/* 124 */             this.field_78877_c.func_110577_a(TextureMap.field_110575_b);
/*     */             break;
/*     */           case 2:
/* 127 */             this.field_78877_c.func_110577_a(TextureMap.field_110576_c);
/*     */             break;
/*     */         } 
/* 130 */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 131 */         GL11.glDepthMask(false);
/* 132 */         GL11.glEnable(3042);
/* 133 */         GL11.glBlendFunc(770, 771);
/* 134 */         GL11.glAlphaFunc(516, 0.003921569F);
/*     */         
/* 136 */         Tessellator tessellator = Tessellator.field_78398_a;
/* 137 */         tessellator.func_78382_b();
/* 138 */         for (byte b1 = 0; b1 < this.field_78876_b[b].size(); b1++) {
/* 139 */           EntityFX entityFX = this.field_78876_b[b].get(b1);
/*     */           
/* 141 */           tessellator.func_78380_c(entityFX.func_70070_b(p_78874_2_));
/*     */           
/*     */           try {
/* 144 */             entityFX.func_70539_a(tessellator, p_78874_2_, f1, f5, f2, f3, f4);
/* 145 */           } catch (Throwable throwable) {
/* 146 */             CrashReport crashReport = CrashReport.func_85055_a(throwable, "Rendering Particle");
/* 147 */             CrashReportCategory crashReportCategory = crashReport.func_85058_a("Particle being rendered");
/* 148 */             byte b2 = b;
/*     */             
/* 150 */             crashReportCategory.func_71500_a("Particle", new Callable(this, entityFX) { private static final String __OBFID = "CL_00000918";
/*     */                   
/*     */                   public String call() {
/* 153 */                     return this.field_147901_a.toString();
/*     */                   } }
/*     */               );
/*     */             
/* 157 */             crashReportCategory.func_71500_a("Particle Type", new Callable(this, b2) { private static final String __OBFID = "CL_00000919";
/*     */                   
/*     */                   public String call() {
/* 160 */                     if (this.field_147904_a == 0)
/* 161 */                       return "MISC_TEXTURE"; 
/* 162 */                     if (this.field_147904_a == 1)
/* 163 */                       return "TERRAIN_TEXTURE"; 
/* 164 */                     if (this.field_147904_a == 2)
/* 165 */                       return "ITEM_TEXTURE"; 
/* 166 */                     if (this.field_147904_a == 3) {
/* 167 */                       return "ENTITY_PARTICLE_TEXTURE";
/*     */                     }
/* 169 */                     return "Unknown - " + this.field_147904_a;
/*     */                   } }
/*     */               );
/*     */ 
/*     */             
/* 174 */             throw new ReportedException(crashReport);
/*     */           } 
/*     */         } 
/* 177 */         tessellator.func_78381_a();
/* 178 */         GL11.glDisable(3042);
/* 179 */         GL11.glDepthMask(true);
/* 180 */         GL11.glAlphaFunc(516, 0.1F);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   public void func_78872_b(Entity p_78872_1_, float p_78872_2_) {
/* 185 */     float f1 = 0.017453292F;
/* 186 */     float f2 = MathHelper.func_76134_b(p_78872_1_.field_70177_z * 0.017453292F);
/* 187 */     float f3 = MathHelper.func_76126_a(p_78872_1_.field_70177_z * 0.017453292F);
/*     */     
/* 189 */     float f4 = -f3 * MathHelper.func_76126_a(p_78872_1_.field_70125_A * 0.017453292F);
/* 190 */     float f5 = f2 * MathHelper.func_76126_a(p_78872_1_.field_70125_A * 0.017453292F);
/* 191 */     float f6 = MathHelper.func_76134_b(p_78872_1_.field_70125_A * 0.017453292F);
/*     */     
/* 193 */     byte b1 = 3;
/* 194 */     List<EntityFX> list = this.field_78876_b[b1];
/* 195 */     if (list.isEmpty())
/*     */       return; 
/* 197 */     Tessellator tessellator = Tessellator.field_78398_a;
/* 198 */     for (byte b2 = 0; b2 < list.size(); b2++) {
/* 199 */       EntityFX entityFX = list.get(b2);
/* 200 */       tessellator.func_78380_c(entityFX.func_70070_b(p_78872_2_));
/* 201 */       entityFX.func_70539_a(tessellator, p_78872_2_, f2, f6, f3, f4, f5);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_78870_a(World p_78870_1_) {
/* 206 */     this.field_78878_a = p_78870_1_;
/* 207 */     for (byte b = 0; b < 4; b++) {
/* 208 */       this.field_78876_b[b].clear();
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_147215_a(int p_147215_1_, int p_147215_2_, int p_147215_3_, Block p_147215_4_, int p_147215_5_) {
/* 213 */     if (p_147215_4_.func_149688_o() == Material.field_151579_a)
/* 214 */       return;  byte b1 = 4;
/* 215 */     for (byte b2 = 0; b2 < b1; b2++) {
/* 216 */       for (byte b = 0; b < b1; b++) {
/* 217 */         for (byte b3 = 0; b3 < b1; b3++) {
/* 218 */           double d1 = p_147215_1_ + (b2 + 0.5D) / b1;
/* 219 */           double d2 = p_147215_2_ + (b + 0.5D) / b1;
/* 220 */           double d3 = p_147215_3_ + (b3 + 0.5D) / b1;
/* 221 */           func_78873_a((new EntityDiggingFX(this.field_78878_a, d1, d2, d3, d1 - p_147215_1_ - 0.5D, d2 - p_147215_2_ - 0.5D, d3 - p_147215_3_ - 0.5D, p_147215_4_, p_147215_5_)).func_70596_a(p_147215_1_, p_147215_2_, p_147215_3_));
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_78867_a(int p_78867_1_, int p_78867_2_, int p_78867_3_, int p_78867_4_) {
/* 228 */     Block block = this.field_78878_a.func_147439_a(p_78867_1_, p_78867_2_, p_78867_3_);
/* 229 */     if (block.func_149688_o() == Material.field_151579_a)
/* 230 */       return;  float f = 0.1F;
/* 231 */     double d1 = p_78867_1_ + this.field_78875_d.nextDouble() * (block.func_149753_y() - block.func_149704_x() - (f * 2.0F)) + f + block.func_149704_x();
/* 232 */     double d2 = p_78867_2_ + this.field_78875_d.nextDouble() * (block.func_149669_A() - block.func_149665_z() - (f * 2.0F)) + f + block.func_149665_z();
/* 233 */     double d3 = p_78867_3_ + this.field_78875_d.nextDouble() * (block.func_149693_C() - block.func_149706_B() - (f * 2.0F)) + f + block.func_149706_B();
/* 234 */     if (p_78867_4_ == 0) d2 = p_78867_2_ + block.func_149665_z() - f; 
/* 235 */     if (p_78867_4_ == 1) d2 = p_78867_2_ + block.func_149669_A() + f; 
/* 236 */     if (p_78867_4_ == 2) d3 = p_78867_3_ + block.func_149706_B() - f; 
/* 237 */     if (p_78867_4_ == 3) d3 = p_78867_3_ + block.func_149693_C() + f; 
/* 238 */     if (p_78867_4_ == 4) d1 = p_78867_1_ + block.func_149704_x() - f; 
/* 239 */     if (p_78867_4_ == 5) d1 = p_78867_1_ + block.func_149753_y() + f; 
/* 240 */     func_78873_a((new EntityDiggingFX(this.field_78878_a, d1, d2, d3, 0.0D, 0.0D, 0.0D, block, this.field_78878_a.func_72805_g(p_78867_1_, p_78867_2_, p_78867_3_))).func_70596_a(p_78867_1_, p_78867_2_, p_78867_3_).func_70543_e(0.2F).func_70541_f(0.6F));
/*     */   }
/*     */   
/*     */   public String func_78869_b() {
/* 244 */     return "" + (this.field_78876_b[0].size() + this.field_78876_b[1].size() + this.field_78876_b[2].size());
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\particle\EffectRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */