/*     */ package JinRyuu.JRMCore.i;
/*     */ 
/*     */ import JinRyuu.JRMCore.JRMCoreConfig;
/*     */ import JinRyuu.JRMCore.JRMCoreH;
/*     */ import JinRyuu.JRMCore.JRMCoreHDBC;
/*     */ import JinRyuu.JRMCore.JRMCoreM;
/*     */ import JinRyuu.JRMCore.JRMCoreMsn;
/*     */ import JinRyuu.JRMCore.JRMCoreMsnBundle;
/*     */ import JinRyuu.JRMCore.client.config.jrmc.JGConfigClientSettings;
/*     */ import JinRyuu.JRMCore.entity.EntityEng;
/*     */ import com.google.common.collect.Lists;
/*     */ import cpw.mods.fml.common.FMLCommonHandler;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityList;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.IExtendedEntityProperties;
/*     */ import org.apache.commons.lang3.math.NumberUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ExtendedPlayer
/*     */   implements IExtendedEntityProperties
/*     */ {
/*     */   public static final String EXT_PROP_NAME = "JRMCEP";
/*  35 */   private final String extra_data_base = "0;0;0f;0;0;0;0;0;0;0;0;0;"; public static final int BLOCKING = 20;
/*     */   public static final int OTHERCODE = 21;
/*     */   public static final int HAIRCODE = 22;
/*     */   public static final int KISHOTNOW = 0;
/*     */   public static final int KISHOTCOL = 1;
/*     */   public static final int KISHOTSI = 2;
/*     */   public static final int KISHOTPART = 3;
/*     */   public static final int HANDEFFECT = 4;
/*  43 */   private int saga = -1; public static final int HANDEFFECT2 = 5; public static final int HANDEFFECT3 = 6; public static final int UIANIMATION = 7; public static final int UIANIMATION_ID = 9; public static final int KISHOOTANIM = 8; public static final int KISHOOTANIM_ON = 10; public static final int GOD_OF_DESTRUCTION_ON = 11; private final EntityPlayer player;
/*  44 */   private int side = -1;
/*     */ 
/*     */ 
/*     */   
/*  48 */   public final InventoryCustomPlayer inventory = new InventoryCustomPlayer();
/*     */ 
/*     */   
/*     */   private int blocking;
/*     */   
/*     */   private String haircode;
/*     */   
/*     */   private String extracode;
/*     */   
/*  57 */   private final int extra_data_sum = 12;
/*     */   
/*  59 */   private final byte HEALTH = 0; private final byte ENERGY = 1; private final byte STAMINA = 2;
/*     */ 
/*     */ 
/*     */   
/*  63 */   private int hairCheckDim = -1;
/*     */   
/*     */   private boolean MRC = true;
/*     */ 
/*     */   
/*     */   public ExtendedPlayer(EntityPlayer player) {
/*  69 */     this.player = player;
/*     */     
/*  71 */     this.blocking = 0;
/*  72 */     this.haircode = "";
/*  73 */     this.extracode = "0;0;0f;0;0;0;0;0;0;0;0;0;";
/*     */     
/*  75 */     this.player.func_70096_w().func_75682_a(JRMCoreConfig.ExtendedPlayerBlockID, Integer.valueOf(this.blocking));
/*  76 */     this.player.func_70096_w().func_75682_a(JRMCoreConfig.ExtendedPlayerOtherID, this.extracode);
/*  77 */     this.player.func_70096_w().func_75682_a(JRMCoreConfig.ExtendedPlayerHairID, this.haircode);
/*     */   }
/*     */   
/*     */   public static final void register(EntityPlayer player) {
/*  81 */     player.registerExtendedProperties("JRMCEP", new ExtendedPlayer(player));
/*     */   }
/*     */   public static final ExtendedPlayer get(EntityPlayer player) {
/*  84 */     return (ExtendedPlayer)player.getExtendedProperties("JRMCEP");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void copy(ExtendedPlayer props) {
/*  92 */     this.inventory.copy(props.inventory);
/*  93 */     this.blocking = props.blocking;
/*  94 */     this.haircode = "";
/*  95 */     this.extracode = "0;0;0f;0;0;0;0;0;0;0;0;0;";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void saveNBTData(NBTTagCompound compound) {
/* 104 */     NBTTagCompound properties = new NBTTagCompound();
/*     */ 
/*     */     
/* 107 */     this.inventory.writeToNBT(properties);
/* 108 */     properties.func_74768_a("blocking", this.player.func_70096_w().func_75679_c(JRMCoreConfig.ExtendedPlayerBlockID));
/* 109 */     properties.func_74778_a("haircode", this.player.func_70096_w().func_75681_e(JRMCoreConfig.ExtendedPlayerHairID));
/* 110 */     properties.func_74778_a("extracode", this.player.func_70096_w().func_75681_e(JRMCoreConfig.ExtendedPlayerOtherID));
/*     */ 
/*     */     
/* 113 */     compound.func_74782_a("JRMCEP", (NBTBase)properties);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void loadNBTData(NBTTagCompound compound) {
/* 122 */     NBTTagCompound properties = (NBTTagCompound)compound.func_74781_a("JRMCEP");
/* 123 */     this.inventory.readFromNBT(properties);
/*     */     
/* 125 */     this.player.func_70096_w().func_75692_b(JRMCoreConfig.ExtendedPlayerBlockID, Integer.valueOf(properties.func_74762_e("blocking")));
/* 126 */     this.player.func_70096_w().func_75692_b(JRMCoreConfig.ExtendedPlayerHairID, properties.func_74779_i("haircode"));
/* 127 */     if ((properties.func_74779_i("extracode").split(";")).length == 12) {
/*     */       
/* 129 */       this.player.func_70096_w().func_75692_b(JRMCoreConfig.ExtendedPlayerOtherID, properties.func_74779_i("extracode"));
/*     */     } else {
/* 131 */       this.player.func_70096_w().func_75692_b(JRMCoreConfig.ExtendedPlayerOtherID, "0;0;0f;0;0;0;0;0;0;0;0;0;");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void init(Entity entity, World world) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate() {
/* 143 */     if (getUIAnim() > 0) {
/*     */       
/* 145 */       setUIAnim(getUIAnim() - 1);
/*     */     }
/* 147 */     else if (getUIAnim() < 0) {
/*     */       
/* 149 */       setUIAnim(getUIAnim() + 1);
/*     */     } 
/* 151 */     if (getUIAnim() == 0) setUIAnimID(0);
/*     */     
/* 153 */     if (!this.player.field_70170_p.field_72995_K) {
/*     */ 
/*     */       
/* 156 */       if (JRMCoreH.updateEveryXTick(this.player.field_70173_aa, 10)) {
/*     */         
/* 158 */         String ex = "";
/* 159 */         if (this.hairCheckDim != this.player.field_71093_bK) {
/*     */           
/* 161 */           this.hairCheckDim = this.player.field_71093_bK;
/* 162 */           ex = "0";
/*     */         } 
/* 164 */         this.haircode = JRMCoreH.getString(this.player, "jrmcDNSH") + ex;
/* 165 */         setHairCode(this.haircode);
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 176 */       if (JRMCoreH.updateEveryXTick(this.player.field_70173_aa, JRMCoreConfig.plUpd)) {
/*     */         
/* 178 */         NBTTagCompound nbt = JRMCoreH.nbt((Entity)this.player, "pres");
/* 179 */         String msd = nbt.func_74779_i("JRMCmissionSync");
/* 180 */         String msdV = nbt.func_74779_i("JRMCmissionSyncVers");
/*     */         
/* 182 */         int syncDaam = 0;
/* 183 */         if (msd.length() > 3 && JRMCoreM.missions != null) {
/*     */           
/* 185 */           String msdO = msd;
/* 186 */           String msdVO = msdV;
/* 187 */           HashMap<String, Integer> h = new HashMap<String, Integer>();
/* 188 */           int pw = nbt.func_74771_c("jrmcPwrtyp");
/* 189 */           int rc = nbt.func_74771_c("jrmcRace");
/* 190 */           int cl = nbt.func_74771_c("jrmcClass");
/* 191 */           int st = nbt.func_74771_c("jrmcState");
/*     */           
/* 193 */           ArrayList<EntityPlayer> ps = JRMCoreM.prog(this.player, true);
/* 194 */           int g = ps.size();
/*     */           
/* 196 */           syncDaam = JRMCoreM.getSydaAmount(msd);
/* 197 */           for (int i = 0; i < syncDaam; i++) {
/*     */             
/* 199 */             String sid = JRMCoreM.getMda_Series(msd, i);
/* 200 */             int msnToSendID = JRMCoreM.getMda_Mission(msd, i);
/*     */             
/* 202 */             ps = JRMCoreM.prog(this.player, true, sid, msnToSendID);
/*     */             
/* 204 */             String seriesID = sid;
/* 205 */             JRMCoreMsnBundle M = (JRMCoreMsnBundle)JRMCoreM.missions.get(seriesID);
/* 206 */             if (M != null) {
/*     */               
/* 208 */               List<JRMCoreMsn> msnl = M.getMissions();
/*     */               
/* 210 */               String[] sydaV = JRMCoreM.getMda(msdV, seriesID);
/* 211 */               int rp = Integer.parseInt(JRMCoreM.getSydaV(sydaV, 2));
/* 212 */               rp = (rp > 0) ? (rp - 1) : rp;
/* 213 */               String cc = JRMCoreM.getSydaV(sydaV, 3);
/* 214 */               String ccv = JRMCoreM.getSydaV(sydaV, 4);
/* 215 */               msdV = JRMCoreM.setSydaV(msdV, seriesID, M.getVersion(), "" + rp, cc, ccv);
/*     */               
/* 217 */               if (rp >= 0) {
/*     */                 
/* 219 */                 boolean reset = false;
/* 220 */                 if (this.MRC) {
/*     */                   
/* 222 */                   sydaV = JRMCoreM.getMda(msdV, seriesID);
/* 223 */                   if (sydaV.length > 1)
/*     */                   {
/* 225 */                     reset = !M.getVersion().equalsIgnoreCase(sydaV[1]);
/*     */                   }
/* 227 */                   this.MRC = false;
/*     */                 } 
/* 229 */                 for (int j = 0; j < msnl.size(); j++) {
/*     */                   
/* 231 */                   JRMCoreMsn msn = msnl.get(j);
/* 232 */                   if (!reset || !JRMCoreM.resetMsnBndl(true, reset, msn, msnToSendID, pw, rc, cl, msd, msdV, msdO, msdVO, seriesID, nbt, M, this.player))
/*     */                   {
/* 234 */                     if (msn.getId() == msnToSendID) {
/*     */                       
/* 236 */                       ArrayList<String> o = msn.getObjectives(pw, rc, cl);
/* 237 */                       int size = o.size();
/* 238 */                       boolean comp = JRMCoreM.getMda_ObjComp_all(o, JRMCoreM.getMda(msd, seriesID), g);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */                       
/* 245 */                       ArrayList<Boolean> arl = Lists.newArrayList();
/* 246 */                       boolean kl = false;
/* 247 */                       for (int k = 0; k < o.size(); k++) {
/* 248 */                         String os = o.get(k);
/* 249 */                         if (os != null && os.length() > 2) {
/* 250 */                           String t = JRMCoreM.getMCo_type(os);
/* 251 */                           String d1 = JRMCoreM.getMCo_data(os, "N");
/* 252 */                           String dt = JRMCoreM.getMCo_data(os, "T");
/*     */                           
/* 254 */                           if (!comp && (t.equalsIgnoreCase("kill") || t.equalsIgnoreCase("killsame"))) {
/* 255 */                             int n = 128;
/* 256 */                             for (EntityPlayer player : ps)
/*     */                             {
/*     */                               
/* 259 */                               EntityPlayer p = player;
/* 260 */                               AxisAlignedBB aabb = AxisAlignedBB.func_72330_a(p.field_70165_t - n, 0.0D, p.field_70161_v - n, p.field_70165_t + n, 255.0D, p.field_70161_v + n);
/* 261 */                               if (EntityList.field_75625_b.get(d1) != null) {
/* 262 */                                 List l = p.field_70170_p.func_72872_a((Class)EntityList.field_75625_b.get(d1), aabb);
/* 263 */                                 boolean nokl = l.isEmpty();
/* 264 */                                 if (dt.length() > 1 && nokl) {
/* 265 */                                   String[] ar = JRMCoreM.getMCo_TranSplit(dt);
/* 266 */                                   for (int m = 0; m < ar.length; m++) {
/* 267 */                                     String[] aamt = ar[m].split("\\|");
/* 268 */                                     aabb = AxisAlignedBB.func_72330_a(p.field_70165_t - n, 0.0D, p.field_70161_v - n, p.field_70165_t + n, 255.0D, p.field_70161_v + n);
/* 269 */                                     if (EntityList.field_75625_b.get(aamt[0]) != null) {
/* 270 */                                       l = p.field_70170_p.func_72872_a((Class)EntityList.field_75625_b.get(aamt[0]), aabb);
/* 271 */                                       nokl = l.isEmpty();
/* 272 */                                       if (!nokl)
/*     */                                         break; 
/*     */                                     } 
/*     */                                   } 
/* 276 */                                 }  arl.add(Boolean.valueOf(nokl));
/*     */                               }
/*     */                             
/*     */                             }
/*     */                           
/* 281 */                           } else if (t.equalsIgnoreCase("biome") || t.equalsIgnoreCase("biome2")) {
/*     */                             
/* 283 */                             boolean b = false;
/* 284 */                             for (EntityPlayer player : ps) {
/*     */ 
/*     */ 
/*     */                               
/* 288 */                               b = (player.field_70170_p.func_72807_a((int)player.field_70165_t, (int)player.field_70161_v)).field_76791_y.equalsIgnoreCase(d1);
/* 289 */                               if (!b)
/*     */                                 break; 
/*     */                             } 
/* 292 */                             msd = JRMCoreM.setSyda(msd, seriesID, msnToSendID, size, k, b ? "1" : "0");
/*     */                           }
/* 294 */                           else if (t.equalsIgnoreCase("dim") || t.equalsIgnoreCase("dim2")) {
/*     */                             
/* 296 */                             boolean b = false;
/* 297 */                             for (EntityPlayer player : ps) {
/*     */ 
/*     */ 
/*     */                               
/* 301 */                               b = (player.field_70170_p.field_73011_w.func_80007_l().equalsIgnoreCase(d1) || (NumberUtils.isNumber(d1) && player.field_71093_bK == Integer.parseInt(d1)));
/* 302 */                               if (!b)
/*     */                                 break; 
/*     */                             } 
/* 305 */                             msd = JRMCoreM.setSyda(msd, seriesID, msnToSendID, size, k, b ? "1" : "0");
/*     */                           }
/* 307 */                           else if (t.equalsIgnoreCase("item")) {
/*     */                             
/* 309 */                             String[] d2 = d1.split("::");
/* 310 */                             Item im = JRMCoreH.getItemByText((d2.length > 1) ? d2[0] : d1);
/* 311 */                             if (im != null) {  } else {  }  ItemStack is = null;
/* 312 */                             String en = (is != null) ? is.func_77977_a() : "ERROR";
/*     */                             
/* 314 */                             int c = 0;
/* 315 */                             for (EntityPlayer player : ps) {
/*     */ 
/*     */                               
/* 318 */                               for (int l = 0; l < player.field_71071_by.field_70462_a.length; l++) {
/* 319 */                                 if (player.field_71071_by.field_70462_a[l] != null && player.field_71071_by.field_70462_a[l].func_77977_a().equalsIgnoreCase(en)) {
/* 320 */                                   c += (player.field_71071_by.field_70462_a[l]).field_77994_a;
/*     */                                 }
/*     */                               } 
/*     */                             } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */                             
/* 329 */                             msd = JRMCoreM.setSyda(msd, seriesID, msnToSendID, size, k, "" + c);
/*     */                           }
/* 331 */                           else if (t.equalsIgnoreCase("state")) {
/*     */                             
/* 333 */                             msd = JRMCoreM.setSyda(msd, seriesID, msnToSendID, size, k, JRMCoreH.TransNmsM[rc][st]);
/*     */                           }
/* 335 */                           else if (t.equalsIgnoreCase("lvl")) {
/*     */                             
/* 337 */                             int b = 0;
/* 338 */                             for (EntityPlayer player : ps) {
/*     */ 
/*     */                               
/* 341 */                               int[] PlyrAttrbts = JRMCoreH.PlyrAttrbts(player);
/* 342 */                               int a = JRMCoreH.getPlayerLevel(PlyrAttrbts);
/* 343 */                               b = (b == 0 || a < b) ? a : b;
/*     */                             } 
/*     */                             
/* 346 */                             msd = JRMCoreM.setSyda(msd, seriesID, msnToSendID, size, k, "" + b);
/*     */                           } 
/*     */                         } 
/*     */                       } 
/* 350 */                       if (!arl.isEmpty()) {
/*     */                         
/* 352 */                         boolean strt = true;
/* 353 */                         for (int l = 0; l < arl.size(); l++) {
/*     */                           
/* 355 */                           boolean b = ((Boolean)arl.get(l)).booleanValue();
/* 356 */                           if (!b) { strt = false; break; }
/*     */                         
/* 358 */                         }  if (strt)
/*     */                         {
/* 360 */                           msd = JRMCoreM.setSyda(msd, seriesID, msnToSendID, size, JRMCoreM.SYNC_COND_data_REV(2), "0");
/*     */                         }
/*     */                       } 
/*     */ 
/*     */ 
/*     */                       
/* 366 */                       if (!msdO.equalsIgnoreCase(msd))
/*     */                       {
/* 368 */                         nbt.func_74778_a("JRMCmissionSync", msd);
/*     */                       }
/*     */                       
/*     */                       break;
/*     */                     } 
/*     */                   }
/*     */                 } 
/* 375 */                 if (!msdVO.equalsIgnoreCase(msdV))
/*     */                 {
/* 377 */                   nbt.func_74778_a("JRMCmissionSyncVers", msdV);
/*     */                 }
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 390 */       if (JRMCoreH.DBC())
/*     */       {
/* 392 */         long worldTime = FMLCommonHandler.instance().getMinecraftServerInstance().func_71218_a(0).func_72820_D() % 24000L;
/* 393 */         if (worldTime == 1L) {
/*     */           
/* 395 */           JRMCoreH.setInt(0, this.player, "jrmcTPlimit");
/* 396 */           JRMCoreH.setInt(0, this.player, "jrmcTPlimit2");
/* 397 */           JRMCoreH.setInt(0, this.player, "DBCSenzu");
/* 398 */           byte tm = JRMCoreH.getByte(this.player, "jrmcTlmd");
/* 399 */           if (tm == 4) {
/*     */             
/* 401 */             Random ran = new Random();
/* 402 */             int r = ran.nextInt(3);
/* 403 */             if (r == 0)
/*     */             {
/* 405 */               JRMCoreH.setByte((byte)0, this.player, "jrmcTlmd");
/*     */             }
/*     */           } 
/*     */         } 
/*     */ 
/*     */         
/* 411 */         if (this.player.field_70170_p.func_147439_a((int)this.player.field_70165_t, (int)this.player.field_70163_u, (int)this.player.field_70161_v) == JRMCoreHDBC.getMedBlock())
/*     */         {
/*     */ 
/*     */           
/* 415 */           if (JRMCoreH.updateEveryXTick(this.player.field_70173_aa, JRMCoreHDBC.DBCgetConfighPodUpd())) {
/*     */             
/* 417 */             int[] PlyrAttrbts = JRMCoreH.PlyrAttrbts(this.player);
/* 418 */             this.player.func_70050_g(300);
/*     */             
/* 420 */             byte pwr = JRMCoreH.getByte(this.player, "jrmcPwrtyp");
/* 421 */             byte rc = JRMCoreH.getByte(this.player, "jrmcRace");
/* 422 */             byte cls = JRMCoreH.getByte(this.player, "jrmcClass");
/* 423 */             int maxBody = JRMCoreH.stat((Entity)this.player, 2, pwr, 2, PlyrAttrbts[2], rc, cls, 0.0F);
/* 424 */             int curBody = JRMCoreH.getInt(this.player, "jrmcBdy");
/* 425 */             int maxEnergy = JRMCoreH.stat((Entity)this.player, 5, pwr, 5, PlyrAttrbts[5], rc, cls, JRMCoreH.SklLvl_KiBs(this.player, pwr));
/* 426 */             int curEnergy = JRMCoreH.getInt(this.player, "jrmcEnrgy");
/* 427 */             int maxStam = JRMCoreH.stat((Entity)this.player, 2, pwr, 3, PlyrAttrbts[2], rc, cls, 0.0F);
/* 428 */             int curStam = JRMCoreH.getInt(this.player, "jrmcStamina");
/*     */             
/* 430 */             float damage = 20.0F - this.player.func_110143_aJ();
/*     */             
/* 432 */             if (curBody - damage > 0.0F)
/*     */             {
/* 434 */               this.player.func_70606_j(this.player.func_110143_aJ() + damage);
/*     */             }
/*     */             
/* 437 */             if (curBody < maxBody) {
/*     */               float body;
/*     */               
/* 440 */               if (JRMCoreHDBC.DBCgetConfighPodPerc(0)) {
/*     */                 
/* 442 */                 body = curBody + JRMCoreHDBC.DBCgetConfighPodRate(0) / 100.0F * maxBody;
/*     */               } else {
/* 444 */                 body = (curBody + JRMCoreHDBC.DBCgetConfighPodRate(0) * 3);
/*     */               } 
/* 446 */               JRMCoreH.setInt((body > maxBody) ? maxBody : body, this.player, "jrmcBdy");
/*     */             } 
/*     */             
/* 449 */             if (curEnergy < maxEnergy) {
/*     */               float energy;
/*     */               
/* 452 */               if (JRMCoreHDBC.DBCgetConfighPodPerc(1)) {
/*     */                 
/* 454 */                 energy = curEnergy + JRMCoreHDBC.DBCgetConfighPodRate(1) / 100.0F * maxEnergy;
/*     */               } else {
/* 456 */                 energy = (curEnergy + JRMCoreHDBC.DBCgetConfighPodRate(1) * 3);
/*     */               } 
/* 458 */               JRMCoreH.setInt((energy > maxEnergy) ? maxEnergy : energy, this.player, "jrmcEnrgy");
/*     */             } 
/*     */             
/* 461 */             if (curStam < maxStam) {
/*     */               float stam;
/*     */               
/* 464 */               if (JRMCoreHDBC.DBCgetConfighPodPerc(2)) {
/*     */                 
/* 466 */                 stam = curStam + JRMCoreHDBC.DBCgetConfighPodRate(2) / 100.0F * maxStam;
/*     */               } else {
/* 468 */                 stam = (curStam + JRMCoreHDBC.DBCgetConfighPodRate(2) * 3);
/*     */               } 
/* 470 */               JRMCoreH.setInt((stam > maxStam) ? maxStam : stam, this.player, "jrmcStamina");
/*     */             } 
/*     */             
/* 473 */             if (this.player.func_71024_bL().func_75121_c()) {
/* 474 */               this.player.func_71024_bL().func_75122_a(1, 0.5F);
/*     */             }
/*     */           } 
/*     */         }
/*     */         
/* 479 */         if (this.player.field_71093_bK == 0) JRMCoreHDBC.DBSpawn(this.player, worldTime); 
/* 480 */         if (this.player.field_71093_bK == 20) JRMCoreHDBC.DBSpawn(this.player, worldTime);
/*     */         
/* 482 */         if (JRMCoreH.updateEveryXTick(this.player.field_70173_aa, JRMCoreConfig.plUpd))
/*     */         {
/* 484 */           if (this.player.field_71093_bK == 0)
/*     */           {
/* 486 */             if (this.player.field_70170_p.func_147439_a((int)this.player.field_70165_t, (int)this.player.field_70163_u, (int)this.player.field_70161_v) != JRMCoreHDBC.DBCgetBlockTCPort())
/*     */             {
/* 488 */               short s1 = (short)JRMCoreH.getByte(this.player, "jrmcMsg");
/* 489 */               if (s1 != 0)
/*     */               {
/* 491 */                 JRMCoreH.setByte(0, this.player, "jrmcMsg");
/*     */               
/*     */               }
/*     */             
/*     */             }
/*     */ 
/*     */           
/*     */           }
/*     */         
/*     */         }
/*     */       }
/*     */     
/*     */     }
/* 504 */     else if (JRMCoreH.DBC()) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 510 */       if (getAnimKiShoot() != 0) {
/*     */ 
/*     */         
/* 513 */         if (getAnimKiShotNow() == 0)
/*     */         {
/* 515 */           if (this.player != null && getAnimKiShoot() != 0 && JGConfigClientSettings.CLIENT_DA10) {
/*     */             
/* 517 */             boolean spawn = true;
/* 518 */             List<Entity> list = checkForEntitiesInside();
/*     */             
/* 520 */             for (int id = 0; id < list.size(); id++) {
/*     */               
/* 522 */               Entity entity = list.get(id);
/* 523 */               if (entity instanceof EntityEng && ((EntityEng)entity).user == this.player)
/*     */               {
/* 525 */                 spawn = false;
/*     */               }
/*     */             } 
/* 528 */             if (spawn) {
/*     */ 
/*     */ 
/*     */               
/* 532 */               EntityEng kiCharge = new EntityEng(this.player.field_70170_p, this.player.field_70165_t, this.player.field_70163_u, this.player.field_70161_v, this.player.func_70005_c_(), getAnimKiShoot(), getKiShotCol(), getKiShotSiz(), getKiShotPart());
/* 533 */               kiCharge.destroyer = (getGoDOn() == 1);
/*     */               
/* 535 */               this.player.field_70170_p.func_72838_d((Entity)kiCharge);
/*     */             } 
/*     */           } 
/*     */         }
/* 539 */         setAnimKiShotNow(1);
/*     */       } else {
/* 541 */         setAnimKiShotNow(0);
/*     */       } 
/*     */     } 
/*     */     
/* 545 */     if (getEffect_used() > 0)
/*     */     {
/* 547 */       setEffect_used(getEffect_used() + 1);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private List checkForEntitiesInside() {
/* 555 */     AxisAlignedBB aabb = this.player.field_70121_D.func_72329_c();
/* 556 */     List list = this.player.field_70170_p.func_72839_b((Entity)this.player, aabb);
/* 557 */     return list;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getBlocking()
/*     */   {
/* 568 */     return this.player.func_70096_w().func_75679_c(JRMCoreConfig.ExtendedPlayerBlockID); } public final String getHairCode() {
/* 569 */     return this.player.func_70096_w().func_75681_e(JRMCoreConfig.ExtendedPlayerHairID);
/*     */   }
/* 571 */   public final int getAnimKiShotNow() { String data = getOtherCode(0); return Integer.parseInt(data); }
/* 572 */   public final int getKiShotCol() { String data = getOtherCode(1); return Integer.parseInt(data); }
/* 573 */   public final float getKiShotSiz() { String data = getOtherCode(2); return Float.parseFloat(data); }
/* 574 */   public final int getKiShotPart() { String data = getOtherCode(3); return Integer.parseInt(data); }
/* 575 */   public final int getHandEffect() { String data = getOtherCode(4); return Integer.parseInt(data); }
/* 576 */   public final int getEffect_used() { String data = getOtherCode(5); return Integer.parseInt(data); }
/* 577 */   public final int getEffect_used2() { String data = getOtherCode(6); return Integer.parseInt(data); }
/* 578 */   public final int getUIAnim() { String data = getOtherCode(7); return Integer.parseInt(data); }
/* 579 */   public final int getUIAnimID() { String data = getOtherCode(9); return Integer.parseInt(data); }
/* 580 */   public final int getAnimKiShoot() { String data = getOtherCode(8); return Integer.parseInt(data); }
/* 581 */   public final int getAnimKiShootOn() { String data = getOtherCode(10); return Integer.parseInt(data); } public final int getGoDOn() {
/* 582 */     String data = getOtherCode(11); return Integer.parseInt(data);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOtherCode(int id) {
/*     */     String data;
/* 589 */     if ((this.player.func_70096_w().func_75681_e(JRMCoreConfig.ExtendedPlayerOtherID).split(";")).length == 12) {
/*     */       
/* 591 */       data = this.player.func_70096_w().func_75681_e(JRMCoreConfig.ExtendedPlayerOtherID).split(";")[id];
/*     */     } else {
/* 593 */       data = "0;0;0f;0;0;0;0;0;0;0;0;0;".split(";")[id];
/* 594 */     }  return data;
/*     */   }
/*     */   
/* 597 */   public final void setBlocking(int amount) { this.player.func_70096_w().func_75692_b(JRMCoreConfig.ExtendedPlayerBlockID, Integer.valueOf(amount)); } public final void setHairCode(String v) {
/* 598 */     this.player.func_70096_w().func_75692_b(JRMCoreConfig.ExtendedPlayerHairID, v);
/*     */   }
/* 600 */   public final void setAnimKiShotNow(int v) { setID(0, v); }
/* 601 */   public final void setKiShotCol(int v) { setID(1, v); }
/* 602 */   public final void setKiShotSiz(float v) { setIDf(2, v); }
/* 603 */   public final void setKiShotPart(int v) { setID(3, v); }
/* 604 */   public final void setHandEffect(int v) { setID(4, v); }
/* 605 */   public final void setEffect_used(int v) { setID(5, v); }
/* 606 */   public final void setEffect_used2(int v) { setID(6, v); }
/* 607 */   public final void setUIAnim(int v) { setID(7, v); }
/* 608 */   public final void setUIAnimID(int v) { setID(9, v); }
/* 609 */   public final void setAnimKiShoot(int v) { setID(8, v); }
/* 610 */   public final void setAnimKiShootOn(int v) { setID(10, v); } public final void setGoDOn(int v) {
/* 611 */     setID(11, v);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void setID(int id, int v) {
/* 617 */     String data = "";
/* 618 */     for (int i = 0; i < 12; i++) {
/*     */       
/* 620 */       String dat = this.player.func_70096_w().func_75681_e(JRMCoreConfig.ExtendedPlayerOtherID).split(";")[i];
/* 621 */       if (i == id) {
/*     */         
/* 623 */         if (i == 2) {
/*     */           
/* 625 */           data = data + v;
/* 626 */           data = data + "f";
/*     */         } else {
/* 628 */           data = data + v;
/*     */         }
/*     */       
/* 631 */       } else if (i == 2) {
/*     */         
/* 633 */         data = data + dat;
/*     */       } else {
/* 635 */         data = data + dat;
/*     */       } 
/* 637 */       data = data + ";";
/*     */     } 
/* 639 */     this.player.func_70096_w().func_75692_b(JRMCoreConfig.ExtendedPlayerOtherID, data);
/*     */   }
/*     */ 
/*     */   
/*     */   private void setIDf(int id, float v) {
/* 644 */     String data = "";
/* 645 */     for (int i = 0; i < 12; i++) {
/*     */       
/* 647 */       String dat = this.player.func_70096_w().func_75681_e(JRMCoreConfig.ExtendedPlayerOtherID).split(";")[i];
/* 648 */       if (i == id) {
/*     */         
/* 650 */         if (i == 2) {
/*     */           
/* 652 */           data = data + v;
/* 653 */           data = data + "f";
/*     */         } else {
/* 655 */           data = data + v;
/*     */         }
/*     */       
/* 658 */       } else if (i == 2) {
/*     */         
/* 660 */         data = data + dat;
/*     */       } else {
/* 662 */         data = data + dat;
/*     */       } 
/* 664 */       data = data + ";";
/*     */     } 
/* 666 */     this.player.func_70096_w().func_75692_b(JRMCoreConfig.ExtendedPlayerOtherID, data);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\i\ExtendedPlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */