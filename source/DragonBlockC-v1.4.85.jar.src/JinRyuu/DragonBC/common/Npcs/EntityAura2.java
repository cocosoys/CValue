/*      */ package JinRyuu.DragonBC.common.Npcs;
/*      */ import JinRyuu.JRMCore.client.config.jrmc.JGConfigClientSettings;
/*      */ import JinRyuu.JRMCore.entity.EntityCusPar;
/*      */ import cpw.mods.fml.relauncher.Side;
/*      */ import cpw.mods.fml.relauncher.SideOnly;
/*      */ import net.minecraft.entity.Entity;
/*      */ import net.minecraft.entity.player.EntityPlayer;
/*      */ import net.minecraft.nbt.NBTTagCompound;
/*      */ import net.minecraft.world.World;
/*      */ 
/*      */ @SideOnly(Side.CLIENT)
/*      */ public class EntityAura2 extends Entity {
/*      */   public static final int NORMAL = -1;
/*      */   public static final int SSJ_GOD = 0;
/*      */   public static final int SSJ_BLUE = 1;
/*      */   public static final int SSJ_BLUE_EVO = 2;
/*      */   public static final int SSJ_ROSE = 3;
/*      */   public static final int GOLDEN = 4;
/*      */   public static final int SSJ_ROSE_SHINKA = 5;
/*      */   public static final int GOD_OF_DESTRUCTION = 6;
/*   21 */   public final int number_of_lightVerts = 10;
/*   22 */   public long[] lightVert = new long[10]; private int lightLivingTime; public int rm;
/*      */   
/*      */   public int getLightLivingTime() {
/*   25 */     return this.lightLivingTime;
/*      */   }
/*   27 */   private String mot = ""; private boolean rot = false; private int Age; private int color; private int colorl2; private int colorl3; private float state; private float state2; private int crel; private float yaw; private float pitch; private float alpha; private String tex; private String texl2; private String texl3; private int speed; private boolean inner; private int rendpass; private boolean bol; private boolean bol2; private boolean bol3; private boolean bol4; private boolean bol4a; private byte bol6;
/*      */   private boolean bol7;
/*      */   public byte kettleMode;
/*      */   
/*   31 */   public EntityAura2(World par1World) { super(par1World);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*   77 */     this.color = 16777215;
/*   78 */     this.colorl2 = 16777215;
/*   79 */     this.colorl3 = -1;
/*   80 */     this.state = 0.0F;
/*   81 */     this.state2 = 0.0F;
/*   82 */     this.crel = 0;
/*   83 */     this.yaw = 0.0F;
/*   84 */     this.pitch = 0.0F;
/*   85 */     this.alpha = 0.1F;
/*   86 */     this.tex = "aura";
/*   87 */     this.texl2 = "";
/*   88 */     this.texl3 = "";
/*   89 */     this.speed = 20;
/*   90 */     this.inner = true;
/*   91 */     this.rendpass = 1;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  137 */     this.bol = false;
/*  138 */     this.bol2 = false;
/*  139 */     this.bol3 = false;
/*  140 */     this.bol4 = false;
/*  141 */     this.bol4a = false;
/*      */ 
/*      */     
/*  144 */     this.bol6 = -1;
/*  145 */     this.bol7 = false;
/*      */ 
/*      */     
/*  148 */     this.kettleMode = 0; } public EntityAura2(World par1World, String dbcCharger, int c, float s, float s2, int cr, boolean b, float a) { this(par1World, dbcCharger, c, s, s2, cr, b); this.alpha = a; } public EntityAura2(World par1World, String dbcCharger, int c, float s, float s2, int cr, boolean b) { this(par1World, dbcCharger, c, s, s2, cr); this.rot = b; } public EntityAura2(World par1World, String dbcCharger, int c, float s, float s2, int cr) { super(par1World); this.color = 16777215; this.colorl2 = 16777215; this.colorl3 = -1; this.state = 0.0F; this.state2 = 0.0F; this.crel = 0; this.yaw = 0.0F; this.pitch = 0.0F; this.alpha = 0.1F; this.tex = "aura"; this.texl2 = ""; this.texl3 = ""; this.speed = 20; this.inner = true; this.rendpass = 1; this.bol = false; this.bol2 = false; this.bol3 = false; this.bol4 = false; this.bol4a = false; this.bol6 = -1; this.bol7 = false; this.kettleMode = 0; this.mot = dbcCharger; this.color = c; this.state = s; this.state2 = s2; this.crel = cr; this.rm = this.field_70146_Z.nextInt(10); int i = 0; getClass(); while (i < 10) { this.lightVert[i] = this.field_70146_Z.nextLong(); i++; }  this.lightLivingTime = this.field_70146_Z.nextInt(4) + 0; if (this.mot.length() > 1) { EntityPlayer entityPlayer = this.field_70170_p.func_72924_a(this.mot); if (entityPlayer != null) { if (this.rot) { this.yaw = ((Entity)entityPlayer).field_70177_z; this.pitch = ((Entity)entityPlayer).field_70125_A; }  func_70080_a(((Entity)entityPlayer).field_70165_t, ((Entity)entityPlayer).field_70163_u + ((entityPlayer instanceof net.minecraft.client.entity.EntityPlayerSP) ? -1.6F : 0.0F), ((Entity)entityPlayer).field_70161_v, ((Entity)entityPlayer).field_70177_z, ((Entity)entityPlayer).field_70125_A); }  }  }
/*      */   public boolean shouldRenderInPass(int pass) { return (pass == this.rendpass); }
/*      */   @SideOnly(Side.CLIENT) public float func_70053_R() { return 0.0F; }
/*      */   public boolean getRot() { return this.rot; }
/*  152 */   public float getYaw() { return this.yaw; } public float getPitch() { return this.pitch; } public int getAge() { return this.Age; } public float getState() { return this.state; } public float getState2() { return this.state2; } public float getCRel() { return this.crel; } public int getCol() { return this.color; } public void setCol(int c) { this.color = c; } public int getColL2() { return this.colorl2; } public void setColL2(int c) { this.colorl2 = c; } public int getColL3() { return this.colorl3; } public void setColL3(int c) { this.colorl3 = c; } public float getAlp() { return this.alpha; } public void setAlp(float f) { this.alpha = f; } public String getTex() { return this.tex; } public void setTex(String s) { this.tex = s; } public String getTexL2() { return this.texl2; } public void setTexL2(String s) { this.texl2 = s; } public void func_70071_h_() { boolean aura_type = JGConfigClientSettings.CLIENT_DA13;
/*  153 */     boolean aura_type2 = JGConfigClientSettings.CLIENT_DA20;
/*  154 */     if (this.mot.length() > 1) {
/*  155 */       EntityPlayer entityPlayer = this.field_70170_p.func_72924_a(this.mot);
/*      */       
/*  157 */       if (entityPlayer != null) {
/*      */ 
/*      */         
/*  160 */         int sneak = entityPlayer.func_70093_af() ? 0 : 1;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  165 */         if (this.kettleMode > 0) {
/*  166 */           for (int k = 0; k < JGConfigClientSettings.get_da1(); k++) {
/*  167 */             if (this.field_70173_aa < 15) {
/*      */               
/*  169 */               EntityPlayer entityPlayer1 = entityPlayer;
/*      */               
/*  171 */               double posXOth = ((Entity)entityPlayer1).field_70165_t;
/*  172 */               double posYOth = ((Entity)entityPlayer1).field_70163_u + ((entityPlayer instanceof net.minecraft.client.entity.EntityPlayerSP) ? -1.6F : 0.0F);
/*  173 */               double posZOth = ((Entity)entityPlayer1).field_70161_v;
/*      */               
/*  175 */               float red = 250.0F, green = 250.0F, blue = 250.0F;
/*      */               
/*  177 */               float out = 0.9F;
/*  178 */               float life = 0.8F * ((Entity)entityPlayer).field_70131_O;
/*  179 */               float extra_scale = 1.2F;
/*  180 */               int dea = 50;
/*  181 */               float outNew = 0.9F;
/*  182 */               float alpha = 1.0F;
/*  183 */               float speed = 1.2F;
/*      */ 
/*      */               
/*  186 */               outNew = 0.99F;
/*      */               
/*  188 */               double y = (((Entity)entityPlayer).field_70131_O * 0.8F);
/*  189 */               double x = Math.random() * outNew - (outNew / 2.0F);
/*  190 */               double z = Math.random() * outNew - (outNew / 2.0F);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*  198 */               EntityCusPar entityCusPar = new EntityCusPar("jinryuumodscore:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, Math.random() * 0.30000001192092896D - 0.15000000596046448D, 0.25D + Math.random() * 0.125D * speed, Math.random() * 0.30000001192092896D - 0.15000000596046448D, -0.02F * speed, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, 0.05F + ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 1.2F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 1.2F / 2.0F, 0.3F * life * 1.2F, 0, red, green, blue, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.1F, 0.0F, 0.4F * alpha, 0.45F * alpha, 0.02F * alpha, false, -1, false, null);
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*  203 */               ((Entity)entityCusPar).field_70170_p.func_72838_d((Entity)entityCusPar);
/*      */             } 
/*      */           } 
/*      */         }
/*      */ 
/*      */         
/*  209 */         if (this.kettleMode != 1 && 
/*  210 */           aura_type) {
/*  211 */           for (int k = 0; k < JGConfigClientSettings.get_da1(); k++) {
/*  212 */             for (int i = 0; i < (int)((Entity)entityPlayer).field_70131_O / 2.0F + 1.0F; i++) {
/*  213 */               if (this.field_70173_aa < 5) {
/*      */                 
/*  215 */                 EntityPlayer entityPlayer1 = entityPlayer;
/*      */                 
/*  217 */                 double posXOth = ((Entity)entityPlayer1).field_70165_t;
/*  218 */                 double posYOth = ((Entity)entityPlayer1).field_70163_u + ((entityPlayer instanceof net.minecraft.client.entity.EntityPlayerSP) ? -1.6F : 0.0F);
/*  219 */                 double posZOth = ((Entity)entityPlayer1).field_70161_v;
/*      */ 
/*      */                 
/*  222 */                 if (this.bol4) {
/*      */                   float red, green, blue, red2, green2, blue2, red3, green3, blue3;
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/*  228 */                   if (this.bol4a) {
/*      */                     
/*  230 */                     red = 87.0F; green = 200.0F; blue = 208.0F;
/*  231 */                     red2 = 203.0F; green2 = 137.0F; blue2 = 234.0F;
/*  232 */                     red3 = 245.0F; green3 = 250.0F; blue3 = 252.0F;
/*      */                   }
/*      */                   else {
/*      */                     
/*  236 */                     red = 141.0F; green = 158.0F; blue = 210.0F;
/*  237 */                     red2 = 215.0F; green2 = 152.0F; blue2 = 219.0F;
/*  238 */                     red3 = 243.0F; green3 = 247.0F; blue3 = 250.0F;
/*      */                   } 
/*      */                   
/*  241 */                   float out = 1.6F, in = 1.5F;
/*  242 */                   float life = 0.8F * ((Entity)entityPlayer).field_70131_O;
/*  243 */                   float extra_scale = 0.5F;
/*  244 */                   int dea = 50;
/*  245 */                   float outNew = 1.6F;
/*  246 */                   float target_fullsize_one1 = 0.32F;
/*  247 */                   float targetsizeMin = ((Entity)entityPlayer).field_70131_O * 8.0F / target_fullsize_one1 * 0.01F;
/*      */                   
/*  249 */                   float target_fullsize_one2 = 0.32F;
/*  250 */                   float targetsizeMax = ((Entity)entityPlayer).field_70131_O * 26.0F / target_fullsize_one2 * 0.01F;
/*      */ 
/*      */ 
/*      */                   
/*  254 */                   float alpha = 0.7F;
/*      */ 
/*      */                   
/*      */                   int repeat2;
/*      */                   
/*  259 */                   for (repeat2 = 0; repeat2 < 4; repeat2++) {
/*      */                     
/*  261 */                     outNew = 1.7600001F;
/*  262 */                     double y = (Math.random() * ((Entity)entityPlayer).field_70131_O - 0.5D) * 0.800000011920929D;
/*  263 */                     double x = Math.random() * outNew - (outNew / 2.0F);
/*  264 */                     double z = Math.random() * outNew - (outNew / 2.0F);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                     
/*  272 */                     EntityCusPar entityCusPar = new EntityCusPar("jinryuumodscore:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 150.0F, 186.0F, 255.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.3F * alpha, 0.35F * alpha, 0.01F * alpha, false, -1, true, (Entity)entityPlayer1);
/*      */ 
/*      */ 
/*      */                     
/*  276 */                     ((Entity)entityCusPar).field_70170_p.func_72838_d((Entity)entityCusPar);
/*      */                   } 
/*      */                   
/*  279 */                   for (repeat2 = 0; repeat2 < 4; repeat2++) {
/*      */                     
/*  281 */                     outNew = 1.7600001F;
/*  282 */                     double y = (Math.random() * ((Entity)entityPlayer).field_70131_O - 0.5D) * 0.800000011920929D;
/*  283 */                     double x = Math.random() * outNew - (outNew / 2.0F);
/*  284 */                     double z = Math.random() * outNew - (outNew / 2.0F);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                     
/*  292 */                     EntityCusPar entityCusPar = new EntityCusPar("jinryuumodscore:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, red, green, blue, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.3F * alpha, 0.35F * alpha, 0.01F * alpha, false, -1, true, (Entity)entityPlayer1);
/*      */ 
/*      */ 
/*      */                     
/*  296 */                     ((Entity)entityCusPar).field_70170_p.func_72838_d((Entity)entityCusPar);
/*      */                   } 
/*      */                   
/*  299 */                   if (this.field_70173_aa % 4 == 0) {
/*      */                     
/*  301 */                     double x = Math.random() * outNew - (outNew / 2.0F);
/*  302 */                     double y = Math.random() * ((Entity)entityPlayer).field_70131_O - 0.5D;
/*  303 */                     double z = Math.random() * outNew - (outNew / 2.0F);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                     
/*  311 */                     EntityCusPar entityCusPar = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F * 0.5F, 0.2F * life * 0.5F * 0.5F, 0, red, green, blue, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F * alpha, 0.45F * alpha, 0.015F * alpha, false, -1, true, (Entity)entityPlayer1);
/*      */ 
/*      */ 
/*      */                     
/*  315 */                     ((Entity)entityCusPar).field_70170_p.func_72838_d((Entity)entityCusPar);
/*      */                   } 
/*      */ 
/*      */ 
/*      */                   
/*  320 */                   if (this.bol4) {
/*      */                     
/*  322 */                     if (this.bol4a) {
/*      */                       
/*  324 */                       outNew = 1.8000001F;
/*  325 */                       double y = (Math.random() * ((Entity)entityPlayer).field_70131_O - 0.5D) * 0.800000011920929D;
/*  326 */                       double x = Math.random() * outNew - (outNew / 2.0F);
/*  327 */                       double z = Math.random() * outNew - (outNew / 2.0F);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                       
/*  335 */                       EntityCusPar entityCusPar = new EntityCusPar("jinryuumodscore:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, red2, green2, blue2, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F * alpha, 0.45F * alpha, 0.015F * alpha, false, -1, true, (Entity)entityPlayer1);
/*      */ 
/*      */ 
/*      */                       
/*  339 */                       ((Entity)entityCusPar).field_70170_p.func_72838_d((Entity)entityCusPar);
/*      */ 
/*      */ 
/*      */                       
/*  343 */                       for (int j = 0; j < 1 + (this.bol4a ? 1 : 0); j++) {
/*      */                         
/*  345 */                         y = Math.random() * (targetsizeMax - targetsizeMin) + targetsizeMin;
/*  346 */                         y -= 0.30000001192092896D;
/*  347 */                         outNew = 1.9499999F;
/*  348 */                         x = Math.random() * outNew - (outNew / 2.0F);
/*  349 */                         z = Math.random() * outNew - (outNew / 2.0F);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                         
/*  357 */                         EntityCusPar entityCusPar1 = new EntityCusPar("jinryuumodscore:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, red2, green2, blue2, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F * alpha, 0.45F * alpha, 0.015F * alpha, false, -1, true, (Entity)entityPlayer1);
/*      */ 
/*      */ 
/*      */                         
/*  361 */                         ((Entity)entityCusPar1).field_70170_p.func_72838_d((Entity)entityCusPar1);
/*      */                       } 
/*      */                     } 
/*      */ 
/*      */ 
/*      */                     
/*  367 */                     if (this.field_70173_aa % (this.bol4a ? 1 : 4) == 0) {
/*      */                       
/*  369 */                       double x = Math.random() * 1.5D - 0.75D;
/*  370 */                       double y = (Math.random() * ((Entity)entityPlayer).field_70131_O - 0.5D) * 0.800000011920929D;
/*  371 */                       double z = Math.random() * 1.5D - 0.75D;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                       
/*  379 */                       EntityCusPar entityCusPar = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.019999999552965164D) + 0.02F) * life * 0.5F * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F * 0.5F, 0.2F * life * 0.5F * 0.5F, 0, red2, green2, blue2, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F * (this.bol4a ? 1.2F : 1.0F) * alpha, 0.45F * (this.bol4a ? 1.2F : 1.0F) * alpha, 0.015F * (this.bol4a ? 1.2F : 1.0F) * alpha, false, -1, true, (Entity)entityPlayer1);
/*      */ 
/*      */ 
/*      */                       
/*  383 */                       ((Entity)entityCusPar).field_70170_p.func_72838_d((Entity)entityCusPar);
/*      */                     } 
/*      */                   } 
/*      */ 
/*      */                   
/*  388 */                   float in2 = 0.6F;
/*      */                   
/*  390 */                   for (int repeat = 0; repeat < 3; repeat++) {
/*      */                     
/*  392 */                     outNew = 0.6F;
/*  393 */                     double x = Math.random() * outNew - (outNew / 2.0F);
/*  394 */                     double y = (Math.random() * ((Entity)entityPlayer).field_70131_O - 0.5D) * 0.800000011920929D * 0.6000000238418579D - 0.30000001192092896D;
/*  395 */                     double z = Math.random() * outNew - (outNew / 2.0F);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                     
/*  403 */                     EntityCusPar entityCusPar = new EntityCusPar("jinryuumodscore:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.03999999910593033D + 0.01D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 243.0F, 247.0F, 250.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.2F * alpha, 0.25F * alpha, 0.005F * alpha, false, -1, true, (Entity)entityPlayer1);
/*      */ 
/*      */ 
/*      */                     
/*  407 */                     ((Entity)entityCusPar).field_70170_p.func_72838_d((Entity)entityCusPar);
/*      */                     
/*  409 */                     for (int j = 0; j < 2; j++) {
/*      */                       
/*  411 */                       y = Math.random() * (targetsizeMax - targetsizeMin) + targetsizeMin;
/*  412 */                       y -= 0.30000001192092896D;
/*      */                       
/*  414 */                       outNew = 1.26F;
/*  415 */                       x = Math.random() * outNew - (outNew / 2.0F);
/*  416 */                       z = Math.random() * outNew - (outNew / 2.0F);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                       
/*  428 */                       EntityCusPar entityCusPar1 = new EntityCusPar("jinryuumodscore:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.03999999910593033D + 0.01D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 32, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, red3, green3, blue3, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.3F * alpha, 0.35F * alpha, 0.02F * alpha, false, -1, true, (Entity)entityPlayer1);
/*      */ 
/*      */ 
/*      */                       
/*  432 */                       ((Entity)entityCusPar1).field_70170_p.func_72838_d((Entity)entityCusPar1);
/*      */                     } 
/*      */                   } 
/*      */                   
/*  436 */                   if (this.field_70173_aa % 4 == 0)
/*      */                   {
/*  438 */                     double x = Math.random() * 0.6000000238418579D - 0.30000001192092896D;
/*  439 */                     double y = (Math.random() * ((Entity)entityPlayer).field_70131_O - 0.5D) * 0.800000011920929D;
/*  440 */                     double z = Math.random() * 0.6000000238418579D - 0.30000001192092896D;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                     
/*  448 */                     EntityCusPar entityCusPar1 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.029999999329447746D + 0.01D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F * 0.5F, 0.2F * life * 0.5F * 0.5F, 0, red3, green3, blue3, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F * alpha, 0.45F * alpha, 0.015F * alpha, false, -1, true, (Entity)entityPlayer1);
/*      */ 
/*      */ 
/*      */                     
/*  452 */                     ((Entity)entityCusPar1).field_70170_p.func_72838_d((Entity)entityCusPar1);
/*      */ 
/*      */ 
/*      */                     
/*  456 */                     y = Math.random() * (targetsizeMax - targetsizeMin) + targetsizeMin;
/*  457 */                     y -= 0.30000001192092896D;
/*      */                     
/*  459 */                     outNew = 1.26F;
/*  460 */                     x = Math.random() * outNew - (outNew / 2.0F);
/*  461 */                     z = Math.random() * outNew - (outNew / 2.0F);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                     
/*  469 */                     EntityCusPar entityCusPar2 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.029999999329447746D + 0.01D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.019999999552965164D) + 0.02F) * life * 0.5F * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F * 0.5F, 0.2F * life * 0.5F * 0.5F, 0, red3, green3, blue3, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F * alpha, 0.45F * alpha, 0.015F * alpha, false, -1, true, (Entity)entityPlayer1);
/*      */ 
/*      */ 
/*      */                     
/*  473 */                     ((Entity)entityCusPar2).field_70170_p.func_72838_d((Entity)entityCusPar2);
/*      */ 
/*      */ 
/*      */                   
/*      */                   }
/*      */ 
/*      */ 
/*      */                 
/*      */                 }
/*  482 */                 else if (this.bol6 == -1 && !aura_type2) {
/*      */                   
/*  484 */                   float a = this.alpha, h1 = 1.0F;
/*  485 */                   float h2 = (this.color >> 16 & 0xFF) / 255.0F;
/*  486 */                   float h3 = (this.color >> 8 & 0xFF) / 255.0F;
/*  487 */                   float h4 = (this.color & 0xFF) / 255.0F;
/*      */                   
/*  489 */                   float red = h1 * h2, green = h1 * h3, blue = h1 * h4;
/*  490 */                   if (red > 1.0F) red = 1.0F; 
/*  491 */                   if (green > 1.0F) green = 1.0F; 
/*  492 */                   if (blue > 1.0F) blue = 1.0F;
/*      */                   
/*  494 */                   for (int gh = 0; gh < 3; gh++) {
/*  495 */                     float life = 0.8F * ((Entity)entityPlayer1).field_70131_O;
/*  496 */                     float extra_scale = 1.0F + ((((Entity)entityPlayer1).field_70131_O > 2.1F) ? (((Entity)entityPlayer1).field_70131_O / 2.0F) : 0.0F) / 5.0F;
/*  497 */                     float width = ((Entity)entityPlayer1).field_70130_N * 3.0F;
/*      */ 
/*      */ 
/*      */                     
/*  501 */                     double x = (Math.random() * 1.0D - 0.5D) * (width * 1.3F);
/*  502 */                     double y = Math.random() * (((Entity)entityPlayer).field_70131_O * 1.4F) - (((Entity)entityPlayer).field_70131_O / 2.0F) - 0.30000001192092896D;
/*  503 */                     double z = (Math.random() * 1.0D - 0.5D) * (width * 1.3F);
/*      */ 
/*      */ 
/*      */                     
/*  507 */                     double motx = Math.random() * 0.019999999552965164D - 0.009999999776482582D;
/*  508 */                     double moty = (Math.random() * 0.8999999761581421D + 0.8999999761581421D) * (life * extra_scale) * 0.07D;
/*  509 */                     double motz = Math.random() * 0.019999999552965164D - 0.009999999776482582D;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                     
/*  519 */                     EntityCusPar entityCusPar2 = new EntityCusPar("jinryuumodscore:bens_particles.png", ((Entity)entityPlayer1).field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, motx, moty, motz, 0.0F, (int)(Math.random() * 3.0D) + 32, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", (int)(30.0F * life * 0.5F), 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * extra_scale, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * extra_scale, 0.2F * life * extra_scale, 0, red, green, blue, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.08F, false, -1, true, (Entity)entityPlayer1);
/*      */ 
/*      */ 
/*      */                     
/*  523 */                     ((Entity)entityPlayer1).field_70170_p.func_72838_d((Entity)entityCusPar2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                     
/*  533 */                     EntityCusPar entityCusPar1 = new EntityCusPar("jinryuudragonbc:bens_particles.png", ((Entity)entityPlayer1).field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, motx, moty, motz, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", (int)(30.0F * life * 0.5F), 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * extra_scale, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * extra_scale, 0.1F * life * extra_scale, 0, red, green, blue, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.08F, false, -1, true, (Entity)entityPlayer1);
/*      */ 
/*      */ 
/*      */                     
/*  537 */                     ((Entity)entityPlayer1).field_70170_p.func_72838_d((Entity)entityCusPar1);
/*      */ 
/*      */ 
/*      */                     
/*  541 */                     if (getColL3() > 0) {
/*  542 */                       width *= 0.8F;
/*  543 */                       life *= 0.8F;
/*      */                       
/*  545 */                       x = (Math.random() * 1.0D - 0.5D) * (width * 0.8F);
/*  546 */                       y = -1.0D;
/*  547 */                       z = (Math.random() * 1.0D - 0.5D) * (width * 0.8F);
/*      */                       
/*  549 */                       h2 = (this.colorl3 >> 16 & 0xFF) / 255.0F;
/*  550 */                       h3 = (this.colorl3 >> 8 & 0xFF) / 255.0F;
/*  551 */                       h4 = (this.colorl3 & 0xFF) / 255.0F;
/*      */                       
/*  553 */                       red = h1 * h2; green = h1 * h3; blue = h1 * h4;
/*  554 */                       if (red > 1.0F) red = 1.0F; 
/*  555 */                       if (green > 1.0F) green = 1.0F; 
/*  556 */                       if (blue > 1.0F) blue = 1.0F; 
/*  557 */                       life *= 0.95F;
/*  558 */                       moty = (Math.random() * 0.10000000149011612D + 0.10000000149011612D) * life * 0.57D;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                       
/*  568 */                       EntityCusPar entityCusPar4 = new EntityCusPar("jinryuumodscore:bens_particles.png", ((Entity)entityPlayer1).field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, motx, moty, motz, 0.0F, (int)(Math.random() * 3.0D) + 32, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", (int)(30.0F * life * 1.6F), 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * extra_scale, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * extra_scale, 0.1F * life * extra_scale, 0, red, green, blue, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2, 0.0F, 0.0F, 0.3F, 0.35F, 0.02F, false, -1, true, (Entity)entityPlayer1);
/*      */ 
/*      */ 
/*      */ 
/*      */                       
/*  573 */                       ((Entity)entityPlayer1).field_70170_p.func_72838_d((Entity)entityCusPar4);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                       
/*  583 */                       EntityCusPar entityCusPar3 = new EntityCusPar("jinryuudragonbc:bens_particles.png", ((Entity)entityPlayer1).field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, motx, moty, motz, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", (int)(30.0F * life * 1.6F), 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * extra_scale, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * extra_scale, 0.1F * life * extra_scale, 0, red, green, blue, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2, 0.0F, 0.0F, 0.3F, 0.35F, 0.02F, false, -1, true, (Entity)entityPlayer1);
/*      */ 
/*      */ 
/*      */ 
/*      */                       
/*  588 */                       ((Entity)entityPlayer1).field_70170_p.func_72838_d((Entity)entityCusPar3);
/*      */                     }
/*      */                   
/*      */                   }
/*      */                 
/*      */                 }
/*  594 */                 else if (this.bol6 == 6) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/*  615 */                   float width = 1.25F;
/*  616 */                   for (int j = 0; j < 2; j++)
/*      */                   {
/*  618 */                     double x = Math.random() * 1.25D - 0.625D;
/*  619 */                     double y = Math.random() * this.field_70131_O - 0.5D;
/*  620 */                     double z = Math.random() * 1.25D - 0.625D;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                     
/*  629 */                     EntityCusPar entityCusPar2 = new EntityCusPar("jinryuumodscore:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 30, 2, (float)(Math.random() * 0.029999999329447746D), (float)(Math.random() * 0.029999999329447746D) + 0.05F, 0.1F, 2, 168.0F, 50.0F, 214.0F, 0.0F, 0.0F, 0.0F, 175.0F, 55.0F, 228.0F, 3, 0.5F, 0.0F, 0.0F, 0.0F, -0.1F, false, -1, true, (Entity)entityPlayer1);
/*      */ 
/*      */ 
/*      */                     
/*  633 */                     ((Entity)entityCusPar2).field_70170_p.func_72838_d((Entity)entityCusPar2);
/*      */ 
/*      */                     
/*  636 */                     x = Math.random() * 1.0D - 0.5D;
/*  637 */                     y = Math.random() * this.field_70131_O - 0.5D;
/*  638 */                     z = Math.random() * 1.0D - 0.5D;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                     
/*  648 */                     EntityCusPar entityCusPar1 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 30, 2, (float)(Math.random() * 0.029999999329447746D), (float)(Math.random() * 0.029999999329447746D) + 0.05F, 0.1F, 2, 168.0F, 50.0F, 214.0F, 0.0F, 0.0F, 0.0F, 175.0F, 55.0F, 228.0F, 3, 0.5F, 0.0F, 0.0F, 0.0F, -0.1F, false, -1, true, (Entity)entityPlayer1);
/*      */ 
/*      */ 
/*      */                     
/*  652 */                     ((Entity)entityCusPar1).field_70170_p.func_72838_d((Entity)entityCusPar1);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/*      */                   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                 
/*      */                 }
/*  695 */                 else if (this.bol6 == 0) {
/*      */                   
/*  697 */                   float red = 215.0F, green = 107.0F, blue = 61.0F;
/*  698 */                   float red2 = 218.0F, green2 = 209.0F, blue2 = 71.0F;
/*  699 */                   float out = 1.6F, in = 1.5F;
/*  700 */                   float life = 0.8F * ((Entity)entityPlayer).field_70131_O;
/*  701 */                   float extra_scale = 0.5F;
/*  702 */                   int dea = 50;
/*      */ 
/*      */ 
/*      */                   
/*  706 */                   double x = Math.random() * 1.600000023841858D - 0.800000011920929D;
/*  707 */                   double y = Math.random() * ((Entity)entityPlayer).field_70131_O - 0.5D;
/*  708 */                   double z = Math.random() * 1.600000023841858D - 0.800000011920929D;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/*  716 */                   EntityCusPar entityCusPar2 = new EntityCusPar("jinryuumodscore:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 215.0F, 107.0F, 61.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, true, (Entity)entityPlayer1);
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/*  721 */                   x = Math.random() * 1.600000023841858D - 0.800000011920929D;
/*  722 */                   y = Math.random() * ((Entity)entityPlayer).field_70131_O - 0.5D;
/*  723 */                   z = Math.random() * 1.600000023841858D - 0.800000011920929D;
/*  724 */                   ((Entity)entityCusPar2).field_70170_p.func_72838_d((Entity)entityCusPar2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/*  732 */                   EntityCusPar entityCusPar4 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 215.0F, 107.0F, 61.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, true, (Entity)entityPlayer1);
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/*  737 */                   ((Entity)entityCusPar2).field_70170_p.func_72838_d((Entity)entityCusPar4);
/*      */ 
/*      */                   
/*  740 */                   x = Math.random() * 1.5D - 0.75D;
/*  741 */                   y = (Math.random() * ((Entity)entityPlayer).field_70131_O - 0.5D) * 0.800000011920929D;
/*  742 */                   z = Math.random() * 1.5D - 0.75D;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/*  750 */                   EntityCusPar entityCusPar1 = new EntityCusPar("jinryuumodscore:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 218.0F, 209.0F, 71.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, true, (Entity)entityPlayer1);
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/*  755 */                   x = Math.random() * 1.5D - 0.75D;
/*  756 */                   y = (Math.random() * ((Entity)entityPlayer).field_70131_O - 0.5D) * 0.800000011920929D;
/*  757 */                   z = Math.random() * 1.5D - 0.75D;
/*  758 */                   ((Entity)entityCusPar1).field_70170_p.func_72838_d((Entity)entityCusPar1);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/*  766 */                   EntityCusPar entityCusPar3 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 218.0F, 209.0F, 71.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, true, (Entity)entityPlayer1);
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/*  771 */                   ((Entity)entityCusPar1).field_70170_p.func_72838_d((Entity)entityCusPar3);
/*      */ 
/*      */ 
/*      */                 
/*      */                 }
/*  776 */                 else if (this.bol6 == 1) {
/*      */                   
/*  778 */                   float red = 48.0F, green = 208.0F, blue = 232.0F;
/*  779 */                   float out = 1.6F, in = 1.0F;
/*  780 */                   float life = 0.8F * ((Entity)entityPlayer).field_70131_O;
/*  781 */                   float extra_scale = 0.5F;
/*  782 */                   int dea = 50;
/*      */ 
/*      */                   
/*  785 */                   for (int gh = 0; gh < 2; gh++) {
/*  786 */                     double d1 = Math.random() * 1.600000023841858D - 0.800000011920929D;
/*  787 */                     double d2 = Math.random() * ((Entity)entityPlayer).field_70131_O - 0.5D;
/*  788 */                     double d3 = Math.random() * 1.600000023841858D - 0.800000011920929D;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                     
/*  796 */                     EntityCusPar entityCusPar3 = new EntityCusPar("jinryuumodscore:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, d1, d2, d3, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 48.0F, 208.0F, 232.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, true, (Entity)entityPlayer1);
/*      */ 
/*      */ 
/*      */ 
/*      */                     
/*  801 */                     d1 = Math.random() * 1.600000023841858D - 0.800000011920929D;
/*  802 */                     d2 = Math.random() * ((Entity)entityPlayer).field_70131_O - 0.5D;
/*  803 */                     d3 = Math.random() * 1.600000023841858D - 0.800000011920929D;
/*  804 */                     ((Entity)entityCusPar3).field_70170_p.func_72838_d((Entity)entityCusPar3);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                     
/*  812 */                     EntityCusPar entityCusPar4 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, d1, d2, d3, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 48.0F, 208.0F, 232.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, true, (Entity)entityPlayer1);
/*      */ 
/*      */ 
/*      */ 
/*      */                     
/*  817 */                     ((Entity)entityCusPar3).field_70170_p.func_72838_d((Entity)entityCusPar4);
/*      */                   } 
/*      */                   
/*  820 */                   double x = Math.random() * 1.0D - 0.5D;
/*  821 */                   double y = (Math.random() * ((Entity)entityPlayer).field_70131_O - 0.5D) * 0.800000011920929D;
/*  822 */                   double z = Math.random() * 1.0D - 0.5D;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/*  830 */                   EntityCusPar entityCusPar1 = new EntityCusPar("jinryuumodscore:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 160.0F, 220.0F, 255.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, true, (Entity)entityPlayer1);
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/*  835 */                   x = Math.random() * 1.0D - 0.5D;
/*  836 */                   y = (Math.random() * ((Entity)entityPlayer).field_70131_O - 0.5D) * 0.800000011920929D;
/*  837 */                   z = Math.random() * 1.0D - 0.5D;
/*  838 */                   ((Entity)entityCusPar1).field_70170_p.func_72838_d((Entity)entityCusPar1);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/*  846 */                   EntityCusPar entityCusPar2 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 160.0F, 220.0F, 255.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, true, (Entity)entityPlayer1);
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/*  851 */                   ((Entity)entityCusPar1).field_70170_p.func_72838_d((Entity)entityCusPar2);
/*      */ 
/*      */ 
/*      */                 
/*      */                 }
/*  856 */                 else if (this.bol6 == 2) {
/*      */                   
/*  858 */                   float red = 80.0F, green = 179.0F, blue = 215.0F;
/*  859 */                   float red2 = 46.0F, green2 = 46.0F, blue2 = 211.0F;
/*  860 */                   float in = 1.0F;
/*  861 */                   float out = 1.6F;
/*  862 */                   float life = 0.8F * ((Entity)entityPlayer).field_70131_O;
/*  863 */                   float extra_scale = 0.5F;
/*  864 */                   int dea = 50;
/*      */ 
/*      */                   
/*  867 */                   for (int gh = 0; gh < 2; gh++) {
/*  868 */                     double d1 = Math.random() * out - (out / 2.0F);
/*  869 */                     double d2 = Math.random() * ((Entity)entityPlayer).field_70131_O - 0.5D;
/*  870 */                     double d3 = Math.random() * out - (out / 2.0F);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                     
/*  878 */                     EntityCusPar entityCusPar5 = new EntityCusPar("jinryuumodscore:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, d1, d2, d3, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 80.0F, 179.0F, 215.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, true, (Entity)entityPlayer1);
/*      */ 
/*      */ 
/*      */ 
/*      */                     
/*  883 */                     d1 = Math.random() * out - (out / 2.0F);
/*  884 */                     d2 = Math.random() * ((Entity)entityPlayer).field_70131_O - 0.5D;
/*  885 */                     d3 = Math.random() * out - (out / 2.0F);
/*  886 */                     ((Entity)entityCusPar5).field_70170_p.func_72838_d((Entity)entityCusPar5);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                     
/*  894 */                     EntityCusPar entityCusPar6 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, d1, d2, d3, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 80.0F, 179.0F, 215.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, true, (Entity)entityPlayer1);
/*      */ 
/*      */ 
/*      */ 
/*      */                     
/*  899 */                     ((Entity)entityCusPar5).field_70170_p.func_72838_d((Entity)entityCusPar6);
/*      */                   } 
/*      */                   
/*  902 */                   out *= 1.4F;
/*  903 */                   double x = Math.random() * out - (out / 2.0F);
/*  904 */                   double y = Math.random() * ((Entity)entityPlayer).field_70131_O - 0.5D;
/*  905 */                   double z = Math.random() * out - (out / 2.0F);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/*  913 */                   EntityCusPar entityCusPar2 = new EntityCusPar("jinryuumodscore:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 46.0F, 46.0F, 211.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, true, (Entity)entityPlayer1);
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/*  918 */                   x = Math.random() * out - (out / 2.0F);
/*  919 */                   y = Math.random() * ((Entity)entityPlayer).field_70131_O - 0.5D;
/*  920 */                   z = Math.random() * out - (out / 2.0F);
/*  921 */                   ((Entity)entityCusPar2).field_70170_p.func_72838_d((Entity)entityCusPar2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/*  929 */                   EntityCusPar entityCusPar4 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 46.0F, 46.0F, 211.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, true, (Entity)entityPlayer1);
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/*  934 */                   ((Entity)entityCusPar2).field_70170_p.func_72838_d((Entity)entityCusPar4);
/*      */ 
/*      */                   
/*  937 */                   x = Math.random() * 1.0D - 0.5D;
/*  938 */                   y = (Math.random() * ((Entity)entityPlayer).field_70131_O - 0.5D) * 0.800000011920929D;
/*  939 */                   z = Math.random() * 1.0D - 0.5D;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/*  947 */                   EntityCusPar entityCusPar1 = new EntityCusPar("jinryuumodscore:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 160.0F, 220.0F, 255.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, true, (Entity)entityPlayer1);
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/*  952 */                   x = Math.random() * 1.0D - 0.5D;
/*  953 */                   y = (Math.random() * ((Entity)entityPlayer).field_70131_O - 0.5D) * 0.800000011920929D;
/*  954 */                   z = Math.random() * 1.0D - 0.5D;
/*  955 */                   ((Entity)entityCusPar1).field_70170_p.func_72838_d((Entity)entityCusPar1);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/*  963 */                   EntityCusPar entityCusPar3 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 160.0F, 220.0F, 255.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, true, (Entity)entityPlayer1);
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/*  968 */                   ((Entity)entityCusPar1).field_70170_p.func_72838_d((Entity)entityCusPar3);
/*      */ 
/*      */ 
/*      */                 
/*      */                 }
/*  973 */                 else if (this.bol6 == 3 && this.field_70173_aa < 3) {
/*      */                   
/*  975 */                   float red = 186.0F, green = 37.0F, blue = 197.0F;
/*  976 */                   float red2 = 140.0F, green2 = 8.0F, blue2 = 62.0F;
/*  977 */                   float out = 1.6F, in = 1.0F;
/*  978 */                   float life = 0.8F * ((Entity)entityPlayer).field_70131_O;
/*  979 */                   float extra_scale = 0.5F;
/*  980 */                   int dea = 50;
/*      */ 
/*      */                   
/*  983 */                   for (int gh = 0; gh < 2; gh++) {
/*  984 */                     double d1 = Math.random() * out - (out / 2.0F);
/*  985 */                     double d2 = Math.random() * ((Entity)entityPlayer).field_70131_O - 0.5D;
/*  986 */                     double d3 = Math.random() * out - (out / 2.0F);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                     
/*  994 */                     EntityCusPar entityCusPar7 = new EntityCusPar("jinryuumodscore:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, d1, d2, d3, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 186.0F, 37.0F, 197.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, true, (Entity)entityPlayer1);
/*      */ 
/*      */ 
/*      */ 
/*      */                     
/*  999 */                     d1 = Math.random() * out - (out / 2.0F);
/* 1000 */                     d2 = Math.random() * ((Entity)entityPlayer).field_70131_O - 0.5D;
/* 1001 */                     d3 = Math.random() * out - (out / 2.0F);
/* 1002 */                     ((Entity)entityCusPar7).field_70170_p.func_72838_d((Entity)entityCusPar7);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                     
/* 1010 */                     EntityCusPar entityCusPar8 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, d1, d2, d3, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 186.0F, 37.0F, 197.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, true, (Entity)entityPlayer1);
/*      */ 
/*      */ 
/*      */ 
/*      */                     
/* 1015 */                     ((Entity)entityCusPar7).field_70170_p.func_72838_d((Entity)entityCusPar8);
/*      */                   } 
/*      */                   
/* 1018 */                   out *= 1.4F;
/* 1019 */                   double x = Math.random() * out - (out / 2.0F);
/* 1020 */                   double y = Math.random() * ((Entity)entityPlayer).field_70131_O - 0.5D;
/* 1021 */                   double z = Math.random() * out - (out / 2.0F);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/* 1029 */                   EntityCusPar entityCusPar3 = new EntityCusPar("jinryuumodscore:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 140.0F, 8.0F, 62.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, true, (Entity)entityPlayer1);
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/* 1034 */                   x = Math.random() * out - (out / 2.0F);
/* 1035 */                   y = Math.random() * ((Entity)entityPlayer).field_70131_O - 0.5D;
/* 1036 */                   z = Math.random() * out - (out / 2.0F);
/* 1037 */                   ((Entity)entityCusPar3).field_70170_p.func_72838_d((Entity)entityCusPar3);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/* 1045 */                   EntityCusPar entityCusPar6 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 140.0F, 8.0F, 62.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, true, (Entity)entityPlayer1);
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/* 1050 */                   ((Entity)entityCusPar3).field_70170_p.func_72838_d((Entity)entityCusPar6);
/*      */ 
/*      */                   
/* 1053 */                   x = Math.random() * in - (in / 2.0F);
/* 1054 */                   y = (Math.random() * ((Entity)entityPlayer).field_70131_O - 0.5D) * 0.800000011920929D;
/* 1055 */                   z = Math.random() * in - (in / 2.0F);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/* 1063 */                   EntityCusPar entityCusPar2 = new EntityCusPar("jinryuumodscore:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 184.0F, 147.0F, 241.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, true, (Entity)entityPlayer1);
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/* 1068 */                   x = Math.random() * in - (in / 2.0F);
/* 1069 */                   y = (Math.random() * ((Entity)entityPlayer).field_70131_O - 0.5D) * 0.800000011920929D;
/* 1070 */                   z = Math.random() * in - (in / 2.0F);
/* 1071 */                   ((Entity)entityCusPar2).field_70170_p.func_72838_d((Entity)entityCusPar2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/* 1079 */                   EntityCusPar entityCusPar5 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 184.0F, 147.0F, 241.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, true, (Entity)entityPlayer1);
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/* 1084 */                   ((Entity)entityCusPar2).field_70170_p.func_72838_d((Entity)entityCusPar5);
/*      */ 
/*      */                   
/* 1087 */                   in *= 1.2F;
/* 1088 */                   x = Math.random() * in - (in / 2.0F);
/* 1089 */                   y = (Math.random() * ((Entity)entityPlayer).field_70131_O - 0.5D) * 0.800000011920929D;
/* 1090 */                   z = Math.random() * in - (in / 2.0F);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/* 1098 */                   EntityCusPar entityCusPar1 = new EntityCusPar("jinryuumodscore:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 93.0F, 3.0F, 177.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, true, (Entity)entityPlayer1);
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/* 1103 */                   x = Math.random() * in - (in / 2.0F);
/* 1104 */                   y = (Math.random() * ((Entity)entityPlayer).field_70131_O - 0.5D) * 0.800000011920929D;
/* 1105 */                   z = Math.random() * in - (in / 2.0F);
/* 1106 */                   ((Entity)entityCusPar1).field_70170_p.func_72838_d((Entity)entityCusPar1);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/* 1114 */                   EntityCusPar entityCusPar4 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 93.0F, 3.0F, 177.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, true, (Entity)entityPlayer1);
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/* 1119 */                   ((Entity)entityCusPar1).field_70170_p.func_72838_d((Entity)entityCusPar4);
/*      */ 
/*      */ 
/*      */                 
/*      */                 }
/* 1124 */                 else if (this.bol6 == 5 && this.field_70173_aa < 3) {
/*      */                   
/* 1126 */                   float red = 191.0F, green = 5.0F, blue = 184.0F;
/* 1127 */                   float red2 = 90.0F, green2 = 19.0F, blue2 = 2.0F;
/* 1128 */                   float out = 1.6F, in = 1.0F;
/* 1129 */                   float life = 0.8F * ((Entity)entityPlayer).field_70131_O;
/* 1130 */                   float extra_scale = 0.5F;
/* 1131 */                   int dea = 50;
/*      */ 
/*      */                   
/* 1134 */                   for (int gh = 0; gh < 2; gh++) {
/* 1135 */                     double d1 = Math.random() * out - (out / 2.0F);
/* 1136 */                     double d2 = Math.random() * ((Entity)entityPlayer).field_70131_O - 0.5D;
/* 1137 */                     double d3 = Math.random() * out - (out / 2.0F);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                     
/* 1145 */                     EntityCusPar entityCusPar7 = new EntityCusPar("jinryuumodscore:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, d1, d2, d3, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 191.0F, 5.0F, 184.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, true, (Entity)entityPlayer1);
/*      */ 
/*      */ 
/*      */ 
/*      */                     
/* 1150 */                     d1 = Math.random() * out - (out / 2.0F);
/* 1151 */                     d2 = Math.random() * ((Entity)entityPlayer).field_70131_O - 0.5D;
/* 1152 */                     d3 = Math.random() * out - (out / 2.0F);
/* 1153 */                     ((Entity)entityCusPar7).field_70170_p.func_72838_d((Entity)entityCusPar7);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                     
/* 1161 */                     EntityCusPar entityCusPar8 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, d1, d2, d3, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 191.0F, 5.0F, 184.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, true, (Entity)entityPlayer1);
/*      */ 
/*      */ 
/*      */ 
/*      */                     
/* 1166 */                     ((Entity)entityCusPar7).field_70170_p.func_72838_d((Entity)entityCusPar8);
/*      */                   } 
/*      */                   
/* 1169 */                   out *= 1.4F;
/* 1170 */                   double x = Math.random() * out - (out / 2.0F);
/* 1171 */                   double y = Math.random() * ((Entity)entityPlayer).field_70131_O - 0.5D;
/* 1172 */                   double z = Math.random() * out - (out / 2.0F);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/* 1180 */                   EntityCusPar entityCusPar3 = new EntityCusPar("jinryuumodscore:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 90.0F, 19.0F, 2.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, true, (Entity)entityPlayer1);
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/* 1185 */                   x = Math.random() * out - (out / 2.0F);
/* 1186 */                   y = Math.random() * ((Entity)entityPlayer).field_70131_O - 0.5D;
/* 1187 */                   z = Math.random() * out - (out / 2.0F);
/* 1188 */                   ((Entity)entityCusPar3).field_70170_p.func_72838_d((Entity)entityCusPar3);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/* 1196 */                   EntityCusPar entityCusPar6 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 90.0F, 19.0F, 2.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, true, (Entity)entityPlayer1);
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/* 1201 */                   ((Entity)entityCusPar3).field_70170_p.func_72838_d((Entity)entityCusPar6);
/*      */ 
/*      */                   
/* 1204 */                   x = Math.random() * in - (in / 2.0F);
/* 1205 */                   y = (Math.random() * ((Entity)entityPlayer).field_70131_O - 0.5D) * 0.800000011920929D;
/* 1206 */                   z = Math.random() * in - (in / 2.0F);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/* 1214 */                   EntityCusPar entityCusPar2 = new EntityCusPar("jinryuumodscore:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 215.0F, 154.0F, 251.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, true, (Entity)entityPlayer1);
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/* 1219 */                   x = Math.random() * in - (in / 2.0F);
/* 1220 */                   y = (Math.random() * ((Entity)entityPlayer).field_70131_O - 0.5D) * 0.800000011920929D;
/* 1221 */                   z = Math.random() * in - (in / 2.0F);
/* 1222 */                   ((Entity)entityCusPar2).field_70170_p.func_72838_d((Entity)entityCusPar2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/* 1230 */                   EntityCusPar entityCusPar5 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 215.0F, 154.0F, 251.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, true, (Entity)entityPlayer1);
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/* 1235 */                   ((Entity)entityCusPar2).field_70170_p.func_72838_d((Entity)entityCusPar5);
/*      */ 
/*      */                   
/* 1238 */                   in *= 1.2F;
/* 1239 */                   x = Math.random() * in - (in / 2.0F);
/* 1240 */                   y = (Math.random() * ((Entity)entityPlayer).field_70131_O - 0.5D) * 0.800000011920929D;
/* 1241 */                   z = Math.random() * in - (in / 2.0F);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/* 1249 */                   EntityCusPar entityCusPar1 = new EntityCusPar("jinryuumodscore:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 158.0F, 0.0F, 216.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, true, (Entity)entityPlayer1);
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/* 1254 */                   x = Math.random() * in - (in / 2.0F);
/* 1255 */                   y = (Math.random() * ((Entity)entityPlayer).field_70131_O - 0.5D) * 0.800000011920929D;
/* 1256 */                   z = Math.random() * in - (in / 2.0F);
/* 1257 */                   ((Entity)entityCusPar1).field_70170_p.func_72838_d((Entity)entityCusPar1);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/* 1265 */                   EntityCusPar entityCusPar4 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 158.0F, 0.0F, 216.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, true, (Entity)entityPlayer1);
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/* 1270 */                   ((Entity)entityCusPar1).field_70170_p.func_72838_d((Entity)entityCusPar4);
/*      */ 
/*      */ 
/*      */                 
/*      */                 }
/* 1275 */                 else if (this.bol6 == 4) {
/*      */                   
/* 1277 */                   float red = 249.0F, green = 212.0F, blue = 33.0F;
/* 1278 */                   float red2 = 234.0F, green2 = 134.0F, blue2 = 34.0F;
/* 1279 */                   float out = 1.6F;
/* 1280 */                   float in = 1.0F;
/* 1281 */                   float life = 0.8F * ((Entity)entityPlayer).field_70131_O;
/* 1282 */                   float extra_scale = 0.5F;
/* 1283 */                   int dea = 50;
/*      */ 
/*      */                   
/* 1286 */                   double x = Math.random() * out - (out / 2.0F);
/* 1287 */                   double y = Math.random() * ((Entity)entityPlayer).field_70131_O - 0.5D;
/* 1288 */                   double z = Math.random() * out - (out / 2.0F);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/* 1296 */                   EntityCusPar entityCusPar3 = new EntityCusPar("jinryuumodscore:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 249.0F, 212.0F, 33.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, true, (Entity)entityPlayer1);
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/* 1301 */                   x = Math.random() * out - (out / 2.0F);
/* 1302 */                   y = Math.random() * ((Entity)entityPlayer).field_70131_O - 0.5D;
/* 1303 */                   z = Math.random() * out - (out / 2.0F);
/* 1304 */                   ((Entity)entityCusPar3).field_70170_p.func_72838_d((Entity)entityCusPar3);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/* 1312 */                   EntityCusPar entityCusPar6 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 249.0F, 212.0F, 33.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, true, (Entity)entityPlayer1);
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/* 1317 */                   ((Entity)entityCusPar3).field_70170_p.func_72838_d((Entity)entityCusPar6);
/*      */ 
/*      */                   
/* 1320 */                   out *= 1.3F;
/* 1321 */                   x = Math.random() * out - (out / 2.0F);
/* 1322 */                   y = Math.random() * ((Entity)entityPlayer).field_70131_O - 0.5D;
/* 1323 */                   z = Math.random() * out - (out / 2.0F);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/* 1331 */                   EntityCusPar entityCusPar2 = new EntityCusPar("jinryuumodscore:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 234.0F, 134.0F, 34.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, true, (Entity)entityPlayer1);
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/* 1336 */                   x = Math.random() * out - (out / 2.0F);
/* 1337 */                   y = Math.random() * ((Entity)entityPlayer).field_70131_O - 0.5D;
/* 1338 */                   z = Math.random() * out - (out / 2.0F);
/* 1339 */                   ((Entity)entityCusPar2).field_70170_p.func_72838_d((Entity)entityCusPar2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/* 1347 */                   EntityCusPar entityCusPar5 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 234.0F, 134.0F, 34.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, true, (Entity)entityPlayer1);
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/* 1352 */                   ((Entity)entityCusPar2).field_70170_p.func_72838_d((Entity)entityCusPar5);
/*      */ 
/*      */                   
/* 1355 */                   x = Math.random() * 1.0D - 0.5D;
/* 1356 */                   y = (Math.random() * ((Entity)entityPlayer).field_70131_O - 0.5D) * 0.800000011920929D;
/* 1357 */                   z = Math.random() * 1.0D - 0.5D;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/* 1365 */                   EntityCusPar entityCusPar1 = new EntityCusPar("jinryuumodscore:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 255.0F, 255.0F, 208.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, true, (Entity)entityPlayer1);
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/* 1370 */                   x = Math.random() * 1.0D - 0.5D;
/* 1371 */                   y = (Math.random() * ((Entity)entityPlayer).field_70131_O - 0.5D) * 0.800000011920929D;
/* 1372 */                   z = Math.random() * 1.0D - 0.5D;
/* 1373 */                   ((Entity)entityCusPar1).field_70170_p.func_72838_d((Entity)entityCusPar1);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/* 1381 */                   EntityCusPar entityCusPar4 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, posXOth, posYOth, posZOth, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 50, 2, ((float)(Math.random() * 0.029999999329447746D) + 0.03F) * life * 0.5F, ((float)(Math.random() * 0.009999999776482582D) + 0.02F) * life * 0.5F, 0.2F * life * 0.5F, 0, 255.0F, 255.0F, 208.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2, 0.0F, 0.0F, 0.4F, 0.45F, 0.015F, false, -1, true, (Entity)entityPlayer1);
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/* 1386 */                   ((Entity)entityCusPar1).field_70170_p.func_72838_d((Entity)entityCusPar4);
/*      */                 } 
/*      */               } 
/*      */             } 
/*      */           } 
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1400 */         if (JGConfigClientSettings.CLIENT_GR0)
/* 1401 */           for (int k = 0; k < JGConfigClientSettings.get_da1(); k++) {
/* 1402 */             if (this.kettleMode != 1 && (this.texl2.equals("aurai2") || this.texl3.equals("auragb")) && this.bol6 != 6) {
/* 1403 */               if (!this.bol4) {
/* 1404 */                 if (this.field_70173_aa % 2 == 0)
/*      */                 {
/* 1406 */                   float a = this.alpha, h1 = 1.0F;
/* 1407 */                   float spe2 = 1.3F;
/* 1408 */                   float h2 = (this.color >> 16 & 0xFF) / 255.0F;
/* 1409 */                   float h3 = (this.color >> 8 & 0xFF) / 255.0F;
/* 1410 */                   float h4 = (this.color & 0xFF) / 255.0F;
/*      */                   
/* 1412 */                   float red = h1 * h2 + 0.6F, green = h1 * h3 + 0.6F, blue = h1 * h4 + 0.6F;
/* 1413 */                   if (red > 1.0F) red = 1.0F; 
/* 1414 */                   if (green > 1.0F) green = 1.0F; 
/* 1415 */                   if (blue > 1.0F) blue = 1.0F; 
/* 1416 */                   Entity pl = this;
/*      */                   
/* 1418 */                   double x = Math.random() * spe2 - (spe2 / 2.0F);
/* 1419 */                   double y = -0.30000001192092896D;
/* 1420 */                   double z = Math.random() * spe2 - (spe2 / 2.0F);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/* 1428 */                   EntityCusPar entityCusPar = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, pl.field_70165_t, pl.field_70163_u, pl.field_70161_v, x, y, z, 0.0D, 0.05D + Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 48, 48, 8, 32, false, 0.0F, false, 0.0F, 1, "", 35, 0, 0.003F + (float)(Math.random() * 0.006000000052154064D), 0.0F, 0.0F, 0, red, green, blue, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2, 0.8F, 0.0F, 0.9F, 0.95F, 0.018F, false, -1, true, (Entity)entityPlayer);
/*      */ 
/*      */ 
/*      */                   
/* 1432 */                   ((Entity)entityCusPar).field_70170_p.func_72838_d((Entity)entityCusPar);
/*      */                 }
/*      */               
/*      */               }
/* 1436 */               else if (this.field_70173_aa % 10 == 0) {
/*      */                 
/* 1438 */                 float a = this.alpha, h1 = 1.0F;
/* 1439 */                 float spe2 = 1.3F;
/* 1440 */                 float h2 = (this.color >> 16 & 0xFF) / 255.0F;
/* 1441 */                 float h3 = (this.color >> 8 & 0xFF) / 255.0F;
/* 1442 */                 float h4 = (this.color & 0xFF) / 255.0F;
/*      */                 
/* 1444 */                 float red = h1 * h2 + 0.6F, green = h1 * h3 + 0.6F, blue = h1 * h4 + 0.6F;
/* 1445 */                 if (red > 1.0F) red = 1.0F; 
/* 1446 */                 if (green > 1.0F) green = 1.0F; 
/* 1447 */                 if (blue > 1.0F) blue = 1.0F; 
/* 1448 */                 Entity pl = this;
/*      */                 
/* 1450 */                 double x = Math.random() * spe2 - (spe2 / 2.0F);
/* 1451 */                 double y = -0.30000001192092896D;
/* 1452 */                 double z = Math.random() * spe2 - (spe2 / 2.0F);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                 
/* 1460 */                 EntityCusPar entityCusPar = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, pl.field_70165_t, pl.field_70163_u, pl.field_70161_v, x, y, z, 0.0D, 0.05D + Math.random() * 0.10000000149011612D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 48, 48, 8, 32, false, 0.0F, false, 0.0F, 1, "", 20, 0, 0.003F + (float)(Math.random() * 0.006000000052154064D), 0.0F, 0.0F, 0, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2, 0.8F, 0.0F, 0.9F, 0.95F, 0.05F, false, -1, true, (Entity)entityPlayer);
/*      */ 
/*      */ 
/*      */                 
/* 1464 */                 ((Entity)entityCusPar).field_70170_p.func_72838_d((Entity)entityCusPar);
/*      */               } 
/*      */             }
/*      */           }  
/* 1468 */         if (this.kettleMode != 1 && JGConfigClientSettings.CLIENT_GR7) {
/* 1469 */           for (int k = 0; k < JGConfigClientSettings.get_da1(); k++) {
/* 1470 */             if ((this.texl2.equals("aurai2") || this.texl3.equals("auragb")) && 
/* 1471 */               this.bol4 && 
/* 1472 */               this.field_70173_aa % 10 == 0) {
/* 1473 */               EntityPlayer entityPlayer1 = entityPlayer;
/*      */               
/* 1475 */               double x = Math.random() * 1.0D - 0.5D;
/* 1476 */               double y = Math.random() * ((Entity)entityPlayer).field_70131_O - 0.5D;
/* 1477 */               double z = Math.random() * 1.0D - 0.5D;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/* 1485 */               EntityCusPar entityCusPar1 = new EntityCusPar("jinryuumodscore:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, ((Entity)entityPlayer1).field_70165_t, ((Entity)entityPlayer1).field_70163_u, ((Entity)entityPlayer1).field_70161_v, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 3.0D) + 8, 8, 3, 32, false, 0.0F, false, 0.0F, 1, "", 100, 2, (float)(Math.random() * 0.05000000074505806D), (float)(Math.random() * 0.07999999821186066D) + 0.1F, 0.1F, 2, 105.0F, 40.0F, 148.0F, 0.0F, 0.0F, 0.0F, 105.0F, 40.0F, 148.0F, 1, 0.5F, 0.0F, 0.0F, 0.0F, -0.01F, false, -1, true, (Entity)entityPlayer);
/*      */ 
/*      */ 
/*      */               
/* 1489 */               ((Entity)entityCusPar1).field_70170_p.func_72838_d((Entity)entityCusPar1);
/*      */               
/* 1491 */               x = Math.random() * 1.0D - 0.5D;
/* 1492 */               y = Math.random() * ((Entity)entityPlayer).field_70131_O - 0.5D;
/* 1493 */               z = Math.random() * 1.0D - 0.5D;
/* 1494 */               double motion = Math.random() * 0.029999999329447746D + 0.0010000000474974513D;
/* 1495 */               int image = (int)(Math.random() * 8.0D) + 32;
/* 1496 */               float sizem = (float)(Math.random() * 0.029999999329447746D);
/* 1497 */               float sizemm = (float)(Math.random() * 0.029999999329447746D) + 0.05F;
/* 1498 */               EntityCusPar entityCusPar2 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, ((Entity)entityPlayer1).field_70165_t, ((Entity)entityPlayer1).field_70163_u, ((Entity)entityPlayer1).field_70161_v, x, y, z, 0.0D, motion, 0.0D, 0.0F, image, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 100, 2, sizem, sizemm, 0.1F, 0, 80.0F, 156.0F, 186.0F, 0.0F, 0.0F, 0.0F, 80.0F, 156.0F, 186.0F, 1, 0.8F, 0.0F, 0.0F, 0.0F, -0.01F, false, -1, true, (Entity)entityPlayer);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/* 1509 */               ((Entity)entityCusPar2).field_70170_p.func_72838_d((Entity)entityCusPar2);
/*      */               
/* 1511 */               entityCusPar2 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, ((Entity)entityPlayer1).field_70165_t, ((Entity)entityPlayer1).field_70163_u, ((Entity)entityPlayer1).field_70161_v, x, y, z, 0.0D, motion, 0.0D, 0.0F, image, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 100, 2, sizem * 0.9F, sizemm * 0.9F, 0.1F, 1, 1.0F, 1.0F, 1.0F, -0.03F, -0.02F, -0.01F, 80.0F, 156.0F, 186.0F, 1, 0.65F, 0.0F, 0.0F, 0.0F, -0.01F, false, -1, true, (Entity)entityPlayer);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/* 1522 */               ((Entity)entityCusPar2).field_70170_p.func_72838_d((Entity)entityCusPar2);
/*      */               
/* 1524 */               x = Math.random() * 1.0D - 0.5D;
/* 1525 */               y = Math.random() * ((Entity)entityPlayer).field_70131_O - 0.20000000298023224D;
/* 1526 */               z = Math.random() * 1.0D - 0.5D;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/* 1534 */               EntityCusPar entityCusPar3 = new EntityCusPar("jinryuumodscore:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, ((Entity)entityPlayer1).field_70165_t, ((Entity)entityPlayer1).field_70163_u, ((Entity)entityPlayer1).field_70161_v, x, y, z, 0.0D, Math.random() * 0.004999999888241291D, 0.0D, 0.0F, 8, 8, 1, 32, false, 0.0F, false, 0.0F, 1, "", 100, 2, (float)(Math.random() * 0.10000000149011612D), (float)(Math.random() * 0.20000000298023224D) + 0.5F, 0.1F, 2, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 1, 0.4F, 0.0F, 0.0F, 0.0F, -0.01F, false, -1, true, (Entity)entityPlayer);
/*      */ 
/*      */ 
/*      */ 
/*      */               
/* 1539 */               ((Entity)entityCusPar3).field_70170_p.func_72838_d((Entity)entityCusPar3);
/*      */               
/* 1541 */               x = Math.random() * 1.0D - 0.5D;
/* 1542 */               y = Math.random() * ((Entity)entityPlayer).field_70131_O - 0.5D;
/* 1543 */               z = Math.random() * 1.0D - 0.5D;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/* 1552 */               EntityCusPar entityCusPar4 = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.field_70170_p, 0.2F, 0.2F, ((Entity)entityPlayer1).field_70165_t, ((Entity)entityPlayer1).field_70163_u, ((Entity)entityPlayer1).field_70161_v, x, y, z, 0.0D, Math.random() * 0.05000000074505806D, 0.0D, 0.0F, (int)(Math.random() * 8.0D) + 32, 32, 8, 32, false, 0.0F, false, 0.0F, 1, "", 100, 2, (float)(Math.random() * 0.029999999329447746D), (float)(Math.random() * 0.029999999329447746D) + 0.05F, 0.1F, 2, 189.0F, 138.0F, 227.0F, 0.0F, 0.0F, 0.0F, 189.0F, 138.0F, 227.0F, 1, 0.7F, 0.0F, 0.0F, 0.0F, -0.01F, false, -1, true, (Entity)entityPlayer);
/*      */ 
/*      */ 
/*      */ 
/*      */               
/* 1557 */               ((Entity)entityCusPar4).field_70170_p.func_72838_d((Entity)entityCusPar4);
/*      */             } 
/*      */           } 
/*      */         }
/*      */ 
/*      */ 
/*      */         
/* 1564 */         if (JGConfigClientSettings.CLIENT_GR1 || JGConfigClientSettings.CLIENT_GR8 || JGConfigClientSettings.CLIENT_GR9) {
/* 1565 */           for (int k = 0; k < JGConfigClientSettings.get_da1(); k++) {
/* 1566 */             int[] tavolsagok = { 5, 6, 8, 10, 20 };
/* 1567 */             int tav = 20;
/*      */ 
/*      */             
/* 1570 */             boolean b1 = false;
/* 1571 */             boolean b2 = false;
/* 1572 */             String[] s = { "dirt", "grass", "rock", "stone" };
/* 1573 */             for (int j = 0; j < 5; j++) {
/* 1574 */               if (!b2 && this.field_70170_p.func_147439_a((int)this.field_70165_t, (int)this.field_70163_u - sneak + j, (int)this.field_70161_v).func_149739_a().toLowerCase().contains("grass")) { b2 = true; tav = tavolsagok[j]; }
/* 1575 */                for (int i = 0; i < s.length; i++) {
/* 1576 */                 if (!b1 && this.field_70170_p.func_147439_a((int)this.field_70165_t, (int)this.field_70163_u - sneak + j, (int)this.field_70161_v).func_149739_a().toLowerCase().contains(s[i])) { b1 = true; tav = tavolsagok[j]; }
/*      */               
/*      */               } 
/*      */             } 
/* 1580 */             if (this.field_70173_aa == 1) {
/* 1581 */               int spwnd = 0;
/* 1582 */               boolean bool1 = false;
/* 1583 */               boolean bool2 = false;
/*      */ 
/*      */               
/* 1586 */               String[] arrayOfString = { "dirt", "grass", "rock", "stone" };
/* 1587 */               for (int i = 0; i < 5; i++) {
/* 1588 */                 if (!bool2 && (this.bol2 || this.bol) && this.field_70170_p.func_147439_a((int)this.field_70165_t, (int)this.field_70163_u - sneak + i, (int)this.field_70161_v).func_149739_a().toLowerCase().contains("grass")) { bool2 = true; spwnd = i; }
/* 1589 */                  for (int m = 0; m < arrayOfString.length; m++) {
/* 1590 */                   if (!bool1 && (this.bol2 || this.bol) && this.field_70170_p.func_147439_a((int)this.field_70165_t, (int)this.field_70163_u - sneak + i, (int)this.field_70161_v).func_149739_a().toLowerCase().contains(arrayOfString[m])) { bool1 = true; spwnd = i; }
/*      */                 
/*      */                 } 
/*      */               } 
/* 1594 */               if (JGConfigClientSettings.CLIENT_GR8 && bool2) {
/*      */                 EntityCusPar entityCusPar;
/* 1596 */                 float spe = 10.0F;
/* 1597 */                 Entity pl = this;
/*      */                 
/* 1599 */                 if (!JGConfigClientSettings.CLIENT_GR11) {
/*      */                   
/* 1601 */                   double x = Math.random() * spe - (spe / 2.0F);
/* 1602 */                   double y = (-0.2F - spwnd);
/* 1603 */                   double z = Math.random() * spe - (spe / 2.0F);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/* 1611 */                   entityCusPar = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.field_70170_p, 1.0F, 1.0F, pl.field_70165_t, pl.field_70163_u, pl.field_70161_v, x, y, z, 0.01D + Math.random() * 0.10000000149011612D - 0.05000000074505806D, 0.05D + Math.random() * 0.20000000298023224D, 0.01D + Math.random() * 0.10000000149011612D - 0.05000000074505806D, (float)(Math.random() * 0.0010000000474974513D) - 5.0E-4F, (int)(Math.random() * 8.0D) + 16, 16, 8, 32, true, 0.5F, false, 0.0F, 1, "", 160, 0, 0.005F + (float)(Math.random() * 0.009999999776482582D), 0.0F, 0.0F, 0, 255.0F, 255.0F, 255.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2, 0.7F, 0.0F, 0.95F, 1.0F, 0.01F, false, -1, false, null);
/*      */                 
/*      */                 }
/*      */                 else {
/*      */ 
/*      */                   
/* 1617 */                   double x = Math.random() * spe - (spe / 2.0F);
/* 1618 */                   double y = (-0.2F - spwnd);
/* 1619 */                   double z = Math.random() * spe - (spe / 2.0F);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/* 1627 */                   entityCusPar = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.field_70170_p, 1.0F, 1.0F, pl.field_70165_t, pl.field_70163_u, pl.field_70161_v, x, y, z, 0.01D + Math.random() * 0.10000000149011612D - 0.05000000074505806D, 0.05D + Math.random() * 0.20000000298023224D, 0.01D + Math.random() * 0.10000000149011612D - 0.05000000074505806D, (float)(Math.random() * 0.0010000000474974513D) - 5.0E-4F, (int)(Math.random() * 8.0D) + 16, 16, 8, 32, true, 0.5F, false, 0.0F, 1, "", 160, 0, 0.005F + (float)(Math.random() * 0.009999999776482582D), 0.0F, 0.0F, 0, 255.0F, 255.0F, 255.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2, 0.7F, 0.0F, 0.95F, 1.0F, 0.01F, true, 0, false, null);
/*      */                 } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                 
/* 1635 */                 ((Entity)entityCusPar).field_70170_p.func_72838_d((Entity)entityCusPar);
/*      */               } 
/* 1637 */               if (JGConfigClientSettings.CLIENT_GR1 && bool1) {
/*      */ 
/*      */                 
/* 1640 */                 float spe2 = 10.0F;
/* 1641 */                 Entity pl = this;
/*      */                 
/* 1643 */                 if (!JGConfigClientSettings.CLIENT_GR11) {
/*      */                   
/* 1645 */                   double x = Math.random() * spe2 - (spe2 / 2.0F);
/* 1646 */                   double y = (-0.2F - spwnd);
/* 1647 */                   double z = Math.random() * spe2 - (spe2 / 2.0F);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/* 1655 */                   EntityCusPar entityCusPar = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.field_70170_p, 1.0F, 1.0F, pl.field_70165_t, pl.field_70163_u, pl.field_70161_v, x, y, z, 0.0D + Math.random() * 0.10000000149011612D - 0.05000000074505806D, 0.05D + (float)(Math.random() * 0.20000000298023224D), 0.0D + Math.random() * 0.10000000149011612D - 0.05000000074505806D, 0.0F, (int)(Math.random() * 13.0D), 0, 13, 32, true, 0.5F, false, 0.0F, 1, "", 160, 0, 0.005F + (float)(Math.random() * 0.019999999552965164D), 0.0F, 0.0F, 0, 255.0F, 255.0F, 255.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2, 0.7F, 0.0F, 0.95F, 1.0F, 0.01F, false, -1, false, null);
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/* 1660 */                   ((Entity)entityCusPar).field_70170_p.func_72838_d((Entity)entityCusPar);
/*      */                 } else {
/*      */                   
/* 1663 */                   double x = Math.random() * spe2 - (spe2 / 2.0F);
/* 1664 */                   double y = (-0.2F - spwnd);
/* 1665 */                   double z = Math.random() * spe2 - (spe2 / 2.0F);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/* 1673 */                   EntityCusPar entityCusPar = new EntityCusPar("jinryuudragonbc:bens_particles.png", this.field_70170_p, 1.0F, 1.0F, pl.field_70165_t, pl.field_70163_u, pl.field_70161_v, x, y, z, 0.0D + Math.random() * 0.10000000149011612D - 0.05000000074505806D, 0.05D + (float)(Math.random() * 0.20000000298023224D), 0.0D + Math.random() * 0.10000000149011612D - 0.05000000074505806D, 0.0F, (int)(Math.random() * 13.0D), 0, 13, 32, true, 0.5F, false, 0.0F, 1, "", 160, 0, 0.005F + (float)(Math.random() * 0.019999999552965164D), 0.0F, 0.0F, 0, 255.0F, 255.0F, 255.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2, 0.7F, 0.0F, 0.95F, 1.0F, 0.01F, true, 1, false, null);
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/* 1678 */                   ((Entity)entityCusPar).field_70170_p.func_72838_d((Entity)entityCusPar);
/*      */                 } 
/*      */               } 
/*      */             } 
/*      */             
/* 1683 */             boolean create = JGConfigClientSettings.CLIENT_GR9;
/* 1684 */             if (this.bol4) create = ((int)(Math.random() * 3.0D) == 0); 
/* 1685 */             if (create && this.field_70173_aa % tav == 0) {
/* 1686 */               int spwnd = 0;
/* 1687 */               boolean bool1 = false;
/* 1688 */               boolean bool2 = false;
/*      */ 
/*      */               
/* 1691 */               String[] arrayOfString = { "dirt", "grass", "rock", "stone" };
/* 1692 */               for (int i = 0; i < 5; i++) {
/* 1693 */                 if (!bool2 && (this.bol2 || this.bol) && this.field_70170_p.func_147439_a((int)this.field_70165_t, (int)this.field_70163_u - sneak + i, (int)this.field_70161_v).func_149739_a().toLowerCase().contains("grass")) { bool2 = true; spwnd = i; }
/* 1694 */                  for (int m = 0; m < arrayOfString.length; m++) {
/* 1695 */                   if (!bool1 && (this.bol3 || this.bol2 || this.bol) && this.field_70170_p.func_147439_a((int)this.field_70165_t, (int)this.field_70163_u - sneak + i, (int)this.field_70161_v).func_149739_a().toLowerCase().contains(arrayOfString[m])) { bool1 = true; spwnd = i; }
/*      */                 
/*      */                 } 
/*      */               } 
/* 1699 */               if (JGConfigClientSettings.CLIENT_GR9 && (bool1 || bool2)) {
/* 1700 */                 float spe = (5.0F - spwnd) / 10.0F;
/* 1701 */                 mod_JRMCore.proxy.func_gcp(this, EntityCusPars.PART6, 0.0D, (-0.2F - spwnd), 0.0D, 
/*      */                     
/* 1703 */                     Math.random() * spe - (spe / 2.0F), 0.0D, Math.random() * spe - (spe / 2.0F), 64);
/*      */               } 
/*      */             } 
/*      */           } 
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1712 */         if (this.kettleMode != 1 && JGConfigClientSettings.CLIENT_DA11 && 
/* 1713 */           !((Entity)entityPlayer).field_70122_E && (((Entity)entityPlayer).field_70142_S != ((Entity)entityPlayer).field_70165_t || ((Entity)entityPlayer).field_70136_U != ((Entity)entityPlayer).field_70161_v)) {
/* 1714 */           float red, green, blue, a = this.alpha, h1 = 1.0F;
/*      */ 
/*      */           
/* 1717 */           if (this.bol4) {
/* 1718 */             red = 215.0F; green = 152.0F; blue = 219.0F;
/* 1719 */             a /= 2.0F;
/*      */           } else {
/*      */             
/* 1722 */             float h2 = (this.color >> 16 & 0xFF) / 255.0F;
/* 1723 */             float h3 = (this.color >> 8 & 0xFF) / 255.0F;
/* 1724 */             float h4 = (this.color & 0xFF) / 255.0F;
/* 1725 */             red = h1 * h2; green = h1 * h3; blue = h1 * h4;
/*      */           } 
/*      */           
/* 1728 */           EntityPlayer entityPlayer1 = entityPlayer;
/*      */           
/* 1730 */           double x = -((Entity)entityPlayer1).field_70159_w * 2.5D + ((((Entity)entityPlayer1).field_70159_w > 0.0D) ? -0.2F : 0.2F);
/* 1731 */           double y = (((Entity)entityPlayer).field_70131_O * 0.25F + ((entityPlayer instanceof net.minecraft.client.entity.EntityPlayerSP) ? -1.6F : 0.0F)) - ((Entity)entityPlayer1).field_70181_x * 2.5D + ((((Entity)entityPlayer1).field_70181_x > 0.0D) ? -0.1F : 0.1F);
/* 1732 */           double z = -((Entity)entityPlayer1).field_70179_y * 2.5D + ((((Entity)entityPlayer1).field_70179_y > 0.0D) ? -0.2F : 0.2F);
/* 1733 */           EntityCusPar entityCusPar1 = new EntityCusPar("jinryuumodscore:bens_particles.png", this.field_70170_p, 1.0F, 1.0F, ((Entity)entityPlayer1).field_70165_t, ((Entity)entityPlayer1).field_70163_u, ((Entity)entityPlayer1).field_70161_v, x, y, z, 0.0D, -0.02D, 0.0D, 0.0F, 8, 11, 1, 32, false, 0.0F, false, 0.0F, 1, "", 15, 1, 0.09F, 0.001F, -0.0045F, 0, red, green, blue, 0.0F, 0.0F, 0.0F, red, green, blue, 1, 0.2F, 0.0F, 0.0F, 0.0F, -0.001F, false, -1, true, null);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1744 */           ((Entity)entityCusPar1).field_70170_p.func_72838_d((Entity)entityCusPar1);
/*      */ 
/*      */ 
/*      */           
/* 1748 */           if (this.bol4) {
/* 1749 */             red = 141.0F; green = 158.0F; blue = 210.0F;
/*      */           }
/*      */           else {
/*      */             
/* 1753 */             float h2 = (this.colorl3 >> 16 & 0xFF) / 255.0F;
/* 1754 */             float h3 = (this.colorl3 >> 8 & 0xFF) / 255.0F;
/* 1755 */             float h4 = (this.colorl3 & 0xFF) / 255.0F;
/* 1756 */             red = h1 * h2; green = h1 * h3; blue = h1 * h4;
/*      */           } 
/*      */ 
/*      */           
/* 1760 */           x = -((Entity)entityPlayer1).field_70159_w * 2.5D + ((((Entity)entityPlayer1).field_70159_w > 0.0D) ? -0.2F : 0.2F);
/* 1761 */           y = (((Entity)entityPlayer).field_70131_O * 0.25F + ((entityPlayer instanceof net.minecraft.client.entity.EntityPlayerSP) ? -1.6F : 0.0F)) - ((Entity)entityPlayer1).field_70181_x * 2.5D + ((((Entity)entityPlayer1).field_70181_x > 0.0D) ? -0.1F : 0.1F);
/* 1762 */           z = -((Entity)entityPlayer1).field_70179_y * 2.5D + ((((Entity)entityPlayer1).field_70179_y > 0.0D) ? -0.2F : 0.2F);
/* 1763 */           EntityCusPar entityCusPar2 = new EntityCusPar("jinryuumodscore:bens_particles.png", this.field_70170_p, 1.0F, 1.0F, ((Entity)entityPlayer1).field_70165_t, ((Entity)entityPlayer1).field_70163_u, ((Entity)entityPlayer1).field_70161_v, x, y, z, 0.0D, -0.02D, 0.0D, 0.0F, 8, 11, 1, 32, false, 0.0F, false, 0.0F, 1, "", 15, 1, 0.06F, 0.001F, -0.003F, 0, red, green, blue, 0.0F, 0.0F, 0.0F, red, green, blue, 1, 0.1F, 0.0F, 0.0F, 0.0F, -0.001F, false, -1, true, null);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1775 */           ((Entity)entityCusPar1).field_70170_p.func_72838_d((Entity)entityCusPar2);
/*      */         } 
/*      */ 
/*      */         
/* 1779 */         if (this.rot) {
/* 1780 */           this.yaw = ((Entity)entityPlayer).field_70177_z;
/* 1781 */           this.pitch = ((Entity)entityPlayer).field_70125_A;
/*      */         } 
/* 1783 */         func_70080_a(((Entity)entityPlayer).field_70165_t, ((Entity)entityPlayer).field_70163_u + ((entityPlayer instanceof net.minecraft.client.entity.EntityPlayerSP) ? -1.6F : 0.0F), ((Entity)entityPlayer).field_70161_v, ((Entity)entityPlayer).field_70177_z, ((Entity)entityPlayer).field_70125_A);
/*      */         
/* 1785 */         if (getAge() < getLightLivingTime() && getState() > 4.0F && getState() < 7.0F && 
/* 1786 */           getAge() == 2) {
/* 1787 */           entityPlayer.func_85030_a("jinryuudragonbc:1610.spark", 0.0375F, 0.85F + this.lightLivingTime * 0.05F);
/*      */         }
/*      */       } else {
/* 1790 */         func_70106_y();
/*      */       } 
/* 1792 */     }  if (this.Age++ >= this.speed)
/* 1793 */       func_70106_y();  }
/*      */   public String getTexL3() { return this.texl3; }
/*      */   public void setTexL3(String s) { this.texl3 = s; }
/*      */   public int getSpd() { return this.speed; }
/* 1797 */   public void setSpd(int s) { this.speed = s; } public boolean getInner() { return this.inner; } public void setInner(boolean s) { this.inner = s; } public void setRendPass(int s) { this.rendpass = s; } public String getmot() { return this.mot; } public void setBol(boolean b) { this.bol = b; } public void setBol2(boolean b) { this.bol2 = b; } public void setBol3(boolean b) { this.bol3 = b; } public void setBol4(boolean b) { this.bol4 = b; } public void setBol4a(boolean b) { this.bol4a = b; } public void setBol6(int b) { this.bol6 = (byte)b; } public void setBol7(boolean b) { this.bol7 = b; } public boolean getBol() { return this.bol; } public boolean getBol2() { return this.bol2; } public boolean getBol3() { return this.bol3; } public boolean getBol4() { return this.bol4; } public boolean getBol4a() { return this.bol4a; } public byte getBol6() { return this.bol6; } public boolean getBol7() { return this.bol7; } public boolean getCanSpawnHere() { return !this.field_70170_p.func_72855_b(this.field_70121_D); }
/*      */   
/*      */   public void onLivingUpdate() {}
/*      */   protected void func_70037_a(NBTTagCompound var1) {}
/*      */   protected void func_70014_b(NBTTagCompound var1) {}
/*      */   protected void func_70088_a() {}
/*      */   public boolean func_70112_a(double par1) {
/* 1804 */     if (JGConfigClientSettings.renderdistanceMultiplierAuras == 10000) return true; 
/* 1805 */     double d1 = this.field_70121_D.func_72320_b();
/* 1806 */     d1 *= 64.0D * this.field_70155_l;
/* 1807 */     return (par1 < d1 * d1 * JGConfigClientSettings.renderdistanceMultiplierAuras / 100.0D);
/*      */   }
/*      */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\EntityAura2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */