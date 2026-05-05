/*     */ package net.minecraft.entity.ai;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import net.minecraft.profiler.Profiler;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ 
/*     */ public class EntityAITasks
/*     */ {
/*  12 */   private static final Logger field_151506_a = LogManager.getLogger();
/*     */   
/*     */   public class EntityAITaskEntry { public EntityAIBase field_75733_a;
/*     */     
/*     */     public EntityAITaskEntry(EntityAITasks p_i1627_1_, int p_i1627_2_, EntityAIBase p_i1627_3_) {
/*  17 */       this.field_75731_b = p_i1627_2_;
/*  18 */       this.field_75733_a = p_i1627_3_;
/*     */     }
/*     */ 
/*     */     
/*     */     public int field_75731_b;
/*     */     private static final String __OBFID = "CL_00001589"; }
/*     */   
/*  25 */   public List field_75782_a = new ArrayList();
/*  26 */   private List field_75780_b = new ArrayList();
/*     */   private final Profiler field_75781_c;
/*     */   private int field_75778_d;
/*  29 */   private int field_75779_e = 3; private static final String __OBFID = "CL_00001588";
/*     */   
/*     */   public EntityAITasks(Profiler p_i1628_1_) {
/*  32 */     this.field_75781_c = p_i1628_1_;
/*     */   }
/*     */   
/*     */   public void func_75776_a(int p_75776_1_, EntityAIBase p_75776_2_) {
/*  36 */     this.field_75782_a.add(new EntityAITaskEntry(this, p_75776_1_, p_75776_2_));
/*     */   }
/*     */   
/*     */   public void func_85156_a(EntityAIBase p_85156_1_) {
/*  40 */     Iterator<EntityAITaskEntry> iterator = this.field_75782_a.iterator();
/*  41 */     while (iterator.hasNext()) {
/*  42 */       EntityAITaskEntry entityAITaskEntry = iterator.next();
/*  43 */       EntityAIBase entityAIBase = entityAITaskEntry.field_75733_a;
/*     */       
/*  45 */       if (entityAIBase == p_85156_1_) {
/*  46 */         if (this.field_75780_b.contains(entityAITaskEntry)) {
/*  47 */           entityAIBase.func_75251_c();
/*  48 */           this.field_75780_b.remove(entityAITaskEntry);
/*     */         } 
/*     */         
/*  51 */         iterator.remove();
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_75774_a() {
/*  57 */     ArrayList<EntityAITaskEntry> arrayList = new ArrayList();
/*     */     
/*  59 */     if (this.field_75778_d++ % this.field_75779_e == 0) {
/*  60 */       for (EntityAITaskEntry entityAITaskEntry : this.field_75782_a) {
/*  61 */         boolean bool = this.field_75780_b.contains(entityAITaskEntry);
/*     */         
/*  63 */         if (bool)
/*  64 */           if (!func_75775_b(entityAITaskEntry) || !func_75773_a(entityAITaskEntry)) {
/*  65 */             entityAITaskEntry.field_75733_a.func_75251_c();
/*  66 */             this.field_75780_b.remove(entityAITaskEntry);
/*     */           } else {
/*     */             continue;
/*     */           }  
/*  70 */         if (!func_75775_b(entityAITaskEntry) || !entityAITaskEntry.field_75733_a.func_75250_a()) {
/*     */           continue;
/*     */         }
/*     */         
/*  74 */         arrayList.add(entityAITaskEntry);
/*  75 */         this.field_75780_b.add(entityAITaskEntry);
/*     */       } 
/*     */     } else {
/*  78 */       Iterator<EntityAITaskEntry> iterator = this.field_75780_b.iterator();
/*     */       
/*  80 */       while (iterator.hasNext()) {
/*  81 */         EntityAITaskEntry entityAITaskEntry = iterator.next();
/*  82 */         if (!entityAITaskEntry.field_75733_a.func_75253_b()) {
/*  83 */           entityAITaskEntry.field_75733_a.func_75251_c();
/*  84 */           iterator.remove();
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/*  89 */     this.field_75781_c.func_76320_a("goalStart");
/*     */     
/*  91 */     for (EntityAITaskEntry entityAITaskEntry : arrayList) {
/*     */       
/*  93 */       this.field_75781_c.func_76320_a(entityAITaskEntry.field_75733_a.getClass().getSimpleName());
/*  94 */       entityAITaskEntry.field_75733_a.func_75249_e();
/*  95 */       this.field_75781_c.func_76319_b();
/*     */     } 
/*  97 */     this.field_75781_c.func_76319_b();
/*     */     
/*  99 */     this.field_75781_c.func_76320_a("goalTick");
/*     */     
/* 101 */     for (EntityAITaskEntry entityAITaskEntry : this.field_75780_b)
/*     */     {
/* 103 */       entityAITaskEntry.field_75733_a.func_75246_d();
/*     */     }
/* 105 */     this.field_75781_c.func_76319_b();
/*     */   }
/*     */   
/*     */   private boolean func_75773_a(EntityAITaskEntry p_75773_1_) {
/* 109 */     this.field_75781_c.func_76320_a("canContinue");
/* 110 */     boolean bool = p_75773_1_.field_75733_a.func_75253_b();
/* 111 */     this.field_75781_c.func_76319_b();
/* 112 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean func_75775_b(EntityAITaskEntry p_75775_1_) {
/* 120 */     this.field_75781_c.func_76320_a("canUse");
/*     */     
/* 122 */     for (EntityAITaskEntry entityAITaskEntry : this.field_75782_a) {
/* 123 */       if (entityAITaskEntry == p_75775_1_)
/*     */         continue; 
/* 125 */       if (p_75775_1_.field_75731_b >= entityAITaskEntry.field_75731_b) {
/* 126 */         if (this.field_75780_b.contains(entityAITaskEntry) && !func_75777_a(p_75775_1_, entityAITaskEntry)) {
/* 127 */           this.field_75781_c.func_76319_b();
/* 128 */           return false;
/*     */         }  continue;
/* 130 */       }  if (this.field_75780_b.contains(entityAITaskEntry) && !entityAITaskEntry.field_75733_a.func_75252_g()) {
/* 131 */         this.field_75781_c.func_76319_b();
/* 132 */         return false;
/*     */       } 
/*     */     } 
/*     */     
/* 136 */     this.field_75781_c.func_76319_b();
/* 137 */     return true;
/*     */   }
/*     */   
/*     */   private boolean func_75777_a(EntityAITaskEntry p_75777_1_, EntityAITaskEntry p_75777_2_) {
/* 141 */     return ((p_75777_1_.field_75733_a.func_75247_h() & p_75777_2_.field_75733_a.func_75247_h()) == 0);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\ai\EntityAITasks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */