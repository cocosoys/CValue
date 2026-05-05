/*    */ package JinRyuu.JRMCore.entity;
/*    */ 
/*    */ import JinRyuu.JRMCore.JRMCoreGuiScreen;
/*    */ import JinRyuu.JRMCore.JRMCoreH;
/*    */ import JinRyuu.JRMCore.manager.AttributeArray;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.awt.Color;
/*    */ import java.time.Duration;
/*    */ import java.time.Instant;
/*    */ import java.util.Random;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class EntityAuraFlat
/*    */   extends EntityLiving
/*    */ {
/* 23 */   private final float LIFE = 0.5F;
/*    */   
/*    */   public AttributeArray array;
/*    */   
/*    */   public AttributeArray transparency;
/*    */   
/*    */   private Instant spawnTime;
/*    */   
/*    */   private float age;
/*    */   private boolean directionX;
/*    */   
/*    */   public EntityAuraFlat(World w) {
/* 35 */     super(w);
/* 36 */     Random r = new Random();
/* 37 */     float ARRAY_SPEED = 2.0F;
/* 38 */     this.transparency = new AttributeArray(new float[] { 0.0F, 0.0F, 0.125F, 0.7F, 0.25F, 0.0F });
/* 39 */     Color base = new Color(191, 215, 255);
/* 40 */     Color kk = new Color(235, 65, 35);
/* 41 */     Color ssj = new Color(255, 237, 117);
/* 42 */     Color god = new Color(250, 36, 25);
/* 43 */     Color blue = new Color(25, 205, 250);
/*    */     
/* 45 */     float combo = JRMCoreGuiScreen.instance.miniGameAirBoxing.comboCounter;
/* 46 */     this.aura = (combo >= 200.0F) ? blue : ((combo >= 150.0F) ? god : ((combo >= 100.0F) ? ssj : ((combo >= 50.0F) ? kk : base)));
/*    */     
/* 48 */     this.auraID = (combo >= 150.0F) ? 4 : (byte)(r.nextInt(3) + 1);
/* 49 */     this.texture = new ResourceLocation(JRMCoreH.tjjrmc + ":textures/auras/auraflat" + this.auraID + ".png");
/*    */     
/* 51 */     float auraSpeed = (combo >= 150.0F) ? 0.35F : 1.0F;
/* 52 */     this.array = new AttributeArray(new float[] { 0.0F, 0.0F, 0.125F, 1.0F * auraSpeed, 0.25F, 2.0F * auraSpeed });
/*    */ 
/*    */     
/* 55 */     this.spawnTime = Instant.now();
/* 56 */     this.age = 0.0F;
/* 57 */     boolean xz = r.nextBoolean();
/* 58 */     this.lrX = r.nextBoolean();
/* 59 */     this.lrZ = r.nextBoolean();
/* 60 */     float value = (r.nextInt(1000) / 100.0F - 5.0F) / 4.0F;
/* 61 */     float limit = 1.25F;
/* 62 */     this.field_70165_t = ((xz ? value : 1.25F) * (this.lrX ? -1 : true));
/* 63 */     this.startY = -(r.nextInt(1000) / 100.0F - 5.0F) / 3.0F + 2.0F;
/* 64 */     this.field_70161_v = ((!xz ? value : 1.25F) * (this.lrZ ? -1 : true));
/* 65 */     this.directionX = xz;
/*    */   }
/*    */   private boolean lrX; private boolean lrZ; private float startY; public Color aura; private byte auraID; private ResourceLocation texture;
/*    */   public void update() {
/* 69 */     this.age += (float)Duration.between(this.spawnTime, Instant.now()).toMillis() / 1000.0F;
/* 70 */     this.array.update(this.age);
/* 71 */     this.transparency.update(this.age);
/* 72 */     this.spawnTime = Instant.now();
/* 73 */     if (this.age >= 0.25F) func_70106_y(); 
/* 74 */     this.field_70163_u = (this.startY - this.array.lastValue);
/* 75 */     if (!this.directionX) { this.field_70165_t = (this.array.lastValue * (this.lrX ? -1 : true)); }
/* 76 */     else { this.field_70161_v = (this.array.lastValue * (this.lrZ ? -1 : true)); }
/*    */   
/*    */   }
/*    */   public ResourceLocation getTexture() {
/* 80 */     return this.texture;
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\entity\EntityAuraFlat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */