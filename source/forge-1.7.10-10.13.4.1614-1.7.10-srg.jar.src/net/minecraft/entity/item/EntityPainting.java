/*     */ package net.minecraft.entity.item;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import java.util.ArrayList;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class EntityPainting extends EntityHanging {
/*     */   public EnumArt field_70522_e;
/*     */   private static final String __OBFID = "CL_00001556";
/*     */   
/*  15 */   public enum EnumArt { Kebab("Kebab", 16, 16, 0, 0),
/*  16 */     Aztec("Aztec", 16, 16, 16, 0),
/*  17 */     Alban("Alban", 16, 16, 32, 0),
/*  18 */     Aztec2("Aztec2", 16, 16, 48, 0),
/*  19 */     Bomb("Bomb", 16, 16, 64, 0),
/*  20 */     Plant("Plant", 16, 16, 80, 0),
/*  21 */     Wasteland("Wasteland", 16, 16, 96, 0),
/*     */     
/*  23 */     Pool("Pool", 32, 16, 0, 32),
/*  24 */     Courbet("Courbet", 32, 16, 32, 32),
/*  25 */     Sea("Sea", 32, 16, 64, 32),
/*  26 */     Sunset("Sunset", 32, 16, 96, 32),
/*  27 */     Creebet("Creebet", 32, 16, 128, 32),
/*     */     
/*  29 */     Wanderer("Wanderer", 16, 32, 0, 64),
/*  30 */     Graham("Graham", 16, 32, 16, 64),
/*     */     
/*  32 */     Match("Match", 32, 32, 0, 128),
/*  33 */     Bust("Bust", 32, 32, 32, 128),
/*  34 */     Stage("Stage", 32, 32, 64, 128),
/*  35 */     Void("Void", 32, 32, 96, 128),
/*  36 */     SkullAndRoses("SkullAndRoses", 32, 32, 128, 128),
/*  37 */     Wither("Wither", 32, 32, 160, 128),
/*  38 */     Fighters("Fighters", 64, 32, 0, 96),
/*     */     
/*  40 */     Pointer("Pointer", 64, 64, 0, 192),
/*  41 */     Pigscene("Pigscene", 64, 64, 64, 192),
/*  42 */     BurningSkull("BurningSkull", 64, 64, 128, 192),
/*     */     
/*  44 */     Skeleton("Skeleton", 64, 48, 192, 64),
/*  45 */     DonkeyKong("DonkeyKong", 64, 48, 192, 112);
/*     */     
/*  47 */     public static final int field_75728_z = "SkullAndRoses".length();
/*     */     
/*     */     public final String field_75702_A;
/*     */     public final int field_75703_B;
/*     */     public final int field_75704_C;
/*     */     
/*     */     EnumArt(String p_i1598_3_, int p_i1598_4_, int p_i1598_5_, int p_i1598_6_, int p_i1598_7_) {
/*  54 */       this.field_75702_A = p_i1598_3_;
/*  55 */       this.field_75703_B = p_i1598_4_;
/*  56 */       this.field_75704_C = p_i1598_5_;
/*  57 */       this.field_75699_D = p_i1598_6_;
/*  58 */       this.field_75700_E = p_i1598_7_;
/*     */     }
/*     */     public final int field_75699_D; public final int field_75700_E; private static final String __OBFID = "CL_00001557";
/*     */     static {
/*     */     
/*     */     } }
/*     */   public EntityPainting(World p_i1599_1_) {
/*  65 */     super(p_i1599_1_);
/*     */   }
/*     */   
/*     */   public EntityPainting(World p_i1600_1_, int p_i1600_2_, int p_i1600_3_, int p_i1600_4_, int p_i1600_5_) {
/*  69 */     super(p_i1600_1_, p_i1600_2_, p_i1600_3_, p_i1600_4_, p_i1600_5_);
/*     */     
/*  71 */     ArrayList<EnumArt> arrayList = new ArrayList();
/*  72 */     for (EnumArt enumArt : EnumArt.values()) {
/*  73 */       this.field_70522_e = enumArt;
/*  74 */       func_82328_a(p_i1600_5_);
/*  75 */       if (func_70518_d()) {
/*  76 */         arrayList.add(enumArt);
/*     */       }
/*     */     } 
/*  79 */     if (!arrayList.isEmpty()) {
/*  80 */       this.field_70522_e = arrayList.get(this.field_70146_Z.nextInt(arrayList.size()));
/*     */     }
/*  82 */     func_82328_a(p_i1600_5_);
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public EntityPainting(World p_i1601_1_, int p_i1601_2_, int p_i1601_3_, int p_i1601_4_, int p_i1601_5_, String p_i1601_6_) {
/*  86 */     this(p_i1601_1_, p_i1601_2_, p_i1601_3_, p_i1601_4_, p_i1601_5_);
/*     */     
/*  88 */     for (EnumArt enumArt : EnumArt.values()) {
/*  89 */       if (enumArt.field_75702_A.equals(p_i1601_6_)) {
/*  90 */         this.field_70522_e = enumArt;
/*     */         break;
/*     */       } 
/*     */     } 
/*  94 */     func_82328_a(p_i1601_5_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70014_b(NBTTagCompound p_70014_1_) {
/*  99 */     p_70014_1_.func_74778_a("Motive", this.field_70522_e.field_75702_A);
/* 100 */     super.func_70014_b(p_70014_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70037_a(NBTTagCompound p_70037_1_) {
/* 105 */     String str = p_70037_1_.func_74779_i("Motive");
/* 106 */     for (EnumArt enumArt : EnumArt.values()) {
/* 107 */       if (enumArt.field_75702_A.equals(str)) {
/* 108 */         this.field_70522_e = enumArt;
/*     */       }
/*     */     } 
/* 111 */     if (this.field_70522_e == null) this.field_70522_e = EnumArt.Kebab; 
/* 112 */     super.func_70037_a(p_70037_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_82329_d() {
/* 117 */     return this.field_70522_e.field_75703_B;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_82330_g() {
/* 122 */     return this.field_70522_e.field_75704_C;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_110128_b(Entity p_110128_1_) {
/* 127 */     if (p_110128_1_ instanceof EntityPlayer) {
/* 128 */       EntityPlayer entityPlayer = (EntityPlayer)p_110128_1_;
/*     */       
/* 130 */       if (entityPlayer.field_71075_bZ.field_75098_d) {
/*     */         return;
/*     */       }
/*     */     } 
/*     */     
/* 135 */     func_70099_a(new ItemStack(Items.field_151159_an), 0.0F);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\item\EntityPainting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */