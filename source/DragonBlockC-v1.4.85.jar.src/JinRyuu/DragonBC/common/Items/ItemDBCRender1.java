/*     */ package JinRyuu.DragonBC.common.Items;
/*     */ 
/*     */ import JinRyuu.JRMCore.JRMCoreClient;
/*     */ import JinRyuu.JRMCore.JRMCoreH;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraftforge.client.IItemRenderer;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ItemDBCRender1
/*     */   implements IItemRenderer
/*     */ {
/*  17 */   protected ItemDBCModel1 model = new ItemDBCModel1();
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean handleRenderType(ItemStack item, IItemRenderer.ItemRenderType type) {
/*  22 */     switch (type) {
/*     */       case EQUIPPED:
/*  24 */         return true;
/*     */       case INVENTORY:
/*  26 */         return true;
/*     */       case ENTITY:
/*  28 */         return true;
/*     */       case EQUIPPED_FIRST_PERSON:
/*  30 */         return true;
/*     */     } 
/*  32 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ItemStack item, IItemRenderer.ItemRendererHelper helper) {
/*  38 */     return false;
/*     */   }
/*     */   public void renderItem(IItemRenderer.ItemRenderType type, ItemStack item, Object... data) {
/*     */     float h1;
/*     */     float scale;
/*  43 */     switch (type) {
/*     */       case INVENTORY:
/*  45 */         GL11.glPushMatrix();
/*     */         
/*  47 */         h1 = 1.0F;
/*  48 */         scale = 2.5F;
/*  49 */         GL11.glEnable(3042);
/*  50 */         GL11.glBlendFunc(770, 771);
/*  51 */         GL11.glScalef(scale, scale, scale);
/*  52 */         GL11.glColor3f(h1, h1, h1);
/*     */         
/*  54 */         GL11.glRotatef(45.0F, 0.0F, 0.0F, 1.0F);
/*  55 */         GL11.glTranslatef(4.5F, 2.2F, 0.0F);
/*     */ 
/*     */ 
/*     */         
/*  59 */         JRMCoreClient.mc.field_71446_o.func_110577_a(new ResourceLocation(JRMCoreH.tjdbcAssts + ":textures/blades/D.png"));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*  67 */         this.model.render();
/*     */ 
/*     */         
/*  70 */         GL11.glDisable(3042);
/*  71 */         GL11.glPopMatrix();
/*     */         break;
/*     */       
/*     */       case ENTITY:
/*  75 */         GL11.glPushMatrix();
/*  76 */         GL11.glEnable(3042);
/*  77 */         GL11.glBlendFunc(770, 771);
/*  78 */         JRMCoreClient.mc.field_71446_o.func_110577_a(new ResourceLocation(JRMCoreH.tjdbcAssts + ":textures/blades/D.png"));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*  85 */         h1 = 1.0F;
/*  86 */         scale = 0.2F;
/*  87 */         GL11.glScalef(scale, scale, scale);
/*     */         
/*  89 */         GL11.glColor3f(h1, h1, h1);
/*  90 */         GL11.glRotatef(-140.0F, 0.0F, 0.0F, 1.0F);
/*  91 */         GL11.glTranslatef(-1.4F, 1.0F, -0.2F);
/*  92 */         this.model.render();
/*     */         
/*  94 */         GL11.glDisable(3042);
/*  95 */         GL11.glPopMatrix();
/*     */         break;
/*     */ 
/*     */       
/*     */       case EQUIPPED:
/*     */       case EQUIPPED_FIRST_PERSON:
/* 101 */         GL11.glPushMatrix();
/* 102 */         GL11.glEnable(3042);
/* 103 */         GL11.glBlendFunc(770, 771);
/* 104 */         JRMCoreClient.mc.field_71446_o.func_110577_a(new ResourceLocation(JRMCoreH.tjdbcAssts + ":textures/blades/D.png"));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 111 */         h1 = 1.0F;
/* 112 */         scale = 0.3F;
/* 113 */         GL11.glScalef(scale, scale, scale);
/*     */         
/* 115 */         GL11.glColor3f(h1, h1, h1);
/* 116 */         GL11.glRotatef(-140.0F, 0.0F, 0.0F, 1.0F);
/* 117 */         GL11.glTranslatef(-2.5F, 0.2F, -0.2F);
/* 118 */         this.model.render();
/*     */         
/* 120 */         GL11.glDisable(3042);
/* 121 */         GL11.glPopMatrix();
/*     */         break;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Items\ItemDBCRender1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */