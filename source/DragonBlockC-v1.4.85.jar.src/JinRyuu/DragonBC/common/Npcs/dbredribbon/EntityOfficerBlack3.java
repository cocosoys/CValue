/*    */ package JinRyuu.DragonBC.common.Npcs.dbredribbon;
/*    */ 
/*    */ import JinRyuu.JRMCore.entity.EntityPrjtls_1;
/*    */ import java.util.Random;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.SharedMonsterAttributes;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class EntityOfficerBlack3 extends EntityRedRibbon {
/* 10 */   public final int AttPow = 170;
/* 11 */   public final int HePo = 480;
/*    */   
/*    */   private int lastShot;
/*    */   
/*    */   private boolean shot;
/*    */   
/*    */   public EntityOfficerBlack3(World world) {
/* 18 */     super(world);
/* 19 */     this.texture = "officer_black_mecha";
/* 20 */     func_70105_a(1.5F, 2.8F);
/* 21 */     this.lastShot = -1;
/* 22 */     this.shot = false;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_110147_ax() {
/* 27 */     super.func_110147_ax();
/* 28 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(480.0D);
/* 29 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(170.0D);
/*    */   }
/*    */   
/*    */   public long BattlePowerOld() {
/* 33 */     int BP = 16320000;
/* 34 */     int exp = this.field_70728_aV * 100;
/* 35 */     long BattlePower = (BP + this.field_70146_Z.nextInt((int)Math.pow(10.0D, ((BP + "").length() - 2))));
/* 36 */     return BattlePower;
/*    */   }
/*    */   
/*    */   public void func_70071_h_() {
/* 40 */     super.func_70071_h_();
/*    */     
/* 42 */     if (!this.field_70170_p.field_72995_K && !this.field_70128_L && this.field_70789_a != null && this.field_70789_a.func_70089_S() && this.field_70789_a.func_70032_d((Entity)this) < 25.0F) {
/*    */       
/* 44 */       if (this.lastShot == -1)
/*    */       {
/* 46 */         this.lastShot = (new Random()).nextInt(2);
/*    */       }
/*    */ 
/*    */       
/* 50 */       if (this.lastShot == 0) {
/*    */         
/* 52 */         if ((this.field_70173_aa + 200) % 400 < 15)
/*    */         {
/* 54 */           EntityPrjtls_1 var8 = new EntityPrjtls_1(this.field_70170_p, (Entity)this, this.field_70789_a, 1.8F, 1.0F, 6);
/* 55 */           this.field_70170_p.func_72956_a((Entity)this, "jinryuudragonbc:DBC5.gun_shot_single", 0.2F, this.field_70170_p.field_73012_v.nextFloat() * 0.1F + 0.9F);
/* 56 */           this.field_70170_p.func_72838_d((Entity)var8);
/* 57 */           this.shot = true;
/*    */         }
/* 59 */         else if (this.shot)
/*    */         {
/* 61 */           this.lastShot = -1;
/* 62 */           this.shot = false;
/*    */         
/*    */         }
/*    */ 
/*    */       
/*    */       }
/* 68 */       else if (this.field_70173_aa % 100 == 0) {
/*    */         
/* 70 */         EntityPrjtls_1 var8 = new EntityPrjtls_1(this.field_70170_p, (Entity)this, this.field_70789_a, 1.8F, 1.0F, 2);
/* 71 */         this.field_70170_p.func_72956_a((Entity)this, "jinryuudragonbc:DBC4.rocket_shot", 0.6F, this.field_70170_p.field_73012_v.nextFloat() * 0.1F + 0.9F);
/* 72 */         this.field_70170_p.func_72838_d((Entity)var8);
/* 73 */         this.shot = true;
/*    */       }
/* 75 */       else if (this.shot) {
/*    */         
/* 77 */         this.lastShot = -1;
/* 78 */         this.shot = false;
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\dbredribbon\EntityOfficerBlack3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */