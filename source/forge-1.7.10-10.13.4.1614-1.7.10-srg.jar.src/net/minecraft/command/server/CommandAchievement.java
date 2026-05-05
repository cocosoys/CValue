/*     */ package net.minecraft.command.server;
/*     */ import com.google.common.collect.Lists;
/*     */ import java.util.ArrayList;
/*     */ import net.minecraft.command.CommandBase;
/*     */ import net.minecraft.command.CommandException;
/*     */ import net.minecraft.command.ICommand;
/*     */ import net.minecraft.command.ICommandSender;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import net.minecraft.stats.Achievement;
/*     */ import net.minecraft.stats.AchievementList;
/*     */ import net.minecraft.stats.StatBase;
/*     */ import net.minecraft.stats.StatList;
/*     */ 
/*     */ public class CommandAchievement extends CommandBase {
/*     */   public String func_71517_b() {
/*  17 */     return "achievement";
/*     */   }
/*     */   private static final String __OBFID = "CL_00000113";
/*     */   
/*     */   public int func_82362_a() {
/*  22 */     return 2;
/*     */   }
/*     */ 
/*     */   
/*     */   public String func_71518_a(ICommandSender p_71518_1_) {
/*  27 */     return "commands.achievement.usage";
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
/*  32 */     if (p_71515_2_.length >= 2) {
/*  33 */       EntityPlayerMP entityPlayerMP; StatBase statBase = StatList.func_151177_a(p_71515_2_[1]);
/*     */ 
/*     */       
/*  36 */       if (statBase == null && !p_71515_2_[1].equals("*")) {
/*  37 */         throw new CommandException("commands.achievement.unknownAchievement", new Object[] { p_71515_2_[1] });
/*     */       }
/*     */       
/*  40 */       if (p_71515_2_.length >= 3) {
/*  41 */         entityPlayerMP = func_82359_c(p_71515_1_, p_71515_2_[2]);
/*     */       } else {
/*  43 */         entityPlayerMP = func_71521_c(p_71515_1_);
/*     */       } 
/*     */       
/*  46 */       if (p_71515_2_[0].equalsIgnoreCase("give")) {
/*  47 */         if (statBase == null) {
/*  48 */           for (Achievement achievement : AchievementList.field_76007_e) {
/*  49 */             entityPlayerMP.func_71029_a((StatBase)achievement);
/*     */           }
/*     */           
/*  52 */           func_152373_a(p_71515_1_, (ICommand)this, "commands.achievement.give.success.all", new Object[] { entityPlayerMP.func_70005_c_() });
/*     */         } else {
/*  54 */           if (statBase instanceof Achievement) {
/*  55 */             Achievement achievement = (Achievement)statBase;
/*  56 */             ArrayList<Achievement> arrayList = Lists.newArrayList();
/*     */             
/*  58 */             while (achievement.field_75992_c != null && !entityPlayerMP.func_147099_x().func_77443_a(achievement.field_75992_c)) {
/*  59 */               arrayList.add(achievement.field_75992_c);
/*  60 */               achievement = achievement.field_75992_c;
/*     */             } 
/*     */             
/*  63 */             for (Achievement achievement1 : Lists.reverse(arrayList)) {
/*  64 */               entityPlayerMP.func_71029_a((StatBase)achievement1);
/*     */             }
/*     */           } 
/*     */           
/*  68 */           entityPlayerMP.func_71029_a(statBase);
/*     */           
/*  70 */           func_152373_a(p_71515_1_, (ICommand)this, "commands.achievement.give.success.one", new Object[] { entityPlayerMP.func_70005_c_(), statBase.func_150955_j() });
/*     */         } 
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/*     */     
/*  77 */     throw new WrongUsageException("commands.achievement.usage", new Object[0]);
/*     */   }
/*     */ 
/*     */   
/*     */   public List func_71516_a(ICommandSender p_71516_1_, String[] p_71516_2_) {
/*  82 */     if (p_71516_2_.length == 1) {
/*  83 */       return func_71530_a(p_71516_2_, new String[] { "give" });
/*     */     }
/*     */     
/*  86 */     if (p_71516_2_.length == 2) {
/*  87 */       ArrayList<String> arrayList = Lists.newArrayList();
/*     */       
/*  89 */       for (StatBase statBase : StatList.field_75940_b) {
/*  90 */         arrayList.add(statBase.field_75975_e);
/*     */       }
/*     */       
/*  93 */       return func_71531_a(p_71516_2_, arrayList);
/*     */     } 
/*     */     
/*  96 */     if (p_71516_2_.length == 3) {
/*  97 */       return func_71530_a(p_71516_2_, MinecraftServer.func_71276_C().func_71213_z());
/*     */     }
/*     */     
/* 100 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_82358_a(String[] p_82358_1_, int p_82358_2_) {
/* 105 */     return (p_82358_2_ == 2);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\command\server\CommandAchievement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */