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
/*     */ 
/*     */ public class ItemDBCRender2
/*     */   implements IItemRenderer
/*     */ {
/*  18 */   protected ItemDBCModel2 model = new ItemDBCModel2();
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean handleRenderType(ItemStack item, IItemRenderer.ItemRenderType type) {
/*  23 */     switch (type) {
/*     */       case EQUIPPED:
/*  25 */         return true;
/*     */       case INVENTORY:
/*  27 */         return true;
/*     */       case ENTITY:
/*  29 */         return true;
/*     */       case EQUIPPED_FIRST_PERSON:
/*  31 */         return true;
/*     */     } 
/*  33 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ItemStack item, IItemRenderer.ItemRendererHelper helper) {
/*  39 */     return false;
/*     */   }
/*     */   public void renderItem(IItemRenderer.ItemRenderType type, ItemStack item, Object... data) {
/*     */     float h1;
/*     */     float scale;
/*  44 */     switch (type) {
/*     */       case INVENTORY:
/*  46 */         GL11.glPushMatrix();
/*     */         
/*  48 */         h1 = 1.0F;
/*  49 */         scale = 2.0F;
/*  50 */         GL11.glEnable(3042);
/*  51 */         GL11.glBlendFunc(770, 771);
/*  52 */         GL11.glScalef(scale, scale, scale);
/*  53 */         GL11.glColor3f(h1, h1, h1);
/*     */         
/*  55 */         GL11.glRotatef(45.0F, 0.0F, 0.0F, 1.0F);
/*  56 */         GL11.glTranslatef(5.5F, 0.5F, 0.0F);
/*     */ 
/*     */         
/*  59 */         JRMCoreClient.mc.field_71446_o.func_110577_a(new ResourceLocation(JRMCoreH.tjdbcAssts + ":textures/blades/E.png"));
/*     */         
/*  61 */         this.model.render();
/*     */ 
/*     */         
/*  64 */         GL11.glDisable(3042);
/*  65 */         GL11.glPopMatrix();
/*     */         break;
/*     */       
/*     */       case ENTITY:
/*  69 */         GL11.glPushMatrix();
/*  70 */         GL11.glEnable(3042);
/*  71 */         GL11.glBlendFunc(770, 771);
/*  72 */         JRMCoreClient.mc.field_71446_o.func_110577_a(new ResourceLocation(JRMCoreH.tjdbcAssts + ":textures/blades/E.png"));
/*     */         
/*  74 */         h1 = 1.0F;
/*  75 */         scale = 0.15F;
/*  76 */         GL11.glScalef(scale, scale, scale);
/*  77 */         GL11.glColor3f(h1, h1, h1);
/*  78 */         GL11.glRotatef(-140.0F, 0.0F, 0.0F, 1.0F);
/*  79 */         GL11.glTranslatef(-1.9F, -1.0F, -0.2F);
/*  80 */         this.model.render();
/*     */         
/*  82 */         GL11.glDisable(3042);
/*  83 */         GL11.glPopMatrix();
/*     */         break;
/*     */ 
/*     */       
/*     */       case EQUIPPED:
/*     */       case EQUIPPED_FIRST_PERSON:
/*  89 */         GL11.glPushMatrix();
/*  90 */         GL11.glEnable(3042);
/*  91 */         GL11.glBlendFunc(770, 771);
/*  92 */         JRMCoreClient.mc.field_71446_o.func_110577_a(new ResourceLocation(JRMCoreH.tjdbcAssts + ":textures/blades/E.png"));
/*     */         
/*  94 */         h1 = 1.0F;
/*  95 */         scale = 0.3F;
/*  96 */         GL11.glScalef(scale, scale, scale);
/*  97 */         GL11.glColor3f(h1, h1, h1);
/*  98 */         GL11.glRotatef(-140.0F, 0.0F, 0.0F, 1.0F);
/*  99 */         GL11.glTranslatef(-2.5F, 0.2F, -0.2F);
/* 100 */         this.model.render();
/*     */         
/* 102 */         GL11.glDisable(3042);
/* 103 */         GL11.glPopMatrix();
/*     */         break;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Items\ItemDBCRender2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */