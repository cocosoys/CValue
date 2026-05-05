/*     */ package JinRyuu.DragonBC.common.Render;
/*     */ 
/*     */ import JinRyuu.DragonBC.common.mod_DragonBC;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class KintounItem
/*     */   extends Item
/*     */ {
/*     */   public KintounItem() {
/*  17 */     func_77637_a(mod_DragonBC.DragonBlockC);
/*  18 */     this.field_77777_bU = 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTextureFile() {
/*  27 */     return "jinryuudragonbc:dragonitems1.png";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_94581_a(IIconRegister iconRegister) {
/*  33 */     this.field_77791_bV = iconRegister.func_94245_a("jinryuudragonbc:" + func_77658_a());
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_77648_a(ItemStack stack, EntityPlayer player, World world, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
/*  38 */     if (par7 == 0) {
/*  39 */       par5--;
/*     */     }
/*     */     
/*  42 */     if (par7 == 1) {
/*  43 */       par5++;
/*     */     }
/*     */     
/*  46 */     if (par7 == 2) {
/*  47 */       par6--;
/*     */     }
/*     */     
/*  50 */     if (par7 == 3) {
/*  51 */       par6++;
/*     */     }
/*     */     
/*  54 */     if (par7 == 4) {
/*  55 */       par4--;
/*     */     }
/*     */     
/*  58 */     if (par7 == 5) {
/*  59 */       par4++;
/*     */     }
/*     */     
/*  62 */     if (!player.func_82247_a(par4, par5, par6, par7, stack)) {
/*  63 */       return false;
/*     */     }
/*     */     
/*  66 */     if (!world.field_72995_K) {
/*     */       
/*  68 */       player.field_71071_by.func_146026_a(this);
/*  69 */       player.field_71071_by.field_70459_e = true;
/*  70 */       player.field_71071_by.field_70459_e = false;
/*  71 */       KintounEntity KintounEntity = new KintounEntity(world);
/*     */       
/*  73 */       KintounEntity.func_70012_b(par4, (par5 + 1), par6, player.field_70177_z, 0.0F);
/*  74 */       world.func_72838_d(KintounEntity);
/*     */     } 
/*     */     
/*  77 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_77659_a(ItemStack stack, World world, EntityPlayer player) {
/*  83 */     if (!world.field_72995_K) {
/*  84 */       Vec3 vec = player.func_70040_Z();
/*  85 */       KintounEntity KintounEntity = new KintounEntity(world);
/*  86 */       KintounEntity.func_70012_b(player.field_70165_t + vec.field_72450_a * 1.5D, player.field_70163_u + 1.0D + vec.field_72448_b * 1.5D, player.field_70161_v + vec.field_72449_c * 1.5D, player.field_70177_z, 0.0F);
/*  87 */       world.func_72838_d(KintounEntity);
/*     */       
/*  89 */       ItemStack[] inv = player.field_71071_by.field_70462_a;
/*  90 */       int id = 0;
/*  91 */       for (ItemStack invStack : inv) {
/*  92 */         if (invStack != null && invStack.equals(stack)) {
/*     */           
/*  94 */           player.field_71071_by.field_70462_a[id] = null;
/*     */           break;
/*     */         } 
/*  97 */         id++;
/*     */       } 
/*     */     } 
/* 100 */     return stack;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Render\KintounItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */