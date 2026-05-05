/*     */ package net.minecraft.item;
/*     */ import net.minecraft.block.BlockEndPortalFrame;
/*     */ import net.minecraft.entity.item.EntityEnderEye;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.util.Direction;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.world.ChunkPosition;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class ItemEnderEye extends Item {
/*     */   public ItemEnderEye() {
/*  13 */     func_77637_a(CreativeTabs.field_78026_f);
/*     */   }
/*     */   
/*     */   private static final String __OBFID = "CL_00000026";
/*     */   
/*     */   public boolean func_77648_a(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
/*  19 */     Block block = p_77648_3_.func_147439_a(p_77648_4_, p_77648_5_, p_77648_6_);
/*  20 */     int i = p_77648_3_.func_72805_g(p_77648_4_, p_77648_5_, p_77648_6_);
/*     */     
/*  22 */     if (p_77648_2_.func_82247_a(p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_1_) && block == Blocks.field_150378_br && !BlockEndPortalFrame.func_150020_b(i)) {
/*  23 */       if (p_77648_3_.field_72995_K) return true; 
/*  24 */       p_77648_3_.func_72921_c(p_77648_4_, p_77648_5_, p_77648_6_, i + 4, 2);
/*  25 */       p_77648_3_.func_147453_f(p_77648_4_, p_77648_5_, p_77648_6_, Blocks.field_150378_br);
/*  26 */       p_77648_1_.field_77994_a--;
/*     */       int j;
/*  28 */       for (j = 0; j < 16; j++) {
/*  29 */         double d1 = (p_77648_4_ + (5.0F + field_77697_d.nextFloat() * 6.0F) / 16.0F);
/*  30 */         double d2 = (p_77648_5_ + 0.8125F);
/*  31 */         double d3 = (p_77648_6_ + (5.0F + field_77697_d.nextFloat() * 6.0F) / 16.0F);
/*  32 */         double d4 = 0.0D;
/*  33 */         double d5 = 0.0D;
/*  34 */         double d6 = 0.0D;
/*     */         
/*  36 */         p_77648_3_.func_72869_a("smoke", d1, d2, d3, d4, d5, d6);
/*     */       } 
/*     */ 
/*     */       
/*  40 */       j = i & 0x3;
/*     */ 
/*     */       
/*  43 */       int k = 0;
/*  44 */       int m = 0;
/*  45 */       boolean bool1 = false;
/*  46 */       boolean bool2 = true;
/*  47 */       int n = Direction.field_71577_f[j]; int i1;
/*  48 */       for (i1 = -2; i1 <= 2; i1++) {
/*  49 */         int i2 = p_77648_4_ + Direction.field_71583_a[n] * i1;
/*  50 */         int i3 = p_77648_6_ + Direction.field_71581_b[n] * i1;
/*     */         
/*  52 */         if (p_77648_3_.func_147439_a(i2, p_77648_5_, i3) == Blocks.field_150378_br) {
/*  53 */           if (!BlockEndPortalFrame.func_150020_b(p_77648_3_.func_72805_g(i2, p_77648_5_, i3))) {
/*  54 */             bool2 = false;
/*     */             break;
/*     */           } 
/*  57 */           m = i1;
/*  58 */           if (!bool1) {
/*  59 */             k = i1;
/*  60 */             bool1 = true;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/*  66 */       if (bool2 && m == k + 2) {
/*     */ 
/*     */         
/*  69 */         for (i1 = k; i1 <= m; i1++) {
/*  70 */           int i2 = p_77648_4_ + Direction.field_71583_a[n] * i1;
/*  71 */           int i3 = p_77648_6_ + Direction.field_71581_b[n] * i1;
/*  72 */           i2 += Direction.field_71583_a[j] * 4;
/*  73 */           i3 += Direction.field_71581_b[j] * 4;
/*     */           
/*  75 */           if (p_77648_3_.func_147439_a(i2, p_77648_5_, i3) != Blocks.field_150378_br || !BlockEndPortalFrame.func_150020_b(p_77648_3_.func_72805_g(i2, p_77648_5_, i3))) {
/*  76 */             bool2 = false;
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/*  81 */         for (i1 = k - 1; i1 <= m + 1; i1 += 4) {
/*  82 */           for (byte b = 1; b <= 3; b++) {
/*  83 */             int i2 = p_77648_4_ + Direction.field_71583_a[n] * i1;
/*  84 */             int i3 = p_77648_6_ + Direction.field_71581_b[n] * i1;
/*  85 */             i2 += Direction.field_71583_a[j] * b;
/*  86 */             i3 += Direction.field_71581_b[j] * b;
/*     */             
/*  88 */             if (p_77648_3_.func_147439_a(i2, p_77648_5_, i3) != Blocks.field_150378_br || !BlockEndPortalFrame.func_150020_b(p_77648_3_.func_72805_g(i2, p_77648_5_, i3))) {
/*  89 */               bool2 = false;
/*     */               break;
/*     */             } 
/*     */           } 
/*     */         } 
/*  94 */         if (bool2)
/*     */         {
/*  96 */           for (i1 = k; i1 <= m; i1++) {
/*  97 */             for (byte b = 1; b <= 3; b++) {
/*  98 */               int i2 = p_77648_4_ + Direction.field_71583_a[n] * i1;
/*  99 */               int i3 = p_77648_6_ + Direction.field_71581_b[n] * i1;
/* 100 */               i2 += Direction.field_71583_a[j] * b;
/* 101 */               i3 += Direction.field_71581_b[j] * b;
/*     */               
/* 103 */               p_77648_3_.func_147465_d(i2, p_77648_5_, i3, Blocks.field_150384_bq, 0, 2);
/*     */             } 
/*     */           } 
/*     */         }
/*     */       } 
/*     */       
/* 109 */       return true;
/*     */     } 
/* 111 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_77659_a(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_) {
/* 117 */     MovingObjectPosition movingObjectPosition = func_77621_a(p_77659_2_, p_77659_3_, false);
/* 118 */     if (movingObjectPosition != null && movingObjectPosition.field_72313_a == MovingObjectPosition.MovingObjectType.BLOCK && 
/* 119 */       p_77659_2_.func_147439_a(movingObjectPosition.field_72311_b, movingObjectPosition.field_72312_c, movingObjectPosition.field_72309_d) == Blocks.field_150378_br) {
/* 120 */       return p_77659_1_;
/*     */     }
/*     */ 
/*     */     
/* 124 */     if (!p_77659_2_.field_72995_K) {
/* 125 */       ChunkPosition chunkPosition = p_77659_2_.func_147440_b("Stronghold", (int)p_77659_3_.field_70165_t, (int)p_77659_3_.field_70163_u, (int)p_77659_3_.field_70161_v);
/* 126 */       if (chunkPosition != null) {
/* 127 */         EntityEnderEye entityEnderEye = new EntityEnderEye(p_77659_2_, p_77659_3_.field_70165_t, p_77659_3_.field_70163_u + 1.62D - p_77659_3_.field_70129_M, p_77659_3_.field_70161_v);
/* 128 */         entityEnderEye.func_70220_a(chunkPosition.field_151329_a, chunkPosition.field_151327_b, chunkPosition.field_151328_c);
/* 129 */         p_77659_2_.func_72838_d((Entity)entityEnderEye);
/*     */         
/* 131 */         p_77659_2_.func_72956_a((Entity)p_77659_3_, "random.bow", 0.5F, 0.4F / (field_77697_d.nextFloat() * 0.4F + 0.8F));
/* 132 */         p_77659_2_.func_72889_a(null, 1002, (int)p_77659_3_.field_70165_t, (int)p_77659_3_.field_70163_u, (int)p_77659_3_.field_70161_v, 0);
/* 133 */         if (!p_77659_3_.field_71075_bZ.field_75098_d) {
/* 134 */           p_77659_1_.field_77994_a--;
/*     */         }
/*     */       } 
/*     */     } 
/* 138 */     return p_77659_1_;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\item\ItemEnderEye.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */