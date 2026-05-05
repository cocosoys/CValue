/*     */ package net.minecraft.server.v1_7_R4;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ import org.bukkit.block.BlockState;
/*     */ import org.bukkit.inventory.InventoryHolder;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TileEntity
/*     */ {
/*  14 */   private static final Logger a = LogManager.getLogger();
/*  15 */   private static Map i = new HashMap<Object, Object>();
/*  16 */   private static Map j = new HashMap<Object, Object>();
/*     */   protected World world;
/*     */   public int x;
/*     */   public int y;
/*     */   public int z;
/*     */   protected boolean f;
/*  22 */   public int g = -1;
/*     */   
/*     */   public Block h;
/*     */ 
/*     */   
/*     */   private static void a(Class<?> oclass, String s) {
/*  28 */     if (i.containsKey(s)) {
/*  29 */       throw new IllegalArgumentException("Duplicate id: " + s);
/*     */     }
/*  31 */     i.put(s, oclass);
/*  32 */     j.put(oclass, s);
/*     */   }
/*     */ 
/*     */   
/*     */   public World getWorld() {
/*  37 */     return this.world;
/*     */   }
/*     */   
/*     */   public void a(World world) {
/*  41 */     this.world = world;
/*     */   }
/*     */   
/*     */   public boolean o() {
/*  45 */     return (this.world != null);
/*     */   }
/*     */   
/*     */   public void a(NBTTagCompound nbttagcompound) {
/*  49 */     this.x = nbttagcompound.getInt("x");
/*  50 */     this.y = nbttagcompound.getInt("y");
/*  51 */     this.z = nbttagcompound.getInt("z");
/*     */   }
/*     */   
/*     */   public void b(NBTTagCompound nbttagcompound) {
/*  55 */     String s = (String)j.get(getClass());
/*     */     
/*  57 */     if (s == null) {
/*  58 */       throw new RuntimeException(getClass() + " is missing a mapping! This is a bug!");
/*     */     }
/*  60 */     nbttagcompound.setString("id", s);
/*  61 */     nbttagcompound.setInt("x", this.x);
/*  62 */     nbttagcompound.setInt("y", this.y);
/*  63 */     nbttagcompound.setInt("z", this.z);
/*     */   }
/*     */ 
/*     */   
/*     */   public void h() {}
/*     */   
/*     */   public static TileEntity c(NBTTagCompound nbttagcompound) {
/*  70 */     TileEntity tileentity = null;
/*     */     
/*     */     try {
/*  73 */       Class<TileEntity> oclass = (Class)i.get(nbttagcompound.getString("id"));
/*     */       
/*  75 */       if (oclass != null) {
/*  76 */         tileentity = oclass.newInstance();
/*     */       }
/*  78 */     } catch (Exception exception) {
/*  79 */       exception.printStackTrace();
/*     */     } 
/*     */     
/*  82 */     if (tileentity != null) {
/*  83 */       tileentity.a(nbttagcompound);
/*     */     } else {
/*  85 */       a.warn("Skipping BlockEntity with id " + nbttagcompound.getString("id"));
/*     */     } 
/*     */     
/*  88 */     return tileentity;
/*     */   }
/*     */   
/*     */   public int p() {
/*  92 */     if (this.g == -1) {
/*  93 */       this.g = this.world.getData(this.x, this.y, this.z);
/*     */     }
/*     */     
/*  96 */     return this.g;
/*     */   }
/*     */   
/*     */   public void update() {
/* 100 */     if (this.world != null) {
/* 101 */       this.g = this.world.getData(this.x, this.y, this.z);
/* 102 */       this.world.b(this.x, this.y, this.z, this);
/* 103 */       if (q() != Blocks.AIR) {
/* 104 */         this.world.updateAdjacentComparators(this.x, this.y, this.z, q());
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public Block q() {
/* 110 */     if (this.h == null) {
/* 111 */       this.h = this.world.getType(this.x, this.y, this.z);
/*     */     }
/*     */     
/* 114 */     return this.h;
/*     */   }
/*     */   
/*     */   public Packet getUpdatePacket() {
/* 118 */     return null;
/*     */   }
/*     */   
/*     */   public boolean r() {
/* 122 */     return this.f;
/*     */   }
/*     */   
/*     */   public void s() {
/* 126 */     this.f = true;
/*     */   }
/*     */   
/*     */   public void t() {
/* 130 */     this.f = false;
/*     */   }
/*     */   
/*     */   public boolean c(int i, int j) {
/* 134 */     return false;
/*     */   }
/*     */   
/*     */   public void u() {
/* 138 */     this.h = null;
/* 139 */     this.g = -1;
/*     */   }
/*     */   
/*     */   public void a(CrashReportSystemDetails crashreportsystemdetails) {
/* 143 */     crashreportsystemdetails.a("Name", new CrashReportTileEntityName(this));
/* 144 */     CrashReportSystemDetails.a(crashreportsystemdetails, this.x, this.y, this.z, q(), p());
/* 145 */     crashreportsystemdetails.a("Actual block type", new CrashReportTileEntityType(this));
/* 146 */     crashreportsystemdetails.a("Actual block data value", new CrashReportTileEntityData(this));
/*     */   }
/*     */   
/*     */   static Map v() {
/* 150 */     return j;
/*     */   }
/*     */   
/*     */   static {
/* 154 */     a(TileEntityFurnace.class, "Furnace");
/* 155 */     a(TileEntityChest.class, "Chest");
/* 156 */     a(TileEntityEnderChest.class, "EnderChest");
/* 157 */     a(TileEntityRecordPlayer.class, "RecordPlayer");
/* 158 */     a(TileEntityDispenser.class, "Trap");
/* 159 */     a(TileEntityDropper.class, "Dropper");
/* 160 */     a(TileEntitySign.class, "Sign");
/* 161 */     a(TileEntityMobSpawner.class, "MobSpawner");
/* 162 */     a(TileEntityNote.class, "Music");
/* 163 */     a(TileEntityPiston.class, "Piston");
/* 164 */     a(TileEntityBrewingStand.class, "Cauldron");
/* 165 */     a(TileEntityEnchantTable.class, "EnchantTable");
/* 166 */     a(TileEntityEnderPortal.class, "Airportal");
/* 167 */     a(TileEntityCommand.class, "Control");
/* 168 */     a(TileEntityBeacon.class, "Beacon");
/* 169 */     a(TileEntitySkull.class, "Skull");
/* 170 */     a(TileEntityLightDetector.class, "DLDetector");
/* 171 */     a(TileEntityHopper.class, "Hopper");
/* 172 */     a(TileEntityComparator.class, "Comparator");
/* 173 */     a(TileEntityFlowerPot.class, "FlowerPot");
/*     */   }
/*     */ 
/*     */   
/*     */   public InventoryHolder getOwner() {
/* 178 */     BlockState state = this.world.getWorld().getBlockAt(this.x, this.y, this.z).getState();
/* 179 */     if (state instanceof InventoryHolder) return (InventoryHolder)state; 
/* 180 */     return null;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\TileEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */