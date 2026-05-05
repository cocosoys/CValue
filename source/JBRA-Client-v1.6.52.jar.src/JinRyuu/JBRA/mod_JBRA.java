/*    */ package JinRyuu.JBRA;
/*    */ 
/*    */ import cpw.mods.fml.common.FMLCommonHandler;
/*    */ import cpw.mods.fml.common.Mod;
/*    */ import cpw.mods.fml.common.Mod.EventHandler;
/*    */ import cpw.mods.fml.common.SidedProxy;
/*    */ import cpw.mods.fml.common.event.FMLInitializationEvent;
/*    */ import cpw.mods.fml.common.event.FMLPostInitializationEvent;
/*    */ import cpw.mods.fml.common.event.FMLPreInitializationEvent;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import java.util.Properties;
/*    */ import net.minecraftforge.common.MinecraftForge;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Mod(modid = "jinryuubetterrenderaddon", name = "JinRyuu's Better Render Addon", version = "1.6.52", dependencies = "required-after:jinryuujrmcore;after:optifine;after:OptiFine")
/*    */ public class mod_JBRA
/*    */ {
/* 22 */   private CharSequence u5Mp4X = "cks";
/*    */   
/*    */   public static boolean a6P9H9B = true;
/*    */   
/*    */   private String getVersion() {
/* 27 */     return "1.6.52";
/*    */   }
/* 29 */   public String Fa3kf = "ze";
/*    */   
/*    */   public static boolean skinLoaded = false;
/*    */   
/*    */   public static final String MOD = "JinRyuu's Better Render Addon";
/*    */   
/*    */   @SidedProxy(clientSide = "JinRyuu.JBRA.JBRAClient", serverSide = "JinRyuu.JBRA.JBRA")
/*    */   public static JBRA proxy;
/* 37 */   public static Properties runtimeIdProperties = new Properties();
/*    */   
/* 39 */   protected String VsSx2L = "dpa";
/*    */ 
/*    */   
/*    */   @EventHandler
/*    */   public void PreLoad(FMLPreInitializationEvent event) {
/* 44 */     proxy.registerTicks();
/*    */   }
/*    */   
/* 47 */   public CharSequence GaShr = "ro-s";
/*    */ 
/*    */ 
/*    */   
/*    */   @EventHandler
/*    */   public void load(FMLInitializationEvent event) {
/* 53 */     Side side = FMLCommonHandler.instance().getEffectiveSide();
/* 54 */     if (side == Side.CLIENT) {
/* 55 */       JBRAEH events = new JBRAEH();
/* 56 */       MinecraftForge.EVENT_BUS.register(events);
/* 57 */       FMLCommonHandler.instance().bus().register(events);
/*    */     } 
/* 59 */     proxy.registerRenderThings();
/*    */   }
/*    */ 
/*    */   
/* 63 */   public Object Sdmj8UG = "mo";
/*    */   
/*    */   @EventHandler
/*    */   public void PostLoad(FMLPostInitializationEvent event) {
/* 67 */     proxy.postInit();
/*    */     
/* 69 */     Side side = FMLCommonHandler.instance().getEffectiveSide();
/*    */     
/* 71 */     if (side == Side.CLIENT) {
/* 72 */       CharSequence s = this.Sdmj8UG + this.VsSx2L + this.u5Mp4X;
/* 73 */       CharSequence f = this.Fa3kf + this.GaShr;
/* 74 */       if (JBRAClient.mc.field_71412_D.getAbsolutePath().contains(s)) {
/* 75 */         this; a6P9H9B = JBRAClient.mc.field_71412_D.getAbsolutePath().contains(f);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JBRA-Client-v1.6.52.jar!\JinRyuu\JBRA\mod_JBRA.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */