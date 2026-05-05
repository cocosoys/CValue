/*     */ package net.minecraft.command.server;
/*     */ import net.minecraft.command.ICommand;
/*     */ import net.minecraft.command.ICommandSender;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityList;
/*     */ import net.minecraft.nbt.JsonToNBT;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTException;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.IChatComponent;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class CommandSummon extends CommandBase {
/*     */   public String func_71517_b() {
/*  15 */     return "summon";
/*     */   }
/*     */   private static final String __OBFID = "CL_00001158";
/*     */   
/*     */   public int func_82362_a() {
/*  20 */     return 2;
/*     */   }
/*     */ 
/*     */   
/*     */   public String func_71518_a(ICommandSender p_71518_1_) {
/*  25 */     return "commands.summon.usage";
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
/*  30 */     if (p_71515_2_.length >= 1) {
/*     */       
/*  32 */       String str = p_71515_2_[0];
/*  33 */       double d1 = (p_71515_1_.func_82114_b()).field_71574_a + 0.5D;
/*  34 */       double d2 = (p_71515_1_.func_82114_b()).field_71572_b;
/*  35 */       double d3 = (p_71515_1_.func_82114_b()).field_71573_c + 0.5D;
/*     */       
/*  37 */       if (p_71515_2_.length >= 4) {
/*  38 */         d1 = func_110666_a(p_71515_1_, d1, p_71515_2_[1]);
/*  39 */         d2 = func_110666_a(p_71515_1_, d2, p_71515_2_[2]);
/*  40 */         d3 = func_110666_a(p_71515_1_, d3, p_71515_2_[3]);
/*     */       } 
/*     */       
/*  43 */       World world = p_71515_1_.func_130014_f_();
/*  44 */       if (!world.func_72899_e((int)d1, (int)d2, (int)d3)) {
/*  45 */         func_152373_a(p_71515_1_, (ICommand)this, "commands.summon.outOfWorld", new Object[0]);
/*     */         
/*     */         return;
/*     */       } 
/*  49 */       NBTTagCompound nBTTagCompound = new NBTTagCompound();
/*  50 */       boolean bool = false;
/*  51 */       if (p_71515_2_.length >= 5) {
/*  52 */         IChatComponent iChatComponent = func_147178_a(p_71515_1_, p_71515_2_, 4);
/*     */         try {
/*  54 */           NBTBase nBTBase = JsonToNBT.func_150315_a(iChatComponent.func_150260_c());
/*  55 */           if (nBTBase instanceof NBTTagCompound) {
/*  56 */             nBTTagCompound = (NBTTagCompound)nBTBase;
/*  57 */             bool = true;
/*     */           } else {
/*  59 */             func_152373_a(p_71515_1_, (ICommand)this, "commands.summon.tagError", new Object[] { "Not a valid tag" });
/*     */             return;
/*     */           } 
/*  62 */         } catch (NBTException nBTException) {
/*  63 */           func_152373_a(p_71515_1_, (ICommand)this, "commands.summon.tagError", new Object[] { nBTException.getMessage() });
/*     */           return;
/*     */         } 
/*     */       } 
/*  67 */       nBTTagCompound.func_74778_a("id", str);
/*     */       
/*  69 */       Entity entity = EntityList.func_75615_a(nBTTagCompound, world);
/*  70 */       if (entity != null) {
/*  71 */         entity.func_70012_b(d1, d2, d3, entity.field_70177_z, entity.field_70125_A);
/*  72 */         if (!bool)
/*     */         {
/*  74 */           if (entity instanceof EntityLiving) {
/*  75 */             ((EntityLiving)entity).func_110161_a(null);
/*     */           }
/*     */         }
/*  78 */         world.func_72838_d(entity);
/*     */ 
/*     */         
/*  81 */         Entity entity1 = entity;
/*  82 */         NBTTagCompound nBTTagCompound1 = nBTTagCompound;
/*  83 */         while (entity1 != null && nBTTagCompound1.func_150297_b("Riding", 10)) {
/*  84 */           Entity entity2 = EntityList.func_75615_a(nBTTagCompound1.func_74775_l("Riding"), world);
/*  85 */           if (entity2 != null) {
/*  86 */             entity2.func_70012_b(d1, d2, d3, entity2.field_70177_z, entity2.field_70125_A);
/*  87 */             world.func_72838_d(entity2);
/*  88 */             entity1.func_70078_a(entity2);
/*     */           } 
/*  90 */           entity1 = entity2;
/*  91 */           nBTTagCompound1 = nBTTagCompound1.func_74775_l("Riding");
/*     */         } 
/*  93 */         func_152373_a(p_71515_1_, (ICommand)this, "commands.summon.success", new Object[0]);
/*     */         return;
/*     */       } 
/*  96 */       func_152373_a(p_71515_1_, (ICommand)this, "commands.summon.failed", new Object[0]);
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 101 */     throw new WrongUsageException("commands.summon.usage", new Object[0]);
/*     */   }
/*     */ 
/*     */   
/*     */   public List func_71516_a(ICommandSender p_71516_1_, String[] p_71516_2_) {
/* 106 */     if (p_71516_2_.length == 1) {
/* 107 */       return func_71530_a(p_71516_2_, func_147182_d());
/*     */     }
/*     */     
/* 110 */     return null;
/*     */   }
/*     */   
/*     */   protected String[] func_147182_d() {
/* 114 */     return (String[])EntityList.func_151515_b().toArray((Object[])new String[0]);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\command\server\CommandSummon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */