/*     */ package net.minecraft.item;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.BlockDispenser;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.command.IEntitySelector;
/*     */ import net.minecraft.dispenser.BehaviorDefaultDispenseItem;
/*     */ import net.minecraft.dispenser.IBehaviorDispenseItem;
/*     */ import net.minecraft.dispenser.IBlockSource;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraft.util.IIcon;
/*     */ 
/*     */ public class ItemArmor extends Item {
/*  22 */   private static final int[] field_77882_bY = new int[] { 11, 16, 15, 13 };
/*     */ 
/*     */ 
/*     */   
/*  26 */   private static final String[] field_94606_cu = new String[] { "leather_helmet_overlay", "leather_chestplate_overlay", "leather_leggings_overlay", "leather_boots_overlay" };
/*     */ 
/*     */ 
/*     */   
/*  30 */   public static final String[] field_94603_a = new String[] { "empty_armor_slot_helmet", "empty_armor_slot_chestplate", "empty_armor_slot_leggings", "empty_armor_slot_boots" };
/*     */ 
/*     */ 
/*     */   
/*  34 */   private static final IBehaviorDispenseItem field_96605_cw = (IBehaviorDispenseItem)new BehaviorDefaultDispenseItem() { private static final String __OBFID = "CL_00001767";
/*     */       
/*     */       protected ItemStack func_82487_b(IBlockSource p_82487_1_, ItemStack p_82487_2_) {
/*  37 */         EnumFacing enumFacing = BlockDispenser.func_149937_b(p_82487_1_.func_82620_h());
/*  38 */         int i = p_82487_1_.func_82623_d() + enumFacing.func_82601_c();
/*  39 */         int j = p_82487_1_.func_82622_e() + enumFacing.func_96559_d();
/*  40 */         int k = p_82487_1_.func_82621_f() + enumFacing.func_82599_e();
/*  41 */         AxisAlignedBB axisAlignedBB = AxisAlignedBB.func_72330_a(i, j, k, (i + 1), (j + 1), (k + 1));
/*  42 */         List<EntityLivingBase> list = p_82487_1_.func_82618_k().func_82733_a(EntityLivingBase.class, axisAlignedBB, (IEntitySelector)new IEntitySelector.ArmoredMob(p_82487_2_));
/*     */         
/*  44 */         if (list.size() > 0) {
/*  45 */           EntityLivingBase entityLivingBase = list.get(0);
/*  46 */           byte b = (entityLivingBase instanceof EntityPlayer) ? 1 : 0;
/*  47 */           int m = EntityLiving.func_82159_b(p_82487_2_);
/*  48 */           ItemStack itemStack = p_82487_2_.func_77946_l();
/*  49 */           itemStack.field_77994_a = 1;
/*  50 */           entityLivingBase.func_70062_b(m - b, itemStack);
/*  51 */           if (entityLivingBase instanceof EntityLiving) ((EntityLiving)entityLivingBase).func_96120_a(m, 2.0F); 
/*  52 */           p_82487_2_.field_77994_a--;
/*  53 */           return p_82487_2_;
/*     */         } 
/*  55 */         return super.func_82487_b(p_82487_1_, p_82487_2_);
/*     */       } }
/*     */   ; public final int field_77881_a; public final int field_77879_b; public final int field_77880_c; private final ArmorMaterial field_77878_bZ; @SideOnly(Side.CLIENT)
/*     */   private IIcon field_94605_cw; @SideOnly(Side.CLIENT)
/*     */   private IIcon field_94604_cx; private static final String __OBFID = "CL_00001766";
/*     */   
/*  61 */   public enum ArmorMaterial { CLOTH(5, new int[] { 1, 3, 2, 1 }, 15),
/*     */     
/*  63 */     CHAIN(15, new int[] { 2, 5, 4, 1 }, 12),
/*     */     
/*  65 */     IRON(15, new int[] { 2, 6, 5, 2 }, 9),
/*     */     
/*  67 */     GOLD(7, new int[] { 2, 5, 3, 1 }, 25),
/*     */     
/*  69 */     DIAMOND(33, new int[] { 3, 8, 6, 3 }, 10);
/*     */     
/*     */     private int field_78048_f;
/*     */     
/*     */     private int[] field_78049_g;
/*     */     private int field_78055_h;
/*     */     private static final String __OBFID = "CL_00001768";
/*     */     
/*     */     ArmorMaterial(int p_i1827_3_, int[] p_i1827_4_, int p_i1827_5_) {
/*  78 */       this.field_78048_f = p_i1827_3_;
/*  79 */       this.field_78049_g = p_i1827_4_;
/*  80 */       this.field_78055_h = p_i1827_5_;
/*     */     }
/*     */     
/*     */     public int func_78046_a(int p_78046_1_) {
/*  84 */       return ItemArmor.field_77882_bY[p_78046_1_] * this.field_78048_f;
/*     */     }
/*     */     
/*     */     public int func_78044_b(int p_78044_1_) {
/*  88 */       return this.field_78049_g[p_78044_1_];
/*     */     }
/*     */     
/*     */     public int func_78045_a() {
/*  92 */       return this.field_78055_h;
/*     */     }
/*     */     
/*     */     public Item func_151685_b() {
/*  96 */       if (this == CLOTH)
/*  97 */         return Items.field_151116_aA; 
/*  98 */       if (this == CHAIN)
/*  99 */         return Items.field_151042_j; 
/* 100 */       if (this == GOLD)
/* 101 */         return Items.field_151043_k; 
/* 102 */       if (this == IRON)
/* 103 */         return Items.field_151042_j; 
/* 104 */       if (this == DIAMOND) {
/* 105 */         return Items.field_151045_i;
/*     */       }
/* 107 */       return null;
/*     */     } }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemArmor(ArmorMaterial p_i45325_1_, int p_i45325_2_, int p_i45325_3_) {
/* 119 */     this.field_77878_bZ = p_i45325_1_;
/* 120 */     this.field_77881_a = p_i45325_3_;
/* 121 */     this.field_77880_c = p_i45325_2_;
/* 122 */     this.field_77879_b = p_i45325_1_.func_78044_b(p_i45325_3_);
/* 123 */     func_77656_e(p_i45325_1_.func_78046_a(p_i45325_3_));
/* 124 */     this.field_77777_bU = 1;
/* 125 */     func_77637_a(CreativeTabs.field_78037_j);
/* 126 */     BlockDispenser.field_149943_a.func_82595_a(this, field_96605_cw);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_82790_a(ItemStack p_82790_1_, int p_82790_2_) {
/* 131 */     if (p_82790_2_ > 0) {
/* 132 */       return 16777215;
/*     */     }
/*     */     
/* 135 */     int i = func_82814_b(p_82790_1_);
/* 136 */     if (i < 0) i = 16777215; 
/* 137 */     return i;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_77623_v() {
/* 142 */     return (this.field_77878_bZ == ArmorMaterial.CLOTH);
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_77619_b() {
/* 147 */     return this.field_77878_bZ.func_78045_a();
/*     */   }
/*     */   
/*     */   public ArmorMaterial func_82812_d() {
/* 151 */     return this.field_77878_bZ;
/*     */   }
/*     */   
/*     */   public boolean func_82816_b_(ItemStack p_82816_1_) {
/* 155 */     if (this.field_77878_bZ != ArmorMaterial.CLOTH) return false; 
/* 156 */     if (!p_82816_1_.func_77942_o()) return false; 
/* 157 */     if (!p_82816_1_.func_77978_p().func_150297_b("display", 10)) return false; 
/* 158 */     if (!p_82816_1_.func_77978_p().func_74775_l("display").func_150297_b("color", 3)) return false;
/*     */     
/* 160 */     return true;
/*     */   }
/*     */   
/*     */   public int func_82814_b(ItemStack p_82814_1_) {
/* 164 */     if (this.field_77878_bZ != ArmorMaterial.CLOTH) return -1;
/*     */     
/* 166 */     NBTTagCompound nBTTagCompound1 = p_82814_1_.func_77978_p();
/* 167 */     if (nBTTagCompound1 == null) return 10511680; 
/* 168 */     NBTTagCompound nBTTagCompound2 = nBTTagCompound1.func_74775_l("display");
/* 169 */     if (nBTTagCompound2 == null) return 10511680;
/*     */     
/* 171 */     if (nBTTagCompound2.func_150297_b("color", 3)) {
/* 172 */       return nBTTagCompound2.func_74762_e("color");
/*     */     }
/* 174 */     return 10511680;
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_77618_c(int p_77618_1_, int p_77618_2_) {
/* 180 */     if (p_77618_2_ == 1) {
/* 181 */       return this.field_94605_cw;
/*     */     }
/* 183 */     return super.func_77618_c(p_77618_1_, p_77618_2_);
/*     */   }
/*     */   
/*     */   public void func_82815_c(ItemStack p_82815_1_) {
/* 187 */     if (this.field_77878_bZ != ArmorMaterial.CLOTH)
/* 188 */       return;  NBTTagCompound nBTTagCompound1 = p_82815_1_.func_77978_p();
/* 189 */     if (nBTTagCompound1 == null)
/* 190 */       return;  NBTTagCompound nBTTagCompound2 = nBTTagCompound1.func_74775_l("display");
/* 191 */     if (nBTTagCompound2.func_74764_b("color")) nBTTagCompound2.func_82580_o("color"); 
/*     */   }
/*     */   
/*     */   public void func_82813_b(ItemStack p_82813_1_, int p_82813_2_) {
/* 195 */     if (this.field_77878_bZ != ArmorMaterial.CLOTH) throw new UnsupportedOperationException("Can't dye non-leather!");
/*     */     
/* 197 */     NBTTagCompound nBTTagCompound1 = p_82813_1_.func_77978_p();
/*     */     
/* 199 */     if (nBTTagCompound1 == null) {
/* 200 */       nBTTagCompound1 = new NBTTagCompound();
/* 201 */       p_82813_1_.func_77982_d(nBTTagCompound1);
/*     */     } 
/*     */     
/* 204 */     NBTTagCompound nBTTagCompound2 = nBTTagCompound1.func_74775_l("display");
/* 205 */     if (!nBTTagCompound1.func_150297_b("display", 10)) nBTTagCompound1.func_74782_a("display", (NBTBase)nBTTagCompound2); 
/* 206 */     nBTTagCompound2.func_74768_a("color", p_82813_2_);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_82789_a(ItemStack p_82789_1_, ItemStack p_82789_2_) {
/* 211 */     if (this.field_77878_bZ.func_151685_b() == p_82789_2_.func_77973_b()) {
/* 212 */       return true;
/*     */     }
/* 214 */     return super.func_82789_a(p_82789_1_, p_82789_2_);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_94581_a(IIconRegister p_94581_1_) {
/* 219 */     super.func_94581_a(p_94581_1_);
/*     */     
/* 221 */     if (this.field_77878_bZ == ArmorMaterial.CLOTH) {
/* 222 */       this.field_94605_cw = p_94581_1_.func_94245_a(field_94606_cu[this.field_77881_a]);
/*     */     }
/*     */     
/* 225 */     this.field_94604_cx = p_94581_1_.func_94245_a(field_94603_a[this.field_77881_a]);
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack func_77659_a(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_) {
/* 230 */     int i = EntityLiving.func_82159_b(p_77659_1_) - 1;
/* 231 */     ItemStack itemStack = p_77659_3_.func_82169_q(i);
/*     */     
/* 233 */     if (itemStack == null) {
/* 234 */       p_77659_3_.func_70062_b(i, p_77659_1_.func_77946_l());
/* 235 */       p_77659_1_.field_77994_a = 0;
/*     */     } 
/*     */     
/* 238 */     return p_77659_1_;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public static IIcon func_94602_b(int p_94602_0_) {
/* 242 */     switch (p_94602_0_) {
/*     */       case 0:
/* 244 */         return Items.field_151161_ac.field_94604_cx;
/*     */       case 1:
/* 246 */         return Items.field_151163_ad.field_94604_cx;
/*     */       case 2:
/* 248 */         return Items.field_151173_ae.field_94604_cx;
/*     */       case 3:
/* 250 */         return Items.field_151175_af.field_94604_cx;
/*     */     } 
/*     */     
/* 253 */     return null;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\item\ItemArmor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */