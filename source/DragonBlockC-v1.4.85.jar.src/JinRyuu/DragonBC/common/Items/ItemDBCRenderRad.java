/*     */ package JinRyuu.DragonBC.common.Items;
/*     */ 
/*     */ import JinRyuu.DragonBC.common.Blocks.BlocksDBC;
/*     */ import JinRyuu.JRMCore.JRMCoreClient;
/*     */ import JinRyuu.JRMCore.JRMCoreH;
/*     */ import JinRyuu.JRMCore.JRMCoreHC;
/*     */ import java.util.ArrayList;
/*     */ import net.minecraft.client.entity.EntityClientPlayerMP;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.entity.Render;
/*     */ import net.minecraft.client.renderer.entity.RenderManager;
/*     */ import net.minecraft.client.renderer.entity.RenderPlayer;
/*     */ import net.minecraft.client.renderer.texture.TextureManager;
/*     */ import net.minecraft.client.renderer.texture.TextureUtil;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraftforge.client.IItemRenderer;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ import org.lwjgl.opengl.GL14;
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
/*     */ public class ItemDBCRenderRad
/*     */   implements IItemRenderer
/*     */ {
/*     */   protected String t;
/*     */   private int tick;
/*     */   
/*     */   public boolean handleRenderType(ItemStack item, IItemRenderer.ItemRenderType type) {
/*  40 */     switch (type) {
/*     */       case EQUIPPED:
/*  42 */         return false;
/*     */       case INVENTORY:
/*  44 */         return false;
/*     */       case ENTITY:
/*  46 */         return false;
/*     */       case EQUIPPED_FIRST_PERSON:
/*  48 */         return true;
/*     */     } 
/*  50 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ItemStack item, IItemRenderer.ItemRendererHelper helper) {
/*  58 */     return false;
/*     */   }
/*     */   public void renderItem(IItemRenderer.ItemRenderType type, ItemStack item, Object... data) {
/*     */     float p_78440_1_;
/*     */     EntityClientPlayerMP entityclientplayermp;
/*     */     float f2;
/*     */     float f13;
/*     */     float f1;
/*     */     float f5;
/*  67 */     switch (type) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case EQUIPPED:
/*     */       case INVENTORY:
/*     */       case ENTITY:
/*     */       case EQUIPPED_FIRST_PERSON:
/*  78 */         GL11.glPushMatrix();
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
/* 118 */         p_78440_1_ = 0.0625F;
/* 119 */         entityclientplayermp = JRMCoreClient.mc.field_71439_g;
/* 120 */         f2 = entityclientplayermp.field_70127_C + (entityclientplayermp.field_70125_A - entityclientplayermp.field_70127_C) * p_78440_1_;
/*     */         
/* 122 */         f13 = 0.8F;
/* 123 */         f1 = 0.0F;
/*     */         
/* 125 */         GL11.glTranslatef(0.35F, -0.0F, -0.3F);
/*     */ 
/*     */         
/* 128 */         f5 = 1.0F - f2 / 45.0F + 0.1F;
/*     */         
/* 130 */         if (f5 < 0.0F)
/*     */         {
/* 132 */           f5 = 0.0F;
/*     */         }
/*     */         
/* 135 */         if (f5 > 1.0F)
/*     */         {
/* 137 */           f5 = 1.0F;
/*     */         }
/*     */         
/* 140 */         f5 = -MathHelper.func_76134_b(f5 * 3.1415927F) * 0.5F + 0.5F;
/*     */ 
/*     */         
/* 143 */         GL11.glRotatef(f5 * -85.0F, 0.0F, 0.0F, 1.0F);
/*     */ 
/*     */         
/* 146 */         GL11.glRotatef(20.0F, 0.0F, 1.0F, 0.0F);
/* 147 */         GL11.glRotatef(-20.0F, 1.0F, 0.0F, 0.0F);
/* 148 */         GL11.glRotatef(20.0F, 0.0F, 0.0F, 1.0F);
/*     */ 
/*     */         
/* 151 */         GL11.glTranslatef(-0.5F, 0.0F, -0.0F);
/* 152 */         renderItem();
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 157 */         GL11.glPopMatrix();
/*     */         break;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 164 */   private static final ResourceLocation RES_ITEM_GLINT = new ResourceLocation("textures/misc/enchanted_item_glint.png");
/* 165 */   private static final ResourceLocation RES_MAP_BACKGROUND = new ResourceLocation("textures/map/map_background.png");
/* 166 */   private static final ResourceLocation RES_UNDERWATER_OVERLAY = new ResourceLocation("textures/misc/underwater.png");
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
/*     */ 
/*     */   
/*     */   public void drawTexturedModalRect(int p_73729_1_, int p_73729_2_, int p_73729_3_, int p_73729_4_, int p_73729_5_, int p_73729_6_) {
/* 282 */     float f = 0.00390625F;
/* 283 */     float f1 = 0.00390625F;
/* 284 */     Tessellator tessellator = Tessellator.field_78398_a;
/* 285 */     tessellator.func_78382_b();
/* 286 */     double zLevel = 0.0D;
/* 287 */     tessellator.func_78374_a((p_73729_1_ + 0), (p_73729_2_ + p_73729_6_), zLevel, ((p_73729_3_ + 0) * f), ((p_73729_4_ + p_73729_6_) * f1));
/* 288 */     tessellator.func_78374_a((p_73729_1_ + p_73729_5_), (p_73729_2_ + p_73729_6_), zLevel, ((p_73729_3_ + p_73729_5_) * f), ((p_73729_4_ + p_73729_6_) * f1));
/* 289 */     tessellator.func_78374_a((p_73729_1_ + p_73729_5_), (p_73729_2_ + 0), zLevel, ((p_73729_3_ + p_73729_5_) * f), ((p_73729_4_ + 0) * f1));
/* 290 */     tessellator.func_78374_a((p_73729_1_ + 0), (p_73729_2_ + 0), zLevel, ((p_73729_3_ + 0) * f), ((p_73729_4_ + 0) * f1));
/* 291 */     tessellator.func_78381_a();
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderItem() {
/* 296 */     GL11.glPushMatrix();
/* 297 */     TextureManager texturemanager = JRMCoreClient.mc.func_110434_K();
/*     */     
/* 299 */     String wish = JRMCoreH.tjdbcAssts + ":radar.png";
/* 300 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 301 */     ResourceLocation tx = new ResourceLocation(wish);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 306 */     int xSize = 166;
/* 307 */     int ySize = 166;
/* 308 */     int xMin = 0;
/* 309 */     int yMin = 0;
/*     */     
/* 311 */     texturemanager.func_110577_a(tx);
/* 312 */     TextureUtil.func_152777_a(false, false, 1.0F);
/* 313 */     Tessellator tessellator = Tessellator.field_78398_a;
/*     */     
/* 315 */     float f = 0.0F;
/* 316 */     float f1 = xSize / 256.0F;
/* 317 */     float f2 = 0.0F;
/* 318 */     float f3 = ySize / 256.0F;
/*     */ 
/*     */     
/* 321 */     float f4 = -0.9F;
/* 322 */     float f5 = -0.5F;
/* 323 */     GL11.glEnable(32826);
/* 324 */     GL11.glTranslatef(-f4 - 0.2F, -f5, 0.13F);
/* 325 */     float f6 = 0.75F;
/* 326 */     GL11.glScalef(f6, f6, f6);
/* 327 */     GL11.glRotatef(10.0F, 1.0F, 0.0F, 0.0F);
/* 328 */     GL11.glRotatef(50.0F, 0.0F, 1.0F, 0.0F);
/* 329 */     GL11.glRotatef(0.0F, 0.0F, 0.0F, 1.0F);
/*     */     
/* 331 */     GL11.glTranslatef(-0.375F, 0.1625F, 0.0F);
/*     */     
/* 333 */     GL11.glPushMatrix();
/*     */     
/* 335 */     JRMCoreHC.ri(tessellator, f1, f2, f, f3, xSize, ySize, 0.0625F);
/*     */     
/* 337 */     GL11.glPopMatrix();
/*     */ 
/*     */ 
/*     */     
/* 341 */     this.tick++;
/* 342 */     if (this.tick > 80) {
/*     */       
/* 344 */       if (this.tick > 90) {
/* 345 */         this.tick = 0;
/*     */       }
/*     */     } else {
/* 348 */       DragonRadar((EntityPlayer)JRMCoreClient.mc.field_71439_g);
/*     */     } 
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 383 */     GL11.glDisable(32826);
/* 384 */     texturemanager.func_110577_a(tx);
/* 385 */     TextureUtil.func_147945_b();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 393 */     GL11.glPopMatrix();
/*     */ 
/*     */ 
/*     */     
/* 397 */     if (ItemDragonRadar.cld) { ItemDragonRadar.cld = false;
/* 398 */       tc = 50; }
/*     */     
/* 400 */     if (tc > 0) tc--;
/*     */ 
/*     */ 
/*     */     
/* 404 */     GL11.glPushMatrix();
/* 405 */     texturemanager = JRMCoreClient.mc.func_110434_K();
/*     */     
/* 407 */     wish = JRMCoreH.tjdbcAssts + ":radar.png";
/* 408 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 409 */     tx = new ResourceLocation(wish);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 414 */     xSize = 166;
/* 415 */     ySize = 17;
/* 416 */     xMin = 0;
/* 417 */     yMin = 166;
/* 418 */     int yMax = 166 + ySize;
/*     */     
/* 420 */     texturemanager.func_110577_a(tx);
/* 421 */     TextureUtil.func_152777_a(false, false, 1.0F);
/* 422 */     Tessellator tessellator1 = Tessellator.field_78398_a;
/*     */     
/* 424 */     float f7 = 0.0F;
/* 425 */     float f8 = xSize / 256.0F;
/* 426 */     float f9 = yMin / 256.0F;
/* 427 */     float f11 = yMax / 256.0F;
/*     */ 
/*     */     
/* 430 */     float f12 = -0.9F;
/* 431 */     float f13 = -1.16F + tc * 5.0E-4F;
/* 432 */     GL11.glEnable(32826);
/*     */     
/* 434 */     GL11.glTranslatef(-f12 - 0.2F, -f13, 0.13F);
/* 435 */     float f14 = 0.75F;
/* 436 */     GL11.glScalef(f14, f14, f14);
/* 437 */     GL11.glRotatef(10.0F, 1.0F, 0.0F, 0.0F);
/* 438 */     GL11.glRotatef(50.0F, 0.0F, 1.0F, 0.0F);
/* 439 */     GL11.glRotatef(0.0F, 0.0F, 0.0F, 1.0F);
/*     */     
/* 441 */     GL11.glTranslatef(-0.635F, 0.2F, 0.097F);
/*     */     
/* 443 */     GL11.glPushMatrix();
/*     */     
/* 445 */     f7 = ySize / 128.0F;
/* 446 */     GL11.glScalef(1.0F, f7, 1.0F);
/* 447 */     JRMCoreHC.ri(tessellator1, f8, f9, f7, f11, xSize, ySize, 0.06F);
/*     */     
/* 449 */     GL11.glPopMatrix();
/*     */     
/* 451 */     GL11.glDisable(32826);
/* 452 */     texturemanager.func_110577_a(tx);
/* 453 */     TextureUtil.func_147945_b();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 461 */     GL11.glPopMatrix();
/*     */ 
/*     */     
/* 464 */     EntityClientPlayerMP entityclientplayermp = JRMCoreClient.mc.field_71439_g;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 469 */     JRMCoreClient.mc.func_110434_K().func_110577_a(entityclientplayermp.func_110306_p());
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 474 */     int j1 = 0;
/* 475 */     GL11.glPushMatrix();
/*     */ 
/*     */ 
/*     */     
/* 479 */     GL11.glTranslatef(0.6F, 0.0F, 0.0F);
/*     */     
/* 481 */     GL11.glRotatef(-20.0F, 0.0F, 0.0F, 1.0F);
/* 482 */     GL11.glRotatef(20.0F, 1.0F, 0.0F, 0.0F);
/* 483 */     GL11.glRotatef(-0.0F, 0.0F, 1.0F, 0.0F);
/* 484 */     GL11.glTranslatef(0.3F, -0.1F, -0.1F);
/*     */     
/* 486 */     j1 = 1;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 491 */     j1 = 1;
/*     */ 
/*     */     
/* 494 */     Render render = RenderManager.field_78727_a.func_78713_a((Entity)entityclientplayermp);
/* 495 */     RenderPlayer renderplayer = (RenderPlayer)render;
/* 496 */     float f10 = 1.0F;
/* 497 */     GL11.glScalef(f10, f10, f10);
/* 498 */     renderplayer.func_82441_a((EntityPlayer)entityclientplayermp);
/* 499 */     GL11.glPopMatrix();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 504 */   ArrayList<double[]> dbs = (ArrayList)new ArrayList<double>();
/* 505 */   ArrayList<double[]> dbs2 = (ArrayList)new ArrayList<double>();
/* 506 */   private int db = 0;
/* 507 */   private static int gdb = 0;
/* 508 */   private int dbw = 0;
/*     */   public void upd(EntityPlayer p) {
/* 510 */     if (p.field_71093_bK != this.dbw) {
/* 511 */       this.dbw = p.field_71093_bK;
/* 512 */       this.dbs.clear();
/* 513 */       this.dbs2.clear();
/*     */     } 
/* 515 */     if (gdb >= 800) {
/* 516 */       gdb = 0;
/* 517 */       if (this.db == 0) { this.db = 1;
/* 518 */         this.dbs.clear(); }
/*     */       else
/* 520 */       { this.db = 0;
/* 521 */         this.dbs2.clear(); }
/*     */     
/*     */     } 
/* 524 */     for (int j = 0; j < 16; j++) {
/* 525 */       if (gdb % 50 == 0 && j == gdb / 50) {
/* 526 */         chk(p, j * 16 + 15, j * 16);
/*     */       }
/*     */     } 
/*     */     
/* 530 */     gdb++;
/*     */   }
/*     */   public void chk(EntityPlayer p, int x, int n) {
/* 533 */     int l1 = MathHelper.func_76128_c(p.field_70165_t);
/* 534 */     int i11 = MathHelper.func_76128_c(p.field_70161_v);
/* 535 */     int m = 80;
/* 536 */     for (int j11 = l1 - m; j11 <= l1 + m; j11++) {
/* 537 */       for (int j2 = i11 - m; j2 <= i11 + m; j2++) {
/* 538 */         for (int k2 = x; k2 >= n; k2--) {
/* 539 */           if (p.field_70170_p.func_147439_a(j11, k2, j2) == BlocksDBC.BlockDragonBall || p.field_70170_p.func_147439_a(j11, k2, j2) == BlocksDBC.BlockNamekDragonBall) {
/* 540 */             double[] d = { j11, j2 };
/* 541 */             this.dbs.add(d);
/* 542 */             this.dbs2.add(d);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void DragonRadar(EntityPlayer p) {
/* 550 */     upd(p);
/* 551 */     int pitch = 0; int i;
/* 552 */     for (i = 0; i < this.dbs.size(); i++) {
/* 553 */       DragonDetect(((double[])this.dbs.get(i))[0] - p.field_70165_t, ((double[])this.dbs.get(i))[1] - p.field_70161_v, ((pitch > 0) ? pitch : false));
/*     */     }
/* 555 */     for (i = 0; i < this.dbs2.size(); i++) {
/* 556 */       DragonDetect(((double[])this.dbs2.get(i))[0] - p.field_70165_t, ((double[])this.dbs2.get(i))[1] - p.field_70161_v, ((pitch > 0) ? pitch : false));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void DragonDetect(double x, double y, float f) {
/* 562 */     int guiLeft = 69;
/* 563 */     int guiTop = 92;
/*     */     
/* 565 */     String ic = "jinryuumodscore:icons.png";
/* 566 */     String ic2 = "jinryuudragonbc:icons3.png";
/*     */ 
/*     */     
/* 569 */     if (x > -70.0D && x < 70.0D && y > -70.0D && y < 70.0D) {
/*     */       
/* 571 */       GL11.glPushMatrix();
/* 572 */       GL11.glEnable(3042);
/* 573 */       GL11.glDisable(2896);
/*     */       
/* 575 */       GL11.glTranslatef(-0.005F, -0.0025F, 0.0F);
/* 576 */       GL11.glTranslatef(0.567F, 0.44F, 0.0F);
/* 577 */       GL11.glRotatef(-JRMCoreClient.mc.field_71439_g.field_70759_as - 180.0F, 0.0F, 0.0F, 1.0F);
/*     */ 
/*     */       
/* 580 */       GL14.glBlendFuncSeparate(0, 1, 771, 0);
/*     */ 
/*     */       
/* 583 */       GL11.glTranslatef(-0.567F, -0.44F, 0.0F);
/* 584 */       GL11.glTranslatef(0.0F, 0.0F, -0.065F);
/* 585 */       float f10 = 0.00609375F;
/* 586 */       GL11.glScalef(f10, f10, f10);
/*     */       
/* 588 */       GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
/*     */       
/* 590 */       int xSize = 166;
/* 591 */       int ySize = 166;
/* 592 */       String var4 = "jinryuudragonbc:radarm.png";
/* 593 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 594 */       ResourceLocation tx = new ResourceLocation(var4);
/* 595 */       JRMCoreClient.mc.field_71446_o.func_110577_a(tx);
/* 596 */       drawTexturedModalRect(-166, -166, 0, 0, xSize, ySize);
/*     */       
/* 598 */       GL11.glBlendFunc(773, 772);
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
/* 613 */       JRMCoreClient.mc.field_71460_t.func_78483_a(0.0D);
/*     */       
/* 615 */       GL11.glTranslatef(1.0F, -0.5F, -0.01F);
/* 616 */       xSize = 8;
/* 617 */       ySize = 8;
/* 618 */       var4 = "jinryuudragonbc:detect.png";
/* 619 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 620 */       tx = new ResourceLocation(var4);
/* 621 */       JRMCoreClient.mc.field_71446_o.func_110577_a(tx);
/* 622 */       drawTexturedModalRect((int)(guiLeft + x) - 166, (int)(guiTop + y) - 166, 0, 0, xSize, ySize);
/*     */       
/* 624 */       JRMCoreClient.mc.field_71460_t.func_78463_b(0.0D);
/*     */       
/* 626 */       GL11.glEnable(2896);
/* 627 */       GL11.glDisable(3042);
/* 628 */       GL11.glPopMatrix();
/*     */     } 
/*     */   }
/*     */   
/* 632 */   public static int tc = 0;
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Items\ItemDBCRenderRad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */