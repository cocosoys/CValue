/*    */ package net.minecraft.command;
/*    */ 
/*    */ import java.util.List;
/*    */ import net.minecraft.enchantment.Enchantment;
/*    */ import net.minecraft.entity.player.EntityPlayerMP;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.nbt.NBTTagList;
/*    */ import net.minecraft.server.MinecraftServer;
/*    */ 
/*    */ public class CommandEnchant
/*    */   extends CommandBase
/*    */ {
/*    */   private static final String __OBFID = "CL_00000377";
/*    */   
/*    */   public String func_71517_b() {
/* 16 */     return "enchant";
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_82362_a() {
/* 21 */     return 2;
/*    */   }
/*    */ 
/*    */   
/*    */   public String func_71518_a(ICommandSender p_71518_1_) {
/* 26 */     return "commands.enchant.usage";
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
/* 31 */     if (p_71515_2_.length >= 2) {
/* 32 */       EntityPlayerMP entityPlayerMP = func_82359_c(p_71515_1_, p_71515_2_[0]);
/*    */       
/* 34 */       int i = func_71532_a(p_71515_1_, p_71515_2_[1], 0, Enchantment.field_77331_b.length - 1);
/* 35 */       int j = 1;
/*    */       
/* 37 */       ItemStack itemStack = entityPlayerMP.func_71045_bC();
/* 38 */       if (itemStack == null) {
/* 39 */         throw new CommandException("commands.enchant.noItem", new Object[0]);
/*    */       }
/*    */       
/* 42 */       Enchantment enchantment = Enchantment.field_77331_b[i];
/* 43 */       if (enchantment == null) {
/* 44 */         throw new NumberInvalidException("commands.enchant.notFound", new Object[] { Integer.valueOf(i) });
/*    */       }
/*    */       
/* 47 */       if (!enchantment.func_92089_a(itemStack)) {
/* 48 */         throw new CommandException("commands.enchant.cantEnchant", new Object[0]);
/*    */       }
/*    */       
/* 51 */       if (p_71515_2_.length >= 3) {
/* 52 */         j = func_71532_a(p_71515_1_, p_71515_2_[2], enchantment.func_77319_d(), enchantment.func_77325_b());
/*    */       }
/*    */       
/* 55 */       if (itemStack.func_77942_o()) {
/* 56 */         NBTTagList nBTTagList = itemStack.func_77986_q();
/* 57 */         if (nBTTagList != null) {
/* 58 */           for (byte b = 0; b < nBTTagList.func_74745_c(); b++) {
/* 59 */             short s = nBTTagList.func_150305_b(b).func_74765_d("id");
/*    */             
/* 61 */             if (Enchantment.field_77331_b[s] != null) {
/* 62 */               Enchantment enchantment1 = Enchantment.field_77331_b[s];
/* 63 */               if (!enchantment1.func_77326_a(enchantment)) {
/* 64 */                 throw new CommandException("commands.enchant.cantCombine", new Object[] { enchantment.func_77316_c(j), enchantment1.func_77316_c(nBTTagList.func_150305_b(b).func_74765_d("lvl")) });
/*    */               }
/*    */             } 
/*    */           } 
/*    */         }
/*    */       } 
/*    */ 
/*    */       
/* 72 */       itemStack.func_77966_a(enchantment, j);
/*    */       
/* 74 */       func_152373_a(p_71515_1_, this, "commands.enchant.success", new Object[0]);
/*    */       
/*    */       return;
/*    */     } 
/* 78 */     throw new WrongUsageException("commands.enchant.usage", new Object[0]);
/*    */   }
/*    */ 
/*    */   
/*    */   public List func_71516_a(ICommandSender p_71516_1_, String[] p_71516_2_) {
/* 83 */     if (p_71516_2_.length == 1) {
/* 84 */       return func_71530_a(p_71516_2_, func_90022_d());
/*    */     }
/*    */     
/* 87 */     return null;
/*    */   }
/*    */   
/*    */   protected String[] func_90022_d() {
/* 91 */     return MinecraftServer.func_71276_C().func_71213_z();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_82358_a(String[] p_82358_1_, int p_82358_2_) {
/* 96 */     return (p_82358_2_ == 0);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\command\CommandEnchant.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */