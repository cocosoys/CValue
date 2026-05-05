/*     */ package JinRyuu.JRMCore.items;
/*     */ 
/*     */ import JinRyuu.JRMCore.JRMCoreH;
/*     */ import JinRyuu.JRMCore.JRMCoreH2;
/*     */ import JinRyuu.JRMCore.JRMCoreHJBRA;
/*     */ import JinRyuu.JRMCore.JRMCoreHJFC;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import net.minecraft.client.model.ModelBiped;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.EnumAction;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemArmor;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ItemVanity
/*     */   extends Item
/*     */ {
/*  37 */   private int defcol = JRMCoreH2.cols[15];
/*  38 */   private String Display = "Color1";
/*     */ 
/*     */   
/*     */   public String armorNamePrefix;
/*     */ 
/*     */   
/*     */   public String modid;
/*     */ 
/*     */   
/*     */   public String na;
/*     */ 
/*     */   
/*     */   public ItemArmor.ArmorMaterial rl;
/*     */   
/*  52 */   public int id = -1;
/*     */   public final int armorType;
/*     */   
/*     */   public ItemVanity(int defcol, int armorType, String armornamePrefix) {
/*  56 */     this.defcol = defcol;
/*  57 */     this.armorType = armorType;
/*  58 */     this.na = armornamePrefix;
/*  59 */     func_77656_e(320);
/*  60 */     func_77625_d(1);
/*  61 */     this.id = -1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemVanity(int defcol, int armorType, String armornamePrefix, int id) {
/*  67 */     this.defcol = defcol;
/*  68 */     this.armorType = armorType;
/*  69 */     this.na = armornamePrefix;
/*  70 */     func_77656_e(320);
/*  71 */     func_77625_d(1);
/*  72 */     this.id = id;
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_77624_a(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List<String> par3List, boolean par4) {
/*  78 */     par3List.add(JRMCoreH.trl("jrmc", "Vanity"));
/*     */ 
/*     */     
/*  81 */     par3List.add(JRMCoreH.trl("jrmc", "descvanityColorable1"));
/*  82 */     par3List.add(JRMCoreH.trl("jrmc", "descvanityColorable2"));
/*  83 */     if (hasColor(par1ItemStack)) par3List.add(JRMCoreH.trl("jrmc", "BodysuitColor") + ": " + JRMCoreH.trl("jrmc", getColorReadable(par1ItemStack))); 
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public ModelBiped giMdl(int slt, EntityLivingBase e) {
/*  88 */     if (wear(e)) {
/*  89 */       boolean has = false;
/*  90 */       for (int i = 0; i < ItemsJRMC.ItemsVanityNum.length; i++) {
/*  91 */         if (ItemsJRMC.ItemVanity3[i] > -1 && 
/*  92 */           this.id == ItemsJRMC.ItemVanity3[i]) {
/*  93 */           has = true;
/*  94 */           return JRMCoreHJBRA.JRMC_GiTurtleMdl2[this.id];
/*     */         } 
/*     */       } 
/*     */       
/*  98 */       if (!has) {
/*  99 */         if (slt != 5) {
/* 100 */           if (func_77658_a().contains("Head")) return JRMCoreHJBRA.GiTurtleMdl2; 
/* 101 */           return JRMCoreHJBRA.GiTurtleMdl3;
/*     */         } 
/* 103 */         return JRMCoreHJBRA.GiTurtleMdl2;
/*     */       } 
/* 105 */     }  return null;
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
/*     */   public boolean wear(EntityLivingBase e) {
/* 134 */     return (JRMCoreH.JBRA() && (e instanceof EntityPlayer || (JRMCoreH.JFC() && JRMCoreHJFC.isChildNPC((Entity)e))));
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, int par3) {
/* 138 */     ModelBiped modelbiped = giMdl(par3, entityLiving);
/*     */     
/* 140 */     if (wear(entityLiving)) {
/* 141 */       modelbiped = JRMCoreHJBRA.showModel(modelbiped, entityLiving, itemStack, par3);
/*     */     } else {
/* 143 */       modelbiped.field_78116_c.field_78806_j = (par3 == 0);
/* 144 */       modelbiped.field_78114_d.field_78806_j = false;
/* 145 */       modelbiped.field_78115_e.field_78806_j = (par3 == 1 || par3 == 2);
/* 146 */       modelbiped.field_78112_f.field_78806_j = (par3 == 1);
/* 147 */       modelbiped.field_78113_g.field_78806_j = (par3 == 1);
/* 148 */       modelbiped.field_78123_h.field_78806_j = (par3 == 2 || par3 == 3);
/* 149 */       modelbiped.field_78124_i.field_78806_j = (par3 == 2 || par3 == 3);
/*     */       
/* 151 */       if (entityLiving instanceof net.minecraft.entity.monster.EntityMob) {
/* 152 */         modelbiped.field_78112_f.field_78806_j = false;
/* 153 */         modelbiped.field_78113_g.field_78806_j = false;
/*     */       } 
/*     */ 
/*     */       
/* 157 */       ItemStack var11 = entityLiving.func_70694_bm();
/* 158 */       modelbiped.field_78120_m = (var11 != null) ? 1 : 0;
/*     */       
/* 160 */       if (var11 != null && entityLiving instanceof EntityPlayer && ((EntityPlayer)entityLiving).func_71052_bv() > 0) {
/* 161 */         EnumAction var12 = var11.func_77975_n();
/*     */         
/* 163 */         if (var12 == EnumAction.block) {
/* 164 */           modelbiped.field_78120_m = 3;
/* 165 */         } else if (var12 == EnumAction.bow) {
/* 166 */           modelbiped.field_78118_o = true;
/*     */         } 
/*     */       } 
/* 169 */       modelbiped.field_78117_n = entityLiving.func_70093_af();
/* 170 */       modelbiped.field_78093_q = entityLiving.func_70115_ae();
/* 171 */       modelbiped.field_78091_s = entityLiving.func_70631_g_();
/*     */     } 
/*     */     
/* 174 */     return modelbiped;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getColorReadable(ItemStack par1) {
/* 179 */     int i = getColor(par1);
/* 180 */     for (int j = 0; j < JRMCoreH2.cols.length; j++) {
/* 181 */       if (JRMCoreH2.cols[j] == i)
/* 182 */         return JRMCoreH2.colNams[j]; 
/*     */     } 
/* 184 */     return JRMCoreH2.colNams[15];
/*     */   }
/*     */   public String getTextureFile() {
/* 187 */     return this.modid + ":";
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
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_94581_a(IIconRegister iconRegister) {
/* 201 */     this.field_77791_bV = iconRegister.func_94245_a(this.modid + ":" + func_77658_a().replaceAll("item.", ""));
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_82790_a(ItemStack item, int var) {
/* 206 */     return getColor(item);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasColor(ItemStack p_82816_1_) {
/* 214 */     return !p_82816_1_.func_77942_o() ? false : (!p_82816_1_.func_77978_p().func_150297_b(this.Display, 10) ? false : p_82816_1_.func_77978_p().func_74775_l(this.Display).func_150297_b("color", 3));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getColor(ItemStack p_82814_1_) {
/* 222 */     NBTTagCompound nbttagcompound = p_82814_1_.func_77978_p();
/*     */     
/* 224 */     if (nbttagcompound == null) return this.defcol;
/*     */     
/* 226 */     NBTTagCompound nbttagcompound1 = nbttagcompound.func_74775_l(this.Display);
/* 227 */     return (nbttagcompound1 == null) ? 10511680 : (nbttagcompound1.func_150297_b("color", 3) ? nbttagcompound1.func_74762_e("color") : this.defcol);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeColor(ItemStack p_82815_1_) {
/* 237 */     NBTTagCompound nbttagcompound = p_82815_1_.func_77978_p();
/*     */     
/* 239 */     if (nbttagcompound != null) {
/* 240 */       NBTTagCompound nbttagcompound1 = nbttagcompound.func_74775_l(this.Display);
/* 241 */       if (nbttagcompound1.func_74764_b("color")) nbttagcompound1.func_82580_o("color");
/*     */     
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack setColor(ItemStack p_82813_1_, int p_82813_2_) {
/* 248 */     NBTTagCompound nbttagcompound = p_82813_1_.func_77978_p();
/*     */     
/* 250 */     if (nbttagcompound == null) {
/* 251 */       nbttagcompound = new NBTTagCompound();
/* 252 */       p_82813_1_.func_77982_d(nbttagcompound);
/*     */     } 
/*     */     
/* 255 */     NBTTagCompound nbttagcompound1 = nbttagcompound.func_74775_l(this.Display);
/*     */     
/* 257 */     if (!nbttagcompound.func_150297_b(this.Display, 10)) nbttagcompound.func_74782_a(this.Display, (NBTBase)nbttagcompound1);
/*     */     
/* 259 */     nbttagcompound1.func_74768_a("color", p_82813_2_);
/* 260 */     p_82813_1_.func_77982_d(nbttagcompound);
/*     */     
/* 262 */     return p_82813_1_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
/* 269 */     String r = "";
/* 270 */     String s = "";
/* 271 */     String j = "";
/* 272 */     if (stack.func_77952_i() > stack.func_77958_k() / 2) s = "_dam"; 
/* 273 */     j = "jbra";
/* 274 */     if (stack.toString().contains("leg") || stack.toString().contains("Leg")) { r = this.modid + ":armor/" + this.na + "_2" + j + s + ".png"; }
/* 275 */     else if (stack.toString().contains("boot") || stack.toString().contains("Boot")) { r = this.modid + ":armor/" + this.na + "_3" + j + s + ".png"; }
/* 276 */     else if (stack.toString().contains("head") || stack.toString().contains("Head")) { r = this.modid + ":armor/" + this.na + "_4" + j + s + ".png"; }
/* 277 */     else { r = this.modid + ":armor/" + this.na + "_1" + j + s + ".png"; }
/*     */     
/* 279 */     if (new ResourceLocation(this.modid, r) != null) return r; 
/* 280 */     return r.replaceAll(s, "");
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\items\ItemVanity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */