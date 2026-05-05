/*     */ package net.minecraft.item;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class ItemBlock extends Item {
/*     */   public final Block field_150939_a;
/*     */   
/*     */   public ItemBlock(Block p_i45328_1_) {
/*  19 */     this.field_150939_a = p_i45328_1_;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   private IIcon field_150938_b; private static final String __OBFID = "CL_00001772";
/*     */   public ItemBlock func_77655_b(String p_77655_1_) {
/*  24 */     super.func_77655_b(p_77655_1_);
/*  25 */     return this;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_94901_k() {
/*  30 */     if (this.field_150939_a.func_149702_O() != null) {
/*  31 */       return 1;
/*     */     }
/*  33 */     return 0;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_77617_a(int p_77617_1_) {
/*  38 */     if (this.field_150938_b != null) {
/*  39 */       return this.field_150938_b;
/*     */     }
/*  41 */     return this.field_150939_a.func_149733_h(1);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_77648_a(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
/*  46 */     Block block = p_77648_3_.func_147439_a(p_77648_4_, p_77648_5_, p_77648_6_);
/*  47 */     if (block == Blocks.field_150431_aC && (p_77648_3_.func_72805_g(p_77648_4_, p_77648_5_, p_77648_6_) & 0x7) < 1) {
/*  48 */       p_77648_7_ = 1;
/*  49 */     } else if (block != Blocks.field_150395_bd && block != Blocks.field_150329_H && block != Blocks.field_150330_I) {
/*     */ 
/*     */       
/*  52 */       if (p_77648_7_ == 0) p_77648_5_--; 
/*  53 */       if (p_77648_7_ == 1) p_77648_5_++; 
/*  54 */       if (p_77648_7_ == 2) p_77648_6_--; 
/*  55 */       if (p_77648_7_ == 3) p_77648_6_++; 
/*  56 */       if (p_77648_7_ == 4) p_77648_4_--; 
/*  57 */       if (p_77648_7_ == 5) p_77648_4_++;
/*     */     
/*     */     } 
/*  60 */     if (p_77648_1_.field_77994_a == 0) return false; 
/*  61 */     if (!p_77648_2_.func_82247_a(p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_1_)) return false;
/*     */     
/*  63 */     if (p_77648_5_ == 255 && this.field_150939_a.func_149688_o().func_76220_a()) return false;
/*     */     
/*  65 */     if (p_77648_3_.func_147472_a(this.field_150939_a, p_77648_4_, p_77648_5_, p_77648_6_, false, p_77648_7_, (Entity)p_77648_2_, p_77648_1_)) {
/*  66 */       int i = func_77647_b(p_77648_1_.func_77960_j());
/*  67 */       int j = this.field_150939_a.func_149660_a(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_8_, p_77648_9_, p_77648_10_, i);
/*  68 */       if (p_77648_3_.func_147465_d(p_77648_4_, p_77648_5_, p_77648_6_, this.field_150939_a, j, 3)) {
/*     */ 
/*     */ 
/*     */         
/*  72 */         if (p_77648_3_.func_147439_a(p_77648_4_, p_77648_5_, p_77648_6_) == this.field_150939_a) {
/*  73 */           this.field_150939_a.func_149689_a(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_, (EntityLivingBase)p_77648_2_, p_77648_1_);
/*  74 */           this.field_150939_a.func_149714_e(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_, j);
/*     */         } 
/*  76 */         p_77648_3_.func_72908_a((p_77648_4_ + 0.5F), (p_77648_5_ + 0.5F), (p_77648_6_ + 0.5F), this.field_150939_a.field_149762_H.func_150496_b(), (this.field_150939_a.field_149762_H.func_150497_c() + 1.0F) / 2.0F, this.field_150939_a.field_149762_H.func_150494_d() * 0.8F);
/*  77 */         p_77648_1_.field_77994_a--;
/*     */       } 
/*  79 */       return true;
/*     */     } 
/*  81 */     return false;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_150936_a(World p_150936_1_, int p_150936_2_, int p_150936_3_, int p_150936_4_, int p_150936_5_, EntityPlayer p_150936_6_, ItemStack p_150936_7_) {
/*  85 */     Block block = p_150936_1_.func_147439_a(p_150936_2_, p_150936_3_, p_150936_4_);
/*  86 */     if (block == Blocks.field_150431_aC) {
/*  87 */       p_150936_5_ = 1;
/*  88 */     } else if (block != Blocks.field_150395_bd && block != Blocks.field_150329_H && block != Blocks.field_150330_I) {
/*  89 */       if (p_150936_5_ == 0) p_150936_3_--; 
/*  90 */       if (p_150936_5_ == 1) p_150936_3_++; 
/*  91 */       if (p_150936_5_ == 2) p_150936_4_--; 
/*  92 */       if (p_150936_5_ == 3) p_150936_4_++; 
/*  93 */       if (p_150936_5_ == 4) p_150936_2_--; 
/*  94 */       if (p_150936_5_ == 5) p_150936_2_++;
/*     */     
/*     */     } 
/*  97 */     return p_150936_1_.func_147472_a(this.field_150939_a, p_150936_2_, p_150936_3_, p_150936_4_, false, p_150936_5_, null, p_150936_7_);
/*     */   }
/*     */ 
/*     */   
/*     */   public String func_77667_c(ItemStack p_77667_1_) {
/* 102 */     return this.field_150939_a.func_149739_a();
/*     */   }
/*     */ 
/*     */   
/*     */   public String func_77658_a() {
/* 107 */     return this.field_150939_a.func_149739_a();
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public CreativeTabs func_77640_w() {
/* 112 */     return this.field_150939_a.func_149708_J();
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_150895_a(Item p_150895_1_, CreativeTabs p_150895_2_, List p_150895_3_) {
/* 117 */     this.field_150939_a.func_149666_a(p_150895_1_, p_150895_2_, p_150895_3_);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_94581_a(IIconRegister p_94581_1_) {
/* 122 */     String str = this.field_150939_a.func_149702_O();
/* 123 */     if (str != null)
/* 124 */       this.field_150938_b = p_94581_1_.func_94245_a(str); 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\item\ItemBlock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */