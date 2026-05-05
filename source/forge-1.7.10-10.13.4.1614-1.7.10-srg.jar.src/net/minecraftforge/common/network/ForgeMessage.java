/*    */ package net.minecraftforge.common.network;
/*    */ 
/*    */ import com.google.common.collect.BiMap;
/*    */ import com.google.common.collect.HashBiMap;
/*    */ import com.google.common.collect.Sets;
/*    */ import cpw.mods.fml.common.FMLLog;
/*    */ import cpw.mods.fml.common.network.ByteBufUtils;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import net.minecraftforge.fluids.Fluid;
/*    */ import net.minecraftforge.fluids.FluidRegistry;
/*    */ import org.apache.logging.log4j.Level;
/*    */ 
/*    */ public abstract class ForgeMessage
/*    */ {
/*    */   abstract void toBytes(ByteBuf paramByteBuf);
/*    */   
/*    */   abstract void fromBytes(ByteBuf paramByteBuf);
/*    */   
/*    */   public static class DimensionRegisterMessage
/*    */     extends ForgeMessage {
/*    */     int dimensionId;
/*    */     int providerId;
/*    */     
/*    */     public DimensionRegisterMessage() {}
/*    */     
/*    */     public DimensionRegisterMessage(int dimensionId, int providerId) {
/* 29 */       this.dimensionId = dimensionId;
/* 30 */       this.providerId = providerId;
/*    */     }
/*    */ 
/*    */ 
/*    */     
/*    */     void toBytes(ByteBuf bytes) {
/* 36 */       bytes.writeInt(this.dimensionId);
/* 37 */       bytes.writeInt(this.providerId);
/*    */     }
/*    */ 
/*    */ 
/*    */     
/*    */     void fromBytes(ByteBuf bytes) {
/* 43 */       this.dimensionId = bytes.readInt();
/* 44 */       this.providerId = bytes.readInt();
/*    */     }
/*    */   }
/*    */   
/*    */   public static class FluidIdMapMessage extends ForgeMessage {
/* 49 */     BiMap<Fluid, Integer> fluidIds = (BiMap<Fluid, Integer>)HashBiMap.create();
/* 50 */     Set<String> defaultFluids = Sets.newHashSet();
/*    */ 
/*    */     
/*    */     void toBytes(ByteBuf bytes) {
/* 54 */       Map<Fluid, Integer> ids = FluidRegistry.getRegisteredFluidIDsByFluid();
/* 55 */       bytes.writeInt(ids.size());
/* 56 */       for (Map.Entry<Fluid, Integer> entry : ids.entrySet()) {
/*    */         
/* 58 */         ByteBufUtils.writeUTF8String(bytes, ((Fluid)entry.getKey()).getName());
/* 59 */         bytes.writeInt(((Integer)entry.getValue()).intValue());
/*    */       } 
/* 61 */       for (Map.Entry<Fluid, Integer> entry : ids.entrySet()) {
/*    */         
/* 63 */         String defaultName = FluidRegistry.getDefaultFluidName(entry.getKey());
/* 64 */         ByteBufUtils.writeUTF8String(bytes, defaultName);
/*    */       } 
/*    */     }
/*    */ 
/*    */ 
/*    */     
/*    */     void fromBytes(ByteBuf bytes) {
/* 71 */       int listSize = bytes.readInt(); int i;
/* 72 */       for (i = 0; i < listSize; i++) {
/* 73 */         String fluidName = ByteBufUtils.readUTF8String(bytes);
/* 74 */         int fluidId = bytes.readInt();
/* 75 */         this.fluidIds.put(FluidRegistry.getFluid(fluidName), Integer.valueOf(fluidId));
/*    */       } 
/*    */ 
/*    */       
/* 79 */       if (bytes.isReadable()) {
/*    */         
/* 81 */         for (i = 0; i < listSize; i++)
/*    */         {
/* 83 */           this.defaultFluids.add(ByteBufUtils.readUTF8String(bytes));
/*    */         }
/*    */       }
/*    */       else {
/*    */         
/* 88 */         FMLLog.getLogger().log(Level.INFO, "Legacy server message contains no default fluid list - there may be problems with fluids");
/* 89 */         this.defaultFluids.clear();
/*    */       } 
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\common\network\ForgeMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */