/*     */ package net.minecraft.village;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.BlockDoor;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.util.ChunkCoordinates;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.WorldSavedData;
/*     */ 
/*     */ public class VillageCollection extends WorldSavedData {
/*  17 */   private final List field_75554_b = new ArrayList(); private World field_75556_a;
/*  18 */   private final List field_75555_c = new ArrayList();
/*  19 */   private final List field_75552_d = new ArrayList(); private int field_75553_e;
/*     */   private static final String __OBFID = "CL_00001635";
/*     */   
/*     */   public VillageCollection(String p_i1677_1_) {
/*  23 */     super(p_i1677_1_);
/*     */   }
/*     */   
/*     */   public VillageCollection(World p_i1678_1_) {
/*  27 */     super("villages");
/*  28 */     this.field_75556_a = p_i1678_1_;
/*  29 */     func_76185_a();
/*     */   }
/*     */   
/*     */   public void func_82566_a(World p_82566_1_) {
/*  33 */     this.field_75556_a = p_82566_1_;
/*     */     
/*  35 */     for (Village village : this.field_75552_d) {
/*  36 */       village.func_82691_a(p_82566_1_);
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_75551_a(int p_75551_1_, int p_75551_2_, int p_75551_3_) {
/*  41 */     if (this.field_75554_b.size() > 64)
/*  42 */       return;  if (!func_75548_d(p_75551_1_, p_75551_2_, p_75551_3_)) this.field_75554_b.add(new ChunkCoordinates(p_75551_1_, p_75551_2_, p_75551_3_)); 
/*     */   }
/*     */   
/*     */   public void func_75544_a() {
/*  46 */     this.field_75553_e++;
/*  47 */     for (Village village : this.field_75552_d)
/*  48 */       village.func_75560_a(this.field_75553_e); 
/*  49 */     func_75549_c();
/*  50 */     func_75543_d();
/*  51 */     func_75545_e();
/*     */     
/*  53 */     if (this.field_75553_e % 400 == 0) {
/*  54 */       func_76185_a();
/*     */     }
/*     */   }
/*     */   
/*     */   private void func_75549_c() {
/*  59 */     for (Iterator<Village> iterator = this.field_75552_d.iterator(); iterator.hasNext(); ) {
/*  60 */       Village village = iterator.next();
/*  61 */       if (village.func_75566_g()) {
/*  62 */         iterator.remove();
/*  63 */         func_76185_a();
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public List func_75540_b() {
/*  69 */     return this.field_75552_d;
/*     */   }
/*     */   
/*     */   public Village func_75550_a(int p_75550_1_, int p_75550_2_, int p_75550_3_, int p_75550_4_) {
/*  73 */     Village village = null;
/*  74 */     float f = Float.MAX_VALUE;
/*  75 */     for (Village village1 : this.field_75552_d) {
/*     */       
/*  77 */       float f1 = village1.func_75577_a().func_71569_e(p_75550_1_, p_75550_2_, p_75550_3_);
/*  78 */       if (f1 >= f)
/*     */         continue; 
/*  80 */       float f2 = (p_75550_4_ + village1.func_75568_b());
/*  81 */       if (f1 > f2 * f2)
/*     */         continue; 
/*  83 */       village = village1;
/*  84 */       f = f1;
/*     */     } 
/*  86 */     return village;
/*     */   }
/*     */   
/*     */   private void func_75543_d() {
/*  90 */     if (this.field_75554_b.isEmpty())
/*  91 */       return;  func_75546_a(this.field_75554_b.remove(0));
/*     */   }
/*     */ 
/*     */   
/*     */   private void func_75545_e() {
/*  96 */     for (byte b = 0; b < this.field_75555_c.size(); b++) {
/*  97 */       VillageDoorInfo villageDoorInfo = this.field_75555_c.get(b);
/*  98 */       boolean bool = false;
/*  99 */       for (Village village : this.field_75552_d) {
/* 100 */         int i = (int)village.func_75577_a().func_71569_e(villageDoorInfo.field_75481_a, villageDoorInfo.field_75479_b, villageDoorInfo.field_75480_c);
/* 101 */         int j = 32 + village.func_75568_b();
/* 102 */         if (i > j * j)
/* 103 */           continue;  village.func_75576_a(villageDoorInfo);
/* 104 */         bool = true;
/*     */       } 
/*     */       
/* 107 */       if (!bool) {
/*     */ 
/*     */         
/* 110 */         Village village = new Village(this.field_75556_a);
/* 111 */         village.func_75576_a(villageDoorInfo);
/* 112 */         this.field_75552_d.add(village);
/* 113 */         func_76185_a();
/*     */       } 
/* 115 */     }  this.field_75555_c.clear();
/*     */   }
/*     */   
/*     */   private void func_75546_a(ChunkCoordinates p_75546_1_) {
/* 119 */     byte b1 = 16, b2 = 4, b3 = 16;
/* 120 */     for (int i = p_75546_1_.field_71574_a - b1; i < p_75546_1_.field_71574_a + b1; i++) {
/* 121 */       for (int j = p_75546_1_.field_71572_b - b2; j < p_75546_1_.field_71572_b + b2; j++) {
/* 122 */         for (int k = p_75546_1_.field_71573_c - b3; k < p_75546_1_.field_71573_c + b3; k++) {
/* 123 */           if (func_75541_e(i, j, k)) {
/*     */             
/* 125 */             VillageDoorInfo villageDoorInfo = func_75547_b(i, j, k);
/* 126 */             if (villageDoorInfo == null) { func_75542_c(i, j, k); }
/* 127 */             else { villageDoorInfo.field_75475_f = this.field_75553_e; }
/*     */           
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   private VillageDoorInfo func_75547_b(int p_75547_1_, int p_75547_2_, int p_75547_3_) {
/* 135 */     for (VillageDoorInfo villageDoorInfo : this.field_75555_c) {
/* 136 */       if (villageDoorInfo.field_75481_a == p_75547_1_ && villageDoorInfo.field_75480_c == p_75547_3_ && Math.abs(villageDoorInfo.field_75479_b - p_75547_2_) <= 1) return villageDoorInfo; 
/* 137 */     }  for (Village village : this.field_75552_d) {
/* 138 */       VillageDoorInfo villageDoorInfo = village.func_75578_e(p_75547_1_, p_75547_2_, p_75547_3_);
/* 139 */       if (villageDoorInfo != null) return villageDoorInfo; 
/*     */     } 
/* 141 */     return null;
/*     */   }
/*     */   
/*     */   private void func_75542_c(int p_75542_1_, int p_75542_2_, int p_75542_3_) {
/* 145 */     int i = ((BlockDoor)Blocks.field_150466_ao).func_150013_e((IBlockAccess)this.field_75556_a, p_75542_1_, p_75542_2_, p_75542_3_);
/* 146 */     if (i == 0 || i == 2) {
/* 147 */       byte b = 0; byte b1;
/* 148 */       for (b1 = -5; b1 < 0; b1++) {
/* 149 */         if (this.field_75556_a.func_72937_j(p_75542_1_ + b1, p_75542_2_, p_75542_3_)) b--; 
/* 150 */       }  for (b1 = 1; b1 <= 5; b1++) {
/* 151 */         if (this.field_75556_a.func_72937_j(p_75542_1_ + b1, p_75542_2_, p_75542_3_)) b++; 
/* 152 */       }  if (b != 0) this.field_75555_c.add(new VillageDoorInfo(p_75542_1_, p_75542_2_, p_75542_3_, (b > 0) ? -2 : 2, 0, this.field_75553_e)); 
/*     */     } else {
/* 154 */       byte b = 0; byte b1;
/* 155 */       for (b1 = -5; b1 < 0; b1++) {
/* 156 */         if (this.field_75556_a.func_72937_j(p_75542_1_, p_75542_2_, p_75542_3_ + b1)) b--; 
/* 157 */       }  for (b1 = 1; b1 <= 5; b1++) {
/* 158 */         if (this.field_75556_a.func_72937_j(p_75542_1_, p_75542_2_, p_75542_3_ + b1)) b++; 
/* 159 */       }  if (b != 0) this.field_75555_c.add(new VillageDoorInfo(p_75542_1_, p_75542_2_, p_75542_3_, 0, (b > 0) ? -2 : 2, this.field_75553_e)); 
/*     */     } 
/*     */   }
/*     */   
/*     */   private boolean func_75548_d(int p_75548_1_, int p_75548_2_, int p_75548_3_) {
/* 164 */     for (ChunkCoordinates chunkCoordinates : this.field_75554_b) {
/* 165 */       if (chunkCoordinates.field_71574_a == p_75548_1_ && chunkCoordinates.field_71572_b == p_75548_2_ && chunkCoordinates.field_71573_c == p_75548_3_) return true; 
/* 166 */     }  return false;
/*     */   }
/*     */   
/*     */   private boolean func_75541_e(int p_75541_1_, int p_75541_2_, int p_75541_3_) {
/* 170 */     return (this.field_75556_a.func_147439_a(p_75541_1_, p_75541_2_, p_75541_3_) == Blocks.field_150466_ao);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_76184_a(NBTTagCompound p_76184_1_) {
/* 176 */     this.field_75553_e = p_76184_1_.func_74762_e("Tick");
/*     */     
/* 178 */     NBTTagList nBTTagList = p_76184_1_.func_150295_c("Villages", 10);
/* 179 */     for (byte b = 0; b < nBTTagList.func_74745_c(); b++) {
/* 180 */       NBTTagCompound nBTTagCompound = nBTTagList.func_150305_b(b);
/* 181 */       Village village = new Village();
/* 182 */       village.func_82690_a(nBTTagCompound);
/* 183 */       this.field_75552_d.add(village);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_76187_b(NBTTagCompound p_76187_1_) {
/* 190 */     p_76187_1_.func_74768_a("Tick", this.field_75553_e);
/* 191 */     NBTTagList nBTTagList = new NBTTagList();
/* 192 */     for (Village village : this.field_75552_d) {
/* 193 */       NBTTagCompound nBTTagCompound = new NBTTagCompound();
/* 194 */       village.func_82689_b(nBTTagCompound);
/* 195 */       nBTTagList.func_74742_a((NBTBase)nBTTagCompound);
/*     */     } 
/* 197 */     p_76187_1_.func_74782_a("Villages", (NBTBase)nBTTagList);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\village\VillageCollection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */