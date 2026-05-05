/*      */ package net.minecraft.world.gen.structure;
/*      */ 
/*      */ import java.util.ArrayList;
/*      */ import java.util.List;
/*      */ import java.util.Random;
/*      */ import net.minecraft.block.Block;
/*      */ import net.minecraft.init.Blocks;
/*      */ import net.minecraft.init.Items;
/*      */ import net.minecraft.item.Item;
/*      */ import net.minecraft.nbt.NBTTagCompound;
/*      */ import net.minecraft.tileentity.TileEntityMobSpawner;
/*      */ import net.minecraft.util.WeightedRandomChestContent;
/*      */ import net.minecraft.world.World;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class StructureNetherBridgePieces
/*      */ {
/*      */   public static void func_143049_a() {
/*   21 */     MapGenStructureIO.func_143031_a(Crossing3.class, "NeBCr");
/*   22 */     MapGenStructureIO.func_143031_a(End.class, "NeBEF");
/*   23 */     MapGenStructureIO.func_143031_a(Straight.class, "NeBS");
/*   24 */     MapGenStructureIO.func_143031_a(Corridor3.class, "NeCCS");
/*   25 */     MapGenStructureIO.func_143031_a(Corridor4.class, "NeCTB");
/*   26 */     MapGenStructureIO.func_143031_a(Entrance.class, "NeCE");
/*   27 */     MapGenStructureIO.func_143031_a(Crossing2.class, "NeSCSC");
/*   28 */     MapGenStructureIO.func_143031_a(Corridor.class, "NeSCLT");
/*   29 */     MapGenStructureIO.func_143031_a(Corridor5.class, "NeSC");
/*   30 */     MapGenStructureIO.func_143031_a(Corridor2.class, "NeSCRT");
/*   31 */     MapGenStructureIO.func_143031_a(NetherStalkRoom.class, "NeCSR");
/*   32 */     MapGenStructureIO.func_143031_a(Throne.class, "NeMT");
/*   33 */     MapGenStructureIO.func_143031_a(Crossing.class, "NeRC");
/*   34 */     MapGenStructureIO.func_143031_a(Stairs.class, "NeSR");
/*   35 */     MapGenStructureIO.func_143031_a(Start.class, "NeStart");
/*      */   }
/*      */ 
/*      */   
/*      */   static class PieceWeight
/*      */   {
/*      */     public Class field_78828_a;
/*      */     public final int field_78826_b;
/*      */     public int field_78827_c;
/*      */     
/*      */     public PieceWeight(Class p_i2055_1_, int p_i2055_2_, int p_i2055_3_, boolean p_i2055_4_) {
/*   46 */       this.field_78828_a = p_i2055_1_;
/*   47 */       this.field_78826_b = p_i2055_2_;
/*   48 */       this.field_78824_d = p_i2055_3_;
/*   49 */       this.field_78825_e = p_i2055_4_;
/*      */     }
/*      */     public int field_78824_d; public boolean field_78825_e; private static final String __OBFID = "CL_00000467";
/*      */     public PieceWeight(Class p_i2056_1_, int p_i2056_2_, int p_i2056_3_) {
/*   53 */       this(p_i2056_1_, p_i2056_2_, p_i2056_3_, false);
/*      */     }
/*      */     
/*      */     public boolean func_78822_a(int p_78822_1_) {
/*   57 */       return (this.field_78824_d == 0 || this.field_78827_c < this.field_78824_d);
/*      */     }
/*      */     
/*      */     public boolean func_78823_a() {
/*   61 */       return (this.field_78824_d == 0 || this.field_78827_c < this.field_78824_d);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*   66 */   private static final PieceWeight[] field_78742_a = new PieceWeight[] { new PieceWeight(Straight.class, 30, 0, true), new PieceWeight(Crossing3.class, 10, 4), new PieceWeight(Crossing.class, 10, 4), new PieceWeight(Stairs.class, 10, 3), new PieceWeight(Throne.class, 5, 2), new PieceWeight(Entrance.class, 5, 1) };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   74 */   private static final PieceWeight[] field_78741_b = new PieceWeight[] { new PieceWeight(Corridor5.class, 25, 0, true), new PieceWeight(Crossing2.class, 15, 5), new PieceWeight(Corridor2.class, 5, 10), new PieceWeight(Corridor.class, 5, 10), new PieceWeight(Corridor3.class, 10, 3, true), new PieceWeight(Corridor4.class, 7, 2), new PieceWeight(NetherStalkRoom.class, 5, 2) };
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static final String __OBFID = "CL_00000453";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static Piece func_78738_b(PieceWeight p_78738_0_, List p_78738_1_, Random p_78738_2_, int p_78738_3_, int p_78738_4_, int p_78738_5_, int p_78738_6_, int p_78738_7_) {
/*      */     NetherStalkRoom netherStalkRoom;
/*   87 */     Class<Straight> clazz = p_78738_0_.field_78828_a;
/*   88 */     Straight straight = null;
/*      */     
/*   90 */     if (clazz == Straight.class) {
/*   91 */       straight = Straight.func_74983_a(p_78738_1_, p_78738_2_, p_78738_3_, p_78738_4_, p_78738_5_, p_78738_6_, p_78738_7_);
/*   92 */     } else if (clazz == Crossing3.class) {
/*   93 */       Crossing3 crossing3 = Crossing3.func_74966_a(p_78738_1_, p_78738_2_, p_78738_3_, p_78738_4_, p_78738_5_, p_78738_6_, p_78738_7_);
/*   94 */     } else if (clazz == Crossing.class) {
/*   95 */       Crossing crossing = Crossing.func_74974_a(p_78738_1_, p_78738_2_, p_78738_3_, p_78738_4_, p_78738_5_, p_78738_6_, p_78738_7_);
/*   96 */     } else if (clazz == Stairs.class) {
/*   97 */       Stairs stairs = Stairs.func_74973_a(p_78738_1_, p_78738_2_, p_78738_3_, p_78738_4_, p_78738_5_, p_78738_6_, p_78738_7_);
/*   98 */     } else if (clazz == Throne.class) {
/*   99 */       Throne throne = Throne.func_74975_a(p_78738_1_, p_78738_2_, p_78738_3_, p_78738_4_, p_78738_5_, p_78738_6_, p_78738_7_);
/*  100 */     } else if (clazz == Entrance.class) {
/*  101 */       Entrance entrance = Entrance.func_74984_a(p_78738_1_, p_78738_2_, p_78738_3_, p_78738_4_, p_78738_5_, p_78738_6_, p_78738_7_);
/*  102 */     } else if (clazz == Corridor5.class) {
/*  103 */       Corridor5 corridor5 = Corridor5.func_74981_a(p_78738_1_, p_78738_2_, p_78738_3_, p_78738_4_, p_78738_5_, p_78738_6_, p_78738_7_);
/*  104 */     } else if (clazz == Corridor2.class) {
/*  105 */       Corridor2 corridor2 = Corridor2.func_74980_a(p_78738_1_, p_78738_2_, p_78738_3_, p_78738_4_, p_78738_5_, p_78738_6_, p_78738_7_);
/*  106 */     } else if (clazz == Corridor.class) {
/*  107 */       Corridor corridor = Corridor.func_74978_a(p_78738_1_, p_78738_2_, p_78738_3_, p_78738_4_, p_78738_5_, p_78738_6_, p_78738_7_);
/*  108 */     } else if (clazz == Corridor3.class) {
/*  109 */       Corridor3 corridor3 = Corridor3.func_74982_a(p_78738_1_, p_78738_2_, p_78738_3_, p_78738_4_, p_78738_5_, p_78738_6_, p_78738_7_);
/*  110 */     } else if (clazz == Corridor4.class) {
/*  111 */       Corridor4 corridor4 = Corridor4.func_74985_a(p_78738_1_, p_78738_2_, p_78738_3_, p_78738_4_, p_78738_5_, p_78738_6_, p_78738_7_);
/*  112 */     } else if (clazz == Crossing2.class) {
/*  113 */       Crossing2 crossing2 = Crossing2.func_74979_a(p_78738_1_, p_78738_2_, p_78738_3_, p_78738_4_, p_78738_5_, p_78738_6_, p_78738_7_);
/*  114 */     } else if (clazz == NetherStalkRoom.class) {
/*  115 */       netherStalkRoom = NetherStalkRoom.func_74977_a(p_78738_1_, p_78738_2_, p_78738_3_, p_78738_4_, p_78738_5_, p_78738_6_, p_78738_7_);
/*      */     } 
/*  117 */     return netherStalkRoom;
/*      */   }
/*      */   
/*      */   static abstract class Piece
/*      */     extends StructureComponent
/*      */   {
/*  123 */     protected static final WeightedRandomChestContent[] field_111019_a = new WeightedRandomChestContent[] { new WeightedRandomChestContent(Items.field_151045_i, 0, 1, 3, 5), new WeightedRandomChestContent(Items.field_151042_j, 0, 1, 5, 5), new WeightedRandomChestContent(Items.field_151043_k, 0, 1, 3, 15), new WeightedRandomChestContent(Items.field_151010_B, 0, 1, 1, 5), new WeightedRandomChestContent((Item)Items.field_151171_ah, 0, 1, 1, 5), new WeightedRandomChestContent(Items.field_151033_d, 0, 1, 1, 5), new WeightedRandomChestContent(Items.field_151075_bm, 0, 3, 7, 5), new WeightedRandomChestContent(Items.field_151141_av, 0, 1, 1, 10), new WeightedRandomChestContent(Items.field_151136_bY, 0, 1, 1, 8), new WeightedRandomChestContent(Items.field_151138_bX, 0, 1, 1, 5), new WeightedRandomChestContent(Items.field_151125_bZ, 0, 1, 1, 3) };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private static final String __OBFID = "CL_00000466";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Piece() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected Piece(int p_i2054_1_) {
/*  143 */       super(p_i2054_1_);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     protected void func_143011_b(NBTTagCompound p_143011_1_) {}
/*      */ 
/*      */     
/*      */     protected void func_143012_a(NBTTagCompound p_143012_1_) {}
/*      */ 
/*      */     
/*      */     private int func_74960_a(List p_74960_1_) {
/*  155 */       boolean bool = false;
/*  156 */       int i = 0;
/*  157 */       for (StructureNetherBridgePieces.PieceWeight pieceWeight : p_74960_1_) {
/*  158 */         if (pieceWeight.field_78824_d > 0 && pieceWeight.field_78827_c < pieceWeight.field_78824_d) {
/*  159 */           bool = true;
/*      */         }
/*  161 */         i += pieceWeight.field_78826_b;
/*      */       } 
/*  163 */       return bool ? i : -1;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     private Piece func_74959_a(StructureNetherBridgePieces.Start p_74959_1_, List p_74959_2_, List p_74959_3_, Random p_74959_4_, int p_74959_5_, int p_74959_6_, int p_74959_7_, int p_74959_8_, int p_74959_9_) {
/*  169 */       int i = func_74960_a(p_74959_2_);
/*  170 */       boolean bool = (i > 0 && p_74959_9_ <= 30) ? true : false;
/*      */       
/*  172 */       byte b = 0;
/*  173 */       while (b < 5 && bool) {
/*  174 */         b++;
/*      */         
/*  176 */         int j = p_74959_4_.nextInt(i);
/*  177 */         for (StructureNetherBridgePieces.PieceWeight pieceWeight : p_74959_2_) {
/*  178 */           j -= pieceWeight.field_78826_b;
/*  179 */           if (j < 0) {
/*      */             
/*  181 */             if (!pieceWeight.func_78822_a(p_74959_9_) || (pieceWeight == p_74959_1_.field_74970_a && !pieceWeight.field_78825_e)) {
/*      */               break;
/*      */             }
/*      */             
/*  185 */             Piece piece = StructureNetherBridgePieces.func_78738_b(pieceWeight, p_74959_3_, p_74959_4_, p_74959_5_, p_74959_6_, p_74959_7_, p_74959_8_, p_74959_9_);
/*  186 */             if (piece != null) {
/*  187 */               pieceWeight.field_78827_c++;
/*  188 */               p_74959_1_.field_74970_a = pieceWeight;
/*      */               
/*  190 */               if (!pieceWeight.func_78823_a()) {
/*  191 */                 p_74959_2_.remove(pieceWeight);
/*      */               }
/*  193 */               return piece;
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       } 
/*  198 */       return StructureNetherBridgePieces.End.func_74971_a(p_74959_3_, p_74959_4_, p_74959_5_, p_74959_6_, p_74959_7_, p_74959_8_, p_74959_9_);
/*      */     }
/*      */     
/*      */     private StructureComponent func_74962_a(StructureNetherBridgePieces.Start p_74962_1_, List<Piece> p_74962_2_, Random p_74962_3_, int p_74962_4_, int p_74962_5_, int p_74962_6_, int p_74962_7_, int p_74962_8_, boolean p_74962_9_) {
/*  202 */       if (Math.abs(p_74962_4_ - (p_74962_1_.func_74874_b()).field_78897_a) > 112 || Math.abs(p_74962_6_ - (p_74962_1_.func_74874_b()).field_78896_c) > 112) {
/*  203 */         return StructureNetherBridgePieces.End.func_74971_a(p_74962_2_, p_74962_3_, p_74962_4_, p_74962_5_, p_74962_6_, p_74962_7_, p_74962_8_);
/*      */       }
/*  205 */       List list = p_74962_1_.field_74968_b;
/*  206 */       if (p_74962_9_) {
/*  207 */         list = p_74962_1_.field_74969_c;
/*      */       }
/*  209 */       Piece piece = func_74959_a(p_74962_1_, list, p_74962_2_, p_74962_3_, p_74962_4_, p_74962_5_, p_74962_6_, p_74962_7_, p_74962_8_ + 1);
/*  210 */       if (piece != null) {
/*  211 */         p_74962_2_.add(piece);
/*  212 */         p_74962_1_.field_74967_d.add(piece);
/*      */       } 
/*  214 */       return piece;
/*      */     }
/*      */     
/*      */     protected StructureComponent func_74963_a(StructureNetherBridgePieces.Start p_74963_1_, List p_74963_2_, Random p_74963_3_, int p_74963_4_, int p_74963_5_, boolean p_74963_6_) {
/*  218 */       switch (this.field_74885_f) {
/*      */         case 2:
/*  220 */           return func_74962_a(p_74963_1_, p_74963_2_, p_74963_3_, this.field_74887_e.field_78897_a + p_74963_4_, this.field_74887_e.field_78895_b + p_74963_5_, this.field_74887_e.field_78896_c - 1, this.field_74885_f, func_74877_c(), p_74963_6_);
/*      */         case 0:
/*  222 */           return func_74962_a(p_74963_1_, p_74963_2_, p_74963_3_, this.field_74887_e.field_78897_a + p_74963_4_, this.field_74887_e.field_78895_b + p_74963_5_, this.field_74887_e.field_78892_f + 1, this.field_74885_f, func_74877_c(), p_74963_6_);
/*      */         case 1:
/*  224 */           return func_74962_a(p_74963_1_, p_74963_2_, p_74963_3_, this.field_74887_e.field_78897_a - 1, this.field_74887_e.field_78895_b + p_74963_5_, this.field_74887_e.field_78896_c + p_74963_4_, this.field_74885_f, func_74877_c(), p_74963_6_);
/*      */         case 3:
/*  226 */           return func_74962_a(p_74963_1_, p_74963_2_, p_74963_3_, this.field_74887_e.field_78893_d + 1, this.field_74887_e.field_78895_b + p_74963_5_, this.field_74887_e.field_78896_c + p_74963_4_, this.field_74885_f, func_74877_c(), p_74963_6_);
/*      */       } 
/*  228 */       return null;
/*      */     }
/*      */     
/*      */     protected StructureComponent func_74961_b(StructureNetherBridgePieces.Start p_74961_1_, List p_74961_2_, Random p_74961_3_, int p_74961_4_, int p_74961_5_, boolean p_74961_6_) {
/*  232 */       switch (this.field_74885_f) {
/*      */         case 2:
/*  234 */           return func_74962_a(p_74961_1_, p_74961_2_, p_74961_3_, this.field_74887_e.field_78897_a - 1, this.field_74887_e.field_78895_b + p_74961_4_, this.field_74887_e.field_78896_c + p_74961_5_, 1, func_74877_c(), p_74961_6_);
/*      */         case 0:
/*  236 */           return func_74962_a(p_74961_1_, p_74961_2_, p_74961_3_, this.field_74887_e.field_78897_a - 1, this.field_74887_e.field_78895_b + p_74961_4_, this.field_74887_e.field_78896_c + p_74961_5_, 1, func_74877_c(), p_74961_6_);
/*      */         case 1:
/*  238 */           return func_74962_a(p_74961_1_, p_74961_2_, p_74961_3_, this.field_74887_e.field_78897_a + p_74961_5_, this.field_74887_e.field_78895_b + p_74961_4_, this.field_74887_e.field_78896_c - 1, 2, func_74877_c(), p_74961_6_);
/*      */         case 3:
/*  240 */           return func_74962_a(p_74961_1_, p_74961_2_, p_74961_3_, this.field_74887_e.field_78897_a + p_74961_5_, this.field_74887_e.field_78895_b + p_74961_4_, this.field_74887_e.field_78896_c - 1, 2, func_74877_c(), p_74961_6_);
/*      */       } 
/*  242 */       return null;
/*      */     }
/*      */     
/*      */     protected StructureComponent func_74965_c(StructureNetherBridgePieces.Start p_74965_1_, List p_74965_2_, Random p_74965_3_, int p_74965_4_, int p_74965_5_, boolean p_74965_6_) {
/*  246 */       switch (this.field_74885_f) {
/*      */         case 2:
/*  248 */           return func_74962_a(p_74965_1_, p_74965_2_, p_74965_3_, this.field_74887_e.field_78893_d + 1, this.field_74887_e.field_78895_b + p_74965_4_, this.field_74887_e.field_78896_c + p_74965_5_, 3, func_74877_c(), p_74965_6_);
/*      */         case 0:
/*  250 */           return func_74962_a(p_74965_1_, p_74965_2_, p_74965_3_, this.field_74887_e.field_78893_d + 1, this.field_74887_e.field_78895_b + p_74965_4_, this.field_74887_e.field_78896_c + p_74965_5_, 3, func_74877_c(), p_74965_6_);
/*      */         case 1:
/*  252 */           return func_74962_a(p_74965_1_, p_74965_2_, p_74965_3_, this.field_74887_e.field_78897_a + p_74965_5_, this.field_74887_e.field_78895_b + p_74965_4_, this.field_74887_e.field_78892_f + 1, 0, func_74877_c(), p_74965_6_);
/*      */         case 3:
/*  254 */           return func_74962_a(p_74965_1_, p_74965_2_, p_74965_3_, this.field_74887_e.field_78897_a + p_74965_5_, this.field_74887_e.field_78895_b + p_74965_4_, this.field_74887_e.field_78892_f + 1, 0, func_74877_c(), p_74965_6_);
/*      */       } 
/*  256 */       return null;
/*      */     }
/*      */     
/*      */     protected static boolean func_74964_a(StructureBoundingBox p_74964_0_) {
/*  260 */       return (p_74964_0_ != null && p_74964_0_.field_78895_b > 10);
/*      */     }
/*      */   }
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
/*      */   public static class Start
/*      */     extends Crossing3
/*      */   {
/*      */     public StructureNetherBridgePieces.PieceWeight field_74970_a;
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
/*      */     public List field_74968_b;
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
/*      */     public List field_74969_c;
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
/*  310 */     public ArrayList field_74967_d = new ArrayList();
/*      */     
/*      */     private static final String __OBFID = "CL_00000470";
/*      */     
/*      */     public Start() {}
/*      */     
/*      */     public Start(Random p_i2059_1_, int p_i2059_2_, int p_i2059_3_) {
/*  317 */       super(p_i2059_1_, p_i2059_2_, p_i2059_3_);
/*      */       
/*  319 */       this.field_74968_b = new ArrayList();
/*  320 */       for (StructureNetherBridgePieces.PieceWeight pieceWeight : StructureNetherBridgePieces.field_78742_a) {
/*  321 */         pieceWeight.field_78827_c = 0;
/*  322 */         this.field_74968_b.add(pieceWeight);
/*      */       } 
/*      */       
/*  325 */       this.field_74969_c = new ArrayList();
/*  326 */       for (StructureNetherBridgePieces.PieceWeight pieceWeight : StructureNetherBridgePieces.field_78741_b) {
/*  327 */         pieceWeight.field_78827_c = 0;
/*  328 */         this.field_74969_c.add(pieceWeight);
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     protected void func_143011_b(NBTTagCompound p_143011_1_) {
/*  334 */       super.func_143011_b(p_143011_1_);
/*      */     }
/*      */ 
/*      */     
/*      */     protected void func_143012_a(NBTTagCompound p_143012_1_) {
/*  339 */       super.func_143012_a(p_143012_1_);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static class Straight
/*      */     extends Piece
/*      */   {
/*      */     private static final String __OBFID = "CL_00000456";
/*      */ 
/*      */     
/*      */     public Straight() {}
/*      */ 
/*      */     
/*      */     public Straight(int p_i2044_1_, Random p_i2044_2_, StructureBoundingBox p_i2044_3_, int p_i2044_4_) {
/*  355 */       super(p_i2044_1_);
/*      */       
/*  357 */       this.field_74885_f = p_i2044_4_;
/*  358 */       this.field_74887_e = p_i2044_3_;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_) {
/*  365 */       func_74963_a((StructureNetherBridgePieces.Start)p_74861_1_, p_74861_2_, p_74861_3_, 1, 3, false);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public static Straight func_74983_a(List p_74983_0_, Random p_74983_1_, int p_74983_2_, int p_74983_3_, int p_74983_4_, int p_74983_5_, int p_74983_6_) {
/*  371 */       StructureBoundingBox structureBoundingBox = StructureBoundingBox.func_78889_a(p_74983_2_, p_74983_3_, p_74983_4_, -1, -3, 0, 5, 10, 19, p_74983_5_);
/*      */       
/*  373 */       if (!func_74964_a(structureBoundingBox) || StructureComponent.func_74883_a(p_74983_0_, structureBoundingBox) != null) {
/*  374 */         return null;
/*      */       }
/*      */       
/*  377 */       return new Straight(p_74983_6_, p_74983_1_, structureBoundingBox, p_74983_5_);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
/*  384 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 3, 0, 4, 4, 18, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*      */       
/*  386 */       func_151549_a(p_74875_1_, p_74875_3_, 1, 5, 0, 3, 7, 18, Blocks.field_150350_a, Blocks.field_150350_a, false);
/*      */ 
/*      */       
/*  389 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 5, 0, 0, 5, 18, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*  390 */       func_151549_a(p_74875_1_, p_74875_3_, 4, 5, 0, 4, 5, 18, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*      */ 
/*      */       
/*  393 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 2, 0, 4, 2, 5, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*  394 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 2, 13, 4, 2, 18, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*  395 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 0, 0, 4, 1, 3, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*  396 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 0, 15, 4, 1, 18, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*      */       
/*  398 */       for (byte b = 0; b <= 4; b++) {
/*  399 */         for (byte b1 = 0; b1 <= 2; b1++) {
/*  400 */           func_151554_b(p_74875_1_, Blocks.field_150385_bj, 0, b, -1, b1, p_74875_3_);
/*  401 */           func_151554_b(p_74875_1_, Blocks.field_150385_bj, 0, b, -1, 18 - b1, p_74875_3_);
/*      */         } 
/*      */       } 
/*      */       
/*  405 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 1, 1, 0, 4, 1, Blocks.field_150386_bk, Blocks.field_150386_bk, false);
/*  406 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 3, 4, 0, 4, 4, Blocks.field_150386_bk, Blocks.field_150386_bk, false);
/*  407 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 3, 14, 0, 4, 14, Blocks.field_150386_bk, Blocks.field_150386_bk, false);
/*  408 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 1, 17, 0, 4, 17, Blocks.field_150386_bk, Blocks.field_150386_bk, false);
/*  409 */       func_151549_a(p_74875_1_, p_74875_3_, 4, 1, 1, 4, 4, 1, Blocks.field_150386_bk, Blocks.field_150386_bk, false);
/*  410 */       func_151549_a(p_74875_1_, p_74875_3_, 4, 3, 4, 4, 4, 4, Blocks.field_150386_bk, Blocks.field_150386_bk, false);
/*  411 */       func_151549_a(p_74875_1_, p_74875_3_, 4, 3, 14, 4, 4, 14, Blocks.field_150386_bk, Blocks.field_150386_bk, false);
/*  412 */       func_151549_a(p_74875_1_, p_74875_3_, 4, 1, 17, 4, 4, 17, Blocks.field_150386_bk, Blocks.field_150386_bk, false);
/*      */       
/*  414 */       return true;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static class End
/*      */     extends Piece
/*      */   {
/*      */     private int field_74972_a;
/*      */     
/*      */     private static final String __OBFID = "CL_00000455";
/*      */ 
/*      */     
/*      */     public End() {}
/*      */ 
/*      */     
/*      */     public End(int p_i2043_1_, Random p_i2043_2_, StructureBoundingBox p_i2043_3_, int p_i2043_4_) {
/*  432 */       super(p_i2043_1_);
/*      */       
/*  434 */       this.field_74885_f = p_i2043_4_;
/*  435 */       this.field_74887_e = p_i2043_3_;
/*  436 */       this.field_74972_a = p_i2043_2_.nextInt();
/*      */     }
/*      */ 
/*      */     
/*      */     public static End func_74971_a(List p_74971_0_, Random p_74971_1_, int p_74971_2_, int p_74971_3_, int p_74971_4_, int p_74971_5_, int p_74971_6_) {
/*  441 */       StructureBoundingBox structureBoundingBox = StructureBoundingBox.func_78889_a(p_74971_2_, p_74971_3_, p_74971_4_, -1, -3, 0, 5, 10, 8, p_74971_5_);
/*      */       
/*  443 */       if (!func_74964_a(structureBoundingBox) || StructureComponent.func_74883_a(p_74971_0_, structureBoundingBox) != null) {
/*  444 */         return null;
/*      */       }
/*      */       
/*  447 */       return new End(p_74971_6_, p_74971_1_, structureBoundingBox, p_74971_5_);
/*      */     }
/*      */ 
/*      */     
/*      */     protected void func_143011_b(NBTTagCompound p_143011_1_) {
/*  452 */       super.func_143011_b(p_143011_1_);
/*      */       
/*  454 */       this.field_74972_a = p_143011_1_.func_74762_e("Seed");
/*      */     }
/*      */ 
/*      */     
/*      */     protected void func_143012_a(NBTTagCompound p_143012_1_) {
/*  459 */       super.func_143012_a(p_143012_1_);
/*      */       
/*  461 */       p_143012_1_.func_74768_a("Seed", this.field_74972_a);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
/*  467 */       Random random = new Random(this.field_74972_a);
/*      */       
/*      */       int i;
/*  470 */       for (i = 0; i <= 4; i++) {
/*  471 */         for (byte b = 3; b <= 4; b++) {
/*  472 */           int j = random.nextInt(8);
/*  473 */           func_151549_a(p_74875_1_, p_74875_3_, i, b, 0, i, b, j, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*      */         } 
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/*  479 */       i = random.nextInt(8);
/*  480 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 5, 0, 0, 5, i, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*      */ 
/*      */       
/*  483 */       i = random.nextInt(8);
/*  484 */       func_151549_a(p_74875_1_, p_74875_3_, 4, 5, 0, 4, 5, i, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*      */ 
/*      */ 
/*      */       
/*  488 */       for (i = 0; i <= 4; i++) {
/*  489 */         int j = random.nextInt(5);
/*  490 */         func_151549_a(p_74875_1_, p_74875_3_, i, 2, 0, i, 2, j, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*      */       } 
/*  492 */       for (i = 0; i <= 4; i++) {
/*  493 */         for (byte b = 0; b <= 1; b++) {
/*  494 */           int j = random.nextInt(3);
/*  495 */           func_151549_a(p_74875_1_, p_74875_3_, i, b, 0, i, b, j, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*      */         } 
/*      */       } 
/*      */       
/*  499 */       return true;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static class Crossing3
/*      */     extends Piece
/*      */   {
/*      */     private static final String __OBFID = "CL_00000454";
/*      */ 
/*      */     
/*      */     public Crossing3() {}
/*      */ 
/*      */     
/*      */     public Crossing3(int p_i2041_1_, Random p_i2041_2_, StructureBoundingBox p_i2041_3_, int p_i2041_4_) {
/*  515 */       super(p_i2041_1_);
/*      */       
/*  517 */       this.field_74885_f = p_i2041_4_;
/*  518 */       this.field_74887_e = p_i2041_3_;
/*      */     }
/*      */ 
/*      */     
/*      */     protected Crossing3(Random p_i2042_1_, int p_i2042_2_, int p_i2042_3_) {
/*  523 */       super(0);
/*      */       
/*  525 */       this.field_74885_f = p_i2042_1_.nextInt(4);
/*      */       
/*  527 */       switch (this.field_74885_f) {
/*      */         case 0:
/*      */         case 2:
/*  530 */           this.field_74887_e = new StructureBoundingBox(p_i2042_2_, 64, p_i2042_3_, p_i2042_2_ + 19 - 1, 73, p_i2042_3_ + 19 - 1);
/*      */           return;
/*      */       } 
/*  533 */       this.field_74887_e = new StructureBoundingBox(p_i2042_2_, 64, p_i2042_3_, p_i2042_2_ + 19 - 1, 73, p_i2042_3_ + 19 - 1);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_) {
/*  541 */       func_74963_a((StructureNetherBridgePieces.Start)p_74861_1_, p_74861_2_, p_74861_3_, 8, 3, false);
/*  542 */       func_74961_b((StructureNetherBridgePieces.Start)p_74861_1_, p_74861_2_, p_74861_3_, 3, 8, false);
/*  543 */       func_74965_c((StructureNetherBridgePieces.Start)p_74861_1_, p_74861_2_, p_74861_3_, 3, 8, false);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public static Crossing3 func_74966_a(List p_74966_0_, Random p_74966_1_, int p_74966_2_, int p_74966_3_, int p_74966_4_, int p_74966_5_, int p_74966_6_) {
/*  549 */       StructureBoundingBox structureBoundingBox = StructureBoundingBox.func_78889_a(p_74966_2_, p_74966_3_, p_74966_4_, -8, -3, 0, 19, 10, 19, p_74966_5_);
/*      */       
/*  551 */       if (!func_74964_a(structureBoundingBox) || StructureComponent.func_74883_a(p_74966_0_, structureBoundingBox) != null) {
/*  552 */         return null;
/*      */       }
/*      */       
/*  555 */       return new Crossing3(p_74966_6_, p_74966_1_, structureBoundingBox, p_74966_5_);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
/*  562 */       func_151549_a(p_74875_1_, p_74875_3_, 7, 3, 0, 11, 4, 18, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*  563 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 3, 7, 18, 4, 11, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*      */       
/*  565 */       func_151549_a(p_74875_1_, p_74875_3_, 8, 5, 0, 10, 7, 18, Blocks.field_150350_a, Blocks.field_150350_a, false);
/*  566 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 5, 8, 18, 7, 10, Blocks.field_150350_a, Blocks.field_150350_a, false);
/*      */       
/*  568 */       func_151549_a(p_74875_1_, p_74875_3_, 7, 5, 0, 7, 5, 7, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*  569 */       func_151549_a(p_74875_1_, p_74875_3_, 7, 5, 11, 7, 5, 18, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*  570 */       func_151549_a(p_74875_1_, p_74875_3_, 11, 5, 0, 11, 5, 7, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*  571 */       func_151549_a(p_74875_1_, p_74875_3_, 11, 5, 11, 11, 5, 18, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*  572 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 5, 7, 7, 5, 7, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*  573 */       func_151549_a(p_74875_1_, p_74875_3_, 11, 5, 7, 18, 5, 7, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*  574 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 5, 11, 7, 5, 11, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*  575 */       func_151549_a(p_74875_1_, p_74875_3_, 11, 5, 11, 18, 5, 11, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*      */ 
/*      */       
/*  578 */       func_151549_a(p_74875_1_, p_74875_3_, 7, 2, 0, 11, 2, 5, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*  579 */       func_151549_a(p_74875_1_, p_74875_3_, 7, 2, 13, 11, 2, 18, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*  580 */       func_151549_a(p_74875_1_, p_74875_3_, 7, 0, 0, 11, 1, 3, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*  581 */       func_151549_a(p_74875_1_, p_74875_3_, 7, 0, 15, 11, 1, 18, Blocks.field_150385_bj, Blocks.field_150385_bj, false); byte b;
/*  582 */       for (b = 7; b <= 11; b++) {
/*  583 */         for (byte b1 = 0; b1 <= 2; b1++) {
/*  584 */           func_151554_b(p_74875_1_, Blocks.field_150385_bj, 0, b, -1, b1, p_74875_3_);
/*  585 */           func_151554_b(p_74875_1_, Blocks.field_150385_bj, 0, b, -1, 18 - b1, p_74875_3_);
/*      */         } 
/*      */       } 
/*      */       
/*  589 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 2, 7, 5, 2, 11, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*  590 */       func_151549_a(p_74875_1_, p_74875_3_, 13, 2, 7, 18, 2, 11, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*  591 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 0, 7, 3, 1, 11, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*  592 */       func_151549_a(p_74875_1_, p_74875_3_, 15, 0, 7, 18, 1, 11, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*  593 */       for (b = 0; b <= 2; b++) {
/*  594 */         for (byte b1 = 7; b1 <= 11; b1++) {
/*  595 */           func_151554_b(p_74875_1_, Blocks.field_150385_bj, 0, b, -1, b1, p_74875_3_);
/*  596 */           func_151554_b(p_74875_1_, Blocks.field_150385_bj, 0, 18 - b, -1, b1, p_74875_3_);
/*      */         } 
/*      */       } 
/*      */       
/*  600 */       return true;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static class Crossing
/*      */     extends Piece
/*      */   {
/*      */     private static final String __OBFID = "CL_00000468";
/*      */ 
/*      */     
/*      */     public Crossing() {}
/*      */ 
/*      */     
/*      */     public Crossing(int p_i2057_1_, Random p_i2057_2_, StructureBoundingBox p_i2057_3_, int p_i2057_4_) {
/*  616 */       super(p_i2057_1_);
/*      */       
/*  618 */       this.field_74885_f = p_i2057_4_;
/*  619 */       this.field_74887_e = p_i2057_3_;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_) {
/*  626 */       func_74963_a((StructureNetherBridgePieces.Start)p_74861_1_, p_74861_2_, p_74861_3_, 2, 0, false);
/*  627 */       func_74961_b((StructureNetherBridgePieces.Start)p_74861_1_, p_74861_2_, p_74861_3_, 0, 2, false);
/*  628 */       func_74965_c((StructureNetherBridgePieces.Start)p_74861_1_, p_74861_2_, p_74861_3_, 0, 2, false);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public static Crossing func_74974_a(List p_74974_0_, Random p_74974_1_, int p_74974_2_, int p_74974_3_, int p_74974_4_, int p_74974_5_, int p_74974_6_) {
/*  634 */       StructureBoundingBox structureBoundingBox = StructureBoundingBox.func_78889_a(p_74974_2_, p_74974_3_, p_74974_4_, -2, 0, 0, 7, 9, 7, p_74974_5_);
/*      */       
/*  636 */       if (!func_74964_a(structureBoundingBox) || StructureComponent.func_74883_a(p_74974_0_, structureBoundingBox) != null) {
/*  637 */         return null;
/*      */       }
/*      */       
/*  640 */       return new Crossing(p_74974_6_, p_74974_1_, structureBoundingBox, p_74974_5_);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
/*  647 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 0, 0, 6, 1, 6, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*      */       
/*  649 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 2, 0, 6, 7, 6, Blocks.field_150350_a, Blocks.field_150350_a, false);
/*      */ 
/*      */       
/*  652 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 2, 0, 1, 6, 0, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*  653 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 2, 6, 1, 6, 6, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*  654 */       func_151549_a(p_74875_1_, p_74875_3_, 5, 2, 0, 6, 6, 0, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*  655 */       func_151549_a(p_74875_1_, p_74875_3_, 5, 2, 6, 6, 6, 6, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*  656 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 2, 0, 0, 6, 1, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*  657 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 2, 5, 0, 6, 6, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*  658 */       func_151549_a(p_74875_1_, p_74875_3_, 6, 2, 0, 6, 6, 1, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*  659 */       func_151549_a(p_74875_1_, p_74875_3_, 6, 2, 5, 6, 6, 6, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*      */ 
/*      */       
/*  662 */       func_151549_a(p_74875_1_, p_74875_3_, 2, 6, 0, 4, 6, 0, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*  663 */       func_151549_a(p_74875_1_, p_74875_3_, 2, 5, 0, 4, 5, 0, Blocks.field_150386_bk, Blocks.field_150386_bk, false);
/*  664 */       func_151549_a(p_74875_1_, p_74875_3_, 2, 6, 6, 4, 6, 6, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*  665 */       func_151549_a(p_74875_1_, p_74875_3_, 2, 5, 6, 4, 5, 6, Blocks.field_150386_bk, Blocks.field_150386_bk, false);
/*  666 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 6, 2, 0, 6, 4, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*  667 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 5, 2, 0, 5, 4, Blocks.field_150386_bk, Blocks.field_150386_bk, false);
/*  668 */       func_151549_a(p_74875_1_, p_74875_3_, 6, 6, 2, 6, 6, 4, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*  669 */       func_151549_a(p_74875_1_, p_74875_3_, 6, 5, 2, 6, 5, 4, Blocks.field_150386_bk, Blocks.field_150386_bk, false);
/*      */ 
/*      */       
/*  672 */       for (byte b = 0; b <= 6; b++) {
/*  673 */         for (byte b1 = 0; b1 <= 6; b1++) {
/*  674 */           func_151554_b(p_74875_1_, Blocks.field_150385_bj, 0, b, -1, b1, p_74875_3_);
/*      */         }
/*      */       } 
/*      */       
/*  678 */       return true;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static class Stairs
/*      */     extends Piece
/*      */   {
/*      */     private static final String __OBFID = "CL_00000469";
/*      */ 
/*      */     
/*      */     public Stairs() {}
/*      */ 
/*      */     
/*      */     public Stairs(int p_i2058_1_, Random p_i2058_2_, StructureBoundingBox p_i2058_3_, int p_i2058_4_) {
/*  694 */       super(p_i2058_1_);
/*      */       
/*  696 */       this.field_74885_f = p_i2058_4_;
/*  697 */       this.field_74887_e = p_i2058_3_;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_) {
/*  704 */       func_74965_c((StructureNetherBridgePieces.Start)p_74861_1_, p_74861_2_, p_74861_3_, 6, 2, false);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public static Stairs func_74973_a(List p_74973_0_, Random p_74973_1_, int p_74973_2_, int p_74973_3_, int p_74973_4_, int p_74973_5_, int p_74973_6_) {
/*  710 */       StructureBoundingBox structureBoundingBox = StructureBoundingBox.func_78889_a(p_74973_2_, p_74973_3_, p_74973_4_, -2, 0, 0, 7, 11, 7, p_74973_5_);
/*      */       
/*  712 */       if (!func_74964_a(structureBoundingBox) || StructureComponent.func_74883_a(p_74973_0_, structureBoundingBox) != null) {
/*  713 */         return null;
/*      */       }
/*      */       
/*  716 */       return new Stairs(p_74973_6_, p_74973_1_, structureBoundingBox, p_74973_5_);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
/*  723 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 0, 0, 6, 1, 6, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*      */       
/*  725 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 2, 0, 6, 10, 6, Blocks.field_150350_a, Blocks.field_150350_a, false);
/*      */ 
/*      */       
/*  728 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 2, 0, 1, 8, 0, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*  729 */       func_151549_a(p_74875_1_, p_74875_3_, 5, 2, 0, 6, 8, 0, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*  730 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 2, 1, 0, 8, 6, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*  731 */       func_151549_a(p_74875_1_, p_74875_3_, 6, 2, 1, 6, 8, 6, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*  732 */       func_151549_a(p_74875_1_, p_74875_3_, 1, 2, 6, 5, 8, 6, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*      */ 
/*      */       
/*  735 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 3, 2, 0, 5, 4, Blocks.field_150386_bk, Blocks.field_150386_bk, false);
/*  736 */       func_151549_a(p_74875_1_, p_74875_3_, 6, 3, 2, 6, 5, 2, Blocks.field_150386_bk, Blocks.field_150386_bk, false);
/*  737 */       func_151549_a(p_74875_1_, p_74875_3_, 6, 3, 4, 6, 5, 4, Blocks.field_150386_bk, Blocks.field_150386_bk, false);
/*      */ 
/*      */       
/*  740 */       func_151550_a(p_74875_1_, Blocks.field_150385_bj, 0, 5, 2, 5, p_74875_3_);
/*  741 */       func_151549_a(p_74875_1_, p_74875_3_, 4, 2, 5, 4, 3, 5, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*  742 */       func_151549_a(p_74875_1_, p_74875_3_, 3, 2, 5, 3, 4, 5, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*  743 */       func_151549_a(p_74875_1_, p_74875_3_, 2, 2, 5, 2, 5, 5, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*  744 */       func_151549_a(p_74875_1_, p_74875_3_, 1, 2, 5, 1, 6, 5, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*      */ 
/*      */       
/*  747 */       func_151549_a(p_74875_1_, p_74875_3_, 1, 7, 1, 5, 7, 4, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*  748 */       func_151549_a(p_74875_1_, p_74875_3_, 6, 8, 2, 6, 8, 4, Blocks.field_150350_a, Blocks.field_150350_a, false);
/*      */ 
/*      */       
/*  751 */       func_151549_a(p_74875_1_, p_74875_3_, 2, 6, 0, 4, 8, 0, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*  752 */       func_151549_a(p_74875_1_, p_74875_3_, 2, 5, 0, 4, 5, 0, Blocks.field_150386_bk, Blocks.field_150386_bk, false);
/*      */       
/*  754 */       for (byte b = 0; b <= 6; b++) {
/*  755 */         for (byte b1 = 0; b1 <= 6; b1++) {
/*  756 */           func_151554_b(p_74875_1_, Blocks.field_150385_bj, 0, b, -1, b1, p_74875_3_);
/*      */         }
/*      */       } 
/*      */       
/*  760 */       return true;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static class Throne
/*      */     extends Piece
/*      */   {
/*      */     private boolean field_74976_a;
/*      */     
/*      */     private static final String __OBFID = "CL_00000465";
/*      */ 
/*      */     
/*      */     public Throne() {}
/*      */ 
/*      */     
/*      */     public Throne(int p_i2053_1_, Random p_i2053_2_, StructureBoundingBox p_i2053_3_, int p_i2053_4_) {
/*  778 */       super(p_i2053_1_);
/*      */       
/*  780 */       this.field_74885_f = p_i2053_4_;
/*  781 */       this.field_74887_e = p_i2053_3_;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     protected void func_143011_b(NBTTagCompound p_143011_1_) {
/*  787 */       super.func_143011_b(p_143011_1_);
/*      */       
/*  789 */       this.field_74976_a = p_143011_1_.func_74767_n("Mob");
/*      */     }
/*      */ 
/*      */     
/*      */     protected void func_143012_a(NBTTagCompound p_143012_1_) {
/*  794 */       super.func_143012_a(p_143012_1_);
/*      */       
/*  796 */       p_143012_1_.func_74757_a("Mob", this.field_74976_a);
/*      */     }
/*      */ 
/*      */     
/*      */     public static Throne func_74975_a(List p_74975_0_, Random p_74975_1_, int p_74975_2_, int p_74975_3_, int p_74975_4_, int p_74975_5_, int p_74975_6_) {
/*  801 */       StructureBoundingBox structureBoundingBox = StructureBoundingBox.func_78889_a(p_74975_2_, p_74975_3_, p_74975_4_, -2, 0, 0, 7, 8, 9, p_74975_5_);
/*      */       
/*  803 */       if (!func_74964_a(structureBoundingBox) || StructureComponent.func_74883_a(p_74975_0_, structureBoundingBox) != null) {
/*  804 */         return null;
/*      */       }
/*      */       
/*  807 */       return new Throne(p_74975_6_, p_74975_1_, structureBoundingBox, p_74975_5_);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
/*  814 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 2, 0, 6, 7, 7, Blocks.field_150350_a, Blocks.field_150350_a, false);
/*      */ 
/*      */       
/*  817 */       func_151549_a(p_74875_1_, p_74875_3_, 1, 0, 0, 5, 1, 7, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*  818 */       func_151549_a(p_74875_1_, p_74875_3_, 1, 2, 1, 5, 2, 7, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*  819 */       func_151549_a(p_74875_1_, p_74875_3_, 1, 3, 2, 5, 3, 7, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*  820 */       func_151549_a(p_74875_1_, p_74875_3_, 1, 4, 3, 5, 4, 7, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*      */ 
/*      */       
/*  823 */       func_151549_a(p_74875_1_, p_74875_3_, 1, 2, 0, 1, 4, 2, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*  824 */       func_151549_a(p_74875_1_, p_74875_3_, 5, 2, 0, 5, 4, 2, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*  825 */       func_151549_a(p_74875_1_, p_74875_3_, 1, 5, 2, 1, 5, 3, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*  826 */       func_151549_a(p_74875_1_, p_74875_3_, 5, 5, 2, 5, 5, 3, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*  827 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 5, 3, 0, 5, 8, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*  828 */       func_151549_a(p_74875_1_, p_74875_3_, 6, 5, 3, 6, 5, 8, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*  829 */       func_151549_a(p_74875_1_, p_74875_3_, 1, 5, 8, 5, 5, 8, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*      */       
/*  831 */       func_151550_a(p_74875_1_, Blocks.field_150386_bk, 0, 1, 6, 3, p_74875_3_);
/*  832 */       func_151550_a(p_74875_1_, Blocks.field_150386_bk, 0, 5, 6, 3, p_74875_3_);
/*  833 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 6, 3, 0, 6, 8, Blocks.field_150386_bk, Blocks.field_150386_bk, false);
/*  834 */       func_151549_a(p_74875_1_, p_74875_3_, 6, 6, 3, 6, 6, 8, Blocks.field_150386_bk, Blocks.field_150386_bk, false);
/*  835 */       func_151549_a(p_74875_1_, p_74875_3_, 1, 6, 8, 5, 7, 8, Blocks.field_150386_bk, Blocks.field_150386_bk, false);
/*  836 */       func_151549_a(p_74875_1_, p_74875_3_, 2, 8, 8, 4, 8, 8, Blocks.field_150386_bk, Blocks.field_150386_bk, false);
/*      */       
/*  838 */       if (!this.field_74976_a) {
/*  839 */         int i = func_74862_a(5), j = func_74865_a(3, 5), k = func_74873_b(3, 5);
/*  840 */         if (p_74875_3_.func_78890_b(j, i, k)) {
/*  841 */           this.field_74976_a = true;
/*  842 */           p_74875_1_.func_147465_d(j, i, k, Blocks.field_150474_ac, 0, 2);
/*  843 */           TileEntityMobSpawner tileEntityMobSpawner = (TileEntityMobSpawner)p_74875_1_.func_147438_o(j, i, k);
/*  844 */           if (tileEntityMobSpawner != null) tileEntityMobSpawner.func_145881_a().func_98272_a("Blaze");
/*      */         
/*      */         } 
/*      */       } 
/*      */       
/*  849 */       for (byte b = 0; b <= 6; b++) {
/*  850 */         for (byte b1 = 0; b1 <= 6; b1++) {
/*  851 */           func_151554_b(p_74875_1_, Blocks.field_150385_bj, 0, b, -1, b1, p_74875_3_);
/*      */         }
/*      */       } 
/*      */       
/*  855 */       return true;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static class Entrance
/*      */     extends Piece
/*      */   {
/*      */     private static final String __OBFID = "CL_00000459";
/*      */ 
/*      */     
/*      */     public Entrance() {}
/*      */ 
/*      */     
/*      */     public Entrance(int p_i2047_1_, Random p_i2047_2_, StructureBoundingBox p_i2047_3_, int p_i2047_4_) {
/*  871 */       super(p_i2047_1_);
/*      */       
/*  873 */       this.field_74885_f = p_i2047_4_;
/*  874 */       this.field_74887_e = p_i2047_3_;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_) {
/*  881 */       func_74963_a((StructureNetherBridgePieces.Start)p_74861_1_, p_74861_2_, p_74861_3_, 5, 3, true);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public static Entrance func_74984_a(List p_74984_0_, Random p_74984_1_, int p_74984_2_, int p_74984_3_, int p_74984_4_, int p_74984_5_, int p_74984_6_) {
/*  887 */       StructureBoundingBox structureBoundingBox = StructureBoundingBox.func_78889_a(p_74984_2_, p_74984_3_, p_74984_4_, -5, -3, 0, 13, 14, 13, p_74984_5_);
/*      */       
/*  889 */       if (!func_74964_a(structureBoundingBox) || StructureComponent.func_74883_a(p_74984_0_, structureBoundingBox) != null) {
/*  890 */         return null;
/*      */       }
/*      */       
/*  893 */       return new Entrance(p_74984_6_, p_74984_1_, structureBoundingBox, p_74984_5_);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
/*  900 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 3, 0, 12, 4, 12, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*      */       
/*  902 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 5, 0, 12, 13, 12, Blocks.field_150350_a, Blocks.field_150350_a, false);
/*      */ 
/*      */       
/*  905 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 5, 0, 1, 12, 12, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*  906 */       func_151549_a(p_74875_1_, p_74875_3_, 11, 5, 0, 12, 12, 12, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*  907 */       func_151549_a(p_74875_1_, p_74875_3_, 2, 5, 11, 4, 12, 12, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*  908 */       func_151549_a(p_74875_1_, p_74875_3_, 8, 5, 11, 10, 12, 12, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*  909 */       func_151549_a(p_74875_1_, p_74875_3_, 5, 9, 11, 7, 12, 12, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*  910 */       func_151549_a(p_74875_1_, p_74875_3_, 2, 5, 0, 4, 12, 1, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*  911 */       func_151549_a(p_74875_1_, p_74875_3_, 8, 5, 0, 10, 12, 1, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*  912 */       func_151549_a(p_74875_1_, p_74875_3_, 5, 9, 0, 7, 12, 1, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*      */ 
/*      */       
/*  915 */       func_151549_a(p_74875_1_, p_74875_3_, 2, 11, 2, 10, 12, 10, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*      */ 
/*      */       
/*  918 */       func_151549_a(p_74875_1_, p_74875_3_, 5, 8, 0, 7, 8, 0, Blocks.field_150386_bk, Blocks.field_150386_bk, false);
/*      */       
/*      */       int i;
/*  921 */       for (i = 1; i <= 11; i += 2) {
/*  922 */         func_151549_a(p_74875_1_, p_74875_3_, i, 10, 0, i, 11, 0, Blocks.field_150386_bk, Blocks.field_150386_bk, false);
/*  923 */         func_151549_a(p_74875_1_, p_74875_3_, i, 10, 12, i, 11, 12, Blocks.field_150386_bk, Blocks.field_150386_bk, false);
/*  924 */         func_151549_a(p_74875_1_, p_74875_3_, 0, 10, i, 0, 11, i, Blocks.field_150386_bk, Blocks.field_150386_bk, false);
/*  925 */         func_151549_a(p_74875_1_, p_74875_3_, 12, 10, i, 12, 11, i, Blocks.field_150386_bk, Blocks.field_150386_bk, false);
/*  926 */         func_151550_a(p_74875_1_, Blocks.field_150385_bj, 0, i, 13, 0, p_74875_3_);
/*  927 */         func_151550_a(p_74875_1_, Blocks.field_150385_bj, 0, i, 13, 12, p_74875_3_);
/*  928 */         func_151550_a(p_74875_1_, Blocks.field_150385_bj, 0, 0, 13, i, p_74875_3_);
/*  929 */         func_151550_a(p_74875_1_, Blocks.field_150385_bj, 0, 12, 13, i, p_74875_3_);
/*  930 */         func_151550_a(p_74875_1_, Blocks.field_150386_bk, 0, i + 1, 13, 0, p_74875_3_);
/*  931 */         func_151550_a(p_74875_1_, Blocks.field_150386_bk, 0, i + 1, 13, 12, p_74875_3_);
/*  932 */         func_151550_a(p_74875_1_, Blocks.field_150386_bk, 0, 0, 13, i + 1, p_74875_3_);
/*  933 */         func_151550_a(p_74875_1_, Blocks.field_150386_bk, 0, 12, 13, i + 1, p_74875_3_);
/*      */       } 
/*  935 */       func_151550_a(p_74875_1_, Blocks.field_150386_bk, 0, 0, 13, 0, p_74875_3_);
/*  936 */       func_151550_a(p_74875_1_, Blocks.field_150386_bk, 0, 0, 13, 12, p_74875_3_);
/*  937 */       func_151550_a(p_74875_1_, Blocks.field_150386_bk, 0, 0, 13, 0, p_74875_3_);
/*  938 */       func_151550_a(p_74875_1_, Blocks.field_150386_bk, 0, 12, 13, 0, p_74875_3_);
/*      */ 
/*      */       
/*  941 */       for (i = 3; i <= 9; i += 2) {
/*  942 */         func_151549_a(p_74875_1_, p_74875_3_, 1, 7, i, 1, 8, i, Blocks.field_150386_bk, Blocks.field_150386_bk, false);
/*  943 */         func_151549_a(p_74875_1_, p_74875_3_, 11, 7, i, 11, 8, i, Blocks.field_150386_bk, Blocks.field_150386_bk, false);
/*      */       } 
/*      */ 
/*      */       
/*  947 */       func_151549_a(p_74875_1_, p_74875_3_, 4, 2, 0, 8, 2, 12, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*  948 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 2, 4, 12, 2, 8, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*      */       
/*  950 */       func_151549_a(p_74875_1_, p_74875_3_, 4, 0, 0, 8, 1, 3, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*  951 */       func_151549_a(p_74875_1_, p_74875_3_, 4, 0, 9, 8, 1, 12, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*  952 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 0, 4, 3, 1, 8, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*  953 */       func_151549_a(p_74875_1_, p_74875_3_, 9, 0, 4, 12, 1, 8, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*      */       
/*  955 */       for (i = 4; i <= 8; i++) {
/*  956 */         for (byte b = 0; b <= 2; b++) {
/*  957 */           func_151554_b(p_74875_1_, Blocks.field_150385_bj, 0, i, -1, b, p_74875_3_);
/*  958 */           func_151554_b(p_74875_1_, Blocks.field_150385_bj, 0, i, -1, 12 - b, p_74875_3_);
/*      */         } 
/*      */       } 
/*  961 */       for (i = 0; i <= 2; i++) {
/*  962 */         for (byte b = 4; b <= 8; b++) {
/*  963 */           func_151554_b(p_74875_1_, Blocks.field_150385_bj, 0, i, -1, b, p_74875_3_);
/*  964 */           func_151554_b(p_74875_1_, Blocks.field_150385_bj, 0, 12 - i, -1, b, p_74875_3_);
/*      */         } 
/*      */       } 
/*      */ 
/*      */       
/*  969 */       func_151549_a(p_74875_1_, p_74875_3_, 5, 5, 5, 7, 5, 7, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*  970 */       func_151549_a(p_74875_1_, p_74875_3_, 6, 1, 6, 6, 4, 6, Blocks.field_150350_a, Blocks.field_150350_a, false);
/*  971 */       func_151550_a(p_74875_1_, Blocks.field_150385_bj, 0, 6, 0, 6, p_74875_3_);
/*  972 */       func_151550_a(p_74875_1_, (Block)Blocks.field_150356_k, 0, 6, 5, 6, p_74875_3_);
/*      */       
/*  974 */       i = func_74865_a(6, 6);
/*  975 */       int j = func_74862_a(5);
/*  976 */       int k = func_74873_b(6, 6);
/*  977 */       if (p_74875_3_.func_78890_b(i, j, k)) {
/*  978 */         p_74875_1_.field_72999_e = true;
/*  979 */         Blocks.field_150356_k.func_149674_a(p_74875_1_, i, j, k, p_74875_2_);
/*  980 */         p_74875_1_.field_72999_e = false;
/*      */       } 
/*      */       
/*  983 */       return true;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static class NetherStalkRoom
/*      */     extends Piece
/*      */   {
/*      */     private static final String __OBFID = "CL_00000464";
/*      */ 
/*      */     
/*      */     public NetherStalkRoom() {}
/*      */ 
/*      */     
/*      */     public NetherStalkRoom(int p_i2052_1_, Random p_i2052_2_, StructureBoundingBox p_i2052_3_, int p_i2052_4_) {
/*  999 */       super(p_i2052_1_);
/*      */       
/* 1001 */       this.field_74885_f = p_i2052_4_;
/* 1002 */       this.field_74887_e = p_i2052_3_;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_) {
/* 1009 */       func_74963_a((StructureNetherBridgePieces.Start)p_74861_1_, p_74861_2_, p_74861_3_, 5, 3, true);
/* 1010 */       func_74963_a((StructureNetherBridgePieces.Start)p_74861_1_, p_74861_2_, p_74861_3_, 5, 11, true);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public static NetherStalkRoom func_74977_a(List p_74977_0_, Random p_74977_1_, int p_74977_2_, int p_74977_3_, int p_74977_4_, int p_74977_5_, int p_74977_6_) {
/* 1016 */       StructureBoundingBox structureBoundingBox = StructureBoundingBox.func_78889_a(p_74977_2_, p_74977_3_, p_74977_4_, -5, -3, 0, 13, 14, 13, p_74977_5_);
/*      */       
/* 1018 */       if (!func_74964_a(structureBoundingBox) || StructureComponent.func_74883_a(p_74977_0_, structureBoundingBox) != null) {
/* 1019 */         return null;
/*      */       }
/*      */       
/* 1022 */       return new NetherStalkRoom(p_74977_6_, p_74977_1_, structureBoundingBox, p_74977_5_);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
/* 1029 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 3, 0, 12, 4, 12, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*      */       
/* 1031 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 5, 0, 12, 13, 12, Blocks.field_150350_a, Blocks.field_150350_a, false);
/*      */ 
/*      */       
/* 1034 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 5, 0, 1, 12, 12, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/* 1035 */       func_151549_a(p_74875_1_, p_74875_3_, 11, 5, 0, 12, 12, 12, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/* 1036 */       func_151549_a(p_74875_1_, p_74875_3_, 2, 5, 11, 4, 12, 12, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/* 1037 */       func_151549_a(p_74875_1_, p_74875_3_, 8, 5, 11, 10, 12, 12, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/* 1038 */       func_151549_a(p_74875_1_, p_74875_3_, 5, 9, 11, 7, 12, 12, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/* 1039 */       func_151549_a(p_74875_1_, p_74875_3_, 2, 5, 0, 4, 12, 1, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/* 1040 */       func_151549_a(p_74875_1_, p_74875_3_, 8, 5, 0, 10, 12, 1, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/* 1041 */       func_151549_a(p_74875_1_, p_74875_3_, 5, 9, 0, 7, 12, 1, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*      */ 
/*      */       
/* 1044 */       func_151549_a(p_74875_1_, p_74875_3_, 2, 11, 2, 10, 12, 10, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*      */       
/*      */       int i;
/* 1047 */       for (i = 1; i <= 11; i += 2) {
/* 1048 */         func_151549_a(p_74875_1_, p_74875_3_, i, 10, 0, i, 11, 0, Blocks.field_150386_bk, Blocks.field_150386_bk, false);
/* 1049 */         func_151549_a(p_74875_1_, p_74875_3_, i, 10, 12, i, 11, 12, Blocks.field_150386_bk, Blocks.field_150386_bk, false);
/* 1050 */         func_151549_a(p_74875_1_, p_74875_3_, 0, 10, i, 0, 11, i, Blocks.field_150386_bk, Blocks.field_150386_bk, false);
/* 1051 */         func_151549_a(p_74875_1_, p_74875_3_, 12, 10, i, 12, 11, i, Blocks.field_150386_bk, Blocks.field_150386_bk, false);
/* 1052 */         func_151550_a(p_74875_1_, Blocks.field_150385_bj, 0, i, 13, 0, p_74875_3_);
/* 1053 */         func_151550_a(p_74875_1_, Blocks.field_150385_bj, 0, i, 13, 12, p_74875_3_);
/* 1054 */         func_151550_a(p_74875_1_, Blocks.field_150385_bj, 0, 0, 13, i, p_74875_3_);
/* 1055 */         func_151550_a(p_74875_1_, Blocks.field_150385_bj, 0, 12, 13, i, p_74875_3_);
/* 1056 */         func_151550_a(p_74875_1_, Blocks.field_150386_bk, 0, i + 1, 13, 0, p_74875_3_);
/* 1057 */         func_151550_a(p_74875_1_, Blocks.field_150386_bk, 0, i + 1, 13, 12, p_74875_3_);
/* 1058 */         func_151550_a(p_74875_1_, Blocks.field_150386_bk, 0, 0, 13, i + 1, p_74875_3_);
/* 1059 */         func_151550_a(p_74875_1_, Blocks.field_150386_bk, 0, 12, 13, i + 1, p_74875_3_);
/*      */       } 
/* 1061 */       func_151550_a(p_74875_1_, Blocks.field_150386_bk, 0, 0, 13, 0, p_74875_3_);
/* 1062 */       func_151550_a(p_74875_1_, Blocks.field_150386_bk, 0, 0, 13, 12, p_74875_3_);
/* 1063 */       func_151550_a(p_74875_1_, Blocks.field_150386_bk, 0, 0, 13, 0, p_74875_3_);
/* 1064 */       func_151550_a(p_74875_1_, Blocks.field_150386_bk, 0, 12, 13, 0, p_74875_3_);
/*      */ 
/*      */       
/* 1067 */       for (i = 3; i <= 9; i += 2) {
/* 1068 */         func_151549_a(p_74875_1_, p_74875_3_, 1, 7, i, 1, 8, i, Blocks.field_150386_bk, Blocks.field_150386_bk, false);
/* 1069 */         func_151549_a(p_74875_1_, p_74875_3_, 11, 7, i, 11, 8, i, Blocks.field_150386_bk, Blocks.field_150386_bk, false);
/*      */       } 
/*      */ 
/*      */       
/* 1073 */       i = func_151555_a(Blocks.field_150387_bl, 3); int j;
/* 1074 */       for (j = 0; j <= 6; j++) {
/* 1075 */         int m = j + 4;
/* 1076 */         for (byte b1 = 5; b1 <= 7; b1++) {
/* 1077 */           func_151550_a(p_74875_1_, Blocks.field_150387_bl, i, b1, 5 + j, m, p_74875_3_);
/*      */         }
/* 1079 */         if (m >= 5 && m <= 8) {
/* 1080 */           func_151549_a(p_74875_1_, p_74875_3_, 5, 5, m, 7, j + 4, m, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/* 1081 */         } else if (m >= 9 && m <= 10) {
/* 1082 */           func_151549_a(p_74875_1_, p_74875_3_, 5, 8, m, 7, j + 4, m, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*      */         } 
/* 1084 */         if (j >= 1) {
/* 1085 */           func_151549_a(p_74875_1_, p_74875_3_, 5, 6 + j, m, 7, 9 + j, m, Blocks.field_150350_a, Blocks.field_150350_a, false);
/*      */         }
/*      */       } 
/* 1088 */       for (j = 5; j <= 7; j++) {
/* 1089 */         func_151550_a(p_74875_1_, Blocks.field_150387_bl, i, j, 12, 11, p_74875_3_);
/*      */       }
/* 1091 */       func_151549_a(p_74875_1_, p_74875_3_, 5, 6, 7, 5, 7, 7, Blocks.field_150386_bk, Blocks.field_150386_bk, false);
/* 1092 */       func_151549_a(p_74875_1_, p_74875_3_, 7, 6, 7, 7, 7, 7, Blocks.field_150386_bk, Blocks.field_150386_bk, false);
/* 1093 */       func_151549_a(p_74875_1_, p_74875_3_, 5, 13, 12, 7, 13, 12, Blocks.field_150350_a, Blocks.field_150350_a, false);
/*      */ 
/*      */       
/* 1096 */       func_151549_a(p_74875_1_, p_74875_3_, 2, 5, 2, 3, 5, 3, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/* 1097 */       func_151549_a(p_74875_1_, p_74875_3_, 2, 5, 9, 3, 5, 10, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/* 1098 */       func_151549_a(p_74875_1_, p_74875_3_, 2, 5, 4, 2, 5, 8, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/* 1099 */       func_151549_a(p_74875_1_, p_74875_3_, 9, 5, 2, 10, 5, 3, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/* 1100 */       func_151549_a(p_74875_1_, p_74875_3_, 9, 5, 9, 10, 5, 10, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/* 1101 */       func_151549_a(p_74875_1_, p_74875_3_, 10, 5, 4, 10, 5, 8, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/* 1102 */       j = func_151555_a(Blocks.field_150387_bl, 0);
/* 1103 */       int k = func_151555_a(Blocks.field_150387_bl, 1);
/* 1104 */       func_151550_a(p_74875_1_, Blocks.field_150387_bl, k, 4, 5, 2, p_74875_3_);
/* 1105 */       func_151550_a(p_74875_1_, Blocks.field_150387_bl, k, 4, 5, 3, p_74875_3_);
/* 1106 */       func_151550_a(p_74875_1_, Blocks.field_150387_bl, k, 4, 5, 9, p_74875_3_);
/* 1107 */       func_151550_a(p_74875_1_, Blocks.field_150387_bl, k, 4, 5, 10, p_74875_3_);
/* 1108 */       func_151550_a(p_74875_1_, Blocks.field_150387_bl, j, 8, 5, 2, p_74875_3_);
/* 1109 */       func_151550_a(p_74875_1_, Blocks.field_150387_bl, j, 8, 5, 3, p_74875_3_);
/* 1110 */       func_151550_a(p_74875_1_, Blocks.field_150387_bl, j, 8, 5, 9, p_74875_3_);
/* 1111 */       func_151550_a(p_74875_1_, Blocks.field_150387_bl, j, 8, 5, 10, p_74875_3_);
/*      */ 
/*      */       
/* 1114 */       func_151549_a(p_74875_1_, p_74875_3_, 3, 4, 4, 4, 4, 8, Blocks.field_150425_aM, Blocks.field_150425_aM, false);
/* 1115 */       func_151549_a(p_74875_1_, p_74875_3_, 8, 4, 4, 9, 4, 8, Blocks.field_150425_aM, Blocks.field_150425_aM, false);
/* 1116 */       func_151549_a(p_74875_1_, p_74875_3_, 3, 5, 4, 4, 5, 8, Blocks.field_150388_bm, Blocks.field_150388_bm, false);
/* 1117 */       func_151549_a(p_74875_1_, p_74875_3_, 8, 5, 4, 9, 5, 8, Blocks.field_150388_bm, Blocks.field_150388_bm, false);
/*      */ 
/*      */       
/* 1120 */       func_151549_a(p_74875_1_, p_74875_3_, 4, 2, 0, 8, 2, 12, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/* 1121 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 2, 4, 12, 2, 8, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*      */       
/* 1123 */       func_151549_a(p_74875_1_, p_74875_3_, 4, 0, 0, 8, 1, 3, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/* 1124 */       func_151549_a(p_74875_1_, p_74875_3_, 4, 0, 9, 8, 1, 12, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/* 1125 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 0, 4, 3, 1, 8, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/* 1126 */       func_151549_a(p_74875_1_, p_74875_3_, 9, 0, 4, 12, 1, 8, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*      */       byte b;
/* 1128 */       for (b = 4; b <= 8; b++) {
/* 1129 */         for (byte b1 = 0; b1 <= 2; b1++) {
/* 1130 */           func_151554_b(p_74875_1_, Blocks.field_150385_bj, 0, b, -1, b1, p_74875_3_);
/* 1131 */           func_151554_b(p_74875_1_, Blocks.field_150385_bj, 0, b, -1, 12 - b1, p_74875_3_);
/*      */         } 
/*      */       } 
/* 1134 */       for (b = 0; b <= 2; b++) {
/* 1135 */         for (byte b1 = 4; b1 <= 8; b1++) {
/* 1136 */           func_151554_b(p_74875_1_, Blocks.field_150385_bj, 0, b, -1, b1, p_74875_3_);
/* 1137 */           func_151554_b(p_74875_1_, Blocks.field_150385_bj, 0, 12 - b, -1, b1, p_74875_3_);
/*      */         } 
/*      */       } 
/*      */       
/* 1141 */       return true;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static class Corridor5
/*      */     extends Piece
/*      */   {
/*      */     private static final String __OBFID = "CL_00000462";
/*      */ 
/*      */     
/*      */     public Corridor5() {}
/*      */ 
/*      */     
/*      */     public Corridor5(int p_i2050_1_, Random p_i2050_2_, StructureBoundingBox p_i2050_3_, int p_i2050_4_) {
/* 1157 */       super(p_i2050_1_);
/*      */       
/* 1159 */       this.field_74885_f = p_i2050_4_;
/* 1160 */       this.field_74887_e = p_i2050_3_;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_) {
/* 1167 */       func_74963_a((StructureNetherBridgePieces.Start)p_74861_1_, p_74861_2_, p_74861_3_, 1, 0, true);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public static Corridor5 func_74981_a(List p_74981_0_, Random p_74981_1_, int p_74981_2_, int p_74981_3_, int p_74981_4_, int p_74981_5_, int p_74981_6_) {
/* 1173 */       StructureBoundingBox structureBoundingBox = StructureBoundingBox.func_78889_a(p_74981_2_, p_74981_3_, p_74981_4_, -1, 0, 0, 5, 7, 5, p_74981_5_);
/*      */       
/* 1175 */       if (!func_74964_a(structureBoundingBox) || StructureComponent.func_74883_a(p_74981_0_, structureBoundingBox) != null) {
/* 1176 */         return null;
/*      */       }
/*      */       
/* 1179 */       return new Corridor5(p_74981_6_, p_74981_1_, structureBoundingBox, p_74981_5_);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
/* 1186 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 0, 0, 4, 1, 4, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*      */       
/* 1188 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 2, 0, 4, 5, 4, Blocks.field_150350_a, Blocks.field_150350_a, false);
/*      */ 
/*      */       
/* 1191 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 2, 0, 0, 5, 4, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/* 1192 */       func_151549_a(p_74875_1_, p_74875_3_, 4, 2, 0, 4, 5, 4, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/* 1193 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 3, 1, 0, 4, 1, Blocks.field_150386_bk, Blocks.field_150386_bk, false);
/* 1194 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 3, 3, 0, 4, 3, Blocks.field_150386_bk, Blocks.field_150386_bk, false);
/* 1195 */       func_151549_a(p_74875_1_, p_74875_3_, 4, 3, 1, 4, 4, 1, Blocks.field_150386_bk, Blocks.field_150386_bk, false);
/* 1196 */       func_151549_a(p_74875_1_, p_74875_3_, 4, 3, 3, 4, 4, 3, Blocks.field_150386_bk, Blocks.field_150386_bk, false);
/*      */ 
/*      */       
/* 1199 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 6, 0, 4, 6, 4, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*      */ 
/*      */       
/* 1202 */       for (byte b = 0; b <= 4; b++) {
/* 1203 */         for (byte b1 = 0; b1 <= 4; b1++) {
/* 1204 */           func_151554_b(p_74875_1_, Blocks.field_150385_bj, 0, b, -1, b1, p_74875_3_);
/*      */         }
/*      */       } 
/*      */       
/* 1208 */       return true;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static class Crossing2
/*      */     extends Piece
/*      */   {
/*      */     private static final String __OBFID = "CL_00000460";
/*      */ 
/*      */     
/*      */     public Crossing2() {}
/*      */ 
/*      */     
/*      */     public Crossing2(int p_i2048_1_, Random p_i2048_2_, StructureBoundingBox p_i2048_3_, int p_i2048_4_) {
/* 1224 */       super(p_i2048_1_);
/*      */       
/* 1226 */       this.field_74885_f = p_i2048_4_;
/* 1227 */       this.field_74887_e = p_i2048_3_;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_) {
/* 1234 */       func_74963_a((StructureNetherBridgePieces.Start)p_74861_1_, p_74861_2_, p_74861_3_, 1, 0, true);
/* 1235 */       func_74961_b((StructureNetherBridgePieces.Start)p_74861_1_, p_74861_2_, p_74861_3_, 0, 1, true);
/* 1236 */       func_74965_c((StructureNetherBridgePieces.Start)p_74861_1_, p_74861_2_, p_74861_3_, 0, 1, true);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public static Crossing2 func_74979_a(List p_74979_0_, Random p_74979_1_, int p_74979_2_, int p_74979_3_, int p_74979_4_, int p_74979_5_, int p_74979_6_) {
/* 1242 */       StructureBoundingBox structureBoundingBox = StructureBoundingBox.func_78889_a(p_74979_2_, p_74979_3_, p_74979_4_, -1, 0, 0, 5, 7, 5, p_74979_5_);
/*      */       
/* 1244 */       if (!func_74964_a(structureBoundingBox) || StructureComponent.func_74883_a(p_74979_0_, structureBoundingBox) != null) {
/* 1245 */         return null;
/*      */       }
/*      */       
/* 1248 */       return new Crossing2(p_74979_6_, p_74979_1_, structureBoundingBox, p_74979_5_);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
/* 1255 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 0, 0, 4, 1, 4, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*      */       
/* 1257 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 2, 0, 4, 5, 4, Blocks.field_150350_a, Blocks.field_150350_a, false);
/*      */ 
/*      */       
/* 1260 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 2, 0, 0, 5, 0, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/* 1261 */       func_151549_a(p_74875_1_, p_74875_3_, 4, 2, 0, 4, 5, 0, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/* 1262 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 2, 4, 0, 5, 4, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/* 1263 */       func_151549_a(p_74875_1_, p_74875_3_, 4, 2, 4, 4, 5, 4, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*      */ 
/*      */       
/* 1266 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 6, 0, 4, 6, 4, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*      */ 
/*      */       
/* 1269 */       for (byte b = 0; b <= 4; b++) {
/* 1270 */         for (byte b1 = 0; b1 <= 4; b1++) {
/* 1271 */           func_151554_b(p_74875_1_, Blocks.field_150385_bj, 0, b, -1, b1, p_74875_3_);
/*      */         }
/*      */       } 
/*      */       
/* 1275 */       return true;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static class Corridor2
/*      */     extends Piece
/*      */   {
/*      */     private boolean field_111020_b;
/*      */     
/*      */     private static final String __OBFID = "CL_00000463";
/*      */ 
/*      */     
/*      */     public Corridor2() {}
/*      */ 
/*      */     
/*      */     public Corridor2(int p_i2051_1_, Random p_i2051_2_, StructureBoundingBox p_i2051_3_, int p_i2051_4_) {
/* 1293 */       super(p_i2051_1_);
/*      */       
/* 1295 */       this.field_74885_f = p_i2051_4_;
/* 1296 */       this.field_74887_e = p_i2051_3_;
/*      */       
/* 1298 */       this.field_111020_b = (p_i2051_2_.nextInt(3) == 0);
/*      */     }
/*      */ 
/*      */     
/*      */     protected void func_143011_b(NBTTagCompound p_143011_1_) {
/* 1303 */       super.func_143011_b(p_143011_1_);
/*      */       
/* 1305 */       this.field_111020_b = p_143011_1_.func_74767_n("Chest");
/*      */     }
/*      */ 
/*      */     
/*      */     protected void func_143012_a(NBTTagCompound p_143012_1_) {
/* 1310 */       super.func_143012_a(p_143012_1_);
/*      */       
/* 1312 */       p_143012_1_.func_74757_a("Chest", this.field_111020_b);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_) {
/* 1318 */       func_74965_c((StructureNetherBridgePieces.Start)p_74861_1_, p_74861_2_, p_74861_3_, 0, 1, true);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public static Corridor2 func_74980_a(List p_74980_0_, Random p_74980_1_, int p_74980_2_, int p_74980_3_, int p_74980_4_, int p_74980_5_, int p_74980_6_) {
/* 1324 */       StructureBoundingBox structureBoundingBox = StructureBoundingBox.func_78889_a(p_74980_2_, p_74980_3_, p_74980_4_, -1, 0, 0, 5, 7, 5, p_74980_5_);
/*      */       
/* 1326 */       if (!func_74964_a(structureBoundingBox) || StructureComponent.func_74883_a(p_74980_0_, structureBoundingBox) != null) {
/* 1327 */         return null;
/*      */       }
/*      */       
/* 1330 */       return new Corridor2(p_74980_6_, p_74980_1_, structureBoundingBox, p_74980_5_);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
/* 1337 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 0, 0, 4, 1, 4, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*      */       
/* 1339 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 2, 0, 4, 5, 4, Blocks.field_150350_a, Blocks.field_150350_a, false);
/*      */ 
/*      */       
/* 1342 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 2, 0, 0, 5, 4, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/* 1343 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 3, 1, 0, 4, 1, Blocks.field_150386_bk, Blocks.field_150386_bk, false);
/* 1344 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 3, 3, 0, 4, 3, Blocks.field_150386_bk, Blocks.field_150386_bk, false);
/*      */       
/* 1346 */       func_151549_a(p_74875_1_, p_74875_3_, 4, 2, 0, 4, 5, 0, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*      */       
/* 1348 */       func_151549_a(p_74875_1_, p_74875_3_, 1, 2, 4, 4, 5, 4, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/* 1349 */       func_151549_a(p_74875_1_, p_74875_3_, 1, 3, 4, 1, 4, 4, Blocks.field_150386_bk, Blocks.field_150385_bj, false);
/* 1350 */       func_151549_a(p_74875_1_, p_74875_3_, 3, 3, 4, 3, 4, 4, Blocks.field_150386_bk, Blocks.field_150385_bj, false);
/*      */       
/* 1352 */       if (this.field_111020_b) {
/* 1353 */         int i = func_74862_a(2);
/* 1354 */         int j = func_74865_a(1, 3), k = func_74873_b(1, 3);
/* 1355 */         if (p_74875_3_.func_78890_b(j, i, k)) {
/* 1356 */           this.field_111020_b = false;
/* 1357 */           func_74879_a(p_74875_1_, p_74875_3_, p_74875_2_, 1, 2, 3, field_111019_a, 2 + p_74875_2_.nextInt(4));
/*      */         } 
/*      */       } 
/*      */ 
/*      */       
/* 1362 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 6, 0, 4, 6, 4, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*      */ 
/*      */       
/* 1365 */       for (byte b = 0; b <= 4; b++) {
/* 1366 */         for (byte b1 = 0; b1 <= 4; b1++) {
/* 1367 */           func_151554_b(p_74875_1_, Blocks.field_150385_bj, 0, b, -1, b1, p_74875_3_);
/*      */         }
/*      */       } 
/*      */       
/* 1371 */       return true;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static class Corridor
/*      */     extends Piece
/*      */   {
/*      */     private boolean field_111021_b;
/*      */     
/*      */     private static final String __OBFID = "CL_00000461";
/*      */ 
/*      */     
/*      */     public Corridor() {}
/*      */ 
/*      */     
/*      */     public Corridor(int p_i2049_1_, Random p_i2049_2_, StructureBoundingBox p_i2049_3_, int p_i2049_4_) {
/* 1389 */       super(p_i2049_1_);
/*      */       
/* 1391 */       this.field_74885_f = p_i2049_4_;
/* 1392 */       this.field_74887_e = p_i2049_3_;
/*      */       
/* 1394 */       this.field_111021_b = (p_i2049_2_.nextInt(3) == 0);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     protected void func_143011_b(NBTTagCompound p_143011_1_) {
/* 1400 */       super.func_143011_b(p_143011_1_);
/*      */       
/* 1402 */       this.field_111021_b = p_143011_1_.func_74767_n("Chest");
/*      */     }
/*      */ 
/*      */     
/*      */     protected void func_143012_a(NBTTagCompound p_143012_1_) {
/* 1407 */       super.func_143012_a(p_143012_1_);
/*      */       
/* 1409 */       p_143012_1_.func_74757_a("Chest", this.field_111021_b);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_) {
/* 1415 */       func_74961_b((StructureNetherBridgePieces.Start)p_74861_1_, p_74861_2_, p_74861_3_, 0, 1, true);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public static Corridor func_74978_a(List p_74978_0_, Random p_74978_1_, int p_74978_2_, int p_74978_3_, int p_74978_4_, int p_74978_5_, int p_74978_6_) {
/* 1421 */       StructureBoundingBox structureBoundingBox = StructureBoundingBox.func_78889_a(p_74978_2_, p_74978_3_, p_74978_4_, -1, 0, 0, 5, 7, 5, p_74978_5_);
/*      */       
/* 1423 */       if (!func_74964_a(structureBoundingBox) || StructureComponent.func_74883_a(p_74978_0_, structureBoundingBox) != null) {
/* 1424 */         return null;
/*      */       }
/*      */       
/* 1427 */       return new Corridor(p_74978_6_, p_74978_1_, structureBoundingBox, p_74978_5_);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
/* 1434 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 0, 0, 4, 1, 4, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*      */       
/* 1436 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 2, 0, 4, 5, 4, Blocks.field_150350_a, Blocks.field_150350_a, false);
/*      */ 
/*      */       
/* 1439 */       func_151549_a(p_74875_1_, p_74875_3_, 4, 2, 0, 4, 5, 4, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/* 1440 */       func_151549_a(p_74875_1_, p_74875_3_, 4, 3, 1, 4, 4, 1, Blocks.field_150386_bk, Blocks.field_150386_bk, false);
/* 1441 */       func_151549_a(p_74875_1_, p_74875_3_, 4, 3, 3, 4, 4, 3, Blocks.field_150386_bk, Blocks.field_150386_bk, false);
/*      */       
/* 1443 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 2, 0, 0, 5, 0, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*      */       
/* 1445 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 2, 4, 3, 5, 4, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/* 1446 */       func_151549_a(p_74875_1_, p_74875_3_, 1, 3, 4, 1, 4, 4, Blocks.field_150386_bk, Blocks.field_150385_bj, false);
/* 1447 */       func_151549_a(p_74875_1_, p_74875_3_, 3, 3, 4, 3, 4, 4, Blocks.field_150386_bk, Blocks.field_150385_bj, false);
/*      */       
/* 1449 */       if (this.field_111021_b) {
/* 1450 */         int i = func_74862_a(2);
/* 1451 */         int j = func_74865_a(3, 3), k = func_74873_b(3, 3);
/* 1452 */         if (p_74875_3_.func_78890_b(j, i, k)) {
/* 1453 */           this.field_111021_b = false;
/* 1454 */           func_74879_a(p_74875_1_, p_74875_3_, p_74875_2_, 3, 2, 3, field_111019_a, 2 + p_74875_2_.nextInt(4));
/*      */         } 
/*      */       } 
/*      */ 
/*      */       
/* 1459 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 6, 0, 4, 6, 4, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*      */ 
/*      */       
/* 1462 */       for (byte b = 0; b <= 4; b++) {
/* 1463 */         for (byte b1 = 0; b1 <= 4; b1++) {
/* 1464 */           func_151554_b(p_74875_1_, Blocks.field_150385_bj, 0, b, -1, b1, p_74875_3_);
/*      */         }
/*      */       } 
/*      */       
/* 1468 */       return true;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static class Corridor3
/*      */     extends Piece
/*      */   {
/*      */     private static final String __OBFID = "CL_00000457";
/*      */ 
/*      */     
/*      */     public Corridor3() {}
/*      */ 
/*      */     
/*      */     public Corridor3(int p_i2045_1_, Random p_i2045_2_, StructureBoundingBox p_i2045_3_, int p_i2045_4_) {
/* 1484 */       super(p_i2045_1_);
/*      */       
/* 1486 */       this.field_74885_f = p_i2045_4_;
/* 1487 */       this.field_74887_e = p_i2045_3_;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_) {
/* 1494 */       func_74963_a((StructureNetherBridgePieces.Start)p_74861_1_, p_74861_2_, p_74861_3_, 1, 0, true);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public static Corridor3 func_74982_a(List p_74982_0_, Random p_74982_1_, int p_74982_2_, int p_74982_3_, int p_74982_4_, int p_74982_5_, int p_74982_6_) {
/* 1500 */       StructureBoundingBox structureBoundingBox = StructureBoundingBox.func_78889_a(p_74982_2_, p_74982_3_, p_74982_4_, -1, -7, 0, 5, 14, 10, p_74982_5_);
/*      */       
/* 1502 */       if (!func_74964_a(structureBoundingBox) || StructureComponent.func_74883_a(p_74982_0_, structureBoundingBox) != null) {
/* 1503 */         return null;
/*      */       }
/*      */       
/* 1506 */       return new Corridor3(p_74982_6_, p_74982_1_, structureBoundingBox, p_74982_5_);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
/* 1513 */       int i = func_151555_a(Blocks.field_150387_bl, 2);
/* 1514 */       for (byte b = 0; b <= 9; b++) {
/* 1515 */         int j = Math.max(1, 7 - b);
/* 1516 */         int k = Math.min(Math.max(j + 5, 14 - b), 13);
/* 1517 */         byte b1 = b;
/*      */ 
/*      */         
/* 1520 */         func_151549_a(p_74875_1_, p_74875_3_, 0, 0, b1, 4, j, b1, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*      */         
/* 1522 */         func_151549_a(p_74875_1_, p_74875_3_, 1, j + 1, b1, 3, k - 1, b1, Blocks.field_150350_a, Blocks.field_150350_a, false);
/* 1523 */         if (b <= 6) {
/* 1524 */           func_151550_a(p_74875_1_, Blocks.field_150387_bl, i, 1, j + 1, b1, p_74875_3_);
/* 1525 */           func_151550_a(p_74875_1_, Blocks.field_150387_bl, i, 2, j + 1, b1, p_74875_3_);
/* 1526 */           func_151550_a(p_74875_1_, Blocks.field_150387_bl, i, 3, j + 1, b1, p_74875_3_);
/*      */         } 
/*      */         
/* 1529 */         func_151549_a(p_74875_1_, p_74875_3_, 0, k, b1, 4, k, b1, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*      */         
/* 1531 */         func_151549_a(p_74875_1_, p_74875_3_, 0, j + 1, b1, 0, k - 1, b1, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/* 1532 */         func_151549_a(p_74875_1_, p_74875_3_, 4, j + 1, b1, 4, k - 1, b1, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/* 1533 */         if ((b & 0x1) == 0) {
/* 1534 */           func_151549_a(p_74875_1_, p_74875_3_, 0, j + 2, b1, 0, j + 3, b1, Blocks.field_150386_bk, Blocks.field_150386_bk, false);
/* 1535 */           func_151549_a(p_74875_1_, p_74875_3_, 4, j + 2, b1, 4, j + 3, b1, Blocks.field_150386_bk, Blocks.field_150386_bk, false);
/*      */         } 
/*      */ 
/*      */         
/* 1539 */         for (byte b2 = 0; b2 <= 4; b2++) {
/* 1540 */           func_151554_b(p_74875_1_, Blocks.field_150385_bj, 0, b2, -1, b1, p_74875_3_);
/*      */         }
/*      */       } 
/*      */       
/* 1544 */       return true;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static class Corridor4
/*      */     extends Piece
/*      */   {
/*      */     private static final String __OBFID = "CL_00000458";
/*      */ 
/*      */     
/*      */     public Corridor4() {}
/*      */ 
/*      */     
/*      */     public Corridor4(int p_i2046_1_, Random p_i2046_2_, StructureBoundingBox p_i2046_3_, int p_i2046_4_) {
/* 1560 */       super(p_i2046_1_);
/*      */       
/* 1562 */       this.field_74885_f = p_i2046_4_;
/* 1563 */       this.field_74887_e = p_i2046_3_;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_) {
/* 1570 */       byte b = 1;
/*      */       
/* 1572 */       if (this.field_74885_f == 1 || this.field_74885_f == 2) {
/* 1573 */         b = 5;
/*      */       }
/*      */       
/* 1576 */       func_74961_b((StructureNetherBridgePieces.Start)p_74861_1_, p_74861_2_, p_74861_3_, 0, b, (p_74861_3_.nextInt(8) > 0));
/* 1577 */       func_74965_c((StructureNetherBridgePieces.Start)p_74861_1_, p_74861_2_, p_74861_3_, 0, b, (p_74861_3_.nextInt(8) > 0));
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public static Corridor4 func_74985_a(List p_74985_0_, Random p_74985_1_, int p_74985_2_, int p_74985_3_, int p_74985_4_, int p_74985_5_, int p_74985_6_) {
/* 1583 */       StructureBoundingBox structureBoundingBox = StructureBoundingBox.func_78889_a(p_74985_2_, p_74985_3_, p_74985_4_, -3, 0, 0, 9, 7, 9, p_74985_5_);
/*      */       
/* 1585 */       if (!func_74964_a(structureBoundingBox) || StructureComponent.func_74883_a(p_74985_0_, structureBoundingBox) != null) {
/* 1586 */         return null;
/*      */       }
/*      */       
/* 1589 */       return new Corridor4(p_74985_6_, p_74985_1_, structureBoundingBox, p_74985_5_);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
/* 1596 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 0, 0, 8, 1, 8, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*      */       
/* 1598 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 2, 0, 8, 5, 8, Blocks.field_150350_a, Blocks.field_150350_a, false);
/*      */       
/* 1600 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 6, 0, 8, 6, 5, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/*      */ 
/*      */       
/* 1603 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 2, 0, 2, 5, 0, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/* 1604 */       func_151549_a(p_74875_1_, p_74875_3_, 6, 2, 0, 8, 5, 0, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/* 1605 */       func_151549_a(p_74875_1_, p_74875_3_, 1, 3, 0, 1, 4, 0, Blocks.field_150386_bk, Blocks.field_150386_bk, false);
/* 1606 */       func_151549_a(p_74875_1_, p_74875_3_, 7, 3, 0, 7, 4, 0, Blocks.field_150386_bk, Blocks.field_150386_bk, false);
/*      */ 
/*      */       
/* 1609 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 2, 4, 8, 2, 8, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/* 1610 */       func_151549_a(p_74875_1_, p_74875_3_, 1, 1, 4, 2, 2, 4, Blocks.field_150350_a, Blocks.field_150350_a, false);
/* 1611 */       func_151549_a(p_74875_1_, p_74875_3_, 6, 1, 4, 7, 2, 4, Blocks.field_150350_a, Blocks.field_150350_a, false);
/*      */ 
/*      */       
/* 1614 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 3, 8, 8, 3, 8, Blocks.field_150386_bk, Blocks.field_150386_bk, false);
/* 1615 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 3, 6, 0, 3, 7, Blocks.field_150386_bk, Blocks.field_150386_bk, false);
/* 1616 */       func_151549_a(p_74875_1_, p_74875_3_, 8, 3, 6, 8, 3, 7, Blocks.field_150386_bk, Blocks.field_150386_bk, false);
/*      */ 
/*      */       
/* 1619 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 3, 4, 0, 5, 5, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/* 1620 */       func_151549_a(p_74875_1_, p_74875_3_, 8, 3, 4, 8, 5, 5, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/* 1621 */       func_151549_a(p_74875_1_, p_74875_3_, 1, 3, 5, 2, 5, 5, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/* 1622 */       func_151549_a(p_74875_1_, p_74875_3_, 6, 3, 5, 7, 5, 5, Blocks.field_150385_bj, Blocks.field_150385_bj, false);
/* 1623 */       func_151549_a(p_74875_1_, p_74875_3_, 1, 4, 5, 1, 5, 5, Blocks.field_150386_bk, Blocks.field_150386_bk, false);
/* 1624 */       func_151549_a(p_74875_1_, p_74875_3_, 7, 4, 5, 7, 5, 5, Blocks.field_150386_bk, Blocks.field_150386_bk, false);
/*      */ 
/*      */       
/* 1627 */       for (byte b = 0; b <= 5; b++) {
/* 1628 */         for (byte b1 = 0; b1 <= 8; b1++) {
/* 1629 */           func_151554_b(p_74875_1_, Blocks.field_150385_bj, 0, b1, -1, b, p_74875_3_);
/*      */         }
/*      */       } 
/*      */       
/* 1633 */       return true;
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\structure\StructureNetherBridgePieces.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */