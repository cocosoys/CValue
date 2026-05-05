/*    */ package JinRyuu.JRMCore.entity;
/*    */ import JinRyuu.JRMCore.blocks.BlockBarrierRender;
/*    */ import JinRyuu.JRMCore.blocks.BlockBarrierTileEntity;
/*    */ import JinRyuu.JRMCore.blocks.BlockBorderRender;
/*    */ import JinRyuu.JRMCore.blocks.BlockBorderTileEntity;
/*    */ import JinRyuu.JRMCore.mod_JRMCore;
/*    */ import cpw.mods.fml.client.registry.ClientRegistry;
/*    */ import cpw.mods.fml.client.registry.RenderingRegistry;
/*    */ import cpw.mods.fml.common.registry.EntityRegistry;
/*    */ import cpw.mods.fml.common.registry.GameRegistry;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.renderer.entity.Render;
/*    */ import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
/*    */ import net.minecraft.entity.Entity;
/*    */ 
/*    */ public class EntitiesJRMC {
/* 18 */   public static int renderId = 100;
/* 19 */   public static int entityID = 0; public static int nextEntityID() {
/* 20 */     entityID++; return entityID;
/*    */   }
/*    */   
/*    */   public static void addEntityClient(Class<? extends Entity> entityClass, Render renderer) {
/* 24 */     RenderingRegistry.registerEntityRenderingHandler(entityClass, renderer);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void addEntityServer(Class<? extends Entity> entityClass, String entityName) {
/* 29 */     addEntityServer(entityClass, entityName, 80, 5);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void addEntityServer(Class<? extends Entity> entityClass, String entityName, int updateFrequency) {
/* 34 */     addEntityServer(entityClass, entityName, 80, updateFrequency, true);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void addEntityServer(Class<? extends Entity> entityClass, String entityName, int trackingRange, int updateFrequency) {
/* 39 */     addEntityServer(entityClass, entityName, trackingRange, updateFrequency, true);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void addEntityServer(Class<? extends Entity> entityClass, String entityName, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates) {
/* 44 */     EntityRegistry.registerModEntity(entityClass, entityName, nextEntityID(), mod_JRMCore.instance, trackingRange, updateFrequency, sendsVelocityUpdates);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public static void client() {
/* 66 */     addEntityClient((Class)EntityEnergyAttJ.class, (Render)new RenderEnergyAttackJutsu());
/* 67 */     addEntityClient((Class)EntityEnergyAttJ2.class, (Render)new RenderEnergyAttJ2());
/* 68 */     addEntityClient((Class)EntityEnergyAttJ3.class, (Render)new RenderEnergyAttJ3());
/* 69 */     addEntityClient((Class)EntityEnergyAttJ4.class, (Render)new RenderEnergyAttJ4());
/* 70 */     addEntityClient((Class)EntityJRMCexpl.class, (Render)new RenderJRMCexpl());
/* 71 */     addEntityClient((Class)EntityEng.class, (Render)new RenderEnergyAttackKiCharge());
/*    */     
/* 73 */     addEntityClient((Class)EntityNPCshadow.class, (Render)new RenderDBC((ModelBase)new ModelNPCNormalScaled(), 0.5F));
/* 74 */     addEntityClient((Class)EntityNull.class, (Render)new RenderNull(new ModelNPCTraining(), 0.5F));
/* 75 */     addEntityClient((Class)EntityAuraFlat.class, (Render)new RenderAuraFlat(new ModelAuraFlat(), 0.5F));
/*    */     
/* 77 */     addEntityClient((Class)EntityCusPar.class, (Render)new RenderCusPar());
/* 78 */     addEntityClient((Class)EntitySafeZone.class, (Render)new RenderSafeZone());
/*    */ 
/*    */     
/* 81 */     ClientRegistry.registerTileEntity(BlockBarrierTileEntity.class, "BlockBarrierTileEntityRemder", (TileEntitySpecialRenderer)new BlockBarrierRender());
/* 82 */     ClientRegistry.registerTileEntity(BlockBorderTileEntity.class, "BlockBorderTileEntityRemder", (TileEntitySpecialRenderer)new BlockBorderRender());
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static void common() {
/* 88 */     EntityRegistry.registerModEntity(EntityEnergyAttJ.class, "JutsuAttack", 104, mod_JRMCore.instance, 80, 5, true);
/*    */ 
/*    */ 
/*    */     
/* 92 */     addEntityServer((Class)EntityEnergyAttJ2.class, "JutsuAttack2");
/* 93 */     addEntityServer((Class)EntityEnergyAttJ3.class, "JutsuAttack3");
/* 94 */     addEntityServer((Class)EntityNPCshadow.class, "TrainingShadowDummy");
/* 95 */     addEntityServer((Class)EntitySafeZone.class, "JGMasterSafeZone");
/*    */ 
/*    */     
/* 98 */     GameRegistry.registerTileEntity(BlockBarrierTileEntity.class, "BlockBarrierTileEntity");
/* 99 */     GameRegistry.registerTileEntity(BlockBorderTileEntity.class, "BlockBorderTileEntity");
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\entity\EntitiesJRMC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */