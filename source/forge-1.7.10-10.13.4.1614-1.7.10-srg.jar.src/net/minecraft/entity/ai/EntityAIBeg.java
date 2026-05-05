/*    */ package net.minecraft.entity.ai;
/*    */ 
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.passive.EntityWolf;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.init.Items;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class EntityAIBeg
/*    */   extends EntityAIBase
/*    */ {
/*    */   private EntityWolf field_75387_a;
/*    */   private EntityPlayer field_75385_b;
/*    */   private World field_75386_c;
/*    */   
/*    */   public EntityAIBeg(EntityWolf p_i1617_1_, float p_i1617_2_) {
/* 18 */     this.field_75387_a = p_i1617_1_;
/* 19 */     this.field_75386_c = p_i1617_1_.field_70170_p;
/* 20 */     this.field_75383_d = p_i1617_2_;
/* 21 */     func_75248_a(2);
/*    */   }
/*    */   private float field_75383_d; private int field_75384_e; private static final String __OBFID = "CL_00001576";
/*    */   
/*    */   public boolean func_75250_a() {
/* 26 */     this.field_75385_b = this.field_75386_c.func_72890_a((Entity)this.field_75387_a, this.field_75383_d);
/* 27 */     if (this.field_75385_b == null) return false; 
/* 28 */     return func_75382_a(this.field_75385_b);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_75253_b() {
/* 33 */     if (!this.field_75385_b.func_70089_S()) return false; 
/* 34 */     if (this.field_75387_a.func_70068_e((Entity)this.field_75385_b) > (this.field_75383_d * this.field_75383_d)) return false; 
/* 35 */     return (this.field_75384_e > 0 && func_75382_a(this.field_75385_b));
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_75249_e() {
/* 40 */     this.field_75387_a.func_70918_i(true);
/* 41 */     this.field_75384_e = 40 + this.field_75387_a.func_70681_au().nextInt(40);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_75251_c() {
/* 46 */     this.field_75387_a.func_70918_i(false);
/* 47 */     this.field_75385_b = null;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_75246_d() {
/* 52 */     this.field_75387_a.func_70671_ap().func_75650_a(this.field_75385_b.field_70165_t, this.field_75385_b.field_70163_u + this.field_75385_b.func_70047_e(), this.field_75385_b.field_70161_v, 10.0F, this.field_75387_a.func_70646_bf());
/* 53 */     this.field_75384_e--;
/*    */   }
/*    */   
/*    */   private boolean func_75382_a(EntityPlayer p_75382_1_) {
/* 57 */     ItemStack itemStack = p_75382_1_.field_71071_by.func_70448_g();
/* 58 */     if (itemStack == null) return false; 
/* 59 */     if (!this.field_75387_a.func_70909_n() && itemStack.func_77973_b() == Items.field_151103_aS) return true; 
/* 60 */     return this.field_75387_a.func_70877_b(itemStack);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\ai\EntityAIBeg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */