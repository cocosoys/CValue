/*    */ package net.minecraft.command;
/*    */ 
/*    */ import java.util.List;
/*    */ import net.minecraft.entity.item.EntityItem;
/*    */ import net.minecraft.entity.player.EntityPlayerMP;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.nbt.JsonToNBT;
/*    */ import net.minecraft.nbt.NBTBase;
/*    */ import net.minecraft.nbt.NBTException;
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ import net.minecraft.server.MinecraftServer;
/*    */ 
/*    */ public class CommandGive extends CommandBase {
/*    */   public String func_71517_b() {
/* 16 */     return "give";
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_82362_a() {
/* 21 */     return 2;
/*    */   }
/*    */   private static final String __OBFID = "CL_00000502";
/*    */   
/*    */   public String func_71518_a(ICommandSender p_71518_1_) {
/* 26 */     return "commands.give.usage";
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
/* 31 */     if (p_71515_2_.length < 2) {
/* 32 */       throw new WrongUsageException("commands.give.usage", new Object[0]);
/*    */     }
/*    */     
/* 35 */     EntityPlayerMP entityPlayerMP = func_82359_c(p_71515_1_, p_71515_2_[0]);
/*    */     
/* 37 */     Item item = func_147179_f(p_71515_1_, p_71515_2_[1]);
/* 38 */     int i = 1;
/* 39 */     int j = 0;
/*    */     
/* 41 */     if (p_71515_2_.length >= 3) {
/* 42 */       i = func_71532_a(p_71515_1_, p_71515_2_[2], 1, 64);
/*    */     }
/*    */     
/* 45 */     if (p_71515_2_.length >= 4) {
/* 46 */       j = func_71526_a(p_71515_1_, p_71515_2_[3]);
/*    */     }
/*    */     
/* 49 */     ItemStack itemStack = new ItemStack(item, i, j);
/*    */     
/* 51 */     if (p_71515_2_.length >= 5) {
/* 52 */       String str = func_147178_a(p_71515_1_, p_71515_2_, 4).func_150260_c();
/*    */       try {
/* 54 */         NBTBase nBTBase = JsonToNBT.func_150315_a(str);
/* 55 */         if (nBTBase instanceof NBTTagCompound) {
/* 56 */           itemStack.func_77982_d((NBTTagCompound)nBTBase);
/*    */         } else {
/* 58 */           func_152373_a(p_71515_1_, this, "commands.give.tagError", new Object[] { "Not a valid tag" });
/*    */           return;
/*    */         } 
/* 61 */       } catch (NBTException nBTException) {
/* 62 */         func_152373_a(p_71515_1_, this, "commands.give.tagError", new Object[] { nBTException.getMessage() });
/*    */         
/*    */         return;
/*    */       } 
/*    */     } 
/* 67 */     EntityItem entityItem = entityPlayerMP.func_71019_a(itemStack, false);
/* 68 */     entityItem.field_145804_b = 0;
/* 69 */     entityItem.func_145797_a(entityPlayerMP.func_70005_c_());
/*    */     
/* 71 */     func_152373_a(p_71515_1_, this, "commands.give.success", new Object[] { itemStack.func_151000_E(), Integer.valueOf(i), entityPlayerMP.func_70005_c_() });
/*    */   }
/*    */ 
/*    */   
/*    */   public List func_71516_a(ICommandSender p_71516_1_, String[] p_71516_2_) {
/* 76 */     if (p_71516_2_.length == 1) {
/* 77 */       return func_71530_a(p_71516_2_, func_71536_c());
/*    */     }
/* 79 */     if (p_71516_2_.length == 2) {
/* 80 */       return func_71531_a(p_71516_2_, Item.field_150901_e.func_148742_b());
/*    */     }
/*    */     
/* 83 */     return null;
/*    */   }
/*    */   
/*    */   protected String[] func_71536_c() {
/* 87 */     return MinecraftServer.func_71276_C().func_71213_z();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_82358_a(String[] p_82358_1_, int p_82358_2_) {
/* 92 */     return (p_82358_2_ == 0);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\command\CommandGive.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */