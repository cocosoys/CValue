/*    */ package net.minecraft.entity.ai;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.item.EntityMinecart;
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ import net.minecraft.tileentity.MobSpawnerBaseLogic;
/*    */ import net.minecraft.util.MathHelper;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class EntityMinecartMobSpawner extends EntityMinecart {
/* 13 */   private final MobSpawnerBaseLogic field_98040_a = new MobSpawnerBaseLogic(this) { private static final String __OBFID = "CL_00001679";
/*    */       
/*    */       public void func_98267_a(int p_98267_1_) {
/* 16 */         this.field_98296_a.field_70170_p.func_72960_a((Entity)this.field_98296_a, (byte)p_98267_1_);
/*    */       }
/*    */ 
/*    */       
/*    */       public World func_98271_a() {
/* 21 */         return this.field_98296_a.field_70170_p;
/*    */       }
/*    */ 
/*    */       
/*    */       public int func_98275_b() {
/* 26 */         return MathHelper.func_76128_c(this.field_98296_a.field_70165_t);
/*    */       }
/*    */ 
/*    */       
/*    */       public int func_98274_c() {
/* 31 */         return MathHelper.func_76128_c(this.field_98296_a.field_70163_u);
/*    */       }
/*    */ 
/*    */       
/*    */       public int func_98266_d() {
/* 36 */         return MathHelper.func_76128_c(this.field_98296_a.field_70161_v);
/*    */       } }
/*    */   ; private static final String __OBFID = "CL_00001678";
/*    */   
/*    */   public EntityMinecartMobSpawner(World p_i1725_1_) {
/* 41 */     super(p_i1725_1_);
/*    */   }
/*    */   
/*    */   public EntityMinecartMobSpawner(World p_i1726_1_, double p_i1726_2_, double p_i1726_4_, double p_i1726_6_) {
/* 45 */     super(p_i1726_1_, p_i1726_2_, p_i1726_4_, p_i1726_6_);
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_94087_l() {
/* 50 */     return 4;
/*    */   }
/*    */ 
/*    */   
/*    */   public Block func_145817_o() {
/* 55 */     return Blocks.field_150474_ac;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_70037_a(NBTTagCompound p_70037_1_) {
/* 60 */     super.func_70037_a(p_70037_1_);
/* 61 */     this.field_98040_a.func_98270_a(p_70037_1_);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_70014_b(NBTTagCompound p_70014_1_) {
/* 66 */     super.func_70014_b(p_70014_1_);
/* 67 */     this.field_98040_a.func_98280_b(p_70014_1_);
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_70103_a(byte p_70103_1_) {
/* 72 */     this.field_98040_a.func_98268_b(p_70103_1_);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_70071_h_() {
/* 77 */     super.func_70071_h_();
/* 78 */     this.field_98040_a.func_98278_g();
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public MobSpawnerBaseLogic func_98039_d() {
/* 82 */     return this.field_98040_a;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\ai\EntityMinecartMobSpawner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */