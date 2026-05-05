/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityAgeable;
/*     */ import net.minecraft.entity.passive.EntityAnimal;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class EntityNamekFrog extends EntityAnimal {
/*     */   private boolean j;
/*     */   
/*     */   public EntityNamekFrog(World par1World) {
/*  15 */     super(par1World);
/*  16 */     this.field_70728_aV = 0;
/*     */     
/*  18 */     func_70606_j(2.0F);
/*     */     
/*  20 */     func_70105_a(1.0F, 1.0F);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public float func_70053_R() {
/*  25 */     return 0.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70071_h_() {
/*  31 */     if (this.j && this.field_70122_E && !this.field_70703_bu) this.j = false;
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
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  85 */     if (!this.j && !this.field_70703_bu && (int)(Math.random() * 10.0D) == 0 && this.field_70173_aa % 100 == 0) func_70664_aZ(); 
/*  86 */     if (!this.j && this.field_70703_bu) {
/*  87 */       this.field_70159_w = Math.random() * 1.0D - 0.5D;
/*  88 */       this.field_70181_x = Math.random() * 1.0D;
/*  89 */       this.field_70179_y = Math.random() * 1.0D - 0.5D;
/*     */ 
/*     */ 
/*     */       
/*  93 */       float min = 0.2F, min2 = -0.2F;
/*  94 */       if (this.field_70159_w > 0.0D)
/*  95 */       { if (this.field_70159_w < min) this.field_70159_w += min;
/*     */          }
/*  97 */       else if (this.field_70159_w < 0.0D && 
/*  98 */         this.field_70159_w > min2) { this.field_70159_w += min2; }
/*     */       
/* 100 */       if (this.field_70181_x > 0.0D)
/* 101 */       { if (this.field_70181_x < min) this.field_70181_x += min;
/*     */          }
/* 103 */       else if (this.field_70181_x < 0.0D && 
/* 104 */         this.field_70181_x > min2) { this.field_70181_x += min2; }
/*     */ 
/*     */       
/* 107 */       this.field_70133_I = true;
/* 108 */       this.j = true;
/*     */     } 
/* 110 */     super.func_70071_h_();
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
/*     */   protected void func_70069_a(float p_70069_1_) {}
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
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String getTexture() {
/* 155 */     return "jinryuudragonbc:npcs/NamekFrog.png";
/*     */   }
/*     */   
/*     */   public boolean func_70601_bi() {
/* 159 */     return (this.field_70170_p.func_72855_b(this.field_70121_D) && this.field_70170_p.func_72945_a((Entity)this, this.field_70121_D).isEmpty() && !this.field_70170_p.func_72953_d(this.field_70121_D));
/*     */   }
/*     */   
/*     */   protected void func_70628_a(boolean par1, int par2) {}
/* 163 */   public boolean func_70085_c(EntityPlayer par1EntityPlayer) { return false; } protected boolean func_70692_ba() {
/* 164 */     return false;
/*     */   }
/*     */   public EntityAgeable func_90011_a(EntityAgeable p_90011_1_) {
/* 167 */     return null;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\EntityNamekFrog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */