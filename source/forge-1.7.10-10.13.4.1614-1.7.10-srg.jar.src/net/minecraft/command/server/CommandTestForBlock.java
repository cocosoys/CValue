/*     */ package net.minecraft.command.server;
/*     */ 
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.command.CommandBase;
/*     */ import net.minecraft.command.CommandException;
/*     */ import net.minecraft.command.ICommandSender;
/*     */ import net.minecraft.command.NumberInvalidException;
/*     */ import net.minecraft.command.WrongUsageException;
/*     */ import net.minecraft.nbt.JsonToNBT;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTException;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.ChatComponentTranslation;
/*     */ import net.minecraft.util.IChatComponent;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class CommandTestForBlock extends CommandBase {
/*     */   private static final String __OBFID = "CL_00001181";
/*     */   
/*     */   public String func_71517_b() {
/*  24 */     return "testforblock";
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_82362_a() {
/*  29 */     return 2;
/*     */   }
/*     */ 
/*     */   
/*     */   public String func_71518_a(ICommandSender p_71518_1_) {
/*  34 */     return "commands.testforblock.usage";
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
/*  39 */     if (p_71515_2_.length >= 4) {
/*  40 */       int i = (p_71515_1_.func_82114_b()).field_71574_a;
/*  41 */       int j = (p_71515_1_.func_82114_b()).field_71572_b;
/*  42 */       int k = (p_71515_1_.func_82114_b()).field_71573_c;
/*  43 */       i = MathHelper.func_76128_c(func_110666_a(p_71515_1_, i, p_71515_2_[0]));
/*  44 */       j = MathHelper.func_76128_c(func_110666_a(p_71515_1_, j, p_71515_2_[1]));
/*  45 */       k = MathHelper.func_76128_c(func_110666_a(p_71515_1_, k, p_71515_2_[2]));
/*     */       
/*  47 */       Block block1 = Block.func_149684_b(p_71515_2_[3]);
/*  48 */       if (block1 == null) {
/*  49 */         throw new NumberInvalidException("commands.setblock.notFound", new Object[] { p_71515_2_[3] });
/*     */       }
/*     */       
/*  52 */       int m = -1;
/*  53 */       if (p_71515_2_.length >= 5) {
/*  54 */         m = func_71532_a(p_71515_1_, p_71515_2_[4], -1, 15);
/*     */       }
/*     */       
/*  57 */       World world = p_71515_1_.func_130014_f_();
/*  58 */       if (!world.func_72899_e(i, j, k)) {
/*  59 */         throw new CommandException("commands.testforblock.outOfWorld", new Object[0]);
/*     */       }
/*     */       
/*  62 */       NBTTagCompound nBTTagCompound = new NBTTagCompound();
/*  63 */       boolean bool = false;
/*  64 */       if (p_71515_2_.length >= 6 && block1.func_149716_u()) {
/*  65 */         String str = func_147178_a(p_71515_1_, p_71515_2_, 5).func_150260_c();
/*     */         try {
/*  67 */           NBTBase nBTBase = JsonToNBT.func_150315_a(str);
/*  68 */           if (nBTBase instanceof NBTTagCompound) {
/*  69 */             nBTTagCompound = (NBTTagCompound)nBTBase;
/*  70 */             bool = true;
/*     */           } else {
/*  72 */             throw new CommandException("commands.setblock.tagError", new Object[] { "Not a valid tag" });
/*     */           } 
/*  74 */         } catch (NBTException nBTException) {
/*  75 */           throw new CommandException("commands.setblock.tagError", new Object[] { nBTException.getMessage() });
/*     */         } 
/*     */       } 
/*     */       
/*  79 */       Block block2 = world.func_147439_a(i, j, k);
/*  80 */       if (block2 != block1) {
/*  81 */         throw new CommandException("commands.testforblock.failed.tile", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), block2.func_149732_F(), block1.func_149732_F() });
/*     */       }
/*     */       
/*  84 */       if (m > -1) {
/*  85 */         int n = world.func_72805_g(i, j, k);
/*  86 */         if (n != m) {
/*  87 */           throw new CommandException("commands.testforblock.failed.data", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(n), Integer.valueOf(m) });
/*     */         }
/*     */       } 
/*     */       
/*  91 */       if (bool) {
/*  92 */         TileEntity tileEntity = world.func_147438_o(i, j, k);
/*  93 */         if (tileEntity == null) {
/*  94 */           throw new CommandException("commands.testforblock.failed.tileEntity", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
/*     */         }
/*  96 */         NBTTagCompound nBTTagCompound1 = new NBTTagCompound();
/*  97 */         tileEntity.func_145841_b(nBTTagCompound1);
/*     */         
/*  99 */         if (!func_147181_a((NBTBase)nBTTagCompound, (NBTBase)nBTTagCompound1)) {
/* 100 */           throw new CommandException("commands.testforblock.failed.nbt", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
/*     */         }
/*     */       } 
/*     */       
/* 104 */       p_71515_1_.func_145747_a((IChatComponent)new ChatComponentTranslation("commands.testforblock.success", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) }));
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 109 */     throw new WrongUsageException("commands.testforblock.usage", new Object[0]);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_147181_a(NBTBase p_147181_1_, NBTBase p_147181_2_) {
/* 114 */     if (p_147181_1_ == p_147181_2_) return true; 
/* 115 */     if (p_147181_1_ == null) return true; 
/* 116 */     if (p_147181_2_ == null) return false; 
/* 117 */     if (!p_147181_1_.getClass().equals(p_147181_2_.getClass())) return false;
/*     */     
/* 119 */     if (p_147181_1_ instanceof NBTTagCompound) {
/* 120 */       NBTTagCompound nBTTagCompound1 = (NBTTagCompound)p_147181_1_;
/* 121 */       NBTTagCompound nBTTagCompound2 = (NBTTagCompound)p_147181_2_;
/*     */       
/* 123 */       for (String str : nBTTagCompound1.func_150296_c()) {
/* 124 */         NBTBase nBTBase = nBTTagCompound1.func_74781_a(str);
/* 125 */         if (!func_147181_a(nBTBase, nBTTagCompound2.func_74781_a(str))) return false;
/*     */       
/*     */       } 
/* 128 */       return true;
/*     */     } 
/* 130 */     return p_147181_1_.equals(p_147181_2_);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List func_71516_a(ICommandSender p_71516_1_, String[] p_71516_2_) {
/* 136 */     if (p_71516_2_.length == 4) {
/* 137 */       return func_71531_a(p_71516_2_, Block.field_149771_c.func_148742_b());
/*     */     }
/*     */     
/* 140 */     return null;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\command\server\CommandTestForBlock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */