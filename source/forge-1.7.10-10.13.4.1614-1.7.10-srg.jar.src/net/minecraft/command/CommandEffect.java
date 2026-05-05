/*     */ package net.minecraft.command;
/*     */ 
/*     */ import java.util.List;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.potion.Potion;
/*     */ import net.minecraft.potion.PotionEffect;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import net.minecraft.util.ChatComponentTranslation;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CommandEffect
/*     */   extends CommandBase
/*     */ {
/*     */   private static final String __OBFID = "CL_00000323";
/*     */   
/*     */   public String func_71517_b() {
/*  20 */     return "effect";
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_82362_a() {
/*  25 */     return 2;
/*     */   }
/*     */ 
/*     */   
/*     */   public String func_71518_a(ICommandSender p_71518_1_) {
/*  30 */     return "commands.effect.usage";
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_) {
/*  35 */     if (p_71515_2_.length >= 2) {
/*  36 */       EntityPlayerMP entityPlayerMP = func_82359_c(p_71515_1_, p_71515_2_[0]);
/*     */       
/*  38 */       if (p_71515_2_[1].equals("clear")) {
/*  39 */         if (entityPlayerMP.func_70651_bq().isEmpty()) {
/*  40 */           throw new CommandException("commands.effect.failure.notActive.all", new Object[] { entityPlayerMP.func_70005_c_() });
/*     */         }
/*  42 */         entityPlayerMP.func_70674_bp();
/*  43 */         func_152373_a(p_71515_1_, this, "commands.effect.success.removed.all", new Object[] { entityPlayerMP.func_70005_c_() });
/*     */       } else {
/*     */         
/*  46 */         int i = func_71528_a(p_71515_1_, p_71515_2_[1], 1);
/*  47 */         int j = 600;
/*  48 */         int k = 30;
/*  49 */         int m = 0;
/*     */         
/*  51 */         if (i < 0 || i >= Potion.field_76425_a.length || Potion.field_76425_a[i] == null) {
/*  52 */           throw new NumberInvalidException("commands.effect.notFound", new Object[] { Integer.valueOf(i) });
/*     */         }
/*     */         
/*  55 */         if (p_71515_2_.length >= 3) {
/*  56 */           k = func_71532_a(p_71515_1_, p_71515_2_[2], 0, 1000000);
/*  57 */           if (Potion.field_76425_a[i].func_76403_b()) {
/*  58 */             j = k;
/*     */           } else {
/*  60 */             j = k * 20;
/*     */           } 
/*  62 */         } else if (Potion.field_76425_a[i].func_76403_b()) {
/*  63 */           j = 1;
/*     */         } 
/*     */         
/*  66 */         if (p_71515_2_.length >= 4) {
/*  67 */           m = func_71532_a(p_71515_1_, p_71515_2_[3], 0, 255);
/*     */         }
/*     */         
/*  70 */         if (k == 0) {
/*  71 */           if (entityPlayerMP.func_82165_m(i)) {
/*  72 */             entityPlayerMP.func_82170_o(i);
/*  73 */             func_152373_a(p_71515_1_, this, "commands.effect.success.removed", new Object[] { new ChatComponentTranslation(Potion.field_76425_a[i].func_76393_a(), new Object[0]), entityPlayerMP.func_70005_c_() });
/*     */           } else {
/*  75 */             throw new CommandException("commands.effect.failure.notActive", new Object[] { new ChatComponentTranslation(Potion.field_76425_a[i].func_76393_a(), new Object[0]), entityPlayerMP.func_70005_c_() });
/*     */           } 
/*     */         } else {
/*  78 */           PotionEffect potionEffect = new PotionEffect(i, j, m);
/*  79 */           entityPlayerMP.func_70690_d(potionEffect);
/*  80 */           func_152373_a(p_71515_1_, this, "commands.effect.success", new Object[] { new ChatComponentTranslation(potionEffect.func_76453_d(), new Object[0]), Integer.valueOf(i), Integer.valueOf(m), entityPlayerMP.func_70005_c_(), Integer.valueOf(k) });
/*     */         } 
/*     */       } 
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/*  87 */     throw new WrongUsageException("commands.effect.usage", new Object[0]);
/*     */   }
/*     */ 
/*     */   
/*     */   public List func_71516_a(ICommandSender p_71516_1_, String[] p_71516_2_) {
/*  92 */     if (p_71516_2_.length == 1) {
/*  93 */       return func_71530_a(p_71516_2_, func_98152_d());
/*     */     }
/*     */     
/*  96 */     return null;
/*     */   }
/*     */   
/*     */   protected String[] func_98152_d() {
/* 100 */     return MinecraftServer.func_71276_C().func_71213_z();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_82358_a(String[] p_82358_1_, int p_82358_2_) {
/* 105 */     return (p_82358_2_ == 0);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\command\CommandEffect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */