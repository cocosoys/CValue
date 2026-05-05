/*     */ package JinRyuu.DragonBC.common.Render;
/*     */ 
/*     */ import JinRyuu.DragonBC.common.Blocks.BlocksDBC;
/*     */ import JinRyuu.DragonBC.common.Npcs.EntityDBC;
/*     */ import JinRyuu.DragonBC.common.Npcs.EntitySaibaiman;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SaibaiHatchedTileEntity
/*     */   extends TileEntity
/*     */ {
/*     */   public void func_145839_a(NBTTagCompound par1NBTTagCompound) {
/*  21 */     super.func_145839_a(par1NBTTagCompound);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_145841_b(NBTTagCompound par1NBTTagCompound) {
/*  30 */     super.func_145841_b(par1NBTTagCompound);
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
/*     */   public void func_145845_h() {
/*  46 */     super.func_145845_h();
/*     */   }
/*     */ 
/*     */   
/*  50 */   private int spawnDelay = 100;
/*  51 */   private String mobID = "Saibaman";
/*     */   
/*     */   public double field_98287_c;
/*  54 */   public double field_98284_d = 0.0D;
/*  55 */   private int minSpawnDelay = 150;
/*  56 */   private int maxSpawnDelay = 600;
/*     */ 
/*     */   
/*  59 */   private int spawnCount = 1;
/*     */   private Entity field_98291_j;
/*  61 */   private int maxNearbyEntities = 1;
/*     */ 
/*     */   
/*  64 */   private int activatingRangeFromPlayer = 4;
/*     */ 
/*     */   
/*  67 */   private int spawnRange = 8;
/*     */   
/*     */   private boolean canRun() {
/*  70 */     return (this.field_145850_b.func_72977_a(this.field_145851_c + 0.5D, this.field_145848_d + 0.5D, this.field_145849_e + 0.5D, this.activatingRangeFromPlayer) != null);
/*     */   }
/*     */   
/*     */   private void updateSpawner() {
/*  74 */     int n = 4;
/*  75 */     AxisAlignedBB aabb = AxisAlignedBB.func_72330_a(this.field_145851_c - n, this.field_145848_d - n, this.field_145849_e - n, this.field_145851_c + n, this.field_145848_d + n, this.field_145849_e + n);
/*     */     
/*  77 */     int p = this.field_145850_b.func_72872_a(EntityPlayer.class, aabb).size();
/*     */     
/*  79 */     if (canRun() && this.field_145850_b.func_72872_a(EntityPlayer.class, aabb).size() > 0)
/*     */     {
/*     */ 
/*     */       
/*  83 */       if (this.field_145850_b.field_72995_K) {
/*     */         
/*  85 */         double d1 = (this.field_145851_c + this.field_145850_b.field_73012_v.nextFloat());
/*  86 */         double d2 = (this.field_145848_d + this.field_145850_b.field_73012_v.nextFloat());
/*  87 */         double d0 = (this.field_145849_e + this.field_145850_b.field_73012_v.nextFloat());
/*     */ 
/*     */ 
/*     */         
/*  91 */         if (this.spawnDelay > 0)
/*     */         {
/*  93 */           this.spawnDelay--;
/*     */         }
/*     */         
/*  96 */         this.field_98284_d = this.field_98287_c;
/*  97 */         this.field_98287_c = (this.field_98287_c + (1000.0F / (this.spawnDelay + 200.0F))) % 360.0D;
/*     */       }
/*     */       else {
/*     */         
/* 101 */         if (this.spawnDelay == -1)
/*     */         {
/* 103 */           func_98273_j();
/*     */         }
/*     */         
/* 106 */         if (this.spawnDelay > 0) {
/*     */           
/* 108 */           this.spawnDelay--;
/*     */           
/*     */           return;
/*     */         } 
/* 112 */         boolean flag = false;
/*     */         
/* 114 */         for (int i = 0; i < 1; i++) {
/*     */ 
/*     */           
/* 117 */           EntitySaibaiman entitySaibaiman = new EntitySaibaiman(this.field_145850_b);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 123 */           n = 16;
/* 124 */           aabb = AxisAlignedBB.func_72330_a(this.field_145851_c - n, this.field_145848_d - n, this.field_145849_e - n, this.field_145851_c + n, this.field_145848_d + n, this.field_145849_e + n);
/*     */           
/* 126 */           int j = this.field_145850_b.func_72872_a(EntityDBC.class, aabb).size();
/*     */ 
/*     */           
/* 129 */           if (this.field_145850_b.func_72872_a(EntityDBC.class, aabb).size() == 0) {
/*     */             
/* 131 */             func_98273_j();
/*     */             
/*     */             return;
/*     */           } 
/*     */           
/* 136 */           double d0 = this.field_145851_c + (this.field_145850_b.field_73012_v.nextDouble() - this.field_145850_b.field_73012_v.nextDouble()) * this.spawnRange;
/* 137 */           double d3 = (this.field_145848_d + this.field_145850_b.field_73012_v.nextInt(3) - 1);
/* 138 */           double d4 = this.field_145849_e + (this.field_145850_b.field_73012_v.nextDouble() - this.field_145850_b.field_73012_v.nextDouble()) * this.spawnRange;
/* 139 */           EntityLiving entityliving = (entitySaibaiman instanceof EntityLiving) ? (EntityLiving)entitySaibaiman : null;
/* 140 */           entitySaibaiman.func_70012_b(d0, d3, d4, this.field_145850_b.field_73012_v.nextFloat() * 360.0F, 0.0F);
/*     */           
/* 142 */           if (entityliving == null || entityliving.func_70601_bi()) {
/*     */             
/* 144 */             func_98265_a((Entity)entitySaibaiman);
/* 145 */             this.field_145850_b.func_72926_e(2004, this.field_145851_c, this.field_145848_d, this.field_145849_e, 0);
/*     */             
/* 147 */             if (entityliving != null)
/*     */             {
/* 149 */               entityliving.func_70656_aK();
/*     */             }
/*     */             
/* 152 */             flag = true;
/*     */           } 
/*     */         } 
/*     */         
/* 156 */         if (flag)
/*     */         {
/* 158 */           func_98273_j();
/*     */         }
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private Entity func_98265_a(Entity par1Entity) {
/* 166 */     if (par1Entity instanceof EntityLiving && par1Entity.field_70170_p != null)
/*     */     {
/*     */       
/* 169 */       this.field_145850_b.func_72838_d(par1Entity);
/*     */     }
/*     */     
/* 172 */     return par1Entity;
/*     */   }
/*     */ 
/*     */   
/*     */   private void func_98273_j() {
/* 177 */     if (this.maxSpawnDelay <= this.minSpawnDelay) {
/*     */       
/* 179 */       this.spawnDelay = this.minSpawnDelay;
/*     */     }
/*     */     else {
/*     */       
/* 183 */       int i = this.maxSpawnDelay - this.minSpawnDelay;
/* 184 */       this.spawnDelay = this.minSpawnDelay + this.field_145850_b.field_73012_v.nextInt(i);
/*     */     } 
/*     */     
/* 187 */     func_98267_a(1);
/*     */   }
/*     */   
/*     */   private void func_98267_a(int par1) {
/* 191 */     this.field_145850_b.func_147452_c(this.field_145851_c, this.field_145848_d, this.field_145849_e, BlocksDBC.SaibaiHatched, par1, 0);
/*     */   }
/*     */   
/*     */   private boolean setDelayToMin(int par1) {
/* 195 */     if (par1 == 1 && this.field_145850_b.field_72995_K) {
/*     */       
/* 197 */       this.spawnDelay = this.minSpawnDelay;
/* 198 */       return true;
/*     */     } 
/*     */ 
/*     */     
/* 202 */     return false;
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
/*     */   public boolean func_145842_c(int par1, int par2) {
/* 221 */     return setDelayToMin(par1) ? true : super.func_145842_c(par1, par2);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Render\SaibaiHatchedTileEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */