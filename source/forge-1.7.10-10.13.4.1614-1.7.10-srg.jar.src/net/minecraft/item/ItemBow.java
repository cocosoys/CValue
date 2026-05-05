/*    */ package net.minecraft.item;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.enchantment.Enchantment;
/*    */ import net.minecraft.enchantment.EnchantmentHelper;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.entity.projectile.EntityArrow;
/*    */ import net.minecraft.init.Items;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class ItemBow extends Item {
/* 11 */   public static final String[] field_94601_a = new String[] { "pulling_0", "pulling_1", "pulling_2" };
/*    */   @SideOnly(Side.CLIENT)
/*    */   private IIcon[] field_94600_b;
/*    */   private static final String __OBFID = "CL_00001777";
/*    */   
/*    */   public ItemBow() {
/* 17 */     this.field_77777_bU = 1;
/* 18 */     func_77656_e(384);
/* 19 */     func_77637_a(CreativeTabs.field_78037_j);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_77615_a(ItemStack p_77615_1_, World p_77615_2_, EntityPlayer p_77615_3_, int p_77615_4_) {
/* 25 */     boolean bool = (p_77615_3_.field_71075_bZ.field_75098_d || EnchantmentHelper.func_77506_a(Enchantment.field_77342_w.field_77352_x, p_77615_1_) > 0) ? true : false;
/*    */     
/* 27 */     if (bool || p_77615_3_.field_71071_by.func_146028_b(Items.field_151032_g)) {
/* 28 */       int i = func_77626_a(p_77615_1_) - p_77615_4_;
/* 29 */       float f = i / 20.0F;
/* 30 */       f = (f * f + f * 2.0F) / 3.0F;
/* 31 */       if (f < 0.1D)
/* 32 */         return;  if (f > 1.0F) f = 1.0F;
/*    */       
/* 34 */       EntityArrow entityArrow = new EntityArrow(p_77615_2_, (EntityLivingBase)p_77615_3_, f * 2.0F);
/* 35 */       if (f == 1.0F) entityArrow.func_70243_d(true); 
/* 36 */       int j = EnchantmentHelper.func_77506_a(Enchantment.field_77345_t.field_77352_x, p_77615_1_);
/* 37 */       if (j > 0) {
/* 38 */         entityArrow.func_70239_b(entityArrow.func_70242_d() + j * 0.5D + 0.5D);
/*    */       }
/* 40 */       int k = EnchantmentHelper.func_77506_a(Enchantment.field_77344_u.field_77352_x, p_77615_1_);
/* 41 */       if (k > 0) {
/* 42 */         entityArrow.func_70240_a(k);
/*    */       }
/* 44 */       if (EnchantmentHelper.func_77506_a(Enchantment.field_77343_v.field_77352_x, p_77615_1_) > 0) {
/* 45 */         entityArrow.func_70015_d(100);
/*    */       }
/* 47 */       p_77615_1_.func_77972_a(1, (EntityLivingBase)p_77615_3_);
/*    */       
/* 49 */       p_77615_2_.func_72956_a((Entity)p_77615_3_, "random.bow", 1.0F, 1.0F / (field_77697_d.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
/* 50 */       if (bool) {
/* 51 */         entityArrow.field_70251_a = 2;
/*    */       } else {
/* 53 */         p_77615_3_.field_71071_by.func_146026_a(Items.field_151032_g);
/*    */       } 
/* 55 */       if (!p_77615_2_.field_72995_K) p_77615_2_.func_72838_d((Entity)entityArrow);
/*    */     
/*    */     } 
/*    */   }
/*    */   
/*    */   public ItemStack func_77654_b(ItemStack p_77654_1_, World p_77654_2_, EntityPlayer p_77654_3_) {
/* 61 */     return p_77654_1_;
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_77626_a(ItemStack p_77626_1_) {
/* 66 */     return 72000;
/*    */   }
/*    */ 
/*    */   
/*    */   public EnumAction func_77661_b(ItemStack p_77661_1_) {
/* 71 */     return EnumAction.bow;
/*    */   }
/*    */ 
/*    */   
/*    */   public ItemStack func_77659_a(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_) {
/* 76 */     if (p_77659_3_.field_71075_bZ.field_75098_d || p_77659_3_.field_71071_by.func_146028_b(Items.field_151032_g)) {
/* 77 */       p_77659_3_.func_71008_a(p_77659_1_, func_77626_a(p_77659_1_));
/*    */     }
/* 79 */     return p_77659_1_;
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_77619_b() {
/* 84 */     return 1;
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_94581_a(IIconRegister p_94581_1_) {
/* 89 */     this.field_77791_bV = p_94581_1_.func_94245_a(func_111208_A() + "_standby");
/*    */     
/* 91 */     this.field_94600_b = new IIcon[field_94601_a.length];
/*    */     
/* 93 */     for (byte b = 0; b < this.field_94600_b.length; b++)
/* 94 */       this.field_94600_b[b] = p_94581_1_.func_94245_a(func_111208_A() + "_" + field_94601_a[b]); 
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public IIcon func_94599_c(int p_94599_1_) {
/* 99 */     return this.field_94600_b[p_94599_1_];
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\item\ItemBow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */