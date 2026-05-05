/*     */ package net.minecraft.item;
/*     */ 
/*     */ import com.mojang.authlib.GameProfile;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.BlockSkull;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTUtil;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.tileentity.TileEntitySkull;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.StatCollector;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class ItemSkull
/*     */   extends Item {
/*  23 */   private static final String[] field_82807_a = new String[] { "skeleton", "wither", "zombie", "char", "creeper" };
/*     */ 
/*     */ 
/*     */   
/*  27 */   public static final String[] field_94587_a = new String[] { "skeleton", "wither", "zombie", "steve", "creeper" };
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   private IIcon[] field_94586_c;
/*     */   private static final String __OBFID = "CL_00000067";
/*     */   
/*     */   public ItemSkull() {
/*  34 */     func_77637_a(CreativeTabs.field_78031_c);
/*  35 */     func_77656_e(0);
/*  36 */     func_77627_a(true);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_77648_a(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
/*  41 */     if (p_77648_7_ == 0) return false; 
/*  42 */     if (!p_77648_3_.func_147439_a(p_77648_4_, p_77648_5_, p_77648_6_).func_149688_o().func_76220_a()) return false;
/*     */     
/*  44 */     if (p_77648_7_ == 1) p_77648_5_++;
/*     */     
/*  46 */     if (p_77648_7_ == 2) p_77648_6_--; 
/*  47 */     if (p_77648_7_ == 3) p_77648_6_++; 
/*  48 */     if (p_77648_7_ == 4) p_77648_4_--; 
/*  49 */     if (p_77648_7_ == 5) p_77648_4_++;
/*     */     
/*  51 */     if (!p_77648_3_.field_72995_K) {
/*  52 */       p_77648_3_.func_147465_d(p_77648_4_, p_77648_5_, p_77648_6_, Blocks.field_150465_bP, p_77648_7_, 2);
/*     */       
/*  54 */       int i = 0;
/*  55 */       if (p_77648_7_ == 1) {
/*  56 */         i = MathHelper.func_76128_c((p_77648_2_.field_70177_z * 16.0F / 360.0F) + 0.5D) & 0xF;
/*     */       }
/*     */       
/*  59 */       TileEntity tileEntity = p_77648_3_.func_147438_o(p_77648_4_, p_77648_5_, p_77648_6_);
/*  60 */       if (tileEntity != null && tileEntity instanceof TileEntitySkull) {
/*  61 */         if (p_77648_1_.func_77960_j() == 3) {
/*  62 */           GameProfile gameProfile = null;
/*  63 */           if (p_77648_1_.func_77942_o()) {
/*  64 */             NBTTagCompound nBTTagCompound = p_77648_1_.func_77978_p();
/*     */             
/*  66 */             if (nBTTagCompound.func_150297_b("SkullOwner", 10)) {
/*  67 */               gameProfile = NBTUtil.func_152459_a(nBTTagCompound.func_74775_l("SkullOwner"));
/*  68 */             } else if (nBTTagCompound.func_150297_b("SkullOwner", 8) && nBTTagCompound.func_74779_i("SkullOwner").length() > 0) {
/*  69 */               gameProfile = new GameProfile(null, nBTTagCompound.func_74779_i("SkullOwner"));
/*     */             } 
/*     */           } 
/*     */           
/*  73 */           ((TileEntitySkull)tileEntity).func_152106_a(gameProfile);
/*     */         } else {
/*  75 */           ((TileEntitySkull)tileEntity).func_152107_a(p_77648_1_.func_77960_j());
/*     */         } 
/*  77 */         ((TileEntitySkull)tileEntity).func_145903_a(i);
/*  78 */         ((BlockSkull)Blocks.field_150465_bP).func_149965_a(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_, (TileEntitySkull)tileEntity);
/*     */       } 
/*     */       
/*  81 */       p_77648_1_.field_77994_a--;
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
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_150895_a(Item p_150895_1_, CreativeTabs p_150895_2_, List<ItemStack> p_150895_3_) {
/* 105 */     for (byte b = 0; b < field_82807_a.length; b++) {
/* 106 */       p_150895_3_.add(new ItemStack(p_150895_1_, 1, b));
/*     */     }
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_77617_a(int p_77617_1_) {
/* 112 */     if (p_77617_1_ < 0 || p_77617_1_ >= field_82807_a.length) {
/* 113 */       p_77617_1_ = 0;
/*     */     }
/* 115 */     return this.field_94586_c[p_77617_1_];
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_77647_b(int p_77647_1_) {
/* 120 */     return p_77647_1_;
/*     */   }
/*     */ 
/*     */   
/*     */   public String func_77667_c(ItemStack p_77667_1_) {
/* 125 */     int i = p_77667_1_.func_77960_j();
/* 126 */     if (i < 0 || i >= field_82807_a.length) {
/* 127 */       i = 0;
/*     */     }
/* 129 */     return func_77658_a() + "." + field_82807_a[i];
/*     */   }
/*     */ 
/*     */   
/*     */   public String func_77653_i(ItemStack p_77653_1_) {
/* 134 */     if (p_77653_1_.func_77960_j() == 3 && p_77653_1_.func_77942_o()) {
/* 135 */       if (p_77653_1_.func_77978_p().func_150297_b("SkullOwner", 10))
/* 136 */         return StatCollector.func_74837_a("item.skull.player.name", new Object[] { NBTUtil.func_152459_a(p_77653_1_.func_77978_p().func_74775_l("SkullOwner")).getName() }); 
/* 137 */       if (p_77653_1_.func_77978_p().func_150297_b("SkullOwner", 8)) {
/* 138 */         return StatCollector.func_74837_a("item.skull.player.name", new Object[] { p_77653_1_.func_77978_p().func_74779_i("SkullOwner") });
/*     */       }
/*     */     } 
/*     */     
/* 142 */     return super.func_77653_i(p_77653_1_);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_94581_a(IIconRegister p_94581_1_) {
/* 147 */     this.field_94586_c = new IIcon[field_94587_a.length];
/*     */     
/* 149 */     for (byte b = 0; b < field_94587_a.length; b++)
/* 150 */       this.field_94586_c[b] = p_94581_1_.func_94245_a(func_111208_A() + "_" + field_94587_a[b]); 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\item\ItemSkull.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */