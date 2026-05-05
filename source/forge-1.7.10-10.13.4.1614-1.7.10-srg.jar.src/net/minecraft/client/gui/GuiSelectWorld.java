/*     */ package net.minecraft.client.gui;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.text.DateFormat;
/*     */ import java.util.Collections;
/*     */ import java.util.Date;
/*     */ import net.minecraft.client.AnvilConverterException;
/*     */ import net.minecraft.client.resources.I18n;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.WorldSettings;
/*     */ import net.minecraft.world.storage.ISaveFormat;
/*     */ import net.minecraft.world.storage.ISaveHandler;
/*     */ import net.minecraft.world.storage.SaveFormatComparator;
/*     */ import net.minecraft.world.storage.WorldInfo;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class GuiSelectWorld extends GuiScreen implements GuiYesNoCallback {
/*  21 */   private static final Logger field_146629_g = LogManager.getLogger();
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
/*  32 */   private final DateFormat field_146633_h = new SimpleDateFormat();
/*     */   
/*     */   protected GuiScreen field_146632_a;
/*  35 */   protected String field_146628_f = "Select world";
/*     */   private boolean field_146634_i;
/*     */   private int field_146640_r;
/*     */   private java.util.List field_146639_s;
/*     */   private List field_146638_t;
/*     */   private String field_146637_u;
/*     */   private String field_146636_v;
/*  42 */   private String[] field_146635_w = new String[3];
/*     */   private boolean field_146643_x;
/*     */   private GuiButton field_146642_y;
/*     */   private GuiButton field_146641_z;
/*     */   private GuiButton field_146630_A;
/*     */   private GuiButton field_146631_B;
/*     */   private static final String __OBFID = "CL_00000711";
/*     */   
/*     */   public GuiSelectWorld(GuiScreen p_i1054_1_) {
/*  51 */     this.field_146632_a = p_i1054_1_;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73866_w_() {
/*  56 */     this.field_146628_f = I18n.func_135052_a("selectWorld.title", new Object[0]);
/*     */     
/*     */     try {
/*  59 */       func_146627_h();
/*  60 */     } catch (AnvilConverterException anvilConverterException) {
/*  61 */       field_146629_g.error("Couldn't load level list", (Throwable)anvilConverterException);
/*  62 */       this.field_146297_k.func_147108_a(new GuiErrorScreen("Unable to load worlds", anvilConverterException.getMessage()));
/*     */       
/*     */       return;
/*     */     } 
/*  66 */     this.field_146637_u = I18n.func_135052_a("selectWorld.world", new Object[0]);
/*  67 */     this.field_146636_v = I18n.func_135052_a("selectWorld.conversion", new Object[0]);
/*  68 */     this.field_146635_w[WorldSettings.GameType.SURVIVAL.func_77148_a()] = I18n.func_135052_a("gameMode.survival", new Object[0]);
/*  69 */     this.field_146635_w[WorldSettings.GameType.CREATIVE.func_77148_a()] = I18n.func_135052_a("gameMode.creative", new Object[0]);
/*  70 */     this.field_146635_w[WorldSettings.GameType.ADVENTURE.func_77148_a()] = I18n.func_135052_a("gameMode.adventure", new Object[0]);
/*     */     
/*  72 */     this.field_146638_t = new List(this);
/*  73 */     this.field_146638_t.func_148134_d(4, 5);
/*     */     
/*  75 */     func_146618_g();
/*     */   }
/*     */   
/*     */   private void func_146627_h() throws AnvilConverterException {
/*  79 */     ISaveFormat iSaveFormat = this.field_146297_k.func_71359_d();
/*  80 */     this.field_146639_s = iSaveFormat.func_75799_b();
/*  81 */     Collections.sort(this.field_146639_s);
/*  82 */     this.field_146640_r = -1;
/*     */   }
/*     */   
/*     */   protected String func_146621_a(int p_146621_1_) {
/*  86 */     return ((SaveFormatComparator)this.field_146639_s.get(p_146621_1_)).func_75786_a();
/*     */   }
/*     */   
/*     */   protected String func_146614_d(int p_146614_1_) {
/*  90 */     String str = ((SaveFormatComparator)this.field_146639_s.get(p_146614_1_)).func_75788_b();
/*     */     
/*  92 */     if (str == null || MathHelper.func_76139_a(str)) {
/*  93 */       str = I18n.func_135052_a("selectWorld.world", new Object[0]) + " " + (p_146614_1_ + 1);
/*     */     }
/*     */     
/*  96 */     return str;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_146618_g() {
/* 101 */     this.field_146292_n.add(this.field_146641_z = new GuiButton(1, this.field_146294_l / 2 - 154, this.field_146295_m - 52, 150, 20, I18n.func_135052_a("selectWorld.select", new Object[0])));
/* 102 */     this.field_146292_n.add(new GuiButton(3, this.field_146294_l / 2 + 4, this.field_146295_m - 52, 150, 20, I18n.func_135052_a("selectWorld.create", new Object[0])));
/*     */     
/* 104 */     this.field_146292_n.add(this.field_146630_A = new GuiButton(6, this.field_146294_l / 2 - 154, this.field_146295_m - 28, 72, 20, I18n.func_135052_a("selectWorld.rename", new Object[0])));
/* 105 */     this.field_146292_n.add(this.field_146642_y = new GuiButton(2, this.field_146294_l / 2 - 76, this.field_146295_m - 28, 72, 20, I18n.func_135052_a("selectWorld.delete", new Object[0])));
/* 106 */     this.field_146292_n.add(this.field_146631_B = new GuiButton(7, this.field_146294_l / 2 + 4, this.field_146295_m - 28, 72, 20, I18n.func_135052_a("selectWorld.recreate", new Object[0])));
/* 107 */     this.field_146292_n.add(new GuiButton(0, this.field_146294_l / 2 + 82, this.field_146295_m - 28, 72, 20, I18n.func_135052_a("gui.cancel", new Object[0])));
/*     */     
/* 109 */     this.field_146641_z.field_146124_l = false;
/* 110 */     this.field_146642_y.field_146124_l = false;
/* 111 */     this.field_146630_A.field_146124_l = false;
/* 112 */     this.field_146631_B.field_146124_l = false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_146284_a(GuiButton p_146284_1_) {
/* 117 */     if (!p_146284_1_.field_146124_l)
/* 118 */       return;  if (p_146284_1_.field_146127_k == 2) {
/* 119 */       String str = func_146614_d(this.field_146640_r);
/* 120 */       if (str != null) {
/* 121 */         this.field_146643_x = true;
/*     */         
/* 123 */         GuiYesNo guiYesNo = func_152129_a(this, str, this.field_146640_r);
/* 124 */         this.field_146297_k.func_147108_a(guiYesNo);
/*     */       } 
/* 126 */     } else if (p_146284_1_.field_146127_k == 1) {
/* 127 */       func_146615_e(this.field_146640_r);
/* 128 */     } else if (p_146284_1_.field_146127_k == 3) {
/* 129 */       this.field_146297_k.func_147108_a(new GuiCreateWorld(this));
/* 130 */     } else if (p_146284_1_.field_146127_k == 6) {
/* 131 */       this.field_146297_k.func_147108_a(new GuiRenameWorld(this, func_146621_a(this.field_146640_r)));
/* 132 */     } else if (p_146284_1_.field_146127_k == 0) {
/* 133 */       this.field_146297_k.func_147108_a(this.field_146632_a);
/* 134 */     } else if (p_146284_1_.field_146127_k == 7) {
/* 135 */       GuiCreateWorld guiCreateWorld = new GuiCreateWorld(this);
/* 136 */       ISaveHandler iSaveHandler = this.field_146297_k.func_71359_d().func_75804_a(func_146621_a(this.field_146640_r), false);
/* 137 */       WorldInfo worldInfo = iSaveHandler.func_75757_d();
/* 138 */       iSaveHandler.func_75759_a();
/*     */       
/* 140 */       guiCreateWorld.func_146318_a(worldInfo);
/* 141 */       this.field_146297_k.func_147108_a(guiCreateWorld);
/*     */     } else {
/* 143 */       this.field_146638_t.func_148147_a(p_146284_1_);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_146615_e(int p_146615_1_) {
/* 148 */     this.field_146297_k.func_147108_a(null);
/* 149 */     if (this.field_146634_i)
/* 150 */       return;  this.field_146634_i = true;
/*     */     
/* 152 */     String str1 = func_146621_a(p_146615_1_);
/* 153 */     if (str1 == null) {
/* 154 */       str1 = "World" + p_146615_1_;
/*     */     }
/* 156 */     String str2 = func_146614_d(p_146615_1_);
/* 157 */     if (str2 == null) {
/* 158 */       str2 = "World" + p_146615_1_;
/*     */     }
/*     */     
/* 161 */     if (this.field_146297_k.func_71359_d().func_90033_f(str1)) {
/* 162 */       this.field_146297_k.func_71371_a(str1, str2, null);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73878_a(boolean p_73878_1_, int p_73878_2_) {
/* 168 */     if (this.field_146643_x) {
/* 169 */       this.field_146643_x = false;
/* 170 */       if (p_73878_1_) {
/* 171 */         ISaveFormat iSaveFormat = this.field_146297_k.func_71359_d();
/* 172 */         iSaveFormat.func_75800_d();
/* 173 */         iSaveFormat.func_75802_e(func_146621_a(p_73878_2_));
/*     */         
/*     */         try {
/* 176 */           func_146627_h();
/* 177 */         } catch (AnvilConverterException anvilConverterException) {
/* 178 */           field_146629_g.error("Couldn't load level list", (Throwable)anvilConverterException);
/*     */         } 
/*     */       } 
/* 181 */       this.field_146297_k.func_147108_a(this);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
/* 187 */     this.field_146638_t.func_148128_a(p_73863_1_, p_73863_2_, p_73863_3_);
/*     */     
/* 189 */     func_73732_a(this.field_146289_q, this.field_146628_f, this.field_146294_l / 2, 20, 16777215);
/*     */     
/* 191 */     super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   class List extends GuiSlot { private static final String __OBFID = "CL_00000712";
/*     */     public List(GuiSelectWorld p_i1053_1_) {
/* 196 */       super(p_i1053_1_.field_146297_k, p_i1053_1_.field_146294_l, p_i1053_1_.field_146295_m, 32, p_i1053_1_.field_146295_m - 64, 36);
/*     */     }
/*     */ 
/*     */     
/*     */     protected int func_148127_b() {
/* 201 */       return this.field_148207_k.field_146639_s.size();
/*     */     }
/*     */ 
/*     */     
/*     */     protected void func_148144_a(int p_148144_1_, boolean p_148144_2_, int p_148144_3_, int p_148144_4_) {
/* 206 */       this.field_148207_k.field_146640_r = p_148144_1_;
/* 207 */       boolean bool = (this.field_148207_k.field_146640_r >= 0 && this.field_148207_k.field_146640_r < func_148127_b()) ? true : false;
/* 208 */       this.field_148207_k.field_146641_z.field_146124_l = bool;
/* 209 */       this.field_148207_k.field_146642_y.field_146124_l = bool;
/* 210 */       this.field_148207_k.field_146630_A.field_146124_l = bool;
/* 211 */       this.field_148207_k.field_146631_B.field_146124_l = bool;
/*     */       
/* 213 */       if (p_148144_2_ && bool) {
/* 214 */         this.field_148207_k.func_146615_e(p_148144_1_);
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     protected boolean func_148131_a(int p_148131_1_) {
/* 220 */       return (p_148131_1_ == this.field_148207_k.field_146640_r);
/*     */     }
/*     */ 
/*     */     
/*     */     protected int func_148138_e() {
/* 225 */       return this.field_148207_k.field_146639_s.size() * 36;
/*     */     }
/*     */ 
/*     */     
/*     */     protected void func_148123_a() {
/* 230 */       this.field_148207_k.func_146276_q_();
/*     */     }
/*     */ 
/*     */     
/*     */     protected void func_148126_a(int p_148126_1_, int p_148126_2_, int p_148126_3_, int p_148126_4_, Tessellator p_148126_5_, int p_148126_6_, int p_148126_7_) {
/* 235 */       SaveFormatComparator saveFormatComparator = this.field_148207_k.field_146639_s.get(p_148126_1_);
/*     */       
/* 237 */       String str1 = saveFormatComparator.func_75788_b();
/* 238 */       if (str1 == null || MathHelper.func_76139_a(str1)) {
/* 239 */         str1 = this.field_148207_k.field_146637_u + " " + (p_148126_1_ + 1);
/*     */       }
/*     */       
/* 242 */       String str2 = saveFormatComparator.func_75786_a();
/* 243 */       str2 = str2 + " (" + this.field_148207_k.field_146633_h.format(new Date(saveFormatComparator.func_75784_e()));
/* 244 */       str2 = str2 + ")";
/* 245 */       String str3 = "";
/*     */       
/* 247 */       if (saveFormatComparator.func_75785_d()) {
/* 248 */         str3 = this.field_148207_k.field_146636_v + " " + str3;
/*     */       } else {
/* 250 */         str3 = this.field_148207_k.field_146635_w[saveFormatComparator.func_75790_f().func_77148_a()];
/*     */         
/* 252 */         if (saveFormatComparator.func_75789_g()) {
/* 253 */           str3 = EnumChatFormatting.DARK_RED + I18n.func_135052_a("gameMode.hardcore", new Object[0]) + EnumChatFormatting.RESET;
/*     */         }
/*     */         
/* 256 */         if (saveFormatComparator.func_75783_h()) {
/* 257 */           str3 = str3 + ", " + I18n.func_135052_a("selectWorld.cheats", new Object[0]);
/*     */         }
/*     */       } 
/*     */       
/* 261 */       this.field_148207_k.func_73731_b(this.field_148207_k.field_146289_q, str1, p_148126_2_ + 2, p_148126_3_ + 1, 16777215);
/* 262 */       this.field_148207_k.func_73731_b(this.field_148207_k.field_146289_q, str2, p_148126_2_ + 2, p_148126_3_ + 12, 8421504);
/* 263 */       this.field_148207_k.func_73731_b(this.field_148207_k.field_146289_q, str3, p_148126_2_ + 2, p_148126_3_ + 12 + 10, 8421504);
/*     */     } }
/*     */ 
/*     */   
/*     */   public static GuiYesNo func_152129_a(GuiYesNoCallback p_152129_0_, String p_152129_1_, int p_152129_2_) {
/* 268 */     String str1 = I18n.func_135052_a("selectWorld.deleteQuestion", new Object[0]);
/* 269 */     String str2 = "'" + p_152129_1_ + "' " + I18n.func_135052_a("selectWorld.deleteWarning", new Object[0]);
/* 270 */     String str3 = I18n.func_135052_a("selectWorld.deleteButton", new Object[0]);
/* 271 */     String str4 = I18n.func_135052_a("gui.cancel", new Object[0]);
/*     */     
/* 273 */     return new GuiYesNo(p_152129_0_, str1, str2, str3, str4, p_152129_2_);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\gui\GuiSelectWorld.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */