/*     */ package net.minecraft.block;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class BlockJukebox extends BlockContainer {
/*     */   @SideOnly(Side.CLIENT)
/*     */   private IIcon field_149927_a;
/*     */   private static final String __OBFID = "CL_00000260";
/*     */   
/*     */   public static class TileEntityJukebox extends TileEntity {
/*     */     private ItemStack field_145858_a;
/*     */     
/*     */     public void func_145839_a(NBTTagCompound p_145839_1_) {
/*  20 */       super.func_145839_a(p_145839_1_);
/*     */       
/*  22 */       if (p_145839_1_.func_150297_b("RecordItem", 10)) {
/*  23 */         func_145857_a(ItemStack.func_77949_a(p_145839_1_.func_74775_l("RecordItem")));
/*  24 */       } else if (p_145839_1_.func_74762_e("Record") > 0) {
/*  25 */         func_145857_a(new ItemStack(Item.func_150899_d(p_145839_1_.func_74762_e("Record")), 1, 0));
/*     */       } 
/*     */     }
/*     */     private static final String __OBFID = "CL_00000261";
/*     */     
/*     */     public void func_145841_b(NBTTagCompound p_145841_1_) {
/*  31 */       super.func_145841_b(p_145841_1_);
/*     */       
/*  33 */       if (func_145856_a() != null) {
/*  34 */         p_145841_1_.func_74782_a("RecordItem", (NBTBase)func_145856_a().func_77955_b(new NBTTagCompound()));
/*  35 */         p_145841_1_.func_74768_a("Record", Item.func_150891_b(func_145856_a().func_77973_b()));
/*     */       } 
/*     */     }
/*     */     
/*     */     public ItemStack func_145856_a() {
/*  40 */       return this.field_145858_a;
/*     */     }
/*     */     
/*     */     public void func_145857_a(ItemStack p_145857_1_) {
/*  44 */       this.field_145858_a = p_145857_1_;
/*  45 */       func_70296_d();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected BlockJukebox() {
/*  52 */     super(Material.field_151575_d);
/*  53 */     func_149647_a(CreativeTabs.field_78031_c);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
/*  58 */     if (p_149691_1_ == 1) {
/*  59 */       return this.field_149927_a;
/*     */     }
/*  61 */     return this.field_149761_L;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149727_a(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
/*  66 */     if (p_149727_1_.func_72805_g(p_149727_2_, p_149727_3_, p_149727_4_) == 0) return false; 
/*  67 */     func_149925_e(p_149727_1_, p_149727_2_, p_149727_3_, p_149727_4_);
/*  68 */     return true;
/*     */   }
/*     */   
/*     */   public void func_149926_b(World p_149926_1_, int p_149926_2_, int p_149926_3_, int p_149926_4_, ItemStack p_149926_5_) {
/*  72 */     if (p_149926_1_.field_72995_K)
/*     */       return; 
/*  74 */     TileEntityJukebox tileEntityJukebox = (TileEntityJukebox)p_149926_1_.func_147438_o(p_149926_2_, p_149926_3_, p_149926_4_);
/*  75 */     if (tileEntityJukebox == null)
/*     */       return; 
/*  77 */     tileEntityJukebox.func_145857_a(p_149926_5_.func_77946_l());
/*     */     
/*  79 */     p_149926_1_.func_72921_c(p_149926_2_, p_149926_3_, p_149926_4_, 1, 2);
/*     */   }
/*     */   
/*     */   public void func_149925_e(World p_149925_1_, int p_149925_2_, int p_149925_3_, int p_149925_4_) {
/*  83 */     if (p_149925_1_.field_72995_K)
/*     */       return; 
/*  85 */     TileEntityJukebox tileEntityJukebox = (TileEntityJukebox)p_149925_1_.func_147438_o(p_149925_2_, p_149925_3_, p_149925_4_);
/*  86 */     if (tileEntityJukebox == null)
/*     */       return; 
/*  88 */     ItemStack itemStack1 = tileEntityJukebox.func_145856_a();
/*  89 */     if (itemStack1 == null)
/*     */       return; 
/*  91 */     p_149925_1_.func_72926_e(1005, p_149925_2_, p_149925_3_, p_149925_4_, 0);
/*  92 */     p_149925_1_.func_72934_a(null, p_149925_2_, p_149925_3_, p_149925_4_);
/*  93 */     tileEntityJukebox.func_145857_a(null);
/*  94 */     p_149925_1_.func_72921_c(p_149925_2_, p_149925_3_, p_149925_4_, 0, 2);
/*     */     
/*  96 */     float f = 0.7F;
/*  97 */     double d1 = (p_149925_1_.field_73012_v.nextFloat() * f) + (1.0F - f) * 0.5D;
/*  98 */     double d2 = (p_149925_1_.field_73012_v.nextFloat() * f) + (1.0F - f) * 0.2D + 0.6D;
/*  99 */     double d3 = (p_149925_1_.field_73012_v.nextFloat() * f) + (1.0F - f) * 0.5D;
/*     */     
/* 101 */     ItemStack itemStack2 = itemStack1.func_77946_l();
/*     */     
/* 103 */     EntityItem entityItem = new EntityItem(p_149925_1_, p_149925_2_ + d1, p_149925_3_ + d2, p_149925_4_ + d3, itemStack2);
/* 104 */     entityItem.field_145804_b = 10;
/* 105 */     p_149925_1_.func_72838_d((Entity)entityItem);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149749_a(World p_149749_1_, int p_149749_2_, int p_149749_3_, int p_149749_4_, Block p_149749_5_, int p_149749_6_) {
/* 110 */     func_149925_e(p_149749_1_, p_149749_2_, p_149749_3_, p_149749_4_);
/* 111 */     super.func_149749_a(p_149749_1_, p_149749_2_, p_149749_3_, p_149749_4_, p_149749_5_, p_149749_6_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149690_a(World p_149690_1_, int p_149690_2_, int p_149690_3_, int p_149690_4_, int p_149690_5_, float p_149690_6_, int p_149690_7_) {
/* 116 */     if (p_149690_1_.field_72995_K)
/* 117 */       return;  super.func_149690_a(p_149690_1_, p_149690_2_, p_149690_3_, p_149690_4_, p_149690_5_, p_149690_6_, 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public TileEntity func_149915_a(World p_149915_1_, int p_149915_2_) {
/* 122 */     return new TileEntityJukebox();
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149651_a(IIconRegister p_149651_1_) {
/* 127 */     this.field_149761_L = p_149651_1_.func_94245_a(func_149641_N() + "_side");
/* 128 */     this.field_149927_a = p_149651_1_.func_94245_a(func_149641_N() + "_top");
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149740_M() {
/* 133 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_149736_g(World p_149736_1_, int p_149736_2_, int p_149736_3_, int p_149736_4_, int p_149736_5_) {
/* 138 */     ItemStack itemStack = ((TileEntityJukebox)p_149736_1_.func_147438_o(p_149736_2_, p_149736_3_, p_149736_4_)).func_145856_a();
/*     */     
/* 140 */     return (itemStack == null) ? 0 : (Item.func_150891_b(itemStack.func_77973_b()) + 1 - Item.func_150891_b(Items.field_151096_cd));
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockJukebox.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */