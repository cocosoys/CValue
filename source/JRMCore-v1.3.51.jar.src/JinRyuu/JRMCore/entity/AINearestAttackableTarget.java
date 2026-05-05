/*    */ package JinRyuu.JRMCore.entity;
/*    */ 
/*    */ import JinRyuu.FamilyC.EntityNPC;
/*    */ import java.util.Collections;
/*    */ import java.util.Comparator;
/*    */ import java.util.List;
/*    */ import net.minecraft.command.IEntitySelector;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityCreature;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AINearestAttackableTarget
/*    */   extends AITarget
/*    */ {
/*    */   private final Class targetClass;
/*    */   private final int targetChance;
/*    */   private final EntityAINearestAttackableTarget.Sorter theNearestAttackableTargetSorter;
/*    */   private final IEntitySelector targetEntitySelector;
/*    */   private EntityLivingBase targetEntity;
/*    */   
/*    */   public AINearestAttackableTarget(EntityCreature par1EntityCreature, Class par2Class, int par3, boolean par4) {
/* 29 */     this(par1EntityCreature, par2Class, par3, par4, false);
/*    */   }
/*    */ 
/*    */   
/*    */   public AINearestAttackableTarget(EntityCreature par1EntityCreature, Class par2Class, int par3, boolean par4, boolean par5) {
/* 34 */     this(par1EntityCreature, par2Class, par3, par4, par5, (IEntitySelector)null);
/*    */   }
/*    */ 
/*    */   
/*    */   public AINearestAttackableTarget(EntityCreature par1EntityCreature, Class par2Class, int par3, boolean par4, boolean par5, IEntitySelector par6IEntitySelector) {
/* 39 */     super(par1EntityCreature, par4, par5);
/* 40 */     this.targetClass = par2Class;
/* 41 */     this.targetChance = par3;
/* 42 */     this.theNearestAttackableTargetSorter = new EntityAINearestAttackableTarget.Sorter((Entity)par1EntityCreature);
/* 43 */     func_75248_a(1);
/* 44 */     this.targetEntitySelector = new AINearestAttackableTargetSelector(this, par6IEntitySelector);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_75250_a() {
/* 53 */     if (this.taskOwner instanceof EntityNPC && !((EntityNPC)this.taskOwner).getAggr()) return false; 
/* 54 */     if (this.targetChance > 0 && this.taskOwner.func_70681_au().nextInt(this.targetChance) != 0)
/*    */     {
/* 56 */       return false;
/*    */     }
/*    */ 
/*    */     
/* 60 */     double d0 = getTargetDistance();
/* 61 */     List<?> list = this.taskOwner.field_70170_p.func_82733_a(this.targetClass, this.taskOwner.field_70121_D.func_72314_b(d0, 4.0D, d0), this.targetEntitySelector);
/* 62 */     Collections.sort(list, (Comparator<?>)this.theNearestAttackableTargetSorter);
/*    */     
/* 64 */     if (list.isEmpty())
/*    */     {
/* 66 */       return false;
/*    */     }
/*    */ 
/*    */     
/* 70 */     this.targetEntity = (EntityLivingBase)list.get(0);
/* 71 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_75249_e() {
/* 81 */     this.taskOwner.func_70624_b(this.targetEntity);
/* 82 */     super.func_75249_e();
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\entity\AINearestAttackableTarget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */