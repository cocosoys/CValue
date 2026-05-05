/*     */ package net.minecraft.client.renderer.entity;
/*     */ 
/*     */ import com.google.common.collect.Maps;
/*     */ import com.mojang.authlib.GameProfile;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Map;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelBiped;
/*     */ import net.minecraft.client.renderer.RenderBlocks;
/*     */ import net.minecraft.client.renderer.tileentity.TileEntitySkullRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemArmor;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTUtil;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.util.StringUtils;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class RenderBiped extends RenderLiving {
/*     */   public ModelBiped field_77071_a;
/*     */   protected float field_77070_b;
/*  30 */   private static final Map field_110859_k = Maps.newHashMap();
/*     */   protected ModelBiped field_82423_g;
/*  32 */   public static String[] field_82424_k = new String[] { "leather", "chainmail", "iron", "diamond", "gold" };
/*     */   protected ModelBiped field_82425_h;
/*     */   private static final String __OBFID = "CL_00001001";
/*     */   
/*     */   public RenderBiped(ModelBiped p_i1257_1_, float p_i1257_2_) {
/*  37 */     this(p_i1257_1_, p_i1257_2_, 1.0F);
/*     */   }
/*     */   
/*     */   public RenderBiped(ModelBiped p_i1258_1_, float p_i1258_2_, float p_i1258_3_) {
/*  41 */     super((ModelBase)p_i1258_1_, p_i1258_2_);
/*  42 */     this.field_77071_a = p_i1258_1_;
/*  43 */     this.field_77070_b = p_i1258_3_;
/*     */     
/*  45 */     func_82421_b();
/*     */   }
/*     */   
/*     */   protected void func_82421_b() {
/*  49 */     this.field_82423_g = new ModelBiped(1.0F);
/*  50 */     this.field_82425_h = new ModelBiped(0.5F);
/*     */   }
/*     */   
/*     */   public static ResourceLocation func_110857_a(ItemArmor p_110857_0_, int p_110857_1_) {
/*  54 */     return func_110858_a(p_110857_0_, p_110857_1_, (String)null);
/*     */   }
/*     */   
/*     */   public static ResourceLocation func_110858_a(ItemArmor p_110858_0_, int p_110858_1_, String p_110858_2_) {
/*  58 */     String str = String.format("textures/models/armor/%s_layer_%d%s.png", new Object[] { field_82424_k[p_110858_0_.field_77880_c], Integer.valueOf((p_110858_1_ == 2) ? 2 : 1), (p_110858_2_ == null) ? "" : String.format("_%s", new Object[] { p_110858_2_ }) });
/*     */     
/*  60 */     ResourceLocation resourceLocation = (ResourceLocation)field_110859_k.get(str);
/*  61 */     if (resourceLocation == null) {
/*  62 */       resourceLocation = new ResourceLocation(str);
/*  63 */       field_110859_k.put(str, resourceLocation);
/*     */     } 
/*     */     
/*  66 */     return resourceLocation;
/*     */   }
/*     */ 
/*     */   
/*     */   protected int func_77032_a(EntityLiving p_77032_1_, int p_77032_2_, float p_77032_3_) {
/*  71 */     ItemStack itemStack = p_77032_1_.func_130225_q(3 - p_77032_2_);
/*  72 */     if (itemStack != null) {
/*  73 */       Item item = itemStack.func_77973_b();
/*  74 */       if (item instanceof ItemArmor) {
/*  75 */         ItemArmor itemArmor = (ItemArmor)item;
/*  76 */         func_110776_a(func_110857_a(itemArmor, p_77032_2_));
/*     */         
/*  78 */         ModelBiped modelBiped = (p_77032_2_ == 2) ? this.field_82425_h : this.field_82423_g;
/*     */         
/*  80 */         modelBiped.field_78116_c.field_78806_j = (p_77032_2_ == 0);
/*  81 */         modelBiped.field_78114_d.field_78806_j = (p_77032_2_ == 0);
/*  82 */         modelBiped.field_78115_e.field_78806_j = (p_77032_2_ == 1 || p_77032_2_ == 2);
/*  83 */         modelBiped.field_78112_f.field_78806_j = (p_77032_2_ == 1);
/*  84 */         modelBiped.field_78113_g.field_78806_j = (p_77032_2_ == 1);
/*  85 */         modelBiped.field_78123_h.field_78806_j = (p_77032_2_ == 2 || p_77032_2_ == 3);
/*  86 */         modelBiped.field_78124_i.field_78806_j = (p_77032_2_ == 2 || p_77032_2_ == 3);
/*     */         
/*  88 */         func_77042_a((ModelBase)modelBiped);
/*  89 */         modelBiped.field_78095_p = this.field_77045_g.field_78095_p;
/*  90 */         modelBiped.field_78093_q = this.field_77045_g.field_78093_q;
/*  91 */         modelBiped.field_78091_s = this.field_77045_g.field_78091_s;
/*     */         
/*  93 */         if (itemArmor.func_82812_d() == ItemArmor.ArmorMaterial.CLOTH) {
/*  94 */           int i = itemArmor.func_82814_b(itemStack);
/*  95 */           float f1 = (i >> 16 & 0xFF) / 255.0F;
/*  96 */           float f2 = (i >> 8 & 0xFF) / 255.0F;
/*  97 */           float f3 = (i & 0xFF) / 255.0F;
/*  98 */           GL11.glColor3f(f1, f2, f3);
/*     */           
/* 100 */           if (itemStack.func_77948_v()) return 31; 
/* 101 */           return 16;
/*     */         } 
/*     */         
/* 104 */         GL11.glColor3f(1.0F, 1.0F, 1.0F);
/*     */ 
/*     */         
/* 107 */         if (itemStack.func_77948_v()) return 15;
/*     */         
/* 109 */         return 1;
/*     */       } 
/*     */     } 
/* 112 */     return -1;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_82408_c(EntityLiving p_82408_1_, int p_82408_2_, float p_82408_3_) {
/* 117 */     ItemStack itemStack = p_82408_1_.func_130225_q(3 - p_82408_2_);
/* 118 */     if (itemStack != null) {
/* 119 */       Item item = itemStack.func_77973_b();
/* 120 */       if (item instanceof ItemArmor) {
/* 121 */         func_110776_a(func_110858_a((ItemArmor)item, p_82408_2_, "overlay"));
/*     */         
/* 123 */         float f = 1.0F;
/* 124 */         GL11.glColor3f(1.0F, 1.0F, 1.0F);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_76986_a(EntityLiving p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
/* 131 */     GL11.glColor3f(1.0F, 1.0F, 1.0F);
/* 132 */     ItemStack itemStack = p_76986_1_.func_70694_bm();
/*     */     
/* 134 */     func_82420_a(p_76986_1_, itemStack);
/*     */     
/* 136 */     double d = p_76986_4_ - p_76986_1_.field_70129_M;
/* 137 */     if (p_76986_1_.func_70093_af()) {
/* 138 */       d -= 0.125D;
/*     */     }
/* 140 */     super.func_76986_a(p_76986_1_, p_76986_2_, d, p_76986_6_, p_76986_8_, p_76986_9_);
/* 141 */     this.field_77071_a.field_78118_o = false;
/* 142 */     this.field_77071_a.field_78117_n = false;
/* 143 */     this.field_77071_a.field_78120_m = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected ResourceLocation func_110775_a(EntityLiving p_110775_1_) {
/* 149 */     return null;
/*     */   }
/*     */   
/*     */   protected void func_82420_a(EntityLiving p_82420_1_, ItemStack p_82420_2_) {
/* 153 */     this.field_77071_a.field_78120_m = (p_82420_2_ != null) ? 1 : 0;
/* 154 */     this.field_77071_a.field_78117_n = p_82420_1_.func_70093_af();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_77029_c(EntityLiving p_77029_1_, float p_77029_2_) {
/* 159 */     GL11.glColor3f(1.0F, 1.0F, 1.0F);
/* 160 */     super.func_77029_c((EntityLivingBase)p_77029_1_, p_77029_2_);
/* 161 */     ItemStack itemStack1 = p_77029_1_.func_70694_bm();
/* 162 */     ItemStack itemStack2 = p_77029_1_.func_130225_q(3);
/*     */     
/* 164 */     if (itemStack2 != null) {
/* 165 */       GL11.glPushMatrix();
/* 166 */       this.field_77071_a.field_78116_c.func_78794_c(0.0625F);
/*     */       
/* 168 */       Item item = itemStack2.func_77973_b();
/* 169 */       if (item instanceof net.minecraft.item.ItemBlock) {
/* 170 */         if (RenderBlocks.func_147739_a(Block.func_149634_a(item).func_149645_b())) {
/* 171 */           float f = 0.625F;
/* 172 */           GL11.glTranslatef(0.0F, -0.25F, 0.0F);
/* 173 */           GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
/* 174 */           GL11.glScalef(f, -f, -f);
/*     */         } 
/*     */         
/* 177 */         this.field_76990_c.field_78721_f.func_78443_a((EntityLivingBase)p_77029_1_, itemStack2, 0);
/* 178 */       } else if (item == Items.field_151144_bL) {
/* 179 */         float f = 1.0625F;
/* 180 */         GL11.glScalef(f, -f, -f);
/*     */         
/* 182 */         GameProfile gameProfile = null;
/* 183 */         if (itemStack2.func_77942_o()) {
/* 184 */           NBTTagCompound nBTTagCompound = itemStack2.func_77978_p();
/* 185 */           if (nBTTagCompound.func_150297_b("SkullOwner", 10)) {
/* 186 */             gameProfile = NBTUtil.func_152459_a(nBTTagCompound.func_74775_l("SkullOwner"));
/* 187 */           } else if (nBTTagCompound.func_150297_b("SkullOwner", 8) && !StringUtils.func_151246_b(nBTTagCompound.func_74779_i("SkullOwner"))) {
/* 188 */             gameProfile = new GameProfile(null, nBTTagCompound.func_74779_i("SkullOwner"));
/*     */           } 
/*     */         } 
/*     */         
/* 192 */         TileEntitySkullRenderer.field_147536_b.func_152674_a(-0.5F, 0.0F, -0.5F, 1, 180.0F, itemStack2.func_77960_j(), gameProfile);
/*     */       } 
/*     */       
/* 195 */       GL11.glPopMatrix();
/*     */     } 
/*     */     
/* 198 */     if (itemStack1 != null && itemStack1.func_77973_b() != null) {
/* 199 */       Item item = itemStack1.func_77973_b();
/* 200 */       GL11.glPushMatrix();
/*     */       
/* 202 */       if (this.field_77045_g.field_78091_s) {
/* 203 */         float f = 0.5F;
/* 204 */         GL11.glTranslatef(0.0F, 0.625F, 0.0F);
/* 205 */         GL11.glRotatef(-20.0F, -1.0F, 0.0F, 0.0F);
/* 206 */         GL11.glScalef(f, f, f);
/*     */       } 
/*     */       
/* 209 */       this.field_77071_a.field_78112_f.func_78794_c(0.0625F);
/* 210 */       GL11.glTranslatef(-0.0625F, 0.4375F, 0.0625F);
/*     */       
/* 212 */       if (item instanceof net.minecraft.item.ItemBlock && RenderBlocks.func_147739_a(Block.func_149634_a(item).func_149645_b())) {
/* 213 */         float f = 0.5F;
/* 214 */         GL11.glTranslatef(0.0F, 0.1875F, -0.3125F);
/* 215 */         f *= 0.75F;
/* 216 */         GL11.glRotatef(20.0F, 1.0F, 0.0F, 0.0F);
/* 217 */         GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
/* 218 */         GL11.glScalef(-f, -f, f);
/* 219 */       } else if (item == Items.field_151031_f) {
/* 220 */         float f = 0.625F;
/* 221 */         GL11.glTranslatef(0.0F, 0.125F, 0.3125F);
/* 222 */         GL11.glRotatef(-20.0F, 0.0F, 1.0F, 0.0F);
/* 223 */         GL11.glScalef(f, -f, f);
/* 224 */         GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
/* 225 */         GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
/* 226 */       } else if (item.func_77662_d()) {
/* 227 */         float f = 0.625F;
/* 228 */         if (item.func_77629_n_()) {
/* 229 */           GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
/* 230 */           GL11.glTranslatef(0.0F, -0.125F, 0.0F);
/*     */         } 
/* 232 */         func_82422_c();
/* 233 */         GL11.glScalef(f, -f, f);
/* 234 */         GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
/* 235 */         GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
/*     */       } else {
/* 237 */         float f = 0.375F;
/* 238 */         GL11.glTranslatef(0.25F, 0.1875F, -0.1875F);
/* 239 */         GL11.glScalef(f, f, f);
/* 240 */         GL11.glRotatef(60.0F, 0.0F, 0.0F, 1.0F);
/* 241 */         GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
/* 242 */         GL11.glRotatef(20.0F, 0.0F, 0.0F, 1.0F);
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 247 */       if (itemStack1.func_77973_b().func_77623_v()) {
/* 248 */         for (byte b = 0; b <= 1; b++) {
/* 249 */           int i = itemStack1.func_77973_b().func_82790_a(itemStack1, b);
/* 250 */           float f1 = (i >> 16 & 0xFF) / 255.0F;
/* 251 */           float f2 = (i >> 8 & 0xFF) / 255.0F;
/* 252 */           float f3 = (i & 0xFF) / 255.0F;
/*     */           
/* 254 */           GL11.glColor4f(f1, f2, f3, 1.0F);
/* 255 */           this.field_76990_c.field_78721_f.func_78443_a((EntityLivingBase)p_77029_1_, itemStack1, b);
/*     */         } 
/*     */       } else {
/* 258 */         int i = itemStack1.func_77973_b().func_82790_a(itemStack1, 0);
/* 259 */         float f1 = (i >> 16 & 0xFF) / 255.0F;
/* 260 */         float f2 = (i >> 8 & 0xFF) / 255.0F;
/* 261 */         float f3 = (i & 0xFF) / 255.0F;
/*     */         
/* 263 */         GL11.glColor4f(f1, f2, f3, 1.0F);
/* 264 */         this.field_76990_c.field_78721_f.func_78443_a((EntityLivingBase)p_77029_1_, itemStack1, 0);
/*     */       } 
/*     */       
/* 267 */       GL11.glPopMatrix();
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void func_82422_c() {
/* 272 */     GL11.glTranslatef(0.0F, 0.1875F, 0.0F);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\entity\RenderBiped.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */