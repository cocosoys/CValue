/*     */ package net.minecraft.server.v1_7_R4;
/*     */ 
/*     */ import net.minecraft.util.com.mojang.authlib.GameProfile;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ItemSkull
/*     */   extends Item
/*     */ {
/*  23 */   private static final String[] b = new String[] { "skeleton", "wither", "zombie", "char", "creeper" };
/*     */ 
/*     */ 
/*     */   
/*  27 */   public static final String[] a = new String[] { "skeleton", "wither", "zombie", "steve", "creeper" };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemSkull() {
/*  34 */     a(CreativeModeTab.c);
/*  35 */     setMaxDurability(0);
/*  36 */     a(true);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean interactWith(ItemStack paramItemStack, EntityHuman paramEntityHuman, World paramWorld, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat1, float paramFloat2, float paramFloat3) {
/*  41 */     if (paramInt4 == 0) return false; 
/*  42 */     if (!paramWorld.getType(paramInt1, paramInt2, paramInt3).getMaterial().isBuildable()) return false;
/*     */     
/*  44 */     if (paramInt4 == 1) paramInt2++;
/*     */     
/*  46 */     if (paramInt4 == 2) paramInt3--; 
/*  47 */     if (paramInt4 == 3) paramInt3++; 
/*  48 */     if (paramInt4 == 4) paramInt1--; 
/*  49 */     if (paramInt4 == 5) paramInt1++;
/*     */     
/*  51 */     if (!paramWorld.isStatic) {
/*  52 */       paramWorld.setTypeAndData(paramInt1, paramInt2, paramInt3, Blocks.SKULL, paramInt4, 2);
/*     */       
/*  54 */       int i = 0;
/*  55 */       if (paramInt4 == 1) {
/*  56 */         i = MathHelper.floor((paramEntityHuman.yaw * 16.0F / 360.0F) + 0.5D) & 0xF;
/*     */       }
/*     */       
/*  59 */       TileEntity tileEntity = paramWorld.getTileEntity(paramInt1, paramInt2, paramInt3);
/*  60 */       if (tileEntity != null && tileEntity instanceof TileEntitySkull) {
/*  61 */         if (paramItemStack.getData() == 3) {
/*  62 */           GameProfile gameProfile = null;
/*  63 */           if (paramItemStack.hasTag()) {
/*  64 */             NBTTagCompound nBTTagCompound = paramItemStack.getTag();
/*     */             
/*  66 */             if (nBTTagCompound.hasKeyOfType("SkullOwner", 10)) {
/*  67 */               gameProfile = GameProfileSerializer.deserialize(nBTTagCompound.getCompound("SkullOwner"));
/*  68 */             } else if (nBTTagCompound.hasKeyOfType("SkullOwner", 8) && nBTTagCompound.getString("SkullOwner").length() > 0) {
/*  69 */               gameProfile = new GameProfile(null, nBTTagCompound.getString("SkullOwner"));
/*     */             } 
/*     */           } 
/*     */           
/*  73 */           ((TileEntitySkull)tileEntity).setGameProfile(gameProfile);
/*     */         } else {
/*  75 */           ((TileEntitySkull)tileEntity).setSkullType(paramItemStack.getData());
/*     */         } 
/*  77 */         ((TileEntitySkull)tileEntity).setRotation(i);
/*  78 */         ((BlockSkull)Blocks.SKULL).a(paramWorld, paramInt1, paramInt2, paramInt3, (TileEntitySkull)tileEntity);
/*     */       } 
/*     */       
/*  81 */       paramItemStack.count--;
/*     */     } 
/*     */     
/*  84 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int filterData(int paramInt) {
/* 120 */     return paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   public String a(ItemStack paramItemStack) {
/* 125 */     int i = paramItemStack.getData();
/* 126 */     if (i < 0 || i >= b.length) {
/* 127 */       i = 0;
/*     */     }
/* 129 */     return getName() + "." + b[i];
/*     */   }
/*     */ 
/*     */   
/*     */   public String n(ItemStack paramItemStack) {
/* 134 */     if (paramItemStack.getData() == 3 && paramItemStack.hasTag()) {
/* 135 */       if (paramItemStack.getTag().hasKeyOfType("SkullOwner", 10))
/* 136 */         return LocaleI18n.get("item.skull.player.name", new Object[] { GameProfileSerializer.deserialize(paramItemStack.getTag().getCompound("SkullOwner")).getName() }); 
/* 137 */       if (paramItemStack.getTag().hasKeyOfType("SkullOwner", 8)) {
/* 138 */         return LocaleI18n.get("item.skull.player.name", new Object[] { paramItemStack.getTag().getString("SkullOwner") });
/*     */       }
/*     */     } 
/*     */     
/* 142 */     return super.n(paramItemStack);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\ItemSkull.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */