/*    */ package net.minecraft.client.renderer;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import java.util.Collection;
/*    */ import net.minecraft.client.resources.I18n;
/*    */ import net.minecraft.inventory.Container;
/*    */ import net.minecraft.potion.Potion;
/*    */ import net.minecraft.potion.PotionEffect;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public abstract class InventoryEffectRenderer extends GuiContainer {
/*    */   private boolean field_147045_u;
/*    */   
/*    */   public InventoryEffectRenderer(Container p_i1089_1_) {
/* 15 */     super(p_i1089_1_);
/*    */   }
/*    */   private static final String __OBFID = "CL_00000755";
/*    */   
/*    */   public void func_73866_w_() {
/* 20 */     super.func_73866_w_();
/*    */     
/* 22 */     if (!this.field_146297_k.field_71439_g.func_70651_bq().isEmpty()) {
/* 23 */       this.field_147003_i = 160 + (this.field_146294_l - this.field_146999_f - 200) / 2;
/* 24 */       this.field_147045_u = true;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
/* 30 */     super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
/* 31 */     if (this.field_147045_u) {
/* 32 */       func_147044_g();
/*    */     }
/*    */   }
/*    */   
/*    */   private void func_147044_g() {
/* 37 */     int i = this.field_147003_i - 124;
/* 38 */     int j = this.field_147009_r;
/*    */     
/* 40 */     char c = '¦';
/*    */     
/* 42 */     Collection collection = this.field_146297_k.field_71439_g.func_70651_bq();
/*    */     
/* 44 */     if (collection.isEmpty()) {
/*    */       return;
/*    */     }
/*    */     
/* 48 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 49 */     GL11.glDisable(2896);
/*    */     
/* 51 */     int k = 33;
/* 52 */     if (collection.size() > 5) {
/* 53 */       k = 132 / (collection.size() - 1);
/*    */     }
/*    */     
/* 56 */     for (PotionEffect potionEffect : this.field_146297_k.field_71439_g.func_70651_bq()) {
/* 57 */       Potion potion = Potion.field_76425_a[potionEffect.func_76456_a()];
/*    */       
/* 59 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 60 */       this.field_146297_k.func_110434_K().func_110577_a(field_147001_a);
/*    */       
/* 62 */       func_73729_b(i, j, 0, 166, 140, 32);
/*    */       
/* 64 */       if (potion.func_76400_d()) {
/* 65 */         int m = potion.func_76392_e();
/* 66 */         func_73729_b(i + 6, j + 7, 0 + m % 8 * 18, 198 + m / 8 * 18, 18, 18);
/*    */       } 
/*    */       
/* 69 */       String str1 = I18n.func_135052_a(potion.func_76393_a(), new Object[0]);
/*    */       
/* 71 */       if (potionEffect.func_76458_c() == 1) {
/* 72 */         str1 = str1 + " " + I18n.func_135052_a("enchantment.level.2", new Object[0]);
/* 73 */       } else if (potionEffect.func_76458_c() == 2) {
/* 74 */         str1 = str1 + " " + I18n.func_135052_a("enchantment.level.3", new Object[0]);
/* 75 */       } else if (potionEffect.func_76458_c() == 3) {
/* 76 */         str1 = str1 + " " + I18n.func_135052_a("enchantment.level.4", new Object[0]);
/*    */       } 
/*    */       
/* 79 */       this.field_146289_q.func_78261_a(str1, i + 10 + 18, j + 6, 16777215);
/*    */       
/* 81 */       String str2 = Potion.func_76389_a(potionEffect);
/* 82 */       this.field_146289_q.func_78261_a(str2, i + 10 + 18, j + 6 + 10, 8355711);
/*    */       
/* 84 */       j += k;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\InventoryEffectRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */