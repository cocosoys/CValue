/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import JinRyuu.DragonBC.common.DBCH;
/*     */ import JinRyuu.DragonBC.common.mod_DragonBC;
/*     */ import JinRyuu.JRMCore.JRMCoreH;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityCreature;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.EntityAIBase;
/*     */ import net.minecraft.entity.ai.EntityAIWatchClosest2;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class EntityDragon
/*     */   extends EntityCreature
/*     */ {
/*  24 */   public int randomSoundDelay = 0;
/*  25 */   private int time = 0;
/*  26 */   public int timeBack = 0; private boolean granted; protected Entity closestEntity; float var1; private float maxDistanceForPlayer;
/*     */   private int lookTime;
/*     */   private Class watchedClass;
/*     */   private int jumpTicks;
/*     */   
/*  31 */   public EntityDragon(World par1World) { super(par1World);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  63 */     this.granted = false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 113 */     this.var1 = 8.0F;
/*     */ 
/*     */     
/* 116 */     this.maxDistanceForPlayer = 4.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 193 */     this.jumpTicks = 0; this.field_70728_aV = 0; func_94061_f(false); func_70105_a(2.0F, 25.0F); this.field_70130_N = 2.0F; this.field_70131_O = 25.0F; this.field_70121_D.field_72336_d = this.field_70121_D.field_72340_a + this.field_70130_N; this.field_70121_D.field_72334_f = this.field_70121_D.field_72339_c + this.field_70130_N; this.field_70121_D.field_72337_e = this.field_70121_D.field_72338_b + this.field_70131_O; this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAIWatchClosest2((EntityLiving)this, EntityPlayer.class, 3.0F, 1.0F)); this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAIWatchClosest2((EntityLiving)this, EntityPlayer.class, 3.0F, 1.0F)); this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAIWatchClosest2((EntityLiving)this, EntityPlayer.class, 3.0F, 1.0F));
/*     */     this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAIWatchClosest2((EntityLiving)this, EntityPlayer.class, 3.0F, 1.0F));
/*     */     this.field_70714_bg.func_75776_a(4, (EntityAIBase)new EntityAIWatchClosest2((EntityLiving)this, EntityPlayer.class, 3.0F, 1.0F));
/*     */     this.field_70714_bg.func_75776_a(5, (EntityAIBase)new EntityAIWatchClosest2((EntityLiving)this, EntityPlayer.class, 3.0F, 1.0F));
/*     */     this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAIWatchClosest2((EntityLiving)this, EntityPlayer.class, 3.0F, 1.0F));
/*     */     this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAIWatchClosest2((EntityLiving)this, EntityPlayer.class, 3.0F, 1.0F));
/*     */     this.field_70714_bg.func_75776_a(8, (EntityAIBase)new EntityAIWatchClosest2((EntityLiving)this, EntityPlayer.class, 3.0F, 1.0F));
/*     */     this.field_70714_bg.func_75776_a(9, (EntityAIBase)new EntityAIWatchClosest2((EntityLiving)this, EntityPlayer.class, 3.0F, 1.0F));
/* 201 */     this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAIWatchClosest2((EntityLiving)this, EntityPlayer.class, 3.0F, 1.0F)); } public void func_70636_d() { if (this.jumpTicks > 0)
/*     */     {
/* 203 */       this.jumpTicks--;
/*     */     }
/*     */     
/* 206 */     if (this.field_70716_bi > 0) {
/*     */       
/* 208 */       double d0 = this.field_70165_t + (this.field_70709_bj - this.field_70165_t) / this.field_70716_bi;
/* 209 */       double d1 = this.field_70163_u + (this.field_70710_bk - this.field_70163_u) / this.field_70716_bi;
/* 210 */       double d2 = this.field_70161_v + (this.field_110152_bk - this.field_70161_v) / this.field_70716_bi;
/* 211 */       double d3 = MathHelper.func_76138_g(this.field_70712_bm - this.field_70177_z);
/* 212 */       this.field_70177_z = (float)(this.field_70177_z + d3 / this.field_70716_bi);
/* 213 */       this.field_70125_A = (float)(this.field_70125_A + (this.field_70705_bn - this.field_70125_A) / this.field_70716_bi);
/* 214 */       this.field_70716_bi--;
/* 215 */       func_70107_b(d0, d1, d2);
/* 216 */       func_70101_b(this.field_70177_z, this.field_70125_A);
/*     */     }
/* 218 */     else if (!func_70613_aW()) {
/*     */       
/* 220 */       this.field_70159_w *= 0.98D;
/* 221 */       this.field_70181_x *= 0.98D;
/* 222 */       this.field_70179_y *= 0.98D;
/*     */     } 
/*     */     
/* 225 */     if (Math.abs(this.field_70159_w) < 0.005D)
/*     */     {
/* 227 */       this.field_70159_w = 0.0D;
/*     */     }
/*     */     
/* 230 */     if (Math.abs(this.field_70181_x) < 0.005D)
/*     */     {
/* 232 */       this.field_70181_x = 0.0D;
/*     */     }
/*     */     
/* 235 */     if (Math.abs(this.field_70179_y) < 0.005D)
/*     */     {
/* 237 */       this.field_70179_y = 0.0D;
/*     */     }
/*     */     
/* 240 */     this.field_70170_p.field_72984_F.func_76320_a("ai");
/*     */     
/* 242 */     if (func_70610_aX()) {
/*     */       
/* 244 */       this.field_70703_bu = false;
/* 245 */       this.field_70702_br = 0.0F;
/* 246 */       this.field_70701_bs = 0.0F;
/* 247 */       this.field_70704_bt = 0.0F;
/*     */     }
/* 249 */     else if (func_70613_aW()) {
/*     */       
/* 251 */       if (func_70650_aV()) {
/*     */         
/* 253 */         this.field_70170_p.field_72984_F.func_76320_a("newAi");
/* 254 */         func_70619_bc();
/* 255 */         this.field_70170_p.field_72984_F.func_76319_b();
/*     */       }
/*     */       else {
/*     */         
/* 259 */         this.field_70170_p.field_72984_F.func_76320_a("oldAi");
/*     */         
/* 261 */         this.field_70170_p.field_72984_F.func_76319_b();
/* 262 */         this.field_70759_as = this.field_70177_z;
/*     */       } 
/*     */     } 
/*     */     
/* 266 */     this.field_70170_p.field_72984_F.func_76319_b();
/* 267 */     this.field_70170_p.field_72984_F.func_76320_a("jump");
/*     */     
/* 269 */     if (this.field_70703_bu) {
/*     */       
/* 271 */       if (!func_70090_H() && !func_70058_J()) {
/*     */         
/* 273 */         if (this.field_70122_E && this.jumpTicks == 0)
/*     */         {
/* 275 */           func_70664_aZ();
/* 276 */           this.jumpTicks = 10;
/*     */         }
/*     */       
/*     */       } else {
/*     */         
/* 281 */         this.field_70181_x += 0.03999999910593033D;
/*     */       }
/*     */     
/*     */     } else {
/*     */       
/* 286 */       this.jumpTicks = 0;
/*     */     } 
/*     */     
/* 289 */     this.field_70170_p.field_72984_F.func_76319_b();
/* 290 */     this.field_70170_p.field_72984_F.func_76320_a("travel");
/* 291 */     this.field_70702_br *= 0.98F;
/* 292 */     this.field_70701_bs *= 0.98F;
/* 293 */     this.field_70704_bt *= 0.9F;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 298 */     this.field_70170_p.field_72984_F.func_76319_b();
/* 299 */     this.field_70170_p.field_72984_F.func_76320_a("push");
/*     */     
/* 301 */     if (!this.field_70170_p.field_72995_K)
/*     */     {
/* 303 */       func_85033_bc();
/*     */     }
/*     */     
/* 306 */     this.field_70170_p.field_72984_F.func_76319_b();
/* 307 */     this.field_70170_p.field_72984_F.func_76320_a("looting");
/*     */     
/* 309 */     if (this.field_70170_p.field_72995_K || !func_98052_bS() || this.field_70729_aU || this.field_70170_p.func_82736_K().func_82766_b("mobGriefing"));
/*     */ 
/*     */     
/* 312 */     this.field_70170_p.field_72984_F.func_76319_b();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 319 */     EntityPlayer var2 = this.field_70170_p.func_72890_a((Entity)this, this.var1);
/*     */     
/* 321 */     if (var2 != null) {
/*     */       
/* 323 */       this.closestEntity = (Entity)var2;
/* 324 */       this.field_70700_bx = 10 + this.field_70146_Z.nextInt(20);
/*     */     }
/*     */     else {
/*     */       
/* 328 */       this.field_70704_bt = (this.field_70146_Z.nextFloat() - 0.5F) * 20.0F;
/*     */     } 
/*     */ 
/*     */     
/* 332 */     if (this.closestEntity != null) {
/*     */       
/* 334 */       func_70625_a(this.closestEntity, 10.0F, func_70646_bf());
/*     */       
/* 336 */       if (this.field_70700_bx-- <= 0 || this.closestEntity.field_70128_L || this.closestEntity.func_70068_e((Entity)this) > (this.var1 * this.var1))
/*     */       {
/* 338 */         this.closestEntity = null; } 
/*     */     }  }
/*     */   public boolean func_70085_c(EntityPlayer par1EntityPlayer) { ItemStack var2 = par1EntityPlayer.field_71071_by.func_70448_g(); boolean var3 = (var2 != null); if (func_70089_S()) {
/*     */       if (!this.field_70170_p.field_72995_K) {
/*     */         if (!this.granted) {
/*     */           this.granted = true; JRMCoreH.setInt(1, par1EntityPlayer, "jrmcWishes"); JRMCoreH.setInt(0, par1EntityPlayer, "jrmcDrgn");
/*     */         } 
/*     */       } else if (!this.granted) {
/*     */         this.granted = true; par1EntityPlayer.openGui(mod_DragonBC.instance, 2, par1EntityPlayer.field_70170_p, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v);
/*     */       }  if (!par1EntityPlayer.field_70170_p.field_72995_K) {
/*     */         EntityDragon2 Dragon2 = new EntityDragon2(par1EntityPlayer.field_70170_p); Dragon2.func_70012_b((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v, this.field_70177_z, 0.0F); Dragon2.timeBack = this.timeBack; par1EntityPlayer.field_70170_p.func_72838_d((Entity)Dragon2);
/*     */       } 
/*     */       func_70106_y();
/*     */       return true;
/*     */     } 
/*     */     return super.func_70085_c(par1EntityPlayer); }
/*     */   protected void func_70619_bc() {}
/*     */   public void shouldExecute() { this.closestEntity = (Entity)this.field_70170_p.func_72890_a((Entity)this, this.maxDistanceForPlayer);
/*     */     if (this.closestEntity != null) {
/*     */       this.watchedClass = EntityPlayer.class;
/*     */       func_70671_ap().func_75650_a(this.closestEntity.field_70165_t, this.closestEntity.field_70163_u + 2.0D, this.closestEntity.field_70161_v, 10.0F, func_70646_bf());
/*     */     }  }
/*     */   public void func_70071_h_() { if (this.randomSoundDelay <= 0 || --this.randomSoundDelay == 0);
/*     */     this.time++;
/*     */     if (this.time == 1)
/*     */       mod_DragonBC.logger.info("Shenron is Summoned!"); 
/*     */     if (this.field_70170_p.field_72995_K)
/*     */       DBCH.dragonSum((Entity)this); 
/*     */     float r = 30.0F;
/*     */     AxisAlignedBB aabb = AxisAlignedBB.func_72330_a(this.field_70165_t - r, this.field_70163_u - r, this.field_70161_v - r, this.field_70165_t + r, this.field_70163_u + r, this.field_70161_v + r);
/*     */     List list = this.field_70170_p.func_72872_a(EntityPlayer.class, aabb);
/*     */     if (list.size() == 0)
/*     */       func_70106_y(); 
/*     */     super.func_70071_h_();
/*     */     shouldExecute(); }
/* 373 */   @SideOnly(Side.CLIENT) public String getTexture() { return "jinryuudragonbc:npcs/Dragon.png"; } public boolean func_70601_bi() { return (this.field_70170_p.func_72855_b(this.field_70121_D) && this.field_70170_p.func_72945_a((Entity)this, this.field_70121_D).isEmpty() && !this.field_70170_p.func_72953_d(this.field_70121_D)); } protected void func_110147_ax() { super.func_110147_ax();
/*     */     
/* 375 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(10000.0D); }
/*     */ 
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\EntityDragon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */