/*     */ package JinRyuu.DragonBC.common.Npcs;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelBiped;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import org.lwjgl.opengl.GL11;
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
/*     */ public class ModelPorunga
/*     */   extends ModelBiped
/*     */ {
/*     */   public ModelRenderer Head1;
/*     */   public ModelRenderer Body1;
/*     */   public ModelRenderer ShoulderR;
/*     */   public ModelRenderer ShoulderL;
/*     */   public ModelRenderer Head2;
/*     */   public ModelRenderer Jaw1;
/*     */   public ModelRenderer TopHornR1;
/*     */   public ModelRenderer TopHornL1;
/*     */   public ModelRenderer TentacleR;
/*     */   public ModelRenderer TentacleL;
/*     */   public ModelRenderer SideHornR1;
/*     */   public ModelRenderer SideHornL1;
/*     */   public ModelRenderer Head3;
/*     */   public ModelRenderer Jaw2;
/*     */   public ModelRenderer JawR;
/*     */   public ModelRenderer JawL;
/*     */   public ModelRenderer Jaw3;
/*     */   public ModelRenderer TopHornR2;
/*     */   public ModelRenderer TopHornR3;
/*     */   public ModelRenderer TopHornL2;
/*     */   public ModelRenderer TopHornL3;
/*     */   public ModelRenderer SideHornR2;
/*     */   public ModelRenderer SideHornR3;
/*     */   public ModelRenderer SideHornL2;
/*     */   public ModelRenderer SideHornL3;
/*     */   public ModelRenderer Body2;
/*     */   public ModelRenderer Neck;
/*     */   public ModelRenderer Body3;
/*     */   public ModelRenderer Chest;
/*     */   public ModelRenderer DragonFin1;
/*     */   public ModelRenderer Abs;
/*     */   public ModelRenderer Body4;
/*     */   public ModelRenderer DragonFin2;
/*     */   public ModelRenderer Tail1;
/*     */   public ModelRenderer Tail2;
/*     */   public ModelRenderer DragonFin3;
/*     */   public ModelRenderer Tail3;
/*     */   public ModelRenderer DragonFin4;
/*     */   public ModelRenderer Tail4;
/*     */   public ModelRenderer DragonFin5;
/*     */   public ModelRenderer Tail5;
/*     */   public ModelRenderer DragonFin6;
/*     */   public ModelRenderer Tail6;
/*     */   public ModelRenderer DragonFin7;
/*     */   public ModelRenderer Tail7;
/*     */   public ModelRenderer DragonFin8;
/*     */   public ModelRenderer Tail8;
/*     */   public ModelRenderer DragonFin9;
/*     */   public ModelRenderer Tail9;
/*     */   public ModelRenderer DragonFin10;
/*     */   public ModelRenderer Tail10;
/*     */   public ModelRenderer DragonFin11;
/*     */   public ModelRenderer Tail11;
/*     */   public ModelRenderer DragonFin11_1;
/*     */   public ModelRenderer Tail12;
/*     */   public ModelRenderer DragonFin11_2;
/*     */   public ModelRenderer Tail13;
/*     */   public ModelRenderer DragonFin11_3;
/*     */   public ModelRenderer Tail14;
/*     */   public ModelRenderer DragonFin11_4;
/*     */   public ModelRenderer Tail15;
/*     */   public ModelRenderer BicepR;
/*     */   public ModelRenderer ShoulderSpikeR1;
/*     */   public ModelRenderer ForeArmR;
/*     */   public ModelRenderer PalmR1;
/*     */   public ModelRenderer RFingerT1;
/*     */   public ModelRenderer RFingerP1;
/*     */   public ModelRenderer RFingerM1;
/*     */   public ModelRenderer RFingerR1;
/*     */   public ModelRenderer RFingerL1;
/*     */   public ModelRenderer PalmR2;
/*     */   public ModelRenderer RFingersT2;
/*     */   public ModelRenderer RFingerP2;
/*     */   public ModelRenderer RFingerM2;
/*     */   public ModelRenderer RFingerR2;
/*     */   public ModelRenderer RFingerL2;
/*     */   public ModelRenderer ShoulderSpikeR2;
/*     */   public ModelRenderer ShoulderSpikeR3;
/*     */   public ModelRenderer ShoulderSpikeR4;
/*     */   public ModelRenderer ShoulderSpikeR5;
/*     */   public ModelRenderer BicepL;
/*     */   public ModelRenderer ShoulderSpikeL1;
/*     */   public ModelRenderer ForeArmL;
/*     */   public ModelRenderer PalmL1;
/*     */   public ModelRenderer LFingerT1;
/*     */   public ModelRenderer LFingerL1;
/*     */   public ModelRenderer LFingerR1;
/*     */   public ModelRenderer LFingerM1;
/*     */   public ModelRenderer LFingerP1;
/*     */   public ModelRenderer PalmL2;
/*     */   public ModelRenderer LFingersT2;
/*     */   public ModelRenderer LFingerL2;
/*     */   public ModelRenderer LFingerR2;
/*     */   public ModelRenderer LFingerM2;
/*     */   public ModelRenderer LFingerP2;
/*     */   public ModelRenderer ShoulderSpikeL2;
/*     */   public ModelRenderer ShoulderSpikeL3;
/*     */   public ModelRenderer ShoulderSpikeL4;
/*     */   public ModelRenderer ShoulderSpikeL5;
/*     */   public boolean whis_granted;
/*     */   public float last_update_tick;
/*     */   
/*     */   public ModelPorunga() {
/* 622 */     this.whis_granted = false;
/*     */     
/* 624 */     this.last_update_tick = 0.0F; this.field_78090_t = 256; this.field_78089_u = 256; this.Tail12 = new ModelRenderer((ModelBase)this, 0, 189); this.Tail12.func_78793_a(0.1F, 15.0F, -0.1F); this.Tail12.func_78790_a(-2.1F, 0.0F, -2.7F, 4, 15, 5, 0.0F); setRotateAngle(this.Tail12, -0.13665928F, -0.18203785F, -0.5462881F); this.ShoulderSpikeL2 = new ModelRenderer((ModelBase)this, 192, 46); this.ShoulderSpikeL2.field_78809_i = true; this.ShoulderSpikeL2.func_78793_a(0.0F, 0.0F, 0.0F); this.ShoulderSpikeL2.func_78790_a(-2.5F, -4.5F, -3.0F, 5, 2, 6, 0.0F); this.LFingerM2 = new ModelRenderer((ModelBase)this, 160, 141); this.LFingerM2.field_78809_i = true; this.LFingerM2.func_78793_a(-0.1F, 3.5F, -0.7F); this.LFingerM2.func_78790_a(-0.5F, -1.1F, -0.9F, 1, 5, 2, 0.0F); setRotateAngle(this.LFingerM2, 1.0016445F, 0.0F, 0.0F); this.ShoulderSpikeR4 = new ModelRenderer((ModelBase)this, 196, 28); this.ShoulderSpikeR4.func_78793_a(0.0F, 0.0F, 0.0F); this.ShoulderSpikeR4.func_78790_a(-1.5F, -11.4F, -1.5F, 3, 4, 3, 0.0F); this.JawR = new ModelRenderer((ModelBase)this, 90, 29); this.JawR.func_78793_a(0.0F, 0.0F, 0.0F); this.JawR.func_78790_a(-5.0F, -0.8F, -4.0F, 2, 3, 3, 0.0F); this.JawL = new ModelRenderer((ModelBase)this, 90, 29); this.JawL.func_78793_a(0.0F, 0.0F, 0.0F); this.JawL.func_78790_a(3.0F, -0.8F, -4.0F, 2, 3, 3, 0.0F); this.ShoulderSpikeR2 = new ModelRenderer((ModelBase)this, 192, 46); this.ShoulderSpikeR2.func_78793_a(0.0F, 0.0F, 0.0F); this.ShoulderSpikeR2.func_78790_a(-2.5F, -4.5F, -3.0F, 5, 2, 6, 0.0F); this.Body4 = new ModelRenderer((ModelBase)this, 17, 111); this.Body4.func_78793_a(0.0F, 13.3F, 0.0F); this.Body4.func_78790_a(-8.5F, -1.0F, -4.8F, 17, 11, 11, 0.0F); setRotateAngle(this.Body4, 0.18203785F, 0.0F, 0.091106184F); this.Head1 = new ModelRenderer((ModelBase)this, 97, 2); this.Head1.func_78793_a(0.0F, -80.0F, -5.0F); this.Head1.func_78790_a(-4.0F, -4.0F, -5.5F, 8, 5, 7, 0.0F); setRotateAngle(this.Head1, 0.4553564F, 0.0F, 0.0F); this.ShoulderSpikeL4 = new ModelRenderer((ModelBase)this, 196, 28); this.ShoulderSpikeL4.field_78809_i = true; this.ShoulderSpikeL4.func_78793_a(0.0F, 0.0F, 0.0F); this.ShoulderSpikeL4.func_78790_a(-1.5F, -11.4F, -1.5F, 3, 4, 3, 0.0F); this.DragonFin1 = new ModelRenderer((ModelBase)this, 85, 62); this.DragonFin1.func_78793_a(0.0F, 0.0F, 11.9F); this.DragonFin1.func_78790_a(0.0F, -9.9F, -11.8F, 0, 26, 20, 0.0F); this.LFingersT2 = new ModelRenderer((ModelBase)this, 173, 133); this.LFingersT2.field_78809_i = true; this.LFingersT2.func_78793_a(-2.5F, -0.2F, 0.0F); this.LFingersT2.func_78790_a(-3.6F, -0.7F, -1.7F, 5, 1, 2, 0.0F); setRotateAngle(this.LFingersT2, 0.0F, 1.0471976F, 0.0F); this.TopHornR2 = new ModelRenderer((ModelBase)this, 129, 11); this.TopHornR2.func_78793_a(0.0F, -4.0F, 2.0F); this.TopHornR2.func_78790_a(-1.1F, -5.3F, -1.5F, 2, 6, 3, 0.0F); setRotateAngle(this.TopHornR2, -0.22759093F, 0.0F, -0.08726646F); this.Body2 = new ModelRenderer((ModelBase)this, 15, 35); this.Body2.func_78793_a(0.0F, 0.0F, 0.0F); this.Body2.func_78790_a(-11.0F, -4.7F, -0.7F, 22, 5, 10, 0.0F); setRotateAngle(this.Body2, -0.4553564F, 0.0F, 0.0F); this.TentacleL = new ModelRenderer((ModelBase)this, 92, 3); this.TentacleL.field_78809_i = true; this.TentacleL.func_78793_a(1.5F, -3.5F, -5.6F); this.TentacleL.func_78790_a(0.0F, -0.5F, 0.0F, 5, 3, 0, 0.0F); setRotateAngle(this.TentacleL, 0.0F, 0.7740535F, -0.17976892F); this.ShoulderR = new ModelRenderer((ModelBase)this, 144, 54); this.ShoulderR.func_78793_a(-14.9F, -76.5F, 3.2F); this.ShoulderR.func_78790_a(-11.1F, -3.6F, -5.0F, 11, 10, 10, 0.0F); setRotateAngle(this.ShoulderR, 0.34906584F, 0.0F, 0.0F); this.RFingersT2 = new ModelRenderer((ModelBase)this, 173, 133); this.RFingersT2.func_78793_a(2.4F, 0.0F, 0.0F); this.RFingersT2.func_78790_a(-1.6F, -0.7F, -1.1F, 5, 1, 2, 0.0F); setRotateAngle(this.RFingersT2, 0.0F, -1.0471976F, 0.0F); this.ShoulderSpikeL3 = new ModelRenderer((ModelBase)this, 195, 37); this.ShoulderSpikeL3.field_78809_i = true; this.ShoulderSpikeL3.func_78793_a(0.0F, 0.0F, 0.0F); this.ShoulderSpikeL3.func_78790_a(-2.0F, -7.5F, -2.0F, 4, 3, 4, 0.0F); this.ShoulderSpikeL1 = new ModelRenderer((ModelBase)this, 191, 57); this.ShoulderSpikeL1.field_78809_i = true; this.ShoulderSpikeL1.func_78793_a(9.5F, -2.0F, 0.0F); this.ShoulderSpikeL1.func_78790_a(-3.0F, -2.5F, -3.5F, 6, 4, 7, 0.0F); setRotateAngle(this.ShoulderSpikeL1, 0.0F, 0.0F, 0.7853982F); this.DragonFin11_1 = new ModelRenderer((ModelBase)this, 96, 156); this.DragonFin11_1.func_78793_a(0.0F, 5.7F, 2.5F); this.DragonFin11_1.func_78790_a(0.0F, -7.4F, -0.1F, 0, 17, 8, 0.0F); setRotateAngle(this.DragonFin11_1, 0.0F, 0.0F, 0.045553092F); this.RFingerL1 = new ModelRenderer((ModelBase)this, 148, 133); this.RFingerL1.func_78793_a(-2.4F, 5.9F, 0.0F); this.RFingerL1.func_78790_a(-1.2F, -1.1F, -2.3F, 2, 4, 3, 0.0F); setRotateAngle(this.RFingerL1, 0.7740535F, 0.045553092F, 0.22759093F); this.DragonFin11_4 = new ModelRenderer((ModelBase)this, 96, 156); this.DragonFin11_4.func_78793_a(0.0F, 0.0F, 0.0F); this.DragonFin11_4.func_78790_a(0.0F, 0.0F, 0.0F, 0, 18, 8, 0.0F); this.Tail8 = new ModelRenderer((ModelBase)this, 21, 190); this.Tail8.func_78793_a(0.4F, 12.3F, 0.0F); this.Tail8.func_78790_a(-3.2F, 0.0F, -3.9F, 5, 13, 6, 0.0F); setRotateAngle(this.Tail8, -0.31869712F, -0.22759093F, -0.5009095F); this.DragonFin11 = new ModelRenderer((ModelBase)this, 96, 156); this.DragonFin11.func_78793_a(0.0F, 4.2F, 2.5F); this.DragonFin11.func_78790_a(0.0F, -7.4F, -0.1F, 0, 18, 8, 0.0F); setRotateAngle(this.DragonFin11, 0.0F, 0.0F, 0.045553092F); this.LFingerT1 = new ModelRenderer((ModelBase)this, 172, 127); this.LFingerT1.field_78809_i = true; this.LFingerT1.func_78793_a(-3.3F, 3.8F, 0.0F); this.LFingerT1.func_78790_a(-3.4F, -1.4F, -2.3F, 3, 2, 3, 0.0F); setRotateAngle(this.LFingerT1, 0.0F, 0.59184116F, -0.18203785F); this.TopHornR3 = new ModelRenderer((ModelBase)this, 130, 2); this.TopHornR3.func_78793_a(0.0F, -5.2F, 0.1F); this.TopHornR3.func_78790_a(-0.7F, -5.8F, -1.2F, 1, 6, 2, 0.0F); setRotateAngle(this.TopHornR3, -0.22759093F, 0.0F, -0.08726646F); this.Abs = new ModelRenderer((ModelBase)this, 98, 63); this.Abs.func_78793_a(0.0F, 0.0F, -5.8F); this.Abs.func_78790_a(-6.0F, -2.0F, -1.2F, 12, 9, 2, 0.0F); this.DragonFin8 = new ModelRenderer((ModelBase)this, 95, 139); this.DragonFin8.func_78793_a(-1.2F, 4.2F, 2.5F); this.DragonFin8.func_78790_a(0.0F, -5.6F, -0.1F, 0, 14, 9, 0.0F); this.ShoulderSpikeR1 = new ModelRenderer((ModelBase)this, 191, 57); this.ShoulderSpikeR1.func_78793_a(-9.5F, -2.0F, 0.0F); this.ShoulderSpikeR1.func_78790_a(-3.0F, -2.5F, -3.5F, 6, 4, 7, 0.0F); setRotateAngle(this.ShoulderSpikeR1, 0.0F, 0.0F, -0.7853982F); this.Body1 = new ModelRenderer((ModelBase)this, 8, 51); this.Body1.func_78793_a(0.0F, -80.0F, 0.0F); this.Body1.func_78790_a(-15.0F, 0.0F, -3.5F, 30, 16, 14, 0.0F); setRotateAngle(this.Body1, 0.27925268F, 0.0F, 0.0F); this.DragonFin6 = new ModelRenderer((ModelBase)this, 95, 139); this.DragonFin6.func_78793_a(-1.2F, 4.2F, 2.5F); this.DragonFin6.func_78790_a(0.0F, -5.4F, -0.1F, 0, 12, 9, 0.0F); this.Head2 = new ModelRenderer((ModelBase)this, 103, 15); this.Head2.func_78793_a(0.0F, 0.0F, 0.0F); this.Head2.func_78790_a(-3.0F, 0.0F, -6.5F, 6, 1, 1, 0.0F); this.Chest = new ModelRenderer((ModelBase)this, 84, 50); this.Chest.func_78793_a(0.0F, 6.2F, -3.3F); this.Chest.func_78790_a(-12.0F, -3.7F, -3.2F, 24, 8, 3, 0.0F); this.Tail2 = new ModelRenderer((ModelBase)this, 49, 157); this.Tail2.func_78793_a(0.0F, 9.8F, 0.0F); this.Tail2.func_78790_a(-6.0F, -0.7F, -3.9F, 12, 12, 8, 0.0F); setRotateAngle(this.Tail2, -0.31869712F, 0.0F, -0.045553092F); this.DragonFin11_2 = new ModelRenderer((ModelBase)this, 96, 156); this.DragonFin11_2.func_78793_a(0.0F, 6.0F, 1.9F); this.DragonFin11_2.func_78790_a(0.0F, -7.4F, -0.1F, 0, 16, 8, 0.0F); setRotateAngle(this.DragonFin11_2, 0.0F, 0.0F, 0.045553092F); this.TopHornL2 = new ModelRenderer((ModelBase)this, 129, 11); this.TopHornL2.field_78809_i = true; this.TopHornL2.func_78793_a(0.0F, -4.0F, 2.0F); this.TopHornL2.func_78790_a(-0.7F, -5.3F, -1.5F, 2, 6, 3, 0.0F); setRotateAngle(this.TopHornL2, -0.22759093F, 0.0F, 0.08726646F); this.RFingerR1 = new ModelRenderer((ModelBase)this, 159, 132); this.RFingerR1.func_78793_a(-0.6F, 7.0F, 0.0F); this.RFingerR1.func_78790_a(-1.2F, -2.2F, -2.3F, 2, 5, 3, 0.0F); setRotateAngle(this.RFingerR1, 0.7740535F, 0.0F, 0.1394518F); this.DragonFin11_3 = new ModelRenderer((ModelBase)this, 96, 156); this.DragonFin11_3.func_78793_a(0.0F, 5.7F, 1.7F); this.DragonFin11_3.func_78790_a(0.0F, -7.4F, -0.1F, 0, 18, 8, 0.0F); setRotateAngle(this.DragonFin11_3, 0.0F, 0.0F, 0.045553092F); this.ShoulderSpikeR3 = new ModelRenderer((ModelBase)this, 195, 37); this.ShoulderSpikeR3.func_78793_a(0.0F, 0.0F, 0.0F); this.ShoulderSpikeR3.func_78790_a(-2.0F, -7.5F, -2.0F, 4, 3, 4, 0.0F); this.Tail11 = new ModelRenderer((ModelBase)this, 0, 167); this.Tail11.func_78793_a(0.1F, 15.0F, -0.1F); this.Tail11.func_78790_a(-2.1F, 0.0F, -2.7F, 4, 15, 5, 0.0F); setRotateAngle(this.Tail11, -0.22759093F, -0.13665928F, -0.3642502F); this.TopHornL1 = new ModelRenderer((ModelBase)this, 128, 21); this.TopHornL1.field_78809_i = true; this.TopHornL1.func_78793_a(2.0F, -4.0F, -3.2F); this.TopHornL1.func_78790_a(-1.4F, -3.9F, 0.0F, 3, 4, 4, 0.0F); setRotateAngle(this.TopHornL1, -0.95609134F, 0.17453292F, 0.0F); this.Head3 = new ModelRenderer((ModelBase)this, 103, 18); this.Head3.func_78793_a(0.0F, 0.0F, 0.0F); this.Head3.func_78790_a(-2.0F, -1.0F, -7.5F, 4, 2, 2, 0.0F); this.SideHornL1 = new ModelRenderer((ModelBase)this, 91, 20); this.SideHornL1.field_78809_i = true; this.SideHornL1.func_78793_a(4.1F, 0.3F, -1.1F); this.SideHornL1.func_78790_a(-0.2F, -1.5F, -1.8F, 2, 3, 3, 0.0F); this.SideHornL2 = new ModelRenderer((ModelBase)this, 80, 22); this.SideHornL2.field_78809_i = true; this.SideHornL2.func_78793_a(0.0F, 0.0F, 0.0F); this.SideHornL2.func_78790_a(1.7F, -0.9F, -1.3F, 3, 2, 2, 0.0F); this.Body3 = new ModelRenderer((ModelBase)this, 12, 83); this.Body3.func_78793_a(0.0F, 13.0F, 1.7F); this.Body3.func_78790_a(-11.0F, -0.2F, -5.3F, 22, 14, 13, 0.0F); setRotateAngle(this.Body3, -0.17453292F, 0.0F, 0.0F); this.LFingerL2 = new ModelRenderer((ModelBase)this, 160, 141); this.LFingerL2.field_78809_i = true; this.LFingerL2.func_78793_a(-0.1F, 2.0F, -0.2F); this.LFingerL2.func_78790_a(-0.4F, -1.1F, -0.9F, 1, 5, 2, 0.0F); setRotateAngle(this.LFingerL2, 0.8651597F, 0.0F, 0.0F); this.TopHornR1 = new ModelRenderer((ModelBase)this, 128, 21); this.TopHornR1.func_78793_a(-2.2F, -4.0F, -3.2F); this.TopHornR1.func_78790_a(-1.4F, -3.9F, 0.0F, 3, 4, 4, 0.0F); setRotateAngle(this.TopHornR1, -0.95609134F, -0.17453292F, 0.0F); this.PalmL1 = new ModelRenderer((ModelBase)this, 148, 119); this.PalmL1.field_78809_i = true; this.PalmL1.func_78793_a(-1.4F, 12.3F, 0.0F); this.PalmL1.func_78790_a(-3.7F, 0.0F, -3.0F, 7, 7, 4, 0.0F); setRotateAngle(this.PalmL1, -0.13665928F, -1.0016445F, -0.045553092F); this.RFingerP2 = new ModelRenderer((ModelBase)this, 160, 141); this.RFingerP2.func_78793_a(-0.1F, 2.7F, -0.3F); this.RFingerP2.func_78790_a(-0.4F, -1.1F, -0.9F, 1, 5, 2, 0.0F); setRotateAngle(this.RFingerP2, 1.0927507F, 0.0F, 0.0F); this.BicepR = new ModelRenderer((ModelBase)this, 146, 76); this.BicepR.func_78793_a(-6.1F, 5.7F, 0.0F); this.BicepR.func_78790_a(-4.5F, 0.0F, -4.5F, 9, 11, 9, 0.0F); setRotateAngle(this.BicepR, -0.12217305F, 0.0F, 0.091106184F); this.SideHornR1 = new ModelRenderer((ModelBase)this, 91, 20); this.SideHornR1.func_78793_a(-4.2F, 0.3F, -1.1F); this.SideHornR1.func_78790_a(-1.8F, -1.5F, -1.8F, 2, 3, 3, 0.0F); this.PalmR2 = new ModelRenderer((ModelBase)this, 171, 119); this.PalmR2.func_78793_a(0.0F, 0.0F, 0.0F); this.PalmR2.func_78790_a(3.2F, 1.9F, -1.8F, 1, 3, 3, 0.0F); this.RFingerT1 = new ModelRenderer((ModelBase)this, 172, 127); this.RFingerT1.func_78793_a(3.1F, 4.1F, 0.0F); this.RFingerT1.func_78790_a(-0.1F, -1.4F, -2.3F, 3, 2, 3, 0.0F); setRotateAngle(this.RFingerT1, 0.0F, -0.59184116F, 0.18203785F); this.SideHornR2 = new ModelRenderer((ModelBase)this, 80, 22); this.SideHornR2.func_78793_a(0.0F, 0.0F, 0.0F); this.SideHornR2.func_78790_a(-4.6F, -0.9F, -1.3F, 3, 2, 2, 0.0F); this.Tail9 = new ModelRenderer((ModelBase)this, 21, 213); this.Tail9.func_78793_a(-0.7F, 13.5F, -0.8F); this.Tail9.func_78790_a(-2.3F, 0.0F, -2.7F, 5, 14, 5, 0.0F); setRotateAngle(this.Tail9, -0.31869712F, 0.0F, -0.59184116F); this.Tail13 = new ModelRenderer((ModelBase)this, 0, 211); this.Tail13.func_78793_a(0.1F, 15.0F, -0.1F); this.Tail13.func_78790_a(-2.1F, 0.0F, -2.2F, 4, 15, 4, 0.0F); setRotateAngle(this.Tail13, -0.13665928F, -0.091106184F, -0.5009095F); this.Tail1 = new ModelRenderer((ModelBase)this, 21, 135); this.Tail1.func_78793_a(0.0F, 9.8F, 0.0F); this.Tail1.func_78790_a(-7.0F, -0.7F, -4.2F, 14, 10, 9, 0.0F); setRotateAngle(this.Tail1, -0.091106184F, 0.0F, 0.18203785F); this.ShoulderSpikeL5 = new ModelRenderer((ModelBase)this, 198, 19); this.ShoulderSpikeL5.field_78809_i = true; this.ShoulderSpikeL5.func_78793_a(0.0F, 0.0F, 0.0F); this.ShoulderSpikeL5.func_78790_a(-1.0F, -16.3F, -1.0F, 2, 5, 2, 0.0F); this.DragonFin10 = new ModelRenderer((ModelBase)this, 95, 139); this.DragonFin10.func_78793_a(0.0F, 4.2F, 2.5F); this.DragonFin10.func_78790_a(0.0F, -6.4F, -0.1F, 0, 14, 9, 0.0F); this.Tail4 = new ModelRenderer((ModelBase)this, 51, 196); this.Tail4.func_78793_a(0.0F, 8.5F, 0.0F); this.Tail4.func_78790_a(-5.5F, 0.0F, -3.9F, 9, 10, 7, 0.0F); setRotateAngle(this.Tail4, -0.5009095F, -0.18203785F, -0.4553564F); this.DragonFin2 = new ModelRenderer((ModelBase)this, 93, 98); this.DragonFin2.func_78793_a(0.0F, 5.9F, 7.5F); this.DragonFin2.func_78790_a(0.0F, -6.4F, -2.5F, 0, 22, 12, 0.0F); this.Jaw1 = new ModelRenderer((ModelBase)this, 99, 23); this.Jaw1.func_78793_a(0.0F, 0.2F, 0.0F); this.Jaw1.func_78790_a(-3.0F, 0.8F, -5.5F, 6, 3, 5, 0.0F); this.DragonFin9 = new ModelRenderer((ModelBase)this, 95, 139); this.DragonFin9.func_78793_a(0.4F, 4.2F, 2.5F); this.DragonFin9.func_78790_a(0.0F, -6.4F, -0.1F, 0, 14, 9, 0.0F); setRotateAngle(this.DragonFin9, 0.0F, 0.0F, 0.22759093F); this.RFingerM2 = new ModelRenderer((ModelBase)this, 160, 141); this.RFingerM2.func_78793_a(-0.1F, 2.7F, -0.3F); this.RFingerM2.func_78790_a(-0.6F, -1.2F, -0.9F, 1, 5, 2, 0.0F); setRotateAngle(this.RFingerM2, 1.1838568F, 0.0F, 0.0F); this.DragonFin5 = new ModelRenderer((ModelBase)this, 95, 139); this.DragonFin5.func_78793_a(0.0F, 4.2F, 2.5F); this.DragonFin5.func_78790_a(0.0F, -7.0F, 0.1F, 0, 14, 9, 0.0F); setRotateAngle(this.DragonFin5, 0.0F, 0.0F, 0.091106184F); this.LFingerR2 = new ModelRenderer((ModelBase)this, 160, 141); this.LFingerR2.field_78809_i = true; this.LFingerR2.func_78793_a(-0.1F, 2.7F, -0.3F); this.LFingerR2.func_78790_a(-0.6F, -1.2F, -0.9F, 1, 5, 2, 0.0F); setRotateAngle(this.LFingerR2, 1.0016445F, 0.0F, 0.0F); this.LFingerL1 = new ModelRenderer((ModelBase)this, 148, 133); this.LFingerL1.field_78809_i = true; this.LFingerL1.func_78793_a(2.2F, 7.1F, 0.4F); this.LFingerL1.func_78790_a(-0.9F, -2.2F, -2.3F, 2, 4, 3, 0.0F); setRotateAngle(this.LFingerL1, 0.63739425F, -0.007504916F, -0.18203785F); this.TopHornL3 = new ModelRenderer((ModelBase)this, 130, 2); this.TopHornL3.field_78809_i = true; this.TopHornL3.func_78793_a(0.0F, -5.2F, 0.1F); this.TopHornL3.func_78790_a(-0.3F, -5.8F, -1.2F, 1, 6, 2, 0.0F); setRotateAngle(this.TopHornL3, -0.22759093F, 0.0F, 0.08726646F); this.Tail15 = new ModelRenderer((ModelBase)this, 0, 246); this.Tail15.func_78793_a(-0.4F, 8.7F, -0.1F); this.Tail15.func_78790_a(-1.1F, 0.0F, -1.5F, 2, 7, 3, 0.0F); setRotateAngle(this.Tail15, -0.091106184F, -0.091106184F, -0.22759093F); this.SideHornR3 = new ModelRenderer((ModelBase)this, 73, 24); this.SideHornR3.func_78793_a(0.0F, 0.0F, 0.0F); this.SideHornR3.func_78790_a(-6.4F, -0.5F, -0.8F, 2, 1, 1, 0.0F); this.RFingerR2 = new ModelRenderer((ModelBase)this, 160, 141); this.RFingerR2.func_78793_a(-0.1F, 2.7F, -0.3F); this.RFingerR2.func_78790_a(-0.5F, -1.1F, -0.9F, 1, 5, 2, 0.0F); setRotateAngle(this.RFingerR2, 0.95609134F, 0.0F, 0.0F); this.BicepL = new ModelRenderer((ModelBase)this, 146, 76); this.BicepL.field_78809_i = true; this.BicepL.func_78793_a(6.1F, 5.7F, 0.0F); this.BicepL.func_78790_a(-4.5F, 0.0F, -4.5F, 9, 11, 9, 0.0F); setRotateAngle(this.BicepL, 0.12217305F, 0.0F, -0.091106184F); this.LFingerP1 = new ModelRenderer((ModelBase)this, 159, 132); this.LFingerP1.field_78809_i = true; this.LFingerP1.func_78793_a(-2.8F, 6.8F, -0.3F); this.LFingerP1.func_78790_a(-1.2F, -1.1F, -2.0F, 2, 5, 3, 0.0F); setRotateAngle(this.LFingerP1, 0.59184116F, 0.045553092F, 0.22759093F); this.ForeArmL = new ModelRenderer((ModelBase)this, 149, 98); this.ForeArmL.field_78809_i = true; this.ForeArmL.func_78793_a(0.0F, 10.5F, 0.0F); this.ForeArmL.func_78790_a(-4.5F, -0.5F, -3.6F, 8, 13, 7, 0.0F); setRotateAngle(this.ForeArmL, -0.5009095F, 0.091106184F, 0.13665928F); this.RFingerL2 = new ModelRenderer((ModelBase)this, 160, 141); this.RFingerL2.func_78793_a(-0.1F, 2.7F, -0.3F); this.RFingerL2.func_78790_a(-0.5F, -1.1F, -0.9F, 1, 5, 2, 0.0F); setRotateAngle(this.RFingerL2, 0.95609134F, 0.0F, 0.0F); this.LFingerM1 = new ModelRenderer((ModelBase)this, 159, 132); this.LFingerM1.field_78809_i = true; this.LFingerM1.func_78793_a(-0.8F, 7.3F, 0.0F); this.LFingerM1.func_78790_a(-1.2F, -1.2F, -2.3F, 2, 5, 3, 0.0F); setRotateAngle(this.LFingerM1, 0.22759093F, 0.0F, 0.1394518F); this.PalmL2 = new ModelRenderer((ModelBase)this, 171, 119); this.PalmL2.field_78809_i = true; this.PalmL2.func_78793_a(0.0F, 0.0F, 0.0F); this.PalmL2.func_78790_a(-4.5F, 1.9F, -1.8F, 1, 3, 3, 0.0F); this.DragonFin4 = new ModelRenderer((ModelBase)this, 95, 139); this.DragonFin4.func_78793_a(0.0F, 4.2F, 2.5F); this.DragonFin4.func_78790_a(0.0F, -6.4F, -0.1F, 0, 14, 9, 0.0F); this.PalmR1 = new ModelRenderer((ModelBase)this, 148, 119); this.PalmR1.func_78793_a(0.8F, 12.3F, 0.0F); this.PalmR1.func_78790_a(-3.7F, 0.0F, -3.0F, 7, 7, 4, 0.0F); setRotateAngle(this.PalmR1, -0.13665928F, 1.0016445F, -0.045553092F); this.ShoulderSpikeR5 = new ModelRenderer((ModelBase)this, 198, 19); this.ShoulderSpikeR5.func_78793_a(0.0F, 0.0F, 0.0F); this.ShoulderSpikeR5.func_78790_a(-1.0F, -16.3F, -1.0F, 2, 5, 2, 0.0F); this.DragonFin7 = new ModelRenderer((ModelBase)this, 95, 139); this.DragonFin7.func_78793_a(-1.6F, 4.2F, 2.5F); this.DragonFin7.func_78790_a(0.0F, -5.7F, -0.1F, 0, 14, 9, 0.0F); this.Jaw3 = new ModelRenderer((ModelBase)this, 104, 36); this.Jaw3.func_78793_a(0.0F, 0.0F, 0.0F); this.Jaw3.func_78790_a(-2.0F, 0.8F, -7.5F, 4, 2, 1, 0.0F); this.Tail6 = new ModelRenderer((ModelBase)this, 52, 235); this.Tail6.func_78793_a(-0.4F, 10.1F, 1.1F); this.Tail6.func_78790_a(-5.0F, 0.0F, -3.9F, 7, 12, 7, 0.0F); setRotateAngle(this.Tail6, -0.3642502F, -0.3642502F, -0.59184116F); this.Neck = new ModelRenderer((ModelBase)this, 28, 20); this.Neck.func_78793_a(0.0F, 0.0F, 0.0F); this.Neck.func_78790_a(-5.8F, -4.1F, -5.1F, 12, 8, 5, 0.0F); setRotateAngle(this.Neck, -0.27314404F, 0.0F, 0.0F); this.RFingerM1 = new ModelRenderer((ModelBase)this, 159, 132); this.RFingerM1.func_78793_a(1.1F, 7.9F, 0.0F); this.RFingerM1.func_78790_a(-1.1F, -2.2F, -2.3F, 2, 5, 3, 0.0F); setRotateAngle(this.RFingerM1, 0.5009095F, 0.0F, 0.0F); this.Tail10 = new ModelRenderer((ModelBase)this, 21, 235); this.Tail10.func_78793_a(0.1F, 15.0F, -0.1F); this.Tail10.func_78790_a(-2.1F, 0.0F, -2.7F, 4, 15, 5, 0.0F); setRotateAngle(this.Tail10, -0.31869712F, -0.31869712F, -0.3642502F); this.ForeArmR = new ModelRenderer((ModelBase)this, 149, 98); this.ForeArmR.func_78793_a(0.0F, 10.5F, 0.0F); this.ForeArmR.func_78790_a(-4.5F, -0.5F, -3.6F, 8, 13, 7, 0.0F); setRotateAngle(this.ForeArmR, -0.5009095F, -0.091106184F, -0.13665928F); this.LFingerR1 = new ModelRenderer((ModelBase)this, 159, 132); this.LFingerR1.field_78809_i = true; this.LFingerR1.func_78793_a(1.1F, 7.9F, 0.0F); this.LFingerR1.func_78790_a(-1.1F, -2.2F, -2.3F, 2, 5, 3, 0.0F); setRotateAngle(this.LFingerR1, 0.31869712F, 0.0F, 0.0F); this.ShoulderL = new ModelRenderer((ModelBase)this, 144, 54); this.ShoulderL.field_78809_i = true; this.ShoulderL.func_78793_a(14.9F, -76.5F, 3.2F); this.ShoulderL.func_78790_a(0.1F, -3.6F, -5.0F, 11, 10, 10, 0.0F); setRotateAngle(this.ShoulderL, 0.34906584F, 0.0F, 0.0F); this.Jaw2 = new ModelRenderer((ModelBase)this, 103, 32); this.Jaw2.func_78793_a(0.0F, 0.0F, 0.0F); this.Jaw2.func_78790_a(-3.0F, 0.8F, -6.5F, 6, 2, 1, 0.0F); this.Tail3 = new ModelRenderer((ModelBase)this, 50, 179); this.Tail3.func_78793_a(0.0F, 10.7F, 0.0F); this.Tail3.func_78790_a(-5.4F, 0.0F, -3.9F, 10, 8, 7, 0.0F); setRotateAngle(this.Tail3, -0.5009095F, -0.18203785F, -0.22759093F); this.TentacleR = new ModelRenderer((ModelBase)this, 92, 3); this.TentacleR.func_78793_a(-1.5F, -3.5F, -5.6F); this.TentacleR.func_78790_a(-4.9F, -0.5F, 0.0F, 5, 3, 0, 0.0F); setRotateAngle(this.TentacleR, 0.0F, -0.7740535F, 0.27314404F); this.SideHornL3 = new ModelRenderer((ModelBase)this, 73, 24); this.SideHornL3.field_78809_i = true; this.SideHornL3.func_78793_a(0.0F, 0.0F, 0.0F); this.SideHornL3.func_78790_a(4.7F, -0.5F, -0.8F, 2, 1, 1, 0.0F); this.DragonFin3 = new ModelRenderer((ModelBase)this, 93, 123); this.DragonFin3.func_78793_a(0.0F, 5.5F, 4.6F); this.DragonFin3.func_78790_a(0.0F, -6.7F, -0.2F, 0, 12, 11, 0.0F); this.Tail7 = new ModelRenderer((ModelBase)this, 21, 169); this.Tail7.func_78793_a(-1.8F, 12.9F, 0.0F); this.Tail7.func_78790_a(-3.0F, 0.0F, -3.9F, 6, 12, 7, 0.0F); setRotateAngle(this.Tail7, -0.31869712F, -0.22759093F, -0.8196066F); this.Tail5 = new ModelRenderer((ModelBase)this, 51, 215); this.Tail5.func_78793_a(-0.7F, 8.5F, 0.0F); this.Tail5.func_78790_a(-4.5F, 0.0F, -3.9F, 7, 11, 7, 0.0F); setRotateAngle(this.Tail5, -0.4098033F, -0.18203785F, -0.68294734F); this.RFingerP1 = new ModelRenderer((ModelBase)this, 159, 132); this.RFingerP1.func_78793_a(2.4F, 7.4F, 0.0F); this.RFingerP1.func_78790_a(-0.9F, -2.2F, -2.3F, 2, 5, 3, 0.0F); setRotateAngle(this.RFingerP1, 0.68294734F, 0.0F, -0.18203785F); this.Tail14 = new ModelRenderer((ModelBase)this, 0, 232); this.Tail14.func_78793_a(-0.4F, 15.0F, -0.1F); this.Tail14.func_78790_a(-1.6F, 0.0F, -2.2F, 3, 9, 4, 0.0F); setRotateAngle(this.Tail14, 0.045553092F, -0.091106184F, -0.3642502F); this.LFingerP2 = new ModelRenderer((ModelBase)this, 160, 141); this.LFingerP2.field_78809_i = true; this.LFingerP2.func_78793_a(-0.3F, 3.7F, -0.4F); this.LFingerP2.func_78790_a(-0.5F, -1.1F, -0.9F, 1, 5, 2, 0.0F); setRotateAngle(this.LFingerP2, 0.8651597F, 0.0F, 0.0F); this.Tail11.func_78792_a(this.Tail12); this.ShoulderSpikeL1.func_78792_a(this.ShoulderSpikeL2); this.LFingerM1.func_78792_a(this.LFingerM2); this.ShoulderSpikeR3.func_78792_a(this.ShoulderSpikeR4); this.Jaw1.func_78792_a(this.JawR); this.Jaw1.func_78792_a(this.JawL); this.ShoulderSpikeR1.func_78792_a(this.ShoulderSpikeR2); this.Body3.func_78792_a(this.Body4); this.ShoulderSpikeL3.func_78792_a(this.ShoulderSpikeL4); this.Body1.func_78792_a(this.DragonFin1); this.LFingerT1.func_78792_a(this.LFingersT2); this.TopHornR1.func_78792_a(this.TopHornR2); this.Body1.func_78792_a(this.Body2); this.Head1.func_78792_a(this.TentacleL); this.RFingerT1.func_78792_a(this.RFingersT2); this.ShoulderSpikeL2.func_78792_a(this.ShoulderSpikeL3); this.ShoulderL.func_78792_a(this.ShoulderSpikeL1); this.Tail10.func_78792_a(this.DragonFin11_1); this.PalmR1.func_78792_a(this.RFingerL1); this.Tail13.func_78792_a(this.DragonFin11_4); this.Tail7.func_78792_a(this.Tail8); this.Tail9.func_78792_a(this.DragonFin11); this.PalmL1.func_78792_a(this.LFingerT1); this.TopHornR2.func_78792_a(this.TopHornR3); this.Body3.func_78792_a(this.Abs); this.Tail6.func_78792_a(this.DragonFin8); this.ShoulderR.func_78792_a(this.ShoulderSpikeR1); this.Tail4.func_78792_a(this.DragonFin6); this.Head1.func_78792_a(this.Head2); this.Body1.func_78792_a(this.Chest); this.Tail1.func_78792_a(this.Tail2); this.Tail11.func_78792_a(this.DragonFin11_2); this.TopHornL1.func_78792_a(this.TopHornL2); this.PalmR1.func_78792_a(this.RFingerR1); this.Tail12.func_78792_a(this.DragonFin11_3); this.ShoulderSpikeR2.func_78792_a(this.ShoulderSpikeR3); this.Tail10.func_78792_a(this.Tail11); this.Head1.func_78792_a(this.TopHornL1); this.Head2.func_78792_a(this.Head3); this.Head1.func_78792_a(this.SideHornL1); this.SideHornL1.func_78792_a(this.SideHornL2); this.Body1.func_78792_a(this.Body3); this.LFingerL1.func_78792_a(this.LFingerL2); this.Head1.func_78792_a(this.TopHornR1); this.ForeArmL.func_78792_a(this.PalmL1); this.RFingerP1.func_78792_a(this.RFingerP2); this.ShoulderR.func_78792_a(this.BicepR); this.Head1.func_78792_a(this.SideHornR1); this.PalmR1.func_78792_a(this.PalmR2); this.PalmR1.func_78792_a(this.RFingerT1); this.SideHornR1.func_78792_a(this.SideHornR2); this.Tail8.func_78792_a(this.Tail9); this.Tail12.func_78792_a(this.Tail13); this.Body4.func_78792_a(this.Tail1); this.ShoulderSpikeL4.func_78792_a(this.ShoulderSpikeL5); this.Tail8.func_78792_a(this.DragonFin10); this.Tail3.func_78792_a(this.Tail4); this.Body3.func_78792_a(this.DragonFin2); this.Head1.func_78792_a(this.Jaw1); this.Tail7.func_78792_a(this.DragonFin9); this.RFingerM1.func_78792_a(this.RFingerM2); this.Tail3.func_78792_a(this.DragonFin5); this.LFingerR1.func_78792_a(this.LFingerR2); this.PalmL1.func_78792_a(this.LFingerL1); this.TopHornL2.func_78792_a(this.TopHornL3); this.Tail14.func_78792_a(this.Tail15); this.SideHornR2.func_78792_a(this.SideHornR3); this.RFingerR1.func_78792_a(this.RFingerR2); this.ShoulderL.func_78792_a(this.BicepL); this.PalmL1.func_78792_a(this.LFingerP1); this.BicepL.func_78792_a(this.ForeArmL); this.RFingerL1.func_78792_a(this.RFingerL2); this.PalmL1.func_78792_a(this.LFingerM1); this.PalmL1.func_78792_a(this.PalmL2); this.Tail2.func_78792_a(this.DragonFin4); this.ForeArmR.func_78792_a(this.PalmR1); this.ShoulderSpikeR4.func_78792_a(this.ShoulderSpikeR5); this.Tail5.func_78792_a(this.DragonFin7); this.Jaw2.func_78792_a(this.Jaw3); this.Tail5.func_78792_a(this.Tail6); this.Body1.func_78792_a(this.Neck); this.PalmR1.func_78792_a(this.RFingerM1); this.Tail9.func_78792_a(this.Tail10); this.BicepR.func_78792_a(this.ForeArmR); this.PalmL1.func_78792_a(this.LFingerR1); this.Jaw1.func_78792_a(this.Jaw2); this.Tail2.func_78792_a(this.Tail3); this.Head1.func_78792_a(this.TentacleR); this.SideHornL2.func_78792_a(this.SideHornL3); this.Tail1.func_78792_a(this.DragonFin3); this.Tail6.func_78792_a(this.Tail7);
/*     */     this.Tail4.func_78792_a(this.Tail5);
/*     */     this.PalmR1.func_78792_a(this.RFingerP1);
/*     */     this.Tail13.func_78792_a(this.Tail14);
/* 628 */     this.LFingerP1.func_78792_a(this.LFingerP2); } public void func_78087_a(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) { f2 = entity.field_70173_aa;
/* 629 */     boolean update = (f2 > this.last_update_tick);
/* 630 */     this.last_update_tick = f2;
/*     */ 
/*     */     
/* 633 */     float rotation = 0.0F;
/* 634 */     float ANIMATION_MULTI = 1.0F;
/* 635 */     float ANIMATION_MULTI2 = 3.0F;
/*     */ 
/*     */ 
/*     */     
/* 639 */     this.Head1.field_78795_f = 0.5F;
/*     */     
/* 641 */     float r = MathHelper.func_76126_a(f2 * 0.01F * 3.0F) * 0.05F * 1.0F + 0.15F;
/* 642 */     float r2 = MathHelper.func_76126_a(f2 * 0.001F * 3.0F) * 0.05F * 1.0F + 0.15F;
/* 643 */     float ANIMATION_MULTI3 = 5.0F;
/* 644 */     float r3 = MathHelper.func_76126_a(f2 * 0.01F * 5.0F) * 0.05F * 1.0F + 0.15F;
/* 645 */     this.Jaw1.field_78795_f = r;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 650 */     rotation = -r2 * 0.5F;
/* 651 */     this.ShoulderR.field_78795_f = rotation * 1.0F;
/* 652 */     rotation = r2 * 0.05F;
/* 653 */     this.ShoulderR.field_78808_h = rotation * 1.0F;
/*     */     
/* 655 */     rotation = -r2;
/* 656 */     this.BicepR.field_78795_f = rotation * 1.0F;
/* 657 */     rotation = r2 * 1.0F;
/* 658 */     this.BicepR.field_78808_h = rotation * 1.0F;
/*     */     
/* 660 */     rotation = -r2 - 0.2F;
/* 661 */     this.ForeArmR.field_78795_f = rotation * 1.0F;
/* 662 */     rotation = -r2 * 1.0F;
/* 663 */     this.ForeArmR.field_78808_h = rotation * 1.0F;
/*     */     
/* 665 */     rotation = -r2 * 1.0F;
/* 666 */     this.RFingerT1.field_78795_f = rotation * 1.0F;
/* 667 */     rotation = -r2 * 2.0F;
/* 668 */     this.RFingerT1.field_78796_g = rotation * 1.0F;
/* 669 */     rotation = -r2 * 2.0F;
/* 670 */     this.RFingerL1.field_78795_f = -rotation * 1.0F;
/* 671 */     this.RFingerR1.field_78795_f = -rotation * 1.0F;
/* 672 */     this.RFingerM1.field_78795_f = -rotation * 1.0F;
/* 673 */     this.RFingerP1.field_78795_f = -rotation * 1.0F;
/*     */     
/* 675 */     rotation = 2.0F + r2 * 1.0F;
/* 676 */     this.PalmR1.field_78796_g = rotation * 1.0F;
/*     */ 
/*     */ 
/*     */     
/* 680 */     rotation = r3 * 1.0F;
/* 681 */     this.Body1.field_78795_f = rotation * 1.0F;
/* 682 */     rotation = -r3 * 1.0F;
/* 683 */     this.Body3.field_78795_f = rotation * 1.0F;
/*     */ 
/*     */ 
/*     */     
/* 687 */     rotation = -r3 * 0.5F;
/* 688 */     float rotation2 = rotation * 1.0F;
/* 689 */     this.Tail1.field_78796_g = rotation2 * 1.0F;
/* 690 */     this.Tail2.field_78796_g = rotation2 * 1.0F;
/* 691 */     rotation2 = rotation + -0.18203785F;
/* 692 */     this.Tail3.field_78796_g = rotation2 * 1.0F;
/* 693 */     rotation2 = rotation + -0.18203785F;
/* 694 */     this.Tail4.field_78796_g = rotation2 * 1.0F;
/* 695 */     rotation2 = rotation + -0.18203785F;
/* 696 */     this.Tail5.field_78796_g = rotation2 * 1.0F;
/* 697 */     rotation2 = rotation + -0.3642502F;
/* 698 */     this.Tail6.field_78796_g = rotation2 * 1.0F;
/* 699 */     rotation2 = rotation + -0.22759093F;
/* 700 */     this.Tail7.field_78796_g = rotation2 * 1.0F;
/* 701 */     rotation2 = rotation + -0.22759093F;
/* 702 */     this.Tail8.field_78796_g = rotation2 * 1.0F;
/* 703 */     rotation2 = r3 * 1.6F;
/* 704 */     this.Tail9.field_78796_g = rotation2 * 1.0F;
/* 705 */     rotation2 = rotation + -0.31869712F;
/* 706 */     this.Tail10.field_78796_g = rotation2 * 1.0F;
/* 707 */     rotation2 = rotation + -0.13665928F;
/* 708 */     this.Tail11.field_78796_g = rotation2 * 1.0F;
/* 709 */     rotation2 = rotation + -0.18203785F;
/* 710 */     this.Tail12.field_78796_g = rotation2 * 1.0F;
/* 711 */     rotation2 = rotation + -0.091106184F;
/* 712 */     this.Tail13.field_78796_g = rotation2 * 1.0F;
/* 713 */     rotation2 = rotation + -0.091106184F;
/* 714 */     this.Tail14.field_78796_g = rotation2 * 1.0F;
/* 715 */     rotation2 = rotation + -0.091106184F;
/* 716 */     this.Tail15.field_78796_g = rotation2 * 1.0F;
/*     */ 
/*     */     
/* 719 */     if (!this.whis_granted) {
/*     */ 
/*     */       
/* 722 */       rotation = -r2 * 0.5F;
/* 723 */       this.ShoulderL.field_78795_f = rotation * 1.0F;
/* 724 */       rotation = -r2 * 0.05F;
/* 725 */       this.ShoulderL.field_78808_h = rotation * 1.0F;
/*     */       
/* 727 */       rotation = -r2;
/* 728 */       this.BicepL.field_78795_f = rotation * 1.0F;
/* 729 */       rotation = -r2 * 1.0F;
/* 730 */       this.BicepL.field_78808_h = rotation * 1.0F;
/*     */       
/* 732 */       rotation = -r2 - 0.2F;
/* 733 */       this.ForeArmL.field_78795_f = rotation * 1.0F;
/* 734 */       rotation = r2 * 1.0F;
/* 735 */       this.ForeArmL.field_78808_h = rotation * 1.0F;
/*     */       
/* 737 */       rotation = -r2 * 1.0F;
/* 738 */       this.LFingerT1.field_78795_f = rotation * 1.0F;
/* 739 */       rotation = -r2 * 2.0F;
/* 740 */       this.LFingerT1.field_78796_g = -rotation * 1.0F;
/* 741 */       rotation = -r2 * 2.0F;
/* 742 */       this.LFingerL1.field_78795_f = -rotation * 1.0F;
/* 743 */       this.LFingerR1.field_78795_f = -rotation * 1.0F;
/* 744 */       this.LFingerM1.field_78795_f = -rotation * 1.0F;
/* 745 */       this.LFingerP1.field_78795_f = -rotation * 1.0F;
/*     */       
/* 747 */       rotation = -r2 * 2.0F;
/* 748 */       this.LFingersT2.field_78796_g = 1.0471976F;
/* 749 */       this.LFingerL2.field_78795_f = 0.8651597F;
/* 750 */       this.LFingerR2.field_78795_f = 1.0016445F;
/* 751 */       this.LFingerM2.field_78795_f = 1.0016445F;
/* 752 */       this.LFingerP2.field_78795_f = 0.8651597F;
/*     */       
/* 754 */       rotation = -2.0F - r2 * 1.0F;
/* 755 */       this.PalmL1.field_78796_g = rotation * 1.0F;
/*     */     
/*     */     }
/*     */     else {
/*     */       
/* 760 */       rotation = -r2 * 0.5F;
/* 761 */       this.ShoulderL.field_78795_f = rotation * 1.0F;
/* 762 */       rotation = -r2 * 0.05F;
/* 763 */       this.ShoulderL.field_78808_h = rotation * 1.0F;
/*     */       
/* 765 */       rotation = -r2;
/* 766 */       this.BicepL.field_78795_f = -0.4F;
/* 767 */       rotation = -r2 * 1.0F;
/* 768 */       this.BicepL.field_78808_h = -0.6F;
/*     */       
/* 770 */       rotation = -r2 - 0.2F;
/* 771 */       this.ForeArmL.field_78795_f = -1.5F;
/* 772 */       rotation = r2 * 1.0F;
/* 773 */       this.ForeArmL.field_78808_h = rotation * 1.0F;
/*     */       
/* 775 */       this.LFingerT1.field_78795_f = -1.8F;
/* 776 */       this.LFingerT1.field_78796_g = 1.6F;
/* 777 */       this.LFingerL1.field_78795_f = 0.1F;
/* 778 */       this.LFingerR1.field_78795_f = 0.0F;
/* 779 */       this.LFingerM1.field_78795_f = 0.0F;
/* 780 */       this.LFingerP1.field_78795_f = 1.1F;
/*     */ 
/*     */       
/* 783 */       this.LFingersT2.field_78796_g = 0.5F;
/* 784 */       this.LFingerL2.field_78795_f = 0.2F;
/* 785 */       this.LFingerR2.field_78795_f = 0.2F;
/* 786 */       this.LFingerM2.field_78795_f = 0.2F;
/* 787 */       this.LFingerP2.field_78795_f = 1.2F;
/*     */       
/* 789 */       this.PalmL1.field_78796_g = -2.0F;
/*     */     }  }
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/*     */     modelRenderer.field_78795_f = x;
/*     */     modelRenderer.field_78796_g = y;
/*     */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*     */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     GL11.glPushMatrix();
/*     */     GL11.glTranslatef(0.0F, -0.5F, 0.0F);
/*     */     this.Head1.func_78785_a(f5);
/*     */     this.ShoulderR.func_78785_a(f5);
/*     */     this.Body1.func_78785_a(f5);
/*     */     this.ShoulderL.func_78785_a(f5);
/*     */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */   public void renderModel(Entity entity, float f) {
/*     */     func_78088_a(entity, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, f);
/*     */   }
/*     */   
/*     */   public void renderModel2(Entity entity, float f) {
/*     */     func_78088_a(entity, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, f);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelPorunga.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */