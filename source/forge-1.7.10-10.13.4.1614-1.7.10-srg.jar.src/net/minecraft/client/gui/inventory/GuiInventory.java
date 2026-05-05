/*     */ package net.minecraft.client.gui.inventory;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import net.minecraft.client.gui.achievement.GuiAchievements;
/*     */ import net.minecraft.client.renderer.OpenGlHelper;
/*     */ import net.minecraft.client.renderer.RenderHelper;
/*     */ import net.minecraft.client.renderer.entity.RenderManager;
/*     */ import net.minecraft.client.resources.I18n;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class GuiInventory extends InventoryEffectRenderer {
/*     */   private float field_147048_u;
/*     */   
/*     */   public GuiInventory(EntityPlayer p_i1094_1_) {
/*  19 */     super(p_i1094_1_.field_71069_bz);
/*  20 */     this.field_146291_p = true;
/*     */   }
/*     */   private float field_147047_v; private static final String __OBFID = "CL_00000761";
/*     */   
/*     */   public void func_73876_c() {
/*  25 */     if (this.field_146297_k.field_71442_b.func_78758_h()) {
/*  26 */       this.field_146297_k.func_147108_a((GuiScreen)new GuiContainerCreative((EntityPlayer)this.field_146297_k.field_71439_g));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73866_w_() {
/*  32 */     this.field_146292_n.clear();
/*  33 */     if (this.field_146297_k.field_71442_b.func_78758_h()) {
/*  34 */       this.field_146297_k.func_147108_a((GuiScreen)new GuiContainerCreative((EntityPlayer)this.field_146297_k.field_71439_g));
/*     */     } else {
/*  36 */       super.func_73866_w_();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_146979_b(int p_146979_1_, int p_146979_2_) {
/*  42 */     this.field_146289_q.func_78276_b(I18n.func_135052_a("container.crafting", new Object[0]), 86, 16, 4210752);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
/*  47 */     super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
/*  48 */     this.field_147048_u = p_73863_1_;
/*  49 */     this.field_147047_v = p_73863_2_;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_146976_a(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
/*  54 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*  55 */     this.field_146297_k.func_110434_K().func_110577_a(field_147001_a);
/*  56 */     int i = this.field_147003_i;
/*  57 */     int j = this.field_147009_r;
/*  58 */     func_73729_b(i, j, 0, 0, this.field_146999_f, this.field_147000_g);
/*     */     
/*  60 */     func_147046_a(i + 51, j + 75, 30, (i + 51) - this.field_147048_u, (j + 75 - 50) - this.field_147047_v, (EntityLivingBase)this.field_146297_k.field_71439_g);
/*     */   }
/*     */   
/*     */   public static void func_147046_a(int p_147046_0_, int p_147046_1_, int p_147046_2_, float p_147046_3_, float p_147046_4_, EntityLivingBase p_147046_5_) {
/*  64 */     GL11.glEnable(2903);
/*     */     
/*  66 */     GL11.glPushMatrix();
/*  67 */     GL11.glTranslatef(p_147046_0_, p_147046_1_, 50.0F);
/*  68 */     GL11.glScalef(-p_147046_2_, p_147046_2_, p_147046_2_);
/*  69 */     GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
/*     */     
/*  71 */     float f1 = p_147046_5_.field_70761_aq;
/*  72 */     float f2 = p_147046_5_.field_70177_z;
/*  73 */     float f3 = p_147046_5_.field_70125_A;
/*  74 */     float f4 = p_147046_5_.field_70758_at;
/*  75 */     float f5 = p_147046_5_.field_70759_as;
/*     */     
/*  77 */     GL11.glRotatef(135.0F, 0.0F, 1.0F, 0.0F);
/*  78 */     RenderHelper.func_74519_b();
/*  79 */     GL11.glRotatef(-135.0F, 0.0F, 1.0F, 0.0F);
/*     */     
/*  81 */     GL11.glRotatef(-((float)Math.atan((p_147046_4_ / 40.0F))) * 20.0F, 1.0F, 0.0F, 0.0F);
/*     */     
/*  83 */     p_147046_5_.field_70761_aq = (float)Math.atan((p_147046_3_ / 40.0F)) * 20.0F;
/*  84 */     p_147046_5_.field_70177_z = (float)Math.atan((p_147046_3_ / 40.0F)) * 40.0F;
/*  85 */     p_147046_5_.field_70125_A = -((float)Math.atan((p_147046_4_ / 40.0F))) * 20.0F;
/*  86 */     p_147046_5_.field_70759_as = p_147046_5_.field_70177_z;
/*  87 */     p_147046_5_.field_70758_at = p_147046_5_.field_70177_z;
/*     */     
/*  89 */     GL11.glTranslatef(0.0F, p_147046_5_.field_70129_M, 0.0F);
/*  90 */     RenderManager.field_78727_a.field_78735_i = 180.0F;
/*  91 */     RenderManager.field_78727_a.func_147940_a((Entity)p_147046_5_, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F);
/*     */     
/*  93 */     p_147046_5_.field_70761_aq = f1;
/*  94 */     p_147046_5_.field_70177_z = f2;
/*  95 */     p_147046_5_.field_70125_A = f3;
/*  96 */     p_147046_5_.field_70758_at = f4;
/*  97 */     p_147046_5_.field_70759_as = f5;
/*  98 */     GL11.glPopMatrix();
/*  99 */     RenderHelper.func_74518_a();
/* 100 */     GL11.glDisable(32826);
/*     */     
/* 102 */     OpenGlHelper.func_77473_a(OpenGlHelper.field_77476_b);
/* 103 */     GL11.glDisable(3553);
/* 104 */     OpenGlHelper.func_77473_a(OpenGlHelper.field_77478_a);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_146284_a(GuiButton p_146284_1_) {
/* 109 */     if (p_146284_1_.field_146127_k == 0) {
/* 110 */       this.field_146297_k.func_147108_a((GuiScreen)new GuiAchievements((GuiScreen)this, this.field_146297_k.field_71439_g.func_146107_m()));
/*     */     }
/* 112 */     if (p_146284_1_.field_146127_k == 1)
/* 113 */       this.field_146297_k.func_147108_a((GuiScreen)new GuiStats((GuiScreen)this, this.field_146297_k.field_71439_g.func_146107_m())); 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\gui\inventory\GuiInventory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */