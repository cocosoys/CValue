/*     */ package JinRyuu.JRMCore.items;
/*     */ 
/*     */ import JinRyuu.JRMCore.JRMCoreClient;
/*     */ import JinRyuu.JRMCore.JRMCoreH;
/*     */ import JinRyuu.JRMCore.JRMCoreHJBRA;
/*     */ import JinRyuu.JRMCore.JRMCoreHJFC;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.client.model.ModelBiped;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.EnumAction;
/*     */ import net.minecraft.item.ItemArmor;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ 
/*     */ public class GiTurtleBase
/*     */   extends ItemArmor {
/*     */   public String modid;
/*     */   public String na;
/*     */   public ItemArmor.ArmorMaterial rl;
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon field_94604_cx1;
/*     */   private IIcon overlayIcon;
/*     */   private IIcon emptySlotIcon;
/*     */   
/*     */   public GiTurtleBase(ItemArmor.ArmorMaterial par2ArmorMaterial, int par3, int par4, String armornamePrefix) {
/*  31 */     super(par2ArmorMaterial, par3, par4);
/*  32 */     this.rl = par2ArmorMaterial;
/*     */     
/*  34 */     func_77656_e(par2ArmorMaterial.func_78046_a(par4));
/*  35 */     this.field_77777_bU = 1;
/*  36 */     this.na = armornamePrefix;
/*  37 */     this.modid = JRMCoreH.tjjrmc;
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public ModelBiped giMdl(int slt, EntityLivingBase e) {
/*  43 */     switch (slt) { case 0:
/*  44 */         return wear(e) ? JRMCoreHJBRA.GiTurtleMdl1 : JRMCoreClient.armor1;
/*  45 */       case 1: return wear(e) ? JRMCoreHJBRA.GiTurtleMdl1 : JRMCoreClient.armor1;
/*  46 */       case 3: return wear(e) ? JRMCoreHJBRA.GiTurtleMdl1 : JRMCoreClient.armor1; }
/*  47 */      return wear(e) ? JRMCoreHJBRA.GiTurtleMdl2 : JRMCoreClient.armor2;
/*     */   }
/*     */   
/*     */   public boolean wear(EntityLivingBase e) {
/*  51 */     return (JRMCoreH.JBRA() && (e instanceof EntityPlayer || (JRMCoreH.JFC() && JRMCoreHJFC.isChildNPC((Entity)e))));
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, int par3) {
/*  57 */     ModelBiped modelbiped = giMdl(par3, entityLiving);
/*     */     
/*  59 */     if (wear(entityLiving)) {
/*  60 */       modelbiped = JRMCoreHJBRA.showModel(modelbiped, entityLiving, itemStack, par3);
/*     */     } else {
/*     */       
/*  63 */       modelbiped.field_78116_c.field_78806_j = (par3 == 0);
/*  64 */       modelbiped.field_78114_d.field_78806_j = false;
/*  65 */       modelbiped.field_78115_e.field_78806_j = (par3 == 1 || par3 == 2);
/*  66 */       modelbiped.field_78112_f.field_78806_j = (par3 == 1);
/*  67 */       modelbiped.field_78113_g.field_78806_j = (par3 == 1);
/*  68 */       modelbiped.field_78123_h.field_78806_j = (par3 == 2 || par3 == 3);
/*  69 */       modelbiped.field_78124_i.field_78806_j = (par3 == 2 || par3 == 3);
/*     */       
/*  71 */       if (entityLiving instanceof net.minecraft.entity.monster.EntityMob) {
/*  72 */         modelbiped.field_78112_f.field_78806_j = false;
/*  73 */         modelbiped.field_78113_g.field_78806_j = false;
/*     */       } 
/*     */       
/*  76 */       ItemStack var11 = entityLiving.func_70694_bm();
/*  77 */       modelbiped.field_78120_m = (var11 != null) ? 1 : 0;
/*     */       
/*  79 */       if (var11 != null && entityLiving instanceof EntityPlayer && ((EntityPlayer)entityLiving).func_71052_bv() > 0) {
/*  80 */         EnumAction var12 = var11.func_77975_n();
/*     */         
/*  82 */         if (var12 == EnumAction.block) {
/*  83 */           modelbiped.field_78120_m = 3;
/*  84 */         } else if (var12 == EnumAction.bow) {
/*  85 */           modelbiped.field_78118_o = true;
/*     */         } 
/*     */       } 
/*  88 */       modelbiped.field_78117_n = entityLiving.func_70093_af();
/*  89 */       modelbiped.field_78093_q = entityLiving.func_70115_ae();
/*  90 */       modelbiped.field_78091_s = entityLiving.func_70631_g_();
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 106 */     return modelbiped;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 113 */   private static final String[] CLOTH_OVERLAY_NAMES = new String[] { "leather_helmet_overlay", "leather_chestplate_overlay", "leather_leggings_overlay", "leather_boots_overlay" };
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_94581_a(IIconRegister par1IconRegister) {
/* 117 */     this.field_77791_bV = par1IconRegister.func_94245_a(this.modid + ":" + func_77658_a().replaceAll("Scoutera", "Scouter").replaceAll("Scouterb", "Scouter"));
/* 118 */     this.field_94604_cx1 = par1IconRegister.func_94245_a(field_94603_a[this.field_77881_a]);
/*     */     
/* 120 */     if (this.rl == ItemArmor.ArmorMaterial.CLOTH)
/*     */     {
/* 122 */       this.overlayIcon = par1IconRegister.func_94245_a(CLOTH_OVERLAY_NAMES[this.field_77881_a]);
/*     */     }
/* 124 */     this.emptySlotIcon = par1IconRegister.func_94245_a(field_94603_a[this.field_77881_a]);
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
/*     */   public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
/* 148 */     String r = "";
/* 149 */     String s = "";
/* 150 */     String j = "";
/* 151 */     if (stack.func_77952_i() > stack.func_77958_k() / 2) {
/* 152 */       s = "_dam";
/*     */     }
/*     */     
/* 155 */     j = "jbra";
/*     */     
/* 157 */     if (stack.toString().contains("leg") || stack.toString().contains("Leg"))
/* 158 */     { r = this.modid + ":armor/" + this.na + "_2" + j + s + ".png"; }
/* 159 */     else { r = this.modid + ":armor/" + this.na + "_1" + j + s + ".png"; }
/* 160 */      if (new ResourceLocation(this.modid, r) != null) {
/* 161 */       return r;
/*     */     }
/* 163 */     return r.replaceAll(s, "");
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\items\GiTurtleBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */