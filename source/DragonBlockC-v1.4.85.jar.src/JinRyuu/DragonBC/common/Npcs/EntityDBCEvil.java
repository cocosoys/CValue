/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ public class EntityDBCEvil extends EntityDBC implements IEntityAdditionalSpawnData { private Entity spwner; protected Entity target;
/*     */   private int noSpwnr;
/*     */   
/*     */   protected NBTTagCompound nbt(EntityPlayer p, String s) {
/*     */     NBTTagCompound nbt;
/*     */     if (s.contains("pres")) {
/*     */       if (!p.getEntityData().func_74764_b("PlayerPersisted")) {
/*     */         nbt = new NBTTagCompound();
/*     */         p.getEntityData().func_74782_a("PlayerPersisted", (NBTBase)nbt);
/*     */       } else {
/*     */         nbt = p.getEntityData().func_74775_l("PlayerPersisted");
/*     */       } 
/*     */     } else {
/*     */       nbt = p.getEntityData();
/*     */     } 
/*     */     return nbt;
/*     */   }
/*     */   
/*     */   public void setSpwner(Entity e) {
/*     */     this.spwner = e;
/*     */   }
/*     */   
/*  24 */   public EntityDBCEvil(World par1World) { super(par1World);
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
/*  40 */     this.spwner = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  47 */     this.target = null;
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
/*  71 */     this.noSpwnr = DBCConfig.mdat; }
/*     */   public Entity getSpwner() { return this.spwner; }
/*     */   public void settarget(Entity e) { this.target = e; } public void func_70071_h_() {
/*  74 */     if (!(this instanceof EntitySaiyan01) && !(this instanceof EntitySaiyan02)) {
/*  75 */       double r = DBCConfig.mdal;
/*  76 */       if (this.spwner != null && r != 0.0D) {
/*  77 */         AxisAlignedBB aabb = AxisAlignedBB.func_72330_a(this.field_70165_t - r, this.field_70163_u - r, this.field_70161_v - r, this.field_70165_t + r, this.field_70163_u + r, this.field_70161_v + r);
/*  78 */         List<EntityPlayer> list = this.field_70170_p.func_72872_a(EntityPlayer.class, aabb);
/*  79 */         boolean b = false;
/*  80 */         int j = 0;
/*  81 */         int sgid = JRMCoreH.getInt((EntityPlayer)this.spwner, "JRMCGID");
/*  82 */         for (int i = 0; i < list.size(); i++) {
/*  83 */           EntityPlayer entity2 = list.get(i);
/*  84 */           int ogid = JRMCoreH.getInt(entity2, "JRMCGID");
/*  85 */           if (this.spwner.func_145782_y() == entity2.func_145782_y() || (sgid != 0 && sgid == ogid)) {
/*  86 */             j++;
/*     */           }
/*     */         } 
/*  89 */         if (func_145782_y() == this.spwner.func_145782_y()) {
/*  90 */           j++;
/*     */         }
/*  92 */         if (j == 0) {
/*  93 */           this.noSpwnr--;
/*  94 */           if (this.noSpwnr <= 0) {
/*  95 */             func_70106_y();
/*     */           }
/*  97 */         } else if (this.noSpwnr != DBCConfig.mdat) {
/*  98 */           this.noSpwnr = DBCConfig.mdat;
/*     */         } 
/*     */       } 
/* 101 */       if (!this.field_70170_p.field_72995_K && this.spwner == null) {
/* 102 */         func_70106_y();
/*     */       }
/*     */     } 
/* 105 */     super.func_70071_h_(); } public Entity gettarget() { return this.target; } public void setETA(Entity par1Entity) { this.field_70789_a = par1Entity; } protected Entity func_70782_k() {
/*     */     return (this.target != null) ? this.target : super.func_70782_k();
/*     */   }
/*     */   public void func_70645_a(DamageSource par1DamageSource) {
/*     */     Entity var3 = par1DamageSource.func_76346_g();
/*     */     super.func_70645_a(par1DamageSource);
/*     */   }
/*     */   public boolean func_70097_a(DamageSource par1DamageSource, float par2) {
/* 113 */     if (!super.func_70097_a(par1DamageSource, par2))
/*     */     {
/* 115 */       return false;
/*     */     }
/* 117 */     if (this.spwner != null) {
/* 118 */       MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
/* 119 */       EntityPlayer spwnr = (EntityPlayer)this.spwner;
/* 120 */       Entity atckr = par1DamageSource.func_76346_g();
/* 121 */       if (atckr instanceof EntityPlayer) {
/* 122 */         int sgid = JRMCoreH.getInt(spwnr, "JRMCGID");
/*     */         
/* 124 */         if (sgid != 0) {
/* 125 */           func_70784_b(atckr);
/* 126 */           settarget(atckr);
/* 127 */           EntityLivingBase entityLivingBase = func_70638_az();
/* 128 */           if (entityLivingBase == null && func_70777_m() instanceof EntityLivingBase)
/* 129 */             entityLivingBase = (EntityLivingBase)func_70777_m(); 
/* 130 */           if (entityLivingBase == null && par1DamageSource.func_76346_g() instanceof EntityLivingBase)
/* 131 */             entityLivingBase = (EntityLivingBase)par1DamageSource.func_76346_g(); 
/* 132 */           return true;
/*     */         } 
/* 134 */         if (spwnr.func_145782_y() == atckr.func_145782_y()) {
/* 135 */           func_70784_b(atckr);
/* 136 */           settarget(atckr);
/* 137 */           EntityLivingBase entityLivingBase = func_70638_az();
/* 138 */           if (entityLivingBase == null && func_70777_m() instanceof EntityLivingBase)
/* 139 */             entityLivingBase = (EntityLivingBase)func_70777_m(); 
/* 140 */           if (entityLivingBase == null && par1DamageSource.func_76346_g() instanceof EntityLivingBase)
/* 141 */             entityLivingBase = (EntityLivingBase)par1DamageSource.func_76346_g(); 
/* 142 */           return true;
/*     */         } 
/* 144 */         return false;
/*     */       } 
/*     */       
/* 147 */       return false;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 152 */     EntityLivingBase entitylivingbase = func_70638_az();
/*     */     
/* 154 */     if (entitylivingbase == null && func_70777_m() instanceof EntityLivingBase)
/*     */     {
/* 156 */       entitylivingbase = (EntityLivingBase)func_70777_m();
/*     */     }
/*     */     
/* 159 */     if (entitylivingbase == null && par1DamageSource.func_76346_g() instanceof EntityLivingBase)
/*     */     {
/* 161 */       entitylivingbase = (EntityLivingBase)par1DamageSource.func_76346_g();
/*     */     }
/*     */     
/* 164 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeSpawnData(ByteBuf data) {
/* 171 */     data.writeInt((this.spwner == null) ? 0 : this.spwner.func_145782_y());
/* 172 */     data.writeInt((this.target == null) ? 0 : this.target.func_145782_y());
/* 173 */     data.writeInt((this.field_70789_a == null) ? 0 : this.field_70789_a.func_145782_y());
/*     */   }
/*     */ 
/*     */   
/*     */   public void readSpawnData(ByteBuf data) {
/* 178 */     int e1 = data.readInt();
/* 179 */     int e2 = data.readInt();
/* 180 */     int e3 = data.readInt();
/* 181 */     this.spwner = (e1 == 0) ? this.spwner : this.field_70170_p.func_73045_a(e1);
/* 182 */     this.target = (e2 == 0) ? this.target : this.field_70170_p.func_73045_a(e2);
/* 183 */     this.field_70789_a = (e3 == 0) ? this.field_70789_a : this.field_70170_p.func_73045_a(e3);
/*     */   } }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\EntityDBCEvil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */