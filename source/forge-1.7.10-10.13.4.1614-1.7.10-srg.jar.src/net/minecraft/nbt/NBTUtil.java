/*    */ package net.minecraft.nbt;
/*    */ 
/*    */ import com.mojang.authlib.GameProfile;
/*    */ import com.mojang.authlib.properties.Property;
/*    */ import java.util.UUID;
/*    */ import net.minecraft.util.StringUtils;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class NBTUtil
/*    */ {
/*    */   private static final String __OBFID = "CL_00001901";
/*    */   
/*    */   public static GameProfile func_152459_a(NBTTagCompound p_152459_0_) {
/* 16 */     String str1 = null;
/* 17 */     String str2 = null;
/*    */     
/* 19 */     if (p_152459_0_.func_150297_b("Name", 8)) {
/* 20 */       str1 = p_152459_0_.func_74779_i("Name");
/*    */     }
/* 22 */     if (p_152459_0_.func_150297_b("Id", 8)) {
/* 23 */       str2 = p_152459_0_.func_74779_i("Id");
/*    */     }
/*    */     
/* 26 */     if (!StringUtils.func_151246_b(str1) || !StringUtils.func_151246_b(str2)) {
/*    */       UUID uUID;
/*    */       try {
/* 29 */         uUID = UUID.fromString(str2);
/* 30 */       } catch (Throwable throwable) {
/* 31 */         uUID = null;
/*    */       } 
/* 33 */       GameProfile gameProfile = new GameProfile(uUID, str1);
/*    */       
/* 35 */       if (p_152459_0_.func_150297_b("Properties", 10)) {
/* 36 */         NBTTagCompound nBTTagCompound = p_152459_0_.func_74775_l("Properties");
/*    */         
/* 38 */         for (String str : nBTTagCompound.func_150296_c()) {
/* 39 */           NBTTagList nBTTagList = nBTTagCompound.func_150295_c(str, 10);
/* 40 */           for (byte b = 0; b < nBTTagList.func_74745_c(); b++) {
/* 41 */             NBTTagCompound nBTTagCompound1 = nBTTagList.func_150305_b(b);
/* 42 */             String str3 = nBTTagCompound1.func_74779_i("Value");
/*    */             
/* 44 */             if (nBTTagCompound1.func_150297_b("Signature", 8)) {
/* 45 */               gameProfile.getProperties().put(str, new Property(str, str3, nBTTagCompound1.func_74779_i("Signature")));
/*    */             } else {
/* 47 */               gameProfile.getProperties().put(str, new Property(str, str3));
/*    */             } 
/*    */           } 
/*    */         } 
/*    */       } 
/*    */       
/* 53 */       return gameProfile;
/*    */     } 
/* 55 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public static void func_152460_a(NBTTagCompound p_152460_0_, GameProfile p_152460_1_) {
/* 60 */     if (!StringUtils.func_151246_b(p_152460_1_.getName())) {
/* 61 */       p_152460_0_.func_74778_a("Name", p_152460_1_.getName());
/*    */     }
/* 63 */     if (p_152460_1_.getId() != null) {
/* 64 */       p_152460_0_.func_74778_a("Id", p_152460_1_.getId().toString());
/*    */     }
/* 66 */     if (!p_152460_1_.getProperties().isEmpty()) {
/* 67 */       NBTTagCompound nBTTagCompound = new NBTTagCompound();
/* 68 */       for (String str : p_152460_1_.getProperties().keySet()) {
/* 69 */         NBTTagList nBTTagList = new NBTTagList();
/* 70 */         for (Property property : p_152460_1_.getProperties().get(str)) {
/* 71 */           NBTTagCompound nBTTagCompound1 = new NBTTagCompound();
/* 72 */           nBTTagCompound1.func_74778_a("Value", property.getValue());
/* 73 */           if (property.hasSignature()) {
/* 74 */             nBTTagCompound1.func_74778_a("Signature", property.getSignature());
/*    */           }
/* 76 */           nBTTagList.func_74742_a(nBTTagCompound1);
/*    */         } 
/* 78 */         nBTTagCompound.func_74782_a(str, nBTTagList);
/*    */       } 
/* 80 */       p_152460_0_.func_74782_a("Properties", nBTTagCompound);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\nbt\NBTUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */