/*    */ package net.minecraftforge.common.util;
/*    */ 
/*    */ import com.google.common.collect.Maps;
/*    */ import com.mojang.authlib.GameProfile;
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.UUID;
/*    */ import net.minecraft.world.WorldServer;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FakePlayerFactory
/*    */ {
/* 17 */   private static GameProfile MINECRAFT = new GameProfile(UUID.fromString("41C82C87-7AfB-4024-BA57-13D2C99CAE77"), "[Minecraft]");
/*    */   
/* 19 */   private static Map<GameProfile, FakePlayer> fakePlayers = Maps.newHashMap();
/* 20 */   private static FakePlayer MINECRAFT_PLAYER = null;
/*    */ 
/*    */   
/*    */   public static FakePlayer getMinecraft(WorldServer world) {
/* 24 */     if (MINECRAFT_PLAYER == null)
/*    */     {
/* 26 */       MINECRAFT_PLAYER = get(world, MINECRAFT);
/*    */     }
/* 28 */     return MINECRAFT_PLAYER;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static FakePlayer get(WorldServer world, GameProfile username) {
/* 38 */     if (!fakePlayers.containsKey(username)) {
/*    */       
/* 40 */       FakePlayer fakePlayer = new FakePlayer(world, username);
/* 41 */       fakePlayers.put(username, fakePlayer);
/*    */     } 
/*    */     
/* 44 */     return fakePlayers.get(username);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void unloadWorld(WorldServer world) {
/* 49 */     Iterator<Map.Entry<GameProfile, FakePlayer>> itr = fakePlayers.entrySet().iterator();
/* 50 */     while (itr.hasNext()) {
/*    */       
/* 52 */       Map.Entry<GameProfile, FakePlayer> entry = itr.next();
/* 53 */       if (((FakePlayer)entry.getValue()).worldObj == world)
/*    */       {
/* 55 */         itr.remove();
/*    */       }
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\commo\\util\FakePlayerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */