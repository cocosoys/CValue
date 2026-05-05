/*     */ package JinRyuu.DragonBC.common.Worlds;
/*     */ 
/*     */ import java.util.Random;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.Teleporter;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.WorldServer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WorldTeleporterDBCTelep
/*     */   extends Teleporter
/*     */ {
/*     */   private Random random;
/*     */   private WorldServer worldServerInstance;
/*     */   
/*     */   public WorldTeleporterDBCTelep(WorldServer par1WorldServer) {
/*  22 */     super(par1WorldServer);
/*  23 */     this.worldServerInstance = par1WorldServer;
/*  24 */     this.random = new Random();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_77185_a(Entity entity, double par2, double par4, double par6, float par8) {
/*  29 */     int i = MathHelper.func_76128_c(entity.field_70165_t + 1.0D);
/*  30 */     int j = MathHelper.func_76128_c(entity.field_70163_u);
/*  31 */     int k = MathHelper.func_76128_c(entity.field_70161_v);
/*     */ 
/*     */     
/*  34 */     int k1 = i;
/*  35 */     int l1 = j;
/*  36 */     int i2 = k;
/*  37 */     for (l1 = 250; l1 > 5; l1--) {
/*  38 */       if (this.worldServerInstance.func_147439_a(k1, l1, i2) != Blocks.field_150350_a) {
/*  39 */         placeInExistingPortal((World)this.worldServerInstance, entity, k1, l1, i2);
/*     */         return;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean placeInExistingPortal(World world, Entity entity, int i, int j, int k) {
/*  83 */     int k1 = i;
/*  84 */     int l1 = j;
/*  85 */     int i2 = k;
/*     */     
/*  87 */     double d2 = k1 + 0.5D;
/*  88 */     double d4 = l1 + 0.5D + 4.0D;
/*  89 */     double d6 = i2 + 0.5D;
/*     */     
/*  91 */     entity.func_70012_b(d2 + 0.0D, d4 + 2.0D, d6 + 0.0D, entity.field_70177_z, 0.0F);
/*  92 */     entity.field_70159_w = entity.field_70181_x = entity.field_70179_y = 0.0D;
/*     */     
/*  94 */     d2 -= 3.0D;
/*  95 */     d6 -= 3.0D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 109 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Worlds\WorldTeleporterDBCTelep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */