/*    */ package net.minecraft.command.server;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.regex.Matcher;
/*    */ import java.util.regex.Pattern;
/*    */ import net.minecraft.command.CommandBase;
/*    */ import net.minecraft.command.ICommand;
/*    */ import net.minecraft.command.ICommandSender;
/*    */ import net.minecraft.command.PlayerNotFoundException;
/*    */ import net.minecraft.command.WrongUsageException;
/*    */ import net.minecraft.entity.player.EntityPlayerMP;
/*    */ import net.minecraft.server.MinecraftServer;
/*    */ import net.minecraft.server.management.IPBanEntry;
/*    */ import net.minecraft.server.management.UserListEntry;
/*    */ import net.minecraft.util.IChatComponent;
/*    */ 
/*    */ public class CommandBanIp extends CommandBase {
/* 18 */   public static final Pattern field_147211_a = Pattern.compile("^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");
/*    */   
/*    */   private static final String __OBFID = "CL_00000139";
/*    */   
/*    */   public String func_71517_b() {
/* 23 */     return "ban-ip";
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_82362_a() {
/* 28 */     return 3;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_71519_b(ICommandSender p_71519_1_) {
/* 33 */     return (MinecraftServer.func_71276_C().func_71203_ab().func_72363_f().func_152689_b() && super.func_71519_b(p_71519_1_));
/*    */   }
/*    */ 
/*    */   
/*    */   public String func_71518_a(ICommandSender p_71518_1_) {
/* 38 */     return "commands.banip.usage";
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
/* 43 */     if (p_71515_2_.length >= 1 && p_71515_2_[0].length() > 1) {
/* 44 */       Matcher matcher = field_147211_a.matcher(p_71515_2_[0]);
/* 45 */       IChatComponent iChatComponent = null;
/*    */       
/* 47 */       if (p_71515_2_.length >= 2) {
/* 48 */         iChatComponent = func_147178_a(p_71515_1_, p_71515_2_, 1);
/*    */       }
/*    */       
/* 51 */       if (matcher.matches()) {
/* 52 */         func_147210_a(p_71515_1_, p_71515_2_[0], (iChatComponent == null) ? null : iChatComponent.func_150260_c());
/*    */       } else {
/* 54 */         EntityPlayerMP entityPlayerMP = MinecraftServer.func_71276_C().func_71203_ab().func_152612_a(p_71515_2_[0]);
/*    */         
/* 56 */         if (entityPlayerMP == null) {
/* 57 */           throw new PlayerNotFoundException("commands.banip.invalid", new Object[0]);
/*    */         }
/*    */         
/* 60 */         func_147210_a(p_71515_1_, entityPlayerMP.func_71114_r(), (iChatComponent == null) ? null : iChatComponent.func_150260_c());
/*    */       } 
/*    */       
/*    */       return;
/*    */     } 
/*    */     
/* 66 */     throw new WrongUsageException("commands.banip.usage", new Object[0]);
/*    */   }
/*    */ 
/*    */   
/*    */   public List func_71516_a(ICommandSender p_71516_1_, String[] p_71516_2_) {
/* 71 */     if (p_71516_2_.length == 1) {
/* 72 */       return func_71530_a(p_71516_2_, MinecraftServer.func_71276_C().func_71213_z());
/*    */     }
/*    */     
/* 75 */     return null;
/*    */   }
/*    */   
/*    */   protected void func_147210_a(ICommandSender p_147210_1_, String p_147210_2_, String p_147210_3_) {
/* 79 */     IPBanEntry iPBanEntry = new IPBanEntry(p_147210_2_, null, p_147210_1_.func_70005_c_(), null, p_147210_3_);
/* 80 */     MinecraftServer.func_71276_C().func_71203_ab().func_72363_f().func_152687_a((UserListEntry)iPBanEntry);
/*    */     
/* 82 */     List list = MinecraftServer.func_71276_C().func_71203_ab().func_72382_j(p_147210_2_);
/* 83 */     String[] arrayOfString = new String[list.size()];
/* 84 */     byte b = 0;
/*    */     
/* 86 */     for (EntityPlayerMP entityPlayerMP : list) {
/* 87 */       entityPlayerMP.field_71135_a.func_147360_c("You have been IP banned.");
/* 88 */       arrayOfString[b++] = entityPlayerMP.func_70005_c_();
/*    */     } 
/*    */     
/* 91 */     if (list.isEmpty()) {
/* 92 */       func_152373_a(p_147210_1_, (ICommand)this, "commands.banip.success", new Object[] { p_147210_2_ });
/*    */     } else {
/* 94 */       func_152373_a(p_147210_1_, (ICommand)this, "commands.banip.success.players", new Object[] { p_147210_2_, func_71527_a((Object[])arrayOfString) });
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\command\server\CommandBanIp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */