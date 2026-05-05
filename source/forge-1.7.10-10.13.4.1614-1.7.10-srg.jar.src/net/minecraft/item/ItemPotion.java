/*     */ package net.minecraft.item;
/*     */ import com.google.common.collect.HashMultimap;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.ai.attributes.AttributeModifier;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.potion.Potion;
/*     */ import net.minecraft.potion.PotionEffect;
/*     */ import net.minecraft.potion.PotionHelper;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.util.StatCollector;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class ItemPotion extends Item {
/*  25 */   private HashMap field_77836_a = new HashMap<Object, Object>();
/*  26 */   private static final Map field_77835_b = new LinkedHashMap<Object, Object>(); @SideOnly(Side.CLIENT)
/*     */   private IIcon field_94591_c; @SideOnly(Side.CLIENT)
/*     */   private IIcon field_94590_d; @SideOnly(Side.CLIENT)
/*     */   private IIcon field_94592_ct;
/*     */   private static final String __OBFID = "CL_00000055";
/*     */   
/*     */   public ItemPotion() {
/*  33 */     func_77625_d(1);
/*  34 */     func_77627_a(true);
/*  35 */     func_77656_e(0);
/*  36 */     func_77637_a(CreativeTabs.field_78038_k);
/*     */   }
/*     */   
/*     */   public List func_77832_l(ItemStack p_77832_1_) {
/*  40 */     if (!p_77832_1_.func_77942_o() || !p_77832_1_.func_77978_p().func_150297_b("CustomPotionEffects", 9)) {
/*  41 */       List list = (List)this.field_77836_a.get(Integer.valueOf(p_77832_1_.func_77960_j()));
/*     */       
/*  43 */       if (list == null) {
/*  44 */         list = PotionHelper.func_77917_b(p_77832_1_.func_77960_j(), false);
/*  45 */         this.field_77836_a.put(Integer.valueOf(p_77832_1_.func_77960_j()), list);
/*     */       } 
/*     */       
/*  48 */       return list;
/*     */     } 
/*  50 */     ArrayList<PotionEffect> arrayList = new ArrayList();
/*  51 */     NBTTagList nBTTagList = p_77832_1_.func_77978_p().func_150295_c("CustomPotionEffects", 10);
/*     */     
/*  53 */     for (byte b = 0; b < nBTTagList.func_74745_c(); b++) {
/*  54 */       NBTTagCompound nBTTagCompound = nBTTagList.func_150305_b(b);
/*  55 */       PotionEffect potionEffect = PotionEffect.func_82722_b(nBTTagCompound);
/*  56 */       if (potionEffect != null) {
/*  57 */         arrayList.add(potionEffect);
/*     */       }
/*     */     } 
/*     */     
/*  61 */     return arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   public List func_77834_f(int p_77834_1_) {
/*  66 */     List list = (List)this.field_77836_a.get(Integer.valueOf(p_77834_1_));
/*  67 */     if (list == null) {
/*  68 */       list = PotionHelper.func_77917_b(p_77834_1_, false);
/*  69 */       this.field_77836_a.put(Integer.valueOf(p_77834_1_), list);
/*     */     } 
/*  71 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack func_77654_b(ItemStack p_77654_1_, World p_77654_2_, EntityPlayer p_77654_3_) {
/*  76 */     if (!p_77654_3_.field_71075_bZ.field_75098_d) p_77654_1_.field_77994_a--;
/*     */     
/*  78 */     if (!p_77654_2_.field_72995_K) {
/*  79 */       List list = func_77832_l(p_77654_1_);
/*  80 */       if (list != null) {
/*  81 */         for (PotionEffect potionEffect : list) {
/*  82 */           p_77654_3_.func_70690_d(new PotionEffect(potionEffect));
/*     */         }
/*     */       }
/*     */     } 
/*  86 */     if (!p_77654_3_.field_71075_bZ.field_75098_d) {
/*  87 */       if (p_77654_1_.field_77994_a <= 0) {
/*  88 */         return new ItemStack(Items.field_151069_bo);
/*     */       }
/*  90 */       p_77654_3_.field_71071_by.func_70441_a(new ItemStack(Items.field_151069_bo));
/*     */     } 
/*     */ 
/*     */     
/*  94 */     return p_77654_1_;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_77626_a(ItemStack p_77626_1_) {
/*  99 */     return 32;
/*     */   }
/*     */ 
/*     */   
/*     */   public EnumAction func_77661_b(ItemStack p_77661_1_) {
/* 104 */     return EnumAction.drink;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack func_77659_a(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_) {
/* 109 */     if (func_77831_g(p_77659_1_.func_77960_j())) {
/* 110 */       if (!p_77659_3_.field_71075_bZ.field_75098_d) p_77659_1_.field_77994_a--; 
/* 111 */       p_77659_2_.func_72956_a((Entity)p_77659_3_, "random.bow", 0.5F, 0.4F / (field_77697_d.nextFloat() * 0.4F + 0.8F));
/* 112 */       if (!p_77659_2_.field_72995_K) p_77659_2_.func_72838_d((Entity)new EntityPotion(p_77659_2_, (EntityLivingBase)p_77659_3_, p_77659_1_)); 
/* 113 */       return p_77659_1_;
/*     */     } 
/* 115 */     p_77659_3_.func_71008_a(p_77659_1_, func_77626_a(p_77659_1_));
/* 116 */     return p_77659_1_;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_77648_a(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
/* 121 */     return false;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_77617_a(int p_77617_1_) {
/* 126 */     if (func_77831_g(p_77617_1_)) {
/* 127 */       return this.field_94591_c;
/*     */     }
/* 129 */     return this.field_94590_d;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_77618_c(int p_77618_1_, int p_77618_2_) {
/* 134 */     if (p_77618_2_ == 0) {
/* 135 */       return this.field_94592_ct;
/*     */     }
/* 137 */     return super.func_77618_c(p_77618_1_, p_77618_2_);
/*     */   }
/*     */   
/*     */   public static boolean func_77831_g(int p_77831_0_) {
/* 141 */     return ((p_77831_0_ & 0x4000) != 0);
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_77620_a(int p_77620_1_) {
/* 145 */     return PotionHelper.func_77915_a(p_77620_1_, false);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_82790_a(ItemStack p_82790_1_, int p_82790_2_) {
/* 150 */     if (p_82790_2_ > 0) {
/* 151 */       return 16777215;
/*     */     }
/* 153 */     return func_77620_a(p_82790_1_.func_77960_j());
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_77623_v() {
/* 158 */     return true;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_77833_h(int p_77833_1_) {
/* 162 */     List list = func_77834_f(p_77833_1_);
/* 163 */     if (list == null || list.isEmpty()) {
/* 164 */       return false;
/*     */     }
/* 166 */     for (PotionEffect potionEffect : list) {
/* 167 */       if (Potion.field_76425_a[potionEffect.func_76456_a()].func_76403_b()) {
/* 168 */         return true;
/*     */       }
/*     */     } 
/* 171 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public String func_77653_i(ItemStack p_77653_1_) {
/* 176 */     if (p_77653_1_.func_77960_j() == 0) {
/* 177 */       return StatCollector.func_74838_a("item.emptyPotion.name").trim();
/*     */     }
/*     */     
/* 180 */     String str1 = "";
/* 181 */     if (func_77831_g(p_77653_1_.func_77960_j())) {
/* 182 */       str1 = StatCollector.func_74838_a("potion.prefix.grenade").trim() + " ";
/*     */     }
/*     */     
/* 185 */     List<PotionEffect> list = Items.field_151068_bn.func_77832_l(p_77653_1_);
/* 186 */     if (list != null && !list.isEmpty()) {
/* 187 */       String str = ((PotionEffect)list.get(0)).func_76453_d();
/* 188 */       str = str + ".postfix";
/* 189 */       return str1 + StatCollector.func_74838_a(str).trim();
/*     */     } 
/* 191 */     String str2 = PotionHelper.func_77905_c(p_77653_1_.func_77960_j());
/* 192 */     return StatCollector.func_74838_a(str2).trim() + " " + super.func_77653_i(p_77653_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_77624_a(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List<String> p_77624_3_, boolean p_77624_4_) {
/* 198 */     if (p_77624_1_.func_77960_j() == 0) {
/*     */       return;
/*     */     }
/*     */     
/* 202 */     List list = Items.field_151068_bn.func_77832_l(p_77624_1_);
/* 203 */     HashMultimap hashMultimap = HashMultimap.create();
/*     */     
/* 205 */     if (list != null && !list.isEmpty()) {
/* 206 */       for (PotionEffect potionEffect : list) {
/* 207 */         String str = StatCollector.func_74838_a(potionEffect.func_76453_d()).trim();
/* 208 */         Potion potion = Potion.field_76425_a[potionEffect.func_76456_a()];
/* 209 */         Map map = potion.func_111186_k();
/*     */         
/* 211 */         if (map != null && map.size() > 0) {
/* 212 */           for (Map.Entry entry : map.entrySet()) {
/* 213 */             AttributeModifier attributeModifier1 = (AttributeModifier)entry.getValue();
/* 214 */             AttributeModifier attributeModifier2 = new AttributeModifier(attributeModifier1.func_111166_b(), potion.func_111183_a(potionEffect.func_76458_c(), attributeModifier1), attributeModifier1.func_111169_c());
/* 215 */             hashMultimap.put(((IAttribute)entry.getKey()).func_111108_a(), attributeModifier2);
/*     */           } 
/*     */         }
/*     */         
/* 219 */         if (potionEffect.func_76458_c() > 0) {
/* 220 */           str = str + " " + StatCollector.func_74838_a("potion.potency." + potionEffect.func_76458_c()).trim();
/*     */         }
/*     */         
/* 223 */         if (potionEffect.func_76459_b() > 20) {
/* 224 */           str = str + " (" + Potion.func_76389_a(potionEffect) + ")";
/*     */         }
/*     */         
/* 227 */         if (potion.func_76398_f()) {
/* 228 */           p_77624_3_.add(EnumChatFormatting.RED + str); continue;
/*     */         } 
/* 230 */         p_77624_3_.add(EnumChatFormatting.GRAY + str);
/*     */       } 
/*     */     } else {
/*     */       
/* 234 */       String str = StatCollector.func_74838_a("potion.empty").trim();
/* 235 */       p_77624_3_.add(EnumChatFormatting.GRAY + str);
/*     */     } 
/*     */     
/* 238 */     if (!hashMultimap.isEmpty()) {
/* 239 */       p_77624_3_.add("");
/* 240 */       p_77624_3_.add(EnumChatFormatting.DARK_PURPLE + StatCollector.func_74838_a("potion.effects.whenDrank"));
/*     */       
/* 242 */       for (Map.Entry entry : hashMultimap.entries()) {
/* 243 */         double d2; AttributeModifier attributeModifier = (AttributeModifier)entry.getValue();
/* 244 */         double d1 = attributeModifier.func_111164_d();
/*     */ 
/*     */         
/* 247 */         if (attributeModifier.func_111169_c() == 1 || attributeModifier.func_111169_c() == 2) {
/* 248 */           d2 = attributeModifier.func_111164_d() * 100.0D;
/*     */         } else {
/* 250 */           d2 = attributeModifier.func_111164_d();
/*     */         } 
/*     */         
/* 253 */         if (d1 > 0.0D) {
/* 254 */           p_77624_3_.add(EnumChatFormatting.BLUE + StatCollector.func_74837_a("attribute.modifier.plus." + attributeModifier.func_111169_c(), new Object[] { ItemStack.field_111284_a.format(d2), StatCollector.func_74838_a("attribute.name." + (String)entry.getKey()) })); continue;
/*     */         } 
/* 256 */         if (d1 < 0.0D) {
/* 257 */           d2 *= -1.0D;
/* 258 */           p_77624_3_.add(EnumChatFormatting.RED + StatCollector.func_74837_a("attribute.modifier.take." + attributeModifier.func_111169_c(), new Object[] { ItemStack.field_111284_a.format(d2), StatCollector.func_74838_a("attribute.name." + (String)entry.getKey()) }));
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_77636_d(ItemStack p_77636_1_) {
/* 267 */     List list = func_77832_l(p_77636_1_);
/* 268 */     return (list != null && !list.isEmpty());
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_150895_a(Item p_150895_1_, CreativeTabs p_150895_2_, List<ItemStack> p_150895_3_) {
/* 273 */     super.func_150895_a(p_150895_1_, p_150895_2_, p_150895_3_);
/*     */     
/* 275 */     if (field_77835_b.isEmpty()) {
/* 276 */       for (byte b = 0; b <= 15; b++) {
/* 277 */         for (byte b1 = 0; b1 <= 1; b1++) {
/* 278 */           int i = b;
/* 279 */           if (b1 == 0) {
/* 280 */             i |= 0x2000;
/*     */           } else {
/* 282 */             i |= 0x4000;
/*     */           } 
/* 284 */           for (byte b2 = 0; b2 <= 2; b2++) {
/* 285 */             int j = i;
/* 286 */             if (b2 != 0)
/*     */             {
/* 288 */               if (b2 == 1) {
/* 289 */                 j |= 0x20;
/* 290 */               } else if (b2 == 2) {
/* 291 */                 j |= 0x40;
/*     */               } 
/*     */             }
/* 294 */             List list = PotionHelper.func_77917_b(j, false);
/*     */             
/* 296 */             if (list != null && !list.isEmpty()) {
/* 297 */               field_77835_b.put(list, Integer.valueOf(j));
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/* 304 */     for (Iterator<Integer> iterator = field_77835_b.values().iterator(); iterator.hasNext(); ) { int i = ((Integer)iterator.next()).intValue();
/* 305 */       p_150895_3_.add(new ItemStack(p_150895_1_, 1, i)); }
/*     */   
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_94581_a(IIconRegister p_94581_1_) {
/* 311 */     this.field_94590_d = p_94581_1_.func_94245_a(func_111208_A() + "_" + "bottle_drinkable");
/* 312 */     this.field_94591_c = p_94581_1_.func_94245_a(func_111208_A() + "_" + "bottle_splash");
/* 313 */     this.field_94592_ct = p_94581_1_.func_94245_a(func_111208_A() + "_" + "overlay");
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public static IIcon func_94589_d(String p_94589_0_) {
/* 317 */     if (p_94589_0_.equals("bottle_drinkable")) return Items.field_151068_bn.field_94590_d; 
/* 318 */     if (p_94589_0_.equals("bottle_splash")) return Items.field_151068_bn.field_94591_c; 
/* 319 */     if (p_94589_0_.equals("overlay")) return Items.field_151068_bn.field_94592_ct; 
/* 320 */     return null;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\item\ItemPotion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */