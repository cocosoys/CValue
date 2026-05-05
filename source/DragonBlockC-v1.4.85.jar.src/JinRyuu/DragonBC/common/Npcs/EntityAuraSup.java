/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import JinRyuu.DragonBC.common.DBCKiAttacks;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EntityAuraSup
/*     */   extends Entity
/*     */ {
/*  17 */   public int randomSoundDelay = 0;
/*     */   
/*  19 */   public int tex = 2;
/*     */   private Entity mot;
/*     */   int Age;
/*     */   int MaxAge;
/*     */   
/*  24 */   public EntityAuraSup(World par1World) { super(par1World);
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
/*  50 */     this.MaxAge = 20; } public EntityAuraSup(World par1World, Entity other) { super(par1World); this.MaxAge = 20;
/*     */     this.mot = other; } @SideOnly(Side.CLIENT)
/*     */   public float func_70053_R() {
/*     */     return 0.0F;
/*     */   } public void func_70071_h_() {
/*  55 */     if (this.mot != null) {
/*  56 */       this.field_70159_w = this.mot.field_70159_w;
/*  57 */       this.field_70181_x = this.mot.field_70181_x;
/*  58 */       this.field_70179_y = this.mot.field_70179_y;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  63 */     int x = 0;
/*  64 */     int y = 0;
/*  65 */     int z = 0;
/*  66 */     if (this.field_70170_p.func_147439_a((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v - 1).func_149688_o() == Material.field_151579_a) {
/*     */       
/*  68 */       x = (int)this.field_70165_t;
/*  69 */       y = (int)this.field_70163_u;
/*  70 */       z = (int)this.field_70161_v;
/*     */     } 
/*     */     
/*  73 */     this.field_70169_q = this.field_70165_t;
/*  74 */     this.field_70167_r = this.field_70163_u;
/*  75 */     this.field_70166_s = this.field_70161_v;
/*  76 */     if (this.Age++ >= this.MaxAge)
/*     */     {
/*     */       
/*  79 */       func_70106_y();
/*     */     }
/*     */     
/*  82 */     this.field_70181_x += 0.0D;
/*  83 */     if (this.field_70163_u == this.field_70167_r) {
/*     */       
/*  85 */       this.field_70159_w *= 1.0D;
/*  86 */       this.field_70179_y *= 1.0D;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  91 */     if (!this.field_70122_E) {
/*     */       
/*  93 */       this.field_70159_w *= DBCKiAttacks.motX;
/*  94 */       this.field_70179_y *= DBCKiAttacks.motZ;
/*  95 */       this.field_70181_x *= DBCKiAttacks.motY;
/*     */     } 
/*  97 */     func_70091_d(this.field_70159_w * 2.0D, this.field_70181_x * 2.0D, this.field_70179_y * 2.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String getTexture() {
/* 107 */     String textura = "";
/* 108 */     if (this.tex == 1)
/*     */     {
/* 110 */       textura = "jinryuudragonbc:aurab.png";
/*     */     }
/* 112 */     if (this.tex == 2)
/*     */     {
/* 114 */       textura = "jinryuudragonbc:auras.png";
/*     */     }
/* 116 */     if (this.tex == 3)
/*     */     {
/* 118 */       textura = "jinryuudragonbc:aurap.png";
/*     */     }
/* 120 */     if (this.tex == 4)
/*     */     {
/* 122 */       textura = "jinryuudragonbc:aurar.png";
/*     */     }
/* 124 */     return textura;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getCanSpawnHere() {
/* 132 */     return !this.field_70170_p.func_72855_b(this.field_70121_D);
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


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\EntityAuraSup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */