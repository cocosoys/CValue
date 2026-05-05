/*     */ package net.minecraft.world.gen.structure;
/*     */ 
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.item.EntityMinecartChest;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.tileentity.TileEntityMobSpawner;
/*     */ import net.minecraft.util.WeightedRandomChestContent;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class StructureMineshaftPieces
/*     */ {
/*     */   public static void func_143048_a() {
/*  24 */     MapGenStructureIO.func_143031_a(Corridor.class, "MSCorridor");
/*  25 */     MapGenStructureIO.func_143031_a(Cross.class, "MSCrossing");
/*  26 */     MapGenStructureIO.func_143031_a(Room.class, "MSRoom");
/*  27 */     MapGenStructureIO.func_143031_a(Stairs.class, "MSStairs");
/*     */   }
/*     */ 
/*     */   
/*     */   private static StructureComponent func_78815_a(List p_78815_0_, Random p_78815_1_, int p_78815_2_, int p_78815_3_, int p_78815_4_, int p_78815_5_, int p_78815_6_) {
/*  32 */     int i = p_78815_1_.nextInt(100);
/*  33 */     if (i >= 80) {
/*  34 */       StructureBoundingBox structureBoundingBox = Cross.func_74951_a(p_78815_0_, p_78815_1_, p_78815_2_, p_78815_3_, p_78815_4_, p_78815_5_);
/*  35 */       if (structureBoundingBox != null) {
/*  36 */         return new Cross(p_78815_6_, p_78815_1_, structureBoundingBox, p_78815_5_);
/*     */       }
/*  38 */     } else if (i >= 70) {
/*  39 */       StructureBoundingBox structureBoundingBox = Stairs.func_74950_a(p_78815_0_, p_78815_1_, p_78815_2_, p_78815_3_, p_78815_4_, p_78815_5_);
/*  40 */       if (structureBoundingBox != null) {
/*  41 */         return new Stairs(p_78815_6_, p_78815_1_, structureBoundingBox, p_78815_5_);
/*     */       }
/*     */     } else {
/*  44 */       StructureBoundingBox structureBoundingBox = Corridor.func_74954_a(p_78815_0_, p_78815_1_, p_78815_2_, p_78815_3_, p_78815_4_, p_78815_5_);
/*  45 */       if (structureBoundingBox != null) {
/*  46 */         return new Corridor(p_78815_6_, p_78815_1_, structureBoundingBox, p_78815_5_);
/*     */       }
/*     */     } 
/*     */     
/*  50 */     return null;
/*     */   }
/*     */   
/*     */   private static StructureComponent func_78817_b(StructureComponent p_78817_0_, List<StructureComponent> p_78817_1_, Random p_78817_2_, int p_78817_3_, int p_78817_4_, int p_78817_5_, int p_78817_6_, int p_78817_7_) {
/*  54 */     if (p_78817_7_ > 8) {
/*  55 */       return null;
/*     */     }
/*  57 */     if (Math.abs(p_78817_3_ - (p_78817_0_.func_74874_b()).field_78897_a) > 80 || Math.abs(p_78817_5_ - (p_78817_0_.func_74874_b()).field_78896_c) > 80) {
/*  58 */       return null;
/*     */     }
/*     */     
/*  61 */     StructureComponent structureComponent = func_78815_a(p_78817_1_, p_78817_2_, p_78817_3_, p_78817_4_, p_78817_5_, p_78817_6_, p_78817_7_ + 1);
/*  62 */     if (structureComponent != null) {
/*  63 */       p_78817_1_.add(structureComponent);
/*  64 */       structureComponent.func_74861_a(p_78817_0_, p_78817_1_, p_78817_2_);
/*     */     } 
/*  66 */     return structureComponent;
/*     */   }
/*     */   
/*     */   public static class Room
/*     */     extends StructureComponent {
/*  71 */     private List field_74949_a = new LinkedList();
/*     */     
/*     */     private static final String __OBFID = "CL_00000447";
/*     */     
/*     */     public Room() {}
/*     */     
/*     */     public Room(int p_i2037_1_, Random p_i2037_2_, int p_i2037_3_, int p_i2037_4_) {
/*  78 */       super(p_i2037_1_);
/*     */       
/*  80 */       this.field_74887_e = new StructureBoundingBox(p_i2037_3_, 50, p_i2037_4_, p_i2037_3_ + 7 + p_i2037_2_.nextInt(6), 54 + p_i2037_2_.nextInt(6), p_i2037_4_ + 7 + p_i2037_2_.nextInt(6));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_) {
/*  86 */       int i = func_74877_c();
/*     */ 
/*     */ 
/*     */       
/*  90 */       int k = this.field_74887_e.func_78882_c() - 3 - 1;
/*  91 */       if (k <= 0) {
/*  92 */         k = 1;
/*     */       }
/*     */ 
/*     */       
/*  96 */       int j = 0;
/*  97 */       while (j < this.field_74887_e.func_78883_b()) {
/*  98 */         j += p_74861_3_.nextInt(this.field_74887_e.func_78883_b());
/*  99 */         if (j + 3 > this.field_74887_e.func_78883_b()) {
/*     */           break;
/*     */         }
/* 102 */         StructureComponent structureComponent = StructureMineshaftPieces.func_78817_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a + j, this.field_74887_e.field_78895_b + p_74861_3_.nextInt(k) + 1, this.field_74887_e.field_78896_c - 1, 2, i);
/*     */         
/* 104 */         if (structureComponent != null) {
/* 105 */           StructureBoundingBox structureBoundingBox = structureComponent.func_74874_b();
/* 106 */           this.field_74949_a.add(new StructureBoundingBox(structureBoundingBox.field_78897_a, structureBoundingBox.field_78895_b, this.field_74887_e.field_78896_c, structureBoundingBox.field_78893_d, structureBoundingBox.field_78894_e, this.field_74887_e.field_78896_c + 1));
/*     */         } 
/* 108 */         j += 4;
/*     */       } 
/*     */       
/* 111 */       j = 0;
/* 112 */       while (j < this.field_74887_e.func_78883_b()) {
/* 113 */         j += p_74861_3_.nextInt(this.field_74887_e.func_78883_b());
/* 114 */         if (j + 3 > this.field_74887_e.func_78883_b()) {
/*     */           break;
/*     */         }
/* 117 */         StructureComponent structureComponent = StructureMineshaftPieces.func_78817_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a + j, this.field_74887_e.field_78895_b + p_74861_3_.nextInt(k) + 1, this.field_74887_e.field_78892_f + 1, 0, i);
/*     */         
/* 119 */         if (structureComponent != null) {
/* 120 */           StructureBoundingBox structureBoundingBox = structureComponent.func_74874_b();
/* 121 */           this.field_74949_a.add(new StructureBoundingBox(structureBoundingBox.field_78897_a, structureBoundingBox.field_78895_b, this.field_74887_e.field_78892_f - 1, structureBoundingBox.field_78893_d, structureBoundingBox.field_78894_e, this.field_74887_e.field_78892_f));
/*     */         } 
/* 123 */         j += 4;
/*     */       } 
/*     */       
/* 126 */       j = 0;
/* 127 */       while (j < this.field_74887_e.func_78880_d()) {
/* 128 */         j += p_74861_3_.nextInt(this.field_74887_e.func_78880_d());
/* 129 */         if (j + 3 > this.field_74887_e.func_78880_d()) {
/*     */           break;
/*     */         }
/* 132 */         StructureComponent structureComponent = StructureMineshaftPieces.func_78817_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a - 1, this.field_74887_e.field_78895_b + p_74861_3_.nextInt(k) + 1, this.field_74887_e.field_78896_c + j, 1, i);
/*     */         
/* 134 */         if (structureComponent != null) {
/* 135 */           StructureBoundingBox structureBoundingBox = structureComponent.func_74874_b();
/* 136 */           this.field_74949_a.add(new StructureBoundingBox(this.field_74887_e.field_78897_a, structureBoundingBox.field_78895_b, structureBoundingBox.field_78896_c, this.field_74887_e.field_78897_a + 1, structureBoundingBox.field_78894_e, structureBoundingBox.field_78892_f));
/*     */         } 
/* 138 */         j += 4;
/*     */       } 
/*     */       
/* 141 */       j = 0;
/* 142 */       while (j < this.field_74887_e.func_78880_d()) {
/* 143 */         j += p_74861_3_.nextInt(this.field_74887_e.func_78880_d());
/* 144 */         if (j + 3 > this.field_74887_e.func_78880_d()) {
/*     */           break;
/*     */         }
/* 147 */         StructureComponent structureComponent = StructureMineshaftPieces.func_78817_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78893_d + 1, this.field_74887_e.field_78895_b + p_74861_3_.nextInt(k) + 1, this.field_74887_e.field_78896_c + j, 3, i);
/*     */         
/* 149 */         if (structureComponent != null) {
/* 150 */           StructureBoundingBox structureBoundingBox = structureComponent.func_74874_b();
/* 151 */           this.field_74949_a.add(new StructureBoundingBox(this.field_74887_e.field_78893_d - 1, structureBoundingBox.field_78895_b, structureBoundingBox.field_78896_c, this.field_74887_e.field_78893_d, structureBoundingBox.field_78894_e, structureBoundingBox.field_78892_f));
/*     */         } 
/* 153 */         j += 4;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
/* 160 */       if (func_74860_a(p_74875_1_, p_74875_3_)) {
/* 161 */         return false;
/*     */       }
/*     */ 
/*     */       
/* 165 */       func_151549_a(p_74875_1_, p_74875_3_, this.field_74887_e.field_78897_a, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c, this.field_74887_e.field_78893_d, this.field_74887_e.field_78895_b, this.field_74887_e.field_78892_f, Blocks.field_150346_d, Blocks.field_150350_a, true);
/*     */ 
/*     */       
/* 168 */       func_151549_a(p_74875_1_, p_74875_3_, this.field_74887_e.field_78897_a, this.field_74887_e.field_78895_b + 1, this.field_74887_e.field_78896_c, this.field_74887_e.field_78893_d, Math.min(this.field_74887_e.field_78895_b + 3, this.field_74887_e.field_78894_e), this.field_74887_e.field_78892_f, Blocks.field_150350_a, Blocks.field_150350_a, false);
/*     */       
/* 170 */       for (StructureBoundingBox structureBoundingBox : this.field_74949_a) {
/* 171 */         func_151549_a(p_74875_1_, p_74875_3_, structureBoundingBox.field_78897_a, structureBoundingBox.field_78894_e - 2, structureBoundingBox.field_78896_c, structureBoundingBox.field_78893_d, structureBoundingBox.field_78894_e, structureBoundingBox.field_78892_f, Blocks.field_150350_a, Blocks.field_150350_a, false);
/*     */       }
/*     */       
/* 174 */       func_151547_a(p_74875_1_, p_74875_3_, this.field_74887_e.field_78897_a, this.field_74887_e.field_78895_b + 4, this.field_74887_e.field_78896_c, this.field_74887_e.field_78893_d, this.field_74887_e.field_78894_e, this.field_74887_e.field_78892_f, Blocks.field_150350_a, false);
/*     */       
/* 176 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     protected void func_143012_a(NBTTagCompound p_143012_1_) {
/* 181 */       NBTTagList nBTTagList = new NBTTagList();
/* 182 */       for (StructureBoundingBox structureBoundingBox : this.field_74949_a) {
/* 183 */         nBTTagList.func_74742_a((NBTBase)structureBoundingBox.func_151535_h());
/*     */       }
/* 185 */       p_143012_1_.func_74782_a("Entrances", (NBTBase)nBTTagList);
/*     */     }
/*     */ 
/*     */     
/*     */     protected void func_143011_b(NBTTagCompound p_143011_1_) {
/* 190 */       NBTTagList nBTTagList = p_143011_1_.func_150295_c("Entrances", 11);
/* 191 */       for (byte b = 0; b < nBTTagList.func_74745_c(); b++) {
/* 192 */         this.field_74949_a.add(new StructureBoundingBox(nBTTagList.func_150306_c(b)));
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Corridor
/*     */     extends StructureComponent
/*     */   {
/*     */     private boolean field_74958_a;
/*     */     private boolean field_74956_b;
/*     */     private boolean field_74957_c;
/*     */     private int field_74955_d;
/*     */     private static final String __OBFID = "CL_00000445";
/*     */     
/*     */     public Corridor() {}
/*     */     
/*     */     protected void func_143012_a(NBTTagCompound p_143012_1_) {
/* 210 */       p_143012_1_.func_74757_a("hr", this.field_74958_a);
/* 211 */       p_143012_1_.func_74757_a("sc", this.field_74956_b);
/* 212 */       p_143012_1_.func_74757_a("hps", this.field_74957_c);
/* 213 */       p_143012_1_.func_74768_a("Num", this.field_74955_d);
/*     */     }
/*     */ 
/*     */     
/*     */     protected void func_143011_b(NBTTagCompound p_143011_1_) {
/* 218 */       this.field_74958_a = p_143011_1_.func_74767_n("hr");
/* 219 */       this.field_74956_b = p_143011_1_.func_74767_n("sc");
/* 220 */       this.field_74957_c = p_143011_1_.func_74767_n("hps");
/* 221 */       this.field_74955_d = p_143011_1_.func_74762_e("Num");
/*     */     }
/*     */     
/*     */     public Corridor(int p_i2035_1_, Random p_i2035_2_, StructureBoundingBox p_i2035_3_, int p_i2035_4_) {
/* 225 */       super(p_i2035_1_);
/* 226 */       this.field_74885_f = p_i2035_4_;
/* 227 */       this.field_74887_e = p_i2035_3_;
/* 228 */       this.field_74958_a = (p_i2035_2_.nextInt(3) == 0);
/* 229 */       this.field_74956_b = (!this.field_74958_a && p_i2035_2_.nextInt(23) == 0);
/*     */       
/* 231 */       if (this.field_74885_f == 2 || this.field_74885_f == 0) {
/* 232 */         this.field_74955_d = p_i2035_3_.func_78880_d() / 5;
/*     */       } else {
/* 234 */         this.field_74955_d = p_i2035_3_.func_78883_b() / 5;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public static StructureBoundingBox func_74954_a(List p_74954_0_, Random p_74954_1_, int p_74954_2_, int p_74954_3_, int p_74954_4_, int p_74954_5_) {
/* 240 */       StructureBoundingBox structureBoundingBox = new StructureBoundingBox(p_74954_2_, p_74954_3_, p_74954_4_, p_74954_2_, p_74954_3_ + 2, p_74954_4_);
/*     */       
/* 242 */       int i = p_74954_1_.nextInt(3) + 2;
/* 243 */       while (i > 0) {
/* 244 */         int j = i * 5;
/*     */         
/* 246 */         switch (p_74954_5_) {
/*     */           case 2:
/* 248 */             structureBoundingBox.field_78893_d = p_74954_2_ + 2;
/* 249 */             structureBoundingBox.field_78896_c = p_74954_4_ - j - 1;
/*     */             break;
/*     */           case 0:
/* 252 */             structureBoundingBox.field_78893_d = p_74954_2_ + 2;
/* 253 */             structureBoundingBox.field_78892_f = p_74954_4_ + j - 1;
/*     */             break;
/*     */           case 1:
/* 256 */             structureBoundingBox.field_78897_a = p_74954_2_ - j - 1;
/* 257 */             structureBoundingBox.field_78892_f = p_74954_4_ + 2;
/*     */             break;
/*     */           case 3:
/* 260 */             structureBoundingBox.field_78893_d = p_74954_2_ + j - 1;
/* 261 */             structureBoundingBox.field_78892_f = p_74954_4_ + 2;
/*     */             break;
/*     */         } 
/*     */         
/* 265 */         if (StructureComponent.func_74883_a(p_74954_0_, structureBoundingBox) != null) {
/* 266 */           i--;
/*     */         }
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 272 */       if (i > 0) {
/* 273 */         return structureBoundingBox;
/*     */       }
/*     */       
/* 276 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_) {
/* 281 */       int i = func_74877_c();
/* 282 */       int j = p_74861_3_.nextInt(4);
/* 283 */       switch (this.field_74885_f) {
/*     */         case 2:
/* 285 */           if (j <= 1) {
/* 286 */             StructureMineshaftPieces.func_78817_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a, this.field_74887_e.field_78895_b - 1 + p_74861_3_.nextInt(3), this.field_74887_e.field_78896_c - 1, this.field_74885_f, i); break;
/* 287 */           }  if (j == 2) {
/* 288 */             StructureMineshaftPieces.func_78817_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a - 1, this.field_74887_e.field_78895_b - 1 + p_74861_3_.nextInt(3), this.field_74887_e.field_78896_c, 1, i); break;
/*     */           } 
/* 290 */           StructureMineshaftPieces.func_78817_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78893_d + 1, this.field_74887_e.field_78895_b - 1 + p_74861_3_.nextInt(3), this.field_74887_e.field_78896_c, 3, i);
/*     */           break;
/*     */         
/*     */         case 0:
/* 294 */           if (j <= 1) {
/* 295 */             StructureMineshaftPieces.func_78817_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a, this.field_74887_e.field_78895_b - 1 + p_74861_3_.nextInt(3), this.field_74887_e.field_78892_f + 1, this.field_74885_f, i); break;
/* 296 */           }  if (j == 2) {
/* 297 */             StructureMineshaftPieces.func_78817_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a - 1, this.field_74887_e.field_78895_b - 1 + p_74861_3_.nextInt(3), this.field_74887_e.field_78892_f - 3, 1, i); break;
/*     */           } 
/* 299 */           StructureMineshaftPieces.func_78817_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78893_d + 1, this.field_74887_e.field_78895_b - 1 + p_74861_3_.nextInt(3), this.field_74887_e.field_78892_f - 3, 3, i);
/*     */           break;
/*     */         
/*     */         case 1:
/* 303 */           if (j <= 1) {
/* 304 */             StructureMineshaftPieces.func_78817_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a - 1, this.field_74887_e.field_78895_b - 1 + p_74861_3_.nextInt(3), this.field_74887_e.field_78896_c, this.field_74885_f, i); break;
/* 305 */           }  if (j == 2) {
/* 306 */             StructureMineshaftPieces.func_78817_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a, this.field_74887_e.field_78895_b - 1 + p_74861_3_.nextInt(3), this.field_74887_e.field_78896_c - 1, 2, i); break;
/*     */           } 
/* 308 */           StructureMineshaftPieces.func_78817_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a, this.field_74887_e.field_78895_b - 1 + p_74861_3_.nextInt(3), this.field_74887_e.field_78892_f + 1, 0, i);
/*     */           break;
/*     */         
/*     */         case 3:
/* 312 */           if (j <= 1) {
/* 313 */             StructureMineshaftPieces.func_78817_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78893_d + 1, this.field_74887_e.field_78895_b - 1 + p_74861_3_.nextInt(3), this.field_74887_e.field_78896_c, this.field_74885_f, i); break;
/* 314 */           }  if (j == 2) {
/* 315 */             StructureMineshaftPieces.func_78817_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78893_d - 3, this.field_74887_e.field_78895_b - 1 + p_74861_3_.nextInt(3), this.field_74887_e.field_78896_c - 1, 2, i); break;
/*     */           } 
/* 317 */           StructureMineshaftPieces.func_78817_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78893_d - 3, this.field_74887_e.field_78895_b - 1 + p_74861_3_.nextInt(3), this.field_74887_e.field_78892_f + 1, 0, i);
/*     */           break;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 323 */       if (i < 8) {
/* 324 */         if (this.field_74885_f == 2 || this.field_74885_f == 0) {
/* 325 */           for (int k = this.field_74887_e.field_78896_c + 3; k + 3 <= this.field_74887_e.field_78892_f; k += 5) {
/* 326 */             int m = p_74861_3_.nextInt(5);
/* 327 */             if (m == 0) {
/* 328 */               StructureMineshaftPieces.func_78817_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a - 1, this.field_74887_e.field_78895_b, k, 1, i + 1);
/* 329 */             } else if (m == 1) {
/* 330 */               StructureMineshaftPieces.func_78817_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78893_d + 1, this.field_74887_e.field_78895_b, k, 3, i + 1);
/*     */             } 
/*     */           } 
/*     */         } else {
/* 334 */           for (int k = this.field_74887_e.field_78897_a + 3; k + 3 <= this.field_74887_e.field_78893_d; k += 5) {
/* 335 */             int m = p_74861_3_.nextInt(5);
/* 336 */             if (m == 0) {
/* 337 */               StructureMineshaftPieces.func_78817_b(p_74861_1_, p_74861_2_, p_74861_3_, k, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c - 1, 2, i + 1);
/* 338 */             } else if (m == 1) {
/* 339 */               StructureMineshaftPieces.func_78817_b(p_74861_1_, p_74861_2_, p_74861_3_, k, this.field_74887_e.field_78895_b, this.field_74887_e.field_78892_f + 1, 0, i + 1);
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     protected boolean func_74879_a(World p_74879_1_, StructureBoundingBox p_74879_2_, Random p_74879_3_, int p_74879_4_, int p_74879_5_, int p_74879_6_, WeightedRandomChestContent[] p_74879_7_, int p_74879_8_) {
/* 348 */       int i = func_74865_a(p_74879_4_, p_74879_6_);
/* 349 */       int j = func_74862_a(p_74879_5_);
/* 350 */       int k = func_74873_b(p_74879_4_, p_74879_6_);
/*     */       
/* 352 */       if (p_74879_2_.func_78890_b(i, j, k) && 
/* 353 */         p_74879_1_.func_147439_a(i, j, k).func_149688_o() == Material.field_151579_a) {
/* 354 */         boolean bool = p_74879_3_.nextBoolean() ? true : false;
/* 355 */         p_74879_1_.func_147465_d(i, j, k, Blocks.field_150448_aq, func_151555_a(Blocks.field_150448_aq, bool), 2);
/* 356 */         EntityMinecartChest entityMinecartChest = new EntityMinecartChest(p_74879_1_, (i + 0.5F), (j + 0.5F), (k + 0.5F));
/* 357 */         WeightedRandomChestContent.func_76293_a(p_74879_3_, p_74879_7_, (IInventory)entityMinecartChest, p_74879_8_);
/* 358 */         p_74879_1_.func_72838_d((Entity)entityMinecartChest);
/* 359 */         return true;
/*     */       } 
/*     */ 
/*     */       
/* 363 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
/* 369 */       if (func_74860_a(p_74875_1_, p_74875_3_)) {
/* 370 */         return false;
/*     */       }
/*     */       
/* 373 */       boolean bool1 = false;
/* 374 */       byte b1 = 2;
/* 375 */       boolean bool2 = false;
/* 376 */       byte b2 = 2;
/* 377 */       int i = this.field_74955_d * 5 - 1;
/*     */ 
/*     */       
/* 380 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 0, 0, 2, 1, i, Blocks.field_150350_a, Blocks.field_150350_a, false);
/* 381 */       func_151551_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.8F, 0, 2, 0, 2, 2, i, Blocks.field_150350_a, Blocks.field_150350_a, false);
/*     */       
/* 383 */       if (this.field_74956_b) {
/* 384 */         func_151551_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.6F, 0, 0, 0, 2, 1, i, Blocks.field_150321_G, Blocks.field_150350_a, false);
/*     */       }
/*     */       
/*     */       byte b3;
/* 388 */       for (b3 = 0; b3 < this.field_74955_d; b3++) {
/*     */         
/* 390 */         int j = 2 + b3 * 5;
/*     */         
/* 392 */         func_151549_a(p_74875_1_, p_74875_3_, 0, 0, j, 0, 1, j, Blocks.field_150422_aJ, Blocks.field_150350_a, false);
/* 393 */         func_151549_a(p_74875_1_, p_74875_3_, 2, 0, j, 2, 1, j, Blocks.field_150422_aJ, Blocks.field_150350_a, false);
/* 394 */         if (p_74875_2_.nextInt(4) == 0) {
/* 395 */           func_151549_a(p_74875_1_, p_74875_3_, 0, 2, j, 0, 2, j, Blocks.field_150344_f, Blocks.field_150350_a, false);
/* 396 */           func_151549_a(p_74875_1_, p_74875_3_, 2, 2, j, 2, 2, j, Blocks.field_150344_f, Blocks.field_150350_a, false);
/*     */         } else {
/* 398 */           func_151549_a(p_74875_1_, p_74875_3_, 0, 2, j, 2, 2, j, Blocks.field_150344_f, Blocks.field_150350_a, false);
/*     */         } 
/* 400 */         func_151552_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.1F, 0, 2, j - 1, Blocks.field_150321_G, 0);
/* 401 */         func_151552_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.1F, 2, 2, j - 1, Blocks.field_150321_G, 0);
/* 402 */         func_151552_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.1F, 0, 2, j + 1, Blocks.field_150321_G, 0);
/* 403 */         func_151552_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.1F, 2, 2, j + 1, Blocks.field_150321_G, 0);
/* 404 */         func_151552_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.05F, 0, 2, j - 2, Blocks.field_150321_G, 0);
/* 405 */         func_151552_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.05F, 2, 2, j - 2, Blocks.field_150321_G, 0);
/* 406 */         func_151552_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.05F, 0, 2, j + 2, Blocks.field_150321_G, 0);
/* 407 */         func_151552_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.05F, 2, 2, j + 2, Blocks.field_150321_G, 0);
/*     */         
/* 409 */         func_151552_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.05F, 1, 2, j - 1, Blocks.field_150478_aa, 0);
/* 410 */         func_151552_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.05F, 1, 2, j + 1, Blocks.field_150478_aa, 0);
/*     */         
/* 412 */         if (p_74875_2_.nextInt(100) == 0) {
/* 413 */           func_74879_a(p_74875_1_, p_74875_3_, p_74875_2_, 2, 0, j - 1, WeightedRandomChestContent.func_92080_a(StructureMineshaftPieces.field_78818_a, new WeightedRandomChestContent[] { Items.field_151134_bR.func_92114_b(p_74875_2_) }), 3 + p_74875_2_.nextInt(4));
/*     */         }
/* 415 */         if (p_74875_2_.nextInt(100) == 0) {
/* 416 */           func_74879_a(p_74875_1_, p_74875_3_, p_74875_2_, 0, 0, j + 1, WeightedRandomChestContent.func_92080_a(StructureMineshaftPieces.field_78818_a, new WeightedRandomChestContent[] { Items.field_151134_bR.func_92114_b(p_74875_2_) }), 3 + p_74875_2_.nextInt(4));
/*     */         }
/* 418 */         if (this.field_74956_b && !this.field_74957_c) {
/* 419 */           int k = func_74862_a(0), m = j - 1 + p_74875_2_.nextInt(3);
/* 420 */           int n = func_74865_a(1, m);
/* 421 */           m = func_74873_b(1, m);
/* 422 */           if (p_74875_3_.func_78890_b(n, k, m)) {
/* 423 */             this.field_74957_c = true;
/* 424 */             p_74875_1_.func_147465_d(n, k, m, Blocks.field_150474_ac, 0, 2);
/* 425 */             TileEntityMobSpawner tileEntityMobSpawner = (TileEntityMobSpawner)p_74875_1_.func_147438_o(n, k, m);
/* 426 */             if (tileEntityMobSpawner != null) tileEntityMobSpawner.func_145881_a().func_98272_a("CaveSpider");
/*     */           
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 432 */       for (b3 = 0; b3 <= 2; b3++) {
/* 433 */         for (byte b = 0; b <= i; b++) {
/* 434 */           byte b4 = -1;
/* 435 */           Block block = func_151548_a(p_74875_1_, b3, b4, b, p_74875_3_);
/* 436 */           if (block.func_149688_o() == Material.field_151579_a) {
/* 437 */             byte b5 = -1;
/* 438 */             func_151550_a(p_74875_1_, Blocks.field_150344_f, 0, b3, b5, b, p_74875_3_);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 443 */       if (this.field_74958_a) {
/* 444 */         for (b3 = 0; b3 <= i; b3++) {
/* 445 */           Block block = func_151548_a(p_74875_1_, 1, -1, b3, p_74875_3_);
/* 446 */           if (block.func_149688_o() != Material.field_151579_a && block.func_149730_j()) {
/* 447 */             func_151552_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.7F, 1, 0, b3, Blocks.field_150448_aq, func_151555_a(Blocks.field_150448_aq, 0));
/*     */           }
/*     */         } 
/*     */       }
/*     */       
/* 452 */       return true;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Cross
/*     */     extends StructureComponent
/*     */   {
/*     */     private int field_74953_a;
/*     */     
/*     */     private boolean field_74952_b;
/*     */     
/*     */     private static final String __OBFID = "CL_00000446";
/*     */ 
/*     */     
/*     */     public Cross() {}
/*     */     
/*     */     protected void func_143012_a(NBTTagCompound p_143012_1_) {
/* 470 */       p_143012_1_.func_74757_a("tf", this.field_74952_b);
/* 471 */       p_143012_1_.func_74768_a("D", this.field_74953_a);
/*     */     }
/*     */ 
/*     */     
/*     */     protected void func_143011_b(NBTTagCompound p_143011_1_) {
/* 476 */       this.field_74952_b = p_143011_1_.func_74767_n("tf");
/* 477 */       this.field_74953_a = p_143011_1_.func_74762_e("D");
/*     */     }
/*     */     
/*     */     public Cross(int p_i2036_1_, Random p_i2036_2_, StructureBoundingBox p_i2036_3_, int p_i2036_4_) {
/* 481 */       super(p_i2036_1_);
/* 482 */       this.field_74953_a = p_i2036_4_;
/* 483 */       this.field_74887_e = p_i2036_3_;
/* 484 */       this.field_74952_b = (p_i2036_3_.func_78882_c() > 3);
/*     */     }
/*     */ 
/*     */     
/*     */     public static StructureBoundingBox func_74951_a(List p_74951_0_, Random p_74951_1_, int p_74951_2_, int p_74951_3_, int p_74951_4_, int p_74951_5_) {
/* 489 */       StructureBoundingBox structureBoundingBox = new StructureBoundingBox(p_74951_2_, p_74951_3_, p_74951_4_, p_74951_2_, p_74951_3_ + 2, p_74951_4_);
/*     */       
/* 491 */       if (p_74951_1_.nextInt(4) == 0) {
/* 492 */         structureBoundingBox.field_78894_e += 4;
/*     */       }
/*     */       
/* 495 */       switch (p_74951_5_) {
/*     */         case 2:
/* 497 */           structureBoundingBox.field_78897_a = p_74951_2_ - 1;
/* 498 */           structureBoundingBox.field_78893_d = p_74951_2_ + 3;
/* 499 */           structureBoundingBox.field_78896_c = p_74951_4_ - 4;
/*     */           break;
/*     */         case 0:
/* 502 */           structureBoundingBox.field_78897_a = p_74951_2_ - 1;
/* 503 */           structureBoundingBox.field_78893_d = p_74951_2_ + 3;
/* 504 */           structureBoundingBox.field_78892_f = p_74951_4_ + 4;
/*     */           break;
/*     */         case 1:
/* 507 */           structureBoundingBox.field_78897_a = p_74951_2_ - 4;
/* 508 */           structureBoundingBox.field_78896_c = p_74951_4_ - 1;
/* 509 */           structureBoundingBox.field_78892_f = p_74951_4_ + 3;
/*     */           break;
/*     */         case 3:
/* 512 */           structureBoundingBox.field_78893_d = p_74951_2_ + 4;
/* 513 */           structureBoundingBox.field_78896_c = p_74951_4_ - 1;
/* 514 */           structureBoundingBox.field_78892_f = p_74951_4_ + 3;
/*     */           break;
/*     */       } 
/*     */       
/* 518 */       if (StructureComponent.func_74883_a(p_74951_0_, structureBoundingBox) != null) {
/* 519 */         return null;
/*     */       }
/*     */       
/* 522 */       return structureBoundingBox;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_) {
/* 528 */       int i = func_74877_c();
/*     */ 
/*     */       
/* 531 */       switch (this.field_74953_a) {
/*     */         case 2:
/* 533 */           StructureMineshaftPieces.func_78817_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a + 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c - 1, 2, i);
/* 534 */           StructureMineshaftPieces.func_78817_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a - 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c + 1, 1, i);
/* 535 */           StructureMineshaftPieces.func_78817_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78893_d + 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c + 1, 3, i);
/*     */           break;
/*     */         case 0:
/* 538 */           StructureMineshaftPieces.func_78817_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a + 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78892_f + 1, 0, i);
/* 539 */           StructureMineshaftPieces.func_78817_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a - 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c + 1, 1, i);
/* 540 */           StructureMineshaftPieces.func_78817_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78893_d + 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c + 1, 3, i);
/*     */           break;
/*     */         case 1:
/* 543 */           StructureMineshaftPieces.func_78817_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a + 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c - 1, 2, i);
/* 544 */           StructureMineshaftPieces.func_78817_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a + 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78892_f + 1, 0, i);
/* 545 */           StructureMineshaftPieces.func_78817_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a - 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c + 1, 1, i);
/*     */           break;
/*     */         case 3:
/* 548 */           StructureMineshaftPieces.func_78817_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a + 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c - 1, 2, i);
/* 549 */           StructureMineshaftPieces.func_78817_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a + 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78892_f + 1, 0, i);
/* 550 */           StructureMineshaftPieces.func_78817_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78893_d + 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c + 1, 3, i);
/*     */           break;
/*     */       } 
/*     */       
/* 554 */       if (this.field_74952_b) {
/* 555 */         if (p_74861_3_.nextBoolean()) StructureMineshaftPieces.func_78817_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a + 1, this.field_74887_e.field_78895_b + 3 + 1, this.field_74887_e.field_78896_c - 1, 2, i); 
/* 556 */         if (p_74861_3_.nextBoolean()) StructureMineshaftPieces.func_78817_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a - 1, this.field_74887_e.field_78895_b + 3 + 1, this.field_74887_e.field_78896_c + 1, 1, i); 
/* 557 */         if (p_74861_3_.nextBoolean()) StructureMineshaftPieces.func_78817_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78893_d + 1, this.field_74887_e.field_78895_b + 3 + 1, this.field_74887_e.field_78896_c + 1, 3, i); 
/* 558 */         if (p_74861_3_.nextBoolean()) StructureMineshaftPieces.func_78817_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a + 1, this.field_74887_e.field_78895_b + 3 + 1, this.field_74887_e.field_78892_f + 1, 0, i);
/*     */       
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
/* 565 */       if (func_74860_a(p_74875_1_, p_74875_3_)) {
/* 566 */         return false;
/*     */       }
/*     */ 
/*     */       
/* 570 */       if (this.field_74952_b) {
/* 571 */         func_151549_a(p_74875_1_, p_74875_3_, this.field_74887_e.field_78897_a + 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c, this.field_74887_e.field_78893_d - 1, this.field_74887_e.field_78895_b + 3 - 1, this.field_74887_e.field_78892_f, Blocks.field_150350_a, Blocks.field_150350_a, false);
/*     */         
/* 573 */         func_151549_a(p_74875_1_, p_74875_3_, this.field_74887_e.field_78897_a, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c + 1, this.field_74887_e.field_78893_d, this.field_74887_e.field_78895_b + 3 - 1, this.field_74887_e.field_78892_f - 1, Blocks.field_150350_a, Blocks.field_150350_a, false);
/*     */         
/* 575 */         func_151549_a(p_74875_1_, p_74875_3_, this.field_74887_e.field_78897_a + 1, this.field_74887_e.field_78894_e - 2, this.field_74887_e.field_78896_c, this.field_74887_e.field_78893_d - 1, this.field_74887_e.field_78894_e, this.field_74887_e.field_78892_f, Blocks.field_150350_a, Blocks.field_150350_a, false);
/*     */         
/* 577 */         func_151549_a(p_74875_1_, p_74875_3_, this.field_74887_e.field_78897_a, this.field_74887_e.field_78894_e - 2, this.field_74887_e.field_78896_c + 1, this.field_74887_e.field_78893_d, this.field_74887_e.field_78894_e, this.field_74887_e.field_78892_f - 1, Blocks.field_150350_a, Blocks.field_150350_a, false);
/*     */         
/* 579 */         func_151549_a(p_74875_1_, p_74875_3_, this.field_74887_e.field_78897_a + 1, this.field_74887_e.field_78895_b + 3, this.field_74887_e.field_78896_c + 1, this.field_74887_e.field_78893_d - 1, this.field_74887_e.field_78895_b + 3, this.field_74887_e.field_78892_f - 1, Blocks.field_150350_a, Blocks.field_150350_a, false);
/*     */       } else {
/*     */         
/* 582 */         func_151549_a(p_74875_1_, p_74875_3_, this.field_74887_e.field_78897_a + 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c, this.field_74887_e.field_78893_d - 1, this.field_74887_e.field_78894_e, this.field_74887_e.field_78892_f, Blocks.field_150350_a, Blocks.field_150350_a, false);
/* 583 */         func_151549_a(p_74875_1_, p_74875_3_, this.field_74887_e.field_78897_a, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c + 1, this.field_74887_e.field_78893_d, this.field_74887_e.field_78894_e, this.field_74887_e.field_78892_f - 1, Blocks.field_150350_a, Blocks.field_150350_a, false);
/*     */       } 
/*     */ 
/*     */       
/* 587 */       func_151549_a(p_74875_1_, p_74875_3_, this.field_74887_e.field_78897_a + 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c + 1, this.field_74887_e.field_78897_a + 1, this.field_74887_e.field_78894_e, this.field_74887_e.field_78896_c + 1, Blocks.field_150344_f, Blocks.field_150350_a, false);
/* 588 */       func_151549_a(p_74875_1_, p_74875_3_, this.field_74887_e.field_78897_a + 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78892_f - 1, this.field_74887_e.field_78897_a + 1, this.field_74887_e.field_78894_e, this.field_74887_e.field_78892_f - 1, Blocks.field_150344_f, Blocks.field_150350_a, false);
/* 589 */       func_151549_a(p_74875_1_, p_74875_3_, this.field_74887_e.field_78893_d - 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c + 1, this.field_74887_e.field_78893_d - 1, this.field_74887_e.field_78894_e, this.field_74887_e.field_78896_c + 1, Blocks.field_150344_f, Blocks.field_150350_a, false);
/* 590 */       func_151549_a(p_74875_1_, p_74875_3_, this.field_74887_e.field_78893_d - 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78892_f - 1, this.field_74887_e.field_78893_d - 1, this.field_74887_e.field_78894_e, this.field_74887_e.field_78892_f - 1, Blocks.field_150344_f, Blocks.field_150350_a, false);
/*     */ 
/*     */ 
/*     */       
/* 594 */       for (int i = this.field_74887_e.field_78897_a; i <= this.field_74887_e.field_78893_d; i++) {
/* 595 */         for (int j = this.field_74887_e.field_78896_c; j <= this.field_74887_e.field_78892_f; j++) {
/* 596 */           if (func_151548_a(p_74875_1_, i, this.field_74887_e.field_78895_b - 1, j, p_74875_3_).func_149688_o() == Material.field_151579_a) {
/* 597 */             func_151550_a(p_74875_1_, Blocks.field_150344_f, 0, i, this.field_74887_e.field_78895_b - 1, j, p_74875_3_);
/*     */           }
/*     */         } 
/*     */       } 
/*     */       
/* 602 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Stairs
/*     */     extends StructureComponent
/*     */   {
/*     */     private static final String __OBFID = "CL_00000449";
/*     */     
/*     */     public Stairs() {}
/*     */     
/*     */     public Stairs(int p_i2038_1_, Random p_i2038_2_, StructureBoundingBox p_i2038_3_, int p_i2038_4_) {
/* 614 */       super(p_i2038_1_);
/* 615 */       this.field_74885_f = p_i2038_4_;
/* 616 */       this.field_74887_e = p_i2038_3_;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected void func_143012_a(NBTTagCompound p_143012_1_) {}
/*     */ 
/*     */ 
/*     */     
/*     */     protected void func_143011_b(NBTTagCompound p_143011_1_) {}
/*     */ 
/*     */ 
/*     */     
/*     */     public static StructureBoundingBox func_74950_a(List p_74950_0_, Random p_74950_1_, int p_74950_2_, int p_74950_3_, int p_74950_4_, int p_74950_5_) {
/* 631 */       StructureBoundingBox structureBoundingBox = new StructureBoundingBox(p_74950_2_, p_74950_3_ - 5, p_74950_4_, p_74950_2_, p_74950_3_ + 2, p_74950_4_);
/*     */       
/* 633 */       switch (p_74950_5_) {
/*     */         case 2:
/* 635 */           structureBoundingBox.field_78893_d = p_74950_2_ + 2;
/* 636 */           structureBoundingBox.field_78896_c = p_74950_4_ - 8;
/*     */           break;
/*     */         case 0:
/* 639 */           structureBoundingBox.field_78893_d = p_74950_2_ + 2;
/* 640 */           structureBoundingBox.field_78892_f = p_74950_4_ + 8;
/*     */           break;
/*     */         case 1:
/* 643 */           structureBoundingBox.field_78897_a = p_74950_2_ - 8;
/* 644 */           structureBoundingBox.field_78892_f = p_74950_4_ + 2;
/*     */           break;
/*     */         case 3:
/* 647 */           structureBoundingBox.field_78893_d = p_74950_2_ + 8;
/* 648 */           structureBoundingBox.field_78892_f = p_74950_4_ + 2;
/*     */           break;
/*     */       } 
/*     */       
/* 652 */       if (StructureComponent.func_74883_a(p_74950_0_, structureBoundingBox) != null) {
/* 653 */         return null;
/*     */       }
/*     */       
/* 656 */       return structureBoundingBox;
/*     */     }
/*     */ 
/*     */     
/*     */     public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_) {
/* 661 */       int i = func_74877_c();
/*     */ 
/*     */       
/* 664 */       switch (this.field_74885_f) {
/*     */         case 2:
/* 666 */           StructureMineshaftPieces.func_78817_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c - 1, 2, i);
/*     */           break;
/*     */         case 0:
/* 669 */           StructureMineshaftPieces.func_78817_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a, this.field_74887_e.field_78895_b, this.field_74887_e.field_78892_f + 1, 0, i);
/*     */           break;
/*     */         case 1:
/* 672 */           StructureMineshaftPieces.func_78817_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a - 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c, 1, i);
/*     */           break;
/*     */         case 3:
/* 675 */           StructureMineshaftPieces.func_78817_b(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78893_d + 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c, 3, i);
/*     */           break;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
/* 684 */       if (func_74860_a(p_74875_1_, p_74875_3_)) {
/* 685 */         return false;
/*     */       }
/*     */ 
/*     */       
/* 689 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 5, 0, 2, 7, 1, Blocks.field_150350_a, Blocks.field_150350_a, false);
/*     */       
/* 691 */       func_151549_a(p_74875_1_, p_74875_3_, 0, 0, 7, 2, 2, 8, Blocks.field_150350_a, Blocks.field_150350_a, false);
/*     */       
/* 693 */       for (byte b = 0; b < 5; b++) {
/* 694 */         func_151549_a(p_74875_1_, p_74875_3_, 0, 5 - b - ((b < 4) ? 1 : 0), 2 + b, 2, 7 - b, 2 + b, Blocks.field_150350_a, Blocks.field_150350_a, false);
/*     */       }
/*     */       
/* 697 */       return true;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 703 */   public static final WeightedRandomChestContent[] field_78818_a = new WeightedRandomChestContent[] { new WeightedRandomChestContent(Items.field_151042_j, 0, 1, 5, 10), new WeightedRandomChestContent(Items.field_151043_k, 0, 1, 3, 5), new WeightedRandomChestContent(Items.field_151137_ax, 0, 4, 9, 5), new WeightedRandomChestContent(Items.field_151100_aR, 4, 4, 9, 5), new WeightedRandomChestContent(Items.field_151045_i, 0, 1, 2, 3), new WeightedRandomChestContent(Items.field_151044_h, 0, 3, 8, 10), new WeightedRandomChestContent(Items.field_151025_P, 0, 1, 3, 15), new WeightedRandomChestContent(Items.field_151035_b, 0, 1, 1, 1), new WeightedRandomChestContent(Item.func_150898_a(Blocks.field_150448_aq), 0, 4, 8, 1), new WeightedRandomChestContent(Items.field_151081_bc, 0, 2, 4, 10), new WeightedRandomChestContent(Items.field_151080_bb, 0, 2, 4, 10), new WeightedRandomChestContent(Items.field_151141_av, 0, 1, 1, 3), new WeightedRandomChestContent(Items.field_151138_bX, 0, 1, 1, 1) };
/*     */   private static final String __OBFID = "CL_00000444";
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\structure\StructureMineshaftPieces.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */