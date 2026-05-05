/*    */ package JinRyuu.DragonBC.common.Npcs;
/*    */ 
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.SharedMonsterAttributes;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.nbt.NBTBase;
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ public class EntityDBCWildlife
/*    */   extends EntityDBC
/*    */ {
/*    */   public EntityDBCWildlife(World par1World) {
/* 15 */     super(par1World);
/*    */   }
/*    */   protected NBTTagCompound nbt(EntityPlayer p, String s) {
/*    */     NBTTagCompound nbt;
/* 19 */     if (s.contains("pres"))
/* 20 */     { if (!p.getEntityData().func_74764_b("PlayerPersisted")) {
/* 21 */         nbt = new NBTTagCompound();
/* 22 */         p.getEntityData().func_74782_a("PlayerPersisted", (NBTBase)nbt);
/*    */       } else {
/* 24 */         nbt = p.getEntityData().func_74775_l("PlayerPersisted");
/*    */       }  }
/* 26 */     else { nbt = p.getEntityData(); }
/*    */     
/* 28 */     return nbt;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_110147_ax() {
/* 33 */     super.func_110147_ax();
/*    */     
/* 35 */     func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(1.0D);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_70014_b(NBTTagCompound par1NBTTagCompound) {
/* 45 */     super.func_70014_b(par1NBTTagCompound);
/* 46 */     par1NBTTagCompound.func_74777_a("Anger", (short)this.angerLevel);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_70037_a(NBTTagCompound par1NBTTagCompound) {
/* 54 */     super.func_70037_a(par1NBTTagCompound);
/* 55 */     this.angerLevel = par1NBTTagCompound.func_74765_d("Anger");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void becomeAngryAt(Entity par1Entity) {
/* 62 */     this.field_70789_a = par1Entity;
/* 63 */     this.angerLevel = 400 + this.field_70146_Z.nextInt(400);
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\EntityDBCWildlife.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */