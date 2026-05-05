/*      */ package net.minecraft.client.renderer;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Random;
/*      */ import net.minecraft.block.Block;
/*      */ import net.minecraft.block.material.Material;
/*      */ import net.minecraft.client.audio.ISound;
/*      */ import net.minecraft.client.multiplayer.WorldClient;
/*      */ import net.minecraft.client.particle.EntityAuraFX;
/*      */ import net.minecraft.client.particle.EntityBreakingFX;
/*      */ import net.minecraft.client.particle.EntityCritFX;
/*      */ import net.minecraft.client.particle.EntityDiggingFX;
/*      */ import net.minecraft.client.particle.EntityFX;
/*      */ import net.minecraft.client.particle.EntityFireworkSparkFX;
/*      */ import net.minecraft.client.particle.EntityHeartFX;
/*      */ import net.minecraft.client.particle.EntitySpellParticleFX;
/*      */ import net.minecraft.client.renderer.culling.ICamera;
/*      */ import net.minecraft.client.renderer.entity.RenderManager;
/*      */ import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
/*      */ import net.minecraft.entity.Entity;
/*      */ import net.minecraft.entity.EntityLiving;
/*      */ import net.minecraft.entity.EntityLivingBase;
/*      */ import net.minecraft.entity.player.EntityPlayer;
/*      */ import net.minecraft.init.Items;
/*      */ import net.minecraft.item.Item;
/*      */ import net.minecraft.item.ItemRecord;
/*      */ import net.minecraft.util.AxisAlignedBB;
/*      */ import net.minecraft.util.ChunkCoordinates;
/*      */ import net.minecraft.util.MathHelper;
/*      */ import net.minecraft.util.MovingObjectPosition;
/*      */ import net.minecraft.util.ResourceLocation;
/*      */ import net.minecraft.util.Vec3;
/*      */ import net.minecraft.world.World;
/*      */ import org.lwjgl.opengl.ARBOcclusionQuery;
/*      */ import org.lwjgl.opengl.GL11;
/*      */ 
/*      */ @SideOnly(Side.CLIENT)
/*      */ public class RenderGlobal implements IWorldAccess {
/*   40 */   private static final Logger field_147599_m = LogManager.getLogger();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   49 */   private static final ResourceLocation field_110927_h = new ResourceLocation("textures/environment/moon_phases.png");
/*   50 */   private static final ResourceLocation field_110928_i = new ResourceLocation("textures/environment/sun.png");
/*   51 */   private static final ResourceLocation field_110925_j = new ResourceLocation("textures/environment/clouds.png");
/*   52 */   private static final ResourceLocation field_110926_k = new ResourceLocation("textures/environment/end_sky.png");
/*      */ 
/*      */ 
/*      */   
/*   56 */   public List field_147598_a = new ArrayList();
/*      */   
/*      */   private WorldClient field_72769_h;
/*      */   
/*      */   private final TextureManager field_72770_i;
/*   61 */   private List field_72767_j = new ArrayList(); private WorldRenderer[] field_72768_k; private WorldRenderer[] field_72765_l; private int field_72766_m; private int field_72763_n; private int field_72764_o; private int field_72778_p; private Minecraft field_72777_q;
/*      */   private RenderBlocks field_147592_B;
/*      */   private IntBuffer field_72775_s;
/*      */   private boolean field_72774_t;
/*      */   private int field_72773_u;
/*      */   private int field_72772_v;
/*      */   private int field_72771_w;
/*      */   private int field_72781_x;
/*      */   private int field_72780_y;
/*      */   private int field_72779_z;
/*      */   private int field_72741_A;
/*      */   private int field_72742_B;
/*      */   private int field_72743_C;
/*      */   private int field_72737_D;
/*   75 */   private final Map field_72738_E = new HashMap<Object, Object>();
/*   76 */   private final Map field_147593_P = Maps.newHashMap();
/*      */ 
/*      */   
/*      */   private IIcon[] field_94141_F;
/*      */ 
/*      */   
/*      */   private boolean field_147595_R;
/*      */ 
/*      */   
/*      */   private int field_147594_S;
/*      */ 
/*      */   
/*      */   private int field_72739_F;
/*      */ 
/*      */   
/*      */   private int field_72740_G;
/*      */ 
/*      */   
/*      */   private int field_72748_H;
/*      */ 
/*      */   
/*      */   private int field_72749_I;
/*      */ 
/*      */   
/*      */   private int field_72750_J;
/*      */   
/*      */   IntBuffer field_72761_c;
/*      */   
/*      */   private int field_72751_K;
/*      */   
/*      */   private int field_72744_L;
/*      */   
/*      */   private int field_72745_M;
/*      */   
/*      */   private int field_72746_N;
/*      */   
/*      */   private int field_72747_O;
/*      */   
/*      */   private int field_72753_P;
/*      */   
/*      */   private int field_72752_Q;
/*      */   
/*      */   private List field_72755_R;
/*      */   
/*      */   private RenderList[] field_72754_S;
/*      */   
/*      */   double field_72758_d;
/*      */   
/*      */   double field_72759_e;
/*      */   
/*      */   double field_72756_f;
/*      */   
/*      */   double field_147596_f;
/*      */   
/*      */   double field_147597_g;
/*      */   
/*      */   double field_147602_h;
/*      */   
/*      */   int field_147603_i;
/*      */   
/*      */   int field_147600_j;
/*      */   
/*      */   int field_147601_k;
/*      */   
/*      */   int field_72757_g;
/*      */   
/*      */   private static final String __OBFID = "CL_00000954";
/*      */ 
/*      */   
/*      */   private void func_72730_g() {
/*  146 */     Random random = new Random(10842L);
/*  147 */     Tessellator tessellator = Tessellator.field_78398_a;
/*  148 */     tessellator.func_78382_b();
/*  149 */     for (byte b = 0; b < 'ל'; b++) {
/*  150 */       double d1 = (random.nextFloat() * 2.0F - 1.0F);
/*  151 */       double d2 = (random.nextFloat() * 2.0F - 1.0F);
/*  152 */       double d3 = (random.nextFloat() * 2.0F - 1.0F);
/*  153 */       double d4 = (0.15F + random.nextFloat() * 0.1F);
/*  154 */       double d5 = d1 * d1 + d2 * d2 + d3 * d3;
/*  155 */       if (d5 < 1.0D && d5 > 0.01D) {
/*  156 */         d5 = 1.0D / Math.sqrt(d5);
/*  157 */         d1 *= d5;
/*  158 */         d2 *= d5;
/*  159 */         d3 *= d5;
/*  160 */         double d6 = d1 * 100.0D;
/*  161 */         double d7 = d2 * 100.0D;
/*  162 */         double d8 = d3 * 100.0D;
/*      */         
/*  164 */         double d9 = Math.atan2(d1, d3);
/*  165 */         double d10 = Math.sin(d9);
/*  166 */         double d11 = Math.cos(d9);
/*      */         
/*  168 */         double d12 = Math.atan2(Math.sqrt(d1 * d1 + d3 * d3), d2);
/*  169 */         double d13 = Math.sin(d12);
/*  170 */         double d14 = Math.cos(d12);
/*      */         
/*  172 */         double d15 = random.nextDouble() * Math.PI * 2.0D;
/*  173 */         double d16 = Math.sin(d15);
/*  174 */         double d17 = Math.cos(d15);
/*      */         
/*  176 */         for (byte b1 = 0; b1 < 4; b1++) {
/*  177 */           double d18 = 0.0D;
/*  178 */           double d19 = ((b1 & 0x2) - 1) * d4;
/*  179 */           double d20 = ((b1 + 1 & 0x2) - 1) * d4;
/*      */           
/*  181 */           double d21 = d18;
/*  182 */           double d22 = d19 * d17 - d20 * d16;
/*  183 */           double d23 = d20 * d17 + d19 * d16;
/*      */           
/*  185 */           double d24 = d23;
/*  186 */           double d25 = d22 * d13 + d21 * d14;
/*  187 */           double d26 = d21 * d13 - d22 * d14;
/*      */           
/*  189 */           double d27 = d26 * d10 - d24 * d11;
/*  190 */           double d28 = d25;
/*  191 */           double d29 = d24 * d10 + d26 * d11;
/*      */           
/*  193 */           tessellator.func_78377_a(d6 + d27, d7 + d28, d8 + d29);
/*      */         } 
/*      */       } 
/*      */     } 
/*  197 */     tessellator.func_78381_a();
/*      */   }
/*      */   
/*      */   public void func_72732_a(WorldClient p_72732_1_) {
/*  201 */     if (this.field_72769_h != null) {
/*  202 */       this.field_72769_h.func_72848_b(this);
/*      */     }
/*      */     
/*  205 */     this.field_72758_d = -9999.0D;
/*  206 */     this.field_72759_e = -9999.0D;
/*  207 */     this.field_72756_f = -9999.0D;
/*  208 */     this.field_147596_f = -9999.0D;
/*  209 */     this.field_147597_g = -9999.0D;
/*  210 */     this.field_147602_h = -9999.0D;
/*  211 */     this.field_147603_i = -9999;
/*  212 */     this.field_147600_j = -9999;
/*  213 */     this.field_147601_k = -9999;
/*      */     
/*  215 */     RenderManager.field_78727_a.func_78717_a((World)p_72732_1_);
/*  216 */     this.field_72769_h = p_72732_1_;
/*  217 */     this.field_147592_B = new RenderBlocks((IBlockAccess)p_72732_1_);
/*  218 */     if (p_72732_1_ != null) {
/*  219 */       p_72732_1_.func_72954_a(this);
/*  220 */       func_72712_a();
/*      */     } 
/*      */   }
/*      */   
/*  224 */   public RenderGlobal(Minecraft p_i1249_1_) { this.field_72739_F = -1;
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
/*  296 */     this.field_72740_G = 2;
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
/*  399 */     this.field_72761_c = GLAllocation.func_74527_f(64);
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
/*  648 */     this.field_72755_R = new ArrayList();
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
/*  736 */     this.field_72754_S = new RenderList[] { new RenderList(), new RenderList(), new RenderList(), new RenderList() };
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
/*      */ 
/*      */ 
/*      */     
/* 1190 */     this.field_72758_d = -9999.0D;
/* 1191 */     this.field_72759_e = -9999.0D;
/* 1192 */     this.field_72756_f = -9999.0D;
/*      */     
/* 1194 */     this.field_147596_f = -9999.0D;
/* 1195 */     this.field_147597_g = -9999.0D;
/* 1196 */     this.field_147602_h = -9999.0D;
/*      */     
/* 1198 */     this.field_147603_i = -999;
/* 1199 */     this.field_147600_j = -999;
/* 1200 */     this.field_147601_k = -999; this.field_72777_q = p_i1249_1_; this.field_72770_i = p_i1249_1_.func_110434_K(); byte b1 = 34; byte b2 = 16; this.field_72778_p = GLAllocation.func_74526_a(b1 * b1 * b2 * 3); this.field_147595_R = false; this.field_147594_S = GLAllocation.func_74526_a(1); this.field_72774_t = OpenGlCapsChecker.func_74371_a(); if (this.field_72774_t) { this.field_72761_c.clear(); this.field_72775_s = GLAllocation.func_74527_f(b1 * b1 * b2); this.field_72775_s.clear(); this.field_72775_s.position(0); this.field_72775_s.limit(b1 * b1 * b2); ARBOcclusionQuery.glGenQueriesARB(this.field_72775_s); }  this.field_72772_v = GLAllocation.func_74526_a(3); GL11.glPushMatrix(); GL11.glNewList(this.field_72772_v, 4864); func_72730_g(); GL11.glEndList(); GL11.glPopMatrix(); Tessellator tessellator = Tessellator.field_78398_a; this.field_72771_w = this.field_72772_v + 1; GL11.glNewList(this.field_72771_w, 4864); byte b3 = 64; int i = 256 / b3 + 2; float f = 16.0F; int j; for (j = -b3 * i; j <= b3 * i; j += b3) { int k; for (k = -b3 * i; k <= b3 * i; k += b3) { tessellator.func_78382_b(); tessellator.func_78377_a((j + 0), f, (k + 0)); tessellator.func_78377_a((j + b3), f, (k + 0)); tessellator.func_78377_a((j + b3), f, (k + b3)); tessellator.func_78377_a((j + 0), f, (k + b3)); tessellator.func_78381_a(); }  }  GL11.glEndList(); this.field_72781_x = this.field_72772_v + 2; GL11.glNewList(this.field_72781_x, 4864); f = -16.0F; tessellator.func_78382_b(); for (j = -b3 * i; j <= b3 * i; j += b3) { int k; for (k = -b3 * i; k <= b3 * i; k += b3) { tessellator.func_78377_a((j + b3), f, (k + 0)); tessellator.func_78377_a((j + 0), f, (k + 0)); tessellator.func_78377_a((j + 0), f, (k + b3)); tessellator.func_78377_a((j + b3), f, (k + b3)); }  }  tessellator.func_78381_a(); GL11.glEndList(); }
/*      */   public void func_72712_a() { if (this.field_72769_h == null) return;  Blocks.field_150362_t.func_150122_b(this.field_72777_q.field_71474_y.field_74347_j); Blocks.field_150361_u.func_150122_b(this.field_72777_q.field_71474_y.field_74347_j); this.field_72739_F = this.field_72777_q.field_71474_y.field_151451_c; if (this.field_72765_l != null) for (byte b = 0; b < this.field_72765_l.length; b++) this.field_72765_l[b].func_78911_c();   int i = this.field_72739_F * 2 + 1; this.field_72766_m = i; this.field_72763_n = 16; this.field_72764_o = i; this.field_72765_l = new WorldRenderer[this.field_72766_m * this.field_72763_n * this.field_72764_o]; this.field_72768_k = new WorldRenderer[this.field_72766_m * this.field_72763_n * this.field_72764_o]; byte b1 = 0; byte b2 = 0; this.field_72780_y = 0; this.field_72779_z = 0; this.field_72741_A = 0; this.field_72742_B = this.field_72766_m; this.field_72743_C = this.field_72763_n; this.field_72737_D = this.field_72764_o; byte b3; for (b3 = 0; b3 < this.field_72767_j.size(); b3++) ((WorldRenderer)this.field_72767_j.get(b3)).field_78939_q = false;  this.field_72767_j.clear(); this.field_147598_a.clear(); func_147584_b(); for (b3 = 0; b3 < this.field_72766_m; b3++) { for (byte b = 0; b < this.field_72763_n; b++) { for (byte b4 = 0; b4 < this.field_72764_o; b4++) { this.field_72765_l[(b4 * this.field_72763_n + b) * this.field_72766_m + b3] = new WorldRenderer((World)this.field_72769_h, this.field_147598_a, b3 * 16, b * 16, b4 * 16, this.field_72778_p + b1); if (this.field_72774_t) (this.field_72765_l[(b4 * this.field_72763_n + b) * this.field_72766_m + b3]).field_78934_v = this.field_72775_s.get(b2);  (this.field_72765_l[(b4 * this.field_72763_n + b) * this.field_72766_m + b3]).field_78935_u = false; (this.field_72765_l[(b4 * this.field_72763_n + b) * this.field_72766_m + b3]).field_78936_t = true; (this.field_72765_l[(b4 * this.field_72763_n + b) * this.field_72766_m + b3]).field_78927_l = true; (this.field_72765_l[(b4 * this.field_72763_n + b) * this.field_72766_m + b3]).field_78937_s = b2++; this.field_72765_l[(b4 * this.field_72763_n + b) * this.field_72766_m + b3].func_78914_f(); this.field_72768_k[(b4 * this.field_72763_n + b) * this.field_72766_m + b3] = this.field_72765_l[(b4 * this.field_72763_n + b) * this.field_72766_m + b3]; this.field_72767_j.add(this.field_72765_l[(b4 * this.field_72763_n + b) * this.field_72766_m + b3]); b1 += 3; }  }  }  if (this.field_72769_h != null) { EntityLivingBase entityLivingBase = this.field_72777_q.field_71451_h; if (entityLivingBase != null) { func_72722_c(MathHelper.func_76128_c(((Entity)entityLivingBase).field_70165_t), MathHelper.func_76128_c(((Entity)entityLivingBase).field_70163_u), MathHelper.func_76128_c(((Entity)entityLivingBase).field_70161_v)); Arrays.sort(this.field_72768_k, new EntitySorter((Entity)entityLivingBase)); }  }  this.field_72740_G = 2; }
/*      */   public void func_147589_a(EntityLivingBase p_147589_1_, ICamera p_147589_2_, float p_147589_3_) { if (this.field_72740_G > 0) { this.field_72740_G--; return; }  double d1 = p_147589_1_.field_70169_q + (p_147589_1_.field_70165_t - p_147589_1_.field_70169_q) * p_147589_3_; double d2 = p_147589_1_.field_70167_r + (p_147589_1_.field_70163_u - p_147589_1_.field_70167_r) * p_147589_3_; double d3 = p_147589_1_.field_70166_s + (p_147589_1_.field_70161_v - p_147589_1_.field_70166_s) * p_147589_3_; this.field_72769_h.field_72984_F.func_76320_a("prepare"); TileEntityRendererDispatcher.field_147556_a.func_147542_a((World)this.field_72769_h, this.field_72777_q.func_110434_K(), this.field_72777_q.field_71466_p, this.field_72777_q.field_71451_h, p_147589_3_); RenderManager.field_78727_a.func_147938_a((World)this.field_72769_h, this.field_72777_q.func_110434_K(), this.field_72777_q.field_71466_p, this.field_72777_q.field_71451_h, this.field_72777_q.field_147125_j, this.field_72777_q.field_71474_y, p_147589_3_); this.field_72748_H = 0; this.field_72749_I = 0; this.field_72750_J = 0; EntityLivingBase entityLivingBase = this.field_72777_q.field_71451_h; double d4 = ((Entity)entityLivingBase).field_70142_S + (((Entity)entityLivingBase).field_70165_t - ((Entity)entityLivingBase).field_70142_S) * p_147589_3_; double d5 = ((Entity)entityLivingBase).field_70137_T + (((Entity)entityLivingBase).field_70163_u - ((Entity)entityLivingBase).field_70137_T) * p_147589_3_; double d6 = ((Entity)entityLivingBase).field_70136_U + (((Entity)entityLivingBase).field_70161_v - ((Entity)entityLivingBase).field_70136_U) * p_147589_3_; TileEntityRendererDispatcher.field_147554_b = d4; TileEntityRendererDispatcher.field_147555_c = d5; TileEntityRendererDispatcher.field_147552_d = d6; this.field_72769_h.field_72984_F.func_76318_c("staticentities"); if (this.field_147595_R) { RenderManager.field_78725_b = 0.0D; RenderManager.field_78726_c = 0.0D; RenderManager.field_78723_d = 0.0D; func_147591_f(); }  GL11.glMatrixMode(5888); GL11.glPushMatrix(); GL11.glTranslated(-d4, -d5, -d6); GL11.glCallList(this.field_147594_S); GL11.glPopMatrix(); RenderManager.field_78725_b = d4; RenderManager.field_78726_c = d5; RenderManager.field_78723_d = d6; this.field_72777_q.field_71460_t.func_78463_b(p_147589_3_); this.field_72769_h.field_72984_F.func_76318_c("global"); List<Entity> list = this.field_72769_h.func_72910_y(); this.field_72748_H = list.size(); byte b; for (b = 0; b < this.field_72769_h.field_73007_j.size(); b++) { Entity entity = this.field_72769_h.field_73007_j.get(b); this.field_72749_I++; if (entity.func_145770_h(d1, d2, d3)) RenderManager.field_78727_a.func_147937_a(entity, p_147589_3_);  }  this.field_72769_h.field_72984_F.func_76318_c("entities"); for (b = 0; b < list.size(); b++) { Entity entity = list.get(b); boolean bool = (entity.func_145770_h(d1, d2, d3) && (entity.field_70158_ak || p_147589_2_.func_78546_a(entity.field_70121_D) || entity.field_70153_n == this.field_72777_q.field_71439_g)); if (!bool && entity instanceof EntityLiving) { EntityLiving entityLiving = (EntityLiving)entity; if (entityLiving.func_110167_bD() && entityLiving.func_110166_bE() != null) { Entity entity1 = entityLiving.func_110166_bE(); bool = p_147589_2_.func_78546_a(entity1.field_70121_D); }  }  if (bool && (entity != this.field_72777_q.field_71451_h || this.field_72777_q.field_71474_y.field_74320_O != 0 || this.field_72777_q.field_71451_h.func_70608_bn()) && this.field_72769_h.func_72899_e(MathHelper.func_76128_c(entity.field_70165_t), 0, MathHelper.func_76128_c(entity.field_70161_v))) { this.field_72749_I++; RenderManager.field_78727_a.func_147937_a(entity, p_147589_3_); }  }  this.field_72769_h.field_72984_F.func_76318_c("blockentities"); RenderHelper.func_74519_b(); for (b = 0; b < this.field_147598_a.size(); b++) TileEntityRendererDispatcher.field_147556_a.func_147544_a(this.field_147598_a.get(b), p_147589_3_);  this.field_72777_q.field_71460_t.func_78483_a(p_147589_3_); this.field_72769_h.field_72984_F.func_76319_b(); }
/* 1203 */   public String func_72735_c() { return "C: " + this.field_72746_N + "/" + this.field_72751_K + ". F: " + this.field_72744_L + ", O: " + this.field_72745_M + ", E: " + this.field_72747_O; } public String func_72723_d() { return "E: " + this.field_72749_I + "/" + this.field_72748_H + ". B: " + this.field_72750_J + ", I: " + (this.field_72748_H - this.field_72750_J - this.field_72749_I); } public void func_147584_b() { this.field_147595_R = true; } public void func_147591_f() { this.field_72769_h.field_72984_F.func_76320_a("staticentityrebuild"); GL11.glPushMatrix(); GL11.glNewList(this.field_147594_S, 4864); List<Entity> list = this.field_72769_h.func_72910_y(); this.field_147595_R = false; for (byte b = 0; b < list.size(); b++) { Entity entity = list.get(b); if (RenderManager.field_78727_a.func_78713_a(entity).func_147905_a()) this.field_147595_R = (this.field_147595_R || !RenderManager.field_78727_a.func_147936_a(entity, 0.0F, true));  }  GL11.glEndList(); GL11.glPopMatrix(); this.field_72769_h.field_72984_F.func_76319_b(); } private void func_72722_c(int p_72722_1_, int p_72722_2_, int p_72722_3_) { p_72722_1_ -= 8; p_72722_2_ -= 8; p_72722_3_ -= 8; this.field_72780_y = Integer.MAX_VALUE; this.field_72779_z = Integer.MAX_VALUE; this.field_72741_A = Integer.MAX_VALUE; this.field_72742_B = Integer.MIN_VALUE; this.field_72743_C = Integer.MIN_VALUE; this.field_72737_D = Integer.MIN_VALUE; int i = this.field_72766_m * 16; int j = i / 2; for (byte b = 0; b < this.field_72766_m; b++) { int k = b * 16; int m = k + j - p_72722_1_; if (m < 0) m -= i - 1;  m /= i; k -= m * i; if (k < this.field_72780_y) this.field_72780_y = k;  if (k > this.field_72742_B) this.field_72742_B = k;  for (byte b1 = 0; b1 < this.field_72764_o; b1++) { int n = b1 * 16; int i1 = n + j - p_72722_3_; if (i1 < 0) i1 -= i - 1;  i1 /= i; n -= i1 * i; if (n < this.field_72741_A) this.field_72741_A = n;  if (n > this.field_72737_D) this.field_72737_D = n;  for (byte b2 = 0; b2 < this.field_72763_n; b2++) { int i2 = b2 * 16; if (i2 < this.field_72779_z) this.field_72779_z = i2;  if (i2 > this.field_72743_C) this.field_72743_C = i2;  WorldRenderer worldRenderer = this.field_72765_l[(b1 * this.field_72763_n + b2) * this.field_72766_m + b]; boolean bool = worldRenderer.field_78939_q; worldRenderer.func_78913_a(k, i2, n); if (!bool && worldRenderer.field_78939_q) this.field_72767_j.add(worldRenderer);  }  }  }  } public int func_72719_a(EntityLivingBase p_72719_1_, int p_72719_2_, double p_72719_3_) { this.field_72769_h.field_72984_F.func_76320_a("sortchunks"); for (byte b = 0; b < 10; b++) { this.field_72752_Q = (this.field_72752_Q + 1) % this.field_72765_l.length; WorldRenderer worldRenderer = this.field_72765_l[this.field_72752_Q]; if (worldRenderer.field_78939_q && !this.field_72767_j.contains(worldRenderer)) this.field_72767_j.add(worldRenderer);  }  if (this.field_72777_q.field_71474_y.field_151451_c != this.field_72739_F) func_72712_a();  if (p_72719_2_ == 0) { this.field_72751_K = 0; this.field_72753_P = 0; this.field_72744_L = 0; this.field_72745_M = 0; this.field_72746_N = 0; this.field_72747_O = 0; }  double d1 = p_72719_1_.field_70142_S + (p_72719_1_.field_70165_t - p_72719_1_.field_70142_S) * p_72719_3_; double d2 = p_72719_1_.field_70137_T + (p_72719_1_.field_70163_u - p_72719_1_.field_70137_T) * p_72719_3_; double d3 = p_72719_1_.field_70136_U + (p_72719_1_.field_70161_v - p_72719_1_.field_70136_U) * p_72719_3_; double d4 = p_72719_1_.field_70165_t - this.field_72758_d; double d5 = p_72719_1_.field_70163_u - this.field_72759_e; double d6 = p_72719_1_.field_70161_v - this.field_72756_f; if (this.field_147603_i != p_72719_1_.field_70176_ah || this.field_147600_j != p_72719_1_.field_70162_ai || this.field_147601_k != p_72719_1_.field_70164_aj || d4 * d4 + d5 * d5 + d6 * d6 > 16.0D) { this.field_72758_d = p_72719_1_.field_70165_t; this.field_72759_e = p_72719_1_.field_70163_u; this.field_72756_f = p_72719_1_.field_70161_v; this.field_147603_i = p_72719_1_.field_70176_ah; this.field_147600_j = p_72719_1_.field_70162_ai; this.field_147601_k = p_72719_1_.field_70164_aj; func_72722_c(MathHelper.func_76128_c(p_72719_1_.field_70165_t), MathHelper.func_76128_c(p_72719_1_.field_70163_u), MathHelper.func_76128_c(p_72719_1_.field_70161_v)); Arrays.sort(this.field_72768_k, new EntitySorter((Entity)p_72719_1_)); }  double d7 = p_72719_1_.field_70165_t - this.field_147596_f; double d8 = p_72719_1_.field_70163_u - this.field_147597_g; double d9 = p_72719_1_.field_70161_v - this.field_147602_h; if (d7 * d7 + d8 * d8 + d9 * d9 > 1.0D) { this.field_147596_f = p_72719_1_.field_70165_t; this.field_147597_g = p_72719_1_.field_70163_u; this.field_147602_h = p_72719_1_.field_70161_v; for (byte b1 = 0; b1 < 27; b1++) this.field_72768_k[b1].func_147889_b(p_72719_1_);  }  RenderHelper.func_74518_a(); int i = 0; if (this.field_72774_t && this.field_72777_q.field_71474_y.field_74349_h && !this.field_72777_q.field_71474_y.field_74337_g && p_72719_2_ == 0) { int j = 0; int k = 16; func_72720_a(j, k); for (int m = j; m < k; m++) (this.field_72768_k[m]).field_78936_t = true;  this.field_72769_h.field_72984_F.func_76318_c("render"); i += func_72724_a(j, k, p_72719_2_, p_72719_3_); do { this.field_72769_h.field_72984_F.func_76318_c("occ"); j = k; k *= 2; if (k > this.field_72768_k.length) k = this.field_72768_k.length;  GL11.glDisable(3553); GL11.glDisable(2896); GL11.glDisable(3008); GL11.glDisable(2912); GL11.glColorMask(false, false, false, false); GL11.glDepthMask(false); this.field_72769_h.field_72984_F.func_76320_a("check"); func_72720_a(j, k); this.field_72769_h.field_72984_F.func_76319_b(); GL11.glPushMatrix(); float f1 = 0.0F; float f2 = 0.0F; float f3 = 0.0F; for (int n = j; n < k; n++) { if (this.field_72768_k[n].func_78906_e()) { (this.field_72768_k[n]).field_78927_l = false; } else { if (!(this.field_72768_k[n]).field_78927_l) (this.field_72768_k[n]).field_78936_t = true;  if ((this.field_72768_k[n]).field_78927_l && !(this.field_72768_k[n]).field_78935_u) { float f = MathHelper.func_76129_c(this.field_72768_k[n].func_78912_a((Entity)p_72719_1_)); int i1 = (int)(1.0F + f / 128.0F); if (this.field_72773_u % i1 == n % i1) { WorldRenderer worldRenderer = this.field_72768_k[n]; float f4 = (float)(worldRenderer.field_78918_f - d1); float f5 = (float)(worldRenderer.field_78919_g - d2); float f6 = (float)(worldRenderer.field_78931_h - d3); float f7 = f4 - f1; float f8 = f5 - f2; float f9 = f6 - f3; if (f7 != 0.0F || f8 != 0.0F || f9 != 0.0F) { GL11.glTranslatef(f7, f8, f9); f1 += f7; f2 += f8; f3 += f9; }  this.field_72769_h.field_72984_F.func_76320_a("bb"); ARBOcclusionQuery.glBeginQueryARB(35092, (this.field_72768_k[n]).field_78934_v); this.field_72768_k[n].func_78904_d(); ARBOcclusionQuery.glEndQueryARB(35092); this.field_72769_h.field_72984_F.func_76319_b(); (this.field_72768_k[n]).field_78935_u = true; }  }  }  }  GL11.glPopMatrix(); if (this.field_72777_q.field_71474_y.field_74337_g) { if (EntityRenderer.field_78515_b == 0) { GL11.glColorMask(false, true, true, true); } else { GL11.glColorMask(true, false, false, true); }  } else { GL11.glColorMask(true, true, true, true); }  GL11.glDepthMask(true); GL11.glEnable(3553); GL11.glEnable(3008); GL11.glEnable(2912); this.field_72769_h.field_72984_F.func_76318_c("render"); i += func_72724_a(j, k, p_72719_2_, p_72719_3_); } while (k < this.field_72768_k.length); } else { this.field_72769_h.field_72984_F.func_76318_c("render"); i += func_72724_a(0, this.field_72768_k.length, p_72719_2_, p_72719_3_); }  this.field_72769_h.field_72984_F.func_76319_b(); return i; } public boolean func_72716_a(EntityLivingBase p_72716_1_, boolean p_72716_2_) { byte b1 = 2;
/*      */     
/* 1205 */     RenderSorter renderSorter = new RenderSorter(p_72716_1_);
/* 1206 */     WorldRenderer[] arrayOfWorldRenderer = new WorldRenderer[b1];
/* 1207 */     ArrayList<WorldRenderer> arrayList = null;
/*      */     
/* 1209 */     int i = this.field_72767_j.size();
/* 1210 */     byte b2 = 0;
/*      */     
/* 1212 */     this.field_72769_h.field_72984_F.func_76320_a("nearChunksSearch"); int j;
/* 1213 */     for (j = 0; j < i; j++) {
/* 1214 */       WorldRenderer worldRenderer = this.field_72767_j.get(j);
/* 1215 */       if (worldRenderer == null)
/*      */         continue; 
/* 1217 */       if (!p_72716_2_) {
/* 1218 */         if (worldRenderer.func_78912_a((Entity)p_72716_1_) > 272.0F) {
/*      */           byte b;
/*      */ 
/*      */           
/* 1222 */           for (b = 0; b < b1 && (
/* 1223 */             arrayOfWorldRenderer[b] == null || renderSorter.compare(arrayOfWorldRenderer[b], worldRenderer) <= 0); b++);
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1228 */           b--;
/*      */           
/* 1230 */           if (b > 0) {
/* 1231 */             byte b3 = b;
/* 1232 */             while (--b3 != 0) {
/* 1233 */               arrayOfWorldRenderer[b3 - 1] = arrayOfWorldRenderer[b3];
/*      */             }
/* 1235 */             arrayOfWorldRenderer[b] = worldRenderer;
/*      */           } 
/*      */           
/*      */           continue;
/*      */         } 
/* 1240 */       } else if (!worldRenderer.field_78927_l) {
/*      */         continue;
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/* 1246 */       if (arrayList == null) {
/* 1247 */         arrayList = new ArrayList();
/*      */       }
/*      */       
/* 1250 */       b2++;
/* 1251 */       arrayList.add(worldRenderer);
/* 1252 */       this.field_72767_j.set(j, null); continue;
/*      */     } 
/* 1254 */     this.field_72769_h.field_72984_F.func_76319_b();
/*      */ 
/*      */     
/* 1257 */     this.field_72769_h.field_72984_F.func_76320_a("sort");
/* 1258 */     if (arrayList != null) {
/* 1259 */       if (arrayList.size() > 1) Collections.sort(arrayList, renderSorter);
/*      */       
/* 1261 */       for (j = arrayList.size() - 1; j >= 0; j--) {
/* 1262 */         WorldRenderer worldRenderer = arrayList.get(j);
/* 1263 */         worldRenderer.func_147892_a(p_72716_1_);
/* 1264 */         worldRenderer.field_78939_q = false;
/*      */       } 
/*      */     } 
/* 1267 */     this.field_72769_h.field_72984_F.func_76319_b();
/*      */ 
/*      */     
/* 1270 */     j = 0;
/*      */     
/* 1272 */     this.field_72769_h.field_72984_F.func_76320_a("rebuild"); int k;
/* 1273 */     for (k = b1 - 1; k >= 0; k--) {
/* 1274 */       WorldRenderer worldRenderer = arrayOfWorldRenderer[k];
/* 1275 */       if (worldRenderer != null) {
/*      */         
/* 1277 */         if (!worldRenderer.field_78927_l && k != b1 - 1) {
/* 1278 */           arrayOfWorldRenderer[k] = null;
/* 1279 */           arrayOfWorldRenderer[0] = null;
/*      */           break;
/*      */         } 
/* 1282 */         arrayOfWorldRenderer[k].func_147892_a(p_72716_1_);
/* 1283 */         (arrayOfWorldRenderer[k]).field_78939_q = false;
/* 1284 */         j++;
/*      */       } 
/*      */     } 
/* 1287 */     this.field_72769_h.field_72984_F.func_76319_b();
/*      */     
/* 1289 */     this.field_72769_h.field_72984_F.func_76320_a("cleanup");
/*      */     
/* 1291 */     k = 0;
/* 1292 */     int m = 0;
/* 1293 */     int n = this.field_72767_j.size();
/* 1294 */     while (k != n) {
/* 1295 */       WorldRenderer worldRenderer = this.field_72767_j.get(k);
/* 1296 */       if (worldRenderer != null) {
/* 1297 */         boolean bool = false;
/* 1298 */         for (byte b = 0; b < b1 && !bool; b++) {
/* 1299 */           if (worldRenderer == arrayOfWorldRenderer[b]) {
/* 1300 */             bool = true;
/*      */           }
/*      */         } 
/* 1303 */         if (!bool) {
/* 1304 */           if (m != k) {
/* 1305 */             this.field_72767_j.set(m, worldRenderer);
/*      */           }
/* 1307 */           m++;
/*      */         } 
/*      */       } 
/* 1310 */       k++;
/*      */     } 
/* 1312 */     this.field_72769_h.field_72984_F.func_76319_b();
/*      */     
/* 1314 */     this.field_72769_h.field_72984_F.func_76320_a("trim");
/*      */     
/* 1316 */     while (--k >= m) {
/* 1317 */       this.field_72767_j.remove(k);
/*      */     }
/* 1319 */     this.field_72769_h.field_72984_F.func_76319_b();
/*      */     
/* 1321 */     return (i == b2 + j); }
/*      */   private void func_72720_a(int p_72720_1_, int p_72720_2_) { for (int i = p_72720_1_; i < p_72720_2_; i++) { if ((this.field_72768_k[i]).field_78935_u) { this.field_72761_c.clear(); ARBOcclusionQuery.glGetQueryObjectuARB((this.field_72768_k[i]).field_78934_v, 34919, this.field_72761_c); if (this.field_72761_c.get(0) != 0) { (this.field_72768_k[i]).field_78935_u = false; this.field_72761_c.clear(); ARBOcclusionQuery.glGetQueryObjectuARB((this.field_72768_k[i]).field_78934_v, 34918, this.field_72761_c); (this.field_72768_k[i]).field_78936_t = (this.field_72761_c.get(0) != 0); }  }  }  }
/*      */   private int func_72724_a(int p_72724_1_, int p_72724_2_, int p_72724_3_, double p_72724_4_) { this.field_72755_R.clear(); byte b1 = 0; int i = p_72724_1_; int j = p_72724_2_; byte b = 1; if (p_72724_3_ == 1) { i = this.field_72768_k.length - 1 - p_72724_1_; j = this.field_72768_k.length - 1 - p_72724_2_; b = -1; }  int k; for (k = i; k != j; k += b) { if (p_72724_3_ == 0) { this.field_72751_K++; if ((this.field_72768_k[k]).field_78928_m[p_72724_3_]) { this.field_72747_O++; } else if (!(this.field_72768_k[k]).field_78927_l) { this.field_72744_L++; } else if (this.field_72774_t && !(this.field_72768_k[k]).field_78936_t) { this.field_72745_M++; } else { this.field_72746_N++; }  }  if (!(this.field_72768_k[k]).field_78928_m[p_72724_3_] && (this.field_72768_k[k]).field_78927_l && (!this.field_72774_t || (this.field_72768_k[k]).field_78936_t)) { int i3 = this.field_72768_k[k].func_78909_a(p_72724_3_); if (i3 >= 0) { this.field_72755_R.add(this.field_72768_k[k]); b1++; }  }  }  EntityLivingBase entityLivingBase = this.field_72777_q.field_71451_h; double d1 = entityLivingBase.field_70142_S + (entityLivingBase.field_70165_t - entityLivingBase.field_70142_S) * p_72724_4_; double d2 = entityLivingBase.field_70137_T + (entityLivingBase.field_70163_u - entityLivingBase.field_70137_T) * p_72724_4_; double d3 = entityLivingBase.field_70136_U + (entityLivingBase.field_70161_v - entityLivingBase.field_70136_U) * p_72724_4_; byte b2 = 0; int m; for (m = 0; m < this.field_72754_S.length; m++) this.field_72754_S[m].func_78421_b();  for (m = 0; m < this.field_72755_R.size(); m++) { WorldRenderer worldRenderer = this.field_72755_R.get(m); byte b3 = -1; for (byte b4 = 0; b4 < b2; b4++) { if (this.field_72754_S[b4].func_78418_a(worldRenderer.field_78918_f, worldRenderer.field_78919_g, worldRenderer.field_78931_h)) b3 = b4;  }  if (b3 < 0) { b3 = b2++; this.field_72754_S[b3].func_78422_a(worldRenderer.field_78918_f, worldRenderer.field_78919_g, worldRenderer.field_78931_h, d1, d2, d3); }  this.field_72754_S[b3].func_78420_a(worldRenderer.func_78909_a(p_72724_3_)); }  m = MathHelper.func_76128_c(d1); int n = MathHelper.func_76128_c(d3); int i1 = m - (m & 0x3FF); int i2 = n - (n & 0x3FF); Arrays.sort(this.field_72754_S, (Comparator<? super RenderList>)new RenderDistanceSorter(i1, i2)); func_72733_a(p_72724_3_, p_72724_4_); return b1; }
/*      */   public void func_72733_a(int p_72733_1_, double p_72733_2_) { this.field_72777_q.field_71460_t.func_78463_b(p_72733_2_); for (byte b = 0; b < this.field_72754_S.length; b++) this.field_72754_S[b].func_78419_a();  this.field_72777_q.field_71460_t.func_78483_a(p_72733_2_); }
/* 1325 */   public void func_72734_e() { this.field_72773_u++; if (this.field_72773_u % 20 == 0) { Iterator<DestroyBlockProgress> iterator = this.field_72738_E.values().iterator(); while (iterator.hasNext()) { DestroyBlockProgress destroyBlockProgress = iterator.next(); int i = destroyBlockProgress.func_82743_f(); if (this.field_72773_u - i > 400) iterator.remove();  }  }  } public void func_72714_a(float p_72714_1_) { if (this.field_72777_q.field_71441_e.field_73011_w.field_76574_g == 1) { GL11.glDisable(2912); GL11.glDisable(3008); GL11.glEnable(3042); OpenGlHelper.func_148821_a(770, 771, 1, 0); RenderHelper.func_74518_a(); GL11.glDepthMask(false); this.field_72770_i.func_110577_a(field_110926_k); Tessellator tessellator1 = Tessellator.field_78398_a; for (byte b = 0; b < 6; b++) { GL11.glPushMatrix(); if (b == 1) GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);  if (b == 2) GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);  if (b == 3) GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);  if (b == 4) GL11.glRotatef(90.0F, 0.0F, 0.0F, 1.0F);  if (b == 5) GL11.glRotatef(-90.0F, 0.0F, 0.0F, 1.0F);  tessellator1.func_78382_b(); tessellator1.func_78378_d(2631720); tessellator1.func_78374_a(-100.0D, -100.0D, -100.0D, 0.0D, 0.0D); tessellator1.func_78374_a(-100.0D, -100.0D, 100.0D, 0.0D, 16.0D); tessellator1.func_78374_a(100.0D, -100.0D, 100.0D, 16.0D, 16.0D); tessellator1.func_78374_a(100.0D, -100.0D, -100.0D, 16.0D, 0.0D); tessellator1.func_78381_a(); GL11.glPopMatrix(); }  GL11.glDepthMask(true); GL11.glEnable(3553); GL11.glEnable(3008); return; }  if (!this.field_72777_q.field_71441_e.field_73011_w.func_76569_d()) return;  GL11.glDisable(3553); Vec3 vec3 = this.field_72769_h.func_72833_a((Entity)this.field_72777_q.field_71451_h, p_72714_1_); float f1 = (float)vec3.field_72450_a; float f2 = (float)vec3.field_72448_b; float f3 = (float)vec3.field_72449_c; if (this.field_72777_q.field_71474_y.field_74337_g) { float f14 = (f1 * 30.0F + f2 * 59.0F + f3 * 11.0F) / 100.0F; float f15 = (f1 * 30.0F + f2 * 70.0F) / 100.0F; float f16 = (f1 * 30.0F + f3 * 70.0F) / 100.0F; f1 = f14; f2 = f15; f3 = f16; }  GL11.glColor3f(f1, f2, f3); Tessellator tessellator = Tessellator.field_78398_a; GL11.glDepthMask(false); GL11.glEnable(2912); GL11.glColor3f(f1, f2, f3); GL11.glCallList(this.field_72771_w); GL11.glDisable(2912); GL11.glDisable(3008); GL11.glEnable(3042); OpenGlHelper.func_148821_a(770, 771, 1, 0); RenderHelper.func_74518_a(); float[] arrayOfFloat = this.field_72769_h.field_73011_w.func_76560_a(this.field_72769_h.func_72826_c(p_72714_1_), p_72714_1_); if (arrayOfFloat != null) { GL11.glDisable(3553); GL11.glShadeModel(7425); GL11.glPushMatrix(); GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F); GL11.glRotatef((MathHelper.func_76126_a(this.field_72769_h.func_72929_e(p_72714_1_)) < 0.0F) ? 180.0F : 0.0F, 0.0F, 0.0F, 1.0F); GL11.glRotatef(90.0F, 0.0F, 0.0F, 1.0F); float f14 = arrayOfFloat[0]; float f15 = arrayOfFloat[1]; float f16 = arrayOfFloat[2]; if (this.field_72777_q.field_71474_y.field_74337_g) { float f17 = (f14 * 30.0F + f15 * 59.0F + f16 * 11.0F) / 100.0F; float f18 = (f14 * 30.0F + f15 * 70.0F) / 100.0F; float f19 = (f14 * 30.0F + f16 * 70.0F) / 100.0F; f14 = f17; f15 = f18; f16 = f19; }  tessellator.func_78371_b(6); tessellator.func_78369_a(f14, f15, f16, arrayOfFloat[3]); tessellator.func_78377_a(0.0D, 100.0D, 0.0D); byte b1 = 16; tessellator.func_78369_a(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2], 0.0F); for (byte b2 = 0; b2 <= b1; b2++) { float f17 = b2 * 3.1415927F * 2.0F / b1; float f18 = MathHelper.func_76126_a(f17); float f19 = MathHelper.func_76134_b(f17); tessellator.func_78377_a((f18 * 120.0F), (f19 * 120.0F), (-f19 * 40.0F * arrayOfFloat[3])); }  tessellator.func_78381_a(); GL11.glPopMatrix(); GL11.glShadeModel(7424); }  GL11.glEnable(3553); OpenGlHelper.func_148821_a(770, 1, 1, 0); GL11.glPushMatrix(); float f4 = 1.0F - this.field_72769_h.func_72867_j(p_72714_1_); float f5 = 0.0F; float f6 = 0.0F; float f7 = 0.0F; GL11.glColor4f(1.0F, 1.0F, 1.0F, f4); GL11.glTranslatef(f5, f6, f7); GL11.glRotatef(-90.0F, 0.0F, 1.0F, 0.0F); GL11.glRotatef(this.field_72769_h.func_72826_c(p_72714_1_) * 360.0F, 1.0F, 0.0F, 0.0F); float f8 = 30.0F; this.field_72770_i.func_110577_a(field_110928_i); tessellator.func_78382_b(); tessellator.func_78374_a(-f8, 100.0D, -f8, 0.0D, 0.0D); tessellator.func_78374_a(f8, 100.0D, -f8, 1.0D, 0.0D); tessellator.func_78374_a(f8, 100.0D, f8, 1.0D, 1.0D); tessellator.func_78374_a(-f8, 100.0D, f8, 0.0D, 1.0D); tessellator.func_78381_a(); f8 = 20.0F; this.field_72770_i.func_110577_a(field_110927_h); int i = this.field_72769_h.func_72853_d(); int j = i % 4; int k = i / 4 % 2; float f9 = (j + 0) / 4.0F; float f10 = (k + 0) / 2.0F; float f11 = (j + 1) / 4.0F; float f12 = (k + 1) / 2.0F; tessellator.func_78382_b(); tessellator.func_78374_a(-f8, -100.0D, f8, f11, f12); tessellator.func_78374_a(f8, -100.0D, f8, f9, f12); tessellator.func_78374_a(f8, -100.0D, -f8, f9, f10); tessellator.func_78374_a(-f8, -100.0D, -f8, f11, f10); tessellator.func_78381_a(); GL11.glDisable(3553); float f13 = this.field_72769_h.func_72880_h(p_72714_1_) * f4; if (f13 > 0.0F) { GL11.glColor4f(f13, f13, f13, f13); GL11.glCallList(this.field_72772_v); }  GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F); GL11.glDisable(3042); GL11.glEnable(3008); GL11.glEnable(2912); GL11.glPopMatrix(); GL11.glDisable(3553); GL11.glColor3f(0.0F, 0.0F, 0.0F); double d = (this.field_72777_q.field_71439_g.func_70666_h(p_72714_1_)).field_72448_b - this.field_72769_h.func_72919_O(); if (d < 0.0D) { GL11.glPushMatrix(); GL11.glTranslatef(0.0F, 12.0F, 0.0F); GL11.glCallList(this.field_72781_x); GL11.glPopMatrix(); f6 = 1.0F; f7 = -((float)(d + 65.0D)); f8 = -f6; float f = f7; tessellator.func_78382_b(); tessellator.func_78384_a(0, 255); tessellator.func_78377_a(-f6, f, f6); tessellator.func_78377_a(f6, f, f6); tessellator.func_78377_a(f6, f8, f6); tessellator.func_78377_a(-f6, f8, f6); tessellator.func_78377_a(-f6, f8, -f6); tessellator.func_78377_a(f6, f8, -f6); tessellator.func_78377_a(f6, f, -f6); tessellator.func_78377_a(-f6, f, -f6); tessellator.func_78377_a(f6, f8, -f6); tessellator.func_78377_a(f6, f8, f6); tessellator.func_78377_a(f6, f, f6); tessellator.func_78377_a(f6, f, -f6); tessellator.func_78377_a(-f6, f, -f6); tessellator.func_78377_a(-f6, f, f6); tessellator.func_78377_a(-f6, f8, f6); tessellator.func_78377_a(-f6, f8, -f6); tessellator.func_78377_a(-f6, f8, -f6); tessellator.func_78377_a(-f6, f8, f6); tessellator.func_78377_a(f6, f8, f6); tessellator.func_78377_a(f6, f8, -f6); tessellator.func_78381_a(); }  if (this.field_72769_h.field_73011_w.func_76561_g()) { GL11.glColor3f(f1 * 0.2F + 0.04F, f2 * 0.2F + 0.04F, f3 * 0.6F + 0.1F); } else { GL11.glColor3f(f1, f2, f3); }  GL11.glPushMatrix(); GL11.glTranslatef(0.0F, -((float)(d - 16.0D)), 0.0F); GL11.glCallList(this.field_72781_x); GL11.glPopMatrix(); GL11.glEnable(3553); GL11.glDepthMask(true); } public void func_72718_b(float p_72718_1_) { if (!this.field_72777_q.field_71441_e.field_73011_w.func_76569_d()) return;  if (this.field_72777_q.field_71474_y.field_74347_j) { func_72736_c(p_72718_1_); return; }  GL11.glDisable(2884); float f1 = (float)(this.field_72777_q.field_71451_h.field_70137_T + (this.field_72777_q.field_71451_h.field_70163_u - this.field_72777_q.field_71451_h.field_70137_T) * p_72718_1_); byte b = 32; int i = 256 / b; Tessellator tessellator = Tessellator.field_78398_a; this.field_72770_i.func_110577_a(field_110925_j); GL11.glEnable(3042); OpenGlHelper.func_148821_a(770, 771, 1, 0); Vec3 vec3 = this.field_72769_h.func_72824_f(p_72718_1_); float f2 = (float)vec3.field_72450_a; float f3 = (float)vec3.field_72448_b; float f4 = (float)vec3.field_72449_c; if (this.field_72777_q.field_71474_y.field_74337_g) { float f9 = (f2 * 30.0F + f3 * 59.0F + f4 * 11.0F) / 100.0F; float f10 = (f2 * 30.0F + f3 * 70.0F) / 100.0F; float f11 = (f2 * 30.0F + f4 * 70.0F) / 100.0F; f2 = f9; f3 = f10; f4 = f11; }  float f5 = 4.8828125E-4F; double d1 = (this.field_72773_u + p_72718_1_); double d2 = this.field_72777_q.field_71451_h.field_70169_q + (this.field_72777_q.field_71451_h.field_70165_t - this.field_72777_q.field_71451_h.field_70169_q) * p_72718_1_ + d1 * 0.029999999329447746D; double d3 = this.field_72777_q.field_71451_h.field_70166_s + (this.field_72777_q.field_71451_h.field_70161_v - this.field_72777_q.field_71451_h.field_70166_s) * p_72718_1_; int j = MathHelper.func_76128_c(d2 / 2048.0D); int k = MathHelper.func_76128_c(d3 / 2048.0D); d2 -= (j * 2048); d3 -= (k * 2048); float f6 = this.field_72769_h.field_73011_w.func_76571_f() - f1 + 0.33F; float f7 = (float)(d2 * f5); float f8 = (float)(d3 * f5); tessellator.func_78382_b(); tessellator.func_78369_a(f2, f3, f4, 0.8F); int m; for (m = -b * i; m < b * i; m += b) { int n; for (n = -b * i; n < b * i; n += b) { tessellator.func_78374_a((m + 0), f6, (n + b), ((m + 0) * f5 + f7), ((n + b) * f5 + f8)); tessellator.func_78374_a((m + b), f6, (n + b), ((m + b) * f5 + f7), ((n + b) * f5 + f8)); tessellator.func_78374_a((m + b), f6, (n + 0), ((m + b) * f5 + f7), ((n + 0) * f5 + f8)); tessellator.func_78374_a((m + 0), f6, (n + 0), ((m + 0) * f5 + f7), ((n + 0) * f5 + f8)); }  }  tessellator.func_78381_a(); GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F); GL11.glDisable(3042); GL11.glEnable(2884); } public boolean func_72721_a(double p_72721_1_, double p_72721_3_, double p_72721_5_, float p_72721_7_) { return false; } public void func_72736_c(float p_72736_1_) { GL11.glDisable(2884); float f1 = (float)(this.field_72777_q.field_71451_h.field_70137_T + (this.field_72777_q.field_71451_h.field_70163_u - this.field_72777_q.field_71451_h.field_70137_T) * p_72736_1_); Tessellator tessellator = Tessellator.field_78398_a; float f2 = 12.0F; float f3 = 4.0F; double d1 = (this.field_72773_u + p_72736_1_); double d2 = (this.field_72777_q.field_71451_h.field_70169_q + (this.field_72777_q.field_71451_h.field_70165_t - this.field_72777_q.field_71451_h.field_70169_q) * p_72736_1_ + d1 * 0.029999999329447746D) / f2; double d3 = (this.field_72777_q.field_71451_h.field_70166_s + (this.field_72777_q.field_71451_h.field_70161_v - this.field_72777_q.field_71451_h.field_70166_s) * p_72736_1_) / f2 + 0.33000001311302185D; float f4 = this.field_72769_h.field_73011_w.func_76571_f() - f1 + 0.33F; int i = MathHelper.func_76128_c(d2 / 2048.0D); int j = MathHelper.func_76128_c(d3 / 2048.0D); d2 -= (i * 2048); d3 -= (j * 2048); this.field_72770_i.func_110577_a(field_110925_j); GL11.glEnable(3042); OpenGlHelper.func_148821_a(770, 771, 1, 0); Vec3 vec3 = this.field_72769_h.func_72824_f(p_72736_1_); float f5 = (float)vec3.field_72450_a; float f6 = (float)vec3.field_72448_b; float f7 = (float)vec3.field_72449_c; if (this.field_72777_q.field_71474_y.field_74337_g) { float f14 = (f5 * 30.0F + f6 * 59.0F + f7 * 11.0F) / 100.0F; float f15 = (f5 * 30.0F + f6 * 70.0F) / 100.0F; float f16 = (f5 * 30.0F + f7 * 70.0F) / 100.0F; f5 = f14; f6 = f15; f7 = f16; }  float f8 = (float)(d2 * 0.0D); float f9 = (float)(d3 * 0.0D); float f10 = 0.00390625F; f8 = MathHelper.func_76128_c(d2) * f10; f9 = MathHelper.func_76128_c(d3) * f10; float f11 = (float)(d2 - MathHelper.func_76128_c(d2)); float f12 = (float)(d3 - MathHelper.func_76128_c(d3)); byte b1 = 8; byte b2 = 4; float f13 = 9.765625E-4F; GL11.glScalef(f2, 1.0F, f2); for (byte b3 = 0; b3 < 2; b3++) { if (b3 == 0) { GL11.glColorMask(false, false, false, false); } else if (this.field_72777_q.field_71474_y.field_74337_g) { if (EntityRenderer.field_78515_b == 0) { GL11.glColorMask(false, true, true, true); } else { GL11.glColorMask(true, false, false, true); }  } else { GL11.glColorMask(true, true, true, true); }  for (int k = -b2 + 1; k <= b2; k++) { for (int m = -b2 + 1; m <= b2; m++) { tessellator.func_78382_b(); float f14 = (k * b1); float f15 = (m * b1); float f16 = f14 - f11; float f17 = f15 - f12; if (f4 > -f3 - 1.0F) { tessellator.func_78369_a(f5 * 0.7F, f6 * 0.7F, f7 * 0.7F, 0.8F); tessellator.func_78375_b(0.0F, -1.0F, 0.0F); tessellator.func_78374_a((f16 + 0.0F), (f4 + 0.0F), (f17 + b1), ((f14 + 0.0F) * f10 + f8), ((f15 + b1) * f10 + f9)); tessellator.func_78374_a((f16 + b1), (f4 + 0.0F), (f17 + b1), ((f14 + b1) * f10 + f8), ((f15 + b1) * f10 + f9)); tessellator.func_78374_a((f16 + b1), (f4 + 0.0F), (f17 + 0.0F), ((f14 + b1) * f10 + f8), ((f15 + 0.0F) * f10 + f9)); tessellator.func_78374_a((f16 + 0.0F), (f4 + 0.0F), (f17 + 0.0F), ((f14 + 0.0F) * f10 + f8), ((f15 + 0.0F) * f10 + f9)); }  if (f4 <= f3 + 1.0F) { tessellator.func_78369_a(f5, f6, f7, 0.8F); tessellator.func_78375_b(0.0F, 1.0F, 0.0F); tessellator.func_78374_a((f16 + 0.0F), (f4 + f3 - f13), (f17 + b1), ((f14 + 0.0F) * f10 + f8), ((f15 + b1) * f10 + f9)); tessellator.func_78374_a((f16 + b1), (f4 + f3 - f13), (f17 + b1), ((f14 + b1) * f10 + f8), ((f15 + b1) * f10 + f9)); tessellator.func_78374_a((f16 + b1), (f4 + f3 - f13), (f17 + 0.0F), ((f14 + b1) * f10 + f8), ((f15 + 0.0F) * f10 + f9)); tessellator.func_78374_a((f16 + 0.0F), (f4 + f3 - f13), (f17 + 0.0F), ((f14 + 0.0F) * f10 + f8), ((f15 + 0.0F) * f10 + f9)); }  tessellator.func_78369_a(f5 * 0.9F, f6 * 0.9F, f7 * 0.9F, 0.8F); if (k > -1) { tessellator.func_78375_b(-1.0F, 0.0F, 0.0F); for (byte b = 0; b < b1; b++) { tessellator.func_78374_a((f16 + b + 0.0F), (f4 + 0.0F), (f17 + b1), ((f14 + b + 0.5F) * f10 + f8), ((f15 + b1) * f10 + f9)); tessellator.func_78374_a((f16 + b + 0.0F), (f4 + f3), (f17 + b1), ((f14 + b + 0.5F) * f10 + f8), ((f15 + b1) * f10 + f9)); tessellator.func_78374_a((f16 + b + 0.0F), (f4 + f3), (f17 + 0.0F), ((f14 + b + 0.5F) * f10 + f8), ((f15 + 0.0F) * f10 + f9)); tessellator.func_78374_a((f16 + b + 0.0F), (f4 + 0.0F), (f17 + 0.0F), ((f14 + b + 0.5F) * f10 + f8), ((f15 + 0.0F) * f10 + f9)); }  }  if (k <= 1) { tessellator.func_78375_b(1.0F, 0.0F, 0.0F); for (byte b = 0; b < b1; b++) { tessellator.func_78374_a((f16 + b + 1.0F - f13), (f4 + 0.0F), (f17 + b1), ((f14 + b + 0.5F) * f10 + f8), ((f15 + b1) * f10 + f9)); tessellator.func_78374_a((f16 + b + 1.0F - f13), (f4 + f3), (f17 + b1), ((f14 + b + 0.5F) * f10 + f8), ((f15 + b1) * f10 + f9)); tessellator.func_78374_a((f16 + b + 1.0F - f13), (f4 + f3), (f17 + 0.0F), ((f14 + b + 0.5F) * f10 + f8), ((f15 + 0.0F) * f10 + f9)); tessellator.func_78374_a((f16 + b + 1.0F - f13), (f4 + 0.0F), (f17 + 0.0F), ((f14 + b + 0.5F) * f10 + f8), ((f15 + 0.0F) * f10 + f9)); }  }  tessellator.func_78369_a(f5 * 0.8F, f6 * 0.8F, f7 * 0.8F, 0.8F); if (m > -1) { tessellator.func_78375_b(0.0F, 0.0F, -1.0F); for (byte b = 0; b < b1; b++) { tessellator.func_78374_a((f16 + 0.0F), (f4 + f3), (f17 + b + 0.0F), ((f14 + 0.0F) * f10 + f8), ((f15 + b + 0.5F) * f10 + f9)); tessellator.func_78374_a((f16 + b1), (f4 + f3), (f17 + b + 0.0F), ((f14 + b1) * f10 + f8), ((f15 + b + 0.5F) * f10 + f9)); tessellator.func_78374_a((f16 + b1), (f4 + 0.0F), (f17 + b + 0.0F), ((f14 + b1) * f10 + f8), ((f15 + b + 0.5F) * f10 + f9)); tessellator.func_78374_a((f16 + 0.0F), (f4 + 0.0F), (f17 + b + 0.0F), ((f14 + 0.0F) * f10 + f8), ((f15 + b + 0.5F) * f10 + f9)); }  }  if (m <= 1) { tessellator.func_78375_b(0.0F, 0.0F, 1.0F); for (byte b = 0; b < b1; b++) { tessellator.func_78374_a((f16 + 0.0F), (f4 + f3), (f17 + b + 1.0F - f13), ((f14 + 0.0F) * f10 + f8), ((f15 + b + 0.5F) * f10 + f9)); tessellator.func_78374_a((f16 + b1), (f4 + f3), (f17 + b + 1.0F - f13), ((f14 + b1) * f10 + f8), ((f15 + b + 0.5F) * f10 + f9)); tessellator.func_78374_a((f16 + b1), (f4 + 0.0F), (f17 + b + 1.0F - f13), ((f14 + b1) * f10 + f8), ((f15 + b + 0.5F) * f10 + f9)); tessellator.func_78374_a((f16 + 0.0F), (f4 + 0.0F), (f17 + b + 1.0F - f13), ((f14 + 0.0F) * f10 + f8), ((f15 + b + 0.5F) * f10 + f9)); }  }  tessellator.func_78381_a(); }  }  }  GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F); GL11.glDisable(3042); GL11.glEnable(2884); } public void func_72717_a(Tessellator p_72717_1_, EntityPlayer p_72717_2_, float p_72717_3_) { double d1 = p_72717_2_.field_70142_S + (p_72717_2_.field_70165_t - p_72717_2_.field_70142_S) * p_72717_3_;
/* 1326 */     double d2 = p_72717_2_.field_70137_T + (p_72717_2_.field_70163_u - p_72717_2_.field_70137_T) * p_72717_3_;
/* 1327 */     double d3 = p_72717_2_.field_70136_U + (p_72717_2_.field_70161_v - p_72717_2_.field_70136_U) * p_72717_3_;
/*      */     
/* 1329 */     if (!this.field_72738_E.isEmpty()) {
/* 1330 */       OpenGlHelper.func_148821_a(774, 768, 1, 0);
/*      */       
/* 1332 */       this.field_72770_i.func_110577_a(TextureMap.field_110575_b);
/* 1333 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.5F);
/* 1334 */       GL11.glPushMatrix();
/* 1335 */       GL11.glPolygonOffset(-3.0F, -3.0F);
/* 1336 */       GL11.glEnable(32823);
/* 1337 */       GL11.glAlphaFunc(516, 0.1F);
/* 1338 */       GL11.glEnable(3008);
/* 1339 */       p_72717_1_.func_78382_b();
/* 1340 */       p_72717_1_.func_78373_b(-d1, -d2, -d3);
/* 1341 */       p_72717_1_.func_78383_c();
/*      */       
/* 1343 */       Iterator<DestroyBlockProgress> iterator = this.field_72738_E.values().iterator();
/* 1344 */       while (iterator.hasNext()) {
/* 1345 */         DestroyBlockProgress destroyBlockProgress = iterator.next();
/* 1346 */         double d4 = destroyBlockProgress.func_73110_b() - d1;
/* 1347 */         double d5 = destroyBlockProgress.func_73109_c() - d2;
/* 1348 */         double d6 = destroyBlockProgress.func_73108_d() - d3;
/*      */         
/* 1350 */         if (d4 * d4 + d5 * d5 + d6 * d6 > 1024.0D) {
/* 1351 */           iterator.remove(); continue;
/*      */         } 
/* 1353 */         Block block = this.field_72769_h.func_147439_a(destroyBlockProgress.func_73110_b(), destroyBlockProgress.func_73109_c(), destroyBlockProgress.func_73108_d());
/* 1354 */         if (block.func_149688_o() != Material.field_151579_a)
/*      */         {
/* 1356 */           this.field_147592_B.func_147792_a(block, destroyBlockProgress.func_73110_b(), destroyBlockProgress.func_73109_c(), destroyBlockProgress.func_73108_d(), this.field_94141_F[destroyBlockProgress.func_73106_e()]);
/*      */         }
/*      */       } 
/*      */ 
/*      */       
/* 1361 */       p_72717_1_.func_78381_a();
/* 1362 */       p_72717_1_.func_78373_b(0.0D, 0.0D, 0.0D);
/* 1363 */       GL11.glDisable(3008);
/* 1364 */       GL11.glPolygonOffset(0.0F, 0.0F);
/* 1365 */       GL11.glDisable(32823);
/* 1366 */       GL11.glEnable(3008);
/*      */       
/* 1368 */       GL11.glDepthMask(true);
/* 1369 */       GL11.glPopMatrix();
/*      */     }  }
/*      */ 
/*      */   
/*      */   public void func_72731_b(EntityPlayer p_72731_1_, MovingObjectPosition p_72731_2_, int p_72731_3_, float p_72731_4_) {
/* 1374 */     if (p_72731_3_ == 0 && p_72731_2_.field_72313_a == MovingObjectPosition.MovingObjectType.BLOCK) {
/* 1375 */       GL11.glEnable(3042);
/* 1376 */       OpenGlHelper.func_148821_a(770, 771, 1, 0);
/* 1377 */       GL11.glColor4f(0.0F, 0.0F, 0.0F, 0.4F);
/* 1378 */       GL11.glLineWidth(2.0F);
/* 1379 */       GL11.glDisable(3553);
/* 1380 */       GL11.glDepthMask(false);
/* 1381 */       float f = 0.002F;
/*      */       
/* 1383 */       Block block = this.field_72769_h.func_147439_a(p_72731_2_.field_72311_b, p_72731_2_.field_72312_c, p_72731_2_.field_72309_d);
/* 1384 */       if (block.func_149688_o() != Material.field_151579_a) {
/* 1385 */         block.func_149719_a((IBlockAccess)this.field_72769_h, p_72731_2_.field_72311_b, p_72731_2_.field_72312_c, p_72731_2_.field_72309_d);
/* 1386 */         double d1 = p_72731_1_.field_70142_S + (p_72731_1_.field_70165_t - p_72731_1_.field_70142_S) * p_72731_4_;
/* 1387 */         double d2 = p_72731_1_.field_70137_T + (p_72731_1_.field_70163_u - p_72731_1_.field_70137_T) * p_72731_4_;
/* 1388 */         double d3 = p_72731_1_.field_70136_U + (p_72731_1_.field_70161_v - p_72731_1_.field_70136_U) * p_72731_4_;
/* 1389 */         func_147590_a(block.func_149633_g((World)this.field_72769_h, p_72731_2_.field_72311_b, p_72731_2_.field_72312_c, p_72731_2_.field_72309_d).func_72314_b(f, f, f).func_72325_c(-d1, -d2, -d3), -1);
/*      */       } 
/* 1391 */       GL11.glDepthMask(true);
/* 1392 */       GL11.glEnable(3553);
/* 1393 */       GL11.glDisable(3042);
/*      */     } 
/*      */   }
/*      */   
/*      */   public static void func_147590_a(AxisAlignedBB p_147590_0_, int p_147590_1_) {
/* 1398 */     Tessellator tessellator = Tessellator.field_78398_a;
/*      */     
/* 1400 */     tessellator.func_78371_b(3);
/* 1401 */     if (p_147590_1_ != -1) {
/* 1402 */       tessellator.func_78378_d(p_147590_1_);
/*      */     }
/* 1404 */     tessellator.func_78377_a(p_147590_0_.field_72340_a, p_147590_0_.field_72338_b, p_147590_0_.field_72339_c);
/* 1405 */     tessellator.func_78377_a(p_147590_0_.field_72336_d, p_147590_0_.field_72338_b, p_147590_0_.field_72339_c);
/* 1406 */     tessellator.func_78377_a(p_147590_0_.field_72336_d, p_147590_0_.field_72338_b, p_147590_0_.field_72334_f);
/* 1407 */     tessellator.func_78377_a(p_147590_0_.field_72340_a, p_147590_0_.field_72338_b, p_147590_0_.field_72334_f);
/* 1408 */     tessellator.func_78377_a(p_147590_0_.field_72340_a, p_147590_0_.field_72338_b, p_147590_0_.field_72339_c);
/* 1409 */     tessellator.func_78381_a();
/*      */     
/* 1411 */     tessellator.func_78371_b(3);
/* 1412 */     if (p_147590_1_ != -1) {
/* 1413 */       tessellator.func_78378_d(p_147590_1_);
/*      */     }
/* 1415 */     tessellator.func_78377_a(p_147590_0_.field_72340_a, p_147590_0_.field_72337_e, p_147590_0_.field_72339_c);
/* 1416 */     tessellator.func_78377_a(p_147590_0_.field_72336_d, p_147590_0_.field_72337_e, p_147590_0_.field_72339_c);
/* 1417 */     tessellator.func_78377_a(p_147590_0_.field_72336_d, p_147590_0_.field_72337_e, p_147590_0_.field_72334_f);
/* 1418 */     tessellator.func_78377_a(p_147590_0_.field_72340_a, p_147590_0_.field_72337_e, p_147590_0_.field_72334_f);
/* 1419 */     tessellator.func_78377_a(p_147590_0_.field_72340_a, p_147590_0_.field_72337_e, p_147590_0_.field_72339_c);
/* 1420 */     tessellator.func_78381_a();
/*      */     
/* 1422 */     tessellator.func_78371_b(1);
/* 1423 */     if (p_147590_1_ != -1) {
/* 1424 */       tessellator.func_78378_d(p_147590_1_);
/*      */     }
/* 1426 */     tessellator.func_78377_a(p_147590_0_.field_72340_a, p_147590_0_.field_72338_b, p_147590_0_.field_72339_c);
/* 1427 */     tessellator.func_78377_a(p_147590_0_.field_72340_a, p_147590_0_.field_72337_e, p_147590_0_.field_72339_c);
/* 1428 */     tessellator.func_78377_a(p_147590_0_.field_72336_d, p_147590_0_.field_72338_b, p_147590_0_.field_72339_c);
/* 1429 */     tessellator.func_78377_a(p_147590_0_.field_72336_d, p_147590_0_.field_72337_e, p_147590_0_.field_72339_c);
/* 1430 */     tessellator.func_78377_a(p_147590_0_.field_72336_d, p_147590_0_.field_72338_b, p_147590_0_.field_72334_f);
/* 1431 */     tessellator.func_78377_a(p_147590_0_.field_72336_d, p_147590_0_.field_72337_e, p_147590_0_.field_72334_f);
/* 1432 */     tessellator.func_78377_a(p_147590_0_.field_72340_a, p_147590_0_.field_72338_b, p_147590_0_.field_72334_f);
/* 1433 */     tessellator.func_78377_a(p_147590_0_.field_72340_a, p_147590_0_.field_72337_e, p_147590_0_.field_72334_f);
/* 1434 */     tessellator.func_78381_a();
/*      */   }
/*      */   
/*      */   public void func_72725_b(int p_72725_1_, int p_72725_2_, int p_72725_3_, int p_72725_4_, int p_72725_5_, int p_72725_6_) {
/* 1438 */     int i = MathHelper.func_76137_a(p_72725_1_, 16);
/* 1439 */     int j = MathHelper.func_76137_a(p_72725_2_, 16);
/* 1440 */     int k = MathHelper.func_76137_a(p_72725_3_, 16);
/* 1441 */     int m = MathHelper.func_76137_a(p_72725_4_, 16);
/* 1442 */     int n = MathHelper.func_76137_a(p_72725_5_, 16);
/* 1443 */     int i1 = MathHelper.func_76137_a(p_72725_6_, 16);
/*      */     
/* 1445 */     for (int i2 = i; i2 <= m; i2++) {
/* 1446 */       int i3 = i2 % this.field_72766_m;
/* 1447 */       if (i3 < 0) i3 += this.field_72766_m; 
/* 1448 */       for (int i4 = j; i4 <= n; i4++) {
/* 1449 */         int i5 = i4 % this.field_72763_n;
/* 1450 */         if (i5 < 0) i5 += this.field_72763_n; 
/* 1451 */         for (int i6 = k; i6 <= i1; i6++) {
/* 1452 */           int i7 = i6 % this.field_72764_o;
/* 1453 */           if (i7 < 0) i7 += this.field_72764_o;
/*      */           
/* 1455 */           int i8 = (i7 * this.field_72763_n + i5) * this.field_72766_m + i3;
/* 1456 */           WorldRenderer worldRenderer = this.field_72765_l[i8];
/* 1457 */           if (worldRenderer != null && !worldRenderer.field_78939_q) {
/* 1458 */             this.field_72767_j.add(worldRenderer);
/* 1459 */             worldRenderer.func_78914_f();
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_147586_a(int p_147586_1_, int p_147586_2_, int p_147586_3_) {
/* 1468 */     func_72725_b(p_147586_1_ - 1, p_147586_2_ - 1, p_147586_3_ - 1, p_147586_1_ + 1, p_147586_2_ + 1, p_147586_3_ + 1);
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_147588_b(int p_147588_1_, int p_147588_2_, int p_147588_3_) {
/* 1473 */     func_72725_b(p_147588_1_ - 1, p_147588_2_ - 1, p_147588_3_ - 1, p_147588_1_ + 1, p_147588_2_ + 1, p_147588_3_ + 1);
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_147585_a(int p_147585_1_, int p_147585_2_, int p_147585_3_, int p_147585_4_, int p_147585_5_, int p_147585_6_) {
/* 1478 */     func_72725_b(p_147585_1_ - 1, p_147585_2_ - 1, p_147585_3_ - 1, p_147585_4_ + 1, p_147585_5_ + 1, p_147585_6_ + 1);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_72729_a(ICamera p_72729_1_, float p_72729_2_) {
/* 1484 */     for (byte b = 0; b < this.field_72765_l.length; b++) {
/* 1485 */       if (!this.field_72765_l[b].func_78906_e() && (
/* 1486 */         !(this.field_72765_l[b]).field_78927_l || (b + this.field_72757_g & 0xF) == 0)) {
/* 1487 */         this.field_72765_l[b].func_78908_a(p_72729_1_);
/*      */       }
/*      */     } 
/*      */     
/* 1491 */     this.field_72757_g++;
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_72702_a(String p_72702_1_, int p_72702_2_, int p_72702_3_, int p_72702_4_) {
/* 1496 */     ChunkCoordinates chunkCoordinates = new ChunkCoordinates(p_72702_2_, p_72702_3_, p_72702_4_);
/* 1497 */     ISound iSound = (ISound)this.field_147593_P.get(chunkCoordinates);
/*      */     
/* 1499 */     if (iSound != null) {
/* 1500 */       this.field_72777_q.func_147118_V().func_147683_b(iSound);
/* 1501 */       this.field_147593_P.remove(chunkCoordinates);
/*      */     } 
/*      */     
/* 1504 */     if (p_72702_1_ != null) {
/* 1505 */       ItemRecord itemRecord = ItemRecord.func_150926_b(p_72702_1_);
/* 1506 */       if (itemRecord != null) {
/* 1507 */         this.field_72777_q.field_71456_v.func_73833_a(itemRecord.func_150927_i());
/*      */       }
/* 1509 */       PositionedSoundRecord positionedSoundRecord = PositionedSoundRecord.func_147675_a(new ResourceLocation(p_72702_1_), p_72702_2_, p_72702_3_, p_72702_4_);
/* 1510 */       this.field_147593_P.put(chunkCoordinates, positionedSoundRecord);
/* 1511 */       this.field_72777_q.func_147118_V().func_147682_a((ISound)positionedSoundRecord);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_72704_a(String p_72704_1_, double p_72704_2_, double p_72704_4_, double p_72704_6_, float p_72704_8_, float p_72704_9_) {}
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_85102_a(EntityPlayer p_85102_1_, String p_85102_2_, double p_85102_3_, double p_85102_5_, double p_85102_7_, float p_85102_9_, float p_85102_10_) {}
/*      */ 
/*      */   
/*      */   public void func_72708_a(String p_72708_1_, double p_72708_2_, double p_72708_4_, double p_72708_6_, double p_72708_8_, double p_72708_10_, double p_72708_12_) {
/*      */     try {
/* 1526 */       func_72726_b(p_72708_1_, p_72708_2_, p_72708_4_, p_72708_6_, p_72708_8_, p_72708_10_, p_72708_12_);
/* 1527 */     } catch (Throwable throwable) {
/* 1528 */       CrashReport crashReport = CrashReport.func_85055_a(throwable, "Exception while adding particle");
/* 1529 */       CrashReportCategory crashReportCategory = crashReport.func_85058_a("Particle being added");
/*      */       
/* 1531 */       crashReportCategory.func_71507_a("Name", p_72708_1_);
/* 1532 */       crashReportCategory.func_71500_a("Position", new Callable(this, p_72708_2_, p_72708_4_, p_72708_6_) { private static final String __OBFID = "CL_00000955";
/*      */             
/*      */             public String call() {
/* 1535 */               return CrashReportCategory.func_85074_a(this.field_85101_a, this.field_85099_b, this.field_85100_c);
/*      */             } }
/*      */         );
/*      */       
/* 1539 */       throw new ReportedException(crashReport);
/*      */     } 
/*      */   } public EntityFX func_72726_b(String p_72726_1_, double p_72726_2_, double p_72726_4_, double p_72726_6_, double p_72726_8_, double p_72726_10_, double p_72726_12_) {
/*      */     EntityFireworkSparkFX entityFireworkSparkFX;
/*      */     EntityDiggingFX entityDiggingFX;
/* 1544 */     if (this.field_72777_q == null || this.field_72777_q.field_71451_h == null || this.field_72777_q.field_71452_i == null) {
/* 1545 */       return null;
/*      */     }
/*      */     
/* 1548 */     int i = this.field_72777_q.field_71474_y.field_74362_aa;
/*      */     
/* 1550 */     if (i == 1)
/*      */     {
/* 1552 */       if (this.field_72769_h.field_73012_v.nextInt(3) == 0) {
/* 1553 */         i = 2;
/*      */       }
/*      */     }
/*      */     
/* 1557 */     double d1 = this.field_72777_q.field_71451_h.field_70165_t - p_72726_2_;
/* 1558 */     double d2 = this.field_72777_q.field_71451_h.field_70163_u - p_72726_4_;
/* 1559 */     double d3 = this.field_72777_q.field_71451_h.field_70161_v - p_72726_6_;
/*      */     
/* 1561 */     EntityHugeExplodeFX entityHugeExplodeFX = null;
/* 1562 */     if (p_72726_1_.equals("hugeexplosion")) { this.field_72777_q.field_71452_i.func_78873_a((EntityFX)(entityHugeExplodeFX = new EntityHugeExplodeFX((World)this.field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_))); }
/* 1563 */     else if (p_72726_1_.equals("largeexplode")) { EntityLargeExplodeFX entityLargeExplodeFX; this.field_72777_q.field_71452_i.func_78873_a((EntityFX)(entityLargeExplodeFX = new EntityLargeExplodeFX(this.field_72770_i, (World)this.field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_))); }
/* 1564 */     else if (p_72726_1_.equals("fireworksSpark"))
/* 1565 */     { this.field_72777_q.field_71452_i.func_78873_a((EntityFX)(entityFireworkSparkFX = new EntityFireworkSparkFX((World)this.field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_, this.field_72777_q.field_71452_i))); }
/*      */ 
/*      */     
/* 1568 */     if (entityFireworkSparkFX != null) {
/* 1569 */       return (EntityFX)entityFireworkSparkFX;
/*      */     }
/*      */     
/* 1572 */     double d4 = 16.0D;
/* 1573 */     if (d1 * d1 + d2 * d2 + d3 * d3 > d4 * d4) {
/* 1574 */       return null;
/*      */     }
/*      */     
/* 1577 */     if (i > 1)
/*      */     {
/* 1579 */       return null;
/*      */     }
/*      */     
/* 1582 */     if (p_72726_1_.equals("bubble")) { EntityBubbleFX entityBubbleFX = new EntityBubbleFX((World)this.field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_); }
/* 1583 */     else if (p_72726_1_.equals("suspended")) { EntitySuspendFX entitySuspendFX = new EntitySuspendFX((World)this.field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_); }
/* 1584 */     else if (p_72726_1_.equals("depthsuspend")) { EntityAuraFX entityAuraFX = new EntityAuraFX((World)this.field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_); }
/* 1585 */     else if (p_72726_1_.equals("townaura")) { EntityAuraFX entityAuraFX = new EntityAuraFX((World)this.field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_); }
/* 1586 */     else if (p_72726_1_.equals("crit")) { EntityCritFX entityCritFX = new EntityCritFX((World)this.field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_); }
/* 1587 */     else if (p_72726_1_.equals("magicCrit"))
/* 1588 */     { EntityCritFX entityCritFX = new EntityCritFX((World)this.field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
/* 1589 */       entityCritFX.func_70538_b(entityCritFX.func_70534_d() * 0.3F, entityCritFX.func_70542_f() * 0.8F, entityCritFX.func_70535_g());
/* 1590 */       entityCritFX.func_94053_h(); }
/* 1591 */     else if (p_72726_1_.equals("smoke")) { EntitySmokeFX entitySmokeFX = new EntitySmokeFX((World)this.field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_); }
/* 1592 */     else if (p_72726_1_.equals("mobSpell"))
/* 1593 */     { EntitySpellParticleFX entitySpellParticleFX = new EntitySpellParticleFX((World)this.field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, 0.0D, 0.0D, 0.0D);
/* 1594 */       entitySpellParticleFX.func_70538_b((float)p_72726_8_, (float)p_72726_10_, (float)p_72726_12_); }
/* 1595 */     else if (p_72726_1_.equals("mobSpellAmbient"))
/* 1596 */     { EntitySpellParticleFX entitySpellParticleFX = new EntitySpellParticleFX((World)this.field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, 0.0D, 0.0D, 0.0D);
/* 1597 */       entitySpellParticleFX.func_82338_g(0.15F);
/* 1598 */       entitySpellParticleFX.func_70538_b((float)p_72726_8_, (float)p_72726_10_, (float)p_72726_12_); }
/* 1599 */     else if (p_72726_1_.equals("spell")) { EntitySpellParticleFX entitySpellParticleFX = new EntitySpellParticleFX((World)this.field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_); }
/* 1600 */     else if (p_72726_1_.equals("instantSpell"))
/* 1601 */     { EntitySpellParticleFX entitySpellParticleFX = new EntitySpellParticleFX((World)this.field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
/* 1602 */       entitySpellParticleFX.func_70589_b(144); }
/* 1603 */     else if (p_72726_1_.equals("witchMagic"))
/* 1604 */     { EntitySpellParticleFX entitySpellParticleFX = new EntitySpellParticleFX((World)this.field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
/* 1605 */       entitySpellParticleFX.func_70589_b(144);
/* 1606 */       float f = this.field_72769_h.field_73012_v.nextFloat() * 0.5F + 0.35F;
/* 1607 */       entitySpellParticleFX.func_70538_b(1.0F * f, 0.0F * f, 1.0F * f); }
/* 1608 */     else if (p_72726_1_.equals("note")) { EntityNoteFX entityNoteFX = new EntityNoteFX((World)this.field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_); }
/* 1609 */     else if (p_72726_1_.equals("portal")) { EntityPortalFX entityPortalFX = new EntityPortalFX((World)this.field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_); }
/* 1610 */     else if (p_72726_1_.equals("enchantmenttable")) { EntityEnchantmentTableParticleFX entityEnchantmentTableParticleFX = new EntityEnchantmentTableParticleFX((World)this.field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_); }
/* 1611 */     else if (p_72726_1_.equals("explode")) { EntityExplodeFX entityExplodeFX = new EntityExplodeFX((World)this.field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_); }
/* 1612 */     else if (p_72726_1_.equals("flame")) { EntityFlameFX entityFlameFX = new EntityFlameFX((World)this.field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_); }
/* 1613 */     else if (p_72726_1_.equals("lava")) { EntityLavaFX entityLavaFX = new EntityLavaFX((World)this.field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_); }
/* 1614 */     else if (p_72726_1_.equals("footstep")) { EntityFootStepFX entityFootStepFX = new EntityFootStepFX(this.field_72770_i, (World)this.field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_); }
/* 1615 */     else if (p_72726_1_.equals("splash")) { EntitySplashFX entitySplashFX = new EntitySplashFX((World)this.field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_); }
/* 1616 */     else if (p_72726_1_.equals("wake")) { EntityFishWakeFX entityFishWakeFX = new EntityFishWakeFX((World)this.field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_); }
/* 1617 */     else if (p_72726_1_.equals("largesmoke")) { EntitySmokeFX entitySmokeFX = new EntitySmokeFX((World)this.field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_, 2.5F); }
/* 1618 */     else if (p_72726_1_.equals("cloud")) { EntityCloudFX entityCloudFX = new EntityCloudFX((World)this.field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_); }
/* 1619 */     else if (p_72726_1_.equals("reddust")) { EntityReddustFX entityReddustFX = new EntityReddustFX((World)this.field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, (float)p_72726_8_, (float)p_72726_10_, (float)p_72726_12_); }
/* 1620 */     else if (p_72726_1_.equals("snowballpoof")) { EntityBreakingFX entityBreakingFX = new EntityBreakingFX((World)this.field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, Items.field_151126_ay); }
/* 1621 */     else if (p_72726_1_.equals("dripWater")) { EntityDropParticleFX entityDropParticleFX = new EntityDropParticleFX((World)this.field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, Material.field_151586_h); }
/* 1622 */     else if (p_72726_1_.equals("dripLava")) { EntityDropParticleFX entityDropParticleFX = new EntityDropParticleFX((World)this.field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, Material.field_151587_i); }
/* 1623 */     else if (p_72726_1_.equals("snowshovel")) { EntitySnowShovelFX entitySnowShovelFX = new EntitySnowShovelFX((World)this.field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_); }
/* 1624 */     else if (p_72726_1_.equals("slime")) { EntityBreakingFX entityBreakingFX = new EntityBreakingFX((World)this.field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, Items.field_151123_aH); }
/* 1625 */     else if (p_72726_1_.equals("heart")) { EntityHeartFX entityHeartFX = new EntityHeartFX((World)this.field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_); }
/* 1626 */     else if (p_72726_1_.equals("angryVillager"))
/* 1627 */     { EntityHeartFX entityHeartFX = new EntityHeartFX((World)this.field_72769_h, p_72726_2_, p_72726_4_ + 0.5D, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
/* 1628 */       entityHeartFX.func_70536_a(81);
/* 1629 */       entityHeartFX.func_70538_b(1.0F, 1.0F, 1.0F); }
/* 1630 */     else if (p_72726_1_.equals("happyVillager"))
/* 1631 */     { EntityAuraFX entityAuraFX = new EntityAuraFX((World)this.field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
/* 1632 */       entityAuraFX.func_70536_a(82);
/* 1633 */       entityAuraFX.func_70538_b(1.0F, 1.0F, 1.0F); }
/* 1634 */     else if (p_72726_1_.startsWith("iconcrack_"))
/* 1635 */     { String[] arrayOfString = p_72726_1_.split("_", 3);
/* 1636 */       int j = Integer.parseInt(arrayOfString[1]);
/* 1637 */       if (arrayOfString.length > 2) {
/* 1638 */         int k = Integer.parseInt(arrayOfString[2]);
/* 1639 */         EntityBreakingFX entityBreakingFX = new EntityBreakingFX((World)this.field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_, Item.func_150899_d(j), k);
/*      */       } else {
/* 1641 */         EntityBreakingFX entityBreakingFX = new EntityBreakingFX((World)this.field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_, Item.func_150899_d(j), 0);
/*      */       }  }
/* 1643 */     else if (p_72726_1_.startsWith("blockcrack_"))
/* 1644 */     { String[] arrayOfString = p_72726_1_.split("_", 3);
/* 1645 */       Block block = Block.func_149729_e(Integer.parseInt(arrayOfString[1]));
/* 1646 */       int j = Integer.parseInt(arrayOfString[2]);
/* 1647 */       entityDiggingFX = (new EntityDiggingFX((World)this.field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_, block, j)).func_90019_g(j); }
/* 1648 */     else if (p_72726_1_.startsWith("blockdust_"))
/* 1649 */     { String[] arrayOfString = p_72726_1_.split("_", 3);
/* 1650 */       Block block = Block.func_149729_e(Integer.parseInt(arrayOfString[1]));
/* 1651 */       int j = Integer.parseInt(arrayOfString[2]);
/* 1652 */       entityDiggingFX = (new EntityBlockDustFX((World)this.field_72769_h, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_, block, j)).func_90019_g(j); }
/*      */ 
/*      */     
/* 1655 */     if (entityDiggingFX != null) {
/* 1656 */       this.field_72777_q.field_71452_i.func_78873_a((EntityFX)entityDiggingFX);
/*      */     }
/*      */     
/* 1659 */     return (EntityFX)entityDiggingFX;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_72703_a(Entity p_72703_1_) {}
/*      */ 
/*      */   
/*      */   public void func_72709_b(Entity p_72709_1_) {}
/*      */ 
/*      */   
/*      */   public void func_72728_f() {
/* 1671 */     GLAllocation.func_74523_b(this.field_72778_p);
/*      */   }
/*      */   
/*      */   public void func_82746_a(int p_82746_1_, int p_82746_2_, int p_82746_3_, int p_82746_4_, int p_82746_5_)
/*      */   {
/* 1676 */     Random random = this.field_72769_h.field_73012_v;
/*      */     
/* 1678 */     switch (p_82746_1_) {
/*      */       case 1013:
/*      */       case 1018:
/* 1681 */         if (this.field_72777_q.field_71451_h != null) {
/*      */           
/* 1683 */           double d1 = p_82746_2_ - this.field_72777_q.field_71451_h.field_70165_t;
/* 1684 */           double d2 = p_82746_3_ - this.field_72777_q.field_71451_h.field_70163_u;
/* 1685 */           double d3 = p_82746_4_ - this.field_72777_q.field_71451_h.field_70161_v;
/*      */           
/* 1687 */           double d4 = Math.sqrt(d1 * d1 + d2 * d2 + d3 * d3);
/* 1688 */           double d5 = this.field_72777_q.field_71451_h.field_70165_t;
/* 1689 */           double d6 = this.field_72777_q.field_71451_h.field_70163_u;
/* 1690 */           double d7 = this.field_72777_q.field_71451_h.field_70161_v;
/*      */           
/* 1692 */           if (d4 > 0.0D) {
/* 1693 */             d5 += d1 / d4 * 2.0D;
/* 1694 */             d6 += d2 / d4 * 2.0D;
/* 1695 */             d7 += d3 / d4 * 2.0D;
/*      */           } 
/* 1697 */           if (p_82746_1_ == 1013) {
/* 1698 */             this.field_72769_h.func_72980_b(d5, d6, d7, "mob.wither.spawn", 1.0F, 1.0F, false); break;
/* 1699 */           }  if (p_82746_1_ == 1018)
/* 1700 */             this.field_72769_h.func_72980_b(d5, d6, d7, "mob.enderdragon.end", 5.0F, 1.0F, false); 
/*      */         }  break;
/*      */     }  } public void func_72706_a(EntityPlayer p_72706_1_, int p_72706_2_, int p_72706_3_, int p_72706_4_, int p_72706_5_, int p_72706_6_) { int i; double d1; int j; double d2, d3, d4; String str1; byte b1;
/*      */     double d5;
/*      */     int k;
/*      */     byte b2;
/*      */     float f1, f2, f3;
/*      */     String str2;
/*      */     byte b3;
/* 1709 */     Random random = this.field_72769_h.field_73012_v;
/* 1710 */     Block block = null;
/* 1711 */     switch (p_72706_2_) {
/*      */       case 1001:
/* 1713 */         this.field_72769_h.func_72980_b(p_72706_3_, p_72706_4_, p_72706_5_, "random.click", 1.0F, 1.2F, false);
/*      */         break;
/*      */       case 1000:
/* 1716 */         this.field_72769_h.func_72980_b(p_72706_3_, p_72706_4_, p_72706_5_, "random.click", 1.0F, 1.0F, false);
/*      */         break;
/*      */       case 1002:
/* 1719 */         this.field_72769_h.func_72980_b(p_72706_3_, p_72706_4_, p_72706_5_, "random.bow", 1.0F, 1.2F, false);
/*      */         break;
/*      */       case 2000:
/* 1722 */         i = p_72706_6_ % 3 - 1;
/* 1723 */         j = p_72706_6_ / 3 % 3 - 1;
/* 1724 */         d2 = p_72706_3_ + i * 0.6D + 0.5D;
/* 1725 */         d3 = p_72706_4_ + 0.5D;
/* 1726 */         d4 = p_72706_5_ + j * 0.6D + 0.5D;
/* 1727 */         for (b2 = 0; b2 < 10; b2++) {
/* 1728 */           double d6 = random.nextDouble() * 0.2D + 0.01D;
/* 1729 */           double d7 = d2 + i * 0.01D + (random.nextDouble() - 0.5D) * j * 0.5D;
/* 1730 */           double d8 = d3 + (random.nextDouble() - 0.5D) * 0.5D;
/* 1731 */           double d9 = d4 + j * 0.01D + (random.nextDouble() - 0.5D) * i * 0.5D;
/* 1732 */           double d10 = i * d6 + random.nextGaussian() * 0.01D;
/* 1733 */           double d11 = -0.03D + random.nextGaussian() * 0.01D;
/* 1734 */           double d12 = j * d6 + random.nextGaussian() * 0.01D;
/* 1735 */           func_72708_a("smoke", d7, d8, d9, d10, d11, d12);
/*      */         } 
/*      */         break;
/*      */ 
/*      */       
/*      */       case 2003:
/* 1741 */         d1 = p_72706_3_ + 0.5D;
/* 1742 */         d2 = p_72706_4_;
/* 1743 */         d3 = p_72706_5_ + 0.5D;
/*      */         
/* 1745 */         str1 = "iconcrack_" + Item.func_150891_b(Items.field_151061_bv);
/* 1746 */         for (b1 = 0; b1 < 8; b1++) {
/* 1747 */           func_72708_a(str1, d1, d2, d3, random.nextGaussian() * 0.15D, random.nextDouble() * 0.2D, random.nextGaussian() * 0.15D);
/*      */         }
/* 1749 */         for (d5 = 0.0D; d5 < 6.283185307179586D; d5 += 0.15707963267948966D) {
/* 1750 */           func_72708_a("portal", d1 + Math.cos(d5) * 5.0D, d2 - 0.4D, d3 + Math.sin(d5) * 5.0D, Math.cos(d5) * -5.0D, 0.0D, Math.sin(d5) * -5.0D);
/* 1751 */           func_72708_a("portal", d1 + Math.cos(d5) * 5.0D, d2 - 0.4D, d3 + Math.sin(d5) * 5.0D, Math.cos(d5) * -7.0D, 0.0D, Math.sin(d5) * -7.0D);
/*      */         } 
/*      */         break;
/*      */ 
/*      */       
/*      */       case 2002:
/* 1757 */         d1 = p_72706_3_;
/* 1758 */         d2 = p_72706_4_;
/* 1759 */         d3 = p_72706_5_;
/*      */         
/* 1761 */         str1 = "iconcrack_" + Item.func_150891_b((Item)Items.field_151068_bn) + "_" + p_72706_6_;
/* 1762 */         for (k = 0; k < 8; k++) {
/* 1763 */           func_72708_a(str1, d1, d2, d3, random.nextGaussian() * 0.15D, random.nextDouble() * 0.2D, random.nextGaussian() * 0.15D);
/*      */         }
/*      */         
/* 1766 */         k = Items.field_151068_bn.func_77620_a(p_72706_6_);
/*      */         
/* 1768 */         f1 = (k >> 16 & 0xFF) / 255.0F;
/* 1769 */         f2 = (k >> 8 & 0xFF) / 255.0F;
/* 1770 */         f3 = (k >> 0 & 0xFF) / 255.0F;
/*      */         
/* 1772 */         str2 = "spell";
/* 1773 */         if (Items.field_151068_bn.func_77833_h(p_72706_6_)) {
/* 1774 */           str2 = "instantSpell";
/*      */         }
/*      */         
/* 1777 */         for (b3 = 0; b3 < 100; b3++) {
/* 1778 */           double d6 = random.nextDouble() * 4.0D;
/* 1779 */           double d7 = random.nextDouble() * Math.PI * 2.0D;
/* 1780 */           double d8 = Math.cos(d7) * d6;
/* 1781 */           double d9 = 0.01D + random.nextDouble() * 0.5D;
/* 1782 */           double d10 = Math.sin(d7) * d6;
/*      */           
/* 1784 */           EntityFX entityFX = func_72726_b(str2, d1 + d8 * 0.1D, d2 + 0.3D, d3 + d10 * 0.1D, d8, d9, d10);
/* 1785 */           if (entityFX != null) {
/* 1786 */             float f = 0.75F + random.nextFloat() * 0.25F;
/* 1787 */             entityFX.func_70538_b(f1 * f, f2 * f, f3 * f);
/* 1788 */             entityFX.func_70543_e((float)d6);
/*      */           } 
/*      */         } 
/* 1791 */         this.field_72769_h.func_72980_b(p_72706_3_ + 0.5D, p_72706_4_ + 0.5D, p_72706_5_ + 0.5D, "game.potion.smash", 1.0F, this.field_72769_h.field_73012_v.nextFloat() * 0.1F + 0.9F, false);
/*      */         break;
/*      */       case 2001:
/* 1794 */         block = Block.func_149729_e(p_72706_6_ & 0xFFF);
/* 1795 */         if (block.func_149688_o() != Material.field_151579_a) {
/* 1796 */           this.field_72777_q.func_147118_V().func_147682_a((ISound)new PositionedSoundRecord(new ResourceLocation(block.field_149762_H.func_150495_a()), (block.field_149762_H.func_150497_c() + 1.0F) / 2.0F, block.field_149762_H.func_150494_d() * 0.8F, p_72706_3_ + 0.5F, p_72706_4_ + 0.5F, p_72706_5_ + 0.5F));
/*      */         }
/* 1798 */         this.field_72777_q.field_71452_i.func_147215_a(p_72706_3_, p_72706_4_, p_72706_5_, block, p_72706_6_ >> 12 & 0xFF);
/*      */         break;
/*      */       case 2004:
/* 1801 */         for (b3 = 0; b3 < 20; b3++) {
/* 1802 */           double d6 = p_72706_3_ + 0.5D + (this.field_72769_h.field_73012_v.nextFloat() - 0.5D) * 2.0D;
/* 1803 */           double d7 = p_72706_4_ + 0.5D + (this.field_72769_h.field_73012_v.nextFloat() - 0.5D) * 2.0D;
/* 1804 */           double d8 = p_72706_5_ + 0.5D + (this.field_72769_h.field_73012_v.nextFloat() - 0.5D) * 2.0D;
/*      */           
/* 1806 */           this.field_72769_h.func_72869_a("smoke", d6, d7, d8, 0.0D, 0.0D, 0.0D);
/* 1807 */           this.field_72769_h.func_72869_a("flame", d6, d7, d8, 0.0D, 0.0D, 0.0D);
/*      */         } 
/*      */         break;
/*      */       case 2005:
/* 1811 */         ItemDye.func_150918_a((World)this.field_72769_h, p_72706_3_, p_72706_4_, p_72706_5_, p_72706_6_);
/*      */         break;
/*      */       case 2006:
/* 1814 */         block = this.field_72769_h.func_147439_a(p_72706_3_, p_72706_4_, p_72706_5_);
/* 1815 */         if (block.func_149688_o() != Material.field_151579_a) {
/* 1816 */           double d = Math.min(0.2F + p_72706_6_ / 15.0F, 10.0F);
/* 1817 */           if (d > 2.5D) {
/* 1818 */             d = 2.5D;
/*      */           }
/* 1820 */           int m = (int)(150.0D * d);
/* 1821 */           for (byte b = 0; b < m; b++) {
/* 1822 */             float f = MathHelper.func_151240_a(random, 0.0F, 6.2831855F);
/* 1823 */             double d6 = MathHelper.func_151240_a(random, 0.75F, 1.0F);
/* 1824 */             double d7 = 0.20000000298023224D + d / 100.0D;
/* 1825 */             double d8 = (MathHelper.func_76134_b(f) * 0.2F) * d6 * d6 * (d + 0.2D);
/* 1826 */             double d9 = (MathHelper.func_76126_a(f) * 0.2F) * d6 * d6 * (d + 0.2D);
/* 1827 */             this.field_72769_h.func_72869_a("blockdust_" + Block.func_149682_b(block) + "_" + this.field_72769_h.func_72805_g(p_72706_3_, p_72706_4_, p_72706_5_), (p_72706_3_ + 0.5F), (p_72706_4_ + 1.0F), (p_72706_5_ + 0.5F), d8, d7, d9);
/*      */           } 
/*      */         } 
/*      */         break;
/*      */       case 1003:
/* 1832 */         if (Math.random() < 0.5D) {
/* 1833 */           this.field_72769_h.func_72980_b(p_72706_3_ + 0.5D, p_72706_4_ + 0.5D, p_72706_5_ + 0.5D, "random.door_open", 1.0F, this.field_72769_h.field_73012_v.nextFloat() * 0.1F + 0.9F, false); break;
/*      */         } 
/* 1835 */         this.field_72769_h.func_72980_b(p_72706_3_ + 0.5D, p_72706_4_ + 0.5D, p_72706_5_ + 0.5D, "random.door_close", 1.0F, this.field_72769_h.field_73012_v.nextFloat() * 0.1F + 0.9F, false);
/*      */         break;
/*      */       
/*      */       case 1004:
/* 1839 */         this.field_72769_h.func_72980_b((p_72706_3_ + 0.5F), (p_72706_4_ + 0.5F), (p_72706_5_ + 0.5F), "random.fizz", 0.5F, 2.6F + (random.nextFloat() - random.nextFloat()) * 0.8F, false);
/*      */         break;
/*      */       case 1020:
/* 1842 */         this.field_72769_h.func_72980_b((p_72706_3_ + 0.5F), (p_72706_4_ + 0.5F), (p_72706_5_ + 0.5F), "random.anvil_break", 1.0F, this.field_72769_h.field_73012_v.nextFloat() * 0.1F + 0.9F, false);
/*      */         break;
/*      */       case 1021:
/* 1845 */         this.field_72769_h.func_72980_b((p_72706_3_ + 0.5F), (p_72706_4_ + 0.5F), (p_72706_5_ + 0.5F), "random.anvil_use", 1.0F, this.field_72769_h.field_73012_v.nextFloat() * 0.1F + 0.9F, false);
/*      */         break;
/*      */       case 1022:
/* 1848 */         this.field_72769_h.func_72980_b((p_72706_3_ + 0.5F), (p_72706_4_ + 0.5F), (p_72706_5_ + 0.5F), "random.anvil_land", 0.3F, this.field_72769_h.field_73012_v.nextFloat() * 0.1F + 0.9F, false);
/*      */         break;
/*      */       case 1005:
/* 1851 */         if (Item.func_150899_d(p_72706_6_) instanceof ItemRecord) {
/* 1852 */           this.field_72769_h.func_72934_a("records." + ((ItemRecord)Item.func_150899_d(p_72706_6_)).field_150929_a, p_72706_3_, p_72706_4_, p_72706_5_); break;
/*      */         } 
/* 1854 */         this.field_72769_h.func_72934_a(null, p_72706_3_, p_72706_4_, p_72706_5_);
/*      */         break;
/*      */       
/*      */       case 1007:
/* 1858 */         this.field_72769_h.func_72980_b(p_72706_3_ + 0.5D, p_72706_4_ + 0.5D, p_72706_5_ + 0.5D, "mob.ghast.charge", 10.0F, (random.nextFloat() - random.nextFloat()) * 0.2F + 1.0F, false);
/*      */         break;
/*      */       case 1008:
/* 1861 */         this.field_72769_h.func_72980_b(p_72706_3_ + 0.5D, p_72706_4_ + 0.5D, p_72706_5_ + 0.5D, "mob.ghast.fireball", 10.0F, (random.nextFloat() - random.nextFloat()) * 0.2F + 1.0F, false);
/*      */         break;
/*      */       case 1010:
/* 1864 */         this.field_72769_h.func_72980_b(p_72706_3_ + 0.5D, p_72706_4_ + 0.5D, p_72706_5_ + 0.5D, "mob.zombie.wood", 2.0F, (random.nextFloat() - random.nextFloat()) * 0.2F + 1.0F, false);
/*      */         break;
/*      */       case 1012:
/* 1867 */         this.field_72769_h.func_72980_b(p_72706_3_ + 0.5D, p_72706_4_ + 0.5D, p_72706_5_ + 0.5D, "mob.zombie.woodbreak", 2.0F, (random.nextFloat() - random.nextFloat()) * 0.2F + 1.0F, false);
/*      */         break;
/*      */       case 1011:
/* 1870 */         this.field_72769_h.func_72980_b(p_72706_3_ + 0.5D, p_72706_4_ + 0.5D, p_72706_5_ + 0.5D, "mob.zombie.metal", 2.0F, (random.nextFloat() - random.nextFloat()) * 0.2F + 1.0F, false);
/*      */         break;
/*      */       case 1009:
/* 1873 */         this.field_72769_h.func_72980_b(p_72706_3_ + 0.5D, p_72706_4_ + 0.5D, p_72706_5_ + 0.5D, "mob.ghast.fireball", 2.0F, (random.nextFloat() - random.nextFloat()) * 0.2F + 1.0F, false);
/*      */         break;
/*      */       case 1014:
/* 1876 */         this.field_72769_h.func_72980_b(p_72706_3_ + 0.5D, p_72706_4_ + 0.5D, p_72706_5_ + 0.5D, "mob.wither.shoot", 2.0F, (random.nextFloat() - random.nextFloat()) * 0.2F + 1.0F, false);
/*      */         break;
/*      */       case 1016:
/* 1879 */         this.field_72769_h.func_72980_b(p_72706_3_ + 0.5D, p_72706_4_ + 0.5D, p_72706_5_ + 0.5D, "mob.zombie.infect", 2.0F, (random.nextFloat() - random.nextFloat()) * 0.2F + 1.0F, false);
/*      */         break;
/*      */       case 1017:
/* 1882 */         this.field_72769_h.func_72980_b(p_72706_3_ + 0.5D, p_72706_4_ + 0.5D, p_72706_5_ + 0.5D, "mob.zombie.unfect", 2.0F, (random.nextFloat() - random.nextFloat()) * 0.2F + 1.0F, false);
/*      */         break;
/*      */       case 1015:
/* 1885 */         this.field_72769_h.func_72980_b(p_72706_3_ + 0.5D, p_72706_4_ + 0.5D, p_72706_5_ + 0.5D, "mob.bat.takeoff", 0.05F, (random.nextFloat() - random.nextFloat()) * 0.2F + 1.0F, false);
/*      */         break;
/*      */     }  }
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
/*      */   public void func_147587_b(int p_147587_1_, int p_147587_2_, int p_147587_3_, int p_147587_4_, int p_147587_5_) {
/* 1904 */     if (p_147587_5_ < 0 || p_147587_5_ >= 10) {
/* 1905 */       this.field_72738_E.remove(Integer.valueOf(p_147587_1_));
/*      */     } else {
/* 1907 */       DestroyBlockProgress destroyBlockProgress = (DestroyBlockProgress)this.field_72738_E.get(Integer.valueOf(p_147587_1_));
/*      */       
/* 1909 */       if (destroyBlockProgress == null || destroyBlockProgress.func_73110_b() != p_147587_2_ || destroyBlockProgress.func_73109_c() != p_147587_3_ || destroyBlockProgress.func_73108_d() != p_147587_4_) {
/* 1910 */         destroyBlockProgress = new DestroyBlockProgress(p_147587_1_, p_147587_2_, p_147587_3_, p_147587_4_);
/* 1911 */         this.field_72738_E.put(Integer.valueOf(p_147587_1_), destroyBlockProgress);
/*      */       } 
/*      */       
/* 1914 */       destroyBlockProgress.func_73107_a(p_147587_5_);
/* 1915 */       destroyBlockProgress.func_82744_b(this.field_72773_u);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void func_94140_a(IIconRegister p_94140_1_) {
/* 1920 */     this.field_94141_F = new IIcon[10];
/*      */     
/* 1922 */     for (byte b = 0; b < this.field_94141_F.length; b++)
/* 1923 */       this.field_94141_F[b] = p_94140_1_.func_94245_a("destroy_stage_" + b); 
/*      */   }
/*      */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\RenderGlobal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */