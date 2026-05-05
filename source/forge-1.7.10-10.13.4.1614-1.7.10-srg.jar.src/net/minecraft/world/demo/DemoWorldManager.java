/*     */ package net.minecraft.world.demo;
/*     */ 
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.network.Packet;
/*     */ import net.minecraft.network.play.server.S2BPacketChangeGameState;
/*     */ import net.minecraft.server.management.ItemInWorldManager;
/*     */ import net.minecraft.util.ChatComponentTranslation;
/*     */ import net.minecraft.util.IChatComponent;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class DemoWorldManager extends ItemInWorldManager {
/*     */   private boolean field_73105_c;
/*     */   private boolean field_73103_d;
/*     */   private int field_73104_e;
/*     */   private int field_73102_f;
/*     */   private static final String __OBFID = "CL_00001429";
/*     */   
/*     */   public DemoWorldManager(World p_i1513_1_) {
/*  20 */     super(p_i1513_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73075_a() {
/*  25 */     super.func_73075_a();
/*  26 */     this.field_73102_f++;
/*     */     
/*  28 */     long l1 = this.field_73092_a.func_82737_E();
/*  29 */     long l2 = l1 / 24000L + 1L;
/*     */     
/*  31 */     if (!this.field_73105_c && this.field_73102_f > 20) {
/*  32 */       this.field_73105_c = true;
/*  33 */       this.field_73090_b.field_71135_a.func_147359_a((Packet)new S2BPacketChangeGameState(5, 0.0F));
/*     */     } 
/*     */     
/*  36 */     this.field_73103_d = (l1 > 120500L);
/*  37 */     if (this.field_73103_d) {
/*  38 */       this.field_73104_e++;
/*     */     }
/*     */     
/*  41 */     if (l1 % 24000L == 500L) {
/*  42 */       if (l2 <= 6L) {
/*  43 */         this.field_73090_b.func_145747_a((IChatComponent)new ChatComponentTranslation("demo.day." + l2, new Object[0]));
/*     */       }
/*  45 */     } else if (l2 == 1L) {
/*  46 */       if (l1 == 100L) {
/*  47 */         this.field_73090_b.field_71135_a.func_147359_a((Packet)new S2BPacketChangeGameState(5, 101.0F));
/*  48 */       } else if (l1 == 175L) {
/*  49 */         this.field_73090_b.field_71135_a.func_147359_a((Packet)new S2BPacketChangeGameState(5, 102.0F));
/*  50 */       } else if (l1 == 250L) {
/*  51 */         this.field_73090_b.field_71135_a.func_147359_a((Packet)new S2BPacketChangeGameState(5, 103.0F));
/*     */       } 
/*  53 */     } else if (l2 == 5L && 
/*  54 */       l1 % 24000L == 22000L) {
/*  55 */       this.field_73090_b.func_145747_a((IChatComponent)new ChatComponentTranslation("demo.day.warning", new Object[0]));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void func_73101_e() {
/*  61 */     if (this.field_73104_e > 100) {
/*  62 */       this.field_73090_b.func_145747_a((IChatComponent)new ChatComponentTranslation("demo.reminder", new Object[0]));
/*  63 */       this.field_73104_e = 0;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73074_a(int p_73074_1_, int p_73074_2_, int p_73074_3_, int p_73074_4_) {
/*  69 */     if (this.field_73103_d) {
/*  70 */       func_73101_e();
/*     */       return;
/*     */     } 
/*  73 */     super.func_73074_a(p_73074_1_, p_73074_2_, p_73074_3_, p_73074_4_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73082_a(int p_73082_1_, int p_73082_2_, int p_73082_3_) {
/*  78 */     if (this.field_73103_d) {
/*     */       return;
/*     */     }
/*  81 */     super.func_73082_a(p_73082_1_, p_73082_2_, p_73082_3_);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_73084_b(int p_73084_1_, int p_73084_2_, int p_73084_3_) {
/*  86 */     if (this.field_73103_d) {
/*  87 */       return false;
/*     */     }
/*  89 */     return super.func_73084_b(p_73084_1_, p_73084_2_, p_73084_3_);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_73085_a(EntityPlayer p_73085_1_, World p_73085_2_, ItemStack p_73085_3_) {
/*  94 */     if (this.field_73103_d) {
/*  95 */       func_73101_e();
/*  96 */       return false;
/*     */     } 
/*  98 */     return super.func_73085_a(p_73085_1_, p_73085_2_, p_73085_3_);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_73078_a(EntityPlayer p_73078_1_, World p_73078_2_, ItemStack p_73078_3_, int p_73078_4_, int p_73078_5_, int p_73078_6_, int p_73078_7_, float p_73078_8_, float p_73078_9_, float p_73078_10_) {
/* 103 */     if (this.field_73103_d) {
/* 104 */       func_73101_e();
/* 105 */       return false;
/*     */     } 
/* 107 */     return super.func_73078_a(p_73078_1_, p_73078_2_, p_73078_3_, p_73078_4_, p_73078_5_, p_73078_6_, p_73078_7_, p_73078_8_, p_73078_9_, p_73078_10_);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\demo\DemoWorldManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */