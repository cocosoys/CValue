/*    */ package net.minecraft.entity.ai;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import net.minecraft.entity.EntityCreature;
/*    */ import net.minecraft.pathfinding.PathEntity;
/*    */ import net.minecraft.util.MathHelper;
/*    */ import net.minecraft.util.Vec3;
/*    */ import net.minecraft.village.Village;
/*    */ import net.minecraft.village.VillageDoorInfo;
/*    */ 
/*    */ public class EntityAIMoveThroughVillage
/*    */   extends EntityAIBase
/*    */ {
/*    */   private EntityCreature field_75420_a;
/*    */   private double field_75418_b;
/*    */   private PathEntity field_75419_c;
/*    */   private VillageDoorInfo field_75416_d;
/*    */   private boolean field_75417_e;
/* 20 */   private List field_75415_f = new ArrayList();
/*    */   
/*    */   public EntityAIMoveThroughVillage(EntityCreature p_i1638_1_, double p_i1638_2_, boolean p_i1638_4_) {
/* 23 */     this.field_75420_a = p_i1638_1_;
/* 24 */     this.field_75418_b = p_i1638_2_;
/* 25 */     this.field_75417_e = p_i1638_4_;
/* 26 */     func_75248_a(1);
/*    */   }
/*    */   private static final String __OBFID = "CL_00001597";
/*    */   
/*    */   public boolean func_75250_a() {
/* 31 */     func_75414_f();
/*    */     
/* 33 */     if (this.field_75417_e && this.field_75420_a.field_70170_p.func_72935_r()) return false;
/*    */     
/* 35 */     Village village = this.field_75420_a.field_70170_p.field_72982_D.func_75550_a(MathHelper.func_76128_c(this.field_75420_a.field_70165_t), MathHelper.func_76128_c(this.field_75420_a.field_70163_u), MathHelper.func_76128_c(this.field_75420_a.field_70161_v), 0);
/* 36 */     if (village == null) return false;
/*    */     
/* 38 */     this.field_75416_d = func_75412_a(village);
/* 39 */     if (this.field_75416_d == null) return false;
/*    */     
/* 41 */     boolean bool = this.field_75420_a.func_70661_as().func_75507_c();
/* 42 */     this.field_75420_a.func_70661_as().func_75498_b(false);
/* 43 */     this.field_75419_c = this.field_75420_a.func_70661_as().func_75488_a(this.field_75416_d.field_75481_a, this.field_75416_d.field_75479_b, this.field_75416_d.field_75480_c);
/* 44 */     this.field_75420_a.func_70661_as().func_75498_b(bool);
/* 45 */     if (this.field_75419_c != null) return true;
/*    */     
/* 47 */     Vec3 vec3 = RandomPositionGenerator.func_75464_a(this.field_75420_a, 10, 7, Vec3.func_72443_a(this.field_75416_d.field_75481_a, this.field_75416_d.field_75479_b, this.field_75416_d.field_75480_c));
/* 48 */     if (vec3 == null) return false; 
/* 49 */     this.field_75420_a.func_70661_as().func_75498_b(false);
/* 50 */     this.field_75419_c = this.field_75420_a.func_70661_as().func_75488_a(vec3.field_72450_a, vec3.field_72448_b, vec3.field_72449_c);
/* 51 */     this.field_75420_a.func_70661_as().func_75498_b(bool);
/* 52 */     return (this.field_75419_c != null);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_75253_b() {
/* 57 */     if (this.field_75420_a.func_70661_as().func_75500_f()) return false; 
/* 58 */     float f = this.field_75420_a.field_70130_N + 4.0F;
/* 59 */     return (this.field_75420_a.func_70092_e(this.field_75416_d.field_75481_a, this.field_75416_d.field_75479_b, this.field_75416_d.field_75480_c) > (f * f));
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_75249_e() {
/* 64 */     this.field_75420_a.func_70661_as().func_75484_a(this.field_75419_c, this.field_75418_b);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_75251_c() {
/* 69 */     if (this.field_75420_a.func_70661_as().func_75500_f() || this.field_75420_a.func_70092_e(this.field_75416_d.field_75481_a, this.field_75416_d.field_75479_b, this.field_75416_d.field_75480_c) < 16.0D) this.field_75415_f.add(this.field_75416_d); 
/*    */   }
/*    */   
/*    */   private VillageDoorInfo func_75412_a(Village p_75412_1_) {
/* 73 */     VillageDoorInfo villageDoorInfo = null;
/* 74 */     int i = Integer.MAX_VALUE;
/* 75 */     List list = p_75412_1_.func_75558_f();
/* 76 */     for (VillageDoorInfo villageDoorInfo1 : list) {
/* 77 */       int j = villageDoorInfo1.func_75474_b(MathHelper.func_76128_c(this.field_75420_a.field_70165_t), MathHelper.func_76128_c(this.field_75420_a.field_70163_u), MathHelper.func_76128_c(this.field_75420_a.field_70161_v));
/* 78 */       if (j >= i || 
/* 79 */         func_75413_a(villageDoorInfo1))
/* 80 */         continue;  villageDoorInfo = villageDoorInfo1;
/* 81 */       i = j;
/*    */     } 
/*    */     
/* 84 */     return villageDoorInfo;
/*    */   }
/*    */   
/*    */   private boolean func_75413_a(VillageDoorInfo p_75413_1_) {
/* 88 */     for (VillageDoorInfo villageDoorInfo : this.field_75415_f) {
/* 89 */       if (p_75413_1_.field_75481_a == villageDoorInfo.field_75481_a && p_75413_1_.field_75479_b == villageDoorInfo.field_75479_b && p_75413_1_.field_75480_c == villageDoorInfo.field_75480_c) return true; 
/* 90 */     }  return false;
/*    */   }
/*    */   
/*    */   private void func_75414_f() {
/* 94 */     if (this.field_75415_f.size() > 15) this.field_75415_f.remove(0); 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\ai\EntityAIMoveThroughVillage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */