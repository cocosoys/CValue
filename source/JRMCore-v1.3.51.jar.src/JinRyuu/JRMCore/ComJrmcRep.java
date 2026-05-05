/*     */ package JinRyuu.JRMCore;
/*     */ 
/*     */ import JinRyuu.JRMCore.i.ExtendedPlayer;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import net.minecraft.command.CommandBase;
/*     */ import net.minecraft.command.ICommand;
/*     */ import net.minecraft.command.ICommandSender;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ 
/*     */ public class ComJrmcRep extends CommandBase {
/*     */   public String func_71517_b() {
/*  17 */     return "jrmcrepair";
/*     */   }
/*  19 */   public static HashMap<String, Object[]> SList = (HashMap)new HashMap<String, Object>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_82362_a() {
/*  26 */     return 1;
/*     */   }
/*     */ 
/*     */   
/*     */   public String func_71518_a(ICommandSender par1ICommandSender) {
/*  31 */     return "Usage: '/jrmcrepair [playerName]'";
/*     */   }
/*     */   
/*     */   public boolean func_71519_b(ICommandSender par1ICommandSender) {
/*  35 */     return true;
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
/*     */   public void func_71515_b(ICommandSender par1ICommandSender, String[] par2ArrayOfStr) {
/*     */     EntityPlayerMP entityplayermp;
/*  49 */     String entitycommansender = "Console";
/*     */     try {
/*  51 */       EntityPlayerMP commansender = func_71521_c(par1ICommandSender);
/*  52 */       entitycommansender = commansender.func_70005_c_();
/*  53 */     } catch (Exception exception) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  59 */     if (par2ArrayOfStr.length > 0) {
/*  60 */       entityplayermp = func_82359_c(par1ICommandSender, par2ArrayOfStr[2]);
/*     */     } else {
/*  62 */       entityplayermp = func_71521_c(par1ICommandSender);
/*     */     } 
/*     */     
/*  65 */     NBTTagCompound nbt = JRMCoreH.nbt((Entity)entityplayermp, "pres");
/*     */     
/*  67 */     if (entityplayermp != null) {
/*  68 */       int i; for (i = 0; i < entityplayermp.field_71071_by.field_70460_b.length; i++) {
/*  69 */         if (entityplayermp.field_71071_by.field_70460_b[i] != null)
/*  70 */           entityplayermp.field_71071_by.field_70460_b[i].func_77964_b(0); 
/*     */       } 
/*  72 */       for (i = 0; i < 11; i++) {
/*  73 */         if ((ExtendedPlayer.get((EntityPlayer)entityplayermp)).inventory.func_70301_a(i) != null) {
/*  74 */           (ExtendedPlayer.get((EntityPlayer)entityplayermp)).inventory.func_70301_a(i).func_77964_b(0);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  79 */     boolean n = entitycommansender.equals("Console") ? JRMCoreConfig.ComHealNAC : (entitycommansender.equals(entityplayermp.func_70005_c_()) ? JRMCoreConfig.ComHealNAS : JRMCoreConfig.ComHealNAO);
/*  80 */     if (n) {
/*  81 */       notifyAdmins(par1ICommandSender, "%s -> all equiped items were fixed!", new Object[] { entityplayermp.func_70005_c_() });
/*     */     }
/*     */   }
/*     */   
/*     */   private void notifyAdmins(ICommandSender par1iCommandSender, String string, Object[] objects) {
/*  86 */     func_152373_a(par1iCommandSender, (ICommand)this, string, objects);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List func_71516_a(ICommandSender par1ICommandSender, String[] par2ArrayOfStr) {
/*  95 */     return (par2ArrayOfStr.length == 2) ? func_71530_a(par2ArrayOfStr, getListOfPlayers()) : null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected String[] getListOfPlayers() {
/* 100 */     return MinecraftServer.func_71276_C().func_71213_z();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isUsernameIndex(int par1) {
/* 108 */     return (par1 == 0);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\ComJrmcRep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */