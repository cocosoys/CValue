/*     */ package cpw.mods.fml.common.event;
/*     */ 
/*     */ import com.google.common.collect.ArrayListMultimap;
/*     */ import com.google.common.collect.ImmutableList;
/*     */ import cpw.mods.fml.common.FMLCommonHandler;
/*     */ import cpw.mods.fml.common.FMLLog;
/*     */ import cpw.mods.fml.common.Loader;
/*     */ import cpw.mods.fml.common.LoaderState;
/*     */ import cpw.mods.fml.common.ModContainer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FMLInterModComms
/*     */ {
/*  36 */   private static final ImmutableList<IMCMessage> emptyIMCList = ImmutableList.of();
/*  37 */   private static ArrayListMultimap<String, IMCMessage> modMessages = ArrayListMultimap.create();
/*     */ 
/*     */ 
/*     */   
/*     */   public static class IMCEvent
/*     */     extends FMLEvent
/*     */   {
/*     */     private ModContainer activeContainer;
/*     */ 
/*     */     
/*     */     private ImmutableList<FMLInterModComms.IMCMessage> currentList;
/*     */ 
/*     */ 
/*     */     
/*     */     public void applyModContainer(ModContainer activeContainer) {
/*  52 */       this.activeContainer = activeContainer;
/*  53 */       this.currentList = null;
/*  54 */       FMLLog.finer("Attempting to deliver %d IMC messages to mod %s", new Object[] { Integer.valueOf(FMLInterModComms.access$000().get(activeContainer.getModId()).size()), activeContainer.getModId() });
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ImmutableList<FMLInterModComms.IMCMessage> getMessages() {
/*  61 */       if (this.currentList == null)
/*     */       {
/*  63 */         this.currentList = ImmutableList.copyOf(FMLInterModComms.modMessages.removeAll(this.activeContainer.getModId()));
/*     */       }
/*  65 */       return this.currentList;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class IMCMessage
/*     */   {
/*     */     private String sender;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final String key;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private Object value;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private IMCMessage(String key, Object value) {
/*  91 */       this.key = key;
/*  92 */       this.value = value;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString() {
/*  98 */       return this.sender;
/*     */     }
/*     */ 
/*     */     
/*     */     public String getSender() {
/* 103 */       return this.sender;
/*     */     }
/*     */ 
/*     */     
/*     */     void setSender(ModContainer activeModContainer) {
/* 108 */       this.sender = activeModContainer.getModId();
/*     */     }
/*     */ 
/*     */     
/*     */     public String getStringValue() {
/* 113 */       return (String)this.value;
/*     */     }
/*     */ 
/*     */     
/*     */     public NBTTagCompound getNBTValue() {
/* 118 */       return (NBTTagCompound)this.value;
/*     */     }
/*     */ 
/*     */     
/*     */     public ItemStack getItemStackValue() {
/* 123 */       return (ItemStack)this.value;
/*     */     }
/*     */ 
/*     */     
/*     */     public Class<?> getMessageType() {
/* 128 */       return this.value.getClass();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isStringMessage() {
/* 133 */       return String.class.isAssignableFrom(getMessageType());
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isItemStackMessage() {
/* 138 */       return ItemStack.class.isAssignableFrom(getMessageType());
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isNBTMessage() {
/* 143 */       return NBTTagCompound.class.isAssignableFrom(getMessageType());
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean sendMessage(String modId, String key, NBTTagCompound value) {
/* 149 */     return enqueueStartupMessage(modId, new IMCMessage(key, value));
/*     */   }
/*     */   
/*     */   public static boolean sendMessage(String modId, String key, ItemStack value) {
/* 153 */     return enqueueStartupMessage(modId, new IMCMessage(key, value));
/*     */   }
/*     */   
/*     */   public static boolean sendMessage(String modId, String key, String value) {
/* 157 */     return enqueueStartupMessage(modId, new IMCMessage(key, value));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void sendRuntimeMessage(Object sourceMod, String modId, String key, NBTTagCompound value) {
/* 162 */     enqueueMessage(sourceMod, modId, new IMCMessage(key, value));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void sendRuntimeMessage(Object sourceMod, String modId, String key, ItemStack value) {
/* 167 */     enqueueMessage(sourceMod, modId, new IMCMessage(key, value));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void sendRuntimeMessage(Object sourceMod, String modId, String key, String value) {
/* 172 */     enqueueMessage(sourceMod, modId, new IMCMessage(key, value));
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean enqueueStartupMessage(String modTarget, IMCMessage message) {
/* 177 */     if (Loader.instance().activeModContainer() == null)
/*     */     {
/* 179 */       return false;
/*     */     }
/* 181 */     enqueueMessage(Loader.instance().activeModContainer(), modTarget, message);
/* 182 */     return (Loader.isModLoaded(modTarget) && !Loader.instance().hasReachedState(LoaderState.POSTINITIALIZATION));
/*     */   }
/*     */ 
/*     */   
/*     */   private static void enqueueMessage(Object sourceMod, String modTarget, IMCMessage message) {
/*     */     ModContainer mc;
/* 188 */     if (sourceMod instanceof ModContainer) {
/* 189 */       mc = (ModContainer)sourceMod;
/*     */     }
/*     */     else {
/*     */       
/* 193 */       mc = FMLCommonHandler.instance().findContainerFor(sourceMod);
/*     */     } 
/* 195 */     if (mc != null && Loader.isModLoaded(modTarget)) {
/*     */       
/* 197 */       message.setSender(mc);
/* 198 */       modMessages.put(modTarget, message);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ImmutableList<IMCMessage> fetchRuntimeMessages(Object forMod) {
/* 209 */     ModContainer mc = FMLCommonHandler.instance().findContainerFor(forMod);
/* 210 */     if (mc != null)
/*     */     {
/* 212 */       return ImmutableList.copyOf(modMessages.removeAll(mc.getModId()));
/*     */     }
/*     */ 
/*     */     
/* 216 */     return emptyIMCList;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\event\FMLInterModComms.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */