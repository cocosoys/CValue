/*     */ package net.minecraft.village;
/*     */ 
/*     */ import java.util.List;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EnumCreatureType;
/*     */ import net.minecraft.entity.monster.EntityZombie;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.util.ChunkCoordinates;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.SpawnerAnimals;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class VillageSiege {
/*     */   private World field_75537_a;
/*     */   private boolean field_75535_b;
/*  17 */   private int field_75536_c = -1;
/*     */   
/*     */   private int field_75533_d;
/*     */   
/*     */   private int field_75534_e;
/*     */   private Village field_75531_f;
/*     */   private int field_75532_g;
/*     */   private int field_75538_h;
/*     */   private int field_75539_i;
/*     */   private static final String __OBFID = "CL_00001634";
/*     */   
/*     */   public VillageSiege(World p_i1676_1_) {
/*  29 */     this.field_75537_a = p_i1676_1_;
/*     */   }
/*     */   
/*     */   public void func_75528_a() {
/*  33 */     boolean bool = false;
/*  34 */     if (bool) {
/*  35 */       if (this.field_75536_c == 2) {
/*  36 */         this.field_75533_d = 100;
/*     */         return;
/*     */       } 
/*     */     } else {
/*  40 */       if (this.field_75537_a.func_72935_r()) {
/*  41 */         this.field_75536_c = 0;
/*     */         
/*     */         return;
/*     */       } 
/*  45 */       if (this.field_75536_c == 2)
/*     */         return; 
/*  47 */       if (this.field_75536_c == 0) {
/*  48 */         float f = this.field_75537_a.func_72826_c(0.0F);
/*  49 */         if (f < 0.5D || f > 0.501D)
/*  50 */           return;  this.field_75536_c = (this.field_75537_a.field_73012_v.nextInt(10) == 0) ? 1 : 2;
/*  51 */         this.field_75535_b = false;
/*  52 */         if (this.field_75536_c == 2)
/*     */           return; 
/*     */       } 
/*     */     } 
/*  56 */     if (!this.field_75535_b) {
/*  57 */       if (func_75529_b()) { this.field_75535_b = true; }
/*     */       else
/*     */       { return; }
/*     */     
/*     */     }
/*  62 */     if (this.field_75534_e > 0) {
/*  63 */       this.field_75534_e--;
/*     */       
/*     */       return;
/*     */     } 
/*  67 */     this.field_75534_e = 2;
/*  68 */     if (this.field_75533_d > 0) {
/*  69 */       func_75530_c();
/*  70 */       this.field_75533_d--;
/*     */     } else {
/*  72 */       this.field_75536_c = 2;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean func_75529_b() {
/*  78 */     List list = this.field_75537_a.field_73010_i;
/*  79 */     for (EntityPlayer entityPlayer : list) {
/*  80 */       this.field_75531_f = this.field_75537_a.field_72982_D.func_75550_a((int)entityPlayer.field_70165_t, (int)entityPlayer.field_70163_u, (int)entityPlayer.field_70161_v, 1);
/*  81 */       if (this.field_75531_f == null || 
/*  82 */         this.field_75531_f.func_75567_c() < 10 || 
/*  83 */         this.field_75531_f.func_75561_d() < 20 || 
/*  84 */         this.field_75531_f.func_75562_e() < 20) {
/*     */         continue;
/*     */       }
/*  87 */       ChunkCoordinates chunkCoordinates = this.field_75531_f.func_75577_a();
/*  88 */       float f = this.field_75531_f.func_75568_b();
/*     */       
/*  90 */       boolean bool = false;
/*  91 */       for (byte b = 0; b < 10; b++) {
/*  92 */         this.field_75532_g = chunkCoordinates.field_71574_a + (int)((MathHelper.func_76134_b(this.field_75537_a.field_73012_v.nextFloat() * 3.1415927F * 2.0F) * f) * 0.9D);
/*  93 */         this.field_75538_h = chunkCoordinates.field_71572_b;
/*  94 */         this.field_75539_i = chunkCoordinates.field_71573_c + (int)((MathHelper.func_76126_a(this.field_75537_a.field_73012_v.nextFloat() * 3.1415927F * 2.0F) * f) * 0.9D);
/*  95 */         bool = false;
/*  96 */         for (Village village : this.field_75537_a.field_72982_D.func_75540_b()) {
/*  97 */           if (village != this.field_75531_f && 
/*  98 */             village.func_75570_a(this.field_75532_g, this.field_75538_h, this.field_75539_i)) {
/*  99 */             bool = true;
/*     */             break;
/*     */           } 
/*     */         } 
/* 103 */         if (!bool)
/*     */           break; 
/* 105 */       }  if (bool) return false;
/*     */       
/* 107 */       Vec3 vec3 = func_75527_a(this.field_75532_g, this.field_75538_h, this.field_75539_i);
/* 108 */       if (vec3 == null)
/*     */         continue; 
/* 110 */       this.field_75534_e = 0;
/* 111 */       this.field_75533_d = 20;
/* 112 */       return true;
/*     */     } 
/* 114 */     return false;
/*     */   }
/*     */   private boolean func_75530_c() {
/*     */     EntityZombie entityZombie;
/* 118 */     Vec3 vec3 = func_75527_a(this.field_75532_g, this.field_75538_h, this.field_75539_i);
/* 119 */     if (vec3 == null) return false;
/*     */     
/*     */     try {
/* 122 */       entityZombie = new EntityZombie(this.field_75537_a);
/* 123 */       entityZombie.func_110161_a(null);
/* 124 */       entityZombie.func_82229_g(false);
/* 125 */     } catch (Exception exception) {
/* 126 */       exception.printStackTrace();
/* 127 */       return false;
/*     */     } 
/* 129 */     entityZombie.func_70012_b(vec3.field_72450_a, vec3.field_72448_b, vec3.field_72449_c, this.field_75537_a.field_73012_v.nextFloat() * 360.0F, 0.0F);
/* 130 */     this.field_75537_a.func_72838_d((Entity)entityZombie);
/* 131 */     ChunkCoordinates chunkCoordinates = this.field_75531_f.func_75577_a();
/* 132 */     entityZombie.func_110171_b(chunkCoordinates.field_71574_a, chunkCoordinates.field_71572_b, chunkCoordinates.field_71573_c, this.field_75531_f.func_75568_b());
/* 133 */     return true;
/*     */   }
/*     */   
/*     */   private Vec3 func_75527_a(int p_75527_1_, int p_75527_2_, int p_75527_3_) {
/* 137 */     for (byte b = 0; b < 10; b++) {
/* 138 */       int i = p_75527_1_ + this.field_75537_a.field_73012_v.nextInt(16) - 8;
/* 139 */       int j = p_75527_2_ + this.field_75537_a.field_73012_v.nextInt(6) - 3;
/* 140 */       int k = p_75527_3_ + this.field_75537_a.field_73012_v.nextInt(16) - 8;
/* 141 */       if (this.field_75531_f.func_75570_a(i, j, k) && 
/* 142 */         SpawnerAnimals.func_77190_a(EnumCreatureType.monster, this.field_75537_a, i, j, k)) Vec3.func_72443_a(i, j, k); 
/*     */     } 
/* 144 */     return null;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\village\VillageSiege.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */