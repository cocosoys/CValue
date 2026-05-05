/*     */ package net.minecraft.client.multiplayer;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.ChatComponentTranslation;
/*     */ import net.minecraft.util.IChatComponent;
/*     */ 
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class ServerData
/*     */ {
/*     */   public String field_78847_a;
/*     */   public String field_78845_b;
/*  15 */   public int field_82821_f = 5; public String field_78846_c; public String field_78843_d; public long field_78844_e;
/*  16 */   public String field_82822_g = "1.7.10";
/*     */   public boolean field_78841_f;
/*     */   public String field_147412_i;
/*  19 */   private ServerResourceMode field_152587_j = ServerResourceMode.PROMPT; private String field_147411_m;
/*     */   private boolean field_152588_l;
/*     */   private static final String __OBFID = "CL_00000890";
/*     */   
/*     */   public ServerData(String p_i1193_1_, String p_i1193_2_) {
/*  24 */     this.field_78847_a = p_i1193_1_;
/*  25 */     this.field_78845_b = p_i1193_2_;
/*     */   }
/*     */   
/*     */   public ServerData(String p_i1055_1_, String p_i1055_2_, boolean p_i1055_3_) {
/*  29 */     this(p_i1055_1_, p_i1055_2_);
/*     */     
/*  31 */     this.field_152588_l = p_i1055_3_;
/*     */   }
/*     */   
/*     */   public NBTTagCompound func_78836_a() {
/*  35 */     NBTTagCompound nBTTagCompound = new NBTTagCompound();
/*  36 */     nBTTagCompound.func_74778_a("name", this.field_78847_a);
/*  37 */     nBTTagCompound.func_74778_a("ip", this.field_78845_b);
/*     */     
/*  39 */     if (this.field_147411_m != null) {
/*  40 */       nBTTagCompound.func_74778_a("icon", this.field_147411_m);
/*     */     }
/*     */     
/*  43 */     if (this.field_152587_j == ServerResourceMode.ENABLED) {
/*  44 */       nBTTagCompound.func_74757_a("acceptTextures", true);
/*  45 */     } else if (this.field_152587_j == ServerResourceMode.DISABLED) {
/*  46 */       nBTTagCompound.func_74757_a("acceptTextures", false);
/*     */     } 
/*     */     
/*  49 */     return nBTTagCompound;
/*     */   }
/*     */   
/*     */   public ServerResourceMode func_152586_b() {
/*  53 */     return this.field_152587_j;
/*     */   }
/*     */   
/*     */   public void func_152584_a(ServerResourceMode p_152584_1_) {
/*  57 */     this.field_152587_j = p_152584_1_;
/*     */   }
/*     */   
/*     */   public static ServerData func_78837_a(NBTTagCompound p_78837_0_) {
/*  61 */     ServerData serverData = new ServerData(p_78837_0_.func_74779_i("name"), p_78837_0_.func_74779_i("ip"));
/*     */     
/*  63 */     if (p_78837_0_.func_150297_b("icon", 8)) {
/*  64 */       serverData.func_147407_a(p_78837_0_.func_74779_i("icon"));
/*     */     }
/*     */     
/*  67 */     if (p_78837_0_.func_150297_b("acceptTextures", 1)) {
/*  68 */       if (p_78837_0_.func_74767_n("acceptTextures")) {
/*  69 */         serverData.func_152584_a(ServerResourceMode.ENABLED);
/*     */       } else {
/*  71 */         serverData.func_152584_a(ServerResourceMode.DISABLED);
/*     */       } 
/*     */     } else {
/*  74 */       serverData.func_152584_a(ServerResourceMode.PROMPT);
/*     */     } 
/*     */     
/*  77 */     return serverData;
/*     */   }
/*     */   
/*     */   public String func_147409_e() {
/*  81 */     return this.field_147411_m;
/*     */   }
/*     */   
/*     */   public void func_147407_a(String p_147407_1_) {
/*  85 */     this.field_147411_m = p_147407_1_;
/*     */   }
/*     */   
/*     */   public void func_152583_a(ServerData p_152583_1_) {
/*  89 */     this.field_78845_b = p_152583_1_.field_78845_b;
/*  90 */     this.field_78847_a = p_152583_1_.field_78847_a;
/*  91 */     func_152584_a(p_152583_1_.func_152586_b());
/*  92 */     this.field_147411_m = p_152583_1_.field_147411_m;
/*     */   }
/*     */   
/*     */   public boolean func_152585_d() {
/*  96 */     return this.field_152588_l;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/* 100 */   public enum ServerResourceMode { ENABLED("enabled"),
/* 101 */     DISABLED("disabled"),
/* 102 */     PROMPT("prompt");
/*     */     
/*     */     private final IChatComponent field_152594_d;
/*     */     private static final String __OBFID = "CL_00001833";
/*     */     
/*     */     ServerResourceMode(String p_i1053_3_) {
/* 108 */       this.field_152594_d = (IChatComponent)new ChatComponentTranslation("addServer.resourcePack." + p_i1053_3_, new Object[0]);
/*     */     }
/*     */     
/*     */     public IChatComponent func_152589_a() {
/* 112 */       return this.field_152594_d;
/*     */     } }
/*     */ 
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\multiplayer\ServerData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */