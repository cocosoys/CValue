/*    */ package net.minecraftforge.common.util;
/*    */ 
/*    */ import com.mojang.authlib.GameProfile;
/*    */ import cpw.mods.fml.common.FMLCommonHandler;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.entity.player.EntityPlayerMP;
/*    */ import net.minecraft.network.play.client.C15PacketClientSettings;
/*    */ import net.minecraft.server.management.ItemInWorldManager;
/*    */ import net.minecraft.stats.StatBase;
/*    */ import net.minecraft.util.ChunkCoordinates;
/*    */ import net.minecraft.util.DamageSource;
/*    */ import net.minecraft.util.IChatComponent;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraft.world.WorldServer;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FakePlayer
/*    */   extends EntityPlayerMP
/*    */ {
/*    */   public FakePlayer(WorldServer world, GameProfile name) {
/* 22 */     super(FMLCommonHandler.instance().getMinecraftServerInstance(), world, name, new ItemInWorldManager((World)world));
/*    */   }
/*    */   public boolean canCommandSenderUseCommand(int i, String s) {
/* 25 */     return false;
/*    */   } public void addChatComponentMessage(IChatComponent chatmessagecomponent) {} public void addStat(StatBase par1StatBase, int par2) {}
/*    */   public ChunkCoordinates getPlayerCoordinates() {
/* 28 */     return new ChunkCoordinates(0, 0, 0);
/*    */   }
/*    */   
/*    */   public void openGui(Object mod, int modGuiId, World world, int x, int y, int z) {}
/*    */   
/*    */   public boolean isEntityInvulnerable() {
/* 34 */     return true; } public boolean canAttackPlayer(EntityPlayer player) {
/* 35 */     return false;
/*    */   }
/*    */   
/*    */   public void onDeath(DamageSource source) {}
/*    */   
/*    */   public void onUpdate() {}
/*    */   
/*    */   public void travelToDimension(int dim) {}
/*    */   
/*    */   public void func_147100_a(C15PacketClientSettings pkt) {}
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\commo\\util\FakePlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */