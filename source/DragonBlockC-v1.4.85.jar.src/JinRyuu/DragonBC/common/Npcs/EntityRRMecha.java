/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import JinRyuu.DragonBC.common.DBCConfig;
/*     */ import JinRyuu.DragonBC.common.Items.ItemsDBC;
/*     */ import JinRyuu.JRMCore.entity.EntityPrjtls_1;
/*     */ import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import io.netty.buffer.ByteBuf;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.monster.IMob;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class EntityRRMecha
/*     */   extends EntityDBCWildlifeA implements IMob, IEntityAdditionalSpawnData {
/*  19 */   public final int AttPow = 20;
/*  20 */   public final int HePo = 200; private byte type;
/*     */   public int getType() {
/*  22 */     return this.type;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70069_a(float f) {}
/*     */   
/*     */   public EntityRRMecha(World par1World) {
/*  29 */     super(par1World);
/*  30 */     float[] sizes = { 0.0F, 0.5F, 1.0F };
/*  31 */     this.field_70728_aV = 50;
/*     */     
/*  33 */     this.type = (byte)(int)(Math.random() * 3.0D);
/*  34 */     func_70105_a(3.0F * (sizes[this.type] + 1.0F), 4.0F * (sizes[this.type] + 1.0F));
/*     */     
/*  36 */     int dam = (this.type == 0) ? DBCConfig.NPC_RRMech1_Dam : ((this.type == 1) ? DBCConfig.NPC_RRMech2_Dam : DBCConfig.NPC_RRMech3_Dam);
/*  37 */     int hp = (this.type == 0) ? DBCConfig.NPC_RRMech1_HP : ((this.type == 1) ? DBCConfig.NPC_RRMech2_HP : DBCConfig.NPC_RRMech3_HP);
/*     */     
/*  39 */     if (dam != 20 || hp != 200) {
/*  40 */       getEntityData().func_74780_a("jrmcSpawnInitiatedCAT", dam);
/*  41 */       getEntityData().func_74780_a("jrmcSpawnInitiatedCHP", hp);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void func_110147_ax() {
/*  46 */     super.func_110147_ax();
/*  47 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(200.0D);
/*  48 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(20.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70071_h_() {
/*  53 */     super.func_70071_h_();
/*  54 */     float range = (25 * (this.type + 1));
/*     */ 
/*     */ 
/*     */     
/*  58 */     if (!this.field_70170_p.field_72995_K && this.field_70789_a != null && this.field_70789_a.func_70089_S() && this.field_70789_a.func_70032_d((Entity)this) < range)
/*     */     {
/*     */ 
/*     */       
/*  62 */       if (this.type == 0) {
/*     */         
/*  64 */         if (this.field_70173_aa % 100 < 31 && this.field_70173_aa % 15 == 0)
/*     */         {
/*  66 */           EntityPrjtls_1 var8 = new EntityPrjtls_1(this.field_70170_p, (Entity)this, this.field_70789_a, 1.8F, 1.0F, 0);
/*  67 */           this.field_70170_p.func_72956_a((Entity)this, "jinryuudragonbc:DBC4.rocket_shot", 0.6F, this.field_70170_p.field_73012_v.nextFloat() * 0.1F + 0.9F);
/*  68 */           this.field_70170_p.func_72838_d((Entity)var8);
/*     */         }
/*     */       
/*     */       }
/*  72 */       else if (this.type == 1) {
/*     */         
/*  74 */         if (this.field_70173_aa % 100 == 0)
/*     */         {
/*  76 */           if ((int)(Math.random() * (6 / (this.type + 1))) == 0)
/*     */           {
/*  78 */             EntityPrjtls_1 var8 = new EntityPrjtls_1(this.field_70170_p, (Entity)this, this.field_70789_a, 1.5F, 1.0F, 1);
/*  79 */             this.field_70170_p.func_72956_a((Entity)this, "jinryuudragonbc:DBC4.rocket_shot", 0.6F, this.field_70170_p.field_73012_v.nextFloat() * 0.1F + 0.9F);
/*  80 */             this.field_70170_p.func_72838_d((Entity)var8);
/*     */           }
/*     */         
/*     */         }
/*     */       }
/*  85 */       else if (this.type == 2) {
/*     */         
/*  87 */         if (this.field_70173_aa % 100 == 0)
/*     */         {
/*  89 */           if ((int)(Math.random() * 2.0D) == 0) {
/*     */             
/*  91 */             EntityPrjtls_1 var8 = new EntityPrjtls_1(this.field_70170_p, (Entity)this, this.field_70789_a, 1.8F, 1.0F, 2);
/*  92 */             this.field_70170_p.func_72956_a((Entity)this, "jinryuudragonbc:DBC4.rocket_shot", 0.6F, this.field_70170_p.field_73012_v.nextFloat() * 0.1F + 0.9F);
/*  93 */             this.field_70170_p.func_72838_d((Entity)var8);
/*     */           } 
/*     */         }
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String getTexture() {
/* 102 */     return "jinryuudragonbc:npcs/rrmecha" + this.type + ".png";
/*     */   }
/*     */   public boolean func_70601_bi() {
/* 105 */     return (this.field_70170_p.func_72855_b(this.field_70121_D) && this.field_70170_p.func_72945_a((Entity)this, this.field_70121_D).isEmpty() && !this.field_70170_p.func_72953_d(this.field_70121_D));
/*     */   }
/*     */   protected Entity func_70782_k() {
/* 108 */     return super.func_70782_k();
/*     */   } public void func_70636_d() {
/* 110 */     super.func_70636_d();
/*     */   }
/*     */   protected void func_70628_a(boolean par1, int par2) {
/* 113 */     if (this.type == 2) {
/* 114 */       float[] chance = { 12.0F, 5.0F, 3.0F };
/* 115 */       int drop_chance = (int)(Math.random() * 101.0D);
/* 116 */       if (drop_chance <= chance[2]) { func_145779_a(ItemsDBC.ItemChipTier3, 1); }
/* 117 */       else if (drop_chance <= chance[1]) { func_145779_a(ItemsDBC.ItemChipTier2, 1); }
/* 118 */       else if (drop_chance <= chance[0]) { func_145779_a(ItemsDBC.ItemAlienTechChipTier1, 1); }
/*     */     
/* 120 */     } else if (this.type == 1) {
/* 121 */       float[] chance = { 8.0F, 4.0F };
/* 122 */       int drop_chance = (int)(Math.random() * 101.0D);
/* 123 */       if (drop_chance <= chance[1]) { func_145779_a(ItemsDBC.ItemChipTier2, 1); }
/* 124 */       else if (drop_chance <= chance[0]) { func_145779_a(ItemsDBC.ItemAlienTechChipTier1, 1); }
/*     */ 
/*     */     
/* 127 */     } else if (this.type == 0) {
/* 128 */       float[] chance = { 7.0F };
/* 129 */       int drop_chance = (int)(Math.random() * 101.0D);
/* 130 */       if (drop_chance <= chance[0]) func_145779_a(ItemsDBC.ItemAlienTechChipTier1, 1); 
/*     */     } 
/*     */   }
/*     */   
/* 134 */   public boolean func_70085_c(EntityPlayer par1EntityPlayer) { return false; } protected boolean func_70692_ba() {
/* 135 */     return true;
/*     */   }
/*     */   public void writeSpawnData(ByteBuf additionalData) {
/* 138 */     additionalData.writeByte(this.type);
/*     */   }
/*     */ 
/*     */   
/*     */   public void readSpawnData(ByteBuf additionalData) {
/* 143 */     this.type = additionalData.readByte();
/* 144 */     float[] sizes = { 0.0F, 0.5F, 1.0F };
/* 145 */     func_70105_a(3.0F * (sizes[this.type] + 1.0F), 4.0F * (sizes[this.type] + 1.0F));
/*     */   }
/*     */   
/*     */   public void func_70014_b(NBTTagCompound par1NBTTagCompound) {
/* 149 */     par1NBTTagCompound.func_74774_a("type", this.type);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70037_a(NBTTagCompound par1NBTTagCompound) {
/* 156 */     this.type = (byte)(par1NBTTagCompound.func_74771_c("type") & 0xFF);
/* 157 */     float[] sizes = { 0.0F, 0.5F, 1.0F };
/* 158 */     func_70105_a(3.0F * (sizes[this.type] + 1.0F), 4.0F * (sizes[this.type] + 1.0F));
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\EntityRRMecha.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */