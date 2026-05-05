/*      */ package net.minecraft.world.gen.structure;
/*      */ 
/*      */ import java.util.ArrayList;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Random;
/*      */ import net.minecraft.block.Block;
/*      */ import net.minecraft.block.material.Material;
/*      */ import net.minecraft.entity.Entity;
/*      */ import net.minecraft.entity.passive.EntityVillager;
/*      */ import net.minecraft.init.Blocks;
/*      */ import net.minecraft.init.Items;
/*      */ import net.minecraft.item.Item;
/*      */ import net.minecraft.nbt.NBTTagCompound;
/*      */ import net.minecraft.util.MathHelper;
/*      */ import net.minecraft.util.WeightedRandomChestContent;
/*      */ import net.minecraft.world.World;
/*      */ import net.minecraft.world.biome.BiomeGenBase;
/*      */ import net.minecraft.world.biome.WorldChunkManager;
/*      */ 
/*      */ 
/*      */ public class StructureVillagePieces
/*      */ {
/*      */   private static final String __OBFID = "CL_00000516";
/*      */   
/*      */   public static void func_143016_a() {
/*   27 */     MapGenStructureIO.func_143031_a(House1.class, "ViBH");
/*   28 */     MapGenStructureIO.func_143031_a(Field1.class, "ViDF");
/*   29 */     MapGenStructureIO.func_143031_a(Field2.class, "ViF");
/*   30 */     MapGenStructureIO.func_143031_a(Torch.class, "ViL");
/*   31 */     MapGenStructureIO.func_143031_a(Hall.class, "ViPH");
/*   32 */     MapGenStructureIO.func_143031_a(House4Garden.class, "ViSH");
/*   33 */     MapGenStructureIO.func_143031_a(WoodHut.class, "ViSmH");
/*   34 */     MapGenStructureIO.func_143031_a(Church.class, "ViST");
/*   35 */     MapGenStructureIO.func_143031_a(House2.class, "ViS");
/*   36 */     MapGenStructureIO.func_143031_a(Start.class, "ViStart");
/*   37 */     MapGenStructureIO.func_143031_a(Path.class, "ViSR");
/*   38 */     MapGenStructureIO.func_143031_a(House3.class, "ViTRH");
/*   39 */     MapGenStructureIO.func_143031_a(Well.class, "ViW");
/*      */   }
/*      */   
/*      */   public static class PieceWeight { public Class field_75090_a;
/*      */     public final int field_75088_b;
/*      */     public int field_75089_c;
/*      */     public int field_75087_d;
/*      */     private static final String __OBFID = "CL_00000521";
/*      */     
/*      */     public PieceWeight(Class p_i2098_1_, int p_i2098_2_, int p_i2098_3_) {
/*   49 */       this.field_75090_a = p_i2098_1_;
/*   50 */       this.field_75088_b = p_i2098_2_;
/*   51 */       this.field_75087_d = p_i2098_3_;
/*      */     }
/*      */     
/*      */     public boolean func_75085_a(int p_75085_1_) {
/*   55 */       return (this.field_75087_d == 0 || this.field_75089_c < this.field_75087_d);
/*      */     }
/*      */     
/*      */     public boolean func_75086_a() {
/*   59 */       return (this.field_75087_d == 0 || this.field_75089_c < this.field_75087_d);
/*      */     } }
/*      */ 
/*      */   
/*      */   public static List func_75084_a(Random p_75084_0_, int p_75084_1_) {
/*   64 */     ArrayList<PieceWeight> arrayList = new ArrayList();
/*      */     
/*   66 */     arrayList.add(new PieceWeight(House4Garden.class, 4, MathHelper.func_76136_a(p_75084_0_, 2 + p_75084_1_, 4 + p_75084_1_ * 2)));
/*   67 */     arrayList.add(new PieceWeight(Church.class, 20, MathHelper.func_76136_a(p_75084_0_, 0 + p_75084_1_, 1 + p_75084_1_)));
/*   68 */     arrayList.add(new PieceWeight(House1.class, 20, MathHelper.func_76136_a(p_75084_0_, 0 + p_75084_1_, 2 + p_75084_1_)));
/*   69 */     arrayList.add(new PieceWeight(WoodHut.class, 3, MathHelper.func_76136_a(p_75084_0_, 2 + p_75084_1_, 5 + p_75084_1_ * 3)));
/*   70 */     arrayList.add(new PieceWeight(Hall.class, 15, MathHelper.func_76136_a(p_75084_0_, 0 + p_75084_1_, 2 + p_75084_1_)));
/*   71 */     arrayList.add(new PieceWeight(Field1.class, 3, MathHelper.func_76136_a(p_75084_0_, 1 + p_75084_1_, 4 + p_75084_1_)));
/*   72 */     arrayList.add(new PieceWeight(Field2.class, 3, MathHelper.func_76136_a(p_75084_0_, 2 + p_75084_1_, 4 + p_75084_1_ * 2)));
/*   73 */     arrayList.add(new PieceWeight(House2.class, 15, MathHelper.func_76136_a(p_75084_0_, 0, 1 + p_75084_1_)));
/*   74 */     arrayList.add(new PieceWeight(House3.class, 8, MathHelper.func_76136_a(p_75084_0_, 0 + p_75084_1_, 3 + p_75084_1_ * 2)));
/*      */ 
/*      */     
/*   77 */     Iterator<PieceWeight> iterator = arrayList.iterator();
/*   78 */     while (iterator.hasNext()) {
/*   79 */       if (((PieceWeight)iterator.next()).field_75087_d == 0) {
/*   80 */         iterator.remove();
/*      */       }
/*      */     } 
/*      */     
/*   84 */     return arrayList;
/*      */   }
/*      */   
/*      */   private static int func_75079_a(List p_75079_0_) {
/*   88 */     boolean bool = false;
/*   89 */     int i = 0;
/*   90 */     for (PieceWeight pieceWeight : p_75079_0_) {
/*   91 */       if (pieceWeight.field_75087_d > 0 && pieceWeight.field_75089_c < pieceWeight.field_75087_d) {
/*   92 */         bool = true;
/*      */       }
/*   94 */       i += pieceWeight.field_75088_b;
/*      */     } 
/*   96 */     return bool ? i : -1;
/*      */   }
/*      */ 
/*      */   
/*      */   private static Village func_75083_a(Start p_75083_0_, PieceWeight p_75083_1_, List p_75083_2_, Random p_75083_3_, int p_75083_4_, int p_75083_5_, int p_75083_6_, int p_75083_7_, int p_75083_8_) {
/*      */     House3 house3;
/*  102 */     Class<House4Garden> clazz = p_75083_1_.field_75090_a;
/*  103 */     House4Garden house4Garden = null;
/*      */     
/*  105 */     if (clazz == House4Garden.class) {
/*  106 */       house4Garden = House4Garden.func_74912_a(p_75083_0_, p_75083_2_, p_75083_3_, p_75083_4_, p_75083_5_, p_75083_6_, p_75083_7_, p_75083_8_);
/*  107 */     } else if (clazz == Church.class) {
/*  108 */       Church church = Church.func_74919_a(p_75083_0_, p_75083_2_, p_75083_3_, p_75083_4_, p_75083_5_, p_75083_6_, p_75083_7_, p_75083_8_);
/*  109 */     } else if (clazz == House1.class) {
/*  110 */       House1 house1 = House1.func_74898_a(p_75083_0_, p_75083_2_, p_75083_3_, p_75083_4_, p_75083_5_, p_75083_6_, p_75083_7_, p_75083_8_);
/*  111 */     } else if (clazz == WoodHut.class) {
/*  112 */       WoodHut woodHut = WoodHut.func_74908_a(p_75083_0_, p_75083_2_, p_75083_3_, p_75083_4_, p_75083_5_, p_75083_6_, p_75083_7_, p_75083_8_);
/*  113 */     } else if (clazz == Hall.class) {
/*  114 */       Hall hall = Hall.func_74906_a(p_75083_0_, p_75083_2_, p_75083_3_, p_75083_4_, p_75083_5_, p_75083_6_, p_75083_7_, p_75083_8_);
/*  115 */     } else if (clazz == Field1.class) {
/*  116 */       Field1 field1 = Field1.func_74900_a(p_75083_0_, p_75083_2_, p_75083_3_, p_75083_4_, p_75083_5_, p_75083_6_, p_75083_7_, p_75083_8_);
/*  117 */     } else if (clazz == Field2.class) {
/*  118 */       Field2 field2 = Field2.func_74902_a(p_75083_0_, p_75083_2_, p_75083_3_, p_75083_4_, p_75083_5_, p_75083_6_, p_75083_7_, p_75083_8_);
/*  119 */     } else if (clazz == House2.class) {
/*  120 */       House2 house2 = House2.func_74915_a(p_75083_0_, p_75083_2_, p_75083_3_, p_75083_4_, p_75083_5_, p_75083_6_, p_75083_7_, p_75083_8_);
/*  121 */     } else if (clazz == House3.class) {
/*  122 */       house3 = House3.func_74921_a(p_75083_0_, p_75083_2_, p_75083_3_, p_75083_4_, p_75083_5_, p_75083_6_, p_75083_7_, p_75083_8_);
/*      */     } 
/*      */     
/*  125 */     return house3;
/*      */   }
/*      */ 
/*      */   
/*      */   private static Village func_75081_c(Start p_75081_0_, List p_75081_1_, Random p_75081_2_, int p_75081_3_, int p_75081_4_, int p_75081_5_, int p_75081_6_, int p_75081_7_) {
/*  130 */     int i = func_75079_a(p_75081_0_.field_74931_h);
/*  131 */     if (i <= 0) {
/*  132 */       return null;
/*      */     }
/*      */     
/*  135 */     byte b = 0;
/*  136 */     while (b < 5) {
/*  137 */       b++;
/*      */       
/*  139 */       int j = p_75081_2_.nextInt(i);
/*  140 */       for (PieceWeight pieceWeight : p_75081_0_.field_74931_h) {
/*  141 */         j -= pieceWeight.field_75088_b;
/*  142 */         if (j < 0) {
/*      */           
/*  144 */           if (!pieceWeight.func_75085_a(p_75081_7_) || (pieceWeight == p_75081_0_.field_74926_d && p_75081_0_.field_74931_h.size() > 1)) {
/*      */             break;
/*      */           }
/*      */           
/*  148 */           Village village = func_75083_a(p_75081_0_, pieceWeight, p_75081_1_, p_75081_2_, p_75081_3_, p_75081_4_, p_75081_5_, p_75081_6_, p_75081_7_);
/*  149 */           if (village != null) {
/*  150 */             pieceWeight.field_75089_c++;
/*  151 */             p_75081_0_.field_74926_d = pieceWeight;
/*      */             
/*  153 */             if (!pieceWeight.func_75086_a()) {
/*  154 */               p_75081_0_.field_74931_h.remove(pieceWeight);
/*      */             }
/*  156 */             return village;
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  164 */     StructureBoundingBox structureBoundingBox = Torch.func_74904_a(p_75081_0_, p_75081_1_, p_75081_2_, p_75081_3_, p_75081_4_, p_75081_5_, p_75081_6_);
/*  165 */     if (structureBoundingBox != null) {
/*  166 */       return new Torch(p_75081_0_, p_75081_7_, p_75081_2_, structureBoundingBox, p_75081_6_);
/*      */     }
/*      */     
/*  169 */     return null;
/*      */   }
/*      */   
/*      */   private static StructureComponent func_75077_d(Start p_75077_0_, List<Village> p_75077_1_, Random p_75077_2_, int p_75077_3_, int p_75077_4_, int p_75077_5_, int p_75077_6_, int p_75077_7_) {
/*  173 */     if (p_75077_7_ > 50) {
/*  174 */       return null;
/*      */     }
/*  176 */     if (Math.abs(p_75077_3_ - (p_75077_0_.func_74874_b()).field_78897_a) > 112 || Math.abs(p_75077_5_ - (p_75077_0_.func_74874_b()).field_78896_c) > 112) {
/*  177 */       return null;
/*      */     }
/*      */     
/*  180 */     Village village = func_75081_c(p_75077_0_, p_75077_1_, p_75077_2_, p_75077_3_, p_75077_4_, p_75077_5_, p_75077_6_, p_75077_7_ + 1);
/*  181 */     if (village != null) {
/*  182 */       int i = (village.field_74887_e.field_78897_a + village.field_74887_e.field_78893_d) / 2;
/*  183 */       int j = (village.field_74887_e.field_78896_c + village.field_74887_e.field_78892_f) / 2;
/*  184 */       int k = village.field_74887_e.field_78893_d - village.field_74887_e.field_78897_a;
/*  185 */       int m = village.field_74887_e.field_78892_f - village.field_74887_e.field_78896_c;
/*  186 */       int n = (k > m) ? k : m;
/*  187 */       if (p_75077_0_.func_74925_d().func_76940_a(i, j, n / 2 + 4, MapGenVillage.field_75055_e)) {
/*  188 */         p_75077_1_.add(village);
/*  189 */         p_75077_0_.field_74932_i.add(village);
/*  190 */         return village;
/*      */       } 
/*      */     } 
/*  193 */     return null;
/*      */   }
/*      */   
/*      */   private static StructureComponent func_75080_e(Start p_75080_0_, List<Path> p_75080_1_, Random p_75080_2_, int p_75080_3_, int p_75080_4_, int p_75080_5_, int p_75080_6_, int p_75080_7_) {
/*  197 */     if (p_75080_7_ > 3 + p_75080_0_.field_74928_c) {
/*  198 */       return null;
/*      */     }
/*  200 */     if (Math.abs(p_75080_3_ - (p_75080_0_.func_74874_b()).field_78897_a) > 112 || Math.abs(p_75080_5_ - (p_75080_0_.func_74874_b()).field_78896_c) > 112) {
/*  201 */       return null;
/*      */     }
/*      */     
/*  204 */     StructureBoundingBox structureBoundingBox = Path.func_74933_a(p_75080_0_, p_75080_1_, p_75080_2_, p_75080_3_, p_75080_4_, p_75080_5_, p_75080_6_);
/*  205 */     if (structureBoundingBox != null && structureBoundingBox.field_78895_b > 10) {
/*  206 */       Path path = new Path(p_75080_0_, p_75080_7_, p_75080_2_, structureBoundingBox, p_75080_6_);
/*  207 */       int i = (path.field_74887_e.field_78897_a + path.field_74887_e.field_78893_d) / 2;
/*  208 */       int j = (path.field_74887_e.field_78896_c + path.field_74887_e.field_78892_f) / 2;
/*  209 */       int k = path.field_74887_e.field_78893_d - path.field_74887_e.field_78897_a;
/*  210 */       int m = path.field_74887_e.field_78892_f - path.field_74887_e.field_78896_c;
/*  211 */       int n = (k > m) ? k : m;
/*  212 */       if (p_75080_0_.func_74925_d().func_76940_a(i, j, n / 2 + 4, MapGenVillage.field_75055_e)) {
/*  213 */         p_75080_1_.add(path);
/*  214 */         p_75080_0_.field_74930_j.add(path);
/*  215 */         return path;
/*      */       } 
/*      */     } 
/*      */     
/*  219 */     return null;
/*      */   }
/*      */   
/*      */   public static abstract class Village
/*      */     extends StructureComponent {
/*  224 */     protected int field_143015_k = -1;
/*      */     
/*      */     private int field_74896_a;
/*      */     private boolean field_143014_b;
/*      */     private static final String __OBFID = "CL_00000531";
/*      */     
/*      */     public Village() {}
/*      */     
/*      */     protected Village(StructureVillagePieces.Start p_i2107_1_, int p_i2107_2_) {
/*  233 */       super(p_i2107_2_);
/*  234 */       if (p_i2107_1_ != null) {
/*  235 */         this.field_143014_b = p_i2107_1_.field_74927_b;
/*      */       }
/*      */     }
/*      */ 
/*      */     
/*      */     protected void func_143012_a(NBTTagCompound p_143012_1_) {
/*  241 */       p_143012_1_.func_74768_a("HPos", this.field_143015_k);
/*  242 */       p_143012_1_.func_74768_a("VCount", this.field_74896_a);
/*  243 */       p_143012_1_.func_74757_a("Desert", this.field_143014_b);
/*      */     }
/*      */ 
/*      */     
/*      */     protected void func_143011_b(NBTTagCompound p_143011_1_) {
/*  248 */       this.field_143015_k = p_143011_1_.func_74762_e("HPos");
/*  249 */       this.field_74896_a = p_143011_1_.func_74762_e("VCount");
/*  250 */       this.field_143014_b = p_143011_1_.func_74767_n("Desert");
/*      */     }
/*      */     
/*      */     protected StructureComponent func_74891_a(StructureVillagePieces.Start p_74891_1_, List p_74891_2_, Random p_74891_3_, int p_74891_4_, int p_74891_5_) {
/*  254 */       switch (this.field_74885_f) {
/*      */         case 2:
/*  256 */           return StructureVillagePieces.func_75077_d(p_74891_1_, p_74891_2_, p_74891_3_, this.field_74887_e.field_78897_a - 1, this.field_74887_e.field_78895_b + p_74891_4_, this.field_74887_e.field_78896_c + p_74891_5_, 1, func_74877_c());
/*      */         case 0:
/*  258 */           return StructureVillagePieces.func_75077_d(p_74891_1_, p_74891_2_, p_74891_3_, this.field_74887_e.field_78897_a - 1, this.field_74887_e.field_78895_b + p_74891_4_, this.field_74887_e.field_78896_c + p_74891_5_, 1, func_74877_c());
/*      */         case 1:
/*  260 */           return StructureVillagePieces.func_75077_d(p_74891_1_, p_74891_2_, p_74891_3_, this.field_74887_e.field_78897_a + p_74891_5_, this.field_74887_e.field_78895_b + p_74891_4_, this.field_74887_e.field_78896_c - 1, 2, func_74877_c());
/*      */         case 3:
/*  262 */           return StructureVillagePieces.func_75077_d(p_74891_1_, p_74891_2_, p_74891_3_, this.field_74887_e.field_78897_a + p_74891_5_, this.field_74887_e.field_78895_b + p_74891_4_, this.field_74887_e.field_78896_c - 1, 2, func_74877_c());
/*      */       } 
/*  264 */       return null;
/*      */     }
/*      */     
/*      */     protected StructureComponent func_74894_b(StructureVillagePieces.Start p_74894_1_, List p_74894_2_, Random p_74894_3_, int p_74894_4_, int p_74894_5_) {
/*  268 */       switch (this.field_74885_f) {
/*      */         case 2:
/*  270 */           return StructureVillagePieces.func_75077_d(p_74894_1_, p_74894_2_, p_74894_3_, this.field_74887_e.field_78893_d + 1, this.field_74887_e.field_78895_b + p_74894_4_, this.field_74887_e.field_78896_c + p_74894_5_, 3, func_74877_c());
/*      */         case 0:
/*  272 */           return StructureVillagePieces.func_75077_d(p_74894_1_, p_74894_2_, p_74894_3_, this.field_74887_e.field_78893_d + 1, this.field_74887_e.field_78895_b + p_74894_4_, this.field_74887_e.field_78896_c + p_74894_5_, 3, func_74877_c());
/*      */         case 1:
/*  274 */           return StructureVillagePieces.func_75077_d(p_74894_1_, p_74894_2_, p_74894_3_, this.field_74887_e.field_78897_a + p_74894_5_, this.field_74887_e.field_78895_b + p_74894_4_, this.field_74887_e.field_78892_f + 1, 0, func_74877_c());
/*      */         case 3:
/*  276 */           return StructureVillagePieces.func_75077_d(p_74894_1_, p_74894_2_, p_74894_3_, this.field_74887_e.field_78897_a + p_74894_5_, this.field_74887_e.field_78895_b + p_74894_4_, this.field_74887_e.field_78892_f + 1, 0, func_74877_c());
/*      */       } 
/*  278 */       return null;
/*      */     }
/*      */ 
/*      */     
/*      */     protected int func_74889_b(World p_74889_1_, StructureBoundingBox p_74889_2_) {
/*  283 */       int i = 0;
/*  284 */       byte b = 0;
/*  285 */       for (int j = this.field_74887_e.field_78896_c; j <= this.field_74887_e.field_78892_f; j++) {
/*  286 */         for (int k = this.field_74887_e.field_78897_a; k <= this.field_74887_e.field_78893_d; k++) {
/*  287 */           if (p_74889_2_.func_78890_b(k, 64, j)) {
/*  288 */             i += Math.max(p_74889_1_.func_72825_h(k, j), p_74889_1_.field_73011_w.func_76557_i());
/*  289 */             b++;
/*      */           } 
/*      */         } 
/*      */       } 
/*      */       
/*  294 */       if (b == 0) {
/*  295 */         return -1;
/*      */       }
/*  297 */       return i / b;
/*      */     }
/*      */     
/*      */     protected static boolean func_74895_a(StructureBoundingBox p_74895_0_) {
/*  301 */       return (p_74895_0_ != null && p_74895_0_.field_78895_b > 10);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected void func_74893_a(World p_74893_1_, StructureBoundingBox p_74893_2_, int p_74893_3_, int p_74893_4_, int p_74893_5_, int p_74893_6_) {
/*  316 */       if (this.field_74896_a >= p_74893_6_) {
/*      */         return;
/*      */       }
/*      */       
/*  320 */       for (int i = this.field_74896_a; i < p_74893_6_; ) {
/*  321 */         int j = func_74865_a(p_74893_3_ + i, p_74893_5_);
/*  322 */         int k = func_74862_a(p_74893_4_);
/*  323 */         int m = func_74873_b(p_74893_3_ + i, p_74893_5_);
/*      */         
/*  325 */         if (p_74893_2_.func_78890_b(j, k, m)) {
/*  326 */           this.field_74896_a++;
/*      */           
/*  328 */           EntityVillager entityVillager = new EntityVillager(p_74893_1_, func_74888_b(i));
/*  329 */           entityVillager.func_70012_b(j + 0.5D, k, m + 0.5D, 0.0F, 0.0F);
/*  330 */           p_74893_1_.func_72838_d((Entity)entityVillager);
/*      */           i++;
/*      */         } 
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     protected int func_74888_b(int p_74888_1_) {
/*  339 */       return 0;
/*      */     }
/*      */     
/*      */     protected Block func_151558_b(Block p_151558_1_, int p_151558_2_) {
/*  343 */       if (this.field_143014_b) {
/*  344 */         if (p_151558_1_ == Blocks.field_150364_r || p_151558_1_ == Blocks.field_150363_s)
/*  345 */           return Blocks.field_150322_A; 
/*  346 */         if (p_151558_1_ == Blocks.field_150347_e)
/*  347 */           return Blocks.field_150322_A; 
/*  348 */         if (p_151558_1_ == Blocks.field_150344_f)
/*  349 */           return Blocks.field_150322_A; 
/*  350 */         if (p_151558_1_ == Blocks.field_150476_ad)
/*  351 */           return Blocks.field_150372_bz; 
/*  352 */         if (p_151558_1_ == Blocks.field_150446_ar)
/*  353 */           return Blocks.field_150372_bz; 
/*  354 */         if (p_151558_1_ == Blocks.field_150351_n) {
/*  355 */           return Blocks.field_150322_A;
/*      */         }
/*      */       } 
/*  358 */       return p_151558_1_;
/*      */     }
/*      */     
/*      */     protected int func_151557_c(Block p_151557_1_, int p_151557_2_) {
/*  362 */       if (this.field_143014_b) {
/*  363 */         if (p_151557_1_ == Blocks.field_150364_r || p_151557_1_ == Blocks.field_150363_s)
/*  364 */           return 0; 
/*  365 */         if (p_151557_1_ == Blocks.field_150347_e)
/*  366 */           return 0; 
/*  367 */         if (p_151557_1_ == Blocks.field_150344_f) {
/*  368 */           return 2;
/*      */         }
/*      */       } 
/*  371 */       return p_151557_2_;
/*      */     }
/*      */ 
/*      */     
/*      */     protected void func_151550_a(World p_151550_1_, Block p_151550_2_, int p_151550_3_, int p_151550_4_, int p_151550_5_, int p_151550_6_, StructureBoundingBox p_151550_7_) {
/*  376 */       Block block = func_151558_b(p_151550_2_, p_151550_3_);
/*  377 */       int i = func_151557_c(p_151550_2_, p_151550_3_);
/*  378 */       super.func_151550_a(p_151550_1_, block, i, p_151550_4_, p_151550_5_, p_151550_6_, p_151550_7_);
/*      */     }
/*      */ 
/*      */     
/*      */     protected void func_151549_a(World p_151549_1_, StructureBoundingBox p_151549_2_, int p_151549_3_, int p_151549_4_, int p_151549_5_, int p_151549_6_, int p_151549_7_, int p_151549_8_, Block p_151549_9_, Block p_151549_10_, boolean p_151549_11_) {
/*  383 */       Block block1 = func_151558_b(p_151549_9_, 0);
/*  384 */       int i = func_151557_c(p_151549_9_, 0);
/*  385 */       Block block2 = func_151558_b(p_151549_10_, 0);
/*  386 */       int j = func_151557_c(p_151549_10_, 0);
/*  387 */       func_151556_a(p_151549_1_, p_151549_2_, p_151549_3_, p_151549_4_, p_151549_5_, p_151549_6_, p_151549_7_, p_151549_8_, block1, i, block2, j, p_151549_11_);
/*      */     }
/*      */ 
/*      */     
/*      */     protected void func_151554_b(World p_151554_1_, Block p_151554_2_, int p_151554_3_, int p_151554_4_, int p_151554_5_, int p_151554_6_, StructureBoundingBox p_151554_7_) {
/*  392 */       Block block = func_151558_b(p_151554_2_, p_151554_3_);
/*  393 */       int i = func_151557_c(p_151554_2_, p_151554_3_);
/*  394 */       super.func_151554_b(p_151554_1_, block, i, p_151554_4_, p_151554_5_, p_151554_6_, p_151554_7_);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public static class Well
/*      */     extends Village
/*      */   {
/*      */     private static final String __OBFID = "CL_00000533";
/*      */ 
/*      */     
/*      */     public Well() {}
/*      */ 
/*      */     
/*      */     public Well(StructureVillagePieces.Start p_i2109_1_, int p_i2109_2_, Random p_i2109_3_, int p_i2109_4_, int p_i2109_5_) {
/*  409 */       super(p_i2109_1_, p_i2109_2_);
/*      */       
/*  411 */       this.field_74885_f = p_i2109_3_.nextInt(4);
/*      */       
/*  413 */       switch (this.field_74885_f) {
/*      */         case 0:
/*      */         case 2:
/*  416 */           this.field_74887_e = new StructureBoundingBox(p_i2109_4_, 64, p_i2109_5_, p_i2109_4_ + 6 - 1, 78, p_i2109_5_ + 6 - 1);
/*      */           return;
/*      */       } 
/*  419 */       this.field_74887_e = new StructureBoundingBox(p_i2109_4_, 64, p_i2109_5_, p_i2109_4_ + 6 - 1, 78, p_i2109_5_ + 6 - 1);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_) {
/*  434 */       StructureVillagePieces.func_75080_e((StructureVillagePieces.Start)p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a - 1, this.field_74887_e.field_78894_e - 4, this.field_74887_e.field_78896_c + 1, 1, func_74877_c());
/*  435 */       StructureVillagePieces.func_75080_e((StructureVillagePieces.Start)p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78893_d + 1, this.field_74887_e.field_78894_e - 4, this.field_74887_e.field_78896_c + 1, 3, func_74877_c());
/*  436 */       StructureVillagePieces.func_75080_e((StructureVillagePieces.Start)p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a + 1, this.field_74887_e.field_78894_e - 4, this.field_74887_e.field_78896_c - 1, 2, func_74877_c());
/*  437 */       StructureVillagePieces.func_75080_e((StructureVillagePieces.Start)p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a + 1, this.field_74887_e.field_78894_e - 4, this.field_74887_e.field_78892_f + 1, 0, func_74877_c());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
/*  444 */       if (this.field_143015_k < 0) {
/*  445 */         this.field_143015_k = func_74889_b(p_74875_1_, p_74875_3_);
/*  446 */         if (this.field_143015_k < 0) {
/*  447 */           return true;
/*      */         }
/*  449 */         this.field_74887_e.func_78886_a(0, this.field_143015_k - this.field_74887_e.field_78894_e + 3, 0);
/*      */       } 
/*      */       
/*  452 */       func_151549_a(p_74875_1_, p_74875_3_, 1, 0, 1, 4, 12, 4, Blocks.field_150347_e, (Block)Blocks.field_150358_i, false);
/*  453 */       func_151550_a(p_74875_1_, Blocks.field_150350_a, 0, 2, 12, 2, p_74875_3_);
/*  454 */       func_151550_a(p_74875_1_, Blocks.field_150350_a, 0, 3, 12, 2, p_74875_3_);
/*  455 */       func_151550_a(p_74875_1_, Blocks.field_150350_a, 0, 2, 12, 3, p_74875_3_);
/*  456 */       func_151550_a(p_74875_1_, Blocks.field_150350_a, 0, 3, 12, 3, p_74875_3_);
/*      */       
/*  458 */       func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, 1, 13, 1, p_74875_3_);
/*  459 */       func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, 1, 14, 1, p_74875_3_);
/*  460 */       func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, 4, 13, 1, p_74875_3_);
/*  461 */       func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, 4, 14, 1, p_74875_3_);
/*  462 */       func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, 1, 13, 4, p_74875_3_);
/*  463 */       func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, 1, 14, 4, p_74875_3_);
/*  464 */       func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, 4, 13, 4, p_74875_3_);
/*  465 */       func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, 4, 14, 4, p_74875_3_);
/*  466 */       func_151549_a(p_74875_1_, p_74875_3_, 1, 15, 1, 4, 15, 4, Blocks.field_150347_e, Blocks.field_150347_e, false);
/*      */       
/*  468 */       for (byte b = 0; b <= 5; b++) {
/*  469 */         for (byte b1 = 0; b1 <= 5; b1++) {
/*      */           
/*  471 */           if (b1 == 0 || b1 == 5 || b == 0 || b == 5) {
/*      */ 
/*      */             
/*  474 */             func_151550_a(p_74875_1_, Blocks.field_150351_n, 0, b1, 11, b, p_74875_3_);
/*  475 */             func_74871_b(p_74875_1_, b1, 12, b, p_74875_3_);
/*      */           } 
/*      */         } 
/*      */       } 
/*  479 */       return true;
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public static class Start
/*      */     extends Well
/*      */   {
/*      */     public WorldChunkManager field_74929_a;
/*      */     
/*      */     public boolean field_74927_b;
/*      */     
/*      */     public int field_74928_c;
/*      */     
/*      */     public StructureVillagePieces.PieceWeight field_74926_d;
/*      */     public List field_74931_h;
/*  495 */     public List field_74932_i = new ArrayList();
/*  496 */     public List field_74930_j = new ArrayList();
/*      */     
/*      */     private static final String __OBFID = "CL_00000527";
/*      */ 
/*      */     
/*      */     public Start() {}
/*      */ 
/*      */     
/*      */     public Start(WorldChunkManager p_i2104_1_, int p_i2104_2_, Random p_i2104_3_, int p_i2104_4_, int p_i2104_5_, List p_i2104_6_, int p_i2104_7_) {
/*  505 */       super((Start)null, 0, p_i2104_3_, p_i2104_4_, p_i2104_5_);
/*  506 */       this.field_74929_a = p_i2104_1_;
/*  507 */       this.field_74931_h = p_i2104_6_;
/*  508 */       this.field_74928_c = p_i2104_7_;
/*      */       
/*  510 */       BiomeGenBase biomeGenBase = p_i2104_1_.func_76935_a(p_i2104_4_, p_i2104_5_);
/*  511 */       this.field_74927_b = (biomeGenBase == BiomeGenBase.field_76769_d || biomeGenBase == BiomeGenBase.field_76786_s);
/*      */     }
/*      */     
/*      */     public WorldChunkManager func_74925_d() {
/*  515 */       return this.field_74929_a;
/*      */     }
/*      */   }
/*      */   
/*      */   public static abstract class Road
/*      */     extends Village {
/*      */     private static final String __OBFID = "CL_00000532";
/*      */     
/*      */     public Road() {}
/*      */     
/*      */     protected Road(StructureVillagePieces.Start p_i2108_1_, int p_i2108_2_) {
/*  526 */       super(p_i2108_1_, p_i2108_2_);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public static class Path
/*      */     extends Road
/*      */   {
/*      */     private int field_74934_a;
/*      */     
/*      */     private static final String __OBFID = "CL_00000528";
/*      */     
/*      */     public Path() {}
/*      */     
/*      */     public Path(StructureVillagePieces.Start p_i2105_1_, int p_i2105_2_, Random p_i2105_3_, StructureBoundingBox p_i2105_4_, int p_i2105_5_) {
/*  541 */       super(p_i2105_1_, p_i2105_2_);
/*      */       
/*  543 */       this.field_74885_f = p_i2105_5_;
/*  544 */       this.field_74887_e = p_i2105_4_;
/*  545 */       this.field_74934_a = Math.max(p_i2105_4_.func_78883_b(), p_i2105_4_.func_78880_d());
/*      */     }
/*      */ 
/*      */     
/*      */     protected void func_143012_a(NBTTagCompound p_143012_1_) {
/*  550 */       super.func_143012_a(p_143012_1_);
/*  551 */       p_143012_1_.func_74768_a("Length", this.field_74934_a);
/*      */     }
/*      */ 
/*      */     
/*      */     protected void func_143011_b(NBTTagCompound p_143011_1_) {
/*  556 */       super.func_143011_b(p_143011_1_);
/*  557 */       this.field_74934_a = p_143011_1_.func_74762_e("Length");
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_) {
/*  563 */       boolean bool = false;
/*      */ 
/*      */       
/*  566 */       int i = p_74861_3_.nextInt(5);
/*  567 */       while (i < this.field_74934_a - 8) {
/*  568 */         StructureComponent structureComponent = func_74891_a((StructureVillagePieces.Start)p_74861_1_, p_74861_2_, p_74861_3_, 0, i);
/*  569 */         if (structureComponent != null) {
/*  570 */           i += Math.max(structureComponent.field_74887_e.func_78883_b(), structureComponent.field_74887_e.func_78880_d());
/*  571 */           bool = true;
/*      */         } 
/*  573 */         i += 2 + p_74861_3_.nextInt(5);
/*      */       } 
/*      */ 
/*      */       
/*  577 */       i = p_74861_3_.nextInt(5);
/*  578 */       while (i < this.field_74934_a - 8) {
/*  579 */         StructureComponent structureComponent = func_74894_b((StructureVillagePieces.Start)p_74861_1_, p_74861_2_, p_74861_3_, 0, i);
/*  580 */         if (structureComponent != null) {
/*  581 */           i += Math.max(structureComponent.field_74887_e.func_78883_b(), structureComponent.field_74887_e.func_78880_d());
/*  582 */           bool = true;
/*      */         } 
/*  584 */         i += 2 + p_74861_3_.nextInt(5);
/*      */       } 
/*      */       
/*  587 */       if (bool && p_74861_3_.nextInt(3) > 0) {
/*  588 */         switch (this.field_74885_f) {
/*      */           case 2:
/*  590 */             StructureVillagePieces.func_75080_e((StructureVillagePieces.Start)p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a - 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c, 1, func_74877_c());
/*      */             break;
/*      */           case 0:
/*  593 */             StructureVillagePieces.func_75080_e((StructureVillagePieces.Start)p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a - 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78892_f - 2, 1, func_74877_c());
/*      */             break;
/*      */           case 3:
/*  596 */             StructureVillagePieces.func_75080_e((StructureVillagePieces.Start)p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78893_d - 2, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c - 1, 2, func_74877_c());
/*      */             break;
/*      */           case 1:
/*  599 */             StructureVillagePieces.func_75080_e((StructureVillagePieces.Start)p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c - 1, 2, func_74877_c());
/*      */             break;
/*      */         } 
/*      */       }
/*  603 */       if (bool && p_74861_3_.nextInt(3) > 0) {
/*  604 */         switch (this.field_74885_f) {
/*      */           case 2:
/*  606 */             StructureVillagePieces.func_75080_e((StructureVillagePieces.Start)p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78893_d + 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c, 3, func_74877_c());
/*      */             break;
/*      */           case 0:
/*  609 */             StructureVillagePieces.func_75080_e((StructureVillagePieces.Start)p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78893_d + 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78892_f - 2, 3, func_74877_c());
/*      */             break;
/*      */           case 3:
/*  612 */             StructureVillagePieces.func_75080_e((StructureVillagePieces.Start)p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78893_d - 2, this.field_74887_e.field_78895_b, this.field_74887_e.field_78892_f + 1, 0, func_74877_c());
/*      */             break;
/*      */           case 1:
/*  615 */             StructureVillagePieces.func_75080_e((StructureVillagePieces.Start)p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a, this.field_74887_e.field_78895_b, this.field_74887_e.field_78892_f + 1, 0, func_74877_c());
/*      */             break;
/*      */         } 
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public static StructureBoundingBox func_74933_a(StructureVillagePieces.Start p_74933_0_, List p_74933_1_, Random p_74933_2_, int p_74933_3_, int p_74933_4_, int p_74933_5_, int p_74933_6_) {
/*  624 */       int i = 7 * MathHelper.func_76136_a(p_74933_2_, 3, 5);
/*      */       
/*  626 */       while (i >= 7) {
/*  627 */         StructureBoundingBox structureBoundingBox = StructureBoundingBox.func_78889_a(p_74933_3_, p_74933_4_, p_74933_5_, 0, 0, 0, 3, 3, i, p_74933_6_);
/*      */         
/*  629 */         if (StructureComponent.func_74883_a(p_74933_1_, structureBoundingBox) == null) {
/*  630 */           return structureBoundingBox;
/*      */         }
/*  632 */         i -= 7;
/*      */       } 
/*      */       
/*  635 */       return null;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
/*  640 */       Block block = func_151558_b(Blocks.field_150351_n, 0);
/*  641 */       for (int i = this.field_74887_e.field_78897_a; i <= this.field_74887_e.field_78893_d; i++) {
/*  642 */         for (int j = this.field_74887_e.field_78896_c; j <= this.field_74887_e.field_78892_f; j++) {
/*  643 */           if (p_74875_3_.func_78890_b(i, 64, j)) {
/*  644 */             int k = p_74875_1_.func_72825_h(i, j) - 1;
/*  645 */             p_74875_1_.func_147465_d(i, k, j, block, 0, 2);
/*      */           } 
/*      */         } 
/*      */       } 
/*      */       
/*  650 */       return true;
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public static class House4Garden
/*      */     extends Village
/*      */   {
/*      */     private boolean field_74913_b;
/*      */     
/*      */     private static final String __OBFID = "CL_00000523";
/*      */ 
/*      */     
/*      */     public House4Garden() {}
/*      */ 
/*      */     
/*      */     public House4Garden(StructureVillagePieces.Start p_i2100_1_, int p_i2100_2_, Random p_i2100_3_, StructureBoundingBox p_i2100_4_, int p_i2100_5_) {
/*  667 */       super(p_i2100_1_, p_i2100_2_);
/*      */       
/*  669 */       this.field_74885_f = p_i2100_5_;
/*  670 */       this.field_74887_e = p_i2100_4_;
/*  671 */       this.field_74913_b = p_i2100_3_.nextBoolean();
/*      */     }
/*      */ 
/*      */     
/*      */     protected void func_143012_a(NBTTagCompound p_143012_1_) {
/*  676 */       super.func_143012_a(p_143012_1_);
/*  677 */       p_143012_1_.func_74757_a("Terrace", this.field_74913_b);
/*      */     }
/*      */ 
/*      */     
/*      */     protected void func_143011_b(NBTTagCompound p_143011_1_) {
/*  682 */       super.func_143011_b(p_143011_1_);
/*  683 */       this.field_74913_b = p_143011_1_.func_74767_n("Terrace");
/*      */     }
/*      */ 
/*      */     
/*      */     public static House4Garden func_74912_a(StructureVillagePieces.Start p_74912_0_, List p_74912_1_, Random p_74912_2_, int p_74912_3_, int p_74912_4_, int p_74912_5_, int p_74912_6_, int p_74912_7_) {
/*  688 */       StructureBoundingBox structureBoundingBox = StructureBoundingBox.func_78889_a(p_74912_3_, p_74912_4_, p_74912_5_, 0, 0, 0, 5, 6, 5, p_74912_6_);
/*      */       
/*  690 */       if (StructureComponent.func_74883_a(p_74912_1_, structureBoundingBox) != null) {
/*  691 */         return null;
/*      */       }
/*      */       
/*  694 */       return new House4Garden(p_74912_0_, p_74912_7_, p_74912_2_, structureBoundingBox, p_74912_6_);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
/*  700 */       if (this.field_143015_k < 0) {
/*  701 */         this.field_143015_k = func_74889_b(p_74875_1_, p_74875_3_);
/*  702 */         if (this.field_143015_k < 0) {
/*  703 */           return true;
/*      */         }
/*  705 */         this.field_74887_e.func_78886_a(0, this.field_143015_k - this.field_74887_e.field_78894_e + 6 - 1, 0);
/*      */       } 
/*      */ 
/*      */       
/*  709 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 0, 0, 4, 0, 4, Blocks.field_150347_e, Blocks.field_150347_e, false);
/*      */       
/*  711 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 4, 0, 4, 4, 4, Blocks.field_150364_r, Blocks.field_150364_r, false);
/*  712 */       func_151549_a(p_74875_1_, p_74875_3_, 1, 4, 1, 3, 4, 3, Blocks.field_150344_f, Blocks.field_150344_f, false);
/*      */ 
/*      */       
/*  715 */       func_151550_a(p_74875_1_, Blocks.field_150347_e, 0, 0, 1, 0, p_74875_3_);
/*  716 */       func_151550_a(p_74875_1_, Blocks.field_150347_e, 0, 0, 2, 0, p_74875_3_);
/*  717 */       func_151550_a(p_74875_1_, Blocks.field_150347_e, 0, 0, 3, 0, p_74875_3_);
/*  718 */       func_151550_a(p_74875_1_, Blocks.field_150347_e, 0, 4, 1, 0, p_74875_3_);
/*  719 */       func_151550_a(p_74875_1_, Blocks.field_150347_e, 0, 4, 2, 0, p_74875_3_);
/*  720 */       func_151550_a(p_74875_1_, Blocks.field_150347_e, 0, 4, 3, 0, p_74875_3_);
/*  721 */       func_151550_a(p_74875_1_, Blocks.field_150347_e, 0, 0, 1, 4, p_74875_3_);
/*  722 */       func_151550_a(p_74875_1_, Blocks.field_150347_e, 0, 0, 2, 4, p_74875_3_);
/*  723 */       func_151550_a(p_74875_1_, Blocks.field_150347_e, 0, 0, 3, 4, p_74875_3_);
/*  724 */       func_151550_a(p_74875_1_, Blocks.field_150347_e, 0, 4, 1, 4, p_74875_3_);
/*  725 */       func_151550_a(p_74875_1_, Blocks.field_150347_e, 0, 4, 2, 4, p_74875_3_);
/*  726 */       func_151550_a(p_74875_1_, Blocks.field_150347_e, 0, 4, 3, 4, p_74875_3_);
/*  727 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 1, 1, 0, 3, 3, Blocks.field_150344_f, Blocks.field_150344_f, false);
/*  728 */       func_151549_a(p_74875_1_, p_74875_3_, 4, 1, 1, 4, 3, 3, Blocks.field_150344_f, Blocks.field_150344_f, false);
/*  729 */       func_151549_a(p_74875_1_, p_74875_3_, 1, 1, 4, 3, 3, 4, Blocks.field_150344_f, Blocks.field_150344_f, false);
/*  730 */       func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 0, 2, 2, p_74875_3_);
/*  731 */       func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 2, 2, 4, p_74875_3_);
/*  732 */       func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 4, 2, 2, p_74875_3_);
/*      */ 
/*      */       
/*  735 */       func_151550_a(p_74875_1_, Blocks.field_150344_f, 0, 1, 1, 0, p_74875_3_);
/*  736 */       func_151550_a(p_74875_1_, Blocks.field_150344_f, 0, 1, 2, 0, p_74875_3_);
/*  737 */       func_151550_a(p_74875_1_, Blocks.field_150344_f, 0, 1, 3, 0, p_74875_3_);
/*  738 */       func_151550_a(p_74875_1_, Blocks.field_150344_f, 0, 2, 3, 0, p_74875_3_);
/*  739 */       func_151550_a(p_74875_1_, Blocks.field_150344_f, 0, 3, 3, 0, p_74875_3_);
/*  740 */       func_151550_a(p_74875_1_, Blocks.field_150344_f, 0, 3, 2, 0, p_74875_3_);
/*  741 */       func_151550_a(p_74875_1_, Blocks.field_150344_f, 0, 3, 1, 0, p_74875_3_);
/*  742 */       if (func_151548_a(p_74875_1_, 2, 0, -1, p_74875_3_).func_149688_o() == Material.field_151579_a && func_151548_a(p_74875_1_, 2, -1, -1, p_74875_3_).func_149688_o() != Material.field_151579_a) {
/*  743 */         func_151550_a(p_74875_1_, Blocks.field_150446_ar, func_151555_a(Blocks.field_150446_ar, 3), 2, 0, -1, p_74875_3_);
/*      */       }
/*      */ 
/*      */       
/*  747 */       func_151549_a(p_74875_1_, p_74875_3_, 1, 1, 1, 3, 3, 3, Blocks.field_150350_a, Blocks.field_150350_a, false);
/*      */ 
/*      */       
/*  750 */       if (this.field_74913_b) {
/*  751 */         func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, 0, 5, 0, p_74875_3_);
/*  752 */         func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, 1, 5, 0, p_74875_3_);
/*  753 */         func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, 2, 5, 0, p_74875_3_);
/*  754 */         func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, 3, 5, 0, p_74875_3_);
/*  755 */         func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, 4, 5, 0, p_74875_3_);
/*  756 */         func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, 0, 5, 4, p_74875_3_);
/*  757 */         func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, 1, 5, 4, p_74875_3_);
/*  758 */         func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, 2, 5, 4, p_74875_3_);
/*  759 */         func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, 3, 5, 4, p_74875_3_);
/*  760 */         func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, 4, 5, 4, p_74875_3_);
/*  761 */         func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, 4, 5, 1, p_74875_3_);
/*  762 */         func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, 4, 5, 2, p_74875_3_);
/*  763 */         func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, 4, 5, 3, p_74875_3_);
/*  764 */         func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, 0, 5, 1, p_74875_3_);
/*  765 */         func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, 0, 5, 2, p_74875_3_);
/*  766 */         func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, 0, 5, 3, p_74875_3_);
/*      */       } 
/*      */ 
/*      */       
/*  770 */       if (this.field_74913_b) {
/*  771 */         int i = func_151555_a(Blocks.field_150468_ap, 3);
/*  772 */         func_151550_a(p_74875_1_, Blocks.field_150468_ap, i, 3, 1, 3, p_74875_3_);
/*  773 */         func_151550_a(p_74875_1_, Blocks.field_150468_ap, i, 3, 2, 3, p_74875_3_);
/*  774 */         func_151550_a(p_74875_1_, Blocks.field_150468_ap, i, 3, 3, 3, p_74875_3_);
/*  775 */         func_151550_a(p_74875_1_, Blocks.field_150468_ap, i, 3, 4, 3, p_74875_3_);
/*      */       } 
/*      */ 
/*      */       
/*  779 */       func_151550_a(p_74875_1_, Blocks.field_150478_aa, 0, 2, 3, 1, p_74875_3_);
/*      */       
/*  781 */       for (byte b = 0; b < 5; b++) {
/*  782 */         for (byte b1 = 0; b1 < 5; b1++) {
/*  783 */           func_74871_b(p_74875_1_, b1, 6, b, p_74875_3_);
/*  784 */           func_151554_b(p_74875_1_, Blocks.field_150347_e, 0, b1, -1, b, p_74875_3_);
/*      */         } 
/*      */       } 
/*      */       
/*  788 */       func_74893_a(p_74875_1_, p_74875_3_, 1, 1, 2, 1);
/*      */       
/*  790 */       return true;
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public static class Church
/*      */     extends Village
/*      */   {
/*      */     private static final String __OBFID = "CL_00000525";
/*      */ 
/*      */     
/*      */     public Church() {}
/*      */ 
/*      */     
/*      */     public Church(StructureVillagePieces.Start p_i2102_1_, int p_i2102_2_, Random p_i2102_3_, StructureBoundingBox p_i2102_4_, int p_i2102_5_) {
/*  805 */       super(p_i2102_1_, p_i2102_2_);
/*      */       
/*  807 */       this.field_74885_f = p_i2102_5_;
/*  808 */       this.field_74887_e = p_i2102_4_;
/*      */     }
/*      */ 
/*      */     
/*      */     public static Church func_74919_a(StructureVillagePieces.Start p_74919_0_, List p_74919_1_, Random p_74919_2_, int p_74919_3_, int p_74919_4_, int p_74919_5_, int p_74919_6_, int p_74919_7_) {
/*  813 */       StructureBoundingBox structureBoundingBox = StructureBoundingBox.func_78889_a(p_74919_3_, p_74919_4_, p_74919_5_, 0, 0, 0, 5, 12, 9, p_74919_6_);
/*      */       
/*  815 */       if (!func_74895_a(structureBoundingBox) || StructureComponent.func_74883_a(p_74919_1_, structureBoundingBox) != null) {
/*  816 */         return null;
/*      */       }
/*      */       
/*  819 */       return new Church(p_74919_0_, p_74919_7_, p_74919_2_, structureBoundingBox, p_74919_6_);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
/*  825 */       if (this.field_143015_k < 0) {
/*  826 */         this.field_143015_k = func_74889_b(p_74875_1_, p_74875_3_);
/*  827 */         if (this.field_143015_k < 0) {
/*  828 */           return true;
/*      */         }
/*  830 */         this.field_74887_e.func_78886_a(0, this.field_143015_k - this.field_74887_e.field_78894_e + 12 - 1, 0);
/*      */       } 
/*      */ 
/*      */       
/*  834 */       func_151549_a(p_74875_1_, p_74875_3_, 1, 1, 1, 3, 3, 7, Blocks.field_150350_a, Blocks.field_150350_a, false);
/*  835 */       func_151549_a(p_74875_1_, p_74875_3_, 1, 5, 1, 3, 9, 3, Blocks.field_150350_a, Blocks.field_150350_a, false);
/*      */ 
/*      */       
/*  838 */       func_151549_a(p_74875_1_, p_74875_3_, 1, 0, 0, 3, 0, 8, Blocks.field_150347_e, Blocks.field_150347_e, false);
/*      */ 
/*      */       
/*  841 */       func_151549_a(p_74875_1_, p_74875_3_, 1, 1, 0, 3, 10, 0, Blocks.field_150347_e, Blocks.field_150347_e, false);
/*      */       
/*  843 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 1, 1, 0, 10, 3, Blocks.field_150347_e, Blocks.field_150347_e, false);
/*      */       
/*  845 */       func_151549_a(p_74875_1_, p_74875_3_, 4, 1, 1, 4, 10, 3, Blocks.field_150347_e, Blocks.field_150347_e, false);
/*      */       
/*  847 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 0, 4, 0, 4, 7, Blocks.field_150347_e, Blocks.field_150347_e, false);
/*      */       
/*  849 */       func_151549_a(p_74875_1_, p_74875_3_, 4, 0, 4, 4, 4, 7, Blocks.field_150347_e, Blocks.field_150347_e, false);
/*      */       
/*  851 */       func_151549_a(p_74875_1_, p_74875_3_, 1, 1, 8, 3, 4, 8, Blocks.field_150347_e, Blocks.field_150347_e, false);
/*      */       
/*  853 */       func_151549_a(p_74875_1_, p_74875_3_, 1, 5, 4, 3, 10, 4, Blocks.field_150347_e, Blocks.field_150347_e, false);
/*      */ 
/*      */       
/*  856 */       func_151549_a(p_74875_1_, p_74875_3_, 1, 5, 5, 3, 5, 7, Blocks.field_150347_e, Blocks.field_150347_e, false);
/*      */       
/*  858 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 9, 0, 4, 9, 4, Blocks.field_150347_e, Blocks.field_150347_e, false);
/*      */       
/*  860 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 4, 0, 4, 4, 4, Blocks.field_150347_e, Blocks.field_150347_e, false);
/*  861 */       func_151550_a(p_74875_1_, Blocks.field_150347_e, 0, 0, 11, 2, p_74875_3_);
/*  862 */       func_151550_a(p_74875_1_, Blocks.field_150347_e, 0, 4, 11, 2, p_74875_3_);
/*  863 */       func_151550_a(p_74875_1_, Blocks.field_150347_e, 0, 2, 11, 0, p_74875_3_);
/*  864 */       func_151550_a(p_74875_1_, Blocks.field_150347_e, 0, 2, 11, 4, p_74875_3_);
/*      */ 
/*      */       
/*  867 */       func_151550_a(p_74875_1_, Blocks.field_150347_e, 0, 1, 1, 6, p_74875_3_);
/*  868 */       func_151550_a(p_74875_1_, Blocks.field_150347_e, 0, 1, 1, 7, p_74875_3_);
/*  869 */       func_151550_a(p_74875_1_, Blocks.field_150347_e, 0, 2, 1, 7, p_74875_3_);
/*  870 */       func_151550_a(p_74875_1_, Blocks.field_150347_e, 0, 3, 1, 6, p_74875_3_);
/*  871 */       func_151550_a(p_74875_1_, Blocks.field_150347_e, 0, 3, 1, 7, p_74875_3_);
/*  872 */       func_151550_a(p_74875_1_, Blocks.field_150446_ar, func_151555_a(Blocks.field_150446_ar, 3), 1, 1, 5, p_74875_3_);
/*  873 */       func_151550_a(p_74875_1_, Blocks.field_150446_ar, func_151555_a(Blocks.field_150446_ar, 3), 2, 1, 6, p_74875_3_);
/*  874 */       func_151550_a(p_74875_1_, Blocks.field_150446_ar, func_151555_a(Blocks.field_150446_ar, 3), 3, 1, 5, p_74875_3_);
/*  875 */       func_151550_a(p_74875_1_, Blocks.field_150446_ar, func_151555_a(Blocks.field_150446_ar, 1), 1, 2, 7, p_74875_3_);
/*  876 */       func_151550_a(p_74875_1_, Blocks.field_150446_ar, func_151555_a(Blocks.field_150446_ar, 0), 3, 2, 7, p_74875_3_);
/*      */ 
/*      */       
/*  879 */       func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 0, 2, 2, p_74875_3_);
/*  880 */       func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 0, 3, 2, p_74875_3_);
/*  881 */       func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 4, 2, 2, p_74875_3_);
/*  882 */       func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 4, 3, 2, p_74875_3_);
/*  883 */       func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 0, 6, 2, p_74875_3_);
/*  884 */       func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 0, 7, 2, p_74875_3_);
/*  885 */       func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 4, 6, 2, p_74875_3_);
/*  886 */       func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 4, 7, 2, p_74875_3_);
/*  887 */       func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 2, 6, 0, p_74875_3_);
/*  888 */       func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 2, 7, 0, p_74875_3_);
/*  889 */       func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 2, 6, 4, p_74875_3_);
/*  890 */       func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 2, 7, 4, p_74875_3_);
/*  891 */       func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 0, 3, 6, p_74875_3_);
/*  892 */       func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 4, 3, 6, p_74875_3_);
/*  893 */       func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 2, 3, 8, p_74875_3_);
/*      */ 
/*      */       
/*  896 */       func_151550_a(p_74875_1_, Blocks.field_150478_aa, 0, 2, 4, 7, p_74875_3_);
/*  897 */       func_151550_a(p_74875_1_, Blocks.field_150478_aa, 0, 1, 4, 6, p_74875_3_);
/*  898 */       func_151550_a(p_74875_1_, Blocks.field_150478_aa, 0, 3, 4, 6, p_74875_3_);
/*  899 */       func_151550_a(p_74875_1_, Blocks.field_150478_aa, 0, 2, 4, 5, p_74875_3_);
/*      */ 
/*      */       
/*  902 */       int i = func_151555_a(Blocks.field_150468_ap, 4); byte b;
/*  903 */       for (b = 1; b <= 9; b++) {
/*  904 */         func_151550_a(p_74875_1_, Blocks.field_150468_ap, i, 3, b, 3, p_74875_3_);
/*      */       }
/*      */ 
/*      */       
/*  908 */       func_151550_a(p_74875_1_, Blocks.field_150350_a, 0, 2, 1, 0, p_74875_3_);
/*  909 */       func_151550_a(p_74875_1_, Blocks.field_150350_a, 0, 2, 2, 0, p_74875_3_);
/*  910 */       func_74881_a(p_74875_1_, p_74875_3_, p_74875_2_, 2, 1, 0, func_151555_a(Blocks.field_150466_ao, 1));
/*  911 */       if (func_151548_a(p_74875_1_, 2, 0, -1, p_74875_3_).func_149688_o() == Material.field_151579_a && func_151548_a(p_74875_1_, 2, -1, -1, p_74875_3_).func_149688_o() != Material.field_151579_a) {
/*  912 */         func_151550_a(p_74875_1_, Blocks.field_150446_ar, func_151555_a(Blocks.field_150446_ar, 3), 2, 0, -1, p_74875_3_);
/*      */       }
/*      */       
/*  915 */       for (b = 0; b < 9; b++) {
/*  916 */         for (byte b1 = 0; b1 < 5; b1++) {
/*  917 */           func_74871_b(p_74875_1_, b1, 12, b, p_74875_3_);
/*  918 */           func_151554_b(p_74875_1_, Blocks.field_150347_e, 0, b1, -1, b, p_74875_3_);
/*      */         } 
/*      */       } 
/*      */       
/*  922 */       func_74893_a(p_74875_1_, p_74875_3_, 2, 1, 2, 1);
/*      */       
/*  924 */       return true;
/*      */     }
/*      */ 
/*      */     
/*      */     protected int func_74888_b(int p_74888_1_) {
/*  929 */       return 2;
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public static class House1
/*      */     extends Village
/*      */   {
/*      */     private static final String __OBFID = "CL_00000517";
/*      */ 
/*      */     
/*      */     public House1() {}
/*      */ 
/*      */     
/*      */     public House1(StructureVillagePieces.Start p_i2094_1_, int p_i2094_2_, Random p_i2094_3_, StructureBoundingBox p_i2094_4_, int p_i2094_5_) {
/*  944 */       super(p_i2094_1_, p_i2094_2_);
/*      */       
/*  946 */       this.field_74885_f = p_i2094_5_;
/*  947 */       this.field_74887_e = p_i2094_4_;
/*      */     }
/*      */ 
/*      */     
/*      */     public static House1 func_74898_a(StructureVillagePieces.Start p_74898_0_, List p_74898_1_, Random p_74898_2_, int p_74898_3_, int p_74898_4_, int p_74898_5_, int p_74898_6_, int p_74898_7_) {
/*  952 */       StructureBoundingBox structureBoundingBox = StructureBoundingBox.func_78889_a(p_74898_3_, p_74898_4_, p_74898_5_, 0, 0, 0, 9, 9, 6, p_74898_6_);
/*      */       
/*  954 */       if (!func_74895_a(structureBoundingBox) || StructureComponent.func_74883_a(p_74898_1_, structureBoundingBox) != null) {
/*  955 */         return null;
/*      */       }
/*      */       
/*  958 */       return new House1(p_74898_0_, p_74898_7_, p_74898_2_, structureBoundingBox, p_74898_6_);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
/*  964 */       if (this.field_143015_k < 0) {
/*  965 */         this.field_143015_k = func_74889_b(p_74875_1_, p_74875_3_);
/*  966 */         if (this.field_143015_k < 0) {
/*  967 */           return true;
/*      */         }
/*  969 */         this.field_74887_e.func_78886_a(0, this.field_143015_k - this.field_74887_e.field_78894_e + 9 - 1, 0);
/*      */       } 
/*      */ 
/*      */       
/*  973 */       func_151549_a(p_74875_1_, p_74875_3_, 1, 1, 1, 7, 5, 4, Blocks.field_150350_a, Blocks.field_150350_a, false);
/*      */ 
/*      */       
/*  976 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 0, 0, 8, 0, 5, Blocks.field_150347_e, Blocks.field_150347_e, false);
/*      */       
/*  978 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 5, 0, 8, 5, 5, Blocks.field_150347_e, Blocks.field_150347_e, false);
/*  979 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 6, 1, 8, 6, 4, Blocks.field_150347_e, Blocks.field_150347_e, false);
/*  980 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 7, 2, 8, 7, 3, Blocks.field_150347_e, Blocks.field_150347_e, false);
/*  981 */       int i = func_151555_a(Blocks.field_150476_ad, 3);
/*  982 */       int j = func_151555_a(Blocks.field_150476_ad, 2); int k;
/*  983 */       for (k = -1; k <= 2; k++) {
/*  984 */         for (byte b1 = 0; b1 <= 8; b1++) {
/*  985 */           func_151550_a(p_74875_1_, Blocks.field_150476_ad, i, b1, 6 + k, k, p_74875_3_);
/*  986 */           func_151550_a(p_74875_1_, Blocks.field_150476_ad, j, b1, 6 + k, 5 - k, p_74875_3_);
/*      */         } 
/*      */       } 
/*      */ 
/*      */       
/*  991 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 1, 0, 0, 1, 5, Blocks.field_150347_e, Blocks.field_150347_e, false);
/*  992 */       func_151549_a(p_74875_1_, p_74875_3_, 1, 1, 5, 8, 1, 5, Blocks.field_150347_e, Blocks.field_150347_e, false);
/*  993 */       func_151549_a(p_74875_1_, p_74875_3_, 8, 1, 0, 8, 1, 4, Blocks.field_150347_e, Blocks.field_150347_e, false);
/*  994 */       func_151549_a(p_74875_1_, p_74875_3_, 2, 1, 0, 7, 1, 0, Blocks.field_150347_e, Blocks.field_150347_e, false);
/*  995 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 2, 0, 0, 4, 0, Blocks.field_150347_e, Blocks.field_150347_e, false);
/*  996 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 2, 5, 0, 4, 5, Blocks.field_150347_e, Blocks.field_150347_e, false);
/*  997 */       func_151549_a(p_74875_1_, p_74875_3_, 8, 2, 5, 8, 4, 5, Blocks.field_150347_e, Blocks.field_150347_e, false);
/*  998 */       func_151549_a(p_74875_1_, p_74875_3_, 8, 2, 0, 8, 4, 0, Blocks.field_150347_e, Blocks.field_150347_e, false);
/*      */ 
/*      */       
/* 1001 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 2, 1, 0, 4, 4, Blocks.field_150344_f, Blocks.field_150344_f, false);
/* 1002 */       func_151549_a(p_74875_1_, p_74875_3_, 1, 2, 5, 7, 4, 5, Blocks.field_150344_f, Blocks.field_150344_f, false);
/* 1003 */       func_151549_a(p_74875_1_, p_74875_3_, 8, 2, 1, 8, 4, 4, Blocks.field_150344_f, Blocks.field_150344_f, false);
/* 1004 */       func_151549_a(p_74875_1_, p_74875_3_, 1, 2, 0, 7, 4, 0, Blocks.field_150344_f, Blocks.field_150344_f, false);
/*      */ 
/*      */       
/* 1007 */       func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 4, 2, 0, p_74875_3_);
/* 1008 */       func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 5, 2, 0, p_74875_3_);
/* 1009 */       func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 6, 2, 0, p_74875_3_);
/* 1010 */       func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 4, 3, 0, p_74875_3_);
/* 1011 */       func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 5, 3, 0, p_74875_3_);
/* 1012 */       func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 6, 3, 0, p_74875_3_);
/* 1013 */       func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 0, 2, 2, p_74875_3_);
/* 1014 */       func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 0, 2, 3, p_74875_3_);
/* 1015 */       func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 0, 3, 2, p_74875_3_);
/* 1016 */       func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 0, 3, 3, p_74875_3_);
/* 1017 */       func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 8, 2, 2, p_74875_3_);
/* 1018 */       func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 8, 2, 3, p_74875_3_);
/* 1019 */       func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 8, 3, 2, p_74875_3_);
/* 1020 */       func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 8, 3, 3, p_74875_3_);
/* 1021 */       func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 2, 2, 5, p_74875_3_);
/* 1022 */       func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 3, 2, 5, p_74875_3_);
/* 1023 */       func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 5, 2, 5, p_74875_3_);
/* 1024 */       func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 6, 2, 5, p_74875_3_);
/*      */ 
/*      */       
/* 1027 */       func_151549_a(p_74875_1_, p_74875_3_, 1, 4, 1, 7, 4, 1, Blocks.field_150344_f, Blocks.field_150344_f, false);
/* 1028 */       func_151549_a(p_74875_1_, p_74875_3_, 1, 4, 4, 7, 4, 4, Blocks.field_150344_f, Blocks.field_150344_f, false);
/* 1029 */       func_151549_a(p_74875_1_, p_74875_3_, 1, 3, 4, 7, 3, 4, Blocks.field_150342_X, Blocks.field_150342_X, false);
/*      */ 
/*      */       
/* 1032 */       func_151550_a(p_74875_1_, Blocks.field_150344_f, 0, 7, 1, 4, p_74875_3_);
/* 1033 */       func_151550_a(p_74875_1_, Blocks.field_150476_ad, func_151555_a(Blocks.field_150476_ad, 0), 7, 1, 3, p_74875_3_);
/* 1034 */       k = func_151555_a(Blocks.field_150476_ad, 3);
/* 1035 */       func_151550_a(p_74875_1_, Blocks.field_150476_ad, k, 6, 1, 4, p_74875_3_);
/* 1036 */       func_151550_a(p_74875_1_, Blocks.field_150476_ad, k, 5, 1, 4, p_74875_3_);
/* 1037 */       func_151550_a(p_74875_1_, Blocks.field_150476_ad, k, 4, 1, 4, p_74875_3_);
/* 1038 */       func_151550_a(p_74875_1_, Blocks.field_150476_ad, k, 3, 1, 4, p_74875_3_);
/*      */ 
/*      */       
/* 1041 */       func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, 6, 1, 3, p_74875_3_);
/* 1042 */       func_151550_a(p_74875_1_, Blocks.field_150452_aw, 0, 6, 2, 3, p_74875_3_);
/* 1043 */       func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, 4, 1, 3, p_74875_3_);
/* 1044 */       func_151550_a(p_74875_1_, Blocks.field_150452_aw, 0, 4, 2, 3, p_74875_3_);
/* 1045 */       func_151550_a(p_74875_1_, Blocks.field_150462_ai, 0, 7, 1, 1, p_74875_3_);
/*      */ 
/*      */       
/* 1048 */       func_151550_a(p_74875_1_, Blocks.field_150350_a, 0, 1, 1, 0, p_74875_3_);
/* 1049 */       func_151550_a(p_74875_1_, Blocks.field_150350_a, 0, 1, 2, 0, p_74875_3_);
/* 1050 */       func_74881_a(p_74875_1_, p_74875_3_, p_74875_2_, 1, 1, 0, func_151555_a(Blocks.field_150466_ao, 1));
/* 1051 */       if (func_151548_a(p_74875_1_, 1, 0, -1, p_74875_3_).func_149688_o() == Material.field_151579_a && func_151548_a(p_74875_1_, 1, -1, -1, p_74875_3_).func_149688_o() != Material.field_151579_a) {
/* 1052 */         func_151550_a(p_74875_1_, Blocks.field_150446_ar, func_151555_a(Blocks.field_150446_ar, 3), 1, 0, -1, p_74875_3_);
/*      */       }
/*      */       
/* 1055 */       for (byte b = 0; b < 6; b++) {
/* 1056 */         for (byte b1 = 0; b1 < 9; b1++) {
/* 1057 */           func_74871_b(p_74875_1_, b1, 9, b, p_74875_3_);
/* 1058 */           func_151554_b(p_74875_1_, Blocks.field_150347_e, 0, b1, -1, b, p_74875_3_);
/*      */         } 
/*      */       } 
/*      */       
/* 1062 */       func_74893_a(p_74875_1_, p_74875_3_, 2, 1, 2, 1);
/*      */       
/* 1064 */       return true;
/*      */     }
/*      */ 
/*      */     
/*      */     protected int func_74888_b(int p_74888_1_) {
/* 1069 */       return 1;
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public static class WoodHut
/*      */     extends Village
/*      */   {
/*      */     private boolean field_74909_b;
/*      */     
/*      */     private int field_74910_c;
/*      */     
/*      */     private static final String __OBFID = "CL_00000524";
/*      */ 
/*      */     
/*      */     public WoodHut() {}
/*      */     
/*      */     public WoodHut(StructureVillagePieces.Start p_i2101_1_, int p_i2101_2_, Random p_i2101_3_, StructureBoundingBox p_i2101_4_, int p_i2101_5_) {
/* 1087 */       super(p_i2101_1_, p_i2101_2_);
/*      */       
/* 1089 */       this.field_74885_f = p_i2101_5_;
/* 1090 */       this.field_74887_e = p_i2101_4_;
/* 1091 */       this.field_74909_b = p_i2101_3_.nextBoolean();
/* 1092 */       this.field_74910_c = p_i2101_3_.nextInt(3);
/*      */     }
/*      */ 
/*      */     
/*      */     protected void func_143012_a(NBTTagCompound p_143012_1_) {
/* 1097 */       super.func_143012_a(p_143012_1_);
/* 1098 */       p_143012_1_.func_74768_a("T", this.field_74910_c);
/* 1099 */       p_143012_1_.func_74757_a("C", this.field_74909_b);
/*      */     }
/*      */ 
/*      */     
/*      */     protected void func_143011_b(NBTTagCompound p_143011_1_) {
/* 1104 */       super.func_143011_b(p_143011_1_);
/* 1105 */       this.field_74910_c = p_143011_1_.func_74762_e("T");
/* 1106 */       this.field_74909_b = p_143011_1_.func_74767_n("C");
/*      */     }
/*      */ 
/*      */     
/*      */     public static WoodHut func_74908_a(StructureVillagePieces.Start p_74908_0_, List p_74908_1_, Random p_74908_2_, int p_74908_3_, int p_74908_4_, int p_74908_5_, int p_74908_6_, int p_74908_7_) {
/* 1111 */       StructureBoundingBox structureBoundingBox = StructureBoundingBox.func_78889_a(p_74908_3_, p_74908_4_, p_74908_5_, 0, 0, 0, 4, 6, 5, p_74908_6_);
/*      */       
/* 1113 */       if (!func_74895_a(structureBoundingBox) || StructureComponent.func_74883_a(p_74908_1_, structureBoundingBox) != null) {
/* 1114 */         return null;
/*      */       }
/*      */       
/* 1117 */       return new WoodHut(p_74908_0_, p_74908_7_, p_74908_2_, structureBoundingBox, p_74908_6_);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
/* 1123 */       if (this.field_143015_k < 0) {
/* 1124 */         this.field_143015_k = func_74889_b(p_74875_1_, p_74875_3_);
/* 1125 */         if (this.field_143015_k < 0) {
/* 1126 */           return true;
/*      */         }
/* 1128 */         this.field_74887_e.func_78886_a(0, this.field_143015_k - this.field_74887_e.field_78894_e + 6 - 1, 0);
/*      */       } 
/*      */ 
/*      */       
/* 1132 */       func_151549_a(p_74875_1_, p_74875_3_, 1, 1, 1, 3, 5, 4, Blocks.field_150350_a, Blocks.field_150350_a, false);
/*      */ 
/*      */       
/* 1135 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 0, 0, 3, 0, 4, Blocks.field_150347_e, Blocks.field_150347_e, false);
/* 1136 */       func_151549_a(p_74875_1_, p_74875_3_, 1, 0, 1, 2, 0, 3, Blocks.field_150346_d, Blocks.field_150346_d, false);
/*      */       
/* 1138 */       if (this.field_74909_b) {
/* 1139 */         func_151549_a(p_74875_1_, p_74875_3_, 1, 4, 1, 2, 4, 3, Blocks.field_150364_r, Blocks.field_150364_r, false);
/*      */       } else {
/* 1141 */         func_151549_a(p_74875_1_, p_74875_3_, 1, 5, 1, 2, 5, 3, Blocks.field_150364_r, Blocks.field_150364_r, false);
/*      */       } 
/* 1143 */       func_151550_a(p_74875_1_, Blocks.field_150364_r, 0, 1, 4, 0, p_74875_3_);
/* 1144 */       func_151550_a(p_74875_1_, Blocks.field_150364_r, 0, 2, 4, 0, p_74875_3_);
/* 1145 */       func_151550_a(p_74875_1_, Blocks.field_150364_r, 0, 1, 4, 4, p_74875_3_);
/* 1146 */       func_151550_a(p_74875_1_, Blocks.field_150364_r, 0, 2, 4, 4, p_74875_3_);
/* 1147 */       func_151550_a(p_74875_1_, Blocks.field_150364_r, 0, 0, 4, 1, p_74875_3_);
/* 1148 */       func_151550_a(p_74875_1_, Blocks.field_150364_r, 0, 0, 4, 2, p_74875_3_);
/* 1149 */       func_151550_a(p_74875_1_, Blocks.field_150364_r, 0, 0, 4, 3, p_74875_3_);
/* 1150 */       func_151550_a(p_74875_1_, Blocks.field_150364_r, 0, 3, 4, 1, p_74875_3_);
/* 1151 */       func_151550_a(p_74875_1_, Blocks.field_150364_r, 0, 3, 4, 2, p_74875_3_);
/* 1152 */       func_151550_a(p_74875_1_, Blocks.field_150364_r, 0, 3, 4, 3, p_74875_3_);
/*      */ 
/*      */       
/* 1155 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 1, 0, 0, 3, 0, Blocks.field_150364_r, Blocks.field_150364_r, false);
/* 1156 */       func_151549_a(p_74875_1_, p_74875_3_, 3, 1, 0, 3, 3, 0, Blocks.field_150364_r, Blocks.field_150364_r, false);
/* 1157 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 1, 4, 0, 3, 4, Blocks.field_150364_r, Blocks.field_150364_r, false);
/* 1158 */       func_151549_a(p_74875_1_, p_74875_3_, 3, 1, 4, 3, 3, 4, Blocks.field_150364_r, Blocks.field_150364_r, false);
/*      */ 
/*      */       
/* 1161 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 1, 1, 0, 3, 3, Blocks.field_150344_f, Blocks.field_150344_f, false);
/* 1162 */       func_151549_a(p_74875_1_, p_74875_3_, 3, 1, 1, 3, 3, 3, Blocks.field_150344_f, Blocks.field_150344_f, false);
/* 1163 */       func_151549_a(p_74875_1_, p_74875_3_, 1, 1, 0, 2, 3, 0, Blocks.field_150344_f, Blocks.field_150344_f, false);
/* 1164 */       func_151549_a(p_74875_1_, p_74875_3_, 1, 1, 4, 2, 3, 4, Blocks.field_150344_f, Blocks.field_150344_f, false);
/*      */ 
/*      */       
/* 1167 */       func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 0, 2, 2, p_74875_3_);
/* 1168 */       func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 3, 2, 2, p_74875_3_);
/*      */ 
/*      */       
/* 1171 */       if (this.field_74910_c > 0) {
/* 1172 */         func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, this.field_74910_c, 1, 3, p_74875_3_);
/* 1173 */         func_151550_a(p_74875_1_, Blocks.field_150452_aw, 0, this.field_74910_c, 2, 3, p_74875_3_);
/*      */       } 
/*      */ 
/*      */       
/* 1177 */       func_151550_a(p_74875_1_, Blocks.field_150350_a, 0, 1, 1, 0, p_74875_3_);
/* 1178 */       func_151550_a(p_74875_1_, Blocks.field_150350_a, 0, 1, 2, 0, p_74875_3_);
/* 1179 */       func_74881_a(p_74875_1_, p_74875_3_, p_74875_2_, 1, 1, 0, func_151555_a(Blocks.field_150466_ao, 1));
/* 1180 */       if (func_151548_a(p_74875_1_, 1, 0, -1, p_74875_3_).func_149688_o() == Material.field_151579_a && func_151548_a(p_74875_1_, 1, -1, -1, p_74875_3_).func_149688_o() != Material.field_151579_a) {
/* 1181 */         func_151550_a(p_74875_1_, Blocks.field_150446_ar, func_151555_a(Blocks.field_150446_ar, 3), 1, 0, -1, p_74875_3_);
/*      */       }
/*      */       
/* 1184 */       for (byte b = 0; b < 5; b++) {
/* 1185 */         for (byte b1 = 0; b1 < 4; b1++) {
/* 1186 */           func_74871_b(p_74875_1_, b1, 6, b, p_74875_3_);
/* 1187 */           func_151554_b(p_74875_1_, Blocks.field_150347_e, 0, b1, -1, b, p_74875_3_);
/*      */         } 
/*      */       } 
/*      */       
/* 1191 */       func_74893_a(p_74875_1_, p_74875_3_, 1, 1, 2, 1);
/*      */       
/* 1193 */       return true;
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public static class Hall
/*      */     extends Village
/*      */   {
/*      */     private static final String __OBFID = "CL_00000522";
/*      */ 
/*      */     
/*      */     public Hall() {}
/*      */ 
/*      */     
/*      */     public Hall(StructureVillagePieces.Start p_i2099_1_, int p_i2099_2_, Random p_i2099_3_, StructureBoundingBox p_i2099_4_, int p_i2099_5_) {
/* 1208 */       super(p_i2099_1_, p_i2099_2_);
/*      */       
/* 1210 */       this.field_74885_f = p_i2099_5_;
/* 1211 */       this.field_74887_e = p_i2099_4_;
/*      */     }
/*      */ 
/*      */     
/*      */     public static Hall func_74906_a(StructureVillagePieces.Start p_74906_0_, List p_74906_1_, Random p_74906_2_, int p_74906_3_, int p_74906_4_, int p_74906_5_, int p_74906_6_, int p_74906_7_) {
/* 1216 */       StructureBoundingBox structureBoundingBox = StructureBoundingBox.func_78889_a(p_74906_3_, p_74906_4_, p_74906_5_, 0, 0, 0, 9, 7, 11, p_74906_6_);
/*      */       
/* 1218 */       if (!func_74895_a(structureBoundingBox) || StructureComponent.func_74883_a(p_74906_1_, structureBoundingBox) != null) {
/* 1219 */         return null;
/*      */       }
/*      */       
/* 1222 */       return new Hall(p_74906_0_, p_74906_7_, p_74906_2_, structureBoundingBox, p_74906_6_);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
/* 1228 */       if (this.field_143015_k < 0) {
/* 1229 */         this.field_143015_k = func_74889_b(p_74875_1_, p_74875_3_);
/* 1230 */         if (this.field_143015_k < 0) {
/* 1231 */           return true;
/*      */         }
/* 1233 */         this.field_74887_e.func_78886_a(0, this.field_143015_k - this.field_74887_e.field_78894_e + 7 - 1, 0);
/*      */       } 
/*      */ 
/*      */       
/* 1237 */       func_151549_a(p_74875_1_, p_74875_3_, 1, 1, 1, 7, 4, 4, Blocks.field_150350_a, Blocks.field_150350_a, false);
/* 1238 */       func_151549_a(p_74875_1_, p_74875_3_, 2, 1, 6, 8, 4, 10, Blocks.field_150350_a, Blocks.field_150350_a, false);
/*      */ 
/*      */       
/* 1241 */       func_151549_a(p_74875_1_, p_74875_3_, 2, 0, 6, 8, 0, 10, Blocks.field_150346_d, Blocks.field_150346_d, false);
/* 1242 */       func_151550_a(p_74875_1_, Blocks.field_150347_e, 0, 6, 0, 6, p_74875_3_);
/*      */       
/* 1244 */       func_151549_a(p_74875_1_, p_74875_3_, 2, 1, 6, 2, 1, 10, Blocks.field_150422_aJ, Blocks.field_150422_aJ, false);
/* 1245 */       func_151549_a(p_74875_1_, p_74875_3_, 8, 1, 6, 8, 1, 10, Blocks.field_150422_aJ, Blocks.field_150422_aJ, false);
/* 1246 */       func_151549_a(p_74875_1_, p_74875_3_, 3, 1, 10, 7, 1, 10, Blocks.field_150422_aJ, Blocks.field_150422_aJ, false);
/*      */ 
/*      */       
/* 1249 */       func_151549_a(p_74875_1_, p_74875_3_, 1, 0, 1, 7, 0, 4, Blocks.field_150344_f, Blocks.field_150344_f, false);
/* 1250 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 0, 0, 0, 3, 5, Blocks.field_150347_e, Blocks.field_150347_e, false);
/* 1251 */       func_151549_a(p_74875_1_, p_74875_3_, 8, 0, 0, 8, 3, 5, Blocks.field_150347_e, Blocks.field_150347_e, false);
/* 1252 */       func_151549_a(p_74875_1_, p_74875_3_, 1, 0, 0, 7, 1, 0, Blocks.field_150347_e, Blocks.field_150347_e, false);
/* 1253 */       func_151549_a(p_74875_1_, p_74875_3_, 1, 0, 5, 7, 1, 5, Blocks.field_150347_e, Blocks.field_150347_e, false);
/*      */ 
/*      */       
/* 1256 */       func_151549_a(p_74875_1_, p_74875_3_, 1, 2, 0, 7, 3, 0, Blocks.field_150344_f, Blocks.field_150344_f, false);
/* 1257 */       func_151549_a(p_74875_1_, p_74875_3_, 1, 2, 5, 7, 3, 5, Blocks.field_150344_f, Blocks.field_150344_f, false);
/* 1258 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 4, 1, 8, 4, 1, Blocks.field_150344_f, Blocks.field_150344_f, false);
/* 1259 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 4, 4, 8, 4, 4, Blocks.field_150344_f, Blocks.field_150344_f, false);
/* 1260 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 5, 2, 8, 5, 3, Blocks.field_150344_f, Blocks.field_150344_f, false);
/* 1261 */       func_151550_a(p_74875_1_, Blocks.field_150344_f, 0, 0, 4, 2, p_74875_3_);
/* 1262 */       func_151550_a(p_74875_1_, Blocks.field_150344_f, 0, 0, 4, 3, p_74875_3_);
/* 1263 */       func_151550_a(p_74875_1_, Blocks.field_150344_f, 0, 8, 4, 2, p_74875_3_);
/* 1264 */       func_151550_a(p_74875_1_, Blocks.field_150344_f, 0, 8, 4, 3, p_74875_3_);
/*      */       
/* 1266 */       int i = func_151555_a(Blocks.field_150476_ad, 3);
/* 1267 */       int j = func_151555_a(Blocks.field_150476_ad, 2); byte b;
/* 1268 */       for (b = -1; b <= 2; b++) {
/* 1269 */         for (byte b1 = 0; b1 <= 8; b1++) {
/* 1270 */           func_151550_a(p_74875_1_, Blocks.field_150476_ad, i, b1, 4 + b, b, p_74875_3_);
/* 1271 */           func_151550_a(p_74875_1_, Blocks.field_150476_ad, j, b1, 4 + b, 5 - b, p_74875_3_);
/*      */         } 
/*      */       } 
/*      */ 
/*      */       
/* 1276 */       func_151550_a(p_74875_1_, Blocks.field_150364_r, 0, 0, 2, 1, p_74875_3_);
/* 1277 */       func_151550_a(p_74875_1_, Blocks.field_150364_r, 0, 0, 2, 4, p_74875_3_);
/* 1278 */       func_151550_a(p_74875_1_, Blocks.field_150364_r, 0, 8, 2, 1, p_74875_3_);
/* 1279 */       func_151550_a(p_74875_1_, Blocks.field_150364_r, 0, 8, 2, 4, p_74875_3_);
/* 1280 */       func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 0, 2, 2, p_74875_3_);
/* 1281 */       func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 0, 2, 3, p_74875_3_);
/* 1282 */       func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 8, 2, 2, p_74875_3_);
/* 1283 */       func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 8, 2, 3, p_74875_3_);
/* 1284 */       func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 2, 2, 5, p_74875_3_);
/* 1285 */       func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 3, 2, 5, p_74875_3_);
/* 1286 */       func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 5, 2, 0, p_74875_3_);
/* 1287 */       func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 6, 2, 5, p_74875_3_);
/*      */ 
/*      */       
/* 1290 */       func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, 2, 1, 3, p_74875_3_);
/* 1291 */       func_151550_a(p_74875_1_, Blocks.field_150452_aw, 0, 2, 2, 3, p_74875_3_);
/* 1292 */       func_151550_a(p_74875_1_, Blocks.field_150344_f, 0, 1, 1, 4, p_74875_3_);
/* 1293 */       func_151550_a(p_74875_1_, Blocks.field_150476_ad, func_151555_a(Blocks.field_150476_ad, 3), 2, 1, 4, p_74875_3_);
/* 1294 */       func_151550_a(p_74875_1_, Blocks.field_150476_ad, func_151555_a(Blocks.field_150476_ad, 1), 1, 1, 3, p_74875_3_);
/*      */ 
/*      */       
/* 1297 */       func_151549_a(p_74875_1_, p_74875_3_, 5, 0, 1, 7, 0, 3, (Block)Blocks.field_150334_T, (Block)Blocks.field_150334_T, false);
/* 1298 */       func_151550_a(p_74875_1_, (Block)Blocks.field_150334_T, 0, 6, 1, 1, p_74875_3_);
/* 1299 */       func_151550_a(p_74875_1_, (Block)Blocks.field_150334_T, 0, 6, 1, 2, p_74875_3_);
/*      */ 
/*      */       
/* 1302 */       func_151550_a(p_74875_1_, Blocks.field_150350_a, 0, 2, 1, 0, p_74875_3_);
/* 1303 */       func_151550_a(p_74875_1_, Blocks.field_150350_a, 0, 2, 2, 0, p_74875_3_);
/* 1304 */       func_151550_a(p_74875_1_, Blocks.field_150478_aa, 0, 2, 3, 1, p_74875_3_);
/* 1305 */       func_74881_a(p_74875_1_, p_74875_3_, p_74875_2_, 2, 1, 0, func_151555_a(Blocks.field_150466_ao, 1));
/* 1306 */       if (func_151548_a(p_74875_1_, 2, 0, -1, p_74875_3_).func_149688_o() == Material.field_151579_a && func_151548_a(p_74875_1_, 2, -1, -1, p_74875_3_).func_149688_o() != Material.field_151579_a) {
/* 1307 */         func_151550_a(p_74875_1_, Blocks.field_150446_ar, func_151555_a(Blocks.field_150446_ar, 3), 2, 0, -1, p_74875_3_);
/*      */       }
/*      */ 
/*      */       
/* 1311 */       func_151550_a(p_74875_1_, Blocks.field_150350_a, 0, 6, 1, 5, p_74875_3_);
/* 1312 */       func_151550_a(p_74875_1_, Blocks.field_150350_a, 0, 6, 2, 5, p_74875_3_);
/* 1313 */       func_151550_a(p_74875_1_, Blocks.field_150478_aa, 0, 6, 3, 4, p_74875_3_);
/* 1314 */       func_74881_a(p_74875_1_, p_74875_3_, p_74875_2_, 6, 1, 5, func_151555_a(Blocks.field_150466_ao, 1));
/*      */       
/* 1316 */       for (b = 0; b < 5; b++) {
/* 1317 */         for (byte b1 = 0; b1 < 9; b1++) {
/* 1318 */           func_74871_b(p_74875_1_, b1, 7, b, p_74875_3_);
/* 1319 */           func_151554_b(p_74875_1_, Blocks.field_150347_e, 0, b1, -1, b, p_74875_3_);
/*      */         } 
/*      */       } 
/*      */       
/* 1323 */       func_74893_a(p_74875_1_, p_74875_3_, 4, 1, 2, 2);
/*      */       
/* 1325 */       return true;
/*      */     }
/*      */ 
/*      */     
/*      */     protected int func_74888_b(int p_74888_1_) {
/* 1330 */       if (p_74888_1_ == 0) {
/* 1331 */         return 4;
/*      */       }
/* 1333 */       return 0;
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public static class House3
/*      */     extends Village
/*      */   {
/*      */     private static final String __OBFID = "CL_00000530";
/*      */ 
/*      */     
/*      */     public House3() {}
/*      */ 
/*      */     
/*      */     public House3(StructureVillagePieces.Start p_i2106_1_, int p_i2106_2_, Random p_i2106_3_, StructureBoundingBox p_i2106_4_, int p_i2106_5_) {
/* 1348 */       super(p_i2106_1_, p_i2106_2_);
/*      */       
/* 1350 */       this.field_74885_f = p_i2106_5_;
/* 1351 */       this.field_74887_e = p_i2106_4_;
/*      */     }
/*      */ 
/*      */     
/*      */     public static House3 func_74921_a(StructureVillagePieces.Start p_74921_0_, List p_74921_1_, Random p_74921_2_, int p_74921_3_, int p_74921_4_, int p_74921_5_, int p_74921_6_, int p_74921_7_) {
/* 1356 */       StructureBoundingBox structureBoundingBox = StructureBoundingBox.func_78889_a(p_74921_3_, p_74921_4_, p_74921_5_, 0, 0, 0, 9, 7, 12, p_74921_6_);
/*      */       
/* 1358 */       if (!func_74895_a(structureBoundingBox) || StructureComponent.func_74883_a(p_74921_1_, structureBoundingBox) != null) {
/* 1359 */         return null;
/*      */       }
/*      */       
/* 1362 */       return new House3(p_74921_0_, p_74921_7_, p_74921_2_, structureBoundingBox, p_74921_6_);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
/* 1368 */       if (this.field_143015_k < 0) {
/* 1369 */         this.field_143015_k = func_74889_b(p_74875_1_, p_74875_3_);
/* 1370 */         if (this.field_143015_k < 0) {
/* 1371 */           return true;
/*      */         }
/* 1373 */         this.field_74887_e.func_78886_a(0, this.field_143015_k - this.field_74887_e.field_78894_e + 7 - 1, 0);
/*      */       } 
/*      */ 
/*      */       
/* 1377 */       func_151549_a(p_74875_1_, p_74875_3_, 1, 1, 1, 7, 4, 4, Blocks.field_150350_a, Blocks.field_150350_a, false);
/* 1378 */       func_151549_a(p_74875_1_, p_74875_3_, 2, 1, 6, 8, 4, 10, Blocks.field_150350_a, Blocks.field_150350_a, false);
/*      */ 
/*      */       
/* 1381 */       func_151549_a(p_74875_1_, p_74875_3_, 2, 0, 5, 8, 0, 10, Blocks.field_150344_f, Blocks.field_150344_f, false);
/* 1382 */       func_151549_a(p_74875_1_, p_74875_3_, 1, 0, 1, 7, 0, 4, Blocks.field_150344_f, Blocks.field_150344_f, false);
/* 1383 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 0, 0, 0, 3, 5, Blocks.field_150347_e, Blocks.field_150347_e, false);
/* 1384 */       func_151549_a(p_74875_1_, p_74875_3_, 8, 0, 0, 8, 3, 10, Blocks.field_150347_e, Blocks.field_150347_e, false);
/* 1385 */       func_151549_a(p_74875_1_, p_74875_3_, 1, 0, 0, 7, 2, 0, Blocks.field_150347_e, Blocks.field_150347_e, false);
/* 1386 */       func_151549_a(p_74875_1_, p_74875_3_, 1, 0, 5, 2, 1, 5, Blocks.field_150347_e, Blocks.field_150347_e, false);
/* 1387 */       func_151549_a(p_74875_1_, p_74875_3_, 2, 0, 6, 2, 3, 10, Blocks.field_150347_e, Blocks.field_150347_e, false);
/* 1388 */       func_151549_a(p_74875_1_, p_74875_3_, 3, 0, 10, 7, 3, 10, Blocks.field_150347_e, Blocks.field_150347_e, false);
/*      */ 
/*      */       
/* 1391 */       func_151549_a(p_74875_1_, p_74875_3_, 1, 2, 0, 7, 3, 0, Blocks.field_150344_f, Blocks.field_150344_f, false);
/* 1392 */       func_151549_a(p_74875_1_, p_74875_3_, 1, 2, 5, 2, 3, 5, Blocks.field_150344_f, Blocks.field_150344_f, false);
/* 1393 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 4, 1, 8, 4, 1, Blocks.field_150344_f, Blocks.field_150344_f, false);
/* 1394 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 4, 4, 3, 4, 4, Blocks.field_150344_f, Blocks.field_150344_f, false);
/* 1395 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 5, 2, 8, 5, 3, Blocks.field_150344_f, Blocks.field_150344_f, false);
/* 1396 */       func_151550_a(p_74875_1_, Blocks.field_150344_f, 0, 0, 4, 2, p_74875_3_);
/* 1397 */       func_151550_a(p_74875_1_, Blocks.field_150344_f, 0, 0, 4, 3, p_74875_3_);
/* 1398 */       func_151550_a(p_74875_1_, Blocks.field_150344_f, 0, 8, 4, 2, p_74875_3_);
/* 1399 */       func_151550_a(p_74875_1_, Blocks.field_150344_f, 0, 8, 4, 3, p_74875_3_);
/* 1400 */       func_151550_a(p_74875_1_, Blocks.field_150344_f, 0, 8, 4, 4, p_74875_3_);
/*      */       
/* 1402 */       int i = func_151555_a(Blocks.field_150476_ad, 3);
/* 1403 */       int j = func_151555_a(Blocks.field_150476_ad, 2); int k;
/* 1404 */       for (k = -1; k <= 2; k++) {
/* 1405 */         for (byte b1 = 0; b1 <= 8; b1++) {
/* 1406 */           func_151550_a(p_74875_1_, Blocks.field_150476_ad, i, b1, 4 + k, k, p_74875_3_);
/* 1407 */           if ((k > -1 || b1 <= 1) && (k > 0 || b1 <= 3) && (k > 1 || b1 <= 4 || b1 >= 6)) {
/* 1408 */             func_151550_a(p_74875_1_, Blocks.field_150476_ad, j, b1, 4 + k, 5 - k, p_74875_3_);
/*      */           }
/*      */         } 
/*      */       } 
/*      */ 
/*      */       
/* 1414 */       func_151549_a(p_74875_1_, p_74875_3_, 3, 4, 5, 3, 4, 10, Blocks.field_150344_f, Blocks.field_150344_f, false);
/* 1415 */       func_151549_a(p_74875_1_, p_74875_3_, 7, 4, 2, 7, 4, 10, Blocks.field_150344_f, Blocks.field_150344_f, false);
/* 1416 */       func_151549_a(p_74875_1_, p_74875_3_, 4, 5, 4, 4, 5, 10, Blocks.field_150344_f, Blocks.field_150344_f, false);
/* 1417 */       func_151549_a(p_74875_1_, p_74875_3_, 6, 5, 4, 6, 5, 10, Blocks.field_150344_f, Blocks.field_150344_f, false);
/* 1418 */       func_151549_a(p_74875_1_, p_74875_3_, 5, 6, 3, 5, 6, 10, Blocks.field_150344_f, Blocks.field_150344_f, false);
/* 1419 */       k = func_151555_a(Blocks.field_150476_ad, 0); int m;
/* 1420 */       for (m = 4; m >= 1; m--) {
/* 1421 */         func_151550_a(p_74875_1_, Blocks.field_150344_f, 0, m, 2 + m, 7 - m, p_74875_3_);
/* 1422 */         for (int n = 8 - m; n <= 10; n++) {
/* 1423 */           func_151550_a(p_74875_1_, Blocks.field_150476_ad, k, m, 2 + m, n, p_74875_3_);
/*      */         }
/*      */       } 
/* 1426 */       m = func_151555_a(Blocks.field_150476_ad, 1);
/* 1427 */       func_151550_a(p_74875_1_, Blocks.field_150344_f, 0, 6, 6, 3, p_74875_3_);
/* 1428 */       func_151550_a(p_74875_1_, Blocks.field_150344_f, 0, 7, 5, 4, p_74875_3_);
/* 1429 */       func_151550_a(p_74875_1_, Blocks.field_150476_ad, m, 6, 6, 4, p_74875_3_); byte b;
/* 1430 */       for (b = 6; b <= 8; b++) {
/* 1431 */         for (byte b1 = 5; b1 <= 10; b1++) {
/* 1432 */           func_151550_a(p_74875_1_, Blocks.field_150476_ad, m, b, 12 - b, b1, p_74875_3_);
/*      */         }
/*      */       } 
/*      */ 
/*      */       
/* 1437 */       func_151550_a(p_74875_1_, Blocks.field_150364_r, 0, 0, 2, 1, p_74875_3_);
/* 1438 */       func_151550_a(p_74875_1_, Blocks.field_150364_r, 0, 0, 2, 4, p_74875_3_);
/* 1439 */       func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 0, 2, 2, p_74875_3_);
/* 1440 */       func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 0, 2, 3, p_74875_3_);
/*      */       
/* 1442 */       func_151550_a(p_74875_1_, Blocks.field_150364_r, 0, 4, 2, 0, p_74875_3_);
/* 1443 */       func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 5, 2, 0, p_74875_3_);
/* 1444 */       func_151550_a(p_74875_1_, Blocks.field_150364_r, 0, 6, 2, 0, p_74875_3_);
/*      */       
/* 1446 */       func_151550_a(p_74875_1_, Blocks.field_150364_r, 0, 8, 2, 1, p_74875_3_);
/* 1447 */       func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 8, 2, 2, p_74875_3_);
/* 1448 */       func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 8, 2, 3, p_74875_3_);
/* 1449 */       func_151550_a(p_74875_1_, Blocks.field_150364_r, 0, 8, 2, 4, p_74875_3_);
/* 1450 */       func_151550_a(p_74875_1_, Blocks.field_150344_f, 0, 8, 2, 5, p_74875_3_);
/* 1451 */       func_151550_a(p_74875_1_, Blocks.field_150364_r, 0, 8, 2, 6, p_74875_3_);
/* 1452 */       func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 8, 2, 7, p_74875_3_);
/* 1453 */       func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 8, 2, 8, p_74875_3_);
/* 1454 */       func_151550_a(p_74875_1_, Blocks.field_150364_r, 0, 8, 2, 9, p_74875_3_);
/* 1455 */       func_151550_a(p_74875_1_, Blocks.field_150364_r, 0, 2, 2, 6, p_74875_3_);
/* 1456 */       func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 2, 2, 7, p_74875_3_);
/* 1457 */       func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 2, 2, 8, p_74875_3_);
/* 1458 */       func_151550_a(p_74875_1_, Blocks.field_150364_r, 0, 2, 2, 9, p_74875_3_);
/*      */       
/* 1460 */       func_151550_a(p_74875_1_, Blocks.field_150364_r, 0, 4, 4, 10, p_74875_3_);
/* 1461 */       func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 5, 4, 10, p_74875_3_);
/* 1462 */       func_151550_a(p_74875_1_, Blocks.field_150364_r, 0, 6, 4, 10, p_74875_3_);
/* 1463 */       func_151550_a(p_74875_1_, Blocks.field_150344_f, 0, 5, 5, 10, p_74875_3_);
/*      */ 
/*      */       
/* 1466 */       func_151550_a(p_74875_1_, Blocks.field_150350_a, 0, 2, 1, 0, p_74875_3_);
/* 1467 */       func_151550_a(p_74875_1_, Blocks.field_150350_a, 0, 2, 2, 0, p_74875_3_);
/* 1468 */       func_151550_a(p_74875_1_, Blocks.field_150478_aa, 0, 2, 3, 1, p_74875_3_);
/* 1469 */       func_74881_a(p_74875_1_, p_74875_3_, p_74875_2_, 2, 1, 0, func_151555_a(Blocks.field_150466_ao, 1));
/* 1470 */       func_151549_a(p_74875_1_, p_74875_3_, 1, 0, -1, 3, 2, -1, Blocks.field_150350_a, Blocks.field_150350_a, false);
/* 1471 */       if (func_151548_a(p_74875_1_, 2, 0, -1, p_74875_3_).func_149688_o() == Material.field_151579_a && func_151548_a(p_74875_1_, 2, -1, -1, p_74875_3_).func_149688_o() != Material.field_151579_a) {
/* 1472 */         func_151550_a(p_74875_1_, Blocks.field_150446_ar, func_151555_a(Blocks.field_150446_ar, 3), 2, 0, -1, p_74875_3_);
/*      */       }
/*      */       
/* 1475 */       for (b = 0; b < 5; b++) {
/* 1476 */         for (byte b1 = 0; b1 < 9; b1++) {
/* 1477 */           func_74871_b(p_74875_1_, b1, 7, b, p_74875_3_);
/* 1478 */           func_151554_b(p_74875_1_, Blocks.field_150347_e, 0, b1, -1, b, p_74875_3_);
/*      */         } 
/*      */       } 
/* 1481 */       for (b = 5; b < 11; b++) {
/* 1482 */         for (byte b1 = 2; b1 < 9; b1++) {
/* 1483 */           func_74871_b(p_74875_1_, b1, 7, b, p_74875_3_);
/* 1484 */           func_151554_b(p_74875_1_, Blocks.field_150347_e, 0, b1, -1, b, p_74875_3_);
/*      */         } 
/*      */       } 
/*      */       
/* 1488 */       func_74893_a(p_74875_1_, p_74875_3_, 4, 1, 2, 2);
/*      */       
/* 1490 */       return true;
/*      */     }
/*      */   }
/*      */   
/*      */   public static class House2
/*      */     extends Village
/*      */   {
/* 1497 */     public static final WeightedRandomChestContent[] field_74918_a = new WeightedRandomChestContent[] { new WeightedRandomChestContent(Items.field_151045_i, 0, 1, 3, 3), new WeightedRandomChestContent(Items.field_151042_j, 0, 1, 5, 10), new WeightedRandomChestContent(Items.field_151043_k, 0, 1, 3, 5), new WeightedRandomChestContent(Items.field_151025_P, 0, 1, 3, 15), new WeightedRandomChestContent(Items.field_151034_e, 0, 1, 3, 15), new WeightedRandomChestContent(Items.field_151035_b, 0, 1, 1, 5), new WeightedRandomChestContent(Items.field_151040_l, 0, 1, 1, 5), new WeightedRandomChestContent((Item)Items.field_151030_Z, 0, 1, 1, 5), new WeightedRandomChestContent((Item)Items.field_151028_Y, 0, 1, 1, 5), new WeightedRandomChestContent((Item)Items.field_151165_aa, 0, 1, 1, 5), new WeightedRandomChestContent((Item)Items.field_151167_ab, 0, 1, 1, 5), new WeightedRandomChestContent(Item.func_150898_a(Blocks.field_150343_Z), 0, 3, 7, 5), new WeightedRandomChestContent(Item.func_150898_a(Blocks.field_150345_g), 0, 3, 7, 5), new WeightedRandomChestContent(Items.field_151141_av, 0, 1, 1, 3), new WeightedRandomChestContent(Items.field_151138_bX, 0, 1, 1, 1), new WeightedRandomChestContent(Items.field_151136_bY, 0, 1, 1, 1), new WeightedRandomChestContent(Items.field_151125_bZ, 0, 1, 1, 1) };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private boolean field_74917_c;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private static final String __OBFID = "CL_00000526";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public House2() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public House2(StructureVillagePieces.Start p_i2103_1_, int p_i2103_2_, Random p_i2103_3_, StructureBoundingBox p_i2103_4_, int p_i2103_5_) {
/* 1532 */       super(p_i2103_1_, p_i2103_2_);
/*      */       
/* 1534 */       this.field_74885_f = p_i2103_5_;
/* 1535 */       this.field_74887_e = p_i2103_4_;
/*      */     }
/*      */ 
/*      */     
/*      */     public static House2 func_74915_a(StructureVillagePieces.Start p_74915_0_, List p_74915_1_, Random p_74915_2_, int p_74915_3_, int p_74915_4_, int p_74915_5_, int p_74915_6_, int p_74915_7_) {
/* 1540 */       StructureBoundingBox structureBoundingBox = StructureBoundingBox.func_78889_a(p_74915_3_, p_74915_4_, p_74915_5_, 0, 0, 0, 10, 6, 7, p_74915_6_);
/*      */       
/* 1542 */       if (!func_74895_a(structureBoundingBox) || StructureComponent.func_74883_a(p_74915_1_, structureBoundingBox) != null) {
/* 1543 */         return null;
/*      */       }
/*      */       
/* 1546 */       return new House2(p_74915_0_, p_74915_7_, p_74915_2_, structureBoundingBox, p_74915_6_);
/*      */     }
/*      */ 
/*      */     
/*      */     protected void func_143012_a(NBTTagCompound p_143012_1_) {
/* 1551 */       super.func_143012_a(p_143012_1_);
/* 1552 */       p_143012_1_.func_74757_a("Chest", this.field_74917_c);
/*      */     }
/*      */ 
/*      */     
/*      */     protected void func_143011_b(NBTTagCompound p_143011_1_) {
/* 1557 */       super.func_143011_b(p_143011_1_);
/* 1558 */       this.field_74917_c = p_143011_1_.func_74767_n("Chest");
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
/* 1564 */       if (this.field_143015_k < 0) {
/* 1565 */         this.field_143015_k = func_74889_b(p_74875_1_, p_74875_3_);
/* 1566 */         if (this.field_143015_k < 0) {
/* 1567 */           return true;
/*      */         }
/* 1569 */         this.field_74887_e.func_78886_a(0, this.field_143015_k - this.field_74887_e.field_78894_e + 6 - 1, 0);
/*      */       } 
/*      */ 
/*      */       
/* 1573 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 1, 0, 9, 4, 6, Blocks.field_150350_a, Blocks.field_150350_a, false);
/*      */ 
/*      */       
/* 1576 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 0, 0, 9, 0, 6, Blocks.field_150347_e, Blocks.field_150347_e, false);
/*      */ 
/*      */       
/* 1579 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 4, 0, 9, 4, 6, Blocks.field_150347_e, Blocks.field_150347_e, false);
/* 1580 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 5, 0, 9, 5, 6, (Block)Blocks.field_150333_U, (Block)Blocks.field_150333_U, false);
/* 1581 */       func_151549_a(p_74875_1_, p_74875_3_, 1, 5, 1, 8, 5, 5, Blocks.field_150350_a, Blocks.field_150350_a, false);
/*      */ 
/*      */       
/* 1584 */       func_151549_a(p_74875_1_, p_74875_3_, 1, 1, 0, 2, 3, 0, Blocks.field_150344_f, Blocks.field_150344_f, false);
/* 1585 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 1, 0, 0, 4, 0, Blocks.field_150364_r, Blocks.field_150364_r, false);
/* 1586 */       func_151549_a(p_74875_1_, p_74875_3_, 3, 1, 0, 3, 4, 0, Blocks.field_150364_r, Blocks.field_150364_r, false);
/* 1587 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 1, 6, 0, 4, 6, Blocks.field_150364_r, Blocks.field_150364_r, false);
/* 1588 */       func_151550_a(p_74875_1_, Blocks.field_150344_f, 0, 3, 3, 1, p_74875_3_);
/* 1589 */       func_151549_a(p_74875_1_, p_74875_3_, 3, 1, 2, 3, 3, 2, Blocks.field_150344_f, Blocks.field_150344_f, false);
/* 1590 */       func_151549_a(p_74875_1_, p_74875_3_, 4, 1, 3, 5, 3, 3, Blocks.field_150344_f, Blocks.field_150344_f, false);
/* 1591 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 1, 1, 0, 3, 5, Blocks.field_150344_f, Blocks.field_150344_f, false);
/* 1592 */       func_151549_a(p_74875_1_, p_74875_3_, 1, 1, 6, 5, 3, 6, Blocks.field_150344_f, Blocks.field_150344_f, false);
/*      */ 
/*      */       
/* 1595 */       func_151549_a(p_74875_1_, p_74875_3_, 5, 1, 0, 5, 3, 0, Blocks.field_150422_aJ, Blocks.field_150422_aJ, false);
/* 1596 */       func_151549_a(p_74875_1_, p_74875_3_, 9, 1, 0, 9, 3, 0, Blocks.field_150422_aJ, Blocks.field_150422_aJ, false);
/*      */ 
/*      */       
/* 1599 */       func_151549_a(p_74875_1_, p_74875_3_, 6, 1, 4, 9, 4, 6, Blocks.field_150347_e, Blocks.field_150347_e, false);
/* 1600 */       func_151550_a(p_74875_1_, (Block)Blocks.field_150356_k, 0, 7, 1, 5, p_74875_3_);
/* 1601 */       func_151550_a(p_74875_1_, (Block)Blocks.field_150356_k, 0, 8, 1, 5, p_74875_3_);
/* 1602 */       func_151550_a(p_74875_1_, Blocks.field_150411_aY, 0, 9, 2, 5, p_74875_3_);
/* 1603 */       func_151550_a(p_74875_1_, Blocks.field_150411_aY, 0, 9, 2, 4, p_74875_3_);
/* 1604 */       func_151549_a(p_74875_1_, p_74875_3_, 7, 2, 4, 8, 2, 5, Blocks.field_150350_a, Blocks.field_150350_a, false);
/* 1605 */       func_151550_a(p_74875_1_, Blocks.field_150347_e, 0, 6, 1, 3, p_74875_3_);
/* 1606 */       func_151550_a(p_74875_1_, Blocks.field_150460_al, 0, 6, 2, 3, p_74875_3_);
/* 1607 */       func_151550_a(p_74875_1_, Blocks.field_150460_al, 0, 6, 3, 3, p_74875_3_);
/* 1608 */       func_151550_a(p_74875_1_, (Block)Blocks.field_150334_T, 0, 8, 1, 1, p_74875_3_);
/*      */ 
/*      */       
/* 1611 */       func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 0, 2, 2, p_74875_3_);
/* 1612 */       func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 0, 2, 4, p_74875_3_);
/* 1613 */       func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 2, 2, 6, p_74875_3_);
/* 1614 */       func_151550_a(p_74875_1_, Blocks.field_150410_aZ, 0, 4, 2, 6, p_74875_3_);
/*      */ 
/*      */       
/* 1617 */       func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, 2, 1, 4, p_74875_3_);
/* 1618 */       func_151550_a(p_74875_1_, Blocks.field_150452_aw, 0, 2, 2, 4, p_74875_3_);
/* 1619 */       func_151550_a(p_74875_1_, Blocks.field_150344_f, 0, 1, 1, 5, p_74875_3_);
/* 1620 */       func_151550_a(p_74875_1_, Blocks.field_150476_ad, func_151555_a(Blocks.field_150476_ad, 3), 2, 1, 5, p_74875_3_);
/* 1621 */       func_151550_a(p_74875_1_, Blocks.field_150476_ad, func_151555_a(Blocks.field_150476_ad, 1), 1, 1, 4, p_74875_3_);
/*      */       
/* 1623 */       if (!this.field_74917_c) {
/* 1624 */         int i = func_74862_a(1);
/* 1625 */         int j = func_74865_a(5, 5), k = func_74873_b(5, 5);
/* 1626 */         if (p_74875_3_.func_78890_b(j, i, k)) {
/* 1627 */           this.field_74917_c = true;
/* 1628 */           func_74879_a(p_74875_1_, p_74875_3_, p_74875_2_, 5, 1, 5, field_74918_a, 3 + p_74875_2_.nextInt(6));
/*      */         } 
/*      */       } 
/*      */       
/*      */       byte b;
/* 1633 */       for (b = 6; b <= 8; b++) {
/* 1634 */         if (func_151548_a(p_74875_1_, b, 0, -1, p_74875_3_).func_149688_o() == Material.field_151579_a && func_151548_a(p_74875_1_, b, -1, -1, p_74875_3_).func_149688_o() != Material.field_151579_a) {
/* 1635 */           func_151550_a(p_74875_1_, Blocks.field_150446_ar, func_151555_a(Blocks.field_150446_ar, 3), b, 0, -1, p_74875_3_);
/*      */         }
/*      */       } 
/*      */       
/* 1639 */       for (b = 0; b < 7; b++) {
/* 1640 */         for (byte b1 = 0; b1 < 10; b1++) {
/* 1641 */           func_74871_b(p_74875_1_, b1, 6, b, p_74875_3_);
/* 1642 */           func_151554_b(p_74875_1_, Blocks.field_150347_e, 0, b1, -1, b, p_74875_3_);
/*      */         } 
/*      */       } 
/*      */       
/* 1646 */       func_74893_a(p_74875_1_, p_74875_3_, 7, 1, 1, 1);
/*      */       
/* 1648 */       return true;
/*      */     }
/*      */ 
/*      */     
/*      */     protected int func_74888_b(int p_74888_1_) {
/* 1653 */       return 3;
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public static class Field2
/*      */     extends Village
/*      */   {
/*      */     private Block field_82675_b;
/*      */     
/*      */     private Block field_82676_c;
/*      */     
/*      */     private static final String __OBFID = "CL_00000519";
/*      */ 
/*      */     
/*      */     public Field2() {}
/*      */     
/*      */     public Field2(StructureVillagePieces.Start p_i2096_1_, int p_i2096_2_, Random p_i2096_3_, StructureBoundingBox p_i2096_4_, int p_i2096_5_) {
/* 1671 */       super(p_i2096_1_, p_i2096_2_);
/*      */       
/* 1673 */       this.field_74885_f = p_i2096_5_;
/* 1674 */       this.field_74887_e = p_i2096_4_;
/*      */       
/* 1676 */       this.field_82675_b = func_151560_a(p_i2096_3_);
/* 1677 */       this.field_82676_c = func_151560_a(p_i2096_3_);
/*      */     }
/*      */ 
/*      */     
/*      */     protected void func_143012_a(NBTTagCompound p_143012_1_) {
/* 1682 */       super.func_143012_a(p_143012_1_);
/* 1683 */       p_143012_1_.func_74768_a("CA", Block.field_149771_c.func_148757_b(this.field_82675_b));
/* 1684 */       p_143012_1_.func_74768_a("CB", Block.field_149771_c.func_148757_b(this.field_82676_c));
/*      */     }
/*      */ 
/*      */     
/*      */     protected void func_143011_b(NBTTagCompound p_143011_1_) {
/* 1689 */       super.func_143011_b(p_143011_1_);
/* 1690 */       this.field_82675_b = Block.func_149729_e(p_143011_1_.func_74762_e("CA"));
/* 1691 */       this.field_82676_c = Block.func_149729_e(p_143011_1_.func_74762_e("CB"));
/*      */     }
/*      */     
/*      */     private Block func_151560_a(Random p_151560_1_) {
/* 1695 */       switch (p_151560_1_.nextInt(5))
/*      */       { default:
/* 1697 */           return Blocks.field_150464_aj;
/*      */         case 0:
/* 1699 */           return Blocks.field_150459_bM;
/*      */         case 1:
/* 1701 */           break; }  return Blocks.field_150469_bN;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public static Field2 func_74902_a(StructureVillagePieces.Start p_74902_0_, List p_74902_1_, Random p_74902_2_, int p_74902_3_, int p_74902_4_, int p_74902_5_, int p_74902_6_, int p_74902_7_) {
/* 1707 */       StructureBoundingBox structureBoundingBox = StructureBoundingBox.func_78889_a(p_74902_3_, p_74902_4_, p_74902_5_, 0, 0, 0, 7, 4, 9, p_74902_6_);
/*      */       
/* 1709 */       if (!func_74895_a(structureBoundingBox) || StructureComponent.func_74883_a(p_74902_1_, structureBoundingBox) != null) {
/* 1710 */         return null;
/*      */       }
/*      */       
/* 1713 */       return new Field2(p_74902_0_, p_74902_7_, p_74902_2_, structureBoundingBox, p_74902_6_);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
/* 1719 */       if (this.field_143015_k < 0) {
/* 1720 */         this.field_143015_k = func_74889_b(p_74875_1_, p_74875_3_);
/* 1721 */         if (this.field_143015_k < 0) {
/* 1722 */           return true;
/*      */         }
/* 1724 */         this.field_74887_e.func_78886_a(0, this.field_143015_k - this.field_74887_e.field_78894_e + 4 - 1, 0);
/*      */       } 
/*      */ 
/*      */       
/* 1728 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 1, 0, 6, 4, 8, Blocks.field_150350_a, Blocks.field_150350_a, false);
/*      */ 
/*      */       
/* 1731 */       func_151549_a(p_74875_1_, p_74875_3_, 1, 0, 1, 2, 0, 7, Blocks.field_150458_ak, Blocks.field_150458_ak, false);
/* 1732 */       func_151549_a(p_74875_1_, p_74875_3_, 4, 0, 1, 5, 0, 7, Blocks.field_150458_ak, Blocks.field_150458_ak, false);
/*      */       
/* 1734 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 0, 0, 0, 0, 8, Blocks.field_150364_r, Blocks.field_150364_r, false);
/* 1735 */       func_151549_a(p_74875_1_, p_74875_3_, 6, 0, 0, 6, 0, 8, Blocks.field_150364_r, Blocks.field_150364_r, false);
/* 1736 */       func_151549_a(p_74875_1_, p_74875_3_, 1, 0, 0, 5, 0, 0, Blocks.field_150364_r, Blocks.field_150364_r, false);
/* 1737 */       func_151549_a(p_74875_1_, p_74875_3_, 1, 0, 8, 5, 0, 8, Blocks.field_150364_r, Blocks.field_150364_r, false);
/*      */       
/* 1739 */       func_151549_a(p_74875_1_, p_74875_3_, 3, 0, 1, 3, 0, 7, Blocks.field_150355_j, Blocks.field_150355_j, false);
/*      */       byte b;
/* 1741 */       for (b = 1; b <= 7; b++) {
/* 1742 */         func_151550_a(p_74875_1_, this.field_82675_b, MathHelper.func_76136_a(p_74875_2_, 2, 7), 1, 1, b, p_74875_3_);
/* 1743 */         func_151550_a(p_74875_1_, this.field_82675_b, MathHelper.func_76136_a(p_74875_2_, 2, 7), 2, 1, b, p_74875_3_);
/* 1744 */         func_151550_a(p_74875_1_, this.field_82676_c, MathHelper.func_76136_a(p_74875_2_, 2, 7), 4, 1, b, p_74875_3_);
/* 1745 */         func_151550_a(p_74875_1_, this.field_82676_c, MathHelper.func_76136_a(p_74875_2_, 2, 7), 5, 1, b, p_74875_3_);
/*      */       } 
/*      */       
/* 1748 */       for (b = 0; b < 9; b++) {
/* 1749 */         for (byte b1 = 0; b1 < 7; b1++) {
/* 1750 */           func_74871_b(p_74875_1_, b1, 4, b, p_74875_3_);
/* 1751 */           func_151554_b(p_74875_1_, Blocks.field_150346_d, 0, b1, -1, b, p_74875_3_);
/*      */         } 
/*      */       } 
/*      */       
/* 1755 */       return true;
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public static class Field1
/*      */     extends Village
/*      */   {
/*      */     private Block field_82679_b;
/*      */     
/*      */     private Block field_82680_c;
/*      */     
/*      */     private Block field_82678_d;
/*      */     
/*      */     private Block field_82681_h;
/*      */     private static final String __OBFID = "CL_00000518";
/*      */     
/*      */     public Field1() {}
/*      */     
/*      */     public Field1(StructureVillagePieces.Start p_i2095_1_, int p_i2095_2_, Random p_i2095_3_, StructureBoundingBox p_i2095_4_, int p_i2095_5_) {
/* 1775 */       super(p_i2095_1_, p_i2095_2_);
/*      */       
/* 1777 */       this.field_74885_f = p_i2095_5_;
/* 1778 */       this.field_74887_e = p_i2095_4_;
/*      */       
/* 1780 */       this.field_82679_b = func_151559_a(p_i2095_3_);
/* 1781 */       this.field_82680_c = func_151559_a(p_i2095_3_);
/* 1782 */       this.field_82678_d = func_151559_a(p_i2095_3_);
/* 1783 */       this.field_82681_h = func_151559_a(p_i2095_3_);
/*      */     }
/*      */ 
/*      */     
/*      */     protected void func_143012_a(NBTTagCompound p_143012_1_) {
/* 1788 */       super.func_143012_a(p_143012_1_);
/* 1789 */       p_143012_1_.func_74768_a("CA", Block.field_149771_c.func_148757_b(this.field_82679_b));
/* 1790 */       p_143012_1_.func_74768_a("CB", Block.field_149771_c.func_148757_b(this.field_82680_c));
/* 1791 */       p_143012_1_.func_74768_a("CC", Block.field_149771_c.func_148757_b(this.field_82678_d));
/* 1792 */       p_143012_1_.func_74768_a("CD", Block.field_149771_c.func_148757_b(this.field_82681_h));
/*      */     }
/*      */ 
/*      */     
/*      */     protected void func_143011_b(NBTTagCompound p_143011_1_) {
/* 1797 */       super.func_143011_b(p_143011_1_);
/* 1798 */       this.field_82679_b = Block.func_149729_e(p_143011_1_.func_74762_e("CA"));
/* 1799 */       this.field_82680_c = Block.func_149729_e(p_143011_1_.func_74762_e("CB"));
/* 1800 */       this.field_82678_d = Block.func_149729_e(p_143011_1_.func_74762_e("CC"));
/* 1801 */       this.field_82681_h = Block.func_149729_e(p_143011_1_.func_74762_e("CD"));
/*      */     }
/*      */     
/*      */     private Block func_151559_a(Random p_151559_1_) {
/* 1805 */       switch (p_151559_1_.nextInt(5))
/*      */       { default:
/* 1807 */           return Blocks.field_150464_aj;
/*      */         case 0:
/* 1809 */           return Blocks.field_150459_bM;
/*      */         case 1:
/* 1811 */           break; }  return Blocks.field_150469_bN;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public static Field1 func_74900_a(StructureVillagePieces.Start p_74900_0_, List p_74900_1_, Random p_74900_2_, int p_74900_3_, int p_74900_4_, int p_74900_5_, int p_74900_6_, int p_74900_7_) {
/* 1817 */       StructureBoundingBox structureBoundingBox = StructureBoundingBox.func_78889_a(p_74900_3_, p_74900_4_, p_74900_5_, 0, 0, 0, 13, 4, 9, p_74900_6_);
/*      */       
/* 1819 */       if (!func_74895_a(structureBoundingBox) || StructureComponent.func_74883_a(p_74900_1_, structureBoundingBox) != null) {
/* 1820 */         return null;
/*      */       }
/*      */       
/* 1823 */       return new Field1(p_74900_0_, p_74900_7_, p_74900_2_, structureBoundingBox, p_74900_6_);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
/* 1829 */       if (this.field_143015_k < 0) {
/* 1830 */         this.field_143015_k = func_74889_b(p_74875_1_, p_74875_3_);
/* 1831 */         if (this.field_143015_k < 0) {
/* 1832 */           return true;
/*      */         }
/* 1834 */         this.field_74887_e.func_78886_a(0, this.field_143015_k - this.field_74887_e.field_78894_e + 4 - 1, 0);
/*      */       } 
/*      */ 
/*      */       
/* 1838 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 1, 0, 12, 4, 8, Blocks.field_150350_a, Blocks.field_150350_a, false);
/*      */ 
/*      */       
/* 1841 */       func_151549_a(p_74875_1_, p_74875_3_, 1, 0, 1, 2, 0, 7, Blocks.field_150458_ak, Blocks.field_150458_ak, false);
/* 1842 */       func_151549_a(p_74875_1_, p_74875_3_, 4, 0, 1, 5, 0, 7, Blocks.field_150458_ak, Blocks.field_150458_ak, false);
/* 1843 */       func_151549_a(p_74875_1_, p_74875_3_, 7, 0, 1, 8, 0, 7, Blocks.field_150458_ak, Blocks.field_150458_ak, false);
/* 1844 */       func_151549_a(p_74875_1_, p_74875_3_, 10, 0, 1, 11, 0, 7, Blocks.field_150458_ak, Blocks.field_150458_ak, false);
/*      */       
/* 1846 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 0, 0, 0, 0, 8, Blocks.field_150364_r, Blocks.field_150364_r, false);
/* 1847 */       func_151549_a(p_74875_1_, p_74875_3_, 6, 0, 0, 6, 0, 8, Blocks.field_150364_r, Blocks.field_150364_r, false);
/* 1848 */       func_151549_a(p_74875_1_, p_74875_3_, 12, 0, 0, 12, 0, 8, Blocks.field_150364_r, Blocks.field_150364_r, false);
/* 1849 */       func_151549_a(p_74875_1_, p_74875_3_, 1, 0, 0, 11, 0, 0, Blocks.field_150364_r, Blocks.field_150364_r, false);
/* 1850 */       func_151549_a(p_74875_1_, p_74875_3_, 1, 0, 8, 11, 0, 8, Blocks.field_150364_r, Blocks.field_150364_r, false);
/*      */       
/* 1852 */       func_151549_a(p_74875_1_, p_74875_3_, 3, 0, 1, 3, 0, 7, Blocks.field_150355_j, Blocks.field_150355_j, false);
/* 1853 */       func_151549_a(p_74875_1_, p_74875_3_, 9, 0, 1, 9, 0, 7, Blocks.field_150355_j, Blocks.field_150355_j, false);
/*      */       byte b;
/* 1855 */       for (b = 1; b <= 7; b++) {
/* 1856 */         func_151550_a(p_74875_1_, this.field_82679_b, MathHelper.func_76136_a(p_74875_2_, 2, 7), 1, 1, b, p_74875_3_);
/* 1857 */         func_151550_a(p_74875_1_, this.field_82679_b, MathHelper.func_76136_a(p_74875_2_, 2, 7), 2, 1, b, p_74875_3_);
/* 1858 */         func_151550_a(p_74875_1_, this.field_82680_c, MathHelper.func_76136_a(p_74875_2_, 2, 7), 4, 1, b, p_74875_3_);
/* 1859 */         func_151550_a(p_74875_1_, this.field_82680_c, MathHelper.func_76136_a(p_74875_2_, 2, 7), 5, 1, b, p_74875_3_);
/* 1860 */         func_151550_a(p_74875_1_, this.field_82678_d, MathHelper.func_76136_a(p_74875_2_, 2, 7), 7, 1, b, p_74875_3_);
/* 1861 */         func_151550_a(p_74875_1_, this.field_82678_d, MathHelper.func_76136_a(p_74875_2_, 2, 7), 8, 1, b, p_74875_3_);
/* 1862 */         func_151550_a(p_74875_1_, this.field_82681_h, MathHelper.func_76136_a(p_74875_2_, 2, 7), 10, 1, b, p_74875_3_);
/* 1863 */         func_151550_a(p_74875_1_, this.field_82681_h, MathHelper.func_76136_a(p_74875_2_, 2, 7), 11, 1, b, p_74875_3_);
/*      */       } 
/*      */       
/* 1866 */       for (b = 0; b < 9; b++) {
/* 1867 */         for (byte b1 = 0; b1 < 13; b1++) {
/* 1868 */           func_74871_b(p_74875_1_, b1, 4, b, p_74875_3_);
/* 1869 */           func_151554_b(p_74875_1_, Blocks.field_150346_d, 0, b1, -1, b, p_74875_3_);
/*      */         } 
/*      */       } 
/*      */       
/* 1873 */       return true;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static class Torch
/*      */     extends Village
/*      */   {
/*      */     private static final String __OBFID = "CL_00000520";
/*      */ 
/*      */     
/*      */     public Torch() {}
/*      */ 
/*      */     
/*      */     public Torch(StructureVillagePieces.Start p_i2097_1_, int p_i2097_2_, Random p_i2097_3_, StructureBoundingBox p_i2097_4_, int p_i2097_5_) {
/* 1889 */       super(p_i2097_1_, p_i2097_2_);
/*      */       
/* 1891 */       this.field_74885_f = p_i2097_5_;
/* 1892 */       this.field_74887_e = p_i2097_4_;
/*      */     }
/*      */ 
/*      */     
/*      */     public static StructureBoundingBox func_74904_a(StructureVillagePieces.Start p_74904_0_, List p_74904_1_, Random p_74904_2_, int p_74904_3_, int p_74904_4_, int p_74904_5_, int p_74904_6_) {
/* 1897 */       StructureBoundingBox structureBoundingBox = StructureBoundingBox.func_78889_a(p_74904_3_, p_74904_4_, p_74904_5_, 0, 0, 0, 3, 4, 2, p_74904_6_);
/*      */       
/* 1899 */       if (StructureComponent.func_74883_a(p_74904_1_, structureBoundingBox) != null) {
/* 1900 */         return null;
/*      */       }
/*      */       
/* 1903 */       return structureBoundingBox;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
/* 1909 */       if (this.field_143015_k < 0) {
/* 1910 */         this.field_143015_k = func_74889_b(p_74875_1_, p_74875_3_);
/* 1911 */         if (this.field_143015_k < 0) {
/* 1912 */           return true;
/*      */         }
/* 1914 */         this.field_74887_e.func_78886_a(0, this.field_143015_k - this.field_74887_e.field_78894_e + 4 - 1, 0);
/*      */       } 
/*      */ 
/*      */       
/* 1918 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 0, 0, 2, 3, 1, Blocks.field_150350_a, Blocks.field_150350_a, false);
/*      */ 
/*      */       
/* 1921 */       func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, 1, 0, 0, p_74875_3_);
/* 1922 */       func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, 1, 1, 0, p_74875_3_);
/* 1923 */       func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, 1, 2, 0, p_74875_3_);
/*      */ 
/*      */       
/* 1926 */       func_151550_a(p_74875_1_, Blocks.field_150325_L, 15, 1, 3, 0, p_74875_3_);
/*      */ 
/*      */       
/* 1929 */       func_151550_a(p_74875_1_, Blocks.field_150478_aa, 0, 0, 3, 0, p_74875_3_);
/* 1930 */       func_151550_a(p_74875_1_, Blocks.field_150478_aa, 0, 1, 3, 1, p_74875_3_);
/* 1931 */       func_151550_a(p_74875_1_, Blocks.field_150478_aa, 0, 2, 3, 0, p_74875_3_);
/* 1932 */       func_151550_a(p_74875_1_, Blocks.field_150478_aa, 0, 1, 3, -1, p_74875_3_);
/*      */       
/* 1934 */       return true;
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\structure\StructureVillagePieces.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */