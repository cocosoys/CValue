/*     */ package JinRyuu.DragonBC.common.Items;
/*     */ 
/*     */ import JinRyuu.DragonBC.common.mod_DragonBC;
/*     */ import cpw.mods.fml.common.eventhandler.Event;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.item.EnumAction;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.MinecraftForge;
/*     */ import net.minecraftforge.event.entity.player.ArrowLooseEvent;
/*     */ import net.minecraftforge.event.entity.player.ArrowNockEvent;
/*     */ 
/*     */ public class ItemNamekChip extends Item {
/*     */   private Minecraft var2;
/*     */   
/*     */   public ItemNamekChip() {
/*  24 */     this.field_77777_bU = 2;
/*  25 */     func_77656_e(1);
/*  26 */     func_77637_a(mod_DragonBC.DragonBlockC);
/*     */   } int slot;
/*     */   public String getTextureFile() {
/*  29 */     return "jinryuudragonbc:";
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_94581_a(IIconRegister par1IconRegister) {
/*  34 */     this.field_77791_bV = par1IconRegister.func_94245_a("jinryuudragonbc:" + func_77658_a());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_77615_a(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer, int par4) {
/*  45 */     int var6 = func_77626_a(par1ItemStack) - par4;
/*     */     
/*  47 */     ArrowLooseEvent event = new ArrowLooseEvent(par3EntityPlayer, par1ItemStack, var6);
/*  48 */     MinecraftForge.EVENT_BUS.post((Event)event);
/*  49 */     if (event.isCanceled()) {
/*     */       return;
/*     */     }
/*     */     
/*  53 */     var6 = event.charge;
/*     */     
/*  55 */     if (par3EntityPlayer.func_70055_a(Material.field_151567_E) == true) {
/*     */ 
/*     */       
/*  58 */       par2World.func_147443_d((int)par3EntityPlayer.field_70165_t, (int)par3EntityPlayer.field_70163_u, (int)par3EntityPlayer.field_70161_v, 1, 1);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  68 */       if (par3EntityPlayer instanceof EntityPlayerMP) {
/*     */         
/*  70 */         EntityPlayerMP playerMP = (EntityPlayerMP)par3EntityPlayer;
/*     */ 
/*     */ 
/*     */         
/*  74 */         if (playerMP.field_71093_bK == 0);
/*     */       } 
/*     */     } 
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack onFoodEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
/* 111 */     return par1ItemStack;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_77626_a(ItemStack par1ItemStack) {
/* 119 */     return 72000;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumAction func_77661_b(ItemStack par1ItemStack) {
/* 127 */     return EnumAction.bow;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_77659_a(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
/* 135 */     ArrowNockEvent event = new ArrowNockEvent(par3EntityPlayer, par1ItemStack);
/* 136 */     MinecraftForge.EVENT_BUS.post((Event)event);
/* 137 */     if (event.isCanceled())
/*     */     {
/* 139 */       return event.result;
/*     */     }
/* 141 */     if (par3EntityPlayer.field_71075_bZ.field_75098_d)
/*     */     {
/* 143 */       par3EntityPlayer.func_71008_a(par1ItemStack, func_77626_a(par1ItemStack));
/*     */     }
/*     */     
/* 146 */     return par1ItemStack;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_77619_b() {
/* 154 */     return 1;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Items\ItemNamekChip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */