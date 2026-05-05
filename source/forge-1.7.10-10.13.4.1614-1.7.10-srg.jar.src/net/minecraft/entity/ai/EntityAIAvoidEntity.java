/*    */ package net.minecraft.entity.ai;
/*    */ 
/*    */ import java.util.List;
/*    */ import net.minecraft.command.IEntitySelector;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityCreature;
/*    */ import net.minecraft.entity.passive.EntityTameable;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.pathfinding.PathEntity;
/*    */ import net.minecraft.pathfinding.PathNavigate;
/*    */ import net.minecraft.util.Vec3;
/*    */ 
/*    */ public class EntityAIAvoidEntity extends EntityAIBase {
/* 14 */   public final IEntitySelector field_98218_a = new IEntitySelector(this)
/*    */     {
/*    */       public boolean func_82704_a(Entity p_82704_1_) {
/* 17 */         return (p_82704_1_.func_70089_S() && this.field_98219_c.field_75380_a.func_70635_at().func_75522_a(p_82704_1_));
/*    */       }
/*    */       private static final String __OBFID = "CL_00001575";
/*    */     };
/*    */   private EntityCreature field_75380_a; private double field_75378_b; private double field_75379_c;
/*    */   private Entity field_75376_d;
/*    */   private float field_75377_e;
/*    */   private PathEntity field_75374_f;
/*    */   private PathNavigate field_75375_g;
/*    */   private Class field_75381_h;
/*    */   private static final String __OBFID = "CL_00001574";
/*    */   
/*    */   public EntityAIAvoidEntity(EntityCreature p_i1616_1_, Class p_i1616_2_, float p_i1616_3_, double p_i1616_4_, double p_i1616_6_) {
/* 30 */     this.field_75380_a = p_i1616_1_;
/* 31 */     this.field_75381_h = p_i1616_2_;
/* 32 */     this.field_75377_e = p_i1616_3_;
/* 33 */     this.field_75378_b = p_i1616_4_;
/* 34 */     this.field_75379_c = p_i1616_6_;
/* 35 */     this.field_75375_g = p_i1616_1_.func_70661_as();
/* 36 */     func_75248_a(1);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_75250_a() {
/* 41 */     if (this.field_75381_h == EntityPlayer.class) {
/* 42 */       if (this.field_75380_a instanceof EntityTameable && ((EntityTameable)this.field_75380_a).func_70909_n()) return false; 
/* 43 */       this.field_75376_d = (Entity)this.field_75380_a.field_70170_p.func_72890_a((Entity)this.field_75380_a, this.field_75377_e);
/* 44 */       if (this.field_75376_d == null) return false; 
/*    */     } else {
/* 46 */       List<Entity> list = this.field_75380_a.field_70170_p.func_82733_a(this.field_75381_h, this.field_75380_a.field_70121_D.func_72314_b(this.field_75377_e, 3.0D, this.field_75377_e), this.field_98218_a);
/* 47 */       if (list.isEmpty()) return false; 
/* 48 */       this.field_75376_d = list.get(0);
/*    */     } 
/*    */     
/* 51 */     Vec3 vec3 = RandomPositionGenerator.func_75461_b(this.field_75380_a, 16, 7, Vec3.func_72443_a(this.field_75376_d.field_70165_t, this.field_75376_d.field_70163_u, this.field_75376_d.field_70161_v));
/* 52 */     if (vec3 == null) return false; 
/* 53 */     if (this.field_75376_d.func_70092_e(vec3.field_72450_a, vec3.field_72448_b, vec3.field_72449_c) < this.field_75376_d.func_70068_e((Entity)this.field_75380_a)) return false; 
/* 54 */     this.field_75374_f = this.field_75375_g.func_75488_a(vec3.field_72450_a, vec3.field_72448_b, vec3.field_72449_c);
/* 55 */     if (this.field_75374_f == null) return false; 
/* 56 */     if (!this.field_75374_f.func_75880_b(vec3)) return false; 
/* 57 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_75253_b() {
/* 62 */     return !this.field_75375_g.func_75500_f();
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_75249_e() {
/* 67 */     this.field_75375_g.func_75484_a(this.field_75374_f, this.field_75378_b);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_75251_c() {
/* 72 */     this.field_75376_d = null;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_75246_d() {
/* 77 */     if (this.field_75380_a.func_70068_e(this.field_75376_d) < 49.0D) { this.field_75380_a.func_70661_as().func_75489_a(this.field_75379_c); }
/* 78 */     else { this.field_75380_a.func_70661_as().func_75489_a(this.field_75378_b); }
/*    */   
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\ai\EntityAIAvoidEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */