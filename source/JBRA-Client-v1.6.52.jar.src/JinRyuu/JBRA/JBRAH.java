/*    */ package JinRyuu.JBRA;
/*    */ import net.minecraft.client.model.ModelRenderer;
/*    */ 
/*    */ public class JBRAH {
/*    */   public static ModelRenderer H;
/*    */   public static ModelRenderer RA;
/*    */   public static ModelRenderer LA;
/*    */   public static ModelRenderer RL;
/*    */   public static ModelRenderer LL;
/*    */   public static ModelRenderer B;
/*    */   
/*    */   public static Object skinData(EntityPlayer acp) {
/* 13 */     if (acp == null) return null; 
/* 14 */     Object[] o = (Object[])JHDSkinsExtender.SList.get(acp.func_70005_c_());
/* 15 */     if (o == null) return null;
/*    */     
/* 17 */     return o[1];
/*    */   } public static ModelRenderer B1; public static ModelRenderer B2; public static ModelRenderer B3; public static ModelRenderer B4; public static ModelRenderer B5; public static ModelRenderer B7; public static ModelRenderer B9;
/*    */   public static boolean JHDS() {
/* 20 */     return Loader.isModLoaded("jinryuuhdskinsextended");
/*    */   }
/* 22 */   public static ResourceLocation getSkinLoc(Object data) { return ((SkinData)data).getCapeLocation(); } public static boolean getSkinHas(Object data) {
/* 23 */     return (data != null && ((SkinData)data).image != null);
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JBRA-Client-v1.6.52.jar!\JinRyuu\JBRA\JBRAH.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */