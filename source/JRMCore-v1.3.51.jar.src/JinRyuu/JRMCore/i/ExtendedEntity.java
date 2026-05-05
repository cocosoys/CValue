/*     */ package JinRyuu.JRMCore.i;
/*     */ 
/*     */ import JinRyuu.JRMCore.JRMCoreHSAC;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.attributes.AttributeModifier;
/*     */ import net.minecraft.entity.monster.EntityMob;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.IExtendedEntityProperties;
/*     */ 
/*     */ public class ExtendedEntity
/*     */   implements IExtendedEntityProperties {
/*     */   public static final String EXT_PROP_NAME = "JRMCEE";
/*     */   private final Entity e;
/*  17 */   private int saga = -1;
/*  18 */   private int side = -1;
/*  19 */   private int cb5 = 100;
/*     */ 
/*     */ 
/*     */   
/*     */   private int Level;
/*     */ 
/*     */   
/*     */   private int Dam;
/*     */ 
/*     */   
/*     */   public static final int LVL = 20;
/*     */ 
/*     */   
/*     */   public static final int DAM = 19;
/*     */ 
/*     */   
/*     */   private int timer;
/*     */ 
/*     */   
/*     */   private int hairCheckDim;
/*     */ 
/*     */ 
/*     */   
/*     */   public static final void register(Entity player) {
/*  43 */     player.registerExtendedProperties("JRMCEE", new ExtendedEntity(player));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final ExtendedEntity get(Entity player) {
/*  50 */     return (ExtendedEntity)player.getExtendedProperties("JRMCEE");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void copy(ExtendedEntity props) {
/*  59 */     this.Level = props.Level;
/*  60 */     this.Dam = props.Dam;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void saveNBTData(NBTTagCompound compound) {
/*  70 */     NBTTagCompound properties = new NBTTagCompound();
/*     */ 
/*     */     
/*  73 */     properties.func_74768_a("level", this.e.func_70096_w().func_75679_c(20));
/*  74 */     properties.func_74768_a("dam", this.e.func_70096_w().func_75679_c(19));
/*     */ 
/*     */     
/*  77 */     compound.func_74782_a("JRMCEE", (NBTBase)properties);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void loadNBTData(NBTTagCompound compound) {
/*  84 */     NBTTagCompound properties = (NBTTagCompound)compound.func_74781_a("JRMCEE");
/*  85 */     if (properties != null) {
/*  86 */       this.e.func_70096_w().func_75692_b(20, Integer.valueOf(properties.func_74762_e("level")));
/*  87 */       this.e.func_70096_w().func_75692_b(19, Integer.valueOf(properties.func_74762_e("dam")));
/*     */     } 
/*     */   }
/*     */   
/*     */   public void init(Entity entity, World world) {}
/*     */   
/*     */   public ExtendedEntity(Entity e) {
/*  94 */     this.timer = 100;
/*  95 */     this.hairCheckDim = -1;
/*     */     this.e = e;
/*     */     this.Level = 0;
/*     */     this.Dam = 3;
/*     */     this.e.func_70096_w().func_75682_a(20, Integer.valueOf(this.Level));
/*     */     this.e.func_70096_w().func_75682_a(19, Integer.valueOf(this.Dam));
/*     */   } public void onUpdate() {
/* 102 */     if (!this.e.field_70170_p.field_72995_K)
/*     */     {
/*     */ 
/*     */ 
/*     */       
/* 107 */       if (getLvl() == 0 && this.e instanceof EntityMob) {
/* 108 */         EntityMob mob = (EntityMob)this.e;
/* 109 */         int lvl = JRMCoreHSAC.SAO_getLvlBasedOnDrop((Entity)mob);
/*     */         
/* 111 */         int newHealth = (int)(mob.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111125_b() * lvl * 1.0D);
/* 112 */         AttributeModifier modifier = new AttributeModifier(mob.func_110124_au(), "maxHealthModifier", newHealth, 0);
/* 113 */         if (modifier != null)
/*     */         {
/* 115 */           mob.func_110140_aT().func_111151_a(SharedMonsterAttributes.field_111267_a).func_111121_a(modifier);
/*     */         }
/* 117 */         int newDamage = (int)(mob.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111125_b() * lvl * 5.0D);
/* 118 */         modifier = new AttributeModifier(mob.func_110124_au(), "attackDamageModifier", newDamage, 0);
/* 119 */         if (modifier != null)
/*     */         {
/* 121 */           mob.func_110140_aT().func_111151_a(SharedMonsterAttributes.field_111264_e).func_111121_a(modifier);
/*     */         }
/*     */         
/* 124 */         mob.func_70606_j(mob.func_110138_aP());
/*     */         
/* 126 */         setDam((int)mob.func_110140_aT().func_111151_a(SharedMonsterAttributes.field_111264_e).func_111126_e());
/*     */ 
/*     */         
/* 129 */         setLvl(lvl);
/*     */       } 
/*     */     }
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
/*     */   public final int getDam() {
/* 178 */     return this.e.func_70096_w().func_75679_c(19);
/*     */   }
/*     */   public final int getLvl() {
/* 181 */     return this.e.func_70096_w().func_75679_c(20);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void setDam(int amount) {
/* 191 */     this.e.func_70096_w().func_75692_b(19, Integer.valueOf(amount));
/*     */   }
/*     */   public final void setLvl(int amount) {
/* 194 */     this.e.func_70096_w().func_75692_b(20, Integer.valueOf(amount));
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\i\ExtendedEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */