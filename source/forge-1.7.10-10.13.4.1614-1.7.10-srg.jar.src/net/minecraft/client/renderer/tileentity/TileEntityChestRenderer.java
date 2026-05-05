/*     */ package net.minecraft.client.renderer.tileentity;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Calendar;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockChest;
/*     */ import net.minecraft.client.model.ModelChest;
/*     */ import net.minecraft.client.model.ModelLargeChest;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.tileentity.TileEntityChest;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class TileEntityChestRenderer extends TileEntitySpecialRenderer {
/*  16 */   private static final ResourceLocation field_147507_b = new ResourceLocation("textures/entity/chest/trapped_double.png");
/*  17 */   private static final ResourceLocation field_147508_c = new ResourceLocation("textures/entity/chest/christmas_double.png");
/*  18 */   private static final ResourceLocation field_147505_d = new ResourceLocation("textures/entity/chest/normal_double.png");
/*  19 */   private static final ResourceLocation field_147506_e = new ResourceLocation("textures/entity/chest/trapped.png");
/*  20 */   private static final ResourceLocation field_147503_f = new ResourceLocation("textures/entity/chest/christmas.png");
/*  21 */   private static final ResourceLocation field_147504_g = new ResourceLocation("textures/entity/chest/normal.png");
/*     */   
/*  23 */   private ModelChest field_147510_h = new ModelChest();
/*  24 */   private ModelChest field_147511_i = (ModelChest)new ModelLargeChest();
/*     */   
/*     */   private boolean field_147509_j;
/*     */   private static final String __OBFID = "CL_00000965";
/*     */   
/*     */   public TileEntityChestRenderer() {
/*  30 */     Calendar calendar = Calendar.getInstance();
/*  31 */     if (calendar.get(2) + 1 == 12 && calendar.get(5) >= 24 && calendar.get(5) <= 26) {
/*  32 */       this.field_147509_j = true;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_147500_a(TileEntityChest p_147500_1_, double p_147500_2_, double p_147500_4_, double p_147500_6_, float p_147500_8_) {
/*     */     int i;
/*     */     ModelChest modelChest;
/*  40 */     if (!p_147500_1_.func_145830_o()) {
/*  41 */       i = 0;
/*     */     } else {
/*  43 */       Block block = p_147500_1_.func_145838_q();
/*  44 */       i = p_147500_1_.func_145832_p();
/*     */       
/*  46 */       if (block instanceof BlockChest && i == 0) {
/*  47 */         ((BlockChest)block).func_149954_e(p_147500_1_.func_145831_w(), p_147500_1_.field_145851_c, p_147500_1_.field_145848_d, p_147500_1_.field_145849_e);
/*  48 */         i = p_147500_1_.func_145832_p();
/*     */       } 
/*     */       
/*  51 */       p_147500_1_.func_145979_i();
/*     */     } 
/*     */     
/*  54 */     if (p_147500_1_.field_145992_i != null || p_147500_1_.field_145991_k != null) {
/*     */       return;
/*     */     }
/*  57 */     if (p_147500_1_.field_145990_j != null || p_147500_1_.field_145988_l != null) {
/*  58 */       modelChest = this.field_147511_i;
/*     */       
/*  60 */       if (p_147500_1_.func_145980_j() == 1) {
/*  61 */         func_147499_a(field_147507_b);
/*  62 */       } else if (this.field_147509_j) {
/*  63 */         func_147499_a(field_147508_c);
/*     */       } else {
/*  65 */         func_147499_a(field_147505_d);
/*     */       } 
/*     */     } else {
/*  68 */       modelChest = this.field_147510_h;
/*  69 */       if (p_147500_1_.func_145980_j() == 1) {
/*  70 */         func_147499_a(field_147506_e);
/*  71 */       } else if (this.field_147509_j) {
/*  72 */         func_147499_a(field_147503_f);
/*     */       } else {
/*  74 */         func_147499_a(field_147504_g);
/*     */       } 
/*     */     } 
/*     */     
/*  78 */     GL11.glPushMatrix();
/*  79 */     GL11.glEnable(32826);
/*  80 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*  81 */     GL11.glTranslatef((float)p_147500_2_, (float)p_147500_4_ + 1.0F, (float)p_147500_6_ + 1.0F);
/*  82 */     GL11.glScalef(1.0F, -1.0F, -1.0F);
/*     */     
/*  84 */     GL11.glTranslatef(0.5F, 0.5F, 0.5F);
/*  85 */     short s = 0;
/*  86 */     if (i == 2) s = 180; 
/*  87 */     if (i == 3) s = 0; 
/*  88 */     if (i == 4) s = 90; 
/*  89 */     if (i == 5) s = -90;
/*     */     
/*  91 */     if (i == 2 && p_147500_1_.field_145990_j != null) {
/*  92 */       GL11.glTranslatef(1.0F, 0.0F, 0.0F);
/*     */     }
/*  94 */     if (i == 5 && p_147500_1_.field_145988_l != null) {
/*  95 */       GL11.glTranslatef(0.0F, 0.0F, -1.0F);
/*     */     }
/*  97 */     GL11.glRotatef(s, 0.0F, 1.0F, 0.0F);
/*  98 */     GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
/*     */     
/* 100 */     float f = p_147500_1_.field_145986_n + (p_147500_1_.field_145989_m - p_147500_1_.field_145986_n) * p_147500_8_;
/* 101 */     if (p_147500_1_.field_145992_i != null) {
/* 102 */       float f1 = p_147500_1_.field_145992_i.field_145986_n + (p_147500_1_.field_145992_i.field_145989_m - p_147500_1_.field_145992_i.field_145986_n) * p_147500_8_;
/* 103 */       if (f1 > f) f = f1; 
/*     */     } 
/* 105 */     if (p_147500_1_.field_145991_k != null) {
/* 106 */       float f1 = p_147500_1_.field_145991_k.field_145986_n + (p_147500_1_.field_145991_k.field_145989_m - p_147500_1_.field_145991_k.field_145986_n) * p_147500_8_;
/* 107 */       if (f1 > f) f = f1;
/*     */     
/*     */     } 
/* 110 */     f = 1.0F - f;
/* 111 */     f = 1.0F - f * f * f;
/*     */     
/* 113 */     modelChest.field_78234_a.field_78795_f = -(f * 3.1415927F / 2.0F);
/* 114 */     modelChest.func_78231_a();
/* 115 */     GL11.glDisable(32826);
/* 116 */     GL11.glPopMatrix();
/* 117 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\tileentity\TileEntityChestRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */