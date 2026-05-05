/*     */ package net.minecraft.world.gen.structure;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.biome.BiomeGenBase;
/*     */ 
/*     */ public class MapGenVillage
/*     */   extends MapGenStructure
/*     */ {
/*  15 */   public static List field_75055_e = Arrays.asList(new BiomeGenBase[] { BiomeGenBase.field_76772_c, BiomeGenBase.field_76769_d, BiomeGenBase.field_150588_X });
/*     */   
/*     */   private int field_75054_f;
/*  18 */   private int field_82665_g = 32;
/*  19 */   private int field_82666_h = 8;
/*     */   
/*     */   private static final String __OBFID = "CL_00000514";
/*     */   
/*     */   public MapGenVillage() {}
/*     */   
/*     */   public MapGenVillage(Map p_i2093_1_) {
/*  26 */     this();
/*     */     
/*  28 */     for (Map.Entry entry : p_i2093_1_.entrySet()) {
/*  29 */       if (((String)entry.getKey()).equals("size")) {
/*  30 */         this.field_75054_f = MathHelper.func_82714_a((String)entry.getValue(), this.field_75054_f, 0); continue;
/*  31 */       }  if (((String)entry.getKey()).equals("distance")) {
/*  32 */         this.field_82665_g = MathHelper.func_82714_a((String)entry.getValue(), this.field_82665_g, this.field_82666_h + 1);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String func_143025_a() {
/*  39 */     return "Village";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean func_75047_a(int p_75047_1_, int p_75047_2_) {
/*  45 */     int i = p_75047_1_;
/*  46 */     int j = p_75047_2_;
/*  47 */     if (p_75047_1_ < 0) p_75047_1_ -= this.field_82665_g - 1; 
/*  48 */     if (p_75047_2_ < 0) p_75047_2_ -= this.field_82665_g - 1;
/*     */     
/*  50 */     int k = p_75047_1_ / this.field_82665_g;
/*  51 */     int m = p_75047_2_ / this.field_82665_g;
/*  52 */     Random random = this.field_75039_c.func_72843_D(k, m, 10387312);
/*  53 */     k *= this.field_82665_g;
/*  54 */     m *= this.field_82665_g;
/*  55 */     k += random.nextInt(this.field_82665_g - this.field_82666_h);
/*  56 */     m += random.nextInt(this.field_82665_g - this.field_82666_h);
/*  57 */     p_75047_1_ = i;
/*  58 */     p_75047_2_ = j;
/*     */     
/*  60 */     if (p_75047_1_ == k && p_75047_2_ == m) {
/*  61 */       boolean bool = this.field_75039_c.func_72959_q().func_76940_a(p_75047_1_ * 16 + 8, p_75047_2_ * 16 + 8, 0, field_75055_e);
/*  62 */       if (bool) {
/*  63 */         return true;
/*     */       }
/*     */     } 
/*     */     
/*  67 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected StructureStart func_75049_b(int p_75049_1_, int p_75049_2_) {
/*  73 */     return new Start(this.field_75039_c, this.field_75038_b, p_75049_1_, p_75049_2_, this.field_75054_f);
/*     */   }
/*     */   
/*     */   public static class Start
/*     */     extends StructureStart {
/*     */     private boolean field_75076_c;
/*     */     private static final String __OBFID = "CL_00000515";
/*     */     
/*     */     public Start() {}
/*     */     
/*     */     public Start(World p_i2092_1_, Random p_i2092_2_, int p_i2092_3_, int p_i2092_4_, int p_i2092_5_) {
/*  84 */       super(p_i2092_3_, p_i2092_4_);
/*     */       
/*  86 */       List list = StructureVillagePieces.func_75084_a(p_i2092_2_, p_i2092_5_);
/*     */       
/*  88 */       StructureVillagePieces.Start start = new StructureVillagePieces.Start(p_i2092_1_.func_72959_q(), 0, p_i2092_2_, (p_i2092_3_ << 4) + 2, (p_i2092_4_ << 4) + 2, list, p_i2092_5_);
/*  89 */       this.field_75075_a.add(start);
/*  90 */       start.func_74861_a(start, this.field_75075_a, p_i2092_2_);
/*     */       
/*  92 */       List<StructureComponent> list1 = start.field_74930_j;
/*  93 */       List<StructureComponent> list2 = start.field_74932_i;
/*  94 */       while (!list1.isEmpty() || !list2.isEmpty()) {
/*     */ 
/*     */         
/*  97 */         if (list1.isEmpty()) {
/*  98 */           int j = p_i2092_2_.nextInt(list2.size());
/*  99 */           StructureComponent structureComponent1 = list2.remove(j);
/* 100 */           structureComponent1.func_74861_a(start, this.field_75075_a, p_i2092_2_); continue;
/*     */         } 
/* 102 */         int i = p_i2092_2_.nextInt(list1.size());
/* 103 */         StructureComponent structureComponent = list1.remove(i);
/* 104 */         structureComponent.func_74861_a(start, this.field_75075_a, p_i2092_2_);
/*     */       } 
/*     */ 
/*     */       
/* 108 */       func_75072_c();
/*     */       
/* 110 */       byte b = 0;
/* 111 */       for (StructureComponent structureComponent : this.field_75075_a) {
/* 112 */         if (!(structureComponent instanceof StructureVillagePieces.Road)) {
/* 113 */           b++;
/*     */         }
/*     */       } 
/* 116 */       this.field_75076_c = (b > 2);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean func_75069_d() {
/* 121 */       return this.field_75076_c;
/*     */     }
/*     */ 
/*     */     
/*     */     public void func_143022_a(NBTTagCompound p_143022_1_) {
/* 126 */       super.func_143022_a(p_143022_1_);
/*     */       
/* 128 */       p_143022_1_.func_74757_a("Valid", this.field_75076_c);
/*     */     }
/*     */ 
/*     */     
/*     */     public void func_143017_b(NBTTagCompound p_143017_1_) {
/* 133 */       super.func_143017_b(p_143017_1_);
/* 134 */       this.field_75076_c = p_143017_1_.func_74767_n("Valid");
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\structure\MapGenVillage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */