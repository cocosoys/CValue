/*     */ package JinRyuu.JRMCore;
/*     */ import JinRyuu.JRMCore.entity.EntitySafeZone;
/*     */ import JinRyuu.JRMCore.manager.JRMCoreManagerDBC;
/*     */ import JinRyuu.JRMCore.manager.JRMCoreManagerNC;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import net.minecraft.command.CommandBase;
/*     */ import net.minecraft.command.ICommand;
/*     */ import net.minecraft.command.ICommandSender;
/*     */ import net.minecraft.command.WrongUsageException;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class ComJrmcSafeZone extends CommandBase {
/*  19 */   private final int DBC_MASTERS = 16; private final int NC_MASTERS = 3;
/*  20 */   private final String[] MODES = new String[] { "add", "change", "remove" };
/*     */ 
/*     */   
/*  23 */   private final String ADD = "add";
/*  24 */   private final String CHANGE = "change";
/*  25 */   private final String REMOVE = "remove";
/*  26 */   private final String name = "jrmcsafezone";
/*     */   
/*     */   public String func_71517_b() {
/*  29 */     return "jrmcsafezone";
/*     */   }
/*     */   
/*     */   public String func_71518_a(ICommandSender icommandsender) {
/*  33 */     return "/jrmcsafezone [playerName] (add/change/remove) (MasterName) (x) (y) (z) (safezone radiusXZ) (safezone radiusY) (duplication Check Radius) ((Safe Zone Name)).";
/*     */   }
/*     */   
/*     */   public int func_82362_a() {
/*  37 */     return 2;
/*     */   }
/*     */   
/*     */   public void func_71515_b(ICommandSender commandSender, String[] stringArray) {
/*     */     EntityPlayerMP entityplayermp;
/*  42 */     int commandLength = stringArray.length;
/*  43 */     if (commandLength <= 0)
/*     */     {
/*  45 */       throw new WrongUsageException("Usage: " + func_71518_a(commandSender), new Object[0]);
/*     */     }
/*     */ 
/*     */     
/*  49 */     int stringID = 0;
/*     */ 
/*     */     
/*     */     try {
/*  53 */       entityplayermp = func_82359_c(commandSender, stringArray[stringID++]);
/*     */     }
/*  55 */     catch (Exception e) {
/*     */       
/*  57 */       entityplayermp = func_71521_c(commandSender);
/*     */     } 
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
/*  69 */     String mode = stringArray[stringID++].toLowerCase();
/*     */ 
/*     */     
/*  72 */     String masterID = stringArray[stringID++];
/*     */     
/*  74 */     String[] list = getMasterIDList();
/*  75 */     int length = list.length;
/*  76 */     int id = -1;
/*     */     
/*  78 */     boolean dbc = JRMCoreH.DBC();
/*  79 */     boolean nc = JRMCoreH.NC();
/*     */     
/*  81 */     for (int i = 0; i < length; i++) {
/*     */       
/*  83 */       if (masterID.toLowerCase().equals(list[i].toLowerCase())) {
/*     */ 
/*     */         
/*  86 */         if ((!dbc && i > 0 && i < length - (nc ? 3 : 0)) || (!nc && i > length - 1 - (nc ? 3 : 0)))
/*  87 */           break;  id = i;
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/*  92 */     if (id != -1) {
/*     */       
/*  94 */       String x = stringArray[stringID++];
/*  95 */       String y = stringArray[stringID++];
/*  96 */       String z = stringArray[stringID++];
/*     */       
/*  98 */       String safezoneRXZ = "";
/*  99 */       String safezoneRY = "";
/* 100 */       String duplicationCheckR = "";
/*     */       
/* 102 */       String name = "";
/*     */       
/* 104 */       boolean add = mode.equals("add");
/*     */       
/* 106 */       boolean remove = mode.equals("remove");
/*     */       
/* 108 */       if (!remove) {
/*     */         
/* 110 */         safezoneRXZ = stringArray[stringID++];
/* 111 */         safezoneRY = stringArray[stringID++];
/* 112 */         duplicationCheckR = stringArray[stringID++];
/*     */ 
/*     */         
/* 115 */         for (int k = stringID; k < commandLength; k++) {
/*     */           
/* 117 */           name = name + stringArray[stringID++].replace("(", "").replace(")", "") + ((k + 1 < commandLength && !stringArray[stringID - 1].endsWith(")")) ? " " : "");
/* 118 */           if (stringArray[stringID - 1].endsWith(")")) {
/*     */             break;
/*     */           }
/*     */         } 
/* 122 */         if (name.length() > 0)
/*     */         {
/* 124 */           name = name.replace(":", "").replace(";", "");
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 129 */       World world = commandSender.func_130014_f_();
/* 130 */       EntitySafeZone master = getEntityList(entityplayermp)[id];
/*     */ 
/*     */       
/* 133 */       double xPos = 0.0D, yPos = 0.0D, zPos = 0.0D;
/*     */       
/* 135 */       if (x != null && x.length() > 0 && !x.equals("~")) { xPos = Double.parseDouble(x); }
/* 136 */       else { xPos = entityplayermp.field_70165_t; }
/*     */       
/* 138 */       if (y != null && y.length() > 0 && !y.equals("~")) { yPos = Double.parseDouble(y); }
/* 139 */       else { yPos = entityplayermp.field_70163_u; }
/*     */       
/* 141 */       if (z != null && z.length() > 0 && !z.equals("~")) { zPos = Double.parseDouble(z); }
/* 142 */       else { zPos = entityplayermp.field_70161_v; }
/*     */ 
/*     */       
/* 145 */       boolean sendMessage = true;
/*     */ 
/*     */       
/* 148 */       if (!remove) {
/*     */         
/* 150 */         if (name != null && name.length() > 0) master.name = name;
/*     */         
/* 152 */         if (safezoneRXZ != null && safezoneRXZ.length() > 0) {
/* 153 */           master.safezoneRadiusXZ = Integer.parseInt(safezoneRXZ);
/* 154 */           if (master.safezoneRadiusXZ < 0) master.safezoneRadiusXZ = 0; 
/*     */         } 
/* 156 */         if (safezoneRY != null && safezoneRY.length() > 0) {
/* 157 */           master.safezoneRadiusY = Integer.parseInt(safezoneRY);
/* 158 */           if (master.safezoneRadiusY < 0) master.safezoneRadiusY = 0; 
/*     */         } 
/* 160 */         if (duplicationCheckR != null && duplicationCheckR.length() > 0) {
/* 161 */           master.duplicatesRadius = Integer.parseInt(duplicationCheckR);
/* 162 */           if (master.duplicatesRadius < 0) master.duplicatesRadius = 0;
/*     */         
/*     */         } 
/*     */       } 
/* 166 */       if (add) {
/*     */         
/* 168 */         if (name != null && name.length() > 0) master.name = name;
/*     */         
/* 170 */         if (safezoneRXZ != null && safezoneRXZ.length() > 0) {
/* 171 */           master.safezoneRadiusXZ = Integer.parseInt(safezoneRXZ);
/* 172 */           if (master.safezoneRadiusXZ < 0) master.safezoneRadiusXZ = 0; 
/*     */         } 
/* 174 */         if (safezoneRY != null && safezoneRY.length() > 0) {
/* 175 */           master.safezoneRadiusY = Integer.parseInt(safezoneRY);
/* 176 */           if (master.safezoneRadiusY < 0) master.safezoneRadiusY = 0; 
/*     */         } 
/* 178 */         if (duplicationCheckR != null && duplicationCheckR.length() > 0) {
/* 179 */           master.duplicatesRadius = Integer.parseInt(duplicationCheckR);
/* 180 */           if (master.duplicatesRadius < 0) master.duplicatesRadius = 0;
/*     */         
/*     */         } 
/* 183 */         master.func_70107_b(xPos, yPos, zPos);
/* 184 */         world.func_72838_d((Entity)master);
/* 185 */         if (sendMessage) notifyAdmins(commandSender, "Safe Zone Created: %s by %s", new Object[] { masterID, entityplayermp.func_70005_c_() });
/*     */ 
/*     */         
/*     */         return;
/*     */       } 
/* 190 */       int r = 2;
/* 191 */       AxisAlignedBB ab = AxisAlignedBB.func_72330_a(xPos - r, yPos - r, zPos - r, xPos + r, yPos + r, zPos + r);
/* 192 */       List<EntitySafeZone> list2 = world.func_72872_a(master.getClass(), ab);
/*     */       
/* 194 */       for (int j = 0; list2.size() > j; j++) {
/*     */         
/* 196 */         EntitySafeZone entity = list2.get(j);
/* 197 */         if (entity.getClass().equals(master.getClass())) {
/*     */           
/* 199 */           if (remove) {
/*     */             
/* 201 */             if (sendMessage) notifyAdmins(commandSender, "Safe Zone Removed: %s by %s", new Object[] { masterID, entityplayermp.func_70005_c_() }); 
/* 202 */             entity.removeAllPlayers();
/* 203 */             entity.func_70106_y();
/*     */           
/*     */           }
/*     */           else {
/*     */             
/* 208 */             if (sendMessage) notifyAdmins(commandSender, "Safe Zone Changed: %s by %s", new Object[] { masterID, entityplayermp.func_70005_c_() }); 
/* 209 */             entity.removeAllPlayers();
/* 210 */             entity.name = name;
/* 211 */             if (safezoneRXZ != null && safezoneRXZ.length() > 0) {
/* 212 */               entity.safezoneRadiusXZ = Integer.parseInt(safezoneRXZ);
/* 213 */               if (entity.safezoneRadiusXZ < 0) entity.safezoneRadiusXZ = 0; 
/*     */             } 
/* 215 */             if (safezoneRY != null && safezoneRY.length() > 0) {
/* 216 */               entity.safezoneRadiusY = Integer.parseInt(safezoneRY);
/* 217 */               if (entity.safezoneRadiusY < 0) entity.safezoneRadiusY = 0; 
/*     */             } 
/* 219 */             if (duplicationCheckR != null && duplicationCheckR.length() > 0) {
/* 220 */               entity.duplicatesRadius = Integer.parseInt(duplicationCheckR);
/* 221 */               if (entity.duplicatesRadius < 0) entity.duplicatesRadius = 0;
/*     */             
/*     */             } 
/*     */           } 
/*     */           
/*     */           return;
/*     */         } 
/*     */       } 
/* 229 */       throw new WrongUsageException("ERROR: No Master was found to delete! '" + masterID + "'", new Object[0]);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 234 */     throw new WrongUsageException("ERROR: Master Name was not found! '" + masterID + "'", new Object[0]);
/*     */   }
/*     */ 
/*     */   
/*     */   private void notifyAdmins(ICommandSender commandSender, String string, Object[] objects) {
/* 239 */     func_152373_a(commandSender, (ICommand)this, string, objects);
/*     */   }
/*     */   
/*     */   private String[] getMasterIDList() {
/* 243 */     ArrayList<String> entityNames = new ArrayList<String>();
/* 244 */     entityNames.add("Empty");
/*     */     
/* 246 */     if (JRMCoreH.DBC())
/*     */     {
/* 248 */       entityNames.addAll(Arrays.asList(JRMCoreManagerDBC.getMasterNames()));
/*     */     }
/*     */     
/* 251 */     if (JRMCoreH.NC())
/*     */     {
/* 253 */       entityNames.addAll(Arrays.asList(JRMCoreManagerNC.getMasterNames()));
/*     */     }
/*     */     
/* 256 */     String[] names = new String[entityNames.size()];
/* 257 */     int i = 0;
/* 258 */     for (String name : entityNames) {
/*     */       
/* 260 */       names[i] = name;
/* 261 */       i++;
/*     */     } 
/* 263 */     return names;
/*     */   }
/*     */ 
/*     */   
/*     */   private EntitySafeZone[] getEntityList(EntityPlayerMP entityplayermp) {
/* 268 */     ArrayList<EntitySafeZone> entityNames = new ArrayList<EntitySafeZone>();
/* 269 */     entityNames.add(new EntitySafeZone(entityplayermp.field_70170_p));
/*     */     
/* 271 */     if (JRMCoreH.DBC())
/*     */     {
/* 273 */       entityNames.addAll(Arrays.asList(JRMCoreManagerDBC.getMasters(entityplayermp)));
/*     */     }
/*     */     
/* 276 */     if (JRMCoreH.NC())
/*     */     {
/* 278 */       entityNames.addAll(Arrays.asList(JRMCoreManagerNC.getMasters(entityplayermp)));
/*     */     }
/*     */     
/* 281 */     EntitySafeZone[] names = new EntitySafeZone[entityNames.size()];
/* 282 */     int i = 0;
/* 283 */     for (EntitySafeZone name : entityNames) {
/*     */       
/* 285 */       names[i] = name;
/* 286 */       i++;
/*     */     } 
/* 288 */     return names;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List func_71516_a(ICommandSender par1ICommandSender, String[] arrayString) {
/* 294 */     int length = arrayString.length;
/* 295 */     switch (length) { case 1:
/* 296 */         return func_71530_a(arrayString, getListOfPlayers());
/* 297 */       case 2: return func_71530_a(arrayString, this.MODES);
/* 298 */       case 3: return func_71530_a(arrayString, getMasterIDList());
/* 299 */       case 4: return func_71530_a(arrayString, new String[] { "~", "0.0" });
/* 300 */       case 5: return func_71530_a(arrayString, new String[] { "~", "0.0" });
/* 301 */       case 6: return func_71530_a(arrayString, new String[] { "~", "0.0" });
/* 302 */       case 7: return func_71530_a(arrayString, new String[] { "60" });
/* 303 */       case 8: return func_71530_a(arrayString, new String[] { "60" });
/* 304 */       case 9: return func_71530_a(arrayString, new String[] { "2" });
/* 305 */       case 10: return func_71530_a(arrayString, new String[] { "(Safe Zone Name)" }); }
/* 306 */      return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected String[] getListOfPlayers() {
/* 312 */     return MinecraftServer.func_71276_C().func_71213_z();
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\ComJrmcSafeZone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */