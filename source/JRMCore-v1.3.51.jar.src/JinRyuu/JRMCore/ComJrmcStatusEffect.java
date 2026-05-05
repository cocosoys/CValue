/*     */ package JinRyuu.JRMCore;
/*     */ import java.util.List;
/*     */ import net.minecraft.command.CommandBase;
/*     */ import net.minecraft.command.ICommand;
/*     */ import net.minecraft.command.ICommandSender;
/*     */ import net.minecraft.command.WrongUsageException;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import net.minecraft.util.ChatComponentTranslation;
/*     */ 
/*     */ public class ComJrmcStatusEffect extends CommandBase {
/*  15 */   private final String[] MODES = new String[] { "set" };
/*  16 */   private final String[] STATUS = new String[] { "Strain", "GodPower", "Fatigue", "NoFuse", "Majin", "Legendary", "Divine", "Pain", "Heat", "KO", "GodOfDestruction" };
/*  17 */   private final String[] TIME = new String[] { "0", "1", "100" };
/*     */   
/*  19 */   private final String[] statusEffectNBT = new String[] { "jrmcStrain", "jrmcGodPwr", "jrmcGodStrain", "jrmcFuzion", "jrmcMajin", "", "", "jrmcGyJ7dp", "jrmcEf8slc", "jrmcHar4va" };
/*     */ 
/*     */   
/*     */   public String func_71517_b() {
/*  23 */     return "jrmcse";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_82362_a() {
/*  31 */     return 2;
/*     */   }
/*     */   
/*     */   public void func_71515_b(ICommandSender par1ICommandSender, String[] stringArray) {
/*     */     EntityPlayerMP entityplayermp;
/*  36 */     if (stringArray.length < 3) {
/*     */       
/*  38 */       String list = "";
/*  39 */       for (int i = 0; i < this.STATUS.length; i++) {
/*  40 */         list = list + ", " + this.STATUS[i];
/*     */       }
/*  42 */       throw new WrongUsageException("/jrmcse set (statusEffectName) (Minutes) [playerName] --> StatusEffectName can be: " + list, new Object[0]);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  49 */     if (stringArray.length > 3) {
/*     */       
/*  51 */       entityplayermp = func_82359_c(par1ICommandSender, stringArray[3]);
/*     */     }
/*     */     else {
/*     */       
/*  55 */       entityplayermp = func_71521_c(par1ICommandSender);
/*     */     } 
/*     */     
/*  58 */     String entitycommansender = "Console";
/*     */     try {
/*  60 */       EntityPlayerMP commansender = func_71521_c(par1ICommandSender);
/*  61 */       entitycommansender = commansender.func_70005_c_();
/*  62 */     } catch (Exception exception) {}
/*     */ 
/*     */     
/*  65 */     boolean n = entitycommansender.equals("Console") ? JRMCoreConfig.ComSENAC : (entitycommansender.equals(entityplayermp.func_70005_c_()) ? JRMCoreConfig.ComSENAS : JRMCoreConfig.ComSENAO);
/*     */     
/*  67 */     String s = stringArray[0];
/*  68 */     boolean set = s.toLowerCase().contentEquals("set");
/*  69 */     s = stringArray[2];
/*  70 */     float value = Float.parseFloat(s);
/*     */     
/*  72 */     if (set) {
/*     */       
/*  74 */       int id = -1;
/*  75 */       for (int i = 0; i < this.STATUS.length; i++) {
/*  76 */         if (stringArray[1].toLowerCase().equals(this.STATUS[i].toLowerCase())) {
/*     */           
/*  78 */           id = i;
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/*  83 */       if (id == 5) {
/*  84 */         JRMCoreH.StusEfcts(14, (EntityPlayer)entityplayermp, (value != 0.0F));
/*     */         
/*  86 */         String t = "Status Effect " + this.STATUS[id] + " has been " + ((value == 0.0F) ? "removed" : "added") + ".";
/*  87 */         entityplayermp.func_145747_a((new ChatComponentTranslation(t, new Object[0])).func_150255_a(JRMCoreH2.styl_ylw));
/*  88 */         if (n) notifyAdmins(par1ICommandSender, "%s's Status Effect %s has been " + ((value == 0.0F) ? "removed" : "added") + ".", new Object[] { entityplayermp.func_70005_c_(), this.STATUS[id], Float.valueOf(value) });
/*     */       
/*     */       }
/*  91 */       else if (id == 4) {
/*  92 */         JRMCoreH.StusEfcts(12, (EntityPlayer)entityplayermp, (value != 0.0F));
/*     */         
/*  94 */         String t = "Status Effect " + this.STATUS[id] + " has been " + ((value == 0.0F) ? "removed" : "added") + ".";
/*  95 */         entityplayermp.func_145747_a((new ChatComponentTranslation(t, new Object[0])).func_150255_a(JRMCoreH2.styl_ylw));
/*  96 */         if (n) notifyAdmins(par1ICommandSender, "%s's Status Effect %s has been " + ((value == 0.0F) ? "removed" : "added") + ".", new Object[] { entityplayermp.func_70005_c_(), this.STATUS[id], Float.valueOf(value) });
/*     */       
/*     */       }
/*  99 */       else if (id == 6) {
/* 100 */         JRMCoreH.StusEfcts(17, (EntityPlayer)entityplayermp, (value != 0.0F));
/*     */         
/* 102 */         String t = "Status Effect " + this.STATUS[id] + " has been " + ((value == 0.0F) ? "removed" : "added") + ".";
/* 103 */         entityplayermp.func_145747_a((new ChatComponentTranslation(t, new Object[0])).func_150255_a(JRMCoreH2.styl_ylw));
/* 104 */         if (n) notifyAdmins(par1ICommandSender, "%s's Status Effect %s has been " + ((value == 0.0F) ? "removed" : "added") + ".", new Object[] { entityplayermp.func_70005_c_(), this.STATUS[id], Float.valueOf(value) });
/*     */       
/*     */       }
/* 107 */       else if (id == 10) {
/* 108 */         JRMCoreH.StusEfcts(20, (EntityPlayer)entityplayermp, (value != 0.0F));
/*     */         
/* 110 */         String t = "Status Effect " + this.STATUS[id] + " has been " + ((value == 0.0F) ? "removed" : "added") + ".";
/* 111 */         entityplayermp.func_145747_a((new ChatComponentTranslation(t, new Object[0])).func_150255_a(JRMCoreH2.styl_ylw));
/* 112 */         if (n) notifyAdmins(par1ICommandSender, "%s's Status Effect %s has been " + ((value == 0.0F) ? "removed" : "added") + ".", new Object[] { entityplayermp.func_70005_c_(), this.STATUS[id], Float.valueOf(value) });
/*     */       
/* 114 */       } else if (id >= 0) {
/* 115 */         if (id == 3) {
/* 116 */           String f = JRMCoreH.getString((EntityPlayer)entityplayermp, this.statusEffectNBT[id]);
/* 117 */           if (!f.contains(",")) JRMCoreH.setString("" + (int)(value * 60.0F / 5.0F), (EntityPlayer)entityplayermp, this.statusEffectNBT[id]); 
/*     */         } else {
/* 119 */           JRMCoreH.setInt(value * 60.0F / 5.0F, (EntityPlayer)entityplayermp, this.statusEffectNBT[id]);
/*     */         } 
/* 121 */         if (this.statusEffectNBT[id].equals("jrmcGyJ7dp")) {
/*     */           
/* 123 */           NBTTagCompound nbt = JRMCoreH.nbt((Entity)entityplayermp, "pres");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 129 */           if (value > 0.0F) {
/* 130 */             nbt.func_74768_a("jrmcUIWasInPainDuration", 0);
/* 131 */             nbt.func_74774_a("jrmcUIWasInPain", (byte)1);
/*     */           }
/*     */         
/* 134 */         } else if (this.statusEffectNBT[id].equals("jrmcEf8slc")) {
/*     */           
/* 136 */           NBTTagCompound nbt = JRMCoreH.nbt((Entity)entityplayermp, "pres");
/* 137 */           nbt.func_74780_a("jrmcEf8slcD", 0.0D);
/*     */         } 
/*     */         
/* 140 */         String t = "Status Effect " + this.STATUS[id] + " has been set to " + value + " mins.";
/* 141 */         entityplayermp.func_145747_a((new ChatComponentTranslation(t, new Object[0])).func_150255_a(JRMCoreH2.styl_ylw));
/* 142 */         if (n) notifyAdmins(par1ICommandSender, "%s's Status Effect %s has been set to %s mins.", new Object[] { entityplayermp.func_70005_c_(), this.STATUS[id], Float.valueOf(value) });
/*     */       
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void notifyAdmins(ICommandSender par1iCommandSender, String string, Object[] objects) {
/* 151 */     func_152373_a(par1iCommandSender, (ICommand)this, string, objects);
/*     */   }
/*     */   
/*     */   public String func_71518_a(ICommandSender icommandsender) {
/* 155 */     return "/jrmcse set (statusEffectName) (TimeValue) [playerName]";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List func_71516_a(ICommandSender commandSender, String[] stringArray) {
/* 161 */     int length = stringArray.length;
/* 162 */     switch (length) { case 1:
/* 163 */         return func_71530_a(stringArray, this.MODES);
/* 164 */       case 2: return func_71530_a(stringArray, this.STATUS);
/* 165 */       case 3: return func_71530_a(stringArray, this.TIME);
/* 166 */       case 4: return func_71530_a(stringArray, getListOfPlayers()); }
/* 167 */      return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected String[] getListOfPlayers() {
/* 173 */     return MinecraftServer.func_71276_C().func_71213_z();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isUsernameIndex(int par1) {
/* 181 */     return (par1 == 0);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\ComJrmcStatusEffect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */