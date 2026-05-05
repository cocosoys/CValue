/*     */ package JinRyuu.DragonBC.common.Items;
/*     */ 
/*     */ import JinRyuu.JRMCore.JRMCoreClient;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraftforge.client.IItemRenderer;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ public class ItemDBCRender
/*     */   implements IItemRenderer
/*     */ {
/*     */   protected ItemKatanaModel model;
/*     */   protected ItemKatanaModel2 model2;
/*     */   protected String t;
/*     */   
/*     */   public ItemDBCRender(String type) {
/*  17 */     this.model = new ItemKatanaModel();
/*  18 */     this.model2 = new ItemKatanaModel2();
/*  19 */     this.t = type;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean handleRenderType(ItemStack item, IItemRenderer.ItemRenderType type) {
/*  26 */     switch (type) {
/*     */       case EQUIPPED:
/*  28 */         return true;
/*     */       case INVENTORY:
/*  30 */         return true;
/*     */       case ENTITY:
/*  32 */         return true;
/*     */       case EQUIPPED_FIRST_PERSON:
/*  34 */         return true;
/*     */     } 
/*  36 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ItemStack item, IItemRenderer.ItemRendererHelper helper) {
/*  44 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderItem(IItemRenderer.ItemRenderType type, ItemStack item, Object... data) {
/*     */     float h1;
/*     */     float scale;
/*  53 */     switch (type) {
/*     */       case INVENTORY:
/*  55 */         GL11.glPushMatrix();
/*     */         
/*  57 */         h1 = 1.0F;
/*  58 */         scale = 10.0F;
/*  59 */         GL11.glEnable(3042);
/*  60 */         GL11.glBlendFunc(770, 771);
/*  61 */         GL11.glScalef(scale, scale, scale);
/*  62 */         GL11.glColor3f(h1, h1, h1);
/*     */         
/*  64 */         GL11.glRotatef(45.0F, 0.0F, 0.0F, 1.0F);
/*  65 */         GL11.glTranslatef(1.1F, -0.4F, -0.0F);
/*     */         
/*  67 */         if (this.t.equals("Z")) {
/*  68 */           float scl = 0.7F;
/*  69 */           GL11.glTranslatef(0.0F, 0.53F, -0.0F);
/*  70 */           GL11.glScalef(scl, scl, scl);
/*     */         } 
/*     */ 
/*     */         
/*  74 */         JRMCoreClient.mc.field_71446_o.func_110577_a(new ResourceLocation("jinryuudragonbc:textures/blades/" + this.t + ".png"));
/*     */         
/*  76 */         if (this.t.equals("Z")) { this.model2.render(); }
/*  77 */         else { this.model.render(this.t); }
/*     */ 
/*     */         
/*  80 */         GL11.glDisable(3042);
/*  81 */         GL11.glPopMatrix();
/*     */         break;
/*     */ 
/*     */       
/*     */       case ENTITY:
/*  86 */         GL11.glPushMatrix();
/*  87 */         GL11.glDisable(2884);
/*  88 */         GL11.glEnable(3042);
/*  89 */         GL11.glBlendFunc(770, 771);
/*  90 */         JRMCoreClient.mc.field_71446_o.func_110577_a(new ResourceLocation("jinryuudragonbc:textures/blades/" + this.t + ".png"));
/*  91 */         h1 = 1.0F;
/*  92 */         scale = 0.65F;
/*  93 */         GL11.glScalef(scale, scale, scale);
/*  94 */         GL11.glColor3f(h1, h1, h1);
/*  95 */         GL11.glRotatef(-140.0F, 0.0F, 0.0F, 1.0F);
/*  96 */         GL11.glTranslatef(-0.4F, -0.7F, -0.0F);
/*     */         
/*  98 */         if (this.t.equals("Z")) {
/*  99 */           float scl = 0.8F;
/* 100 */           GL11.glTranslatef(0.0F, 0.42999998F, -0.0F);
/* 101 */           GL11.glScalef(scl, scl, scl);
/*     */         } 
/*     */         
/* 104 */         if (this.t.equals("Z")) { this.model2.render(); }
/* 105 */         else { this.model.render(this.t); }
/*     */         
/* 107 */         GL11.glDisable(3042);
/* 108 */         GL11.glPopMatrix();
/*     */         break;
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
/*     */       case EQUIPPED:
/*     */       case EQUIPPED_FIRST_PERSON:
/* 135 */         GL11.glPushMatrix();
/* 136 */         GL11.glDisable(2884);
/* 137 */         GL11.glEnable(3042);
/* 138 */         GL11.glBlendFunc(770, 771);
/* 139 */         JRMCoreClient.mc.field_71446_o.func_110577_a(new ResourceLocation("jinryuudragonbc:textures/blades/" + this.t + ".png"));
/* 140 */         h1 = 1.0F;
/* 141 */         scale = 1.0F;
/* 142 */         GL11.glScalef(scale, scale, scale);
/* 143 */         GL11.glColor3f(h1, h1, h1);
/* 144 */         GL11.glRotatef(-140.0F, 0.0F, 0.0F, 1.0F);
/* 145 */         GL11.glTranslatef(-0.8F, -0.75F, -0.0F);
/*     */ 
/*     */         
/* 148 */         if (this.t.equals("Z")) {
/* 149 */           float scl = 0.8F;
/* 150 */           GL11.glTranslatef(0.0F, 0.42999998F, -0.0F);
/* 151 */           GL11.glScalef(scl, scl, scl);
/*     */         } 
/*     */         
/* 154 */         if (this.t.equals("Z")) { this.model2.render(); }
/* 155 */         else { this.model.render(this.t); }
/*     */         
/* 157 */         GL11.glDisable(3042);
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
/* 170 */         GL11.glPopMatrix();
/*     */         break;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Items\ItemDBCRender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */