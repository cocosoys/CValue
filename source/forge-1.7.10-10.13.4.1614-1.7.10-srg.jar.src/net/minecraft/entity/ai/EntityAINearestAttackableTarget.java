/*    */ package net.minecraft.entity.ai;
/*    */ import java.util.Collections;
/*    */ import java.util.List;
/*    */ import net.minecraft.command.IEntitySelector;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityCreature;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ 
/*    */ public class EntityAINearestAttackableTarget extends EntityAITarget {
/*    */   private final Class field_75307_b;
/*    */   private final int field_75308_c;
/*    */   private final Sorter field_75306_g;
/*    */   
/*    */   public EntityAINearestAttackableTarget(EntityCreature p_i1663_1_, Class p_i1663_2_, int p_i1663_3_, boolean p_i1663_4_) {
/* 15 */     this(p_i1663_1_, p_i1663_2_, p_i1663_3_, p_i1663_4_, false);
/*    */   }
/*    */   private final IEntitySelector field_82643_g; private EntityLivingBase field_75309_a; private static final String __OBFID = "CL_00001620";
/*    */   public EntityAINearestAttackableTarget(EntityCreature p_i1664_1_, Class p_i1664_2_, int p_i1664_3_, boolean p_i1664_4_, boolean p_i1664_5_) {
/* 19 */     this(p_i1664_1_, p_i1664_2_, p_i1664_3_, p_i1664_4_, p_i1664_5_, (IEntitySelector)null);
/*    */   }
/*    */   
/*    */   public EntityAINearestAttackableTarget(EntityCreature p_i1665_1_, Class p_i1665_2_, int p_i1665_3_, boolean p_i1665_4_, boolean p_i1665_5_, IEntitySelector p_i1665_6_) {
/* 23 */     super(p_i1665_1_, p_i1665_4_, p_i1665_5_);
/* 24 */     this.field_75307_b = p_i1665_2_;
/* 25 */     this.field_75308_c = p_i1665_3_;
/* 26 */     this.field_75306_g = new Sorter((Entity)p_i1665_1_);
/* 27 */     func_75248_a(1);
/*    */     
/* 29 */     this.field_82643_g = new IEntitySelector(this, p_i1665_6_) { private static final String __OBFID = "CL_00001621";
/*    */         
/*    */         public boolean func_82704_a(Entity p_82704_1_) {
/* 32 */           if (!(p_82704_1_ instanceof EntityLivingBase)) return false; 
/* 33 */           if (this.field_111103_c != null && !this.field_111103_c.func_82704_a(p_82704_1_)) return false; 
/* 34 */           return this.field_111102_d.func_75296_a((EntityLivingBase)p_82704_1_, false);
/*    */         } }
/*    */       ;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_75250_a() {
/* 41 */     if (this.field_75308_c > 0 && this.field_75299_d.func_70681_au().nextInt(this.field_75308_c) != 0) return false;
/*    */     
/* 43 */     double d = func_111175_f();
/* 44 */     List<?> list = this.field_75299_d.field_70170_p.func_82733_a(this.field_75307_b, this.field_75299_d.field_70121_D.func_72314_b(d, 4.0D, d), this.field_82643_g);
/* 45 */     Collections.sort(list, this.field_75306_g);
/*    */     
/* 47 */     if (list.isEmpty()) {
/* 48 */       return false;
/*    */     }
/* 50 */     this.field_75309_a = (EntityLivingBase)list.get(0);
/* 51 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_75249_e() {
/* 57 */     this.field_75299_d.func_70624_b(this.field_75309_a);
/* 58 */     super.func_75249_e();
/*    */   }
/*    */   
/*    */   public static class Sorter implements Comparator { private final Entity field_75459_b;
/*    */     private static final String __OBFID = "CL_00001622";
/*    */     
/*    */     public Sorter(Entity p_i1662_1_) {
/* 65 */       this.field_75459_b = p_i1662_1_;
/*    */     }
/*    */ 
/*    */     
/*    */     public int compare(Entity p_compare_1_, Entity p_compare_2_) {
/* 70 */       double d1 = this.field_75459_b.func_70068_e(p_compare_1_);
/* 71 */       double d2 = this.field_75459_b.func_70068_e(p_compare_2_);
/* 72 */       if (d1 < d2) return -1; 
/* 73 */       if (d1 > d2) return 1; 
/* 74 */       return 0;
/*    */     } }
/*    */ 
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\ai\EntityAINearestAttackableTarget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */