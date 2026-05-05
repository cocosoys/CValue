/*     */ package net.minecraft.util;
/*     */ public enum EnumChatFormatting {
/*     */   private static final Map field_96321_w;
/*     */   private static final Map field_96331_x;
/*     */   private static final Pattern field_96330_y;
/*     */   private final char field_96329_z;
/*   7 */   BLACK('0'),
/*   8 */   DARK_BLUE('1'),
/*   9 */   DARK_GREEN('2'),
/*  10 */   DARK_AQUA('3'),
/*  11 */   DARK_RED('4'),
/*  12 */   DARK_PURPLE('5'),
/*  13 */   GOLD('6'),
/*  14 */   GRAY('7'),
/*  15 */   DARK_GRAY('8'),
/*  16 */   BLUE('9'),
/*  17 */   GREEN('a'),
/*  18 */   AQUA('b'),
/*  19 */   RED('c'),
/*  20 */   LIGHT_PURPLE('d'),
/*  21 */   YELLOW('e'),
/*  22 */   WHITE('f'),
/*  23 */   OBFUSCATED('k', true),
/*  24 */   BOLD('l', true),
/*  25 */   STRIKETHROUGH('m', true),
/*  26 */   UNDERLINE('n', true),
/*  27 */   ITALIC('o', true),
/*  28 */   RESET('r'); private final boolean field_96303_A; private final String field_96304_B; private static final String __OBFID = "CL_00000342";
/*     */   
/*     */   static {
/*  31 */     field_96321_w = new HashMap<Object, Object>();
/*  32 */     field_96331_x = new HashMap<Object, Object>();
/*  33 */     field_96330_y = Pattern.compile("(?i)" + String.valueOf('§') + "[0-9A-FK-OR]");
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
/*  51 */     for (EnumChatFormatting enumChatFormatting : values()) {
/*  52 */       field_96321_w.put(Character.valueOf(enumChatFormatting.func_96298_a()), enumChatFormatting);
/*  53 */       field_96331_x.put(enumChatFormatting.func_96297_d(), enumChatFormatting);
/*     */     }  } EnumChatFormatting(char p_i1337_3_, boolean p_i1337_4_) { this.field_96329_z = p_i1337_3_;
/*     */     this.field_96303_A = p_i1337_4_;
/*     */     this.field_96304_B = "§" + p_i1337_3_; }
/*     */   public char func_96298_a() {
/*  58 */     return this.field_96329_z;
/*     */   }
/*     */   
/*     */   public boolean func_96301_b() {
/*  62 */     return this.field_96303_A;
/*     */   }
/*     */   
/*     */   public boolean func_96302_c() {
/*  66 */     return (!this.field_96303_A && this != RESET);
/*     */   }
/*     */   
/*     */   public String func_96297_d() {
/*  70 */     return name().toLowerCase();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  75 */     return this.field_96304_B;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public static String func_110646_a(String p_110646_0_) {
/*  79 */     return (p_110646_0_ == null) ? null : field_96330_y.matcher(p_110646_0_).replaceAll("");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static EnumChatFormatting func_96300_b(String p_96300_0_) {
/*  87 */     if (p_96300_0_ == null) return null; 
/*  88 */     return (EnumChatFormatting)field_96331_x.get(p_96300_0_.toLowerCase());
/*     */   }
/*     */   
/*     */   public static Collection func_96296_a(boolean p_96296_0_, boolean p_96296_1_) {
/*  92 */     ArrayList<String> arrayList = new ArrayList();
/*     */     
/*  94 */     for (EnumChatFormatting enumChatFormatting : values()) {
/*  95 */       if ((!enumChatFormatting.func_96302_c() || p_96296_0_) && (
/*  96 */         !enumChatFormatting.func_96301_b() || p_96296_1_)) {
/*  97 */         arrayList.add(enumChatFormatting.func_96297_d());
/*     */       }
/*     */     } 
/* 100 */     return arrayList;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraf\\util\EnumChatFormatting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */