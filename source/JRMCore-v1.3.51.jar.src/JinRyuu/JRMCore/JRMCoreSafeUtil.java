/*    */ package JinRyuu.JRMCore;
/*    */ 
/*    */ import java.io.BufferedReader;
/*    */ import java.io.BufferedWriter;
/*    */ import java.io.File;
/*    */ import java.io.FileInputStream;
/*    */ import java.io.FileNotFoundException;
/*    */ import java.io.FileOutputStream;
/*    */ import java.io.InputStreamReader;
/*    */ import java.io.OutputStreamWriter;
/*    */ import java.io.UnsupportedEncodingException;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraft.world.storage.ISaveHandler;
/*    */ import net.minecraft.world.storage.SaveHandler;
/*    */ 
/*    */ public class JRMCoreSafeUtil
/*    */ {
/*    */   public static BufferedReader getReader(File file) throws UnsupportedEncodingException, FileNotFoundException {
/* 19 */     return new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF8"));
/*    */   }
/*    */   
/*    */   public static File getWorldSaveDir(World world) {
/* 23 */     ISaveHandler isavehandler = world.func_72860_G();
/*    */     
/* 25 */     if (isavehandler instanceof SaveHandler) {
/* 26 */       return ((SaveHandler)isavehandler).func_75765_b();
/*    */     }
/* 28 */     return null;
/*    */   }
/*    */   
/*    */   public static BufferedWriter getWriter(File file) throws UnsupportedEncodingException, FileNotFoundException {
/* 32 */     return new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF8"));
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\JRMCoreSafeUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */