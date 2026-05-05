/*     */ package net.minecraft.client.gui;
/*     */ import com.google.common.collect.Maps;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Map;
/*     */ import net.minecraft.block.material.MapColor;
/*     */ import net.minecraft.client.renderer.OpenGlHelper;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.texture.DynamicTexture;
/*     */ import net.minecraft.client.renderer.texture.TextureManager;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.world.storage.MapData;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class MapItemRenderer {
/*  17 */   private static final ResourceLocation field_148253_a = new ResourceLocation("textures/map/map_icons.png");
/*     */   
/*     */   private final TextureManager field_148251_b;
/*     */   
/*  21 */   private final Map field_148252_c = Maps.newHashMap(); private static final String __OBFID = "CL_00000663";
/*     */   
/*     */   public MapItemRenderer(TextureManager p_i45009_1_) {
/*  24 */     this.field_148251_b = p_i45009_1_;
/*     */   }
/*     */   
/*     */   public void func_148246_a(MapData p_148246_1_) {
/*  28 */     func_148248_b(p_148246_1_).func_148236_a();
/*     */   }
/*     */   
/*     */   public void func_148250_a(MapData p_148250_1_, boolean p_148250_2_) {
/*  32 */     func_148248_b(p_148250_1_).func_148237_a(p_148250_2_);
/*     */   }
/*     */   
/*     */   private Instance func_148248_b(MapData p_148248_1_) {
/*  36 */     Instance instance = (Instance)this.field_148252_c.get(p_148248_1_.field_76190_i);
/*     */     
/*  38 */     if (instance == null) {
/*  39 */       instance = new Instance(p_148248_1_);
/*  40 */       this.field_148252_c.put(p_148248_1_.field_76190_i, instance);
/*     */     } 
/*  42 */     return instance;
/*     */   }
/*     */   
/*     */   public void func_148249_a() {
/*  46 */     for (Instance instance : this.field_148252_c.values()) {
/*  47 */       this.field_148251_b.func_147645_c(instance.field_148240_d);
/*     */     }
/*     */     
/*  50 */     this.field_148252_c.clear();
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   class Instance
/*     */   {
/*     */     private final MapData field_148242_b;
/*     */     private final DynamicTexture field_148243_c;
/*     */     
/*     */     private Instance(MapItemRenderer p_i45007_1_, MapData p_i45007_2_) {
/*  60 */       this.field_148242_b = p_i45007_2_;
/*  61 */       this.field_148243_c = new DynamicTexture(128, 128);
/*  62 */       this.field_148241_e = this.field_148243_c.func_110565_c();
/*  63 */       this.field_148240_d = p_i45007_1_.field_148251_b.func_110578_a("map/" + p_i45007_2_.field_76190_i, this.field_148243_c);
/*     */ 
/*     */       
/*  66 */       for (byte b = 0; b < this.field_148241_e.length; b++)
/*  67 */         this.field_148241_e[b] = 0; 
/*     */     }
/*     */     private final ResourceLocation field_148240_d; private final int[] field_148241_e; private static final String __OBFID = "CL_00000665";
/*     */     
/*     */     private void func_148236_a() {
/*  72 */       for (byte b = 0; b < '䀀'; b++) {
/*  73 */         int i = this.field_148242_b.field_76198_e[b] & 0xFF;
/*  74 */         if (i / 4 == 0) {
/*  75 */           this.field_148241_e[b] = (b + b / 128 & 0x1) * 8 + 16 << 24;
/*     */         } else {
/*  77 */           this.field_148241_e[b] = MapColor.field_76281_a[i / 4].func_151643_b(i & 0x3);
/*     */         } 
/*     */       } 
/*     */       
/*  81 */       this.field_148243_c.func_110564_a();
/*     */     }
/*     */     
/*     */     private void func_148237_a(boolean p_148237_1_) {
/*  85 */       byte b1 = 0;
/*  86 */       byte b2 = 0;
/*  87 */       Tessellator tessellator = Tessellator.field_78398_a;
/*     */       
/*  89 */       float f = 0.0F;
/*     */       
/*  91 */       this.field_148244_a.field_148251_b.func_110577_a(this.field_148240_d);
/*  92 */       GL11.glEnable(3042);
/*  93 */       OpenGlHelper.func_148821_a(1, 771, 0, 1);
/*  94 */       GL11.glDisable(3008);
/*  95 */       tessellator.func_78382_b();
/*  96 */       tessellator.func_78374_a(((b1 + 0) + f), ((b2 + 128) - f), -0.009999999776482582D, 0.0D, 1.0D);
/*  97 */       tessellator.func_78374_a(((b1 + 128) - f), ((b2 + 128) - f), -0.009999999776482582D, 1.0D, 1.0D);
/*  98 */       tessellator.func_78374_a(((b1 + 128) - f), ((b2 + 0) + f), -0.009999999776482582D, 1.0D, 0.0D);
/*  99 */       tessellator.func_78374_a(((b1 + 0) + f), ((b2 + 0) + f), -0.009999999776482582D, 0.0D, 0.0D);
/* 100 */       tessellator.func_78381_a();
/* 101 */       GL11.glEnable(3008);
/* 102 */       GL11.glDisable(3042);
/*     */       
/* 104 */       this.field_148244_a.field_148251_b.func_110577_a(MapItemRenderer.field_148253_a);
/* 105 */       byte b3 = 0;
/* 106 */       for (MapData.MapCoord mapCoord : this.field_148242_b.field_76203_h.values()) {
/* 107 */         if (p_148237_1_ && mapCoord.field_76216_a != 1)
/* 108 */           continue;  GL11.glPushMatrix();
/* 109 */         GL11.glTranslatef(b1 + mapCoord.field_76214_b / 2.0F + 64.0F, b2 + mapCoord.field_76215_c / 2.0F + 64.0F, -0.02F);
/* 110 */         GL11.glRotatef((mapCoord.field_76212_d * 360) / 16.0F, 0.0F, 0.0F, 1.0F);
/* 111 */         GL11.glScalef(4.0F, 4.0F, 3.0F);
/* 112 */         GL11.glTranslatef(-0.125F, 0.125F, 0.0F);
/*     */         
/* 114 */         float f1 = (mapCoord.field_76216_a % 4 + 0) / 4.0F;
/* 115 */         float f2 = (mapCoord.field_76216_a / 4 + 0) / 4.0F;
/* 116 */         float f3 = (mapCoord.field_76216_a % 4 + 1) / 4.0F;
/* 117 */         float f4 = (mapCoord.field_76216_a / 4 + 1) / 4.0F;
/*     */         
/* 119 */         tessellator.func_78382_b();
/* 120 */         tessellator.func_78374_a(-1.0D, 1.0D, (b3 * 0.001F), f1, f2);
/* 121 */         tessellator.func_78374_a(1.0D, 1.0D, (b3 * 0.001F), f3, f2);
/* 122 */         tessellator.func_78374_a(1.0D, -1.0D, (b3 * 0.001F), f3, f4);
/* 123 */         tessellator.func_78374_a(-1.0D, -1.0D, (b3 * 0.001F), f1, f4);
/* 124 */         tessellator.func_78381_a();
/* 125 */         GL11.glPopMatrix();
/* 126 */         b3++;
/*     */       } 
/*     */       
/* 129 */       GL11.glPushMatrix();
/* 130 */       GL11.glTranslatef(0.0F, 0.0F, -0.04F);
/* 131 */       GL11.glScalef(1.0F, 1.0F, 1.0F);
/* 132 */       GL11.glPopMatrix();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\gui\MapItemRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */