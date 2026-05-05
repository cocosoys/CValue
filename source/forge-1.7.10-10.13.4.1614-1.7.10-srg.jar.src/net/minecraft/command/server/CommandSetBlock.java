/*     */ package net.minecraft.command.server;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.command.CommandBase;
/*     */ import net.minecraft.command.CommandException;
/*     */ import net.minecraft.command.ICommandSender;
/*     */ import net.minecraft.command.WrongUsageException;
/*     */ import net.minecraft.nbt.JsonToNBT;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTException;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class CommandSetBlock extends CommandBase {
/*     */   public String func_71517_b() {
/*  17 */     return "setblock";
/*     */   }
/*     */   private static final String __OBFID = "CL_00000949";
/*     */   
/*     */   public int func_82362_a() {
/*  22 */     return 2;
/*     */   }
/*     */ 
/*     */   
/*     */   public String func_71518_a(ICommandSender p_71518_1_) {
/*  27 */     return "commands.setblock.usage";
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
/*  32 */     if (p_71515_2_.length >= 4) {
/*     */       
/*  34 */       int i = (p_71515_1_.func_82114_b()).field_71574_a;
/*  35 */       int j = (p_71515_1_.func_82114_b()).field_71572_b;
/*  36 */       int k = (p_71515_1_.func_82114_b()).field_71573_c;
/*  37 */       i = MathHelper.func_76128_c(func_110666_a(p_71515_1_, i, p_71515_2_[0]));
/*  38 */       j = MathHelper.func_76128_c(func_110666_a(p_71515_1_, j, p_71515_2_[1]));
/*  39 */       k = MathHelper.func_76128_c(func_110666_a(p_71515_1_, k, p_71515_2_[2]));
/*     */       
/*  41 */       Block block = CommandBase.func_147180_g(p_71515_1_, p_71515_2_[3]);
/*     */       
/*  43 */       int m = 0;
/*  44 */       if (p_71515_2_.length >= 5) {
/*  45 */         m = func_71532_a(p_71515_1_, p_71515_2_[4], 0, 15);
/*     */       }
/*     */       
/*  48 */       World world = p_71515_1_.func_130014_f_();
/*  49 */       if (!world.func_72899_e(i, j, k)) {
/*  50 */         throw new CommandException("commands.setblock.outOfWorld", new Object[0]);
/*     */       }
/*     */       
/*  53 */       NBTTagCompound nBTTagCompound = new NBTTagCompound();
/*  54 */       boolean bool = false;
/*  55 */       if (p_71515_2_.length >= 7 && block.func_149716_u()) {
/*  56 */         String str = func_147178_a(p_71515_1_, p_71515_2_, 6).func_150260_c();
/*     */         try {
/*  58 */           NBTBase nBTBase = JsonToNBT.func_150315_a(str);
/*  59 */           if (nBTBase instanceof NBTTagCompound) {
/*  60 */             nBTTagCompound = (NBTTagCompound)nBTBase;
/*  61 */             bool = true;
/*     */           } else {
/*  63 */             throw new CommandException("commands.setblock.tagError", new Object[] { "Not a valid tag" });
/*     */           } 
/*  65 */         } catch (NBTException nBTException) {
/*  66 */           throw new CommandException("commands.setblock.tagError", new Object[] { nBTException.getMessage() });
/*     */         } 
/*     */       } 
/*     */       
/*  70 */       if (p_71515_2_.length >= 6) {
/*  71 */         if (p_71515_2_[5].equals("destroy")) {
/*  72 */           world.func_147480_a(i, j, k, true);
/*  73 */         } else if (p_71515_2_[5].equals("keep") && 
/*  74 */           !world.func_147437_c(i, j, k)) {
/*  75 */           throw new CommandException("commands.setblock.noChange", new Object[0]);
/*     */         } 
/*     */       }
/*     */ 
/*     */       
/*  80 */       if (!world.func_147465_d(i, j, k, block, m, 3)) {
/*  81 */         throw new CommandException("commands.setblock.noChange", new Object[0]);
/*     */       }
/*     */       
/*  84 */       if (bool) {
/*  85 */         TileEntity tileEntity = world.func_147438_o(i, j, k);
/*  86 */         if (tileEntity != null) {
/*     */           
/*  88 */           nBTTagCompound.func_74768_a("x", i);
/*  89 */           nBTTagCompound.func_74768_a("y", j);
/*  90 */           nBTTagCompound.func_74768_a("z", k);
/*     */           
/*  92 */           tileEntity.func_145839_a(nBTTagCompound);
/*     */         } 
/*     */       } 
/*  95 */       func_152373_a(p_71515_1_, (ICommand)this, "commands.setblock.success", new Object[0]);
/*     */       
/*     */       return;
/*     */     } 
/*  99 */     throw new WrongUsageException("commands.setblock.usage", new Object[0]);
/*     */   }
/*     */ 
/*     */   
/*     */   public List func_71516_a(ICommandSender p_71516_1_, String[] p_71516_2_) {
/* 104 */     if (p_71516_2_.length == 4) {
/* 105 */       return func_71531_a(p_71516_2_, Block.field_149771_c.func_148742_b());
/*     */     }
/* 107 */     if (p_71516_2_.length == 6) {
/* 108 */       return func_71530_a(p_71516_2_, new String[] { "replace", "destroy", "keep" });
/*     */     }
/*     */     
/* 111 */     return null;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\command\server\CommandSetBlock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */