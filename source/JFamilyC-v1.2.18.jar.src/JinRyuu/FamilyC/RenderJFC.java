/*      */ package JinRyuu.FamilyC;
/*      */ 
/*      */ import JinRyuu.DragonBC.common.Items.ItemsDBC;
/*      */ import JinRyuu.JRMCore.JRMCoreClient;
/*      */ import JinRyuu.JRMCore.JRMCoreGuiScreen;
/*      */ import JinRyuu.JRMCore.JRMCoreH;
/*      */ import JinRyuu.JRMCore.JRMCoreHJBRA;
/*      */ import JinRyuu.JRMCore.JRMCoreHJYC;
/*      */ import JinRyuu.JRMCore.entity.ModelBipedBody;
/*      */ import JinRyuu.JYearsC.JYearsCConfig;
/*      */ import com.mojang.authlib.GameProfile;
/*      */ import cpw.mods.fml.common.eventhandler.Event;
/*      */ import cpw.mods.fml.relauncher.Side;
/*      */ import cpw.mods.fml.relauncher.SideOnly;
/*      */ import java.util.HashMap;
/*      */ import java.util.UUID;
/*      */ import net.minecraft.block.Block;
/*      */ import net.minecraft.client.gui.FontRenderer;
/*      */ import net.minecraft.client.model.ModelBase;
/*      */ import net.minecraft.client.model.ModelBiped;
/*      */ import net.minecraft.client.renderer.OpenGlHelper;
/*      */ import net.minecraft.client.renderer.RenderBlocks;
/*      */ import net.minecraft.client.renderer.Tessellator;
/*      */ import net.minecraft.client.renderer.entity.RenderBiped;
/*      */ import net.minecraft.client.renderer.entity.RendererLivingEntity;
/*      */ import net.minecraft.client.renderer.tileentity.TileEntitySkullRenderer;
/*      */ import net.minecraft.entity.Entity;
/*      */ import net.minecraft.entity.EntityLiving;
/*      */ import net.minecraft.entity.EntityLivingBase;
/*      */ import net.minecraft.init.Items;
/*      */ import net.minecraft.item.Item;
/*      */ import net.minecraft.item.ItemArmor;
/*      */ import net.minecraft.item.ItemStack;
/*      */ import net.minecraft.nbt.NBTTagCompound;
/*      */ import net.minecraft.nbt.NBTUtil;
/*      */ import net.minecraft.util.MathHelper;
/*      */ import net.minecraft.util.ResourceLocation;
/*      */ import net.minecraft.util.StringUtils;
/*      */ import net.minecraftforge.client.ForgeHooksClient;
/*      */ import net.minecraftforge.client.IItemRenderer;
/*      */ import net.minecraftforge.client.MinecraftForgeClient;
/*      */ import net.minecraftforge.client.event.RenderLivingEvent;
/*      */ import net.minecraftforge.common.MinecraftForge;
/*      */ import org.lwjgl.opengl.GL11;
/*      */ 
/*      */ @SideOnly(Side.CLIENT)
/*      */ public class RenderJFC
/*      */   extends RenderBiped {
/*   49 */   private static final ResourceLocation RES_ITEM_GLINT = new ResourceLocation("textures/misc/enchanted_item_glint.png");
/*      */   
/*      */   private ModelBipedJFC modelMain;
/*      */   
/*      */   private ModelBiped bra;
/*      */   
/*      */   private ModelBiped others;
/*      */   
/*      */   private ModelBiped pants;
/*      */   
/*      */   private ModelBiped modelArmorChestplateDBC;
/*      */   
/*      */   private ModelBiped modelArmorDBC;
/*      */   private ModelBiped modelArmor;
/*      */   private ModelBiped modelArmorChestplate;
/*   64 */   protected ResourceLocation curSkin = null; public ModelBiped armrMdl; public ModelBiped armrMdl2; boolean b; private float age; private boolean curSkinUp; private int gen; private int breast; private String dns; private String dnsH;
/*      */   private String name;
/*      */   
/*   67 */   public RenderJFC() { super(new ModelBiped(0.0F), 0.5F);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*   86 */     this.armrMdl = JRMCoreH.JBRA() ? JRMCoreHJBRA.ModelBipedBody(1.0F) : null;
/*   87 */     this.armrMdl2 = JRMCoreH.JBRA() ? JRMCoreHJBRA.ModelBipedBody(0.5F) : null;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  183 */     this.b = true;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1172 */     this.gen = 0;
/* 1173 */     this.breast = 0;
/*      */ 
/*      */ 
/*      */     
/* 1177 */     this.dns = "";
/* 1178 */     this.dnsH = "";
/* 1179 */     this.name = "Child"; this.modelMain = new ModelBipedJFC(0.0F); this.bra = (ModelBiped)new ModelBipedBody(0.001F); this.modelArmorChestplate = (ModelBiped)new ModelBipedBody(1.0F, 0.0F, 64, 32); this.modelArmor = (ModelBiped)new ModelBipedBody(0.5F, 0.0F, 64, 32); this.modelArmorChestplateDBC = (ModelBiped)new ModelBipedBody(0.205F); this.modelArmorDBC = (ModelBiped)new ModelBipedBody(0.11F); this.field_77045_g = (ModelBase)this.modelMain; this.field_77071_a = this.modelMain; } protected int func_77032_a(EntityLiving par1EntityLiving, int par2, float par3) { ItemStack itemstack = par1EntityLiving.func_130225_q(3 - par2); if (itemstack != null && JRMCoreH.JBRA()) { Item item = itemstack.func_77973_b(); if (item instanceof ItemArmor) { ItemArmor itemarmor = (ItemArmor)item; JRMCoreClient.mc.func_110434_K().func_110577_a(RenderBiped.getArmorResource((Entity)par1EntityLiving, itemstack, par2, null)); this.modelArmor = this.armrMdl2; this.modelArmorChestplate = this.armrMdl; ModelBiped modelbiped = (par2 == 2) ? this.modelArmor : this.modelArmorChestplate; modelbiped = ForgeHooksClient.getArmorModel((EntityLivingBase)par1EntityLiving, itemstack, par2, modelbiped); modelbiped = JRMCoreHJBRA.showModel(modelbiped, (EntityLivingBase)par1EntityLiving, itemstack, par2); func_77042_a((ModelBase)modelbiped); modelbiped.field_78093_q = par1EntityLiving.func_70115_ae(); modelbiped.field_78091_s = par1EntityLiving.func_70631_g_(); modelbiped.field_78117_n = par1EntityLiving.func_70093_af(); int j = itemarmor.func_82814_b(itemstack); if (j != -1) { float f1 = (j >> 16 & 0xFF) / 255.0F; float f2 = (j >> 8 & 0xFF) / 255.0F; float f3 = (j & 0xFF) / 255.0F; GL11.glColor3f(f1, f2, f3); if (itemstack.func_77948_v()) return 31;  return 16; }  GL11.glColor3f(1.0F, 1.0F, 1.0F); if (itemstack.func_77948_v()) return 15;  return 1; }  }  return -1; } public void func_76986_a(Entity entity, double d0, double d1, double d2, float f, float f1) { doRenderLiving((EntityLivingBase)entity, d0, d1, d2, f, f1); } protected ResourceLocation func_110775_a(Entity entity) { if (this.curSkin == null) {  } else {  }  return this.curSkin; } byte b(int n) { return (byte)n; } byte b(String n) { return Byte.parseByte(n); } int i(String n) { return Integer.parseInt(n); } private int JFCgetConfigpt() { return FamilyCConfig.pt; } private float JYCgetConfigpgut() { return JYearsCConfig.pgut; }
/*      */   protected void func_77029_c(EntityLivingBase par1EntityLivingBase, float par2) { if (par1EntityLivingBase instanceof EntityNPC) { EntityNPC e = (EntityNPC)par1EntityLivingBase; this.dns = e.getDNS(); this.dnsH = e.getDNSH(); if (this.dns.length() > 5) this.gen = JRMCoreH.dnsGender(this.dns);  this.name = e.getNam(); this.age = e.getNPCgrw(); renderSkins(par1EntityLivingBase, par2); }  GL11.glColor3f(1.0F, 1.0F, 1.0F); ItemStack itemstack = par1EntityLivingBase.func_70694_bm(); ItemStack itemstack1 = ((EntityLiving)par1EntityLivingBase).func_130225_q(3); if (itemstack1 != null) { GL11.glPushMatrix(); int gen = this.gen + 1; float childScl = this.age; if (gen <= 1) { GL11.glScalef(1.0F / childScl, 1.0F / childScl, 1.0F / childScl); GL11.glTranslatef(-0.1F, (childScl - 1.0F) * 1.5F, 0.0F); this.modelMain.field_78112_f.func_78794_c(0.0625F); }  if (gen >= 2) { GL11.glScalef(1.0F / childScl * ((gen <= 1) ? 1.0F : 0.7F), 1.0F / childScl, 1.0F / childScl * ((gen <= 1) ? 1.0F : 0.7F)); GL11.glTranslatef(-0.1F, (childScl - 1.0F) * 1.5F, 0.0F); this.modelMain.Brightarm.func_78794_c(0.0625F); }  Item item = itemstack1.func_77973_b(); IItemRenderer customRenderer = MinecraftForgeClient.getItemRenderer(itemstack1, IItemRenderer.ItemRenderType.EQUIPPED); boolean is3D = (customRenderer != null && customRenderer.shouldUseRenderHelper(IItemRenderer.ItemRenderType.EQUIPPED, itemstack1, IItemRenderer.ItemRendererHelper.BLOCK_3D)); if (item instanceof net.minecraft.item.ItemBlock) { if (is3D || RenderBlocks.func_147739_a(Block.func_149634_a(item).func_149645_b())) { float f1 = 0.625F; GL11.glTranslatef(0.0F, -0.25F, 0.0F); GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F); GL11.glScalef(f1, -f1, -f1); }  this.field_76990_c.field_78721_f.func_78443_a(par1EntityLivingBase, itemstack1, 0); } else if (item == Items.field_151144_bL) { float f1 = 1.0625F; GL11.glScalef(f1, -f1, -f1); GameProfile gameprofile = null; if (itemstack1.func_77942_o()) { NBTTagCompound nbttagcompound = itemstack1.func_77978_p(); if (nbttagcompound.func_150297_b("SkullOwner", 10)) { gameprofile = NBTUtil.func_152459_a(nbttagcompound.func_74775_l("SkullOwner")); } else if (nbttagcompound.func_150297_b("SkullOwner", 8) && !StringUtils.func_151246_b(nbttagcompound.func_74779_i("SkullOwner"))) { gameprofile = new GameProfile((UUID)null, nbttagcompound.func_74779_i("SkullOwner")); }  }  TileEntitySkullRenderer.field_147536_b.func_152674_a(-0.5F, 0.0F, -0.5F, 1, 180.0F, itemstack1.func_77960_j(), gameprofile); }  GL11.glPopMatrix(); }  if (itemstack != null && itemstack.func_77973_b() != null) { Item item = itemstack.func_77973_b(); GL11.glPushMatrix(); if (this.field_77045_g.field_78091_s) { float f1 = 0.5F; GL11.glTranslatef(0.0F, 0.625F, 0.0F); GL11.glRotatef(-20.0F, -1.0F, 0.0F, 0.0F); GL11.glScalef(f1, f1, f1); }  int gen = this.gen + 1; float childScl = this.age; if (gen <= 1) { GL11.glScalef(1.0F / childScl, 1.0F / childScl, 1.0F / childScl); GL11.glTranslatef(-0.1F, (childScl - 1.0F) * 1.5F, 0.0F); this.modelMain.field_78112_f.func_78794_c(0.0625F); }  if (gen >= 2) { GL11.glScalef(1.0F / childScl * ((gen <= 1) ? 1.0F : 0.7F), 1.0F / childScl, 1.0F / childScl * ((gen <= 1) ? 1.0F : 0.7F)); GL11.glTranslatef(-0.1F, (childScl - 1.0F) * 1.5F, 0.0F); this.modelMain.Brightarm.func_78794_c(0.0625F); }  GL11.glTranslatef(-0.0625F, 0.4375F, 0.0625F); IItemRenderer customRenderer = MinecraftForgeClient.getItemRenderer(itemstack, IItemRenderer.ItemRenderType.EQUIPPED); boolean is3D = (customRenderer != null && customRenderer.shouldUseRenderHelper(IItemRenderer.ItemRenderType.EQUIPPED, itemstack, IItemRenderer.ItemRendererHelper.BLOCK_3D)); if (item instanceof net.minecraft.item.ItemBlock && (is3D || RenderBlocks.func_147739_a(Block.func_149634_a(item).func_149645_b()))) { float f1 = 0.5F; GL11.glTranslatef(0.0F, 0.1875F, -0.3125F); f1 *= 0.75F; GL11.glRotatef(20.0F, 1.0F, 0.0F, 0.0F); GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F); GL11.glScalef(-f1, -f1, f1); } else if (item == Items.field_151031_f) { float f1 = 0.625F; GL11.glTranslatef(0.0F, 0.125F, 0.3125F); GL11.glRotatef(-20.0F, 0.0F, 1.0F, 0.0F); GL11.glScalef(f1, -f1, f1); GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F); GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F); } else if (item.func_77662_d()) { float f1 = 0.625F; if (item.func_77629_n_()) { GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F); GL11.glTranslatef(0.0F, -0.125F, 0.0F); }  func_82422_c(); GL11.glScalef(f1, -f1, f1); GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F); GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F); } else { float f1 = 0.375F; GL11.glTranslatef(0.25F, 0.1875F, -0.1875F); GL11.glScalef(f1, f1, f1); GL11.glRotatef(60.0F, 0.0F, 0.0F, 1.0F); GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F); GL11.glRotatef(20.0F, 0.0F, 0.0F, 1.0F); }  if (itemstack.func_77973_b().func_77623_v()) { for (int i = 0; i < itemstack.func_77973_b().getRenderPasses(itemstack.func_77960_j()); i++) { int j = itemstack.func_77973_b().func_82790_a(itemstack, i); float f5 = (j >> 16 & 0xFF) / 255.0F; float f2 = (j >> 8 & 0xFF) / 255.0F; float f3 = (j & 0xFF) / 255.0F; GL11.glColor4f(f5, f2, f3, 1.0F); this.field_76990_c.field_78721_f.func_78443_a(par1EntityLivingBase, itemstack, i); }  } else { int i = itemstack.func_77973_b().func_82790_a(itemstack, 0); float f4 = (i >> 16 & 0xFF) / 255.0F; float f5 = (i >> 8 & 0xFF) / 255.0F; float f2 = (i & 0xFF) / 255.0F; GL11.glColor4f(f4, f5, f2, 1.0F); this.field_76990_c.field_78721_f.func_78443_a(par1EntityLivingBase, itemstack, 0); }  GL11.glPopMatrix(); }  }
/*      */   public void glColor3f(int c) { float h2 = (c >> 16 & 0xFF) / 255.0F; float h3 = (c >> 8 & 0xFF) / 255.0F; float h4 = (c & 0xFF) / 255.0F; float h1 = 1.0F; GL11.glColor3f(h1 * h2, h1 * h3, h1 * h4); }
/*      */   public void glColor3f(int c, float a) { float h2 = (c >> 16 & 0xFF) / 255.0F; float h3 = (c >> 8 & 0xFF) / 255.0F; float h4 = (c & 0xFF) / 255.0F; float h1 = 1.0F; if (JRMCoreH.JYC() && a > (JRMCoreHJYC.JYCgetConfigpls() / 2)) { float lifespan = JRMCoreHJYC.JYCgetConfigpls() * 0.25F; float age = a - JRMCoreHJYC.JYCgetConfigpls() * 0.5F; float grey = 0.8627451F; float percentComplete = age / lifespan; percentComplete = (percentComplete > 1.0F) ? 1.0F : percentComplete; float percentGone = 1.0F - percentComplete; float red = h2 * percentGone + grey * percentComplete; float green = h3 * percentGone + grey * percentComplete; float blue = h4 * percentGone + grey * percentComplete; h2 = red; h3 = green; h4 = blue; }  GL11.glColor3f(h1 * h2, h1 * h3, h1 * h4); }
/* 1183 */   public void doRenderLiving(EntityLivingBase par1EntityLivingBase, double par2, double par4, double par6, float par8, float par9) { if (MinecraftForge.EVENT_BUS.post((Event)new RenderLivingEvent.Pre(par1EntityLivingBase, (RendererLivingEntity)this, par2, par4, par6)))
/* 1184 */       return;  GL11.glPushMatrix();
/* 1185 */     GL11.glDisable(2884);
/*      */ 
/*      */     
/* 1188 */     this.modelMain.field_78095_p = func_77040_d(par1EntityLivingBase, par9);
/*      */     
/* 1190 */     if (this.field_77046_h != null)
/*      */     {
/* 1192 */       this.field_77046_h.field_78095_p = this.modelMain.field_78095_p;
/*      */     }
/*      */     
/* 1195 */     this.modelMain.field_78093_q = par1EntityLivingBase.func_70115_ae();
/*      */     
/* 1197 */     if (this.field_77046_h != null)
/*      */     {
/* 1199 */       this.field_77046_h.field_78093_q = this.modelMain.field_78093_q;
/*      */     }
/*      */     
/* 1202 */     this.modelMain.field_78091_s = par1EntityLivingBase.func_70631_g_();
/*      */     
/* 1204 */     if (this.field_77046_h != null)
/*      */     {
/* 1206 */       this.field_77046_h.field_78091_s = this.modelMain.field_78091_s;
/*      */     }
/*      */ 
/*      */     
/*      */     try {
/* 1211 */       float f2 = interpolateRotation(par1EntityLivingBase.field_70760_ar, par1EntityLivingBase.field_70761_aq, par9);
/* 1212 */       float f3 = interpolateRotation(par1EntityLivingBase.field_70758_at, par1EntityLivingBase.field_70759_as, par9);
/*      */ 
/*      */       
/* 1215 */       if (par1EntityLivingBase.func_70115_ae() && par1EntityLivingBase.field_70154_o instanceof EntityLivingBase) {
/*      */         
/* 1217 */         EntityLivingBase entitylivingbase1 = (EntityLivingBase)par1EntityLivingBase.field_70154_o;
/* 1218 */         f2 = interpolateRotation(entitylivingbase1.field_70760_ar, entitylivingbase1.field_70761_aq, par9);
/* 1219 */         float f = MathHelper.func_76142_g(f3 - f2);
/*      */         
/* 1221 */         if (f < -85.0F)
/*      */         {
/* 1223 */           f = -85.0F;
/*      */         }
/*      */         
/* 1226 */         if (f >= 85.0F)
/*      */         {
/* 1228 */           f = 85.0F;
/*      */         }
/*      */         
/* 1231 */         f2 = f3 - f;
/*      */         
/* 1233 */         if (f * f > 2500.0F)
/*      */         {
/* 1235 */           f2 += f * 0.2F;
/*      */         }
/*      */       } 
/*      */       
/* 1239 */       float f5 = par1EntityLivingBase.field_70127_C + (par1EntityLivingBase.field_70125_A - par1EntityLivingBase.field_70127_C) * par9;
/* 1240 */       func_77039_a(par1EntityLivingBase, par2, par4, par6);
/* 1241 */       float f4 = func_77044_a(par1EntityLivingBase, par9);
/* 1242 */       func_77043_a(par1EntityLivingBase, f4, f2, par9);
/* 1243 */       float f6 = 0.0625F;
/* 1244 */       GL11.glEnable(32826);
/* 1245 */       GL11.glScalef(-1.0F, -1.0F, 1.0F);
/* 1246 */       func_77041_b(par1EntityLivingBase, par9);
/* 1247 */       GL11.glTranslatef(0.0F, -24.0F * f6 - 0.0078125F, 0.0F);
/* 1248 */       float f7 = par1EntityLivingBase.field_70722_aY + (par1EntityLivingBase.field_70721_aZ - par1EntityLivingBase.field_70722_aY) * par9;
/* 1249 */       float f8 = par1EntityLivingBase.field_70754_ba - par1EntityLivingBase.field_70721_aZ * (1.0F - par9);
/*      */       
/* 1251 */       if (par1EntityLivingBase.func_70631_g_())
/*      */       {
/* 1253 */         f8 *= 3.0F;
/*      */       }
/*      */       
/* 1256 */       if (f7 > 1.0F)
/*      */       {
/* 1258 */         f7 = 1.0F;
/*      */       }
/*      */       
/* 1261 */       GL11.glEnable(3008);
/* 1262 */       this.modelMain.func_78086_a(par1EntityLivingBase, f8, f7, par9);
/* 1263 */       func_77036_a(par1EntityLivingBase, f8, f7, f4, f3 - f2, f5, f6);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1269 */       for (int j = 0; j < 4; j++) {
/*      */         
/* 1271 */         int k = func_77032_a(par1EntityLivingBase, j, par9);
/*      */         
/* 1273 */         if (k > 0) {
/*      */           
/* 1275 */           this.field_77046_h.func_78086_a(par1EntityLivingBase, f8, f7, par9);
/* 1276 */           this.field_77046_h.func_78088_a((Entity)par1EntityLivingBase, f8, f7, f4, f3 - f2, f5, f6);
/*      */           
/* 1278 */           if ((k & 0xF0) == 16) {
/*      */             
/* 1280 */             func_82408_c(par1EntityLivingBase, j, par9);
/* 1281 */             this.field_77046_h.func_78088_a((Entity)par1EntityLivingBase, f8, f7, f4, f3 - f2, f5, f6);
/*      */           } 
/*      */           
/* 1284 */           if ((k & 0xF) == 15) {
/*      */             
/* 1286 */             float f9 = par1EntityLivingBase.field_70173_aa + par9;
/* 1287 */             func_110776_a(RES_ITEM_GLINT);
/* 1288 */             GL11.glEnable(3042);
/* 1289 */             float f10 = 0.5F;
/* 1290 */             GL11.glColor4f(f10, f10, f10, 1.0F);
/* 1291 */             GL11.glDepthFunc(514);
/* 1292 */             GL11.glDepthMask(false);
/*      */             
/* 1294 */             for (int m = 0; m < 2; m++) {
/*      */               
/* 1296 */               GL11.glDisable(2896);
/* 1297 */               float f11 = 0.76F;
/* 1298 */               GL11.glColor4f(0.5F * f11, 0.25F * f11, 0.8F * f11, 1.0F);
/* 1299 */               GL11.glBlendFunc(768, 1);
/* 1300 */               GL11.glMatrixMode(5890);
/* 1301 */               GL11.glLoadIdentity();
/* 1302 */               float f12 = f9 * (0.001F + m * 0.003F) * 20.0F;
/* 1303 */               float f13 = 0.33333334F;
/* 1304 */               GL11.glScalef(f13, f13, f13);
/* 1305 */               GL11.glRotatef(30.0F - m * 60.0F, 0.0F, 0.0F, 1.0F);
/* 1306 */               GL11.glTranslatef(0.0F, f12, 0.0F);
/* 1307 */               GL11.glMatrixMode(5888);
/* 1308 */               this.field_77046_h.func_78088_a((Entity)par1EntityLivingBase, f8, f7, f4, f3 - f2, f5, f6);
/*      */             } 
/*      */             
/* 1311 */             GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 1312 */             GL11.glMatrixMode(5890);
/* 1313 */             GL11.glDepthMask(true);
/* 1314 */             GL11.glLoadIdentity();
/* 1315 */             GL11.glMatrixMode(5888);
/* 1316 */             GL11.glEnable(2896);
/* 1317 */             GL11.glDisable(3042);
/* 1318 */             GL11.glDepthFunc(515);
/*      */           } 
/*      */           
/* 1321 */           GL11.glDisable(3042);
/* 1322 */           GL11.glEnable(3008);
/*      */         } 
/*      */       } 
/*      */       
/* 1326 */       GL11.glDepthMask(true);
/* 1327 */       func_77029_c(par1EntityLivingBase, par9);
/* 1328 */       float f14 = par1EntityLivingBase.func_70013_c(par9);
/* 1329 */       int i = func_77030_a(par1EntityLivingBase, f14, par9);
/* 1330 */       OpenGlHelper.func_77473_a(OpenGlHelper.field_77476_b);
/* 1331 */       GL11.glDisable(3553);
/* 1332 */       OpenGlHelper.func_77473_a(OpenGlHelper.field_77478_a);
/*      */       
/* 1334 */       if ((i >> 24 & 0xFF) > 0 || par1EntityLivingBase.field_70737_aN > 0 || par1EntityLivingBase.field_70725_aQ > 0) {
/*      */         
/* 1336 */         GL11.glDisable(3553);
/* 1337 */         GL11.glDisable(3008);
/* 1338 */         GL11.glEnable(3042);
/* 1339 */         GL11.glBlendFunc(770, 771);
/* 1340 */         GL11.glDepthFunc(514);
/*      */         
/* 1342 */         if (par1EntityLivingBase.field_70737_aN > 0 || par1EntityLivingBase.field_70725_aQ > 0) {
/*      */           
/* 1344 */           GL11.glColor4f(f14, 0.0F, 0.0F, 0.4F);
/* 1345 */           this.modelMain.func_78088_a((Entity)par1EntityLivingBase, f8, f7, f4, f3 - f2, f5, f6);
/*      */           
/* 1347 */           for (int l = 0; l < 4; l++) {
/*      */             
/* 1349 */             if (func_77035_b(par1EntityLivingBase, l, par9) >= 0) {
/*      */               
/* 1351 */               GL11.glColor4f(f14, 0.0F, 0.0F, 0.4F);
/* 1352 */               this.field_77046_h.func_78088_a((Entity)par1EntityLivingBase, f8, f7, f4, f3 - f2, f5, f6);
/*      */             } 
/*      */           } 
/*      */         } 
/*      */         
/* 1357 */         if ((i >> 24 & 0xFF) > 0) {
/*      */           
/* 1359 */           float f9 = (i >> 16 & 0xFF) / 255.0F;
/* 1360 */           float f10 = (i >> 8 & 0xFF) / 255.0F;
/* 1361 */           float f15 = (i & 0xFF) / 255.0F;
/* 1362 */           float f11 = (i >> 24 & 0xFF) / 255.0F;
/* 1363 */           GL11.glColor4f(f9, f10, f15, f11);
/* 1364 */           this.modelMain.func_78088_a((Entity)par1EntityLivingBase, f8, f7, f4, f3 - f2, f5, f6);
/*      */           
/* 1366 */           for (int i1 = 0; i1 < 4; i1++) {
/*      */             
/* 1368 */             if (func_77035_b(par1EntityLivingBase, i1, par9) >= 0) {
/*      */               
/* 1370 */               GL11.glColor4f(f9, f10, f15, f11);
/* 1371 */               this.field_77046_h.func_78088_a((Entity)par1EntityLivingBase, f8, f7, f4, f3 - f2, f5, f6);
/*      */             } 
/*      */           } 
/*      */         } 
/*      */         
/* 1376 */         GL11.glDepthFunc(515);
/* 1377 */         GL11.glDisable(3042);
/* 1378 */         GL11.glEnable(3008);
/* 1379 */         GL11.glEnable(3553);
/*      */       } 
/*      */       
/* 1382 */       GL11.glDisable(32826);
/*      */     }
/* 1384 */     catch (Exception exception) {
/*      */       
/* 1386 */       exception.printStackTrace();
/*      */     } 
/*      */     
/* 1389 */     OpenGlHelper.func_77473_a(OpenGlHelper.field_77476_b);
/* 1390 */     GL11.glEnable(3553);
/* 1391 */     OpenGlHelper.func_77473_a(OpenGlHelper.field_77478_a);
/* 1392 */     GL11.glEnable(2884);
/* 1393 */     GL11.glPopMatrix();
/* 1394 */     func_77033_b(par1EntityLivingBase, par2, par4, par6);
/* 1395 */     MinecraftForge.EVENT_BUS.post((Event)new RenderLivingEvent.Post(par1EntityLivingBase, (RendererLivingEntity)this, par2, par4, par6)); }
/*      */   private void renderSkins(EntityLivingBase par1EntityLivingBase, float par2) { boolean dbc = JRMCoreH.DBC(); if (par1EntityLivingBase instanceof EntityNPC) { EntityNPC e = (EntityNPC)par1EntityLivingBase; this.dns = e.getDNS(); this.dnsH = e.getDNSH(); this.dnsH = JRMCoreH.dnsHairG1toG2(this.dnsH); if (this.dns.length() > 5) { int State = 0; int ts = 0; int race = JRMCoreH.dnsRace(this.dns); int gen = JRMCoreH.dnsGender(this.dns); int haircol = JRMCoreH.dnsHairC(this.dns); int hairback = JRMCoreH.dnsHairB(this.dns); int breast = JRMCoreH.dnsBreast(this.dns); int skintype = JRMCoreH.dnsSkinT(this.dns); int bodytype = (skintype == 0) ? 0 : JRMCoreH.dnsBodyT(this.dns); int bodycm = (skintype == 0) ? 0 : JRMCoreH.dnsBodyCM(this.dns); int bodyc1 = (skintype == 0) ? 0 : JRMCoreH.dnsBodyC1(this.dns); int bodyc2 = (skintype == 0) ? 0 : JRMCoreH.dnsBodyC2(this.dns); int bodyc3 = (skintype == 0) ? 0 : JRMCoreH.dnsBodyC3(this.dns); int facen = (skintype == 0) ? 0 : JRMCoreH.dnsFaceN(this.dns); int facem = (skintype == 0) ? 0 : JRMCoreH.dnsFaceM(this.dns); int eyes = (skintype == 0) ? 0 : JRMCoreH.dnsEyes(this.dns); int eyec1 = (skintype == 0) ? 0 : JRMCoreH.dnsEyeC1(this.dns); int eyec2 = (skintype == 0) ? 0 : JRMCoreH.dnsEyeC2(this.dns); int superhcol = 16574610; int superecol = 2988684; int plyrSpc = (skintype == 0) ? 0 : ((JRMCoreH.RaceCustomSkin[race] == 0) ? 0 : ((bodytype >= JRMCoreH.Specials[race]) ? (JRMCoreH.Specials[race] - 1) : bodytype)); float f5 = e.field_70126_B + (e.field_70177_z - e.field_70126_B) * par2 - e.field_70760_ar + (e.field_70761_aq - e.field_70760_ar) * par2; float f3 = e.field_70127_C + (e.field_70125_A - e.field_70127_C) * par2; GL11.glPushMatrix(); if (JRMCoreH.isRaceMajin(race) && dbc) { haircol = bodycm; if (skintype != 0) { ResourceLocation bdyskn = new ResourceLocation("jinryuudragonbc:cc/majin/" + ((gen == 1) ? "f" : "") + "majin.png"); this.curSkin = bdyskn; func_110776_a(bdyskn); glColor3f(bodycm); this.modelMain.renderBody(0.0625F, 1, breast); func_110776_a(new ResourceLocation("jinryuudragonbc:cc/majin/" + ((gen == 1) ? "f" : "") + "majinn" + facen + ".png")); glColor3f(bodycm); this.modelMain.renderHairs(0.0625F, "FACENOSE"); func_110776_a(new ResourceLocation("jinryuudragonbc:cc/majin/" + ((gen == 1) ? "f" : "") + "majinm" + facem + ".png")); glColor3f(bodycm); this.modelMain.renderHairs(0.0625F, "FACEMOUTH"); func_110776_a(new ResourceLocation("jinryuudragonbc:cc/majin/" + ((gen == 1) ? "f" : "") + "majinb" + eyes + ".png")); GL11.glColor3f(1.0F, 1.0F, 1.0F); this.modelMain.renderHairs(0.0625F, "EYEBASE"); func_110776_a(new ResourceLocation("jinryuudragonbc:cc/majin/" + ((gen == 1) ? "f" : "") + "majinl" + eyes + ".png")); glColor3f(((race == 1 || race == 2) && State != 0) ? superecol : eyec1); this.modelMain.renderHairs(0.0625F, "EYELEFT"); func_110776_a(new ResourceLocation("jinryuudragonbc:cc/majin/" + ((gen == 1) ? "f" : "") + "majinr" + eyes + ".png")); glColor3f(((race == 1 || race == 2) && State != 0) ? superecol : eyec2); this.modelMain.renderHairs(0.0625F, "EYERIGHT"); }  if ((race == 1 || race == 2) && dbc) { float f = 1.0F; int i = (State == 0) ? ((skintype == 1) ? bodyc1 : 6498048) : 16574610; func_110776_a(new ResourceLocation("jinryuudragonbc:gui/allw.png")); glColor3f(i); this.modelMain.renderHairs(0.0625F, (ts == 0 || ts == -1) ? "SJT1" : ((ts == 1) ? "SJT2" : "")); }  float h1 = 1.0F; int j = haircol; int Hair = hairback; if ((Hair == 8 || Hair == 9) && (State == 0 || State == 1)) { j = (State != 0) ? 16574610 : j; String s1 = (Hair == 8) ? "c2" : "c1"; func_110776_a(new ResourceLocation("jinryuumodscore:gui/" + s1 + ".png")); } else if (Hair >= 0 && Hair <= 12) { j = (State != 0) ? 16574610 : j; String s1 = (State == 0) ? "normall" : "superall"; func_110776_a(new ResourceLocation("jinryuumodscore:gui/" + s1 + ".png")); }  glColor3f(j, haircol); if (Hair < 10) Hair = (Hair % 2 == 0) ? 10 : 11;  if (Hair == 10) { func_110776_a(new ResourceLocation("jinryuumodscore:gui/normallmajin.png")); glColor3f(haircol); this.modelMain.renderHairsV2(0.0625F, "005050555050000050505550500000505055505000005050455050000050505250500000505052505000005050555050000050505450500000505052505000005050525050000150433450500000505055505000005050525050000054395050500000505045505000005050475050000050504750500000505047505000015043655050000050504750500000505047505000005050475050000050504750500000544545505000005250505050000052505050500000525050505000005250505050000050505050500000505050505000005050505050000052505050500000525050505000005250505050000052505050500000525050505000005245505050000054505050500000525050505000005252505050000070505050500000705050505000007050505050000070505050500000705050505000347050505050003470505050500000705050505000007050505050000069505050500000695050505000007050505050000070505050500000705050505000007050505050000070505050500020", 0.0F, State, 0, e.func_145782_y(), race, this); } else if (Hair == 11) { func_110776_a(new ResourceLocation("jinryuumodscore:gui/normallmajin.png")); glColor3f(haircol); this.modelMain.renderHairsV2(0.0625F, "345052545050001250545650500023505041505000345056455050000150505250500001505052505000015050555050000150505450500001505052505000015050525050000150433450500001505055505000015050525050000154395050500001505045505000015050475050000150504750500001505047505000015043655050000150504750500001505047505000015050475050000150504750500001544545505000015250505050003450505050500034505050505000015250505050000150505050500001505050505000015050505050000150505050500001525050505000015050505050000150505050500001525050505000235250505050003450505050500034505050505000235250505050000180501850500034695050505000346950505050000180501950500001805019505000345850505050003463505050500001805018505000018050185050003476505050500034765050505000018050195050003480501850500034505050505000345050505050003480501950500020", 0.0F, State, 0, e.func_145782_y(), race, this); } else if (Hair == 12) { func_110776_a(new ResourceLocation("jinryuumodscore:gui/normallmajin.png")); if (JRMCoreGuiScreen.hairPreview > 0) State = JRMCoreGuiScreen.hairPreviewStates[JRMCoreGuiScreen.hairPreview];  if (State == 6) { this.modelMain.renderHairs(0.0625F, "" + JRMCoreH.HairsT[6] + JRMCoreH.Hairs[0]); } else { this.modelMain.renderHairsV2(0.0625F, this.dnsH, 0.0F, State, 0, e.func_145782_y(), race, this); }  } else { this.modelMain.renderHairs(0.0625F, "" + JRMCoreH.HairsT[State] + JRMCoreH.Hairs[Hair]); }  } else if (race == 3 && dbc) { int j = 5095183; func_110776_a(new ResourceLocation("jinryuudragonbc:gui/allw.png")); float h1 = 1.0F; glColor3f(bodycm); this.modelMain.renderHairs(0.0625F, "N"); ResourceLocation bdyskn = new ResourceLocation("jinryuudragonbc:cc/nam/0nam" + plyrSpc + ".png"); this.curSkin = bdyskn; func_110776_a(bdyskn); glColor3f(bodycm); this.modelMain.renderBody(0.0625F, 1); bdyskn = new ResourceLocation("jinryuudragonbc:cc/nam/1nam" + plyrSpc + ".png"); this.curSkin = bdyskn; func_110776_a(bdyskn); glColor3f(bodyc1); this.modelMain.renderBody(0.0625F, 1); bdyskn = new ResourceLocation("jinryuudragonbc:cc/nam/2nam" + plyrSpc + ".png"); this.curSkin = bdyskn; func_110776_a(bdyskn); glColor3f(bodyc2); this.modelMain.renderBody(0.0625F, 1); bdyskn = new ResourceLocation("jinryuudragonbc:cc/nam/3nam" + plyrSpc + ".png"); this.curSkin = bdyskn; func_110776_a(bdyskn); GL11.glColor3f(h1, h1, h1); this.modelMain.renderBody(0.0625F, 1, breast); func_110776_a(new ResourceLocation("jinryuudragonbc", "cc/nam/4namn" + facen + ".png")); glColor3f(bodycm); this.modelMain.renderHairs(0.0625F, "FACENOSE"); func_110776_a(new ResourceLocation("jinryuudragonbc", "cc/nam/4namm" + facem + ".png")); glColor3f(bodycm); this.modelMain.renderHairs(0.0625F, "FACEMOUTH"); func_110776_a(new ResourceLocation("jinryuudragonbc", "cc/nam/4namb" + eyes + ".png")); GL11.glColor3f(1.0F, 1.0F, 1.0F); this.modelMain.renderHairs(0.0625F, "EYEBASE"); func_110776_a(new ResourceLocation("jinryuudragonbc", "cc/nam/4naml" + eyes + ".png")); glColor3f(eyec1); this.modelMain.renderHairs(0.0625F, "EYELEFT"); func_110776_a(new ResourceLocation("jinryuudragonbc", "cc/nam/4namr" + eyes + ".png")); glColor3f(eyec2); this.modelMain.renderHairs(0.0625F, "EYERIGHT"); func_110776_a(new ResourceLocation("jinryuudragonbc", "cc/nam/4namw" + eyes + ".png")); glColor3f(bodycm); this.modelMain.renderHairs(0.0625F, "EYEBROW"); } else if (race == 4 && dbc) { func_110776_a(new ResourceLocation("jinryuudragonbc:cc/arc/" + ((gen == 1) ? "f" : "m") + "/0B" + JRMCoreH.TransFrSkn2[State] + plyrSpc + ".png")); glColor3f(bodycm); this.modelMain.renderHairs(0.0625F, "FR" + JRMCoreH.TransFrHrn[State]); ResourceLocation bdyskn = new ResourceLocation("jinryuudragonbc:cc/arc/" + ((gen == 1) ? "f" : "m") + "/0A" + JRMCoreH.TransFrSkn[State] + plyrSpc + ".png"); this.curSkin = bdyskn; func_110776_a(bdyskn); glColor3f(bodycm); this.modelMain.renderBody(0.0625F, 1, breast); func_110776_a(new ResourceLocation("jinryuudragonbc:cc/arc/" + ((gen == 1) ? "f" : "m") + "/1B" + JRMCoreH.TransFrSkn2[State] + plyrSpc + ".png")); glColor3f(bodyc1); this.modelMain.renderHairs(0.0625F, "FR" + JRMCoreH.TransFrHrn[State]); bdyskn = new ResourceLocation("jinryuudragonbc:cc/arc/" + ((gen == 1) ? "f" : "m") + "/1A" + JRMCoreH.TransFrSkn[State] + plyrSpc + ".png"); this.curSkin = bdyskn; func_110776_a(bdyskn); glColor3f(bodyc1); this.modelMain.renderBody(0.0625F, 1, breast); func_110776_a(new ResourceLocation("jinryuudragonbc:cc/arc/" + ((gen == 1) ? "f" : "m") + "/2B" + JRMCoreH.TransFrSkn2[State] + plyrSpc + ".png")); glColor3f(bodyc2); this.modelMain.renderHairs(0.0625F, "FR" + JRMCoreH.TransFrHrn[State]); bdyskn = new ResourceLocation("jinryuudragonbc:cc/arc/" + ((gen == 1) ? "f" : "m") + "/2A" + JRMCoreH.TransFrSkn[State] + plyrSpc + ".png"); this.curSkin = bdyskn; func_110776_a(bdyskn); glColor3f(bodyc2); this.modelMain.renderBody(0.0625F, 1, breast); func_110776_a(new ResourceLocation("jinryuudragonbc:cc/arc/" + ((gen == 1) ? "f" : "m") + "/3B" + JRMCoreH.TransFrSkn2[State] + plyrSpc + ".png")); glColor3f(bodyc3); this.modelMain.renderHairs(0.0625F, "FR" + JRMCoreH.TransFrHrn[State]); bdyskn = new ResourceLocation("jinryuudragonbc:cc/arc/" + ((gen == 1) ? "f" : "m") + "/3A" + JRMCoreH.TransFrSkn[State] + plyrSpc + ".png"); this.curSkin = bdyskn; func_110776_a(bdyskn); glColor3f(bodyc3); this.modelMain.renderBody(0.0625F, 1, breast); func_110776_a(new ResourceLocation("jinryuudragonbc:cc/arc/" + ((gen == 1) ? "f" : "m") + "/4B" + JRMCoreH.TransFrSkn2[State] + plyrSpc + ".png")); float h1 = 1.0F; GL11.glColor3f(h1, h1, h1); this.modelMain.renderHairs(0.0625F, "FR" + JRMCoreH.TransFrHrn[State]); bdyskn = new ResourceLocation("jinryuudragonbc:cc/arc/" + ((gen == 1) ? "f" : "m") + "/4A" + JRMCoreH.TransFrSkn[State] + plyrSpc + ".png"); this.curSkin = bdyskn; func_110776_a(bdyskn); GL11.glColor3f(h1, h1, h1); this.modelMain.renderBody(0.0625F, 1, breast); func_110776_a(new ResourceLocation("jinryuudragonbc", "cc/arc/" + ((gen == 1) ? "f" : "m") + "/4A" + JRMCoreH.TransFrSkn[State] + plyrSpc + "n" + facen + ".png")); glColor3f(bodyc1); this.modelMain.renderHairs(0.0625F, "FACENOSE"); func_110776_a(new ResourceLocation("jinryuudragonbc", "cc/arc/" + ((gen == 1) ? "f" : "m") + "/4A" + JRMCoreH.TransFrSkn[State] + plyrSpc + "m" + facem + ".png")); glColor3f(bodyc1); this.modelMain.renderHairs(0.0625F, "FACEMOUTH"); func_110776_a(new ResourceLocation("jinryuudragonbc", "cc/arc/" + ((gen == 1) ? "f" : "m") + "/4A" + JRMCoreH.TransFrSkn[State] + plyrSpc + "b" + eyes + ".png")); GL11.glColor3f(1.0F, 1.0F, 1.0F); this.modelMain.renderHairs(0.0625F, "EYEBASE"); func_110776_a(new ResourceLocation("jinryuudragonbc", "cc/arc/" + ((gen == 1) ? "f" : "m") + "/4A" + JRMCoreH.TransFrSkn[State] + plyrSpc + "l" + eyes + ".png")); glColor3f(eyec1); this.modelMain.renderHairs(0.0625F, "EYELEFT"); func_110776_a(new ResourceLocation("jinryuudragonbc", "cc/arc/" + ((gen == 1) ? "f" : "m") + "/4A" + JRMCoreH.TransFrSkn[State] + plyrSpc + "r" + eyes + ".png")); glColor3f(eyec2); this.modelMain.renderHairs(0.0625F, "EYERIGHT"); } else { if (skintype != 0) { ResourceLocation bdyskn = new ResourceLocation("jinryuumodscore:cc/" + ((gen == 1) ? "f" : "") + "hum.png"); this.curSkin = bdyskn; func_110776_a(bdyskn); glColor3f(bodycm); this.modelMain.renderBody(0.0625F, 1, breast); func_110776_a(new ResourceLocation("jinryuumodscore", "cc/" + ((gen == 1) ? "f" : "") + "humn" + facen + ".png")); glColor3f(bodycm); this.modelMain.renderHairs(0.0625F, "FACENOSE"); func_110776_a(new ResourceLocation("jinryuumodscore", "cc/" + ((gen == 1) ? "f" : "") + "humm" + facem + ".png")); glColor3f(bodycm); this.modelMain.renderHairs(0.0625F, "FACEMOUTH"); func_110776_a(new ResourceLocation("jinryuumodscore", "cc/" + ((gen == 1) ? "f" : "") + "humb" + eyes + ".png")); GL11.glColor3f(1.0F, 1.0F, 1.0F); this.modelMain.renderHairs(0.0625F, "EYEBASE"); func_110776_a(new ResourceLocation("jinryuumodscore", "cc/" + ((gen == 1) ? "f" : "") + "huml" + eyes + ".png")); glColor3f(((race == 1 || race == 2) && State != 0) ? superecol : eyec1); this.modelMain.renderHairs(0.0625F, "EYELEFT"); func_110776_a(new ResourceLocation("jinryuumodscore", "cc/" + ((gen == 1) ? "f" : "") + "humr" + eyes + ".png")); glColor3f(((race == 1 || race == 2) && State != 0) ? superecol : eyec2); this.modelMain.renderHairs(0.0625F, "EYERIGHT"); func_110776_a(new ResourceLocation("jinryuumodscore", "cc/" + ((gen == 1) ? "f" : "") + "humw" + eyes + ".png")); if ((race == 1 || race == 2) && State != 0) { glColor3f(superhcol); } else { glColor3f(haircol, this.age); }  this.modelMain.renderHairs(0.0625F, "EYEBROW"); }  if ((race == 1 || race == 2) && dbc) { float f = 1.0F; int i = (State == 0) ? ((skintype == 1) ? bodyc1 : 6498048) : 16574610; func_110776_a(new ResourceLocation("jinryuudragonbc:gui/allw.png")); glColor3f(i); this.modelMain.renderHairs(0.0625F, (ts == 0 || ts == -1) ? "SJT1" : ((ts == 1) ? "SJT2" : "")); }  float h1 = 1.0F; int j = haircol; int Hair = hairback; if ((Hair == 8 || Hair == 9) && (State == 0 || State == 1)) { j = (State != 0) ? 16574610 : j; String s1 = (Hair == 8) ? "c2" : "c1"; func_110776_a(new ResourceLocation("jinryuumodscore:gui/" + s1 + ".png")); } else if (Hair >= 0 && Hair <= 12) { j = (State != 0) ? 16574610 : j; String s1 = (State == 0) ? "normall" : "superall"; func_110776_a(new ResourceLocation("jinryuumodscore:gui/" + s1 + ".png")); }  if (State != 0) { glColor3f(j); } else { glColor3f(j, this.age); }  if (Hair == 12) { func_110776_a(new ResourceLocation("jinryuumodscore:gui/normall.png")); if (JRMCoreGuiScreen.hairPreview > 0) State = JRMCoreGuiScreen.hairPreviewStates[JRMCoreGuiScreen.hairPreview];  if (State == 6) { this.modelMain.renderHairs(0.0625F, "" + JRMCoreH.HairsT[6] + JRMCoreH.Hairs[0]); } else { this.modelMain.renderHairsV2(0.0625F, this.dnsH, 0.0F, State, 0, e.func_145782_y(), race, this); }  } else if (Hair != 10) { this.modelMain.renderHairs(0.0625F, "" + JRMCoreH.HairsT[State] + JRMCoreH.Hairs[Hair]); }  }  GL11.glPopMatrix(); if (dbc) { int armr = 0; ItemStack itemstack2 = e.func_130225_q(3 - armr); GL11.glPushMatrix(); GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F); GL11.glEnable(3042); GL11.glBlendFunc(770, 771); if (itemstack2 != null) { Item item = itemstack2.func_77973_b(); if (item instanceof ItemArmor) { ItemArmor itemarmor = (ItemArmor)item; ItemArmor var6 = itemarmor; ItemStack par1 = itemstack2; boolean normalRender = false; if (JRMCoreH.DBC()) { ItemArmor.ArmorMaterial all = null; ItemArmor.ArmorMaterial scouter1 = DBCArmorMatscouter1(); ItemArmor.ArmorMaterial scouter2 = DBCArmorMatscouter2(); ItemArmor.ArmorMaterial scouter3 = DBCArmorMatscouter3(); if (var6.func_82812_d() == scouter1) all = scouter1;  if (var6.func_82812_d() == scouter2) all = scouter2;  if (var6.func_82812_d() == scouter3)
/*      */                   all = scouter3;  ItemArmor.ArmorMaterial loaded = all; if (var6.func_82812_d() == all) { func_110776_a(RenderBiped.getArmorResource((Entity)e, itemstack2, armr, null)); this.modelMain.field_78116_c.field_78806_j = (armr == 0); this.modelMain.renderHairs(0.0625F, "SC"); }  }  }  }  GL11.glPopMatrix(); }  boolean bool = false; if (dbc && bool) { GL11.glPushMatrix(); func_110776_a(new ResourceLocation("jinryuudragonbc:armor/halo.png")); GL11.glColor3f(1.0F, 1.0F, 1.0F); this.modelMain.renderHalo(0.0625F); GL11.glPopMatrix(); }  }  }  boolean dead = false; if (dead) { GL11.glPushMatrix(); func_110776_a(new ResourceLocation("jinryuudragonbc:armor/halo.png")); GL11.glColor3f(1.0F, 1.0F, 1.0F); this.modelMain.renderHalo(0.0625F); GL11.glPopMatrix(); }  }
/*      */   private ItemArmor.ArmorMaterial DBCArmorMatGI() { return ItemsDBC.GI; }
/*      */   private ItemArmor.ArmorMaterial DBCArmorMattier0() { return ItemsDBC.tier0; }
/*      */   private ItemArmor.ArmorMaterial DBCArmorMattier1() { return ItemsDBC.tier1; }
/* 1401 */   private ItemArmor.ArmorMaterial DBCArmorMattier2() { return ItemsDBC.tier2; } private float interpolateRotation(float par1, float par2, float par3) { float f3; for (f3 = par2 - par1; f3 < -180.0F; f3 += 360.0F);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1406 */     while (f3 >= 180.0F)
/*      */     {
/* 1408 */       f3 -= 360.0F;
/*      */     }
/*      */     
/* 1411 */     return par1 + par3 * f3; }
/*      */   private ItemArmor.ArmorMaterial DBCArmorMattier3() { return ItemsDBC.tier3; }
/*      */   private ItemArmor.ArmorMaterial DBCArmorMatscouter1() { return ItemsDBC.scouter1; }
/* 1414 */   private ItemArmor.ArmorMaterial DBCArmorMatscouter2() { return ItemsDBC.scouter2; } private ItemArmor.ArmorMaterial DBCArmorMatscouter3() { return ItemsDBC.scouter3; } protected void func_77033_b(EntityLivingBase par1EntityLivingBase, double par2, double par4, double par6) { if (MinecraftForge.EVENT_BUS.post((Event)new RenderLivingEvent.Specials.Pre(par1EntityLivingBase, (RendererLivingEntity)this, par2, par4, par6))) return;  if (this.b) { float f = 1.6F; float f1 = 0.016666668F * f; double d3 = par1EntityLivingBase.func_70068_e((Entity)this.field_76990_c.field_78734_h); float f2 = par1EntityLivingBase.func_70093_af() ? NAME_TAG_RANGE_SNEAK : NAME_TAG_RANGE; if (d3 < (f2 * f2)) { String s = ((EntityNPC)par1EntityLivingBase).getNam(); if (par1EntityLivingBase.func_70093_af()) { FontRenderer fontrenderer = func_76983_a(); GL11.glPushMatrix(); GL11.glTranslatef((float)par2 + 0.0F, (float)par4 + par1EntityLivingBase.field_70131_O + 0.5F, (float)par6); GL11.glNormal3f(0.0F, 1.0F, 0.0F); GL11.glRotatef(-this.field_76990_c.field_78735_i, 0.0F, 1.0F, 0.0F); GL11.glRotatef(this.field_76990_c.field_78732_j, 1.0F, 0.0F, 0.0F); GL11.glScalef(-f1, -f1, f1); GL11.glDisable(2896); GL11.glTranslatef(0.0F, 0.25F / f1, 0.0F); GL11.glDepthMask(false); GL11.glEnable(3042); GL11.glBlendFunc(770, 771); Tessellator tessellator = Tessellator.field_78398_a; GL11.glDisable(3553); tessellator.func_78382_b(); int i = fontrenderer.func_78256_a(s) / 2; tessellator.func_78369_a(0.0F, 0.0F, 0.0F, 0.25F); tessellator.func_78377_a((-i - 1), -1.0D, 0.0D); tessellator.func_78377_a((-i - 1), 8.0D, 0.0D); tessellator.func_78377_a((i + 1), 8.0D, 0.0D); tessellator.func_78377_a((i + 1), -1.0D, 0.0D); tessellator.func_78381_a(); GL11.glEnable(3553); GL11.glDepthMask(true); fontrenderer.func_78276_b(s, -fontrenderer.func_78256_a(s) / 2, 0, 553648127); GL11.glEnable(2896); GL11.glDisable(3042); GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F); GL11.glPopMatrix(); } else { func_96449_a(par1EntityLivingBase, par2, par4, par6, s, f1, d3); }  }  }  MinecraftForge.EVENT_BUS.post((Event)new RenderLivingEvent.Specials.Post(par1EntityLivingBase, (RendererLivingEntity)this, par2, par4, par6)); } protected void renderLivingLabel(EntityLivingBase par1EntityLivingBase, String par2Str, double par3, double par5, double par7, int par9) { double d3 = par1EntityLivingBase.func_70068_e((Entity)this.field_76990_c.field_78734_h); if (d3 <= (par9 * par9)) { FontRenderer fontrenderer = func_76983_a(); float f = 1.6F; float f1 = 0.016666668F * f; GL11.glPushMatrix(); GL11.glTranslatef((float)par3 + 0.0F, (float)par5 + par1EntityLivingBase.field_70131_O + 0.7F, (float)par7); GL11.glNormal3f(0.0F, 1.0F, 0.0F); GL11.glRotatef(-this.field_76990_c.field_78735_i, 0.0F, 1.0F, 0.0F); GL11.glRotatef(this.field_76990_c.field_78732_j, 1.0F, 0.0F, 0.0F); GL11.glScalef(-f1, -f1, f1); GL11.glDisable(2896); GL11.glDepthMask(false); GL11.glDisable(2929); GL11.glEnable(3042); GL11.glBlendFunc(770, 771); Tessellator tessellator = Tessellator.field_78398_a; byte b0 = 0; if (par2Str.equals("deadmau5")) b0 = -10;  GL11.glDisable(3553); tessellator.func_78382_b(); int j = fontrenderer.func_78256_a(par2Str) / 2; tessellator.func_78369_a(0.0F, 0.0F, 0.0F, 0.25F); tessellator.func_78377_a((-j - 1), (-1 + b0), 0.0D); tessellator.func_78377_a((-j - 1), (8 + b0), 0.0D); tessellator.func_78377_a((j + 1), (8 + b0), 0.0D); tessellator.func_78377_a((j + 1), (-1 + b0), 0.0D); tessellator.func_78381_a(); GL11.glEnable(3553); fontrenderer.func_78276_b(par2Str, -fontrenderer.func_78256_a(par2Str) / 2, b0, 553648127); GL11.glEnable(2929); GL11.glDepthMask(true); fontrenderer.func_78276_b(par2Str, -fontrenderer.func_78256_a(par2Str) / 2, b0, -1); GL11.glEnable(2896); GL11.glDisable(3042); GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F); GL11.glPopMatrix(); }  } public static HashMap<Integer, Integer> state = new HashMap<Integer, Integer>();
/* 1415 */   public static HashMap<Integer, Integer> stateChange = new HashMap<Integer, Integer>();
/* 1416 */   public static HashMap<Integer, Integer> state2Change = new HashMap<Integer, Integer>();
/* 1417 */   public static HashMap<Integer, Integer> auratype = new HashMap<Integer, Integer>();
/* 1418 */   public static HashMap<Integer, Integer> auratime = new HashMap<Integer, Integer>();
/* 1419 */   public static HashMap<Integer, Integer> bendtime = new HashMap<Integer, Integer>();
/*      */   public int getState(int pl) {
/* 1421 */     return (state.get(Integer.valueOf(pl)) == null) ? 0 : ((Integer)state.get(Integer.valueOf(pl))).intValue();
/*      */   }
/*      */   public void setState(int state, int pl) {
/* 1424 */     this; RenderJFC.state.put(Integer.valueOf(pl), Integer.valueOf(state));
/*      */   }
/*      */   public int getStateChange(int pl) {
/* 1427 */     return (stateChange.get(Integer.valueOf(pl)) == null) ? 0 : ((Integer)stateChange.get(Integer.valueOf(pl))).intValue();
/*      */   }
/*      */   public void setStateChange(int stateChange, int pl) {
/* 1430 */     this; RenderJFC.stateChange.put(Integer.valueOf(pl), Integer.valueOf(stateChange));
/*      */   }
/*      */   public int getState2Change(int pl) {
/* 1433 */     return (state2Change.get(Integer.valueOf(pl)) == null) ? 0 : ((Integer)state2Change.get(Integer.valueOf(pl))).intValue();
/*      */   }
/*      */   public void setState2Change(int state2Change, int pl) {
/* 1436 */     this; RenderJFC.state2Change.put(Integer.valueOf(pl), Integer.valueOf(state2Change));
/*      */   }
/*      */   public int getAuratype(int pl) {
/* 1439 */     return (auratype.get(Integer.valueOf(pl)) == null) ? 0 : ((Integer)auratype.get(Integer.valueOf(pl))).intValue();
/*      */   }
/*      */   public void setAuratype(int auratype, int pl) {
/* 1442 */     this; RenderJFC.auratype.put(Integer.valueOf(pl), Integer.valueOf(auratype));
/*      */   }
/*      */   public int getAuratime(int pl) {
/* 1445 */     return (auratime.get(Integer.valueOf(pl)) == null) ? 0 : ((Integer)auratime.get(Integer.valueOf(pl))).intValue();
/*      */   }
/*      */   public void setAuratime(int auratime, int pl) {
/* 1448 */     this; RenderJFC.auratime.put(Integer.valueOf(pl), Integer.valueOf(auratime));
/*      */   }
/*      */   public int getBendtime(int pl) {
/* 1451 */     return (bendtime.get(Integer.valueOf(pl)) == null) ? 0 : ((Integer)bendtime.get(Integer.valueOf(pl))).intValue();
/*      */   }
/*      */   public void setBendtime(int bendtime, int pl) {
/* 1454 */     this; RenderJFC.bendtime.put(Integer.valueOf(pl), Integer.valueOf(bendtime));
/*      */   }
/*      */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JFamilyC-v1.2.18.jar!\JinRyuu\FamilyC\RenderJFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */