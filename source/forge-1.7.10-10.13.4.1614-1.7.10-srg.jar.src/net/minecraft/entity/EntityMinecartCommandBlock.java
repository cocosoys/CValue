/*     */ package net.minecraft.entity;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import io.netty.buffer.ByteBuf;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.command.server.CommandBlockLogic;
/*     */ import net.minecraft.entity.item.EntityMinecart;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.ChunkCoordinates;
/*     */ import net.minecraft.util.IChatComponent;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EntityMinecartCommandBlock
/*     */   extends EntityMinecart
/*     */ {
/*  22 */   private final CommandBlockLogic field_145824_a = new CommandBlockLogic(this)
/*     */     {
/*     */       public void func_145756_e() {
/*  25 */         this.field_145768_a.func_70096_w().func_75692_b(23, func_145753_i());
/*  26 */         this.field_145768_a.func_70096_w().func_75692_b(24, IChatComponent.Serializer.func_150696_a(func_145749_h()));
/*     */       }
/*     */       private static final String __OBFID = "CL_00001673";
/*     */       @SideOnly(Side.CLIENT)
/*     */       public int func_145751_f() {
/*  31 */         return 1;
/*     */       }
/*     */       
/*     */       @SideOnly(Side.CLIENT)
/*     */       public void func_145757_a(ByteBuf p_145757_1_) {
/*  36 */         p_145757_1_.writeInt(this.field_145768_a.func_145782_y());
/*     */       }
/*     */ 
/*     */       
/*     */       public ChunkCoordinates func_82114_b() {
/*  41 */         return new ChunkCoordinates(MathHelper.func_76128_c(this.field_145768_a.field_70165_t), MathHelper.func_76128_c(this.field_145768_a.field_70163_u + 0.5D), MathHelper.func_76128_c(this.field_145768_a.field_70161_v));
/*     */       }
/*     */ 
/*     */       
/*     */       public World func_130014_f_() {
/*  46 */         return this.field_145768_a.field_70170_p;
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*  51 */   private int field_145823_b = 0; private static final String __OBFID = "CL_00001672";
/*     */   
/*     */   public EntityMinecartCommandBlock(World p_i45321_1_) {
/*  54 */     super(p_i45321_1_);
/*     */   }
/*     */   
/*     */   public EntityMinecartCommandBlock(World p_i45322_1_, double p_i45322_2_, double p_i45322_4_, double p_i45322_6_) {
/*  58 */     super(p_i45322_1_, p_i45322_2_, p_i45322_4_, p_i45322_6_);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70088_a() {
/*  63 */     super.func_70088_a();
/*  64 */     func_70096_w().func_75682_a(23, "");
/*  65 */     func_70096_w().func_75682_a(24, "");
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70037_a(NBTTagCompound p_70037_1_) {
/*  70 */     super.func_70037_a(p_70037_1_);
/*  71 */     this.field_145824_a.func_145759_b(p_70037_1_);
/*  72 */     func_70096_w().func_75692_b(23, func_145822_e().func_145753_i());
/*  73 */     func_70096_w().func_75692_b(24, IChatComponent.Serializer.func_150696_a(func_145822_e().func_145749_h()));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70014_b(NBTTagCompound p_70014_1_) {
/*  78 */     super.func_70014_b(p_70014_1_);
/*  79 */     this.field_145824_a.func_145758_a(p_70014_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_94087_l() {
/*  84 */     return 6;
/*     */   }
/*     */ 
/*     */   
/*     */   public Block func_145817_o() {
/*  89 */     return Blocks.field_150483_bI;
/*     */   }
/*     */   
/*     */   public CommandBlockLogic func_145822_e() {
/*  93 */     return this.field_145824_a;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_96095_a(int p_96095_1_, int p_96095_2_, int p_96095_3_, boolean p_96095_4_) {
/*  98 */     if (p_96095_4_ && 
/*  99 */       this.field_70173_aa - this.field_145823_b >= 4) {
/* 100 */       func_145822_e().func_145755_a(this.field_70170_p);
/* 101 */       this.field_145823_b = this.field_70173_aa;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_130002_c(EntityPlayer p_130002_1_) {
/* 108 */     if (this.field_70170_p.field_72995_K) {
/* 109 */       p_130002_1_.func_146095_a(func_145822_e());
/*     */     }
/*     */     
/* 112 */     return super.func_130002_c(p_130002_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_145781_i(int p_145781_1_) {
/* 117 */     super.func_145781_i(p_145781_1_);
/*     */     
/* 119 */     if (p_145781_1_ == 24) {
/*     */       try {
/* 121 */         this.field_145824_a.func_145750_b(IChatComponent.Serializer.func_150699_a(func_70096_w().func_75681_e(24)));
/* 122 */       } catch (Throwable throwable) {}
/* 123 */     } else if (p_145781_1_ == 23) {
/* 124 */       this.field_145824_a.func_145752_a(func_70096_w().func_75681_e(23));
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\EntityMinecartCommandBlock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */