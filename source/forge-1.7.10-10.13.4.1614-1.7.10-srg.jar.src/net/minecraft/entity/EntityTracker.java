/*     */ package net.minecraft.entity;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.Callable;
/*     */ import net.minecraft.crash.CrashReport;
/*     */ import net.minecraft.crash.CrashReportCategory;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.network.Packet;
/*     */ import net.minecraft.util.IntHashMap;
/*     */ import net.minecraft.util.ReportedException;
/*     */ import net.minecraft.world.WorldServer;
/*     */ import net.minecraft.world.chunk.Chunk;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EntityTracker
/*     */ {
/*  22 */   private static final Logger field_151249_a = LogManager.getLogger();
/*     */   private final WorldServer field_72795_a;
/*  24 */   private Set field_72793_b = new HashSet();
/*  25 */   private IntHashMap field_72794_c = new IntHashMap();
/*     */   private int field_72792_d;
/*     */   
/*     */   public EntityTracker(WorldServer p_i1516_1_) {
/*  29 */     this.field_72795_a = p_i1516_1_;
/*  30 */     this.field_72792_d = p_i1516_1_.func_73046_m().func_71203_ab().func_72372_a();
/*     */   }
/*     */   private static final String __OBFID = "CL_00001431";
/*     */   public void func_72786_a(Entity p_72786_1_) {
/*  34 */     if (p_72786_1_ instanceof EntityPlayerMP)
/*  35 */     { func_72791_a(p_72786_1_, 512, 2);
/*  36 */       EntityPlayerMP entityPlayerMP = (EntityPlayerMP)p_72786_1_;
/*  37 */       for (EntityTrackerEntry entityTrackerEntry : this.field_72793_b) {
/*  38 */         if (entityTrackerEntry.field_73132_a != entityPlayerMP) {
/*  39 */           entityTrackerEntry.func_73117_b(entityPlayerMP);
/*     */         }
/*     */       }  }
/*  42 */     else if (p_72786_1_ instanceof net.minecraft.entity.projectile.EntityFishHook) { func_72785_a(p_72786_1_, 64, 5, true); }
/*  43 */     else if (p_72786_1_ instanceof net.minecraft.entity.projectile.EntityArrow) { func_72785_a(p_72786_1_, 64, 20, false); }
/*  44 */     else if (p_72786_1_ instanceof net.minecraft.entity.projectile.EntitySmallFireball) { func_72785_a(p_72786_1_, 64, 10, false); }
/*  45 */     else if (p_72786_1_ instanceof net.minecraft.entity.projectile.EntityFireball) { func_72785_a(p_72786_1_, 64, 10, false); }
/*  46 */     else if (p_72786_1_ instanceof net.minecraft.entity.projectile.EntitySnowball) { func_72785_a(p_72786_1_, 64, 10, true); }
/*  47 */     else if (p_72786_1_ instanceof net.minecraft.entity.item.EntityEnderPearl) { func_72785_a(p_72786_1_, 64, 10, true); }
/*  48 */     else if (p_72786_1_ instanceof net.minecraft.entity.item.EntityEnderEye) { func_72785_a(p_72786_1_, 64, 4, true); }
/*  49 */     else if (p_72786_1_ instanceof net.minecraft.entity.projectile.EntityEgg) { func_72785_a(p_72786_1_, 64, 10, true); }
/*  50 */     else if (p_72786_1_ instanceof net.minecraft.entity.projectile.EntityPotion) { func_72785_a(p_72786_1_, 64, 10, true); }
/*  51 */     else if (p_72786_1_ instanceof net.minecraft.entity.item.EntityExpBottle) { func_72785_a(p_72786_1_, 64, 10, true); }
/*  52 */     else if (p_72786_1_ instanceof net.minecraft.entity.item.EntityFireworkRocket) { func_72785_a(p_72786_1_, 64, 10, true); }
/*  53 */     else if (p_72786_1_ instanceof net.minecraft.entity.item.EntityItem) { func_72785_a(p_72786_1_, 64, 20, true); }
/*  54 */     else if (p_72786_1_ instanceof net.minecraft.entity.item.EntityMinecart) { func_72785_a(p_72786_1_, 80, 3, true); }
/*  55 */     else if (p_72786_1_ instanceof net.minecraft.entity.item.EntityBoat) { func_72785_a(p_72786_1_, 80, 3, true); }
/*  56 */     else if (p_72786_1_ instanceof net.minecraft.entity.passive.EntitySquid) { func_72785_a(p_72786_1_, 64, 3, true); }
/*  57 */     else if (p_72786_1_ instanceof net.minecraft.entity.boss.EntityWither) { func_72785_a(p_72786_1_, 80, 3, false); }
/*  58 */     else if (p_72786_1_ instanceof net.minecraft.entity.passive.EntityBat) { func_72785_a(p_72786_1_, 80, 3, false); }
/*  59 */     else if (p_72786_1_ instanceof net.minecraft.entity.passive.IAnimals) { func_72785_a(p_72786_1_, 80, 3, true); }
/*  60 */     else if (p_72786_1_ instanceof net.minecraft.entity.boss.EntityDragon) { func_72785_a(p_72786_1_, 160, 3, true); }
/*  61 */     else if (p_72786_1_ instanceof net.minecraft.entity.item.EntityTNTPrimed) { func_72785_a(p_72786_1_, 160, 10, true); }
/*  62 */     else if (p_72786_1_ instanceof net.minecraft.entity.item.EntityFallingBlock) { func_72785_a(p_72786_1_, 160, 20, true); }
/*  63 */     else if (p_72786_1_ instanceof EntityHanging) { func_72785_a(p_72786_1_, 160, 2147483647, false); }
/*  64 */     else if (p_72786_1_ instanceof net.minecraft.entity.item.EntityXPOrb) { func_72785_a(p_72786_1_, 160, 20, true); }
/*  65 */     else if (p_72786_1_ instanceof net.minecraft.entity.item.EntityEnderCrystal) { func_72785_a(p_72786_1_, 256, 2147483647, false); }
/*     */   
/*     */   }
/*     */   public void func_72791_a(Entity p_72791_1_, int p_72791_2_, int p_72791_3_) {
/*  69 */     func_72785_a(p_72791_1_, p_72791_2_, p_72791_3_, false);
/*     */   }
/*     */   
/*     */   public void func_72785_a(Entity p_72785_1_, int p_72785_2_, int p_72785_3_, boolean p_72785_4_) {
/*  73 */     if (p_72785_2_ > this.field_72792_d) p_72785_2_ = this.field_72792_d;
/*     */     
/*     */     try {
/*  76 */       if (this.field_72794_c.func_76037_b(p_72785_1_.func_145782_y())) {
/*  77 */         throw new IllegalStateException("Entity is already tracked!");
/*     */       }
/*  79 */       EntityTrackerEntry entityTrackerEntry = new EntityTrackerEntry(p_72785_1_, p_72785_2_, p_72785_3_, p_72785_4_);
/*  80 */       this.field_72793_b.add(entityTrackerEntry);
/*  81 */       this.field_72794_c.func_76038_a(p_72785_1_.func_145782_y(), entityTrackerEntry);
/*  82 */       entityTrackerEntry.func_73125_b(this.field_72795_a.field_73010_i);
/*  83 */     } catch (Throwable throwable) {
/*  84 */       CrashReport crashReport = CrashReport.func_85055_a(throwable, "Adding entity to track");
/*  85 */       CrashReportCategory crashReportCategory1 = crashReport.func_85058_a("Entity To Track");
/*     */       
/*  87 */       crashReportCategory1.func_71507_a("Tracking range", p_72785_2_ + " blocks");
/*  88 */       crashReportCategory1.func_71500_a("Update interval", new Callable(this, p_72785_3_) { private static final String __OBFID = "CL_00001432";
/*     */             
/*     */             public String call() {
/*  91 */               String str = "Once per " + this.field_96570_a + " ticks";
/*  92 */               if (this.field_96570_a == Integer.MAX_VALUE) str = "Maximum (" + str + ")"; 
/*  93 */               return str;
/*     */             } }
/*     */         );
/*  96 */       p_72785_1_.func_85029_a(crashReportCategory1);
/*     */       
/*  98 */       CrashReportCategory crashReportCategory2 = crashReport.func_85058_a("Entity That Is Already Tracked");
/*  99 */       ((EntityTrackerEntry)this.field_72794_c.func_76041_a(p_72785_1_.func_145782_y())).field_73132_a.func_85029_a(crashReportCategory2);
/*     */       
/*     */       try {
/* 102 */         throw new ReportedException(crashReport);
/* 103 */       } catch (ReportedException reportedException) {
/* 104 */         field_151249_a.error("\"Silently\" catching entity tracking error.", (Throwable)reportedException);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_72790_b(Entity p_72790_1_) {
/* 110 */     if (p_72790_1_ instanceof EntityPlayerMP) {
/* 111 */       EntityPlayerMP entityPlayerMP = (EntityPlayerMP)p_72790_1_;
/* 112 */       for (EntityTrackerEntry entityTrackerEntry1 : this.field_72793_b) {
/* 113 */         entityTrackerEntry1.func_73118_a(entityPlayerMP);
/*     */       }
/*     */     } 
/* 116 */     EntityTrackerEntry entityTrackerEntry = (EntityTrackerEntry)this.field_72794_c.func_76049_d(p_72790_1_.func_145782_y());
/* 117 */     if (entityTrackerEntry != null) {
/* 118 */       this.field_72793_b.remove(entityTrackerEntry);
/* 119 */       entityTrackerEntry.func_73119_a();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_72788_a() {
/* 124 */     ArrayList<EntityPlayerMP> arrayList = new ArrayList();
/* 125 */     for (EntityTrackerEntry entityTrackerEntry : this.field_72793_b) {
/* 126 */       entityTrackerEntry.func_73122_a(this.field_72795_a.field_73010_i);
/* 127 */       if (entityTrackerEntry.field_73133_n && entityTrackerEntry.field_73132_a instanceof EntityPlayerMP) {
/* 128 */         arrayList.add((EntityPlayerMP)entityTrackerEntry.field_73132_a);
/*     */       }
/*     */     } 
/*     */     
/* 132 */     for (byte b = 0; b < arrayList.size(); b++) {
/* 133 */       EntityPlayerMP entityPlayerMP = arrayList.get(b);
/* 134 */       for (EntityTrackerEntry entityTrackerEntry : this.field_72793_b) {
/* 135 */         if (entityTrackerEntry.field_73132_a != entityPlayerMP) {
/* 136 */           entityTrackerEntry.func_73117_b(entityPlayerMP);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_151247_a(Entity p_151247_1_, Packet p_151247_2_) {
/* 143 */     EntityTrackerEntry entityTrackerEntry = (EntityTrackerEntry)this.field_72794_c.func_76041_a(p_151247_1_.func_145782_y());
/* 144 */     if (entityTrackerEntry != null) {
/* 145 */       entityTrackerEntry.func_151259_a(p_151247_2_);
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_151248_b(Entity p_151248_1_, Packet p_151248_2_) {
/* 150 */     EntityTrackerEntry entityTrackerEntry = (EntityTrackerEntry)this.field_72794_c.func_76041_a(p_151248_1_.func_145782_y());
/* 151 */     if (entityTrackerEntry != null) {
/* 152 */       entityTrackerEntry.func_151261_b(p_151248_2_);
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_72787_a(EntityPlayerMP p_72787_1_) {
/* 157 */     for (EntityTrackerEntry entityTrackerEntry : this.field_72793_b) {
/* 158 */       entityTrackerEntry.func_73123_c(p_72787_1_);
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_85172_a(EntityPlayerMP p_85172_1_, Chunk p_85172_2_) {
/* 163 */     for (EntityTrackerEntry entityTrackerEntry : this.field_72793_b) {
/* 164 */       if (entityTrackerEntry.field_73132_a != p_85172_1_ && entityTrackerEntry.field_73132_a.field_70176_ah == p_85172_2_.field_76635_g && entityTrackerEntry.field_73132_a.field_70164_aj == p_85172_2_.field_76647_h)
/* 165 */         entityTrackerEntry.func_73117_b(p_85172_1_); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\EntityTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */