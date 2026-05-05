/*     */ package JinRyuu.JRMCore.entity;
/*     */ 
/*     */ import JinRyuu.JRMCore.m.mEnergy;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RenderEnergyAttack<E extends Entity>
/*     */   extends RenderJRMC
/*     */ {
/*  17 */   public final byte DBC = 0, NARUTO_C = 1, DBC_CHARGE = 2;
/*  18 */   public final byte FIRE = 0, WIND = 1, LIGHTNING = 2, EARTH = 3, WATER = 4;
/*  19 */   public final byte WAVE = 0; public final byte BLAST = 1; public final byte DISK = 2; public final byte LASER = 3; public final byte SPIRAL = 4; public final byte LARGE = 5; public final byte BARRAGE = 6; public final byte SHIELD = 7; public final byte EXPLOSION = 8;
/*     */   
/*  21 */   public final String[] texture_type = new String[] { "wave", "blast", "disk", "laser", "spiral", "blast", "blast", "shield", "explosion" };
/*  22 */   public final String[] texture_element = new String[] { "fire", "wind", "lightning", "earth", "water" };
/*     */   
/*  24 */   public final String TEXTURE_HEAD = "head", TEXTURE_HEAD2 = "head_connect";
/*  25 */   public final String TEXTURE_MIDDLE = "middle", TEXTURE_NOISE = "noise";
/*  26 */   public final String TEXTURE_TAIL = "tail"; public final String TEXTURE_TAIL2 = "tail_connect";
/*     */   
/*     */   public byte mode;
/*     */   
/*     */   public float rotationSpeed;
/*     */   
/*     */   public double modifierTranslation;
/*     */   
/*     */   public double endSize;
/*     */   
/*     */   public int detail;
/*     */   
/*     */   public int brightness;
/*     */   
/*     */   public float red;
/*     */   
/*     */   public float green;
/*     */   
/*     */   public float blue;
/*     */   public float red2;
/*     */   public float green2;
/*     */   public float blue2;
/*     */   public float alpha;
/*  49 */   public final byte RENDER_NORMAL = 0; public float scale_head; public float scale_head_connect; public float scale_middle; public float scale_noise; public float scale_tail; public float scale_tail_connect; public boolean render_head; public boolean render_head_connect; public boolean render_middle; public boolean render_noise; public boolean render_tail; public boolean render_tail_connect; public byte rendermode_tail; public final byte RENDER_DISK = 1; public final byte RENDER_SHIELD = 2; public boolean rotate_head;
/*     */   public boolean rotate_head_connect;
/*     */   public boolean rotate_middle;
/*     */   public boolean rotate_noise;
/*     */   public boolean rotate_tail;
/*     */   public boolean rotate_tail_connect;
/*     */   public boolean scaling_head;
/*     */   public boolean scaling_tail;
/*     */   public float scale_head_more;
/*     */   public float scale_tail_more;
/*     */   public boolean head_follow;
/*     */   public boolean tail_follow;
/*     */   public boolean random_texture;
/*  62 */   public final String TEXTURE_FOLDER = "jinryuumodscore:textures/fx/";
/*     */ 
/*     */   
/*     */   public String texture;
/*     */   
/*     */   public boolean transparent;
/*     */ 
/*     */   
/*     */   public RenderEnergyAttack() {
/*  71 */     super((ModelBase)new mEnergy(), 0.5F);
/*     */   }
/*     */   
/*     */   public void func_76986_a(Entity entity, double par2, double par4, double par6, float par8, float par9) {
/*  75 */     this.field_76989_e = 0.0F;
/*  76 */     renderEnergy((E)entity, par2, par4, par6, par8, par9);
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderEnergy(E entity, double par2, double par4, double par6, float par8, float par9) {}
/*     */   
/*     */   public void updateEffect(E entity) {}
/*     */   
/*     */   public void updateEffect2(E entity) {}
/*     */   
/*     */   public void setVisuals(E entity, byte type, short effect, int color, int color2, float scale, byte mode) {}
/*     */   
/*     */   public ResourceLocation set_resource(String texture, int id) {
/*  89 */     return new ResourceLocation("jinryuumodscore:textures/fx/" + this.texture + texture + ((id > 0) ? (String)Integer.valueOf(id) : "") + ".png");
/*     */   } public void apply_detail_rotation(int id) {
/*  91 */     GL11.glRotatef((id * 360 / this.detail), 0.0F, 1.0F, 0.0F);
/*     */   }
/*     */   protected float handleRotationFloat(Entity entity, float par2) {
/*  94 */     return entity.field_70173_aa + par2;
/*     */   }
/*     */   
/*     */   public void setColors(int color, float alpha) {
/*  98 */     this.red = (color >> 16 & 0xFF) / 255.0F;
/*  99 */     this.green = (color >> 8 & 0xFF) / 255.0F;
/* 100 */     this.blue = (color & 0xFF) / 255.0F;
/* 101 */     this.alpha = alpha;
/*     */   }
/*     */   
/*     */   public void setColors2(int color) {
/* 105 */     this.red2 = (color >> 16 & 0xFF) / 255.0F;
/* 106 */     this.green2 = (color >> 8 & 0xFF) / 255.0F;
/* 107 */     this.blue2 = (color & 0xFF) / 255.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void glStart(E entity, double par2, double par4, double par6, float par9) {
/* 114 */     glStart();
/* 115 */     glRotate(entity, par2, par4, par6, par9);
/*     */   }
/*     */   
/*     */   public void glRotate(E entity, double par2, double par4, double par6, float par9) {
/* 119 */     GL11.glTranslatef((float)par2, (float)par4, (float)par6);
/* 120 */     GL11.glRotatef(((Entity)entity).field_70126_B + (((Entity)entity).field_70177_z - ((Entity)entity).field_70126_B) * par9 - 180.0F, 0.0F, 1.0F, 0.0F);
/* 121 */     GL11.glRotatef(((Entity)entity).field_70127_C + (((Entity)entity).field_70125_A - ((Entity)entity).field_70127_C) * par9, 1.0F, 0.0F, 0.0F);
/* 122 */     GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
/*     */   }
/*     */   
/*     */   public void glStart() {
/* 126 */     GL11.glPushMatrix();
/* 127 */     GL11.glEnable(2977);
/* 128 */     GL11.glEnable(3042);
/* 129 */     GL11.glBlendFunc(770, 771);
/*     */   }
/*     */   
/*     */   public void glEnd() {
/* 133 */     GL11.glDisable(3042);
/* 134 */     GL11.glDisable(2977);
/* 135 */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */   public void render_2d(E entity, double par2, double par4, double par6, float par8, float par9, float scale, double sx, double sy, double sz, int color, float rotation) {}
/*     */   
/*     */   public void render_3d(E entity, double par2, double par4, double par6, float par8, float par9, float scale, double sx, double sy, double sz, int color, float rotation) {}
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\entity\RenderEnergyAttack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */