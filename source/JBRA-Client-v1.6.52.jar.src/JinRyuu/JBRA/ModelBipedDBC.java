/*      */ package JinRyuu.JBRA;
/*      */ 
/*      */ import JinRyuu.JRMCore.JRMCoreClient;
/*      */ import JinRyuu.JRMCore.JRMCoreH;
/*      */ import JinRyuu.JRMCore.entity.ModelBipedBody;
/*      */ import cpw.mods.fml.relauncher.Side;
/*      */ import cpw.mods.fml.relauncher.SideOnly;
/*      */ import java.util.Random;
/*      */ import net.minecraft.client.entity.AbstractClientPlayer;
/*      */ import net.minecraft.client.model.ModelBase;
/*      */ import net.minecraft.client.model.ModelRenderer;
/*      */ import net.minecraft.util.MathHelper;
/*      */ import org.lwjgl.opengl.GL11;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ @SideOnly(Side.CLIENT)
/*      */ public class ModelBipedDBC
/*      */   extends ModelBipedBody
/*      */ {
/*      */   private static final int hTOP = 4;
/*      */   private static final int hRIGHT = 1;
/*      */   private static final int hLeft = 2;
/*      */   private static final int hBACK = 3;
/*      */   public ModelRenderer bipedHeadAll;
/*      */   public ModelRenderer bipedHeadg;
/*      */   public ModelRenderer bipedHeadt;
/*      */   public ModelRenderer bipedHeadsg;
/*      */   public ModelRenderer bipedHeadssg;
/*      */   public ModelRenderer bipedHeadst;
/*      */   public ModelRenderer bipedHeadsst;
/*      */   public ModelRenderer bipedHeadv;
/*      */   public ModelRenderer bipedHeadsv;
/*      */   public ModelRenderer bipedHeadssv;
/*      */   public ModelRenderer bipedHeadgh;
/*      */   public ModelRenderer bipedHeadsgh;
/*      */   public ModelRenderer bipedHeadssgh;
/*      */   public ModelRenderer bipedHeadnull;
/*      */   public ModelRenderer bipedHeadg2;
/*      */   public ModelRenderer bipedHeadght;
/*      */   public ModelRenderer bipedHeadgt;
/*      */   public ModelRenderer bipedHeadgtt;
/*      */   public ModelRenderer bipedHeadrad;
/*      */   public ModelRenderer bipedHeadradl2;
/*      */   public ModelRenderer bipedHeadradl;
/*      */   public ModelRenderer bipedHeadc7;
/*      */   public ModelRenderer bipedHeadc8;
/*      */   public ModelRenderer bipedHeadssj3;
/*      */   public ModelRenderer bipedHeadssj3l;
/*      */   public ModelRenderer bipedHeadssj3t;
/*      */   public ModelRenderer bipedHeadssj3l2;
/*      */   public ModelRenderer goku1;
/*      */   public ModelRenderer goku2;
/*      */   public ModelRenderer goku3;
/*      */   public ModelRenderer goku4;
/*      */   public ModelRenderer goku5;
/*      */   public ModelRenderer goku6;
/*      */   public ModelRenderer goku7;
/*      */   public ModelRenderer goku8;
/*      */   public ModelRenderer goku9;
/*      */   public ModelRenderer goku10;
/*      */   public ModelRenderer goku11;
/*      */   public ModelRenderer goku12;
/*      */   public ModelRenderer goku13;
/*      */   public ModelRenderer goku14;
/*      */   public ModelRenderer goku15;
/*      */   public ModelRenderer goku16;
/*      */   public ModelRenderer sgoku1;
/*      */   public ModelRenderer sgoku2;
/*      */   public ModelRenderer sgoku3;
/*      */   public ModelRenderer sgoku4;
/*      */   public ModelRenderer sgoku5;
/*      */   public ModelRenderer sgoku6;
/*      */   public ModelRenderer sgoku7;
/*      */   public ModelRenderer sgoku8;
/*      */   public ModelRenderer sgoku9;
/*      */   public ModelRenderer sgoku10;
/*      */   public ModelRenderer sgoku11;
/*      */   public ModelRenderer sgoku12;
/*      */   public ModelRenderer sgoku13;
/*      */   public ModelRenderer sgoku14;
/*      */   public ModelRenderer sgoku15;
/*      */   public ModelRenderer sgoku16;
/*      */   public ModelRenderer sgoku17;
/*      */   public ModelRenderer sgoku18;
/*      */   public ModelRenderer sgoku19;
/*      */   public ModelRenderer sgoku20;
/*      */   public ModelRenderer sgoku21;
/*      */   public ModelRenderer sgoku22;
/*      */   public ModelRenderer sgoku23;
/*      */   public ModelRenderer sgoku24;
/*      */   public ModelRenderer sgoku25;
/*      */   public ModelRenderer sgoku26;
/*      */   public ModelRenderer ssgoku1;
/*      */   public ModelRenderer ssgoku2;
/*      */   public ModelRenderer ssgoku3;
/*      */   public ModelRenderer ssgoku4;
/*      */   public ModelRenderer ssgoku5;
/*      */   public ModelRenderer ssgoku6;
/*      */   public ModelRenderer ssgoku7;
/*      */   public ModelRenderer ssgoku8;
/*      */   public ModelRenderer ssgoku9;
/*      */   public ModelRenderer ssgoku10;
/*      */   public ModelRenderer ssgoku11;
/*      */   public ModelRenderer ssgoku12;
/*      */   public ModelRenderer ssgoku13;
/*      */   public ModelRenderer ssgoku14;
/*      */   public ModelRenderer ssgoku15;
/*      */   public ModelRenderer ssgoku16;
/*      */   public ModelRenderer ssgoku17;
/*      */   public ModelRenderer ssgoku18;
/*      */   public ModelRenderer ssgoku19;
/*      */   public ModelRenderer ssgoku20;
/*      */   public ModelRenderer ssgoku21;
/*      */   public ModelRenderer ssgoku22;
/*      */   public ModelRenderer ssgoku23;
/*      */   public ModelRenderer ssgoku24;
/*      */   public ModelRenderer ssgoku25;
/*      */   public ModelRenderer ssgoku26;
/*      */   public ModelRenderer trunk1;
/*      */   public ModelRenderer trunk2;
/*      */   public ModelRenderer trunk3;
/*      */   public ModelRenderer trunk4;
/*      */   public ModelRenderer trunk5;
/*      */   public ModelRenderer trunk6;
/*      */   public ModelRenderer trunk7;
/*      */   public ModelRenderer trunk8;
/*      */   public ModelRenderer trunk9;
/*      */   public ModelRenderer strunk1;
/*      */   public ModelRenderer strunk2;
/*      */   public ModelRenderer strunk3;
/*      */   public ModelRenderer strunk4;
/*      */   public ModelRenderer strunk5;
/*      */   public ModelRenderer strunk6;
/*      */   public ModelRenderer strunk7;
/*      */   public ModelRenderer strunk8;
/*      */   public ModelRenderer strunk9;
/*      */   public ModelRenderer strunk10;
/*      */   public ModelRenderer strunk11;
/*      */   public ModelRenderer strunk12;
/*      */   public ModelRenderer strunk13;
/*      */   public ModelRenderer strunk14;
/*      */   public ModelRenderer strunk15;
/*      */   public ModelRenderer strunk16;
/*      */   public ModelRenderer strunk17;
/*      */   public ModelRenderer sstrunk1;
/*      */   public ModelRenderer sstrunk2;
/*      */   public ModelRenderer sstrunk3;
/*      */   public ModelRenderer sstrunk4;
/*      */   public ModelRenderer sstrunk5;
/*      */   public ModelRenderer sstrunk6;
/*      */   public ModelRenderer sstrunk7;
/*      */   public ModelRenderer sstrunk8;
/*      */   public ModelRenderer sstrunk9;
/*      */   public ModelRenderer sstrunk10;
/*      */   public ModelRenderer sstrunk11;
/*      */   public ModelRenderer sstrunk12;
/*      */   public ModelRenderer sstrunk13;
/*      */   public ModelRenderer sstrunk14;
/*      */   public ModelRenderer sstrunk15;
/*      */   public ModelRenderer sstrunk16;
/*      */   public ModelRenderer sstrunk17;
/*      */   public ModelRenderer vegeta1;
/*      */   public ModelRenderer vegeta2;
/*      */   public ModelRenderer vegeta3;
/*      */   public ModelRenderer vegeta4;
/*      */   public ModelRenderer vegeta5;
/*      */   public ModelRenderer vegeta6;
/*      */   public ModelRenderer vegeta7;
/*      */   public ModelRenderer vegeta8;
/*      */   public ModelRenderer vegeta9;
/*      */   public ModelRenderer vegeta10;
/*      */   public ModelRenderer vegeta11;
/*      */   public ModelRenderer vegeta12;
/*      */   public ModelRenderer vegeta13;
/*      */   public ModelRenderer vegeta14;
/*      */   public ModelRenderer vegeta15;
/*      */   public ModelRenderer vegeta16;
/*      */   public ModelRenderer vegeta17;
/*      */   public ModelRenderer vegeta18;
/*      */   public ModelRenderer vegeta19;
/*      */   public ModelRenderer vegeta20;
/*      */   public ModelRenderer vegeta21;
/*      */   public ModelRenderer vegeta22;
/*      */   public ModelRenderer svegeta1;
/*      */   public ModelRenderer svegeta2;
/*      */   public ModelRenderer svegeta3;
/*      */   public ModelRenderer svegeta4;
/*      */   public ModelRenderer svegeta5;
/*      */   public ModelRenderer svegeta6;
/*      */   public ModelRenderer svegeta7;
/*      */   public ModelRenderer svegeta8;
/*      */   public ModelRenderer svegeta9;
/*      */   public ModelRenderer svegeta10;
/*      */   public ModelRenderer svegeta11;
/*      */   public ModelRenderer svegeta12;
/*      */   public ModelRenderer svegeta13;
/*      */   public ModelRenderer svegeta14;
/*      */   public ModelRenderer svegeta15;
/*      */   public ModelRenderer svegeta16;
/*      */   public ModelRenderer svegeta17;
/*      */   public ModelRenderer svegeta18;
/*      */   public ModelRenderer svegeta19;
/*      */   public ModelRenderer svegeta20;
/*      */   public ModelRenderer svegeta21;
/*      */   public ModelRenderer svegeta22;
/*      */   public ModelRenderer ssvegeta1;
/*      */   public ModelRenderer ssvegeta2;
/*      */   public ModelRenderer ssvegeta3;
/*      */   public ModelRenderer ssvegeta4;
/*      */   public ModelRenderer ssvegeta5;
/*      */   public ModelRenderer ssvegeta6;
/*      */   public ModelRenderer ssvegeta7;
/*      */   public ModelRenderer ssvegeta8;
/*      */   public ModelRenderer ssvegeta9;
/*      */   public ModelRenderer ssvegeta10;
/*      */   public ModelRenderer ssvegeta11;
/*      */   public ModelRenderer ssvegeta12;
/*      */   public ModelRenderer ssvegeta13;
/*      */   public ModelRenderer ssvegeta14;
/*      */   public ModelRenderer ssvegeta15;
/*      */   public ModelRenderer ssvegeta16;
/*      */   public ModelRenderer ssvegeta17;
/*      */   public ModelRenderer ssvegeta18;
/*      */   public ModelRenderer ssvegeta19;
/*      */   public ModelRenderer ssvegeta20;
/*      */   public ModelRenderer ssvegeta21;
/*      */   public ModelRenderer ssvegeta22;
/*      */   public ModelRenderer gohan1;
/*      */   public ModelRenderer gohan7;
/*      */   public ModelRenderer gohan8;
/*      */   public ModelRenderer gohan10;
/*      */   public ModelRenderer gohan11;
/*      */   public ModelRenderer gohan12;
/*      */   public ModelRenderer gohan13;
/*      */   public ModelRenderer gohan14;
/*      */   public ModelRenderer gohan15;
/*      */   public ModelRenderer gohan16;
/*      */   public ModelRenderer gohan17;
/*      */   public ModelRenderer gohan18;
/*      */   public ModelRenderer gohan19;
/*      */   public ModelRenderer gohan20;
/*      */   public ModelRenderer gohan21;
/*      */   public ModelRenderer gohan22;
/*      */   public ModelRenderer gohan26;
/*      */   public ModelRenderer sgohan1;
/*      */   public ModelRenderer sgohan7;
/*      */   public ModelRenderer sgohan8;
/*      */   public ModelRenderer sgohan10;
/*      */   public ModelRenderer sgohan11;
/*      */   public ModelRenderer sgohan12;
/*      */   public ModelRenderer sgohan13;
/*      */   public ModelRenderer sgohan14;
/*      */   public ModelRenderer sgohan15;
/*      */   public ModelRenderer sgohan16;
/*      */   public ModelRenderer sgohan17;
/*      */   public ModelRenderer sgohan18;
/*      */   public ModelRenderer sgohan19;
/*      */   public ModelRenderer sgohan20;
/*      */   public ModelRenderer sgohan21;
/*      */   public ModelRenderer sgohan22;
/*      */   public ModelRenderer sgohan26;
/*      */   public ModelRenderer ssgohan1;
/*      */   public ModelRenderer ssgohan7;
/*      */   public ModelRenderer ssgohan8;
/*      */   public ModelRenderer ssgohan10;
/*      */   public ModelRenderer ssgohan11;
/*      */   public ModelRenderer ssgohan12;
/*      */   public ModelRenderer ssgohan13;
/*      */   public ModelRenderer ssgohan14;
/*      */   public ModelRenderer ssgohan15;
/*      */   public ModelRenderer ssgohan16;
/*      */   public ModelRenderer ssgohan17;
/*      */   public ModelRenderer ssgohan18;
/*      */   public ModelRenderer ssgohan19;
/*      */   public ModelRenderer ssgohan20;
/*      */   public ModelRenderer ssgohan21;
/*      */   public ModelRenderer ssgohan22;
/*      */   public ModelRenderer ssgohan26;
/*      */   public ModelRenderer gokuni1;
/*      */   public ModelRenderer gokuni2;
/*      */   public ModelRenderer gokuni3;
/*      */   public ModelRenderer gokuni4;
/*      */   public ModelRenderer gokuni5;
/*      */   public ModelRenderer gokuni6;
/*      */   public ModelRenderer gokuni7;
/*      */   public ModelRenderer gokuni8;
/*      */   public ModelRenderer gokuni9;
/*      */   public ModelRenderer gokuni10;
/*      */   public ModelRenderer gokuni11;
/*      */   public ModelRenderer gokuni12;
/*      */   public ModelRenderer ght1;
/*      */   public ModelRenderer ght2;
/*      */   public ModelRenderer ght3;
/*      */   public ModelRenderer ght4;
/*      */   public ModelRenderer ght5;
/*      */   public ModelRenderer ght6;
/*      */   public ModelRenderer ght7;
/*      */   public ModelRenderer ght8;
/*      */   public ModelRenderer ght9;
/*      */   public ModelRenderer ght11;
/*      */   public ModelRenderer ght14;
/*      */   public ModelRenderer ght16;
/*      */   public ModelRenderer goten2;
/*      */   public ModelRenderer goten3;
/*      */   public ModelRenderer goten4;
/*      */   public ModelRenderer goten5;
/*      */   public ModelRenderer goten6;
/*      */   public ModelRenderer goten9;
/*      */   public ModelRenderer goten14;
/*      */   public ModelRenderer goten16;
/*      */   public ModelRenderer gotent1;
/*      */   public ModelRenderer gotent2;
/*      */   public ModelRenderer gotent3;
/*      */   public ModelRenderer gotent5;
/*      */   public ModelRenderer gotent6;
/*      */   public ModelRenderer gotent7;
/*      */   public ModelRenderer gotent8;
/*      */   public ModelRenderer gotent9;
/*      */   public ModelRenderer gotent11;
/*      */   public ModelRenderer gotent16;
/*      */   public ModelRenderer hairc71;
/*      */   public ModelRenderer hairc72;
/*      */   public ModelRenderer hairc81;
/*      */   public ModelRenderer hairc82;
/*      */   public ModelRenderer hairc83;
/*      */   public ModelRenderer radlike1;
/*      */   public ModelRenderer radlike2;
/*      */   public ModelRenderer radlike3;
/*      */   public ModelRenderer radlike4;
/*      */   public ModelRenderer radlike5;
/*      */   public ModelRenderer radlike7;
/*      */   public ModelRenderer radlike8;
/*      */   public ModelRenderer radlike10;
/*      */   public ModelRenderer radlike11;
/*      */   public ModelRenderer radlike12;
/*      */   public ModelRenderer radlike13;
/*      */   public ModelRenderer radlike14;
/*      */   public ModelRenderer radlike15;
/*      */   public ModelRenderer radlike16;
/*      */   public ModelRenderer radlike17;
/*      */   public ModelRenderer radlike18;
/*      */   public ModelRenderer radlike19;
/*      */   public ModelRenderer radlike20;
/*      */   public ModelRenderer radlike21;
/*      */   public ModelRenderer radlike22;
/*      */   public ModelRenderer radlike23;
/*      */   public ModelRenderer radlike24;
/*      */   public ModelRenderer radlike25;
/*      */   public ModelRenderer radlike26;
/*      */   public ModelRenderer radlike27;
/*      */   public ModelRenderer radlike28;
/*      */   public ModelRenderer radlike29;
/*      */   public ModelRenderer radlike30;
/*      */   public ModelRenderer radlike31;
/*      */   public ModelRenderer radlike32;
/*      */   public ModelRenderer radlik6;
/*      */   public ModelRenderer radlik7;
/*      */   public ModelRenderer radlik15;
/*      */   public ModelRenderer radlik1;
/*      */   public ModelRenderer radlik2;
/*      */   public ModelRenderer radlik3;
/*      */   public ModelRenderer radlik4;
/*      */   public ModelRenderer radlik5;
/*      */   public ModelRenderer radlik8;
/*      */   public ModelRenderer radlik9;
/*      */   public ModelRenderer radlik10;
/*      */   public ModelRenderer radlik11;
/*      */   public ModelRenderer radlik12;
/*      */   public ModelRenderer radlik13;
/*      */   public ModelRenderer radlik14;
/*      */   public ModelRenderer radlik16;
/*      */   public ModelRenderer radlik17;
/*      */   public ModelRenderer radlik18;
/*      */   public ModelRenderer ssjsan1;
/*      */   public ModelRenderer ssjsan2;
/*      */   public ModelRenderer ssjsan3;
/*      */   public ModelRenderer ssjsan4;
/*      */   public ModelRenderer ssjsan5;
/*      */   public ModelRenderer ssjsan7;
/*      */   public ModelRenderer ssjsan8;
/*      */   public ModelRenderer ssjsan10;
/*      */   public ModelRenderer ssjsan11;
/*      */   public ModelRenderer ssjsan12;
/*      */   public ModelRenderer ssjsan13;
/*      */   public ModelRenderer ssjsan14;
/*      */   public ModelRenderer ssjsan15;
/*      */   public ModelRenderer ssjsan16;
/*      */   public ModelRenderer ssjsan17;
/*      */   public ModelRenderer ssjsan18;
/*      */   public ModelRenderer ssjsan19;
/*      */   public ModelRenderer ssjsan20;
/*      */   public ModelRenderer ssjsan21;
/*      */   public ModelRenderer ssjsan22;
/*      */   public ModelRenderer ssjsan23;
/*      */   public ModelRenderer ssjsan24;
/*      */   public ModelRenderer ssjsan25;
/*      */   public ModelRenderer ssjsan26;
/*      */   public ModelRenderer ssjsan27;
/*      */   public ModelRenderer ssjsan28;
/*      */   public ModelRenderer ssjsan29;
/*      */   public ModelRenderer ssjsan30;
/*      */   public ModelRenderer ssjsan31;
/*      */   public ModelRenderer ssjsan32;
/*      */   public ModelRenderer long6;
/*      */   public ModelRenderer long7;
/*      */   public ModelRenderer long15;
/*      */   public ModelRenderer long1;
/*      */   public ModelRenderer long2;
/*      */   public ModelRenderer long3;
/*      */   public ModelRenderer long4;
/*      */   public ModelRenderer long5;
/*      */   public ModelRenderer long8;
/*      */   public ModelRenderer long9;
/*      */   public ModelRenderer long10;
/*      */   public ModelRenderer long11;
/*      */   public ModelRenderer long12;
/*      */   public ModelRenderer long13;
/*      */   public ModelRenderer long14;
/*      */   public ModelRenderer long16;
/*      */   public ModelRenderer long17;
/*      */   public ModelRenderer long18;
/*      */   public ModelRenderer tincs1;
/*      */   public ModelRenderer halo;
/*      */   public ModelRenderer halo1;
/*      */   public ModelRenderer halo2;
/*      */   public ModelRenderer halo3;
/*      */   public ModelRenderer halo4;
/*      */   public ModelRenderer rightarm;
/*      */   public ModelRenderer leftarm;
/*      */   public ModelRenderer Brightarm;
/*      */   public ModelRenderer Bleftarm;
/*      */   public ModelRenderer rightleg;
/*      */   public ModelRenderer leftleg;
/*      */   public ModelRenderer skirt1;
/*      */   public ModelRenderer skirt2;
/*      */   public ModelRenderer body;
/*      */   public ModelRenderer hip;
/*      */   public ModelRenderer waist;
/*      */   public ModelRenderer Bbreast;
/*      */   public ModelRenderer breast;
/*      */   public ModelRenderer bottom;
/*      */   public ModelRenderer breast2;
/*      */   public ModelRenderer Bbreast2;
/*      */   public ModelRenderer Nam;
/*      */   public ModelRenderer near1;
/*      */   public ModelRenderer near2;
/*      */   public ModelRenderer ant1;
/*      */   public ModelRenderer ant2;
/*      */   public ModelRenderer ant3;
/*      */   public ModelRenderer ant4;
/*      */   public ModelRenderer Fro;
/*      */   public ModelRenderer Fro0;
/*      */   public ModelRenderer Fro1;
/*      */   public ModelRenderer Fro2;
/*      */   public ModelRenderer Fro5;
/*      */   public ModelRenderer Fro5b;
/*      */   public ModelRenderer Fro5l;
/*      */   public ModelRenderer Fro5r;
/*      */   public ModelRenderer FroB;
/*      */   public ModelRenderer appule;
/*      */   public ModelRenderer Fhorn2;
/*      */   public ModelRenderer Fhorn1;
/*      */   public ModelRenderer Fhorn3;
/*      */   public ModelRenderer Fhorn4;
/*      */   public ModelRenderer F2horn1;
/*      */   public ModelRenderer F2horn2;
/*      */   public ModelRenderer F5horn1;
/*      */   public ModelRenderer F5horn2;
/*      */   public ModelRenderer F5horn3;
/*      */   public ModelRenderer F5horn4;
/*      */   public ModelRenderer F5horn5;
/*      */   public ModelRenderer F5spike1;
/*      */   public ModelRenderer F5spike2;
/*      */   public ModelRenderer F5spike3;
/*      */   public ModelRenderer F5spike4;
/*      */   public ModelRenderer ftail1;
/*      */   public ModelRenderer ftail2;
/*      */   public ModelRenderer fear1;
/*      */   public ModelRenderer fear2;
/*      */   public ModelRenderer leftarmshoulder;
/*      */   public ModelRenderer rightarmshoulder;
/*      */   public ModelRenderer ftailS1;
/*      */   public ModelRenderer ftailS2;
/*      */   public ModelRenderer ftailS3;
/*      */   public ModelRenderer ftailS4;
/*      */   public ModelRenderer ftailS5;
/*      */   public ModelRenderer ftailS6;
/*      */   public ModelRenderer SaiE;
/*      */   public ModelRenderer kao;
/*      */   public ModelRenderer SaiT1;
/*      */   public ModelRenderer SaiT2;
/*      */   public ModelRenderer tail1;
/*      */   public ModelRenderer tail2;
/*      */   public ModelRenderer tailS3;
/*      */   public ModelRenderer tailS4;
/*      */   public ModelRenderer tailS5;
/*      */   public ModelRenderer tailS6;
/*      */   public ModelRenderer tail3;
/*      */   public ModelRenderer tail4;
/*      */   public ModelRenderer tail5;
/*      */   public ModelRenderer tail6;
/*      */   public ModelRenderer SaiO;
/*      */   public ModelRenderer SaiOmouth;
/*      */   public ModelRenderer WShell;
/*      */   public ModelRenderer WRightarm;
/*      */   public ModelRenderer WLeftarm;
/*      */   public ModelRenderer WRightleg;
/*      */   public ModelRenderer WLeftleg;
/*      */   public ModelRendererJBRA[] hairall;
/*      */   public ModelRenderer face1;
/*      */   public ModelRenderer nose;
/*      */   public ModelRenderer face2;
/*      */   public ModelRenderer mouth;
/*      */   public ModelRenderer face3;
/*      */   public ModelRenderer eyel;
/*      */   public ModelRenderer face4;
/*      */   public ModelRenderer eyer;
/*      */   public ModelRenderer face5;
/*      */   public ModelRenderer eyeb;
/*      */   public ModelRenderer face6;
/*      */   public ModelRenderer eyew;
/*      */   private boolean tail1B1;
/*      */   private boolean tail2B1;
/*      */   private boolean tailS3B1;
/*      */   private boolean tailS4B1;
/*      */   private boolean tailS5B1;
/*      */   private boolean tailS6B1;
/*      */   private boolean tail1B2;
/*      */   private boolean tail2B2;
/*      */   private boolean tailS3B2;
/*      */   private boolean tailS4B2;
/*      */   private boolean tailS5B2;
/*      */   private boolean tailS6B2;
/*      */   
/*      */   public ModelBipedDBC() {
/*  565 */     this(0.0F);
/*      */   }
/*      */ 
/*      */   
/*      */   public ModelBipedDBC(float par1) {
/*  570 */     this(par1, 0.0F, 64, 32);
/*      */   }
/*      */   
/*      */   public ModelBipedDBC(float par1, float par2, int par3, int par4)
/*      */   {
/*  575 */     super(par1, par2, par3, par4);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3770 */     this.tail1B1 = false;
/* 3771 */     this.tail2B1 = false;
/* 3772 */     this.tailS3B1 = false;
/* 3773 */     this.tailS4B1 = false;
/* 3774 */     this.tailS5B1 = false;
/* 3775 */     this.tailS6B1 = false;
/* 3776 */     this.tail1B2 = false;
/* 3777 */     this.tail2B2 = false;
/* 3778 */     this.tailS3B2 = false;
/* 3779 */     this.tailS4B2 = false;
/* 3780 */     this.tailS5B2 = false;
/* 3781 */     this.tailS6B2 = false; model(par1, par2, par3, par4); }
/*      */   public void model(float par1, float par2, int par3, int par4) { this.field_78119_l = 0; this.field_78120_m = 0; this.field_78117_n = false; this.field_78118_o = false; this.field_78090_t = par3; this.field_78089_u = par4; this.bipedHeadg = new ModelRenderer((ModelBase)this, 0, 0); this.bipedHeadg.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.bipedHeadg.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.bipedHeadt = new ModelRenderer((ModelBase)this, 0, 0); this.bipedHeadt.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.bipedHeadt.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.bipedHeadsg = new ModelRenderer((ModelBase)this, 0, 0); this.bipedHeadsg.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.bipedHeadsg.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.bipedHeadssg = new ModelRenderer((ModelBase)this, 0, 0); this.bipedHeadssg.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.bipedHeadssg.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.bipedHeadst = new ModelRenderer((ModelBase)this, 0, 0); this.bipedHeadst.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.bipedHeadst.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.bipedHeadsst = new ModelRenderer((ModelBase)this, 0, 0); this.bipedHeadsst.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.bipedHeadsst.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.bipedHeadv = new ModelRenderer((ModelBase)this, 0, 0); this.bipedHeadv.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.bipedHeadv.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.bipedHeadsv = new ModelRenderer((ModelBase)this, 0, 0); this.bipedHeadsv.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.bipedHeadsv.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.bipedHeadssv = new ModelRenderer((ModelBase)this, 0, 0); this.bipedHeadssv.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.bipedHeadssv.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.bipedHeadgh = new ModelRenderer((ModelBase)this, 0, 0); this.bipedHeadgh.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.bipedHeadgh.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.bipedHeadsgh = new ModelRenderer((ModelBase)this, 0, 0); this.bipedHeadsgh.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.bipedHeadsgh.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.bipedHeadssgh = new ModelRenderer((ModelBase)this, 0, 0); this.bipedHeadssgh.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.bipedHeadssgh.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.bipedHeadnull = new ModelRenderer((ModelBase)this, 0, 0); this.bipedHeadnull.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.bipedHeadnull.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.bipedHeadg2 = new ModelRenderer((ModelBase)this, 0, 0); this.bipedHeadg2.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.bipedHeadg2.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.bipedHeadght = new ModelRenderer((ModelBase)this, 0, 0); this.bipedHeadght.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.bipedHeadght.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.bipedHeadgt = new ModelRenderer((ModelBase)this, 0, 0); this.bipedHeadgt.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.bipedHeadgt.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.bipedHeadgtt = new ModelRenderer((ModelBase)this, 0, 0); this.bipedHeadgtt.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.bipedHeadgtt.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.bipedHeadc7 = new ModelRenderer((ModelBase)this, 0, 0); this.bipedHeadc7.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.bipedHeadc7.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.bipedHeadc8 = new ModelRenderer((ModelBase)this, 0, 0); this.bipedHeadc8.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.bipedHeadc8.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.bipedHeadrad = new ModelRenderer((ModelBase)this, 0, 0); this.bipedHeadrad.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.bipedHeadrad.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.bipedHeadradl2 = new ModelRenderer((ModelBase)this, 0, 0); this.bipedHeadradl2.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.bipedHeadradl2.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.bipedHeadradl = new ModelRenderer((ModelBase)this, 0, 0); this.bipedHeadradl.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.bipedHeadradl.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.bipedHeadssj3 = new ModelRenderer((ModelBase)this, 0, 0); this.bipedHeadssj3.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.bipedHeadssj3.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.bipedHeadssj3l = new ModelRenderer((ModelBase)this, 0, 0); this.bipedHeadssj3l.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.bipedHeadssj3l.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.bipedHeadssj3t = new ModelRenderer((ModelBase)this, 0, 0); this.bipedHeadssj3t.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.bipedHeadssj3t.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.bipedHeadssj3l2 = new ModelRenderer((ModelBase)this, 0, 0); this.bipedHeadssj3l2.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.bipedHeadssj3l2.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.bipedHeadAll = new ModelRenderer((ModelBase)this, 0, 0); this.bipedHeadAll.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, par1 + 0.01F); this.bipedHeadAll.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.goku1 = new ModelRenderer((ModelBase)this, 32, 0); this.goku1.func_78789_a(-1.0F, -10.0F, 0.0F, 4, 4, 4); this.goku1.func_78793_a(0.0F, 0.0F, 0.0F); this.goku1.func_78787_b(128, 64); this.goku1.field_78809_i = true; setRotation(this.goku1, 0.1745329F, 0.0F, -0.4363323F); this.goku2 = new ModelRenderer((ModelBase)this, 32, 0); this.goku2.func_78789_a(-8.0F, -4.5F, 0.0F, 4, 3, 3); this.goku2.func_78793_a(0.0F, 0.0F, 0.0F); this.goku2.func_78787_b(128, 64); this.goku2.field_78809_i = true; setRotation(this.goku2, 0.0F, -0.1745329F, 0.3490659F); this.goku3 = new ModelRenderer((ModelBase)this, 32, 0); this.goku3.func_78789_a(-7.0F, -2.6F, 1.0F, 4, 2, 2); this.goku3.func_78793_a(0.0F, 0.0F, 0.0F); this.goku3.func_78787_b(128, 64); this.goku3.field_78809_i = true; setRotation(this.goku3, 0.0F, -0.2617994F, 0.1943133F); this.goku4 = new ModelRenderer((ModelBase)this, 32, 0); this.goku4.func_78789_a(3.0F, -4.0F, 0.0F, 4, 3, 3); this.goku4.func_78793_a(0.0F, 0.0F, 0.0F); this.goku4.func_78787_b(128, 64); this.goku4.field_78809_i = true; setRotation(this.goku4, 0.0F, 0.1745329F, -0.3490659F); this.goku5 = new ModelRenderer((ModelBase)this, 32, 0); this.goku5.func_78789_a(3.0F, -2.3F, 0.7F, 3, 2, 2); this.goku5.func_78793_a(0.0F, 0.0F, 0.0F); this.goku5.func_78787_b(128, 64); this.goku5.field_78809_i = true; setRotation(this.goku5, 0.0F, 0.1745329F, -0.1151917F); this.goku6 = new ModelRenderer((ModelBase)this, 32, 0); this.goku6.func_78789_a(5.0F, -4.3F, 1.5F, 3, 2, 2); this.goku6.func_78793_a(0.0F, 0.0F, 0.0F); this.goku6.func_78787_b(128, 64); this.goku6.field_78809_i = true; setRotation(this.goku6, 0.0F, 0.3490659F, -0.2617994F); this.goku7 = new ModelRenderer((ModelBase)this, 32, 0); this.goku7.func_78789_a(1.0F, -11.0F, 2.0F, 3, 3, 3); this.goku7.func_78793_a(0.0F, 0.0F, 0.0F); this.goku7.func_78787_b(128, 64); this.goku7.field_78809_i = true; setRotation(this.goku7, 0.3490659F, 0.0F, -0.6108652F); this.goku8 = new ModelRenderer((ModelBase)this, 32, 0); this.goku8.func_78789_a(3.0F, -12.0F, 4.0F, 2, 3, 2); this.goku8.func_78793_a(0.0F, 0.0F, 0.0F); this.goku8.func_78787_b(128, 64); this.goku8.field_78809_i = true; setRotation(this.goku8, 0.5235988F, 0.0F, -0.7853982F); this.goku9 = new ModelRenderer((ModelBase)this, 32, 0); this.goku9.func_78789_a(-9.0F, -4.7F, 1.5F, 3, 2, 2); this.goku9.func_78793_a(0.0F, 0.0F, 0.0F); this.goku9.func_78787_b(128, 64); this.goku9.field_78809_i = true; setRotation(this.goku9, 0.0F, -0.3490659F, 0.2617994F); this.goku10 = new ModelRenderer((ModelBase)this, 32, 0); this.goku10.func_78789_a(-10.0F, -4.8F, 1.0F, 5, 2, 2); this.goku10.func_78793_a(0.0F, 0.0F, 0.0F); this.goku10.func_78787_b(128, 64); this.goku10.field_78809_i = true; setRotation(this.goku10, 0.0F, -0.3839724F, 0.5270894F); this.goku11 = new ModelRenderer((ModelBase)this, 32, 0); this.goku11.func_78789_a(1.0F, -8.0F, 5.0F, 1, 4, 1); this.goku11.func_78793_a(0.0F, 0.0F, 0.0F); this.goku11.func_78787_b(128, 64); this.goku11.field_78809_i = true; setRotation(this.goku11, 0.6806784F, 0.0F, -0.1745329F); this.goku12 = new ModelRenderer((ModelBase)this, 32, 0); this.goku12.func_78789_a(-3.5F, -7.0F, -5.0F, 2, 3, 3); this.goku12.func_78793_a(0.0F, 0.0F, 0.0F); this.goku12.func_78787_b(128, 64); this.goku12.field_78809_i = true; setRotation(this.goku12, 0.0F, 0.0F, 0.4014257F); this.goku13 = new ModelRenderer((ModelBase)this, 32, 0); this.goku13.func_78789_a(-6.2F, -5.5F, -5.0F, 2, 3, 2); this.goku13.func_78793_a(0.0F, 0.0F, 0.0F); this.goku13.func_78787_b(128, 64); this.goku13.field_78809_i = true; setRotation(this.goku13, 0.0F, 0.0F, 0.5235988F); this.goku14 = new ModelRenderer((ModelBase)this, 32, 0); this.goku14.func_78789_a(-7.5F, -4.0F, -5.0F, 1, 3, 2); this.goku14.func_78793_a(0.0F, 0.0F, 0.0F); this.goku14.func_78787_b(128, 64); this.goku14.field_78809_i = true; setRotation(this.goku14, 0.0F, 0.0F, 0.6108652F); this.goku15 = new ModelRenderer((ModelBase)this, 32, 0); this.goku15.func_78789_a(3.2F, -6.5F, -5.0F, 2, 3, 2); this.goku15.func_78793_a(0.0F, 0.0F, 0.0F); this.goku15.func_78787_b(128, 64); this.goku15.field_78809_i = true; setRotation(this.goku15, 0.0F, 0.0F, -0.3490659F); this.goku16 = new ModelRenderer((ModelBase)this, 32, 0); this.goku16.func_78789_a(6.5F, -4.5F, -5.0F, 1, 3, 2); this.goku16.func_78793_a(0.0F, 0.0F, 0.0F); this.goku16.func_78787_b(128, 64); this.goku16.field_78809_i = true; setRotation(this.goku16, 0.0F, 0.0F, -0.6108652F); this.sgoku1 = new ModelRenderer((ModelBase)this, 32, 0); this.sgoku1.func_78789_a(-1.0F, -10.0F, -6.0F, 4, 4, 4); this.sgoku1.func_78793_a(0.0F, 0.0F, 0.0F); this.sgoku1.func_78787_b(128, 64); this.sgoku1.field_78809_i = true; setRotation(this.sgoku1, -0.3141593F, 0.0F, 0.0F); this.sgoku2 = new ModelRenderer((ModelBase)this, 32, 0); this.sgoku2.func_78789_a(-8.0F, -4.5F, -1.0F, 4, 3, 3); this.sgoku2.func_78793_a(0.0F, 0.0F, 0.0F); this.sgoku2.func_78787_b(128, 64); this.sgoku2.field_78809_i = true; setRotation(this.sgoku2, 0.0F, 0.1745329F, 0.5759587F); this.sgoku3 = new ModelRenderer((ModelBase)this, 32, 0); this.sgoku3.func_78789_a(-7.0F, -2.0F, 0.0F, 4, 2, 2); this.sgoku3.func_78793_a(0.0F, 0.0F, 0.0F); this.sgoku3.func_78787_b(128, 64); this.sgoku3.field_78809_i = true; setRotation(this.sgoku3, 0.0F, 0.2617994F, 0.5061455F); this.sgoku4 = new ModelRenderer((ModelBase)this, 32, 0); this.sgoku4.func_78789_a(4.0F, -4.0F, -1.0F, 4, 3, 3); this.sgoku4.func_78793_a(0.0F, 0.0F, 0.0F); this.sgoku4.func_78787_b(128, 64); this.sgoku4.field_78809_i = true; setRotation(this.sgoku4, 0.0F, -0.1745329F, -0.6108652F); this.sgoku5 = new ModelRenderer((ModelBase)this, 32, 0); this.sgoku5.func_78789_a(3.0F, -2.0F, 0.7F, 4, 2, 2); this.sgoku5.func_78793_a(0.0F, 0.0F, 0.0F); this.sgoku5.func_78787_b(128, 64); this.sgoku5.field_78809_i = true; setRotation(this.sgoku5, 0.0F, -0.1745329F, -0.5061455F); this.sgoku6 = new ModelRenderer((ModelBase)this, 32, 0); this.sgoku6.func_78789_a(7.0F, -2.0F, -1.5F, 3, 2, 2); this.sgoku6.func_78793_a(0.0F, 0.0F, 0.0F); this.sgoku6.func_78787_b(128, 64); this.sgoku6.field_78809_i = true; setRotation(this.sgoku6, 0.0F, -0.3490659F, -0.9250245F); this.sgoku7 = new ModelRenderer((ModelBase)this, 32, 0); this.sgoku7.func_78789_a(-0.5F, -12.0F, -6.0F, 3, 3, 3); this.sgoku7.func_78793_a(0.0F, 0.0F, 0.0F); this.sgoku7.func_78787_b(128, 64); this.sgoku7.field_78809_i = true; setRotation(this.sgoku7, -0.4363323F, 0.0F, 0.0F); this.sgoku8 = new ModelRenderer((ModelBase)this, 32, 0); this.sgoku8.func_78789_a(0.0F, -14.0F, -7.0F, 2, 3, 2); this.sgoku8.func_78793_a(0.0F, 0.0F, 0.0F); this.sgoku8.func_78787_b(128, 64); this.sgoku8.field_78809_i = true; setRotation(this.sgoku8, -0.5934119F, 0.0F, 0.0F); this.sgoku9 = new ModelRenderer((ModelBase)this, 32, 0); this.sgoku9.func_78789_a(-10.0F, -2.166667F, -1.5F, 3, 2, 2); this.sgoku9.func_78793_a(0.0F, 0.0F, 0.0F); this.sgoku9.func_78787_b(128, 64); this.sgoku9.field_78809_i = true; setRotation(this.sgoku9, 0.0F, 0.3490659F, 0.8901179F); this.sgoku10 = new ModelRenderer((ModelBase)this, 32, 0); this.sgoku10.func_78789_a(-1.0F, -10.0F, -6.0F, 4, 6, 4); this.sgoku10.func_78793_a(0.0F, 0.0F, 0.0F); this.sgoku10.func_78787_b(128, 64); this.sgoku10.field_78809_i = true; setRotation(this.sgoku10, -0.4363323F, 0.0F, -0.4014257F); this.sgoku11 = new ModelRenderer((ModelBase)this, 32, 0); this.sgoku11.func_78789_a(-0.5F, -12.0F, -6.0F, 5, 4, 3); this.sgoku11.func_78793_a(0.0F, 0.0F, 0.0F); this.sgoku11.func_78787_b(128, 64); this.sgoku11.field_78809_i = true; setRotation(this.sgoku11, -0.5410521F, 0.0F, -0.3665191F); this.sgoku12 = new ModelRenderer((ModelBase)this, 32, 0); this.sgoku12.func_78789_a(-0.5F, -14.0F, -6.0F, 3, 3, 3); this.sgoku12.func_78793_a(0.0F, 0.0F, 0.0F); this.sgoku12.func_78787_b(128, 64); this.sgoku12.field_78809_i = true; setRotation(this.sgoku12, -0.6108652F, 0.0F, -0.2443461F); this.sgoku13 = new ModelRenderer((ModelBase)this, 32, 0); this.sgoku13.func_78789_a(0.0F, -15.4F, -7.0F, 2, 5, 2); this.sgoku13.func_78793_a(0.0F, 0.0F, 0.0F); this.sgoku13.func_78787_b(128, 64); this.sgoku13.field_78809_i = true; setRotation(this.sgoku13, -0.6981317F, 0.0F, -0.122173F); this.sgoku14 = new ModelRenderer((ModelBase)this, 32, 0); this.sgoku14.func_78789_a(-1.5F, -9.0F, -5.0F, 3, 5, 3); this.sgoku14.func_78793_a(0.0F, 0.0F, 0.0F); this.sgoku14.func_78787_b(128, 64); this.sgoku14.field_78809_i = true; setRotation(this.sgoku14, -0.3665191F, 0.0F, 0.4363323F); this.sgoku15 = new ModelRenderer((ModelBase)this, 32, 0); this.sgoku15.func_78789_a(-0.5F, -10.0F, -6.0F, 3, 3, 3); this.sgoku15.func_78793_a(0.0F, 0.0F, 0.0F); this.sgoku15.func_78787_b(128, 64); this.sgoku15.field_78809_i = true; setRotation(this.sgoku15, -0.5410521F, 0.0F, 0.2455096F); this.sgoku16 = new ModelRenderer((ModelBase)this, 32, 0); this.sgoku16.func_78789_a(-1.0F, -12.0F, -6.0F, 3, 3, 3); this.sgoku16.func_78793_a(0.0F, 0.0F, 0.0F); this.sgoku16.func_78787_b(128, 64); this.sgoku16.field_78809_i = true; setRotation(this.sgoku16, -0.5759587F, 0.0F, 0.1396263F); this.sgoku17 = new ModelRenderer((ModelBase)this, 32, 0); this.sgoku17.func_78789_a(-2.0F, -9.0F, -1.0F, 4, 5, 4); this.sgoku17.func_78793_a(0.0F, 0.0F, 0.0F); this.sgoku17.func_78787_b(128, 64); this.sgoku17.field_78809_i = true; setRotation(this.sgoku17, -0.2792527F, 0.0F, 0.0F); this.sgoku18 = new ModelRenderer((ModelBase)this, 32, 0); this.sgoku18.func_78789_a(-1.0F, -10.0F, -1.0F, 4, 5, 4); this.sgoku18.func_78793_a(0.0F, 0.0F, 0.0F); this.sgoku18.func_78787_b(128, 64); this.sgoku18.field_78809_i = true; setRotation(this.sgoku18, -0.2443461F, 0.2617994F, 0.0174533F); this.sgoku19 = new ModelRenderer((ModelBase)this, 32, 0); this.sgoku19.func_78789_a(-4.0F, -11.0F, -1.0F, 4, 6, 4); this.sgoku19.func_78793_a(0.0F, 0.0F, 0.0F); this.sgoku19.func_78787_b(128, 64); this.sgoku19.field_78809_i = true; setRotation(this.sgoku19, -0.2443461F, -0.2617994F, 0.0174533F); this.sgoku20 = new ModelRenderer((ModelBase)this, 32, 0); this.sgoku20.func_78789_a(-2.0F, -13.0F, -1.0F, 3, 5, 4); this.sgoku20.func_78793_a(0.0F, 0.0F, 0.0F); this.sgoku20.func_78787_b(128, 64); this.sgoku20.field_78809_i = true; setRotation(this.sgoku20, -0.1396263F, 0.0F, 0.0F); this.sgoku21 = new ModelRenderer((ModelBase)this, 32, 0); this.sgoku21.func_78789_a(-1.0F, -14.0F, 0.0F, 3, 5, 3); this.sgoku21.func_78793_a(0.0F, 0.0F, 0.0F); this.sgoku21.func_78787_b(128, 64); this.sgoku21.field_78809_i = true; setRotation(this.sgoku21, -0.122173F, 0.1745329F, 0.0F); this.sgoku22 = new ModelRenderer((ModelBase)this, 32, 0); this.sgoku22.func_78789_a(-2.866667F, -13.2F, -0.6666667F, 3, 4, 3); this.sgoku22.func_78793_a(0.0F, 0.0F, 0.0F); this.sgoku22.func_78787_b(128, 64); this.sgoku22.field_78809_i = true; setRotation(this.sgoku22, -0.2443461F, -0.2617994F, 0.0174533F); this.sgoku23 = new ModelRenderer((ModelBase)this, 32, 0); this.sgoku23.func_78789_a(2.466667F, -6.5F, -5.333333F, 2, 3, 3); this.sgoku23.func_78793_a(0.0F, 0.0F, 0.0F); this.sgoku23.func_78787_b(128, 64); this.sgoku23.field_78809_i = true; setRotation(this.sgoku23, 0.0F, 0.0F, -0.4014257F); this.sgoku24 = new ModelRenderer((ModelBase)this, 32, 0); this.sgoku24.func_78789_a(-3.7F, -6.7F, -5.533333F, 2, 3, 3); this.sgoku24.func_78793_a(0.0F, 0.0F, 0.0F); this.sgoku24.func_78787_b(128, 64); this.sgoku24.field_78809_i = true; setRotation(this.sgoku24, 0.0F, 0.0F, 0.3665191F); this.sgoku25 = new ModelRenderer((ModelBase)this, 32, 0); this.sgoku25.func_78789_a(-7.0F, -4.5F, -5.0F, 2, 3, 3); this.sgoku25.func_78793_a(0.0F, 0.0F, 0.0F); this.sgoku25.func_78787_b(128, 64); this.sgoku25.field_78809_i = true; setRotation(this.sgoku25, 0.0F, 0.0F, 0.6806784F); this.sgoku26 = new ModelRenderer((ModelBase)this, 32, 0); this.sgoku26.func_78789_a(5.3F, -4.5F, -5.266667F, 2, 3, 3); this.sgoku26.func_78793_a(0.0F, 0.0F, 0.0F); this.sgoku26.func_78787_b(128, 64); this.sgoku26.field_78809_i = true; setRotation(this.sgoku26, 0.0F, 0.0F, -0.5934119F); this.ssgoku1 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgoku1.func_78789_a(-1.0F, -10.0F, -6.0F, 4, 4, 4); this.ssgoku1.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgoku1, -0.3141593F, 0.0F, 0.0F); this.ssgoku2 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgoku2.func_78789_a(-8.8F, -4.5F, -1.0F, 4, 3, 3); this.ssgoku2.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgoku2, 0.0F, 0.1745329F, 0.6108652F); this.ssgoku3 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgoku3.func_78789_a(-7.3F, -2.0F, 0.0F, 4, 2, 2); this.ssgoku3.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgoku3, 0.0F, 0.2617994F, 0.5410521F); this.ssgoku4 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgoku4.func_78789_a(4.8F, -4.0F, -1.0F, 4, 3, 3); this.ssgoku4.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgoku4, 0.0F, -0.1745329F, -0.6806784F); this.ssgoku5 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgoku5.func_78789_a(3.8F, -2.0F, 0.7F, 4, 2, 2); this.ssgoku5.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgoku5, 0.0F, -0.1745329F, -0.6108652F); this.ssgoku6 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgoku6.func_78789_a(7.8F, -2.0F, -1.5F, 3, 2, 2); this.ssgoku6.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgoku6, 0.0F, -0.3490659F, -0.9599311F); this.ssgoku7 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgoku7.func_78789_a(-0.5F, -12.0F, -6.0F, 3, 3, 3); this.ssgoku7.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgoku7, -0.4014257F, 0.0F, 0.0F); this.ssgoku8 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgoku8.func_78789_a(0.0F, -14.0F, -7.0F, 2, 3, 2); this.ssgoku8.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgoku8, -0.5410521F, 0.0F, 0.0F); this.ssgoku9 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgoku9.func_78789_a(-10.8F, -2.166667F, -1.5F, 3, 2, 2); this.ssgoku9.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgoku9, 0.0F, 0.3490659F, 0.9250245F); this.ssgoku10 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgoku10.func_78789_a(-1.0F, -10.3F, -6.0F, 4, 6, 4); this.ssgoku10.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgoku10, -0.4363323F, 0.0F, -0.3665191F); this.ssgoku11 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgoku11.func_78789_a(-0.5F, -12.3F, -6.0F, 5, 4, 3); this.ssgoku11.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgoku11, -0.5410521F, 0.0F, -0.3316126F); this.ssgoku12 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgoku12.func_78789_a(-0.5F, -14.5F, -6.0F, 3, 3, 3); this.ssgoku12.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgoku12, -0.5934119F, 0.0F, -0.2268928F); this.ssgoku13 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgoku13.func_78789_a(0.0F, -15.4F, -7.0F, 2, 5, 2); this.ssgoku13.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgoku13, -0.6806784F, 0.0F, -0.0698132F); this.ssgoku14 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgoku14.func_78789_a(-1.3F, -9.3F, -5.0F, 3, 5, 3); this.ssgoku14.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgoku14, -0.3665191F, 0.0F, 0.4014257F); this.ssgoku15 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgoku15.func_78789_a(-0.5F, -10.8F, -6.0F, 3, 3, 3); this.ssgoku15.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgoku15, -0.5410521F, 0.0F, 0.2617994F); this.ssgoku16 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgoku16.func_78789_a(-1.0F, -12.8F, -6.0F, 3, 3, 3); this.ssgoku16.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgoku16, -0.5759587F, 0.0F, 0.1745329F); this.ssgoku17 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgoku17.func_78789_a(-2.0F, -9.0F, -1.0F, 4, 5, 4); this.ssgoku17.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgoku17, -0.2792527F, 0.0F, 0.0F); this.ssgoku18 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgoku18.func_78789_a(-1.0F, -10.0F, -1.0F, 4, 5, 4); this.ssgoku18.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgoku18, -0.2443461F, 0.2617994F, 0.0174533F); this.ssgoku19 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgoku19.func_78789_a(-4.0F, -11.0F, -1.0F, 4, 6, 4); this.ssgoku19.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgoku19, -0.2443461F, -0.2617994F, 0.0174533F); this.ssgoku20 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgoku20.func_78789_a(-2.0F, -13.0F, -1.0F, 3, 5, 4); this.ssgoku20.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgoku20, -0.1396263F, 0.0F, 0.0F); this.ssgoku21 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgoku21.func_78789_a(-0.6F, -14.5F, 0.0F, 3, 5, 3); this.ssgoku21.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgoku21, -0.122173F, 0.1745329F, 0.0F); this.ssgoku22 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgoku22.func_78789_a(-2.866667F, -13.2F, -0.6666667F, 3, 4, 3); this.ssgoku22.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgoku22, -0.2443461F, -0.2617994F, 0.0174533F); this.ssgoku23 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgoku23.func_78789_a(-0.5333334F, -9.0F, -6.333333F, 2, 3, 3); this.ssgoku23.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgoku23, -0.1745329F, 0.0F, 0.1919862F); this.ssgoku24 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgoku24.func_78789_a(-3.7F, -6.7F, -5.533333F, 2, 3, 3); this.ssgoku24.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgoku24, 0.0F, 0.0F, 0.3665191F); this.ssgoku25 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgoku25.func_78789_a(-8.2F, -4.1F, -5.0F, 2, 3, 3); this.ssgoku25.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgoku25, 0.0F, 0.0F, 0.6806784F); this.ssgoku26 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgoku26.func_78789_a(5.433333F, -4.5F, -5.266667F, 2, 3, 3); this.ssgoku26.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgoku26, 0.0F, 0.0F, -0.5934119F); this.trunk1 = new ModelRenderer((ModelBase)this, 32, 0); this.trunk1.func_78789_a(4.7F, -6.4F, -4.2F, 4, 6, 3); this.trunk1.func_78793_a(0.0F, 0.0F, 0.0F); this.trunk1.func_78787_b(128, 64); this.trunk1.field_78809_i = true; setRotation(this.trunk1, 0.1745329F, 0.0F, -0.8028515F); this.trunk2 = new ModelRenderer((ModelBase)this, 32, 0); this.trunk2.func_78789_a(-8.733334F, -6.4F, -4.0F, 4, 6, 3); this.trunk2.func_78793_a(0.0F, 0.0F, 0.0F); this.trunk2.func_78787_b(128, 64); this.trunk2.field_78809_i = true; setRotation(this.trunk2, 0.1745329F, 0.0F, 0.8028515F); this.trunk3 = new ModelRenderer((ModelBase)this, 32, 0); this.trunk3.func_78789_a(3.0F, -8.0F, -1.2F, 4, 6, 3); this.trunk3.func_78793_a(0.0F, 0.0F, 0.0F); this.trunk3.func_78787_b(128, 64); this.trunk3.field_78809_i = true; setRotation(this.trunk3, 0.1745329F, -0.0872665F, -0.4014257F); this.trunk4 = new ModelRenderer((ModelBase)this, 32, 0); this.trunk4.func_78789_a(3.0F, -7.6F, 1.6F, 4, 6, 3); this.trunk4.func_78793_a(0.0F, 0.0F, 0.0F); this.trunk4.func_78787_b(128, 64); this.trunk4.field_78809_i = true; setRotation(this.trunk4, 0.1745329F, -0.0174533F, -0.4014257F); this.trunk5 = new ModelRenderer((ModelBase)this, 32, 0); this.trunk5.func_78789_a(-7.0F, -7.6F, 1.8F, 4, 6, 3); this.trunk5.func_78793_a(0.0F, 0.0F, 0.0F); this.trunk5.func_78787_b(128, 64); this.trunk5.field_78809_i = true; setRotation(this.trunk5, 0.1745329F, -0.0174533F, 0.4014257F); this.trunk6 = new ModelRenderer((ModelBase)this, 32, 0); this.trunk6.func_78789_a(-7.0F, -8.0F, -1.2F, 4, 6, 3); this.trunk6.func_78793_a(0.0F, 0.0F, 0.0F); this.trunk6.func_78787_b(128, 64); this.trunk6.field_78809_i = true; setRotation(this.trunk6, 0.1745329F, 0.0872665F, 0.4014257F); this.trunk7 = new ModelRenderer((ModelBase)this, 32, 0); this.trunk7.func_78789_a(4.4F, -7.0F, 0.6F, 4, 5, 3); this.trunk7.func_78793_a(0.0F, 0.0F, 0.0F); this.trunk7.func_78787_b(128, 64); this.trunk7.field_78809_i = true; setRotation(this.trunk7, 0.0F, -0.6457718F, -0.3665191F); this.trunk8 = new ModelRenderer((ModelBase)this, 32, 0); this.trunk8.func_78789_a(-8.4F, -7.0F, 0.6F, 4, 5, 3); this.trunk8.func_78793_a(0.0F, 0.0F, 0.0F); this.trunk8.func_78787_b(128, 64); this.trunk8.field_78809_i = true; setRotation(this.trunk8, 0.0F, 0.6457718F, 0.3665191F); this.trunk9 = new ModelRenderer((ModelBase)this, 32, 0); this.trunk9.func_78789_a(-2.5F, -7.0F, 4.0F, 5, 4, 3); this.trunk9.func_78793_a(0.0F, 0.0F, 0.0F); this.trunk9.func_78787_b(128, 64); this.trunk9.field_78809_i = true; setRotation(this.trunk9, 0.08F, 0.0F, 0.0F); this.strunk1 = new ModelRenderer((ModelBase)this, 32, 0); this.strunk1.func_78789_a(-2.0F, -9.0F, -4.933333F, 6, 3, 4); this.strunk1.func_78793_a(0.0F, 0.0F, 0.0F); this.strunk1.func_78787_b(128, 64); this.strunk1.field_78809_i = true; setRotation(this.strunk1, -0.0872665F, 0.0F, 0.2443461F); this.strunk2 = new ModelRenderer((ModelBase)this, 32, 0); this.strunk2.func_78789_a(-4.0F, -9.0F, -5.0F, 6, 3, 4); this.strunk2.func_78793_a(0.0F, 0.0F, 0.0F); this.strunk2.func_78787_b(128, 64); this.strunk2.field_78809_i = true; setRotation(this.strunk2, -0.0872665F, 0.0F, -0.2443461F); this.strunk3 = new ModelRenderer((ModelBase)this, 32, 0); this.strunk3.func_78789_a(-7.0F, -9.0F, -2.0F, 6, 3, 3); this.strunk3.func_78793_a(0.0F, 0.0F, 0.0F); this.strunk3.func_78787_b(128, 64); this.strunk3.field_78809_i = true; setRotation(this.strunk3, -0.0872665F, 0.0F, 0.1745329F); this.strunk4 = new ModelRenderer((ModelBase)this, 32, 0); this.strunk4.func_78789_a(1.0F, -9.0F, -2.0F, 6, 3, 3); this.strunk4.func_78793_a(0.0F, 0.0F, 0.0F); this.strunk4.func_78787_b(128, 64); this.strunk4.field_78809_i = true; setRotation(this.strunk4, -0.0872665F, 0.0F, -0.1745329F); this.strunk5 = new ModelRenderer((ModelBase)this, 32, 0); this.strunk5.func_78789_a(3.0F, -9.0F, 1.0F, 6, 3, 3); this.strunk5.func_78793_a(0.0F, 0.0F, 0.0F); this.strunk5.func_78787_b(128, 64); this.strunk5.field_78809_i = true; setRotation(this.strunk5, -0.0872665F, 0.0F, -0.3490659F); this.strunk6 = new ModelRenderer((ModelBase)this, 32, 0); this.strunk6.func_78789_a(-9.0F, -9.0F, 1.0F, 6, 3, 3); this.strunk6.func_78793_a(0.0F, 0.0F, 0.0F); this.strunk6.func_78787_b(128, 64); this.strunk6.field_78809_i = true; setRotation(this.strunk6, -0.0872665F, 0.0F, 0.3490659F); this.strunk7 = new ModelRenderer((ModelBase)this, 32, 0); this.strunk7.func_78789_a(-1.0F, -11.46667F, -2.0F, 3, 6, 3); this.strunk7.func_78793_a(0.0F, 0.0F, 0.0F); this.strunk7.func_78787_b(128, 64); this.strunk7.field_78809_i = true; setRotation(this.strunk7, -0.1745329F, 0.0F, -0.5235988F); this.strunk8 = new ModelRenderer((ModelBase)this, 32, 0); this.strunk8.func_78789_a(-2.0F, -11.46667F, -2.0F, 3, 6, 3); this.strunk8.func_78793_a(0.0F, 0.0F, 0.0F); this.strunk8.func_78787_b(128, 64); this.strunk8.field_78809_i = true; setRotation(this.strunk8, -0.1745329F, 0.0F, 0.5235988F); this.strunk9 = new ModelRenderer((ModelBase)this, 32, 0); this.strunk9.func_78789_a(-1.0F, -13.46667F, 0.0F, 3, 8, 3); this.strunk9.func_78793_a(0.0F, 0.0F, 0.0F); this.strunk9.func_78787_b(128, 64); this.strunk9.field_78809_i = true; setRotation(this.strunk9, -0.1745329F, 0.0F, 0.3490659F); this.strunk10 = new ModelRenderer((ModelBase)this, 32, 0); this.strunk10.func_78789_a(-2.0F, -13.46667F, 0.0F, 3, 8, 3); this.strunk10.func_78793_a(0.0F, 0.0F, 0.0F); this.strunk10.func_78787_b(128, 64); this.strunk10.field_78809_i = true; setRotation(this.strunk10, -0.1745329F, 0.0F, -0.3490659F); this.strunk11 = new ModelRenderer((ModelBase)this, 32, 0); this.strunk11.func_78789_a(-3.0F, -4.0F, 5.2F, 4, 3, 3); this.strunk11.func_78793_a(0.0F, 0.0F, 0.0F); this.strunk11.func_78787_b(128, 64); this.strunk11.field_78809_i = true; setRotation(this.strunk11, 0.5934119F, -0.6108652F, 0.0F); this.strunk12 = new ModelRenderer((ModelBase)this, 32, 0); this.strunk12.func_78789_a(-7.0F, -7.0F, -0.9333333F, 3, 3, 4); this.strunk12.func_78793_a(0.0F, 0.0F, 0.0F); this.strunk12.func_78787_b(128, 64); this.strunk12.field_78809_i = true; setRotation(this.strunk12, -0.0872665F, 0.0F, 0.2094395F); this.strunk13 = new ModelRenderer((ModelBase)this, 32, 0); this.strunk13.func_78789_a(4.133333F, -7.0F, -1.0F, 3, 3, 4); this.strunk13.func_78793_a(0.0F, 0.0F, 0.0F); this.strunk13.func_78787_b(128, 64); this.strunk13.field_78809_i = true; setRotation(this.strunk13, -0.0872665F, 0.0F, -0.2443461F); this.strunk14 = new ModelRenderer((ModelBase)this, 32, 0); this.strunk14.func_78789_a(-1.133333F, -4.0F, 5.2F, 4, 3, 3); this.strunk14.func_78793_a(0.0F, 0.0F, 0.0F); this.strunk14.func_78787_b(128, 64); this.strunk14.field_78809_i = true; setRotation(this.strunk14, 0.5934119F, 0.6108652F, 0.0F); this.strunk15 = new ModelRenderer((ModelBase)this, 32, 0); this.strunk15.func_78789_a(-3.133333F, -4.466667F, 4.933333F, 6, 3, 3); this.strunk15.func_78793_a(0.0F, 0.0F, 0.0F); this.strunk15.func_78787_b(128, 64); this.strunk15.field_78809_i = true; setRotation(this.strunk15, 0.5934119F, 0.0F, 0.0F); this.strunk16 = new ModelRenderer((ModelBase)this, 32, 0); this.strunk16.func_78789_a(-1.6F, -11.86667F, 1.0F, 2, 4, 2); this.strunk16.func_78793_a(0.0F, 0.0F, 0.0F); this.strunk16.func_78787_b(128, 64); this.strunk16.field_78809_i = true; setRotation(this.strunk16, -0.2792527F, 0.0F, 0.5235988F); this.strunk17 = new ModelRenderer((ModelBase)this, 32, 0); this.strunk17.func_78789_a(-0.4666667F, -11.86667F, 1.0F, 2, 4, 2); this.strunk17.func_78793_a(0.0F, 0.0F, 0.0F); this.strunk17.func_78787_b(128, 64); this.strunk17.field_78809_i = true; setRotation(this.strunk17, -0.2617994F, 0.0F, -0.5235988F); this.sstrunk1 = new ModelRenderer((ModelBase)this, 32, 0); this.sstrunk1.func_78789_a(-2.0F, -9.0F, -4.933333F, 6, 3, 4); this.sstrunk1.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.sstrunk1, -0.1047198F, 0.0F, 0.2268928F); this.sstrunk2 = new ModelRenderer((ModelBase)this, 32, 0); this.sstrunk2.func_78789_a(-4.0F, -9.0F, -5.0F, 6, 3, 4); this.sstrunk2.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.sstrunk2, -0.1047198F, 0.0F, -0.2268928F); this.sstrunk3 = new ModelRenderer((ModelBase)this, 32, 0); this.sstrunk3.func_78789_a(-11.0F, -7.0F, -2.0F, 6, 3, 3); this.sstrunk3.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.sstrunk3, -0.0872665F, 0.0F, 0.6981317F); this.sstrunk4 = new ModelRenderer((ModelBase)this, 32, 0); this.sstrunk4.func_78789_a(5.0F, -7.0F, -2.0F, 6, 3, 3); this.sstrunk4.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.sstrunk4, -0.0872665F, 0.0F, -0.6981317F); this.sstrunk5 = new ModelRenderer((ModelBase)this, 32, 0); this.sstrunk5.func_78789_a(6.0F, -2.3F, 1.0F, 6, 3, 3); this.sstrunk5.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.sstrunk5, -0.0872665F, 0.0F, -1.37881F); this.sstrunk6 = new ModelRenderer((ModelBase)this, 32, 0); this.sstrunk6.func_78789_a(-12.0F, -2.333333F, 1.0F, 6, 3, 3); this.sstrunk6.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.sstrunk6, -0.0872665F, 0.0F, 1.37881F); this.sstrunk7 = new ModelRenderer((ModelBase)this, 32, 0); this.sstrunk7.func_78789_a(-1.0F, -13.46667F, -2.0F, 3, 6, 3); this.sstrunk7.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.sstrunk7, -0.1745329F, 0.0F, -0.2268928F); this.sstrunk8 = new ModelRenderer((ModelBase)this, 32, 0); this.sstrunk8.func_78789_a(-2.0F, -13.46667F, -2.0F, 3, 6, 3); this.sstrunk8.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.sstrunk8, -0.1570796F, 0.0F, 0.2268928F); this.sstrunk9 = new ModelRenderer((ModelBase)this, 32, 0); this.sstrunk9.func_78789_a(-1.0F, -13.46667F, -1.0F, 3, 8, 3); this.sstrunk9.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.sstrunk9, -0.4363323F, 0.0F, 0.3490659F); this.sstrunk10 = new ModelRenderer((ModelBase)this, 32, 0); this.sstrunk10.func_78789_a(-2.0F, -13.46667F, -1.0F, 3, 8, 3); this.sstrunk10.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.sstrunk10, -0.4363323F, 0.0F, -0.3490659F); this.sstrunk11 = new ModelRenderer((ModelBase)this, 32, 0); this.sstrunk11.func_78789_a(-3.0F, -4.0F, 5.2F, 4, 3, 3); this.sstrunk11.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.sstrunk11, 0.5934119F, -0.6108652F, 0.0F); this.sstrunk12 = new ModelRenderer((ModelBase)this, 32, 0); this.sstrunk12.func_78789_a(-9.0F, -7.0F, -0.9333333F, 3, 3, 4); this.sstrunk12.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.sstrunk12, -0.0872665F, 0.0F, 0.3490659F); this.sstrunk13 = new ModelRenderer((ModelBase)this, 32, 0); this.sstrunk13.func_78789_a(6.0F, -7.0F, -1.0F, 3, 3, 4); this.sstrunk13.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.sstrunk13, -0.0872665F, 0.0F, -0.3490659F); this.sstrunk14 = new ModelRenderer((ModelBase)this, 32, 0); this.sstrunk14.func_78789_a(-1.133333F, -4.0F, 5.2F, 4, 3, 3); this.sstrunk14.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.sstrunk14, 0.5934119F, 0.6108652F, 0.0F); this.sstrunk15 = new ModelRenderer((ModelBase)this, 32, 0); this.sstrunk15.func_78789_a(-3.133333F, -4.466667F, 4.933333F, 6, 3, 3); this.sstrunk15.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.sstrunk15, 0.5934119F, 0.0F, 0.0F); this.sstrunk16 = new ModelRenderer((ModelBase)this, 32, 0); this.sstrunk16.func_78789_a(-2.0F, -11.86667F, 0.0F, 2, 4, 2); this.sstrunk16.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.sstrunk16, -0.5235988F, 0.0F, 0.2617994F); this.sstrunk17 = new ModelRenderer((ModelBase)this, 32, 0); this.sstrunk17.func_78789_a(0.0F, -11.86667F, 0.0F, 2, 4, 2); this.sstrunk17.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.sstrunk17, -0.5235988F, 0.0F, -0.2617994F); this.vegeta1 = new ModelRenderer((ModelBase)this, 32, 0); this.vegeta1.func_78789_a(-1.0F, -10.0F, -6.05F, 4, 4, 4); this.vegeta1.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.vegeta1, -0.3141593F, 0.0F, 0.0F); this.vegeta2 = new ModelRenderer((ModelBase)this, 32, 0); this.vegeta2.func_78789_a(-8.0F, -4.5F, -1.0F, 4, 3, 3); this.vegeta2.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.vegeta2, 0.0F, 0.1745329F, 0.5759587F); this.vegeta3 = new ModelRenderer((ModelBase)this, 32, 0); this.vegeta3.func_78789_a(-7.0F, -2.0F, 0.0F, 4, 2, 2); this.vegeta3.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.vegeta3, 0.0F, 0.2617994F, 0.5061455F); this.vegeta4 = new ModelRenderer((ModelBase)this, 32, 0); this.vegeta4.func_78789_a(4.0F, -4.0F, -1.0F, 4, 3, 3); this.vegeta4.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.vegeta4, 0.0F, -0.1745329F, -0.6108652F); this.vegeta5 = new ModelRenderer((ModelBase)this, 32, 0); this.vegeta5.func_78789_a(3.0F, -2.0F, 0.7F, 4, 2, 2); this.vegeta5.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.vegeta5, 0.0F, -0.1745329F, -0.5061455F); this.vegeta6 = new ModelRenderer((ModelBase)this, 32, 0); this.vegeta6.func_78789_a(7.0F, -2.0F, -1.5F, 3, 2, 2); this.vegeta6.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.vegeta6, 0.0F, -0.3490659F, -0.9250245F); this.vegeta7 = new ModelRenderer((ModelBase)this, 32, 0); this.vegeta7.func_78789_a(-0.5F, -12.0F, -6.0F, 3, 3, 3); this.vegeta7.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.vegeta7, -0.4363323F, 0.0F, 0.0F); this.vegeta8 = new ModelRenderer((ModelBase)this, 32, 0); this.vegeta8.func_78789_a(0.0F, -14.0F, -7.0F, 2, 3, 2); this.vegeta8.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.vegeta8, -0.5934119F, 0.0F, 0.0F); this.vegeta9 = new ModelRenderer((ModelBase)this, 32, 0); this.vegeta9.func_78789_a(-10.0F, -2.166667F, -1.5F, 3, 2, 2); this.vegeta9.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.vegeta9, 0.0F, 0.3490659F, 0.8901179F); this.vegeta10 = new ModelRenderer((ModelBase)this, 32, 0); this.vegeta10.func_78789_a(-1.0F, -10.0F, -6.2F, 4, 6, 4); this.vegeta10.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.vegeta10, -0.4363323F, 0.0F, -0.4014257F); this.vegeta11 = new ModelRenderer((ModelBase)this, 32, 0); this.vegeta11.func_78789_a(-0.5F, -12.0F, -6.0F, 5, 4, 3); this.vegeta11.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.vegeta11, -0.5410521F, 0.0F, -0.3665191F); this.vegeta12 = new ModelRenderer((ModelBase)this, 32, 0); this.vegeta12.func_78789_a(-0.5F, -14.0F, -6.0F, 3, 3, 3); this.vegeta12.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.vegeta12, -0.6108652F, 0.0F, -0.2443461F); this.vegeta13 = new ModelRenderer((ModelBase)this, 32, 0); this.vegeta13.func_78789_a(0.0F, -15.4F, -7.0F, 2, 5, 2); this.vegeta13.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.vegeta13, -0.6981317F, 0.0F, -0.122173F); this.vegeta14 = new ModelRenderer((ModelBase)this, 32, 0); this.vegeta14.func_78789_a(-1.5F, -9.0F, -5.5F, 3, 5, 3); this.vegeta14.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.vegeta14, -0.3665191F, 0.0F, 0.4363323F); this.vegeta15 = new ModelRenderer((ModelBase)this, 32, 0); this.vegeta15.func_78789_a(-0.5F, -10.0F, -6.0F, 3, 3, 3); this.vegeta15.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.vegeta15, -0.5410521F, 0.0F, 0.2455096F); this.vegeta16 = new ModelRenderer((ModelBase)this, 32, 0); this.vegeta16.func_78789_a(-1.0F, -12.0F, -6.0F, 3, 3, 3); this.vegeta16.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.vegeta16, -0.5759587F, 0.0F, 0.1396263F); this.vegeta17 = new ModelRenderer((ModelBase)this, 32, 0); this.vegeta17.func_78789_a(-2.0F, -9.0F, -1.0F, 4, 5, 4); this.vegeta17.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.vegeta17, -0.2792527F, 0.0F, 0.0F); this.vegeta18 = new ModelRenderer((ModelBase)this, 32, 0); this.vegeta18.func_78789_a(-1.0F, -10.0F, -1.0F, 4, 5, 4); this.vegeta18.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.vegeta18, -0.2443461F, 0.2617994F, 0.0174533F); this.vegeta19 = new ModelRenderer((ModelBase)this, 32, 0); this.vegeta19.func_78789_a(-4.0F, -11.0F, -1.0F, 4, 6, 4); this.vegeta19.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.vegeta19, -0.2443461F, -0.2617994F, 0.0174533F); this.vegeta20 = new ModelRenderer((ModelBase)this, 32, 0); this.vegeta20.func_78789_a(-2.0F, -13.0F, -1.0F, 3, 5, 4); this.vegeta20.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.vegeta20, -0.1396263F, 0.0F, 0.0F); this.vegeta21 = new ModelRenderer((ModelBase)this, 32, 0); this.vegeta21.func_78789_a(-1.0F, -14.0F, 0.0F, 3, 5, 3); this.vegeta21.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.vegeta21, -0.122173F, 0.1745329F, 0.0F); this.vegeta22 = new ModelRenderer((ModelBase)this, 32, 0); this.vegeta22.func_78789_a(-2.866667F, -13.2F, -0.6666667F, 3, 4, 3); this.vegeta22.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.vegeta22, -0.2443461F, -0.2617994F, 0.0174533F); this.svegeta1 = new ModelRenderer((ModelBase)this, 32, 0); this.svegeta1.func_78789_a(-1.0F, -10.0F, -6.05F, 4, 4, 4); this.svegeta1.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.svegeta1, -0.3141593F, 0.0F, 0.0F); this.svegeta2 = new ModelRenderer((ModelBase)this, 32, 0); this.svegeta2.func_78789_a(-8.0F, -4.5F, -1.0F, 4, 3, 3); this.svegeta2.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.svegeta2, 0.0F, 0.1745329F, 0.5759587F); this.svegeta3 = new ModelRenderer((ModelBase)this, 32, 0); this.svegeta3.func_78789_a(-7.0F, -2.0F, 0.0F, 4, 2, 2); this.svegeta3.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.svegeta3, 0.0F, 0.2617994F, 0.5061455F); this.svegeta4 = new ModelRenderer((ModelBase)this, 32, 0); this.svegeta4.func_78789_a(4.0F, -4.0F, -1.0F, 4, 3, 3); this.svegeta4.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.svegeta4, 0.0F, -0.1745329F, -0.6108652F); this.svegeta5 = new ModelRenderer((ModelBase)this, 32, 0); this.svegeta5.func_78789_a(3.0F, -2.0F, 0.7F, 4, 2, 2); this.svegeta5.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.svegeta5, 0.0F, -0.1745329F, -0.5061455F); this.svegeta6 = new ModelRenderer((ModelBase)this, 32, 0); this.svegeta6.func_78789_a(7.0F, -2.0F, -1.5F, 3, 2, 2); this.svegeta6.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.svegeta6, 0.0F, -0.3490659F, -0.9250245F); this.svegeta7 = new ModelRenderer((ModelBase)this, 32, 0); this.svegeta7.func_78789_a(-0.5F, -12.0F, -6.0F, 3, 3, 3); this.svegeta7.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.svegeta7, -0.4363323F, 0.0F, 0.0F); this.svegeta8 = new ModelRenderer((ModelBase)this, 32, 0); this.svegeta8.func_78789_a(0.0F, -14.0F, -7.0F, 2, 3, 2); this.svegeta8.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.svegeta8, -0.5934119F, 0.0F, 0.0F); this.svegeta9 = new ModelRenderer((ModelBase)this, 32, 0); this.svegeta9.func_78789_a(-10.0F, -2.166667F, -1.5F, 3, 2, 2); this.svegeta9.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.svegeta9, 0.0F, 0.3490659F, 0.8901179F); this.svegeta10 = new ModelRenderer((ModelBase)this, 32, 0); this.svegeta10.func_78789_a(-1.0F, -10.0F, -6.2F, 4, 6, 4); this.svegeta10.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.svegeta10, -0.4363323F, 0.0F, -0.4014257F); this.svegeta11 = new ModelRenderer((ModelBase)this, 32, 0); this.svegeta11.func_78789_a(-0.5F, -12.0F, -6.0F, 5, 4, 3); this.svegeta11.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.svegeta11, -0.5410521F, 0.0F, -0.3665191F); this.svegeta12 = new ModelRenderer((ModelBase)this, 32, 0); this.svegeta12.func_78789_a(-0.5F, -14.0F, -6.0F, 3, 3, 3); this.svegeta12.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.svegeta12, -0.6108652F, 0.0F, -0.2443461F); this.svegeta13 = new ModelRenderer((ModelBase)this, 32, 0); this.svegeta13.func_78789_a(0.0F, -15.4F, -7.0F, 2, 5, 2); this.svegeta13.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.svegeta13, -0.6981317F, 0.0F, -0.122173F); this.svegeta14 = new ModelRenderer((ModelBase)this, 32, 0); this.svegeta14.func_78789_a(-1.5F, -9.0F, -5.5F, 3, 5, 3); this.svegeta14.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.svegeta14, -0.3665191F, 0.0F, 0.4363323F); this.svegeta15 = new ModelRenderer((ModelBase)this, 32, 0); this.svegeta15.func_78789_a(-0.5F, -10.0F, -6.0F, 3, 3, 3); this.svegeta15.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.svegeta15, -0.5410521F, 0.0F, 0.2455096F); this.svegeta16 = new ModelRenderer((ModelBase)this, 32, 0); this.svegeta16.func_78789_a(-1.0F, -12.0F, -6.0F, 3, 3, 3); this.svegeta16.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.svegeta16, -0.5759587F, 0.0F, 0.1396263F); this.svegeta17 = new ModelRenderer((ModelBase)this, 32, 0); this.svegeta17.func_78789_a(-2.0F, -9.0F, -1.0F, 4, 5, 4); this.svegeta17.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.svegeta17, -0.2792527F, 0.0F, 0.0F); this.svegeta18 = new ModelRenderer((ModelBase)this, 32, 0); this.svegeta18.func_78789_a(-1.0F, -10.0F, -1.0F, 4, 5, 4); this.svegeta18.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.svegeta18, -0.2443461F, 0.2617994F, 0.0174533F); this.svegeta19 = new ModelRenderer((ModelBase)this, 32, 0); this.svegeta19.func_78789_a(-4.0F, -11.0F, -1.0F, 4, 6, 4); this.svegeta19.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.svegeta19, -0.2443461F, -0.2617994F, 0.0174533F); this.svegeta20 = new ModelRenderer((ModelBase)this, 32, 0); this.svegeta20.func_78789_a(-2.0F, -13.0F, -1.0F, 3, 5, 4); this.svegeta20.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.svegeta20, -0.1396263F, 0.0F, 0.0F); this.svegeta21 = new ModelRenderer((ModelBase)this, 32, 0); this.svegeta21.func_78789_a(-1.0F, -14.0F, 0.0F, 3, 5, 3); this.svegeta21.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.svegeta21, -0.122173F, 0.1745329F, 0.0F); this.svegeta22 = new ModelRenderer((ModelBase)this, 32, 0); this.svegeta22.func_78789_a(-2.866667F, -13.2F, -0.6666667F, 3, 4, 3); this.svegeta22.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.svegeta22, -0.2443461F, -0.2617994F, 0.0174533F); this.ssvegeta1 = new ModelRenderer((ModelBase)this, 32, 0); this.ssvegeta1.func_78789_a(-1.0F, -10.0F, -6.05F, 4, 4, 4); this.ssvegeta1.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssvegeta1, -0.3141593F, 0.0F, 0.0F); this.ssvegeta2 = new ModelRenderer((ModelBase)this, 32, 0); this.ssvegeta2.func_78789_a(-8.8F, -4.5F, -1.0F, 4, 3, 3); this.ssvegeta2.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssvegeta2, 0.0F, 0.1745329F, 0.6108652F); this.ssvegeta3 = new ModelRenderer((ModelBase)this, 32, 0); this.ssvegeta3.func_78789_a(-7.3F, -2.0F, 0.0F, 4, 2, 2); this.ssvegeta3.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssvegeta3, 0.0F, 0.2617994F, 0.5410521F); this.ssvegeta4 = new ModelRenderer((ModelBase)this, 32, 0); this.ssvegeta4.func_78789_a(4.8F, -4.0F, -1.0F, 4, 3, 3); this.ssvegeta4.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssvegeta4, 0.0F, -0.1745329F, -0.6806784F); this.ssvegeta5 = new ModelRenderer((ModelBase)this, 32, 0); this.ssvegeta5.func_78789_a(3.8F, -2.0F, 0.7F, 4, 2, 2); this.ssvegeta5.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssvegeta5, 0.0F, -0.1745329F, -0.6108652F); this.ssvegeta6 = new ModelRenderer((ModelBase)this, 32, 0); this.ssvegeta6.func_78789_a(7.8F, -2.0F, -1.5F, 3, 2, 2); this.ssvegeta6.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssvegeta6, 0.0F, -0.3490659F, -0.9599311F); this.ssvegeta7 = new ModelRenderer((ModelBase)this, 32, 0); this.ssvegeta7.func_78789_a(-0.5F, -12.0F, -6.0F, 3, 3, 3); this.ssvegeta7.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssvegeta7, -0.4014257F, 0.0F, 0.0F); this.ssvegeta8 = new ModelRenderer((ModelBase)this, 32, 0); this.ssvegeta8.func_78789_a(0.0F, -14.0F, -7.0F, 2, 3, 2); this.ssvegeta8.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssvegeta8, -0.5410521F, 0.0F, 0.0F); this.ssvegeta9 = new ModelRenderer((ModelBase)this, 32, 0); this.ssvegeta9.func_78789_a(-10.8F, -2.166667F, -1.5F, 3, 2, 2); this.ssvegeta9.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssvegeta9, 0.0F, 0.3490659F, 0.9250245F); this.ssvegeta10 = new ModelRenderer((ModelBase)this, 32, 0); this.ssvegeta10.func_78789_a(-1.0F, -10.3F, -6.3F, 4, 6, 4); this.ssvegeta10.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssvegeta10, -0.4363323F, 0.0F, -0.3665191F); this.ssvegeta11 = new ModelRenderer((ModelBase)this, 32, 0); this.ssvegeta11.func_78789_a(-0.5F, -12.3F, -6.0F, 5, 4, 3); this.ssvegeta11.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssvegeta11, -0.5410521F, 0.0F, -0.3316126F); this.ssvegeta12 = new ModelRenderer((ModelBase)this, 32, 0); this.ssvegeta12.func_78789_a(-0.5F, -14.5F, -6.0F, 3, 3, 3); this.ssvegeta12.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssvegeta12, -0.5934119F, 0.0F, -0.2268928F); this.ssvegeta13 = new ModelRenderer((ModelBase)this, 32, 0); this.ssvegeta13.func_78789_a(0.0F, -15.4F, -7.0F, 2, 5, 2); this.ssvegeta13.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssvegeta13, -0.6806784F, 0.0F, -0.0698132F); this.ssvegeta14 = new ModelRenderer((ModelBase)this, 32, 0); this.ssvegeta14.func_78789_a(-1.3F, -9.3F, -5.5F, 3, 5, 3); this.ssvegeta14.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssvegeta14, -0.3665191F, 0.0F, 0.4014257F); this.ssvegeta15 = new ModelRenderer((ModelBase)this, 32, 0); this.ssvegeta15.func_78789_a(-0.5F, -10.8F, -6.0F, 3, 3, 3); this.ssvegeta15.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssvegeta15, -0.5410521F, 0.0F, 0.2617994F); this.ssvegeta16 = new ModelRenderer((ModelBase)this, 32, 0); this.ssvegeta16.func_78789_a(-1.0F, -12.8F, -6.0F, 3, 3, 3); this.ssvegeta16.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssvegeta16, -0.5759587F, 0.0F, 0.1745329F); this.ssvegeta17 = new ModelRenderer((ModelBase)this, 32, 0); this.ssvegeta17.func_78789_a(-2.0F, -9.0F, -1.0F, 4, 5, 4); this.ssvegeta17.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssvegeta17, -0.2792527F, 0.0F, 0.0F); this.ssvegeta18 = new ModelRenderer((ModelBase)this, 32, 0); this.ssvegeta18.func_78789_a(-1.0F, -10.0F, -1.0F, 4, 5, 4); this.ssvegeta18.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssvegeta18, -0.2443461F, 0.2617994F, 0.0174533F); this.ssvegeta19 = new ModelRenderer((ModelBase)this, 32, 0); this.ssvegeta19.func_78789_a(-4.0F, -11.0F, -1.0F, 4, 6, 4); this.ssvegeta19.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssvegeta19, -0.2443461F, -0.2617994F, 0.0174533F); this.ssvegeta20 = new ModelRenderer((ModelBase)this, 32, 0); this.ssvegeta20.func_78789_a(-2.0F, -13.0F, -1.0F, 3, 5, 4); this.ssvegeta20.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssvegeta20, -0.1396263F, 0.0F, 0.0F); this.ssvegeta21 = new ModelRenderer((ModelBase)this, 32, 0); this.ssvegeta21.func_78789_a(-0.6F, -14.5F, 0.0F, 3, 5, 3); this.ssvegeta21.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssvegeta21, -0.122173F, 0.1745329F, 0.0F); this.ssvegeta22 = new ModelRenderer((ModelBase)this, 32, 0); this.ssvegeta22.func_78789_a(-2.866667F, -13.2F, -0.6666667F, 3, 4, 3); this.ssvegeta22.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssvegeta22, -0.2443461F, -0.2617994F, 0.0174533F); this.gohan1 = new ModelRenderer((ModelBase)this, 32, 0); this.gohan1.func_78789_a(-1.0F, -10.0F, -5.066667F, 4, 4, 4); this.gohan1.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.gohan1, -0.1745329F, 0.0F, 0.0F); this.gohan7 = new ModelRenderer((ModelBase)this, 32, 0); this.gohan7.func_78789_a(-0.5F, -11.0F, -6.0F, 3, 2, 3); this.gohan7.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.gohan7, -0.3665191F, 0.0F, 0.0F); this.gohan8 = new ModelRenderer((ModelBase)this, 32, 0); this.gohan8.func_78789_a(0.0F, -11.0F, -7.0F, 2, 2, 2); this.gohan8.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.gohan8, -0.5585054F, 0.0F, 0.0F); this.gohan10 = new ModelRenderer((ModelBase)this, 32, 0); this.gohan10.func_78789_a(-1.533333F, -10.3F, -5.466667F, 4, 5, 4); this.gohan10.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.gohan10, -0.2617994F, 0.0F, -0.3665191F); this.gohan11 = new ModelRenderer((ModelBase)this, 32, 0); this.gohan11.func_78789_a(-0.5F, -11.3F, -6.0F, 5, 4, 4); this.gohan11.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.gohan11, -0.418879F, 0.0F, -0.3316126F); this.gohan12 = new ModelRenderer((ModelBase)this, 32, 0); this.gohan12.func_78789_a(-0.5F, -12.5F, -6.0F, 3, 3, 3); this.gohan12.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.gohan12, -0.5235988F, 0.0F, -0.2268928F); this.gohan13 = new ModelRenderer((ModelBase)this, 32, 0); this.gohan13.func_78789_a(0.0F, -12.66667F, -7.0F, 2, 4, 2); this.gohan13.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.gohan13, -0.6283185F, 0.0F, -0.0698132F); this.gohan14 = new ModelRenderer((ModelBase)this, 32, 0); this.gohan14.func_78789_a(-1.3F, -9.3F, -5.0F, 3, 5, 3); this.gohan14.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.gohan14, -0.2268928F, 0.0F, 0.4014257F); this.gohan15 = new ModelRenderer((ModelBase)this, 32, 0); this.gohan15.func_78789_a(-0.8333333F, -10.8F, -6.0F, 3, 4, 4); this.gohan15.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.gohan15, -0.4537856F, 0.0F, 0.2617994F); this.gohan16 = new ModelRenderer((ModelBase)this, 32, 0); this.gohan16.func_78789_a(-1.0F, -12.46667F, -6.0F, 3, 4, 3); this.gohan16.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.gohan16, -0.5410521F, 0.0F, 0.1745329F); this.gohan17 = new ModelRenderer((ModelBase)this, 32, 0); this.gohan17.func_78789_a(-2.0F, -9.0F, -1.0F, 4, 5, 4); this.gohan17.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.gohan17, -0.2792527F, 0.0F, 0.0F); this.gohan18 = new ModelRenderer((ModelBase)this, 32, 0); this.gohan18.func_78789_a(-0.8F, -10.0F, -1.0F, 4, 5, 4); this.gohan18.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.gohan18, -0.2443461F, 0.2617994F, 0.0174533F); this.gohan19 = new ModelRenderer((ModelBase)this, 32, 0); this.gohan19.func_78789_a(-3.266667F, -10.0F, -1.0F, 4, 4, 4); this.gohan19.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.gohan19, -0.2443461F, -0.2617994F, 0.0174533F); this.gohan20 = new ModelRenderer((ModelBase)this, 32, 0); this.gohan20.func_78789_a(-2.0F, -12.0F, -1.0F, 3, 4, 4); this.gohan20.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.gohan20, -0.1396263F, 0.0F, 0.0F); this.gohan21 = new ModelRenderer((ModelBase)this, 32, 0); this.gohan21.func_78789_a(-0.6F, -11.5F, 0.0F, 3, 2, 3); this.gohan21.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.gohan21, -0.122173F, 0.1745329F, 0.0F); this.gohan22 = new ModelRenderer((ModelBase)this, 32, 0); this.gohan22.func_78789_a(-2.866667F, -11.53333F, -0.6666667F, 3, 4, 3); this.gohan22.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.gohan22, -0.2443461F, -0.2617994F, 0.0174533F); this.gohan26 = new ModelRenderer((ModelBase)this, 32, 0); this.gohan26.func_78789_a(4.433333F, -6.5F, -5.266667F, 2, 3, 3); this.gohan26.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.gohan26, 0.0F, 0.0F, -0.5934119F); this.sgohan1 = new ModelRenderer((ModelBase)this, 32, 0); this.sgohan1.func_78789_a(-1.0F, -10.0F, -5.066667F, 4, 4, 4); this.sgohan1.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.sgohan1, -0.1745329F, 0.0F, 0.0F); this.sgohan7 = new ModelRenderer((ModelBase)this, 32, 0); this.sgohan7.func_78789_a(-0.5F, -11.0F, -6.0F, 3, 2, 3); this.sgohan7.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.sgohan7, -0.3665191F, 0.0F, 0.0F); this.sgohan8 = new ModelRenderer((ModelBase)this, 32, 0); this.sgohan8.func_78789_a(0.0F, -11.0F, -7.0F, 2, 2, 2); this.sgohan8.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.sgohan8, -0.5585054F, 0.0F, 0.0F); this.sgohan10 = new ModelRenderer((ModelBase)this, 32, 0); this.sgohan10.func_78789_a(-1.533333F, -10.3F, -5.466667F, 4, 5, 4); this.sgohan10.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.sgohan10, -0.2617994F, 0.0F, -0.3665191F); this.sgohan11 = new ModelRenderer((ModelBase)this, 32, 0); this.sgohan11.func_78789_a(-0.5F, -11.3F, -6.0F, 5, 4, 4); this.sgohan11.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.sgohan11, -0.418879F, 0.0F, -0.3316126F); this.sgohan12 = new ModelRenderer((ModelBase)this, 32, 0); this.sgohan12.func_78789_a(-0.5F, -12.5F, -6.0F, 3, 3, 3); this.sgohan12.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.sgohan12, -0.5235988F, 0.0F, -0.2268928F); this.sgohan13 = new ModelRenderer((ModelBase)this, 32, 0); this.sgohan13.func_78789_a(0.0F, -12.66667F, -7.0F, 2, 4, 2); this.sgohan13.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.sgohan13, -0.6283185F, 0.0F, -0.0698132F); this.sgohan14 = new ModelRenderer((ModelBase)this, 32, 0); this.sgohan14.func_78789_a(-1.3F, -9.3F, -5.0F, 3, 5, 3); this.sgohan14.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.sgohan14, -0.2268928F, 0.0F, 0.4014257F); this.sgohan15 = new ModelRenderer((ModelBase)this, 32, 0); this.sgohan15.func_78789_a(-0.8333333F, -10.8F, -6.0F, 3, 4, 4); this.sgohan15.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.sgohan15, -0.4537856F, 0.0F, 0.2617994F); this.sgohan16 = new ModelRenderer((ModelBase)this, 32, 0); this.sgohan16.func_78789_a(-1.0F, -12.46667F, -6.0F, 3, 4, 3); this.sgohan16.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.sgohan16, -0.5410521F, 0.0F, 0.1745329F); this.sgohan17 = new ModelRenderer((ModelBase)this, 32, 0); this.sgohan17.func_78789_a(-2.0F, -9.0F, -1.0F, 4, 5, 4); this.sgohan17.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.sgohan17, -0.2792527F, 0.0F, 0.0F); this.sgohan18 = new ModelRenderer((ModelBase)this, 32, 0); this.sgohan18.func_78789_a(-0.8F, -10.0F, -1.0F, 4, 5, 4); this.sgohan18.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.sgohan18, -0.2443461F, 0.2617994F, 0.0174533F); this.sgohan19 = new ModelRenderer((ModelBase)this, 32, 0); this.sgohan19.func_78789_a(-3.266667F, -10.0F, -1.0F, 4, 4, 4); this.sgohan19.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.sgohan19, -0.2443461F, -0.2617994F, 0.0174533F); this.sgohan20 = new ModelRenderer((ModelBase)this, 32, 0); this.sgohan20.func_78789_a(-2.0F, -12.0F, -1.0F, 3, 4, 4); this.sgohan20.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.sgohan20, -0.1396263F, 0.0F, 0.0F); this.sgohan21 = new ModelRenderer((ModelBase)this, 32, 0); this.sgohan21.func_78789_a(-0.6F, -11.5F, 0.0F, 3, 2, 3); this.sgohan21.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.sgohan21, -0.122173F, 0.1745329F, 0.0F); this.sgohan22 = new ModelRenderer((ModelBase)this, 32, 0); this.sgohan22.func_78789_a(-2.866667F, -11.53333F, -0.6666667F, 3, 4, 3); this.sgohan22.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.sgohan22, -0.2443461F, -0.2617994F, 0.0174533F); this.sgohan26 = new ModelRenderer((ModelBase)this, 32, 0); this.sgohan26.func_78789_a(4.433333F, -6.5F, -5.266667F, 2, 3, 3); this.sgohan26.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.sgohan26, 0.0F, 0.0F, -0.5934119F); this.ssgohan1 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgohan1.func_78789_a(-1.0F, -10.5F, -5.066667F, 4, 4, 4); this.ssgohan1.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgohan1, -0.1745329F, 0.0F, 0.0F); this.ssgohan7 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgohan7.func_78789_a(-0.5F, -11.5F, -6.0F, 3, 3, 3); this.ssgohan7.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgohan7, -0.3665191F, 0.0F, 0.0F); this.ssgohan8 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgohan8.func_78789_a(0.0F, -12.0F, -7.0F, 2, 3, 2); this.ssgohan8.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgohan8, -0.5585054F, 0.0F, 0.0F); this.ssgohan10 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgohan10.func_78789_a(-1.533333F, -10.8F, -5.466667F, 4, 5, 4); this.ssgohan10.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgohan10, -0.2617994F, 0.0F, -0.3665191F); this.ssgohan11 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgohan11.func_78789_a(-0.5F, -11.8F, -6.0F, 5, 4, 4); this.ssgohan11.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgohan11, -0.418879F, 0.0F, -0.3316126F); this.ssgohan12 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgohan12.func_78789_a(-0.5F, -13.0F, -6.0F, 3, 3, 3); this.ssgohan12.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgohan12, -0.5235988F, 0.0F, -0.2268928F); this.ssgohan13 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgohan13.func_78789_a(0.0F, -13.2F, -7.0F, 2, 4, 2); this.ssgohan13.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgohan13, -0.6283185F, 0.0F, -0.0698132F); this.ssgohan14 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgohan14.func_78789_a(-1.3F, -9.8F, -5.0F, 3, 5, 3); this.ssgohan14.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgohan14, -0.2268928F, 0.0F, 0.4014257F); this.ssgohan15 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgohan15.func_78789_a(-0.8333333F, -11.3F, -6.0F, 3, 4, 4); this.ssgohan15.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgohan15, -0.4537856F, 0.0F, 0.2617994F); this.ssgohan16 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgohan16.func_78789_a(-1.0F, -13.0F, -6.0F, 3, 4, 3); this.ssgohan16.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgohan16, -0.5410521F, 0.0F, 0.1745329F); this.ssgohan17 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgohan17.func_78789_a(-2.0F, -9.0F, -1.0F, 4, 5, 4); this.ssgohan17.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgohan17, -0.2792527F, 0.0F, 0.0F); this.ssgohan18 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgohan18.func_78789_a(-0.8F, -10.0F, -1.0F, 4, 5, 4); this.ssgohan18.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgohan18, -0.2443461F, 0.2617994F, 0.0174533F); this.ssgohan19 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgohan19.func_78789_a(-3.266667F, -10.0F, -1.0F, 4, 4, 4); this.ssgohan19.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgohan19, -0.2443461F, -0.2617994F, 0.0174533F); this.ssgohan20 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgohan20.func_78789_a(-2.0F, -12.5F, -1.0F, 3, 4, 4); this.ssgohan20.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgohan20, -0.1396263F, 0.0F, 0.0F); this.ssgohan21 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgohan21.func_78789_a(-0.6F, -12.0F, 0.0F, 3, 3, 3); this.ssgohan21.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgohan21, -0.122173F, 0.1745329F, 0.0F); this.ssgohan22 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgohan22.func_78789_a(-2.866667F, -11.53333F, -0.6666667F, 3, 4, 3); this.ssgohan22.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgohan22, -0.2443461F, -0.2617994F, 0.0174533F); this.ssgohan26 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgohan26.func_78789_a(4.0F, -6.5F, -5.266667F, 2, 4, 3); this.ssgohan26.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgohan26, 0.0F, 0.0F, -0.5235988F); this.gokuni1 = new ModelRenderer((ModelBase)this, 32, 0); this.gokuni1.func_78789_a(-1.0F, -11.0F, -2.0F, 4, 4, 4); this.gokuni1.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.gokuni1, 0.2268928F, 0.0F, -0.4363323F); this.gokuni2 = new ModelRenderer((ModelBase)this, 32, 0); this.gokuni2.func_78789_a(-8.0F, -5.1F, -1.0F, 4, 2, 2); this.gokuni2.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.gokuni2, 0.0F, -0.2617994F, 0.1745329F); this.gokuni3 = new ModelRenderer((ModelBase)this, 32, 0); this.gokuni3.func_78789_a(-6.0F, -4.6F, -1.0F, 4, 2, 2); this.gokuni3.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.gokuni3, 0.0F, 0.0F, -0.1396263F); this.gokuni4 = new ModelRenderer((ModelBase)this, 32, 0); this.gokuni4.func_78789_a(3.0F, -4.0F, 0.0F, 4, 3, 3); this.gokuni4.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.gokuni4, 0.0F, 0.0F, -0.3490659F); this.gokuni5 = new ModelRenderer((ModelBase)this, 32, 0); this.gokuni5.func_78789_a(3.0F, -3.8F, 0.7F, 3, 2, 2); this.gokuni5.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.gokuni5, 0.0F, 0.0349066F, 0.1815142F); this.gokuni6 = new ModelRenderer((ModelBase)this, 32, 0); this.gokuni6.func_78789_a(6.0F, -4.3F, 0.5F, 3, 2, 2); this.gokuni6.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.gokuni6, 0.0F, 0.0F, -0.2617994F); this.gokuni7 = new ModelRenderer((ModelBase)this, 32, 0); this.gokuni7.func_78789_a(1.0F, -12.0F, 1.266667F, 3, 3, 3); this.gokuni7.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.gokuni7, 0.5235988F, 0.0F, -0.6108652F); this.gokuni8 = new ModelRenderer((ModelBase)this, 32, 0); this.gokuni8.func_78789_a(3.266667F, -13.0F, 4.0F, 2, 3, 2); this.gokuni8.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.gokuni8, 0.7853982F, 0.0F, -0.7853982F); this.gokuni9 = new ModelRenderer((ModelBase)this, 32, 0); this.gokuni9.func_78789_a(-8.733334F, -5.7F, 0.1F, 2, 1, 1); this.gokuni9.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.gokuni9, 0.0F, -0.3490659F, 0.0174533F); this.gokuni10 = new ModelRenderer((ModelBase)this, 32, 0); this.gokuni10.func_78789_a(-11.0F, -4.133333F, 0.0F, 5, 2, 2); this.gokuni10.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.gokuni10, 0.0F, -0.6981317F, 0.4921828F); this.gokuni11 = new ModelRenderer((ModelBase)this, 32, 0); this.gokuni11.func_78789_a(1.066667F, -9.866667F, 1.6F, 1, 3, 1); this.gokuni11.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.gokuni11, 0.1745329F, 0.0F, -0.1745329F); this.gokuni12 = new ModelRenderer((ModelBase)this, 32, 0); this.gokuni12.func_78789_a(5.0F, -4.333333F, 1.7F, 3, 1, 1); this.gokuni12.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.gokuni12, 0.0F, 0.1745329F, -0.4991642F); this.ght1 = new ModelRenderer((ModelBase)this, 32, 0); this.ght1.func_78789_a(-0.4666667F, -10.0F, -1.533333F, 3, 3, 3); this.ght1.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ght1, 0.2443461F, 0.0F, -0.4363323F); this.ght2 = new ModelRenderer((ModelBase)this, 32, 0); this.ght2.func_78789_a(-8.533334F, -6.8F, 0.6F, 5, 2, 2); this.ght2.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ght2, 0.0F, -0.8726646F, 0.2094395F); this.ght3 = new ModelRenderer((ModelBase)this, 32, 0); this.ght3.func_78789_a(-6.0F, -6.6F, 0.0F, 4, 2, 2); this.ght3.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ght3, 0.0F, -0.6867716F, -0.1745329F); this.ght4 = new ModelRenderer((ModelBase)this, 32, 0); this.ght4.func_78789_a(-0.01F, -6.0001F, 2.0F, 4, 5, 4); this.ght4.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ght4, 0.296706F, 0.0F, 0.0F); this.ght5 = new ModelRenderer((ModelBase)this, 32, 0); this.ght5.func_78789_a(4.6F, -7.666667F, 2.7F, 1, 2, 1); this.ght5.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ght5, 0.0F, 0.1745329F, -0.3490659F); this.ght6 = new ModelRenderer((ModelBase)this, 32, 0); this.ght6.func_78789_a(0.5333334F, -8.566667F, 2.1F, 2, 1, 1); this.ght6.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ght6, 0.0F, -0.0349066F, 0.3490659F); this.ght7 = new ModelRenderer((ModelBase)this, 32, 0); this.ght7.func_78789_a(1.2F, -11.0F, 0.1333333F, 2, 3, 2); this.ght7.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ght7, 0.418879F, 0.0F, -0.5934119F); this.ght8 = new ModelRenderer((ModelBase)this, 32, 0); this.ght8.func_78789_a(3.0F, -11.8F, 2.2F, 1, 3, 1); this.ght8.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ght8, 0.6108652F, 0.0F, -0.7679449F); this.ght9 = new ModelRenderer((ModelBase)this, 32, 0); this.ght9.func_78789_a(-8.066667F, -7.6F, 1.833333F, 3, 1, 1); this.ght9.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ght9, 0.0F, -1.047198F, 0.0F); this.ght11 = new ModelRenderer((ModelBase)this, 32, 0); this.ght11.func_78789_a(0.4F, -10.0F, 0.06666667F, 1, 4, 1); this.ght11.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ght11, 0.0523599F, 0.0F, -0.1745329F); this.ght14 = new ModelRenderer((ModelBase)this, 32, 0); this.ght14.func_78789_a(-3.99F, -6.0001F, 2.001F, 4, 5, 4); this.ght14.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ght14, 0.296706F, 0.0F, 0.0F); this.ght16 = new ModelRenderer((ModelBase)this, 32, 0); this.ght16.func_78789_a(7.0F, -5.1F, -0.3666667F, 2, 1, 1); this.ght16.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ght16, 0.0F, -0.7853982F, -0.4363323F); this.goten2 = new ModelRenderer((ModelBase)this, 32, 0); this.goten2.func_78789_a(-8.533334F, -6.8F, 0.6F, 5, 2, 2); this.goten2.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.goten2, 0.0F, -0.8726646F, 0.3141593F); this.goten3 = new ModelRenderer((ModelBase)this, 32, 0); this.goten3.func_78789_a(-6.0F, -6.933333F, 0.0F, 4, 2, 2); this.goten3.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.goten3, 0.0F, -0.6867716F, -0.1745329F); this.goten4 = new ModelRenderer((ModelBase)this, 32, 0); this.goten4.func_78789_a(-0.01F, -6.0001F, 1.1F, 4, 5, 4); this.goten4.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.goten4, 0.1745329F, 0.0F, 0.0F); this.goten5 = new ModelRenderer((ModelBase)this, 32, 0); this.goten5.func_78789_a(4.6F, -7.666667F, 2.7F, 1, 2, 1); this.goten5.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.goten5, 0.0F, 0.1745329F, -0.3490659F); this.goten6 = new ModelRenderer((ModelBase)this, 32, 0); this.goten6.func_78789_a(0.5333334F, -8.566667F, 2.1F, 2, 1, 1); this.goten6.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.goten6, 0.0F, -0.0349066F, 0.3490659F); this.goten9 = new ModelRenderer((ModelBase)this, 32, 0); this.goten9.func_78789_a(-9.066667F, -7.6F, 1.833333F, 3, 1, 1); this.goten9.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.goten9, 0.0F, -1.047198F, 0.122173F); this.goten14 = new ModelRenderer((ModelBase)this, 32, 0); this.goten14.func_78789_a(-3.99F, -6.0001F, 1.1F, 4, 5, 4); this.goten14.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.goten14, 0.1745329F, 0.0F, 0.0F); this.goten16 = new ModelRenderer((ModelBase)this, 32, 0); this.goten16.func_78789_a(7.0F, -5.1F, -0.3666667F, 2, 1, 1); this.goten16.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.goten16, 0.0F, -0.7853982F, -0.4363323F); this.gotent1 = new ModelRenderer((ModelBase)this, 32, 0); this.gotent1.func_78789_a(-0.4666667F, -11.33333F, -1.533333F, 2, 3, 2); this.gotent1.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.gotent1, 0.296706F, 0.0F, -0.2792527F); this.gotent2 = new ModelRenderer((ModelBase)this, 32, 0); this.gotent2.func_78789_a(-10.53333F, -0.8F, -3.4F, 5, 2, 2); this.gotent2.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.gotent2, 0.0F, 0.0F, 1.239184F); this.gotent3 = new ModelRenderer((ModelBase)this, 32, 0); this.gotent3.func_78789_a(-3.133333F, -9.133333F, 3.8F, 4, 4, 2); this.gotent3.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.gotent3, 0.8726646F, 0.2094395F, 0.0F); this.gotent5 = new ModelRenderer((ModelBase)this, 32, 0); this.gotent5.func_78789_a(4.6F, -7.666667F, 2.7F, 1, 2, 1); this.gotent5.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.gotent5, 0.0F, 0.1745329F, -0.3490659F); this.gotent6 = new ModelRenderer((ModelBase)this, 32, 0); this.gotent6.func_78789_a(0.5333334F, -8.566667F, 2.1F, 2, 1, 1); this.gotent6.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.gotent6, 0.0F, -0.0349066F, 0.3490659F); this.gotent7 = new ModelRenderer((ModelBase)this, 32, 0); this.gotent7.func_78789_a(1.2F, -11.0F, 0.1333333F, 2, 4, 2); this.gotent7.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.gotent7, 0.5235988F, 0.0F, -0.2617994F); this.gotent8 = new ModelRenderer((ModelBase)this, 32, 0); this.gotent8.func_78789_a(3.0F, -9.8F, 2.2F, 2, 3, 2); this.gotent8.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.gotent8, 0.8203047F, 0.0F, -0.9250245F); this.gotent9 = new ModelRenderer((ModelBase)this, 32, 0); this.gotent9.func_78789_a(-9.066667F, -4.6F, 0.5F, 5, 2, 2); this.gotent9.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.gotent9, 0.0F, -0.8901179F, 0.4712389F); this.gotent11 = new ModelRenderer((ModelBase)this, 32, 0); this.gotent11.func_78789_a(0.4F, -10.0F, 0.06666667F, 2, 5, 2); this.gotent11.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.gotent11, 0.3665191F, 0.0F, -0.5934119F); this.gotent16 = new ModelRenderer((ModelBase)this, 32, 0); this.gotent16.func_78789_a(7.0F, -5.1F, -0.3666667F, 2, 1, 1); this.gotent16.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.gotent16, 0.0F, -0.7853982F, -0.4363323F); this.hairc71 = new ModelRenderer((ModelBase)this, 32, 15); this.hairc71.func_78789_a(2.0F, -8.0F, -4.5F, 4, 8, 9); this.hairc71.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.hairc71, 0.0F, 0.0174533F, -0.2617994F); this.hairc72 = new ModelRenderer((ModelBase)this, 36, 0); this.hairc72.func_78789_a(-6.0F, -8.0F, -4.5F, 4, 8, 9); this.hairc72.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.hairc72, 0.0F, 0.0F, 0.2617994F); this.hairc81 = new ModelRenderer((ModelBase)this, 32, 15); this.hairc81.func_78789_a(2.133333F, -8.066667F, -4.5F, 3, 8, 9); this.hairc81.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.hairc81, 0.0F, 0.0174533F, -0.0872665F); this.hairc82 = new ModelRenderer((ModelBase)this, 34, 0); this.hairc82.func_78789_a(-6.0F, -8.0F, -4.5F, 4, 8, 9); this.hairc82.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.hairc82, 0.0F, 0.0F, 0.2617994F); this.hairc83 = new ModelRenderer((ModelBase)this, 0, 22); this.hairc83.func_78789_a(-5.0F, -8.466666F, -4.5F, 6, 1, 9); this.hairc83.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.hairc83, 0.0F, 0.0174533F, 0.1745329F); this.radlike1 = new ModelRenderer((ModelBase)this, 32, 0); this.radlike1.func_78789_a(-1.0F, -10.0F, -6.05F, 4, 4, 4); this.radlike1.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlike1, -0.3141593F, 0.0F, 0.0F); this.radlike2 = new ModelRenderer((ModelBase)this, 32, 0); this.radlike2.func_78789_a(-6.8F, -6.5F, -1.0F, 4, 3, 3); this.radlike2.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlike2, 0.0F, 0.1745329F, -0.1396263F); this.radlike3 = new ModelRenderer((ModelBase)this, 32, 0); this.radlike3.func_78789_a(-6.3F, -4.0F, 0.0F, 3, 2, 2); this.radlike3.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlike3, 0.0F, 0.2617994F, -0.1919862F); this.radlike4 = new ModelRenderer((ModelBase)this, 32, 0); this.radlike4.func_78789_a(2.8F, -7.0F, -1.0F, 4, 3, 3); this.radlike4.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlike4, 0.0F, -0.1745329F, 0.1919862F); this.radlike5 = new ModelRenderer((ModelBase)this, 32, 0); this.radlike5.func_78789_a(2.8F, -4.0F, 0.7F, 3, 2, 2); this.radlike5.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlike5, 0.0F, -0.1745329F, 0.1570796F); this.radlike7 = new ModelRenderer((ModelBase)this, 32, 0); this.radlike7.func_78789_a(-1.5F, -11.0F, -8.0F, 3, 3, 3); this.radlike7.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlike7, -0.5934119F, 0.0F, 0.1047198F); this.radlike8 = new ModelRenderer((ModelBase)this, 32, 0); this.radlike8.func_78789_a(-5.0F, -12.0F, -8.0F, 2, 3, 2); this.radlike8.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlike8, -0.6981317F, 0.0F, 0.4363323F); this.radlike10 = new ModelRenderer((ModelBase)this, 32, 0); this.radlike10.func_78789_a(-1.0F, -10.3F, -6.3F, 4, 6, 4); this.radlike10.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlike10, -0.4363323F, 0.0F, -0.3665191F); this.radlike11 = new ModelRenderer((ModelBase)this, 32, 0); this.radlike11.func_78789_a(1.0F, -11.3F, -6.0F, 5, 4, 3); this.radlike11.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlike11, -0.5410521F, 0.0F, -0.4886922F); this.radlike12 = new ModelRenderer((ModelBase)this, 32, 0); this.radlike12.func_78789_a(3.5F, -11.5F, -8.0F, 3, 3, 3); this.radlike12.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlike12, -0.8552113F, 0.0F, -0.6108652F); this.radlike13 = new ModelRenderer((ModelBase)this, 32, 0); this.radlike13.func_78789_a(6.0F, -12.4F, -8.0F, 2, 3, 2); this.radlike13.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlike13, -0.9948377F, 0.0F, -0.7679449F); this.radlike14 = new ModelRenderer((ModelBase)this, 32, 0); this.radlike14.func_78789_a(-1.3F, -9.3F, -5.5F, 3, 5, 3); this.radlike14.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlike14, -0.3665191F, 0.0F, 0.4014257F); this.radlike15 = new ModelRenderer((ModelBase)this, 32, 0); this.radlike15.func_78789_a(-5.5F, -9.8F, -6.0F, 3, 3, 3); this.radlike15.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlike15, -0.5410521F, 0.0F, 0.837758F); this.radlike16 = new ModelRenderer((ModelBase)this, 32, 0); this.radlike16.func_78789_a(-9.0F, -8.533334F, -6.0F, 2, 3, 2); this.radlike16.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlike16, -0.837758F, 0.0F, 1.27409F); this.radlike17 = new ModelRenderer((ModelBase)this, 32, 0); this.radlike17.func_78789_a(-2.0F, -2.0F, 4.0F, 4, 5, 4); this.radlike17.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlike17, 0.4886922F, 0.0F, 0.0F); this.radlike18 = new ModelRenderer((ModelBase)this, 32, 0); this.radlike18.func_78789_a(-1.0F, -5.0F, 5.0F, 4, 5, 4); this.radlike18.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlike18, 0.5061455F, 0.2617994F, 0.0174533F); this.radlike19 = new ModelRenderer((ModelBase)this, 32, 0); this.radlike19.func_78789_a(-4.0F, -6.0F, 5.0F, 4, 6, 4); this.radlike19.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlike19, 0.5235988F, -0.2617994F, 0.0F); this.radlike20 = new ModelRenderer((ModelBase)this, 32, 0); this.radlike20.func_78789_a(-2.4F, -5.2F, 7.0F, 4, 5, 4); this.radlike20.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlike20, 0.6981317F, 0.0F, 0.0F); this.radlike21 = new ModelRenderer((ModelBase)this, 32, 0); this.radlike21.func_78789_a(0.1333333F, -6.5F, 7.533333F, 3, 5, 3); this.radlike21.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlike21, 0.7679449F, 0.1745329F, 0.0F); this.radlike22 = new ModelRenderer((ModelBase)this, 32, 0); this.radlike22.func_78789_a(-2.866667F, -7.2F, 7.333333F, 3, 4, 3); this.radlike22.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlike22, 0.5934119F, -0.2617994F, 0.0F); this.radlike23 = new ModelRenderer((ModelBase)this, 32, 0); this.radlike23.func_78789_a(1.0F, -9.0F, -4.05F, 3, 4, 4); this.radlike23.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlike23, -0.3141593F, 0.0F, -0.8726646F); this.radlike24 = new ModelRenderer((ModelBase)this, 32, 0); this.radlike24.func_78789_a(3.533333F, -10.0F, -4.716667F, 3, 4, 3); this.radlike24.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlike24, -0.5585054F, 0.0F, -1.082104F); this.radlike25 = new ModelRenderer((ModelBase)this, 32, 0); this.radlike25.func_78789_a(3.533333F, -12.0F, -4.716667F, 2, 4, 2); this.radlike25.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlike25, -0.5934119F, 0.0F, -0.8203047F); this.radlike26 = new ModelRenderer((ModelBase)this, 32, 0); this.radlike26.func_78789_a(3.533333F, -9.666667F, -3.116667F, 3, 4, 3); this.radlike26.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlike26, -0.5585054F, 0.0F, -1.396263F); this.radlike27 = new ModelRenderer((ModelBase)this, 32, 0); this.radlike27.func_78789_a(-4.5F, -6.8F, -5.0F, 3, 4, 3); this.radlike27.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlike27, -0.5410521F, 0.0F, 1.047198F); this.radlike28 = new ModelRenderer((ModelBase)this, 32, 0); this.radlike28.func_78789_a(-6.8F, -7.533333F, -5.0F, 3, 4, 3); this.radlike28.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlike28, -0.837758F, 0.0F, 1.308997F); this.radlike29 = new ModelRenderer((ModelBase)this, 32, 0); this.radlike29.func_78789_a(6.0F, -10.2F, -5.0F, 2, 3, 2); this.radlike29.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlike29, -0.7679449F, 0.0F, -1.291544F); this.radlike30 = new ModelRenderer((ModelBase)this, 32, 0); this.radlike30.func_78789_a(-2.433333F, -10.6F, -7.666667F, 3, 3, 3); this.radlike30.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlike30, -0.7330383F, 0.0F, 0.3839724F); this.radlike31 = new ModelRenderer((ModelBase)this, 32, 0); this.radlike31.func_78789_a(-5.466667F, -11.0F, -8.333333F, 2, 3, 2); this.radlike31.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlike31, -0.9424778F, 0.0F, 0.6806784F); this.radlike32 = new ModelRenderer((ModelBase)this, 32, 0); this.radlike32.func_78789_a(-1.4F, -14.0F, -3.0F, 3, 4, 3); this.radlike32.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlike32, -0.4363323F, 0.0F, -0.0349066F); this.radlik6 = new ModelRenderer((ModelBase)this, 32, 0); this.radlik6.func_78789_a(-6.8F, -1.733333F, 3.2F, 3, 6, 3); this.radlik6.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlik6, 0.4363323F, 0.0F, 0.3490659F); this.radlik7 = new ModelRenderer((ModelBase)this, 32, 0); this.radlik7.func_78789_a(4.0F, -3.066667F, 2.6F, 3, 6, 3); this.radlik7.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlik7, 0.4363323F, 0.0F, -0.3490659F); this.radlik15 = new ModelRenderer((ModelBase)this, 32, 0); this.radlik15.func_78789_a(-2.266667F, -3.2F, 5.4F, 4, 4, 4); this.radlik15.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlik15, 0.4363323F, 0.0F, 0.0F); this.radlik1 = new ModelRenderer((ModelBase)this, 32, 0); this.radlik1.func_78789_a(-4.466667F, 6.2F, 4.0F, 3, 3, 2); this.radlik1.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlik1, 0.0872665F, 0.0F, 0.0698132F); this.radlik2 = new ModelRenderer((ModelBase)this, 32, 0); this.radlik2.func_78789_a(2.533333F, 4.2F, 3.0F, 3, 3, 3); this.radlik2.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlik2, 0.1396263F, 0.0F, -0.0872665F); this.radlik3 = new ModelRenderer((ModelBase)this, 32, 0); this.radlik3.func_78789_a(-5.466667F, 4.2F, 3.0F, 3, 3, 3); this.radlik3.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlik3, 0.1396263F, 0.0F, 0.0872665F); this.radlik4 = new ModelRenderer((ModelBase)this, 32, 0); this.radlik4.func_78789_a(-6.133333F, 0.7333333F, 3.0F, 3, 5, 3); this.radlik4.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlik4, 0.2268928F, 0.0F, 0.2094395F); this.radlik5 = new ModelRenderer((ModelBase)this, 32, 0); this.radlik5.func_78789_a(3.266667F, 0.7333333F, 3.0F, 3, 5, 3); this.radlik5.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlik5, 0.2268928F, 0.0F, -0.2094395F); this.radlik8 = new ModelRenderer((ModelBase)this, 32, 0); this.radlik8.func_78789_a(-1.466667F, 6.0F, 4.0F, 3, 5, 4); this.radlik8.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlik8, 0.0872665F, -0.2617994F, 0.0F); this.radlik9 = new ModelRenderer((ModelBase)this, 32, 0); this.radlik9.func_78789_a(-2.466667F, 2.0F, 4.0F, 4, 5, 4); this.radlik9.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlik9, 0.1570796F, -0.2617994F, 0.0F); this.radlik10 = new ModelRenderer((ModelBase)this, 32, 0); this.radlik10.func_78789_a(-2.0F, 7.266667F, 4.0F, 4, 4, 4); this.radlik10.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlik10, 0.0698132F, 0.2617994F, 0.0F); this.radlik11 = new ModelRenderer((ModelBase)this, 32, 0); this.radlik11.func_78789_a(-1.0F, 4.266667F, 4.0F, 4, 4, 4); this.radlik11.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlik11, 0.1047198F, 0.2617994F, 0.0F); this.radlik12 = new ModelRenderer((ModelBase)this, 32, 0); this.radlik12.func_78789_a(-0.9F, 1.266667F, 4.0F, 4, 4, 4); this.radlik12.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlik12, 0.1745329F, 0.2617994F, 0.0F); this.radlik13 = new ModelRenderer((ModelBase)this, 32, 0); this.radlik13.func_78789_a(-1.933333F, 5.0F, 4.0F, 4, 5, 4); this.radlik13.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlik13, 0.1745329F, 0.0F, 0.0F); this.radlik14 = new ModelRenderer((ModelBase)this, 32, 0); this.radlik14.func_78789_a(-1.4F, 8.0F, 5.6F, 3, 5, 3); this.radlik14.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlik14, 0.0872665F, 0.0F, 0.0F); this.radlik16 = new ModelRenderer((ModelBase)this, 32, 0); this.radlik16.func_78789_a(-2.533333F, -2.0F, 3.333333F, 4, 6, 4); this.radlik16.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlik16, 0.3490659F, -0.2617994F, 0.0F); this.radlik17 = new ModelRenderer((ModelBase)this, 32, 0); this.radlik17.func_78789_a(-1.0F, -2.0F, 4.0F, 4, 5, 4); this.radlik17.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlik17, 0.3316126F, 0.2617994F, 0.0F); this.radlik18 = new ModelRenderer((ModelBase)this, 32, 0); this.radlik18.func_78789_a(-2.0F, 1.0F, 4.0F, 4, 5, 4); this.radlik18.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlik18, 0.2792527F, 0.0F, 0.0F); this.ssjsan1 = new ModelRenderer((ModelBase)this, 32, 0); this.ssjsan1.func_78789_a(-1.0F, -10.0F, -6.05F, 4, 4, 4); this.ssjsan1.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssjsan1, -0.3141593F, 0.0F, 0.0F); this.ssjsan2 = new ModelRenderer((ModelBase)this, 32, 0); this.ssjsan2.func_78789_a(-6.8F, -6.5F, -1.0F, 4, 3, 3); this.ssjsan2.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssjsan2, 0.0F, 0.1745329F, -0.1396263F); this.ssjsan3 = new ModelRenderer((ModelBase)this, 32, 0); this.ssjsan3.func_78789_a(-6.3F, -4.0F, 0.0F, 3, 2, 2); this.ssjsan3.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssjsan3, 0.0F, 0.2617994F, -0.1919862F); this.ssjsan4 = new ModelRenderer((ModelBase)this, 32, 0); this.ssjsan4.func_78789_a(2.8F, -7.0F, -1.0F, 4, 3, 3); this.ssjsan4.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssjsan4, 0.0F, -0.1745329F, 0.1919862F); this.ssjsan5 = new ModelRenderer((ModelBase)this, 32, 0); this.ssjsan5.func_78789_a(2.8F, -4.0F, 0.7F, 3, 2, 2); this.ssjsan5.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssjsan5, 0.0F, -0.1745329F, 0.1570796F); this.ssjsan7 = new ModelRenderer((ModelBase)this, 32, 0); this.ssjsan7.func_78789_a(-1.5F, -11.0F, -8.0F, 3, 3, 3); this.ssjsan7.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssjsan7, -0.5934119F, 0.0F, 0.1047198F); this.ssjsan8 = new ModelRenderer((ModelBase)this, 32, 0); this.ssjsan8.func_78789_a(-5.0F, -12.0F, -8.0F, 2, 3, 2); this.ssjsan8.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssjsan8, -0.6981317F, 0.0F, 0.4363323F); this.ssjsan10 = new ModelRenderer((ModelBase)this, 32, 0); this.ssjsan10.func_78789_a(-1.0F, -10.3F, -6.3F, 4, 6, 4); this.ssjsan10.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssjsan10, -0.4363323F, 0.0F, -0.3665191F); this.ssjsan11 = new ModelRenderer((ModelBase)this, 32, 0); this.ssjsan11.func_78789_a(1.0F, -11.3F, -6.0F, 5, 4, 3); this.ssjsan11.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssjsan11, -0.5410521F, 0.0F, -0.4886922F); this.ssjsan12 = new ModelRenderer((ModelBase)this, 32, 0); this.ssjsan12.func_78789_a(3.5F, -11.5F, -8.0F, 3, 3, 3); this.ssjsan12.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssjsan12, -0.8552113F, 0.0F, -0.6108652F); this.ssjsan13 = new ModelRenderer((ModelBase)this, 32, 0); this.ssjsan13.func_78789_a(6.0F, -12.4F, -8.0F, 2, 3, 2); this.ssjsan13.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssjsan13, -0.9948377F, 0.0F, -0.7679449F); this.ssjsan14 = new ModelRenderer((ModelBase)this, 32, 0); this.ssjsan14.func_78789_a(-1.3F, -9.3F, -5.5F, 3, 5, 3); this.ssjsan14.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssjsan14, -0.3665191F, 0.0F, 0.4014257F); this.ssjsan15 = new ModelRenderer((ModelBase)this, 32, 0); this.ssjsan15.func_78789_a(-5.5F, -9.8F, -6.0F, 3, 3, 3); this.ssjsan15.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssjsan15, -0.5410521F, 0.0F, 0.837758F); this.ssjsan16 = new ModelRenderer((ModelBase)this, 32, 0); this.ssjsan16.func_78789_a(-9.0F, -8.533334F, -6.0F, 2, 3, 2); this.ssjsan16.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssjsan16, -0.837758F, 0.0F, 1.27409F); this.ssjsan17 = new ModelRenderer((ModelBase)this, 32, 0); this.ssjsan17.func_78789_a(-2.0F, -2.0F, 4.0F, 4, 5, 4); this.ssjsan17.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssjsan17, 0.4886922F, 0.0F, 0.0F); this.ssjsan18 = new ModelRenderer((ModelBase)this, 32, 0); this.ssjsan18.func_78789_a(-1.0F, -5.0F, 5.0F, 4, 5, 4); this.ssjsan18.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssjsan18, 0.5061455F, 0.2617994F, 0.0174533F); this.ssjsan19 = new ModelRenderer((ModelBase)this, 32, 0); this.ssjsan19.func_78789_a(-4.0F, -6.0F, 5.0F, 4, 6, 4); this.ssjsan19.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssjsan19, 0.5235988F, -0.2617994F, 0.0F); this.ssjsan20 = new ModelRenderer((ModelBase)this, 32, 0); this.ssjsan20.func_78789_a(-2.4F, -5.2F, 7.0F, 4, 5, 4); this.ssjsan20.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssjsan20, 0.6981317F, 0.0F, 0.0F); this.ssjsan21 = new ModelRenderer((ModelBase)this, 32, 0); this.ssjsan21.func_78789_a(0.1333333F, -6.5F, 7.533333F, 3, 5, 3); this.ssjsan21.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssjsan21, 0.7679449F, 0.1745329F, 0.0F); this.ssjsan22 = new ModelRenderer((ModelBase)this, 32, 0); this.ssjsan22.func_78789_a(-2.866667F, -7.2F, 7.333333F, 3, 4, 3); this.ssjsan22.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssjsan22, 0.5934119F, -0.2617994F, 0.0F); this.ssjsan23 = new ModelRenderer((ModelBase)this, 32, 0); this.ssjsan23.func_78789_a(1.0F, -9.0F, -4.05F, 3, 4, 4); this.ssjsan23.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssjsan23, -0.3141593F, 0.0F, -0.8726646F); this.ssjsan24 = new ModelRenderer((ModelBase)this, 32, 0); this.ssjsan24.func_78789_a(3.533333F, -10.0F, -4.716667F, 3, 4, 3); this.ssjsan24.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssjsan24, -0.5585054F, 0.0F, -1.082104F); this.ssjsan25 = new ModelRenderer((ModelBase)this, 32, 0); this.ssjsan25.func_78789_a(3.533333F, -12.0F, -4.716667F, 2, 4, 2); this.ssjsan25.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssjsan25, -0.5934119F, 0.0F, -0.8203047F); this.ssjsan26 = new ModelRenderer((ModelBase)this, 32, 0); this.ssjsan26.func_78789_a(3.533333F, -9.666667F, -3.116667F, 3, 4, 3); this.ssjsan26.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssjsan26, -0.5585054F, 0.0F, -1.396263F); this.ssjsan27 = new ModelRenderer((ModelBase)this, 32, 0); this.ssjsan27.func_78789_a(-4.5F, -6.8F, -5.0F, 3, 4, 3); this.ssjsan27.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssjsan27, -0.5410521F, 0.0F, 1.047198F); this.ssjsan28 = new ModelRenderer((ModelBase)this, 32, 0); this.ssjsan28.func_78789_a(-6.8F, -7.533333F, -5.0F, 3, 4, 3); this.ssjsan28.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssjsan28, -0.837758F, 0.0F, 1.308997F); this.ssjsan29 = new ModelRenderer((ModelBase)this, 32, 0); this.ssjsan29.func_78789_a(6.0F, -10.2F, -5.0F, 2, 3, 2); this.ssjsan29.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssjsan29, -0.7679449F, 0.0F, -1.291544F); this.ssjsan30 = new ModelRenderer((ModelBase)this, 32, 0); this.ssjsan30.func_78789_a(-2.433333F, -10.6F, -7.666667F, 3, 3, 3); this.ssjsan30.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssjsan30, -0.7330383F, 0.0F, 0.3839724F); this.ssjsan31 = new ModelRenderer((ModelBase)this, 32, 0); this.ssjsan31.func_78789_a(-5.466667F, -11.0F, -8.333333F, 2, 3, 2); this.ssjsan31.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssjsan31, -0.9424778F, 0.0F, 0.6806784F); this.ssjsan32 = new ModelRenderer((ModelBase)this, 32, 0); this.ssjsan32.func_78789_a(-1.4F, -14.0F, -3.0F, 3, 4, 3); this.ssjsan32.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssjsan32, -0.4363323F, 0.0F, -0.0349066F); this.long6 = new ModelRenderer((ModelBase)this, 32, 0); this.long6.func_78789_a(-6.8F, -1.733333F, 3.2F, 3, 6, 3); this.long6.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.long6, 0.4363323F, 0.0F, 0.3490659F); this.long7 = new ModelRenderer((ModelBase)this, 32, 0); this.long7.func_78789_a(4.0F, -3.066667F, 2.6F, 3, 6, 3); this.long7.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.long7, 0.4363323F, 0.0F, -0.3490659F); this.long15 = new ModelRenderer((ModelBase)this, 32, 0); this.long15.func_78789_a(-2.266667F, -3.2F, 5.4F, 4, 4, 4); this.long15.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.long15, 0.4363323F, 0.0F, 0.0F); this.long1 = new ModelRenderer((ModelBase)this, 32, 0); this.long1.func_78789_a(-4.466667F, 8.2F, 4.0F, 3, 4, 2); this.long1.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.long1, 0.0872665F, 0.0F, 0.0698132F); this.long2 = new ModelRenderer((ModelBase)this, 32, 0); this.long2.func_78789_a(2.533333F, 4.2F, 3.0F, 3, 5, 3); this.long2.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.long2, 0.1396263F, 0.0F, -0.0872665F); this.long3 = new ModelRenderer((ModelBase)this, 32, 0); this.long3.func_78789_a(-5.466667F, 4.2F, 3.0F, 3, 5, 3); this.long3.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.long3, 0.1396263F, 0.0F, 0.0872665F); this.long4 = new ModelRenderer((ModelBase)this, 32, 0); this.long4.func_78789_a(-6.133333F, 0.7333333F, 3.0F, 3, 5, 3); this.long4.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.long4, 0.2268928F, 0.0F, 0.2094395F); this.long5 = new ModelRenderer((ModelBase)this, 32, 0); this.long5.func_78789_a(3.266667F, 0.7333333F, 3.0F, 3, 5, 3); this.long5.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.long5, 0.2268928F, 0.0F, -0.2094395F); this.long8 = new ModelRenderer((ModelBase)this, 32, 0); this.long8.func_78789_a(-1.466667F, 7.0F, 4.0F, 3, 7, 4); this.long8.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.long8, 0.0872665F, -0.2617994F, 0.0F); this.long9 = new ModelRenderer((ModelBase)this, 32, 0); this.long9.func_78789_a(-2.466667F, 2.0F, 4.0F, 4, 6, 4); this.long9.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.long9, 0.1570796F, -0.2617994F, 0.0F); this.long10 = new ModelRenderer((ModelBase)this, 32, 0); this.long10.func_78789_a(-2.0F, 9.266666F, 4.0F, 4, 5, 4); this.long10.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.long10, 0.0698132F, 0.2617994F, 0.0F); this.long11 = new ModelRenderer((ModelBase)this, 32, 0); this.long11.func_78789_a(-1.0F, 5.266667F, 4.0F, 4, 5, 4); this.long11.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.long11, 0.1047198F, 0.2617994F, 0.0F); this.long12 = new ModelRenderer((ModelBase)this, 32, 0); this.long12.func_78789_a(-0.9F, 1.266667F, 4.0F, 4, 5, 4); this.long12.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.long12, 0.1745329F, 0.2617994F, 0.0F); this.long13 = new ModelRenderer((ModelBase)this, 32, 0); this.long13.func_78789_a(-1.933333F, 6.0F, 4.0F, 4, 6, 4); this.long13.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.long13, 0.1745329F, 0.0F, 0.0F); this.long14 = new ModelRenderer((ModelBase)this, 32, 0); this.long14.func_78789_a(-1.4F, 11.0F, 5.6F, 3, 6, 3); this.long14.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.long14, 0.0872665F, 0.0F, 0.0F); this.long16 = new ModelRenderer((ModelBase)this, 32, 0); this.long16.func_78789_a(-2.533333F, -2.0F, 3.333333F, 4, 6, 4); this.long16.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.long16, 0.3490659F, -0.2617994F, 0.0F); this.long17 = new ModelRenderer((ModelBase)this, 32, 0); this.long17.func_78789_a(-1.0F, -2.0F, 4.0F, 4, 5, 4); this.long17.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.long17, 0.3316126F, 0.2617994F, 0.0F); this.long18 = new ModelRenderer((ModelBase)this, 32, 0); this.long18.func_78789_a(-2.0F, 1.0F, 4.0F, 4, 6, 4); this.long18.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.long18, 0.2792527F, 0.0F, 0.0F); this.tincs1 = new ModelRenderer((ModelBase)this, 32, 0); this.tincs1.func_78789_a(2.866667F, -5.533333F, -6.25F, 2, 4, 1); this.tincs1.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.tincs1, -0.3141593F, 0.0F, -0.4712389F); this.bipedHeadg.func_78792_a(this.bipedHeadAll); this.bipedHeadg.func_78792_a(this.goku1); this.bipedHeadg.func_78792_a(this.goku2); this.bipedHeadg.func_78792_a(this.goku3); this.bipedHeadg.func_78792_a(this.goku4); this.bipedHeadg.func_78792_a(this.goku5); this.bipedHeadg.func_78792_a(this.goku6); this.bipedHeadg.func_78792_a(this.goku7); this.bipedHeadg.func_78792_a(this.goku8); this.bipedHeadg.func_78792_a(this.goku9); this.bipedHeadg.func_78792_a(this.goku10); this.bipedHeadg.func_78792_a(this.goku11); this.bipedHeadg.func_78792_a(this.goku12); this.bipedHeadg.func_78792_a(this.goku13); this.bipedHeadg.func_78792_a(this.goku14); this.bipedHeadg.func_78792_a(this.goku15); this.bipedHeadg.func_78792_a(this.goku16); this.bipedHeadsg.func_78792_a(this.bipedHeadAll); this.bipedHeadsg.func_78792_a(this.sgoku1); this.bipedHeadsg.func_78792_a(this.sgoku2); this.bipedHeadsg.func_78792_a(this.sgoku3); this.bipedHeadsg.func_78792_a(this.sgoku4); this.bipedHeadsg.func_78792_a(this.sgoku5); this.bipedHeadsg.func_78792_a(this.sgoku6); this.bipedHeadsg.func_78792_a(this.sgoku7); this.bipedHeadsg.func_78792_a(this.sgoku8); this.bipedHeadsg.func_78792_a(this.sgoku9); this.bipedHeadsg.func_78792_a(this.sgoku10); this.bipedHeadsg.func_78792_a(this.sgoku11); this.bipedHeadsg.func_78792_a(this.sgoku12); this.bipedHeadsg.func_78792_a(this.sgoku13); this.bipedHeadsg.func_78792_a(this.sgoku14); this.bipedHeadsg.func_78792_a(this.sgoku15); this.bipedHeadsg.func_78792_a(this.sgoku16); this.bipedHeadsg.func_78792_a(this.sgoku17); this.bipedHeadsg.func_78792_a(this.sgoku18); this.bipedHeadsg.func_78792_a(this.sgoku19); this.bipedHeadsg.func_78792_a(this.sgoku20); this.bipedHeadsg.func_78792_a(this.sgoku21); this.bipedHeadsg.func_78792_a(this.sgoku22); this.bipedHeadsg.func_78792_a(this.sgoku23); this.bipedHeadsg.func_78792_a(this.sgoku24); this.bipedHeadsg.func_78792_a(this.sgoku25); this.bipedHeadsg.func_78792_a(this.sgoku26); this.bipedHeadssg.func_78792_a(this.bipedHeadAll); this.bipedHeadssg.func_78792_a(this.ssgoku1); this.bipedHeadssg.func_78792_a(this.ssgoku2); this.bipedHeadssg.func_78792_a(this.ssgoku3); this.bipedHeadssg.func_78792_a(this.ssgoku4); this.bipedHeadssg.func_78792_a(this.ssgoku5); this.bipedHeadssg.func_78792_a(this.ssgoku6); this.bipedHeadssg.func_78792_a(this.ssgoku7); this.bipedHeadssg.func_78792_a(this.ssgoku8); this.bipedHeadssg.func_78792_a(this.ssgoku9); this.bipedHeadssg.func_78792_a(this.ssgoku10); this.bipedHeadssg.func_78792_a(this.ssgoku11); this.bipedHeadssg.func_78792_a(this.ssgoku12); this.bipedHeadssg.func_78792_a(this.ssgoku13); this.bipedHeadssg.func_78792_a(this.ssgoku14); this.bipedHeadssg.func_78792_a(this.ssgoku15); this.bipedHeadssg.func_78792_a(this.ssgoku16); this.bipedHeadssg.func_78792_a(this.ssgoku17); this.bipedHeadssg.func_78792_a(this.ssgoku18); this.bipedHeadssg.func_78792_a(this.ssgoku19); this.bipedHeadssg.func_78792_a(this.ssgoku20); this.bipedHeadssg.func_78792_a(this.ssgoku21); this.bipedHeadssg.func_78792_a(this.ssgoku22); this.bipedHeadssg.func_78792_a(this.ssgoku23); this.bipedHeadssg.func_78792_a(this.ssgoku24); this.bipedHeadssg.func_78792_a(this.ssgoku25); this.bipedHeadssg.func_78792_a(this.ssgoku26); this.bipedHeadt.func_78792_a(this.bipedHeadAll); this.bipedHeadt.func_78792_a(this.trunk1); this.bipedHeadt.func_78792_a(this.trunk2); this.bipedHeadt.func_78792_a(this.trunk3); this.bipedHeadt.func_78792_a(this.trunk4); this.bipedHeadt.func_78792_a(this.trunk5); this.bipedHeadt.func_78792_a(this.trunk6); this.bipedHeadt.func_78792_a(this.trunk7); this.bipedHeadt.func_78792_a(this.trunk8); this.bipedHeadt.func_78792_a(this.trunk9); this.bipedHeadst.func_78792_a(this.bipedHeadAll); this.bipedHeadst.func_78792_a(this.strunk1); this.bipedHeadst.func_78792_a(this.strunk2); this.bipedHeadst.func_78792_a(this.strunk3); this.bipedHeadst.func_78792_a(this.strunk4); this.bipedHeadst.func_78792_a(this.strunk5); this.bipedHeadst.func_78792_a(this.strunk6); this.bipedHeadst.func_78792_a(this.strunk7); this.bipedHeadst.func_78792_a(this.strunk8); this.bipedHeadst.func_78792_a(this.strunk9); this.bipedHeadst.func_78792_a(this.strunk10); this.bipedHeadst.func_78792_a(this.strunk11); this.bipedHeadst.func_78792_a(this.strunk12); this.bipedHeadst.func_78792_a(this.strunk13); this.bipedHeadst.func_78792_a(this.strunk14); this.bipedHeadst.func_78792_a(this.strunk15); this.bipedHeadst.func_78792_a(this.strunk16); this.bipedHeadst.func_78792_a(this.strunk17); this.bipedHeadsst.func_78792_a(this.bipedHeadAll); this.bipedHeadsst.func_78792_a(this.sstrunk1); this.bipedHeadsst.func_78792_a(this.sstrunk2); this.bipedHeadsst.func_78792_a(this.sstrunk3); this.bipedHeadsst.func_78792_a(this.sstrunk4); this.bipedHeadsst.func_78792_a(this.sstrunk5); this.bipedHeadsst.func_78792_a(this.sstrunk6); this.bipedHeadsst.func_78792_a(this.sstrunk7); this.bipedHeadsst.func_78792_a(this.sstrunk8); this.bipedHeadsst.func_78792_a(this.sstrunk9); this.bipedHeadsst.func_78792_a(this.sstrunk10); this.bipedHeadsst.func_78792_a(this.sstrunk11); this.bipedHeadsst.func_78792_a(this.sstrunk12); this.bipedHeadsst.func_78792_a(this.sstrunk13); this.bipedHeadsst.func_78792_a(this.sstrunk14); this.bipedHeadsst.func_78792_a(this.sstrunk15); this.bipedHeadsst.func_78792_a(this.sstrunk16); this.bipedHeadsst.func_78792_a(this.sstrunk17); this.bipedHeadv.func_78792_a(this.bipedHeadAll); this.bipedHeadv.func_78792_a(this.vegeta1); this.bipedHeadv.func_78792_a(this.vegeta2); this.bipedHeadv.func_78792_a(this.vegeta3); this.bipedHeadv.func_78792_a(this.vegeta4); this.bipedHeadv.func_78792_a(this.vegeta5); this.bipedHeadv.func_78792_a(this.vegeta6); this.bipedHeadv.func_78792_a(this.vegeta7); this.bipedHeadv.func_78792_a(this.vegeta8); this.bipedHeadv.func_78792_a(this.vegeta9); this.bipedHeadv.func_78792_a(this.vegeta10); this.bipedHeadv.func_78792_a(this.vegeta11); this.bipedHeadv.func_78792_a(this.vegeta12); this.bipedHeadv.func_78792_a(this.vegeta13); this.bipedHeadv.func_78792_a(this.vegeta14); this.bipedHeadv.func_78792_a(this.vegeta15); this.bipedHeadv.func_78792_a(this.vegeta16); this.bipedHeadv.func_78792_a(this.vegeta17); this.bipedHeadv.func_78792_a(this.vegeta18); this.bipedHeadv.func_78792_a(this.vegeta19); this.bipedHeadv.func_78792_a(this.vegeta20); this.bipedHeadv.func_78792_a(this.vegeta21); this.bipedHeadv.func_78792_a(this.vegeta22); this.bipedHeadsv.func_78792_a(this.bipedHeadAll); this.bipedHeadsv.func_78792_a(this.svegeta1); this.bipedHeadsv.func_78792_a(this.svegeta2); this.bipedHeadsv.func_78792_a(this.svegeta3); this.bipedHeadsv.func_78792_a(this.svegeta4); this.bipedHeadsv.func_78792_a(this.svegeta5); this.bipedHeadsv.func_78792_a(this.svegeta6); this.bipedHeadsv.func_78792_a(this.svegeta7); this.bipedHeadsv.func_78792_a(this.svegeta8); this.bipedHeadsv.func_78792_a(this.svegeta9); this.bipedHeadsv.func_78792_a(this.svegeta10); this.bipedHeadsv.func_78792_a(this.svegeta11); this.bipedHeadsv.func_78792_a(this.svegeta12); this.bipedHeadsv.func_78792_a(this.svegeta13); this.bipedHeadsv.func_78792_a(this.svegeta14); this.bipedHeadsv.func_78792_a(this.svegeta15); this.bipedHeadsv.func_78792_a(this.svegeta16); this.bipedHeadsv.func_78792_a(this.svegeta17); this.bipedHeadsv.func_78792_a(this.svegeta18); this.bipedHeadsv.func_78792_a(this.svegeta19); this.bipedHeadsv.func_78792_a(this.svegeta20); this.bipedHeadsv.func_78792_a(this.svegeta21); this.bipedHeadsv.func_78792_a(this.svegeta22); this.bipedHeadssv.func_78792_a(this.bipedHeadAll); this.bipedHeadssv.func_78792_a(this.ssvegeta1); this.bipedHeadssv.func_78792_a(this.ssvegeta2); this.bipedHeadssv.func_78792_a(this.ssvegeta3); this.bipedHeadssv.func_78792_a(this.ssvegeta4); this.bipedHeadssv.func_78792_a(this.ssvegeta5); this.bipedHeadssv.func_78792_a(this.ssvegeta6); this.bipedHeadssv.func_78792_a(this.ssvegeta7); this.bipedHeadssv.func_78792_a(this.ssvegeta8); this.bipedHeadssv.func_78792_a(this.ssvegeta9); this.bipedHeadssv.func_78792_a(this.ssvegeta10); this.bipedHeadssv.func_78792_a(this.ssvegeta11); this.bipedHeadssv.func_78792_a(this.ssvegeta12); this.bipedHeadssv.func_78792_a(this.ssvegeta13); this.bipedHeadssv.func_78792_a(this.ssvegeta14); this.bipedHeadssv.func_78792_a(this.ssvegeta15); this.bipedHeadssv.func_78792_a(this.ssvegeta16); this.bipedHeadssv.func_78792_a(this.ssvegeta17); this.bipedHeadssv.func_78792_a(this.ssvegeta18); this.bipedHeadssv.func_78792_a(this.ssvegeta19); this.bipedHeadssv.func_78792_a(this.ssvegeta20); this.bipedHeadssv.func_78792_a(this.ssvegeta21); this.bipedHeadssv.func_78792_a(this.ssvegeta22); this.bipedHeadgh.func_78792_a(this.bipedHeadAll); this.bipedHeadgh.func_78792_a(this.gohan1); this.bipedHeadgh.func_78792_a(this.gohan7); this.bipedHeadgh.func_78792_a(this.gohan8); this.bipedHeadgh.func_78792_a(this.gohan10); this.bipedHeadgh.func_78792_a(this.gohan11); this.bipedHeadgh.func_78792_a(this.gohan12); this.bipedHeadgh.func_78792_a(this.gohan13); this.bipedHeadgh.func_78792_a(this.gohan14); this.bipedHeadgh.func_78792_a(this.gohan15); this.bipedHeadgh.func_78792_a(this.gohan16); this.bipedHeadgh.func_78792_a(this.gohan17); this.bipedHeadgh.func_78792_a(this.gohan18); this.bipedHeadgh.func_78792_a(this.gohan19); this.bipedHeadgh.func_78792_a(this.gohan20); this.bipedHeadgh.func_78792_a(this.gohan21); this.bipedHeadgh.func_78792_a(this.gohan22); this.bipedHeadgh.func_78792_a(this.gohan26); this.bipedHeadsgh.func_78792_a(this.bipedHeadAll); this.bipedHeadsgh.func_78792_a(this.sgohan1); this.bipedHeadsgh.func_78792_a(this.sgohan7); this.bipedHeadsgh.func_78792_a(this.sgohan8); this.bipedHeadsgh.func_78792_a(this.sgohan10); this.bipedHeadsgh.func_78792_a(this.sgohan11); this.bipedHeadsgh.func_78792_a(this.sgohan12); this.bipedHeadsgh.func_78792_a(this.sgohan13); this.bipedHeadsgh.func_78792_a(this.sgohan14); this.bipedHeadsgh.func_78792_a(this.sgohan15); this.bipedHeadsgh.func_78792_a(this.sgohan16); this.bipedHeadsgh.func_78792_a(this.sgohan17); this.bipedHeadsgh.func_78792_a(this.sgohan18); this.bipedHeadsgh.func_78792_a(this.sgohan19); this.bipedHeadsgh.func_78792_a(this.sgohan20); this.bipedHeadsgh.func_78792_a(this.sgohan21); this.bipedHeadsgh.func_78792_a(this.sgohan22); this.bipedHeadsgh.func_78792_a(this.sgohan26); this.bipedHeadssgh.func_78792_a(this.bipedHeadAll); this.bipedHeadssgh.func_78792_a(this.ssgohan1); this.bipedHeadssgh.func_78792_a(this.ssgohan7); this.bipedHeadssgh.func_78792_a(this.ssgohan8); this.bipedHeadssgh.func_78792_a(this.ssgohan10); this.bipedHeadssgh.func_78792_a(this.ssgohan11); this.bipedHeadssgh.func_78792_a(this.ssgohan12); this.bipedHeadssgh.func_78792_a(this.ssgohan13); this.bipedHeadssgh.func_78792_a(this.ssgohan14); this.bipedHeadssgh.func_78792_a(this.ssgohan15); this.bipedHeadssgh.func_78792_a(this.ssgohan16); this.bipedHeadssgh.func_78792_a(this.ssgohan17); this.bipedHeadssgh.func_78792_a(this.ssgohan18); this.bipedHeadssgh.func_78792_a(this.ssgohan19); this.bipedHeadssgh.func_78792_a(this.ssgohan20); this.bipedHeadssgh.func_78792_a(this.ssgohan21); this.bipedHeadssgh.func_78792_a(this.ssgohan22); this.bipedHeadssgh.func_78792_a(this.ssgohan26); this.bipedHeadg2.func_78792_a(this.bipedHeadAll); this.bipedHeadg2.func_78792_a(this.gokuni1); this.bipedHeadg2.func_78792_a(this.gokuni2); this.bipedHeadg2.func_78792_a(this.gokuni3); this.bipedHeadg2.func_78792_a(this.gokuni4); this.bipedHeadg2.func_78792_a(this.gokuni5); this.bipedHeadg2.func_78792_a(this.gokuni6); this.bipedHeadg2.func_78792_a(this.gokuni7); this.bipedHeadg2.func_78792_a(this.gokuni8); this.bipedHeadg2.func_78792_a(this.gokuni9); this.bipedHeadg2.func_78792_a(this.gokuni10); this.bipedHeadg2.func_78792_a(this.gokuni11); this.bipedHeadg2.func_78792_a(this.gokuni12); this.bipedHeadght.func_78792_a(this.bipedHeadAll); this.bipedHeadght.func_78792_a(this.ght1); this.bipedHeadght.func_78792_a(this.ght2); this.bipedHeadght.func_78792_a(this.ght3); this.bipedHeadght.func_78792_a(this.ght4); this.bipedHeadght.func_78792_a(this.ght5); this.bipedHeadght.func_78792_a(this.ght6); this.bipedHeadght.func_78792_a(this.ght7); this.bipedHeadght.func_78792_a(this.ght8); this.bipedHeadght.func_78792_a(this.ght9); this.bipedHeadght.func_78792_a(this.ght11); this.bipedHeadght.func_78792_a(this.ght14); this.bipedHeadght.func_78792_a(this.ght16); this.bipedHeadgt.func_78792_a(this.bipedHeadAll); this.bipedHeadgt.func_78792_a(this.goten2); this.bipedHeadgt.func_78792_a(this.goten3); this.bipedHeadgt.func_78792_a(this.goten4); this.bipedHeadgt.func_78792_a(this.goten5); this.bipedHeadgt.func_78792_a(this.goten6); this.bipedHeadgt.func_78792_a(this.goten9); this.bipedHeadgt.func_78792_a(this.goten14); this.bipedHeadgt.func_78792_a(this.goten16); this.bipedHeadgtt.func_78792_a(this.bipedHeadAll); this.bipedHeadgtt.func_78792_a(this.gotent1); this.bipedHeadgtt.func_78792_a(this.gotent2); this.bipedHeadgtt.func_78792_a(this.gotent3); this.bipedHeadgtt.func_78792_a(this.gotent5); this.bipedHeadgtt.func_78792_a(this.gotent6); this.bipedHeadgtt.func_78792_a(this.gotent7); this.bipedHeadgtt.func_78792_a(this.gotent8); this.bipedHeadgtt.func_78792_a(this.gotent9); this.bipedHeadgtt.func_78792_a(this.gotent11); this.bipedHeadgtt.func_78792_a(this.gotent16); this.bipedHeadc7.func_78792_a(this.bipedHeadAll); this.bipedHeadc7.func_78792_a(this.hairc71); this.bipedHeadc7.func_78792_a(this.hairc72); this.bipedHeadc8.func_78792_a(this.bipedHeadAll); this.bipedHeadc8.func_78792_a(this.hairc81); this.bipedHeadc8.func_78792_a(this.hairc82); this.bipedHeadc8.func_78792_a(this.hairc83); this.bipedHeadrad.func_78792_a(this.bipedHeadAll); this.bipedHeadrad.func_78792_a(this.radlike1); this.bipedHeadrad.func_78792_a(this.radlike2); this.bipedHeadrad.func_78792_a(this.radlike3); this.bipedHeadrad.func_78792_a(this.radlike4); this.bipedHeadrad.func_78792_a(this.radlike5); this.bipedHeadrad.func_78792_a(this.radlike7); this.bipedHeadrad.func_78792_a(this.radlike8); this.bipedHeadrad.func_78792_a(this.radlike10); this.bipedHeadrad.func_78792_a(this.radlike11); this.bipedHeadrad.func_78792_a(this.radlike12); this.bipedHeadrad.func_78792_a(this.radlike13); this.bipedHeadrad.func_78792_a(this.radlike14); this.bipedHeadrad.func_78792_a(this.radlike15); this.bipedHeadrad.func_78792_a(this.radlike16); this.bipedHeadrad.func_78792_a(this.radlike18); this.bipedHeadrad.func_78792_a(this.radlike19); this.bipedHeadrad.func_78792_a(this.radlike20); this.bipedHeadrad.func_78792_a(this.radlike21); this.bipedHeadrad.func_78792_a(this.radlike22); this.bipedHeadrad.func_78792_a(this.radlike23); this.bipedHeadrad.func_78792_a(this.radlike24); this.bipedHeadrad.func_78792_a(this.radlike25); this.bipedHeadrad.func_78792_a(this.radlike26); this.bipedHeadrad.func_78792_a(this.radlike27); this.bipedHeadrad.func_78792_a(this.radlike28); this.bipedHeadrad.func_78792_a(this.radlike29); this.bipedHeadrad.func_78792_a(this.radlike30); this.bipedHeadrad.func_78792_a(this.radlike31); this.bipedHeadrad.func_78792_a(this.radlike32); this.bipedHeadradl.func_78792_a(this.radlik1); this.bipedHeadradl.func_78792_a(this.radlik2); this.bipedHeadradl.func_78792_a(this.radlik3); this.bipedHeadradl.func_78792_a(this.radlik4); this.bipedHeadradl.func_78792_a(this.radlik5); this.bipedHeadradl.func_78792_a(this.radlik8); this.bipedHeadradl.func_78792_a(this.radlik9); this.bipedHeadradl.func_78792_a(this.radlik10); this.bipedHeadradl.func_78792_a(this.radlik11); this.bipedHeadradl.func_78792_a(this.radlik12); this.bipedHeadradl.func_78792_a(this.radlik13); this.bipedHeadradl.func_78792_a(this.radlik14); this.bipedHeadradl.func_78792_a(this.radlik18); this.bipedHeadradl2.func_78792_a(this.radlik6); this.bipedHeadradl2.func_78792_a(this.radlik7); this.bipedHeadradl2.func_78792_a(this.radlik15); this.bipedHeadradl2.func_78792_a(this.radlike17); this.bipedHeadradl2.func_78792_a(this.radlik16); this.bipedHeadradl2.func_78792_a(this.radlik17); this.bipedHeadssj3.func_78792_a(this.bipedHeadAll); this.bipedHeadssj3.func_78792_a(this.ssjsan1); this.bipedHeadssj3.func_78792_a(this.ssjsan2); this.bipedHeadssj3.func_78792_a(this.ssjsan3); this.bipedHeadssj3.func_78792_a(this.ssjsan4); this.bipedHeadssj3.func_78792_a(this.ssjsan5); this.bipedHeadssj3.func_78792_a(this.ssjsan7); this.bipedHeadssj3.func_78792_a(this.ssjsan8); this.bipedHeadssj3.func_78792_a(this.ssjsan10); this.bipedHeadssj3.func_78792_a(this.ssjsan11); this.bipedHeadssj3.func_78792_a(this.ssjsan12); this.bipedHeadssj3.func_78792_a(this.ssjsan13); this.bipedHeadssj3.func_78792_a(this.ssjsan14); this.bipedHeadssj3.func_78792_a(this.ssjsan15); this.bipedHeadssj3.func_78792_a(this.ssjsan16); this.bipedHeadssj3.func_78792_a(this.ssjsan18); this.bipedHeadssj3.func_78792_a(this.ssjsan19); this.bipedHeadssj3.func_78792_a(this.ssjsan20); this.bipedHeadssj3.func_78792_a(this.ssjsan21); this.bipedHeadssj3.func_78792_a(this.ssjsan22); this.bipedHeadssj3.func_78792_a(this.ssjsan23); this.bipedHeadssj3.func_78792_a(this.ssjsan24); this.bipedHeadssj3.func_78792_a(this.ssjsan25); this.bipedHeadssj3.func_78792_a(this.ssjsan26); this.bipedHeadssj3.func_78792_a(this.ssjsan27); this.bipedHeadssj3.func_78792_a(this.ssjsan28); this.bipedHeadssj3.func_78792_a(this.ssjsan29); this.bipedHeadssj3.func_78792_a(this.ssjsan30); this.bipedHeadssj3.func_78792_a(this.ssjsan31); this.bipedHeadssj3.func_78792_a(this.ssjsan32); this.bipedHeadssj3l2.func_78792_a(this.long6); this.bipedHeadssj3l2.func_78792_a(this.long7); this.bipedHeadssj3l2.func_78792_a(this.long15); this.bipedHeadssj3l2.func_78792_a(this.ssjsan17); this.bipedHeadssj3l2.func_78792_a(this.long16); this.bipedHeadssj3l2.func_78792_a(this.long17); this.bipedHeadssj3l.func_78792_a(this.long1); this.bipedHeadssj3l.func_78792_a(this.long2); this.bipedHeadssj3l.func_78792_a(this.long3); this.bipedHeadssj3l.func_78792_a(this.long4); this.bipedHeadssj3l.func_78792_a(this.long5); this.bipedHeadssj3l.func_78792_a(this.long8); this.bipedHeadssj3l.func_78792_a(this.long9); this.bipedHeadssj3l.func_78792_a(this.long10); this.bipedHeadssj3l.func_78792_a(this.long11); this.bipedHeadssj3l.func_78792_a(this.long12); this.bipedHeadssj3l.func_78792_a(this.long13); this.bipedHeadssj3l.func_78792_a(this.long14); this.bipedHeadssj3l.func_78792_a(this.long18); this.bipedHeadssj3t.func_78792_a(this.tincs1); this.halo = new ModelRenderer((ModelBase)this, 32, 0); this.halo.func_78789_a(-0.0F, -0.0F, -0.0F, 0, 0, 0); this.halo.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.halo, 0.0F, 0.0F, 0.0F); this.halo1 = new ModelRenderer((ModelBase)this, 32, 0); this.halo1.func_78789_a(-4.0F, -13.0F, -5.0F, 9, 1, 1); this.halo1.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.halo1, 0.0F, 0.0F, 0.0F); this.halo2 = new ModelRenderer((ModelBase)this, 32, 0); this.halo2.func_78789_a(-5.0F, -13.0F, -5.0F, 1, 1, 9); this.halo2.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.halo2, 0.0F, 0.0F, 0.0F); this.halo3 = new ModelRenderer((ModelBase)this, 32, 0); this.halo3.func_78789_a(4.0F, -13.0F, -4.0F, 1, 1, 9); this.halo3.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.halo3, 0.0F, 0.0F, 0.0F); this.halo4 = new ModelRenderer((ModelBase)this, 32, 0); this.halo4.func_78789_a(-5.0F, -13.0F, 4.0F, 9, 1, 1); this.halo4.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.halo4, 0.0F, 0.0F, 0.0F); this.halo.func_78792_a(this.halo1); this.halo.func_78792_a(this.halo2); this.halo.func_78792_a(this.halo3); this.halo.func_78792_a(this.halo4); this.rightarm = new ModelRenderer((ModelBase)this, 40, 16); this.rightarm.func_78790_a(-3.0F, -2.0F, -2.0F, 4, 12, 4, par1 * 0.5F); this.rightarm.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.rightarm, 0.0F, 0.0F, 0.122173F); this.leftarm = new ModelRenderer((ModelBase)this, 40, 16); this.leftarm.field_78809_i = true; this.leftarm.func_78790_a(-1.0F, -2.0F, -2.0F, 4, 12, 4, par1 * 0.5F); this.leftarm.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.leftarm, 0.0F, 0.0F, -0.122173F); this.Brightarm = new ModelRenderer((ModelBase)this, 0, 0); this.Brightarm.func_78790_a(-3.0F, -2.0F, -2.0F, 0, 0, 0, par1 * 0.5F); this.Brightarm.func_78793_a(-5.0F, 2.0F, 0.0F); this.Bleftarm = new ModelRenderer((ModelBase)this, 0, 0); this.Bleftarm.field_78809_i = true; this.Bleftarm.func_78790_a(-1.0F, -2.0F, -2.0F, 0, 0, 0, par1 * 0.5F); this.Bleftarm.func_78793_a(5.0F, 2.0F, 0.0F); this.rightleg = new ModelRenderer((ModelBase)this, 0, 16); this.rightleg.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, par1 * 0.5F); this.rightleg.func_78793_a(-2.0F, 12.0F, 0.0F); setRotation(this.rightleg, 0.0F, 0.0F, 0.0F); this.leftleg = new ModelRenderer((ModelBase)this, 0, 16); this.leftleg.field_78809_i = true; this.leftleg.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, par1 * 0.5F); this.leftleg.func_78793_a(2.0F, 12.0F, 0.0F); setRotation(this.leftleg, 0.0F, 0.0F, 0.0F); this.skirt1 = new ModelRenderer((ModelBase)this, 16, 18); this.skirt1.func_78790_a(-4.0F, 9.0F, -2.0F, 8, 2, 4, par1 * 0.5F); this.skirt1.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.skirt1, 0.0F, 0.0F, 0.0F); this.skirt2 = new ModelRenderer((ModelBase)this, 16, 20); this.skirt2.func_78790_a(-4.0F, 11.0F, -2.0F, 8, 1, 4, par1 * 0.5F); this.skirt2.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.skirt2, 0.0F, 0.0F, 0.0F); this.body = new ModelRenderer((ModelBase)this, 16, 16); this.body.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 4, 4, par1 * 0.5F); this.body.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.body, 0.0F, 0.0F, 0.0F); this.hip = new ModelRenderer((ModelBase)this, 16, 23); this.hip.func_78790_a(-4.0F, 7.0F, -2.0F, 8, 2, 4, par1 * 0.5F); this.hip.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.hip, 0.0F, 0.0F, 0.0F); this.waist = new ModelRenderer((ModelBase)this, 16, 20); this.waist.func_78790_a(-4.0F, 4.0F, -2.0F, 8, 3, 4, par1 * 0.5F); this.waist.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.waist, 0.0F, 0.0F, 0.0F); this.Bbreast = new ModelRenderer((ModelBase)this, 0, 0); this.Bbreast.func_78790_a(-4.0F, 2.266667F, -1.0F, 0, 0, 0, par1 * 0.5F); this.Bbreast.func_78793_a(0.0F, 0.0F, 0.0F); this.breast = new ModelRenderer((ModelBase)this, 17, 18); this.breast.func_78790_a(-4.0F, 2.266667F, -1.0F, 8, 3, 3, par1 * 0.5F); this.breast.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.breast, -0.5235988F, 0.0F, 0.0F); this.Bbreast2 = new ModelRenderer((ModelBase)this, 0, 0); this.Bbreast2.func_78790_a(-4.0F, 2.266667F, -1.0F, 0, 0, 0, par1 * 0.5F); this.Bbreast2.func_78793_a(0.0F, 0.0F, 0.0F); this.breast2 = new ModelRenderer((ModelBase)this, 9, 23); this.breast2.field_78809_i = true; this.breast2.func_78790_a(-4.0F, 2.266667F, -2.0F, 8, 3, 3, par1 * 0.5F); this.breast2.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.breast2, 0.5235988F, 3.141593F, 0.0F); this.bottom = new ModelRenderer((ModelBase)this, 16, 25); this.bottom.func_78790_a(-4.0F, 9.0F, -2.0F, 8, 3, 4, par1 * 0.5F); this.bottom.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.bottom, 0.0F, 0.0F, 0.0F); this.Bbreast.func_78792_a(this.breast); this.Bbreast2.func_78792_a(this.breast2); this.Bleftarm.func_78792_a(this.leftarm); this.Brightarm.func_78792_a(this.rightarm); this.Nam = new ModelRenderer((ModelBase)this, 0, 0); this.Nam.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.Nam.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.near1 = new ModelRenderer((ModelBase)this, 24, -2); this.near1.func_78789_a(-3.5F, -6.0F, -4.0F, 0, 4, 2); this.near1.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.near1, -0.4014257F, 0.0F, -0.1745329F); this.near2 = new ModelRenderer((ModelBase)this, 24, -2); this.near2.func_78789_a(3.466667F, -6.0F, -4.0F, 0, 4, 2); this.near2.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.near2, -0.4014257F, 0.0F, 0.1745329F); this.ant1 = new ModelRenderer((ModelBase)this, 24, 4); this.ant1.func_78789_a(0.0F, -5.0F, -8.0F, 1, 1, 2); this.ant1.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ant1, -0.3490659F, -0.4363323F, 0.0F); this.ant2 = new ModelRenderer((ModelBase)this, 24, 4); this.ant2.func_78789_a(0.0F, -8.533334F, -6.2F, 1, 1, 2); this.ant2.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ant2, 0.2094395F, -0.4364196F, 0.0F); this.ant3 = new ModelRenderer((ModelBase)this, 24, 4); this.ant3.func_78789_a(-1.0F, -5.0F, -8.0F, 1, 1, 2); this.ant3.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ant3, -0.3490659F, 0.4363323F, 0.0F); this.ant4 = new ModelRenderer((ModelBase)this, 24, 4); this.ant4.func_78789_a(-1.0F, -8.533334F, -6.2F, 1, 1, 2); this.ant4.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ant4, 0.2094395F, 0.4364196F, 0.0F); this.Nam.func_78792_a(this.ant1); this.Nam.func_78792_a(this.ant2); this.Nam.func_78792_a(this.ant3); this.Nam.func_78792_a(this.ant4); this.Fro = new ModelRenderer((ModelBase)this, 0, 0); this.Fro.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.Fro.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.Fro0 = new ModelRenderer((ModelBase)this, 0, 0); this.Fro0.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.Fro0.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.Fro1 = new ModelRenderer((ModelBase)this, 0, 0); this.Fro1.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.Fro1.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.Fro2 = new ModelRenderer((ModelBase)this, 0, 0); this.Fro2.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.Fro2.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.Fro5 = new ModelRenderer((ModelBase)this, 0, 0); this.Fro5.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.Fro5.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.Fro5b = new ModelRenderer((ModelBase)this, 0, 0); this.Fro5b.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.Fro5b.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.Fro5r = new ModelRenderer((ModelBase)this, 0, 0); this.Fro5r.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.Fro5r.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.Fro5l = new ModelRenderer((ModelBase)this, 0, 0); this.Fro5l.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.Fro5l.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.FroB = new ModelRenderer((ModelBase)this, 0, 0); this.FroB.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 12, 0, 0.02F); this.FroB.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.appule = new ModelRenderer((ModelBase)this, 0, 16); this.appule.func_78789_a(-4.0F, -8.0F, 4.0F, 8, 8, 8); this.appule.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.appule, 0.0F, 0.0F, 0.0F); this.Fhorn2 = new ModelRenderer((ModelBase)this, 8, 6); this.Fhorn2.func_78789_a(1.5F, -11.0F, -3.5F, 2, 4, 2); this.Fhorn2.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.Fhorn2, 0.0F, 0.0F, -0.7853982F); this.Fhorn1 = new ModelRenderer((ModelBase)this, 8, 6); this.Fhorn1.func_78789_a(-3.5F, -11.0F, -3.5F, 2, 4, 2); this.Fhorn1.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.Fhorn1, 0.0F, 0.0F, 0.7853982F); this.Fhorn3 = new ModelRenderer((ModelBase)this, 8, 6); this.Fhorn3.func_78789_a(2.5F, -14.0F, -3.5F, 2, 4, 2); this.Fhorn3.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.Fhorn3, 0.0F, 0.0F, 0.2094395F); this.Fhorn4 = new ModelRenderer((ModelBase)this, 8, 6); this.Fhorn4.func_78789_a(-4.5F, -14.0F, -3.5F, 2, 4, 2); this.Fhorn4.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.Fhorn4, 0.0F, 0.0F, -0.2094395F); this.F2horn1 = new ModelRenderer((ModelBase)this, 16, 6); this.F2horn1.func_78789_a(-3.5F, -11.0F, 6.5F, 2, 4, 2); this.F2horn1.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.F2horn1, 0.0F, 0.0F, 0.7853982F); this.F2horn2 = new ModelRenderer((ModelBase)this, 16, 6); this.F2horn2.func_78789_a(1.5F, -11.0F, 6.5F, 2, 4, 2); this.F2horn2.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.F2horn2, 0.0F, 0.0F, -0.7853982F); this.ftail1 = new ModelRenderer((ModelBase)this, 32, 16); this.ftail1.func_78789_a(-2.0F, 7.0F, 4.0F, 4, 4, 12); this.ftail1.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ftail1, -0.3490659F, 0.0F, 0.0F); this.ftail2 = new ModelRenderer((ModelBase)this, 32, 16); this.ftail2.func_78789_a(-2.0F, 15.0F, 2.0F, 4, 4, 12); this.ftail2.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ftail2, 0.5235988F, 1.33E-5F, 0.0F); this.F5horn1 = new ModelRenderer((ModelBase)this, 8, 6); this.F5horn1.func_78789_a(-4.5F, -8.0F, -6.5F, 2, 6, 2); this.F5horn1.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.F5horn1, -0.6981317F, 0.0F, 1.047198F); this.F5horn2 = new ModelRenderer((ModelBase)this, 8, 6); this.F5horn2.func_78789_a(2.5F, -8.0F, -6.5F, 2, 6, 2); this.F5horn2.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.F5horn2, -0.6981317F, 0.0F, -1.047198F); this.F5horn3 = new ModelRenderer((ModelBase)this, 8, 6); this.F5horn3.func_78789_a(-0.5F, -10.0F, -8.0F, 2, 6, 2); this.F5horn3.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.F5horn3, -0.6981317F, 0.0F, 0.2094395F); this.F5horn4 = new ModelRenderer((ModelBase)this, 8, 6); this.F5horn4.func_78789_a(-1.5F, -10.0F, -8.0F, 2, 6, 2); this.F5horn4.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.F5horn4, -0.6981317F, 0.0F, -0.2094395F); this.F5horn5 = new ModelRenderer((ModelBase)this, 8, 6); this.F5horn5.func_78789_a(-2.5F, -7.0F, -7.2F, 5, 2, 2); this.F5horn5.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.F5horn5, -0.5235988F, 0.0F, 0.0F); this.F5spike1 = new ModelRenderer((ModelBase)this, 0, 6); this.F5spike1.func_78789_a(-6.0F, 1.0F, -1.0F, 1, 5, 2); this.F5spike1.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.F5spike1, 0.0F, 0.0F, -0.5235988F); this.F5spike2 = new ModelRenderer((ModelBase)this, 0, 6); this.F5spike2.func_78789_a(5.0F, 1.0F, -1.0F, 1, 5, 2); this.F5spike2.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.F5spike2, 0.0F, 0.0F, 0.5235988F); this.F5spike3 = new ModelRenderer((ModelBase)this, 8, 38); this.F5spike3.func_78789_a(2.0F, -4.0F, 3.0F, 2, 6, 2); this.F5spike3.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.F5spike3, -0.9773844F, 0.0F, 0.2094395F); this.F5spike4 = new ModelRenderer((ModelBase)this, 8, 38); this.F5spike4.func_78789_a(-4.0F, -4.0F, 3.0F, 2, 6, 2); this.F5spike4.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.F5spike4, -0.9773844F, 0.0F, -0.2094395F); this.ftailS1 = new ModelRenderer((ModelBase)this, 38, 54); this.ftailS1.func_78789_a(-2.0F, -2.0F, 0.0F, 4, 4, 6); this.ftailS1.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ftailS1, -0.5235988F, 0.0F, 0.0F); this.ftailS2 = new ModelRenderer((ModelBase)this, 38, 54); this.ftailS2.func_78789_a(-2.0F, -2.0F, 0.0F, 4, 4, 6); this.ftailS2.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ftailS2, 0.5235988F, 8.727E-4F, 0.0F); this.ftailS3 = new ModelRenderer((ModelBase)this, 38, 54); this.ftailS3.func_78789_a(-2.0F, -2.0F, 0.0F, 4, 4, 6); this.ftailS3.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ftailS3, 0.0F, 0.0F, 0.0F); this.ftailS4 = new ModelRenderer((ModelBase)this, 38, 54); this.ftailS4.func_78789_a(-2.0F, -2.0F, 0.0F, 4, 4, 6); this.ftailS4.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ftailS4, 0.0F, 0.0F, 0.0F); this.ftailS5 = new ModelRenderer((ModelBase)this, 38, 54); this.ftailS5.func_78789_a(-2.0F, -2.0F, 0.0F, 4, 4, 6); this.ftailS5.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ftailS5, 0.0F, 0.0F, 0.0F); this.ftailS6 = new ModelRenderer((ModelBase)this, 38, 54); this.ftailS6.func_78789_a(-2.0F, -2.0F, 0.0F, 4, 4, 6); this.ftailS6.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ftailS6, 0.0F, 0.0F, 0.0F); this.ftailS5.func_78792_a(this.ftailS6); this.ftailS4.func_78792_a(this.ftailS5); this.ftailS3.func_78792_a(this.ftailS4); this.ftailS2.func_78792_a(this.ftailS3); this.ftailS1.func_78792_a(this.ftailS2); this.FroB.func_78792_a(this.ftailS1); this.FroB.field_78800_c = 2.0F; this.FroB.field_78797_d = 10.0F; this.FroB.field_78798_e = 2.0F; this.ftailS1.field_78800_c = -2.0F; this.ftailS1.field_78797_d = -2.0F; this.ftailS1.field_78798_e = 0.0F; this.ftailS2.field_78800_c = 0.0F; this.ftailS2.field_78797_d = 0.0F; this.ftailS2.field_78798_e = 5.0F; this.ftailS3.field_78800_c = 0.0F; this.ftailS3.field_78797_d = 0.0F; this.ftailS3.field_78798_e = 5.0F; this.ftailS4.field_78800_c = 0.0F; this.ftailS4.field_78797_d = 0.0F; this.ftailS4.field_78798_e = 5.0F; this.ftailS5.field_78800_c = 0.0F; this.ftailS5.field_78797_d = 0.0F; this.ftailS5.field_78798_e = 5.0F; this.ftailS6.field_78800_c = 0.0F; this.ftailS6.field_78797_d = 0.0F; this.ftailS6.field_78798_e = 5.0F; this.fear1 = new ModelRenderer((ModelBase)this, 12, 0); this.fear1.func_78789_a(-5.0F, -5.0F, -3.0F, 1, 3, 2); this.fear1.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.fear1, -0.4014257F, 0.0F, 0.0F); this.fear2 = new ModelRenderer((ModelBase)this, 12, 0); this.fear2.field_78809_i = true; this.fear2.func_78789_a(4.0F, -5.0F, -3.0F, 1, 3, 2); this.fear2.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.fear2, -0.4014257F, 0.0F, 0.0F); this.rightarmshoulder = new ModelRenderer((ModelBase)this, 38, 0); this.rightarmshoulder.func_78789_a(-6.0F, -3.0F, -3.0F, 7, 4, 6); this.rightarmshoulder.func_78793_a(-5.0F, 2.0F, 0.0F); this.rightarmshoulder.func_78787_b(128, 64); this.leftarmshoulder = new ModelRenderer((ModelBase)this, 38, 0); this.leftarmshoulder.field_78809_i = true; this.leftarmshoulder.func_78789_a(-1.0F, -3.0F, -3.0F, 7, 4, 6); this.leftarmshoulder.func_78793_a(5.0F, 2.0F, 0.0F); this.leftarmshoulder.func_78787_b(128, 64); this.Fro0.func_78792_a(this.Fhorn2); this.Fro0.func_78792_a(this.Fhorn1); this.Fro1.func_78792_a(this.Fhorn3); this.Fro1.func_78792_a(this.Fhorn4); this.Fro2.func_78792_a(this.appule); this.Fro2.func_78792_a(this.F2horn1); this.Fro2.func_78792_a(this.F2horn2); this.Fro.func_78792_a(this.fear1); this.Fro.func_78792_a(this.fear2); this.Fro5.func_78792_a(this.F5horn1); this.Fro5.func_78792_a(this.F5horn2); this.Fro5.func_78792_a(this.F5horn3); this.Fro5.func_78792_a(this.F5horn4); this.Fro5.func_78792_a(this.F5horn5); this.Fro5r.func_78792_a(this.F5spike1); this.Fro5l.func_78792_a(this.F5spike2); this.Fro5b.func_78792_a(this.F5spike3); this.Fro5b.func_78792_a(this.F5spike4); this.SaiO = new ModelRenderer((ModelBase)this, 0, 0); this.SaiO.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.SaiO.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.SaiOmouth = new ModelRenderer((ModelBase)this, 0, 8); this.SaiOmouth.func_78789_a(-2.0F, -3.0F, -8.0F, 4, 3, 4); this.SaiOmouth.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.SaiOmouth, 0.0F, 0.0F, 0.0F); this.SaiO.func_78792_a(this.SaiOmouth); this.SaiE = new ModelRenderer((ModelBase)this, 0, 0); this.SaiE.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.SaiE.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.kao = new ModelRenderer((ModelBase)this, 0, 0); this.kao.func_78789_a(-4.0F, -8.0F, -4.005F, 8, 8, 0); this.kao.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.kao, 0.0F, 0.0F, 0.0F); this.SaiE.func_78792_a(this.kao); this.face1 = new ModelRenderer((ModelBase)this, 0, 0); this.face1.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.face1.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.nose = new ModelRenderer((ModelBase)this, 0, 0); this.nose.func_78789_a(-4.0F, -8.0F, -4.006F, 8, 8, 0); this.nose.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.nose, 0.0F, 0.0F, 0.0F); this.face1.func_78792_a(this.nose); this.face2 = new ModelRenderer((ModelBase)this, 0, 0); this.face2.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.face2.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.mouth = new ModelRenderer((ModelBase)this, 0, 0); this.mouth.func_78789_a(-4.0F, -8.0F, -4.007F, 8, 8, 0); this.mouth.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.mouth, 0.0F, 0.0F, 0.0F); this.face2.func_78792_a(this.mouth); this.face5 = new ModelRenderer((ModelBase)this, 0, 0); this.face5.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.face5.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.eyeb = new ModelRenderer((ModelBase)this, 0, 0); this.eyeb.func_78789_a(-4.0F, -8.0F, -4.008F, 8, 8, 0); this.eyeb.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.eyeb, 0.0F, 0.0F, 0.0F); this.face5.func_78792_a(this.eyeb); this.face3 = new ModelRenderer((ModelBase)this, 0, 0); this.face3.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.face3.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.eyel = new ModelRenderer((ModelBase)this, 0, 0); this.eyel.func_78789_a(-4.0F, -8.0F, -4.009F, 8, 8, 0); this.eyel.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.eyel, 0.0F, 0.0F, 0.0F); this.face3.func_78792_a(this.eyel); this.face4 = new ModelRenderer((ModelBase)this, 0, 0); this.face4.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.face4.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.eyer = new ModelRenderer((ModelBase)this, 0, 0); this.eyer.func_78789_a(-4.0F, -8.0F, -4.01F, 8, 8, 0); this.eyer.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.eyer, 0.0F, 0.0F, 0.0F); this.face4.func_78792_a(this.eyer); this.face6 = new ModelRenderer((ModelBase)this, 0, 0); this.face6.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.face6.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.eyew = new ModelRenderer((ModelBase)this, 0, 0); this.eyew.func_78789_a(-4.0F, -8.0F, -4.01F, 8, 8, 0); this.eyew.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.eyew, 0.0F, 0.0F, 0.0F); this.face6.func_78792_a(this.eyew); this.SaiT1 = new ModelRenderer((ModelBase)this, 0, 0); this.SaiT1.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.SaiT1.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.SaiT2 = new ModelRenderer((ModelBase)this, 0, 0); this.SaiT2.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.SaiT2.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.tail1 = new ModelRenderer((ModelBase)this, 32, 48); this.tail1.func_78789_a(-1.0F, -1.0F, 0.0F, 2, 2, 4); this.tail1.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.tail1, -0.5235988F, 0.0F, 0.0F); this.tail2 = new ModelRenderer((ModelBase)this, 32, 48); this.tail2.func_78789_a(-1.0F, -1.0F, 0.0F, 2, 2, 4); this.tail2.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.tail2, 0.5235988F, 8.727E-4F, 0.0F); this.tailS3 = new ModelRenderer((ModelBase)this, 32, 48); this.tailS3.func_78789_a(-1.0F, -1.0F, 0.0F, 2, 2, 4); this.tailS3.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.tailS3, 0.0F, 0.0F, 0.0F); this.tailS4 = new ModelRenderer((ModelBase)this, 32, 48); this.tailS4.func_78789_a(-1.0F, -1.0F, 0.0F, 2, 2, 4); this.tailS4.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.tailS4, 0.0F, 0.0F, 0.0F); this.tailS5 = new ModelRenderer((ModelBase)this, 32, 48); this.tailS5.func_78789_a(-1.0F, -1.0F, 0.0F, 2, 2, 4); this.tailS5.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.tailS5, 0.0F, 0.0F, 0.0F); this.tailS6 = new ModelRenderer((ModelBase)this, 32, 48); this.tailS6.func_78789_a(-1.0F, -1.0F, 0.0F, 2, 2, 4); this.tailS6.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.tailS6, 0.0F, 0.0F, 0.0F); this.tail3 = new ModelRenderer((ModelBase)this, 32, 48); this.tail3.func_78789_a(3.5F, 8.0F, -2.5F, 1, 2, 5); this.tail3.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.tail3, 0.0F, 0.0F, 0.0F); this.tail4 = new ModelRenderer((ModelBase)this, 32, 48); this.tail4.func_78789_a(-4.433333F, 8.0F, -2.5F, 1, 2, 5); this.tail4.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.tail4, 0.0F, 0.0F, 0.0F); this.tail5 = new ModelRenderer((ModelBase)this, 32, 48); this.tail5.func_78789_a(-3.433333F, 8.0F, 1.5F, 7, 2, 1); this.tail5.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.tail5, 0.0F, 0.0F, 0.0F); this.tail6 = new ModelRenderer((ModelBase)this, 32, 48); this.tail6.func_78789_a(-3.433333F, 8.0F, -2.5F, 7, 2, 1); this.tail6.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.tail6, 0.0F, 0.0F, 0.0F); this.tailS5.func_78792_a(this.tailS6); this.tailS4.func_78792_a(this.tailS5); this.tailS3.func_78792_a(this.tailS4); this.tail2.func_78792_a(this.tailS3); this.tail1.func_78792_a(this.tail2); this.SaiT1.func_78792_a(this.tail1); this.SaiT2.func_78792_a(this.tail3); this.SaiT2.func_78792_a(this.tail4); this.SaiT2.func_78792_a(this.tail5); this.SaiT2.func_78792_a(this.tail6); this.SaiT1.field_78800_c = 1.0F; this.SaiT1.field_78797_d = 10.0F; this.SaiT1.field_78798_e = 2.0F; this.tail1.field_78800_c = -1.0F; this.tail1.field_78797_d = -1.0F; this.tail1.field_78798_e = 0.0F; this.tail2.field_78800_c = 0.0F; this.tail2.field_78797_d = 0.0F; this.tail2.field_78798_e = 4.0F; this.tailS3.field_78800_c = 0.0F; this.tailS3.field_78797_d = 0.0F; this.tailS3.field_78798_e = 4.0F; this.tailS4.field_78800_c = 0.0F; this.tailS4.field_78797_d = 0.0F; this.tailS4.field_78798_e = 4.0F; this.tailS5.field_78800_c = 0.0F; this.tailS5.field_78797_d = 0.0F; this.tailS5.field_78798_e = 4.0F; this.tailS6.field_78800_c = 0.0F; this.tailS6.field_78797_d = 0.0F; this.tailS6.field_78798_e = 4.0F; this.WShell = new ModelRenderer((ModelBase)this, 0, 0); this.WShell.func_78789_a(-5.0F, -1.0F, 2.0F, 10, 12, 4); this.WShell.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.WShell, 0.0F, 0.0F, 0.0F); this.WRightarm = new ModelRenderer((ModelBase)this, 40, 0); this.WRightarm.func_78789_a(-4.0F, 5.0F, -3.0F, 6, 3, 6); this.WRightarm.func_78793_a(-5.0F, 2.0F, 0.0F); setRotation(this.WRightarm, 0.0F, 0.0F, 0.0F); this.WLeftarm = new ModelRenderer((ModelBase)this, 40, 9); this.WLeftarm.func_78789_a(-2.0F, 5.0F, -3.0F, 6, 3, 6); this.WLeftarm.func_78793_a(5.0F, 2.0F, 0.0F); setRotation(this.WLeftarm, 0.0F, 0.0F, 0.0F); this.WRightleg = new ModelRenderer((ModelBase)this, 0, 0); this.WRightleg.func_78789_a(-3.0F, 6.0F, -3.0F, 6, 4, 6); this.WRightleg.func_78793_a(-2.0F, 12.0F, 0.0F); setRotation(this.WRightleg, 0.0F, 0.0F, 0.0F); this.WLeftleg = new ModelRenderer((ModelBase)this, 0, 10); this.WLeftleg.func_78789_a(-3.0F, 6.0F, -3.0F, 6, 4, 6); this.WLeftleg.func_78793_a(2.0F, 12.0F, 0.0F); setRotation(this.WLeftleg, 0.0F, 0.0F, 0.0F); if (this.hairall == null) { this.hairall = new ModelRendererJBRA[224]; int hossz; for (hossz = 0; hossz < 4; hossz++) { for (int face = 0; face < 56; face++) { if (this.hairall[hossz + face * 4] == null) { this.hairall[hossz + face * 4] = new ModelRendererJBRA((ModelBase)this, 32, 0); this.hairall[hossz + face * 4].addBox(-1.0F, (hossz == 0) ? -1.0F : 0.0F, -1.0F, 2, 3, 2); this.hairall[hossz + face * 4].setRotationPoint(0.0F, 0.0F, 0.0F); setRotation(this.hairall[hossz + face * 4], 0.0F, 0.0F, 0.0F); }  }  }  for (hossz = 0; hossz < 4; hossz++) { for (int face = 0; face < 56; face++) { if (hossz != 3) this.hairall[hossz + face * 4].addChild(this.hairall[hossz + 1 + face * 4]);  }  }  }  }
/* 3783 */   private void setRotation(ModelRenderer model, float x, float y, float z) { model.field_78795_f = x; model.field_78796_g = y; model.field_78808_h = z; } private void setRotation(ModelRendererJBRA model, float x, float y, float z) { model.rotateAngleX = x; model.rotateAngleY = y; model.rotateAngleZ = z; } private void transRot(float f5, ModelRenderer m) { GL11.glTranslatef(m.field_78800_c * f5, m.field_78797_d * f5, m.field_78798_e * f5); if (m.field_78808_h != 0.0F) GL11.glRotatef(m.field_78808_h * 57.295776F, 0.0F, 0.0F, 1.0F);  if (m.field_78796_g != 0.0F) GL11.glRotatef(m.field_78796_g * 57.295776F, 0.0F, 1.0F, 0.0F);  if (m.field_78795_f != 0.0F) GL11.glRotatef(m.field_78795_f * 57.295776F, 1.0F, 0.0F, 0.0F);  } public static String saO(String s1, int s2) { return s1.charAt(s2) + ""; } public static int sa(String s1, int s2) { try { return Integer.parseInt(saO(s1, s2)); } catch (NumberFormatException e) { return 0; }  } public static int sa2(String s1, int s2) { try { return Integer.parseInt(saO(s1, s2) + saO(s1, s2 + 1)); } catch (NumberFormatException e) { return 0; }  } public void renderHairs(float par1, String hair) { renderHairs(par1, hair, ""); }
/*      */   public static int dnsHair1(String s, int n) { return (s.length() > n) ? sa(s, n) : 0; }
/*      */   public static int dnsHair2(String s, int n) { return (s.length() > n) ? sa2(s, n) : 0; }
/* 3786 */   public static String dnsHair1set(String s, int n, String w) { return (s.length() > n) ? (s.substring(0, n) + w + s.substring(n + 1)) : ""; } public static String dnsHair2set(String s, int n, String w) { return (s.length() > n) ? (s.substring(0, n) + w + s.substring(n + 2)) : ""; } public void renderHairsV2(float par1, String h, float hl, int s, int rg, int pl, int rc, RenderPlayerJBRA rp) { renderHairsV2(par1, h, hl, s, rg, pl, rc, rp, (AbstractClientPlayer)null); } public void renderHairsV2(float par1, String h, float hl, int s, int rg, int pl, int rc, RenderPlayerJBRA rp, AbstractClientPlayer abstractClientPlayer) { String playerName = JRMCoreH.plyrs[pl]; boolean canUse = mod_JBRA.a6P9H9B; boolean pstrty = JRMCoreH.plyrSttngsClient(1, pl); boolean aura = JRMCoreH.StusEfctsClient(4, pl); boolean trbo = JRMCoreH.StusEfctsClient(3, pl); boolean kken = JRMCoreH.StusEfctsClient(5, pl); boolean trty = JRMCoreH.StusEfctsClient(1, pl); int trTime = canUse ? 2 : 200; int arTime = canUse ? 2 : 200; if (rc == 1 || rc == 2) { if (JRMCoreH.HairsT(s, "B") && rp.getStateChange(playerName) < 200) rp.setStateChange(rp.getStateChange(playerName) + trTime, playerName);  if (JRMCoreH.HairsT(s, "C")) { if (rp.getStateChange(playerName) < 200) rp.setStateChange(rp.getStateChange(playerName) + trTime, playerName);  if (rp.getState2Change(playerName) < 200) rp.setState2Change(rp.getState2Change(playerName) + trTime, playerName);  }  if (JRMCoreH.HairsT(rp.getState(playerName), "A") && !JRMCoreH.HairsT(s, "A")) { if (!JRMCoreH.HairsT(rp.getState(playerName), s) && rp.getStateChange(playerName) < 200) rp.setStateChange(rp.getStateChange(playerName) + trTime, playerName);  if (rp.getStateChange(playerName) >= 200) { rp.setStateChange(200, playerName); rp.setState(s, playerName); }  } else if (!JRMCoreH.HairsT(rp.getState(playerName), "A") && JRMCoreH.HairsT(s, "A")) { if ((!JRMCoreH.HairsT(rp.getState(playerName), s) || rg == 0) && rp.getStateChange(playerName) > 0) rp.setStateChange(rp.getStateChange(playerName) - trTime, playerName);  if (rp.getStateChange(playerName) <= 0) { rp.setStateChange(0, playerName); rp.setState(s, playerName); }  } else if (!JRMCoreH.HairsT(rp.getState(playerName), s) && JRMCoreH.HairsT(rp.getState(playerName), "B") && JRMCoreH.HairsT(s, "B")) { rp.setState(s, playerName); } else if (JRMCoreH.HairsT(rp.getState(playerName), "A")) { if (!canUse && JRMCoreH.HairsT(rp.getState(playerName), s) && rg > 90) { rp.setStateChange(rp.getStateChange(playerName) + trTime, playerName); if (rp.getStateChange(playerName) > 200) rp.setStateChange(200, playerName);  } else if (canUse && JRMCoreH.HairsT(rp.getState(playerName), s) && rg > 0 && rp.getStateChange(playerName) < rg * 2) { rp.setStateChange(rp.getStateChange(playerName) + trTime, playerName); } else if (JRMCoreH.HairsT(rp.getState(playerName), s)) { if (rp.getStateChange(playerName) > 0) { rp.setStateChange(rp.getStateChange(playerName) - trTime, playerName); } else { rp.setStateChange(0, playerName); }  if (rp.getState2Change(playerName) > 0) { rp.setState2Change(rp.getState2Change(playerName) - trTime, playerName); } else { rp.setState2Change(0, playerName); }  }  } else if ((JRMCoreH.HairsT(s, "B") && pstrty) || JRMCoreH.HairsT(s, "B")) { if (!canUse && JRMCoreH.HairsT(rp.getState(playerName), s) && rg > 90) { rp.setState2Change(rp.getState2Change(playerName) + trTime, playerName); if (rp.getState2Change(playerName) > 200) rp.setState2Change(200, playerName);  } else if (canUse && JRMCoreH.HairsT(rp.getState(playerName), s) && rg > 0 && rp.getState2Change(playerName) < rg * 2) { rp.setState2Change(rp.getState2Change(playerName) + trTime, playerName); } else if (rp.getState2Change(playerName) > 200) { rp.setState2Change(200, playerName); rp.setState(s, playerName); } else if (rp.getState2Change(playerName) > 0) { rp.setState2Change(rp.getState2Change(playerName) - trTime, playerName); } else if (rp.getState2Change(playerName) != 0) { rp.setState2Change(0, playerName); }  } else if (!JRMCoreH.HairsT(rp.getState(playerName), s) && JRMCoreH.HairsT(s, "C")) { if (rp.getState2Change(playerName) < 200) rp.setState2Change(rp.getState2Change(playerName) + trTime, playerName);  if (rp.getState2Change(playerName) >= 200) { rp.setState2Change(200, playerName); rp.setState(s, playerName); }  }  }  if (canUse && (aura || trty || kken || trbo)) { if (JRMCoreH.HairsT(rp.getState(playerName), s) && rp.getAuratime(playerName) < 50) { if (rp.getAuratime(playerName) < 50 && rp.getAuratype(playerName) == 0) rp.setAuratime(rp.getAuratime(playerName) + arTime, playerName);  if (rp.getAuratime(playerName) >= 50) rp.setAuratype(1, playerName);  if (rp.getAuratime(playerName) < 20 && rp.getAuratype(playerName) == 1) rp.setAuratype(0, playerName);  if (rp.getAuratime(playerName) > 0 && rp.getAuratype(playerName) == 1) rp.setAuratime(rp.getAuratime(playerName) - arTime, playerName);  } else if (JRMCoreH.HairsT(rp.getState(playerName), s) && !JRMCoreH.HairsT(s, "A")) { if (rp.getAuratype(playerName) < 2) rp.setAuratype(2, playerName);  if (rp.getBendtime(playerName) < 50 && rp.getAuratype(playerName) == 2) rp.setBendtime(rp.getBendtime(playerName) + arTime, playerName);  if (rp.getBendtime(playerName) >= 50) rp.setAuratype(3, playerName);  if (rp.getBendtime(playerName) < 20 && rp.getAuratype(playerName) == 3) rp.setAuratype(2, playerName);  if (rp.getBendtime(playerName) > 0 && rp.getAuratype(playerName) == 3) rp.setBendtime(rp.getBendtime(playerName) - arTime, playerName);  }  } else { if (rp.getAuratype(playerName) > 0) rp.setAuratype(0, playerName);  if (rp.getBendtime(playerName) > 0) rp.setBendtime(rp.getBendtime(playerName) - 1, playerName);  if (rp.getAuratime(playerName) > 0) rp.setAuratime(rp.getAuratime(playerName) - 1, playerName);  }  GL11.glPushMatrix(); GL11.glScalef((0.5F + 0.5F / ModelBipedDBC.f) * ((g <= 1) ? 1.0F : 0.85F), 0.5F + 0.5F / ModelBipedDBC.f, (0.5F + 0.5F / ModelBipedDBC.f) * ((g <= 1) ? 1.0F : 0.85F)); GL11.glTranslatef(0.0F, (ModelBipedDBC.f - 1.0F) / ModelBipedDBC.f * (2.0F - ((ModelBipedDBC.f >= 1.5F && ModelBipedDBC.f <= 2.0F) ? ((2.0F - ModelBipedDBC.f) / 2.5F) : ((ModelBipedDBC.f < 1.5F && ModelBipedDBC.f >= 1.0F) ? ((ModelBipedDBC.f * 2.0F - 2.0F) * 0.2F) : 0.0F))), 0.0F); float[] front = { 0.6F, 0.5F, 0.4F, -0.5F }; float[] front2 = { 0.0F, 0.0F, 0.0F, 0.0F }; int[] hairRightPosZ = { 3, 2, 1, 0, 3, 2, 1, 3, 2, 3 }; int[] hairRightPosY = { 0, 0, 0, 0, 1, 1, 1, 2, 2, 3 }; int[] hairLeftPosZ = { 0, 1, 2, 3, 1, 2, 3, 2, 3, 3 }; int[] hairLeftPosY = { 0, 0, 0, 0, 1, 1, 1, 2, 2, 3 }; int[] hairBackPosX = { 0, 1, 2, 3, 0, 1, 2, 3, 0, 1, 2, 3, 0, 1, 2, 3 }; int[] hairBackPosY = { 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3 }; int[] hairTopPosX = { 0, 1, 2, 3, 0, 1, 2, 3, 0, 1, 2, 3, 0, 1, 2, 3 }; int[] hairTopPosZ = { 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3 }; int[] hairPos = { 0, 4, 14, 24, 40, 56 }; String hairdns = h; for (int face = 0; face < 56; face++) { int l = dnsHair2(hairdns, face * 14); if (l != 0) { int X = dnsHair2(hairdns, face * 14 + 2); int Y = dnsHair2(hairdns, face * 14 + 4); int Z = dnsHair2(hairdns, face * 14 + 6); int B = dnsHair2(hairdns, face * 14 + 8); int P = dnsHair2(hairdns, face * 14 + 10); int T = dnsHair2(hairdns, face * 14 + 12); X = (X > 82) ? 82 : ((X < 18) ? 18 : X); Y = (Y > 82) ? 82 : ((Y < 18) ? 18 : Y); Z = (Z > 82) ? 82 : ((Z < 18) ? 18 : Z); B = (B > 82) ? 82 : ((B < 18) ? 18 : B); P = (P > 82) ? 82 : ((P < 18) ? 18 : P); T = (T > 82) ? 82 : ((T < 18) ? 18 : T); float x = (X - 50) * 0.1F; float y = (Y - 50) * 0.1F; float z = (Z - 50) * 0.1F; float b = (B - 50) * 0.1F; float p = (P - 50) * 0.1F; int t = (int)((T - 18) * 1.62F); float Int = t * 0.01F; float pb = b; boolean hpFront = (face >= hairPos[0] && face < hairPos[1]); boolean hpTop = (face >= hairPos[4] && face < hairPos[5]); boolean hpRight = (face >= hairPos[1] && face < hairPos[2]); boolean hpLeft = (face >= hairPos[2] && face < hairPos[3]); boolean hpBack = (face >= hairPos[3] && face < hairPos[4]); if (rp.getStateChange(playerName) > 0 && l > 0) { if (y > -1.0F && y < 1.0F && z > -1.0F && z < 1.0F && hpBack) { x += rp.getStateChange(playerName) * Int * ((x < 0.0F) ? -0.01F : 0.01F) * l * 0.01F; x = (x > 3.0F) ? 3.0F : x; x = (x < -3.0F) ? -3.0F : x; }  if (y > -1.0F && y < 1.0F && x > -1.0F && x < 1.0F && !hpBack) { z += rp.getStateChange(playerName) * Int * ((z < 0.0F) ? -0.01F : 0.01F); z = (z > 3.2F) ? 3.2F : z; z = (z < -3.2F) ? -3.2F : z; if (!hpFront || x < 0.0F) { x += rp.getStateChange(playerName) * Int * 0.01F; x = (x > 0.4F) ? 0.4F : x; x = (x < -0.4F) ? -0.4F : x; }  if (z > 0.0F) { boolean add = hpTop ? ((hairTopPosZ[face - hairPos[4]] == 0 || hairTopPosZ[face - hairPos[4]] == 2)) : false; boolean add2 = hpTop ? ((face % 4 == 0 || face % 4 == 3)) : false; b += rp.getStateChange(playerName) * Int * -0.02F; b = (b < ((add && add2) ? 0.0F : -0.2F)) ? ((add && add2) ? 0.0F : -0.2F) : b; } else if (z < 0.0F) { boolean add = hpTop ? ((hairTopPosZ[face - hairPos[4]] == 0 || hairTopPosZ[face - hairPos[4]] == 2)) : false; boolean add2 = hpTop ? ((face % 4 == 0 || face % 4 == 3)) : false; b += rp.getStateChange(playerName) * Int * 0.02F; b = (b > ((add && add2) ? 0.0F : 0.2F)) ? ((add && add2) ? 0.0F : 0.2F) : b; }  } else if (y > -1.0F && y < 1.0F) { x += rp.getStateChange(playerName) * Int * ((x < 0.0F) ? -0.01F : 0.01F); x = (x > 2.8F) ? 2.8F : x; x = (x < -2.8F) ? -2.8F : x; if (b > 1.5F) { x = (x > 1.5F) ? 1.5F : x; x = (x < -1.5F) ? -1.5F : x; b += rp.getStateChange(playerName) * Int * ((b < 0.0F) ? 0.03F : -0.03F); b = (b > 2.8F) ? 2.8F : b; b = (b < -2.8F) ? -2.8F : b; }  } else if (x > -1.0F && x < 1.0F) { z += rp.getStateChange(playerName) * Int * ((z < 0.0F) ? -0.01F : 0.01F); z = (z > 2.8F) ? 2.8F : z; z = (z < -2.8F) ? -2.8F : z; if (b > 0.0F && z > 0.0F && y < 1.6F) { z = (z > 2.2F) ? 2.2F : z; z = (z < -2.2F) ? -2.2F : z; b += rp.getStateChange(playerName) * Int * -0.02F; b = (b > pb) ? pb : b; b = (b < -pb) ? -pb : b; } else if (b > 0.0F && z < 0.0F && y > 0.0F) { z = (z > 2.2F) ? 2.2F : z; z = (z < -2.2F) ? -2.2F : z; b += rp.getStateChange(playerName) * Int * -0.02F; b = (b > pb) ? pb : b; b = (b < -pb) ? -pb : b; } else if (y < -1.3F && b > 0.0F) { z = (z > 2.2F) ? 2.2F : z; z = (z < -2.2F) ? -2.2F : z; b += rp.getStateChange(playerName) * Int * -0.02F; b = (b < 0.5F) ? 0.5F : b; }  }  }  if (rp.getState2Change(playerName) > 0) { if (y > -1.0F && y < 1.0F && x > -1.0F && x < 1.0F && hpFront) { float Int2 = (Int > 0.02F) ? 0.6F : Int; x += rp.getState2Change(playerName) * Int2 * 0.01F; x = (x > 0.2F) ? 0.2F : x; x = (x < -0.2F) ? -0.2F : x; z += rp.getState2Change(playerName) * Int2 * ((z < 0.0F) ? -0.02F : 0.02F); z = (z > 2.8F) ? 2.8F : z; z = (z < -2.8F) ? -2.8F : z; }  l = (int)(l + rp.getState2Change(playerName) * 0.1F); if (b < 0.0F) { b += rp.getState2Change(playerName) * 5.0E-4F; b = (b >= 0.0F) ? 0.2F : b; }  if (b > 0.0F) { b += rp.getState2Change(playerName) * -5.0E-4F; b = (b <= 0.0F) ? -0.2F : b; }  }  if (rp.getBendtime(playerName) > 0) { z += rp.getBendtime(playerName) * ((z < 0.0F) ? -0.0025F : 0.0025F); b += rp.getBendtime(playerName) * ((b > 0.0F) ? -0.005F : 0.005F); z = (z > 3.2F) ? 3.2F : z; z = (z < -3.2F) ? -3.2F : z; }  if (rp.getAuratime(playerName) > 0) { z += rp.getAuratime(playerName) * ((z < 0.0F) ? -0.0025F : 0.0025F); b += rp.getAuratime(playerName) * ((b > 0.0F) ? -0.005F : 0.005F); z = (z > 3.2F) ? 3.2F : z; z = (z < -3.2F) ? -3.2F : z; }  int lng = 0; if (!JRMCoreClient.mc.func_147113_T()) { setRotation(this.hairall[lng + face * 4], x, y, z); (this.hairall[lng + face * 4]).rotationPointX = -2.999F + ((face < 4) ? (face * 2) : ((face >= 14 && face < 24) ? 7 : ((face >= 24 && face < 40) ? (hairBackPosX[face - 4 - 10 - 10] * 2) : ((face >= 40 && face < 56) ? (hairTopPosX[face - 4 - 10 - 10 - 16] * 2) : -1)))); (this.hairall[lng + face * 4]).rotationPointZ = -3.999F + ((face >= 4 && face < 14) ? (hairRightPosZ[face - 4] * 2 + 1) : ((face >= 14 && face < 24) ? (hairLeftPosZ[face - 4 - 10] * 2 + 1) : ((face >= 24 && face < 40) ? 8.0F : ((face >= 40 && face < 56) ? ((hairTopPosZ[face - 4 - 10 - 10 - 16] * 2) + 0.9F) : 0.0F)))); (this.hairall[lng + face * 4]).rotationPointY = -7.0F + ((face >= 4 && face < 14) ? (hairRightPosY[face - 4] * 2) : ((face >= 14 && face < 24) ? (hairLeftPosY[face - 4 - 10] * 2) : ((face >= 24 && face < 40) ? (hairBackPosY[face - 4 - 10 - 10] * 2) : -0.5F))); float f = 1.57F; float r = MathHelper.func_76126_a(this.rot3 * 0.02F) * 0.1F; float r2 = MathHelper.func_76134_b(this.rot3 * 0.02F) * 0.1F; float r3 = MathHelper.func_76134_b(this.rot3 * 0.14F) * 0.1F; (this.hairall[1 + face * 4]).rotateAngleY = 0.0F; (this.hairall[1 + face * 4]).rotateAngleX = -0.0F; (this.hairall[2 + face * 4]).rotateAngleY = 0.0F; (this.hairall[2 + face * 4]).rotateAngleX = 0.0F; (this.hairall[3 + face * 4]).rotateAngleY = 0.0F; (this.hairall[3 + face * 4]).rotateAngleX = 0.0F; if (hpTop || hpRight || hpLeft) { int min = hpLeft ? 1 : -1; (this.hairall[1 + face * 4]).rotateAngleZ = min * b * 0.3F * ((p > 0.5F) ? (1.0F - p * 0.3F) : ((p < -0.5F) ? (1.0F + -p * 0.1F) : 1.0F)); (this.hairall[2 + face * 4]).rotateAngleZ = min * b * 0.3F; (this.hairall[3 + face * 4]).rotateAngleZ = min * b * 0.3F * ((p > 0.5F) ? (1.0F + p * 0.1F) : ((p < -0.5F) ? (1.0F - -p * 0.3F) : 1.0F)); } else { (this.hairall[1 + face * 4]).rotateAngleX = b * 0.3F * ((p > 0.5F) ? (1.0F - p * 0.3F) : ((p < -0.5F) ? (1.0F + -p * 0.1F) : 1.0F)); (this.hairall[2 + face * 4]).rotateAngleX = b * 0.3F; (this.hairall[3 + face * 4]).rotateAngleX = b * 0.3F * ((p > 0.5F) ? (1.0F + p * 0.1F) : ((p < -0.5F) ? (1.0F - -p * 0.3F) : 1.0F)); }  }  (this.hairall[1 + face * 4]).rotationPointX = 0.0F; (this.hairall[1 + face * 4]).rotationPointZ = 0.0F; (this.hairall[1 + face * 4]).rotationPointY = 1.5F; (this.hairall[2 + face * 4]).rotationPointX = 0.0F; (this.hairall[2 + face * 4]).rotationPointZ = 0.0F; (this.hairall[2 + face * 4]).rotationPointY = 2.5F; (this.hairall[3 + face * 4]).rotationPointX = 0.0F; (this.hairall[3 + face * 4]).rotationPointZ = 0.0F; (this.hairall[3 + face * 4]).rotationPointY = 2.5F; GL11.glPushMatrix(); GL11.glTranslatef(this.field_78116_c.field_78800_c * par1, this.field_78116_c.field_78797_d * par1, this.field_78116_c.field_78798_e * par1); if (this.field_78116_c.field_78808_h != 0.0F) GL11.glRotatef(this.field_78116_c.field_78808_h * 57.295776F, 0.0F, 0.0F, 1.0F);  if (this.field_78116_c.field_78796_g != 0.0F) GL11.glRotatef(this.field_78116_c.field_78796_g * 57.295776F, 0.0F, 1.0F, 0.0F);  if (this.field_78116_c.field_78795_f != 0.0F) GL11.glRotatef(this.field_78116_c.field_78795_f * 57.295776F, 1.0F, 0.0F, 0.0F);  GL11.glPushMatrix(); float[] TypL1 = { 4.0F, 2.0F, 1.5F, 1.0F, 1.0F }; boolean[] TypS1 = { false, true, true, true, true }; boolean[] TypS2 = { false, false, true, true, true }; boolean[] TypS3 = { false, false, false, true, true }; float tincs1 = (l < 33.0F) ? (l / 33.0F) : 1.0F; float tincs2 = (l > 33.0F && l < 66.0F) ? ((l - 33.0F) / 33.0F) : ((l < 33.0F) ? 0.0F : 1.0F); float tincs3 = (l > 66.0F) ? ((l - 66.0F) / 33.0F) : ((l < 66.0F) ? 0.0F : 1.0F); (this.hairall[lng + face * 4]).lengthY = 1.0F; (this.hairall[1 + face * 4]).lengthY = tincs1; (this.hairall[2 + face * 4]).lengthY = tincs2; (this.hairall[3 + face * 4]).lengthY = tincs3; (this.hairall[0 + face * 4]).sizeXZ = 1.1F; (this.hairall[1 + face * 4]).sizeXZ = 1.0F; (this.hairall[2 + face * 4]).sizeXZ = 0.9F; (this.hairall[3 + face * 4]).sizeXZ = 0.8F; (this.hairall[1 + face * 4]).showModel = (l > 0.0F); (this.hairall[2 + face * 4]).showModel = (l > 33.0F); (this.hairall[3 + face * 4]).showModel = (l > 66.0F); this.hairall[lng + face * 4].render(par1); GL11.glPopMatrix(); GL11.glPopMatrix(); }  }  GL11.glScalef(1.0F, 1.0F, 1.0F); GL11.glPopMatrix(); } private float limiter(float f, float c) { return (f - 0.7F > c) ? (c + 0.05F) : ((f + 0.7F < c) ? (c - 0.05F) : f); } private float limiter2(float f, float c) { return (f - 0.7F > c) ? (c + 0.05F) : ((f + 0.7F < c) ? (c - 0.05F) : f); } public String renderHairs(float par1, String hair, String anim) { float f6 = ModelBipedDBC.f;
/*      */     
/* 3788 */     GL11.glPushMatrix();
/* 3789 */     GL11.glScalef(1.0F / f6 * ((g <= 1) ? 1.0F : 0.7F), 1.0F / f6, 1.0F / f6 * ((g <= 1) ? 1.0F : 0.7F));
/* 3790 */     GL11.glTranslatef(0.0F, (f6 - 1.0F) * 1.5F, 0.0F);
/* 3791 */     if (hair.contains("FR") && 
/* 3792 */       hair.contains("2")) {
/* 3793 */       this.leftarmshoulder.field_78798_e = this.LA.field_78798_e;
/* 3794 */       this.leftarmshoulder.field_78797_d = this.LA.field_78797_d;
/* 3795 */       this.leftarmshoulder.field_78800_c = this.LA.field_78800_c;
/* 3796 */       this.leftarmshoulder.field_78796_g = this.LA.field_78796_g;
/* 3797 */       this.leftarmshoulder.field_78795_f = this.LA.field_78795_f;
/* 3798 */       this.leftarmshoulder.field_78808_h = this.LA.field_78808_h;
/* 3799 */       this.leftarmshoulder.func_78785_a(par1);
/* 3800 */       this.rightarmshoulder.field_78798_e = this.RA.field_78798_e;
/* 3801 */       this.rightarmshoulder.field_78797_d = this.RA.field_78797_d;
/* 3802 */       this.rightarmshoulder.field_78800_c = this.RA.field_78800_c;
/* 3803 */       this.rightarmshoulder.field_78796_g = this.RA.field_78796_g;
/* 3804 */       this.rightarmshoulder.field_78795_f = this.RA.field_78795_f;
/* 3805 */       this.rightarmshoulder.field_78808_h = this.RA.field_78808_h;
/* 3806 */       this.rightarmshoulder.func_78785_a(par1);
/*      */     } 
/*      */     
/* 3809 */     if (hair.contains("whandleg")) {
/* 3810 */       GL11.glPushMatrix();
/* 3811 */       this.WLeftarm.field_78798_e = this.LA.field_78798_e;
/* 3812 */       this.WLeftarm.field_78797_d = this.LA.field_78797_d;
/* 3813 */       this.WLeftarm.field_78800_c = this.LA.field_78800_c;
/* 3814 */       this.WLeftarm.field_78796_g = this.LA.field_78796_g;
/* 3815 */       this.WLeftarm.field_78795_f = this.LA.field_78795_f;
/* 3816 */       this.WLeftarm.field_78808_h = this.LA.field_78808_h;
/* 3817 */       this.WLeftarm.func_78785_a(par1);
/* 3818 */       this.WRightarm.field_78798_e = this.RA.field_78798_e;
/* 3819 */       this.WRightarm.field_78797_d = this.RA.field_78797_d;
/* 3820 */       this.WRightarm.field_78800_c = this.RA.field_78800_c;
/* 3821 */       this.WRightarm.field_78796_g = this.RA.field_78796_g;
/* 3822 */       this.WRightarm.field_78795_f = this.RA.field_78795_f;
/* 3823 */       this.WRightarm.field_78808_h = this.RA.field_78808_h;
/* 3824 */       this.WRightarm.func_78785_a(par1);
/* 3825 */       this.WLeftleg.field_78798_e = this.LL.field_78798_e;
/* 3826 */       this.WLeftleg.field_78797_d = this.LL.field_78797_d;
/* 3827 */       this.WLeftleg.field_78800_c = this.LL.field_78800_c;
/* 3828 */       this.WLeftleg.field_78796_g = this.LL.field_78796_g;
/* 3829 */       this.WLeftleg.field_78795_f = this.LL.field_78795_f;
/* 3830 */       this.WLeftleg.field_78808_h = this.LL.field_78808_h;
/* 3831 */       this.WLeftleg.func_78785_a(par1);
/* 3832 */       this.WRightleg.field_78798_e = this.RL.field_78798_e;
/* 3833 */       this.WRightleg.field_78797_d = this.RL.field_78797_d;
/* 3834 */       this.WRightleg.field_78800_c = this.RL.field_78800_c;
/* 3835 */       this.WRightleg.field_78796_g = this.RL.field_78796_g;
/* 3836 */       this.WRightleg.field_78795_f = this.RL.field_78795_f;
/* 3837 */       this.WRightleg.field_78808_h = this.RL.field_78808_h;
/* 3838 */       this.WRightleg.func_78785_a(par1);
/* 3839 */       GL11.glPopMatrix();
/*      */     } 
/* 3841 */     GL11.glPopMatrix();
/* 3842 */     GL11.glPushMatrix();
/* 3843 */     GL11.glScalef(1.0F / f6 * ((g <= 1) ? 1.0F : 0.7F), 1.0F / f6, 1.0F / f6 * ((g <= 1) ? 1.0F : 0.7F));
/* 3844 */     GL11.glTranslatef(0.0F, (f6 - 1.0F) * 1.5F, 0.0F);
/* 3845 */     if (hair.contains("FR")) {
/*      */       
/* 3847 */       if (!hair.contains("nFR")) {
/*      */         
/* 3849 */         GL11.glPushMatrix();
/*      */         
/* 3851 */         transRot(par1, this.B1);
/* 3852 */         GL11.glScalef(1.0F, 1.0F, 1.0F);
/* 3853 */         this.FroB.func_78785_a(par1);
/*      */         
/* 3855 */         float f = 1.57F;
/* 3856 */         float r = MathHelper.func_76126_a(this.rot3 * 0.02F) * 0.1F;
/* 3857 */         float r2 = MathHelper.func_76134_b(this.rot3 * 0.02F) * 0.1F;
/* 3858 */         float r3 = MathHelper.func_76134_b(this.rot3 * 0.14F) * 0.1F;
/* 3859 */         this.ftailS1.field_78796_g = 0.2F;
/* 3860 */         if (mod_JBRA.a6P9H9B)
/* 3861 */           this.ftailS1.field_78796_g += MathHelper.func_76134_b(this.rot3 * 0.09F) * 0.2F - 0.2F + r; 
/* 3862 */         this.ftailS1.field_78795_f = -0.3F;
/*      */         
/* 3864 */         this.ftailS2.field_78796_g = 0.2F;
/* 3865 */         if (mod_JBRA.a6P9H9B)
/* 3866 */           this.ftailS2.field_78796_g += MathHelper.func_76134_b(this.rot3 * 0.09F) * 0.2F - 0.2F + r2 + r3; 
/* 3867 */         this.ftailS2.field_78795_f = 0.4F;
/*      */         
/* 3869 */         this.ftailS3.field_78796_g = 0.1F;
/* 3870 */         if (mod_JBRA.a6P9H9B)
/* 3871 */           this.ftailS3.field_78796_g += MathHelper.func_76134_b(this.rot3 * 0.09F) * 0.1F - 0.1F + r + r3; 
/* 3872 */         this.ftailS3.field_78795_f = 0.6F;
/* 3873 */         if (mod_JBRA.a6P9H9B)
/* 3874 */           this.ftailS3.field_78795_f += MathHelper.func_76126_a(this.rot3 * 0.09F) * 0.4F + 0.3F; 
/* 3875 */         this.ftailS4.field_78796_g = 0.1F;
/* 3876 */         if (mod_JBRA.a6P9H9B)
/* 3877 */           this.ftailS4.field_78796_g += MathHelper.func_76134_b(this.rot3 * 0.09F) * 0.4F - 0.1F + r2; 
/* 3878 */         this.ftailS4.field_78795_f = 0.3F;
/* 3879 */         if (mod_JBRA.a6P9H9B)
/* 3880 */           this.ftailS4.field_78795_f += MathHelper.func_76126_a(this.rot3 * 0.09F) * 0.1F - 0.2F; 
/* 3881 */         this.ftailS5.field_78796_g = 0.2F;
/* 3882 */         if (mod_JBRA.a6P9H9B)
/* 3883 */           this.ftailS5.field_78796_g += MathHelper.func_76134_b(this.rot3 * 0.09F) * 0.4F - 0.2F + r + r3; 
/* 3884 */         this.ftailS5.field_78795_f = -0.2F;
/* 3885 */         if (mod_JBRA.a6P9H9B)
/* 3886 */           this.ftailS5.field_78795_f += MathHelper.func_76126_a(this.rot3 * 0.09F) * 0.1F - 0.3F; 
/* 3887 */         this.ftailS6.field_78796_g = 0.2F;
/* 3888 */         if (mod_JBRA.a6P9H9B)
/* 3889 */           this.ftailS6.field_78796_g += MathHelper.func_76134_b(this.rot3 * 0.09F) * 0.4F - 0.2F + r2 + r3; 
/* 3890 */         this.ftailS6.field_78795_f = -0.4F;
/* 3891 */         if (mod_JBRA.a6P9H9B)
/* 3892 */           this.ftailS6.field_78795_f += MathHelper.func_76126_a(this.rot3 * 0.09F) * 0.4F - 0.4F; 
/* 3893 */         GL11.glPopMatrix();
/*      */       } 
/* 3895 */       if (hair.contains("4")) {
/* 3896 */         this.Fro5b.field_78796_g = this.B.field_78796_g;
/* 3897 */         this.Fro5b.field_78795_f = this.B.field_78795_f;
/* 3898 */         this.Fro5b.field_78800_c = this.B.field_78800_c;
/* 3899 */         this.Fro5b.field_78797_d = this.B.field_78797_d;
/* 3900 */         this.Fro5b.func_78785_a(par1);
/* 3901 */         this.Fro5r.field_78800_c = this.RA.field_78800_c;
/* 3902 */         this.Fro5r.field_78797_d = this.RA.field_78797_d;
/* 3903 */         this.Fro5r.field_78798_e = this.RA.field_78798_e;
/* 3904 */         this.Fro5r.field_78796_g = this.RA.field_78796_g;
/* 3905 */         this.Fro5r.field_78795_f = this.RA.field_78795_f;
/* 3906 */         this.Fro5r.field_78808_h = this.RA.field_78808_h;
/* 3907 */         this.Fro5r.func_78785_a(par1);
/* 3908 */         this.Fro5l.field_78800_c = this.LA.field_78800_c;
/* 3909 */         this.Fro5l.field_78797_d = this.LA.field_78797_d;
/* 3910 */         this.Fro5l.field_78798_e = this.LA.field_78798_e;
/* 3911 */         this.Fro5l.field_78796_g = this.LA.field_78796_g;
/* 3912 */         this.Fro5l.field_78795_f = this.LA.field_78795_f;
/* 3913 */         this.Fro5l.field_78808_h = this.LA.field_78808_h;
/* 3914 */         this.Fro5l.func_78785_a(par1);
/*      */       } 
/*      */     } 
/* 3917 */     if (hair.contains("SJT1")) {
/* 3918 */       GL11.glPushMatrix();
/*      */       
/* 3920 */       transRot(par1, this.B1);
/* 3921 */       GL11.glScalef(1.0F, 1.0F, 1.0F);
/* 3922 */       this.SaiT1.func_78785_a(par1);
/*      */       
/* 3924 */       float r = MathHelper.func_76126_a(this.rot3 * 0.02F) * 0.1F;
/* 3925 */       float r2 = MathHelper.func_76134_b(this.rot3 * 0.02F) * 0.1F;
/* 3926 */       float r3 = MathHelper.func_76134_b(this.rot3 * 0.14F) * 0.1F;
/* 3927 */       this.tail1.field_78796_g = 0.2F;
/* 3928 */       if (mod_JBRA.a6P9H9B)
/* 3929 */         this.tail1.field_78796_g += MathHelper.func_76134_b(this.rot3 * 0.09F) * 0.2F - 0.2F + r; 
/* 3930 */       this.tail1.field_78795_f = -0.3F;
/*      */       
/* 3932 */       this.tail2.field_78796_g = 0.2F;
/* 3933 */       if (mod_JBRA.a6P9H9B)
/* 3934 */         this.tail2.field_78796_g += MathHelper.func_76134_b(this.rot3 * 0.09F) * 0.2F - 0.2F + r2 + r3; 
/* 3935 */       this.tail2.field_78795_f = 0.4F;
/*      */       
/* 3937 */       this.tailS3.field_78796_g = 0.1F;
/* 3938 */       if (mod_JBRA.a6P9H9B)
/* 3939 */         this.tailS3.field_78796_g += MathHelper.func_76134_b(this.rot3 * 0.09F) * 0.1F - 0.1F + r + r3; 
/* 3940 */       this.tailS3.field_78795_f = 0.6F;
/* 3941 */       if (mod_JBRA.a6P9H9B)
/* 3942 */         this.tailS3.field_78795_f += MathHelper.func_76126_a(this.rot3 * 0.09F) * 0.4F + 0.3F; 
/* 3943 */       this.tailS4.field_78796_g = 0.1F;
/* 3944 */       if (mod_JBRA.a6P9H9B)
/* 3945 */         this.tailS4.field_78796_g += MathHelper.func_76134_b(this.rot3 * 0.09F) * 0.4F - 0.1F + r2; 
/* 3946 */       this.tailS4.field_78795_f = 0.3F;
/* 3947 */       if (mod_JBRA.a6P9H9B)
/* 3948 */         this.tailS4.field_78795_f += MathHelper.func_76126_a(this.rot3 * 0.09F) * 0.1F - 0.2F; 
/* 3949 */       this.tailS5.field_78796_g = 0.2F;
/* 3950 */       if (mod_JBRA.a6P9H9B)
/* 3951 */         this.tailS5.field_78796_g += MathHelper.func_76134_b(this.rot3 * 0.09F) * 0.4F - 0.2F + r + r3; 
/* 3952 */       this.tailS5.field_78795_f = -0.2F;
/* 3953 */       if (mod_JBRA.a6P9H9B)
/* 3954 */         this.tailS5.field_78795_f += MathHelper.func_76126_a(this.rot3 * 0.09F) * 0.1F - 0.3F; 
/* 3955 */       this.tailS6.field_78796_g = 0.2F;
/* 3956 */       if (mod_JBRA.a6P9H9B)
/* 3957 */         this.tailS6.field_78796_g += MathHelper.func_76134_b(this.rot3 * 0.09F) * 0.4F - 0.2F + r2 + r3; 
/* 3958 */       this.tailS6.field_78795_f = -0.4F;
/* 3959 */       if (mod_JBRA.a6P9H9B) {
/* 3960 */         this.tailS6.field_78795_f += MathHelper.func_76126_a(this.rot3 * 0.09F) * 0.4F - 0.4F;
/*      */       }
/* 3962 */       GL11.glPopMatrix();
/*      */     } 
/*      */     
/* 3965 */     if (hair.contains("SJT2")) {
/*      */       
/* 3967 */       transRot(par1, this.B1);
/* 3968 */       this.SaiT2.field_78796_g = this.B1.field_78796_g;
/* 3969 */       this.SaiT2.func_78785_a(par1);
/*      */     } 
/*      */     
/* 3972 */     if (hair.contains("wshell")) {
/*      */       
/* 3974 */       GL11.glPushMatrix();
/* 3975 */       this.WShell.func_78785_a(par1);
/* 3976 */       GL11.glPopMatrix();
/*      */     } 
/* 3978 */     GL11.glPopMatrix();
/*      */     
/* 3980 */     GL11.glPushMatrix();
/* 3981 */     GL11.glScalef((0.5F + 0.5F / f6) * ((g <= 1) ? 1.0F : 0.85F), 0.5F + 0.5F / f6, (0.5F + 0.5F / f6) * ((g <= 1) ? 1.0F : 0.85F));
/* 3982 */     GL11.glTranslatef(0.0F, (f6 - 1.0F) / f6 * (2.0F - ((f6 >= 1.5F && f6 <= 2.0F) ? ((2.0F - f6) / 2.5F) : ((f6 < 1.5F && f6 >= 1.0F) ? ((f6 * 2.0F - 2.0F) * 0.2F) : 0.0F))), 0.0F);
/* 3983 */     if (hair.contains("FR")) {
/* 3984 */       this.Fro.field_78796_g = this.field_78116_c.field_78796_g;
/* 3985 */       this.Fro.field_78795_f = this.field_78116_c.field_78795_f;
/* 3986 */       this.Fro.field_78800_c = this.field_78116_c.field_78800_c;
/* 3987 */       this.Fro.field_78797_d = this.field_78116_c.field_78797_d;
/* 3988 */       this.Fro.func_78785_a(par1);
/*      */       
/* 3990 */       if (hair.contains("0") || hair.contains("2") || hair.contains("1")) {
/* 3991 */         this.Fro0.field_78796_g = this.field_78116_c.field_78796_g;
/* 3992 */         this.Fro0.field_78795_f = this.field_78116_c.field_78795_f;
/* 3993 */         this.Fro0.field_78800_c = this.field_78116_c.field_78800_c;
/* 3994 */         this.Fro0.field_78797_d = this.field_78116_c.field_78797_d;
/* 3995 */         this.Fro0.func_78785_a(par1);
/*      */       } 
/* 3997 */       if (hair.contains("1") || hair.contains("2")) {
/* 3998 */         this.Fro1.field_78796_g = this.field_78116_c.field_78796_g;
/* 3999 */         this.Fro1.field_78795_f = this.field_78116_c.field_78795_f;
/* 4000 */         this.Fro1.field_78800_c = this.field_78116_c.field_78800_c;
/* 4001 */         this.Fro1.field_78797_d = this.field_78116_c.field_78797_d;
/* 4002 */         this.Fro1.func_78785_a(par1);
/*      */       } 
/* 4004 */       if (hair.contains("2")) {
/* 4005 */         this.Fro2.field_78796_g = this.field_78116_c.field_78796_g;
/* 4006 */         this.Fro2.field_78795_f = this.field_78116_c.field_78795_f;
/* 4007 */         this.Fro2.field_78800_c = this.field_78116_c.field_78800_c;
/* 4008 */         this.Fro2.field_78797_d = this.field_78116_c.field_78797_d;
/* 4009 */         this.Fro2.func_78785_a(par1);
/*      */       } 
/* 4011 */       if (hair.contains("4")) {
/* 4012 */         this.Fro5.field_78796_g = this.field_78116_c.field_78796_g;
/* 4013 */         this.Fro5.field_78795_f = this.field_78116_c.field_78795_f;
/* 4014 */         this.Fro5.field_78800_c = this.field_78116_c.field_78800_c;
/* 4015 */         this.Fro5.field_78797_d = this.field_78116_c.field_78797_d;
/* 4016 */         this.Fro5.func_78785_a(par1);
/*      */       } 
/*      */     } 
/*      */     
/* 4020 */     if (hair.contains("OOZARU")) {
/* 4021 */       this.SaiO.field_78796_g = this.field_78116_c.field_78796_g;
/* 4022 */       this.SaiO.field_78795_f = this.field_78116_c.field_78795_f;
/* 4023 */       this.SaiO.field_78800_c = this.field_78116_c.field_78800_c;
/* 4024 */       this.SaiO.field_78797_d = this.field_78116_c.field_78797_d;
/* 4025 */       this.SaiO.func_78785_a(par1);
/*      */     } 
/* 4027 */     if (hair.contains("N")) {
/* 4028 */       this.Nam.field_78796_g = this.field_78116_c.field_78796_g;
/* 4029 */       this.Nam.field_78795_f = this.field_78116_c.field_78795_f;
/* 4030 */       this.Nam.field_78800_c = this.field_78116_c.field_78800_c;
/* 4031 */       this.Nam.field_78797_d = this.field_78116_c.field_78797_d;
/* 4032 */       this.Nam.func_78785_a(par1);
/*      */     } 
/* 4034 */     if (hair.contains("SJE")) {
/* 4035 */       this.SaiE.field_78796_g = this.field_78116_c.field_78796_g;
/* 4036 */       this.SaiE.field_78795_f = this.field_78116_c.field_78795_f;
/* 4037 */       this.SaiE.field_78800_c = this.field_78116_c.field_78800_c;
/* 4038 */       this.SaiE.field_78797_d = this.field_78116_c.field_78797_d;
/* 4039 */       this.SaiE.func_78785_a(par1);
/*      */     } 
/* 4041 */     if (hair.contains("FACENOSE")) {
/* 4042 */       this.face1.field_78796_g = this.field_78116_c.field_78796_g;
/* 4043 */       this.face1.field_78795_f = this.field_78116_c.field_78795_f;
/* 4044 */       this.face1.field_78800_c = this.field_78116_c.field_78800_c;
/* 4045 */       this.face1.field_78797_d = this.field_78116_c.field_78797_d;
/* 4046 */       this.face1.func_78785_a(par1);
/*      */     } 
/* 4048 */     if (hair.contains("FACEMOUTH")) {
/* 4049 */       this.face2.field_78796_g = this.field_78116_c.field_78796_g;
/* 4050 */       this.face2.field_78795_f = this.field_78116_c.field_78795_f;
/* 4051 */       this.face2.field_78800_c = this.field_78116_c.field_78800_c;
/* 4052 */       this.face2.field_78797_d = this.field_78116_c.field_78797_d;
/* 4053 */       this.face2.func_78785_a(par1);
/*      */     } 
/* 4055 */     if (hair.contains("EYEBROW")) {
/* 4056 */       this.face6.field_78796_g = this.field_78116_c.field_78796_g;
/* 4057 */       this.face6.field_78795_f = this.field_78116_c.field_78795_f;
/* 4058 */       this.face6.field_78800_c = this.field_78116_c.field_78800_c;
/* 4059 */       this.face6.field_78797_d = this.field_78116_c.field_78797_d;
/* 4060 */       this.face6.func_78785_a(par1);
/*      */     } 
/* 4062 */     if (hair.contains("EYEBASE")) {
/* 4063 */       this.face5.field_78796_g = this.field_78116_c.field_78796_g;
/* 4064 */       this.face5.field_78795_f = this.field_78116_c.field_78795_f;
/* 4065 */       this.face5.field_78800_c = this.field_78116_c.field_78800_c;
/* 4066 */       this.face5.field_78797_d = this.field_78116_c.field_78797_d;
/* 4067 */       this.face5.func_78785_a(par1);
/*      */     } 
/* 4069 */     if (hair.contains("EYELEFT")) {
/* 4070 */       this.face3.field_78796_g = this.field_78116_c.field_78796_g;
/* 4071 */       this.face3.field_78795_f = this.field_78116_c.field_78795_f;
/* 4072 */       this.face3.field_78800_c = this.field_78116_c.field_78800_c;
/* 4073 */       this.face3.field_78797_d = this.field_78116_c.field_78797_d;
/* 4074 */       this.face3.func_78785_a(par1);
/*      */     } 
/* 4076 */     if (hair.contains("EYERIGHT")) {
/* 4077 */       this.face4.field_78796_g = this.field_78116_c.field_78796_g;
/* 4078 */       this.face4.field_78795_f = this.field_78116_c.field_78795_f;
/* 4079 */       this.face4.field_78800_c = this.field_78116_c.field_78800_c;
/* 4080 */       this.face4.field_78797_d = this.field_78116_c.field_78797_d;
/* 4081 */       this.face4.func_78785_a(par1);
/*      */     } 
/*      */ 
/*      */     
/* 4085 */     if (hair.contains("A01")) {
/* 4086 */       this.bipedHeadg.field_78796_g = this.field_78116_c.field_78796_g;
/* 4087 */       this.bipedHeadg.field_78795_f = this.field_78116_c.field_78795_f;
/* 4088 */       this.bipedHeadg.field_78800_c = this.field_78116_c.field_78800_c;
/* 4089 */       this.bipedHeadg.field_78797_d = this.field_78116_c.field_78797_d;
/* 4090 */       this.bipedHeadg.func_78785_a(par1);
/*      */     } 
/* 4092 */     if (hair.contains("A02")) {
/* 4093 */       this.bipedHeadt.field_78796_g = this.field_78116_c.field_78796_g;
/* 4094 */       this.bipedHeadt.field_78795_f = this.field_78116_c.field_78795_f;
/* 4095 */       this.bipedHeadt.field_78800_c = this.field_78116_c.field_78800_c;
/* 4096 */       this.bipedHeadt.field_78797_d = this.field_78116_c.field_78797_d;
/* 4097 */       this.bipedHeadt.func_78785_a(par1);
/*      */     } 
/* 4099 */     if (hair.contains("A03")) {
/* 4100 */       this.bipedHeadv.field_78796_g = this.field_78116_c.field_78796_g;
/* 4101 */       this.bipedHeadv.field_78795_f = this.field_78116_c.field_78795_f;
/* 4102 */       this.bipedHeadv.field_78800_c = this.field_78116_c.field_78800_c;
/* 4103 */       this.bipedHeadv.field_78797_d = this.field_78116_c.field_78797_d;
/* 4104 */       this.bipedHeadv.func_78785_a(par1);
/*      */     } 
/* 4106 */     if (hair.contains("A04")) {
/* 4107 */       this.bipedHeadgh.field_78796_g = this.field_78116_c.field_78796_g;
/* 4108 */       this.bipedHeadgh.field_78795_f = this.field_78116_c.field_78795_f;
/* 4109 */       this.bipedHeadgh.field_78800_c = this.field_78116_c.field_78800_c;
/* 4110 */       this.bipedHeadgh.field_78797_d = this.field_78116_c.field_78797_d;
/* 4111 */       this.bipedHeadgh.func_78785_a(par1);
/*      */     } 
/* 4113 */     if (hair.contains("A05")) {
/* 4114 */       this.bipedHeadg2.field_78796_g = this.field_78116_c.field_78796_g;
/* 4115 */       this.bipedHeadg2.field_78795_f = this.field_78116_c.field_78795_f;
/* 4116 */       this.bipedHeadg2.field_78800_c = this.field_78116_c.field_78800_c;
/* 4117 */       this.bipedHeadg2.field_78797_d = this.field_78116_c.field_78797_d;
/* 4118 */       this.bipedHeadg2.func_78785_a(par1);
/*      */     } 
/* 4120 */     if (hair.contains("A06") || hair.contains("B06") || hair.contains("C06")) {
/* 4121 */       this.bipedHeadght.field_78796_g = this.field_78116_c.field_78796_g;
/* 4122 */       this.bipedHeadght.field_78795_f = this.field_78116_c.field_78795_f;
/* 4123 */       this.bipedHeadght.field_78800_c = this.field_78116_c.field_78800_c;
/* 4124 */       this.bipedHeadght.field_78797_d = this.field_78116_c.field_78797_d;
/* 4125 */       this.bipedHeadght.func_78785_a(par1);
/*      */     } 
/* 4127 */     if (hair.contains("A07") || hair.contains("B07") || hair.contains("C07")) {
/* 4128 */       this.bipedHeadgt.field_78796_g = this.field_78116_c.field_78796_g;
/* 4129 */       this.bipedHeadgt.field_78795_f = this.field_78116_c.field_78795_f;
/* 4130 */       this.bipedHeadgt.field_78800_c = this.field_78116_c.field_78800_c;
/* 4131 */       this.bipedHeadgt.field_78797_d = this.field_78116_c.field_78797_d;
/* 4132 */       this.bipedHeadgt.func_78785_a(par1);
/*      */     } 
/* 4134 */     if (hair.contains("A08") || hair.contains("B08") || hair.contains("C08")) {
/* 4135 */       this.bipedHeadgtt.field_78796_g = this.field_78116_c.field_78796_g;
/* 4136 */       this.bipedHeadgtt.field_78795_f = this.field_78116_c.field_78795_f;
/* 4137 */       this.bipedHeadgtt.field_78800_c = this.field_78116_c.field_78800_c;
/* 4138 */       this.bipedHeadgtt.field_78797_d = this.field_78116_c.field_78797_d;
/* 4139 */       this.bipedHeadgtt.func_78785_a(par1);
/*      */     } 
/* 4141 */     if (hair.contains("A09")) {
/* 4142 */       this.bipedHeadc7.field_78796_g = this.field_78116_c.field_78796_g;
/* 4143 */       this.bipedHeadc7.field_78795_f = this.field_78116_c.field_78795_f;
/* 4144 */       this.bipedHeadc7.field_78800_c = this.field_78116_c.field_78800_c;
/* 4145 */       this.bipedHeadc7.field_78797_d = this.field_78116_c.field_78797_d;
/* 4146 */       this.bipedHeadc7.func_78785_a(par1);
/*      */     } 
/* 4148 */     if (hair.contains("A10")) {
/* 4149 */       this.bipedHeadc8.field_78796_g = this.field_78116_c.field_78796_g;
/* 4150 */       this.bipedHeadc8.field_78795_f = this.field_78116_c.field_78795_f;
/* 4151 */       this.bipedHeadc8.field_78800_c = this.field_78116_c.field_78800_c;
/* 4152 */       this.bipedHeadc8.field_78797_d = this.field_78116_c.field_78797_d;
/* 4153 */       this.bipedHeadc8.func_78785_a(par1);
/*      */     } 
/* 4155 */     if (hair.contains("12") || hair.contains("D")) {
/* 4156 */       this.bipedHeadrad.field_78796_g = this.field_78116_c.field_78796_g;
/* 4157 */       this.bipedHeadrad.field_78795_f = this.field_78116_c.field_78795_f;
/* 4158 */       this.bipedHeadrad.field_78800_c = this.field_78116_c.field_78800_c;
/* 4159 */       this.bipedHeadrad.field_78797_d = this.field_78116_c.field_78797_d;
/* 4160 */       this.bipedHeadrad.func_78785_a(par1);
/* 4161 */       this.bipedHeadradl.field_78796_g = this.field_78116_c.field_78796_g;
/* 4162 */       this.field_78116_c.field_78795_f /= 4.0F;
/* 4163 */       this.bipedHeadradl.field_78800_c = this.field_78116_c.field_78800_c;
/* 4164 */       this.bipedHeadradl.field_78797_d = this.field_78116_c.field_78797_d;
/* 4165 */       this.bipedHeadradl.func_78785_a(par1);
/* 4166 */       this.bipedHeadradl2.field_78796_g = this.field_78116_c.field_78796_g;
/* 4167 */       this.field_78116_c.field_78795_f /= 2.0F;
/* 4168 */       this.bipedHeadradl2.field_78800_c = this.field_78116_c.field_78800_c;
/* 4169 */       this.bipedHeadradl2.field_78797_d = this.field_78116_c.field_78797_d;
/* 4170 */       this.bipedHeadradl2.func_78785_a(par1);
/* 4171 */       this.bipedHeadradl2.field_78796_g = this.field_78116_c.field_78796_g;
/* 4172 */       this.field_78116_c.field_78795_f /= 1.2F;
/* 4173 */       this.bipedHeadradl2.field_78800_c = this.field_78116_c.field_78800_c;
/* 4174 */       this.bipedHeadradl2.field_78797_d = this.field_78116_c.field_78797_d;
/* 4175 */       this.bipedHeadradl2.func_78785_a(par1);
/* 4176 */       if (hair.contains("01") || hair.contains("02") || hair.contains("05")) {
/* 4177 */         this.bipedHeadssj3t.field_78796_g = this.field_78116_c.field_78796_g;
/* 4178 */         this.bipedHeadssj3t.field_78795_f = this.field_78116_c.field_78795_f;
/* 4179 */         this.bipedHeadssj3t.field_78800_c = this.field_78116_c.field_78800_c;
/* 4180 */         this.bipedHeadssj3t.field_78797_d = this.field_78116_c.field_78797_d;
/* 4181 */         this.bipedHeadssj3t.func_78785_a(par1);
/*      */       } 
/*      */     } 
/* 4184 */     if (hair.contains("B01") || hair.contains("B05")) {
/* 4185 */       this.bipedHeadsg.field_78796_g = this.field_78116_c.field_78796_g;
/* 4186 */       this.bipedHeadsg.field_78795_f = this.field_78116_c.field_78795_f;
/* 4187 */       this.bipedHeadsg.field_78800_c = this.field_78116_c.field_78800_c;
/* 4188 */       this.bipedHeadsg.field_78797_d = this.field_78116_c.field_78797_d;
/* 4189 */       this.bipedHeadsg.func_78785_a(par1);
/*      */     } 
/* 4191 */     if (hair.contains("B02") || hair.contains("B09") || hair.contains("B10")) {
/* 4192 */       this.bipedHeadst.field_78796_g = this.field_78116_c.field_78796_g;
/* 4193 */       this.bipedHeadst.field_78795_f = this.field_78116_c.field_78795_f;
/* 4194 */       this.bipedHeadst.field_78800_c = this.field_78116_c.field_78800_c;
/* 4195 */       this.bipedHeadst.field_78797_d = this.field_78116_c.field_78797_d;
/* 4196 */       this.bipedHeadst.func_78785_a(par1);
/*      */     } 
/* 4198 */     if (hair.contains("B03")) {
/* 4199 */       this.bipedHeadsv.field_78796_g = this.field_78116_c.field_78796_g;
/* 4200 */       this.bipedHeadsv.field_78795_f = this.field_78116_c.field_78795_f;
/* 4201 */       this.bipedHeadsv.field_78800_c = this.field_78116_c.field_78800_c;
/* 4202 */       this.bipedHeadsv.field_78797_d = this.field_78116_c.field_78797_d;
/* 4203 */       this.bipedHeadsv.func_78785_a(par1);
/*      */     } 
/* 4205 */     if (hair.contains("B04")) {
/* 4206 */       this.bipedHeadsgh.field_78796_g = this.field_78116_c.field_78796_g;
/* 4207 */       this.bipedHeadsgh.field_78795_f = this.field_78116_c.field_78795_f;
/* 4208 */       this.bipedHeadsgh.field_78800_c = this.field_78116_c.field_78800_c;
/* 4209 */       this.bipedHeadsgh.field_78797_d = this.field_78116_c.field_78797_d;
/* 4210 */       this.bipedHeadsgh.func_78785_a(par1);
/*      */     } 
/* 4212 */     if (hair.contains("C01") || hair.contains("C05")) {
/* 4213 */       this.bipedHeadssg.field_78796_g = this.field_78116_c.field_78796_g;
/* 4214 */       this.bipedHeadssg.field_78795_f = this.field_78116_c.field_78795_f;
/* 4215 */       this.bipedHeadssg.field_78800_c = this.field_78116_c.field_78800_c;
/* 4216 */       this.bipedHeadssg.field_78797_d = this.field_78116_c.field_78797_d;
/* 4217 */       this.bipedHeadssg.func_78785_a(par1);
/*      */     } 
/* 4219 */     if (hair.contains("C02") || hair.contains("C09") || hair.contains("C10")) {
/* 4220 */       this.bipedHeadsst.field_78796_g = this.field_78116_c.field_78796_g;
/* 4221 */       this.bipedHeadsst.field_78795_f = this.field_78116_c.field_78795_f;
/* 4222 */       this.bipedHeadsst.field_78800_c = this.field_78116_c.field_78800_c;
/* 4223 */       this.bipedHeadsst.field_78797_d = this.field_78116_c.field_78797_d;
/* 4224 */       this.bipedHeadsst.func_78785_a(par1);
/*      */     } 
/* 4226 */     if (hair.contains("C03")) {
/* 4227 */       this.bipedHeadssv.field_78796_g = this.field_78116_c.field_78796_g;
/* 4228 */       this.bipedHeadssv.field_78795_f = this.field_78116_c.field_78795_f;
/* 4229 */       this.bipedHeadssv.field_78800_c = this.field_78116_c.field_78800_c;
/* 4230 */       this.bipedHeadssv.field_78797_d = this.field_78116_c.field_78797_d;
/* 4231 */       this.bipedHeadssv.func_78785_a(par1);
/*      */     } 
/* 4233 */     if (hair.contains("C04")) {
/* 4234 */       this.bipedHeadssgh.field_78796_g = this.field_78116_c.field_78796_g;
/* 4235 */       this.bipedHeadssgh.field_78795_f = this.field_78116_c.field_78795_f;
/* 4236 */       this.bipedHeadssgh.field_78800_c = this.field_78116_c.field_78800_c;
/* 4237 */       this.bipedHeadssgh.field_78797_d = this.field_78116_c.field_78797_d;
/* 4238 */       this.bipedHeadssgh.func_78785_a(par1);
/*      */     } 
/* 4240 */     GL11.glPopMatrix();
/* 4241 */     return ""; }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void renderHeadwear(float par1) {
/* 4247 */     float f6 = f;
/* 4248 */     GL11.glPushMatrix();
/* 4249 */     GL11.glScalef((0.5F + 0.5F / f6) * ((g <= 1) ? 1.0F : 0.85F), 0.5F + 0.5F / f6, (0.5F + 0.5F / f6) * ((g <= 1) ? 1.0F : 0.85F));
/* 4250 */     GL11.glTranslatef(0.0F, (f6 - 1.0F) / f6 * (2.0F - ((f6 >= 1.5F && f6 <= 2.0F) ? ((2.0F - f6) / 2.5F) : ((f6 < 1.5F && f6 >= 1.0F) ? ((f6 * 2.0F - 2.0F) * 0.2F) : 0.0F))), 0.0F);
/* 4251 */     this.field_78114_d.field_78796_g = this.field_78116_c.field_78796_g;
/* 4252 */     this.field_78114_d.field_78795_f = this.field_78116_c.field_78795_f;
/* 4253 */     this.field_78114_d.field_78800_c = this.field_78116_c.field_78800_c;
/* 4254 */     this.field_78114_d.field_78797_d = this.field_78116_c.field_78797_d;
/* 4255 */     this.field_78114_d.func_78785_a(par1);
/* 4256 */     GL11.glPopMatrix();
/*      */   }
/*      */   
/*      */   public void renderHalo(float par1) {
/* 4260 */     float f6 = f;
/* 4261 */     GL11.glPushMatrix();
/* 4262 */     GL11.glScalef((0.5F + 0.5F / f6) * ((g <= 1) ? 1.0F : 0.85F), 0.5F + 0.5F / f6, (0.5F + 0.5F / f6) * ((g <= 1) ? 1.0F : 0.85F));
/* 4263 */     GL11.glTranslatef(0.0F, (f6 - 1.0F) / f6 * (2.0F - ((f6 >= 1.5F && f6 <= 2.0F) ? ((2.0F - f6) / 2.5F) : ((f6 < 1.5F && f6 >= 1.0F) ? ((f6 * 2.0F - 2.0F) * 0.2F) : 0.0F))), 0.0F);
/* 4264 */     this.halo.field_78796_g = this.field_78116_c.field_78796_g;
/* 4265 */     this.halo.field_78795_f = this.field_78116_c.field_78795_f;
/* 4266 */     this.halo.field_78800_c = this.field_78116_c.field_78800_c;
/* 4267 */     this.halo.field_78797_d = this.field_78116_c.field_78797_d;
/* 4268 */     this.halo.func_78785_a(par1);
/* 4269 */     GL11.glPopMatrix();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_78110_b(float par1) {
/* 4276 */     float f6 = f;
/* 4277 */     GL11.glPushMatrix();
/* 4278 */     GL11.glScalef((0.5F + 0.5F / f6) * ((g <= 1) ? 1.0F : 0.85F), 0.5F + 0.5F / f6, (0.5F + 0.5F / f6) * ((g <= 1) ? 1.0F : 0.85F));
/* 4279 */     GL11.glTranslatef(0.0F, (f6 - 1.0F) / f6 * (2.0F - ((f6 >= 1.5F && f6 <= 2.0F) ? ((2.0F - f6) / 2.5F) : ((f6 < 1.5F && f6 >= 1.0F) ? ((f6 * 2.0F - 2.0F) * 0.2F) : 0.0F))), 0.0F);
/* 4280 */     this.field_78121_j.field_78796_g = this.field_78116_c.field_78796_g;
/* 4281 */     this.field_78121_j.field_78795_f = this.field_78116_c.field_78795_f;
/* 4282 */     this.field_78121_j.field_78800_c = 0.0F;
/* 4283 */     this.field_78121_j.field_78797_d = 0.0F;
/* 4284 */     this.field_78121_j.func_78785_a(par1);
/* 4285 */     GL11.glPopMatrix();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_78111_c(float par1) {
/* 4293 */     this.field_78122_k.func_78785_a(par1);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public ModelRenderer func_85181_a(Random p_85181_1_) {
/* 4299 */     return this.field_78116_c;
/*      */   }
/*      */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JBRA-Client-v1.6.52.jar!\JinRyuu\JBRA\ModelBipedDBC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */