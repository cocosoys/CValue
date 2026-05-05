/*     */ package net.minecraft.command.server;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import io.netty.buffer.ByteBuf;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import net.minecraft.command.ICommandManager;
/*     */ import net.minecraft.command.ICommandSender;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import net.minecraft.util.ChatComponentText;
/*     */ import net.minecraft.util.IChatComponent;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public abstract class CommandBlockLogic
/*     */   implements ICommandSender
/*     */ {
/*  19 */   private static final SimpleDateFormat field_145766_a = new SimpleDateFormat("HH:mm:ss");
/*     */ 
/*     */   
/*     */   private int field_145764_b;
/*     */   
/*     */   private boolean field_145765_c = true;
/*     */   
/*  26 */   private IChatComponent field_145762_d = null;
/*  27 */   private String field_145763_e = "";
/*  28 */   private String field_145761_f = "@";
/*     */   
/*     */   public int func_145760_g() {
/*  31 */     return this.field_145764_b;
/*     */   }
/*     */ 
/*     */   
/*     */   private static final String __OBFID = "CL_00000128";
/*     */ 
/*     */   
/*     */   public IChatComponent func_145749_h() {
/*  39 */     return this.field_145762_d;
/*     */   }
/*     */   
/*     */   public void func_145758_a(NBTTagCompound p_145758_1_) {
/*  43 */     p_145758_1_.func_74778_a("Command", this.field_145763_e);
/*  44 */     p_145758_1_.func_74768_a("SuccessCount", this.field_145764_b);
/*  45 */     p_145758_1_.func_74778_a("CustomName", this.field_145761_f);
/*  46 */     if (this.field_145762_d != null) p_145758_1_.func_74778_a("LastOutput", IChatComponent.Serializer.func_150696_a(this.field_145762_d)); 
/*  47 */     p_145758_1_.func_74757_a("TrackOutput", this.field_145765_c);
/*     */   }
/*     */   
/*     */   public void func_145759_b(NBTTagCompound p_145759_1_) {
/*  51 */     this.field_145763_e = p_145759_1_.func_74779_i("Command");
/*  52 */     this.field_145764_b = p_145759_1_.func_74762_e("SuccessCount");
/*  53 */     if (p_145759_1_.func_150297_b("CustomName", 8)) this.field_145761_f = p_145759_1_.func_74779_i("CustomName"); 
/*  54 */     if (p_145759_1_.func_150297_b("LastOutput", 8)) this.field_145762_d = IChatComponent.Serializer.func_150699_a(p_145759_1_.func_74779_i("LastOutput")); 
/*  55 */     if (p_145759_1_.func_150297_b("TrackOutput", 1)) this.field_145765_c = p_145759_1_.func_74767_n("TrackOutput");
/*     */   
/*     */   }
/*     */   
/*     */   public boolean func_70003_b(int p_70003_1_, String p_70003_2_) {
/*  60 */     return (p_70003_1_ <= 2);
/*     */   }
/*     */   
/*     */   public void func_145752_a(String p_145752_1_) {
/*  64 */     this.field_145763_e = p_145752_1_;
/*     */   }
/*     */   
/*     */   public String func_145753_i() {
/*  68 */     return this.field_145763_e;
/*     */   }
/*     */   
/*     */   public void func_145755_a(World p_145755_1_) {
/*  72 */     if (p_145755_1_.field_72995_K) {
/*  73 */       this.field_145764_b = 0;
/*     */     }
/*     */     
/*  76 */     MinecraftServer minecraftServer = MinecraftServer.func_71276_C();
/*  77 */     if (minecraftServer != null && minecraftServer.func_82356_Z()) {
/*  78 */       ICommandManager iCommandManager = minecraftServer.func_71187_D();
/*  79 */       this.field_145764_b = iCommandManager.func_71556_a(this, this.field_145763_e);
/*     */     } else {
/*  81 */       this.field_145764_b = 0;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String func_70005_c_() {
/*  87 */     return this.field_145761_f;
/*     */   }
/*     */ 
/*     */   
/*     */   public IChatComponent func_145748_c_() {
/*  92 */     return (IChatComponent)new ChatComponentText(func_70005_c_());
/*     */   }
/*     */   
/*     */   public void func_145754_b(String p_145754_1_) {
/*  96 */     this.field_145761_f = p_145754_1_;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_145747_a(IChatComponent p_145747_1_) {
/* 101 */     if (this.field_145765_c && func_130014_f_() != null && !(func_130014_f_()).field_72995_K) {
/* 102 */       this.field_145762_d = (new ChatComponentText("[" + field_145766_a.format(new Date()) + "] ")).func_150257_a(p_145747_1_);
/* 103 */       func_145756_e();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract void func_145756_e();
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_145750_b(IChatComponent p_145750_1_) {
/* 114 */     this.field_145762_d = p_145750_1_;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public abstract int func_145751_f();
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public abstract void func_145757_a(ByteBuf paramByteBuf);
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\command\server\CommandBlockLogic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */