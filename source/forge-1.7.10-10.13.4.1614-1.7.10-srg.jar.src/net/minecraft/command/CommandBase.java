/*     */ package net.minecraft.command;
/*     */ 
/*     */ import com.google.common.primitives.Doubles;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import net.minecraft.util.ChatComponentText;
/*     */ import net.minecraft.util.ChatComponentTranslation;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ import net.minecraft.util.IChatComponent;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class CommandBase
/*     */   implements ICommand
/*     */ {
/*     */   private static IAdminCommand field_71533_a;
/*     */   private static final String __OBFID = "CL_00001739";
/*     */   
/*     */   public int func_82362_a() {
/*  27 */     return 4;
/*     */   }
/*     */ 
/*     */   
/*     */   public List func_71514_a() {
/*  32 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_71519_b(ICommandSender p_71519_1_) {
/*  37 */     return p_71519_1_.func_70003_b(func_82362_a(), func_71517_b());
/*     */   }
/*     */ 
/*     */   
/*     */   public List func_71516_a(ICommandSender p_71516_1_, String[] p_71516_2_) {
/*  42 */     return null;
/*     */   }
/*     */   
/*     */   public static int func_71526_a(ICommandSender p_71526_0_, String p_71526_1_) {
/*     */     try {
/*  47 */       return Integer.parseInt(p_71526_1_);
/*  48 */     } catch (NumberFormatException numberFormatException) {
/*  49 */       throw new NumberInvalidException("commands.generic.num.invalid", new Object[] { p_71526_1_ });
/*     */     } 
/*     */   }
/*     */   
/*     */   public static int func_71528_a(ICommandSender p_71528_0_, String p_71528_1_, int p_71528_2_) {
/*  54 */     return func_71532_a(p_71528_0_, p_71528_1_, p_71528_2_, 2147483647);
/*     */   }
/*     */   
/*     */   public static int func_71532_a(ICommandSender p_71532_0_, String p_71532_1_, int p_71532_2_, int p_71532_3_) {
/*  58 */     int i = func_71526_a(p_71532_0_, p_71532_1_);
/*     */     
/*  60 */     if (i < p_71532_2_)
/*  61 */       throw new NumberInvalidException("commands.generic.num.tooSmall", new Object[] { Integer.valueOf(i), Integer.valueOf(p_71532_2_) }); 
/*  62 */     if (i > p_71532_3_) {
/*  63 */       throw new NumberInvalidException("commands.generic.num.tooBig", new Object[] { Integer.valueOf(i), Integer.valueOf(p_71532_3_) });
/*     */     }
/*     */     
/*  66 */     return i;
/*     */   }
/*     */   
/*     */   public static double func_82363_b(ICommandSender p_82363_0_, String p_82363_1_) {
/*     */     try {
/*  71 */       double d = Double.parseDouble(p_82363_1_);
/*  72 */       if (!Doubles.isFinite(d)) throw new NumberInvalidException("commands.generic.num.invalid", new Object[] { p_82363_1_ }); 
/*  73 */       return d;
/*  74 */     } catch (NumberFormatException numberFormatException) {
/*  75 */       throw new NumberInvalidException("commands.generic.num.invalid", new Object[] { p_82363_1_ });
/*     */     } 
/*     */   }
/*     */   
/*     */   public static double func_110664_a(ICommandSender p_110664_0_, String p_110664_1_, double p_110664_2_) {
/*  80 */     return func_110661_a(p_110664_0_, p_110664_1_, p_110664_2_, Double.MAX_VALUE);
/*     */   }
/*     */   
/*     */   public static double func_110661_a(ICommandSender p_110661_0_, String p_110661_1_, double p_110661_2_, double p_110661_4_) {
/*  84 */     double d = func_82363_b(p_110661_0_, p_110661_1_);
/*     */     
/*  86 */     if (d < p_110661_2_)
/*  87 */       throw new NumberInvalidException("commands.generic.double.tooSmall", new Object[] { Double.valueOf(d), Double.valueOf(p_110661_2_) }); 
/*  88 */     if (d > p_110661_4_) {
/*  89 */       throw new NumberInvalidException("commands.generic.double.tooBig", new Object[] { Double.valueOf(d), Double.valueOf(p_110661_4_) });
/*     */     }
/*     */     
/*  92 */     return d;
/*     */   }
/*     */   
/*     */   public static boolean func_110662_c(ICommandSender p_110662_0_, String p_110662_1_) {
/*  96 */     if (p_110662_1_.equals("true") || p_110662_1_.equals("1"))
/*  97 */       return true; 
/*  98 */     if (p_110662_1_.equals("false") || p_110662_1_.equals("0")) {
/*  99 */       return false;
/*     */     }
/* 101 */     throw new CommandException("commands.generic.boolean.invalid", new Object[] { p_110662_1_ });
/*     */   }
/*     */ 
/*     */   
/*     */   public static EntityPlayerMP func_71521_c(ICommandSender p_71521_0_) {
/* 106 */     if (p_71521_0_ instanceof EntityPlayerMP) {
/* 107 */       return (EntityPlayerMP)p_71521_0_;
/*     */     }
/* 109 */     throw new PlayerNotFoundException("You must specify which player you wish to perform this action on.", new Object[0]);
/*     */   }
/*     */ 
/*     */   
/*     */   public static EntityPlayerMP func_82359_c(ICommandSender p_82359_0_, String p_82359_1_) {
/* 114 */     EntityPlayerMP entityPlayerMP = PlayerSelector.func_82386_a(p_82359_0_, p_82359_1_);
/* 115 */     if (entityPlayerMP != null) return entityPlayerMP;
/*     */     
/* 117 */     entityPlayerMP = MinecraftServer.func_71276_C().func_71203_ab().func_152612_a(p_82359_1_);
/*     */     
/* 119 */     if (entityPlayerMP == null) {
/* 120 */       throw new PlayerNotFoundException();
/*     */     }
/* 122 */     return entityPlayerMP;
/*     */   }
/*     */ 
/*     */   
/*     */   public static String func_96332_d(ICommandSender p_96332_0_, String p_96332_1_) {
/* 127 */     EntityPlayerMP entityPlayerMP = PlayerSelector.func_82386_a(p_96332_0_, p_96332_1_);
/*     */     
/* 129 */     if (entityPlayerMP != null)
/* 130 */       return entityPlayerMP.func_70005_c_(); 
/* 131 */     if (PlayerSelector.func_82378_b(p_96332_1_)) {
/* 132 */       throw new PlayerNotFoundException();
/*     */     }
/*     */     
/* 135 */     return p_96332_1_;
/*     */   }
/*     */   
/*     */   public static IChatComponent func_147178_a(ICommandSender p_147178_0_, String[] p_147178_1_, int p_147178_2_) {
/* 139 */     return func_147176_a(p_147178_0_, p_147178_1_, p_147178_2_, false);
/*     */   }
/*     */   
/*     */   public static IChatComponent func_147176_a(ICommandSender p_147176_0_, String[] p_147176_1_, int p_147176_2_, boolean p_147176_3_) {
/* 143 */     ChatComponentText chatComponentText = new ChatComponentText("");
/*     */     
/* 145 */     for (int i = p_147176_2_; i < p_147176_1_.length; i++) {
/* 146 */       IChatComponent iChatComponent; if (i > p_147176_2_) chatComponentText.func_150258_a(" "); 
/* 147 */       ChatComponentText chatComponentText1 = new ChatComponentText(p_147176_1_[i]);
/*     */       
/* 149 */       if (p_147176_3_) {
/* 150 */         IChatComponent iChatComponent1 = PlayerSelector.func_150869_b(p_147176_0_, p_147176_1_[i]);
/*     */         
/* 152 */         if (iChatComponent1 != null) {
/* 153 */           iChatComponent = iChatComponent1;
/* 154 */         } else if (PlayerSelector.func_82378_b(p_147176_1_[i])) {
/* 155 */           throw new PlayerNotFoundException();
/*     */         } 
/*     */       } 
/*     */       
/* 159 */       chatComponentText.func_150257_a(iChatComponent);
/*     */     } 
/*     */     
/* 162 */     return (IChatComponent)chatComponentText;
/*     */   }
/*     */   
/*     */   public static String func_82360_a(ICommandSender p_82360_0_, String[] p_82360_1_, int p_82360_2_) {
/* 166 */     StringBuilder stringBuilder = new StringBuilder();
/*     */     
/* 168 */     for (int i = p_82360_2_; i < p_82360_1_.length; i++) {
/* 169 */       if (i > p_82360_2_) stringBuilder.append(" "); 
/* 170 */       String str = p_82360_1_[i];
/*     */       
/* 172 */       stringBuilder.append(str);
/*     */     } 
/*     */     
/* 175 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   public static double func_110666_a(ICommandSender p_110666_0_, double p_110666_1_, String p_110666_3_) {
/* 179 */     return func_110665_a(p_110666_0_, p_110666_1_, p_110666_3_, -30000000, 30000000);
/*     */   }
/*     */   
/*     */   public static double func_110665_a(ICommandSender p_110665_0_, double p_110665_1_, String p_110665_3_, int p_110665_4_, int p_110665_5_) {
/* 183 */     boolean bool = p_110665_3_.startsWith("~");
/* 184 */     if (bool && Double.isNaN(p_110665_1_)) throw new NumberInvalidException("commands.generic.num.invalid", new Object[] { Double.valueOf(p_110665_1_) }); 
/* 185 */     double d = bool ? p_110665_1_ : 0.0D;
/*     */     
/* 187 */     if (!bool || p_110665_3_.length() > 1) {
/* 188 */       boolean bool1 = p_110665_3_.contains(".");
/* 189 */       if (bool) p_110665_3_ = p_110665_3_.substring(1);
/*     */       
/* 191 */       d += func_82363_b(p_110665_0_, p_110665_3_);
/*     */       
/* 193 */       if (!bool1 && !bool) {
/* 194 */         d += 0.5D;
/*     */       }
/*     */     } 
/*     */     
/* 198 */     if (p_110665_4_ != 0 || p_110665_5_ != 0) {
/* 199 */       if (d < p_110665_4_)
/* 200 */         throw new NumberInvalidException("commands.generic.double.tooSmall", new Object[] { Double.valueOf(d), Integer.valueOf(p_110665_4_) }); 
/* 201 */       if (d > p_110665_5_) {
/* 202 */         throw new NumberInvalidException("commands.generic.double.tooBig", new Object[] { Double.valueOf(d), Integer.valueOf(p_110665_5_) });
/*     */       }
/*     */     } 
/*     */     
/* 206 */     return d;
/*     */   }
/*     */   
/*     */   public static Item func_147179_f(ICommandSender p_147179_0_, String p_147179_1_) {
/* 210 */     Item item = (Item)Item.field_150901_e.func_82594_a(p_147179_1_);
/*     */     
/* 212 */     if (item == null) {
/*     */       try {
/* 214 */         Item item1 = Item.func_150899_d(Integer.parseInt(p_147179_1_));
/*     */         
/* 216 */         if (item1 != null) {
/* 217 */           ChatComponentTranslation chatComponentTranslation = new ChatComponentTranslation("commands.generic.deprecatedId", new Object[] { Item.field_150901_e.func_148750_c(item1) });
/* 218 */           chatComponentTranslation.func_150256_b().func_150238_a(EnumChatFormatting.GRAY);
/* 219 */           p_147179_0_.func_145747_a((IChatComponent)chatComponentTranslation);
/*     */         } 
/*     */         
/* 222 */         item = item1;
/* 223 */       } catch (NumberFormatException numberFormatException) {}
/*     */     }
/*     */ 
/*     */     
/* 227 */     if (item == null) {
/* 228 */       throw new NumberInvalidException("commands.give.notFound", new Object[] { p_147179_1_ });
/*     */     }
/*     */     
/* 231 */     return item;
/*     */   }
/*     */   
/*     */   public static Block func_147180_g(ICommandSender p_147180_0_, String p_147180_1_) {
/* 235 */     if (Block.field_149771_c.func_148741_d(p_147180_1_)) {
/* 236 */       return (Block)Block.field_149771_c.func_82594_a(p_147180_1_);
/*     */     }
/*     */     
/*     */     try {
/* 240 */       int i = Integer.parseInt(p_147180_1_);
/*     */       
/* 242 */       if (Block.field_149771_c.func_148753_b(i)) {
/* 243 */         Block block = Block.func_149729_e(i);
/*     */         
/* 245 */         ChatComponentTranslation chatComponentTranslation = new ChatComponentTranslation("commands.generic.deprecatedId", new Object[] { Block.field_149771_c.func_148750_c(block) });
/* 246 */         chatComponentTranslation.func_150256_b().func_150238_a(EnumChatFormatting.GRAY);
/* 247 */         p_147180_0_.func_145747_a((IChatComponent)chatComponentTranslation);
/*     */         
/* 249 */         return block;
/*     */       } 
/* 251 */     } catch (NumberFormatException numberFormatException) {}
/*     */ 
/*     */     
/* 254 */     throw new NumberInvalidException("commands.give.notFound", new Object[] { p_147180_1_ });
/*     */   }
/*     */   
/*     */   public static String func_71527_a(Object[] p_71527_0_) {
/* 258 */     StringBuilder stringBuilder = new StringBuilder();
/*     */     
/* 260 */     for (byte b = 0; b < p_71527_0_.length; b++) {
/* 261 */       String str = p_71527_0_[b].toString();
/*     */       
/* 263 */       if (b > 0) {
/* 264 */         if (b == p_71527_0_.length - 1) {
/* 265 */           stringBuilder.append(" and ");
/*     */         } else {
/* 267 */           stringBuilder.append(", ");
/*     */         } 
/*     */       }
/*     */       
/* 271 */       stringBuilder.append(str);
/*     */     } 
/*     */     
/* 274 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   public static IChatComponent func_147177_a(IChatComponent[] p_147177_0_) {
/* 278 */     ChatComponentText chatComponentText = new ChatComponentText("");
/*     */     
/* 280 */     for (byte b = 0; b < p_147177_0_.length; b++) {
/* 281 */       if (b > 0) {
/* 282 */         if (b == p_147177_0_.length - 1) {
/* 283 */           chatComponentText.func_150258_a(" and ");
/* 284 */         } else if (b > 0) {
/* 285 */           chatComponentText.func_150258_a(", ");
/*     */         } 
/*     */       }
/*     */       
/* 289 */       chatComponentText.func_150257_a(p_147177_0_[b]);
/*     */     } 
/*     */     
/* 292 */     return (IChatComponent)chatComponentText;
/*     */   }
/*     */   
/*     */   public static String func_96333_a(Collection p_96333_0_) {
/* 296 */     return func_71527_a(p_96333_0_.toArray((Object[])new String[p_96333_0_.size()]));
/*     */   }
/*     */   
/*     */   public static boolean func_71523_a(String p_71523_0_, String p_71523_1_) {
/* 300 */     return p_71523_1_.regionMatches(true, 0, p_71523_0_, 0, p_71523_0_.length());
/*     */   }
/*     */   
/*     */   public static List func_71530_a(String[] p_71530_0_, String... p_71530_1_) {
/* 304 */     String str = p_71530_0_[p_71530_0_.length - 1];
/* 305 */     ArrayList<String> arrayList = new ArrayList();
/*     */     
/* 307 */     for (String str1 : p_71530_1_) {
/* 308 */       if (func_71523_a(str, str1)) {
/* 309 */         arrayList.add(str1);
/*     */       }
/*     */     } 
/*     */     
/* 313 */     return arrayList;
/*     */   }
/*     */   
/*     */   public static List func_71531_a(String[] p_71531_0_, Iterable p_71531_1_) {
/* 317 */     String str = p_71531_0_[p_71531_0_.length - 1];
/* 318 */     ArrayList<String> arrayList = new ArrayList();
/*     */     
/* 320 */     for (String str1 : p_71531_1_) {
/* 321 */       if (func_71523_a(str, str1)) {
/* 322 */         arrayList.add(str1);
/*     */       }
/*     */     } 
/*     */     
/* 326 */     return arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_82358_a(String[] p_82358_1_, int p_82358_2_) {
/* 331 */     return false;
/*     */   }
/*     */   
/*     */   public static void func_152373_a(ICommandSender p_152373_0_, ICommand p_152373_1_, String p_152373_2_, Object... p_152373_3_) {
/* 335 */     func_152374_a(p_152373_0_, p_152373_1_, 0, p_152373_2_, p_152373_3_);
/*     */   }
/*     */   
/*     */   public static void func_152374_a(ICommandSender p_152374_0_, ICommand p_152374_1_, int p_152374_2_, String p_152374_3_, Object... p_152374_4_) {
/* 339 */     if (field_71533_a != null) {
/* 340 */       field_71533_a.func_152372_a(p_152374_0_, p_152374_1_, p_152374_2_, p_152374_3_, p_152374_4_);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void func_71529_a(IAdminCommand p_71529_0_) {
/* 345 */     field_71533_a = p_71529_0_;
/*     */   }
/*     */ 
/*     */   
/*     */   public int compareTo(ICommand p_compareTo_1_) {
/* 350 */     return func_71517_b().compareTo(p_compareTo_1_.func_71517_b());
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\command\CommandBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */