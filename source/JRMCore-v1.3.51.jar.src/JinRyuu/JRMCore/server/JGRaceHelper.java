/*    */ package JinRyuu.JRMCore.server;
/*    */ 
/*    */ import JinRyuu.JRMCore.JRMCoreH;
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class JGRaceHelper
/*    */ {
/*    */   public static boolean isAboveMaxRacialSkill(byte current, boolean dbc, boolean nc, byte race) {
/* 11 */     return (current > getMaxRacialSkillLevel(dbc, nc, race));
/*    */   }
/*    */ 
/*    */   
/*    */   public static boolean isAboveMaxRacialSkill(NBTTagCompound nbt) {
/* 16 */     byte current = getRacialSkillLevel(nbt);
/* 17 */     byte max = getMaxRacialSkillLevel(nbt);
/* 18 */     return (current > max);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static byte getRacialSkillLevel(NBTTagCompound nbt) {
/* 25 */     boolean dbc = (nbt.func_74771_c("jrmcPwrtyp") == 1);
/* 26 */     boolean nc = (nbt.func_74771_c("jrmcPwrtyp") == 2);
/* 27 */     byte race = nbt.func_74771_c("jrmcRace");
/*    */     
/* 29 */     byte currentLevel = 0;
/* 30 */     String key = dbc ? "jrmcSSltX" : "jrmcSSltY";
/* 31 */     if (nbt.func_74764_b(key) && !nbt.func_74779_i(key).contains("pty") && nbt.func_74779_i(key).length() > 1 && (!nc || (
/* 32 */       !nbt.func_74779_i("jrmcSSltY").contains("Sai") && race != 1 && race != 2)))
/*    */     {
/* 34 */       return Byte.parseByte(nbt.func_74779_i(key).substring(2));
/*    */     }
/* 36 */     return -1;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static byte getMaxRacialSkillLevel(NBTTagCompound nbt) {
/* 42 */     boolean dbc = (nbt.func_74771_c("jrmcPwrtyp") == 1);
/* 43 */     boolean nc = (nbt.func_74771_c("jrmcPwrtyp") == 2);
/* 44 */     byte race = nbt.func_74771_c("jrmcRace");
/* 45 */     return getMaxRacialSkillLevel(dbc, nc, race);
/*    */   }
/*    */ 
/*    */   
/* 49 */   public static int[][] RACIAL_SKILL_MAX = new int[][] { { 0, 0, 0, 0, 0, 0, 0 }, { 5, 7, 7, 5, 6, 5, 5 }, { 9, 9, 9, 9, 9, 9, 9 }, { 0, 0, 0, 0, 0, 0, 0 } };
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static byte getMaxRacialSkillLevel(boolean dbc, boolean nc, byte race) {
/* 58 */     if (dbc) {
/*    */       
/* 60 */       if (JRMCoreH.rSai(race)) return 7;
/*    */       
/* 62 */       if (JRMCoreH.isRaceArcosian(race)) return 6; 
/* 63 */       return 5;
/*    */     } 
/* 65 */     if (nc) return 9;
/*    */     
/* 67 */     return 0;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void setRacialSkillToMax(NBTTagCompound nbt) {
/* 74 */     boolean dbc = (nbt.func_74771_c("jrmcPwrtyp") == 1);
/* 75 */     boolean nc = (nbt.func_74771_c("jrmcPwrtyp") == 2);
/* 76 */     byte race = nbt.func_74771_c("jrmcRace");
/* 77 */     setRacialSkill(nbt, getMaxRacialSkillLevel(dbc, nc, race), dbc, nc, race);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static void setRacialSkill(NBTTagCompound nbt, byte value) {
/* 83 */     boolean dbc = (nbt.func_74771_c("jrmcPwrtyp") == 1);
/* 84 */     boolean nc = (nbt.func_74771_c("jrmcPwrtyp") == 2);
/* 85 */     byte race = nbt.func_74771_c("jrmcRace");
/*    */     
/* 87 */     setRacialSkill(nbt, value, dbc, nc, race);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void setRacialSkill(NBTTagCompound nbt, byte value, boolean dbc, boolean nc, byte race) {
/* 92 */     if (dbc || nc) {
/*    */       
/* 94 */       String key = dbc ? "jrmcSSltX" : "jrmcSSltY";
/* 95 */       nbt.func_74778_a(key, (dbc ? JRMCoreH.vlblRSkls[0] : JRMCoreH.ncCSkls[nbt.func_74771_c("jrmcClass")]) + value);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\server\JGRaceHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */