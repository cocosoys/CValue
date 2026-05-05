/*     */ package JinRyuu.JRMCore.items;
/*     */ 
/*     */ import JinRyuu.JRMCore.JRMCoreH;
/*     */ import JinRyuu.JRMCore.JRMCoreH2;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ 
/*     */ public class ItemBodysuit
/*     */   extends Item {
/*  17 */   private int defcol = JRMCoreH2.cols[15];
/*  18 */   private String Display = "Color1";
/*     */   
/*     */   public ItemBodysuit(int defcol) {
/*  21 */     this.defcol = defcol;
/*  22 */     func_77656_e(320);
/*  23 */     func_77625_d(1);
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_77624_a(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List<String> par3List, boolean par4) {
/*  27 */     if (hasColor(par1ItemStack)) par3List.add(JRMCoreH.trl("jrmc", "BodysuitColor") + ": " + JRMCoreH.trl("jrmc", getColorReadable(par1ItemStack))); 
/*     */   }
/*     */   
/*     */   public String getColorReadable(ItemStack par1) {
/*  31 */     int i = getColor(par1);
/*  32 */     for (int j = 0; j < JRMCoreH2.cols.length; j++) {
/*  33 */       if (JRMCoreH2.cols[j] == i)
/*  34 */         return JRMCoreH2.colNams[j]; 
/*     */     } 
/*  36 */     return JRMCoreH2.colNams[15];
/*     */   }
/*     */   public String getTextureFile() {
/*  39 */     return JRMCoreH.tjjrmc + ":";
/*     */   }
/*     */   
/*     */   public void func_94581_a(IIconRegister iconRegister) {
/*  43 */     this.field_77791_bV = iconRegister.func_94245_a(JRMCoreH.tjjrmc + ":" + func_77658_a().replaceAll("item.", ""));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasColor(ItemStack p_82816_1_) {
/*  50 */     return !p_82816_1_.func_77942_o() ? false : (!p_82816_1_.func_77978_p().func_150297_b(this.Display, 10) ? false : p_82816_1_.func_77978_p().func_74775_l(this.Display).func_150297_b("color", 3));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getColor(ItemStack p_82814_1_) {
/*  58 */     NBTTagCompound nbttagcompound = p_82814_1_.func_77978_p();
/*     */     
/*  60 */     if (nbttagcompound == null) return this.defcol;
/*     */     
/*  62 */     NBTTagCompound nbttagcompound1 = nbttagcompound.func_74775_l(this.Display);
/*  63 */     return (nbttagcompound1 == null) ? 10511680 : (nbttagcompound1.func_150297_b("color", 3) ? nbttagcompound1.func_74762_e("color") : this.defcol);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_82790_a(ItemStack item, int var) {
/*  70 */     return getColor(item);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeColor(ItemStack p_82815_1_) {
/*  78 */     NBTTagCompound nbttagcompound = p_82815_1_.func_77978_p();
/*     */     
/*  80 */     if (nbttagcompound != null) {
/*  81 */       NBTTagCompound nbttagcompound1 = nbttagcompound.func_74775_l(this.Display);
/*  82 */       if (nbttagcompound1.func_74764_b("color")) nbttagcompound1.func_82580_o("color");
/*     */     
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack setColor(ItemStack p_82813_1_, int p_82813_2_) {
/*  89 */     NBTTagCompound nbttagcompound = p_82813_1_.func_77978_p();
/*     */     
/*  91 */     if (nbttagcompound == null) {
/*  92 */       nbttagcompound = new NBTTagCompound();
/*  93 */       p_82813_1_.func_77982_d(nbttagcompound);
/*     */     } 
/*     */     
/*  96 */     NBTTagCompound nbttagcompound1 = nbttagcompound.func_74775_l(this.Display);
/*     */     
/*  98 */     if (!nbttagcompound.func_150297_b(this.Display, 10)) nbttagcompound.func_74782_a(this.Display, (NBTBase)nbttagcompound1);
/*     */     
/* 100 */     nbttagcompound1.func_74768_a("color", p_82813_2_);
/* 101 */     p_82813_1_.func_77982_d(nbttagcompound);
/*     */     
/* 103 */     return p_82813_1_;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\items\ItemBodysuit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */