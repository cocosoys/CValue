/*     */ package JinRyuu.DragonBC.common.Gui;
/*     */ 
/*     */ import JinRyuu.JRMCore.JRMCoreConfig;
/*     */ import JinRyuu.JRMCore.JRMCoreH;
/*     */ import JinRyuu.JRMCore.entity.EntityEnergyAtt;
/*     */ import java.util.List;
/*     */ import net.minecraft.command.CommandBase;
/*     */ import net.minecraft.command.ICommandSender;
/*     */ import net.minecraft.command.WrongUsageException;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ComDbcSpawnKi
/*     */   extends CommandBase
/*     */ {
/*  23 */   final String line = "Use '/dbcspawnki (Type) (Speed) (Damage) (Effect) (Color) (Density) (Sound: Move) (Charge Percentage) [User Position X] [User Position Y] [User Position Z]' to spawn a Ki Attack.";
/*     */   
/*     */   public String func_71517_b() {
/*  26 */     return "dbcspawnki"; } public String func_71518_a(ICommandSender icommandsender) {
/*  27 */     return "Use '/dbcspawnki (Type) (Speed) (Damage) (Effect) (Color) (Density) (Sound: Move) (Charge Percentage) [User Position X] [User Position Y] [User Position Z]' to spawn a Ki Attack.";
/*     */   }
/*     */   
/*     */   public int func_82362_a() {
/*  31 */     return 2; } public boolean func_71519_b(ICommandSender par1ICommandSender) {
/*  32 */     return true;
/*     */   }
/*     */   private NBTTagCompound nbt(EntityPlayer p, String s) {
/*  35 */     return JRMCoreH.nbt((Entity)p, s);
/*     */   } public void func_71515_b(ICommandSender par1ICommandSender, String[] par2ArrayOfStr) {
/*     */     EntityPlayerMP entityPlayerMP;
/*  38 */     if (par2ArrayOfStr.length < 10) {
/*  39 */       throw new WrongUsageException("Use '/dbcspawnki (Type) (Speed) (Damage) (Effect) (Color) (Density) (Sound: Move) (Charge Percentage) [User Position X] [User Position Y] [User Position Z]' to spawn a Ki Attack.", new Object[0]);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  48 */     boolean spawn = true;
/*  49 */     boolean found = false;
/*     */     
/*  51 */     if (par2ArrayOfStr.length == 11) {
/*     */ 
/*     */ 
/*     */       
/*  55 */       double minx = Double.parseDouble(par2ArrayOfStr[8]) - 1.0D, miny = Double.parseDouble(par2ArrayOfStr[9]) - 1.0D, minz = Double.parseDouble(par2ArrayOfStr[10]) - 1.0D;
/*  56 */       double maxx = minx + 2.0D, maxy = miny + 2.0D, maxz = minz + 2.0D;
/*  57 */       List<Entity> var6 = par1ICommandSender.func_130014_f_().func_72839_b(null, AxisAlignedBB.func_72330_a(minx, miny, minz, maxx, maxy, maxz));
/*     */       
/*  59 */       Entity var10 = null;
/*     */       
/*  61 */       for (int var9 = 0; var9 < var6.size(); var9++) {
/*     */ 
/*     */         
/*  64 */         var10 = var6.get(var9);
/*  65 */         if (var10 instanceof EntityLivingBase && var10.func_70067_L()) {
/*     */           
/*  67 */           found = true;
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/*     */       
/*  73 */       if (found) {
/*  74 */         EntityLivingBase entityplayermp = (EntityLivingBase)var10;
/*     */       } else {
/*  76 */         EntityLivingBase entityplayermp = null;
/*     */       }
/*     */     
/*  79 */     } else if (par2ArrayOfStr.length == 12) {
/*  80 */       entityPlayerMP = func_82359_c(par1ICommandSender, par2ArrayOfStr[11]);
/*  81 */       spawn = true;
/*  82 */       found = true;
/*     */     } else {
/*     */       return;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  89 */     EntityEnergyAtt mr = null;
/*  90 */     boolean spawned = false;
/*  91 */     if (spawn && found && entityPlayerMP != null) {
/*  92 */       byte type = Byte.parseByte(par2ArrayOfStr[0]);
/*  93 */       if (JRMCoreConfig.dat5695[type]) {
/*  94 */         if (type < 0) type = 0;  if (type > 8) type = 8; 
/*  95 */         byte speed = Byte.parseByte(par2ArrayOfStr[1]);
/*  96 */         if (speed < 0) speed = 0; 
/*  97 */         int dam1 = Integer.parseInt(par2ArrayOfStr[2]);
/*  98 */         if (dam1 < 0) dam1 = 0; 
/*  99 */         byte effect = Byte.parseByte(par2ArrayOfStr[3]);
/* 100 */         if (effect < 0) effect = 0;  if (effect > 1) effect = 1; 
/* 101 */         byte color = Byte.parseByte(par2ArrayOfStr[4]);
/* 102 */         if (color < 0) color = 0;  if (color > JRMCoreH.techCol.length - 1) color = (byte)(JRMCoreH.techCol.length - 1); 
/* 103 */         byte density = Byte.parseByte(par2ArrayOfStr[5]);
/* 104 */         if (density < 0) density = 0; 
/* 105 */         byte sndMv = Byte.parseByte(par2ArrayOfStr[6]);
/* 106 */         if (sndMv < 0) sndMv = 0;  if (sndMv > 1) sndMv = 1; 
/* 107 */         byte chrg = Byte.parseByte(par2ArrayOfStr[7]);
/* 108 */         if (chrg < 0) chrg = 0;  if (chrg > 100) chrg = 100;
/*     */         
/* 110 */         byte[] sts = JRMCoreH.techDBCstatsDefault;
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
/* 122 */         ((EntityLivingBase)entityPlayerMP).field_70170_p.func_72956_a((Entity)entityPlayerMP, "jinryuudragonbc:DBC2.basicbeam_fire", 0.5F, 1.0F);
/* 123 */         mr = new EntityEnergyAtt((EntityLivingBase)entityPlayerMP, type, speed, 50, effect, color, density, (byte)0, (byte)0, sndMv, chrg, dam1, 0, sts, (byte)0);
/*     */ 
/*     */         
/* 126 */         ((EntityLivingBase)entityPlayerMP).field_70170_p.func_72838_d((Entity)mr);
/* 127 */         spawned = true;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Gui\ComDbcSpawnKi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */