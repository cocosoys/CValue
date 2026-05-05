/*     */ package JinRyuu.JRMCore;
/*     */ 
/*     */ import JinRyuu.JRMCore.client.JGRecipeHandler;
/*     */ import JinRyuu.JRMCore.client.config.jrmc.JGConfigClientSettings;
/*     */ import JinRyuu.JRMCore.entity.EntitiesJRMC;
/*     */ import JinRyuu.JRMCore.entity.EntityCusPar;
/*     */ import JinRyuu.JRMCore.items.GiTurtleMdl;
/*     */ import cpw.mods.fml.client.registry.ClientRegistry;
/*     */ import cpw.mods.fml.common.FMLCommonHandler;
/*     */ import cpw.mods.fml.common.network.simpleimpl.MessageContext;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.model.ModelBiped;
/*     */ import net.minecraft.client.particle.EntityFX;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.world.World;
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
/*     */ public class JRMCoreClient
/*     */   extends JRMCore
/*     */ {
/*  53 */   public static Minecraft mc = Minecraft.func_71410_x();
/*     */   static JRMCoreGui JFCGui;
/*     */   public static JRMCoreGuiBars bars;
/*  56 */   public static JRMCorePacHanC phc = new JRMCorePacHanC();
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*  59 */   public static final ModelBiped armor1 = (ModelBiped)new GiTurtleMdl(0.205F);
/*     */   @SideOnly(Side.CLIENT)
/*  61 */   public static final ModelBiped armor2 = (ModelBiped)new GiTurtleMdl(0.11F);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void initialize() {
/*  69 */     super.initialize();
/*     */ 
/*     */     
/*  72 */     FMLCommonHandler.instance().bus().register(new JRMCoreCliTicH(mc));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void postInit() {
/*  78 */     super.postInit();
/*  79 */     JRMCoreA.actionInit();
/*  80 */     JGRecipeHandler.registerRecipes();
/*     */   }
/*     */   
/*     */   public void registerRenderThings() {
/*  84 */     JFCGui = new JRMCoreGui();
/*  85 */     bars = new JRMCoreGuiBars();
/*  86 */     EntitiesJRMC.client();
/*     */   }
/*     */   
/*     */   public void registerKeys() {
/*  90 */     ClientRegistry.registerKeyBinding(JRMCoreKeyHandler.DS);
/*  91 */     ClientRegistry.registerKeyBinding(JRMCoreKeyHandler.Fn);
/*  92 */     ClientRegistry.registerKeyBinding(JRMCoreKeyHandler.actionMenu);
/*  93 */     ClientRegistry.registerKeyBinding(JRMCoreKeyHandler.KiCharge);
/*  94 */     ClientRegistry.registerKeyBinding(JRMCoreKeyHandler.KiAscend);
/*  95 */     ClientRegistry.registerKeyBinding(JRMCoreKeyHandler.KiDescend);
/*  96 */     ClientRegistry.registerKeyBinding(JRMCoreKeyHandler.KiDash);
/*  97 */     ClientRegistry.registerKeyBinding(JRMCoreKeyHandler.lockOn);
/*  98 */     ClientRegistry.registerKeyBinding(JRMCoreKeyHandler.KiFlight);
/*  99 */     ClientRegistry.registerKeyBinding(JRMCoreKeyHandler.Sagasys);
/* 100 */     ClientRegistry.registerKeyBinding(JRMCoreKeyHandler.infopanel);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerTicks() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EntityPlayer getPlayerEntity(MessageContext ctx) {
/* 115 */     return ctx.side.isClient() ? (EntityPlayer)mc.field_71439_g : super.getPlayerEntity(ctx);
/*     */   }
/*     */   
/* 118 */   public EntityPlayer getPlayerEntity() { return (EntityPlayer)mc.field_71439_g; } public EntityPlayer getPlayerClient() {
/* 119 */     return (EntityPlayer)mc.field_71439_g;
/*     */   }
/*     */ 
/*     */   
/*     */   public void generateDamIndParticles(double x, double y, double z, double amount, float timeleft) {
/* 124 */     double motionX = (getPlayerClient()).field_70170_p.field_73012_v.nextGaussian() * 0.02D;
/* 125 */     double motionY = (getPlayerClient()).field_70170_p.field_73012_v.nextGaussian() * 0.02D;
/* 126 */     double motionZ = (getPlayerClient()).field_70170_p.field_73012_v.nextGaussian() * 0.02D;
/*     */     
/* 128 */     JRMCoreDamInd jRMCoreDamInd = new JRMCoreDamInd(amount, timeleft, (getPlayerClient()).field_70170_p, x, y, z, 0.0D, 0.0D, 0.0D);
/*     */     
/* 130 */     mc.field_71452_i.func_78873_a((EntityFX)jRMCoreDamInd);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_gcp(Entity entity, EntityCusPar e, double poX, double poY, double poZ, double moX, double moY, double moZ) {
/* 138 */     for (int i = 0; i < JGConfigClientSettings.get_da1(); i++) {
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
/* 149 */       EntityCusPar entityCusPar = new EntityCusPar(e.getdata3(), entity.field_70170_p, e.field_70131_O, e.field_70130_N, entity.field_70165_t + poX, entity.field_70163_u + poY, entity.field_70161_v + poZ, 0.0D, 0.0D, 0.0D, moX, moY, moZ, 0.0F, (int)(Math.random() * e.getId_max()) + e.getId_min(), e.getId_min(), e.getId_max(), 32, e.getRotate(), e.getMaxRotation_Sp(), e.getRotate2(), e.getMaxRotation_Sp2(), e.getdata1(), e.getrr(), e.getdata2(), e.getdata4(), e.getdata5(), e.getdata6(), e.getdata7(), e.getdata31(), e.getdata8(), e.getdata9(), e.getdata10(), e.getdata11(), e.getdata12(), e.getdata13(), e.getdata14(), e.getdata15(), e.getdata16(), e.getdata20(), e.getdata21(), e.getdata22(), e.getdata23(), e.getdata24(), e.getdata25(), false, -1, false, null);
/*     */ 
/*     */       
/* 152 */       entity.field_70170_p.func_72838_d((Entity)entityCusPar);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_gcp(Entity entity, EntityCusPar e, double poX, double poY, double poZ, double moX, double moY, double moZ, float size_min, float size_max, float size_speed) {
/* 161 */     for (int i = 0; i < JGConfigClientSettings.get_da1(); i++) {
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
/* 172 */       EntityCusPar entityCusPar = new EntityCusPar(e.getdata3(), entity.field_70170_p, e.field_70131_O, e.field_70130_N, entity.field_70165_t + poX, entity.field_70163_u + poY, entity.field_70161_v + poZ, 0.0D, 0.0D, 0.0D, moX, moY, moZ, 0.0F, (int)(Math.random() * e.getId_max()) + e.getId_min(), e.getId_min(), e.getId_max(), 32, e.getRotate(), e.getMaxRotation_Sp(), e.getRotate2(), e.getMaxRotation_Sp2(), e.getdata1(), e.getrr(), e.getdata2(), e.getdata4(), e.getdata5() * size_min, e.getdata6() * size_max, e.getdata7() * size_speed, e.getdata31(), e.getdata8(), e.getdata9(), e.getdata10(), e.getdata11(), e.getdata12(), e.getdata13(), e.getdata14(), e.getdata15(), e.getdata16(), e.getdata20(), e.getdata21(), e.getdata22(), e.getdata23(), e.getdata24(), e.getdata25(), false, -1, false, null);
/*     */       
/* 174 */       entity.field_70170_p.func_72838_d((Entity)entityCusPar);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_gcp(Entity entity, EntityCusPar e, double poX, double poY, double poZ, double moX, double moY, double moZ, float size_min, float size_max, float size_speed, float motion) {
/* 183 */     for (int i = 0; i < JGConfigClientSettings.get_da1(); i++) {
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
/* 194 */       EntityCusPar entityCusPar = new EntityCusPar(e.getdata3(), entity.field_70170_p, e.field_70131_O, e.field_70130_N, entity.field_70165_t + poX, entity.field_70163_u + poY, entity.field_70161_v + poZ, 0.0D, 0.0D, 0.0D, moX, moY, moZ, motion, (int)(Math.random() * e.getId_max()) + e.getId_min(), e.getId_min(), e.getId_max(), 32, e.getRotate(), e.getMaxRotation_Sp(), e.getRotate2(), e.getMaxRotation_Sp2(), e.getdata1(), e.getrr(), e.getdata2(), e.getdata4(), e.getdata5() * size_min, e.getdata6() * size_max, e.getdata7() * size_speed, e.getdata31(), e.getdata8(), e.getdata9(), e.getdata10(), e.getdata11(), e.getdata12(), e.getdata13(), e.getdata14(), e.getdata15(), e.getdata16(), e.getdata20(), e.getdata21(), e.getdata22(), e.getdata23(), e.getdata24(), e.getdata25(), false, -1, false, null);
/*     */       
/* 196 */       entity.field_70170_p.func_72838_d((Entity)entityCusPar);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_gcp(Entity entity, EntityCusPar e, double poX, double poY, double poZ, double moX, double moY, double moZ, float size_min, float size_max, float size_speed, float motion, int death) {
/* 205 */     for (int i = 0; i < JGConfigClientSettings.get_da1(); i++) {
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
/* 216 */       EntityCusPar entityCusPar = new EntityCusPar(e.getdata3(), entity.field_70170_p, e.field_70131_O, e.field_70130_N, entity.field_70165_t + poX, entity.field_70163_u + poY, entity.field_70161_v + poZ, 0.0D, 0.0D, 0.0D, moX, moY, moZ, motion, (int)(Math.random() * e.getId_max()) + e.getId_min(), e.getId_min(), e.getId_max(), 32, e.getRotate(), e.getMaxRotation_Sp(), e.getRotate2(), e.getMaxRotation_Sp2(), e.getdata1(), e.getrr(), death, e.getdata4(), e.getdata5() * size_min, e.getdata6() * size_max, e.getdata7() * size_speed, e.getdata31(), e.getdata8(), e.getdata9(), e.getdata10(), e.getdata11(), e.getdata12(), e.getdata13(), e.getdata14(), e.getdata15(), e.getdata16(), e.getdata20(), e.getdata21(), e.getdata22(), e.getdata23(), e.getdata24(), e.getdata25(), false, -1, false, null);
/*     */       
/* 218 */       entity.field_70170_p.func_72838_d((Entity)entityCusPar);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_gcp(Entity entity, EntityCusPar e, double poX, double poY, double poZ, double moX, double moY, double moZ, int img_s) {
/* 227 */     for (int i = 0; i < JGConfigClientSettings.get_da1(); i++) {
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
/* 238 */       EntityCusPar entityCusPar = new EntityCusPar(e.getdata3(), entity.field_70170_p, e.field_70131_O, e.field_70130_N, entity.field_70165_t + poX, entity.field_70163_u + poY, entity.field_70161_v + poZ, 0.0D, 0.0D, 0.0D, moX, moY, moZ, 0.0F, (int)(Math.random() * e.getId_max()) + e.getId_min(), e.getId_min(), e.getId_max(), img_s, e.getRotate(), e.getMaxRotation_Sp(), e.getRotate2(), e.getMaxRotation_Sp2(), e.getdata1(), e.getrr(), e.getdata2(), e.getdata4(), e.getdata5(), e.getdata6(), e.getdata7(), e.getdata31(), e.getdata8(), e.getdata9(), e.getdata10(), e.getdata11(), e.getdata12(), e.getdata13(), e.getdata14(), e.getdata15(), e.getdata16(), e.getdata20(), e.getdata21(), e.getdata22(), e.getdata23(), e.getdata24(), e.getdata25(), false, -1, false, null);
/*     */ 
/*     */       
/* 241 */       entity.field_70170_p.func_72838_d((Entity)entityCusPar);
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
/*     */   public void func_gcp(String data3, World w, float box1, float box2, double poX, double poY, double poZ, double start_poX, double start_poY, double start_poZ, double moX, double moY, double moZ, float data29, int id, int id_min, int id_max, int data32, boolean rotate, float max_rotation_sp, boolean rotate2, float max_rotation_sp2, int data1, String rr, int data2, int data4, float data5, float data6, float data7, int data31, float data8, float data9, float data10, float data11, float data12, float data13, float data14, float data15, float data16, int data20, float data21, float data22, float data23, float data24, float data25, boolean data33, int data34, boolean data35, Entity ent) {
/* 262 */     for (int i = 0; i < JGConfigClientSettings.get_da1(); i++) {
/* 263 */       EntityCusPar entityCusPar = new EntityCusPar(data3, w, box1, box2, poX, poY, poZ, start_poX, start_poY, start_poZ, moX, moY, moZ, data29, id, id_min, id_max, data32, rotate, max_rotation_sp, rotate2, max_rotation_sp2, data1, rr, data2, data4, data5, data6, data7, data31, data8, data9, data10, data11, data12, data13, data14, data15, data16, data20, data21, data22, data23, data24, data25, data33, data34, data35, ent);
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
/* 279 */       w.func_72838_d((Entity)entityCusPar);
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
/*     */   public void func_gcp(String data3, World w, float box1, float box2, double poX, double poY, double poZ, double start_poX, double start_poY, double start_poZ, double moX, double moY, double moZ, float data29, int id, int id_min, int id_max, int data32, boolean rotate, float max_rotation_sp, boolean rotate2, float max_rotation_sp2, int data1, String rr, int data2, int data4, float data5, float data6, float data7, int data31, float data8, float data9, float data10, float data11, float data12, float data13, float data14, float data15, float data16, int data20, float data21, float data22, float data23, float data24, float data25, boolean data33, int data34, boolean data35) {
/*     */     EntityLivingBase entityLivingBase;
/* 299 */     boolean found = false;
/* 300 */     Entity base = null;
/*     */     
/* 302 */     double minx = poX - 1.0D, miny = poY - 1.0D, minz = poZ - 1.0D;
/* 303 */     double maxx = minx + 2.0D, maxy = miny + 2.0D, maxz = minz + 2.0D;
/* 304 */     List<Entity> var6 = w.func_72839_b(null, AxisAlignedBB.func_72330_a(minx, miny, minz, maxx, maxy, maxz));
/* 305 */     Entity var10 = null;
/*     */     
/* 307 */     for (int var9 = 0; var9 < var6.size(); var9++) {
/*     */       
/* 309 */       var10 = var6.get(var9);
/* 310 */       if (var10 instanceof EntityLivingBase && var10.func_70067_L()) {
/*     */ 
/*     */         
/* 313 */         found = true;
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/*     */     
/* 319 */     if (found)
/*     */     {
/* 321 */       entityLivingBase = (EntityLivingBase)var10;
/*     */     }
/*     */     
/* 324 */     for (int i = 0; i < JGConfigClientSettings.get_da1(); i++) {
/* 325 */       EntityCusPar entityCusPar = new EntityCusPar(data3, w, box1, box2, found ? ((Entity)entityLivingBase).field_70165_t : poX, found ? (((Entity)entityLivingBase).field_70163_u + ((entityLivingBase instanceof net.minecraft.client.entity.EntityPlayerSP) ? -1.6F : 0.0F)) : poY, found ? ((Entity)entityLivingBase).field_70161_v : poZ, start_poX, start_poY, start_poZ, moX, moY, moZ, data29, id, id_min, id_max, data32, rotate, max_rotation_sp, rotate2, max_rotation_sp2, data1, rr, data2, data4, data5, data6, data7, data31, data8, data9, data10, data11, data12, data13, data14, data15, data16, data20, data21, data22, data23, data24, data25, data33, data34, data35, (Entity)entityLivingBase);
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
/* 341 */       w.func_72838_d((Entity)entityCusPar);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\JRMCoreClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */