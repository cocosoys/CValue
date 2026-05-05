/*     */ package net.minecraft.client.renderer.entity;
/*     */ import com.mojang.authlib.GameProfile;
/*     */ import net.minecraft.client.entity.AbstractClientPlayer;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelBiped;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.EnumAction;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemArmor;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.scoreboard.Score;
/*     */ import net.minecraft.scoreboard.ScoreObjective;
/*     */ import net.minecraft.scoreboard.Scoreboard;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class RenderPlayer extends RendererLivingEntity {
/*  23 */   private static final ResourceLocation field_110826_a = new ResourceLocation("textures/entity/steve.png"); public ModelBiped field_77109_a;
/*     */   public ModelBiped field_77108_b;
/*     */   public ModelBiped field_77111_i;
/*     */   private static final String __OBFID = "CL_00001020";
/*     */   
/*     */   public RenderPlayer() {
/*  29 */     super((ModelBase)new ModelBiped(0.0F), 0.5F);
/*     */     
/*  31 */     this.field_77109_a = (ModelBiped)this.field_77045_g;
/*     */     
/*  33 */     this.field_77108_b = new ModelBiped(1.0F);
/*  34 */     this.field_77111_i = new ModelBiped(0.5F);
/*     */   }
/*     */ 
/*     */   
/*     */   protected int func_77032_a(AbstractClientPlayer p_77032_1_, int p_77032_2_, float p_77032_3_) {
/*  39 */     ItemStack itemStack = p_77032_1_.field_71071_by.func_70440_f(3 - p_77032_2_);
/*  40 */     if (itemStack != null) {
/*  41 */       Item item = itemStack.func_77973_b();
/*  42 */       if (item instanceof ItemArmor) {
/*  43 */         ItemArmor itemArmor = (ItemArmor)item;
/*  44 */         func_110776_a(RenderBiped.func_110857_a(itemArmor, p_77032_2_));
/*     */         
/*  46 */         ModelBiped modelBiped = (p_77032_2_ == 2) ? this.field_77111_i : this.field_77108_b;
/*     */         
/*  48 */         modelBiped.field_78116_c.field_78806_j = (p_77032_2_ == 0);
/*  49 */         modelBiped.field_78114_d.field_78806_j = (p_77032_2_ == 0);
/*  50 */         modelBiped.field_78115_e.field_78806_j = (p_77032_2_ == 1 || p_77032_2_ == 2);
/*  51 */         modelBiped.field_78112_f.field_78806_j = (p_77032_2_ == 1);
/*  52 */         modelBiped.field_78113_g.field_78806_j = (p_77032_2_ == 1);
/*  53 */         modelBiped.field_78123_h.field_78806_j = (p_77032_2_ == 2 || p_77032_2_ == 3);
/*  54 */         modelBiped.field_78124_i.field_78806_j = (p_77032_2_ == 2 || p_77032_2_ == 3);
/*     */         
/*  56 */         func_77042_a((ModelBase)modelBiped);
/*  57 */         modelBiped.field_78095_p = this.field_77045_g.field_78095_p;
/*  58 */         modelBiped.field_78093_q = this.field_77045_g.field_78093_q;
/*  59 */         modelBiped.field_78091_s = this.field_77045_g.field_78091_s;
/*     */         
/*  61 */         if (itemArmor.func_82812_d() == ItemArmor.ArmorMaterial.CLOTH) {
/*  62 */           int i = itemArmor.func_82814_b(itemStack);
/*  63 */           float f1 = (i >> 16 & 0xFF) / 255.0F;
/*  64 */           float f2 = (i >> 8 & 0xFF) / 255.0F;
/*  65 */           float f3 = (i & 0xFF) / 255.0F;
/*  66 */           GL11.glColor3f(f1, f2, f3);
/*     */           
/*  68 */           if (itemStack.func_77948_v()) return 31; 
/*  69 */           return 16;
/*     */         } 
/*  71 */         GL11.glColor3f(1.0F, 1.0F, 1.0F);
/*     */ 
/*     */         
/*  74 */         if (itemStack.func_77948_v()) return 15;
/*     */         
/*  76 */         return 1;
/*     */       } 
/*     */     } 
/*  79 */     return -1;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_82408_c(AbstractClientPlayer p_82408_1_, int p_82408_2_, float p_82408_3_) {
/*  84 */     ItemStack itemStack = p_82408_1_.field_71071_by.func_70440_f(3 - p_82408_2_);
/*  85 */     if (itemStack != null) {
/*  86 */       Item item = itemStack.func_77973_b();
/*  87 */       if (item instanceof ItemArmor) {
/*  88 */         func_110776_a(RenderBiped.func_110858_a((ItemArmor)item, p_82408_2_, "overlay"));
/*     */         
/*  90 */         GL11.glColor3f(1.0F, 1.0F, 1.0F);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_76986_a(AbstractClientPlayer p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
/*  97 */     GL11.glColor3f(1.0F, 1.0F, 1.0F);
/*  98 */     ItemStack itemStack = p_76986_1_.field_71071_by.func_70448_g();
/*  99 */     this.field_77109_a.field_78120_m = (itemStack != null) ? 1 : 0;
/* 100 */     if (itemStack != null && 
/* 101 */       p_76986_1_.func_71052_bv() > 0) {
/* 102 */       EnumAction enumAction = itemStack.func_77975_n();
/* 103 */       if (enumAction == EnumAction.block) {
/* 104 */         this.field_77109_a.field_78120_m = 3;
/* 105 */       } else if (enumAction == EnumAction.bow) {
/* 106 */         this.field_77109_a.field_78118_o = true;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 111 */     this.field_77109_a.field_78117_n = p_76986_1_.func_70093_af();
/*     */     
/* 113 */     double d = p_76986_4_ - p_76986_1_.field_70129_M;
/* 114 */     if (p_76986_1_.func_70093_af() && !(p_76986_1_ instanceof net.minecraft.client.entity.EntityPlayerSP)) {
/* 115 */       d -= 0.125D;
/*     */     }
/* 117 */     super.func_76986_a((EntityLivingBase)p_76986_1_, p_76986_2_, d, p_76986_6_, p_76986_8_, p_76986_9_);
/* 118 */     this.field_77109_a.field_78118_o = false;
/* 119 */     this.field_77109_a.field_78117_n = false;
/* 120 */     this.field_77109_a.field_78120_m = 0;
/*     */   }
/*     */ 
/*     */   
/*     */   protected ResourceLocation func_110775_a(AbstractClientPlayer p_110775_1_) {
/* 125 */     return p_110775_1_.func_110306_p();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_77029_c(AbstractClientPlayer p_77029_1_, float p_77029_2_) {
/* 130 */     GL11.glColor3f(1.0F, 1.0F, 1.0F);
/* 131 */     super.func_77029_c((EntityLivingBase)p_77029_1_, p_77029_2_);
/* 132 */     func_85093_e((EntityLivingBase)p_77029_1_, p_77029_2_);
/* 133 */     ItemStack itemStack1 = p_77029_1_.field_71071_by.func_70440_f(3);
/*     */     
/* 135 */     if (itemStack1 != null) {
/* 136 */       GL11.glPushMatrix();
/* 137 */       this.field_77109_a.field_78116_c.func_78794_c(0.0625F);
/*     */       
/* 139 */       if (itemStack1.func_77973_b() instanceof net.minecraft.item.ItemBlock) {
/* 140 */         if (RenderBlocks.func_147739_a(Block.func_149634_a(itemStack1.func_77973_b()).func_149645_b())) {
/* 141 */           float f = 0.625F;
/* 142 */           GL11.glTranslatef(0.0F, -0.25F, 0.0F);
/* 143 */           GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
/* 144 */           GL11.glScalef(f, -f, -f);
/*     */         } 
/*     */         
/* 147 */         this.field_76990_c.field_78721_f.func_78443_a((EntityLivingBase)p_77029_1_, itemStack1, 0);
/* 148 */       } else if (itemStack1.func_77973_b() == Items.field_151144_bL) {
/* 149 */         float f = 1.0625F;
/* 150 */         GL11.glScalef(f, -f, -f);
/*     */         
/* 152 */         GameProfile gameProfile = null;
/* 153 */         if (itemStack1.func_77942_o()) {
/* 154 */           NBTTagCompound nBTTagCompound = itemStack1.func_77978_p();
/* 155 */           if (nBTTagCompound.func_150297_b("SkullOwner", 10)) {
/* 156 */             gameProfile = NBTUtil.func_152459_a(nBTTagCompound.func_74775_l("SkullOwner"));
/* 157 */           } else if (nBTTagCompound.func_150297_b("SkullOwner", 8) && !StringUtils.func_151246_b(nBTTagCompound.func_74779_i("SkullOwner"))) {
/* 158 */             gameProfile = new GameProfile(null, nBTTagCompound.func_74779_i("SkullOwner"));
/*     */           } 
/*     */         } 
/*     */         
/* 162 */         TileEntitySkullRenderer.field_147536_b.func_152674_a(-0.5F, 0.0F, -0.5F, 1, 180.0F, itemStack1.func_77960_j(), gameProfile);
/*     */       } 
/*     */       
/* 165 */       GL11.glPopMatrix();
/*     */     } 
/*     */     
/* 168 */     if (p_77029_1_.func_70005_c_().equals("deadmau5") && p_77029_1_.func_152123_o()) {
/* 169 */       func_110776_a(p_77029_1_.func_110306_p());
/* 170 */       for (byte b = 0; b < 2; b++) {
/* 171 */         float f1 = p_77029_1_.field_70126_B + (p_77029_1_.field_70177_z - p_77029_1_.field_70126_B) * p_77029_2_ - p_77029_1_.field_70760_ar + (p_77029_1_.field_70761_aq - p_77029_1_.field_70760_ar) * p_77029_2_;
/* 172 */         float f2 = p_77029_1_.field_70127_C + (p_77029_1_.field_70125_A - p_77029_1_.field_70127_C) * p_77029_2_;
/* 173 */         GL11.glPushMatrix();
/* 174 */         GL11.glRotatef(f1, 0.0F, 1.0F, 0.0F);
/* 175 */         GL11.glRotatef(f2, 1.0F, 0.0F, 0.0F);
/* 176 */         GL11.glTranslatef(0.375F * (b * 2 - 1), 0.0F, 0.0F);
/* 177 */         GL11.glTranslatef(0.0F, -0.375F, 0.0F);
/* 178 */         GL11.glRotatef(-f2, 1.0F, 0.0F, 0.0F);
/* 179 */         GL11.glRotatef(-f1, 0.0F, 1.0F, 0.0F);
/*     */         
/* 181 */         float f3 = 1.3333334F;
/* 182 */         GL11.glScalef(f3, f3, f3);
/* 183 */         this.field_77109_a.func_78110_b(0.0625F);
/* 184 */         GL11.glPopMatrix();
/*     */       } 
/*     */     } 
/*     */     
/* 188 */     boolean bool = p_77029_1_.func_152122_n();
/* 189 */     if (bool && !p_77029_1_.func_82150_aj() && !p_77029_1_.func_82238_cc()) {
/* 190 */       func_110776_a(p_77029_1_.func_110303_q());
/* 191 */       GL11.glPushMatrix();
/* 192 */       GL11.glTranslatef(0.0F, 0.0F, 0.125F);
/*     */       
/* 194 */       double d1 = p_77029_1_.field_71091_bM + (p_77029_1_.field_71094_bP - p_77029_1_.field_71091_bM) * p_77029_2_ - p_77029_1_.field_70169_q + (p_77029_1_.field_70165_t - p_77029_1_.field_70169_q) * p_77029_2_;
/* 195 */       double d2 = p_77029_1_.field_71096_bN + (p_77029_1_.field_71095_bQ - p_77029_1_.field_71096_bN) * p_77029_2_ - p_77029_1_.field_70167_r + (p_77029_1_.field_70163_u - p_77029_1_.field_70167_r) * p_77029_2_;
/* 196 */       double d3 = p_77029_1_.field_71097_bO + (p_77029_1_.field_71085_bR - p_77029_1_.field_71097_bO) * p_77029_2_ - p_77029_1_.field_70166_s + (p_77029_1_.field_70161_v - p_77029_1_.field_70166_s) * p_77029_2_;
/*     */       
/* 198 */       float f1 = p_77029_1_.field_70760_ar + (p_77029_1_.field_70761_aq - p_77029_1_.field_70760_ar) * p_77029_2_;
/*     */       
/* 200 */       double d4 = MathHelper.func_76126_a(f1 * 3.1415927F / 180.0F);
/* 201 */       double d5 = -MathHelper.func_76134_b(f1 * 3.1415927F / 180.0F);
/*     */       
/* 203 */       float f2 = (float)d2 * 10.0F;
/* 204 */       if (f2 < -6.0F) f2 = -6.0F; 
/* 205 */       if (f2 > 32.0F) f2 = 32.0F; 
/* 206 */       float f3 = (float)(d1 * d4 + d3 * d5) * 100.0F;
/* 207 */       float f4 = (float)(d1 * d5 - d3 * d4) * 100.0F;
/* 208 */       if (f3 < 0.0F) f3 = 0.0F;
/*     */       
/* 210 */       float f5 = p_77029_1_.field_71107_bF + (p_77029_1_.field_71109_bG - p_77029_1_.field_71107_bF) * p_77029_2_;
/*     */       
/* 212 */       f2 += MathHelper.func_76126_a((p_77029_1_.field_70141_P + (p_77029_1_.field_70140_Q - p_77029_1_.field_70141_P) * p_77029_2_) * 6.0F) * 32.0F * f5;
/* 213 */       if (p_77029_1_.func_70093_af()) {
/* 214 */         f2 += 25.0F;
/*     */       }
/*     */       
/* 217 */       GL11.glRotatef(6.0F + f3 / 2.0F + f2, 1.0F, 0.0F, 0.0F);
/* 218 */       GL11.glRotatef(f4 / 2.0F, 0.0F, 0.0F, 1.0F);
/* 219 */       GL11.glRotatef(-f4 / 2.0F, 0.0F, 1.0F, 0.0F);
/* 220 */       GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
/* 221 */       this.field_77109_a.func_78111_c(0.0625F);
/* 222 */       GL11.glPopMatrix();
/*     */     } 
/*     */     
/* 225 */     ItemStack itemStack2 = p_77029_1_.field_71071_by.func_70448_g();
/*     */     
/* 227 */     if (itemStack2 != null) {
/* 228 */       GL11.glPushMatrix();
/* 229 */       this.field_77109_a.field_78112_f.func_78794_c(0.0625F);
/* 230 */       GL11.glTranslatef(-0.0625F, 0.4375F, 0.0625F);
/*     */       
/* 232 */       if (p_77029_1_.field_71104_cf != null) {
/* 233 */         itemStack2 = new ItemStack(Items.field_151055_y);
/*     */       }
/*     */       
/* 236 */       EnumAction enumAction = null;
/* 237 */       if (p_77029_1_.func_71052_bv() > 0) {
/* 238 */         enumAction = itemStack2.func_77975_n();
/*     */       }
/*     */       
/* 241 */       if (itemStack2.func_77973_b() instanceof net.minecraft.item.ItemBlock && RenderBlocks.func_147739_a(Block.func_149634_a(itemStack2.func_77973_b()).func_149645_b())) {
/* 242 */         float f = 0.5F;
/* 243 */         GL11.glTranslatef(0.0F, 0.1875F, -0.3125F);
/* 244 */         f *= 0.75F;
/* 245 */         GL11.glRotatef(20.0F, 1.0F, 0.0F, 0.0F);
/* 246 */         GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
/* 247 */         GL11.glScalef(-f, -f, f);
/* 248 */       } else if (itemStack2.func_77973_b() == Items.field_151031_f) {
/* 249 */         float f = 0.625F;
/* 250 */         GL11.glTranslatef(0.0F, 0.125F, 0.3125F);
/* 251 */         GL11.glRotatef(-20.0F, 0.0F, 1.0F, 0.0F);
/* 252 */         GL11.glScalef(f, -f, f);
/* 253 */         GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
/* 254 */         GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
/* 255 */       } else if (itemStack2.func_77973_b().func_77662_d()) {
/* 256 */         float f = 0.625F;
/* 257 */         if (itemStack2.func_77973_b().func_77629_n_()) {
/* 258 */           GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
/* 259 */           GL11.glTranslatef(0.0F, -0.125F, 0.0F);
/*     */         } 
/* 261 */         if (p_77029_1_.func_71052_bv() > 0 && 
/* 262 */           enumAction == EnumAction.block) {
/* 263 */           GL11.glTranslatef(0.05F, 0.0F, -0.1F);
/* 264 */           GL11.glRotatef(-50.0F, 0.0F, 1.0F, 0.0F);
/* 265 */           GL11.glRotatef(-10.0F, 1.0F, 0.0F, 0.0F);
/* 266 */           GL11.glRotatef(-60.0F, 0.0F, 0.0F, 1.0F);
/*     */         } 
/*     */         
/* 269 */         GL11.glTranslatef(0.0F, 0.1875F, 0.0F);
/* 270 */         GL11.glScalef(f, -f, f);
/* 271 */         GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
/* 272 */         GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
/*     */       } else {
/* 274 */         float f = 0.375F;
/* 275 */         GL11.glTranslatef(0.25F, 0.1875F, -0.1875F);
/* 276 */         GL11.glScalef(f, f, f);
/* 277 */         GL11.glRotatef(60.0F, 0.0F, 0.0F, 1.0F);
/* 278 */         GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
/* 279 */         GL11.glRotatef(20.0F, 0.0F, 0.0F, 1.0F);
/*     */       } 
/*     */       
/* 282 */       if (itemStack2.func_77973_b().func_77623_v()) {
/* 283 */         for (byte b = 0; b <= 1; b++) {
/* 284 */           int i = itemStack2.func_77973_b().func_82790_a(itemStack2, b);
/* 285 */           float f1 = (i >> 16 & 0xFF) / 255.0F;
/* 286 */           float f2 = (i >> 8 & 0xFF) / 255.0F;
/* 287 */           float f3 = (i & 0xFF) / 255.0F;
/*     */           
/* 289 */           GL11.glColor4f(f1, f2, f3, 1.0F);
/* 290 */           this.field_76990_c.field_78721_f.func_78443_a((EntityLivingBase)p_77029_1_, itemStack2, b);
/*     */         } 
/*     */       } else {
/* 293 */         int i = itemStack2.func_77973_b().func_82790_a(itemStack2, 0);
/* 294 */         float f1 = (i >> 16 & 0xFF) / 255.0F;
/* 295 */         float f2 = (i >> 8 & 0xFF) / 255.0F;
/* 296 */         float f3 = (i & 0xFF) / 255.0F;
/*     */         
/* 298 */         GL11.glColor4f(f1, f2, f3, 1.0F);
/* 299 */         this.field_76990_c.field_78721_f.func_78443_a((EntityLivingBase)p_77029_1_, itemStack2, 0);
/*     */       } 
/*     */       
/* 302 */       GL11.glPopMatrix();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_77041_b(AbstractClientPlayer p_77041_1_, float p_77041_2_) {
/* 308 */     float f = 0.9375F;
/* 309 */     GL11.glScalef(f, f, f);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_96449_a(AbstractClientPlayer p_96449_1_, double p_96449_2_, double p_96449_4_, double p_96449_6_, String p_96449_8_, float p_96449_9_, double p_96449_10_) {
/* 314 */     if (p_96449_10_ < 100.0D) {
/* 315 */       Scoreboard scoreboard = p_96449_1_.func_96123_co();
/* 316 */       ScoreObjective scoreObjective = scoreboard.func_96539_a(2);
/*     */       
/* 318 */       if (scoreObjective != null) {
/* 319 */         Score score = scoreboard.func_96529_a(p_96449_1_.func_70005_c_(), scoreObjective);
/*     */         
/* 321 */         if (p_96449_1_.func_70608_bn()) {
/* 322 */           func_147906_a((Entity)p_96449_1_, score.func_96652_c() + " " + scoreObjective.func_96678_d(), p_96449_2_, p_96449_4_ - 1.5D, p_96449_6_, 64);
/*     */         } else {
/* 324 */           func_147906_a((Entity)p_96449_1_, score.func_96652_c() + " " + scoreObjective.func_96678_d(), p_96449_2_, p_96449_4_, p_96449_6_, 64);
/*     */         } 
/*     */         
/* 327 */         p_96449_4_ += ((func_76983_a()).field_78288_b * 1.15F * p_96449_9_);
/*     */       } 
/*     */     } 
/*     */     
/* 331 */     super.func_96449_a((EntityLivingBase)p_96449_1_, p_96449_2_, p_96449_4_, p_96449_6_, p_96449_8_, p_96449_9_, p_96449_10_);
/*     */   }
/*     */   
/*     */   public void func_82441_a(EntityPlayer p_82441_1_) {
/* 335 */     float f = 1.0F;
/* 336 */     GL11.glColor3f(f, f, f);
/* 337 */     this.field_77109_a.field_78095_p = 0.0F;
/* 338 */     this.field_77109_a.func_78087_a(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, (Entity)p_82441_1_);
/* 339 */     this.field_77109_a.field_78112_f.func_78785_a(0.0625F);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_77039_a(AbstractClientPlayer p_77039_1_, double p_77039_2_, double p_77039_4_, double p_77039_6_) {
/* 344 */     if (p_77039_1_.func_70089_S() && p_77039_1_.func_70608_bn()) {
/* 345 */       super.func_77039_a((EntityLivingBase)p_77039_1_, p_77039_2_ + p_77039_1_.field_71079_bU, p_77039_4_ + p_77039_1_.field_71082_cx, p_77039_6_ + p_77039_1_.field_71089_bV);
/*     */     } else {
/*     */       
/* 348 */       super.func_77039_a((EntityLivingBase)p_77039_1_, p_77039_2_, p_77039_4_, p_77039_6_);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_77043_a(AbstractClientPlayer p_77043_1_, float p_77043_2_, float p_77043_3_, float p_77043_4_) {
/* 355 */     if (p_77043_1_.func_70089_S() && p_77043_1_.func_70608_bn()) {
/* 356 */       GL11.glRotatef(p_77043_1_.func_71051_bG(), 0.0F, 1.0F, 0.0F);
/* 357 */       GL11.glRotatef(func_77037_a((EntityLivingBase)p_77043_1_), 0.0F, 0.0F, 1.0F);
/* 358 */       GL11.glRotatef(270.0F, 0.0F, 1.0F, 0.0F);
/*     */     } else {
/* 360 */       super.func_77043_a((EntityLivingBase)p_77043_1_, p_77043_2_, p_77043_3_, p_77043_4_);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\entity\RenderPlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */