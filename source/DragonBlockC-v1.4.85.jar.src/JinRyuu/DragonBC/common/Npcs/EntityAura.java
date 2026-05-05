/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class EntityAura
/*     */   extends Entity
/*     */ {
/*  20 */   public int randomSoundDelay = 0;
/*     */   public long lightVert; private int lightLivingTime; private String mot; private boolean rot; private int Age; private int color; private int colorl2; private float state; private float state2; private int crel; private float yaw; private float pitch;
/*     */   private float alpha;
/*     */   private String tex;
/*     */   private String texl2;
/*     */   private int speed;
/*     */   private boolean inner;
/*     */   private int rendpass;
/*     */   
/*  29 */   public int getLightLivingTime() { return this.lightLivingTime; }
/*     */   public EntityAura(World par1World, String dbcCharger, int c, float s, float s2, int cr, boolean b, float a) { this(par1World, dbcCharger, c, s, s2, cr, b);
/*     */     this.alpha = a; }
/*     */   public EntityAura(World par1World, String dbcCharger, int c, float s, float s2, int cr, boolean b) { this(par1World, dbcCharger, c, s, s2, cr);
/*     */     this.rot = b; }
/*  34 */   public EntityAura(World par1World) { super(par1World);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  42 */     this.mot = "";
/*     */     
/*  44 */     this.rot = false;
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
/*  87 */     this.color = 16777215;
/*  88 */     this.colorl2 = 16777215;
/*  89 */     this.state = 0.0F;
/*  90 */     this.state2 = 0.0F;
/*  91 */     this.crel = 0;
/*  92 */     this.yaw = 0.0F;
/*  93 */     this.pitch = 0.0F;
/*  94 */     this.alpha = 0.1F;
/*  95 */     this.tex = "aura";
/*  96 */     this.texl2 = "";
/*  97 */     this.speed = 20;
/*  98 */     this.inner = true;
/*  99 */     this.rendpass = 1; } public EntityAura(World par1World, String dbcCharger, int c, float s, float s2, int cr) { super(par1World); this.mot = ""; this.rot = false; this.color = 16777215; this.colorl2 = 16777215; this.state = 0.0F; this.state2 = 0.0F; this.crel = 0; this.yaw = 0.0F; this.pitch = 0.0F; this.alpha = 0.1F; this.tex = "aura"; this.texl2 = ""; this.speed = 20; this.inner = true; this.rendpass = 1; this.mot = dbcCharger; this.color = c; this.state = s; this.state2 = s2; this.crel = cr; this.lightVert = this.field_70146_Z.nextLong();
/*     */     this.lightLivingTime = this.field_70146_Z.nextInt(4) + 0; } public boolean shouldRenderInPass(int pass) { return (pass == this.rendpass); }
/*     */   @SideOnly(Side.CLIENT) public float func_70053_R() { return 0.0F; }
/* 102 */   public boolean getRot() { return this.rot; }
/*     */    public float getYaw() {
/* 104 */     return this.yaw;
/*     */   } public float getPitch() {
/* 106 */     return this.pitch;
/*     */   } public int getAge() {
/* 108 */     return this.Age;
/*     */   } public float getState() {
/* 110 */     return this.state;
/*     */   } public float getState2() {
/* 112 */     return this.state2;
/*     */   } public float getCRel() {
/* 114 */     return this.crel;
/*     */   } public int getCol() {
/* 116 */     return this.color;
/*     */   } public void setCol(int c) {
/* 118 */     this.color = c;
/*     */   } public int getColL2() {
/* 120 */     return this.colorl2;
/*     */   } public void setColL2(int c) {
/* 122 */     this.colorl2 = c;
/*     */   } public float getAlp() {
/* 124 */     return this.alpha;
/*     */   } public void setAlp(float f) {
/* 126 */     this.alpha = f;
/*     */   } public String getTex() {
/* 128 */     return this.tex;
/*     */   } public void setTex(String s) {
/* 130 */     this.tex = s;
/*     */   } public String getTexL2() {
/* 132 */     return this.texl2;
/*     */   } public void setTexL2(String s) {
/* 134 */     this.texl2 = s;
/*     */   } public int getSpd() {
/* 136 */     return this.speed;
/*     */   } public void setSpd(int s) {
/* 138 */     this.speed = s;
/*     */   } public boolean getInner() {
/* 140 */     return this.inner;
/*     */   } public void setInner(boolean s) {
/* 142 */     this.inner = s;
/*     */   } public void setRendPass(int s) {
/* 144 */     this.rendpass = s;
/*     */   } public String getmot() {
/* 146 */     return this.mot;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70071_h_() {
/* 152 */     if (this.mot.length() > 1) {
/* 153 */       EntityPlayer entityPlayer = this.field_70170_p.func_72924_a(this.mot);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 158 */       if (entityPlayer != null) {
/* 159 */         if (this.rot) {
/* 160 */           this.yaw = ((Entity)entityPlayer).field_70177_z;
/* 161 */           this.pitch = ((Entity)entityPlayer).field_70125_A;
/*     */         } 
/* 163 */         func_70012_b(((Entity)entityPlayer).field_70165_t, ((Entity)entityPlayer).field_70163_u + ((entityPlayer instanceof net.minecraft.client.entity.EntityPlayerSP) ? -1.6F : 0.0F), ((Entity)entityPlayer).field_70161_v, ((Entity)entityPlayer).field_70177_z, ((Entity)entityPlayer).field_70125_A);
/* 164 */         if (getAge() < getLightLivingTime() && getState() > 4.0F && getState() < 7.0F)
/*     */         {
/*     */           
/* 167 */           if (getAge() == 2) {
/* 168 */             entityPlayer.func_85030_a("jinryuudragonbc:1610.spark", 0.0375F, 0.85F + this.lightLivingTime * 0.05F);
/*     */           }
/*     */         }
/*     */       } else {
/*     */         
/* 173 */         func_70106_y();
/*     */       } 
/*     */     } 
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
/* 194 */     if (this.Age++ >= this.speed)
/*     */     {
/*     */       
/* 197 */       func_70106_y();
/*     */     }
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
/* 250 */     return !this.field_70170_p.func_72855_b(this.field_70121_D);
/*     */   }
/*     */   
/*     */   public void onLivingUpdate() {}
/*     */   
/*     */   protected void func_70037_a(NBTTagCompound var1) {}
/*     */   
/*     */   protected void func_70014_b(NBTTagCompound var1) {}
/*     */   
/*     */   protected void func_70088_a() {}
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\EntityAura.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */