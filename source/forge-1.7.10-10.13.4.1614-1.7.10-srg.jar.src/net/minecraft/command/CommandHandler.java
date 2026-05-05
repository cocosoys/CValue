/*     */ package net.minecraft.command;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.util.ChatComponentTranslation;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ import net.minecraft.util.IChatComponent;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ 
/*     */ public class CommandHandler implements ICommandManager {
/*  15 */   private static final Logger field_147175_a = LogManager.getLogger();
/*  16 */   private final Map field_71562_a = new HashMap<Object, Object>();
/*  17 */   private final Set field_71561_b = new HashSet();
/*     */   private static final String __OBFID = "CL_00001765";
/*     */   
/*     */   public int func_71556_a(ICommandSender p_71556_1_, String p_71556_2_) {
/*  21 */     p_71556_2_ = p_71556_2_.trim();
/*  22 */     if (p_71556_2_.startsWith("/")) p_71556_2_ = p_71556_2_.substring(1);
/*     */     
/*  24 */     String[] arrayOfString = p_71556_2_.split(" ");
/*  25 */     String str = arrayOfString[0];
/*     */     
/*  27 */     arrayOfString = func_71559_a(arrayOfString);
/*     */     
/*  29 */     ICommand iCommand = (ICommand)this.field_71562_a.get(str);
/*  30 */     int i = func_82370_a(iCommand, arrayOfString);
/*  31 */     byte b = 0;
/*     */     
/*     */     try {
/*  34 */       if (iCommand == null) {
/*  35 */         throw new CommandNotFoundException();
/*     */       }
/*  37 */       if (iCommand.func_71519_b(p_71556_1_)) {
/*  38 */         if (i > -1) {
/*     */           
/*  40 */           EntityPlayerMP[] arrayOfEntityPlayerMP = PlayerSelector.func_82380_c(p_71556_1_, arrayOfString[i]);
/*  41 */           String str1 = arrayOfString[i];
/*     */           
/*  43 */           for (EntityPlayerMP entityPlayerMP : arrayOfEntityPlayerMP) {
/*  44 */             arrayOfString[i] = entityPlayerMP.func_70005_c_();
/*     */             
/*     */             try {
/*  47 */               iCommand.func_71515_b(p_71556_1_, arrayOfString);
/*  48 */               b++;
/*  49 */             } catch (CommandException commandException) {
/*  50 */               ChatComponentTranslation chatComponentTranslation = new ChatComponentTranslation(commandException.getMessage(), commandException.func_74844_a());
/*  51 */               chatComponentTranslation.func_150256_b().func_150238_a(EnumChatFormatting.RED);
/*  52 */               p_71556_1_.func_145747_a((IChatComponent)chatComponentTranslation);
/*     */             } 
/*     */           } 
/*     */           
/*  56 */           arrayOfString[i] = str1;
/*     */         } else {
/*     */           try {
/*  59 */             iCommand.func_71515_b(p_71556_1_, arrayOfString);
/*  60 */             b++;
/*  61 */           } catch (CommandException commandException) {
/*  62 */             ChatComponentTranslation chatComponentTranslation = new ChatComponentTranslation(commandException.getMessage(), commandException.func_74844_a());
/*  63 */             chatComponentTranslation.func_150256_b().func_150238_a(EnumChatFormatting.RED);
/*  64 */             p_71556_1_.func_145747_a((IChatComponent)chatComponentTranslation);
/*     */           } 
/*     */         } 
/*     */       } else {
/*  68 */         ChatComponentTranslation chatComponentTranslation = new ChatComponentTranslation("commands.generic.permission", new Object[0]);
/*  69 */         chatComponentTranslation.func_150256_b().func_150238_a(EnumChatFormatting.RED);
/*  70 */         p_71556_1_.func_145747_a((IChatComponent)chatComponentTranslation);
/*     */       }
/*     */     
/*  73 */     } catch (WrongUsageException wrongUsageException) {
/*  74 */       ChatComponentTranslation chatComponentTranslation = new ChatComponentTranslation("commands.generic.usage", new Object[] { new ChatComponentTranslation(wrongUsageException.getMessage(), wrongUsageException.func_74844_a()) });
/*  75 */       chatComponentTranslation.func_150256_b().func_150238_a(EnumChatFormatting.RED);
/*  76 */       p_71556_1_.func_145747_a((IChatComponent)chatComponentTranslation);
/*  77 */     } catch (CommandException commandException) {
/*  78 */       ChatComponentTranslation chatComponentTranslation = new ChatComponentTranslation(commandException.getMessage(), commandException.func_74844_a());
/*  79 */       chatComponentTranslation.func_150256_b().func_150238_a(EnumChatFormatting.RED);
/*  80 */       p_71556_1_.func_145747_a((IChatComponent)chatComponentTranslation);
/*  81 */     } catch (Throwable throwable) {
/*  82 */       ChatComponentTranslation chatComponentTranslation = new ChatComponentTranslation("commands.generic.exception", new Object[0]);
/*  83 */       chatComponentTranslation.func_150256_b().func_150238_a(EnumChatFormatting.RED);
/*  84 */       p_71556_1_.func_145747_a((IChatComponent)chatComponentTranslation);
/*  85 */       field_147175_a.error("Couldn't process command: '" + p_71556_2_ + "'", throwable);
/*     */     } 
/*     */     
/*  88 */     return b;
/*     */   }
/*     */   
/*     */   public ICommand func_71560_a(ICommand p_71560_1_) {
/*  92 */     List list = p_71560_1_.func_71514_a();
/*     */     
/*  94 */     this.field_71562_a.put(p_71560_1_.func_71517_b(), p_71560_1_);
/*  95 */     this.field_71561_b.add(p_71560_1_);
/*     */     
/*  97 */     if (list != null) {
/*  98 */       for (String str : list) {
/*  99 */         ICommand iCommand = (ICommand)this.field_71562_a.get(str);
/*     */         
/* 101 */         if (iCommand == null || !iCommand.func_71517_b().equals(str)) {
/* 102 */           this.field_71562_a.put(str, p_71560_1_);
/*     */         }
/*     */       } 
/*     */     }
/*     */     
/* 107 */     return p_71560_1_;
/*     */   }
/*     */   
/*     */   private static String[] func_71559_a(String[] p_71559_0_) {
/* 111 */     String[] arrayOfString = new String[p_71559_0_.length - 1];
/*     */     
/* 113 */     for (byte b = 1; b < p_71559_0_.length; b++) {
/* 114 */       arrayOfString[b - 1] = p_71559_0_[b];
/*     */     }
/*     */     
/* 117 */     return arrayOfString;
/*     */   }
/*     */ 
/*     */   
/*     */   public List func_71558_b(ICommandSender p_71558_1_, String p_71558_2_) {
/* 122 */     String[] arrayOfString = p_71558_2_.split(" ", -1);
/* 123 */     String str = arrayOfString[0];
/*     */     
/* 125 */     if (arrayOfString.length == 1) {
/*     */       
/* 127 */       ArrayList arrayList = new ArrayList();
/*     */       
/* 129 */       for (Map.Entry entry : this.field_71562_a.entrySet()) {
/* 130 */         if (CommandBase.func_71523_a(str, (String)entry.getKey()) && ((ICommand)entry.getValue()).func_71519_b(p_71558_1_)) {
/* 131 */           arrayList.add(entry.getKey());
/*     */         }
/*     */       } 
/*     */       
/* 135 */       return arrayList;
/* 136 */     }  if (arrayOfString.length > 1) {
/*     */ 
/*     */       
/* 139 */       ICommand iCommand = (ICommand)this.field_71562_a.get(str);
/*     */       
/* 141 */       if (iCommand != null) {
/* 142 */         return iCommand.func_71516_a(p_71558_1_, func_71559_a(arrayOfString));
/*     */       }
/*     */     } 
/*     */     
/* 146 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public List func_71557_a(ICommandSender p_71557_1_) {
/* 151 */     ArrayList<ICommand> arrayList = new ArrayList();
/*     */     
/* 153 */     for (ICommand iCommand : this.field_71561_b) {
/* 154 */       if (iCommand.func_71519_b(p_71557_1_)) {
/* 155 */         arrayList.add(iCommand);
/*     */       }
/*     */     } 
/*     */     
/* 159 */     return arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   public Map func_71555_a() {
/* 164 */     return this.field_71562_a;
/*     */   }
/*     */   
/*     */   private int func_82370_a(ICommand p_82370_1_, String[] p_82370_2_) {
/* 168 */     if (p_82370_1_ == null) {
/* 169 */       return -1;
/*     */     }
/*     */     
/* 172 */     for (byte b = 0; b < p_82370_2_.length; b++) {
/* 173 */       if (p_82370_1_.func_82358_a(p_82370_2_, b) && PlayerSelector.func_82377_a(p_82370_2_[b])) {
/* 174 */         return b;
/*     */       }
/*     */     } 
/*     */     
/* 178 */     return -1;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\command\CommandHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */