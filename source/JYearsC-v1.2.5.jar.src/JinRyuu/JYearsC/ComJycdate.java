/*     */ package JinRyuu.JYearsC;
/*     */ 
/*     */ import JinRyuu.JRMCore.JYearsCH;
/*     */ import cpw.mods.fml.common.FMLCommonHandler;
/*     */ import net.minecraft.command.CommandBase;
/*     */ import net.minecraft.command.ICommand;
/*     */ import net.minecraft.command.ICommandSender;
/*     */ import net.minecraft.command.WrongUsageException;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import net.minecraft.world.WorldServer;
/*     */ 
/*     */ public class ComJycdate extends CommandBase {
/*     */   public String func_71517_b() {
/*  15 */     return "jycdate";
/*     */   }
/*     */ 
/*     */   
/*     */   public String func_71518_a(ICommandSender icommandsender) {
/*  20 */     return "/jycdate (amount)(Y or M or D) (amount)(Y or M or D) (amount)(Y or M or D)  Example: /jycdate 2D 3M 5Y";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int func_82362_a() {
/*  28 */     return 2;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_71515_b(ICommandSender par1ICommandSender, String[] par2ArrayOfStr) {
/*  33 */     if (par2ArrayOfStr.length <= 0)
/*     */     {
/*  35 */       throw new WrongUsageException("/jycdate (amount)(Y or M or D) (amount)(Y or M or D) (amount)(Y or M or D)", new Object[0]);
/*     */     }
/*     */ 
/*     */     
/*  39 */     if (par2ArrayOfStr.length < 3)
/*     */     {
/*  41 */       throw new WrongUsageException("/jycdate (amount)(Y or M or D) (amount)(Y or M or D) (amount)(Y or M or D)  Example: /jycdate 2D 3M 5Y", new Object[0]);
/*     */     }
/*     */     
/*  44 */     String s = par2ArrayOfStr[0];
/*  45 */     boolean flag = (s.endsWith("y") || s.endsWith("Y"));
/*  46 */     boolean flagm = (s.endsWith("m") || s.endsWith("M"));
/*  47 */     boolean flagd = (s.endsWith("d") || s.endsWith("D"));
/*     */     
/*  49 */     if ((flag || flagm || flagd) && s.length() > 1)
/*     */     {
/*  51 */       s = s.substring(0, s.length() - 1);
/*     */     }
/*     */     
/*  54 */     int i = func_71526_a(par1ICommandSender, s);
/*  55 */     boolean flag1 = (i < 0);
/*     */     
/*  57 */     if (flag1)
/*     */     {
/*  59 */       i *= -1;
/*     */     }
/*     */     
/*  62 */     String s1 = par2ArrayOfStr[1];
/*  63 */     boolean flag2 = (s1.endsWith("y") || s1.endsWith("Y"));
/*  64 */     boolean flagm1 = (s1.endsWith("m") || s1.endsWith("M"));
/*  65 */     boolean flagd1 = (s1.endsWith("d") || s1.endsWith("D"));
/*     */     
/*  67 */     if ((flag2 || flagm1 || flagd1) && s1.length() > 1)
/*     */     {
/*  69 */       s1 = s1.substring(0, s1.length() - 1);
/*     */     }
/*     */     
/*  72 */     int i1 = func_71526_a(par1ICommandSender, s1);
/*  73 */     boolean flag11 = (i1 < 0);
/*     */     
/*  75 */     if (flag11)
/*     */     {
/*  77 */       i1 *= -1;
/*     */     }
/*     */ 
/*     */     
/*  81 */     String s2 = par2ArrayOfStr[2];
/*  82 */     boolean flag3 = (s2.endsWith("y") || s2.endsWith("Y"));
/*  83 */     boolean flagm2 = (s2.endsWith("m") || s2.endsWith("M"));
/*  84 */     boolean flagd2 = (s2.endsWith("d") || s2.endsWith("D"));
/*     */     
/*  86 */     if ((flag3 || flagm2 || flagd2) && s2.length() > 1)
/*     */     {
/*  88 */       s2 = s2.substring(0, s2.length() - 1);
/*     */     }
/*     */     
/*  91 */     int i2 = func_71526_a(par1ICommandSender, s2);
/*  92 */     boolean flag12 = (i2 < 0);
/*     */     
/*  94 */     if (flag12)
/*     */     {
/*  96 */       i2 *= -1;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 101 */     EntityPlayerMP entityplayermp = func_71521_c(par1ICommandSender);
/*     */     
/* 103 */     WorldServer dim0 = FMLCommonHandler.instance().getMinecraftServerInstance().func_71218_a(0);
/* 104 */     MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
/*     */     
/* 106 */     if (flag1 || flag11 || flag12)
/*     */     {
/* 108 */       throw new WrongUsageException("Nothing can be negative", new Object[0]);
/*     */     }
/* 110 */     if (flag || flag2 || flag3) {
/*     */       
/* 112 */       if (i >= 1000000 || i1 >= 1000000 || i2 >= 1000000)
/*     */       {
/* 114 */         throw new WrongUsageException("Year can't be more then a million!", new Object[0]);
/*     */       }
/* 116 */       if (flag) { JYearsCH.wcd(server, i + "", "y", false); i = 1; }
/* 117 */        if (flag2) { JYearsCH.wcd(server, i1 + "", "y", false); i1 = 1; }
/* 118 */        if (flag3) { JYearsCH.wcd(server, i2 + "", "y", false); i2 = 1; }
/* 119 */        notifyAdmins(par1ICommandSender, "Year Set success", new Object[] { entityplayermp.getDisplayName() });
/*     */     } else {
/* 121 */       throw new WrongUsageException("The date Year format is not as expected.", new Object[0]);
/*     */     } 
/*     */     
/* 124 */     if (i < 1 || i1 < 1 || i2 < 1) {
/* 125 */       throw new WrongUsageException("Dont add 0 (null) or negative numbers!", new Object[0]);
/*     */     }
/*     */     
/* 128 */     if (flagd1 || flagd2 || flagd) {
/*     */       
/* 130 */       if (i > 13 || i < 1 || i1 > 13 || i1 < 1 || i2 > 13 || i2 < 1)
/*     */       {
/* 132 */         throw new WrongUsageException("Days can only be from 1 to 13, depending on the month!", new Object[0]);
/*     */       }
/*     */       
/* 135 */       if (flagd) { JYearsCH.wcd(server, (i - 1) + "", "d", false); i = 1; }
/* 136 */        if (flagd1) { JYearsCH.wcd(server, (i1 - 1) + "", "d", false); i1 = 1; }
/* 137 */        if (flagd2) { JYearsCH.wcd(server, (i2 - 1) + "", "d", false); i2 = 1; }
/* 138 */        notifyAdmins(par1ICommandSender, "Day Set success", new Object[] { entityplayermp.getDisplayName() });
/*     */     } else {
/* 140 */       throw new WrongUsageException("The date Day format is not as expected.", new Object[0]);
/*     */     } 
/* 142 */     if (flagm1 || flagm2 || flagm) {
/*     */       
/* 144 */       if (i > 4 || i < 1 || i1 > 4 || i1 < 1 || i2 > 4 || i2 < 1)
/*     */       {
/* 146 */         throw new WrongUsageException("Month can only be from 1 to 4!", new Object[0]);
/*     */       }
/*     */       
/* 149 */       if (flagm) JYearsCH.wcd(server, (i - 1) + "", "m", false); 
/* 150 */       if (flagm1) JYearsCH.wcd(server, (i1 - 1) + "", "m", false); 
/* 151 */       if (flagm2) JYearsCH.wcd(server, (i2 - 1) + "", "m", false); 
/* 152 */       notifyAdmins(par1ICommandSender, "Month Set success", new Object[] { entityplayermp.getDisplayName() });
/*     */     } else {
/* 154 */       throw new WrongUsageException("The date Month format is not as expected.", new Object[0]);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void notifyAdmins(ICommandSender par1iCommandSender, String string, Object[] objects) {
/* 159 */     func_152373_a(par1iCommandSender, (ICommand)this, string, objects);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JYearsC-v1.2.5.jar!\JinRyuu\JYearsC\ComJycdate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */