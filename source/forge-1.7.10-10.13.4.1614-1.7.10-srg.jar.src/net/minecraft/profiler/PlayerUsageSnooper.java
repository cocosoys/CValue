/*     */ package net.minecraft.profiler;
/*     */ import com.google.common.collect.Maps;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.lang.management.RuntimeMXBean;
/*     */ import java.net.URL;
/*     */ import java.util.HashMap;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Timer;
/*     */ import java.util.TimerTask;
/*     */ import net.minecraft.util.HttpUtil;
/*     */ 
/*     */ public class PlayerUsageSnooper {
/*  16 */   private final Map field_152773_a = Maps.newHashMap();
/*  17 */   private final Map field_152774_b = Maps.newHashMap();
/*     */   
/*  19 */   private final String field_76480_b = UUID.randomUUID().toString();
/*     */   private final URL field_76481_c;
/*     */   private final IPlayerUsage field_76478_d;
/*  22 */   private final Timer field_76479_e = new Timer("Snooper Timer", true);
/*  23 */   private final Object field_76476_f = new Object(); private final long field_98224_g;
/*     */   private boolean field_76477_g;
/*     */   private int field_76483_h;
/*     */   private static final String __OBFID = "CL_00001515";
/*     */   
/*     */   public PlayerUsageSnooper(String p_i1563_1_, IPlayerUsage p_i1563_2_, long p_i1563_3_) {
/*     */     try {
/*  30 */       this.field_76481_c = new URL("http://snoop.minecraft.net/" + p_i1563_1_ + "?version=" + '\002');
/*  31 */     } catch (MalformedURLException malformedURLException) {
/*  32 */       throw new IllegalArgumentException();
/*     */     } 
/*     */     
/*  35 */     this.field_76478_d = p_i1563_2_;
/*  36 */     this.field_98224_g = p_i1563_3_;
/*     */   }
/*     */   
/*     */   public void func_76463_a() {
/*  40 */     if (this.field_76477_g)
/*  41 */       return;  this.field_76477_g = true;
/*     */     
/*  43 */     func_152766_h();
/*     */     
/*  45 */     this.field_76479_e.schedule(new TimerTask(this) { private static final String __OBFID = "CL_00001516";
/*     */           public void run() {
/*     */             HashMap<Object, Object> hashMap;
/*  48 */             if (!this.field_76344_a.field_76478_d.func_70002_Q()) {
/*     */               return;
/*     */             }
/*  51 */             synchronized (this.field_76344_a.field_76476_f) {
/*  52 */               hashMap = new HashMap<Object, Object>(this.field_76344_a.field_152774_b);
/*  53 */               if (this.field_76344_a.field_76483_h == 0) hashMap.putAll(this.field_76344_a.field_152773_a); 
/*  54 */               hashMap.put("snooper_count", Integer.valueOf(this.field_76344_a.field_76483_h++));
/*  55 */               hashMap.put("snooper_token", this.field_76344_a.field_76480_b);
/*     */             } 
/*     */             
/*  58 */             HttpUtil.func_151226_a(this.field_76344_a.field_76481_c, hashMap, true);
/*     */           } }
/*     */         0L, 900000L);
/*     */   }
/*     */   
/*     */   private void func_152766_h() {
/*  64 */     func_76467_g();
/*     */     
/*  66 */     func_152768_a("snooper_token", this.field_76480_b);
/*  67 */     func_152767_b("snooper_token", this.field_76480_b);
/*  68 */     func_152767_b("os_name", System.getProperty("os.name"));
/*  69 */     func_152767_b("os_version", System.getProperty("os.version"));
/*  70 */     func_152767_b("os_architecture", System.getProperty("os.arch"));
/*  71 */     func_152767_b("java_version", System.getProperty("java.version"));
/*  72 */     func_152767_b("version", "1.7.10");
/*     */     
/*  74 */     this.field_76478_d.func_70001_b(this);
/*     */   }
/*     */   
/*     */   private void func_76467_g() {
/*  78 */     RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
/*  79 */     List<String> list = runtimeMXBean.getInputArguments();
/*  80 */     byte b = 0;
/*     */     
/*  82 */     for (String str : list) {
/*  83 */       if (str.startsWith("-X")) {
/*  84 */         func_152768_a("jvm_arg[" + b++ + "]", str);
/*     */       }
/*     */     } 
/*     */     
/*  88 */     func_152768_a("jvm_args", Integer.valueOf(b));
/*     */   }
/*     */   
/*     */   public void func_76471_b() {
/*  92 */     func_152767_b("memory_total", Long.valueOf(Runtime.getRuntime().totalMemory()));
/*  93 */     func_152767_b("memory_max", Long.valueOf(Runtime.getRuntime().maxMemory()));
/*  94 */     func_152767_b("memory_free", Long.valueOf(Runtime.getRuntime().freeMemory()));
/*  95 */     func_152767_b("cpu_cores", Integer.valueOf(Runtime.getRuntime().availableProcessors()));
/*     */     
/*  97 */     this.field_76478_d.func_70000_a(this);
/*     */   }
/*     */   
/*     */   public void func_152768_a(String p_152768_1_, Object p_152768_2_) {
/* 101 */     synchronized (this.field_76476_f) {
/* 102 */       this.field_152774_b.put(p_152768_1_, p_152768_2_);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_152767_b(String p_152767_1_, Object p_152767_2_) {
/* 107 */     synchronized (this.field_76476_f) {
/* 108 */       this.field_152773_a.put(p_152767_1_, p_152767_2_);
/*     */     } 
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public Map func_76465_c() {
/* 113 */     LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
/*     */     
/* 115 */     synchronized (this.field_76476_f) {
/* 116 */       func_76471_b();
/*     */       
/* 118 */       for (Map.Entry entry : this.field_152773_a.entrySet()) {
/* 119 */         linkedHashMap.put(entry.getKey(), entry.getValue().toString());
/*     */       }
/*     */       
/* 122 */       for (Map.Entry entry : this.field_152774_b.entrySet()) {
/* 123 */         linkedHashMap.put(entry.getKey(), entry.getValue().toString());
/*     */       }
/*     */     } 
/*     */     
/* 127 */     return linkedHashMap;
/*     */   }
/*     */   
/*     */   public boolean func_76468_d() {
/* 131 */     return this.field_76477_g;
/*     */   }
/*     */   
/*     */   public void func_76470_e() {
/* 135 */     this.field_76479_e.cancel();
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String func_80006_f() {
/* 139 */     return this.field_76480_b;
/*     */   }
/*     */   
/*     */   public long func_130105_g() {
/* 143 */     return this.field_98224_g;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\profiler\PlayerUsageSnooper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */