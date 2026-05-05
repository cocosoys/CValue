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
/*     */ public class EntityAuraPur
/*     */   extends Entity
/*     */ {
/*  17 */   public int randomSoundDelay = 0;
/*     */   
/*  19 */   public int tex = 3;
/*     */   private Entity mot;
/*     */   int Age;
/*     */   int MaxAge;
/*     */   
/*  24 */   public EntityAuraPur(World par1World) { super(par1World);
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
/*  51 */     this.MaxAge = 20; } public EntityAuraPur(World par1World, Entity other) { super(par1World); this.MaxAge = 20;
/*     */     this.mot = other; } @SideOnly(Side.CLIENT)
/*     */   public float func_70053_R() {
/*     */     return 0.0F;
/*     */   } public void func_70071_h_() {
/*  56 */     if (this.mot != null) {
/*  57 */       this.field_70159_w = this.mot.field_70159_w;
/*  58 */       this.field_70181_x = this.mot.field_70181_x;
/*  59 */       this.field_70179_y = this.mot.field_70179_y;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  64 */     boolean doit = false;
/*  65 */     int x = 0;
/*  66 */     int y = 0;
/*  67 */     int z = 0;
/*  68 */     if (this.field_70170_p.func_147439_a((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v - 1).func_149688_o() == Material.field_151579_a) {
/*  69 */       doit = true;
/*     */       
/*  71 */       x = (int)this.field_70165_t;
/*  72 */       y = (int)this.field_70163_u;
/*  73 */       z = (int)this.field_70161_v;
/*     */     } 
/*     */     
/*  76 */     this.field_70169_q = this.field_70165_t;
/*  77 */     this.field_70167_r = this.field_70163_u;
/*  78 */     this.field_70166_s = this.field_70161_v;
/*  79 */     if (this.Age++ >= this.MaxAge) {
/*     */       
/*  81 */       if (doit);
/*     */ 
/*     */       
/*  84 */       func_70106_y();
/*     */     } 
/*     */     
/*  87 */     this.field_70181_x += 0.0D;
/*  88 */     if (this.field_70163_u == this.field_70167_r) {
/*     */       
/*  90 */       this.field_70159_w *= 1.0D;
/*  91 */       this.field_70179_y *= 1.0D;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  96 */     if (!this.field_70122_E) {
/*     */       
/*  98 */       this.field_70159_w *= DBCKiAttacks.motX;
/*  99 */       this.field_70179_y *= DBCKiAttacks.motZ;
/* 100 */       this.field_70181_x *= DBCKiAttacks.motY;
/*     */     } 
/* 102 */     func_70091_d(this.field_70159_w * 2.0D, this.field_70181_x * 2.0D, this.field_70179_y * 2.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String getTexture() {
/* 112 */     String textura = "";
/* 113 */     if (this.tex == 1)
/*     */     {
/* 115 */       textura = "jinryuudragonbc:aurab.png";
/*     */     }
/* 117 */     if (this.tex == 2)
/*     */     {
/* 119 */       textura = "jinryuudragonbc:auras.png";
/*     */     }
/* 121 */     if (this.tex == 3)
/*     */     {
/* 123 */       textura = "jinryuudragonbc:aurap.png";
/*     */     }
/* 125 */     if (this.tex == 4)
/*     */     {
/* 127 */       textura = "jinryuudragonbc:aurar.png";
/*     */     }
/* 129 */     return textura;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getCanSpawnHere() {
/* 137 */     return !this.field_70170_p.func_72855_b(this.field_70121_D);
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


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\EntityAuraPur.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */