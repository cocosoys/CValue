/*     */ package net.minecraft.entity.item;
/*     */ 
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.command.IEntitySelector;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.tileentity.IHopper;
/*     */ import net.minecraft.tileentity.TileEntityHopper;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class EntityMinecartHopper
/*     */   extends EntityMinecartContainer
/*     */   implements IHopper
/*     */ {
/*     */   private boolean field_96113_a = true;
/*  20 */   private int field_98044_b = -1;
/*     */   
/*     */   public EntityMinecartHopper(World p_i1720_1_) {
/*  23 */     super(p_i1720_1_);
/*     */   }
/*     */   private static final String __OBFID = "CL_00001676";
/*     */   public EntityMinecartHopper(World p_i1721_1_, double p_i1721_2_, double p_i1721_4_, double p_i1721_6_) {
/*  27 */     super(p_i1721_1_, p_i1721_2_, p_i1721_4_, p_i1721_6_);
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_94087_l() {
/*  32 */     return 5;
/*     */   }
/*     */ 
/*     */   
/*     */   public Block func_145817_o() {
/*  37 */     return (Block)Blocks.field_150438_bZ;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_94085_r() {
/*  42 */     return 1;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_70302_i_() {
/*  47 */     return 5;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_130002_c(EntityPlayer p_130002_1_) {
/*  52 */     if (!this.field_70170_p.field_72995_K) {
/*  53 */       p_130002_1_.func_96125_a(this);
/*     */     }
/*     */     
/*  56 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_96095_a(int p_96095_1_, int p_96095_2_, int p_96095_3_, boolean p_96095_4_) {
/*  61 */     boolean bool = !p_96095_4_;
/*     */     
/*  63 */     if (bool != func_96111_ay()) {
/*  64 */       func_96110_f(bool);
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean func_96111_ay() {
/*  69 */     return this.field_96113_a;
/*     */   }
/*     */   
/*     */   public void func_96110_f(boolean p_96110_1_) {
/*  73 */     this.field_96113_a = p_96110_1_;
/*     */   }
/*     */ 
/*     */   
/*     */   public World func_145831_w() {
/*  78 */     return this.field_70170_p;
/*     */   }
/*     */ 
/*     */   
/*     */   public double func_96107_aA() {
/*  83 */     return this.field_70165_t;
/*     */   }
/*     */ 
/*     */   
/*     */   public double func_96109_aB() {
/*  88 */     return this.field_70163_u;
/*     */   }
/*     */ 
/*     */   
/*     */   public double func_96108_aC() {
/*  93 */     return this.field_70161_v;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70071_h_() {
/*  98 */     super.func_70071_h_();
/*     */     
/* 100 */     if (!this.field_70170_p.field_72995_K && func_70089_S() && func_96111_ay()) {
/* 101 */       this.field_98044_b--;
/* 102 */       if (!func_98043_aE()) {
/* 103 */         func_98042_n(0);
/*     */         
/* 105 */         if (func_96112_aD()) {
/* 106 */           func_98042_n(4);
/* 107 */           func_70296_d();
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean func_96112_aD() {
/* 114 */     if (TileEntityHopper.func_145891_a(this)) return true;
/*     */     
/* 116 */     List<EntityItem> list = this.field_70170_p.func_82733_a(EntityItem.class, this.field_70121_D.func_72314_b(0.25D, 0.0D, 0.25D), IEntitySelector.field_94557_a);
/*     */     
/* 118 */     if (list.size() > 0) {
/* 119 */       TileEntityHopper.func_145898_a(this, list.get(0));
/*     */     }
/*     */     
/* 122 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_94095_a(DamageSource p_94095_1_) {
/* 127 */     super.func_94095_a(p_94095_1_);
/*     */     
/* 129 */     func_145778_a(Item.func_150898_a((Block)Blocks.field_150438_bZ), 1, 0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70014_b(NBTTagCompound p_70014_1_) {
/* 134 */     super.func_70014_b(p_70014_1_);
/* 135 */     p_70014_1_.func_74768_a("TransferCooldown", this.field_98044_b);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70037_a(NBTTagCompound p_70037_1_) {
/* 140 */     super.func_70037_a(p_70037_1_);
/* 141 */     this.field_98044_b = p_70037_1_.func_74762_e("TransferCooldown");
/*     */   }
/*     */   
/*     */   public void func_98042_n(int p_98042_1_) {
/* 145 */     this.field_98044_b = p_98042_1_;
/*     */   }
/*     */   
/*     */   public boolean func_98043_aE() {
/* 149 */     return (this.field_98044_b > 0);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\item\EntityMinecartHopper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */