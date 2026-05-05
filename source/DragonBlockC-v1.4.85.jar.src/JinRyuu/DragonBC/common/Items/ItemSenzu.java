/*     */ package JinRyuu.DragonBC.common.Items;
/*     */ 
/*     */ import JinRyuu.DragonBC.common.DBCConfig;
/*     */ import JinRyuu.DragonBC.common.mod_DragonBC;
/*     */ import JinRyuu.JRMCore.JRMCoreConfig;
/*     */ import JinRyuu.JRMCore.JRMCoreH;
/*     */ import JinRyuu.JRMCore.server.JGPlayerMP;
/*     */ import cpw.mods.fml.common.eventhandler.Event;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.EnumAction;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.ChatComponentText;
/*     */ import net.minecraft.util.ChatStyle;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ import net.minecraft.util.StatCollector;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.MinecraftForge;
/*     */ import net.minecraftforge.event.entity.player.ArrowLooseEvent;
/*     */ import net.minecraftforge.event.entity.player.ArrowNockEvent;
/*     */ 
/*     */ public class ItemSenzu
/*     */   extends Item
/*     */ {
/*     */   private boolean alwaysEdible;
/*     */   
/*     */   public ItemSenzu(int par2, float par3, boolean par4) {
/*  33 */     func_77627_a(true);
/*  34 */     this.field_77777_bU = 5;
/*  35 */     func_77656_e(1);
/*  36 */     func_77637_a(mod_DragonBC.DragonBlockC);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_77624_a(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List<String> par3List, boolean par4) {
/*  41 */     par3List.add(StatCollector.func_74838_a("dbc.itemSenzu.line1"));
/*     */   }
/*     */   
/*     */   public String getTextureFile() {
/*  45 */     return "jinryuudragonbc:";
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_94581_a(IIconRegister iconRegister) {
/*  50 */     this.field_77791_bV = iconRegister.func_94245_a("jinryuudragonbc:" + func_77658_a());
/*     */   }
/*     */   
/*     */   public void func_77615_a(ItemStack itemStack, World world, EntityPlayer entityPlayer, int par4) {
/*  54 */     int j = func_77626_a(itemStack) - par4;
/*     */     
/*  56 */     ArrowLooseEvent event = new ArrowLooseEvent(entityPlayer, itemStack, j);
/*  57 */     MinecraftForge.EVENT_BUS.post((Event)event);
/*     */     
/*  59 */     if (event.isCanceled()) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/*  64 */     j = event.charge;
/*     */     
/*  66 */     if (!world.field_72995_K) {
/*     */       
/*  68 */       EntityPlayer player = entityPlayer;
/*     */       
/*  70 */       int currentTime = (int)(System.currentTimeMillis() / 1000L);
/*  71 */       int senzuCool = JRMCoreH.getInt(player, "jrmcSenzuCC");
/*     */       
/*  73 */       if (senzuCool > currentTime) {
/*     */         
/*  75 */         player.func_145747_a((new ChatComponentText("Senzu can be used again after " + (senzuCool - currentTime) + " seconds!")).func_150255_a((new ChatStyle()).func_150238_a(EnumChatFormatting.GOLD)));
/*     */         
/*     */         return;
/*     */       } 
/*  79 */       JGPlayerMP jgPlayer = new JGPlayerMP(player);
/*  80 */       jgPlayer.connectBaseNBT();
/*     */       
/*  82 */       if (!JRMCoreConfig.CanUseSenzuWhileKOd && jgPlayer.getNBT().func_74762_e("jrmcHar4va") > 0) {
/*     */         return;
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*  88 */       int[] playerAttributes = jgPlayer.getAttributes();
/*  89 */       byte powerType = jgPlayer.getPowerType();
/*  90 */       byte race = jgPlayer.getRace();
/*  91 */       byte classID = jgPlayer.getClassID();
/*  92 */       int maxBody = jgPlayer.getHealthMax(race, classID, powerType, playerAttributes);
/*  93 */       int maxEnergy = jgPlayer.getEnergyMax(race, classID, powerType, playerAttributes, JRMCoreH.SklLvl_KiBs(player, powerType));
/*  94 */       int maxStam = jgPlayer.getStaminaMax(race, classID, powerType, playerAttributes);
/*     */       
/*  96 */       JRMCoreH.setInt(maxBody, player, "jrmcBdy");
/*  97 */       JRMCoreH.setInt(maxEnergy, player, "jrmcEnrgy");
/*  98 */       JRMCoreH.setInt(maxStam, player, "jrmcStamina");
/*  99 */       JRMCoreH.setInt(currentTime + DBCConfig.senzuCool, player, "jrmcSenzuCC");
/*     */       
/* 101 */       entityPlayer.func_70606_j(entityPlayer.func_110138_aP());
/* 102 */       world.func_72956_a((Entity)entityPlayer, "jinryuudragonbc:DBC2.sensu", 0.5F, world.field_73012_v.nextFloat() * 0.1F + 0.9F);
/* 103 */       entityPlayer.func_71024_bL().func_75122_a(20, 0.9F);
/*     */       
/* 105 */       if (!entityPlayer.field_71075_bZ.field_75098_d)
/*     */       {
/* 107 */         entityPlayer.field_71071_by.func_146026_a(this);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack func_77654_b(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
/* 114 */     return par1ItemStack;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_77626_a(ItemStack par1ItemStack) {
/* 119 */     return 72000;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack func_77659_a(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
/* 124 */     ArrowNockEvent event = new ArrowNockEvent(par3EntityPlayer, par1ItemStack);
/* 125 */     MinecraftForge.EVENT_BUS.post((Event)event);
/* 126 */     if (event.isCanceled())
/*     */     {
/* 128 */       return event.result;
/*     */     }
/*     */     
/* 131 */     if (par3EntityPlayer.field_71075_bZ.field_75098_d || par3EntityPlayer.field_71071_by.func_146028_b(this))
/*     */     {
/* 133 */       par3EntityPlayer.func_71008_a(par1ItemStack, func_77626_a(par1ItemStack));
/*     */     }
/*     */     
/* 136 */     return par1ItemStack;
/*     */   }
/*     */ 
/*     */   
/*     */   public EnumAction func_77661_b(ItemStack par1ItemStack) {
/* 141 */     return EnumAction.block;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Items\ItemSenzu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */