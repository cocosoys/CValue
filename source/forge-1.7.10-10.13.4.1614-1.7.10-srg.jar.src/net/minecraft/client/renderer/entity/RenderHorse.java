/*    */ package net.minecraft.client.renderer.entity;
/*    */ import com.google.common.collect.Maps;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.Map;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.renderer.texture.ITextureObject;
/*    */ import net.minecraft.client.renderer.texture.LayeredTexture;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.passive.EntityHorse;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderHorse extends RenderLiving {
/* 16 */   private static final Map field_110852_a = Maps.newHashMap();
/* 17 */   private static final ResourceLocation field_110850_f = new ResourceLocation("textures/entity/horse/horse_white.png");
/* 18 */   private static final ResourceLocation field_110851_g = new ResourceLocation("textures/entity/horse/mule.png");
/* 19 */   private static final ResourceLocation field_110855_h = new ResourceLocation("textures/entity/horse/donkey.png");
/* 20 */   private static final ResourceLocation field_110854_k = new ResourceLocation("textures/entity/horse/horse_zombie.png");
/* 21 */   private static final ResourceLocation field_110853_l = new ResourceLocation("textures/entity/horse/horse_skeleton.png"); private static final String __OBFID = "CL_00001000";
/*    */   
/*    */   public RenderHorse(ModelBase p_i1256_1_, float p_i1256_2_) {
/* 24 */     super(p_i1256_1_, p_i1256_2_);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void func_77041_b(EntityHorse p_77041_1_, float p_77041_2_) {
/* 33 */     float f = 1.0F;
/*    */     
/* 35 */     int i = p_77041_1_.func_110265_bP();
/* 36 */     if (i == 1) {
/* 37 */       f *= 0.87F;
/* 38 */     } else if (i == 2) {
/* 39 */       f *= 0.92F;
/*    */     } 
/* 41 */     GL11.glScalef(f, f, f);
/* 42 */     super.func_77041_b((EntityLivingBase)p_77041_1_, p_77041_2_);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_77036_a(EntityHorse p_77036_1_, float p_77036_2_, float p_77036_3_, float p_77036_4_, float p_77036_5_, float p_77036_6_, float p_77036_7_) {
/* 47 */     if (p_77036_1_.func_82150_aj()) {
/* 48 */       this.field_77045_g.func_78087_a(p_77036_2_, p_77036_3_, p_77036_4_, p_77036_5_, p_77036_6_, p_77036_7_, (Entity)p_77036_1_);
/*    */     } else {
/* 50 */       func_110777_b((Entity)p_77036_1_);
/* 51 */       this.field_77045_g.func_78088_a((Entity)p_77036_1_, p_77036_2_, p_77036_3_, p_77036_4_, p_77036_5_, p_77036_6_, p_77036_7_);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   protected ResourceLocation func_110775_a(EntityHorse p_110775_1_) {
/* 57 */     if (!p_110775_1_.func_110239_cn()) {
/* 58 */       switch (p_110775_1_.func_110265_bP())
/*    */       
/*    */       { default:
/* 61 */           return field_110850_f;
/*    */         case 2:
/* 63 */           return field_110851_g;
/*    */         case 1:
/* 65 */           return field_110855_h;
/*    */         case 3:
/* 67 */           return field_110854_k;
/*    */         case 4:
/* 69 */           break; }  return field_110853_l;
/*    */     } 
/*    */ 
/*    */     
/* 73 */     return func_110848_b(p_110775_1_);
/*    */   }
/*    */   
/*    */   private ResourceLocation func_110848_b(EntityHorse p_110848_1_) {
/* 77 */     String str = p_110848_1_.func_110264_co();
/*    */     
/* 79 */     ResourceLocation resourceLocation = (ResourceLocation)field_110852_a.get(str);
/* 80 */     if (resourceLocation == null) {
/* 81 */       resourceLocation = new ResourceLocation(str);
/* 82 */       Minecraft.func_71410_x().func_110434_K().func_110579_a(resourceLocation, (ITextureObject)new LayeredTexture(p_110848_1_.func_110212_cp()));
/*    */       
/* 84 */       field_110852_a.put(str, resourceLocation);
/*    */     } 
/*    */     
/* 87 */     return resourceLocation;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\entity\RenderHorse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */