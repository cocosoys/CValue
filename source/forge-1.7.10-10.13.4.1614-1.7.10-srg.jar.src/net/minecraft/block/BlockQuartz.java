/*     */ package net.minecraft.block;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.material.MapColor;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ public class BlockQuartz
/*     */   extends Block
/*     */ {
/*  19 */   public static final String[] field_150191_a = new String[] { "default", "chiseled", "lines" };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  27 */   private static final String[] field_150189_b = new String[] { "side", "chiseled", "lines", null, null };
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   private IIcon[] field_150192_M;
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   private IIcon field_150193_N;
/*     */   @SideOnly(Side.CLIENT)
/*     */   private IIcon field_150194_O;
/*     */   
/*     */   public BlockQuartz() {
/*  38 */     super(Material.field_151576_e);
/*  39 */     func_149647_a(CreativeTabs.field_78030_b);
/*     */   } @SideOnly(Side.CLIENT)
/*     */   private IIcon field_150190_P; @SideOnly(Side.CLIENT)
/*     */   private IIcon field_150188_Q; private static final String __OBFID = "CL_00000292"; @SideOnly(Side.CLIENT)
/*     */   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
/*  44 */     if (p_149691_2_ == 2 || p_149691_2_ == 3 || p_149691_2_ == 4) {
/*  45 */       if (p_149691_2_ == 2 && (p_149691_1_ == 1 || p_149691_1_ == 0))
/*  46 */         return this.field_150194_O; 
/*  47 */       if (p_149691_2_ == 3 && (p_149691_1_ == 5 || p_149691_1_ == 4))
/*  48 */         return this.field_150194_O; 
/*  49 */       if (p_149691_2_ == 4 && (p_149691_1_ == 2 || p_149691_1_ == 3)) {
/*  50 */         return this.field_150194_O;
/*     */       }
/*     */       
/*  53 */       return this.field_150192_M[p_149691_2_];
/*     */     } 
/*     */     
/*  56 */     if (p_149691_1_ == 1 || (p_149691_1_ == 0 && p_149691_2_ == 1)) {
/*  57 */       if (p_149691_2_ == 1) {
/*  58 */         return this.field_150193_N;
/*     */       }
/*  60 */       return this.field_150190_P;
/*     */     } 
/*  62 */     if (p_149691_1_ == 0) {
/*  63 */       return this.field_150188_Q;
/*     */     }
/*  65 */     if (p_149691_2_ < 0 || p_149691_2_ >= this.field_150192_M.length) p_149691_2_ = 0; 
/*  66 */     return this.field_150192_M[p_149691_2_];
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149660_a(World p_149660_1_, int p_149660_2_, int p_149660_3_, int p_149660_4_, int p_149660_5_, float p_149660_6_, float p_149660_7_, float p_149660_8_, int p_149660_9_) {
/*  71 */     if (p_149660_9_ == 2) {
/*  72 */       switch (p_149660_5_) {
/*     */         case 2:
/*     */         case 3:
/*  75 */           p_149660_9_ = 4;
/*     */           break;
/*     */         case 4:
/*     */         case 5:
/*  79 */           p_149660_9_ = 3;
/*     */           break;
/*     */         case 0:
/*     */         case 1:
/*  83 */           p_149660_9_ = 2;
/*     */           break;
/*     */       } 
/*     */     
/*     */     }
/*  88 */     return p_149660_9_;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149692_a(int p_149692_1_) {
/*  93 */     if (p_149692_1_ == 3 || p_149692_1_ == 4) return 2;
/*     */     
/*  95 */     return p_149692_1_;
/*     */   }
/*     */ 
/*     */   
/*     */   protected ItemStack func_149644_j(int p_149644_1_) {
/* 100 */     if (p_149644_1_ == 3 || p_149644_1_ == 4) return new ItemStack(Item.func_150898_a(this), 1, 2); 
/* 101 */     return super.func_149644_j(p_149644_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149645_b() {
/* 106 */     return 39;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149666_a(Item p_149666_1_, CreativeTabs p_149666_2_, List<ItemStack> p_149666_3_) {
/* 111 */     p_149666_3_.add(new ItemStack(p_149666_1_, 1, 0));
/* 112 */     p_149666_3_.add(new ItemStack(p_149666_1_, 1, 1));
/* 113 */     p_149666_3_.add(new ItemStack(p_149666_1_, 1, 2));
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149651_a(IIconRegister p_149651_1_) {
/* 118 */     this.field_150192_M = new IIcon[field_150189_b.length];
/*     */     
/* 120 */     for (byte b = 0; b < this.field_150192_M.length; b++) {
/* 121 */       if (field_150189_b[b] == null) {
/* 122 */         this.field_150192_M[b] = this.field_150192_M[b - 1];
/*     */       } else {
/* 124 */         this.field_150192_M[b] = p_149651_1_.func_94245_a(func_149641_N() + "_" + field_150189_b[b]);
/*     */       } 
/*     */     } 
/*     */     
/* 128 */     this.field_150190_P = p_149651_1_.func_94245_a(func_149641_N() + "_" + "top");
/* 129 */     this.field_150193_N = p_149651_1_.func_94245_a(func_149641_N() + "_" + "chiseled_top");
/* 130 */     this.field_150194_O = p_149651_1_.func_94245_a(func_149641_N() + "_" + "lines_top");
/* 131 */     this.field_150188_Q = p_149651_1_.func_94245_a(func_149641_N() + "_" + "bottom");
/*     */   }
/*     */ 
/*     */   
/*     */   public MapColor func_149728_f(int p_149728_1_) {
/* 136 */     return MapColor.field_151677_p;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockQuartz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */