/*     */ package net.minecraft.command.server;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.HashSet;
/*     */ import java.util.Map;
/*     */ import net.minecraft.command.CommandException;
/*     */ import net.minecraft.command.ICommand;
/*     */ import net.minecraft.command.ICommandSender;
/*     */ import net.minecraft.command.SyntaxErrorException;
/*     */ import net.minecraft.command.WrongUsageException;
/*     */ import net.minecraft.scoreboard.IScoreObjectiveCriteria;
/*     */ import net.minecraft.scoreboard.Score;
/*     */ import net.minecraft.scoreboard.ScoreObjective;
/*     */ import net.minecraft.scoreboard.ScorePlayerTeam;
/*     */ import net.minecraft.scoreboard.Scoreboard;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import net.minecraft.util.ChatComponentTranslation;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ import net.minecraft.util.IChatComponent;
/*     */ 
/*     */ public class CommandScoreboard extends CommandBase {
/*     */   public String func_71517_b() {
/*  24 */     return "scoreboard";
/*     */   }
/*     */   private static final String __OBFID = "CL_00000896";
/*     */   
/*     */   public int func_82362_a() {
/*  29 */     return 2;
/*     */   }
/*     */ 
/*     */   
/*     */   public String func_71518_a(ICommandSender p_71518_1_) {
/*  34 */     return "commands.scoreboard.usage";
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
/*  39 */     if (p_71515_2_.length >= 1) {
/*  40 */       if (p_71515_2_[0].equalsIgnoreCase("objectives")) {
/*  41 */         if (p_71515_2_.length == 1)
/*  42 */           throw new WrongUsageException("commands.scoreboard.objectives.usage", new Object[0]); 
/*  43 */         if (p_71515_2_[1].equalsIgnoreCase("list")) {
/*  44 */           func_147196_d(p_71515_1_);
/*  45 */         } else if (p_71515_2_[1].equalsIgnoreCase("add")) {
/*  46 */           if (p_71515_2_.length >= 4) {
/*  47 */             func_147193_c(p_71515_1_, p_71515_2_, 2);
/*     */           } else {
/*  49 */             throw new WrongUsageException("commands.scoreboard.objectives.add.usage", new Object[0]);
/*     */           } 
/*  51 */         } else if (p_71515_2_[1].equalsIgnoreCase("remove")) {
/*  52 */           if (p_71515_2_.length == 3) {
/*  53 */             func_147191_h(p_71515_1_, p_71515_2_[2]);
/*     */           } else {
/*  55 */             throw new WrongUsageException("commands.scoreboard.objectives.remove.usage", new Object[0]);
/*     */           } 
/*  57 */         } else if (p_71515_2_[1].equalsIgnoreCase("setdisplay")) {
/*  58 */           if (p_71515_2_.length == 3 || p_71515_2_.length == 4) {
/*  59 */             func_147198_k(p_71515_1_, p_71515_2_, 2);
/*     */           } else {
/*  61 */             throw new WrongUsageException("commands.scoreboard.objectives.setdisplay.usage", new Object[0]);
/*     */           } 
/*     */         } else {
/*  64 */           throw new WrongUsageException("commands.scoreboard.objectives.usage", new Object[0]);
/*     */         } 
/*     */         return;
/*     */       } 
/*  68 */       if (p_71515_2_[0].equalsIgnoreCase("players")) {
/*  69 */         if (p_71515_2_.length == 1)
/*  70 */           throw new WrongUsageException("commands.scoreboard.players.usage", new Object[0]); 
/*  71 */         if (p_71515_2_[1].equalsIgnoreCase("list")) {
/*  72 */           if (p_71515_2_.length <= 3) {
/*  73 */             func_147195_l(p_71515_1_, p_71515_2_, 2);
/*     */           } else {
/*  75 */             throw new WrongUsageException("commands.scoreboard.players.list.usage", new Object[0]);
/*     */           } 
/*  77 */         } else if (p_71515_2_[1].equalsIgnoreCase("add")) {
/*  78 */           if (p_71515_2_.length == 5) {
/*  79 */             func_147197_m(p_71515_1_, p_71515_2_, 2);
/*     */           } else {
/*  81 */             throw new WrongUsageException("commands.scoreboard.players.add.usage", new Object[0]);
/*     */           } 
/*  83 */         } else if (p_71515_2_[1].equalsIgnoreCase("remove")) {
/*  84 */           if (p_71515_2_.length == 5) {
/*  85 */             func_147197_m(p_71515_1_, p_71515_2_, 2);
/*     */           } else {
/*  87 */             throw new WrongUsageException("commands.scoreboard.players.remove.usage", new Object[0]);
/*     */           } 
/*  89 */         } else if (p_71515_2_[1].equalsIgnoreCase("set")) {
/*  90 */           if (p_71515_2_.length == 5) {
/*  91 */             func_147197_m(p_71515_1_, p_71515_2_, 2);
/*     */           } else {
/*  93 */             throw new WrongUsageException("commands.scoreboard.players.set.usage", new Object[0]);
/*     */           } 
/*  95 */         } else if (p_71515_2_[1].equalsIgnoreCase("reset")) {
/*  96 */           if (p_71515_2_.length == 3) {
/*  97 */             func_147187_n(p_71515_1_, p_71515_2_, 2);
/*     */           } else {
/*  99 */             throw new WrongUsageException("commands.scoreboard.players.reset.usage", new Object[0]);
/*     */           } 
/*     */         } else {
/* 102 */           throw new WrongUsageException("commands.scoreboard.players.usage", new Object[0]);
/*     */         } 
/*     */         return;
/*     */       } 
/* 106 */       if (p_71515_2_[0].equalsIgnoreCase("teams")) {
/* 107 */         if (p_71515_2_.length == 1)
/* 108 */           throw new WrongUsageException("commands.scoreboard.teams.usage", new Object[0]); 
/* 109 */         if (p_71515_2_[1].equalsIgnoreCase("list")) {
/* 110 */           if (p_71515_2_.length <= 3) {
/* 111 */             func_147186_g(p_71515_1_, p_71515_2_, 2);
/*     */           } else {
/* 113 */             throw new WrongUsageException("commands.scoreboard.teams.list.usage", new Object[0]);
/*     */           } 
/* 115 */         } else if (p_71515_2_[1].equalsIgnoreCase("add")) {
/* 116 */           if (p_71515_2_.length >= 3) {
/* 117 */             func_147185_d(p_71515_1_, p_71515_2_, 2);
/*     */           } else {
/* 119 */             throw new WrongUsageException("commands.scoreboard.teams.add.usage", new Object[0]);
/*     */           } 
/* 121 */         } else if (p_71515_2_[1].equalsIgnoreCase("remove")) {
/* 122 */           if (p_71515_2_.length == 3) {
/* 123 */             func_147194_f(p_71515_1_, p_71515_2_, 2);
/*     */           } else {
/* 125 */             throw new WrongUsageException("commands.scoreboard.teams.remove.usage", new Object[0]);
/*     */           } 
/* 127 */         } else if (p_71515_2_[1].equalsIgnoreCase("empty")) {
/* 128 */           if (p_71515_2_.length == 3) {
/* 129 */             func_147188_j(p_71515_1_, p_71515_2_, 2);
/*     */           } else {
/* 131 */             throw new WrongUsageException("commands.scoreboard.teams.empty.usage", new Object[0]);
/*     */           } 
/* 133 */         } else if (p_71515_2_[1].equalsIgnoreCase("join")) {
/* 134 */           if (p_71515_2_.length >= 4 || (p_71515_2_.length == 3 && p_71515_1_ instanceof net.minecraft.entity.player.EntityPlayer)) {
/* 135 */             func_147190_h(p_71515_1_, p_71515_2_, 2);
/*     */           } else {
/* 137 */             throw new WrongUsageException("commands.scoreboard.teams.join.usage", new Object[0]);
/*     */           } 
/* 139 */         } else if (p_71515_2_[1].equalsIgnoreCase("leave")) {
/* 140 */           if (p_71515_2_.length >= 3 || p_71515_1_ instanceof net.minecraft.entity.player.EntityPlayer) {
/* 141 */             func_147199_i(p_71515_1_, p_71515_2_, 2);
/*     */           } else {
/* 143 */             throw new WrongUsageException("commands.scoreboard.teams.leave.usage", new Object[0]);
/*     */           } 
/* 145 */         } else if (p_71515_2_[1].equalsIgnoreCase("option")) {
/* 146 */           if (p_71515_2_.length == 4 || p_71515_2_.length == 5) {
/* 147 */             func_147200_e(p_71515_1_, p_71515_2_, 2);
/*     */           } else {
/* 149 */             throw new WrongUsageException("commands.scoreboard.teams.option.usage", new Object[0]);
/*     */           } 
/*     */         } else {
/* 152 */           throw new WrongUsageException("commands.scoreboard.teams.usage", new Object[0]);
/*     */         } 
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/*     */     
/* 159 */     throw new WrongUsageException("commands.scoreboard.usage", new Object[0]);
/*     */   }
/*     */   
/*     */   protected Scoreboard func_147192_d() {
/* 163 */     return MinecraftServer.func_71276_C().func_71218_a(0).func_96441_U();
/*     */   }
/*     */   
/*     */   protected ScoreObjective func_147189_a(String p_147189_1_, boolean p_147189_2_) {
/* 167 */     Scoreboard scoreboard = func_147192_d();
/* 168 */     ScoreObjective scoreObjective = scoreboard.func_96518_b(p_147189_1_);
/*     */     
/* 170 */     if (scoreObjective == null)
/* 171 */       throw new CommandException("commands.scoreboard.objectiveNotFound", new Object[] { p_147189_1_ }); 
/* 172 */     if (p_147189_2_ && scoreObjective.func_96680_c().func_96637_b()) {
/* 173 */       throw new CommandException("commands.scoreboard.objectiveReadOnly", new Object[] { p_147189_1_ });
/*     */     }
/*     */     
/* 176 */     return scoreObjective;
/*     */   }
/*     */   
/*     */   protected ScorePlayerTeam func_147183_a(String p_147183_1_) {
/* 180 */     Scoreboard scoreboard = func_147192_d();
/* 181 */     ScorePlayerTeam scorePlayerTeam = scoreboard.func_96508_e(p_147183_1_);
/*     */     
/* 183 */     if (scorePlayerTeam == null) {
/* 184 */       throw new CommandException("commands.scoreboard.teamNotFound", new Object[] { p_147183_1_ });
/*     */     }
/*     */     
/* 187 */     return scorePlayerTeam;
/*     */   }
/*     */   
/*     */   protected void func_147193_c(ICommandSender p_147193_1_, String[] p_147193_2_, int p_147193_3_) {
/* 191 */     String str1 = p_147193_2_[p_147193_3_++];
/* 192 */     String str2 = p_147193_2_[p_147193_3_++];
/* 193 */     Scoreboard scoreboard = func_147192_d();
/* 194 */     IScoreObjectiveCriteria iScoreObjectiveCriteria = (IScoreObjectiveCriteria)IScoreObjectiveCriteria.field_96643_a.get(str2);
/*     */     
/* 196 */     if (iScoreObjectiveCriteria == null) {
/* 197 */       throw new WrongUsageException("commands.scoreboard.objectives.add.wrongType", new Object[] { str2 });
/*     */     }
/* 199 */     if (scoreboard.func_96518_b(str1) != null) {
/* 200 */       throw new CommandException("commands.scoreboard.objectives.add.alreadyExists", new Object[] { str1 });
/*     */     }
/* 202 */     if (str1.length() > 16) {
/* 203 */       throw new SyntaxErrorException("commands.scoreboard.objectives.add.tooLong", new Object[] { str1, Integer.valueOf(16) });
/*     */     }
/* 205 */     if (str1.length() == 0) {
/* 206 */       throw new WrongUsageException("commands.scoreboard.objectives.add.usage", new Object[0]);
/*     */     }
/*     */     
/* 209 */     if (p_147193_2_.length > p_147193_3_) {
/* 210 */       String str = func_147178_a(p_147193_1_, p_147193_2_, p_147193_3_).func_150260_c();
/*     */       
/* 212 */       if (str.length() > 32) {
/* 213 */         throw new SyntaxErrorException("commands.scoreboard.objectives.add.displayTooLong", new Object[] { str, Integer.valueOf(32) });
/*     */       }
/* 215 */       if (str.length() > 0) {
/* 216 */         scoreboard.func_96535_a(str1, iScoreObjectiveCriteria).func_96681_a(str);
/*     */       } else {
/* 218 */         scoreboard.func_96535_a(str1, iScoreObjectiveCriteria);
/*     */       } 
/*     */     } else {
/* 221 */       scoreboard.func_96535_a(str1, iScoreObjectiveCriteria);
/*     */     } 
/*     */     
/* 224 */     func_152373_a(p_147193_1_, (ICommand)this, "commands.scoreboard.objectives.add.success", new Object[] { str1 });
/*     */   }
/*     */   
/*     */   protected void func_147185_d(ICommandSender p_147185_1_, String[] p_147185_2_, int p_147185_3_) {
/* 228 */     String str = p_147185_2_[p_147185_3_++];
/* 229 */     Scoreboard scoreboard = func_147192_d();
/*     */     
/* 231 */     if (scoreboard.func_96508_e(str) != null) {
/* 232 */       throw new CommandException("commands.scoreboard.teams.add.alreadyExists", new Object[] { str });
/*     */     }
/* 234 */     if (str.length() > 16) {
/* 235 */       throw new SyntaxErrorException("commands.scoreboard.teams.add.tooLong", new Object[] { str, Integer.valueOf(16) });
/*     */     }
/* 237 */     if (str.length() == 0) {
/* 238 */       throw new WrongUsageException("commands.scoreboard.teams.add.usage", new Object[0]);
/*     */     }
/*     */     
/* 241 */     if (p_147185_2_.length > p_147185_3_) {
/* 242 */       String str1 = func_147178_a(p_147185_1_, p_147185_2_, p_147185_3_).func_150260_c();
/*     */       
/* 244 */       if (str1.length() > 32) {
/* 245 */         throw new SyntaxErrorException("commands.scoreboard.teams.add.displayTooLong", new Object[] { str1, Integer.valueOf(32) });
/*     */       }
/* 247 */       if (str1.length() > 0) {
/* 248 */         scoreboard.func_96527_f(str).func_96664_a(str1);
/*     */       } else {
/* 250 */         scoreboard.func_96527_f(str);
/*     */       } 
/*     */     } else {
/* 253 */       scoreboard.func_96527_f(str);
/*     */     } 
/*     */     
/* 256 */     func_152373_a(p_147185_1_, (ICommand)this, "commands.scoreboard.teams.add.success", new Object[] { str });
/*     */   }
/*     */   
/*     */   protected void func_147200_e(ICommandSender p_147200_1_, String[] p_147200_2_, int p_147200_3_) {
/* 260 */     ScorePlayerTeam scorePlayerTeam = func_147183_a(p_147200_2_[p_147200_3_++]);
/* 261 */     if (scorePlayerTeam == null)
/* 262 */       return;  String str1 = p_147200_2_[p_147200_3_++].toLowerCase();
/*     */     
/* 264 */     if (!str1.equalsIgnoreCase("color") && !str1.equalsIgnoreCase("friendlyfire") && !str1.equalsIgnoreCase("seeFriendlyInvisibles")) {
/* 265 */       throw new WrongUsageException("commands.scoreboard.teams.option.usage", new Object[0]);
/*     */     }
/*     */     
/* 268 */     if (p_147200_2_.length == 4) {
/* 269 */       if (str1.equalsIgnoreCase("color"))
/* 270 */         throw new WrongUsageException("commands.scoreboard.teams.option.noValue", new Object[] { str1, func_96333_a(EnumChatFormatting.func_96296_a(true, false)) }); 
/* 271 */       if (str1.equalsIgnoreCase("friendlyfire") || str1.equalsIgnoreCase("seeFriendlyInvisibles")) {
/* 272 */         throw new WrongUsageException("commands.scoreboard.teams.option.noValue", new Object[] { str1, func_96333_a(Arrays.asList(new String[] { "true", "false" })) });
/*     */       }
/*     */       
/* 275 */       throw new WrongUsageException("commands.scoreboard.teams.option.usage", new Object[0]);
/*     */     } 
/*     */     
/* 278 */     String str2 = p_147200_2_[p_147200_3_++];
/*     */     
/* 280 */     if (str1.equalsIgnoreCase("color")) {
/* 281 */       EnumChatFormatting enumChatFormatting = EnumChatFormatting.func_96300_b(str2);
/* 282 */       if (enumChatFormatting == null || enumChatFormatting.func_96301_b()) throw new WrongUsageException("commands.scoreboard.teams.option.noValue", new Object[] { str1, func_96333_a(EnumChatFormatting.func_96296_a(true, false)) }); 
/* 283 */       scorePlayerTeam.func_96666_b(enumChatFormatting.toString());
/* 284 */       scorePlayerTeam.func_96662_c(EnumChatFormatting.RESET.toString());
/* 285 */     } else if (str1.equalsIgnoreCase("friendlyfire")) {
/* 286 */       if (!str2.equalsIgnoreCase("true") && !str2.equalsIgnoreCase("false")) throw new WrongUsageException("commands.scoreboard.teams.option.noValue", new Object[] { str1, func_96333_a(Arrays.asList(new String[] { "true", "false" })) }); 
/* 287 */       scorePlayerTeam.func_96660_a(str2.equalsIgnoreCase("true"));
/* 288 */     } else if (str1.equalsIgnoreCase("seeFriendlyInvisibles")) {
/* 289 */       if (!str2.equalsIgnoreCase("true") && !str2.equalsIgnoreCase("false")) throw new WrongUsageException("commands.scoreboard.teams.option.noValue", new Object[] { str1, func_96333_a(Arrays.asList(new String[] { "true", "false" })) }); 
/* 290 */       scorePlayerTeam.func_98300_b(str2.equalsIgnoreCase("true"));
/*     */     } 
/*     */     
/* 293 */     func_152373_a(p_147200_1_, (ICommand)this, "commands.scoreboard.teams.option.success", new Object[] { str1, scorePlayerTeam.func_96661_b(), str2 });
/*     */   }
/*     */   
/*     */   protected void func_147194_f(ICommandSender p_147194_1_, String[] p_147194_2_, int p_147194_3_) {
/* 297 */     Scoreboard scoreboard = func_147192_d();
/* 298 */     ScorePlayerTeam scorePlayerTeam = func_147183_a(p_147194_2_[p_147194_3_++]);
/* 299 */     if (scorePlayerTeam == null)
/*     */       return; 
/* 301 */     scoreboard.func_96511_d(scorePlayerTeam);
/*     */     
/* 303 */     func_152373_a(p_147194_1_, (ICommand)this, "commands.scoreboard.teams.remove.success", new Object[] { scorePlayerTeam.func_96661_b() });
/*     */   }
/*     */   
/*     */   protected void func_147186_g(ICommandSender p_147186_1_, String[] p_147186_2_, int p_147186_3_) {
/* 307 */     Scoreboard scoreboard = func_147192_d();
/*     */     
/* 309 */     if (p_147186_2_.length > p_147186_3_) {
/* 310 */       ScorePlayerTeam scorePlayerTeam = func_147183_a(p_147186_2_[p_147186_3_++]);
/* 311 */       if (scorePlayerTeam == null)
/*     */         return; 
/* 313 */       Collection collection = scorePlayerTeam.func_96670_d();
/*     */       
/* 315 */       if (collection.size() > 0) {
/* 316 */         ChatComponentTranslation chatComponentTranslation = new ChatComponentTranslation("commands.scoreboard.teams.list.player.count", new Object[] { Integer.valueOf(collection.size()), scorePlayerTeam.func_96661_b() });
/* 317 */         chatComponentTranslation.func_150256_b().func_150238_a(EnumChatFormatting.DARK_GREEN);
/* 318 */         p_147186_1_.func_145747_a((IChatComponent)chatComponentTranslation);
/* 319 */         p_147186_1_.func_145747_a((IChatComponent)new ChatComponentText(func_71527_a(collection.toArray())));
/*     */       } else {
/* 321 */         throw new CommandException("commands.scoreboard.teams.list.player.empty", new Object[] { scorePlayerTeam.func_96661_b() });
/*     */       } 
/*     */     } else {
/* 324 */       Collection collection = scoreboard.func_96525_g();
/*     */       
/* 326 */       if (collection.size() > 0) {
/* 327 */         ChatComponentTranslation chatComponentTranslation = new ChatComponentTranslation("commands.scoreboard.teams.list.count", new Object[] { Integer.valueOf(collection.size()) });
/* 328 */         chatComponentTranslation.func_150256_b().func_150238_a(EnumChatFormatting.DARK_GREEN);
/* 329 */         p_147186_1_.func_145747_a((IChatComponent)chatComponentTranslation);
/*     */         
/* 331 */         for (ScorePlayerTeam scorePlayerTeam : collection) {
/* 332 */           p_147186_1_.func_145747_a((IChatComponent)new ChatComponentTranslation("commands.scoreboard.teams.list.entry", new Object[] { scorePlayerTeam.func_96661_b(), scorePlayerTeam.func_96669_c(), Integer.valueOf(scorePlayerTeam.func_96670_d().size()) }));
/*     */         } 
/*     */       } else {
/* 335 */         throw new CommandException("commands.scoreboard.teams.list.empty", new Object[0]);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void func_147190_h(ICommandSender p_147190_1_, String[] p_147190_2_, int p_147190_3_) {
/* 341 */     Scoreboard scoreboard = func_147192_d();
/* 342 */     String str = p_147190_2_[p_147190_3_++];
/* 343 */     HashSet<String> hashSet1 = new HashSet();
/* 344 */     HashSet<String> hashSet2 = new HashSet();
/*     */     
/* 346 */     if (p_147190_1_ instanceof net.minecraft.entity.player.EntityPlayer && p_147190_3_ == p_147190_2_.length) {
/* 347 */       String str1 = func_71521_c(p_147190_1_).func_70005_c_();
/*     */       
/* 349 */       if (scoreboard.func_151392_a(str1, str)) {
/* 350 */         hashSet1.add(str1);
/*     */       } else {
/* 352 */         hashSet2.add(str1);
/*     */       } 
/*     */     } else {
/* 355 */       while (p_147190_3_ < p_147190_2_.length) {
/* 356 */         String str1 = func_96332_d(p_147190_1_, p_147190_2_[p_147190_3_++]);
/*     */         
/* 358 */         if (scoreboard.func_151392_a(str1, str)) {
/* 359 */           hashSet1.add(str1); continue;
/*     */         } 
/* 361 */         hashSet2.add(str1);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 366 */     if (!hashSet1.isEmpty()) func_152373_a(p_147190_1_, (ICommand)this, "commands.scoreboard.teams.join.success", new Object[] { Integer.valueOf(hashSet1.size()), str, func_71527_a(hashSet1.toArray((Object[])new String[0])) }); 
/* 367 */     if (!hashSet2.isEmpty()) throw new CommandException("commands.scoreboard.teams.join.failure", new Object[] { Integer.valueOf(hashSet2.size()), str, func_71527_a(hashSet2.toArray(new String[0])) }); 
/*     */   }
/*     */   
/*     */   protected void func_147199_i(ICommandSender p_147199_1_, String[] p_147199_2_, int p_147199_3_) {
/* 371 */     Scoreboard scoreboard = func_147192_d();
/* 372 */     HashSet<String> hashSet1 = new HashSet();
/* 373 */     HashSet<String> hashSet2 = new HashSet();
/*     */     
/* 375 */     if (p_147199_1_ instanceof net.minecraft.entity.player.EntityPlayer && p_147199_3_ == p_147199_2_.length) {
/* 376 */       String str = func_71521_c(p_147199_1_).func_70005_c_();
/*     */       
/* 378 */       if (scoreboard.func_96524_g(str)) {
/* 379 */         hashSet1.add(str);
/*     */       } else {
/* 381 */         hashSet2.add(str);
/*     */       } 
/*     */     } else {
/* 384 */       while (p_147199_3_ < p_147199_2_.length) {
/* 385 */         String str = func_96332_d(p_147199_1_, p_147199_2_[p_147199_3_++]);
/*     */         
/* 387 */         if (scoreboard.func_96524_g(str)) {
/* 388 */           hashSet1.add(str); continue;
/*     */         } 
/* 390 */         hashSet2.add(str);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 395 */     if (!hashSet1.isEmpty()) func_152373_a(p_147199_1_, (ICommand)this, "commands.scoreboard.teams.leave.success", new Object[] { Integer.valueOf(hashSet1.size()), func_71527_a(hashSet1.toArray((Object[])new String[0])) }); 
/* 396 */     if (!hashSet2.isEmpty()) throw new CommandException("commands.scoreboard.teams.leave.failure", new Object[] { Integer.valueOf(hashSet2.size()), func_71527_a(hashSet2.toArray(new String[0])) }); 
/*     */   }
/*     */   
/*     */   protected void func_147188_j(ICommandSender p_147188_1_, String[] p_147188_2_, int p_147188_3_) {
/* 400 */     Scoreboard scoreboard = func_147192_d();
/* 401 */     ScorePlayerTeam scorePlayerTeam = func_147183_a(p_147188_2_[p_147188_3_++]);
/* 402 */     if (scorePlayerTeam == null)
/*     */       return; 
/* 404 */     ArrayList arrayList = new ArrayList(scorePlayerTeam.func_96670_d());
/*     */     
/* 406 */     if (arrayList.isEmpty()) {
/* 407 */       throw new CommandException("commands.scoreboard.teams.empty.alreadyEmpty", new Object[] { scorePlayerTeam.func_96661_b() });
/*     */     }
/*     */     
/* 410 */     for (String str : arrayList) {
/* 411 */       scoreboard.func_96512_b(str, scorePlayerTeam);
/*     */     }
/*     */     
/* 414 */     func_152373_a(p_147188_1_, (ICommand)this, "commands.scoreboard.teams.empty.success", new Object[] { Integer.valueOf(arrayList.size()), scorePlayerTeam.func_96661_b() });
/*     */   }
/*     */   
/*     */   protected void func_147191_h(ICommandSender p_147191_1_, String p_147191_2_) {
/* 418 */     Scoreboard scoreboard = func_147192_d();
/* 419 */     ScoreObjective scoreObjective = func_147189_a(p_147191_2_, false);
/*     */     
/* 421 */     scoreboard.func_96519_k(scoreObjective);
/*     */     
/* 423 */     func_152373_a(p_147191_1_, (ICommand)this, "commands.scoreboard.objectives.remove.success", new Object[] { p_147191_2_ });
/*     */   }
/*     */   
/*     */   protected void func_147196_d(ICommandSender p_147196_1_) {
/* 427 */     Scoreboard scoreboard = func_147192_d();
/* 428 */     Collection collection = scoreboard.func_96514_c();
/*     */     
/* 430 */     if (collection.size() > 0) {
/* 431 */       ChatComponentTranslation chatComponentTranslation = new ChatComponentTranslation("commands.scoreboard.objectives.list.count", new Object[] { Integer.valueOf(collection.size()) });
/* 432 */       chatComponentTranslation.func_150256_b().func_150238_a(EnumChatFormatting.DARK_GREEN);
/* 433 */       p_147196_1_.func_145747_a((IChatComponent)chatComponentTranslation);
/*     */       
/* 435 */       for (ScoreObjective scoreObjective : collection) {
/* 436 */         p_147196_1_.func_145747_a((IChatComponent)new ChatComponentTranslation("commands.scoreboard.objectives.list.entry", new Object[] { scoreObjective.func_96679_b(), scoreObjective.func_96678_d(), scoreObjective.func_96680_c().func_96636_a() }));
/*     */       } 
/*     */     } else {
/* 439 */       throw new CommandException("commands.scoreboard.objectives.list.empty", new Object[0]);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void func_147198_k(ICommandSender p_147198_1_, String[] p_147198_2_, int p_147198_3_) {
/* 444 */     Scoreboard scoreboard = func_147192_d();
/* 445 */     String str = p_147198_2_[p_147198_3_++];
/* 446 */     int i = Scoreboard.func_96537_j(str);
/* 447 */     ScoreObjective scoreObjective = null;
/*     */     
/* 449 */     if (p_147198_2_.length == 4) {
/* 450 */       scoreObjective = func_147189_a(p_147198_2_[p_147198_3_++], false);
/*     */     }
/*     */     
/* 453 */     if (i < 0) {
/* 454 */       throw new CommandException("commands.scoreboard.objectives.setdisplay.invalidSlot", new Object[] { str });
/*     */     }
/*     */     
/* 457 */     scoreboard.func_96530_a(i, scoreObjective);
/*     */     
/* 459 */     if (scoreObjective != null) {
/* 460 */       func_152373_a(p_147198_1_, (ICommand)this, "commands.scoreboard.objectives.setdisplay.successSet", new Object[] { Scoreboard.func_96517_b(i), scoreObjective.func_96679_b() });
/*     */     } else {
/* 462 */       func_152373_a(p_147198_1_, (ICommand)this, "commands.scoreboard.objectives.setdisplay.successCleared", new Object[] { Scoreboard.func_96517_b(i) });
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void func_147195_l(ICommandSender p_147195_1_, String[] p_147195_2_, int p_147195_3_) {
/* 467 */     Scoreboard scoreboard = func_147192_d();
/*     */     
/* 469 */     if (p_147195_2_.length > p_147195_3_) {
/* 470 */       String str = func_96332_d(p_147195_1_, p_147195_2_[p_147195_3_++]);
/* 471 */       Map map = scoreboard.func_96510_d(str);
/*     */       
/* 473 */       if (map.size() > 0) {
/* 474 */         ChatComponentTranslation chatComponentTranslation = new ChatComponentTranslation("commands.scoreboard.players.list.player.count", new Object[] { Integer.valueOf(map.size()), str });
/* 475 */         chatComponentTranslation.func_150256_b().func_150238_a(EnumChatFormatting.DARK_GREEN);
/* 476 */         p_147195_1_.func_145747_a((IChatComponent)chatComponentTranslation);
/*     */         
/* 478 */         for (Score score : map.values()) {
/* 479 */           p_147195_1_.func_145747_a((IChatComponent)new ChatComponentTranslation("commands.scoreboard.players.list.player.entry", new Object[] { Integer.valueOf(score.func_96652_c()), score.func_96645_d().func_96678_d(), score.func_96645_d().func_96679_b() }));
/*     */         } 
/*     */       } else {
/* 482 */         throw new CommandException("commands.scoreboard.players.list.player.empty", new Object[] { str });
/*     */       } 
/*     */     } else {
/* 485 */       Collection collection = scoreboard.func_96526_d();
/*     */       
/* 487 */       if (collection.size() > 0) {
/* 488 */         ChatComponentTranslation chatComponentTranslation = new ChatComponentTranslation("commands.scoreboard.players.list.count", new Object[] { Integer.valueOf(collection.size()) });
/* 489 */         chatComponentTranslation.func_150256_b().func_150238_a(EnumChatFormatting.DARK_GREEN);
/* 490 */         p_147195_1_.func_145747_a((IChatComponent)chatComponentTranslation);
/* 491 */         p_147195_1_.func_145747_a((IChatComponent)new ChatComponentText(func_71527_a(collection.toArray())));
/*     */       } else {
/* 493 */         throw new CommandException("commands.scoreboard.players.list.empty", new Object[0]);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void func_147197_m(ICommandSender p_147197_1_, String[] p_147197_2_, int p_147197_3_) {
/* 499 */     String str1 = p_147197_2_[p_147197_3_ - 1];
/* 500 */     String str2 = func_96332_d(p_147197_1_, p_147197_2_[p_147197_3_++]);
/* 501 */     ScoreObjective scoreObjective = func_147189_a(p_147197_2_[p_147197_3_++], true);
/* 502 */     int i = str1.equalsIgnoreCase("set") ? func_71526_a(p_147197_1_, p_147197_2_[p_147197_3_++]) : func_71528_a(p_147197_1_, p_147197_2_[p_147197_3_++], 1);
/* 503 */     Scoreboard scoreboard = func_147192_d();
/* 504 */     Score score = scoreboard.func_96529_a(str2, scoreObjective);
/*     */     
/* 506 */     if (str1.equalsIgnoreCase("set")) {
/* 507 */       score.func_96647_c(i);
/* 508 */     } else if (str1.equalsIgnoreCase("add")) {
/* 509 */       score.func_96649_a(i);
/*     */     } else {
/* 511 */       score.func_96646_b(i);
/*     */     } 
/*     */     
/* 514 */     func_152373_a(p_147197_1_, (ICommand)this, "commands.scoreboard.players.set.success", new Object[] { scoreObjective.func_96679_b(), str2, Integer.valueOf(score.func_96652_c()) });
/*     */   }
/*     */   
/*     */   protected void func_147187_n(ICommandSender p_147187_1_, String[] p_147187_2_, int p_147187_3_) {
/* 518 */     Scoreboard scoreboard = func_147192_d();
/* 519 */     String str = func_96332_d(p_147187_1_, p_147187_2_[p_147187_3_++]);
/*     */     
/* 521 */     scoreboard.func_96515_c(str);
/*     */     
/* 523 */     func_152373_a(p_147187_1_, (ICommand)this, "commands.scoreboard.players.reset.success", new Object[] { str });
/*     */   }
/*     */ 
/*     */   
/*     */   public List func_71516_a(ICommandSender p_71516_1_, String[] p_71516_2_) {
/* 528 */     if (p_71516_2_.length == 1) {
/* 529 */       return func_71530_a(p_71516_2_, new String[] { "objectives", "players", "teams" });
/*     */     }
/*     */     
/* 532 */     if (p_71516_2_[0].equalsIgnoreCase("objectives")) {
/* 533 */       if (p_71516_2_.length == 2) {
/* 534 */         return func_71530_a(p_71516_2_, new String[] { "list", "add", "remove", "setdisplay" });
/*     */       }
/*     */       
/* 537 */       if (p_71516_2_[1].equalsIgnoreCase("add")) {
/* 538 */         if (p_71516_2_.length == 4) {
/* 539 */           Set set = IScoreObjectiveCriteria.field_96643_a.keySet();
/* 540 */           return func_71531_a(p_71516_2_, set);
/*     */         } 
/* 542 */       } else if (p_71516_2_[1].equalsIgnoreCase("remove")) {
/* 543 */         if (p_71516_2_.length == 3) {
/* 544 */           return func_71531_a(p_71516_2_, func_147184_a(false));
/*     */         }
/* 546 */       } else if (p_71516_2_[1].equalsIgnoreCase("setdisplay")) {
/* 547 */         if (p_71516_2_.length == 3)
/* 548 */           return func_71530_a(p_71516_2_, new String[] { "list", "sidebar", "belowName" }); 
/* 549 */         if (p_71516_2_.length == 4) {
/* 550 */           return func_71531_a(p_71516_2_, func_147184_a(false));
/*     */         }
/*     */       } 
/* 553 */     } else if (p_71516_2_[0].equalsIgnoreCase("players")) {
/* 554 */       if (p_71516_2_.length == 2) {
/* 555 */         return func_71530_a(p_71516_2_, new String[] { "set", "add", "remove", "reset", "list" });
/*     */       }
/*     */       
/* 558 */       if (p_71516_2_[1].equalsIgnoreCase("set") || p_71516_2_[1].equalsIgnoreCase("add") || p_71516_2_[1].equalsIgnoreCase("remove")) {
/* 559 */         if (p_71516_2_.length == 3)
/* 560 */           return func_71530_a(p_71516_2_, MinecraftServer.func_71276_C().func_71213_z()); 
/* 561 */         if (p_71516_2_.length == 4) {
/* 562 */           return func_71531_a(p_71516_2_, func_147184_a(true));
/*     */         }
/* 564 */       } else if ((p_71516_2_[1].equalsIgnoreCase("reset") || p_71516_2_[1].equalsIgnoreCase("list")) && 
/* 565 */         p_71516_2_.length == 3) {
/* 566 */         return func_71531_a(p_71516_2_, func_147192_d().func_96526_d());
/*     */       }
/*     */     
/* 569 */     } else if (p_71516_2_[0].equalsIgnoreCase("teams")) {
/* 570 */       if (p_71516_2_.length == 2) {
/* 571 */         return func_71530_a(p_71516_2_, new String[] { "add", "remove", "join", "leave", "empty", "list", "option" });
/*     */       }
/*     */       
/* 574 */       if (p_71516_2_[1].equalsIgnoreCase("join")) {
/* 575 */         if (p_71516_2_.length == 3)
/* 576 */           return func_71531_a(p_71516_2_, func_147192_d().func_96531_f()); 
/* 577 */         if (p_71516_2_.length >= 4)
/* 578 */           return func_71530_a(p_71516_2_, MinecraftServer.func_71276_C().func_71213_z()); 
/*     */       } else {
/* 580 */         if (p_71516_2_[1].equalsIgnoreCase("leave"))
/* 581 */           return func_71530_a(p_71516_2_, MinecraftServer.func_71276_C().func_71213_z()); 
/* 582 */         if (p_71516_2_[1].equalsIgnoreCase("empty") || p_71516_2_[1].equalsIgnoreCase("list") || p_71516_2_[1].equalsIgnoreCase("remove")) {
/* 583 */           if (p_71516_2_.length == 3) {
/* 584 */             return func_71531_a(p_71516_2_, func_147192_d().func_96531_f());
/*     */           }
/* 586 */         } else if (p_71516_2_[1].equalsIgnoreCase("option")) {
/* 587 */           if (p_71516_2_.length == 3)
/* 588 */             return func_71531_a(p_71516_2_, func_147192_d().func_96531_f()); 
/* 589 */           if (p_71516_2_.length == 4)
/* 590 */             return func_71530_a(p_71516_2_, new String[] { "color", "friendlyfire", "seeFriendlyInvisibles" }); 
/* 591 */           if (p_71516_2_.length == 5) {
/* 592 */             if (p_71516_2_[3].equalsIgnoreCase("color"))
/* 593 */               return func_71531_a(p_71516_2_, EnumChatFormatting.func_96296_a(true, false)); 
/* 594 */             if (p_71516_2_[3].equalsIgnoreCase("friendlyfire") || p_71516_2_[3].equalsIgnoreCase("seeFriendlyInvisibles")) {
/* 595 */               return func_71530_a(p_71516_2_, new String[] { "true", "false" });
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 601 */     return null;
/*     */   }
/*     */   
/*     */   protected List func_147184_a(boolean p_147184_1_) {
/* 605 */     Collection collection = func_147192_d().func_96514_c();
/* 606 */     ArrayList<String> arrayList = new ArrayList();
/*     */     
/* 608 */     for (ScoreObjective scoreObjective : collection) {
/* 609 */       if (!p_147184_1_ || !scoreObjective.func_96680_c().func_96637_b()) arrayList.add(scoreObjective.func_96679_b());
/*     */     
/*     */     } 
/* 612 */     return arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_82358_a(String[] p_82358_1_, int p_82358_2_) {
/* 617 */     if (p_82358_1_[0].equalsIgnoreCase("players"))
/* 618 */       return (p_82358_2_ == 2); 
/* 619 */     if (p_82358_1_[0].equalsIgnoreCase("teams")) {
/* 620 */       return (p_82358_2_ == 2 || p_82358_2_ == 3);
/*     */     }
/*     */     
/* 623 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\command\server\CommandScoreboard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */