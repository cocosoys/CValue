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
/*     */ public class ItemWeaponRender2
/*     */   implements IItemRenderer
/*     */ {
/*  17 */   protected Itemm mod = new Itemppm();
/*  18 */   private String t = "P";
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
/*     */ 
/*     */   
/*     */   public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ItemStack item, IItemRenderer.ItemRendererHelper helper) {
/*  41 */     return false;
/*     */   }
/*     */   
/*     */   public void renderItem(IItemRenderer.ItemRenderType type, ItemStack item, Object... data) {
/*     */     float h1;
/*     */     float scale;
/*  47 */     switch (type) {
/*     */       case INVENTORY:
/*  49 */         GL11.glPushMatrix();
/*     */         
/*  51 */         h1 = 1.0F;
/*  52 */         scale = 14.0F;
/*  53 */         GL11.glEnable(3042);
/*  54 */         GL11.glBlendFunc(770, 771);
/*  55 */         GL11.glScalef(scale, scale, scale);
/*  56 */         GL11.glColor3f(h1, h1, h1);
/*     */         
/*  58 */         GL11.glRotatef(45.0F, 0.0F, 0.0F, 1.0F);
/*     */ 
/*     */ 
/*     */         
/*  62 */         GL11.glTranslatef(0.8F, 0.1F, -0.0F);
/*     */ 
/*     */         
/*  65 */         JRMCoreClient.mc.field_71446_o.func_110577_a(new ResourceLocation(JRMCoreH.tjdbcAssts + ":textures/blades/" + this.t + ".png"));
/*     */         
/*  67 */         this.mod.render(this.t);
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
/*  78 */         JRMCoreClient.mc.field_71446_o.func_110577_a(new ResourceLocation(JRMCoreH.tjdbcAssts + ":textures/blades/" + this.t + ".png"));
/*  79 */         h1 = 1.0F;
/*  80 */         scale = 1.0F;
/*  81 */         GL11.glScalef(scale, scale, scale);
/*  82 */         GL11.glColor3f(h1, h1, h1);
/*  83 */         GL11.glRotatef(-140.0F, 0.0F, 0.0F, 1.0F);
/*  84 */         GL11.glTranslatef(-0.2F, -0.2F, 0.025F);
/*  85 */         this.mod.render(this.t);
/*     */         
/*  87 */         GL11.glDisable(3042);
/*  88 */         GL11.glPopMatrix();
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
/* 115 */         GL11.glPushMatrix();
/* 116 */         GL11.glEnable(3042);
/* 117 */         GL11.glBlendFunc(770, 771);
/* 118 */         JRMCoreClient.mc.field_71446_o.func_110577_a(new ResourceLocation(JRMCoreH.tjdbcAssts + ":textures/blades/" + this.t + ".png"));
/* 119 */         h1 = 1.0F;
/* 120 */         scale = 1.0F;
/* 121 */         GL11.glScalef(scale, scale, scale);
/* 122 */         GL11.glColor3f(h1, h1, h1);
/* 123 */         GL11.glRotatef(-145.0F, 0.0F, 0.0F, 1.0F);
/* 124 */         GL11.glTranslatef(-0.77F, 0.17F, 0.025F);
/* 125 */         this.mod.render(this.t);
/*     */         
/* 127 */         GL11.glDisable(3042);
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
/* 140 */         GL11.glPopMatrix();
/*     */         break;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Items\ItemWeaponRender2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */