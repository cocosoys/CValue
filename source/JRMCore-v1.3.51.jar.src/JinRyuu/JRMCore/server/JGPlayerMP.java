/*     */ package JinRyuu.JRMCore.server;
/*     */ 
/*     */ import JinRyuu.JRMCore.JRMCoreH;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class JGPlayerMP
/*     */ {
/*     */   public EntityPlayer player;
/*     */   private NBTTagCompound nbt;
/*     */   
/*     */   public JGPlayerMP(EntityPlayer player) {
/*  22 */     this.player = player;
/*     */   }
/*     */   
/*     */   public JGPlayerMP(EntityPlayerMP player) {
/*  26 */     this.player = (EntityPlayer)player;
/*     */   }
/*     */   
/*  29 */   public NBTTagCompound getNBT() { return this.nbt; } public void setNBT(NBTTagCompound nbt) {
/*  30 */     this.nbt = nbt;
/*     */   } public NBTTagCompound connectBaseNBT() {
/*  32 */     return this.nbt = JRMCoreH.nbt((Entity)this.player, "pres");
/*     */   }
/*  34 */   public int[] getAttributes() { return JRMCoreH.PlyrAttrbts(this.player); }
/*  35 */   public String[] getSkills() { return JRMCoreH.PlyrSkills(this.player); }
/*  36 */   public String getSkillsX() { return this.nbt.func_74779_i("jrmcSSltX"); } public String getSkillsY() {
/*  37 */     return this.nbt.func_74779_i("jrmcSSltY");
/*     */   }
/*  39 */   public int getLevel(int[] playerAttributes) { return JRMCoreH.getPlayerLevel(playerAttributes); }
/*  40 */   public byte getRace() { return this.nbt.func_74771_c("jrmcRace"); }
/*  41 */   public byte getClassID() { return this.nbt.func_74771_c("jrmcClass"); }
/*  42 */   public byte getPowerType() { return this.nbt.func_74771_c("jrmcPwrtyp"); } public int getAlignment() {
/*  43 */     return this.nbt.func_74771_c("jrmcAlign");
/*     */   }
/*  45 */   public byte getState() { return this.nbt.func_74771_c("jrmcState"); } public void setState(int value) {
/*  46 */     this.nbt.func_74774_a("jrmcState", (byte)value);
/*     */   }
/*  48 */   public byte getState2() { return this.nbt.func_74771_c("jrmcState2"); } public void setState2(int value) {
/*  49 */     this.nbt.func_74774_a("jrmcState2", (byte)value);
/*     */   }
/*  51 */   public byte getRelease() { return this.nbt.func_74771_c("jrmcRelease"); } public void setRelease(int value) {
/*  52 */     this.nbt.func_74774_a("jrmcRelease", (byte)value);
/*     */   }
/*     */   public int getReserve() {
/*  55 */     return this.nbt.func_74762_e("jrmcArcRsrv");
/*     */   } public void setReserve(int value) {
/*  57 */     this.nbt.func_74768_a("jrmcArcRsrv", value);
/*     */   }
/*  59 */   public String getAbsorption() { return this.nbt.func_74779_i("jrmcMajinAbsorptionData"); } public void setAbsorption(String value) {
/*  60 */     this.nbt.func_74778_a("jrmcMajinAbsorptionData", value);
/*     */   }
/*  62 */   public int getTransformationMeter() { return this.nbt.func_74771_c("jrmcSaiRg"); } public void setTransformationMeter(int value) {
/*  63 */     this.nbt.func_74774_a("jrmcSaiRg", (byte)value);
/*     */   }
/*     */   public void setStateAndTransformationMeter(int valueSt, int valueTr) {
/*  66 */     setState(valueSt);
/*  67 */     setTransformationMeter(valueTr);
/*     */   }
/*     */   
/*     */   public int getStat(byte race, byte classID, int attributeID, int stat, byte powerType, int attribute) {
/*  71 */     return getStat(race, classID, attributeID, stat, powerType, attribute, 0.0F);
/*     */   }
/*     */   
/*  74 */   public String getStatusEffects() { return this.nbt.func_74779_i("jrmcStatusEff"); }
/*  75 */   public boolean hasStatusEffect(int statusEffectID, String statusEffects) { return JRMCoreH.StusEfcts(statusEffectID, statusEffects); } public String getPlayerSettings() {
/*  76 */     return this.nbt.func_74779_i("jrmcSettings");
/*     */   }
/*     */   public int getStat(byte race, byte classID, int attributeID, int stat, byte powerType, int[] playerAttributes) {
/*  79 */     return getStat(race, classID, attributeID, stat, powerType, playerAttributes[attributeID], 0.0F);
/*     */   }
/*     */   public int getStat(byte race, byte classID, int attributeID, int stat, byte powerType, int[] playerAttributes, float skillBonus) {
/*  82 */     return getStat(race, classID, attributeID, stat, powerType, playerAttributes[attributeID], skillBonus);
/*     */   }
/*     */   public int getStat(byte race, byte classID, int attributeID, int stat, byte powerType, int attribute, float skillBonus) {
/*  85 */     return JRMCoreH.stat((Entity)this.player, attributeID, powerType, stat, attribute, race, classID, skillBonus);
/*     */   }
/*     */   public int getHealth() {
/*  88 */     return JRMCoreH.getInt(this.player, "jrmcBdy");
/*     */   } public int getHealthMax(byte race, byte classID, byte powerType, int[] playerAttributes) {
/*  90 */     return getStat(race, classID, 2, 2, powerType, playerAttributes);
/*     */   }
/*     */   public int getHealthRegen(byte race, byte classID, byte powerType) {
/*  93 */     return getStat(race, classID, -1, 8, powerType, 100);
/*     */   }
/*     */   public int getEnergy() {
/*  96 */     return JRMCoreH.getInt(this.player, "jrmcEnrgy");
/*     */   } public int getEnergyMax(byte race, byte classID, byte powerType, int[] playerAttributes, float skillBonus) {
/*  98 */     return getStat(race, classID, 5, 5, powerType, playerAttributes, skillBonus);
/*     */   }
/*     */   public int getEnergyRegen(byte race, byte classID, byte powerType) {
/* 101 */     return getStat(race, classID, -1, 10, powerType, 100);
/*     */   }
/*     */   public int getStamina() {
/* 104 */     return JRMCoreH.getInt(this.player, "jrmcStamina");
/*     */   } public int getStaminaMax(byte race, byte classID, byte powerType, int[] playerAttributes) {
/* 106 */     return getStat(race, classID, 2, 3, powerType, playerAttributes);
/*     */   }
/*     */   public int getStaminaRegen(byte race, byte classID, byte powerType) {
/* 109 */     return getStat(race, classID, -1, 9, powerType, 100);
/*     */   }
/*     */   
/*     */   public int getEnergyPower() {
/* 113 */     return getEnergyPower(getRace(), getClassID(), getPowerType());
/*     */   }
/*     */   public int getEnergyPower(byte race, byte classID, byte powerType) {
/* 116 */     return getStat(race, classID, 3, 4, powerType, getAttribute(3), 0.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getAttribute(int attributeID) {
/* 122 */     int powerType = getPowerType();
/* 123 */     int race = getRace();
/* 124 */     int state = getState();
/* 125 */     int state2 = getState2();
/* 126 */     int classID = getClassID();
/* 127 */     byte release = getRelease();
/* 128 */     int reserve = getReserve();
/* 129 */     String absorption = getAbsorption();
/*     */     
/* 131 */     int[] attributes = getAttributes();
/* 132 */     String skillsX = getSkillsX();
/* 133 */     String[] skills = getSkills();
/*     */     
/* 135 */     String statusEffects = getStatusEffects();
/* 136 */     boolean hasLegendary = hasStatusEffect(14, statusEffects);
/* 137 */     boolean hasMajin = hasStatusEffect(12, statusEffects);
/* 138 */     boolean hasKaioken = hasStatusEffect(5, statusEffects);
/* 139 */     boolean hasMystic = hasStatusEffect(13, statusEffects);
/* 140 */     boolean hasUltraInstinct = hasStatusEffect(19, statusEffects);
/* 141 */     boolean hasGodOfDestruction = hasStatusEffect(20, statusEffects);
/* 142 */     boolean hasFusion = (hasStatusEffect(10, statusEffects) || hasStatusEffect(11, statusEffects));
/*     */     
/* 144 */     return JRMCoreH.getPlayerAttribute(this.player, attributes, attributeID, state, state2, race, skillsX, release, reserve, hasLegendary, hasMajin, hasKaioken, hasMystic, hasUltraInstinct, hasGodOfDestruction, powerType, skills, hasFusion, absorption);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\server\JGPlayerMP.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */