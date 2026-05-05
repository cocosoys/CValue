/*     */ package cpw.mods.fml.common.network.internal;
/*     */ 
/*     */ import com.google.common.base.Preconditions;
/*     */ import com.google.common.base.Strings;
/*     */ import com.google.common.collect.ImmutableMap;
/*     */ import com.google.common.collect.ImmutableSet;
/*     */ import com.google.common.collect.SetMultimap;
/*     */ import cpw.mods.fml.common.FMLLog;
/*     */ import cpw.mods.fml.common.ModContainer;
/*     */ import cpw.mods.fml.common.discovery.ASMDataTable;
/*     */ import cpw.mods.fml.common.network.NetworkCheckHandler;
/*     */ import cpw.mods.fml.common.versioning.ArtifactVersion;
/*     */ import cpw.mods.fml.common.versioning.DefaultArtifactVersion;
/*     */ import cpw.mods.fml.common.versioning.InvalidVersionSpecificationException;
/*     */ import cpw.mods.fml.common.versioning.VersionRange;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.apache.logging.log4j.Level;
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
/*     */ public class NetworkModHolder
/*     */ {
/*     */   public abstract class NetworkChecker
/*     */   {
/*     */     public abstract boolean check(Map<String, String> param1Map, Side param1Side);
/*     */   }
/*     */   
/*     */   private class IgnoredChecker
/*     */     extends NetworkChecker
/*     */   {
/*     */     private IgnoredChecker() {}
/*     */     
/*     */     public boolean check(Map<String, String> remoteVersions, Side side) {
/*  46 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/*  51 */       return "No network checking performed";
/*     */     } }
/*     */   
/*     */   private class DefaultNetworkChecker extends NetworkChecker {
/*     */     private DefaultNetworkChecker() {}
/*     */     
/*     */     public boolean check(Map<String, String> remoteVersions, Side side) {
/*  58 */       return remoteVersions.containsKey(NetworkModHolder.this.container.getModId()) ? NetworkModHolder.this.acceptVersion(remoteVersions.get(NetworkModHolder.this.container.getModId())) : ((side == Side.SERVER));
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/*  63 */       return (NetworkModHolder.this.acceptableRange != null) ? String.format("Accepting range %s", new Object[] { NetworkModHolder.access$100(this.this$0) }) : String.format("Accepting version %s", new Object[] { NetworkModHolder.access$000(this.this$0).getVersion() });
/*     */     }
/*     */   }
/*     */   
/*     */   private class MethodNetworkChecker extends NetworkChecker {
/*     */     private MethodNetworkChecker() {}
/*     */     
/*     */     public boolean check(Map<String, String> remoteVersions, Side side) {
/*     */       try {
/*  72 */         return ((Boolean)NetworkModHolder.this.checkHandler.invoke(NetworkModHolder.this.container.getMod(), new Object[] { remoteVersions, side })).booleanValue();
/*     */       }
/*  74 */       catch (Exception e) {
/*     */         
/*  76 */         FMLLog.log(Level.ERROR, e, "Error occurred invoking NetworkCheckHandler %s at %s", new Object[] { NetworkModHolder.access$200(this.this$0).getName(), NetworkModHolder.access$000(this.this$0) });
/*  77 */         return false;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/*  83 */       return String.format("Invoking method %s", new Object[] { NetworkModHolder.access$200(this.this$0).getName() });
/*     */     } }
/*     */   
/*  86 */   private static int assignedIds = 1;
/*     */   
/*     */   private int localId;
/*     */   
/*     */   private int networkId;
/*     */   
/*     */   private ModContainer container;
/*     */   
/*     */   private Method checkHandler;
/*     */   
/*     */   private VersionRange acceptableRange;
/*     */   
/*     */   private NetworkChecker checker;
/*     */   private boolean acceptsVanillaClient;
/*     */   private boolean acceptsVanillaServer;
/*     */   
/*     */   public NetworkModHolder(ModContainer container) {
/* 103 */     this.container = container;
/* 104 */     this.localId = assignedIds++;
/* 105 */     this.networkId = this.localId;
/*     */   }
/*     */   
/*     */   public NetworkModHolder(ModContainer container, NetworkChecker checker) {
/* 109 */     this(container);
/* 110 */     this.checker = (NetworkChecker)Preconditions.checkNotNull(checker);
/* 111 */     FMLLog.fine("The mod %s is using a custom checker %s", new Object[] { container.getModId(), checker.getClass().getName() });
/*     */   }
/*     */   
/*     */   public NetworkModHolder(ModContainer container, Class<?> modClass, String acceptableVersionRange, ASMDataTable table) {
/* 115 */     this(container); ImmutableSet immutableSet;
/* 116 */     SetMultimap<String, ASMDataTable.ASMData> annotationTable = table.getAnnotationsFor(container);
/*     */     
/* 118 */     if (annotationTable != null) {
/*     */       
/* 120 */       Set<ASMDataTable.ASMData> versionCheckHandlers = annotationTable.get(NetworkCheckHandler.class.getName());
/*     */     }
/*     */     else {
/*     */       
/* 124 */       immutableSet = ImmutableSet.of();
/*     */     } 
/* 126 */     String networkCheckHandlerMethod = null;
/* 127 */     for (ASMDataTable.ASMData vch : immutableSet) {
/*     */       
/* 129 */       if (vch.getClassName().equals(modClass.getName())) {
/*     */         
/* 131 */         networkCheckHandlerMethod = vch.getObjectName();
/* 132 */         networkCheckHandlerMethod = networkCheckHandlerMethod.substring(0, networkCheckHandlerMethod.indexOf('('));
/*     */         break;
/*     */       } 
/*     */     } 
/* 136 */     if (immutableSet.isEmpty())
/*     */     {
/* 138 */       for (Method m : modClass.getMethods()) {
/*     */         
/* 140 */         if (m.isAnnotationPresent((Class)NetworkCheckHandler.class)) {
/*     */           
/* 142 */           if ((m.getParameterTypes()).length == 2 && m.getParameterTypes()[0].equals(Map.class) && m.getParameterTypes()[1].equals(Side.class)) {
/*     */             
/* 144 */             this.checkHandler = m;
/*     */             
/*     */             break;
/*     */           } 
/*     */           
/* 149 */           FMLLog.severe("Found unexpected method signature for annotation NetworkCheckHandler", new Object[0]);
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/* 154 */     if (networkCheckHandlerMethod != null) {
/*     */       
/*     */       try {
/*     */         
/* 158 */         Method checkHandlerMethod = modClass.getDeclaredMethod(networkCheckHandlerMethod, new Class[] { Map.class, Side.class });
/* 159 */         if (checkHandlerMethod.isAnnotationPresent((Class)NetworkCheckHandler.class))
/*     */         {
/* 161 */           this.checkHandler = checkHandlerMethod;
/*     */         }
/*     */       }
/* 164 */       catch (Exception e) {
/*     */         
/* 166 */         FMLLog.log(Level.WARN, e, "The declared version check handler method %s on network mod id %s is not accessible", new Object[] { networkCheckHandlerMethod, container.getModId() });
/*     */       } 
/*     */     }
/* 169 */     if (this.checkHandler != null) {
/*     */       
/* 171 */       this.checker = new MethodNetworkChecker();
/*     */     }
/* 173 */     else if (!Strings.isNullOrEmpty(acceptableVersionRange) && acceptableVersionRange.equals("*")) {
/*     */       
/* 175 */       this.checker = new IgnoredChecker();
/*     */     } else {
/*     */ 
/*     */       
/*     */       try {
/*     */         
/* 181 */         this.acceptableRange = VersionRange.createFromVersionSpec(acceptableVersionRange);
/*     */       }
/* 183 */       catch (InvalidVersionSpecificationException e) {
/*     */         
/* 185 */         FMLLog.log(Level.WARN, (Throwable)e, "Invalid bounded range %s specified for network mod id %s", new Object[] { acceptableVersionRange, container.getModId() });
/*     */       } 
/* 187 */       this.checker = new DefaultNetworkChecker();
/*     */     } 
/* 189 */     FMLLog.finer("Mod %s is using network checker : %s", new Object[] { container.getModId(), this.checker });
/* 190 */     FMLLog.finer("Testing mod %s to verify it accepts its own version in a remote connection", new Object[] { container.getModId() });
/* 191 */     boolean acceptsSelf = acceptVersion(container.getVersion());
/* 192 */     if (!acceptsSelf) {
/*     */       
/* 194 */       FMLLog.severe("The mod %s appears to reject its own version number (%s) in its version handling. This is likely a severe bug in the mod!", new Object[] { container.getModId(), container.getVersion() });
/*     */     }
/*     */     else {
/*     */       
/* 198 */       FMLLog.finer("The mod %s accepts its own version (%s)", new Object[] { container.getModId(), container.getVersion() });
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean acceptVersion(String version) {
/* 204 */     if (this.acceptableRange != null)
/*     */     {
/* 206 */       return this.acceptableRange.containsVersion((ArtifactVersion)new DefaultArtifactVersion(version));
/*     */     }
/*     */     
/* 209 */     return this.container.getVersion().equals(version);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean check(Map<String, String> data, Side side) {
/* 214 */     return this.checker.check(data, side);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getLocalId() {
/* 219 */     return this.localId;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getNetworkId() {
/* 224 */     return this.networkId;
/*     */   }
/*     */ 
/*     */   
/*     */   public ModContainer getContainer() {
/* 229 */     return this.container;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setNetworkId(int value) {
/* 234 */     this.networkId = value;
/*     */   }
/*     */   
/*     */   public void testVanillaAcceptance() {
/* 238 */     this.acceptsVanillaClient = check((Map<String, String>)ImmutableMap.of(), Side.CLIENT);
/* 239 */     this.acceptsVanillaServer = check((Map<String, String>)ImmutableMap.of(), Side.SERVER);
/*     */   }
/*     */   public boolean acceptsVanilla(Side from) {
/* 242 */     return (from == Side.CLIENT) ? this.acceptsVanillaClient : this.acceptsVanillaServer;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\network\internal\NetworkModHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */