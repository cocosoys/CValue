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
/*      */ import net.minecraft.world.ChunkPosition;
/*      */ import net.minecraft.world.World;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class StructureStrongholdPieces
/*      */ {
/*      */   public static void func_143046_a() {
/*   26 */     MapGenStructureIO.func_143031_a(ChestCorridor.class, "SHCC");
/*   27 */     MapGenStructureIO.func_143031_a(Corridor.class, "SHFC");
/*   28 */     MapGenStructureIO.func_143031_a(Crossing.class, "SH5C");
/*   29 */     MapGenStructureIO.func_143031_a(LeftTurn.class, "SHLT");
/*   30 */     MapGenStructureIO.func_143031_a(Library.class, "SHLi");
/*   31 */     MapGenStructureIO.func_143031_a(PortalRoom.class, "SHPR");
/*   32 */     MapGenStructureIO.func_143031_a(Prison.class, "SHPH");
/*   33 */     MapGenStructureIO.func_143031_a(RightTurn.class, "SHRT");
/*   34 */     MapGenStructureIO.func_143031_a(RoomCrossing.class, "SHRC");
/*   35 */     MapGenStructureIO.func_143031_a(Stairs.class, "SHSD");
/*   36 */     MapGenStructureIO.func_143031_a(Stairs2.class, "SHStart");
/*   37 */     MapGenStructureIO.func_143031_a(Straight.class, "SHS");
/*   38 */     MapGenStructureIO.func_143031_a(StairsStraight.class, "SHSSD");
/*      */   }
/*      */   
/*      */   static class PieceWeight { public Class field_75194_a;
/*      */     public final int field_75192_b;
/*      */     public int field_75193_c;
/*      */     public int field_75191_d;
/*      */     private static final String __OBFID = "CL_00000492";
/*      */     
/*      */     public PieceWeight(Class p_i2076_1_, int p_i2076_2_, int p_i2076_3_) {
/*   48 */       this.field_75194_a = p_i2076_1_;
/*   49 */       this.field_75192_b = p_i2076_2_;
/*   50 */       this.field_75191_d = p_i2076_3_;
/*      */     }
/*      */     
/*      */     public boolean func_75189_a(int p_75189_1_) {
/*   54 */       return (this.field_75191_d == 0 || this.field_75193_c < this.field_75191_d);
/*      */     }
/*      */     
/*      */     public boolean func_75190_a() {
/*   58 */       return (this.field_75191_d == 0 || this.field_75193_c < this.field_75191_d);
/*      */     } }
/*      */ 
/*      */ 
/*      */   
/*   63 */   private static final PieceWeight[] field_75205_b = new PieceWeight[] { new PieceWeight(Straight.class, 40, 0), new PieceWeight(Prison.class, 5, 5), new PieceWeight(LeftTurn.class, 20, 0), new PieceWeight(RightTurn.class, 20, 0), new PieceWeight(RoomCrossing.class, 10, 6), new PieceWeight(StairsStraight.class, 5, 5), new PieceWeight(Stairs.class, 5, 5), new PieceWeight(Crossing.class, 5, 4), new PieceWeight(ChestCorridor.class, 5, 4), new PieceWeight(Library.class, 10, 2)
/*      */       {
/*      */         private static final String __OBFID = "CL_00000484";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public boolean func_75189_a(int p_75189_1_) {
/*   76 */           return (super.func_75189_a(p_75189_1_) && p_75189_1_ > 4);
/*      */         }
/*      */       }, 
/*      */       new PieceWeight(PortalRoom.class, 20, 1) { private static final String __OBFID = "CL_00000485";
/*      */         
/*      */         public boolean func_75189_a(int p_75189_1_) {
/*   82 */           return (super.func_75189_a(p_75189_1_) && p_75189_1_ > 5);
/*      */         } }
/*      */        };
/*      */   
/*      */   private static List field_75206_c;
/*      */   
/*      */   private static Class field_75203_d;
/*      */   static int field_75207_a;
/*      */   
/*      */   public static void func_75198_a() {
/*   92 */     field_75206_c = new ArrayList();
/*   93 */     for (PieceWeight pieceWeight : field_75205_b) {
/*   94 */       pieceWeight.field_75193_c = 0;
/*   95 */       field_75206_c.add(pieceWeight);
/*      */     } 
/*   97 */     field_75203_d = null;
/*      */   }
/*      */   
/*      */   private static boolean func_75202_c() {
/*  101 */     boolean bool = false;
/*  102 */     field_75207_a = 0;
/*  103 */     for (PieceWeight pieceWeight : field_75206_c) {
/*  104 */       if (pieceWeight.field_75191_d > 0 && pieceWeight.field_75193_c < pieceWeight.field_75191_d) {
/*  105 */         bool = true;
/*      */       }
/*  107 */       field_75207_a += pieceWeight.field_75192_b;
/*      */     } 
/*  109 */     return bool;
/*      */   }
/*      */ 
/*      */   
/*      */   private static Stronghold func_75200_a(Class<Straight> p_75200_0_, List p_75200_1_, Random p_75200_2_, int p_75200_3_, int p_75200_4_, int p_75200_5_, int p_75200_6_, int p_75200_7_) {
/*      */     PortalRoom portalRoom;
/*  115 */     Straight straight = null;
/*      */     
/*  117 */     if (p_75200_0_ == Straight.class) {
/*  118 */       straight = Straight.func_75018_a(p_75200_1_, p_75200_2_, p_75200_3_, p_75200_4_, p_75200_5_, p_75200_6_, p_75200_7_);
/*  119 */     } else if (p_75200_0_ == Prison.class) {
/*  120 */       Prison prison = Prison.func_75016_a(p_75200_1_, p_75200_2_, p_75200_3_, p_75200_4_, p_75200_5_, p_75200_6_, p_75200_7_);
/*  121 */     } else if (p_75200_0_ == LeftTurn.class) {
/*  122 */       LeftTurn leftTurn = LeftTurn.func_75010_a(p_75200_1_, p_75200_2_, p_75200_3_, p_75200_4_, p_75200_5_, p_75200_6_, p_75200_7_);
/*  123 */     } else if (p_75200_0_ == RightTurn.class) {
/*  124 */       LeftTurn leftTurn = RightTurn.func_75010_a(p_75200_1_, p_75200_2_, p_75200_3_, p_75200_4_, p_75200_5_, p_75200_6_, p_75200_7_);
/*  125 */     } else if (p_75200_0_ == RoomCrossing.class) {
/*  126 */       RoomCrossing roomCrossing = RoomCrossing.func_75012_a(p_75200_1_, p_75200_2_, p_75200_3_, p_75200_4_, p_75200_5_, p_75200_6_, p_75200_7_);
/*  127 */     } else if (p_75200_0_ == StairsStraight.class) {
/*  128 */       StairsStraight stairsStraight = StairsStraight.func_75028_a(p_75200_1_, p_75200_2_, p_75200_3_, p_75200_4_, p_75200_5_, p_75200_6_, p_75200_7_);
/*  129 */     } else if (p_75200_0_ == Stairs.class) {
/*  130 */       Stairs stairs = Stairs.func_75022_a(p_75200_1_, p_75200_2_, p_75200_3_, p_75200_4_, p_75200_5_, p_75200_6_, p_75200_7_);
/*  131 */     } else if (p_75200_0_ == Crossing.class) {
/*  132 */       Crossing crossing = Crossing.func_74994_a(p_75200_1_, p_75200_2_, p_75200_3_, p_75200_4_, p_75200_5_, p_75200_6_, p_75200_7_);
/*  133 */     } else if (p_75200_0_ == ChestCorridor.class) {
/*  134 */       ChestCorridor chestCorridor = ChestCorridor.func_75000_a(p_75200_1_, p_75200_2_, p_75200_3_, p_75200_4_, p_75200_5_, p_75200_6_, p_75200_7_);
/*  135 */     } else if (p_75200_0_ == Library.class) {
/*  136 */       Library library = Library.func_75006_a(p_75200_1_, p_75200_2_, p_75200_3_, p_75200_4_, p_75200_5_, p_75200_6_, p_75200_7_);
/*  137 */     } else if (p_75200_0_ == PortalRoom.class) {
/*  138 */       portalRoom = PortalRoom.func_75004_a(p_75200_1_, p_75200_2_, p_75200_3_, p_75200_4_, p_75200_5_, p_75200_6_, p_75200_7_);
/*      */     } 
/*      */     
/*  141 */     return portalRoom;
/*      */   }
/*      */ 
/*      */   
/*      */   private static Stronghold func_75201_b(Stairs2 p_75201_0_, List p_75201_1_, Random p_75201_2_, int p_75201_3_, int p_75201_4_, int p_75201_5_, int p_75201_6_, int p_75201_7_) {
/*  146 */     if (!func_75202_c()) {
/*  147 */       return null;
/*      */     }
/*      */     
/*  150 */     if (field_75203_d != null) {
/*      */       
/*  152 */       Stronghold stronghold = func_75200_a(field_75203_d, p_75201_1_, p_75201_2_, p_75201_3_, p_75201_4_, p_75201_5_, p_75201_6_, p_75201_7_);
/*  153 */       field_75203_d = null;
/*      */       
/*  155 */       if (stronghold != null) {
/*  156 */         return stronghold;
/*      */       }
/*      */     } 
/*      */     
/*  160 */     byte b = 0;
/*  161 */     while (b < 5) {
/*  162 */       b++;
/*      */       
/*  164 */       int i = p_75201_2_.nextInt(field_75207_a);
/*  165 */       for (PieceWeight pieceWeight : field_75206_c) {
/*  166 */         i -= pieceWeight.field_75192_b;
/*  167 */         if (i < 0) {
/*      */           
/*  169 */           if (!pieceWeight.func_75189_a(p_75201_7_) || pieceWeight == p_75201_0_.field_75027_a) {
/*      */             break;
/*      */           }
/*      */           
/*  173 */           Stronghold stronghold = func_75200_a(pieceWeight.field_75194_a, p_75201_1_, p_75201_2_, p_75201_3_, p_75201_4_, p_75201_5_, p_75201_6_, p_75201_7_);
/*  174 */           if (stronghold != null) {
/*  175 */             pieceWeight.field_75193_c++;
/*  176 */             p_75201_0_.field_75027_a = pieceWeight;
/*      */             
/*  178 */             if (!pieceWeight.func_75190_a()) {
/*  179 */               field_75206_c.remove(pieceWeight);
/*      */             }
/*  181 */             return stronghold;
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/*  187 */     StructureBoundingBox structureBoundingBox = Corridor.func_74992_a(p_75201_1_, p_75201_2_, p_75201_3_, p_75201_4_, p_75201_5_, p_75201_6_);
/*  188 */     if (structureBoundingBox != null && structureBoundingBox.field_78895_b > 1) {
/*  189 */       return new Corridor(p_75201_7_, p_75201_2_, structureBoundingBox, p_75201_6_);
/*      */     }
/*      */     
/*  192 */     return null;
/*      */   }
/*      */   
/*      */   private static StructureComponent func_75196_c(Stairs2 p_75196_0_, List<Stronghold> p_75196_1_, Random p_75196_2_, int p_75196_3_, int p_75196_4_, int p_75196_5_, int p_75196_6_, int p_75196_7_) {
/*  196 */     if (p_75196_7_ > 50) {
/*  197 */       return null;
/*      */     }
/*  199 */     if (Math.abs(p_75196_3_ - (p_75196_0_.func_74874_b()).field_78897_a) > 112 || Math.abs(p_75196_5_ - (p_75196_0_.func_74874_b()).field_78896_c) > 112) {
/*  200 */       return null;
/*      */     }
/*      */     
/*  203 */     Stronghold stronghold = func_75201_b(p_75196_0_, p_75196_1_, p_75196_2_, p_75196_3_, p_75196_4_, p_75196_5_, p_75196_6_, p_75196_7_ + 1);
/*  204 */     if (stronghold != null) {
/*  205 */       p_75196_1_.add(stronghold);
/*  206 */       p_75196_0_.field_75026_c.add(stronghold);
/*      */     } 
/*  208 */     return stronghold;
/*      */   }
/*      */   
/*      */   public static abstract class Stronghold
/*      */     extends StructureComponent {
/*  213 */     protected Door field_143013_d = Door.OPENING;
/*      */     
/*      */     private static final String __OBFID = "CL_00000503";
/*      */     
/*      */     public Stronghold() {}
/*      */     
/*      */     protected Stronghold(int p_i2087_1_) {
/*  220 */       super(p_i2087_1_);
/*      */     }
/*      */     
/*      */     public enum Door {
/*  224 */       OPENING, WOOD_DOOR, GRATES, IRON_DOOR;
/*      */       private static final String __OBFID = "CL_00000504";
/*      */     }
/*      */     
/*      */     protected void func_143012_a(NBTTagCompound p_143012_1_) {
/*  229 */       p_143012_1_.func_74778_a("EntryDoor", this.field_143013_d.name());
/*      */     }
/*      */ 
/*      */     
/*      */     protected void func_143011_b(NBTTagCompound p_143011_1_) {
/*  234 */       this.field_143013_d = Door.valueOf(p_143011_1_.func_74779_i("EntryDoor"));
/*      */     }
/*      */ 
/*      */     
/*      */     protected void func_74990_a(World p_74990_1_, Random p_74990_2_, StructureBoundingBox p_74990_3_, Door p_74990_4_, int p_74990_5_, int p_74990_6_, int p_74990_7_) {
/*  239 */       switch (StructureStrongholdPieces.SwitchDoor.field_75245_a[p_74990_4_.ordinal()]) {
/*      */         
/*      */         default:
/*  242 */           func_151549_a(p_74990_1_, p_74990_3_, p_74990_5_, p_74990_6_, p_74990_7_, p_74990_5_ + 3 - 1, p_74990_6_ + 3 - 1, p_74990_7_, Blocks.field_150350_a, Blocks.field_150350_a, false);
/*      */           return;
/*      */         case 2:
/*  245 */           func_151550_a(p_74990_1_, Blocks.field_150417_aV, 0, p_74990_5_, p_74990_6_, p_74990_7_, p_74990_3_);
/*  246 */           func_151550_a(p_74990_1_, Blocks.field_150417_aV, 0, p_74990_5_, p_74990_6_ + 1, p_74990_7_, p_74990_3_);
/*  247 */           func_151550_a(p_74990_1_, Blocks.field_150417_aV, 0, p_74990_5_, p_74990_6_ + 2, p_74990_7_, p_74990_3_);
/*  248 */           func_151550_a(p_74990_1_, Blocks.field_150417_aV, 0, p_74990_5_ + 1, p_74990_6_ + 2, p_74990_7_, p_74990_3_);
/*  249 */           func_151550_a(p_74990_1_, Blocks.field_150417_aV, 0, p_74990_5_ + 2, p_74990_6_ + 2, p_74990_7_, p_74990_3_);
/*  250 */           func_151550_a(p_74990_1_, Blocks.field_150417_aV, 0, p_74990_5_ + 2, p_74990_6_ + 1, p_74990_7_, p_74990_3_);
/*  251 */           func_151550_a(p_74990_1_, Blocks.field_150417_aV, 0, p_74990_5_ + 2, p_74990_6_, p_74990_7_, p_74990_3_);
/*  252 */           func_151550_a(p_74990_1_, Blocks.field_150466_ao, 0, p_74990_5_ + 1, p_74990_6_, p_74990_7_, p_74990_3_);
/*  253 */           func_151550_a(p_74990_1_, Blocks.field_150466_ao, 8, p_74990_5_ + 1, p_74990_6_ + 1, p_74990_7_, p_74990_3_);
/*      */           return;
/*      */         case 3:
/*  256 */           func_151550_a(p_74990_1_, Blocks.field_150350_a, 0, p_74990_5_ + 1, p_74990_6_, p_74990_7_, p_74990_3_);
/*  257 */           func_151550_a(p_74990_1_, Blocks.field_150350_a, 0, p_74990_5_ + 1, p_74990_6_ + 1, p_74990_7_, p_74990_3_);
/*  258 */           func_151550_a(p_74990_1_, Blocks.field_150411_aY, 0, p_74990_5_, p_74990_6_, p_74990_7_, p_74990_3_);
/*  259 */           func_151550_a(p_74990_1_, Blocks.field_150411_aY, 0, p_74990_5_, p_74990_6_ + 1, p_74990_7_, p_74990_3_);
/*  260 */           func_151550_a(p_74990_1_, Blocks.field_150411_aY, 0, p_74990_5_, p_74990_6_ + 2, p_74990_7_, p_74990_3_);
/*  261 */           func_151550_a(p_74990_1_, Blocks.field_150411_aY, 0, p_74990_5_ + 1, p_74990_6_ + 2, p_74990_7_, p_74990_3_);
/*  262 */           func_151550_a(p_74990_1_, Blocks.field_150411_aY, 0, p_74990_5_ + 2, p_74990_6_ + 2, p_74990_7_, p_74990_3_);
/*  263 */           func_151550_a(p_74990_1_, Blocks.field_150411_aY, 0, p_74990_5_ + 2, p_74990_6_ + 1, p_74990_7_, p_74990_3_);
/*  264 */           func_151550_a(p_74990_1_, Blocks.field_150411_aY, 0, p_74990_5_ + 2, p_74990_6_, p_74990_7_, p_74990_3_); return;
/*      */         case 4:
/*      */           break;
/*  267 */       }  func_151550_a(p_74990_1_, Blocks.field_150417_aV, 0, p_74990_5_, p_74990_6_, p_74990_7_, p_74990_3_);
/*  268 */       func_151550_a(p_74990_1_, Blocks.field_150417_aV, 0, p_74990_5_, p_74990_6_ + 1, p_74990_7_, p_74990_3_);
/*  269 */       func_151550_a(p_74990_1_, Blocks.field_150417_aV, 0, p_74990_5_, p_74990_6_ + 2, p_74990_7_, p_74990_3_);
/*  270 */       func_151550_a(p_74990_1_, Blocks.field_150417_aV, 0, p_74990_5_ + 1, p_74990_6_ + 2, p_74990_7_, p_74990_3_);
/*  271 */       func_151550_a(p_74990_1_, Blocks.field_150417_aV, 0, p_74990_5_ + 2, p_74990_6_ + 2, p_74990_7_, p_74990_3_);
/*  272 */       func_151550_a(p_74990_1_, Blocks.field_150417_aV, 0, p_74990_5_ + 2, p_74990_6_ + 1, p_74990_7_, p_74990_3_);
/*  273 */       func_151550_a(p_74990_1_, Blocks.field_150417_aV, 0, p_74990_5_ + 2, p_74990_6_, p_74990_7_, p_74990_3_);
/*  274 */       func_151550_a(p_74990_1_, Blocks.field_150454_av, 0, p_74990_5_ + 1, p_74990_6_, p_74990_7_, p_74990_3_);
/*  275 */       func_151550_a(p_74990_1_, Blocks.field_150454_av, 8, p_74990_5_ + 1, p_74990_6_ + 1, p_74990_7_, p_74990_3_);
/*  276 */       func_151550_a(p_74990_1_, Blocks.field_150430_aB, func_151555_a(Blocks.field_150430_aB, 4), p_74990_5_ + 2, p_74990_6_ + 1, p_74990_7_ + 1, p_74990_3_);
/*  277 */       func_151550_a(p_74990_1_, Blocks.field_150430_aB, func_151555_a(Blocks.field_150430_aB, 3), p_74990_5_ + 2, p_74990_6_ + 1, p_74990_7_ - 1, p_74990_3_);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     protected Door func_74988_a(Random p_74988_1_) {
/*  283 */       int i = p_74988_1_.nextInt(5);
/*  284 */       switch (i)
/*      */       
/*      */       { 
/*      */         default:
/*  288 */           return Door.OPENING;
/*      */         case 2:
/*  290 */           return Door.WOOD_DOOR;
/*      */         case 3:
/*  292 */           return Door.GRATES;
/*      */         case 4:
/*  294 */           break; }  return Door.IRON_DOOR;
/*      */     }
/*      */ 
/*      */     
/*      */     protected StructureComponent func_74986_a(StructureStrongholdPieces.Stairs2 p_74986_1_, List p_74986_2_, Random p_74986_3_, int p_74986_4_, int p_74986_5_) {
/*  299 */       switch (this.field_74885_f) {
/*      */         case 2:
/*  301 */           return StructureStrongholdPieces.func_75196_c(p_74986_1_, p_74986_2_, p_74986_3_, this.field_74887_e.field_78897_a + p_74986_4_, this.field_74887_e.field_78895_b + p_74986_5_, this.field_74887_e.field_78896_c - 1, this.field_74885_f, func_74877_c());
/*      */         case 0:
/*  303 */           return StructureStrongholdPieces.func_75196_c(p_74986_1_, p_74986_2_, p_74986_3_, this.field_74887_e.field_78897_a + p_74986_4_, this.field_74887_e.field_78895_b + p_74986_5_, this.field_74887_e.field_78892_f + 1, this.field_74885_f, func_74877_c());
/*      */         case 1:
/*  305 */           return StructureStrongholdPieces.func_75196_c(p_74986_1_, p_74986_2_, p_74986_3_, this.field_74887_e.field_78897_a - 1, this.field_74887_e.field_78895_b + p_74986_5_, this.field_74887_e.field_78896_c + p_74986_4_, this.field_74885_f, func_74877_c());
/*      */         case 3:
/*  307 */           return StructureStrongholdPieces.func_75196_c(p_74986_1_, p_74986_2_, p_74986_3_, this.field_74887_e.field_78893_d + 1, this.field_74887_e.field_78895_b + p_74986_5_, this.field_74887_e.field_78896_c + p_74986_4_, this.field_74885_f, func_74877_c());
/*      */       } 
/*  309 */       return null;
/*      */     }
/*      */     
/*      */     protected StructureComponent func_74989_b(StructureStrongholdPieces.Stairs2 p_74989_1_, List p_74989_2_, Random p_74989_3_, int p_74989_4_, int p_74989_5_) {
/*  313 */       switch (this.field_74885_f) {
/*      */         case 2:
/*  315 */           return StructureStrongholdPieces.func_75196_c(p_74989_1_, p_74989_2_, p_74989_3_, this.field_74887_e.field_78897_a - 1, this.field_74887_e.field_78895_b + p_74989_4_, this.field_74887_e.field_78896_c + p_74989_5_, 1, func_74877_c());
/*      */         case 0:
/*  317 */           return StructureStrongholdPieces.func_75196_c(p_74989_1_, p_74989_2_, p_74989_3_, this.field_74887_e.field_78897_a - 1, this.field_74887_e.field_78895_b + p_74989_4_, this.field_74887_e.field_78896_c + p_74989_5_, 1, func_74877_c());
/*      */         case 1:
/*  319 */           return StructureStrongholdPieces.func_75196_c(p_74989_1_, p_74989_2_, p_74989_3_, this.field_74887_e.field_78897_a + p_74989_5_, this.field_74887_e.field_78895_b + p_74989_4_, this.field_74887_e.field_78896_c - 1, 2, func_74877_c());
/*      */         case 3:
/*  321 */           return StructureStrongholdPieces.func_75196_c(p_74989_1_, p_74989_2_, p_74989_3_, this.field_74887_e.field_78897_a + p_74989_5_, this.field_74887_e.field_78895_b + p_74989_4_, this.field_74887_e.field_78896_c - 1, 2, func_74877_c());
/*      */       } 
/*  323 */       return null;
/*      */     }
/*      */     
/*      */     protected StructureComponent func_74987_c(StructureStrongholdPieces.Stairs2 p_74987_1_, List p_74987_2_, Random p_74987_3_, int p_74987_4_, int p_74987_5_) {
/*  327 */       switch (this.field_74885_f) {
/*      */         case 2:
/*  329 */           return StructureStrongholdPieces.func_75196_c(p_74987_1_, p_74987_2_, p_74987_3_, this.field_74887_e.field_78893_d + 1, this.field_74887_e.field_78895_b + p_74987_4_, this.field_74887_e.field_78896_c + p_74987_5_, 3, func_74877_c());
/*      */         case 0:
/*  331 */           return StructureStrongholdPieces.func_75196_c(p_74987_1_, p_74987_2_, p_74987_3_, this.field_74887_e.field_78893_d + 1, this.field_74887_e.field_78895_b + p_74987_4_, this.field_74887_e.field_78896_c + p_74987_5_, 3, func_74877_c());
/*      */         case 1:
/*  333 */           return StructureStrongholdPieces.func_75196_c(p_74987_1_, p_74987_2_, p_74987_3_, this.field_74887_e.field_78897_a + p_74987_5_, this.field_74887_e.field_78895_b + p_74987_4_, this.field_74887_e.field_78892_f + 1, 0, func_74877_c());
/*      */         case 3:
/*  335 */           return StructureStrongholdPieces.func_75196_c(p_74987_1_, p_74987_2_, p_74987_3_, this.field_74887_e.field_78897_a + p_74987_5_, this.field_74887_e.field_78895_b + p_74987_4_, this.field_74887_e.field_78892_f + 1, 0, func_74877_c());
/*      */       } 
/*  337 */       return null;
/*      */     }
/*      */     
/*      */     protected static boolean func_74991_a(StructureBoundingBox p_74991_0_) {
/*  341 */       return (p_74991_0_ != null && p_74991_0_.field_78895_b > 10);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public static class Corridor
/*      */     extends Stronghold
/*      */   {
/*      */     private int field_74993_a;
/*      */     
/*      */     private static final String __OBFID = "CL_00000488";
/*      */ 
/*      */     
/*      */     public Corridor() {}
/*      */ 
/*      */     
/*      */     public Corridor(int p_i2072_1_, Random p_i2072_2_, StructureBoundingBox p_i2072_3_, int p_i2072_4_) {
/*  358 */       super(p_i2072_1_);
/*      */       
/*  360 */       this.field_74885_f = p_i2072_4_;
/*  361 */       this.field_74887_e = p_i2072_3_;
/*  362 */       this.field_74993_a = (p_i2072_4_ == 2 || p_i2072_4_ == 0) ? p_i2072_3_.func_78880_d() : p_i2072_3_.func_78883_b();
/*      */     }
/*      */ 
/*      */     
/*      */     protected void func_143012_a(NBTTagCompound p_143012_1_) {
/*  367 */       super.func_143012_a(p_143012_1_);
/*  368 */       p_143012_1_.func_74768_a("Steps", this.field_74993_a);
/*      */     }
/*      */ 
/*      */     
/*      */     protected void func_143011_b(NBTTagCompound p_143011_1_) {
/*  373 */       super.func_143011_b(p_143011_1_);
/*  374 */       this.field_74993_a = p_143011_1_.func_74762_e("Steps");
/*      */     }
/*      */ 
/*      */     
/*      */     public static StructureBoundingBox func_74992_a(List p_74992_0_, Random p_74992_1_, int p_74992_2_, int p_74992_3_, int p_74992_4_, int p_74992_5_) {
/*  379 */       byte b = 3;
/*      */       
/*  381 */       StructureBoundingBox structureBoundingBox = StructureBoundingBox.func_78889_a(p_74992_2_, p_74992_3_, p_74992_4_, -1, -1, 0, 5, 5, 4, p_74992_5_);
/*      */       
/*  383 */       StructureComponent structureComponent = StructureComponent.func_74883_a(p_74992_0_, structureBoundingBox);
/*  384 */       if (structureComponent == null)
/*      */       {
/*  386 */         return null;
/*      */       }
/*      */       
/*  389 */       if ((structureComponent.func_74874_b()).field_78895_b == structureBoundingBox.field_78895_b)
/*      */       {
/*  391 */         for (byte b1 = 3; b1 >= 1; b1--) {
/*  392 */           structureBoundingBox = StructureBoundingBox.func_78889_a(p_74992_2_, p_74992_3_, p_74992_4_, -1, -1, 0, 5, 5, b1 - 1, p_74992_5_);
/*  393 */           if (!structureComponent.func_74874_b().func_78884_a(structureBoundingBox))
/*      */           {
/*      */             
/*  396 */             return StructureBoundingBox.func_78889_a(p_74992_2_, p_74992_3_, p_74992_4_, -1, -1, 0, 5, 5, b1, p_74992_5_);
/*      */           }
/*      */         } 
/*      */       }
/*      */       
/*  401 */       return null;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
/*  406 */       if (func_74860_a(p_74875_1_, p_74875_3_)) {
/*  407 */         return false;
/*      */       }
/*      */ 
/*      */       
/*  411 */       for (byte b = 0; b < this.field_74993_a; b++) {
/*      */         
/*  413 */         func_151550_a(p_74875_1_, Blocks.field_150417_aV, 0, 0, 0, b, p_74875_3_);
/*  414 */         func_151550_a(p_74875_1_, Blocks.field_150417_aV, 0, 1, 0, b, p_74875_3_);
/*  415 */         func_151550_a(p_74875_1_, Blocks.field_150417_aV, 0, 2, 0, b, p_74875_3_);
/*  416 */         func_151550_a(p_74875_1_, Blocks.field_150417_aV, 0, 3, 0, b, p_74875_3_);
/*  417 */         func_151550_a(p_74875_1_, Blocks.field_150417_aV, 0, 4, 0, b, p_74875_3_);
/*      */         
/*  419 */         for (byte b1 = 1; b1 <= 3; b1++) {
/*  420 */           func_151550_a(p_74875_1_, Blocks.field_150417_aV, 0, 0, b1, b, p_74875_3_);
/*  421 */           func_151550_a(p_74875_1_, Blocks.field_150350_a, 0, 1, b1, b, p_74875_3_);
/*  422 */           func_151550_a(p_74875_1_, Blocks.field_150350_a, 0, 2, b1, b, p_74875_3_);
/*  423 */           func_151550_a(p_74875_1_, Blocks.field_150350_a, 0, 3, b1, b, p_74875_3_);
/*  424 */           func_151550_a(p_74875_1_, Blocks.field_150417_aV, 0, 4, b1, b, p_74875_3_);
/*      */         } 
/*      */         
/*  427 */         func_151550_a(p_74875_1_, Blocks.field_150417_aV, 0, 0, 4, b, p_74875_3_);
/*  428 */         func_151550_a(p_74875_1_, Blocks.field_150417_aV, 0, 1, 4, b, p_74875_3_);
/*  429 */         func_151550_a(p_74875_1_, Blocks.field_150417_aV, 0, 2, 4, b, p_74875_3_);
/*  430 */         func_151550_a(p_74875_1_, Blocks.field_150417_aV, 0, 3, 4, b, p_74875_3_);
/*  431 */         func_151550_a(p_74875_1_, Blocks.field_150417_aV, 0, 4, 4, b, p_74875_3_);
/*      */       } 
/*      */       
/*  434 */       return true;
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public static class Stairs
/*      */     extends Stronghold
/*      */   {
/*      */     private boolean field_75024_a;
/*      */     
/*      */     private static final String __OBFID = "CL_00000498";
/*      */ 
/*      */     
/*      */     public Stairs() {}
/*      */ 
/*      */     
/*      */     public Stairs(int p_i2081_1_, Random p_i2081_2_, int p_i2081_3_, int p_i2081_4_) {
/*  451 */       super(p_i2081_1_);
/*      */       
/*  453 */       this.field_75024_a = true;
/*  454 */       this.field_74885_f = p_i2081_2_.nextInt(4);
/*  455 */       this.field_143013_d = StructureStrongholdPieces.Stronghold.Door.OPENING;
/*      */       
/*  457 */       switch (this.field_74885_f) {
/*      */         case 0:
/*      */         case 2:
/*  460 */           this.field_74887_e = new StructureBoundingBox(p_i2081_3_, 64, p_i2081_4_, p_i2081_3_ + 5 - 1, 74, p_i2081_4_ + 5 - 1);
/*      */           return;
/*      */       } 
/*  463 */       this.field_74887_e = new StructureBoundingBox(p_i2081_3_, 64, p_i2081_4_, p_i2081_3_ + 5 - 1, 74, p_i2081_4_ + 5 - 1);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public Stairs(int p_i2082_1_, Random p_i2082_2_, StructureBoundingBox p_i2082_3_, int p_i2082_4_) {
/*  469 */       super(p_i2082_1_);
/*      */       
/*  471 */       this.field_75024_a = false;
/*  472 */       this.field_74885_f = p_i2082_4_;
/*  473 */       this.field_143013_d = func_74988_a(p_i2082_2_);
/*  474 */       this.field_74887_e = p_i2082_3_;
/*      */     }
/*      */ 
/*      */     
/*      */     protected void func_143012_a(NBTTagCompound p_143012_1_) {
/*  479 */       super.func_143012_a(p_143012_1_);
/*  480 */       p_143012_1_.func_74757_a("Source", this.field_75024_a);
/*      */     }
/*      */ 
/*      */     
/*      */     protected void func_143011_b(NBTTagCompound p_143011_1_) {
/*  485 */       super.func_143011_b(p_143011_1_);
/*  486 */       this.field_75024_a = p_143011_1_.func_74767_n("Source");
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_) {
/*  492 */       if (this.field_75024_a)
/*      */       {
/*  494 */         StructureStrongholdPieces.field_75203_d = StructureStrongholdPieces.Crossing.class;
/*      */       }
/*  496 */       func_74986_a((StructureStrongholdPieces.Stairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 1);
/*      */     }
/*      */ 
/*      */     
/*      */     public static Stairs func_75022_a(List p_75022_0_, Random p_75022_1_, int p_75022_2_, int p_75022_3_, int p_75022_4_, int p_75022_5_, int p_75022_6_) {
/*  501 */       StructureBoundingBox structureBoundingBox = StructureBoundingBox.func_78889_a(p_75022_2_, p_75022_3_, p_75022_4_, -1, -7, 0, 5, 11, 5, p_75022_5_);
/*      */       
/*  503 */       if (!func_74991_a(structureBoundingBox) || StructureComponent.func_74883_a(p_75022_0_, structureBoundingBox) != null) {
/*  504 */         return null;
/*      */       }
/*      */       
/*  507 */       return new Stairs(p_75022_6_, p_75022_1_, structureBoundingBox, p_75022_5_);
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
/*  512 */       if (func_74860_a(p_74875_1_, p_74875_3_)) {
/*  513 */         return false;
/*      */       }
/*      */ 
/*      */       
/*  517 */       func_74882_a(p_74875_1_, p_74875_3_, 0, 0, 0, 4, 10, 4, true, p_74875_2_, StructureStrongholdPieces.field_75204_e);
/*      */       
/*  519 */       func_74990_a(p_74875_1_, p_74875_2_, p_74875_3_, this.field_143013_d, 1, 7, 0);
/*      */       
/*  521 */       func_74990_a(p_74875_1_, p_74875_2_, p_74875_3_, StructureStrongholdPieces.Stronghold.Door.OPENING, 1, 1, 4);
/*      */ 
/*      */       
/*  524 */       func_151550_a(p_74875_1_, Blocks.field_150417_aV, 0, 2, 6, 1, p_74875_3_);
/*  525 */       func_151550_a(p_74875_1_, Blocks.field_150417_aV, 0, 1, 5, 1, p_74875_3_);
/*  526 */       func_151550_a(p_74875_1_, (Block)Blocks.field_150333_U, 0, 1, 6, 1, p_74875_3_);
/*  527 */       func_151550_a(p_74875_1_, Blocks.field_150417_aV, 0, 1, 5, 2, p_74875_3_);
/*  528 */       func_151550_a(p_74875_1_, Blocks.field_150417_aV, 0, 1, 4, 3, p_74875_3_);
/*  529 */       func_151550_a(p_74875_1_, (Block)Blocks.field_150333_U, 0, 1, 5, 3, p_74875_3_);
/*  530 */       func_151550_a(p_74875_1_, Blocks.field_150417_aV, 0, 2, 4, 3, p_74875_3_);
/*  531 */       func_151550_a(p_74875_1_, Blocks.field_150417_aV, 0, 3, 3, 3, p_74875_3_);
/*  532 */       func_151550_a(p_74875_1_, (Block)Blocks.field_150333_U, 0, 3, 4, 3, p_74875_3_);
/*  533 */       func_151550_a(p_74875_1_, Blocks.field_150417_aV, 0, 3, 3, 2, p_74875_3_);
/*  534 */       func_151550_a(p_74875_1_, Blocks.field_150417_aV, 0, 3, 2, 1, p_74875_3_);
/*  535 */       func_151550_a(p_74875_1_, (Block)Blocks.field_150333_U, 0, 3, 3, 1, p_74875_3_);
/*  536 */       func_151550_a(p_74875_1_, Blocks.field_150417_aV, 0, 2, 2, 1, p_74875_3_);
/*  537 */       func_151550_a(p_74875_1_, Blocks.field_150417_aV, 0, 1, 1, 1, p_74875_3_);
/*  538 */       func_151550_a(p_74875_1_, (Block)Blocks.field_150333_U, 0, 1, 2, 1, p_74875_3_);
/*  539 */       func_151550_a(p_74875_1_, Blocks.field_150417_aV, 0, 1, 1, 2, p_74875_3_);
/*  540 */       func_151550_a(p_74875_1_, (Block)Blocks.field_150333_U, 0, 1, 1, 3, p_74875_3_);
/*      */       
/*  542 */       return true;
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public static class Stairs2
/*      */     extends Stairs
/*      */   {
/*      */     public StructureStrongholdPieces.PieceWeight field_75027_a;
/*      */     
/*      */     public StructureStrongholdPieces.PortalRoom field_75025_b;
/*  553 */     public List field_75026_c = new ArrayList();
/*      */     
/*      */     private static final String __OBFID = "CL_00000499";
/*      */     
/*      */     public Stairs2() {}
/*      */     
/*      */     public Stairs2(int p_i2083_1_, Random p_i2083_2_, int p_i2083_3_, int p_i2083_4_) {
/*  560 */       super(0, p_i2083_2_, p_i2083_3_, p_i2083_4_);
/*      */     }
/*      */ 
/*      */     
/*      */     public ChunkPosition func_151553_a() {
/*  565 */       if (this.field_75025_b != null) {
/*  566 */         return this.field_75025_b.func_151553_a();
/*      */       }
/*  568 */       return super.func_151553_a();
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public static class Straight
/*      */     extends Stronghold
/*      */   {
/*      */     private boolean field_75019_b;
/*      */     
/*      */     private boolean field_75020_c;
/*      */     
/*      */     private static final String __OBFID = "CL_00000500";
/*      */ 
/*      */     
/*      */     public Straight() {}
/*      */ 
/*      */     
/*      */     public Straight(int p_i2084_1_, Random p_i2084_2_, StructureBoundingBox p_i2084_3_, int p_i2084_4_) {
/*  587 */       super(p_i2084_1_);
/*      */       
/*  589 */       this.field_74885_f = p_i2084_4_;
/*  590 */       this.field_143013_d = func_74988_a(p_i2084_2_);
/*  591 */       this.field_74887_e = p_i2084_3_;
/*      */       
/*  593 */       this.field_75019_b = (p_i2084_2_.nextInt(2) == 0);
/*  594 */       this.field_75020_c = (p_i2084_2_.nextInt(2) == 0);
/*      */     }
/*      */ 
/*      */     
/*      */     protected void func_143012_a(NBTTagCompound p_143012_1_) {
/*  599 */       super.func_143012_a(p_143012_1_);
/*  600 */       p_143012_1_.func_74757_a("Left", this.field_75019_b);
/*  601 */       p_143012_1_.func_74757_a("Right", this.field_75020_c);
/*      */     }
/*      */ 
/*      */     
/*      */     protected void func_143011_b(NBTTagCompound p_143011_1_) {
/*  606 */       super.func_143011_b(p_143011_1_);
/*  607 */       this.field_75019_b = p_143011_1_.func_74767_n("Left");
/*  608 */       this.field_75020_c = p_143011_1_.func_74767_n("Right");
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_) {
/*  614 */       func_74986_a((StructureStrongholdPieces.Stairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 1);
/*  615 */       if (this.field_75019_b) func_74989_b((StructureStrongholdPieces.Stairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 2); 
/*  616 */       if (this.field_75020_c) func_74987_c((StructureStrongholdPieces.Stairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 2);
/*      */     
/*      */     }
/*      */ 
/*      */     
/*      */     public static Straight func_75018_a(List p_75018_0_, Random p_75018_1_, int p_75018_2_, int p_75018_3_, int p_75018_4_, int p_75018_5_, int p_75018_6_) {
/*  622 */       StructureBoundingBox structureBoundingBox = StructureBoundingBox.func_78889_a(p_75018_2_, p_75018_3_, p_75018_4_, -1, -1, 0, 5, 5, 7, p_75018_5_);
/*      */       
/*  624 */       if (!func_74991_a(structureBoundingBox) || StructureComponent.func_74883_a(p_75018_0_, structureBoundingBox) != null) {
/*  625 */         return null;
/*      */       }
/*      */       
/*  628 */       return new Straight(p_75018_6_, p_75018_1_, structureBoundingBox, p_75018_5_);
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
/*  633 */       if (func_74860_a(p_74875_1_, p_74875_3_)) {
/*  634 */         return false;
/*      */       }
/*      */ 
/*      */       
/*  638 */       func_74882_a(p_74875_1_, p_74875_3_, 0, 0, 0, 4, 4, 6, true, p_74875_2_, StructureStrongholdPieces.field_75204_e);
/*      */       
/*  640 */       func_74990_a(p_74875_1_, p_74875_2_, p_74875_3_, this.field_143013_d, 1, 1, 0);
/*      */       
/*  642 */       func_74990_a(p_74875_1_, p_74875_2_, p_74875_3_, StructureStrongholdPieces.Stronghold.Door.OPENING, 1, 1, 6);
/*      */       
/*  644 */       func_151552_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.1F, 1, 2, 1, Blocks.field_150478_aa, 0);
/*  645 */       func_151552_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.1F, 3, 2, 1, Blocks.field_150478_aa, 0);
/*  646 */       func_151552_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.1F, 1, 2, 5, Blocks.field_150478_aa, 0);
/*  647 */       func_151552_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.1F, 3, 2, 5, Blocks.field_150478_aa, 0);
/*      */       
/*  649 */       if (this.field_75019_b) {
/*  650 */         func_151549_a(p_74875_1_, p_74875_3_, 0, 1, 2, 0, 3, 4, Blocks.field_150350_a, Blocks.field_150350_a, false);
/*      */       }
/*  652 */       if (this.field_75020_c) {
/*  653 */         func_151549_a(p_74875_1_, p_74875_3_, 4, 1, 2, 4, 3, 4, Blocks.field_150350_a, Blocks.field_150350_a, false);
/*      */       }
/*      */       
/*  656 */       return true;
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public static class ChestCorridor
/*      */     extends Stronghold
/*      */   {
/*  664 */     public static final WeightedRandomChestContent[] field_75003_a = new WeightedRandomChestContent[] { new WeightedRandomChestContent(Items.field_151079_bi, 0, 1, 1, 10), new WeightedRandomChestContent(Items.field_151045_i, 0, 1, 3, 3), new WeightedRandomChestContent(Items.field_151042_j, 0, 1, 5, 10), new WeightedRandomChestContent(Items.field_151043_k, 0, 1, 3, 5), new WeightedRandomChestContent(Items.field_151137_ax, 0, 4, 9, 5), new WeightedRandomChestContent(Items.field_151025_P, 0, 1, 3, 15), new WeightedRandomChestContent(Items.field_151034_e, 0, 1, 3, 15), new WeightedRandomChestContent(Items.field_151035_b, 0, 1, 1, 5), new WeightedRandomChestContent(Items.field_151040_l, 0, 1, 1, 5), new WeightedRandomChestContent((Item)Items.field_151030_Z, 0, 1, 1, 5), new WeightedRandomChestContent((Item)Items.field_151028_Y, 0, 1, 1, 5), new WeightedRandomChestContent((Item)Items.field_151165_aa, 0, 1, 1, 5), new WeightedRandomChestContent((Item)Items.field_151167_ab, 0, 1, 1, 5), new WeightedRandomChestContent(Items.field_151153_ao, 0, 1, 1, 1), new WeightedRandomChestContent(Items.field_151141_av, 0, 1, 1, 1), new WeightedRandomChestContent(Items.field_151138_bX, 0, 1, 1, 1), new WeightedRandomChestContent(Items.field_151136_bY, 0, 1, 1, 1), new WeightedRandomChestContent(Items.field_151125_bZ, 0, 1, 1, 1) };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private boolean field_75002_c;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private static final String __OBFID = "CL_00000487";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ChestCorridor() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ChestCorridor(int p_i2071_1_, Random p_i2071_2_, StructureBoundingBox p_i2071_3_, int p_i2071_4_) {
/*  699 */       super(p_i2071_1_);
/*      */       
/*  701 */       this.field_74885_f = p_i2071_4_;
/*  702 */       this.field_143013_d = func_74988_a(p_i2071_2_);
/*  703 */       this.field_74887_e = p_i2071_3_;
/*      */     }
/*      */ 
/*      */     
/*      */     protected void func_143012_a(NBTTagCompound p_143012_1_) {
/*  708 */       super.func_143012_a(p_143012_1_);
/*  709 */       p_143012_1_.func_74757_a("Chest", this.field_75002_c);
/*      */     }
/*      */ 
/*      */     
/*      */     protected void func_143011_b(NBTTagCompound p_143011_1_) {
/*  714 */       super.func_143011_b(p_143011_1_);
/*  715 */       this.field_75002_c = p_143011_1_.func_74767_n("Chest");
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_) {
/*  721 */       func_74986_a((StructureStrongholdPieces.Stairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 1);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public static ChestCorridor func_75000_a(List p_75000_0_, Random p_75000_1_, int p_75000_2_, int p_75000_3_, int p_75000_4_, int p_75000_5_, int p_75000_6_) {
/*  727 */       StructureBoundingBox structureBoundingBox = StructureBoundingBox.func_78889_a(p_75000_2_, p_75000_3_, p_75000_4_, -1, -1, 0, 5, 5, 7, p_75000_5_);
/*      */       
/*  729 */       if (!func_74991_a(structureBoundingBox) || StructureComponent.func_74883_a(p_75000_0_, structureBoundingBox) != null) {
/*  730 */         return null;
/*      */       }
/*      */       
/*  733 */       return new ChestCorridor(p_75000_6_, p_75000_1_, structureBoundingBox, p_75000_5_);
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
/*  738 */       if (func_74860_a(p_74875_1_, p_74875_3_)) {
/*  739 */         return false;
/*      */       }
/*      */ 
/*      */       
/*  743 */       func_74882_a(p_74875_1_, p_74875_3_, 0, 0, 0, 4, 4, 6, true, p_74875_2_, StructureStrongholdPieces.field_75204_e);
/*      */       
/*  745 */       func_74990_a(p_74875_1_, p_74875_2_, p_74875_3_, this.field_143013_d, 1, 1, 0);
/*      */       
/*  747 */       func_74990_a(p_74875_1_, p_74875_2_, p_74875_3_, StructureStrongholdPieces.Stronghold.Door.OPENING, 1, 1, 6);
/*      */ 
/*      */       
/*  750 */       func_151549_a(p_74875_1_, p_74875_3_, 3, 1, 2, 3, 1, 4, Blocks.field_150417_aV, Blocks.field_150417_aV, false);
/*  751 */       func_151550_a(p_74875_1_, (Block)Blocks.field_150333_U, 5, 3, 1, 1, p_74875_3_);
/*  752 */       func_151550_a(p_74875_1_, (Block)Blocks.field_150333_U, 5, 3, 1, 5, p_74875_3_);
/*  753 */       func_151550_a(p_74875_1_, (Block)Blocks.field_150333_U, 5, 3, 2, 2, p_74875_3_);
/*  754 */       func_151550_a(p_74875_1_, (Block)Blocks.field_150333_U, 5, 3, 2, 4, p_74875_3_); int i;
/*  755 */       for (i = 2; i <= 4; i++) {
/*  756 */         func_151550_a(p_74875_1_, (Block)Blocks.field_150333_U, 5, 2, 1, i, p_74875_3_);
/*      */       }
/*      */       
/*  759 */       if (!this.field_75002_c) {
/*  760 */         i = func_74862_a(2);
/*  761 */         int j = func_74865_a(3, 3), k = func_74873_b(3, 3);
/*  762 */         if (p_74875_3_.func_78890_b(j, i, k)) {
/*  763 */           this.field_75002_c = true;
/*  764 */           func_74879_a(p_74875_1_, p_74875_3_, p_74875_2_, 3, 2, 3, WeightedRandomChestContent.func_92080_a(field_75003_a, new WeightedRandomChestContent[] { Items.field_151134_bR.func_92114_b(p_74875_2_) }), 2 + p_74875_2_.nextInt(2));
/*      */         } 
/*      */       } 
/*      */       
/*  768 */       return true;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static class StairsStraight
/*      */     extends Stronghold
/*      */   {
/*      */     private static final String __OBFID = "CL_00000501";
/*      */ 
/*      */     
/*      */     public StairsStraight() {}
/*      */ 
/*      */     
/*      */     public StairsStraight(int p_i2085_1_, Random p_i2085_2_, StructureBoundingBox p_i2085_3_, int p_i2085_4_) {
/*  784 */       super(p_i2085_1_);
/*      */       
/*  786 */       this.field_74885_f = p_i2085_4_;
/*  787 */       this.field_143013_d = func_74988_a(p_i2085_2_);
/*  788 */       this.field_74887_e = p_i2085_3_;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_) {
/*  795 */       func_74986_a((StructureStrongholdPieces.Stairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 1);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public static StairsStraight func_75028_a(List p_75028_0_, Random p_75028_1_, int p_75028_2_, int p_75028_3_, int p_75028_4_, int p_75028_5_, int p_75028_6_) {
/*  801 */       StructureBoundingBox structureBoundingBox = StructureBoundingBox.func_78889_a(p_75028_2_, p_75028_3_, p_75028_4_, -1, -7, 0, 5, 11, 8, p_75028_5_);
/*      */       
/*  803 */       if (!func_74991_a(structureBoundingBox) || StructureComponent.func_74883_a(p_75028_0_, structureBoundingBox) != null) {
/*  804 */         return null;
/*      */       }
/*      */       
/*  807 */       return new StairsStraight(p_75028_6_, p_75028_1_, structureBoundingBox, p_75028_5_);
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
/*  812 */       if (func_74860_a(p_74875_1_, p_74875_3_)) {
/*  813 */         return false;
/*      */       }
/*      */ 
/*      */       
/*  817 */       func_74882_a(p_74875_1_, p_74875_3_, 0, 0, 0, 4, 10, 7, true, p_74875_2_, StructureStrongholdPieces.field_75204_e);
/*      */       
/*  819 */       func_74990_a(p_74875_1_, p_74875_2_, p_74875_3_, this.field_143013_d, 1, 7, 0);
/*      */       
/*  821 */       func_74990_a(p_74875_1_, p_74875_2_, p_74875_3_, StructureStrongholdPieces.Stronghold.Door.OPENING, 1, 1, 7);
/*      */ 
/*      */       
/*  824 */       int i = func_151555_a(Blocks.field_150446_ar, 2);
/*  825 */       for (byte b = 0; b < 6; b++) {
/*  826 */         func_151550_a(p_74875_1_, Blocks.field_150446_ar, i, 1, 6 - b, 1 + b, p_74875_3_);
/*  827 */         func_151550_a(p_74875_1_, Blocks.field_150446_ar, i, 2, 6 - b, 1 + b, p_74875_3_);
/*  828 */         func_151550_a(p_74875_1_, Blocks.field_150446_ar, i, 3, 6 - b, 1 + b, p_74875_3_);
/*  829 */         if (b < 5) {
/*  830 */           func_151550_a(p_74875_1_, Blocks.field_150417_aV, 0, 1, 5 - b, 1 + b, p_74875_3_);
/*  831 */           func_151550_a(p_74875_1_, Blocks.field_150417_aV, 0, 2, 5 - b, 1 + b, p_74875_3_);
/*  832 */           func_151550_a(p_74875_1_, Blocks.field_150417_aV, 0, 3, 5 - b, 1 + b, p_74875_3_);
/*      */         } 
/*      */       } 
/*      */       
/*  836 */       return true;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static class LeftTurn
/*      */     extends Stronghold
/*      */   {
/*      */     private static final String __OBFID = "CL_00000490";
/*      */ 
/*      */     
/*      */     public LeftTurn() {}
/*      */ 
/*      */     
/*      */     public LeftTurn(int p_i2074_1_, Random p_i2074_2_, StructureBoundingBox p_i2074_3_, int p_i2074_4_) {
/*  852 */       super(p_i2074_1_);
/*      */       
/*  854 */       this.field_74885_f = p_i2074_4_;
/*  855 */       this.field_143013_d = func_74988_a(p_i2074_2_);
/*  856 */       this.field_74887_e = p_i2074_3_;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_) {
/*  862 */       if (this.field_74885_f == 2 || this.field_74885_f == 3) {
/*  863 */         func_74989_b((StructureStrongholdPieces.Stairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 1);
/*      */       } else {
/*  865 */         func_74987_c((StructureStrongholdPieces.Stairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 1);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public static LeftTurn func_75010_a(List p_75010_0_, Random p_75010_1_, int p_75010_2_, int p_75010_3_, int p_75010_4_, int p_75010_5_, int p_75010_6_) {
/*  872 */       StructureBoundingBox structureBoundingBox = StructureBoundingBox.func_78889_a(p_75010_2_, p_75010_3_, p_75010_4_, -1, -1, 0, 5, 5, 5, p_75010_5_);
/*      */       
/*  874 */       if (!func_74991_a(structureBoundingBox) || StructureComponent.func_74883_a(p_75010_0_, structureBoundingBox) != null) {
/*  875 */         return null;
/*      */       }
/*      */       
/*  878 */       return new LeftTurn(p_75010_6_, p_75010_1_, structureBoundingBox, p_75010_5_);
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
/*  883 */       if (func_74860_a(p_74875_1_, p_74875_3_)) {
/*  884 */         return false;
/*      */       }
/*      */ 
/*      */       
/*  888 */       func_74882_a(p_74875_1_, p_74875_3_, 0, 0, 0, 4, 4, 4, true, p_74875_2_, StructureStrongholdPieces.field_75204_e);
/*      */       
/*  890 */       func_74990_a(p_74875_1_, p_74875_2_, p_74875_3_, this.field_143013_d, 1, 1, 0);
/*      */       
/*  892 */       if (this.field_74885_f == 2 || this.field_74885_f == 3) {
/*  893 */         func_151549_a(p_74875_1_, p_74875_3_, 0, 1, 1, 0, 3, 3, Blocks.field_150350_a, Blocks.field_150350_a, false);
/*      */       } else {
/*  895 */         func_151549_a(p_74875_1_, p_74875_3_, 4, 1, 1, 4, 3, 3, Blocks.field_150350_a, Blocks.field_150350_a, false);
/*      */       } 
/*      */       
/*  898 */       return true;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class RightTurn
/*      */     extends LeftTurn
/*      */   {
/*      */     private static final String __OBFID = "CL_00000495";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_) {
/*  916 */       if (this.field_74885_f == 2 || this.field_74885_f == 3) {
/*  917 */         func_74987_c((StructureStrongholdPieces.Stairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 1);
/*      */       } else {
/*  919 */         func_74989_b((StructureStrongholdPieces.Stairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 1);
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
/*  925 */       if (func_74860_a(p_74875_1_, p_74875_3_)) {
/*  926 */         return false;
/*      */       }
/*      */ 
/*      */       
/*  930 */       func_74882_a(p_74875_1_, p_74875_3_, 0, 0, 0, 4, 4, 4, true, p_74875_2_, StructureStrongholdPieces.field_75204_e);
/*      */       
/*  932 */       func_74990_a(p_74875_1_, p_74875_2_, p_74875_3_, this.field_143013_d, 1, 1, 0);
/*      */       
/*  934 */       if (this.field_74885_f == 2 || this.field_74885_f == 3) {
/*  935 */         func_151549_a(p_74875_1_, p_74875_3_, 4, 1, 1, 4, 3, 3, Blocks.field_150350_a, Blocks.field_150350_a, false);
/*      */       } else {
/*  937 */         func_151549_a(p_74875_1_, p_74875_3_, 0, 1, 1, 0, 3, 3, Blocks.field_150350_a, Blocks.field_150350_a, false);
/*      */       } 
/*      */       
/*  940 */       return true;
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public static class RoomCrossing
/*      */     extends Stronghold
/*      */   {
/*  948 */     public static final WeightedRandomChestContent[] field_75014_c = new WeightedRandomChestContent[] { new WeightedRandomChestContent(Items.field_151042_j, 0, 1, 5, 10), new WeightedRandomChestContent(Items.field_151043_k, 0, 1, 3, 5), new WeightedRandomChestContent(Items.field_151137_ax, 0, 4, 9, 5), new WeightedRandomChestContent(Items.field_151044_h, 0, 3, 8, 10), new WeightedRandomChestContent(Items.field_151025_P, 0, 1, 3, 15), new WeightedRandomChestContent(Items.field_151034_e, 0, 1, 3, 15), new WeightedRandomChestContent(Items.field_151035_b, 0, 1, 1, 1) };
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected int field_75013_b;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private static final String __OBFID = "CL_00000496";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public RoomCrossing() {}
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public RoomCrossing(int p_i2079_1_, Random p_i2079_2_, StructureBoundingBox p_i2079_3_, int p_i2079_4_) {
/*  970 */       super(p_i2079_1_);
/*      */       
/*  972 */       this.field_74885_f = p_i2079_4_;
/*  973 */       this.field_143013_d = func_74988_a(p_i2079_2_);
/*  974 */       this.field_74887_e = p_i2079_3_;
/*  975 */       this.field_75013_b = p_i2079_2_.nextInt(5);
/*      */     }
/*      */ 
/*      */     
/*      */     protected void func_143012_a(NBTTagCompound p_143012_1_) {
/*  980 */       super.func_143012_a(p_143012_1_);
/*  981 */       p_143012_1_.func_74768_a("Type", this.field_75013_b);
/*      */     }
/*      */ 
/*      */     
/*      */     protected void func_143011_b(NBTTagCompound p_143011_1_) {
/*  986 */       super.func_143011_b(p_143011_1_);
/*  987 */       this.field_75013_b = p_143011_1_.func_74762_e("Type");
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_) {
/*  993 */       func_74986_a((StructureStrongholdPieces.Stairs2)p_74861_1_, p_74861_2_, p_74861_3_, 4, 1);
/*  994 */       func_74989_b((StructureStrongholdPieces.Stairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 4);
/*  995 */       func_74987_c((StructureStrongholdPieces.Stairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 4);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public static RoomCrossing func_75012_a(List p_75012_0_, Random p_75012_1_, int p_75012_2_, int p_75012_3_, int p_75012_4_, int p_75012_5_, int p_75012_6_) {
/* 1001 */       StructureBoundingBox structureBoundingBox = StructureBoundingBox.func_78889_a(p_75012_2_, p_75012_3_, p_75012_4_, -4, -1, 0, 11, 7, 11, p_75012_5_);
/*      */       
/* 1003 */       if (!func_74991_a(structureBoundingBox) || StructureComponent.func_74883_a(p_75012_0_, structureBoundingBox) != null) {
/* 1004 */         return null;
/*      */       }
/*      */       
/* 1007 */       return new RoomCrossing(p_75012_6_, p_75012_1_, structureBoundingBox, p_75012_5_);
/*      */     }
/*      */     
/*      */     public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
/*      */     {
/* 1012 */       if (func_74860_a(p_74875_1_, p_74875_3_)) {
/* 1013 */         return false;
/*      */       }
/*      */ 
/*      */       
/* 1017 */       func_74882_a(p_74875_1_, p_74875_3_, 0, 0, 0, 10, 6, 10, true, p_74875_2_, StructureStrongholdPieces.field_75204_e);
/*      */       
/* 1019 */       func_74990_a(p_74875_1_, p_74875_2_, p_74875_3_, this.field_143013_d, 4, 1, 0);
/*      */       
/* 1021 */       func_151549_a(p_74875_1_, p_74875_3_, 4, 1, 10, 6, 3, 10, Blocks.field_150350_a, Blocks.field_150350_a, false);
/* 1022 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 1, 4, 0, 3, 6, Blocks.field_150350_a, Blocks.field_150350_a, false);
/* 1023 */       func_151549_a(p_74875_1_, p_74875_3_, 10, 1, 4, 10, 3, 6, Blocks.field_150350_a, Blocks.field_150350_a, false);
/*      */       
/* 1025 */       switch (this.field_75013_b) {
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
/*      */ 
/*      */         
/*      */         default:
/* 1101 */           return true;
/*      */         case 0:
/*      */           func_151550_a(p_74875_1_, Blocks.field_150417_aV, 0, 5, 1, 5, p_74875_3_); func_151550_a(p_74875_1_, Blocks.field_150417_aV, 0, 5, 2, 5, p_74875_3_); func_151550_a(p_74875_1_, Blocks.field_150417_aV, 0, 5, 3, 5, p_74875_3_); func_151550_a(p_74875_1_, Blocks.field_150478_aa, 0, 4, 3, 5, p_74875_3_); func_151550_a(p_74875_1_, Blocks.field_150478_aa, 0, 6, 3, 5, p_74875_3_); func_151550_a(p_74875_1_, Blocks.field_150478_aa, 0, 5, 3, 4, p_74875_3_); func_151550_a(p_74875_1_, Blocks.field_150478_aa, 0, 5, 3, 6, p_74875_3_); func_151550_a(p_74875_1_, (Block)Blocks.field_150333_U, 0, 4, 1, 4, p_74875_3_); func_151550_a(p_74875_1_, (Block)Blocks.field_150333_U, 0, 4, 1, 5, p_74875_3_); func_151550_a(p_74875_1_, (Block)Blocks.field_150333_U, 0, 4, 1, 6, p_74875_3_); func_151550_a(p_74875_1_, (Block)Blocks.field_150333_U, 0, 6, 1, 4, p_74875_3_); func_151550_a(p_74875_1_, (Block)Blocks.field_150333_U, 0, 6, 1, 5, p_74875_3_); func_151550_a(p_74875_1_, (Block)Blocks.field_150333_U, 0, 6, 1, 6, p_74875_3_); func_151550_a(p_74875_1_, (Block)Blocks.field_150333_U, 0, 5, 1, 4, p_74875_3_); func_151550_a(p_74875_1_, (Block)Blocks.field_150333_U, 0, 5, 1, 6, p_74875_3_);
/*      */         case 1:
/*      */           for (b = 0; b < 5; b++) { func_151550_a(p_74875_1_, Blocks.field_150417_aV, 0, 3, 1, 3 + b, p_74875_3_); func_151550_a(p_74875_1_, Blocks.field_150417_aV, 0, 7, 1, 3 + b, p_74875_3_); func_151550_a(p_74875_1_, Blocks.field_150417_aV, 0, 3 + b, 1, 3, p_74875_3_); func_151550_a(p_74875_1_, Blocks.field_150417_aV, 0, 3 + b, 1, 7, p_74875_3_); }
/*      */            func_151550_a(p_74875_1_, Blocks.field_150417_aV, 0, 5, 1, 5, p_74875_3_); func_151550_a(p_74875_1_, Blocks.field_150417_aV, 0, 5, 2, 5, p_74875_3_); func_151550_a(p_74875_1_, Blocks.field_150417_aV, 0, 5, 3, 5, p_74875_3_); func_151550_a(p_74875_1_, (Block)Blocks.field_150358_i, 0, 5, 4, 5, p_74875_3_);
/*      */         case 2:
/*      */           break;
/*      */       }  byte b; for (b = 1; b <= 9; b++) { func_151550_a(p_74875_1_, Blocks.field_150347_e, 0, 1, 3, b, p_74875_3_); func_151550_a(p_74875_1_, Blocks.field_150347_e, 0, 9, 3, b, p_74875_3_); }
/*      */        for (b = 1; b <= 9; b++) { func_151550_a(p_74875_1_, Blocks.field_150347_e, 0, b, 3, 1, p_74875_3_); func_151550_a(p_74875_1_, Blocks.field_150347_e, 0, b, 3, 9, p_74875_3_); }
/*      */        func_151550_a(p_74875_1_, Blocks.field_150347_e, 0, 5, 1, 4, p_74875_3_); func_151550_a(p_74875_1_, Blocks.field_150347_e, 0, 5, 1, 6, p_74875_3_); func_151550_a(p_74875_1_, Blocks.field_150347_e, 0, 5, 3, 4, p_74875_3_); func_151550_a(p_74875_1_, Blocks.field_150347_e, 0, 5, 3, 6, p_74875_3_); func_151550_a(p_74875_1_, Blocks.field_150347_e, 0, 4, 1, 5, p_74875_3_); func_151550_a(p_74875_1_, Blocks.field_150347_e, 0, 6, 1, 5, p_74875_3_); func_151550_a(p_74875_1_, Blocks.field_150347_e, 0, 4, 3, 5, p_74875_3_); func_151550_a(p_74875_1_, Blocks.field_150347_e, 0, 6, 3, 5, p_74875_3_); for (b = 1; b <= 3; b++) {
/*      */         func_151550_a(p_74875_1_, Blocks.field_150347_e, 0, 4, b, 4, p_74875_3_); func_151550_a(p_74875_1_, Blocks.field_150347_e, 0, 6, b, 4, p_74875_3_); func_151550_a(p_74875_1_, Blocks.field_150347_e, 0, 4, b, 6, p_74875_3_); func_151550_a(p_74875_1_, Blocks.field_150347_e, 0, 6, b, 6, p_74875_3_);
/*      */       }  func_151550_a(p_74875_1_, Blocks.field_150478_aa, 0, 5, 3, 5, p_74875_3_); for (b = 2; b <= 8; b++) {
/*      */         func_151550_a(p_74875_1_, Blocks.field_150344_f, 0, 2, 3, b, p_74875_3_); func_151550_a(p_74875_1_, Blocks.field_150344_f, 0, 3, 3, b, p_74875_3_); if (b <= 3 || b >= 7) {
/*      */           func_151550_a(p_74875_1_, Blocks.field_150344_f, 0, 4, 3, b, p_74875_3_); func_151550_a(p_74875_1_, Blocks.field_150344_f, 0, 5, 3, b, p_74875_3_); func_151550_a(p_74875_1_, Blocks.field_150344_f, 0, 6, 3, b, p_74875_3_);
/*      */         }  func_151550_a(p_74875_1_, Blocks.field_150344_f, 0, 7, 3, b, p_74875_3_); func_151550_a(p_74875_1_, Blocks.field_150344_f, 0, 8, 3, b, p_74875_3_);
/* 1117 */       }  func_151550_a(p_74875_1_, Blocks.field_150468_ap, func_151555_a(Blocks.field_150468_ap, 4), 9, 1, 3, p_74875_3_); func_151550_a(p_74875_1_, Blocks.field_150468_ap, func_151555_a(Blocks.field_150468_ap, 4), 9, 2, 3, p_74875_3_); func_151550_a(p_74875_1_, Blocks.field_150468_ap, func_151555_a(Blocks.field_150468_ap, 4), 9, 3, 3, p_74875_3_); func_74879_a(p_74875_1_, p_74875_3_, p_74875_2_, 3, 4, 8, WeightedRandomChestContent.func_92080_a(field_75014_c, new WeightedRandomChestContent[] { Items.field_151134_bR.func_92114_b(p_74875_2_) }), 1 + p_74875_2_.nextInt(4)); } } public static class Prison extends Stronghold { public Prison(int p_i2078_1_, Random p_i2078_2_, StructureBoundingBox p_i2078_3_, int p_i2078_4_) { super(p_i2078_1_);
/*      */       
/* 1119 */       this.field_74885_f = p_i2078_4_;
/* 1120 */       this.field_143013_d = func_74988_a(p_i2078_2_);
/* 1121 */       this.field_74887_e = p_i2078_3_; }
/*      */     
/*      */     private static final String __OBFID = "CL_00000494";
/*      */     public Prison() {}
/*      */     
/*      */     public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_) {
/* 1127 */       func_74986_a((StructureStrongholdPieces.Stairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 1);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public static Prison func_75016_a(List p_75016_0_, Random p_75016_1_, int p_75016_2_, int p_75016_3_, int p_75016_4_, int p_75016_5_, int p_75016_6_) {
/* 1133 */       StructureBoundingBox structureBoundingBox = StructureBoundingBox.func_78889_a(p_75016_2_, p_75016_3_, p_75016_4_, -1, -1, 0, 9, 5, 11, p_75016_5_);
/*      */       
/* 1135 */       if (!func_74991_a(structureBoundingBox) || StructureComponent.func_74883_a(p_75016_0_, structureBoundingBox) != null) {
/* 1136 */         return null;
/*      */       }
/*      */       
/* 1139 */       return new Prison(p_75016_6_, p_75016_1_, structureBoundingBox, p_75016_5_);
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
/* 1144 */       if (func_74860_a(p_74875_1_, p_74875_3_)) {
/* 1145 */         return false;
/*      */       }
/*      */ 
/*      */       
/* 1149 */       func_74882_a(p_74875_1_, p_74875_3_, 0, 0, 0, 8, 4, 10, true, p_74875_2_, StructureStrongholdPieces.field_75204_e);
/*      */       
/* 1151 */       func_74990_a(p_74875_1_, p_74875_2_, p_74875_3_, this.field_143013_d, 1, 1, 0);
/*      */       
/* 1153 */       func_151549_a(p_74875_1_, p_74875_3_, 1, 1, 10, 3, 3, 10, Blocks.field_150350_a, Blocks.field_150350_a, false);
/*      */ 
/*      */       
/* 1156 */       func_74882_a(p_74875_1_, p_74875_3_, 4, 1, 1, 4, 3, 1, false, p_74875_2_, StructureStrongholdPieces.field_75204_e);
/* 1157 */       func_74882_a(p_74875_1_, p_74875_3_, 4, 1, 3, 4, 3, 3, false, p_74875_2_, StructureStrongholdPieces.field_75204_e);
/* 1158 */       func_74882_a(p_74875_1_, p_74875_3_, 4, 1, 7, 4, 3, 7, false, p_74875_2_, StructureStrongholdPieces.field_75204_e);
/* 1159 */       func_74882_a(p_74875_1_, p_74875_3_, 4, 1, 9, 4, 3, 9, false, p_74875_2_, StructureStrongholdPieces.field_75204_e);
/*      */ 
/*      */       
/* 1162 */       func_151549_a(p_74875_1_, p_74875_3_, 4, 1, 4, 4, 3, 6, Blocks.field_150411_aY, Blocks.field_150411_aY, false);
/* 1163 */       func_151549_a(p_74875_1_, p_74875_3_, 5, 1, 5, 7, 3, 5, Blocks.field_150411_aY, Blocks.field_150411_aY, false);
/*      */ 
/*      */       
/* 1166 */       func_151550_a(p_74875_1_, Blocks.field_150411_aY, 0, 4, 3, 2, p_74875_3_);
/* 1167 */       func_151550_a(p_74875_1_, Blocks.field_150411_aY, 0, 4, 3, 8, p_74875_3_);
/* 1168 */       func_151550_a(p_74875_1_, Blocks.field_150454_av, func_151555_a(Blocks.field_150454_av, 3), 4, 1, 2, p_74875_3_);
/* 1169 */       func_151550_a(p_74875_1_, Blocks.field_150454_av, func_151555_a(Blocks.field_150454_av, 3) + 8, 4, 2, 2, p_74875_3_);
/* 1170 */       func_151550_a(p_74875_1_, Blocks.field_150454_av, func_151555_a(Blocks.field_150454_av, 3), 4, 1, 8, p_74875_3_);
/* 1171 */       func_151550_a(p_74875_1_, Blocks.field_150454_av, func_151555_a(Blocks.field_150454_av, 3) + 8, 4, 2, 8, p_74875_3_);
/*      */       
/* 1173 */       return true;
/*      */     } }
/*      */ 
/*      */ 
/*      */   
/*      */   public static class Library
/*      */     extends Stronghold
/*      */   {
/* 1181 */     public static final WeightedRandomChestContent[] field_75007_b = new WeightedRandomChestContent[] { new WeightedRandomChestContent(Items.field_151122_aG, 0, 1, 3, 20), new WeightedRandomChestContent(Items.field_151121_aF, 0, 2, 7, 20), new WeightedRandomChestContent((Item)Items.field_151148_bJ, 0, 1, 1, 1), new WeightedRandomChestContent(Items.field_151111_aL, 0, 1, 1, 1) };
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private boolean field_75008_c;
/*      */ 
/*      */ 
/*      */     
/*      */     private static final String __OBFID = "CL_00000491";
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Library() {}
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Library(int p_i2075_1_, Random p_i2075_2_, StructureBoundingBox p_i2075_3_, int p_i2075_4_) {
/* 1201 */       super(p_i2075_1_);
/*      */       
/* 1203 */       this.field_74885_f = p_i2075_4_;
/* 1204 */       this.field_143013_d = func_74988_a(p_i2075_2_);
/* 1205 */       this.field_74887_e = p_i2075_3_;
/* 1206 */       this.field_75008_c = (p_i2075_3_.func_78882_c() > 6);
/*      */     }
/*      */ 
/*      */     
/*      */     protected void func_143012_a(NBTTagCompound p_143012_1_) {
/* 1211 */       super.func_143012_a(p_143012_1_);
/* 1212 */       p_143012_1_.func_74757_a("Tall", this.field_75008_c);
/*      */     }
/*      */ 
/*      */     
/*      */     protected void func_143011_b(NBTTagCompound p_143011_1_) {
/* 1217 */       super.func_143011_b(p_143011_1_);
/* 1218 */       this.field_75008_c = p_143011_1_.func_74767_n("Tall");
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public static Library func_75006_a(List p_75006_0_, Random p_75006_1_, int p_75006_2_, int p_75006_3_, int p_75006_4_, int p_75006_5_, int p_75006_6_) {
/* 1224 */       StructureBoundingBox structureBoundingBox = StructureBoundingBox.func_78889_a(p_75006_2_, p_75006_3_, p_75006_4_, -4, -1, 0, 14, 11, 15, p_75006_5_);
/*      */       
/* 1226 */       if (!func_74991_a(structureBoundingBox) || StructureComponent.func_74883_a(p_75006_0_, structureBoundingBox) != null) {
/*      */         
/* 1228 */         structureBoundingBox = StructureBoundingBox.func_78889_a(p_75006_2_, p_75006_3_, p_75006_4_, -4, -1, 0, 14, 6, 15, p_75006_5_);
/*      */         
/* 1230 */         if (!func_74991_a(structureBoundingBox) || StructureComponent.func_74883_a(p_75006_0_, structureBoundingBox) != null) {
/* 1231 */           return null;
/*      */         }
/*      */       } 
/*      */       
/* 1235 */       return new Library(p_75006_6_, p_75006_1_, structureBoundingBox, p_75006_5_);
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
/* 1240 */       if (func_74860_a(p_74875_1_, p_74875_3_)) {
/* 1241 */         return false;
/*      */       }
/*      */       
/* 1244 */       byte b1 = 11;
/* 1245 */       if (!this.field_75008_c) {
/* 1246 */         b1 = 6;
/*      */       }
/*      */ 
/*      */       
/* 1250 */       func_74882_a(p_74875_1_, p_74875_3_, 0, 0, 0, 13, b1 - 1, 14, true, p_74875_2_, StructureStrongholdPieces.field_75204_e);
/*      */       
/* 1252 */       func_74990_a(p_74875_1_, p_74875_2_, p_74875_3_, this.field_143013_d, 4, 1, 0);
/*      */ 
/*      */       
/* 1255 */       func_151551_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.07F, 2, 1, 1, 11, 4, 13, Blocks.field_150321_G, Blocks.field_150321_G, false);
/*      */       
/* 1257 */       boolean bool = true;
/* 1258 */       byte b2 = 12;
/*      */       
/*      */       int i;
/* 1261 */       for (i = 1; i <= 13; i++) {
/* 1262 */         if ((i - 1) % 4 == 0) {
/* 1263 */           func_151549_a(p_74875_1_, p_74875_3_, 1, 1, i, 1, 4, i, Blocks.field_150344_f, Blocks.field_150344_f, false);
/* 1264 */           func_151549_a(p_74875_1_, p_74875_3_, 12, 1, i, 12, 4, i, Blocks.field_150344_f, Blocks.field_150344_f, false);
/*      */           
/* 1266 */           func_151550_a(p_74875_1_, Blocks.field_150478_aa, 0, 2, 3, i, p_74875_3_);
/* 1267 */           func_151550_a(p_74875_1_, Blocks.field_150478_aa, 0, 11, 3, i, p_74875_3_);
/*      */           
/* 1269 */           if (this.field_75008_c) {
/* 1270 */             func_151549_a(p_74875_1_, p_74875_3_, 1, 6, i, 1, 9, i, Blocks.field_150344_f, Blocks.field_150344_f, false);
/* 1271 */             func_151549_a(p_74875_1_, p_74875_3_, 12, 6, i, 12, 9, i, Blocks.field_150344_f, Blocks.field_150344_f, false);
/*      */           } 
/*      */         } else {
/*      */           
/* 1275 */           func_151549_a(p_74875_1_, p_74875_3_, 1, 1, i, 1, 4, i, Blocks.field_150342_X, Blocks.field_150342_X, false);
/* 1276 */           func_151549_a(p_74875_1_, p_74875_3_, 12, 1, i, 12, 4, i, Blocks.field_150342_X, Blocks.field_150342_X, false);
/*      */           
/* 1278 */           if (this.field_75008_c) {
/* 1279 */             func_151549_a(p_74875_1_, p_74875_3_, 1, 6, i, 1, 9, i, Blocks.field_150342_X, Blocks.field_150342_X, false);
/* 1280 */             func_151549_a(p_74875_1_, p_74875_3_, 12, 6, i, 12, 9, i, Blocks.field_150342_X, Blocks.field_150342_X, false);
/*      */           } 
/*      */         } 
/*      */       } 
/*      */ 
/*      */       
/* 1286 */       for (i = 3; i < 12; i += 2) {
/* 1287 */         func_151549_a(p_74875_1_, p_74875_3_, 3, 1, i, 4, 3, i, Blocks.field_150342_X, Blocks.field_150342_X, false);
/* 1288 */         func_151549_a(p_74875_1_, p_74875_3_, 6, 1, i, 7, 3, i, Blocks.field_150342_X, Blocks.field_150342_X, false);
/* 1289 */         func_151549_a(p_74875_1_, p_74875_3_, 9, 1, i, 10, 3, i, Blocks.field_150342_X, Blocks.field_150342_X, false);
/*      */       } 
/*      */       
/* 1292 */       if (this.field_75008_c) {
/*      */         
/* 1294 */         func_151549_a(p_74875_1_, p_74875_3_, 1, 5, 1, 3, 5, 13, Blocks.field_150344_f, Blocks.field_150344_f, false);
/* 1295 */         func_151549_a(p_74875_1_, p_74875_3_, 10, 5, 1, 12, 5, 13, Blocks.field_150344_f, Blocks.field_150344_f, false);
/* 1296 */         func_151549_a(p_74875_1_, p_74875_3_, 4, 5, 1, 9, 5, 2, Blocks.field_150344_f, Blocks.field_150344_f, false);
/* 1297 */         func_151549_a(p_74875_1_, p_74875_3_, 4, 5, 12, 9, 5, 13, Blocks.field_150344_f, Blocks.field_150344_f, false);
/*      */         
/* 1299 */         func_151550_a(p_74875_1_, Blocks.field_150344_f, 0, 9, 5, 11, p_74875_3_);
/* 1300 */         func_151550_a(p_74875_1_, Blocks.field_150344_f, 0, 8, 5, 11, p_74875_3_);
/* 1301 */         func_151550_a(p_74875_1_, Blocks.field_150344_f, 0, 9, 5, 10, p_74875_3_);
/*      */ 
/*      */         
/* 1304 */         func_151549_a(p_74875_1_, p_74875_3_, 3, 6, 2, 3, 6, 12, Blocks.field_150422_aJ, Blocks.field_150422_aJ, false);
/* 1305 */         func_151549_a(p_74875_1_, p_74875_3_, 10, 6, 2, 10, 6, 10, Blocks.field_150422_aJ, Blocks.field_150422_aJ, false);
/* 1306 */         func_151549_a(p_74875_1_, p_74875_3_, 4, 6, 2, 9, 6, 2, Blocks.field_150422_aJ, Blocks.field_150422_aJ, false);
/* 1307 */         func_151549_a(p_74875_1_, p_74875_3_, 4, 6, 12, 8, 6, 12, Blocks.field_150422_aJ, Blocks.field_150422_aJ, false);
/* 1308 */         func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, 9, 6, 11, p_74875_3_);
/* 1309 */         func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, 8, 6, 11, p_74875_3_);
/* 1310 */         func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, 9, 6, 10, p_74875_3_);
/*      */ 
/*      */         
/* 1313 */         i = func_151555_a(Blocks.field_150468_ap, 3);
/* 1314 */         func_151550_a(p_74875_1_, Blocks.field_150468_ap, i, 10, 1, 13, p_74875_3_);
/* 1315 */         func_151550_a(p_74875_1_, Blocks.field_150468_ap, i, 10, 2, 13, p_74875_3_);
/* 1316 */         func_151550_a(p_74875_1_, Blocks.field_150468_ap, i, 10, 3, 13, p_74875_3_);
/* 1317 */         func_151550_a(p_74875_1_, Blocks.field_150468_ap, i, 10, 4, 13, p_74875_3_);
/* 1318 */         func_151550_a(p_74875_1_, Blocks.field_150468_ap, i, 10, 5, 13, p_74875_3_);
/* 1319 */         func_151550_a(p_74875_1_, Blocks.field_150468_ap, i, 10, 6, 13, p_74875_3_);
/* 1320 */         func_151550_a(p_74875_1_, Blocks.field_150468_ap, i, 10, 7, 13, p_74875_3_);
/*      */ 
/*      */         
/* 1323 */         byte b3 = 7;
/* 1324 */         byte b4 = 7;
/* 1325 */         func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, b3 - 1, 9, b4, p_74875_3_);
/* 1326 */         func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, b3, 9, b4, p_74875_3_);
/* 1327 */         func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, b3 - 1, 8, b4, p_74875_3_);
/* 1328 */         func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, b3, 8, b4, p_74875_3_);
/* 1329 */         func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, b3 - 1, 7, b4, p_74875_3_);
/* 1330 */         func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, b3, 7, b4, p_74875_3_);
/*      */         
/* 1332 */         func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, b3 - 2, 7, b4, p_74875_3_);
/* 1333 */         func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, b3 + 1, 7, b4, p_74875_3_);
/* 1334 */         func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, b3 - 1, 7, b4 - 1, p_74875_3_);
/* 1335 */         func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, b3 - 1, 7, b4 + 1, p_74875_3_);
/* 1336 */         func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, b3, 7, b4 - 1, p_74875_3_);
/* 1337 */         func_151550_a(p_74875_1_, Blocks.field_150422_aJ, 0, b3, 7, b4 + 1, p_74875_3_);
/*      */         
/* 1339 */         func_151550_a(p_74875_1_, Blocks.field_150478_aa, 0, b3 - 2, 8, b4, p_74875_3_);
/* 1340 */         func_151550_a(p_74875_1_, Blocks.field_150478_aa, 0, b3 + 1, 8, b4, p_74875_3_);
/* 1341 */         func_151550_a(p_74875_1_, Blocks.field_150478_aa, 0, b3 - 1, 8, b4 - 1, p_74875_3_);
/* 1342 */         func_151550_a(p_74875_1_, Blocks.field_150478_aa, 0, b3 - 1, 8, b4 + 1, p_74875_3_);
/* 1343 */         func_151550_a(p_74875_1_, Blocks.field_150478_aa, 0, b3, 8, b4 - 1, p_74875_3_);
/* 1344 */         func_151550_a(p_74875_1_, Blocks.field_150478_aa, 0, b3, 8, b4 + 1, p_74875_3_);
/*      */       } 
/*      */ 
/*      */       
/* 1348 */       func_74879_a(p_74875_1_, p_74875_3_, p_74875_2_, 3, 3, 5, WeightedRandomChestContent.func_92080_a(field_75007_b, new WeightedRandomChestContent[] { Items.field_151134_bR.func_92112_a(p_74875_2_, 1, 5, 2) }), 1 + p_74875_2_.nextInt(4));
/* 1349 */       if (this.field_75008_c) {
/* 1350 */         func_151550_a(p_74875_1_, Blocks.field_150350_a, 0, 12, 9, 1, p_74875_3_);
/* 1351 */         func_74879_a(p_74875_1_, p_74875_3_, p_74875_2_, 12, 8, 1, WeightedRandomChestContent.func_92080_a(field_75007_b, new WeightedRandomChestContent[] { Items.field_151134_bR.func_92112_a(p_74875_2_, 1, 5, 2) }), 1 + p_74875_2_.nextInt(4));
/*      */       } 
/*      */ 
/*      */       
/* 1355 */       return true;
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public static class Crossing
/*      */     extends Stronghold
/*      */   {
/*      */     private boolean field_74996_b;
/*      */     
/*      */     private boolean field_74997_c;
/*      */     private boolean field_74995_d;
/*      */     private boolean field_74999_h;
/*      */     private static final String __OBFID = "CL_00000489";
/*      */     
/*      */     public Crossing() {}
/*      */     
/*      */     public Crossing(int p_i2073_1_, Random p_i2073_2_, StructureBoundingBox p_i2073_3_, int p_i2073_4_) {
/* 1373 */       super(p_i2073_1_);
/*      */       
/* 1375 */       this.field_74885_f = p_i2073_4_;
/* 1376 */       this.field_143013_d = func_74988_a(p_i2073_2_);
/* 1377 */       this.field_74887_e = p_i2073_3_;
/*      */       
/* 1379 */       this.field_74996_b = p_i2073_2_.nextBoolean();
/* 1380 */       this.field_74997_c = p_i2073_2_.nextBoolean();
/* 1381 */       this.field_74995_d = p_i2073_2_.nextBoolean();
/* 1382 */       this.field_74999_h = (p_i2073_2_.nextInt(3) > 0);
/*      */     }
/*      */ 
/*      */     
/*      */     protected void func_143012_a(NBTTagCompound p_143012_1_) {
/* 1387 */       super.func_143012_a(p_143012_1_);
/* 1388 */       p_143012_1_.func_74757_a("leftLow", this.field_74996_b);
/* 1389 */       p_143012_1_.func_74757_a("leftHigh", this.field_74997_c);
/* 1390 */       p_143012_1_.func_74757_a("rightLow", this.field_74995_d);
/* 1391 */       p_143012_1_.func_74757_a("rightHigh", this.field_74999_h);
/*      */     }
/*      */ 
/*      */     
/*      */     protected void func_143011_b(NBTTagCompound p_143011_1_) {
/* 1396 */       super.func_143011_b(p_143011_1_);
/* 1397 */       this.field_74996_b = p_143011_1_.func_74767_n("leftLow");
/* 1398 */       this.field_74997_c = p_143011_1_.func_74767_n("leftHigh");
/* 1399 */       this.field_74995_d = p_143011_1_.func_74767_n("rightLow");
/* 1400 */       this.field_74999_h = p_143011_1_.func_74767_n("rightHigh");
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_) {
/* 1406 */       int i = 3;
/* 1407 */       int j = 5;
/*      */       
/* 1409 */       if (this.field_74885_f == 1 || this.field_74885_f == 2) {
/* 1410 */         i = 8 - i;
/* 1411 */         j = 8 - j;
/*      */       } 
/*      */       
/* 1414 */       func_74986_a((StructureStrongholdPieces.Stairs2)p_74861_1_, p_74861_2_, p_74861_3_, 5, 1);
/* 1415 */       if (this.field_74996_b) func_74989_b((StructureStrongholdPieces.Stairs2)p_74861_1_, p_74861_2_, p_74861_3_, i, 1); 
/* 1416 */       if (this.field_74997_c) func_74989_b((StructureStrongholdPieces.Stairs2)p_74861_1_, p_74861_2_, p_74861_3_, j, 7); 
/* 1417 */       if (this.field_74995_d) func_74987_c((StructureStrongholdPieces.Stairs2)p_74861_1_, p_74861_2_, p_74861_3_, i, 1); 
/* 1418 */       if (this.field_74999_h) func_74987_c((StructureStrongholdPieces.Stairs2)p_74861_1_, p_74861_2_, p_74861_3_, j, 7);
/*      */     
/*      */     }
/*      */ 
/*      */     
/*      */     public static Crossing func_74994_a(List p_74994_0_, Random p_74994_1_, int p_74994_2_, int p_74994_3_, int p_74994_4_, int p_74994_5_, int p_74994_6_) {
/* 1424 */       StructureBoundingBox structureBoundingBox = StructureBoundingBox.func_78889_a(p_74994_2_, p_74994_3_, p_74994_4_, -4, -3, 0, 10, 9, 11, p_74994_5_);
/*      */       
/* 1426 */       if (!func_74991_a(structureBoundingBox) || StructureComponent.func_74883_a(p_74994_0_, structureBoundingBox) != null) {
/* 1427 */         return null;
/*      */       }
/*      */       
/* 1430 */       return new Crossing(p_74994_6_, p_74994_1_, structureBoundingBox, p_74994_5_);
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
/* 1435 */       if (func_74860_a(p_74875_1_, p_74875_3_)) {
/* 1436 */         return false;
/*      */       }
/*      */ 
/*      */       
/* 1440 */       func_74882_a(p_74875_1_, p_74875_3_, 0, 0, 0, 9, 8, 10, true, p_74875_2_, StructureStrongholdPieces.field_75204_e);
/*      */       
/* 1442 */       func_74990_a(p_74875_1_, p_74875_2_, p_74875_3_, this.field_143013_d, 4, 3, 0);
/*      */ 
/*      */       
/* 1445 */       if (this.field_74996_b) func_151549_a(p_74875_1_, p_74875_3_, 0, 3, 1, 0, 5, 3, Blocks.field_150350_a, Blocks.field_150350_a, false); 
/* 1446 */       if (this.field_74995_d) func_151549_a(p_74875_1_, p_74875_3_, 9, 3, 1, 9, 5, 3, Blocks.field_150350_a, Blocks.field_150350_a, false); 
/* 1447 */       if (this.field_74997_c) func_151549_a(p_74875_1_, p_74875_3_, 0, 5, 7, 0, 7, 9, Blocks.field_150350_a, Blocks.field_150350_a, false); 
/* 1448 */       if (this.field_74999_h) func_151549_a(p_74875_1_, p_74875_3_, 9, 5, 7, 9, 7, 9, Blocks.field_150350_a, Blocks.field_150350_a, false); 
/* 1449 */       func_151549_a(p_74875_1_, p_74875_3_, 5, 1, 10, 7, 3, 10, Blocks.field_150350_a, Blocks.field_150350_a, false);
/*      */ 
/*      */       
/* 1452 */       func_74882_a(p_74875_1_, p_74875_3_, 1, 2, 1, 8, 2, 6, false, p_74875_2_, StructureStrongholdPieces.field_75204_e);
/*      */       
/* 1454 */       func_74882_a(p_74875_1_, p_74875_3_, 4, 1, 5, 4, 4, 9, false, p_74875_2_, StructureStrongholdPieces.field_75204_e);
/* 1455 */       func_74882_a(p_74875_1_, p_74875_3_, 8, 1, 5, 8, 4, 9, false, p_74875_2_, StructureStrongholdPieces.field_75204_e);
/*      */       
/* 1457 */       func_74882_a(p_74875_1_, p_74875_3_, 1, 4, 7, 3, 4, 9, false, p_74875_2_, StructureStrongholdPieces.field_75204_e);
/*      */ 
/*      */       
/* 1460 */       func_74882_a(p_74875_1_, p_74875_3_, 1, 3, 5, 3, 3, 6, false, p_74875_2_, StructureStrongholdPieces.field_75204_e);
/* 1461 */       func_151549_a(p_74875_1_, p_74875_3_, 1, 3, 4, 3, 3, 4, (Block)Blocks.field_150333_U, (Block)Blocks.field_150333_U, false);
/* 1462 */       func_151549_a(p_74875_1_, p_74875_3_, 1, 4, 6, 3, 4, 6, (Block)Blocks.field_150333_U, (Block)Blocks.field_150333_U, false);
/*      */ 
/*      */       
/* 1465 */       func_74882_a(p_74875_1_, p_74875_3_, 5, 1, 7, 7, 1, 8, false, p_74875_2_, StructureStrongholdPieces.field_75204_e);
/* 1466 */       func_151549_a(p_74875_1_, p_74875_3_, 5, 1, 9, 7, 1, 9, (Block)Blocks.field_150333_U, (Block)Blocks.field_150333_U, false);
/* 1467 */       func_151549_a(p_74875_1_, p_74875_3_, 5, 2, 7, 7, 2, 7, (Block)Blocks.field_150333_U, (Block)Blocks.field_150333_U, false);
/*      */ 
/*      */       
/* 1470 */       func_151549_a(p_74875_1_, p_74875_3_, 4, 5, 7, 4, 5, 9, (Block)Blocks.field_150333_U, (Block)Blocks.field_150333_U, false);
/* 1471 */       func_151549_a(p_74875_1_, p_74875_3_, 8, 5, 7, 8, 5, 9, (Block)Blocks.field_150333_U, (Block)Blocks.field_150333_U, false);
/* 1472 */       func_151549_a(p_74875_1_, p_74875_3_, 5, 5, 7, 7, 5, 9, (Block)Blocks.field_150334_T, (Block)Blocks.field_150334_T, false);
/* 1473 */       func_151550_a(p_74875_1_, Blocks.field_150478_aa, 0, 6, 5, 6, p_74875_3_);
/*      */       
/* 1475 */       return true;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static class PortalRoom
/*      */     extends Stronghold
/*      */   {
/*      */     private boolean field_75005_a;
/*      */     
/*      */     private static final String __OBFID = "CL_00000493";
/*      */ 
/*      */     
/*      */     public PortalRoom() {}
/*      */ 
/*      */     
/*      */     public PortalRoom(int p_i2077_1_, Random p_i2077_2_, StructureBoundingBox p_i2077_3_, int p_i2077_4_) {
/* 1493 */       super(p_i2077_1_);
/*      */       
/* 1495 */       this.field_74885_f = p_i2077_4_;
/* 1496 */       this.field_74887_e = p_i2077_3_;
/*      */     }
/*      */ 
/*      */     
/*      */     protected void func_143012_a(NBTTagCompound p_143012_1_) {
/* 1501 */       super.func_143012_a(p_143012_1_);
/* 1502 */       p_143012_1_.func_74757_a("Mob", this.field_75005_a);
/*      */     }
/*      */ 
/*      */     
/*      */     protected void func_143011_b(NBTTagCompound p_143011_1_) {
/* 1507 */       super.func_143011_b(p_143011_1_);
/* 1508 */       this.field_75005_a = p_143011_1_.func_74767_n("Mob");
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_) {
/* 1514 */       if (p_74861_1_ != null) {
/* 1515 */         ((StructureStrongholdPieces.Stairs2)p_74861_1_).field_75025_b = this;
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public static PortalRoom func_75004_a(List p_75004_0_, Random p_75004_1_, int p_75004_2_, int p_75004_3_, int p_75004_4_, int p_75004_5_, int p_75004_6_) {
/* 1522 */       StructureBoundingBox structureBoundingBox = StructureBoundingBox.func_78889_a(p_75004_2_, p_75004_3_, p_75004_4_, -4, -1, 0, 11, 8, 16, p_75004_5_);
/*      */       
/* 1524 */       if (!func_74991_a(structureBoundingBox) || StructureComponent.func_74883_a(p_75004_0_, structureBoundingBox) != null) {
/* 1525 */         return null;
/*      */       }
/*      */       
/* 1528 */       return new PortalRoom(p_75004_6_, p_75004_1_, structureBoundingBox, p_75004_5_);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
/* 1534 */       func_74882_a(p_74875_1_, p_74875_3_, 0, 0, 0, 10, 7, 15, false, p_74875_2_, StructureStrongholdPieces.field_75204_e);
/*      */       
/* 1536 */       func_74990_a(p_74875_1_, p_74875_2_, p_74875_3_, StructureStrongholdPieces.Stronghold.Door.GRATES, 4, 1, 0);
/*      */ 
/*      */       
/* 1539 */       int i = 6;
/* 1540 */       func_74882_a(p_74875_1_, p_74875_3_, 1, i, 1, 1, i, 14, false, p_74875_2_, StructureStrongholdPieces.field_75204_e);
/* 1541 */       func_74882_a(p_74875_1_, p_74875_3_, 9, i, 1, 9, i, 14, false, p_74875_2_, StructureStrongholdPieces.field_75204_e);
/* 1542 */       func_74882_a(p_74875_1_, p_74875_3_, 2, i, 1, 8, i, 2, false, p_74875_2_, StructureStrongholdPieces.field_75204_e);
/* 1543 */       func_74882_a(p_74875_1_, p_74875_3_, 2, i, 14, 8, i, 14, false, p_74875_2_, StructureStrongholdPieces.field_75204_e);
/*      */ 
/*      */       
/* 1546 */       func_74882_a(p_74875_1_, p_74875_3_, 1, 1, 1, 2, 1, 4, false, p_74875_2_, StructureStrongholdPieces.field_75204_e);
/* 1547 */       func_74882_a(p_74875_1_, p_74875_3_, 8, 1, 1, 9, 1, 4, false, p_74875_2_, StructureStrongholdPieces.field_75204_e);
/* 1548 */       func_151549_a(p_74875_1_, p_74875_3_, 1, 1, 1, 1, 1, 3, (Block)Blocks.field_150356_k, (Block)Blocks.field_150356_k, false);
/* 1549 */       func_151549_a(p_74875_1_, p_74875_3_, 9, 1, 1, 9, 1, 3, (Block)Blocks.field_150356_k, (Block)Blocks.field_150356_k, false);
/*      */ 
/*      */       
/* 1552 */       func_74882_a(p_74875_1_, p_74875_3_, 3, 1, 8, 7, 1, 12, false, p_74875_2_, StructureStrongholdPieces.field_75204_e);
/* 1553 */       func_151549_a(p_74875_1_, p_74875_3_, 4, 1, 9, 6, 1, 11, (Block)Blocks.field_150356_k, (Block)Blocks.field_150356_k, false);
/*      */       
/*      */       int j;
/* 1556 */       for (j = 3; j < 14; j += 2) {
/* 1557 */         func_151549_a(p_74875_1_, p_74875_3_, 0, 3, j, 0, 4, j, Blocks.field_150411_aY, Blocks.field_150411_aY, false);
/* 1558 */         func_151549_a(p_74875_1_, p_74875_3_, 10, 3, j, 10, 4, j, Blocks.field_150411_aY, Blocks.field_150411_aY, false);
/*      */       } 
/* 1560 */       for (j = 2; j < 9; j += 2) {
/* 1561 */         func_151549_a(p_74875_1_, p_74875_3_, j, 3, 15, j, 4, 15, Blocks.field_150411_aY, Blocks.field_150411_aY, false);
/*      */       }
/*      */ 
/*      */       
/* 1565 */       j = func_151555_a(Blocks.field_150390_bg, 3);
/* 1566 */       func_74882_a(p_74875_1_, p_74875_3_, 4, 1, 5, 6, 1, 7, false, p_74875_2_, StructureStrongholdPieces.field_75204_e);
/* 1567 */       func_74882_a(p_74875_1_, p_74875_3_, 4, 2, 6, 6, 2, 7, false, p_74875_2_, StructureStrongholdPieces.field_75204_e);
/* 1568 */       func_74882_a(p_74875_1_, p_74875_3_, 4, 3, 7, 6, 3, 7, false, p_74875_2_, StructureStrongholdPieces.field_75204_e); byte b1;
/* 1569 */       for (b1 = 4; b1 <= 6; b1++) {
/* 1570 */         func_151550_a(p_74875_1_, Blocks.field_150390_bg, j, b1, 1, 4, p_74875_3_);
/* 1571 */         func_151550_a(p_74875_1_, Blocks.field_150390_bg, j, b1, 2, 5, p_74875_3_);
/* 1572 */         func_151550_a(p_74875_1_, Blocks.field_150390_bg, j, b1, 3, 6, p_74875_3_);
/*      */       } 
/*      */       
/* 1575 */       b1 = 2;
/* 1576 */       byte b2 = 0;
/* 1577 */       byte b3 = 3;
/* 1578 */       byte b4 = 1;
/*      */       
/* 1580 */       switch (this.field_74885_f) {
/*      */         case 0:
/* 1582 */           b1 = 0;
/* 1583 */           b2 = 2;
/*      */           break;
/*      */         case 3:
/* 1586 */           b1 = 3;
/* 1587 */           b2 = 1;
/* 1588 */           b3 = 0;
/* 1589 */           b4 = 2;
/*      */           break;
/*      */         case 1:
/* 1592 */           b1 = 1;
/* 1593 */           b2 = 3;
/* 1594 */           b3 = 0;
/* 1595 */           b4 = 2;
/*      */           break;
/*      */       } 
/*      */       
/* 1599 */       func_151550_a(p_74875_1_, Blocks.field_150378_br, b1 + ((p_74875_2_.nextFloat() > 0.9F) ? 4 : 0), 4, 3, 8, p_74875_3_);
/* 1600 */       func_151550_a(p_74875_1_, Blocks.field_150378_br, b1 + ((p_74875_2_.nextFloat() > 0.9F) ? 4 : 0), 5, 3, 8, p_74875_3_);
/* 1601 */       func_151550_a(p_74875_1_, Blocks.field_150378_br, b1 + ((p_74875_2_.nextFloat() > 0.9F) ? 4 : 0), 6, 3, 8, p_74875_3_);
/* 1602 */       func_151550_a(p_74875_1_, Blocks.field_150378_br, b2 + ((p_74875_2_.nextFloat() > 0.9F) ? 4 : 0), 4, 3, 12, p_74875_3_);
/* 1603 */       func_151550_a(p_74875_1_, Blocks.field_150378_br, b2 + ((p_74875_2_.nextFloat() > 0.9F) ? 4 : 0), 5, 3, 12, p_74875_3_);
/* 1604 */       func_151550_a(p_74875_1_, Blocks.field_150378_br, b2 + ((p_74875_2_.nextFloat() > 0.9F) ? 4 : 0), 6, 3, 12, p_74875_3_);
/* 1605 */       func_151550_a(p_74875_1_, Blocks.field_150378_br, b3 + ((p_74875_2_.nextFloat() > 0.9F) ? 4 : 0), 3, 3, 9, p_74875_3_);
/* 1606 */       func_151550_a(p_74875_1_, Blocks.field_150378_br, b3 + ((p_74875_2_.nextFloat() > 0.9F) ? 4 : 0), 3, 3, 10, p_74875_3_);
/* 1607 */       func_151550_a(p_74875_1_, Blocks.field_150378_br, b3 + ((p_74875_2_.nextFloat() > 0.9F) ? 4 : 0), 3, 3, 11, p_74875_3_);
/* 1608 */       func_151550_a(p_74875_1_, Blocks.field_150378_br, b4 + ((p_74875_2_.nextFloat() > 0.9F) ? 4 : 0), 7, 3, 9, p_74875_3_);
/* 1609 */       func_151550_a(p_74875_1_, Blocks.field_150378_br, b4 + ((p_74875_2_.nextFloat() > 0.9F) ? 4 : 0), 7, 3, 10, p_74875_3_);
/* 1610 */       func_151550_a(p_74875_1_, Blocks.field_150378_br, b4 + ((p_74875_2_.nextFloat() > 0.9F) ? 4 : 0), 7, 3, 11, p_74875_3_);
/*      */       
/* 1612 */       if (!this.field_75005_a) {
/* 1613 */         i = func_74862_a(3);
/* 1614 */         int k = func_74865_a(5, 6), m = func_74873_b(5, 6);
/* 1615 */         if (p_74875_3_.func_78890_b(k, i, m)) {
/* 1616 */           this.field_75005_a = true;
/* 1617 */           p_74875_1_.func_147465_d(k, i, m, Blocks.field_150474_ac, 0, 2);
/* 1618 */           TileEntityMobSpawner tileEntityMobSpawner = (TileEntityMobSpawner)p_74875_1_.func_147438_o(k, i, m);
/* 1619 */           if (tileEntityMobSpawner != null) tileEntityMobSpawner.func_145881_a().func_98272_a("Silverfish");
/*      */         
/*      */         } 
/*      */       } 
/* 1623 */       return true;
/*      */     } }
/*      */   
/*      */   static class Stones extends StructureComponent.BlockSelector {
/*      */     private static final String __OBFID = "CL_00000497";
/*      */     
/*      */     private Stones() {}
/*      */     
/*      */     public void func_75062_a(Random p_75062_1_, int p_75062_2_, int p_75062_3_, int p_75062_4_, boolean p_75062_5_) {
/* 1632 */       if (p_75062_5_) {
/* 1633 */         this.field_151562_a = Blocks.field_150417_aV;
/*      */         
/* 1635 */         float f = p_75062_1_.nextFloat();
/* 1636 */         if (f < 0.2F) {
/* 1637 */           this.field_75065_b = 2;
/* 1638 */         } else if (f < 0.5F) {
/* 1639 */           this.field_75065_b = 1;
/* 1640 */         } else if (f < 0.55F) {
/* 1641 */           this.field_151562_a = Blocks.field_150418_aU;
/* 1642 */           this.field_75065_b = 2;
/*      */         } else {
/* 1644 */           this.field_75065_b = 0;
/*      */         } 
/*      */       } else {
/* 1647 */         this.field_151562_a = Blocks.field_150350_a;
/* 1648 */         this.field_75065_b = 0;
/*      */       } 
/*      */     }
/*      */   }
/*      */   
/* 1653 */   private static final Stones field_75204_e = new Stones();
/*      */   private static final String __OBFID = "CL_00000483";
/*      */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\structure\StructureStrongholdPieces.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */