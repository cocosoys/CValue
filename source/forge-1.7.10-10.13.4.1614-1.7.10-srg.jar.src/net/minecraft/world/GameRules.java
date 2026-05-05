/*     */ package net.minecraft.world;
/*     */ 
/*     */ import java.util.Set;
/*     */ import java.util.TreeMap;
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
/*     */ public class GameRules
/*     */ {
/*  20 */   private TreeMap field_82771_a = new TreeMap<Object, Object>();
/*     */   
/*     */   public GameRules() {
/*  23 */     func_82769_a("doFireTick", "true");
/*  24 */     func_82769_a("mobGriefing", "true");
/*  25 */     func_82769_a("keepInventory", "false");
/*  26 */     func_82769_a("doMobSpawning", "true");
/*  27 */     func_82769_a("doMobLoot", "true");
/*  28 */     func_82769_a("doTileDrops", "true");
/*  29 */     func_82769_a("commandBlockOutput", "true");
/*  30 */     func_82769_a("naturalRegeneration", "true");
/*  31 */     func_82769_a("doDaylightCycle", "true");
/*     */   }
/*     */   private static final String __OBFID = "CL_00000136";
/*     */   public void func_82769_a(String p_82769_1_, String p_82769_2_) {
/*  35 */     this.field_82771_a.put(p_82769_1_, new Value(p_82769_2_));
/*     */   }
/*     */   
/*     */   public void func_82764_b(String p_82764_1_, String p_82764_2_) {
/*  39 */     Value value = (Value)this.field_82771_a.get(p_82764_1_);
/*  40 */     if (value != null) {
/*  41 */       value.func_82757_a(p_82764_2_);
/*     */     } else {
/*  43 */       func_82769_a(p_82764_1_, p_82764_2_);
/*     */     } 
/*     */   }
/*     */   
/*     */   public String func_82767_a(String p_82767_1_) {
/*  48 */     Value value = (Value)this.field_82771_a.get(p_82767_1_);
/*  49 */     if (value != null) {
/*  50 */       return value.func_82756_a();
/*     */     }
/*  52 */     return "";
/*     */   }
/*     */   
/*     */   public boolean func_82766_b(String p_82766_1_) {
/*  56 */     Value value = (Value)this.field_82771_a.get(p_82766_1_);
/*  57 */     if (value != null) {
/*  58 */       return value.func_82758_b();
/*     */     }
/*  60 */     return false;
/*     */   }
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
/*     */   public NBTTagCompound func_82770_a() {
/*  80 */     NBTTagCompound nBTTagCompound = new NBTTagCompound();
/*     */     
/*  82 */     for (String str : this.field_82771_a.keySet()) {
/*  83 */       Value value = (Value)this.field_82771_a.get(str);
/*  84 */       nBTTagCompound.func_74778_a(str, value.func_82756_a());
/*     */     } 
/*     */     
/*  87 */     return nBTTagCompound;
/*     */   }
/*     */   
/*     */   public void func_82768_a(NBTTagCompound p_82768_1_) {
/*  91 */     Set set = p_82768_1_.func_150296_c();
/*  92 */     for (String str1 : set) {
/*  93 */       String str2 = str1;
/*  94 */       String str3 = p_82768_1_.func_74779_i(str1);
/*     */       
/*  96 */       func_82764_b(str2, str3);
/*     */     } 
/*     */   }
/*     */   
/*     */   public String[] func_82763_b() {
/* 101 */     return (String[])this.field_82771_a.keySet().toArray((Object[])new String[0]);
/*     */   }
/*     */   
/*     */   public boolean func_82765_e(String p_82765_1_) {
/* 105 */     return this.field_82771_a.containsKey(p_82765_1_);
/*     */   }
/*     */   
/*     */   static class Value
/*     */   {
/*     */     private String field_82762_a;
/*     */     private boolean field_82760_b;
/*     */     private int field_82761_c;
/*     */     private double field_82759_d;
/*     */     private static final String __OBFID = "CL_00000137";
/*     */     
/*     */     public Value(String p_i1949_1_) {
/* 117 */       func_82757_a(p_i1949_1_);
/*     */     }
/*     */     
/*     */     public void func_82757_a(String p_82757_1_) {
/* 121 */       this.field_82762_a = p_82757_1_;
/* 122 */       this.field_82760_b = Boolean.parseBoolean(p_82757_1_);
/*     */       try {
/* 124 */         this.field_82761_c = Integer.parseInt(p_82757_1_);
/* 125 */       } catch (NumberFormatException numberFormatException) {}
/*     */       
/*     */       try {
/* 128 */         this.field_82759_d = Double.parseDouble(p_82757_1_);
/* 129 */       } catch (NumberFormatException numberFormatException) {}
/*     */     }
/*     */ 
/*     */     
/*     */     public String func_82756_a() {
/* 134 */       return this.field_82762_a;
/*     */     }
/*     */     
/*     */     public boolean func_82758_b() {
/* 138 */       return this.field_82760_b;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\GameRules.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */