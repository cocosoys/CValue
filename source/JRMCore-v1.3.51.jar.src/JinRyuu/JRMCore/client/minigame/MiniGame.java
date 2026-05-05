/*    */ package JinRyuu.JRMCore.client.minigame;
/*    */ 
/*    */ import JinRyuu.JRMCore.JRMCoreClient;
/*    */ import JinRyuu.JRMCore.JRMCoreGuiScreen;
/*    */ import JinRyuu.JRMCore.JRMCoreH;
/*    */ 
/*    */ public abstract class MiniGame {
/*  8 */   public static final String training1 = JRMCoreH.tjjrmc + ":gui/training1.png";
/*  9 */   public static final String training1gui = JRMCoreH.tjjrmc + ":gui/training1gui.png";
/* 10 */   public static final String[] States = new String[] { "Loading", "Initializing", "Playing", "GameOver" };
/*    */   public static final int STATE_ZERO = 0;
/*    */   public static final int STATE_INIT = 1;
/* 13 */   public int state = 0; public static final int STATE_GAME = 2; public static final int STATE_END = 3;
/* 14 */   public int lvl = 0;
/* 15 */   public int score = 0;
/* 16 */   public int lives = 3;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public JRMCoreGuiScreen getGUIInstance() {
/* 22 */     return JRMCoreGuiScreen.instance;
/*    */   }
/*    */   public abstract void gameReset();
/*    */   public abstract void generateStart();
/*    */   
/*    */   public abstract void chooseReward();
/*    */   
/*    */   public abstract void update(int paramInt1, int paramInt2);
/*    */   
/*    */   public void stateManager(int guiLeft, int guiTop) {
/* 32 */     if (!JRMCoreClient.mc.field_71439_g.field_70170_p.field_72995_K || !JRMCoreClient.mc.func_147113_T())
/*    */     {
/* 34 */       switch (this.state) {
/*    */         case 0:
/* 36 */           gameReset();
/*    */           break;
/*    */         case 1:
/* 39 */           generateStart();
/*    */           break;
/*    */         case 2:
/* 42 */           update(guiLeft, guiTop);
/*    */           break;
/*    */         case 3:
/* 45 */           chooseReward();
/*    */           break;
/*    */       } 
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\client\minigame\MiniGame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */