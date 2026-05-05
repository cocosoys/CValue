/*     */ package net.minecraft.block;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.command.IEntitySelector;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityMinecartCommandBlock;
/*     */ import net.minecraft.entity.item.EntityMinecart;
/*     */ import net.minecraft.inventory.Container;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class BlockRailDetector extends BlockRailBase {
/*     */   @SideOnly(Side.CLIENT)
/*     */   private IIcon[] field_150055_b;
/*     */   
/*     */   public BlockRailDetector() {
/*  23 */     super(true);
/*     */     
/*  25 */     func_149675_a(true);
/*     */   }
/*     */   private static final String __OBFID = "CL_00000225";
/*     */   
/*     */   public int func_149738_a(World p_149738_1_) {
/*  30 */     return 20;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149744_f() {
/*  35 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149670_a(World p_149670_1_, int p_149670_2_, int p_149670_3_, int p_149670_4_, Entity p_149670_5_) {
/*  40 */     if (p_149670_1_.field_72995_K) {
/*     */       return;
/*     */     }
/*     */     
/*  44 */     int i = p_149670_1_.func_72805_g(p_149670_2_, p_149670_3_, p_149670_4_);
/*  45 */     if ((i & 0x8) != 0) {
/*     */       return;
/*     */     }
/*     */     
/*  49 */     func_150054_a(p_149670_1_, p_149670_2_, p_149670_3_, p_149670_4_, i);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149674_a(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
/*  54 */     if (p_149674_1_.field_72995_K)
/*     */       return; 
/*  56 */     int i = p_149674_1_.func_72805_g(p_149674_2_, p_149674_3_, p_149674_4_);
/*  57 */     if ((i & 0x8) == 0) {
/*     */       return;
/*     */     }
/*     */     
/*  61 */     func_150054_a(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_, i);
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149709_b(IBlockAccess p_149709_1_, int p_149709_2_, int p_149709_3_, int p_149709_4_, int p_149709_5_) {
/*  66 */     return ((p_149709_1_.func_72805_g(p_149709_2_, p_149709_3_, p_149709_4_) & 0x8) != 0) ? 15 : 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149748_c(IBlockAccess p_149748_1_, int p_149748_2_, int p_149748_3_, int p_149748_4_, int p_149748_5_) {
/*  71 */     if ((p_149748_1_.func_72805_g(p_149748_2_, p_149748_3_, p_149748_4_) & 0x8) == 0) return 0; 
/*  72 */     return (p_149748_5_ == 1) ? 15 : 0;
/*     */   }
/*     */   
/*     */   private void func_150054_a(World p_150054_1_, int p_150054_2_, int p_150054_3_, int p_150054_4_, int p_150054_5_) {
/*  76 */     boolean bool1 = ((p_150054_5_ & 0x8) != 0) ? true : false;
/*  77 */     boolean bool2 = false;
/*     */     
/*  79 */     float f = 0.125F;
/*  80 */     List list = p_150054_1_.func_72872_a(EntityMinecart.class, AxisAlignedBB.func_72330_a((p_150054_2_ + f), p_150054_3_, (p_150054_4_ + f), ((p_150054_2_ + 1) - f), ((p_150054_3_ + 1) - f), ((p_150054_4_ + 1) - f)));
/*  81 */     if (!list.isEmpty()) {
/*  82 */       bool2 = true;
/*     */     }
/*     */     
/*  85 */     if (bool2 && !bool1) {
/*  86 */       p_150054_1_.func_72921_c(p_150054_2_, p_150054_3_, p_150054_4_, p_150054_5_ | 0x8, 3);
/*  87 */       p_150054_1_.func_147459_d(p_150054_2_, p_150054_3_, p_150054_4_, this);
/*  88 */       p_150054_1_.func_147459_d(p_150054_2_, p_150054_3_ - 1, p_150054_4_, this);
/*  89 */       p_150054_1_.func_147458_c(p_150054_2_, p_150054_3_, p_150054_4_, p_150054_2_, p_150054_3_, p_150054_4_);
/*     */     } 
/*     */     
/*  92 */     if (!bool2 && bool1) {
/*  93 */       p_150054_1_.func_72921_c(p_150054_2_, p_150054_3_, p_150054_4_, p_150054_5_ & 0x7, 3);
/*  94 */       p_150054_1_.func_147459_d(p_150054_2_, p_150054_3_, p_150054_4_, this);
/*  95 */       p_150054_1_.func_147459_d(p_150054_2_, p_150054_3_ - 1, p_150054_4_, this);
/*  96 */       p_150054_1_.func_147458_c(p_150054_2_, p_150054_3_, p_150054_4_, p_150054_2_, p_150054_3_, p_150054_4_);
/*     */     } 
/*     */     
/*  99 */     if (bool2) {
/* 100 */       p_150054_1_.func_147464_a(p_150054_2_, p_150054_3_, p_150054_4_, this, func_149738_a(p_150054_1_));
/*     */     }
/*     */     
/* 103 */     p_150054_1_.func_147453_f(p_150054_2_, p_150054_3_, p_150054_4_, this);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149726_b(World p_149726_1_, int p_149726_2_, int p_149726_3_, int p_149726_4_) {
/* 108 */     super.func_149726_b(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_);
/* 109 */     func_150054_a(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_, p_149726_1_.func_72805_g(p_149726_2_, p_149726_3_, p_149726_4_));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149740_M() {
/* 114 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149736_g(World p_149736_1_, int p_149736_2_, int p_149736_3_, int p_149736_4_, int p_149736_5_) {
/* 119 */     if ((p_149736_1_.func_72805_g(p_149736_2_, p_149736_3_, p_149736_4_) & 0x8) > 0) {
/* 120 */       float f = 0.125F;
/* 121 */       List<EntityMinecartCommandBlock> list = p_149736_1_.func_72872_a(EntityMinecartCommandBlock.class, AxisAlignedBB.func_72330_a((p_149736_2_ + f), p_149736_3_, (p_149736_4_ + f), ((p_149736_2_ + 1) - f), ((p_149736_3_ + 1) - f), ((p_149736_4_ + 1) - f)));
/*     */       
/* 123 */       if (list.size() > 0) {
/* 124 */         return ((EntityMinecartCommandBlock)list.get(0)).func_145822_e().func_145760_g();
/*     */       }
/*     */       
/* 127 */       List<IInventory> list1 = p_149736_1_.func_82733_a(EntityMinecart.class, AxisAlignedBB.func_72330_a((p_149736_2_ + f), p_149736_3_, (p_149736_4_ + f), ((p_149736_2_ + 1) - f), ((p_149736_3_ + 1) - f), ((p_149736_4_ + 1) - f)), IEntitySelector.field_96566_b);
/*     */       
/* 129 */       if (list1.size() > 0) {
/* 130 */         return Container.func_94526_b(list1.get(0));
/*     */       }
/*     */     } 
/*     */     
/* 134 */     return 0;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149651_a(IIconRegister p_149651_1_) {
/* 139 */     this.field_150055_b = new IIcon[2];
/* 140 */     this.field_150055_b[0] = p_149651_1_.func_94245_a(func_149641_N());
/* 141 */     this.field_150055_b[1] = p_149651_1_.func_94245_a(func_149641_N() + "_powered");
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
/* 146 */     if ((p_149691_2_ & 0x8) != 0) {
/* 147 */       return this.field_150055_b[1];
/*     */     }
/* 149 */     return this.field_150055_b[0];
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockRailDetector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */