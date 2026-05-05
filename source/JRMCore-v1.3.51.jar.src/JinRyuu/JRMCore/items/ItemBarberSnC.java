/*     */ package JinRyuu.JRMCore.items;
/*     */ 
/*     */ import JinRyuu.JRMCore.JRMCoreH;
/*     */ import JinRyuu.JRMCore.JRMCoreHJFC;
/*     */ import JinRyuu.JRMCore.mod_JRMCore;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.enchantment.Enchantment;
/*     */ import net.minecraft.enchantment.EnchantmentHelper;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.IShearable;
/*     */ 
/*     */ 
/*     */ public class ItemBarberSnC
/*     */   extends Item
/*     */ {
/*     */   public static Entity barberTarget;
/*     */   
/*     */   public ItemBarberSnC(int par2, float par3, boolean par4) {
/*  31 */     func_77625_d(1);
/*  32 */     func_77656_e(10);
/*  33 */     func_77637_a(mod_JRMCore.JRMCore);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_77624_a(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List<String> par3List, boolean par4) {
/*  38 */     par3List.add(JRMCoreH.trl("jrmc", "BarberSnC.line1"));
/*     */   }
/*     */   
/*     */   public String getTextureFile() {
/*  42 */     return JRMCoreH.tjjrmc + ":";
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_94581_a(IIconRegister iconRegister) {
/*  47 */     this.field_77791_bV = iconRegister.func_94245_a(JRMCoreH.tjjrmc + ":" + func_77658_a().substring(5));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_77659_a(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
/*  55 */     if (par3EntityPlayer.field_71075_bZ.field_75098_d || par3EntityPlayer.field_71071_by.func_146028_b(this));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  60 */     if (par2World.field_72995_K) {
/*     */       
/*  62 */       barberTarget = null;
/*  63 */       par3EntityPlayer.openGui(mod_JRMCore.instance, 8, par3EntityPlayer.field_70170_p, (int)par3EntityPlayer.field_70165_t, (int)par3EntityPlayer.field_70163_u, (int)par3EntityPlayer.field_70161_v);
/*     */     } 
/*     */     
/*  66 */     if (!par3EntityPlayer.field_71075_bZ.field_75098_d) {
/*  67 */       par1ItemStack.func_77972_a(1, (EntityLivingBase)par3EntityPlayer);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  76 */     return par1ItemStack;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_111207_a(ItemStack itemstack, EntityPlayer player, EntityLivingBase entity) {
/*  87 */     if (entity.field_70170_p.field_72995_K) {
/*     */       
/*  89 */       if (JRMCoreH.JFC() && JRMCoreHJFC.isChildNPC((Entity)entity)) {
/*  90 */         itemstack.func_77972_a(1, entity);
/*  91 */         barberTarget = (Entity)entity;
/*  92 */         player.openGui(mod_JRMCore.instance, 8, player.field_70170_p, (int)player.field_70165_t, (int)player.field_70163_u, (int)player.field_70161_v);
/*     */       } 
/*  94 */       return true;
/*     */     } 
/*  96 */     if (entity instanceof IShearable) {
/*     */       
/*  98 */       IShearable target = (IShearable)entity;
/*  99 */       if (target.isShearable(itemstack, (IBlockAccess)entity.field_70170_p, (int)entity.field_70165_t, (int)entity.field_70163_u, (int)entity.field_70161_v)) {
/*     */         
/* 101 */         ArrayList<ItemStack> drops = target.onSheared(itemstack, (IBlockAccess)entity.field_70170_p, (int)entity.field_70165_t, (int)entity.field_70163_u, (int)entity.field_70161_v, 
/* 102 */             EnchantmentHelper.func_77506_a(Enchantment.field_77346_s.field_77352_x, itemstack));
/*     */         
/* 104 */         Random rand = new Random();
/* 105 */         for (ItemStack stack : drops) {
/*     */           
/* 107 */           EntityItem ent = entity.func_70099_a(stack, 1.0F);
/* 108 */           ent.field_70181_x += (rand.nextFloat() * 0.05F);
/* 109 */           ent.field_70159_w += ((rand.nextFloat() - rand.nextFloat()) * 0.1F);
/* 110 */           ent.field_70179_y += ((rand.nextFloat() - rand.nextFloat()) * 0.1F);
/*     */         } 
/* 112 */         itemstack.func_77972_a(1, entity);
/*     */       } 
/* 114 */       return true;
/*     */     } 
/* 116 */     return false;
/*     */   }
/*     */   private boolean getChild() {
/* 119 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\items\ItemBarberSnC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */