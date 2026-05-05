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
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class EntityAuraRing
/*     */   extends Entity
/*     */ {
/*  18 */   public int randomSoundDelay = 0;
/*     */   
/*  20 */   public int tex = 1;
/*     */   private String mot; int Age; int MaxAge; int color; private float state; private float state2; int crel; float alpha;
/*     */   public boolean shouldRenderInPass(int pass) {
/*     */     return (pass == 1);
/*     */   }
/*  25 */   public EntityAuraRing(World par1World) { super(par1World);
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
/*  41 */     this.mot = "";
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
/*  61 */     this.MaxAge = 20;
/*  62 */     this.color = 16777215;
/*  63 */     this.state = 0.0F;
/*  64 */     this.state2 = 0.0F;
/*  65 */     this.crel = 0;
/*  66 */     this.alpha = 0.1F; } public EntityAuraRing(World par1World, String dbcCharger, int c, float s, float s2, int cr) { super(par1World); this.mot = ""; this.MaxAge = 20; this.color = 16777215; this.state = 0.0F; this.state2 = 0.0F; this.crel = 0; this.alpha = 0.1F; this.mot = dbcCharger; this.color = c; this.state = s;
/*     */     this.state2 = s2;
/*     */     this.crel = cr; } @SideOnly(Side.CLIENT) public float func_70053_R() { return 0.0F; }
/*  69 */   public int getAge() { return this.Age; }
/*     */    public int getCol() {
/*  71 */     return this.color;
/*     */   } public float getState() {
/*  73 */     return this.state;
/*     */   } public float getState2() {
/*  75 */     return this.state2;
/*     */   } public float getCRel() {
/*  77 */     return this.crel;
/*     */   } public void setCol(int c) {
/*  79 */     this.color = c;
/*     */   } public float getAlp() {
/*  81 */     return this.alpha;
/*     */   } public void setAlp(float a) {
/*  83 */     this.alpha = a;
/*     */   }
/*     */   public float update_alpha() {
/*  86 */     float one_age = this.MaxAge / 100.0F;
/*  87 */     float one_alpha = getAlp() / 100.0F;
/*  88 */     float alpha_curr = (100.0F - this.Age / one_age) / 100.0F * getAlp() * 3.0F;
/*     */     
/*  90 */     return alpha_curr;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70071_h_() {
/*  96 */     if (this.mot.length() > 1) {
/*  97 */       EntityPlayer entityPlayer = this.field_70170_p.func_72924_a(this.mot);
/*     */ 
/*     */ 
/*     */       
/* 101 */       if (entityPlayer != null) {
/* 102 */         func_70012_b(((Entity)entityPlayer).field_70165_t, ((Entity)entityPlayer).field_70163_u + ((entityPlayer instanceof net.minecraft.client.entity.EntityPlayerSP) ? -1.6F : 0.0F), ((Entity)entityPlayer).field_70161_v, 0.0F, 0.0F);
/*     */       } else {
/* 104 */         func_70106_y();
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
/* 116 */     if (this.Age++ >= this.MaxAge) func_70106_y();
/*     */   
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
/*     */   public boolean getCanSpawnHere() {
/* 168 */     return !this.field_70170_p.func_72855_b(this.field_70121_D);
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


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\EntityAuraRing.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */