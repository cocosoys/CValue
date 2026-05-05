/*     */ package net.minecraft.entity.item;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.stats.AchievementList;
/*     */ import net.minecraft.stats.StatBase;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.StatCollector;
/*     */ import net.minecraft.world.World;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ 
/*     */ public class EntityItem extends Entity {
/*  21 */   private static final Logger field_145803_d = LogManager.getLogger();
/*     */ 
/*     */   
/*     */   public int field_70292_b;
/*     */ 
/*     */   
/*     */   public int field_145804_b;
/*     */   
/*  29 */   private int field_70291_e = 5;
/*     */   private String field_145801_f;
/*     */   private String field_145802_g;
/*  32 */   public float field_70290_d = (float)(Math.random() * Math.PI * 2.0D); private static final String __OBFID = "CL_00001669";
/*     */   
/*     */   public EntityItem(World p_i1709_1_, double p_i1709_2_, double p_i1709_4_, double p_i1709_6_) {
/*  35 */     super(p_i1709_1_);
/*  36 */     func_70105_a(0.25F, 0.25F);
/*  37 */     this.field_70129_M = this.field_70131_O / 2.0F;
/*  38 */     func_70107_b(p_i1709_2_, p_i1709_4_, p_i1709_6_);
/*     */     
/*  40 */     this.field_70177_z = (float)(Math.random() * 360.0D);
/*     */     
/*  42 */     this.field_70159_w = (float)(Math.random() * 0.20000000298023224D - 0.10000000149011612D);
/*  43 */     this.field_70181_x = 0.20000000298023224D;
/*  44 */     this.field_70179_y = (float)(Math.random() * 0.20000000298023224D - 0.10000000149011612D);
/*     */   }
/*     */   
/*     */   public EntityItem(World p_i1710_1_, double p_i1710_2_, double p_i1710_4_, double p_i1710_6_, ItemStack p_i1710_8_) {
/*  48 */     this(p_i1710_1_, p_i1710_2_, p_i1710_4_, p_i1710_6_);
/*  49 */     func_92058_a(p_i1710_8_);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean func_70041_e_() {
/*  54 */     return false;
/*     */   }
/*     */   
/*     */   public EntityItem(World p_i1711_1_) {
/*  58 */     super(p_i1711_1_);
/*  59 */     func_70105_a(0.25F, 0.25F);
/*  60 */     this.field_70129_M = this.field_70131_O / 2.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70088_a() {
/*  65 */     func_70096_w().func_82709_a(10, 5);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70071_h_() {
/*  70 */     if (func_92059_d() == null) {
/*  71 */       func_70106_y();
/*     */       return;
/*     */     } 
/*  74 */     super.func_70071_h_();
/*  75 */     if (this.field_145804_b > 0) this.field_145804_b--; 
/*  76 */     this.field_70169_q = this.field_70165_t;
/*  77 */     this.field_70167_r = this.field_70163_u;
/*  78 */     this.field_70166_s = this.field_70161_v;
/*     */     
/*  80 */     this.field_70181_x -= 0.03999999910593033D;
/*  81 */     this.field_70145_X = func_145771_j(this.field_70165_t, (this.field_70121_D.field_72338_b + this.field_70121_D.field_72337_e) / 2.0D, this.field_70161_v);
/*  82 */     func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
/*     */     
/*  84 */     boolean bool = ((int)this.field_70169_q != (int)this.field_70165_t || (int)this.field_70167_r != (int)this.field_70163_u || (int)this.field_70166_s != (int)this.field_70161_v) ? true : false;
/*     */     
/*  86 */     if (bool || this.field_70173_aa % 25 == 0) {
/*  87 */       if (this.field_70170_p.func_147439_a(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70163_u), MathHelper.func_76128_c(this.field_70161_v)).func_149688_o() == Material.field_151587_i) {
/*  88 */         this.field_70181_x = 0.20000000298023224D;
/*  89 */         this.field_70159_w = ((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2F);
/*  90 */         this.field_70179_y = ((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.2F);
/*  91 */         func_85030_a("random.fizz", 0.4F, 2.0F + this.field_70146_Z.nextFloat() * 0.4F);
/*     */       } 
/*     */       
/*  94 */       if (!this.field_70170_p.field_72995_K) {
/*  95 */         func_85054_d();
/*     */       }
/*     */     } 
/*     */     
/*  99 */     float f = 0.98F;
/* 100 */     if (this.field_70122_E) {
/* 101 */       f = (this.field_70170_p.func_147439_a(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70121_D.field_72338_b) - 1, MathHelper.func_76128_c(this.field_70161_v))).field_149765_K * 0.98F;
/*     */     }
/*     */     
/* 104 */     this.field_70159_w *= f;
/* 105 */     this.field_70181_x *= 0.9800000190734863D;
/* 106 */     this.field_70179_y *= f;
/*     */     
/* 108 */     if (this.field_70122_E) {
/* 109 */       this.field_70181_x *= -0.5D;
/*     */     }
/*     */     
/* 112 */     this.field_70292_b++;
/* 113 */     if (!this.field_70170_p.field_72995_K && this.field_70292_b >= 6000) {
/* 114 */       func_70106_y();
/*     */     }
/*     */   }
/*     */   
/*     */   private void func_85054_d() {
/* 119 */     for (EntityItem entityItem : this.field_70170_p.func_72872_a(EntityItem.class, this.field_70121_D.func_72314_b(0.5D, 0.0D, 0.5D))) {
/* 120 */       func_70289_a(entityItem);
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean func_70289_a(EntityItem p_70289_1_) {
/* 125 */     if (p_70289_1_ == this) return false; 
/* 126 */     if (!p_70289_1_.func_70089_S() || !func_70089_S()) return false; 
/* 127 */     ItemStack itemStack1 = func_92059_d();
/* 128 */     ItemStack itemStack2 = p_70289_1_.func_92059_d();
/*     */     
/* 130 */     if (itemStack2.func_77973_b() != itemStack1.func_77973_b()) return false; 
/* 131 */     if ((itemStack2.func_77942_o() ^ itemStack1.func_77942_o()) != 0) return false; 
/* 132 */     if (itemStack2.func_77942_o() && !itemStack2.func_77978_p().equals(itemStack1.func_77978_p())) return false; 
/* 133 */     if (itemStack2.func_77973_b() == null) return false; 
/* 134 */     if (itemStack2.func_77973_b().func_77614_k() && itemStack2.func_77960_j() != itemStack1.func_77960_j()) return false; 
/* 135 */     if (itemStack2.field_77994_a < itemStack1.field_77994_a) return p_70289_1_.func_70289_a(this); 
/* 136 */     if (itemStack2.field_77994_a + itemStack1.field_77994_a > itemStack2.func_77976_d()) return false;
/*     */     
/* 138 */     itemStack2.field_77994_a += itemStack1.field_77994_a;
/* 139 */     p_70289_1_.field_145804_b = Math.max(p_70289_1_.field_145804_b, this.field_145804_b);
/* 140 */     p_70289_1_.field_70292_b = Math.min(p_70289_1_.field_70292_b, this.field_70292_b);
/* 141 */     p_70289_1_.func_92058_a(itemStack2);
/* 142 */     func_70106_y();
/*     */     
/* 144 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70288_d() {
/* 149 */     this.field_70292_b = 4800;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70072_I() {
/* 154 */     return this.field_70170_p.func_72918_a(this.field_70121_D, Material.field_151586_h, this);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70081_e(int p_70081_1_) {
/* 159 */     func_70097_a(DamageSource.field_76372_a, p_70081_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70097_a(DamageSource p_70097_1_, float p_70097_2_) {
/* 164 */     if (func_85032_ar()) return false; 
/* 165 */     if (func_92059_d() != null && func_92059_d().func_77973_b() == Items.field_151156_bN && p_70097_1_.func_94541_c()) return false; 
/* 166 */     func_70018_K();
/* 167 */     this.field_70291_e = (int)(this.field_70291_e - p_70097_2_);
/* 168 */     if (this.field_70291_e <= 0) {
/* 169 */       func_70106_y();
/*     */     }
/* 171 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70014_b(NBTTagCompound p_70014_1_) {
/* 176 */     p_70014_1_.func_74777_a("Health", (short)(byte)this.field_70291_e);
/* 177 */     p_70014_1_.func_74777_a("Age", (short)this.field_70292_b);
/* 178 */     if (func_145800_j() != null) p_70014_1_.func_74778_a("Thrower", this.field_145801_f); 
/* 179 */     if (func_145798_i() != null) p_70014_1_.func_74778_a("Owner", this.field_145802_g); 
/* 180 */     if (func_92059_d() != null) p_70014_1_.func_74782_a("Item", (NBTBase)func_92059_d().func_77955_b(new NBTTagCompound()));
/*     */   
/*     */   }
/*     */   
/*     */   public void func_70037_a(NBTTagCompound p_70037_1_) {
/* 185 */     this.field_70291_e = p_70037_1_.func_74765_d("Health") & 0xFF;
/* 186 */     this.field_70292_b = p_70037_1_.func_74765_d("Age");
/* 187 */     if (p_70037_1_.func_74764_b("Owner")) this.field_145802_g = p_70037_1_.func_74779_i("Owner"); 
/* 188 */     if (p_70037_1_.func_74764_b("Thrower")) this.field_145801_f = p_70037_1_.func_74779_i("Thrower"); 
/* 189 */     NBTTagCompound nBTTagCompound = p_70037_1_.func_74775_l("Item");
/* 190 */     func_92058_a(ItemStack.func_77949_a(nBTTagCompound));
/* 191 */     if (func_92059_d() == null) func_70106_y();
/*     */   
/*     */   }
/*     */   
/*     */   public void func_70100_b_(EntityPlayer p_70100_1_) {
/* 196 */     if (this.field_70170_p.field_72995_K)
/*     */       return; 
/* 198 */     ItemStack itemStack = func_92059_d();
/* 199 */     int i = itemStack.field_77994_a;
/* 200 */     if (this.field_145804_b == 0 && (this.field_145802_g == null || 6000 - this.field_70292_b <= 200 || this.field_145802_g.equals(p_70100_1_.func_70005_c_())) && p_70100_1_.field_71071_by.func_70441_a(itemStack)) {
/* 201 */       if (itemStack.func_77973_b() == Item.func_150898_a(Blocks.field_150364_r)) p_70100_1_.func_71029_a((StatBase)AchievementList.field_76005_g); 
/* 202 */       if (itemStack.func_77973_b() == Item.func_150898_a(Blocks.field_150363_s)) p_70100_1_.func_71029_a((StatBase)AchievementList.field_76005_g); 
/* 203 */       if (itemStack.func_77973_b() == Items.field_151116_aA) p_70100_1_.func_71029_a((StatBase)AchievementList.field_76022_t); 
/* 204 */       if (itemStack.func_77973_b() == Items.field_151045_i) p_70100_1_.func_71029_a((StatBase)AchievementList.field_76019_w); 
/* 205 */       if (itemStack.func_77973_b() == Items.field_151072_bj) p_70100_1_.func_71029_a((StatBase)AchievementList.field_76027_z); 
/* 206 */       if (itemStack.func_77973_b() == Items.field_151045_i && func_145800_j() != null) {
/* 207 */         EntityPlayer entityPlayer = this.field_70170_p.func_72924_a(func_145800_j());
/* 208 */         if (entityPlayer != null && entityPlayer != p_70100_1_) {
/* 209 */           entityPlayer.func_71029_a((StatBase)AchievementList.field_150966_x);
/*     */         }
/*     */       } 
/* 212 */       this.field_70170_p.func_72956_a((Entity)p_70100_1_, "random.pop", 0.2F, ((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.7F + 1.0F) * 2.0F);
/* 213 */       p_70100_1_.func_71001_a(this, i);
/* 214 */       if (itemStack.field_77994_a <= 0) func_70106_y();
/*     */     
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String func_70005_c_() {
/* 221 */     return StatCollector.func_74838_a("item." + func_92059_d().func_77977_a());
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70075_an() {
/* 226 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_71027_c(int p_71027_1_) {
/* 231 */     super.func_71027_c(p_71027_1_);
/*     */     
/* 233 */     if (!this.field_70170_p.field_72995_K) func_85054_d(); 
/*     */   }
/*     */   
/*     */   public ItemStack func_92059_d() {
/* 237 */     ItemStack itemStack = func_70096_w().func_82710_f(10);
/*     */     
/* 239 */     if (itemStack == null) {
/* 240 */       return new ItemStack(Blocks.field_150348_b);
/*     */     }
/*     */     
/* 243 */     return itemStack;
/*     */   }
/*     */   
/*     */   public void func_92058_a(ItemStack p_92058_1_) {
/* 247 */     func_70096_w().func_75692_b(10, p_92058_1_);
/* 248 */     func_70096_w().func_82708_h(10);
/*     */   }
/*     */   
/*     */   public String func_145798_i() {
/* 252 */     return this.field_145802_g;
/*     */   }
/*     */   
/*     */   public void func_145797_a(String p_145797_1_) {
/* 256 */     this.field_145802_g = p_145797_1_;
/*     */   }
/*     */   
/*     */   public String func_145800_j() {
/* 260 */     return this.field_145801_f;
/*     */   }
/*     */   
/*     */   public void func_145799_b(String p_145799_1_) {
/* 264 */     this.field_145801_f = p_145799_1_;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\item\EntityItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */