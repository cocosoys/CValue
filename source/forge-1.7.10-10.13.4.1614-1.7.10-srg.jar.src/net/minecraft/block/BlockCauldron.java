/*     */ package net.minecraft.block;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemArmor;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class BlockCauldron extends Block {
/*     */   @SideOnly(Side.CLIENT)
/*     */   private IIcon field_150029_a;
/*     */   @SideOnly(Side.CLIENT)
/*     */   private IIcon field_150028_b;
/*     */   @SideOnly(Side.CLIENT)
/*     */   private IIcon field_150030_M;
/*     */   private static final String __OBFID = "CL_00000213";
/*     */   
/*     */   public BlockCauldron() {
/*  33 */     super(Material.field_151573_f);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
/*  38 */     if (p_149691_1_ == 1) {
/*  39 */       return this.field_150028_b;
/*     */     }
/*  41 */     if (p_149691_1_ == 0) {
/*  42 */       return this.field_150030_M;
/*     */     }
/*  44 */     return this.field_149761_L;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149651_a(IIconRegister p_149651_1_) {
/*  49 */     this.field_150029_a = p_149651_1_.func_94245_a(func_149641_N() + "_" + "inner");
/*  50 */     this.field_150028_b = p_149651_1_.func_94245_a(func_149641_N() + "_top");
/*  51 */     this.field_150030_M = p_149651_1_.func_94245_a(func_149641_N() + "_" + "bottom");
/*  52 */     this.field_149761_L = p_149651_1_.func_94245_a(func_149641_N() + "_side");
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public static IIcon func_150026_e(String p_150026_0_) {
/*  56 */     if (p_150026_0_.equals("inner")) return Blocks.field_150383_bp.field_150029_a; 
/*  57 */     if (p_150026_0_.equals("bottom")) return Blocks.field_150383_bp.field_150030_M; 
/*  58 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149743_a(World p_149743_1_, int p_149743_2_, int p_149743_3_, int p_149743_4_, AxisAlignedBB p_149743_5_, List p_149743_6_, Entity p_149743_7_) {
/*  63 */     func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 0.3125F, 1.0F);
/*  64 */     super.func_149743_a(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
/*  65 */     float f = 0.125F;
/*  66 */     func_149676_a(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
/*  67 */     super.func_149743_a(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
/*  68 */     func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f);
/*  69 */     super.func_149743_a(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
/*  70 */     func_149676_a(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
/*  71 */     super.func_149743_a(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
/*  72 */     func_149676_a(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F);
/*  73 */     super.func_149743_a(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
/*     */     
/*  75 */     func_149683_g();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149683_g() {
/*  80 */     func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/*  85 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149645_b() {
/*  90 */     return 24;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/*  95 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149670_a(World p_149670_1_, int p_149670_2_, int p_149670_3_, int p_149670_4_, Entity p_149670_5_) {
/* 100 */     int i = func_150027_b(p_149670_1_.func_72805_g(p_149670_2_, p_149670_3_, p_149670_4_));
/* 101 */     float f = p_149670_3_ + (6.0F + (3 * i)) / 16.0F;
/*     */     
/* 103 */     if (!p_149670_1_.field_72995_K && p_149670_5_.func_70027_ad() && i > 0 && p_149670_5_.field_70121_D.field_72338_b <= f) {
/* 104 */       p_149670_5_.func_70066_B();
/*     */       
/* 106 */       func_150024_a(p_149670_1_, p_149670_2_, p_149670_3_, p_149670_4_, i - 1);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149727_a(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
/* 112 */     if (p_149727_1_.field_72995_K) {
/* 113 */       return true;
/*     */     }
/*     */     
/* 116 */     ItemStack itemStack = p_149727_5_.field_71071_by.func_70448_g();
/* 117 */     if (itemStack == null) {
/* 118 */       return true;
/*     */     }
/*     */     
/* 121 */     int i = p_149727_1_.func_72805_g(p_149727_2_, p_149727_3_, p_149727_4_);
/* 122 */     int j = func_150027_b(i);
/*     */     
/* 124 */     if (itemStack.func_77973_b() == Items.field_151131_as) {
/* 125 */       if (j < 3) {
/* 126 */         if (!p_149727_5_.field_71075_bZ.field_75098_d) {
/* 127 */           p_149727_5_.field_71071_by.func_70299_a(p_149727_5_.field_71071_by.field_70461_c, new ItemStack(Items.field_151133_ar));
/*     */         }
/*     */         
/* 130 */         func_150024_a(p_149727_1_, p_149727_2_, p_149727_3_, p_149727_4_, 3);
/*     */       } 
/* 132 */       return true;
/* 133 */     }  if (itemStack.func_77973_b() == Items.field_151069_bo) {
/* 134 */       if (j > 0) {
/* 135 */         if (!p_149727_5_.field_71075_bZ.field_75098_d) {
/* 136 */           ItemStack itemStack1 = new ItemStack((Item)Items.field_151068_bn, 1, 0);
/* 137 */           if (!p_149727_5_.field_71071_by.func_70441_a(itemStack1)) {
/* 138 */             p_149727_1_.func_72838_d((Entity)new EntityItem(p_149727_1_, p_149727_2_ + 0.5D, p_149727_3_ + 1.5D, p_149727_4_ + 0.5D, itemStack1));
/* 139 */           } else if (p_149727_5_ instanceof EntityPlayerMP) {
/* 140 */             ((EntityPlayerMP)p_149727_5_).func_71120_a(p_149727_5_.field_71069_bz);
/*     */           } 
/*     */           
/* 143 */           itemStack.field_77994_a--;
/* 144 */           if (itemStack.field_77994_a <= 0) {
/* 145 */             p_149727_5_.field_71071_by.func_70299_a(p_149727_5_.field_71071_by.field_70461_c, null);
/*     */           }
/*     */         } 
/*     */         
/* 149 */         func_150024_a(p_149727_1_, p_149727_2_, p_149727_3_, p_149727_4_, j - 1);
/*     */       } 
/* 151 */     } else if (j > 0 && itemStack.func_77973_b() instanceof ItemArmor && ((ItemArmor)itemStack.func_77973_b()).func_82812_d() == ItemArmor.ArmorMaterial.CLOTH) {
/* 152 */       ItemArmor itemArmor = (ItemArmor)itemStack.func_77973_b();
/* 153 */       itemArmor.func_82815_c(itemStack);
/* 154 */       func_150024_a(p_149727_1_, p_149727_2_, p_149727_3_, p_149727_4_, j - 1);
/* 155 */       return true;
/*     */     } 
/*     */     
/* 158 */     return false;
/*     */   }
/*     */   
/*     */   public void func_150024_a(World p_150024_1_, int p_150024_2_, int p_150024_3_, int p_150024_4_, int p_150024_5_) {
/* 162 */     p_150024_1_.func_72921_c(p_150024_2_, p_150024_3_, p_150024_4_, MathHelper.func_76125_a(p_150024_5_, 0, 3), 2);
/* 163 */     p_150024_1_.func_147453_f(p_150024_2_, p_150024_3_, p_150024_4_, this);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149639_l(World p_149639_1_, int p_149639_2_, int p_149639_3_, int p_149639_4_) {
/* 168 */     if (p_149639_1_.field_73012_v.nextInt(20) != 1)
/*     */       return; 
/* 170 */     int i = p_149639_1_.func_72805_g(p_149639_2_, p_149639_3_, p_149639_4_);
/*     */     
/* 172 */     if (i < 3) {
/* 173 */       p_149639_1_.func_72921_c(p_149639_2_, p_149639_3_, p_149639_4_, i + 1, 2);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
/* 179 */     return Items.field_151066_bu;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public Item func_149694_d(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_) {
/* 184 */     return Items.field_151066_bu;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149740_M() {
/* 189 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149736_g(World p_149736_1_, int p_149736_2_, int p_149736_3_, int p_149736_4_, int p_149736_5_) {
/* 194 */     int i = p_149736_1_.func_72805_g(p_149736_2_, p_149736_3_, p_149736_4_);
/*     */     
/* 196 */     return func_150027_b(i);
/*     */   }
/*     */   
/*     */   public static int func_150027_b(int p_150027_0_) {
/* 200 */     return p_150027_0_;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public static float func_150025_c(int p_150025_0_) {
/* 204 */     int i = MathHelper.func_76125_a(p_150025_0_, 0, 3);
/* 205 */     return (6 + 3 * i) / 16.0F;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockCauldron.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */