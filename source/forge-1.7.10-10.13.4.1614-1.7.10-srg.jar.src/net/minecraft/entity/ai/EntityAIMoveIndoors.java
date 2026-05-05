/*    */ package net.minecraft.entity.ai;
/*    */ 
/*    */ import net.minecraft.entity.EntityCreature;
/*    */ import net.minecraft.util.MathHelper;
/*    */ import net.minecraft.util.Vec3;
/*    */ import net.minecraft.village.Village;
/*    */ import net.minecraft.village.VillageDoorInfo;
/*    */ 
/*    */ public class EntityAIMoveIndoors
/*    */   extends EntityAIBase
/*    */ {
/*    */   private EntityCreature field_75424_a;
/*    */   private VillageDoorInfo field_75422_b;
/* 14 */   private int field_75423_c = -1; private int field_75421_d = -1; private static final String __OBFID = "CL_00001596";
/*    */   
/*    */   public EntityAIMoveIndoors(EntityCreature p_i1637_1_) {
/* 17 */     this.field_75424_a = p_i1637_1_;
/* 18 */     func_75248_a(1);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_75250_a() {
/* 23 */     int i = MathHelper.func_76128_c(this.field_75424_a.field_70165_t);
/* 24 */     int j = MathHelper.func_76128_c(this.field_75424_a.field_70163_u);
/* 25 */     int k = MathHelper.func_76128_c(this.field_75424_a.field_70161_v);
/* 26 */     if ((this.field_75424_a.field_70170_p.func_72935_r() && !this.field_75424_a.field_70170_p.func_72896_J() && this.field_75424_a.field_70170_p.func_72807_a(i, k).func_76738_d()) || this.field_75424_a.field_70170_p.field_73011_w.field_76576_e) return false; 
/* 27 */     if (this.field_75424_a.func_70681_au().nextInt(50) != 0) return false; 
/* 28 */     if (this.field_75423_c != -1 && this.field_75424_a.func_70092_e(this.field_75423_c, this.field_75424_a.field_70163_u, this.field_75421_d) < 4.0D) return false; 
/* 29 */     Village village = this.field_75424_a.field_70170_p.field_72982_D.func_75550_a(i, j, k, 14);
/* 30 */     if (village == null) return false; 
/* 31 */     this.field_75422_b = village.func_75569_c(i, j, k);
/* 32 */     return (this.field_75422_b != null);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_75253_b() {
/* 37 */     return !this.field_75424_a.func_70661_as().func_75500_f();
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_75249_e() {
/* 42 */     this.field_75423_c = -1;
/* 43 */     if (this.field_75424_a.func_70092_e(this.field_75422_b.func_75471_a(), this.field_75422_b.field_75479_b, this.field_75422_b.func_75472_c()) > 256.0D)
/* 44 */     { Vec3 vec3 = RandomPositionGenerator.func_75464_a(this.field_75424_a, 14, 3, Vec3.func_72443_a(this.field_75422_b.func_75471_a() + 0.5D, this.field_75422_b.func_75473_b(), this.field_75422_b.func_75472_c() + 0.5D));
/* 45 */       if (vec3 != null) this.field_75424_a.func_70661_as().func_75492_a(vec3.field_72450_a, vec3.field_72448_b, vec3.field_72449_c, 1.0D);  }
/* 46 */     else { this.field_75424_a.func_70661_as().func_75492_a(this.field_75422_b.func_75471_a() + 0.5D, this.field_75422_b.func_75473_b(), this.field_75422_b.func_75472_c() + 0.5D, 1.0D); }
/*    */   
/*    */   }
/*    */   
/*    */   public void func_75251_c() {
/* 51 */     this.field_75423_c = this.field_75422_b.func_75471_a();
/* 52 */     this.field_75421_d = this.field_75422_b.func_75472_c();
/* 53 */     this.field_75422_b = null;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\ai\EntityAIMoveIndoors.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */