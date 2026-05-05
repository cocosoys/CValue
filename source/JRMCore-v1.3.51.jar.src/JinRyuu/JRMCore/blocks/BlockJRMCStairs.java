/*     */ package JinRyuu.JRMCore.blocks;
/*     */ 
/*     */ import JinRyuu.JRMCore.mod_JRMCore;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockStairs;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.Explosion;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class BlockJRMCStairs
/*     */   extends BlockStairs
/*     */ {
/*  26 */   private static final int[][] field_72159_a = new int[][] { { 2, 6 }, { 3, 7 }, { 2, 3 }, { 6, 7 }, { 0, 4 }, { 1, 5 }, { 0, 1 }, { 4, 5 } };
/*     */   
/*     */   private final Block modelBlock;
/*     */   
/*     */   private final int modelBlockMetadata;
/*     */   
/*     */   private boolean field_72156_cr;
/*     */   
/*     */   private int field_72160_cs;
/*     */   private String tex;
/*     */   
/*     */   public BlockJRMCStairs(Block par2Block, int par3, String tex) {
/*  38 */     super(par2Block, par3);
/*  39 */     this.modelBlock = par2Block;
/*  40 */     this.modelBlockMetadata = par3;
/*  41 */     func_149722_s();
/*  42 */     func_149752_b(6000000.0F);
/*  43 */     func_149647_a(mod_JRMCore.JRMCore);
/*  44 */     this.tex = tex;
/*  45 */     this.field_149783_u = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149719_a(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
/*  53 */     if (this.field_72156_cr) {
/*     */       
/*  55 */       func_149676_a(0.5F * (this.field_72160_cs % 2), 0.5F * (this.field_72160_cs / 2 % 2), 0.5F * (this.field_72160_cs / 4 % 2), 0.5F + 0.5F * (this.field_72160_cs % 2), 0.5F + 0.5F * (this.field_72160_cs / 2 % 2), 0.5F + 0.5F * (this.field_72160_cs / 4 % 2));
/*     */     }
/*     */     else {
/*     */       
/*  59 */       func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/*  69 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/*  77 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149645_b() {
/*  85 */     return 10;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_82541_d(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
/*  90 */     int l = par1IBlockAccess.func_72805_g(par2, par3, par4);
/*     */     
/*  92 */     if ((l & 0x4) != 0) {
/*     */       
/*  94 */       func_149676_a(0.0F, 0.5F, 0.0F, 1.0F, 1.0F, 1.0F);
/*     */     }
/*     */     else {
/*     */       
/*  98 */       func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
/*     */     } 
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
/*     */   public void func_149699_a(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer) {
/* 384 */     this.modelBlock.func_149699_a(par1World, par2, par3, par4, par5EntityPlayer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149734_b(World par1World, int par2, int par3, int par4, Random par5Random) {
/* 394 */     this.modelBlock.func_149734_b(par1World, par2, par3, par4, par5Random);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149664_b(World par1World, int par2, int par3, int par4, int par5) {
/* 402 */     this.modelBlock.func_149664_b(par1World, par2, par3, par4, par5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_149677_c(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
/* 412 */     return this.modelBlock.func_149677_c(par1IBlockAccess, par2, par3, par4);
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
/*     */   public float func_149638_a(Entity par1Entity) {
/* 430 */     return this.modelBlock.func_149638_a(par1Entity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149738_a(World par1World) {
/* 438 */     return this.modelBlock.func_149738_a(par1World);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149640_a(World par1World, int par2, int par3, int par4, Entity par5Entity, Vec3 par6Vec3) {
/* 446 */     this.modelBlock.func_149640_a(par1World, par2, par3, par4, par5Entity, par6Vec3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_149701_w() {
/* 456 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_149691_a(int par1, int par2) {
/* 466 */     return this.modelBlock.func_149691_a(par1, this.modelBlockMetadata);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public AxisAlignedBB func_149633_g(World par1World, int par2, int par3, int par4) {
/* 476 */     return this.modelBlock.func_149633_g(par1World, par2, par3, par4);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149703_v() {
/* 484 */     return this.modelBlock.func_149703_v();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149678_a(int par1, boolean par2) {
/* 493 */     return this.modelBlock.func_149678_a(par1, par2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149742_c(World par1World, int par2, int par3, int par4) {
/* 501 */     return this.modelBlock.func_149742_c(par1World, par2, par3, par4);
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
/*     */   public void func_149724_b(World par1World, int par2, int par3, int par4, Entity par5Entity) {
/* 526 */     this.modelBlock.func_149724_b(par1World, par2, par3, par4, par5Entity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149674_a(World par1World, int par2, int par3, int par4, Random par5Random) {
/* 534 */     this.modelBlock.func_149674_a(par1World, par2, par3, par4, par5Random);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149727_a(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
/* 542 */     return this.modelBlock.func_149727_a(par1World, par2, par3, par4, par5EntityPlayer, 0, 0.0F, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149723_a(World par1World, int par2, int par3, int par4, Explosion par5Explosion) {
/* 550 */     this.modelBlock.func_149723_a(par1World, par2, par3, par4, par5Explosion);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149689_a(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack) {
/* 558 */     int l = MathHelper.func_76128_c((par5EntityLivingBase.field_70177_z * 4.0F / 360.0F) + 0.5D) & 0x3;
/* 559 */     int i1 = par1World.func_72805_g(par2, par3, par4) & 0x4;
/*     */     
/* 561 */     if (l == 0)
/*     */     {
/* 563 */       par1World.func_72921_c(par2, par3, par4, 0x2 | i1, 2);
/*     */     }
/*     */     
/* 566 */     if (l == 1)
/*     */     {
/* 568 */       par1World.func_72921_c(par2, par3, par4, 0x1 | i1, 2);
/*     */     }
/*     */     
/* 571 */     if (l == 2)
/*     */     {
/* 573 */       par1World.func_72921_c(par2, par3, par4, 0x3 | i1, 2);
/*     */     }
/*     */     
/* 576 */     if (l == 3)
/*     */     {
/* 578 */       par1World.func_72921_c(par2, par3, par4, 0x0 | i1, 2);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149660_a(World par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8, int par9) {
/* 587 */     return (par5 != 0 && (par5 == 1 || par7 <= 0.5D)) ? par9 : (par9 | 0x4);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MovingObjectPosition func_149731_a(World par1World, int par2, int par3, int par4, Vec3 par5Vec3, Vec3 par6Vec3) {
/* 596 */     MovingObjectPosition[] amovingobjectposition = new MovingObjectPosition[8];
/* 597 */     int l = par1World.func_72805_g(par2, par3, par4);
/* 598 */     int i1 = l & 0x3;
/* 599 */     boolean flag = ((l & 0x4) == 4);
/* 600 */     int[] aint = field_72159_a[i1 + (flag ? 4 : 0)];
/* 601 */     this.field_72156_cr = true;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 606 */     for (int i2 = 0; i2 < 8; i2++) {
/*     */       
/* 608 */       this.field_72160_cs = i2;
/* 609 */       int[] aint1 = aint;
/* 610 */       int i = aint.length;
/*     */       
/* 612 */       for (int k1 = 0; k1 < i; k1++) {
/*     */         
/* 614 */         int j = aint1[k1];
/*     */         
/* 616 */         if (j == i2);
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 622 */       amovingobjectposition[i2] = super.func_149731_a(par1World, par2, par3, par4, par5Vec3, par6Vec3);
/*     */     } 
/*     */     
/* 625 */     int[] aint2 = aint;
/* 626 */     int j2 = aint.length;
/*     */     
/* 628 */     for (int j1 = 0; j1 < j2; j1++) {
/*     */       
/* 630 */       int k1 = aint2[j1];
/* 631 */       amovingobjectposition[k1] = null;
/*     */     } 
/*     */     
/* 634 */     MovingObjectPosition movingobjectposition = null;
/* 635 */     double d0 = 0.0D;
/* 636 */     MovingObjectPosition[] amovingobjectposition1 = amovingobjectposition;
/* 637 */     int l1 = amovingobjectposition.length;
/*     */     
/* 639 */     for (int k2 = 0; k2 < l1; k2++) {
/*     */       
/* 641 */       MovingObjectPosition movingobjectposition1 = amovingobjectposition1[k2];
/*     */       
/* 643 */       if (movingobjectposition1 != null) {
/*     */         
/* 645 */         double d1 = movingobjectposition1.field_72307_f.func_72436_e(par6Vec3);
/*     */         
/* 647 */         if (d1 > d0) {
/*     */           
/* 649 */           movingobjectposition = movingobjectposition1;
/* 650 */           d0 = d1;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 655 */     return movingobjectposition;
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149651_a(IIconRegister par1IconRegister) {
/* 661 */     this.field_149761_L = par1IconRegister.func_94245_a("jinryuumodscore:" + this.tex);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_149745_a(Random par1Random) {
/* 667 */     return 1;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\blocks\BlockJRMCStairs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */