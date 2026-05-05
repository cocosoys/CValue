/*      */ package net.minecraft.client.renderer;
/*      */ import com.google.gson.JsonSyntaxException;
/*      */ import cpw.mods.fml.relauncher.Side;
/*      */ import cpw.mods.fml.relauncher.SideOnly;
/*      */ import java.io.IOException;
/*      */ import java.nio.FloatBuffer;
/*      */ import java.util.List;
/*      */ import java.util.Random;
/*      */ import java.util.concurrent.Callable;
/*      */ import net.minecraft.block.Block;
/*      */ import net.minecraft.block.material.Material;
/*      */ import net.minecraft.client.Minecraft;
/*      */ import net.minecraft.client.entity.EntityPlayerSP;
/*      */ import net.minecraft.client.gui.MapItemRenderer;
/*      */ import net.minecraft.client.gui.ScaledResolution;
/*      */ import net.minecraft.client.multiplayer.WorldClient;
/*      */ import net.minecraft.client.particle.EffectRenderer;
/*      */ import net.minecraft.client.renderer.culling.Frustrum;
/*      */ import net.minecraft.client.renderer.texture.TextureMap;
/*      */ import net.minecraft.client.resources.IResourceManager;
/*      */ import net.minecraft.client.shader.ShaderGroup;
/*      */ import net.minecraft.client.shader.ShaderLinkHelper;
/*      */ import net.minecraft.crash.CrashReport;
/*      */ import net.minecraft.crash.CrashReportCategory;
/*      */ import net.minecraft.enchantment.EnchantmentHelper;
/*      */ import net.minecraft.entity.Entity;
/*      */ import net.minecraft.entity.EntityLivingBase;
/*      */ import net.minecraft.entity.player.EntityPlayer;
/*      */ import net.minecraft.potion.Potion;
/*      */ import net.minecraft.util.AxisAlignedBB;
/*      */ import net.minecraft.util.MathHelper;
/*      */ import net.minecraft.util.MouseFilter;
/*      */ import net.minecraft.util.MovingObjectPosition;
/*      */ import net.minecraft.util.ResourceLocation;
/*      */ import net.minecraft.util.Vec3;
/*      */ import net.minecraft.world.World;
/*      */ import net.minecraft.world.biome.BiomeGenBase;
/*      */ import org.lwjgl.input.Mouse;
/*      */ import org.lwjgl.opengl.GL11;
/*      */ import org.lwjgl.opengl.GLContext;
/*      */ 
/*      */ @SideOnly(Side.CLIENT)
/*      */ public class EntityRenderer implements IResourceManagerReloadListener {
/*   44 */   private static final Logger field_147710_q = LogManager.getLogger();
/*   45 */   private static final ResourceLocation field_110924_q = new ResourceLocation("textures/environment/rain.png");
/*   46 */   private static final ResourceLocation field_110923_r = new ResourceLocation("textures/environment/snow.png");
/*      */   
/*      */   public static boolean field_78517_a;
/*      */   
/*      */   public static int field_78515_b;
/*      */   
/*      */   private Minecraft field_78531_r;
/*      */   
/*      */   private float field_78530_s;
/*      */   public final ItemRenderer field_78516_c;
/*      */   private final MapItemRenderer field_147709_v;
/*      */   private int field_78529_t;
/*      */   private Entity field_78528_u;
/*   59 */   private MouseFilter field_78527_v = new MouseFilter();
/*   60 */   private MouseFilter field_78526_w = new MouseFilter();
/*      */ 
/*      */   
/*   63 */   private MouseFilter field_78541_x = new MouseFilter();
/*   64 */   private MouseFilter field_78540_y = new MouseFilter();
/*   65 */   private MouseFilter field_78538_z = new MouseFilter();
/*   66 */   private MouseFilter field_78489_A = new MouseFilter();
/*   67 */   private float field_78490_B = 4.0F;
/*   68 */   private float field_78491_C = 4.0F;
/*      */   
/*      */   private float field_78485_D;
/*      */   
/*      */   private float field_78486_E;
/*      */   
/*      */   private float field_78487_F;
/*      */   
/*      */   private float field_78488_G;
/*      */   
/*      */   private float field_78496_H;
/*      */   
/*      */   private float field_78497_I;
/*      */   
/*      */   private float field_78498_J;
/*      */   private float field_78499_K;
/*      */   private float field_78492_L;
/*      */   private float field_78493_M;
/*      */   private float field_78494_N;
/*      */   private float field_78495_O;
/*      */   private float field_78505_P;
/*      */   private final DynamicTexture field_78513_d;
/*      */   private final int[] field_78504_Q;
/*      */   private final ResourceLocation field_110922_T;
/*      */   private float field_78507_R;
/*      */   private float field_78506_S;
/*      */   private float field_78501_T;
/*      */   private float field_82831_U;
/*      */   private float field_82832_V;
/*      */   private boolean field_78500_U;
/*      */   private final IResourceManager field_147711_ac;
/*      */   public ShaderGroup field_147707_d;
/*  100 */   private static final ResourceLocation[] field_147712_ad = new ResourceLocation[] { new ResourceLocation("shaders/post/notch.json"), new ResourceLocation("shaders/post/fxaa.json"), new ResourceLocation("shaders/post/art.json"), new ResourceLocation("shaders/post/bumpy.json"), new ResourceLocation("shaders/post/blobs2.json"), new ResourceLocation("shaders/post/pencil.json"), new ResourceLocation("shaders/post/color_convolve.json"), new ResourceLocation("shaders/post/deconverge.json"), new ResourceLocation("shaders/post/flip.json"), new ResourceLocation("shaders/post/invert.json"), new ResourceLocation("shaders/post/ntsc.json"), new ResourceLocation("shaders/post/outline.json"), new ResourceLocation("shaders/post/phosphor.json"), new ResourceLocation("shaders/post/scan_pincushion.json"), new ResourceLocation("shaders/post/sobel.json"), new ResourceLocation("shaders/post/bits.json"), new ResourceLocation("shaders/post/desaturate.json"), new ResourceLocation("shaders/post/green.json"), new ResourceLocation("shaders/post/blur.json"), new ResourceLocation("shaders/post/wobble.json"), new ResourceLocation("shaders/post/blobs.json"), new ResourceLocation("shaders/post/antialias.json") };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  124 */   public static final int field_147708_e = field_147712_ad.length;
/*  125 */   private int field_147713_ae = field_147708_e; private double field_78503_V; private double field_78502_W; private double field_78509_X; private long field_78508_Y; private long field_78510_Z; private boolean field_78536_aa; float field_78514_e; float field_78511_f; float field_78512_g;
/*      */   float field_78524_h;
/*      */   private Random field_78537_ab;
/*      */   private int field_78534_ac;
/*      */   float[] field_78525_i;
/*      */   float[] field_78522_j;
/*      */   FloatBuffer field_78521_m;
/*      */   float field_78518_n;
/*      */   float field_78519_o;
/*      */   float field_78533_p;
/*      */   private float field_78535_ad;
/*      */   private float field_78539_ae;
/*      */   public int field_78532_q;
/*      */   private static final String __OBFID = "CL_00000947";
/*      */   
/*      */   public boolean func_147702_a() {
/*  141 */     return (OpenGlHelper.field_148824_g && this.field_147707_d != null);
/*      */   }
/*      */   
/*      */   public void func_147703_b() {
/*  145 */     if (this.field_147707_d != null) this.field_147707_d.func_148021_a(); 
/*  146 */     this.field_147707_d = null;
/*  147 */     this.field_147713_ae = field_147708_e;
/*      */   }
/*      */   
/*      */   public void func_147705_c() {
/*  151 */     if (!OpenGlHelper.field_148824_g) {
/*      */       return;
/*      */     }
/*      */     
/*  155 */     if (this.field_147707_d != null) {
/*  156 */       this.field_147707_d.func_148021_a();
/*      */     }
/*      */ 
/*      */     
/*  160 */     this.field_147713_ae = (this.field_147713_ae + 1) % (field_147712_ad.length + 1);
/*  161 */     if (this.field_147713_ae != field_147708_e) {
/*      */       try {
/*  163 */         field_147710_q.info("Selecting effect " + field_147712_ad[this.field_147713_ae]);
/*  164 */         this.field_147707_d = new ShaderGroup(this.field_78531_r.func_110434_K(), this.field_147711_ac, this.field_78531_r.func_147110_a(), field_147712_ad[this.field_147713_ae]);
/*  165 */         this.field_147707_d.func_148026_a(this.field_78531_r.field_71443_c, this.field_78531_r.field_71440_d);
/*  166 */       } catch (IOException iOException) {
/*  167 */         field_147710_q.warn("Failed to load shader: " + field_147712_ad[this.field_147713_ae], iOException);
/*  168 */         this.field_147713_ae = field_147708_e;
/*  169 */       } catch (JsonSyntaxException jsonSyntaxException) {
/*  170 */         field_147710_q.warn("Failed to load shader: " + field_147712_ad[this.field_147713_ae], (Throwable)jsonSyntaxException);
/*  171 */         this.field_147713_ae = field_147708_e;
/*      */       } 
/*      */     } else {
/*  174 */       this.field_147707_d = null;
/*  175 */       field_147710_q.info("No effect selected");
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_110549_a(IResourceManager p_110549_1_) {
/*  181 */     if (this.field_147707_d != null) {
/*  182 */       this.field_147707_d.func_148021_a();
/*      */     }
/*  184 */     if (this.field_147713_ae != field_147708_e) {
/*      */       try {
/*  186 */         this.field_147707_d = new ShaderGroup(this.field_78531_r.func_110434_K(), p_110549_1_, this.field_78531_r.func_147110_a(), field_147712_ad[this.field_147713_ae]);
/*  187 */         this.field_147707_d.func_148026_a(this.field_78531_r.field_71443_c, this.field_78531_r.field_71440_d);
/*  188 */       } catch (IOException iOException) {
/*  189 */         field_147710_q.warn("Failed to load shader: " + field_147712_ad[this.field_147713_ae], iOException);
/*  190 */         this.field_147713_ae = field_147708_e;
/*      */       } 
/*      */     }
/*      */   }
/*      */   
/*      */   public void func_78464_a() {
/*  196 */     if (OpenGlHelper.field_148824_g && ShaderLinkHelper.func_148074_b() == null) {
/*  197 */       ShaderLinkHelper.func_148076_a();
/*      */     }
/*      */     
/*  200 */     func_78477_e();
/*  201 */     func_78470_f();
/*  202 */     this.field_78535_ad = this.field_78539_ae;
/*  203 */     this.field_78491_C = this.field_78490_B;
/*  204 */     this.field_78486_E = this.field_78485_D;
/*  205 */     this.field_78488_G = this.field_78487_F;
/*  206 */     this.field_78494_N = this.field_78493_M;
/*  207 */     this.field_78505_P = this.field_78495_O;
/*      */     
/*  209 */     if (this.field_78531_r.field_71474_y.field_74326_T) {
/*      */ 
/*      */       
/*  212 */       float f4 = this.field_78531_r.field_71474_y.field_74341_c * 0.6F + 0.2F;
/*  213 */       float f5 = f4 * f4 * f4 * 8.0F;
/*  214 */       this.field_78498_J = this.field_78527_v.func_76333_a(this.field_78496_H, 0.05F * f5);
/*  215 */       this.field_78499_K = this.field_78526_w.func_76333_a(this.field_78497_I, 0.05F * f5);
/*  216 */       this.field_78492_L = 0.0F;
/*      */       
/*  218 */       this.field_78496_H = 0.0F;
/*  219 */       this.field_78497_I = 0.0F;
/*      */     } 
/*      */     
/*  222 */     if (this.field_78531_r.field_71451_h == null) {
/*  223 */       this.field_78531_r.field_71451_h = (EntityLivingBase)this.field_78531_r.field_71439_g;
/*      */     }
/*      */     
/*  226 */     float f1 = this.field_78531_r.field_71441_e.func_72801_o(MathHelper.func_76128_c(this.field_78531_r.field_71451_h.field_70165_t), MathHelper.func_76128_c(this.field_78531_r.field_71451_h.field_70163_u), MathHelper.func_76128_c(this.field_78531_r.field_71451_h.field_70161_v));
/*  227 */     float f2 = this.field_78531_r.field_71474_y.field_151451_c / 16.0F;
/*  228 */     float f3 = f1 * (1.0F - f2) + f2;
/*  229 */     this.field_78539_ae += (f3 - this.field_78539_ae) * 0.1F;
/*      */     
/*  231 */     this.field_78529_t++;
/*      */     
/*  233 */     this.field_78516_c.func_78441_a();
/*  234 */     func_78484_h();
/*      */     
/*  236 */     this.field_82832_V = this.field_82831_U;
/*  237 */     if (BossStatus.field_82825_d) {
/*  238 */       this.field_82831_U += 0.05F;
/*  239 */       if (this.field_82831_U > 1.0F) {
/*  240 */         this.field_82831_U = 1.0F;
/*      */       }
/*  242 */       BossStatus.field_82825_d = false;
/*  243 */     } else if (this.field_82831_U > 0.0F) {
/*  244 */       this.field_82831_U -= 0.0125F;
/*      */     } 
/*      */   }
/*      */   
/*      */   public ShaderGroup func_147706_e() {
/*  249 */     return this.field_147707_d;
/*      */   }
/*      */   
/*      */   public void func_147704_a(int p_147704_1_, int p_147704_2_) {
/*  253 */     if (!OpenGlHelper.field_148824_g) {
/*      */       return;
/*      */     }
/*      */     
/*  257 */     if (this.field_147707_d != null) {
/*  258 */       this.field_147707_d.func_148026_a(p_147704_1_, p_147704_2_);
/*      */     }
/*      */   }
/*      */   
/*      */   public void func_78473_a(float p_78473_1_) {
/*  263 */     if (this.field_78531_r.field_71451_h == null)
/*  264 */       return;  if (this.field_78531_r.field_71441_e == null)
/*      */       return; 
/*  266 */     this.field_78531_r.field_147125_j = null;
/*      */     
/*  268 */     double d1 = this.field_78531_r.field_71442_b.func_78757_d();
/*  269 */     this.field_78531_r.field_71476_x = this.field_78531_r.field_71451_h.func_70614_a(d1, p_78473_1_);
/*      */     
/*  271 */     double d2 = d1;
/*  272 */     Vec3 vec31 = this.field_78531_r.field_71451_h.func_70666_h(p_78473_1_);
/*      */ 
/*      */     
/*  275 */     d2 = d1 = 6.0D;
/*      */     
/*  277 */     if (d2 > 3.0D) d2 = 3.0D; 
/*  278 */     d1 = d2;
/*      */ 
/*      */     
/*  281 */     if (this.field_78531_r.field_71476_x != null) {
/*  282 */       d2 = this.field_78531_r.field_71476_x.field_72307_f.func_72438_d(vec31);
/*      */     }
/*      */     
/*  285 */     Vec3 vec32 = this.field_78531_r.field_71451_h.func_70676_i(p_78473_1_);
/*  286 */     Vec3 vec33 = vec31.func_72441_c(vec32.field_72450_a * d1, vec32.field_72448_b * d1, vec32.field_72449_c * d1);
/*  287 */     this.field_78528_u = null;
/*  288 */     Vec3 vec34 = null;
/*  289 */     float f = 1.0F;
/*      */     
/*  291 */     List<Entity> list = this.field_78531_r.field_71441_e.func_72839_b((Entity)this.field_78531_r.field_71451_h, this.field_78531_r.field_71451_h.field_70121_D.func_72321_a(vec32.field_72450_a * d1, vec32.field_72448_b * d1, vec32.field_72449_c * d1).func_72314_b(f, f, f));
/*  292 */     double d3 = d2;
/*  293 */     for (byte b = 0; b < list.size(); b++) {
/*  294 */       Entity entity = list.get(b);
/*  295 */       if (entity.func_70067_L()) {
/*      */         
/*  297 */         float f1 = entity.func_70111_Y();
/*  298 */         AxisAlignedBB axisAlignedBB = entity.field_70121_D.func_72314_b(f1, f1, f1);
/*  299 */         MovingObjectPosition movingObjectPosition = axisAlignedBB.func_72327_a(vec31, vec33);
/*  300 */         if (axisAlignedBB.func_72318_a(vec31)) {
/*  301 */           if (0.0D < d3 || d3 == 0.0D) {
/*  302 */             this.field_78528_u = entity;
/*  303 */             vec34 = (movingObjectPosition == null) ? vec31 : movingObjectPosition.field_72307_f;
/*  304 */             d3 = 0.0D;
/*      */           } 
/*  306 */         } else if (movingObjectPosition != null) {
/*  307 */           double d = vec31.func_72438_d(movingObjectPosition.field_72307_f);
/*  308 */           if (d < d3 || d3 == 0.0D) {
/*  309 */             if (entity == this.field_78531_r.field_71451_h.field_70154_o) {
/*  310 */               if (d3 == 0.0D) {
/*  311 */                 this.field_78528_u = entity;
/*  312 */                 vec34 = movingObjectPosition.field_72307_f;
/*      */               } 
/*      */             } else {
/*  315 */               this.field_78528_u = entity;
/*  316 */               vec34 = movingObjectPosition.field_72307_f;
/*  317 */               d3 = d;
/*      */             } 
/*      */           }
/*      */         } 
/*      */       } 
/*      */     } 
/*  323 */     if (this.field_78528_u != null && (
/*  324 */       d3 < d2 || this.field_78531_r.field_71476_x == null)) {
/*  325 */       this.field_78531_r.field_71476_x = new MovingObjectPosition(this.field_78528_u, vec34);
/*  326 */       if (this.field_78528_u instanceof EntityLivingBase || this.field_78528_u instanceof net.minecraft.entity.item.EntityItemFrame) {
/*  327 */         this.field_78531_r.field_147125_j = this.field_78528_u;
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void func_78477_e() {
/*  334 */     EntityPlayerSP entityPlayerSP = (EntityPlayerSP)this.field_78531_r.field_71451_h;
/*      */     
/*  336 */     this.field_78501_T = entityPlayerSP.func_71151_f();
/*      */     
/*  338 */     this.field_78506_S = this.field_78507_R;
/*  339 */     this.field_78507_R += (this.field_78501_T - this.field_78507_R) * 0.5F;
/*      */     
/*  341 */     if (this.field_78507_R > 1.5F) this.field_78507_R = 1.5F; 
/*  342 */     if (this.field_78507_R < 0.1F) this.field_78507_R = 0.1F; 
/*      */   }
/*      */   
/*      */   private float func_78481_a(float p_78481_1_, boolean p_78481_2_) {
/*  346 */     if (this.field_78532_q > 0) return 90.0F;
/*      */     
/*  348 */     EntityPlayer entityPlayer = (EntityPlayer)this.field_78531_r.field_71451_h;
/*  349 */     float f = 70.0F;
/*  350 */     if (p_78481_2_) {
/*  351 */       f = this.field_78531_r.field_71474_y.field_74334_X;
/*  352 */       f *= this.field_78506_S + (this.field_78507_R - this.field_78506_S) * p_78481_1_;
/*      */     } 
/*  354 */     if (entityPlayer.func_110143_aJ() <= 0.0F) {
/*  355 */       float f1 = entityPlayer.field_70725_aQ + p_78481_1_;
/*      */       
/*  357 */       f /= (1.0F - 500.0F / (f1 + 500.0F)) * 2.0F + 1.0F;
/*      */     } 
/*      */     
/*  360 */     Block block = ActiveRenderInfo.func_151460_a((World)this.field_78531_r.field_71441_e, (EntityLivingBase)entityPlayer, p_78481_1_);
/*  361 */     if (block.func_149688_o() == Material.field_151586_h) f = f * 60.0F / 70.0F;
/*      */     
/*  363 */     return f + this.field_78494_N + (this.field_78493_M - this.field_78494_N) * p_78481_1_;
/*      */   }
/*      */   
/*      */   private void func_78482_e(float p_78482_1_) {
/*  367 */     EntityLivingBase entityLivingBase = this.field_78531_r.field_71451_h;
/*      */     
/*  369 */     float f1 = entityLivingBase.field_70737_aN - p_78482_1_;
/*      */     
/*  371 */     if (entityLivingBase.func_110143_aJ() <= 0.0F) {
/*  372 */       float f = entityLivingBase.field_70725_aQ + p_78482_1_;
/*      */       
/*  374 */       GL11.glRotatef(40.0F - 8000.0F / (f + 200.0F), 0.0F, 0.0F, 1.0F);
/*      */     } 
/*      */     
/*  377 */     if (f1 < 0.0F)
/*  378 */       return;  f1 /= entityLivingBase.field_70738_aO;
/*  379 */     f1 = MathHelper.func_76126_a(f1 * f1 * f1 * f1 * 3.1415927F);
/*      */     
/*  381 */     float f2 = entityLivingBase.field_70739_aP;
/*      */     
/*  383 */     GL11.glRotatef(-f2, 0.0F, 1.0F, 0.0F);
/*  384 */     GL11.glRotatef(-f1 * 14.0F, 0.0F, 0.0F, 1.0F);
/*  385 */     GL11.glRotatef(f2, 0.0F, 1.0F, 0.0F);
/*      */   }
/*      */   
/*      */   private void func_78475_f(float p_78475_1_) {
/*  389 */     if (!(this.field_78531_r.field_71451_h instanceof EntityPlayer)) {
/*      */       return;
/*      */     }
/*  392 */     EntityPlayer entityPlayer = (EntityPlayer)this.field_78531_r.field_71451_h;
/*      */     
/*  394 */     float f1 = entityPlayer.field_70140_Q - entityPlayer.field_70141_P;
/*  395 */     float f2 = -(entityPlayer.field_70140_Q + f1 * p_78475_1_);
/*  396 */     float f3 = entityPlayer.field_71107_bF + (entityPlayer.field_71109_bG - entityPlayer.field_71107_bF) * p_78475_1_;
/*  397 */     float f4 = entityPlayer.field_70727_aS + (entityPlayer.field_70726_aT - entityPlayer.field_70727_aS) * p_78475_1_;
/*  398 */     GL11.glTranslatef(MathHelper.func_76126_a(f2 * 3.1415927F) * f3 * 0.5F, -Math.abs(MathHelper.func_76134_b(f2 * 3.1415927F) * f3), 0.0F);
/*  399 */     GL11.glRotatef(MathHelper.func_76126_a(f2 * 3.1415927F) * f3 * 3.0F, 0.0F, 0.0F, 1.0F);
/*  400 */     GL11.glRotatef(Math.abs(MathHelper.func_76134_b(f2 * 3.1415927F - 0.2F) * f3) * 5.0F, 1.0F, 0.0F, 0.0F);
/*  401 */     GL11.glRotatef(f4, 1.0F, 0.0F, 0.0F);
/*      */   }
/*      */   
/*      */   private void func_78467_g(float p_78467_1_) {
/*  405 */     EntityLivingBase entityLivingBase = this.field_78531_r.field_71451_h;
/*      */     
/*  407 */     float f = entityLivingBase.field_70129_M - 1.62F;
/*      */     
/*  409 */     double d1 = entityLivingBase.field_70169_q + (entityLivingBase.field_70165_t - entityLivingBase.field_70169_q) * p_78467_1_;
/*  410 */     double d2 = entityLivingBase.field_70167_r + (entityLivingBase.field_70163_u - entityLivingBase.field_70167_r) * p_78467_1_ - f;
/*  411 */     double d3 = entityLivingBase.field_70166_s + (entityLivingBase.field_70161_v - entityLivingBase.field_70166_s) * p_78467_1_;
/*      */     
/*  413 */     GL11.glRotatef(this.field_78505_P + (this.field_78495_O - this.field_78505_P) * p_78467_1_, 0.0F, 0.0F, 1.0F);
/*      */     
/*  415 */     if (entityLivingBase.func_70608_bn()) {
/*  416 */       f = (float)(f + 1.0D);
/*  417 */       GL11.glTranslatef(0.0F, 0.3F, 0.0F);
/*  418 */       if (!this.field_78531_r.field_71474_y.field_74325_U) {
/*  419 */         Block block = this.field_78531_r.field_71441_e.func_147439_a(MathHelper.func_76128_c(entityLivingBase.field_70165_t), MathHelper.func_76128_c(entityLivingBase.field_70163_u), MathHelper.func_76128_c(entityLivingBase.field_70161_v));
/*  420 */         if (block == Blocks.field_150324_C) {
/*  421 */           int i = this.field_78531_r.field_71441_e.func_72805_g(MathHelper.func_76128_c(entityLivingBase.field_70165_t), MathHelper.func_76128_c(entityLivingBase.field_70163_u), MathHelper.func_76128_c(entityLivingBase.field_70161_v));
/*      */           
/*  423 */           int j = i & 0x3;
/*  424 */           GL11.glRotatef((j * 90), 0.0F, 1.0F, 0.0F);
/*      */         } 
/*  426 */         GL11.glRotatef(entityLivingBase.field_70126_B + (entityLivingBase.field_70177_z - entityLivingBase.field_70126_B) * p_78467_1_ + 180.0F, 0.0F, -1.0F, 0.0F);
/*  427 */         GL11.glRotatef(entityLivingBase.field_70127_C + (entityLivingBase.field_70125_A - entityLivingBase.field_70127_C) * p_78467_1_, -1.0F, 0.0F, 0.0F);
/*      */       } 
/*  429 */     } else if (this.field_78531_r.field_71474_y.field_74320_O > 0) {
/*  430 */       double d = (this.field_78491_C + (this.field_78490_B - this.field_78491_C) * p_78467_1_);
/*      */       
/*  432 */       if (this.field_78531_r.field_71474_y.field_74325_U) {
/*      */         
/*  434 */         float f1 = this.field_78486_E + (this.field_78485_D - this.field_78486_E) * p_78467_1_;
/*  435 */         float f2 = this.field_78488_G + (this.field_78487_F - this.field_78488_G) * p_78467_1_;
/*      */         
/*  437 */         GL11.glTranslatef(0.0F, 0.0F, (float)-d);
/*  438 */         GL11.glRotatef(f2, 1.0F, 0.0F, 0.0F);
/*  439 */         GL11.glRotatef(f1, 0.0F, 1.0F, 0.0F);
/*      */       } else {
/*  441 */         float f1 = entityLivingBase.field_70177_z;
/*  442 */         float f2 = entityLivingBase.field_70125_A;
/*      */         
/*  444 */         if (this.field_78531_r.field_71474_y.field_74320_O == 2) {
/*  445 */           f2 += 180.0F;
/*      */         }
/*      */         
/*  448 */         double d4 = (-MathHelper.func_76126_a(f1 / 180.0F * 3.1415927F) * MathHelper.func_76134_b(f2 / 180.0F * 3.1415927F)) * d;
/*  449 */         double d5 = (MathHelper.func_76134_b(f1 / 180.0F * 3.1415927F) * MathHelper.func_76134_b(f2 / 180.0F * 3.1415927F)) * d;
/*  450 */         double d6 = -MathHelper.func_76126_a(f2 / 180.0F * 3.1415927F) * d;
/*      */         
/*  452 */         for (byte b = 0; b < 8; b++) {
/*  453 */           float f3 = ((b & 0x1) * 2 - 1);
/*  454 */           float f4 = ((b >> 1 & 0x1) * 2 - 1);
/*  455 */           float f5 = ((b >> 2 & 0x1) * 2 - 1);
/*      */           
/*  457 */           f3 *= 0.1F;
/*  458 */           f4 *= 0.1F;
/*  459 */           f5 *= 0.1F;
/*      */           
/*  461 */           MovingObjectPosition movingObjectPosition = this.field_78531_r.field_71441_e.func_72933_a(Vec3.func_72443_a(d1 + f3, d2 + f4, d3 + f5), Vec3.func_72443_a(d1 - d4 + f3 + f5, d2 - d6 + f4, d3 - d5 + f5));
/*  462 */           if (movingObjectPosition != null) {
/*  463 */             double d7 = movingObjectPosition.field_72307_f.func_72438_d(Vec3.func_72443_a(d1, d2, d3));
/*  464 */             if (d7 < d) d = d7;
/*      */           
/*      */           } 
/*      */         } 
/*  468 */         if (this.field_78531_r.field_71474_y.field_74320_O == 2) {
/*  469 */           GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
/*      */         }
/*      */         
/*  472 */         GL11.glRotatef(entityLivingBase.field_70125_A - f2, 1.0F, 0.0F, 0.0F);
/*  473 */         GL11.glRotatef(entityLivingBase.field_70177_z - f1, 0.0F, 1.0F, 0.0F);
/*  474 */         GL11.glTranslatef(0.0F, 0.0F, (float)-d);
/*  475 */         GL11.glRotatef(f1 - entityLivingBase.field_70177_z, 0.0F, 1.0F, 0.0F);
/*  476 */         GL11.glRotatef(f2 - entityLivingBase.field_70125_A, 1.0F, 0.0F, 0.0F);
/*      */       } 
/*      */     } else {
/*  479 */       GL11.glTranslatef(0.0F, 0.0F, -0.1F);
/*      */     } 
/*      */     
/*  482 */     if (!this.field_78531_r.field_71474_y.field_74325_U) {
/*  483 */       GL11.glRotatef(entityLivingBase.field_70127_C + (entityLivingBase.field_70125_A - entityLivingBase.field_70127_C) * p_78467_1_, 1.0F, 0.0F, 0.0F);
/*  484 */       GL11.glRotatef(entityLivingBase.field_70126_B + (entityLivingBase.field_70177_z - entityLivingBase.field_70126_B) * p_78467_1_ + 180.0F, 0.0F, 1.0F, 0.0F);
/*      */     } 
/*      */     
/*  487 */     GL11.glTranslatef(0.0F, f, 0.0F);
/*      */     
/*  489 */     d1 = entityLivingBase.field_70169_q + (entityLivingBase.field_70165_t - entityLivingBase.field_70169_q) * p_78467_1_;
/*  490 */     d2 = entityLivingBase.field_70167_r + (entityLivingBase.field_70163_u - entityLivingBase.field_70167_r) * p_78467_1_ - f;
/*  491 */     d3 = entityLivingBase.field_70166_s + (entityLivingBase.field_70161_v - entityLivingBase.field_70166_s) * p_78467_1_;
/*      */     
/*  493 */     this.field_78500_U = this.field_78531_r.field_71438_f.func_72721_a(d1, d2, d3, p_78467_1_);
/*      */   }
/*      */   
/*  496 */   public EntityRenderer(Minecraft p_i45076_1_, IResourceManager p_i45076_2_) { this.field_78503_V = 1.0D;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  605 */     this.field_78508_Y = Minecraft.func_71386_F();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1121 */     this.field_78537_ab = new Random();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1331 */     this.field_78521_m = GLAllocation.func_74529_h(16); this.field_78531_r = p_i45076_1_; this.field_147711_ac = p_i45076_2_; this.field_147709_v = new MapItemRenderer(p_i45076_1_.func_110434_K()); this.field_78516_c = new ItemRenderer(p_i45076_1_); this.field_78513_d = new DynamicTexture(16, 16); this.field_110922_T = p_i45076_1_.func_110434_K().func_110578_a("lightMap", this.field_78513_d); this.field_78504_Q = this.field_78513_d.func_110565_c(); this.field_147707_d = null; } private void func_78479_a(float p_78479_1_, int p_78479_2_) { this.field_78530_s = (this.field_78531_r.field_71474_y.field_151451_c * 16); GL11.glMatrixMode(5889); GL11.glLoadIdentity(); float f1 = 0.07F; if (this.field_78531_r.field_71474_y.field_74337_g) GL11.glTranslatef(-(p_78479_2_ * 2 - 1) * f1, 0.0F, 0.0F);  if (this.field_78503_V != 1.0D) { GL11.glTranslatef((float)this.field_78502_W, (float)-this.field_78509_X, 0.0F); GL11.glScaled(this.field_78503_V, this.field_78503_V, 1.0D); }  Project.gluPerspective(func_78481_a(p_78479_1_, true), this.field_78531_r.field_71443_c / this.field_78531_r.field_71440_d, 0.05F, this.field_78530_s * 2.0F); if (this.field_78531_r.field_71442_b.func_78747_a()) { float f = 0.6666667F; GL11.glScalef(1.0F, f, 1.0F); }  GL11.glMatrixMode(5888); GL11.glLoadIdentity(); if (this.field_78531_r.field_71474_y.field_74337_g) GL11.glTranslatef((p_78479_2_ * 2 - 1) * 0.1F, 0.0F, 0.0F);  func_78482_e(p_78479_1_); if (this.field_78531_r.field_71474_y.field_74336_f) func_78475_f(p_78479_1_);  float f2 = this.field_78531_r.field_71439_g.field_71080_cy + (this.field_78531_r.field_71439_g.field_71086_bY - this.field_78531_r.field_71439_g.field_71080_cy) * p_78479_1_; if (f2 > 0.0F) { byte b = 20; if (this.field_78531_r.field_71439_g.func_70644_a(Potion.field_76431_k)) b = 7;  float f = 5.0F / (f2 * f2 + 5.0F) - f2 * 0.04F; f *= f; GL11.glRotatef((this.field_78529_t + p_78479_1_) * b, 0.0F, 1.0F, 1.0F); GL11.glScalef(1.0F / f, 1.0F, 1.0F); GL11.glRotatef(-(this.field_78529_t + p_78479_1_) * b, 0.0F, 1.0F, 1.0F); }  func_78467_g(p_78479_1_); if (this.field_78532_q > 0) { int i = this.field_78532_q - 1; if (i == 1) GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);  if (i == 2) GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);  if (i == 3) GL11.glRotatef(-90.0F, 0.0F, 1.0F, 0.0F);  if (i == 4) GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);  if (i == 5) GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);  }  } private void func_78476_b(float p_78476_1_, int p_78476_2_) { if (this.field_78532_q > 0) return;  GL11.glMatrixMode(5889); GL11.glLoadIdentity(); float f = 0.07F; if (this.field_78531_r.field_71474_y.field_74337_g) GL11.glTranslatef(-(p_78476_2_ * 2 - 1) * f, 0.0F, 0.0F);  if (this.field_78503_V != 1.0D) { GL11.glTranslatef((float)this.field_78502_W, (float)-this.field_78509_X, 0.0F); GL11.glScaled(this.field_78503_V, this.field_78503_V, 1.0D); }  Project.gluPerspective(func_78481_a(p_78476_1_, false), this.field_78531_r.field_71443_c / this.field_78531_r.field_71440_d, 0.05F, this.field_78530_s * 2.0F); if (this.field_78531_r.field_71442_b.func_78747_a()) { float f1 = 0.6666667F; GL11.glScalef(1.0F, f1, 1.0F); }  GL11.glMatrixMode(5888); GL11.glLoadIdentity(); if (this.field_78531_r.field_71474_y.field_74337_g) GL11.glTranslatef((p_78476_2_ * 2 - 1) * 0.1F, 0.0F, 0.0F);  GL11.glPushMatrix(); func_78482_e(p_78476_1_); if (this.field_78531_r.field_71474_y.field_74336_f) func_78475_f(p_78476_1_);  if (this.field_78531_r.field_71474_y.field_74320_O == 0 && !this.field_78531_r.field_71451_h.func_70608_bn() && !this.field_78531_r.field_71474_y.field_74319_N && !this.field_78531_r.field_71442_b.func_78747_a()) { func_78463_b(p_78476_1_); this.field_78516_c.func_78440_a(p_78476_1_); func_78483_a(p_78476_1_); }  GL11.glPopMatrix(); if (this.field_78531_r.field_71474_y.field_74320_O == 0 && !this.field_78531_r.field_71451_h.func_70608_bn()) { this.field_78516_c.func_78447_b(p_78476_1_); func_78482_e(p_78476_1_); }  if (this.field_78531_r.field_71474_y.field_74336_f) func_78475_f(p_78476_1_);  }
/*      */   public void func_78483_a(double p_78483_1_) { OpenGlHelper.func_77473_a(OpenGlHelper.field_77476_b); GL11.glDisable(3553); OpenGlHelper.func_77473_a(OpenGlHelper.field_77478_a); }
/*      */   public void func_78463_b(double p_78463_1_) { OpenGlHelper.func_77473_a(OpenGlHelper.field_77476_b); GL11.glMatrixMode(5890); GL11.glLoadIdentity(); float f = 0.00390625F; GL11.glScalef(f, f, f); GL11.glTranslatef(8.0F, 8.0F, 8.0F); GL11.glMatrixMode(5888); this.field_78531_r.func_110434_K().func_110577_a(this.field_110922_T); GL11.glTexParameteri(3553, 10241, 9729); GL11.glTexParameteri(3553, 10240, 9729); GL11.glTexParameteri(3553, 10241, 9729); GL11.glTexParameteri(3553, 10240, 9729); GL11.glTexParameteri(3553, 10242, 10496); GL11.glTexParameteri(3553, 10243, 10496); GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F); GL11.glEnable(3553); OpenGlHelper.func_77473_a(OpenGlHelper.field_77478_a); }
/*      */   private void func_78470_f() { this.field_78511_f = (float)(this.field_78511_f + (Math.random() - Math.random()) * Math.random() * Math.random()); this.field_78524_h = (float)(this.field_78524_h + (Math.random() - Math.random()) * Math.random() * Math.random()); this.field_78511_f = (float)(this.field_78511_f * 0.9D); this.field_78524_h = (float)(this.field_78524_h * 0.9D); this.field_78514_e += (this.field_78511_f - this.field_78514_e) * 1.0F; this.field_78512_g += (this.field_78524_h - this.field_78512_g) * 1.0F; this.field_78536_aa = true; }
/*      */   private void func_78472_g(float p_78472_1_) { WorldClient worldClient = this.field_78531_r.field_71441_e; if (worldClient == null) return;  for (byte b = 0; b < 'Ā'; b++) { float f1 = worldClient.func_72971_b(1.0F) * 0.95F + 0.05F; float f2 = ((World)worldClient).field_73011_w.field_76573_f[b / 16] * f1; float f3 = ((World)worldClient).field_73011_w.field_76573_f[b % 16] * (this.field_78514_e * 0.1F + 1.5F); if (((World)worldClient).field_73016_r > 0) f2 = ((World)worldClient).field_73011_w.field_76573_f[b / 16];  float f4 = f2 * (worldClient.func_72971_b(1.0F) * 0.65F + 0.35F); float f5 = f2 * (worldClient.func_72971_b(1.0F) * 0.65F + 0.35F); float f6 = f2; float f7 = f3; float f8 = f3 * ((f3 * 0.6F + 0.4F) * 0.6F + 0.4F); float f9 = f3 * (f3 * f3 * 0.6F + 0.4F); float f10 = f4 + f7; float f11 = f5 + f8; float f12 = f6 + f9; f10 = f10 * 0.96F + 0.03F; f11 = f11 * 0.96F + 0.03F; f12 = f12 * 0.96F + 0.03F; if (this.field_82831_U > 0.0F) { float f = this.field_82832_V + (this.field_82831_U - this.field_82832_V) * p_78472_1_; f10 = f10 * (1.0F - f) + f10 * 0.7F * f; f11 = f11 * (1.0F - f) + f11 * 0.6F * f; f12 = f12 * (1.0F - f) + f12 * 0.6F * f; }  if (((World)worldClient).field_73011_w.field_76574_g == 1) { f10 = 0.22F + f7 * 0.75F; f11 = 0.28F + f8 * 0.75F; f12 = 0.25F + f9 * 0.75F; }  if (this.field_78531_r.field_71439_g.func_70644_a(Potion.field_76439_r)) { float f17 = func_82830_a((EntityPlayer)this.field_78531_r.field_71439_g, p_78472_1_); float f18 = 1.0F / f10; if (f18 > 1.0F / f11) f18 = 1.0F / f11;  if (f18 > 1.0F / f12) f18 = 1.0F / f12;  f10 = f10 * (1.0F - f17) + f10 * f18 * f17; f11 = f11 * (1.0F - f17) + f11 * f18 * f17; f12 = f12 * (1.0F - f17) + f12 * f18 * f17; }  if (f10 > 1.0F) f10 = 1.0F;  if (f11 > 1.0F) f11 = 1.0F;  if (f12 > 1.0F) f12 = 1.0F;  float f13 = this.field_78531_r.field_71474_y.field_74333_Y; float f14 = 1.0F - f10; float f15 = 1.0F - f11; float f16 = 1.0F - f12; f14 = 1.0F - f14 * f14 * f14 * f14; f15 = 1.0F - f15 * f15 * f15 * f15; f16 = 1.0F - f16 * f16 * f16 * f16; f10 = f10 * (1.0F - f13) + f14 * f13; f11 = f11 * (1.0F - f13) + f15 * f13; f12 = f12 * (1.0F - f13) + f16 * f13; f10 = f10 * 0.96F + 0.03F; f11 = f11 * 0.96F + 0.03F; f12 = f12 * 0.96F + 0.03F; if (f10 > 1.0F) f10 = 1.0F;  if (f11 > 1.0F) f11 = 1.0F;  if (f12 > 1.0F) f12 = 1.0F;  if (f10 < 0.0F) f10 = 0.0F;  if (f11 < 0.0F) f11 = 0.0F;  if (f12 < 0.0F) f12 = 0.0F;  char c = 'ÿ'; int i = (int)(f10 * 255.0F); int j = (int)(f11 * 255.0F); int k = (int)(f12 * 255.0F); this.field_78504_Q[b] = c << 24 | i << 16 | j << 8 | k; }  this.field_78513_d.func_110564_a(); this.field_78536_aa = false; }
/*      */   private float func_82830_a(EntityPlayer p_82830_1_, float p_82830_2_) { int i = p_82830_1_.func_70660_b(Potion.field_76439_r).func_76459_b(); if (i > 200) return 1.0F;  return 0.7F + MathHelper.func_76126_a((i - p_82830_2_) * 3.1415927F * 0.2F) * 0.3F; }
/* 1337 */   private void func_78466_h(float p_78466_1_) { WorldClient worldClient = this.field_78531_r.field_71441_e;
/* 1338 */     EntityLivingBase entityLivingBase = this.field_78531_r.field_71451_h;
/*      */     
/* 1340 */     float f1 = 0.25F + 0.75F * this.field_78531_r.field_71474_y.field_151451_c / 16.0F;
/* 1341 */     f1 = 1.0F - (float)Math.pow(f1, 0.25D);
/*      */     
/* 1343 */     Vec3 vec31 = worldClient.func_72833_a((Entity)this.field_78531_r.field_71451_h, p_78466_1_);
/* 1344 */     float f2 = (float)vec31.field_72450_a;
/* 1345 */     float f3 = (float)vec31.field_72448_b;
/* 1346 */     float f4 = (float)vec31.field_72449_c;
/*      */     
/* 1348 */     Vec3 vec32 = worldClient.func_72948_g(p_78466_1_);
/* 1349 */     this.field_78518_n = (float)vec32.field_72450_a;
/* 1350 */     this.field_78519_o = (float)vec32.field_72448_b;
/* 1351 */     this.field_78533_p = (float)vec32.field_72449_c;
/*      */     
/* 1353 */     if (this.field_78531_r.field_71474_y.field_151451_c >= 4) {
/* 1354 */       Vec3 vec3 = (MathHelper.func_76126_a(worldClient.func_72929_e(p_78466_1_)) > 0.0F) ? Vec3.func_72443_a(-1.0D, 0.0D, 0.0D) : Vec3.func_72443_a(1.0D, 0.0D, 0.0D);
/* 1355 */       float f = (float)entityLivingBase.func_70676_i(p_78466_1_).func_72430_b(vec3);
/* 1356 */       if (f < 0.0F) f = 0.0F; 
/* 1357 */       if (f > 0.0F) {
/* 1358 */         float[] arrayOfFloat = ((World)worldClient).field_73011_w.func_76560_a(worldClient.func_72826_c(p_78466_1_), p_78466_1_);
/* 1359 */         if (arrayOfFloat != null) {
/* 1360 */           f *= arrayOfFloat[3];
/* 1361 */           this.field_78518_n = this.field_78518_n * (1.0F - f) + arrayOfFloat[0] * f;
/* 1362 */           this.field_78519_o = this.field_78519_o * (1.0F - f) + arrayOfFloat[1] * f;
/* 1363 */           this.field_78533_p = this.field_78533_p * (1.0F - f) + arrayOfFloat[2] * f;
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/* 1368 */     this.field_78518_n += (f2 - this.field_78518_n) * f1;
/* 1369 */     this.field_78519_o += (f3 - this.field_78519_o) * f1;
/* 1370 */     this.field_78533_p += (f4 - this.field_78533_p) * f1;
/*      */     
/* 1372 */     float f5 = worldClient.func_72867_j(p_78466_1_);
/* 1373 */     if (f5 > 0.0F) {
/* 1374 */       float f8 = 1.0F - f5 * 0.5F;
/* 1375 */       float f9 = 1.0F - f5 * 0.4F;
/* 1376 */       this.field_78518_n *= f8;
/* 1377 */       this.field_78519_o *= f8;
/* 1378 */       this.field_78533_p *= f9;
/*      */     } 
/* 1380 */     float f6 = worldClient.func_72819_i(p_78466_1_);
/* 1381 */     if (f6 > 0.0F) {
/* 1382 */       float f = 1.0F - f6 * 0.5F;
/* 1383 */       this.field_78518_n *= f;
/* 1384 */       this.field_78519_o *= f;
/* 1385 */       this.field_78533_p *= f;
/*      */     } 
/*      */     
/* 1388 */     Block block = ActiveRenderInfo.func_151460_a((World)this.field_78531_r.field_71441_e, entityLivingBase, p_78466_1_);
/* 1389 */     if (this.field_78500_U) {
/* 1390 */       Vec3 vec3 = worldClient.func_72824_f(p_78466_1_);
/* 1391 */       this.field_78518_n = (float)vec3.field_72450_a;
/* 1392 */       this.field_78519_o = (float)vec3.field_72448_b;
/* 1393 */       this.field_78533_p = (float)vec3.field_72449_c;
/* 1394 */     } else if (block.func_149688_o() == Material.field_151586_h) {
/* 1395 */       float f = EnchantmentHelper.func_77501_a(entityLivingBase) * 0.2F;
/*      */       
/* 1397 */       this.field_78518_n = 0.02F + f;
/* 1398 */       this.field_78519_o = 0.02F + f;
/* 1399 */       this.field_78533_p = 0.2F + f;
/* 1400 */     } else if (block.func_149688_o() == Material.field_151587_i) {
/* 1401 */       this.field_78518_n = 0.6F;
/* 1402 */       this.field_78519_o = 0.1F;
/* 1403 */       this.field_78533_p = 0.0F;
/*      */     } 
/*      */     
/* 1406 */     float f7 = this.field_78535_ad + (this.field_78539_ae - this.field_78535_ad) * p_78466_1_;
/* 1407 */     this.field_78518_n *= f7;
/* 1408 */     this.field_78519_o *= f7;
/* 1409 */     this.field_78533_p *= f7;
/*      */     
/* 1411 */     double d = (entityLivingBase.field_70137_T + (entityLivingBase.field_70163_u - entityLivingBase.field_70137_T) * p_78466_1_) * ((World)worldClient).field_73011_w.func_76565_k();
/* 1412 */     if (entityLivingBase.func_70644_a(Potion.field_76440_q)) {
/* 1413 */       int i = entityLivingBase.func_70660_b(Potion.field_76440_q).func_76459_b();
/* 1414 */       if (i < 20) {
/* 1415 */         d *= (1.0F - i / 20.0F);
/*      */       } else {
/* 1417 */         d = 0.0D;
/*      */       } 
/*      */     } 
/* 1420 */     if (d < 1.0D) {
/* 1421 */       if (d < 0.0D) d = 0.0D; 
/* 1422 */       d *= d;
/* 1423 */       this.field_78518_n = (float)(this.field_78518_n * d);
/* 1424 */       this.field_78519_o = (float)(this.field_78519_o * d);
/* 1425 */       this.field_78533_p = (float)(this.field_78533_p * d);
/*      */     } 
/*      */     
/* 1428 */     if (this.field_82831_U > 0.0F) {
/* 1429 */       float f = this.field_82832_V + (this.field_82831_U - this.field_82832_V) * p_78466_1_;
/* 1430 */       this.field_78518_n = this.field_78518_n * (1.0F - f) + this.field_78518_n * 0.7F * f;
/* 1431 */       this.field_78519_o = this.field_78519_o * (1.0F - f) + this.field_78519_o * 0.6F * f;
/* 1432 */       this.field_78533_p = this.field_78533_p * (1.0F - f) + this.field_78533_p * 0.6F * f;
/*      */     } 
/*      */     
/* 1435 */     if (entityLivingBase.func_70644_a(Potion.field_76439_r)) {
/* 1436 */       float f8 = func_82830_a((EntityPlayer)this.field_78531_r.field_71439_g, p_78466_1_);
/*      */       
/* 1438 */       float f9 = 1.0F / this.field_78518_n;
/* 1439 */       if (f9 > 1.0F / this.field_78519_o) {
/* 1440 */         f9 = 1.0F / this.field_78519_o;
/*      */       }
/* 1442 */       if (f9 > 1.0F / this.field_78533_p) {
/* 1443 */         f9 = 1.0F / this.field_78533_p;
/*      */       }
/* 1445 */       this.field_78518_n = this.field_78518_n * (1.0F - f8) + this.field_78518_n * f9 * f8;
/* 1446 */       this.field_78519_o = this.field_78519_o * (1.0F - f8) + this.field_78519_o * f9 * f8;
/* 1447 */       this.field_78533_p = this.field_78533_p * (1.0F - f8) + this.field_78533_p * f9 * f8;
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 1452 */     if (this.field_78531_r.field_71474_y.field_74337_g) {
/* 1453 */       float f8 = (this.field_78518_n * 30.0F + this.field_78519_o * 59.0F + this.field_78533_p * 11.0F) / 100.0F;
/* 1454 */       float f9 = (this.field_78518_n * 30.0F + this.field_78519_o * 70.0F) / 100.0F;
/* 1455 */       float f10 = (this.field_78518_n * 30.0F + this.field_78533_p * 70.0F) / 100.0F;
/*      */       
/* 1457 */       this.field_78518_n = f8;
/* 1458 */       this.field_78519_o = f9;
/* 1459 */       this.field_78533_p = f10;
/*      */     } 
/*      */     
/* 1462 */     GL11.glClearColor(this.field_78518_n, this.field_78519_o, this.field_78533_p, 0.0F); } public void func_78480_b(float p_78480_1_) { this.field_78531_r.field_71424_I.func_76320_a("lightTex"); if (this.field_78536_aa) func_78472_g(p_78480_1_);  this.field_78531_r.field_71424_I.func_76319_b(); boolean bool = Display.isActive(); if (bool || !this.field_78531_r.field_71474_y.field_82881_y || (this.field_78531_r.field_71474_y.field_85185_A && Mouse.isButtonDown(1))) { this.field_78508_Y = Minecraft.func_71386_F(); } else if (Minecraft.func_71386_F() - this.field_78508_Y > 500L) { this.field_78531_r.func_71385_j(); }  this.field_78531_r.field_71424_I.func_76320_a("mouse"); if (this.field_78531_r.field_71415_G && bool) { this.field_78531_r.field_71417_B.func_74374_c(); float f1 = this.field_78531_r.field_71474_y.field_74341_c * 0.6F + 0.2F; float f2 = f1 * f1 * f1 * 8.0F; float f3 = this.field_78531_r.field_71417_B.field_74377_a * f2; float f4 = this.field_78531_r.field_71417_B.field_74375_b * f2; byte b = 1; if (this.field_78531_r.field_71474_y.field_74338_d) b = -1;  if (this.field_78531_r.field_71474_y.field_74326_T) { this.field_78496_H += f3; this.field_78497_I += f4; float f = p_78480_1_ - this.field_78492_L; this.field_78492_L = p_78480_1_; f3 = this.field_78498_J * f; f4 = this.field_78499_K * f; this.field_78531_r.field_71439_g.func_70082_c(f3, f4 * b); } else { this.field_78531_r.field_71439_g.func_70082_c(f3, f4 * b); }  }  this.field_78531_r.field_71424_I.func_76319_b(); if (this.field_78531_r.field_71454_w) return;  field_78517_a = this.field_78531_r.field_71474_y.field_74337_g; ScaledResolution scaledResolution = new ScaledResolution(this.field_78531_r, this.field_78531_r.field_71443_c, this.field_78531_r.field_71440_d); int i = scaledResolution.func_78326_a(); int j = scaledResolution.func_78328_b(); int k = Mouse.getX() * i / this.field_78531_r.field_71443_c; int m = j - Mouse.getY() * j / this.field_78531_r.field_71440_d - 1; int n = this.field_78531_r.field_71474_y.field_74350_i; if (this.field_78531_r.field_71441_e != null) { this.field_78531_r.field_71424_I.func_76320_a("level"); if (this.field_78531_r.func_147107_h()) { func_78471_a(p_78480_1_, this.field_78510_Z + (1000000000 / n)); } else { func_78471_a(p_78480_1_, 0L); }  if (OpenGlHelper.field_148824_g) { if (this.field_147707_d != null) { GL11.glMatrixMode(5890); GL11.glPushMatrix(); GL11.glLoadIdentity(); this.field_147707_d.func_148018_a(p_78480_1_); GL11.glPopMatrix(); }  this.field_78531_r.func_147110_a().func_147610_a(true); }  this.field_78510_Z = System.nanoTime(); this.field_78531_r.field_71424_I.func_76318_c("gui"); if (!this.field_78531_r.field_71474_y.field_74319_N || this.field_78531_r.field_71462_r != null) { GL11.glAlphaFunc(516, 0.1F); this.field_78531_r.field_71456_v.func_73830_a(p_78480_1_, (this.field_78531_r.field_71462_r != null), k, m); }  this.field_78531_r.field_71424_I.func_76319_b(); } else { GL11.glViewport(0, 0, this.field_78531_r.field_71443_c, this.field_78531_r.field_71440_d); GL11.glMatrixMode(5889); GL11.glLoadIdentity(); GL11.glMatrixMode(5888); GL11.glLoadIdentity(); func_78478_c(); this.field_78510_Z = System.nanoTime(); }  if (this.field_78531_r.field_71462_r != null) { GL11.glClear(256); try { this.field_78531_r.field_71462_r.func_73863_a(k, m, p_78480_1_); } catch (Throwable throwable) { CrashReport crashReport = CrashReport.func_85055_a(throwable, "Rendering screen"); CrashReportCategory crashReportCategory = crashReport.func_85058_a("Screen render details"); crashReportCategory.func_71500_a("Screen name", new Callable(this) {
/*      */               private static final String __OBFID = "CL_00000948"; public String call() { return this.field_90032_a.field_78531_r.field_71462_r.getClass().getCanonicalName(); }
/*      */             }); crashReportCategory.func_71500_a("Mouse location", new Callable(this, k, m) {
/*      */               private static final String __OBFID = "CL_00000950"; public String call() { return String.format("Scaled: (%d, %d). Absolute: (%d, %d)", new Object[] { Integer.valueOf(this.field_90026_a), Integer.valueOf(this.field_90024_b), Integer.valueOf(Mouse.getX()), Integer.valueOf(Mouse.getY()) }); }
/*      */             }); crashReportCategory.func_71500_a("Screen size", new Callable(this, scaledResolution) {
/*      */               private static final String __OBFID = "CL_00000951"; public String call() { return String.format("Scaled: (%d, %d). Absolute: (%d, %d). Scale factor of %d", new Object[] { Integer.valueOf(this.field_90029_a.func_78326_a()), Integer.valueOf(this.field_90029_a.func_78328_b()), Integer.valueOf((EntityRenderer.access$000(this.field_90028_b)).field_71443_c), Integer.valueOf((EntityRenderer.access$000(this.field_90028_b)).field_71440_d), Integer.valueOf(this.field_90029_a.func_78325_e()) }); }
/*      */             }); throw new ReportedException(crashReport); }  }  } public void func_152430_c(float p_152430_1_) { func_78478_c(); ScaledResolution scaledResolution = new ScaledResolution(this.field_78531_r, this.field_78531_r.field_71443_c, this.field_78531_r.field_71440_d); int i = scaledResolution.func_78326_a(); int j = scaledResolution.func_78328_b(); this.field_78531_r.field_71456_v.func_152126_a(i, j); } public void func_78471_a(float p_78471_1_, long p_78471_2_) { this.field_78531_r.field_71424_I.func_76320_a("lightTex"); if (this.field_78536_aa) func_78472_g(p_78471_1_);  GL11.glEnable(2884); GL11.glEnable(2929); GL11.glEnable(3008); GL11.glAlphaFunc(516, 0.5F); if (this.field_78531_r.field_71451_h == null) this.field_78531_r.field_71451_h = (EntityLivingBase)this.field_78531_r.field_71439_g;  this.field_78531_r.field_71424_I.func_76318_c("pick"); func_78473_a(p_78471_1_); EntityLivingBase entityLivingBase = this.field_78531_r.field_71451_h; RenderGlobal renderGlobal = this.field_78531_r.field_71438_f; EffectRenderer effectRenderer = this.field_78531_r.field_71452_i; double d1 = entityLivingBase.field_70142_S + (entityLivingBase.field_70165_t - entityLivingBase.field_70142_S) * p_78471_1_; double d2 = entityLivingBase.field_70137_T + (entityLivingBase.field_70163_u - entityLivingBase.field_70137_T) * p_78471_1_; double d3 = entityLivingBase.field_70136_U + (entityLivingBase.field_70161_v - entityLivingBase.field_70136_U) * p_78471_1_; this.field_78531_r.field_71424_I.func_76318_c("center"); for (byte b = 0; b < 2; b++) { if (this.field_78531_r.field_71474_y.field_74337_g) { field_78515_b = b; if (field_78515_b == 0) { GL11.glColorMask(false, true, true, false); } else { GL11.glColorMask(true, false, false, false); }  }  this.field_78531_r.field_71424_I.func_76318_c("clear"); GL11.glViewport(0, 0, this.field_78531_r.field_71443_c, this.field_78531_r.field_71440_d); func_78466_h(p_78471_1_); GL11.glClear(16640); GL11.glEnable(2884); this.field_78531_r.field_71424_I.func_76318_c("camera"); func_78479_a(p_78471_1_, b); ActiveRenderInfo.func_74583_a((EntityPlayer)this.field_78531_r.field_71439_g, (this.field_78531_r.field_71474_y.field_74320_O == 2)); this.field_78531_r.field_71424_I.func_76318_c("frustrum"); ClippingHelperImpl.func_78558_a(); if (this.field_78531_r.field_71474_y.field_151451_c >= 4) { func_78468_a(-1, p_78471_1_); this.field_78531_r.field_71424_I.func_76318_c("sky"); renderGlobal.func_72714_a(p_78471_1_); }  GL11.glEnable(2912); func_78468_a(1, p_78471_1_); if (this.field_78531_r.field_71474_y.field_74348_k != 0) GL11.glShadeModel(7425);  this.field_78531_r.field_71424_I.func_76318_c("culling"); Frustrum frustrum = new Frustrum(); frustrum.func_78547_a(d1, d2, d3); this.field_78531_r.field_71438_f.func_72729_a((ICamera)frustrum, p_78471_1_); if (b == 0) { this.field_78531_r.field_71424_I.func_76318_c("updatechunks"); while (!this.field_78531_r.field_71438_f.func_72716_a(entityLivingBase, false)) { if (p_78471_2_ == 0L) break;  long l = p_78471_2_ - System.nanoTime(); if (l < 0L || l > 1000000000L) break;  }  }  if (entityLivingBase.field_70163_u < 128.0D) func_82829_a(renderGlobal, p_78471_1_);  this.field_78531_r.field_71424_I.func_76318_c("prepareterrain"); func_78468_a(0, p_78471_1_); GL11.glEnable(2912); this.field_78531_r.func_110434_K().func_110577_a(TextureMap.field_110575_b); RenderHelper.func_74518_a(); this.field_78531_r.field_71424_I.func_76318_c("terrain"); GL11.glMatrixMode(5888); GL11.glPushMatrix(); renderGlobal.func_72719_a(entityLivingBase, 0, p_78471_1_); GL11.glShadeModel(7424); GL11.glAlphaFunc(516, 0.1F); if (this.field_78532_q == 0) { GL11.glMatrixMode(5888); GL11.glPopMatrix(); GL11.glPushMatrix(); RenderHelper.func_74519_b(); this.field_78531_r.field_71424_I.func_76318_c("entities"); renderGlobal.func_147589_a(entityLivingBase, (ICamera)frustrum, p_78471_1_); RenderHelper.func_74518_a(); func_78483_a(p_78471_1_); GL11.glMatrixMode(5888); GL11.glPopMatrix(); GL11.glPushMatrix(); if (this.field_78531_r.field_71476_x != null && entityLivingBase.func_70055_a(Material.field_151586_h) && entityLivingBase instanceof EntityPlayer && !this.field_78531_r.field_71474_y.field_74319_N) { EntityPlayer entityPlayer = (EntityPlayer)entityLivingBase; GL11.glDisable(3008); this.field_78531_r.field_71424_I.func_76318_c("outline"); renderGlobal.func_72731_b(entityPlayer, this.field_78531_r.field_71476_x, 0, p_78471_1_); GL11.glEnable(3008); }  }  GL11.glMatrixMode(5888); GL11.glPopMatrix(); if (this.field_78503_V == 1.0D && entityLivingBase instanceof EntityPlayer && !this.field_78531_r.field_71474_y.field_74319_N && this.field_78531_r.field_71476_x != null && !entityLivingBase.func_70055_a(Material.field_151586_h)) { EntityPlayer entityPlayer = (EntityPlayer)entityLivingBase; GL11.glDisable(3008); this.field_78531_r.field_71424_I.func_76318_c("outline"); renderGlobal.func_72731_b(entityPlayer, this.field_78531_r.field_71476_x, 0, p_78471_1_); GL11.glEnable(3008); }  this.field_78531_r.field_71424_I.func_76318_c("destroyProgress"); GL11.glEnable(3042); OpenGlHelper.func_148821_a(770, 1, 1, 0); renderGlobal.func_72717_a(Tessellator.field_78398_a, (EntityPlayer)entityLivingBase, p_78471_1_); GL11.glDisable(3042); if (this.field_78532_q == 0) { func_78463_b(p_78471_1_); this.field_78531_r.field_71424_I.func_76318_c("litParticles"); effectRenderer.func_78872_b((Entity)entityLivingBase, p_78471_1_); RenderHelper.func_74518_a(); func_78468_a(0, p_78471_1_); this.field_78531_r.field_71424_I.func_76318_c("particles"); effectRenderer.func_78874_a((Entity)entityLivingBase, p_78471_1_); func_78483_a(p_78471_1_); }  GL11.glDepthMask(false); GL11.glEnable(2884); this.field_78531_r.field_71424_I.func_76318_c("weather"); func_78474_d(p_78471_1_); GL11.glDepthMask(true); GL11.glDisable(3042); GL11.glEnable(2884); OpenGlHelper.func_148821_a(770, 771, 1, 0); GL11.glAlphaFunc(516, 0.1F); func_78468_a(0, p_78471_1_); GL11.glEnable(3042); GL11.glDepthMask(false); this.field_78531_r.func_110434_K().func_110577_a(TextureMap.field_110575_b); if (this.field_78531_r.field_71474_y.field_74347_j) { this.field_78531_r.field_71424_I.func_76318_c("water"); if (this.field_78531_r.field_71474_y.field_74348_k != 0)
/* 1469 */           GL11.glShadeModel(7425);  GL11.glEnable(3042); OpenGlHelper.func_148821_a(770, 771, 1, 0); if (this.field_78531_r.field_71474_y.field_74337_g) { if (field_78515_b == 0) { GL11.glColorMask(false, true, true, true); } else { GL11.glColorMask(true, false, false, true); }  renderGlobal.func_72719_a(entityLivingBase, 1, p_78471_1_); } else { renderGlobal.func_72719_a(entityLivingBase, 1, p_78471_1_); }  GL11.glDisable(3042); GL11.glShadeModel(7424); } else { this.field_78531_r.field_71424_I.func_76318_c("water"); renderGlobal.func_72719_a(entityLivingBase, 1, p_78471_1_); }  GL11.glDepthMask(true); GL11.glEnable(2884); GL11.glDisable(3042); GL11.glDisable(2912); if (entityLivingBase.field_70163_u >= 128.0D) { this.field_78531_r.field_71424_I.func_76318_c("aboveClouds"); func_82829_a(renderGlobal, p_78471_1_); }  this.field_78531_r.field_71424_I.func_76318_c("hand"); if (this.field_78503_V == 1.0D) { GL11.glClear(256); func_78476_b(p_78471_1_, b); }  if (!this.field_78531_r.field_71474_y.field_74337_g) { this.field_78531_r.field_71424_I.func_76319_b(); return; }  }  GL11.glColorMask(true, true, true, false); this.field_78531_r.field_71424_I.func_76319_b(); } private void func_78468_a(int p_78468_1_, float p_78468_2_) { EntityLivingBase entityLivingBase = this.field_78531_r.field_71451_h;
/*      */     
/* 1471 */     boolean bool = false;
/* 1472 */     if (entityLivingBase instanceof EntityPlayer) {
/* 1473 */       bool = ((EntityPlayer)entityLivingBase).field_71075_bZ.field_75098_d;
/*      */     }
/*      */     
/* 1476 */     if (p_78468_1_ == 999) {
/* 1477 */       GL11.glFog(2918, func_78469_a(0.0F, 0.0F, 0.0F, 1.0F));
/* 1478 */       GL11.glFogi(2917, 9729);
/* 1479 */       GL11.glFogf(2915, 0.0F);
/* 1480 */       GL11.glFogf(2916, 8.0F);
/*      */       
/* 1482 */       if ((GLContext.getCapabilities()).GL_NV_fog_distance) {
/* 1483 */         GL11.glFogi(34138, 34139);
/*      */       }
/*      */       
/* 1486 */       GL11.glFogf(2915, 0.0F);
/*      */       
/*      */       return;
/*      */     } 
/* 1490 */     GL11.glFog(2918, func_78469_a(this.field_78518_n, this.field_78519_o, this.field_78533_p, 1.0F));
/* 1491 */     GL11.glNormal3f(0.0F, -1.0F, 0.0F);
/* 1492 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*      */     
/* 1494 */     Block block = ActiveRenderInfo.func_151460_a((World)this.field_78531_r.field_71441_e, entityLivingBase, p_78468_2_);
/*      */     
/* 1496 */     if (entityLivingBase.func_70644_a(Potion.field_76440_q)) {
/* 1497 */       float f = 5.0F;
/* 1498 */       int i = entityLivingBase.func_70660_b(Potion.field_76440_q).func_76459_b();
/* 1499 */       if (i < 20) {
/* 1500 */         f = 5.0F + (this.field_78530_s - 5.0F) * (1.0F - i / 20.0F);
/*      */       }
/*      */       
/* 1503 */       GL11.glFogi(2917, 9729);
/* 1504 */       if (p_78468_1_ < 0) {
/* 1505 */         GL11.glFogf(2915, 0.0F);
/* 1506 */         GL11.glFogf(2916, f * 0.8F);
/*      */       } else {
/* 1508 */         GL11.glFogf(2915, f * 0.25F);
/* 1509 */         GL11.glFogf(2916, f);
/*      */       } 
/* 1511 */       if ((GLContext.getCapabilities()).GL_NV_fog_distance) {
/* 1512 */         GL11.glFogi(34138, 34139);
/*      */       }
/* 1514 */     } else if (this.field_78500_U) {
/* 1515 */       GL11.glFogi(2917, 2048);
/* 1516 */       GL11.glFogf(2914, 0.1F);
/* 1517 */     } else if (block.func_149688_o() == Material.field_151586_h) {
/* 1518 */       GL11.glFogi(2917, 2048);
/* 1519 */       if (entityLivingBase.func_70644_a(Potion.field_76427_o)) {
/* 1520 */         GL11.glFogf(2914, 0.05F);
/*      */       } else {
/* 1522 */         GL11.glFogf(2914, 0.1F - EnchantmentHelper.func_77501_a(entityLivingBase) * 0.03F);
/*      */       } 
/* 1524 */     } else if (block.func_149688_o() == Material.field_151587_i) {
/* 1525 */       GL11.glFogi(2917, 2048);
/* 1526 */       GL11.glFogf(2914, 2.0F);
/*      */     } else {
/* 1528 */       float f = this.field_78530_s;
/* 1529 */       if (this.field_78531_r.field_71441_e.field_73011_w.func_76564_j() && !bool) {
/* 1530 */         double d = ((entityLivingBase.func_70070_b(p_78468_2_) & 0xF00000) >> 20) / 16.0D + (entityLivingBase.field_70137_T + (entityLivingBase.field_70163_u - entityLivingBase.field_70137_T) * p_78468_2_ + 4.0D) / 32.0D;
/* 1531 */         if (d < 1.0D) {
/* 1532 */           if (d < 0.0D) d = 0.0D; 
/* 1533 */           d *= d;
/* 1534 */           float f1 = 100.0F * (float)d;
/* 1535 */           if (f1 < 5.0F) f1 = 5.0F; 
/* 1536 */           if (f > f1) f = f1;
/*      */         
/*      */         } 
/*      */       } 
/* 1540 */       GL11.glFogi(2917, 9729);
/* 1541 */       if (p_78468_1_ < 0) {
/* 1542 */         GL11.glFogf(2915, 0.0F);
/* 1543 */         GL11.glFogf(2916, f);
/*      */       } else {
/* 1545 */         GL11.glFogf(2915, f * 0.75F);
/* 1546 */         GL11.glFogf(2916, f);
/*      */       } 
/* 1548 */       if ((GLContext.getCapabilities()).GL_NV_fog_distance) {
/* 1549 */         GL11.glFogi(34138, 34139);
/*      */       }
/*      */       
/* 1552 */       if (this.field_78531_r.field_71441_e.field_73011_w.func_76568_b((int)entityLivingBase.field_70165_t, (int)entityLivingBase.field_70161_v)) {
/* 1553 */         GL11.glFogf(2915, f * 0.05F);
/* 1554 */         GL11.glFogf(2916, Math.min(f, 192.0F) * 0.5F);
/*      */       } 
/*      */     } 
/*      */     
/* 1558 */     GL11.glEnable(2903);
/* 1559 */     GL11.glColorMaterial(1028, 4608); }
/*      */   private void func_82829_a(RenderGlobal p_82829_1_, float p_82829_2_) { if (this.field_78531_r.field_71474_y.func_74309_c()) { this.field_78531_r.field_71424_I.func_76318_c("clouds"); GL11.glPushMatrix(); func_78468_a(0, p_82829_2_); GL11.glEnable(2912); p_82829_1_.func_72718_b(p_82829_2_); GL11.glDisable(2912); func_78468_a(1, p_82829_2_); GL11.glPopMatrix(); }  }
/*      */   private void func_78484_h() { float f = this.field_78531_r.field_71441_e.func_72867_j(1.0F); if (!this.field_78531_r.field_71474_y.field_74347_j) f /= 2.0F;  if (f == 0.0F) return;  this.field_78537_ab.setSeed(this.field_78529_t * 312987231L); EntityLivingBase entityLivingBase = this.field_78531_r.field_71451_h; WorldClient worldClient = this.field_78531_r.field_71441_e; int i = MathHelper.func_76128_c(entityLivingBase.field_70165_t); int j = MathHelper.func_76128_c(entityLivingBase.field_70163_u); int k = MathHelper.func_76128_c(entityLivingBase.field_70161_v); byte b1 = 10; double d1 = 0.0D; double d2 = 0.0D; double d3 = 0.0D; byte b2 = 0; int m = (int)(100.0F * f * f); if (this.field_78531_r.field_71474_y.field_74362_aa == 1) { m >>= 1; } else if (this.field_78531_r.field_71474_y.field_74362_aa == 2) { m = 0; }  for (byte b3 = 0; b3 < m; b3++) { int n = i + this.field_78537_ab.nextInt(b1) - this.field_78537_ab.nextInt(b1); int i1 = k + this.field_78537_ab.nextInt(b1) - this.field_78537_ab.nextInt(b1); int i2 = worldClient.func_72874_g(n, i1); Block block = worldClient.func_147439_a(n, i2 - 1, i1); BiomeGenBase biomeGenBase = worldClient.func_72807_a(n, i1); if (i2 <= j + b1 && i2 >= j - b1 && biomeGenBase.func_76738_d() && biomeGenBase.func_150564_a(n, i2, i1) >= 0.15F) { float f1 = this.field_78537_ab.nextFloat(); float f2 = this.field_78537_ab.nextFloat(); if (block.func_149688_o() == Material.field_151587_i) { this.field_78531_r.field_71452_i.func_78873_a((EntityFX)new EntitySmokeFX((World)worldClient, (n + f1), (i2 + 0.1F) - block.func_149665_z(), (i1 + f2), 0.0D, 0.0D, 0.0D)); } else if (block.func_149688_o() != Material.field_151579_a) { if (this.field_78537_ab.nextInt(++b2) == 0) { d1 = (n + f1); d2 = (i2 + 0.1F) - block.func_149665_z(); d3 = (i1 + f2); }  this.field_78531_r.field_71452_i.func_78873_a((EntityFX)new EntityRainFX((World)worldClient, (n + f1), (i2 + 0.1F) - block.func_149665_z(), (i1 + f2))); }  }  }  if (b2 > 0 && this.field_78537_ab.nextInt(3) < this.field_78534_ac++) { this.field_78534_ac = 0; if (d2 > entityLivingBase.field_70163_u + 1.0D && worldClient.func_72874_g(MathHelper.func_76128_c(entityLivingBase.field_70165_t), MathHelper.func_76128_c(entityLivingBase.field_70161_v)) > MathHelper.func_76128_c(entityLivingBase.field_70163_u)) { this.field_78531_r.field_71441_e.func_72980_b(d1, d2, d3, "ambient.weather.rain", 0.1F, 0.5F, false); } else { this.field_78531_r.field_71441_e.func_72980_b(d1, d2, d3, "ambient.weather.rain", 0.2F, 1.0F, false); }  }  }
/*      */   protected void func_78474_d(float p_78474_1_) { float f1 = this.field_78531_r.field_71441_e.func_72867_j(p_78474_1_); if (f1 <= 0.0F) return;  func_78463_b(p_78474_1_); if (this.field_78525_i == null) { this.field_78525_i = new float[1024]; this.field_78522_j = new float[1024]; for (byte b2 = 0; b2 < 32; b2++) { for (byte b3 = 0; b3 < 32; b3++) { float f3 = (b3 - 16); float f4 = (b2 - 16); float f5 = MathHelper.func_76129_c(f3 * f3 + f4 * f4); this.field_78525_i[b2 << 5 | b3] = -f4 / f5; this.field_78522_j[b2 << 5 | b3] = f3 / f5; }  }  }  EntityLivingBase entityLivingBase = this.field_78531_r.field_71451_h; WorldClient worldClient = this.field_78531_r.field_71441_e; int i = MathHelper.func_76128_c(entityLivingBase.field_70165_t); int j = MathHelper.func_76128_c(entityLivingBase.field_70163_u); int k = MathHelper.func_76128_c(entityLivingBase.field_70161_v); Tessellator tessellator = Tessellator.field_78398_a; GL11.glDisable(2884); GL11.glNormal3f(0.0F, 1.0F, 0.0F); GL11.glEnable(3042); OpenGlHelper.func_148821_a(770, 771, 1, 0); GL11.glAlphaFunc(516, 0.1F); double d1 = entityLivingBase.field_70142_S + (entityLivingBase.field_70165_t - entityLivingBase.field_70142_S) * p_78474_1_; double d2 = entityLivingBase.field_70137_T + (entityLivingBase.field_70163_u - entityLivingBase.field_70137_T) * p_78474_1_; double d3 = entityLivingBase.field_70136_U + (entityLivingBase.field_70161_v - entityLivingBase.field_70136_U) * p_78474_1_; int m = MathHelper.func_76128_c(d2); byte b = 5; if (this.field_78531_r.field_71474_y.field_74347_j) b = 10;  boolean bool = false; byte b1 = -1; float f2 = this.field_78529_t + p_78474_1_; if (this.field_78531_r.field_71474_y.field_74347_j) b = 10;  GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F); bool = false; for (int n = k - b; n <= k + b; n++) { for (int i1 = i - b; i1 <= i + b; i1++) { int i2 = (n - k + 16) * 32 + i1 - i + 16; float f3 = this.field_78525_i[i2] * 0.5F; float f4 = this.field_78522_j[i2] * 0.5F; BiomeGenBase biomeGenBase = worldClient.func_72807_a(i1, n); if (biomeGenBase.func_76738_d() || biomeGenBase.func_76746_c()) { int i3 = worldClient.func_72874_g(i1, n); int i4 = j - b; int i5 = j + b; if (i4 < i3) i4 = i3;  if (i5 < i3) i5 = i3;  float f = 1.0F; int i6 = i3; if (i6 < m) i6 = m;  if (i4 != i5) { this.field_78537_ab.setSeed((i1 * i1 * 3121 + i1 * 45238971 ^ n * n * 418711 + n * 13761)); float f5 = biomeGenBase.func_150564_a(i1, i4, n); if (worldClient.func_72959_q().func_76939_a(f5, i3) >= 0.15F) { if (b1 != 0) { if (b1 >= 0) tessellator.func_78381_a();  b1 = 0; this.field_78531_r.func_110434_K().func_110577_a(field_110924_q); tessellator.func_78382_b(); }  float f6 = ((this.field_78529_t + i1 * i1 * 3121 + i1 * 45238971 + n * n * 418711 + n * 13761 & 0x1F) + p_78474_1_) / 32.0F * (3.0F + this.field_78537_ab.nextFloat()); double d4 = (i1 + 0.5F) - entityLivingBase.field_70165_t; double d5 = (n + 0.5F) - entityLivingBase.field_70161_v; float f7 = MathHelper.func_76133_a(d4 * d4 + d5 * d5) / b; float f8 = 1.0F; tessellator.func_78380_c(worldClient.func_72802_i(i1, i6, n, 0)); tessellator.func_78369_a(f8, f8, f8, ((1.0F - f7 * f7) * 0.5F + 0.5F) * f1); tessellator.func_78373_b(-d1 * 1.0D, -d2 * 1.0D, -d3 * 1.0D); tessellator.func_78374_a((i1 - f3) + 0.5D, i4, (n - f4) + 0.5D, (0.0F * f), (i4 * f / 4.0F + f6 * f)); tessellator.func_78374_a((i1 + f3) + 0.5D, i4, (n + f4) + 0.5D, (1.0F * f), (i4 * f / 4.0F + f6 * f)); tessellator.func_78374_a((i1 + f3) + 0.5D, i5, (n + f4) + 0.5D, (1.0F * f), (i5 * f / 4.0F + f6 * f)); tessellator.func_78374_a((i1 - f3) + 0.5D, i5, (n - f4) + 0.5D, (0.0F * f), (i5 * f / 4.0F + f6 * f)); tessellator.func_78373_b(0.0D, 0.0D, 0.0D); } else { if (b1 != 1) { if (b1 >= 0) tessellator.func_78381_a();  b1 = 1; this.field_78531_r.func_110434_K().func_110577_a(field_110923_r); tessellator.func_78382_b(); }  float f6 = ((this.field_78529_t & 0x1FF) + p_78474_1_) / 512.0F; float f7 = this.field_78537_ab.nextFloat() + f2 * 0.01F * (float)this.field_78537_ab.nextGaussian(); float f8 = this.field_78537_ab.nextFloat() + f2 * (float)this.field_78537_ab.nextGaussian() * 0.001F; double d4 = (i1 + 0.5F) - entityLivingBase.field_70165_t; double d5 = (n + 0.5F) - entityLivingBase.field_70161_v; float f9 = MathHelper.func_76133_a(d4 * d4 + d5 * d5) / b; float f10 = 1.0F; tessellator.func_78380_c((worldClient.func_72802_i(i1, i6, n, 0) * 3 + 15728880) / 4); tessellator.func_78369_a(f10, f10, f10, ((1.0F - f9 * f9) * 0.3F + 0.5F) * f1); tessellator.func_78373_b(-d1 * 1.0D, -d2 * 1.0D, -d3 * 1.0D); tessellator.func_78374_a((i1 - f3) + 0.5D, i4, (n - f4) + 0.5D, (0.0F * f + f7), (i4 * f / 4.0F + f6 * f + f8)); tessellator.func_78374_a((i1 + f3) + 0.5D, i4, (n + f4) + 0.5D, (1.0F * f + f7), (i4 * f / 4.0F + f6 * f + f8)); tessellator.func_78374_a((i1 + f3) + 0.5D, i5, (n + f4) + 0.5D, (1.0F * f + f7), (i5 * f / 4.0F + f6 * f + f8)); tessellator.func_78374_a((i1 - f3) + 0.5D, i5, (n - f4) + 0.5D, (0.0F * f + f7), (i5 * f / 4.0F + f6 * f + f8)); tessellator.func_78373_b(0.0D, 0.0D, 0.0D); }  }  }  }  }  if (b1 >= 0) tessellator.func_78381_a();  GL11.glEnable(2884); GL11.glDisable(3042); GL11.glAlphaFunc(516, 0.1F); func_78483_a(p_78474_1_); }
/* 1563 */   public void func_78478_c() { ScaledResolution scaledResolution = new ScaledResolution(this.field_78531_r, this.field_78531_r.field_71443_c, this.field_78531_r.field_71440_d); GL11.glClear(256); GL11.glMatrixMode(5889); GL11.glLoadIdentity(); GL11.glOrtho(0.0D, scaledResolution.func_78327_c(), scaledResolution.func_78324_d(), 0.0D, 1000.0D, 3000.0D); GL11.glMatrixMode(5888); GL11.glLoadIdentity(); GL11.glTranslatef(0.0F, 0.0F, -2000.0F); } private FloatBuffer func_78469_a(float p_78469_1_, float p_78469_2_, float p_78469_3_, float p_78469_4_) { this.field_78521_m.clear();
/* 1564 */     this.field_78521_m.put(p_78469_1_).put(p_78469_2_).put(p_78469_3_).put(p_78469_4_);
/* 1565 */     this.field_78521_m.flip();
/* 1566 */     return this.field_78521_m; }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public MapItemRenderer func_147701_i() {
/* 1581 */     return this.field_147709_v;
/*      */   }
/*      */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\EntityRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */