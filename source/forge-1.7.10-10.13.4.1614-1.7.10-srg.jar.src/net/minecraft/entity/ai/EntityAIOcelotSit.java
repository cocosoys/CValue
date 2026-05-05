/*     */ package net.minecraft.entity.ai;
/*     */ 
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockBed;
/*     */ import net.minecraft.entity.passive.EntityOcelot;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.tileentity.TileEntityChest;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EntityAIOcelotSit
/*     */   extends EntityAIBase
/*     */ {
/*     */   private final EntityOcelot field_151493_a;
/*     */   private final double field_151491_b;
/*     */   private int field_151492_c;
/*     */   private int field_151489_d;
/*     */   private int field_151490_e;
/*     */   private int field_151487_f;
/*     */   private int field_151488_g;
/*     */   private int field_151494_h;
/*     */   private static final String __OBFID = "CL_00001601";
/*     */   
/*     */   public EntityAIOcelotSit(EntityOcelot p_i45315_1_, double p_i45315_2_) {
/*  26 */     this.field_151493_a = p_i45315_1_;
/*  27 */     this.field_151491_b = p_i45315_2_;
/*  28 */     func_75248_a(5);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_75250_a() {
/*  33 */     return (this.field_151493_a.func_70909_n() && !this.field_151493_a.func_70906_o() && this.field_151493_a.func_70681_au().nextDouble() <= 0.006500000134110451D && func_151485_f());
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_75253_b() {
/*  38 */     return (this.field_151492_c <= this.field_151490_e && this.field_151489_d <= 60 && func_151486_a(this.field_151493_a.field_70170_p, this.field_151487_f, this.field_151488_g, this.field_151494_h));
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_75249_e() {
/*  43 */     this.field_151493_a.func_70661_as().func_75492_a(this.field_151487_f + 0.5D, (this.field_151488_g + 1), this.field_151494_h + 0.5D, this.field_151491_b);
/*  44 */     this.field_151492_c = 0;
/*  45 */     this.field_151489_d = 0;
/*  46 */     this.field_151490_e = this.field_151493_a.func_70681_au().nextInt(this.field_151493_a.func_70681_au().nextInt(1200) + 1200) + 1200;
/*  47 */     this.field_151493_a.func_70907_r().func_75270_a(false);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_75251_c() {
/*  52 */     this.field_151493_a.func_70904_g(false);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_75246_d() {
/*  57 */     this.field_151492_c++;
/*  58 */     this.field_151493_a.func_70907_r().func_75270_a(false);
/*  59 */     if (this.field_151493_a.func_70092_e(this.field_151487_f, (this.field_151488_g + 1), this.field_151494_h) > 1.0D) {
/*  60 */       this.field_151493_a.func_70904_g(false);
/*  61 */       this.field_151493_a.func_70661_as().func_75492_a(this.field_151487_f + 0.5D, (this.field_151488_g + 1), this.field_151494_h + 0.5D, this.field_151491_b);
/*  62 */       this.field_151489_d++;
/*  63 */     } else if (!this.field_151493_a.func_70906_o()) {
/*  64 */       this.field_151493_a.func_70904_g(true);
/*     */     } else {
/*  66 */       this.field_151489_d--;
/*     */     } 
/*     */   }
/*     */   
/*     */   private boolean func_151485_f() {
/*  71 */     int i = (int)this.field_151493_a.field_70163_u;
/*  72 */     double d = 2.147483647E9D;
/*     */     
/*  74 */     for (int j = (int)this.field_151493_a.field_70165_t - 8; j < this.field_151493_a.field_70165_t + 8.0D; j++) {
/*  75 */       for (int k = (int)this.field_151493_a.field_70161_v - 8; k < this.field_151493_a.field_70161_v + 8.0D; k++) {
/*  76 */         if (func_151486_a(this.field_151493_a.field_70170_p, j, i, k) && this.field_151493_a.field_70170_p.func_147437_c(j, i + 1, k)) {
/*  77 */           double d1 = this.field_151493_a.func_70092_e(j, i, k);
/*     */           
/*  79 */           if (d1 < d) {
/*  80 */             this.field_151487_f = j;
/*  81 */             this.field_151488_g = i;
/*  82 */             this.field_151494_h = k;
/*  83 */             d = d1;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/*  89 */     return (d < 2.147483647E9D);
/*     */   }
/*     */   
/*     */   private boolean func_151486_a(World p_151486_1_, int p_151486_2_, int p_151486_3_, int p_151486_4_) {
/*  93 */     Block block = p_151486_1_.func_147439_a(p_151486_2_, p_151486_3_, p_151486_4_);
/*  94 */     int i = p_151486_1_.func_72805_g(p_151486_2_, p_151486_3_, p_151486_4_);
/*     */     
/*  96 */     if (block == Blocks.field_150486_ae) {
/*  97 */       TileEntityChest tileEntityChest = (TileEntityChest)p_151486_1_.func_147438_o(p_151486_2_, p_151486_3_, p_151486_4_);
/*     */       
/*  99 */       if (tileEntityChest.field_145987_o < 1)
/* 100 */         return true; 
/*     */     } else {
/* 102 */       if (block == Blocks.field_150470_am)
/* 103 */         return true; 
/* 104 */       if (block == Blocks.field_150324_C && !BlockBed.func_149975_b(i)) {
/* 105 */         return true;
/*     */       }
/*     */     } 
/* 108 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\ai\EntityAIOcelotSit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */