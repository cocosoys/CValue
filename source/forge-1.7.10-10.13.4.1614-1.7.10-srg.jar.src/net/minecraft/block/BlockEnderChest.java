/*     */ package net.minecraft.block;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.inventory.InventoryEnderChest;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.tileentity.TileEntityEnderChest;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockEnderChest
/*     */   extends BlockContainer
/*     */ {
/*     */   private static final String __OBFID = "CL_00000238";
/*     */   
/*     */   protected BlockEnderChest() {
/*  29 */     super(Material.field_151576_e);
/*  30 */     func_149647_a(CreativeTabs.field_78031_c);
/*     */     
/*  32 */     func_149676_a(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/*  37 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/*  42 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149645_b() {
/*  47 */     return 22;
/*     */   }
/*     */ 
/*     */   
/*     */   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
/*  52 */     return Item.func_150898_a(Blocks.field_150343_Z);
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149745_a(Random p_149745_1_) {
/*  57 */     return 8;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean func_149700_E() {
/*  62 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149689_a(World p_149689_1_, int p_149689_2_, int p_149689_3_, int p_149689_4_, EntityLivingBase p_149689_5_, ItemStack p_149689_6_) {
/*  68 */     byte b = 0;
/*  69 */     int i = MathHelper.func_76128_c((p_149689_5_.field_70177_z * 4.0F / 360.0F) + 0.5D) & 0x3;
/*     */     
/*  71 */     if (i == 0) b = 2; 
/*  72 */     if (i == 1) b = 5; 
/*  73 */     if (i == 2) b = 3; 
/*  74 */     if (i == 3) b = 4;
/*     */     
/*  76 */     p_149689_1_.func_72921_c(p_149689_2_, p_149689_3_, p_149689_4_, b, 2);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149727_a(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
/*  81 */     InventoryEnderChest inventoryEnderChest = p_149727_5_.func_71005_bN();
/*  82 */     TileEntityEnderChest tileEntityEnderChest = (TileEntityEnderChest)p_149727_1_.func_147438_o(p_149727_2_, p_149727_3_, p_149727_4_);
/*  83 */     if (inventoryEnderChest == null || tileEntityEnderChest == null) return true;
/*     */     
/*  85 */     if (p_149727_1_.func_147439_a(p_149727_2_, p_149727_3_ + 1, p_149727_4_).func_149721_r()) return true;
/*     */     
/*  87 */     if (p_149727_1_.field_72995_K) {
/*  88 */       return true;
/*     */     }
/*     */     
/*  91 */     inventoryEnderChest.func_146031_a(tileEntityEnderChest);
/*  92 */     p_149727_5_.func_71007_a((IInventory)inventoryEnderChest);
/*     */     
/*  94 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public TileEntity func_149915_a(World p_149915_1_, int p_149915_2_) {
/*  99 */     return (TileEntity)new TileEntityEnderChest();
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149734_b(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_) {
/* 104 */     for (byte b = 0; b < 3; b++) {
/* 105 */       double d1 = (p_149734_2_ + p_149734_5_.nextFloat());
/* 106 */       double d2 = (p_149734_3_ + p_149734_5_.nextFloat());
/* 107 */       double d3 = (p_149734_4_ + p_149734_5_.nextFloat());
/* 108 */       double d4 = 0.0D;
/* 109 */       double d5 = 0.0D;
/* 110 */       double d6 = 0.0D;
/* 111 */       int i = p_149734_5_.nextInt(2) * 2 - 1;
/* 112 */       int j = p_149734_5_.nextInt(2) * 2 - 1;
/* 113 */       d4 = (p_149734_5_.nextFloat() - 0.5D) * 0.125D;
/* 114 */       d5 = (p_149734_5_.nextFloat() - 0.5D) * 0.125D;
/* 115 */       d6 = (p_149734_5_.nextFloat() - 0.5D) * 0.125D;
/* 116 */       d3 = p_149734_4_ + 0.5D + 0.25D * j;
/* 117 */       d6 = (p_149734_5_.nextFloat() * 1.0F * j);
/* 118 */       d1 = p_149734_2_ + 0.5D + 0.25D * i;
/* 119 */       d4 = (p_149734_5_.nextFloat() * 1.0F * i);
/*     */       
/* 121 */       p_149734_1_.func_72869_a("portal", d1, d2, d3, d4, d5, d6);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149651_a(IIconRegister p_149651_1_) {
/* 129 */     this.field_149761_L = p_149651_1_.func_94245_a("obsidian");
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockEnderChest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */