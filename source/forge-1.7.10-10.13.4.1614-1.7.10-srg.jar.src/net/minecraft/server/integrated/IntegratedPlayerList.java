/*    */ package net.minecraft.server.integrated;
/*    */ import com.mojang.authlib.GameProfile;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import java.net.SocketAddress;
/*    */ import net.minecraft.entity.player.EntityPlayerMP;
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ import net.minecraft.server.management.ServerConfigurationManager;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class IntegratedPlayerList extends ServerConfigurationManager {
/*    */   private NBTTagCompound field_72416_e;
/*    */   
/*    */   public IntegratedPlayerList(IntegratedServer p_i1314_1_) {
/* 14 */     super(p_i1314_1_);
/*    */     
/* 16 */     func_152611_a(10);
/*    */   }
/*    */   private static final String __OBFID = "CL_00001128";
/*    */   
/*    */   protected void func_72391_b(EntityPlayerMP p_72391_1_) {
/* 21 */     if (p_72391_1_.func_70005_c_().equals(func_72365_p().func_71214_G())) {
/* 22 */       this.field_72416_e = new NBTTagCompound();
/* 23 */       p_72391_1_.func_70109_d(this.field_72416_e);
/*    */     } 
/*    */     
/* 26 */     super.func_72391_b(p_72391_1_);
/*    */   }
/*    */ 
/*    */   
/*    */   public String func_148542_a(SocketAddress p_148542_1_, GameProfile p_148542_2_) {
/* 31 */     if (p_148542_2_.getName().equalsIgnoreCase(func_72365_p().func_71214_G()) && func_152612_a(p_148542_2_.getName()) != null) {
/* 32 */       return "That name is already taken.";
/*    */     }
/*    */     
/* 35 */     return super.func_148542_a(p_148542_1_, p_148542_2_);
/*    */   }
/*    */ 
/*    */   
/*    */   public IntegratedServer func_72365_p() {
/* 40 */     return (IntegratedServer)super.func_72365_p();
/*    */   }
/*    */ 
/*    */   
/*    */   public NBTTagCompound func_72378_q() {
/* 45 */     return this.field_72416_e;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\server\integrated\IntegratedPlayerList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */