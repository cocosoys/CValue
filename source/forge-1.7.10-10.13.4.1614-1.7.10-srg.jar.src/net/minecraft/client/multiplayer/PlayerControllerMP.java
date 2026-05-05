/*     */ package net.minecraft.client.multiplayer;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.entity.EntityClientPlayerMP;
/*     */ import net.minecraft.client.network.NetHandlerPlayClient;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemBlock;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.network.Packet;
/*     */ import net.minecraft.network.play.client.C02PacketUseEntity;
/*     */ import net.minecraft.network.play.client.C07PacketPlayerDigging;
/*     */ import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;
/*     */ import net.minecraft.network.play.client.C10PacketCreativeInventoryAction;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.WorldSettings;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class PlayerControllerMP {
/*     */   private final Minecraft field_78776_a;
/*  23 */   private int field_78775_c = -1; private final NetHandlerPlayClient field_78774_b;
/*  24 */   private int field_78772_d = -1;
/*  25 */   private int field_78773_e = -1;
/*     */   private ItemStack field_85183_f;
/*     */   private float field_78770_f;
/*     */   private float field_78780_h;
/*     */   private int field_78781_i;
/*     */   private boolean field_78778_j;
/*  31 */   private WorldSettings.GameType field_78779_k = WorldSettings.GameType.SURVIVAL; private int field_78777_l; private static final String __OBFID = "CL_00000881";
/*     */   
/*     */   public PlayerControllerMP(Minecraft p_i45062_1_, NetHandlerPlayClient p_i45062_2_) {
/*  34 */     this.field_78776_a = p_i45062_1_;
/*  35 */     this.field_78774_b = p_i45062_2_;
/*     */   }
/*     */   
/*     */   public static void func_78744_a(Minecraft p_78744_0_, PlayerControllerMP p_78744_1_, int p_78744_2_, int p_78744_3_, int p_78744_4_, int p_78744_5_) {
/*  39 */     if (!p_78744_0_.field_71441_e.func_72886_a((EntityPlayer)p_78744_0_.field_71439_g, p_78744_2_, p_78744_3_, p_78744_4_, p_78744_5_)) {
/*  40 */       p_78744_1_.func_78751_a(p_78744_2_, p_78744_3_, p_78744_4_, p_78744_5_);
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_78748_a(EntityPlayer p_78748_1_) {
/*  45 */     this.field_78779_k.func_77147_a(p_78748_1_.field_71075_bZ);
/*     */   }
/*     */   
/*     */   public boolean func_78747_a() {
/*  49 */     return false;
/*     */   }
/*     */   
/*     */   public void func_78746_a(WorldSettings.GameType p_78746_1_) {
/*  53 */     this.field_78779_k = p_78746_1_;
/*  54 */     this.field_78779_k.func_77147_a(this.field_78776_a.field_71439_g.field_71075_bZ);
/*     */   }
/*     */   
/*     */   public void func_78745_b(EntityPlayer p_78745_1_) {
/*  58 */     p_78745_1_.field_70177_z = -180.0F;
/*     */   }
/*     */   
/*     */   public boolean func_78755_b() {
/*  62 */     return this.field_78779_k.func_77144_e();
/*     */   }
/*     */   
/*     */   public boolean func_78751_a(int p_78751_1_, int p_78751_2_, int p_78751_3_, int p_78751_4_) {
/*  66 */     if (this.field_78779_k.func_82752_c() && 
/*  67 */       !this.field_78776_a.field_71439_g.func_82246_f(p_78751_1_, p_78751_2_, p_78751_3_)) {
/*  68 */       return false;
/*     */     }
/*     */ 
/*     */     
/*  72 */     if (this.field_78779_k.func_77145_d() && 
/*  73 */       this.field_78776_a.field_71439_g.func_70694_bm() != null && this.field_78776_a.field_71439_g.func_70694_bm().func_77973_b() instanceof net.minecraft.item.ItemSword) {
/*  74 */       return false;
/*     */     }
/*     */ 
/*     */     
/*  78 */     WorldClient worldClient = this.field_78776_a.field_71441_e;
/*  79 */     Block block = worldClient.func_147439_a(p_78751_1_, p_78751_2_, p_78751_3_);
/*     */ 
/*     */     
/*  82 */     if (block.func_149688_o() == Material.field_151579_a) return false;
/*     */     
/*  84 */     worldClient.func_72926_e(2001, p_78751_1_, p_78751_2_, p_78751_3_, Block.func_149682_b(block) + (worldClient.func_72805_g(p_78751_1_, p_78751_2_, p_78751_3_) << 12));
/*     */     
/*  86 */     int i = worldClient.func_72805_g(p_78751_1_, p_78751_2_, p_78751_3_);
/*  87 */     boolean bool = worldClient.func_147468_f(p_78751_1_, p_78751_2_, p_78751_3_);
/*  88 */     if (bool) {
/*  89 */       block.func_149664_b(worldClient, p_78751_1_, p_78751_2_, p_78751_3_, i);
/*     */     }
/*  91 */     this.field_78772_d = -1;
/*     */     
/*  93 */     if (!this.field_78779_k.func_77145_d()) {
/*  94 */       ItemStack itemStack = this.field_78776_a.field_71439_g.func_71045_bC();
/*  95 */       if (itemStack != null) {
/*  96 */         itemStack.func_150999_a(worldClient, block, p_78751_1_, p_78751_2_, p_78751_3_, (EntityPlayer)this.field_78776_a.field_71439_g);
/*  97 */         if (itemStack.field_77994_a == 0) {
/*  98 */           this.field_78776_a.field_71439_g.func_71028_bD();
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 103 */     return bool;
/*     */   }
/*     */   
/*     */   public void func_78743_b(int p_78743_1_, int p_78743_2_, int p_78743_3_, int p_78743_4_) {
/* 107 */     if (this.field_78779_k.func_82752_c() && 
/* 108 */       !this.field_78776_a.field_71439_g.func_82246_f(p_78743_1_, p_78743_2_, p_78743_3_)) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 113 */     if (this.field_78779_k.func_77145_d()) {
/* 114 */       this.field_78774_b.func_147297_a((Packet)new C07PacketPlayerDigging(0, p_78743_1_, p_78743_2_, p_78743_3_, p_78743_4_));
/* 115 */       func_78744_a(this.field_78776_a, this, p_78743_1_, p_78743_2_, p_78743_3_, p_78743_4_);
/* 116 */       this.field_78781_i = 5;
/* 117 */     } else if (!this.field_78778_j || !func_85182_a(p_78743_1_, p_78743_2_, p_78743_3_)) {
/* 118 */       if (this.field_78778_j) {
/* 119 */         this.field_78774_b.func_147297_a((Packet)new C07PacketPlayerDigging(1, this.field_78775_c, this.field_78772_d, this.field_78773_e, p_78743_4_));
/*     */       }
/* 121 */       this.field_78774_b.func_147297_a((Packet)new C07PacketPlayerDigging(0, p_78743_1_, p_78743_2_, p_78743_3_, p_78743_4_));
/*     */       
/* 123 */       Block block = this.field_78776_a.field_71441_e.func_147439_a(p_78743_1_, p_78743_2_, p_78743_3_);
/* 124 */       boolean bool = (block.func_149688_o() != Material.field_151579_a) ? true : false;
/* 125 */       if (bool && this.field_78770_f == 0.0F) {
/* 126 */         block.func_149699_a(this.field_78776_a.field_71441_e, p_78743_1_, p_78743_2_, p_78743_3_, (EntityPlayer)this.field_78776_a.field_71439_g);
/*     */       }
/* 128 */       if (bool && block.func_149737_a((EntityPlayer)this.field_78776_a.field_71439_g, this.field_78776_a.field_71439_g.field_70170_p, p_78743_1_, p_78743_2_, p_78743_3_) >= 1.0F) {
/* 129 */         func_78751_a(p_78743_1_, p_78743_2_, p_78743_3_, p_78743_4_);
/*     */       } else {
/* 131 */         this.field_78778_j = true;
/* 132 */         this.field_78775_c = p_78743_1_;
/* 133 */         this.field_78772_d = p_78743_2_;
/* 134 */         this.field_78773_e = p_78743_3_;
/* 135 */         this.field_85183_f = this.field_78776_a.field_71439_g.func_70694_bm();
/* 136 */         this.field_78770_f = 0.0F;
/* 137 */         this.field_78780_h = 0.0F;
/* 138 */         this.field_78776_a.field_71441_e.func_147443_d(this.field_78776_a.field_71439_g.func_145782_y(), this.field_78775_c, this.field_78772_d, this.field_78773_e, (int)(this.field_78770_f * 10.0F) - 1);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_78767_c() {
/* 144 */     if (this.field_78778_j) {
/* 145 */       this.field_78774_b.func_147297_a((Packet)new C07PacketPlayerDigging(1, this.field_78775_c, this.field_78772_d, this.field_78773_e, -1));
/*     */     }
/*     */     
/* 148 */     this.field_78778_j = false;
/* 149 */     this.field_78770_f = 0.0F;
/* 150 */     this.field_78776_a.field_71441_e.func_147443_d(this.field_78776_a.field_71439_g.func_145782_y(), this.field_78775_c, this.field_78772_d, this.field_78773_e, -1);
/*     */   }
/*     */   
/*     */   public void func_78759_c(int p_78759_1_, int p_78759_2_, int p_78759_3_, int p_78759_4_) {
/* 154 */     func_78750_j();
/*     */     
/* 156 */     if (this.field_78781_i > 0) {
/* 157 */       this.field_78781_i--;
/*     */       
/*     */       return;
/*     */     } 
/* 161 */     if (this.field_78779_k.func_77145_d()) {
/* 162 */       this.field_78781_i = 5;
/* 163 */       this.field_78774_b.func_147297_a((Packet)new C07PacketPlayerDigging(0, p_78759_1_, p_78759_2_, p_78759_3_, p_78759_4_));
/* 164 */       func_78744_a(this.field_78776_a, this, p_78759_1_, p_78759_2_, p_78759_3_, p_78759_4_);
/*     */       
/*     */       return;
/*     */     } 
/* 168 */     if (func_85182_a(p_78759_1_, p_78759_2_, p_78759_3_)) {
/* 169 */       Block block = this.field_78776_a.field_71441_e.func_147439_a(p_78759_1_, p_78759_2_, p_78759_3_);
/*     */       
/* 171 */       if (block.func_149688_o() == Material.field_151579_a) {
/* 172 */         this.field_78778_j = false;
/*     */         
/*     */         return;
/*     */       } 
/* 176 */       this.field_78770_f += block.func_149737_a((EntityPlayer)this.field_78776_a.field_71439_g, this.field_78776_a.field_71439_g.field_70170_p, p_78759_1_, p_78759_2_, p_78759_3_);
/*     */       
/* 178 */       if (this.field_78780_h % 4.0F == 0.0F) {
/* 179 */         this.field_78776_a.func_147118_V().func_147682_a((ISound)new PositionedSoundRecord(new ResourceLocation(block.field_149762_H.func_150498_e()), (block.field_149762_H.func_150497_c() + 1.0F) / 8.0F, block.field_149762_H.func_150494_d() * 0.5F, p_78759_1_ + 0.5F, p_78759_2_ + 0.5F, p_78759_3_ + 0.5F));
/*     */       }
/*     */       
/* 182 */       this.field_78780_h++;
/*     */       
/* 184 */       if (this.field_78770_f >= 1.0F) {
/* 185 */         this.field_78778_j = false;
/* 186 */         this.field_78774_b.func_147297_a((Packet)new C07PacketPlayerDigging(2, p_78759_1_, p_78759_2_, p_78759_3_, p_78759_4_));
/* 187 */         func_78751_a(p_78759_1_, p_78759_2_, p_78759_3_, p_78759_4_);
/* 188 */         this.field_78770_f = 0.0F;
/* 189 */         this.field_78780_h = 0.0F;
/* 190 */         this.field_78781_i = 5;
/*     */       } 
/*     */       
/* 193 */       this.field_78776_a.field_71441_e.func_147443_d(this.field_78776_a.field_71439_g.func_145782_y(), this.field_78775_c, this.field_78772_d, this.field_78773_e, (int)(this.field_78770_f * 10.0F) - 1);
/*     */     } else {
/* 195 */       func_78743_b(p_78759_1_, p_78759_2_, p_78759_3_, p_78759_4_);
/*     */     } 
/*     */   }
/*     */   
/*     */   public float func_78757_d() {
/* 200 */     if (this.field_78779_k.func_77145_d()) {
/* 201 */       return 5.0F;
/*     */     }
/* 203 */     return 4.5F;
/*     */   }
/*     */   
/*     */   public void func_78765_e() {
/* 207 */     func_78750_j();
/*     */ 
/*     */ 
/*     */     
/* 211 */     if (this.field_78774_b.func_147298_b().func_150724_d()) {
/* 212 */       this.field_78774_b.func_147298_b().func_74428_b();
/* 213 */     } else if (this.field_78774_b.func_147298_b().func_150730_f() != null) {
/* 214 */       this.field_78774_b.func_147298_b().func_150729_e().func_147231_a(this.field_78774_b.func_147298_b().func_150730_f());
/*     */     } else {
/* 216 */       this.field_78774_b.func_147298_b().func_150729_e().func_147231_a((IChatComponent)new ChatComponentText("Disconnected from server"));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean func_85182_a(int p_85182_1_, int p_85182_2_, int p_85182_3_) {
/* 223 */     ItemStack itemStack = this.field_78776_a.field_71439_g.func_70694_bm();
/* 224 */     boolean bool = (this.field_85183_f == null && itemStack == null) ? true : false;
/* 225 */     if (this.field_85183_f != null && itemStack != null) {
/* 226 */       bool = (itemStack.func_77973_b() == this.field_85183_f.func_77973_b() && ItemStack.func_77970_a(itemStack, this.field_85183_f) && (itemStack.func_77984_f() || itemStack.func_77960_j() == this.field_85183_f.func_77960_j())) ? true : false;
/*     */     }
/* 228 */     return (p_85182_1_ == this.field_78775_c && p_85182_2_ == this.field_78772_d && p_85182_3_ == this.field_78773_e && bool);
/*     */   }
/*     */   
/*     */   private void func_78750_j() {
/* 232 */     int i = this.field_78776_a.field_71439_g.field_71071_by.field_70461_c;
/* 233 */     if (i != this.field_78777_l) {
/* 234 */       this.field_78777_l = i;
/* 235 */       this.field_78774_b.func_147297_a((Packet)new C09PacketHeldItemChange(this.field_78777_l));
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean func_78760_a(EntityPlayer p_78760_1_, World p_78760_2_, ItemStack p_78760_3_, int p_78760_4_, int p_78760_5_, int p_78760_6_, int p_78760_7_, Vec3 p_78760_8_) {
/* 240 */     func_78750_j();
/* 241 */     float f1 = (float)p_78760_8_.field_72450_a - p_78760_4_;
/* 242 */     float f2 = (float)p_78760_8_.field_72448_b - p_78760_5_;
/* 243 */     float f3 = (float)p_78760_8_.field_72449_c - p_78760_6_;
/* 244 */     boolean bool = false;
/*     */     
/* 246 */     if ((!p_78760_1_.func_70093_af() || p_78760_1_.func_70694_bm() == null) && 
/* 247 */       p_78760_2_.func_147439_a(p_78760_4_, p_78760_5_, p_78760_6_).func_149727_a(p_78760_2_, p_78760_4_, p_78760_5_, p_78760_6_, p_78760_1_, p_78760_7_, f1, f2, f3)) bool = true;
/*     */ 
/*     */     
/* 250 */     if (!bool && p_78760_3_ != null && p_78760_3_.func_77973_b() instanceof ItemBlock) {
/* 251 */       ItemBlock itemBlock = (ItemBlock)p_78760_3_.func_77973_b();
/* 252 */       if (!itemBlock.func_150936_a(p_78760_2_, p_78760_4_, p_78760_5_, p_78760_6_, p_78760_7_, p_78760_1_, p_78760_3_)) return false;
/*     */     
/*     */     } 
/* 255 */     this.field_78774_b.func_147297_a((Packet)new C08PacketPlayerBlockPlacement(p_78760_4_, p_78760_5_, p_78760_6_, p_78760_7_, p_78760_1_.field_71071_by.func_70448_g(), f1, f2, f3));
/* 256 */     if (bool) return true; 
/* 257 */     if (p_78760_3_ == null) return false;
/*     */     
/* 259 */     if (this.field_78779_k.func_77145_d()) {
/* 260 */       int i = p_78760_3_.func_77960_j();
/* 261 */       int j = p_78760_3_.field_77994_a;
/* 262 */       boolean bool1 = p_78760_3_.func_77943_a(p_78760_1_, p_78760_2_, p_78760_4_, p_78760_5_, p_78760_6_, p_78760_7_, f1, f2, f3);
/* 263 */       p_78760_3_.func_77964_b(i);
/* 264 */       p_78760_3_.field_77994_a = j;
/* 265 */       return bool1;
/*     */     } 
/* 267 */     return p_78760_3_.func_77943_a(p_78760_1_, p_78760_2_, p_78760_4_, p_78760_5_, p_78760_6_, p_78760_7_, f1, f2, f3);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_78769_a(EntityPlayer p_78769_1_, World p_78769_2_, ItemStack p_78769_3_) {
/* 272 */     func_78750_j();
/* 273 */     this.field_78774_b.func_147297_a((Packet)new C08PacketPlayerBlockPlacement(-1, -1, -1, 255, p_78769_1_.field_71071_by.func_70448_g(), 0.0F, 0.0F, 0.0F));
/* 274 */     int i = p_78769_3_.field_77994_a;
/* 275 */     ItemStack itemStack = p_78769_3_.func_77957_a(p_78769_2_, p_78769_1_);
/*     */     
/* 277 */     if (itemStack != p_78769_3_ || (itemStack != null && itemStack.field_77994_a != i)) {
/* 278 */       p_78769_1_.field_71071_by.field_70462_a[p_78769_1_.field_71071_by.field_70461_c] = itemStack;
/*     */       
/* 280 */       if (itemStack.field_77994_a == 0) {
/* 281 */         p_78769_1_.field_71071_by.field_70462_a[p_78769_1_.field_71071_by.field_70461_c] = null;
/*     */       }
/* 283 */       return true;
/*     */     } 
/*     */     
/* 286 */     return false;
/*     */   }
/*     */   
/*     */   public EntityClientPlayerMP func_147493_a(World p_147493_1_, StatFileWriter p_147493_2_) {
/* 290 */     return new EntityClientPlayerMP(this.field_78776_a, p_147493_1_, this.field_78776_a.func_110432_I(), this.field_78774_b, p_147493_2_);
/*     */   }
/*     */   
/*     */   public void func_78764_a(EntityPlayer p_78764_1_, Entity p_78764_2_) {
/* 294 */     func_78750_j();
/* 295 */     this.field_78774_b.func_147297_a((Packet)new C02PacketUseEntity(p_78764_2_, C02PacketUseEntity.Action.ATTACK));
/* 296 */     p_78764_1_.func_71059_n(p_78764_2_);
/*     */   }
/*     */   
/*     */   public boolean func_78768_b(EntityPlayer p_78768_1_, Entity p_78768_2_) {
/* 300 */     func_78750_j();
/* 301 */     this.field_78774_b.func_147297_a((Packet)new C02PacketUseEntity(p_78768_2_, C02PacketUseEntity.Action.INTERACT));
/* 302 */     return p_78768_1_.func_70998_m(p_78768_2_);
/*     */   }
/*     */   
/*     */   public ItemStack func_78753_a(int p_78753_1_, int p_78753_2_, int p_78753_3_, int p_78753_4_, EntityPlayer p_78753_5_) {
/* 306 */     short s = p_78753_5_.field_71070_bA.func_75136_a(p_78753_5_.field_71071_by);
/*     */     
/* 308 */     ItemStack itemStack = p_78753_5_.field_71070_bA.func_75144_a(p_78753_2_, p_78753_3_, p_78753_4_, p_78753_5_);
/* 309 */     this.field_78774_b.func_147297_a((Packet)new C0EPacketClickWindow(p_78753_1_, p_78753_2_, p_78753_3_, p_78753_4_, itemStack, s));
/*     */     
/* 311 */     return itemStack;
/*     */   }
/*     */   
/*     */   public void func_78756_a(int p_78756_1_, int p_78756_2_) {
/* 315 */     this.field_78774_b.func_147297_a((Packet)new C11PacketEnchantItem(p_78756_1_, p_78756_2_));
/*     */   }
/*     */   
/*     */   public void func_78761_a(ItemStack p_78761_1_, int p_78761_2_) {
/* 319 */     if (this.field_78779_k.func_77145_d()) {
/* 320 */       this.field_78774_b.func_147297_a((Packet)new C10PacketCreativeInventoryAction(p_78761_2_, p_78761_1_));
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_78752_a(ItemStack p_78752_1_) {
/* 325 */     if (this.field_78779_k.func_77145_d() && p_78752_1_ != null) {
/* 326 */       this.field_78774_b.func_147297_a((Packet)new C10PacketCreativeInventoryAction(-1, p_78752_1_));
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_78766_c(EntityPlayer p_78766_1_) {
/* 331 */     func_78750_j();
/* 332 */     this.field_78774_b.func_147297_a((Packet)new C07PacketPlayerDigging(5, 0, 0, 0, 255));
/* 333 */     p_78766_1_.func_71034_by();
/*     */   }
/*     */   
/*     */   public boolean func_78763_f() {
/* 337 */     return this.field_78779_k.func_77144_e();
/*     */   }
/*     */   
/*     */   public boolean func_78762_g() {
/* 341 */     return !this.field_78779_k.func_77145_d();
/*     */   }
/*     */   
/*     */   public boolean func_78758_h() {
/* 345 */     return this.field_78779_k.func_77145_d();
/*     */   }
/*     */   
/*     */   public boolean func_78749_i() {
/* 349 */     return this.field_78779_k.func_77145_d();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_110738_j() {
/* 359 */     return (this.field_78776_a.field_71439_g.func_70115_ae() && this.field_78776_a.field_71439_g.field_70154_o instanceof net.minecraft.entity.passive.EntityHorse);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\multiplayer\PlayerControllerMP.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */