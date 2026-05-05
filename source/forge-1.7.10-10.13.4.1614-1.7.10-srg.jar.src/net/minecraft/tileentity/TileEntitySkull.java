/*     */ package net.minecraft.tileentity;
/*     */ 
/*     */ import com.google.common.collect.Iterables;
/*     */ import com.mojang.authlib.GameProfile;
/*     */ import com.mojang.authlib.properties.Property;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTUtil;
/*     */ import net.minecraft.network.Packet;
/*     */ import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import net.minecraft.util.StringUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TileEntitySkull
/*     */   extends TileEntity
/*     */ {
/*     */   private int field_145908_a;
/*     */   private int field_145910_i;
/*  24 */   private GameProfile field_152110_j = null;
/*     */   private static final String __OBFID = "CL_00000364";
/*     */   
/*     */   public void func_145841_b(NBTTagCompound p_145841_1_) {
/*  28 */     super.func_145841_b(p_145841_1_);
/*  29 */     p_145841_1_.func_74774_a("SkullType", (byte)(this.field_145908_a & 0xFF));
/*  30 */     p_145841_1_.func_74774_a("Rot", (byte)(this.field_145910_i & 0xFF));
/*     */     
/*  32 */     if (this.field_152110_j != null) {
/*  33 */       NBTTagCompound nBTTagCompound = new NBTTagCompound();
/*  34 */       NBTUtil.func_152460_a(nBTTagCompound, this.field_152110_j);
/*  35 */       p_145841_1_.func_74782_a("Owner", (NBTBase)nBTTagCompound);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_145839_a(NBTTagCompound p_145839_1_) {
/*  41 */     super.func_145839_a(p_145839_1_);
/*  42 */     this.field_145908_a = p_145839_1_.func_74771_c("SkullType");
/*  43 */     this.field_145910_i = p_145839_1_.func_74771_c("Rot");
/*     */     
/*  45 */     if (this.field_145908_a == 3) {
/*  46 */       if (p_145839_1_.func_150297_b("Owner", 10)) {
/*  47 */         this.field_152110_j = NBTUtil.func_152459_a(p_145839_1_.func_74775_l("Owner"));
/*  48 */       } else if (p_145839_1_.func_150297_b("ExtraType", 8) && !StringUtils.func_151246_b(p_145839_1_.func_74779_i("ExtraType"))) {
/*  49 */         this.field_152110_j = new GameProfile(null, p_145839_1_.func_74779_i("ExtraType"));
/*  50 */         func_152109_d();
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public GameProfile func_152108_a() {
/*  57 */     return this.field_152110_j;
/*     */   }
/*     */ 
/*     */   
/*     */   public Packet func_145844_m() {
/*  62 */     NBTTagCompound nBTTagCompound = new NBTTagCompound();
/*  63 */     func_145841_b(nBTTagCompound);
/*  64 */     return (Packet)new S35PacketUpdateTileEntity(this.field_145851_c, this.field_145848_d, this.field_145849_e, 4, nBTTagCompound);
/*     */   }
/*     */   
/*     */   public void func_152107_a(int p_152107_1_) {
/*  68 */     this.field_145908_a = p_152107_1_;
/*  69 */     this.field_152110_j = null;
/*     */   }
/*     */   
/*     */   public void func_152106_a(GameProfile p_152106_1_) {
/*  73 */     this.field_145908_a = 3;
/*  74 */     this.field_152110_j = p_152106_1_;
/*  75 */     func_152109_d();
/*     */   }
/*     */   
/*     */   private void func_152109_d() {
/*  79 */     if (this.field_152110_j == null || StringUtils.func_151246_b(this.field_152110_j.getName()))
/*     */       return; 
/*  81 */     if (this.field_152110_j.isComplete() && this.field_152110_j.getProperties().containsKey("textures")) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/*  86 */     GameProfile gameProfile = MinecraftServer.func_71276_C().func_152358_ax().func_152655_a(this.field_152110_j.getName());
/*  87 */     if (gameProfile == null) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/*  92 */     Property property = (Property)Iterables.getFirst(gameProfile.getProperties().get("textures"), null);
/*  93 */     if (property == null) {
/*  94 */       gameProfile = MinecraftServer.func_71276_C().func_147130_as().fillProfileProperties(gameProfile, true);
/*     */     }
/*     */     
/*  97 */     this.field_152110_j = gameProfile;
/*  98 */     func_70296_d();
/*     */   }
/*     */   
/*     */   public int func_145904_a() {
/* 102 */     return this.field_145908_a;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_145906_b() {
/* 106 */     return this.field_145910_i;
/*     */   }
/*     */   
/*     */   public void func_145903_a(int p_145903_1_) {
/* 110 */     this.field_145910_i = p_145903_1_;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\tileentity\TileEntitySkull.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */