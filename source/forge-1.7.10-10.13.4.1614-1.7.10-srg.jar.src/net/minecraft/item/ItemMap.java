/*     */ package net.minecraft.item;
/*     */ 
/*     */ import com.google.common.collect.HashMultiset;
/*     */ import com.google.common.collect.Iterables;
/*     */ import com.google.common.collect.Multiset;
/*     */ import com.google.common.collect.Multisets;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.MapColor;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.network.Packet;
/*     */ import net.minecraft.network.play.server.S34PacketMaps;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.WorldSavedData;
/*     */ import net.minecraft.world.chunk.Chunk;
/*     */ import net.minecraft.world.storage.MapData;
/*     */ 
/*     */ public class ItemMap extends ItemMapBase {
/*     */   protected ItemMap() {
/*  26 */     func_77627_a(true);
/*     */   } private static final String __OBFID = "CL_00000047";
/*     */   @SideOnly(Side.CLIENT)
/*     */   public static MapData func_150912_a(int p_150912_0_, World p_150912_1_) {
/*  30 */     String str = "map_" + p_150912_0_;
/*  31 */     MapData mapData = (MapData)p_150912_1_.func_72943_a(MapData.class, str);
/*     */     
/*  33 */     if (mapData == null) {
/*  34 */       mapData = new MapData(str);
/*     */       
/*  36 */       p_150912_1_.func_72823_a(str, (WorldSavedData)mapData);
/*     */     } 
/*     */     
/*  39 */     return mapData;
/*     */   }
/*     */   
/*     */   public MapData func_77873_a(ItemStack p_77873_1_, World p_77873_2_) {
/*  43 */     String str = "map_" + p_77873_1_.func_77960_j();
/*  44 */     MapData mapData = (MapData)p_77873_2_.func_72943_a(MapData.class, str);
/*     */     
/*  46 */     if (mapData == null && !p_77873_2_.field_72995_K) {
/*  47 */       p_77873_1_.func_77964_b(p_77873_2_.func_72841_b("map"));
/*  48 */       str = "map_" + p_77873_1_.func_77960_j();
/*  49 */       mapData = new MapData(str);
/*     */       
/*  51 */       mapData.field_76197_d = 3;
/*  52 */       int i = 128 * (1 << mapData.field_76197_d);
/*  53 */       mapData.field_76201_a = Math.round(p_77873_2_.func_72912_H().func_76079_c() / i) * i;
/*  54 */       mapData.field_76199_b = Math.round((p_77873_2_.func_72912_H().func_76074_e() / i)) * i;
/*  55 */       mapData.field_76200_c = (byte)p_77873_2_.field_73011_w.field_76574_g;
/*     */       
/*  57 */       mapData.func_76185_a();
/*     */       
/*  59 */       p_77873_2_.func_72823_a(str, (WorldSavedData)mapData);
/*     */     } 
/*     */     
/*  62 */     return mapData;
/*     */   }
/*     */   
/*     */   public void func_77872_a(World p_77872_1_, Entity p_77872_2_, MapData p_77872_3_) {
/*  66 */     if (p_77872_1_.field_73011_w.field_76574_g != p_77872_3_.field_76200_c || !(p_77872_2_ instanceof EntityPlayer)) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/*  71 */     int i = 1 << p_77872_3_.field_76197_d;
/*  72 */     int j = p_77872_3_.field_76201_a;
/*  73 */     int k = p_77872_3_.field_76199_b;
/*     */     
/*  75 */     int m = MathHelper.func_76128_c(p_77872_2_.field_70165_t - j) / i + 64;
/*  76 */     int n = MathHelper.func_76128_c(p_77872_2_.field_70161_v - k) / i + 64;
/*  77 */     int i1 = 128 / i;
/*     */     
/*  79 */     if (p_77872_1_.field_73011_w.field_76576_e) {
/*  80 */       i1 /= 2;
/*     */     }
/*     */     
/*  83 */     MapData.MapInfo mapInfo = p_77872_3_.func_82568_a((EntityPlayer)p_77872_2_);
/*  84 */     mapInfo.field_82569_d++;
/*     */     
/*  86 */     for (int i2 = m - i1 + 1; i2 < m + i1; i2++) {
/*  87 */       if ((i2 & 0xF) == (mapInfo.field_82569_d & 0xF)) {
/*     */         
/*  89 */         int i3 = 255;
/*  90 */         int i4 = 0;
/*     */         
/*  92 */         double d = 0.0D;
/*  93 */         for (int i5 = n - i1 - 1; i5 < n + i1; i5++) {
/*  94 */           if (i2 >= 0 && i5 >= -1 && i2 < 128 && i5 < 128) {
/*     */             
/*  96 */             int i6 = i2 - m;
/*  97 */             int i7 = i5 - n;
/*     */             
/*  99 */             boolean bool = (i6 * i6 + i7 * i7 > (i1 - 2) * (i1 - 2)) ? true : false;
/*     */             
/* 101 */             int i8 = (j / i + i2 - 64) * i;
/* 102 */             int i9 = (k / i + i5 - 64) * i;
/*     */             
/* 104 */             HashMultiset hashMultiset = HashMultiset.create();
/*     */             
/* 106 */             Chunk chunk = p_77872_1_.func_72938_d(i8, i9);
/* 107 */             if (!chunk.func_76621_g()) {
/* 108 */               int i10 = i8 & 0xF;
/* 109 */               int i11 = i9 & 0xF;
/* 110 */               int i12 = 0;
/*     */               
/* 112 */               double d1 = 0.0D;
/* 113 */               if (p_77872_1_.field_73011_w.field_76576_e) {
/* 114 */                 int i13 = i8 + i9 * 231871;
/* 115 */                 i13 = i13 * i13 * 31287121 + i13 * 11;
/*     */                 
/* 117 */                 if ((i13 >> 20 & 0x1) == 0) {
/* 118 */                   hashMultiset.add(Blocks.field_150346_d.func_149728_f(0), 10);
/*     */                 } else {
/* 120 */                   hashMultiset.add(Blocks.field_150348_b.func_149728_f(0), 100);
/*     */                 } 
/*     */                 
/* 123 */                 d1 = 100.0D;
/*     */               } else {
/* 125 */                 for (byte b1 = 0; b1 < i; b1++) {
/* 126 */                   for (byte b2 = 0; b2 < i; b2++) {
/* 127 */                     int i13 = chunk.func_76611_b(b1 + i10, b2 + i11) + 1;
/* 128 */                     Block block = Blocks.field_150350_a;
/* 129 */                     int i14 = 0;
/*     */                     
/* 131 */                     if (i13 > 1) {
/*     */                       do {
/* 133 */                         i13--;
/* 134 */                         block = chunk.func_150810_a(b1 + i10, i13, b2 + i11);
/* 135 */                         i14 = chunk.func_76628_c(b1 + i10, i13, b2 + i11);
/* 136 */                       } while (block.func_149728_f(i14) == MapColor.field_151660_b && i13 > 0);
/*     */                       
/* 138 */                       if (i13 > 0 && block.func_149688_o().func_76224_d()) {
/* 139 */                         Block block1; int i15 = i13 - 1;
/*     */                         
/*     */                         do {
/* 142 */                           block1 = chunk.func_150810_a(b1 + i10, i15--, b2 + i11);
/* 143 */                           i12++;
/* 144 */                         } while (i15 > 0 && block1.func_149688_o().func_76224_d());
/*     */                       } 
/*     */                     } 
/*     */                     
/* 148 */                     d1 += i13 / (i * i);
/*     */                     
/* 150 */                     hashMultiset.add(block.func_149728_f(i14));
/*     */                   } 
/*     */                 } 
/*     */               } 
/* 154 */               i12 /= i * i;
/*     */               
/* 156 */               double d2 = (d1 - d) * 4.0D / (i + 4) + ((i2 + i5 & 0x1) - 0.5D) * 0.4D;
/* 157 */               byte b = 1;
/* 158 */               if (d2 > 0.6D) b = 2; 
/* 159 */               if (d2 < -0.6D) b = 0;
/*     */               
/* 161 */               MapColor mapColor = (MapColor)Iterables.getFirst((Iterable)Multisets.copyHighestCountFirst((Multiset)hashMultiset), MapColor.field_151660_b);
/*     */               
/* 163 */               if (mapColor == MapColor.field_151662_n) {
/* 164 */                 d2 = i12 * 0.1D + (i2 + i5 & 0x1) * 0.2D;
/* 165 */                 b = 1;
/* 166 */                 if (d2 < 0.5D) b = 2; 
/* 167 */                 if (d2 > 0.9D) b = 0;
/*     */               
/*     */               } 
/* 170 */               d = d1;
/*     */               
/* 172 */               if (i5 >= 0 && 
/* 173 */                 i6 * i6 + i7 * i7 < i1 * i1 && (
/* 174 */                 !bool || (i2 + i5 & 0x1) != 0)) {
/*     */ 
/*     */                 
/* 177 */                 byte b1 = p_77872_3_.field_76198_e[i2 + i5 * 128];
/* 178 */                 byte b2 = (byte)(mapColor.field_76290_q * 4 + b);
/* 179 */                 if (b1 != b2)
/* 180 */                 { if (i3 > i5) i3 = i5; 
/* 181 */                   if (i4 < i5) i4 = i5; 
/* 182 */                   p_77872_3_.field_76198_e[i2 + i5 * 128] = b2; } 
/*     */               } 
/*     */             } 
/*     */           } 
/* 186 */         }  if (i3 <= i4) {
/* 187 */           p_77872_3_.func_76194_a(i2, i3, i4);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_77663_a(ItemStack p_77663_1_, World p_77663_2_, Entity p_77663_3_, int p_77663_4_, boolean p_77663_5_) {
/* 194 */     if (p_77663_2_.field_72995_K)
/*     */       return; 
/* 196 */     MapData mapData = func_77873_a(p_77663_1_, p_77663_2_);
/* 197 */     if (p_77663_3_ instanceof EntityPlayer) {
/* 198 */       EntityPlayer entityPlayer = (EntityPlayer)p_77663_3_;
/* 199 */       mapData.func_76191_a(entityPlayer, p_77663_1_);
/*     */     } 
/*     */     
/* 202 */     if (p_77663_5_) {
/* 203 */       func_77872_a(p_77663_2_, p_77663_3_, mapData);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Packet func_150911_c(ItemStack p_150911_1_, World p_150911_2_, EntityPlayer p_150911_3_) {
/* 209 */     byte[] arrayOfByte = func_77873_a(p_150911_1_, p_150911_2_).func_76193_a(p_150911_1_, p_150911_2_, p_150911_3_);
/* 210 */     if (arrayOfByte == null) return null; 
/* 211 */     return (Packet)new S34PacketMaps(p_150911_1_.func_77960_j(), arrayOfByte);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_77622_d(ItemStack p_77622_1_, World p_77622_2_, EntityPlayer p_77622_3_) {
/* 216 */     if (p_77622_1_.func_77942_o() && p_77622_1_.func_77978_p().func_74767_n("map_is_scaling")) {
/* 217 */       MapData mapData1 = Items.field_151098_aY.func_77873_a(p_77622_1_, p_77622_2_);
/* 218 */       p_77622_1_.func_77964_b(p_77622_2_.func_72841_b("map"));
/* 219 */       MapData mapData2 = new MapData("map_" + p_77622_1_.func_77960_j());
/*     */       
/* 221 */       mapData2.field_76197_d = (byte)(mapData1.field_76197_d + 1);
/* 222 */       if (mapData2.field_76197_d > 4) mapData2.field_76197_d = 4; 
/* 223 */       mapData2.field_76201_a = mapData1.field_76201_a;
/* 224 */       mapData2.field_76199_b = mapData1.field_76199_b;
/* 225 */       mapData2.field_76200_c = mapData1.field_76200_c;
/* 226 */       mapData2.func_76185_a();
/* 227 */       p_77622_2_.func_72823_a("map_" + p_77622_1_.func_77960_j(), (WorldSavedData)mapData2);
/*     */     } 
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_77624_a(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List<String> p_77624_3_, boolean p_77624_4_) {
/* 233 */     MapData mapData = func_77873_a(p_77624_1_, p_77624_2_.field_70170_p);
/*     */     
/* 235 */     if (p_77624_4_)
/* 236 */       if (mapData == null) {
/* 237 */         p_77624_3_.add("Unknown map");
/*     */       } else {
/* 239 */         p_77624_3_.add("Scaling at 1:" + (1 << mapData.field_76197_d));
/* 240 */         p_77624_3_.add("(Level " + mapData.field_76197_d + "/" + '\004' + ")");
/*     */       }  
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\item\ItemMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */