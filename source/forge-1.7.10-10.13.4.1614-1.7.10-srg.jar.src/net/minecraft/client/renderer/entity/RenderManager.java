/*     */ package net.minecraft.client.renderer.entity;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelCow;
/*     */ import net.minecraft.client.model.ModelPig;
/*     */ import net.minecraft.client.model.ModelSlime;
/*     */ import net.minecraft.client.model.ModelWolf;
/*     */ import net.minecraft.client.renderer.OpenGlHelper;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.client.renderer.texture.TextureManager;
/*     */ import net.minecraft.client.settings.GameSettings;
/*     */ import net.minecraft.crash.CrashReport;
/*     */ import net.minecraft.crash.CrashReportCategory;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.item.EntityExpBottle;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.monster.EntityWitch;
/*     */ import net.minecraft.entity.passive.EntityCow;
/*     */ import net.minecraft.entity.passive.EntityPig;
/*     */ import net.minecraft.entity.passive.EntityVillager;
/*     */ import net.minecraft.entity.projectile.EntityLargeFireball;
/*     */ import net.minecraft.entity.projectile.EntitySnowball;
/*     */ import net.minecraft.entity.projectile.EntityWitherSkull;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.ReportedException;
/*     */ import net.minecraft.world.World;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class RenderManager {
/*  35 */   public Map field_78729_o = new HashMap<Object, Object>();
/*     */   
/*  37 */   public static RenderManager field_78727_a = new RenderManager(); private FontRenderer field_78736_p; public static double field_78725_b; public static double field_78726_c;
/*     */   public static double field_78723_d;
/*     */   public TextureManager field_78724_e;
/*     */   public ItemRenderer field_78721_f;
/*     */   public World field_78722_g;
/*     */   public EntityLivingBase field_78734_h;
/*     */   public Entity field_147941_i;
/*     */   public float field_78735_i;
/*     */   public float field_78732_j;
/*     */   public GameSettings field_78733_k;
/*     */   public double field_78730_l;
/*     */   public double field_78731_m;
/*     */   public double field_78728_n;
/*     */   public static boolean field_85095_o;
/*     */   private static final String __OBFID = "CL_00000991";
/*     */   
/*     */   private RenderManager() {
/*  54 */     this.field_78729_o.put(EntityCaveSpider.class, new RenderCaveSpider());
/*  55 */     this.field_78729_o.put(EntitySpider.class, new RenderSpider());
/*  56 */     this.field_78729_o.put(EntityPig.class, new RenderPig((ModelBase)new ModelPig(), (ModelBase)new ModelPig(0.5F), 0.7F));
/*  57 */     this.field_78729_o.put(EntitySheep.class, new RenderSheep((ModelBase)new ModelSheep2(), (ModelBase)new ModelSheep1(), 0.7F));
/*  58 */     this.field_78729_o.put(EntityCow.class, new RenderCow((ModelBase)new ModelCow(), 0.7F));
/*  59 */     this.field_78729_o.put(EntityMooshroom.class, new RenderMooshroom((ModelBase)new ModelCow(), 0.7F));
/*  60 */     this.field_78729_o.put(EntityWolf.class, new RenderWolf((ModelBase)new ModelWolf(), (ModelBase)new ModelWolf(), 0.5F));
/*  61 */     this.field_78729_o.put(EntityChicken.class, new RenderChicken((ModelBase)new ModelChicken(), 0.3F));
/*  62 */     this.field_78729_o.put(EntityOcelot.class, new RenderOcelot((ModelBase)new ModelOcelot(), 0.4F));
/*  63 */     this.field_78729_o.put(EntitySilverfish.class, new RenderSilverfish());
/*  64 */     this.field_78729_o.put(EntityCreeper.class, new RenderCreeper());
/*  65 */     this.field_78729_o.put(EntityEnderman.class, new RenderEnderman());
/*  66 */     this.field_78729_o.put(EntitySnowman.class, new RenderSnowMan());
/*  67 */     this.field_78729_o.put(EntitySkeleton.class, new RenderSkeleton());
/*  68 */     this.field_78729_o.put(EntityWitch.class, new RenderWitch());
/*  69 */     this.field_78729_o.put(EntityBlaze.class, new RenderBlaze());
/*  70 */     this.field_78729_o.put(EntityZombie.class, new RenderZombie());
/*  71 */     this.field_78729_o.put(EntitySlime.class, new RenderSlime((ModelBase)new ModelSlime(16), (ModelBase)new ModelSlime(0), 0.25F));
/*  72 */     this.field_78729_o.put(EntityMagmaCube.class, new RenderMagmaCube());
/*  73 */     this.field_78729_o.put(EntityPlayer.class, new RenderPlayer());
/*  74 */     this.field_78729_o.put(EntityGiantZombie.class, new RenderGiantZombie((ModelBase)new ModelZombie(), 0.5F, 6.0F));
/*  75 */     this.field_78729_o.put(EntityGhast.class, new RenderGhast());
/*  76 */     this.field_78729_o.put(EntitySquid.class, new RenderSquid((ModelBase)new ModelSquid(), 0.7F));
/*  77 */     this.field_78729_o.put(EntityVillager.class, new RenderVillager());
/*  78 */     this.field_78729_o.put(EntityIronGolem.class, new RenderIronGolem());
/*  79 */     this.field_78729_o.put(EntityBat.class, new RenderBat());
/*     */     
/*  81 */     this.field_78729_o.put(EntityDragon.class, new RenderDragon());
/*  82 */     this.field_78729_o.put(EntityEnderCrystal.class, new RenderEnderCrystal());
/*     */     
/*  84 */     this.field_78729_o.put(EntityWither.class, new RenderWither());
/*     */     
/*  86 */     this.field_78729_o.put(Entity.class, new RenderEntity());
/*     */     
/*  88 */     this.field_78729_o.put(EntityPainting.class, new RenderPainting());
/*  89 */     this.field_78729_o.put(EntityItemFrame.class, new RenderItemFrame());
/*  90 */     this.field_78729_o.put(EntityLeashKnot.class, new RenderLeashKnot());
/*  91 */     this.field_78729_o.put(EntityArrow.class, new RenderArrow());
/*  92 */     this.field_78729_o.put(EntitySnowball.class, new RenderSnowball(Items.field_151126_ay));
/*  93 */     this.field_78729_o.put(EntityEnderPearl.class, new RenderSnowball(Items.field_151079_bi));
/*  94 */     this.field_78729_o.put(EntityEnderEye.class, new RenderSnowball(Items.field_151061_bv));
/*  95 */     this.field_78729_o.put(EntityEgg.class, new RenderSnowball(Items.field_151110_aK));
/*  96 */     this.field_78729_o.put(EntityPotion.class, new RenderSnowball((Item)Items.field_151068_bn, 16384));
/*  97 */     this.field_78729_o.put(EntityExpBottle.class, new RenderSnowball(Items.field_151062_by));
/*  98 */     this.field_78729_o.put(EntityFireworkRocket.class, new RenderSnowball(Items.field_151152_bP));
/*  99 */     this.field_78729_o.put(EntityLargeFireball.class, new RenderFireball(2.0F));
/* 100 */     this.field_78729_o.put(EntitySmallFireball.class, new RenderFireball(0.5F));
/* 101 */     this.field_78729_o.put(EntityWitherSkull.class, new RenderWitherSkull());
/* 102 */     this.field_78729_o.put(EntityItem.class, new RenderItem());
/* 103 */     this.field_78729_o.put(EntityXPOrb.class, new RenderXPOrb());
/* 104 */     this.field_78729_o.put(EntityTNTPrimed.class, new RenderTNTPrimed());
/* 105 */     this.field_78729_o.put(EntityFallingBlock.class, new RenderFallingBlock());
/*     */     
/* 107 */     this.field_78729_o.put(EntityMinecartTNT.class, new RenderTntMinecart());
/* 108 */     this.field_78729_o.put(EntityMinecartMobSpawner.class, new RenderMinecartMobSpawner());
/* 109 */     this.field_78729_o.put(EntityMinecart.class, new RenderMinecart());
/* 110 */     this.field_78729_o.put(EntityBoat.class, new RenderBoat());
/* 111 */     this.field_78729_o.put(EntityFishHook.class, new RenderFish());
/*     */     
/* 113 */     this.field_78729_o.put(EntityHorse.class, new RenderHorse((ModelBase)new ModelHorse(), 0.75F));
/*     */     
/* 115 */     this.field_78729_o.put(EntityLightningBolt.class, new RenderLightningBolt());
/*     */     
/* 117 */     for (Render render : this.field_78729_o.values()) {
/* 118 */       render.func_76976_a(this);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Render func_78715_a(Class<Entity> p_78715_1_) {
/* 124 */     Render render = (Render)this.field_78729_o.get(p_78715_1_);
/* 125 */     if (render == null && p_78715_1_ != Entity.class) {
/* 126 */       render = func_78715_a(p_78715_1_.getSuperclass());
/* 127 */       this.field_78729_o.put(p_78715_1_, render);
/*     */     } 
/* 129 */     return render;
/*     */   }
/*     */   
/*     */   public Render func_78713_a(Entity p_78713_1_) {
/* 133 */     return func_78715_a(p_78713_1_.getClass());
/*     */   }
/*     */   
/*     */   public void func_147938_a(World p_147938_1_, TextureManager p_147938_2_, FontRenderer p_147938_3_, EntityLivingBase p_147938_4_, Entity p_147938_5_, GameSettings p_147938_6_, float p_147938_7_) {
/* 137 */     this.field_78722_g = p_147938_1_;
/* 138 */     this.field_78724_e = p_147938_2_;
/* 139 */     this.field_78733_k = p_147938_6_;
/* 140 */     this.field_78734_h = p_147938_4_;
/* 141 */     this.field_147941_i = p_147938_5_;
/* 142 */     this.field_78736_p = p_147938_3_;
/*     */     
/* 144 */     if (p_147938_4_.func_70608_bn()) {
/* 145 */       Block block = p_147938_1_.func_147439_a(MathHelper.func_76128_c(p_147938_4_.field_70165_t), MathHelper.func_76128_c(p_147938_4_.field_70163_u), MathHelper.func_76128_c(p_147938_4_.field_70161_v));
/* 146 */       if (block == Blocks.field_150324_C) {
/* 147 */         int i = p_147938_1_.func_72805_g(MathHelper.func_76128_c(p_147938_4_.field_70165_t), MathHelper.func_76128_c(p_147938_4_.field_70163_u), MathHelper.func_76128_c(p_147938_4_.field_70161_v));
/*     */         
/* 149 */         int j = i & 0x3;
/* 150 */         this.field_78735_i = (j * 90 + 180);
/* 151 */         this.field_78732_j = 0.0F;
/*     */       } 
/*     */     } else {
/* 154 */       this.field_78735_i = p_147938_4_.field_70126_B + (p_147938_4_.field_70177_z - p_147938_4_.field_70126_B) * p_147938_7_;
/* 155 */       this.field_78732_j = p_147938_4_.field_70127_C + (p_147938_4_.field_70125_A - p_147938_4_.field_70127_C) * p_147938_7_;
/*     */     } 
/*     */     
/* 158 */     if (p_147938_6_.field_74320_O == 2) {
/* 159 */       this.field_78735_i += 180.0F;
/*     */     }
/*     */     
/* 162 */     this.field_78730_l = p_147938_4_.field_70142_S + (p_147938_4_.field_70165_t - p_147938_4_.field_70142_S) * p_147938_7_;
/* 163 */     this.field_78731_m = p_147938_4_.field_70137_T + (p_147938_4_.field_70163_u - p_147938_4_.field_70137_T) * p_147938_7_;
/* 164 */     this.field_78728_n = p_147938_4_.field_70136_U + (p_147938_4_.field_70161_v - p_147938_4_.field_70136_U) * p_147938_7_;
/*     */   }
/*     */   
/*     */   public boolean func_147937_a(Entity p_147937_1_, float p_147937_2_) {
/* 168 */     return func_147936_a(p_147937_1_, p_147937_2_, false);
/*     */   }
/*     */   
/*     */   public boolean func_147936_a(Entity p_147936_1_, float p_147936_2_, boolean p_147936_3_) {
/* 172 */     if (p_147936_1_.field_70173_aa == 0) {
/* 173 */       p_147936_1_.field_70142_S = p_147936_1_.field_70165_t;
/* 174 */       p_147936_1_.field_70137_T = p_147936_1_.field_70163_u;
/* 175 */       p_147936_1_.field_70136_U = p_147936_1_.field_70161_v;
/*     */     } 
/* 177 */     double d1 = p_147936_1_.field_70142_S + (p_147936_1_.field_70165_t - p_147936_1_.field_70142_S) * p_147936_2_;
/* 178 */     double d2 = p_147936_1_.field_70137_T + (p_147936_1_.field_70163_u - p_147936_1_.field_70137_T) * p_147936_2_;
/* 179 */     double d3 = p_147936_1_.field_70136_U + (p_147936_1_.field_70161_v - p_147936_1_.field_70136_U) * p_147936_2_;
/* 180 */     float f = p_147936_1_.field_70126_B + (p_147936_1_.field_70177_z - p_147936_1_.field_70126_B) * p_147936_2_;
/*     */     
/* 182 */     int i = p_147936_1_.func_70070_b(p_147936_2_);
/* 183 */     if (p_147936_1_.func_70027_ad()) {
/* 184 */       i = 15728880;
/*     */     }
/* 186 */     int j = i % 65536;
/* 187 */     int k = i / 65536;
/* 188 */     OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, j / 1.0F, k / 1.0F);
/* 189 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */     
/* 191 */     return func_147939_a(p_147936_1_, d1 - field_78725_b, d2 - field_78726_c, d3 - field_78723_d, f, p_147936_2_, p_147936_3_);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_147940_a(Entity p_147940_1_, double p_147940_2_, double p_147940_4_, double p_147940_6_, float p_147940_8_, float p_147940_9_) {
/* 197 */     return func_147939_a(p_147940_1_, p_147940_2_, p_147940_4_, p_147940_6_, p_147940_8_, p_147940_9_, false);
/*     */   }
/*     */   
/*     */   public boolean func_147939_a(Entity p_147939_1_, double p_147939_2_, double p_147939_4_, double p_147939_6_, float p_147939_8_, float p_147939_9_, boolean p_147939_10_) {
/* 201 */     Render render = null;
/*     */     
/*     */     try {
/* 204 */       render = func_78713_a(p_147939_1_);
/* 205 */       if (render != null && this.field_78724_e != null) {
/* 206 */         if (!render.func_147905_a() || p_147939_10_) {
/*     */           try {
/* 208 */             render.func_76986_a(p_147939_1_, p_147939_2_, p_147939_4_, p_147939_6_, p_147939_8_, p_147939_9_);
/* 209 */           } catch (Throwable throwable) {
/* 210 */             throw new ReportedException(CrashReport.func_85055_a(throwable, "Rendering entity in world"));
/*     */           } 
/*     */           
/*     */           try {
/* 214 */             render.func_76979_b(p_147939_1_, p_147939_2_, p_147939_4_, p_147939_6_, p_147939_8_, p_147939_9_);
/* 215 */           } catch (Throwable throwable) {
/* 216 */             throw new ReportedException(CrashReport.func_85055_a(throwable, "Post-rendering entity in world"));
/*     */           } 
/*     */           
/* 219 */           if (field_85095_o && !p_147939_1_.func_82150_aj() && !p_147939_10_) {
/*     */             try {
/* 221 */               func_85094_b(p_147939_1_, p_147939_2_, p_147939_4_, p_147939_6_, p_147939_8_, p_147939_9_);
/* 222 */             } catch (Throwable throwable) {
/* 223 */               throw new ReportedException(CrashReport.func_85055_a(throwable, "Rendering entity hitbox in world"));
/*     */             } 
/*     */           }
/*     */         } 
/* 227 */       } else if (this.field_78724_e != null) {
/* 228 */         return false;
/*     */       } 
/* 230 */     } catch (Throwable throwable) {
/* 231 */       CrashReport crashReport = CrashReport.func_85055_a(throwable, "Rendering entity in world");
/* 232 */       CrashReportCategory crashReportCategory1 = crashReport.func_85058_a("Entity being rendered");
/* 233 */       p_147939_1_.func_85029_a(crashReportCategory1);
/*     */       
/* 235 */       CrashReportCategory crashReportCategory2 = crashReport.func_85058_a("Renderer details");
/* 236 */       crashReportCategory2.func_71507_a("Assigned renderer", render);
/* 237 */       crashReportCategory2.func_71507_a("Location", CrashReportCategory.func_85074_a(p_147939_2_, p_147939_4_, p_147939_6_));
/* 238 */       crashReportCategory2.func_71507_a("Rotation", Float.valueOf(p_147939_8_));
/* 239 */       crashReportCategory2.func_71507_a("Delta", Float.valueOf(p_147939_9_));
/*     */       
/* 241 */       throw new ReportedException(crashReport);
/*     */     } 
/* 243 */     return true;
/*     */   }
/*     */   
/*     */   private void func_85094_b(Entity p_85094_1_, double p_85094_2_, double p_85094_4_, double p_85094_6_, float p_85094_8_, float p_85094_9_) {
/* 247 */     GL11.glDepthMask(false);
/* 248 */     GL11.glDisable(3553);
/* 249 */     GL11.glDisable(2896);
/* 250 */     GL11.glDisable(2884);
/* 251 */     GL11.glDisable(3042);
/*     */     
/* 253 */     float f = p_85094_1_.field_70130_N / 2.0F;
/* 254 */     AxisAlignedBB axisAlignedBB = AxisAlignedBB.func_72330_a(p_85094_2_ - f, p_85094_4_, p_85094_6_ - f, p_85094_2_ + f, p_85094_4_ + p_85094_1_.field_70131_O, p_85094_6_ + f);
/* 255 */     RenderGlobal.func_147590_a(axisAlignedBB, 16777215);
/*     */     
/* 257 */     GL11.glEnable(3553);
/* 258 */     GL11.glEnable(2896);
/* 259 */     GL11.glEnable(2884);
/* 260 */     GL11.glDisable(3042);
/* 261 */     GL11.glDepthMask(true);
/*     */   }
/*     */   
/*     */   public void func_78717_a(World p_78717_1_) {
/* 265 */     this.field_78722_g = p_78717_1_;
/*     */   }
/*     */   
/*     */   public double func_78714_a(double p_78714_1_, double p_78714_3_, double p_78714_5_) {
/* 269 */     double d1 = p_78714_1_ - this.field_78730_l;
/* 270 */     double d2 = p_78714_3_ - this.field_78731_m;
/* 271 */     double d3 = p_78714_5_ - this.field_78728_n;
/* 272 */     return d1 * d1 + d2 * d2 + d3 * d3;
/*     */   }
/*     */   
/*     */   public FontRenderer func_78716_a() {
/* 276 */     return this.field_78736_p;
/*     */   }
/*     */   
/*     */   public void func_94178_a(IIconRegister p_94178_1_) {
/* 280 */     for (Render render : this.field_78729_o.values())
/* 281 */       render.func_94143_a(p_94178_1_); 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\entity\RenderManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */