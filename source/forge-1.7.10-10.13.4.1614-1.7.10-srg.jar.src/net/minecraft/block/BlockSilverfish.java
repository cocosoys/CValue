/*     */ package net.minecraft.block;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.monster.EntitySilverfish;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.World;
/*     */ import org.apache.commons.lang3.tuple.ImmutablePair;
/*     */ 
/*     */ public class BlockSilverfish
/*     */   extends Block {
/*  21 */   public static final String[] field_150198_a = new String[] { "stone", "cobble", "brick", "mossybrick", "crackedbrick", "chiseledbrick" };
/*     */   
/*     */   private static final String __OBFID = "CL_00000271";
/*     */   
/*     */   public BlockSilverfish() {
/*  26 */     super(Material.field_151571_B);
/*     */     
/*  28 */     func_149711_c(0.0F);
/*  29 */     func_149647_a(CreativeTabs.field_78031_c);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
/*  34 */     switch (p_149691_2_) {
/*     */       case 1:
/*  36 */         return Blocks.field_150347_e.func_149733_h(p_149691_1_);
/*     */       case 2:
/*  38 */         return Blocks.field_150417_aV.func_149733_h(p_149691_1_);
/*     */       case 3:
/*  40 */         return Blocks.field_150417_aV.func_149691_a(p_149691_1_, 1);
/*     */       case 4:
/*  42 */         return Blocks.field_150417_aV.func_149691_a(p_149691_1_, 2);
/*     */       case 5:
/*  44 */         return Blocks.field_150417_aV.func_149691_a(p_149691_1_, 3);
/*     */     } 
/*  46 */     return Blocks.field_150348_b.func_149733_h(p_149691_1_);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149651_a(IIconRegister p_149651_1_) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149664_b(World p_149664_1_, int p_149664_2_, int p_149664_3_, int p_149664_4_, int p_149664_5_) {
/*  57 */     if (!p_149664_1_.field_72995_K) {
/*  58 */       EntitySilverfish entitySilverfish = new EntitySilverfish(p_149664_1_);
/*  59 */       entitySilverfish.func_70012_b(p_149664_2_ + 0.5D, p_149664_3_, p_149664_4_ + 0.5D, 0.0F, 0.0F);
/*  60 */       p_149664_1_.func_72838_d((Entity)entitySilverfish);
/*     */       
/*  62 */       entitySilverfish.func_70656_aK();
/*     */     } 
/*  64 */     super.func_149664_b(p_149664_1_, p_149664_2_, p_149664_3_, p_149664_4_, p_149664_5_);
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149745_a(Random p_149745_1_) {
/*  69 */     return 0;
/*     */   }
/*     */   
/*     */   public static boolean func_150196_a(Block p_150196_0_) {
/*  73 */     return (p_150196_0_ == Blocks.field_150348_b || p_150196_0_ == Blocks.field_150347_e || p_150196_0_ == Blocks.field_150417_aV);
/*     */   }
/*     */   
/*     */   public static int func_150195_a(Block p_150195_0_, int p_150195_1_) {
/*  77 */     if (p_150195_1_ == 0) {
/*  78 */       if (p_150195_0_ == Blocks.field_150347_e) {
/*  79 */         return 1;
/*     */       }
/*  81 */       if (p_150195_0_ == Blocks.field_150417_aV) {
/*  82 */         return 2;
/*     */       }
/*     */     }
/*  85 */     else if (p_150195_0_ == Blocks.field_150417_aV) {
/*  86 */       switch (p_150195_1_) {
/*     */         case 1:
/*  88 */           return 3;
/*     */         case 2:
/*  90 */           return 4;
/*     */         case 3:
/*  92 */           return 5;
/*     */       } 
/*     */     
/*     */     } 
/*  96 */     return 0;
/*     */   }
/*     */   
/*     */   public static ImmutablePair func_150197_b(int p_150197_0_) {
/* 100 */     switch (p_150197_0_) {
/*     */       case 1:
/* 102 */         return new ImmutablePair(Blocks.field_150347_e, Integer.valueOf(0));
/*     */       case 2:
/* 104 */         return new ImmutablePair(Blocks.field_150417_aV, Integer.valueOf(0));
/*     */       case 3:
/* 106 */         return new ImmutablePair(Blocks.field_150417_aV, Integer.valueOf(1));
/*     */       case 4:
/* 108 */         return new ImmutablePair(Blocks.field_150417_aV, Integer.valueOf(2));
/*     */       case 5:
/* 110 */         return new ImmutablePair(Blocks.field_150417_aV, Integer.valueOf(3));
/*     */     } 
/* 112 */     return new ImmutablePair(Blocks.field_150348_b, Integer.valueOf(0));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected ItemStack func_149644_j(int p_149644_1_) {
/* 118 */     switch (p_149644_1_) {
/*     */       case 1:
/* 120 */         return new ItemStack(Blocks.field_150347_e);
/*     */       case 2:
/* 122 */         return new ItemStack(Blocks.field_150417_aV);
/*     */       case 3:
/* 124 */         return new ItemStack(Blocks.field_150417_aV, 1, 1);
/*     */       case 4:
/* 126 */         return new ItemStack(Blocks.field_150417_aV, 1, 2);
/*     */       case 5:
/* 128 */         return new ItemStack(Blocks.field_150417_aV, 1, 3);
/*     */     } 
/* 130 */     return new ItemStack(Blocks.field_150348_b);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149690_a(World p_149690_1_, int p_149690_2_, int p_149690_3_, int p_149690_4_, int p_149690_5_, float p_149690_6_, int p_149690_7_) {
/* 136 */     if (!p_149690_1_.field_72995_K) {
/* 137 */       EntitySilverfish entitySilverfish = new EntitySilverfish(p_149690_1_);
/* 138 */       entitySilverfish.func_70012_b(p_149690_2_ + 0.5D, p_149690_3_, p_149690_4_ + 0.5D, 0.0F, 0.0F);
/* 139 */       p_149690_1_.func_72838_d((Entity)entitySilverfish);
/*     */       
/* 141 */       entitySilverfish.func_70656_aK();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149643_k(World p_149643_1_, int p_149643_2_, int p_149643_3_, int p_149643_4_) {
/* 147 */     return p_149643_1_.func_72805_g(p_149643_2_, p_149643_3_, p_149643_4_);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149666_a(Item p_149666_1_, CreativeTabs p_149666_2_, List<ItemStack> p_149666_3_) {
/* 152 */     for (byte b = 0; b < field_150198_a.length; b++)
/* 153 */       p_149666_3_.add(new ItemStack(p_149666_1_, 1, b)); 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockSilverfish.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */