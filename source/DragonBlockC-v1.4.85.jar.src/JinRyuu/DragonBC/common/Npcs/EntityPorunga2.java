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
/*     */ public class EntityPorunga2
/*     */   extends EntityCreature {
/*  20 */   public int randomSoundDelay = 0; public int timeBack;
/*     */   protected Entity closestEntity;
/*     */   float var1;
/*     */   private int age;
/*     */   private int jumpTicks;
/*     */   
/*  26 */   public EntityPorunga2(World par1World) { super(par1World);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  81 */     this.var1 = 8.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 132 */     this.jumpTicks = 0; this.field_70728_aV = 0; this.field_70130_N = 1.0F; this.field_70131_O = 32.0F; this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAIWatchClosest2((EntityLiving)this, EntityPlayer.class, 3.0F, 1.0F)); this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAIWatchClosest2((EntityLiving)this, EntityPlayer.class, 3.0F, 1.0F)); this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAIWatchClosest2((EntityLiving)this, EntityPlayer.class, 3.0F, 1.0F));
/*     */     this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAIWatchClosest2((EntityLiving)this, EntityPlayer.class, 3.0F, 1.0F));
/*     */     this.field_70714_bg.func_75776_a(4, (EntityAIBase)new EntityAIWatchClosest2((EntityLiving)this, EntityPlayer.class, 3.0F, 1.0F));
/*     */     this.field_70714_bg.func_75776_a(5, (EntityAIBase)new EntityAIWatchClosest2((EntityLiving)this, EntityPlayer.class, 3.0F, 1.0F));
/*     */     this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAIWatchClosest2((EntityLiving)this, EntityPlayer.class, 3.0F, 1.0F));
/*     */     this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAIWatchClosest2((EntityLiving)this, EntityPlayer.class, 3.0F, 1.0F));
/*     */     this.field_70714_bg.func_75776_a(8, (EntityAIBase)new EntityAIWatchClosest2((EntityLiving)this, EntityPlayer.class, 3.0F, 1.0F));
/*     */     this.field_70714_bg.func_75776_a(9, (EntityAIBase)new EntityAIWatchClosest2((EntityLiving)this, EntityPlayer.class, 3.0F, 1.0F));
/* 140 */     this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAIWatchClosest2((EntityLiving)this, EntityPlayer.class, 3.0F, 1.0F)); } public void func_70636_d() { if (this.jumpTicks > 0)
/*     */     {
/* 142 */       this.jumpTicks--;
/*     */     }
/*     */     
/* 145 */     if (this.field_70716_bi > 0) {
/*     */       
/* 147 */       double d0 = this.field_70165_t + (this.field_70709_bj - this.field_70165_t) / this.field_70716_bi;
/* 148 */       double d1 = this.field_70163_u + (this.field_70710_bk - this.field_70163_u) / this.field_70716_bi;
/* 149 */       double d2 = this.field_70161_v + (this.field_110152_bk - this.field_70161_v) / this.field_70716_bi;
/* 150 */       double d3 = MathHelper.func_76138_g(this.field_70712_bm - this.field_70177_z);
/* 151 */       this.field_70177_z = (float)(this.field_70177_z + d3 / this.field_70716_bi);
/* 152 */       this.field_70125_A = (float)(this.field_70125_A + (this.field_70705_bn - this.field_70125_A) / this.field_70716_bi);
/* 153 */       this.field_70716_bi--;
/* 154 */       func_70107_b(d0, d1, d2);
/* 155 */       func_70101_b(this.field_70177_z, this.field_70125_A);
/*     */     }
/* 157 */     else if (!func_70613_aW()) {
/*     */       
/* 159 */       this.field_70159_w *= 0.98D;
/* 160 */       this.field_70181_x *= 0.98D;
/* 161 */       this.field_70179_y *= 0.98D;
/*     */     } 
/*     */     
/* 164 */     if (Math.abs(this.field_70159_w) < 0.005D)
/*     */     {
/* 166 */       this.field_70159_w = 0.0D;
/*     */     }
/*     */     
/* 169 */     if (Math.abs(this.field_70181_x) < 0.005D)
/*     */     {
/* 171 */       this.field_70181_x = 0.0D;
/*     */     }
/*     */     
/* 174 */     if (Math.abs(this.field_70179_y) < 0.005D)
/*     */     {
/* 176 */       this.field_70179_y = 0.0D;
/*     */     }
/*     */     
/* 179 */     this.field_70170_p.field_72984_F.func_76320_a("ai");
/*     */     
/* 181 */     if (func_70610_aX()) {
/*     */       
/* 183 */       this.field_70703_bu = false;
/* 184 */       this.field_70702_br = 0.0F;
/* 185 */       this.field_70701_bs = 0.0F;
/* 186 */       this.field_70704_bt = 0.0F;
/*     */     }
/* 188 */     else if (func_70613_aW()) {
/*     */       
/* 190 */       if (func_70650_aV()) {
/*     */         
/* 192 */         this.field_70170_p.field_72984_F.func_76320_a("newAi");
/* 193 */         func_70619_bc();
/* 194 */         this.field_70170_p.field_72984_F.func_76319_b();
/*     */       }
/*     */       else {
/*     */         
/* 198 */         this.field_70170_p.field_72984_F.func_76320_a("oldAi");
/*     */         
/* 200 */         this.field_70170_p.field_72984_F.func_76319_b();
/* 201 */         this.field_70759_as = this.field_70177_z;
/*     */       } 
/*     */     } 
/*     */     
/* 205 */     this.field_70170_p.field_72984_F.func_76319_b();
/* 206 */     this.field_70170_p.field_72984_F.func_76320_a("jump");
/*     */     
/* 208 */     if (this.field_70703_bu) {
/*     */       
/* 210 */       if (!func_70090_H() && !func_70058_J()) {
/*     */         
/* 212 */         if (this.field_70122_E && this.jumpTicks == 0)
/*     */         {
/* 214 */           func_70664_aZ();
/* 215 */           this.jumpTicks = 10;
/*     */         }
/*     */       
/*     */       } else {
/*     */         
/* 220 */         this.field_70181_x += 0.03999999910593033D;
/*     */       }
/*     */     
/*     */     } else {
/*     */       
/* 225 */       this.jumpTicks = 0;
/*     */     } 
/*     */     
/* 228 */     this.field_70170_p.field_72984_F.func_76319_b();
/* 229 */     this.field_70170_p.field_72984_F.func_76320_a("travel");
/* 230 */     this.field_70702_br *= 0.98F;
/* 231 */     this.field_70701_bs *= 0.98F;
/* 232 */     this.field_70704_bt *= 0.9F;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 237 */     this.field_70170_p.field_72984_F.func_76319_b();
/* 238 */     this.field_70170_p.field_72984_F.func_76320_a("push");
/*     */     
/* 240 */     if (!this.field_70170_p.field_72995_K)
/*     */     {
/* 242 */       func_85033_bc();
/*     */     }
/*     */     
/* 245 */     this.field_70170_p.field_72984_F.func_76319_b();
/* 246 */     this.field_70170_p.field_72984_F.func_76320_a("looting");
/*     */     
/* 248 */     if (this.field_70170_p.field_72995_K || !func_98052_bS() || this.field_70729_aU || this.field_70170_p.func_82736_K().func_82766_b("mobGriefing"));
/*     */ 
/*     */     
/* 251 */     this.field_70170_p.field_72984_F.func_76319_b();
/*     */ 
/*     */     
/* 254 */     func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(1.0E-6D);
/* 255 */     this.field_70159_w *= 1.0E-4D;
/* 256 */     this.field_70179_y *= 1.0E-4D; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_70619_bc() {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70071_h_() {
/*     */     if (this.randomSoundDelay <= 0 || --this.randomSoundDelay == 0);
/*     */     this.field_70159_w *= 0.0D;
/*     */     this.field_70179_y *= 0.0D;
/*     */     super.func_70071_h_();
/*     */     this.age++;
/*     */     if (this.age == 200) {
/*     */       mod_DragonBC.logger.info("Porunga has fulfilled a wish!");
/*     */       func_70106_y();
/*     */     } 
/*     */     if (this.field_70170_p.field_72995_K) {
/*     */       DBCH.dragonSum((Entity)this);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String getTexture() {
/*     */     return "jinryuudragonbc:npcs/Porunga.png";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_70601_bi() {
/*     */     return (this.field_70170_p.func_72855_b(this.field_70121_D) && this.field_70170_p.func_72945_a((Entity)this, this.field_70121_D).isEmpty() && !this.field_70170_p.func_72953_d(this.field_70121_D));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_110147_ax() {
/* 312 */     super.func_110147_ax();
/*     */     
/* 314 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(50000.0D);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\EntityPorunga2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */