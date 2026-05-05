/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import JinRyuu.DragonBC.common.DBCKiAttacks;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class EntityAuraLightning
/*     */   extends Entity
/*     */ {
/*  18 */   public int randomSoundDelay = 0;
/*     */   
/*  20 */   public int tex = 1;
/*     */   private Entity mot;
/*     */   int Age;
/*     */   int MaxAge;
/*     */   
/*  25 */   public EntityAuraLightning(World par1World) { super(par1World);
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
/*  52 */     this.MaxAge = 7; this.field_70131_O = 4.0F; this.field_70130_N = 4.0F; } public EntityAuraLightning(World par1World, Entity other) { super(par1World); this.MaxAge = 7;
/*     */     this.mot = other; } @SideOnly(Side.CLIENT)
/*     */   public float func_70053_R() {
/*     */     return 0.0F;
/*     */   } public void func_70071_h_() {
/*  57 */     if (this.mot != null) {
/*  58 */       this.field_70159_w = this.mot.field_70159_w;
/*  59 */       this.field_70181_x = this.mot.field_70181_x;
/*  60 */       this.field_70179_y = this.mot.field_70179_y;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  66 */     this.field_70169_q = this.field_70165_t;
/*  67 */     this.field_70167_r = this.field_70163_u;
/*  68 */     this.field_70166_s = this.field_70161_v;
/*  69 */     if (this.Age++ >= this.MaxAge)
/*     */     {
/*  71 */       func_70106_y();
/*     */     }
/*     */     
/*  74 */     this.field_70181_x += 0.0D;
/*  75 */     if (this.field_70163_u == this.field_70167_r) {
/*     */       
/*  77 */       this.field_70159_w *= 1.0D;
/*  78 */       this.field_70179_y *= 1.0D;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  83 */     if (!this.field_70122_E) {
/*     */       
/*  85 */       this.field_70159_w *= DBCKiAttacks.motX;
/*  86 */       this.field_70179_y *= DBCKiAttacks.motZ;
/*  87 */       this.field_70181_x *= DBCKiAttacks.motY;
/*     */     } 
/*  89 */     func_70091_d(this.field_70159_w * 2.0D, this.field_70181_x * 2.0D, this.field_70179_y * 2.0D);
/*     */   }
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
/*     */   public boolean getCanSpawnHere() {
/* 124 */     return !this.field_70170_p.func_72855_b(this.field_70121_D);
/*     */   }
/*     */   
/*     */   public void onLivingUpdate() {}
/*     */   
/*     */   protected void func_70088_a() {}
/*     */   
/*     */   protected void func_70037_a(NBTTagCompound var1) {}
/*     */   
/*     */   protected void func_70014_b(NBTTagCompound var1) {}
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\EntityAuraLightning.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */