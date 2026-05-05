/*     */ package net.minecraft.tileentity;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.Callable;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockJukebox;
/*     */ import net.minecraft.crash.CrashReportCategory;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.world.World;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ 
/*     */ public class TileEntity {
/*  16 */   private static final Logger field_145852_a = LogManager.getLogger();
/*  17 */   private static Map field_145855_i = new HashMap<Object, Object>();
/*  18 */   private static Map field_145853_j = new HashMap<Object, Object>(); protected World field_145850_b; public int field_145851_c;
/*     */   
/*     */   public static void func_145826_a(Class<?> p_145826_0_, String p_145826_1_) {
/*  21 */     if (field_145855_i.containsKey(p_145826_1_)) throw new IllegalArgumentException("Duplicate id: " + p_145826_1_); 
/*  22 */     field_145855_i.put(p_145826_1_, p_145826_0_);
/*  23 */     field_145853_j.put(p_145826_0_, p_145826_1_);
/*     */   }
/*     */   public int field_145848_d; public int field_145849_e; protected boolean field_145846_f;
/*     */   static {
/*  27 */     func_145826_a(TileEntityFurnace.class, "Furnace");
/*  28 */     func_145826_a(TileEntityChest.class, "Chest");
/*  29 */     func_145826_a(TileEntityEnderChest.class, "EnderChest");
/*  30 */     func_145826_a(BlockJukebox.TileEntityJukebox.class, "RecordPlayer");
/*  31 */     func_145826_a(TileEntityDispenser.class, "Trap");
/*  32 */     func_145826_a(TileEntityDropper.class, "Dropper");
/*  33 */     func_145826_a(TileEntitySign.class, "Sign");
/*  34 */     func_145826_a(TileEntityMobSpawner.class, "MobSpawner");
/*  35 */     func_145826_a(TileEntityNote.class, "Music");
/*  36 */     func_145826_a(TileEntityPiston.class, "Piston");
/*  37 */     func_145826_a(TileEntityBrewingStand.class, "Cauldron");
/*  38 */     func_145826_a(TileEntityEnchantmentTable.class, "EnchantTable");
/*  39 */     func_145826_a(TileEntityEndPortal.class, "Airportal");
/*  40 */     func_145826_a(TileEntityCommandBlock.class, "Control");
/*  41 */     func_145826_a(TileEntityBeacon.class, "Beacon");
/*  42 */     func_145826_a(TileEntitySkull.class, "Skull");
/*  43 */     func_145826_a(TileEntityDaylightDetector.class, "DLDetector");
/*  44 */     func_145826_a(TileEntityHopper.class, "Hopper");
/*  45 */     func_145826_a(TileEntityComparator.class, "Comparator");
/*  46 */     func_145826_a(TileEntityFlowerPot.class, "FlowerPot");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  53 */   public int field_145847_g = -1; public Block field_145854_h;
/*     */   private static final String __OBFID = "CL_00000340";
/*     */   
/*     */   public World func_145831_w() {
/*  57 */     return this.field_145850_b;
/*     */   }
/*     */   
/*     */   public void func_145834_a(World p_145834_1_) {
/*  61 */     this.field_145850_b = p_145834_1_;
/*     */   }
/*     */   
/*     */   public boolean func_145830_o() {
/*  65 */     return (this.field_145850_b != null);
/*     */   }
/*     */   
/*     */   public void func_145839_a(NBTTagCompound p_145839_1_) {
/*  69 */     this.field_145851_c = p_145839_1_.func_74762_e("x");
/*  70 */     this.field_145848_d = p_145839_1_.func_74762_e("y");
/*  71 */     this.field_145849_e = p_145839_1_.func_74762_e("z");
/*     */   }
/*     */   
/*     */   public void func_145841_b(NBTTagCompound p_145841_1_) {
/*  75 */     String str = (String)field_145853_j.get(getClass());
/*  76 */     if (str == null) {
/*  77 */       throw new RuntimeException(getClass() + " is missing a mapping! This is a bug!");
/*     */     }
/*  79 */     p_145841_1_.func_74778_a("id", str);
/*  80 */     p_145841_1_.func_74768_a("x", this.field_145851_c);
/*  81 */     p_145841_1_.func_74768_a("y", this.field_145848_d);
/*  82 */     p_145841_1_.func_74768_a("z", this.field_145849_e);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_145845_h() {}
/*     */   
/*     */   public static TileEntity func_145827_c(NBTTagCompound p_145827_0_) {
/*  89 */     TileEntity tileEntity = null;
/*     */     try {
/*  91 */       Class<TileEntity> clazz = (Class)field_145855_i.get(p_145827_0_.func_74779_i("id"));
/*  92 */       if (clazz != null) tileEntity = clazz.newInstance(); 
/*  93 */     } catch (Exception exception) {
/*  94 */       exception.printStackTrace();
/*     */     } 
/*  96 */     if (tileEntity != null) {
/*  97 */       tileEntity.func_145839_a(p_145827_0_);
/*     */     } else {
/*  99 */       field_145852_a.warn("Skipping BlockEntity with id " + p_145827_0_.func_74779_i("id"));
/*     */     } 
/* 101 */     return tileEntity;
/*     */   }
/*     */   
/*     */   public int func_145832_p() {
/* 105 */     if (this.field_145847_g == -1) this.field_145847_g = this.field_145850_b.func_72805_g(this.field_145851_c, this.field_145848_d, this.field_145849_e); 
/* 106 */     return this.field_145847_g;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70296_d() {
/* 115 */     if (this.field_145850_b != null) {
/* 116 */       this.field_145847_g = this.field_145850_b.func_72805_g(this.field_145851_c, this.field_145848_d, this.field_145849_e);
/* 117 */       this.field_145850_b.func_147476_b(this.field_145851_c, this.field_145848_d, this.field_145849_e, this);
/*     */       
/* 119 */       if (func_145838_q() != Blocks.field_150350_a)
/* 120 */         this.field_145850_b.func_147453_f(this.field_145851_c, this.field_145848_d, this.field_145849_e, func_145838_q()); 
/*     */     } 
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public double func_145835_a(double p_145835_1_, double p_145835_3_, double p_145835_5_) {
/* 126 */     double d1 = this.field_145851_c + 0.5D - p_145835_1_;
/* 127 */     double d2 = this.field_145848_d + 0.5D - p_145835_3_;
/* 128 */     double d3 = this.field_145849_e + 0.5D - p_145835_5_;
/* 129 */     return d1 * d1 + d2 * d2 + d3 * d3;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public double func_145833_n() {
/* 133 */     return 4096.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public Block func_145838_q() {
/* 138 */     if (this.field_145854_h == null) {
/* 139 */       this.field_145854_h = this.field_145850_b.func_147439_a(this.field_145851_c, this.field_145848_d, this.field_145849_e);
/*     */     }
/* 141 */     return this.field_145854_h;
/*     */   }
/*     */   
/*     */   public Packet func_145844_m() {
/* 145 */     return null;
/*     */   }
/*     */   
/*     */   public boolean func_145837_r() {
/* 149 */     return this.field_145846_f;
/*     */   }
/*     */   
/*     */   public void func_145843_s() {
/* 153 */     this.field_145846_f = true;
/*     */   }
/*     */   
/*     */   public void func_145829_t() {
/* 157 */     this.field_145846_f = false;
/*     */   }
/*     */   
/*     */   public boolean func_145842_c(int p_145842_1_, int p_145842_2_) {
/* 161 */     return false;
/*     */   }
/*     */   
/*     */   public void func_145836_u() {
/* 165 */     this.field_145854_h = null;
/* 166 */     this.field_145847_g = -1;
/*     */   }
/*     */   
/*     */   public void func_145828_a(CrashReportCategory p_145828_1_) {
/* 170 */     p_145828_1_.func_71500_a("Name", new Callable(this) { private static final String __OBFID = "CL_00000341";
/*     */           
/*     */           public String call() {
/* 173 */             return (String)TileEntity.field_145853_j.get(this.field_150830_a.getClass()) + " // " + this.field_150830_a.getClass().getCanonicalName();
/*     */           } }
/*     */       );
/*     */     
/* 177 */     CrashReportCategory.func_147153_a(p_145828_1_, this.field_145851_c, this.field_145848_d, this.field_145849_e, func_145838_q(), func_145832_p());
/*     */     
/* 179 */     p_145828_1_.func_71500_a("Actual block type", new Callable(this) { private static final String __OBFID = "CL_00000343";
/*     */           
/*     */           public String call() {
/* 182 */             int i = Block.func_149682_b(this.field_150832_a.field_145850_b.func_147439_a(this.field_150832_a.field_145851_c, this.field_150832_a.field_145848_d, this.field_150832_a.field_145849_e));
/*     */             try {
/* 184 */               return String.format("ID #%d (%s // %s)", new Object[] { Integer.valueOf(i), Block.func_149729_e(i).func_149739_a(), Block.func_149729_e(i).getClass().getCanonicalName() });
/* 185 */             } catch (Throwable throwable) {
/* 186 */               return "ID #" + i;
/*     */             } 
/*     */           } }
/*     */       );
/*     */     
/* 191 */     p_145828_1_.func_71500_a("Actual block data value", new Callable(this) { private static final String __OBFID = "CL_00000344";
/*     */           
/*     */           public String call() {
/* 194 */             int i = this.field_150834_a.field_145850_b.func_72805_g(this.field_150834_a.field_145851_c, this.field_150834_a.field_145848_d, this.field_150834_a.field_145849_e);
/* 195 */             if (i < 0) return "Unknown? (Got " + i + ")"; 
/* 196 */             String str = String.format("%4s", new Object[] { Integer.toBinaryString(i) }).replace(" ", "0");
/*     */ 
/*     */             
/* 199 */             return String.format("%1$d / 0x%1$X / 0b%2$s", new Object[] { Integer.valueOf(i), str });
/*     */           } }
/*     */       );
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\tileentity\TileEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */