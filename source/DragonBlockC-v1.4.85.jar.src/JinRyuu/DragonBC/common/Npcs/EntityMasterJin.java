/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ import JinRyuu.DragonBC.common.mod_DragonBC;
/*     */ import JinRyuu.JRMCore.client.config.jrmc.JGConfigClientSettings;
/*     */ import JinRyuu.JRMCore.entity.EntityCusPar;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class EntityMasterJin extends EntityDBCKami {
/*  14 */   public final int HePo = 80000;
/*     */   
/*     */   public EntityMasterJin(World par1World) {
/*  17 */     super(par1World);
/*  18 */     this.name = "Master Jin";
/*     */   }
/*     */   
/*     */   protected void func_110147_ax() {
/*  22 */     super.func_110147_ax();
/*  23 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(80000.0D);
/*     */   }
/*     */   
/*     */   public boolean func_70085_c(EntityPlayer par1EntityPlayer) {
/*  27 */     ItemStack var2 = par1EntityPlayer.field_71071_by.func_70448_g();
/*  28 */     boolean var3 = (var2 != null);
/*     */     
/*  30 */     if (func_70089_S()) {
/*  31 */       par1EntityPlayer.openGui(mod_DragonBC.instance, 9000, par1EntityPlayer.field_70170_p, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v);
/*  32 */       return true;
/*     */     } 
/*  34 */     return super.func_70085_c(par1EntityPlayer);
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String getTexture() {
/*  38 */     return "jinryuudragonbc:npcs/jin.png";
/*     */   }
/*     */   public void func_70071_h_() {
/*  41 */     super.func_70071_h_();
/*  42 */     if (this.field_70170_p.field_72995_K)
/*  43 */       for (int k = 0; k < JGConfigClientSettings.get_da1(); k++) {
/*  44 */         if (JGConfigClientSettings.CLIENT_DA8) {
/*  45 */           EntityMasterJin entityMasterJin = this;
/*  46 */           double posXOth = ((Entity)entityMasterJin).field_70165_t, posYOth = ((Entity)entityMasterJin).field_70163_u, posZOth = ((Entity)entityMasterJin).field_70161_v;
/*     */           
/*  48 */           float red = 141.0F, green = 158.0F, blue = 210.0F;
/*  49 */           float red2 = 215.0F, green2 = 152.0F, blue2 = 219.0F;
/*  50 */           float out = 1.6F, in = 1.5F;
/*  51 */           float life = 0.8F * ((Entity)entityMasterJin).field_70131_O;
/*  52 */           float extra_scale = 0.5F;
/*  53 */           int dea = 50;
/*     */ 
/*     */ 
/*     */           
/*  57 */           double x = Math.random() * 1.600000023841858D - 0.800000011920929D;
/*  58 */           double y = Math.random() * ((Entity)entityMasterJin).field_70131_O - 0.5D;
/*  59 */           double z = Math.random() * 1.600000023841858D - 0.800000011920929D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*  67 */           EntityCusPar entityCusPar2 = new EntityCusPar("jinryuumodscore:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 141.0F, 158.0F, 210.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, true, (Entity)entityMasterJin);
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*  72 */           x = Math.random() * 1.600000023841858D - 0.800000011920929D;
/*  73 */           y = Math.random() * ((Entity)entityMasterJin).field_70131_O - 0.5D;
/*  74 */           z = Math.random() * 1.600000023841858D - 0.800000011920929D;
/*  75 */           ((Entity)entityCusPar2).field_70170_p.func_72838_d((Entity)entityCusPar2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*  83 */           EntityCusPar entityCusPar5 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 141.0F, 158.0F, 210.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, true, (Entity)entityMasterJin);
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*  88 */           ((Entity)entityCusPar2).field_70170_p.func_72838_d((Entity)entityCusPar5);
/*     */ 
/*     */           
/*  91 */           x = Math.random() * 1.5D - 0.75D;
/*  92 */           y = (Math.random() * ((Entity)entityMasterJin).field_70131_O - 0.5D) * 0.800000011920929D;
/*  93 */           z = Math.random() * 1.5D - 0.75D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 101 */           EntityCusPar entityCusPar1 = new EntityCusPar("jinryuumodscore:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 215.0F, 152.0F, 219.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, true, (Entity)entityMasterJin);
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 106 */           x = Math.random() * 1.5D - 0.75D;
/* 107 */           y = (Math.random() * ((Entity)entityMasterJin).field_70131_O - 0.5D) * 0.800000011920929D;
/* 108 */           z = Math.random() * 1.5D - 0.75D;
/* 109 */           ((Entity)entityCusPar1).field_70170_p.func_72838_d((Entity)entityCusPar1);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 117 */           EntityCusPar entityCusPar4 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 215.0F, 152.0F, 219.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, true, (Entity)entityMasterJin);
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 122 */           ((Entity)entityCusPar1).field_70170_p.func_72838_d((Entity)entityCusPar4);
/*     */ 
/*     */           
/* 125 */           float in2 = 0.6F;
/* 126 */           x = Math.random() * 0.6000000238418579D - 0.30000001192092896D;
/* 127 */           y = (Math.random() * ((Entity)entityMasterJin).field_70131_O - 0.5D) * 0.800000011920929D * 0.6000000238418579D;
/* 128 */           z = Math.random() * 0.6000000238418579D - 0.30000001192092896D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 136 */           EntityCusPar entityCusPar3 = new EntityCusPar("jinryuumodscore:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 243.0F, 247.0F, 250.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, true, (Entity)entityMasterJin);
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 141 */           x = Math.random() * 0.6000000238418579D - 0.30000001192092896D;
/* 142 */           y = (Math.random() * ((Entity)entityMasterJin).field_70131_O - 0.5D) * 0.800000011920929D;
/* 143 */           z = Math.random() * 0.6000000238418579D - 0.30000001192092896D;
/* 144 */           ((Entity)entityCusPar3).field_70170_p.func_72838_d((Entity)entityCusPar3);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 152 */           EntityCusPar entityCusPar6 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 243.0F, 247.0F, 250.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, true, (Entity)entityMasterJin);
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 157 */           ((Entity)entityCusPar3).field_70170_p.func_72838_d((Entity)entityCusPar6);
/*     */         } 
/*     */       }  
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\EntityMasterJin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */