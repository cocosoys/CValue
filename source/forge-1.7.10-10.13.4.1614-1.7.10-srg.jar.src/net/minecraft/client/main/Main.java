/*     */ package net.minecraft.client.main;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.io.File;
/*     */ import java.lang.reflect.ParameterizedType;
/*     */ import java.lang.reflect.Type;
/*     */ import java.net.Proxy;
/*     */ import java.util.Map;
/*     */ import joptsimple.ArgumentAcceptingOptionSpec;
/*     */ import joptsimple.OptionParser;
/*     */ import joptsimple.OptionSet;
/*     */ import joptsimple.OptionSpec;
/*     */ import net.minecraft.client.Minecraft;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class Main {
/*  17 */   private static final Type field_152370_a = new ParameterizedType() { private static final String __OBFID = "CL_00000828";
/*     */       
/*     */       public Type[] getActualTypeArguments() {
/*  20 */         return new Type[] { String.class, new ParameterizedType(this) {
/*     */               private static final String __OBFID = "CL_00001836";
/*     */               
/*     */               public Type[] getActualTypeArguments() {
/*  24 */                 return new Type[] { String.class };
/*     */               }
/*     */ 
/*     */ 
/*     */ 
/*     */               
/*     */               public Type getRawType() {
/*  31 */                 return Collection.class;
/*     */               }
/*     */ 
/*     */               
/*     */               public Type getOwnerType() {
/*  36 */                 return null;
/*     */               }
/*     */             } };
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public Type getRawType() {
/*  44 */         return Map.class;
/*     */       }
/*     */ 
/*     */       
/*     */       public Type getOwnerType() {
/*  49 */         return null;
/*     */       } }
/*     */   ;
/*     */   
/*     */   private static final String __OBFID = "CL_00001461";
/*     */   
/*     */   public static void main(String[] p_main_0_) {
/*  56 */     System.setProperty("java.net.preferIPv4Stack", "true");
/*     */     
/*  58 */     OptionParser optionParser = new OptionParser();
/*  59 */     optionParser.allowsUnrecognizedOptions();
/*     */     
/*  61 */     optionParser.accepts("demo");
/*  62 */     optionParser.accepts("fullscreen");
/*  63 */     ArgumentAcceptingOptionSpec argumentAcceptingOptionSpec1 = optionParser.accepts("server").withRequiredArg();
/*  64 */     ArgumentAcceptingOptionSpec argumentAcceptingOptionSpec2 = optionParser.accepts("port").withRequiredArg().ofType(Integer.class).defaultsTo(Integer.valueOf(25565), (Object[])new Integer[0]);
/*  65 */     ArgumentAcceptingOptionSpec argumentAcceptingOptionSpec3 = optionParser.accepts("gameDir").withRequiredArg().ofType(File.class).defaultsTo(new File("."), (Object[])new File[0]);
/*  66 */     ArgumentAcceptingOptionSpec argumentAcceptingOptionSpec4 = optionParser.accepts("assetsDir").withRequiredArg().ofType(File.class);
/*  67 */     ArgumentAcceptingOptionSpec argumentAcceptingOptionSpec5 = optionParser.accepts("resourcePackDir").withRequiredArg().ofType(File.class);
/*  68 */     ArgumentAcceptingOptionSpec argumentAcceptingOptionSpec6 = optionParser.accepts("proxyHost").withRequiredArg();
/*  69 */     ArgumentAcceptingOptionSpec argumentAcceptingOptionSpec7 = optionParser.accepts("proxyPort").withRequiredArg().defaultsTo("8080", (Object[])new String[0]).ofType(Integer.class);
/*  70 */     ArgumentAcceptingOptionSpec argumentAcceptingOptionSpec8 = optionParser.accepts("proxyUser").withRequiredArg();
/*  71 */     ArgumentAcceptingOptionSpec argumentAcceptingOptionSpec9 = optionParser.accepts("proxyPass").withRequiredArg();
/*  72 */     ArgumentAcceptingOptionSpec argumentAcceptingOptionSpec10 = optionParser.accepts("username").withRequiredArg().defaultsTo("Player" + (Minecraft.func_71386_F() % 1000L), (Object[])new String[0]);
/*  73 */     ArgumentAcceptingOptionSpec argumentAcceptingOptionSpec11 = optionParser.accepts("uuid").withRequiredArg();
/*  74 */     ArgumentAcceptingOptionSpec argumentAcceptingOptionSpec12 = optionParser.accepts("accessToken").withRequiredArg().required();
/*  75 */     ArgumentAcceptingOptionSpec argumentAcceptingOptionSpec13 = optionParser.accepts("version").withRequiredArg().required();
/*  76 */     ArgumentAcceptingOptionSpec argumentAcceptingOptionSpec14 = optionParser.accepts("width").withRequiredArg().ofType(Integer.class).defaultsTo(Integer.valueOf(854), (Object[])new Integer[0]);
/*  77 */     ArgumentAcceptingOptionSpec argumentAcceptingOptionSpec15 = optionParser.accepts("height").withRequiredArg().ofType(Integer.class).defaultsTo(Integer.valueOf(480), (Object[])new Integer[0]);
/*  78 */     ArgumentAcceptingOptionSpec argumentAcceptingOptionSpec16 = optionParser.accepts("userProperties").withRequiredArg().required();
/*  79 */     ArgumentAcceptingOptionSpec argumentAcceptingOptionSpec17 = optionParser.accepts("assetIndex").withRequiredArg();
/*  80 */     ArgumentAcceptingOptionSpec argumentAcceptingOptionSpec18 = optionParser.accepts("userType").withRequiredArg().defaultsTo("legacy", (Object[])new String[0]);
/*  81 */     NonOptionArgumentSpec nonOptionArgumentSpec = optionParser.nonOptions();
/*     */     
/*  83 */     OptionSet optionSet = optionParser.parse(p_main_0_);
/*  84 */     List list = optionSet.valuesOf((OptionSpec)nonOptionArgumentSpec);
/*     */ 
/*     */     
/*  87 */     String str1 = (String)optionSet.valueOf((OptionSpec)argumentAcceptingOptionSpec6);
/*  88 */     Proxy proxy = Proxy.NO_PROXY;
/*  89 */     if (str1 != null) {
/*     */       try {
/*  91 */         proxy = new Proxy(Proxy.Type.SOCKS, new InetSocketAddress(str1, ((Integer)optionSet.valueOf((OptionSpec)argumentAcceptingOptionSpec7)).intValue()));
/*  92 */       } catch (Exception exception) {}
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*  97 */     String str2 = (String)optionSet.valueOf((OptionSpec)argumentAcceptingOptionSpec8);
/*  98 */     String str3 = (String)optionSet.valueOf((OptionSpec)argumentAcceptingOptionSpec9);
/*  99 */     if (!proxy.equals(Proxy.NO_PROXY) && func_110121_a(str2) && func_110121_a(str3)) {
/* 100 */       Authenticator.setDefault(new Authenticator(str2, str3) { private static final String __OBFID = "CL_00000829";
/*     */             
/*     */             protected PasswordAuthentication getPasswordAuthentication() {
/* 103 */               return new PasswordAuthentication(this.field_152581_a, this.field_152582_b.toCharArray());
/*     */             } }
/*     */         );
/*     */     }
/*     */ 
/*     */     
/* 109 */     int i = ((Integer)optionSet.valueOf((OptionSpec)argumentAcceptingOptionSpec14)).intValue();
/* 110 */     int j = ((Integer)optionSet.valueOf((OptionSpec)argumentAcceptingOptionSpec15)).intValue();
/* 111 */     boolean bool1 = optionSet.has("fullscreen");
/* 112 */     boolean bool2 = optionSet.has("demo");
/* 113 */     String str4 = (String)optionSet.valueOf((OptionSpec)argumentAcceptingOptionSpec13);
/* 114 */     HashMultimap hashMultimap = HashMultimap.create();
/*     */     
/* 116 */     for (Map.Entry entry : ((Map)(new Gson()).fromJson((String)optionSet.valueOf((OptionSpec)argumentAcceptingOptionSpec16), field_152370_a)).entrySet()) {
/* 117 */       hashMultimap.putAll(entry.getKey(), (Iterable)entry.getValue());
/*     */     }
/*     */ 
/*     */     
/* 121 */     File file1 = (File)optionSet.valueOf((OptionSpec)argumentAcceptingOptionSpec3);
/* 122 */     File file2 = optionSet.has((OptionSpec)argumentAcceptingOptionSpec4) ? (File)optionSet.valueOf((OptionSpec)argumentAcceptingOptionSpec4) : new File(file1, "assets/");
/* 123 */     File file3 = optionSet.has((OptionSpec)argumentAcceptingOptionSpec5) ? (File)optionSet.valueOf((OptionSpec)argumentAcceptingOptionSpec5) : new File(file1, "resourcepacks/");
/* 124 */     String str5 = optionSet.has((OptionSpec)argumentAcceptingOptionSpec11) ? (String)argumentAcceptingOptionSpec11.value(optionSet) : (String)argumentAcceptingOptionSpec10.value(optionSet);
/* 125 */     String str6 = optionSet.has((OptionSpec)argumentAcceptingOptionSpec17) ? (String)argumentAcceptingOptionSpec17.value(optionSet) : null;
/*     */ 
/*     */     
/* 128 */     Session session = new Session((String)argumentAcceptingOptionSpec10.value(optionSet), str5, (String)argumentAcceptingOptionSpec12.value(optionSet), (String)argumentAcceptingOptionSpec18.value(optionSet));
/* 129 */     Minecraft minecraft = new Minecraft(session, i, j, bool1, bool2, file1, file2, file3, proxy, str4, (Multimap)hashMultimap, str6);
/*     */ 
/*     */     
/* 132 */     String str7 = (String)optionSet.valueOf((OptionSpec)argumentAcceptingOptionSpec1);
/* 133 */     if (str7 != null) {
/* 134 */       minecraft.func_71367_a(str7, ((Integer)optionSet.valueOf((OptionSpec)argumentAcceptingOptionSpec2)).intValue());
/*     */     }
/*     */     
/* 137 */     Runtime.getRuntime().addShutdownHook(new Thread("Client Shutdown Thread") { private static final String __OBFID = "CL_00001835";
/*     */           
/*     */           public void run() {
/* 140 */             Minecraft.func_71363_D();
/*     */           } }
/*     */       );
/*     */     
/* 144 */     if (!list.isEmpty()) System.out.println("Completely ignored arguments: " + list);
/*     */ 
/*     */     
/* 147 */     Thread.currentThread().setName("Client thread");
/* 148 */     minecraft.func_99999_d();
/*     */   }
/*     */   
/*     */   private static boolean func_110121_a(String p_110121_0_) {
/* 152 */     return (p_110121_0_ != null && !p_110121_0_.isEmpty());
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\main\Main.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */