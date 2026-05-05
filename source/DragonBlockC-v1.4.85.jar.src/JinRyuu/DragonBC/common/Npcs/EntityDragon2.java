/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import JinRyuu.DragonBC.common.DBCH;
/*     */ import JinRyuu.DragonBC.common.mod_DragonBC;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityCreature;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.EntityAIBase;
/*     */ import net.minecraft.entity.ai.EntityAIWatchClosest2;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class EntityDragon2
/*     */   extends EntityCreature
/*     */ {
/*  21 */   public int randomSoundDelay = 0;
/*  22 */   public int timeBack = 0;
/*     */   private int age;
/*     */   private int jumpTicks;
/*     */   
/*     */   public EntityDragon2(World par1World) {
/*  27 */     super(par1World);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 131 */     this.jumpTicks = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 283 */     this.var1 = 8.0F;
/*     */     this.field_70130_N = 2.0F;
/*     */     this.field_70131_O = 25.0F;
/*     */     this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAIWatchClosest2((EntityLiving)this, EntityPlayer.class, 3.0F, 1.0F));
/*     */     this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAIWatchClosest2((EntityLiving)this, EntityPlayer.class, 3.0F, 1.0F));
/*     */     this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAIWatchClosest2((EntityLiving)this, EntityPlayer.class, 3.0F, 1.0F));
/*     */     this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAIWatchClosest2((EntityLiving)this, EntityPlayer.class, 3.0F, 1.0F));
/*     */     this.field_70714_bg.func_75776_a(4, (EntityAIBase)new EntityAIWatchClosest2((EntityLiving)this, EntityPlayer.class, 3.0F, 1.0F));
/*     */     this.field_70714_bg.func_75776_a(5, (EntityAIBase)new EntityAIWatchClosest2((EntityLiving)this, EntityPlayer.class, 3.0F, 1.0F));
/*     */     this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAIWatchClosest2((EntityLiving)this, EntityPlayer.class, 3.0F, 1.0F));
/*     */     this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAIWatchClosest2((EntityLiving)this, EntityPlayer.class, 3.0F, 1.0F));
/*     */     this.field_70714_bg.func_75776_a(8, (EntityAIBase)new EntityAIWatchClosest2((EntityLiving)this, EntityPlayer.class, 3.0F, 1.0F));
/*     */     this.field_70714_bg.func_75776_a(9, (EntityAIBase)new EntityAIWatchClosest2((EntityLiving)this, EntityPlayer.class, 3.0F, 1.0F));
/*     */     this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAIWatchClosest2((EntityLiving)this, EntityPlayer.class, 3.0F, 1.0F));
/*     */   }
/*     */ 
/*     */   
/*     */   protected Entity closestEntity;
/*     */   float var1;
/*     */   
/*     */   public boolean func_70085_c(EntityPlayer par1EntityPlayer) {
/*     */     ItemStack var2 = par1EntityPlayer.field_71071_by.func_70448_g();
/*     */     boolean var3 = (var2 != null);
/*     */     if (func_70089_S()) {
/*     */       return true;
/*     */     }
/*     */     return super.func_70085_c(par1EntityPlayer);
/*     */   }
/*     */   
/*     */   protected void func_110147_ax() {
/* 313 */     super.func_110147_ax();
/*     */     
/* 315 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(10000.0D);
/*     */   }
/*     */   
/*     */   protected void func_70619_bc() {}
/*     */   
/*     */   public void func_70071_h_() {
/*     */     if (this.randomSoundDelay <= 0 || --this.randomSoundDelay == 0);
/*     */     this.field_70159_w *= 0.0D;
/*     */     this.field_70179_y *= 0.0D;
/*     */     super.func_70071_h_();
/*     */     this.age++;
/*     */     if (this.age == 200) {
/*     */       mod_DragonBC.logger.info("Shenron has fulfilled a wish!");
/*     */       func_70106_y();
/*     */     } 
/*     */     if (this.field_70170_p.field_72995_K)
/*     */       DBCH.dragonSum((Entity)this); 
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String getTexture() {
/*     */     return "jinryuudragonbc:npcs/Dragon.png";
/*     */   }
/*     */   
/*     */   public boolean func_70601_bi() {
/*     */     return (this.field_70170_p.func_72855_b(this.field_70121_D) && this.field_70170_p.func_72945_a((Entity)this, this.field_70121_D).isEmpty() && !this.field_70170_p.func_72953_d(this.field_70121_D));
/*     */   }
/*     */   
/*     */   public void func_70636_d() {
/*     */     if (this.jumpTicks > 0)
/*     */       this.jumpTicks--; 
/*     */     if (this.field_70716_bi > 0) {
/*     */       double d0 = this.field_70165_t + (this.field_70709_bj - this.field_70165_t) / this.field_70716_bi;
/*     */       double d1 = this.field_70163_u + (this.field_70710_bk - this.field_70163_u) / this.field_70716_bi;
/*     */       double d2 = this.field_70161_v + (this.field_110152_bk - this.field_70161_v) / this.field_70716_bi;
/*     */       double d3 = MathHelper.func_76138_g(this.field_70712_bm - this.field_70177_z);
/*     */       this.field_70177_z = (float)(this.field_70177_z + d3 / this.field_70716_bi);
/*     */       this.field_70125_A = (float)(this.field_70125_A + (this.field_70705_bn - this.field_70125_A) / this.field_70716_bi);
/*     */       this.field_70716_bi--;
/*     */       func_70107_b(d0, d1, d2);
/*     */       func_70101_b(this.field_70177_z, this.field_70125_A);
/*     */     } else if (!func_70613_aW()) {
/*     */       this.field_70159_w *= 0.98D;
/*     */       this.field_70181_x *= 0.98D;
/*     */       this.field_70179_y *= 0.98D;
/*     */     } 
/*     */     if (Math.abs(this.field_70159_w) < 0.005D)
/*     */       this.field_70159_w = 0.0D; 
/*     */     if (Math.abs(this.field_70181_x) < 0.005D)
/*     */       this.field_70181_x = 0.0D; 
/*     */     if (Math.abs(this.field_70179_y) < 0.005D)
/*     */       this.field_70179_y = 0.0D; 
/*     */     this.field_70170_p.field_72984_F.func_76320_a("ai");
/*     */     if (func_70610_aX()) {
/*     */       this.field_70703_bu = false;
/*     */       this.field_70702_br = 0.0F;
/*     */       this.field_70701_bs = 0.0F;
/*     */       this.field_70704_bt = 0.0F;
/*     */     } else if (func_70613_aW()) {
/*     */       if (func_70650_aV()) {
/*     */         this.field_70170_p.field_72984_F.func_76320_a("newAi");
/*     */         func_70619_bc();
/*     */         this.field_70170_p.field_72984_F.func_76319_b();
/*     */       } else {
/*     */         this.field_70170_p.field_72984_F.func_76320_a("oldAi");
/*     */         this.field_70170_p.field_72984_F.func_76319_b();
/*     */         this.field_70759_as = this.field_70177_z;
/*     */       } 
/*     */     } 
/*     */     this.field_70170_p.field_72984_F.func_76319_b();
/*     */     this.field_70170_p.field_72984_F.func_76320_a("jump");
/*     */     if (this.field_70703_bu) {
/*     */       if (!func_70090_H() && !func_70058_J()) {
/*     */         if (this.field_70122_E && this.jumpTicks == 0) {
/*     */           func_70664_aZ();
/*     */           this.jumpTicks = 10;
/*     */         } 
/*     */       } else {
/*     */         this.field_70181_x += 0.03999999910593033D;
/*     */       } 
/*     */     } else {
/*     */       this.jumpTicks = 0;
/*     */     } 
/*     */     this.field_70170_p.field_72984_F.func_76319_b();
/*     */     this.field_70170_p.field_72984_F.func_76320_a("travel");
/*     */     this.field_70702_br *= 0.98F;
/*     */     this.field_70701_bs *= 0.98F;
/*     */     this.field_70704_bt *= 0.9F;
/*     */     this.field_70170_p.field_72984_F.func_76319_b();
/*     */     this.field_70170_p.field_72984_F.func_76320_a("push");
/*     */     if (!this.field_70170_p.field_72995_K)
/*     */       func_85033_bc(); 
/*     */     this.field_70170_p.field_72984_F.func_76319_b();
/*     */     this.field_70170_p.field_72984_F.func_76320_a("looting");
/*     */     if (this.field_70170_p.field_72995_K || !func_98052_bS() || this.field_70729_aU || this.field_70170_p.func_82736_K().func_82766_b("mobGriefing"));
/*     */     this.field_70170_p.field_72984_F.func_76319_b();
/*     */     func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(1.0E-6D);
/*     */     this.field_70159_w *= 1.0E-4D;
/*     */     this.field_70179_y *= 1.0E-4D;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\EntityDragon2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */