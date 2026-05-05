/*     */ package net.minecraft.inventory;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.enchantment.EnchantmentData;
/*     */ import net.minecraft.enchantment.EnchantmentHelper;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.InventoryPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class ContainerEnchantment extends Container {
/*  18 */   public IInventory field_75168_e = new InventoryBasic(this, "Enchant", true, 1)
/*     */     {
/*     */       public int func_70297_j_() {
/*  21 */         return 1;
/*     */       }
/*     */       private static final String __OBFID = "CL_00001746";
/*     */       
/*     */       public void func_70296_d() {
/*  26 */         super.func_70296_d();
/*  27 */         this.field_70484_a.func_75130_a(this);
/*     */       }
/*     */     };
/*     */   private World field_75172_h;
/*     */   private int field_75173_i;
/*     */   private int field_75170_j;
/*     */   private int field_75171_k;
/*  34 */   private Random field_75169_l = new Random();
/*     */   
/*     */   public long field_75166_f;
/*  37 */   public int[] field_75167_g = new int[3]; private static final String __OBFID = "CL_00001745";
/*     */   
/*     */   public ContainerEnchantment(InventoryPlayer p_i1811_1_, World p_i1811_2_, int p_i1811_3_, int p_i1811_4_, int p_i1811_5_) {
/*  40 */     this.field_75172_h = p_i1811_2_;
/*  41 */     this.field_75173_i = p_i1811_3_;
/*  42 */     this.field_75170_j = p_i1811_4_;
/*  43 */     this.field_75171_k = p_i1811_5_;
/*  44 */     func_75146_a(new Slot(this, this.field_75168_e, 0, 25, 47) { private static final String __OBFID = "CL_00001747";
/*     */           
/*     */           public boolean func_75214_a(ItemStack p_75214_1_) {
/*  47 */             return true;
/*     */           } }
/*     */       );
/*     */     byte b;
/*  51 */     for (b = 0; b < 3; b++) {
/*  52 */       for (byte b1 = 0; b1 < 9; b1++) {
/*  53 */         func_75146_a(new Slot((IInventory)p_i1811_1_, b1 + b * 9 + 9, 8 + b1 * 18, 84 + b * 18));
/*     */       }
/*     */     } 
/*  56 */     for (b = 0; b < 9; b++) {
/*  57 */       func_75146_a(new Slot((IInventory)p_i1811_1_, b, 8 + b * 18, 142));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_75132_a(ICrafting p_75132_1_) {
/*  63 */     super.func_75132_a(p_75132_1_);
/*     */     
/*  65 */     p_75132_1_.func_71112_a(this, 0, this.field_75167_g[0]);
/*  66 */     p_75132_1_.func_71112_a(this, 1, this.field_75167_g[1]);
/*  67 */     p_75132_1_.func_71112_a(this, 2, this.field_75167_g[2]);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_75142_b() {
/*  72 */     super.func_75142_b();
/*     */     
/*  74 */     for (byte b = 0; b < this.field_75149_d.size(); b++) {
/*  75 */       ICrafting iCrafting = this.field_75149_d.get(b);
/*  76 */       iCrafting.func_71112_a(this, 0, this.field_75167_g[0]);
/*  77 */       iCrafting.func_71112_a(this, 1, this.field_75167_g[1]);
/*  78 */       iCrafting.func_71112_a(this, 2, this.field_75167_g[2]);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_75137_b(int p_75137_1_, int p_75137_2_) {
/*  85 */     if (p_75137_1_ >= 0 && p_75137_1_ <= 2) {
/*  86 */       this.field_75167_g[p_75137_1_] = p_75137_2_;
/*     */     } else {
/*  88 */       super.func_75137_b(p_75137_1_, p_75137_2_);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_75130_a(IInventory p_75130_1_) {
/*  94 */     if (p_75130_1_ == this.field_75168_e) {
/*  95 */       ItemStack itemStack = p_75130_1_.func_70301_a(0);
/*     */       
/*  97 */       if (itemStack == null || !itemStack.func_77956_u()) {
/*  98 */         for (byte b = 0; b < 3; b++) {
/*  99 */           this.field_75167_g[b] = 0;
/*     */         }
/*     */       } else {
/* 102 */         this.field_75166_f = this.field_75169_l.nextLong();
/*     */         
/* 104 */         if (!this.field_75172_h.field_72995_K) {
/*     */           
/* 106 */           byte b = 0; byte b1;
/* 107 */           for (b1 = -1; b1 <= 1; b1++) {
/* 108 */             for (byte b2 = -1; b2 <= 1; b2++) {
/* 109 */               if (b1 != 0 || b2 != 0)
/*     */               {
/*     */ 
/*     */                 
/* 113 */                 if (this.field_75172_h.func_147437_c(this.field_75173_i + b2, this.field_75170_j, this.field_75171_k + b1) && this.field_75172_h.func_147437_c(this.field_75173_i + b2, this.field_75170_j + 1, this.field_75171_k + b1)) {
/* 114 */                   if (this.field_75172_h.func_147439_a(this.field_75173_i + b2 * 2, this.field_75170_j, this.field_75171_k + b1 * 2) == Blocks.field_150342_X) {
/* 115 */                     b++;
/*     */                   }
/* 117 */                   if (this.field_75172_h.func_147439_a(this.field_75173_i + b2 * 2, this.field_75170_j + 1, this.field_75171_k + b1 * 2) == Blocks.field_150342_X) {
/* 118 */                     b++;
/*     */                   }
/*     */                   
/* 121 */                   if (b2 != 0 && b1 != 0) {
/* 122 */                     if (this.field_75172_h.func_147439_a(this.field_75173_i + b2 * 2, this.field_75170_j, this.field_75171_k + b1) == Blocks.field_150342_X) {
/* 123 */                       b++;
/*     */                     }
/* 125 */                     if (this.field_75172_h.func_147439_a(this.field_75173_i + b2 * 2, this.field_75170_j + 1, this.field_75171_k + b1) == Blocks.field_150342_X) {
/* 126 */                       b++;
/*     */                     }
/* 128 */                     if (this.field_75172_h.func_147439_a(this.field_75173_i + b2, this.field_75170_j, this.field_75171_k + b1 * 2) == Blocks.field_150342_X) {
/* 129 */                       b++;
/*     */                     }
/* 131 */                     if (this.field_75172_h.func_147439_a(this.field_75173_i + b2, this.field_75170_j + 1, this.field_75171_k + b1 * 2) == Blocks.field_150342_X) {
/* 132 */                       b++;
/*     */                     }
/*     */                   } 
/*     */                 } 
/*     */               }
/*     */             } 
/*     */           } 
/* 139 */           for (b1 = 0; b1 < 3; b1++) {
/* 140 */             this.field_75167_g[b1] = EnchantmentHelper.func_77514_a(this.field_75169_l, b1, b, itemStack);
/*     */           }
/* 142 */           func_75142_b();
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_75140_a(EntityPlayer p_75140_1_, int p_75140_2_) {
/* 150 */     ItemStack itemStack = this.field_75168_e.func_70301_a(0);
/* 151 */     if (this.field_75167_g[p_75140_2_] > 0 && itemStack != null && (p_75140_1_.field_71068_ca >= this.field_75167_g[p_75140_2_] || p_75140_1_.field_71075_bZ.field_75098_d)) {
/*     */       
/* 153 */       if (!this.field_75172_h.field_72995_K) {
/* 154 */         List<EnchantmentData> list = EnchantmentHelper.func_77513_b(this.field_75169_l, itemStack, this.field_75167_g[p_75140_2_]);
/* 155 */         boolean bool = (itemStack.func_77973_b() == Items.field_151122_aG) ? true : false;
/*     */         
/* 157 */         if (list != null) {
/* 158 */           p_75140_1_.func_82242_a(-this.field_75167_g[p_75140_2_]);
/* 159 */           if (bool) itemStack.func_150996_a((Item)Items.field_151134_bR); 
/* 160 */           byte b1 = (bool && list.size() > 1) ? this.field_75169_l.nextInt(list.size()) : -1;
/*     */           
/* 162 */           for (byte b2 = 0; b2 < list.size(); b2++) {
/* 163 */             EnchantmentData enchantmentData = list.get(b2);
/* 164 */             if (!bool || b2 != b1)
/*     */             {
/* 166 */               if (bool) {
/* 167 */                 Items.field_151134_bR.func_92115_a(itemStack, enchantmentData);
/*     */               } else {
/* 169 */                 itemStack.func_77966_a(enchantmentData.field_76302_b, enchantmentData.field_76303_c);
/*     */               } 
/*     */             }
/*     */           } 
/* 173 */           func_75130_a(this.field_75168_e);
/*     */         } 
/*     */       } 
/* 176 */       return true;
/*     */     } 
/* 178 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_75134_a(EntityPlayer p_75134_1_) {
/* 183 */     super.func_75134_a(p_75134_1_);
/* 184 */     if (this.field_75172_h.field_72995_K)
/*     */       return; 
/* 186 */     ItemStack itemStack = this.field_75168_e.func_70304_b(0);
/* 187 */     if (itemStack != null) {
/* 188 */       p_75134_1_.func_71019_a(itemStack, false);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_75145_c(EntityPlayer p_75145_1_) {
/* 194 */     if (this.field_75172_h.func_147439_a(this.field_75173_i, this.field_75170_j, this.field_75171_k) != Blocks.field_150381_bn) return false; 
/* 195 */     if (p_75145_1_.func_70092_e(this.field_75173_i + 0.5D, this.field_75170_j + 0.5D, this.field_75171_k + 0.5D) > 64.0D) return false; 
/* 196 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack func_82846_b(EntityPlayer p_82846_1_, int p_82846_2_) {
/* 201 */     ItemStack itemStack = null;
/* 202 */     Slot slot = this.field_75151_b.get(p_82846_2_);
/* 203 */     if (slot != null && slot.func_75216_d()) {
/* 204 */       ItemStack itemStack1 = slot.func_75211_c();
/* 205 */       itemStack = itemStack1.func_77946_l();
/*     */       
/* 207 */       if (p_82846_2_ == 0) {
/* 208 */         if (!func_75135_a(itemStack1, 1, 37, true)) {
/* 209 */           return null;
/*     */         }
/* 211 */       } else if (!((Slot)this.field_75151_b.get(0)).func_75216_d() && ((Slot)this.field_75151_b.get(0)).func_75214_a(itemStack1)) {
/* 212 */         if (itemStack1.func_77942_o() && itemStack1.field_77994_a == 1) {
/* 213 */           ((Slot)this.field_75151_b.get(0)).func_75215_d(itemStack1.func_77946_l());
/* 214 */           itemStack1.field_77994_a = 0;
/* 215 */         } else if (itemStack1.field_77994_a >= 1) {
/* 216 */           ((Slot)this.field_75151_b.get(0)).func_75215_d(new ItemStack(itemStack1.func_77973_b(), 1, itemStack1.func_77960_j()));
/* 217 */           itemStack1.field_77994_a--;
/*     */         } 
/*     */       } else {
/* 220 */         return null;
/*     */       } 
/* 222 */       if (itemStack1.field_77994_a == 0) {
/* 223 */         slot.func_75215_d(null);
/*     */       } else {
/* 225 */         slot.func_75218_e();
/*     */       } 
/* 227 */       if (itemStack1.field_77994_a == itemStack.field_77994_a) {
/* 228 */         return null;
/*     */       }
/* 230 */       slot.func_82870_a(p_82846_1_, itemStack1);
/*     */     } 
/*     */     
/* 233 */     return itemStack;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\inventory\ContainerEnchantment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */