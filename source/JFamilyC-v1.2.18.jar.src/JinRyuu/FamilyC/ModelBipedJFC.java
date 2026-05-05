/*      */ package JinRyuu.FamilyC;
/*      */ 
/*      */ import JinRyuu.JRMCore.JRMCoreH;
/*      */ import cpw.mods.fml.relauncher.Side;
/*      */ import cpw.mods.fml.relauncher.SideOnly;
/*      */ import net.minecraft.client.model.ModelBase;
/*      */ import net.minecraft.client.model.ModelBiped;
/*      */ import net.minecraft.client.model.ModelRenderer;
/*      */ import net.minecraft.entity.Entity;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*      */ public class ModelBipedJFC
/*      */   extends ModelBiped
/*      */ {
/*      */   private static final int hTOP = 4;
/*      */   private static final int hRIGHT = 1;
/*      */   private static final int hLeft = 2;
/*      */   public ModelRenderer field_78116_c;
/*      */   public ModelRenderer field_78114_d;
/*      */   public ModelRenderer field_78115_e;
/*      */   public ModelRenderer field_78112_f;
/*      */   public ModelRenderer field_78113_g;
/*      */   public ModelRenderer field_78123_h;
/*      */   public ModelRenderer field_78124_i;
/*      */   public ModelRenderer field_78121_j;
/*      */   public ModelRenderer field_78122_k;
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
/*      */   ModelRenderer gokuni1;
/*      */   ModelRenderer gokuni2;
/*      */   ModelRenderer gokuni3;
/*      */   ModelRenderer gokuni4;
/*      */   ModelRenderer gokuni5;
/*      */   ModelRenderer gokuni6;
/*      */   ModelRenderer gokuni7;
/*      */   ModelRenderer gokuni8;
/*      */   ModelRenderer gokuni9;
/*      */   ModelRenderer gokuni10;
/*      */   ModelRenderer gokuni11;
/*      */   ModelRenderer gokuni12;
/*      */   ModelRenderer ght1;
/*      */   ModelRenderer ght2;
/*      */   ModelRenderer ght3;
/*      */   ModelRenderer ght4;
/*      */   ModelRenderer ght5;
/*      */   ModelRenderer ght6;
/*      */   ModelRenderer ght7;
/*      */   ModelRenderer ght8;
/*      */   ModelRenderer ght9;
/*      */   ModelRenderer ght11;
/*      */   ModelRenderer ght14;
/*      */   ModelRenderer ght16;
/*      */   ModelRenderer goten2;
/*      */   ModelRenderer goten3;
/*      */   ModelRenderer goten4;
/*      */   ModelRenderer goten5;
/*      */   ModelRenderer goten6;
/*      */   ModelRenderer goten9;
/*      */   ModelRenderer goten14;
/*      */   ModelRenderer goten16;
/*      */   ModelRenderer gotent1;
/*      */   ModelRenderer gotent2;
/*      */   ModelRenderer gotent3;
/*      */   ModelRenderer gotent5;
/*      */   ModelRenderer gotent6;
/*      */   ModelRenderer gotent7;
/*      */   ModelRenderer gotent8;
/*      */   ModelRenderer gotent9;
/*      */   ModelRenderer gotent11;
/*      */   ModelRenderer gotent16;
/*      */   ModelRenderer hairc71;
/*      */   ModelRenderer hairc72;
/*      */   ModelRenderer hairc81;
/*      */   ModelRenderer hairc82;
/*      */   ModelRenderer hairc83;
/*      */   ModelRenderer radlike1;
/*      */   ModelRenderer radlike2;
/*      */   ModelRenderer radlike3;
/*      */   ModelRenderer radlike4;
/*      */   ModelRenderer radlike5;
/*      */   ModelRenderer radlike7;
/*      */   ModelRenderer radlike8;
/*      */   ModelRenderer radlike10;
/*      */   ModelRenderer radlike11;
/*      */   ModelRenderer radlike12;
/*      */   ModelRenderer radlike13;
/*      */   ModelRenderer radlike14;
/*      */   ModelRenderer radlike15;
/*      */   ModelRenderer radlike16;
/*      */   ModelRenderer radlike17;
/*      */   ModelRenderer radlike18;
/*      */   ModelRenderer radlike19;
/*      */   ModelRenderer radlike20;
/*      */   ModelRenderer radlike21;
/*      */   ModelRenderer radlike22;
/*      */   ModelRenderer radlike23;
/*      */   ModelRenderer radlike24;
/*      */   ModelRenderer radlike25;
/*      */   ModelRenderer radlike26;
/*      */   ModelRenderer radlike27;
/*      */   ModelRenderer radlike28;
/*      */   ModelRenderer radlike29;
/*      */   ModelRenderer radlike30;
/*      */   ModelRenderer radlike31;
/*      */   ModelRenderer radlike32;
/*      */   ModelRenderer radlik6;
/*      */   ModelRenderer radlik7;
/*      */   ModelRenderer radlik15;
/*      */   ModelRenderer radlik1;
/*      */   ModelRenderer radlik2;
/*      */   ModelRenderer radlik3;
/*      */   ModelRenderer radlik4;
/*      */   ModelRenderer radlik5;
/*      */   ModelRenderer radlik8;
/*      */   ModelRenderer radlik9;
/*      */   ModelRenderer radlik10;
/*      */   ModelRenderer radlik11;
/*      */   ModelRenderer radlik12;
/*      */   ModelRenderer radlik13;
/*      */   ModelRenderer radlik14;
/*      */   ModelRenderer radlik16;
/*      */   ModelRenderer radlik17;
/*      */   ModelRenderer radlik18;
/*      */   ModelRenderer ssjsan1;
/*      */   ModelRenderer ssjsan2;
/*      */   ModelRenderer ssjsan3;
/*      */   ModelRenderer ssjsan4;
/*      */   ModelRenderer ssjsan5;
/*      */   ModelRenderer ssjsan7;
/*      */   ModelRenderer ssjsan8;
/*      */   ModelRenderer ssjsan10;
/*      */   ModelRenderer ssjsan11;
/*      */   ModelRenderer ssjsan12;
/*      */   ModelRenderer ssjsan13;
/*      */   ModelRenderer ssjsan14;
/*      */   ModelRenderer ssjsan15;
/*      */   ModelRenderer ssjsan16;
/*      */   ModelRenderer ssjsan17;
/*      */   ModelRenderer ssjsan18;
/*      */   ModelRenderer ssjsan19;
/*      */   ModelRenderer ssjsan20;
/*      */   ModelRenderer ssjsan21;
/*      */   ModelRenderer ssjsan22;
/*      */   ModelRenderer ssjsan23;
/*      */   ModelRenderer ssjsan24;
/*      */   ModelRenderer ssjsan25;
/*      */   ModelRenderer ssjsan26;
/*      */   ModelRenderer ssjsan27;
/*      */   ModelRenderer ssjsan28;
/*      */   ModelRenderer ssjsan29;
/*      */   ModelRenderer ssjsan30;
/*      */   ModelRenderer ssjsan31;
/*      */   ModelRenderer ssjsan32;
/*      */   ModelRenderer long6;
/*      */   ModelRenderer long7;
/*      */   ModelRenderer long15;
/*      */   ModelRenderer long1;
/*      */   ModelRenderer long2;
/*      */   ModelRenderer long3;
/*      */   ModelRenderer long4;
/*      */   ModelRenderer long5;
/*      */   ModelRenderer long8;
/*      */   ModelRenderer long9;
/*      */   ModelRenderer long10;
/*      */   ModelRenderer long11;
/*      */   ModelRenderer long12;
/*      */   ModelRenderer long13;
/*      */   ModelRenderer long14;
/*      */   ModelRenderer long16;
/*      */   ModelRenderer long17;
/*      */   ModelRenderer long18;
/*      */   ModelRenderer tincs1;
/*      */   public ModelRenderer halo;
/*      */   public ModelRenderer halo1;
/*      */   public ModelRenderer halo2;
/*      */   public ModelRenderer halo3;
/*      */   public ModelRenderer halo4;
/*      */   ModelRenderer rightarm;
/*      */   ModelRenderer leftarm;
/*      */   ModelRenderer Brightarm;
/*      */   ModelRenderer Bleftarm;
/*      */   ModelRenderer rightleg;
/*      */   ModelRenderer leftleg;
/*      */   ModelRenderer skirt1;
/*      */   ModelRenderer skirt2;
/*      */   ModelRenderer body;
/*      */   ModelRenderer hip;
/*      */   ModelRenderer waist;
/*      */   ModelRenderer Bbreast;
/*      */   ModelRenderer breast;
/*      */   ModelRenderer bottom;
/*      */   ModelRenderer breast2;
/*      */   ModelRenderer Bbreast2;
/*      */   public ModelRenderer S1bipedHead;
/*      */   public ModelRenderer S1bipedBody;
/*      */   public ModelRenderer S1bipedRightArm;
/*      */   public ModelRenderer S1bipedLeftArm;
/*      */   public ModelRenderer S1bipedRightLeg;
/*      */   public ModelRenderer S1bipedLeftLeg;
/*      */   ModelRenderer S1rightarm;
/*      */   ModelRenderer S1leftarm;
/*      */   ModelRenderer S1Brightarm;
/*      */   ModelRenderer S1Bleftarm;
/*      */   ModelRenderer S1rightleg;
/*      */   ModelRenderer S1leftleg;
/*      */   ModelRenderer S1skirt1;
/*      */   ModelRenderer S1skirt2;
/*      */   ModelRenderer S1body;
/*      */   ModelRenderer S1hip;
/*      */   ModelRenderer S1waist;
/*      */   ModelRenderer S1Bbreast;
/*      */   ModelRenderer S1breast;
/*      */   ModelRenderer S1bottom;
/*      */   ModelRenderer S1breast2;
/*      */   ModelRenderer S1Bbreast2;
/*      */   ModelRenderer Nam;
/*      */   ModelRenderer near1;
/*      */   ModelRenderer near2;
/*      */   ModelRenderer ant1;
/*      */   ModelRenderer ant2;
/*      */   ModelRenderer ant3;
/*      */   ModelRenderer ant4;
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
/*      */   ModelRendererJBRA[] hairall;
/*      */   ModelRenderer face1;
/*      */   ModelRenderer nose;
/*      */   ModelRenderer face2;
/*      */   ModelRenderer mouth;
/*      */   ModelRenderer face3;
/*      */   ModelRenderer eyel;
/*      */   ModelRenderer face4;
/*      */   ModelRenderer eyer;
/*      */   ModelRenderer face5;
/*      */   ModelRenderer eyeb;
/*      */   ModelRenderer face6;
/*      */   ModelRenderer eyew;
/*      */   public int field_78119_l;
/*      */   public int field_78120_m;
/*      */   public boolean field_78117_n;
/*      */   public boolean field_78118_o;
/*      */   private Entity Entity;
/*      */   private String name;
/*      */   private String dns;
/*      */   private float age;
/*      */   
/*      */   public ModelBipedJFC() {
/*  620 */     this(0.0F);
/*      */   }
/*      */ 
/*      */   
/*      */   public ModelBipedJFC(float par1) {
/*  625 */     this(par1, 0.0F, 64, 32);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/*      */     model.field_78795_f = x;
/*      */     model.field_78796_g = y;
/*      */     model.field_78808_h = z;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void setRotation(ModelRendererJBRA model, float x, float y, float z) {
/*      */     model.rotateAngleX = x;
/*      */     model.rotateAngleY = y;
/*      */     model.rotateAngleZ = z;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static float f = 1.0F;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int g = 1;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int y = 1;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int p = 0;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static float rot1;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static float rot4;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static float rot3;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static float rot2;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static float rot5;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static float rot6;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   ModelRenderer H;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   ModelRenderer RA;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   ModelRenderer LA;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   ModelRenderer RL;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   ModelRenderer LL;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   ModelRenderer B;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   ModelRenderer B1;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   ModelRenderer B2;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   ModelRenderer B3;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   ModelRenderer B4;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   ModelRenderer B5;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   ModelRenderer B7;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   ModelRenderer B9;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int b;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setF(float f) {
/*      */     this;
/*      */     ModelBipedJFC.f = f;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setG(int g) {
/*      */     this;
/*      */     ModelBipedJFC.g = g;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public float getF() {
/*      */     this;
/*      */     return f;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getG() {
/*      */     this;
/*      */     return g;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_78088_a(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7) {
/*      */     this;
/*      */     rot1 = par2;
/*      */     this;
/*      */     rot2 = par3;
/*      */     this;
/*      */     rot3 = par4;
/*      */     this;
/*      */     rot4 = par5;
/*      */     this;
/*      */     rot5 = par6;
/*      */     this;
/*      */     rot6 = par7;
/*      */     this.Entity = par1Entity;
/*      */     if (par1Entity instanceof EntityNPC) {
/*      */       EntityNPC e = (EntityNPC)par1Entity;
/*      */       this.dns = e.getDNS();
/*      */       this.b = JRMCoreH.dnsBreast(this.dns);
/*      */       if (this.dns.length() > 5) {
/*      */         g = JRMCoreH.dnsGender(this.dns) + 1;
/*      */       }
/*      */       this.age = e.getNPCgrw();
/*      */       this.b = JRMCoreH.dnsBreast(this.dns);
/*      */       f = this.age;
/*      */     } 
/*      */     func_78087_a(par2, par3, par4, par5, par6, par7, par1Entity);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void renderBody(float par7, int skn) {
/*      */     renderBody(par7, skn, 4);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void renderBody(float par7, int skn, int b) {
/*      */     if (g <= 1) {
/*      */       if (this.field_78091_s) {
/*      */         float f6 = 2.0F;
/*      */         GL11.glPushMatrix();
/*      */         GL11.glScalef(1.5F / f6, 1.5F / f6, 1.5F / f6);
/*      */         GL11.glTranslatef(0.0F, 16.0F * par7, 0.0F);
/*      */         if (skn == 0) {
/*      */           this.field_78116_c.func_78785_a(par7);
/*      */         } else if (skn == 1) {
/*      */           this.S1bipedHead.func_78785_a(par7);
/*      */         } 
/*      */         GL11.glPopMatrix();
/*      */         GL11.glPushMatrix();
/*      */         GL11.glScalef(1.0F / f6, 1.0F / f6, 1.0F / f6);
/*      */         GL11.glTranslatef(0.0F, 24.0F * par7, 0.0F);
/*      */         if (skn == 0) {
/*      */           this.field_78115_e.func_78785_a(par7);
/*      */         } else if (skn == 1) {
/*      */           this.S1bipedBody.func_78785_a(par7);
/*      */         } 
/*      */         if (skn == 0) {
/*      */           this.field_78112_f.func_78785_a(par7);
/*      */         } else if (skn == 1) {
/*      */           this.S1bipedRightArm.func_78785_a(par7);
/*      */         } 
/*      */         if (skn == 0) {
/*      */           this.field_78113_g.func_78785_a(par7);
/*      */         } else if (skn == 1) {
/*      */           this.S1bipedLeftArm.func_78785_a(par7);
/*      */         } 
/*      */         if (skn == 0) {
/*      */           this.field_78123_h.func_78785_a(par7);
/*      */         } else if (skn == 1) {
/*      */           this.S1bipedRightLeg.func_78785_a(par7);
/*      */         } 
/*      */         if (skn == 0) {
/*      */           this.field_78124_i.func_78785_a(par7);
/*      */         } else if (skn == 1) {
/*      */           this.S1bipedLeftLeg.func_78785_a(par7);
/*      */         } 
/*      */         GL11.glPopMatrix();
/*      */       } else {
/*      */         float f6 = f;
/*      */         GL11.glPushMatrix();
/*      */         GL11.glScalef(0.5F + 0.5F / f6, 0.5F + 0.5F / f6, 0.5F + 0.5F / f6);
/*      */         GL11.glTranslatef(0.0F, (f6 - 1.0F) / f6 * (2.0F - ((f6 >= 1.5F && f6 <= 2.0F) ? ((2.0F - f6) / 2.5F) : ((f6 < 1.5F && f6 >= 1.0F) ? ((f6 * 2.0F - 2.0F) * 0.2F) : 0.0F))), 0.0F);
/*      */         if (skn == 0) {
/*      */           this.field_78116_c.func_78785_a(par7);
/*      */         } else if (skn == 1) {
/*      */           this.S1bipedHead.func_78785_a(par7);
/*      */         } 
/*      */         GL11.glPopMatrix();
/*      */         GL11.glPushMatrix();
/*      */         GL11.glScalef(1.0F / f6, 1.0F / f6, 1.0F / f6);
/*      */         GL11.glTranslatef(0.0F, (f6 - 1.0F) * 1.5F, 0.0F);
/*      */         if (skn == 0) {
/*      */           this.field_78115_e.func_78785_a(par7);
/*      */         } else if (skn == 1) {
/*      */           this.S1bipedBody.func_78785_a(par7);
/*      */         } 
/*      */         if (skn == 0) {
/*      */           this.field_78112_f.func_78785_a(par7);
/*      */         } else if (skn == 1) {
/*      */           this.S1bipedRightArm.func_78785_a(par7);
/*      */         } 
/*      */         if (skn == 0) {
/*      */           this.field_78113_g.func_78785_a(par7);
/*      */         } else if (skn == 1) {
/*      */           this.S1bipedLeftArm.func_78785_a(par7);
/*      */         } 
/*      */         if (skn == 0) {
/*      */           this.field_78123_h.func_78785_a(par7);
/*      */         } else if (skn == 1) {
/*      */           this.S1bipedRightLeg.func_78785_a(par7);
/*      */         } 
/*      */         if (skn == 0) {
/*      */           this.field_78124_i.func_78785_a(par7);
/*      */         } else if (skn == 1) {
/*      */           this.S1bipedLeftLeg.func_78785_a(par7);
/*      */         } 
/*      */         GL11.glPopMatrix();
/*      */       } 
/*      */     } else {
/*      */       float f5 = par7;
/*      */       float f6 = f;
/*      */       GL11.glPushMatrix();
/*      */       GL11.glScalef((0.5F + 0.5F / f6) * ((g <= 1) ? 1.0F : 0.85F), 0.5F + 0.5F / f6, (0.5F + 0.5F / f6) * ((g <= 1) ? 1.0F : 0.85F));
/*      */       GL11.glTranslatef(0.0F, (f6 - 1.0F) / f6 * (2.0F - ((f6 >= 1.5F && f6 <= 2.0F) ? ((2.0F - f6) / 2.5F) : ((f6 < 1.5F && f6 >= 1.0F) ? ((f6 * 2.0F - 2.0F) * 0.2F) : 0.0F))), 0.0F);
/*      */       if (skn == 0) {
/*      */         this.field_78116_c.func_78785_a(f5);
/*      */       } else if (skn == 1) {
/*      */         this.S1bipedHead.func_78785_a(f5);
/*      */       } 
/*      */       GL11.glPopMatrix();
/*      */       GL11.glPushMatrix();
/*      */       GL11.glScalef(1.0F / f6 * ((g <= 1) ? 1.0F : 0.7F), 1.0F / f6, 1.0F / f6 * ((g <= 1) ? 1.0F : 0.7F));
/*      */       GL11.glTranslatef(0.0F, (f6 - 1.0F) * 1.5F, 0.0F);
/*      */       if (skn == 0) {
/*      */         this.Brightarm.func_78785_a(f5);
/*      */       } else if (skn == 1) {
/*      */         this.S1Brightarm.func_78785_a(f5);
/*      */       } 
/*      */       if (skn == 0) {
/*      */         this.Bleftarm.func_78785_a(f5);
/*      */       } else if (skn == 1) {
/*      */         this.S1Bleftarm.func_78785_a(f5);
/*      */       } 
/*      */       GL11.glPopMatrix();
/*      */       GL11.glPushMatrix();
/*      */       GL11.glScalef(1.0F / f6 * ((g <= 1) ? 1.0F : 0.85F), 1.0F / f6, 1.0F / f6 * ((g <= 1) ? 1.0F : 0.775F));
/*      */       if (this.field_78117_n) {
/*      */         GL11.glTranslatef(-0.015F, (f6 - 1.0F) * 1.5F, -0.0F);
/*      */       } else {
/*      */         GL11.glTranslatef(-0.015F, (f6 - 1.0F) * 1.5F, -0.015F);
/*      */       } 
/*      */       if (skn == 0) {
/*      */         this.rightleg.func_78785_a(f5);
/*      */       } else if (skn == 1) {
/*      */         this.S1rightleg.func_78785_a(f5);
/*      */       } 
/*      */       GL11.glPopMatrix();
/*      */       GL11.glPushMatrix();
/*      */       GL11.glScalef(1.0F / f6 * ((g <= 1) ? 1.0F : 0.85F), 1.0F / f6, 1.0F / f6 * ((g <= 1) ? 1.0F : 0.775F));
/*      */       if (this.field_78117_n) {
/*      */         GL11.glTranslatef(0.015F, (f6 - 1.0F) * 1.5F, -0.0F);
/*      */       } else {
/*      */         GL11.glTranslatef(0.015F, (f6 - 1.0F) * 1.5F, -0.015F);
/*      */       } 
/*      */       if (skn == 0) {
/*      */         this.leftleg.func_78785_a(f5);
/*      */       } else if (skn == 1) {
/*      */         this.S1leftleg.func_78785_a(f5);
/*      */       } 
/*      */       GL11.glPopMatrix();
/*      */       GL11.glPushMatrix();
/*      */       GL11.glScalef(1.0F / f6 * ((g <= 1) ? 1.0F : 0.675F), 1.0F / f6, 1.0F / f6 * ((g <= 1) ? 1.0F : 0.8F));
/*      */       float scale = b * 0.03F;
/*      */       float br = 0.4235988F + scale;
/*      */       float bs = 0.8F + scale;
/*      */       float bsY = 0.85F + scale * 0.5F;
/*      */       float bt = 0.1F * scale;
/*      */       boolean bounce = (this.Entity.field_70122_E || this.Entity.func_70090_H());
/*      */       float bspeed = this.Entity.func_70051_ag() ? 1.5F : (this.Entity.func_70093_af() ? 0.5F : 1.0F);
/*      */       this;
/*      */       this;
/*      */       float bbY = (bounce ? (MathHelper.func_76126_a(rot1 * 0.6662F * bspeed * 1.5F + 3.1415927F) * rot2 * 0.03F) : 0.0F) * b * 0.1119F;
/*      */       GL11.glTranslatef(0.0F, (f6 - 1.0F) * 1.5F + bbY, 0.015F + bt);
/*      */       GL11.glScalef(1.0F, bsY, bs);
/*      */       setRotation(this.breast, -br, 0.0F, 0.0F);
/*      */       setRotation(this.S1breast, -br, 0.0F, 0.0F);
/*      */       setRotation(this.breast2, br, 3.141593F, 0.0F);
/*      */       setRotation(this.S1breast2, br, 3.141593F, 0.0F);
/*      */       if (bounce) {
/*      */         this;
/*      */         this;
/*      */         this.breast.field_78795_f += -MathHelper.func_76134_b(rot1 * 0.6662F * bspeed + 3.1415927F) * rot2 * 0.05F * b * 0.1119F;
/*      */         this;
/*      */         this;
/*      */         this.breast.field_78796_g += MathHelper.func_76134_b(rot1 * 0.6662F * bspeed + 3.1415927F) * rot2 * 0.02F * b * 0.1119F;
/*      */         this;
/*      */         this;
/*      */         this.breast2.field_78795_f += MathHelper.func_76134_b(rot1 * 0.6662F * bspeed + 3.1415927F) * rot2 * 0.05F * b * 0.1119F;
/*      */         this;
/*      */         this;
/*      */         this.breast2.field_78796_g += MathHelper.func_76134_b(rot1 * 0.6662F * bspeed + 3.1415927F) * rot2 * 0.02F * b * 0.1119F;
/*      */         this;
/*      */         this;
/*      */         this.S1breast.field_78795_f += -MathHelper.func_76134_b(rot1 * 0.6662F * bspeed + 3.1415927F) * rot2 * 0.05F * b * 0.1119F;
/*      */         this;
/*      */         this;
/*      */         this.S1breast.field_78796_g += MathHelper.func_76134_b(rot1 * 0.6662F * bspeed + 3.1415927F) * rot2 * 0.02F * b * 0.1119F;
/*      */         this;
/*      */         this;
/*      */         this.S1breast2.field_78795_f += MathHelper.func_76134_b(rot1 * 0.6662F * bspeed + 3.1415927F) * rot2 * 0.05F * b * 0.1119F;
/*      */         this;
/*      */         this;
/*      */         this.S1breast2.field_78796_g += MathHelper.func_76134_b(rot1 * 0.6662F * bspeed + 3.1415927F) * rot2 * 0.02F * b * 0.1119F;
/*      */       } 
/*      */       if (skn == 0) {
/*      */         this.Bbreast.func_78785_a(f5);
/*      */       } else if (skn == 1) {
/*      */         this.S1Bbreast.func_78785_a(f5);
/*      */       } 
/*      */       GL11.glPopMatrix();
/*      */       GL11.glPushMatrix();
/*      */       GL11.glScalef(1.0F / f6 * ((g <= 1) ? 1.0F : 0.7F), 1.0F / f6, 1.0F / f6 * ((g <= 1) ? 1.0F : 0.7F));
/*      */       GL11.glTranslatef(0.0F, (f6 - 1.0F) * 1.5F, 0.0F);
/*      */       if (skn == 0) {
/*      */         this.body.func_78785_a(f5);
/*      */       } else if (skn == 1) {
/*      */         this.S1body.func_78785_a(f5);
/*      */       } 
/*      */       GL11.glPopMatrix();
/*      */       GL11.glPushMatrix();
/*      */       GL11.glScalef(1.0F / f6 * ((g <= 1) ? 1.0F : 0.75F), 1.0F / f6, 1.0F / f6 * ((g <= 1) ? 1.0F : 0.75F) * (1.0F + 0.005F * p));
/*      */       if (this.field_78117_n) {
/*      */         GL11.glTranslatef(0.0F, (f6 - 1.0F) * 1.5F, 0.0F);
/*      */       } else {
/*      */         GL11.glTranslatef(0.0F, (f6 - 1.0F) * 1.5F, -0.018F - 5.0E-4F * p);
/*      */       } 
/*      */       if (skn == 0) {
/*      */         this.hip.func_78785_a(f5);
/*      */       } else if (skn == 1) {
/*      */         this.S1hip.func_78785_a(f5);
/*      */       } 
/*      */       GL11.glPopMatrix();
/*      */       if (p >= 30);
/*      */       GL11.glPushMatrix();
/*      */       GL11.glScalef(1.0F / f6 * ((g <= 1) ? 1.0F : 0.65F), 1.0F / f6, 1.0F / f6 * ((g <= 1) ? 1.0F : 0.65F) * (1.0F + 0.001F * p));
/*      */       if (this.field_78117_n) {
/*      */         GL11.glTranslatef(0.0F, (f6 - 1.0F) * 1.5F, 0.0F);
/*      */       } else {
/*      */         GL11.glTranslatef(0.0F, (f6 - 1.0F) * 1.5F, -0.04F - 1.0E-4F * p);
/*      */       } 
/*      */       if (skn == 0) {
/*      */         this.waist.func_78785_a(f5);
/*      */       } else if (skn == 1) {
/*      */         this.S1waist.func_78785_a(f5);
/*      */       } 
/*      */       GL11.glPopMatrix();
/*      */       GL11.glPushMatrix();
/*      */       GL11.glScalef(1.0F / f6 * ((g <= 1) ? 1.0F : 0.85F), 1.0F / f6, 1.0F / f6 * ((g <= 1) ? 1.0F : 0.85F) * (1.0F + 0.005F * p));
/*      */       GL11.glTranslatef(0.0F, (f6 - 1.0F) * 1.5F, 0.001F - 5.0E-4F * p);
/*      */       if (skn == 0) {
/*      */         this.bottom.func_78785_a(f5);
/*      */       } else if (skn == 1) {
/*      */         this.S1bottom.func_78785_a(f5);
/*      */       } 
/*      */       GL11.glPopMatrix();
/*      */       GL11.glPushMatrix();
/*      */       GL11.glScalef(1.0F / f6 * ((g <= 1) ? 1.0F : 0.675F) - 0.001F, 1.0F / f6, 1.0F / f6 * ((g <= 1) ? 1.0F : 0.8F) - 0.001F);
/*      */       GL11.glTranslatef(0.0F, (f6 - 1.0F) * 1.5F + 0.001F + bbY, 0.015F + bt);
/*      */       GL11.glScalef(1.0F, bsY, bs);
/*      */       if (skn == 0) {
/*      */         this.Bbreast2.func_78785_a(f5);
/*      */       } else if (skn == 1) {
/*      */         this.S1Bbreast2.func_78785_a(f5);
/*      */       } 
/*      */       GL11.glPopMatrix();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void modelCheck() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void transRot(float f5, ModelRenderer m) {
/*      */     GL11.glTranslatef(m.field_78800_c * f5, m.field_78797_d * f5, m.field_78798_e * f5);
/*      */     if (m.field_78808_h != 0.0F) {
/*      */       GL11.glRotatef(m.field_78808_h * 57.295776F, 0.0F, 0.0F, 1.0F);
/*      */     }
/*      */     if (m.field_78796_g != 0.0F) {
/*      */       GL11.glRotatef(m.field_78796_g * 57.295776F, 0.0F, 1.0F, 0.0F);
/*      */     }
/*      */     if (m.field_78795_f != 0.0F) {
/*      */       GL11.glRotatef(m.field_78795_f * 57.295776F, 1.0F, 0.0F, 0.0F);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ModelBipedJFC(float par1, float par2, int par3, int par4) {
/* 3740 */     this.b = 0; this.field_78119_l = 0; this.field_78120_m = 0; this.field_78117_n = false; this.field_78118_o = false; this.field_78090_t = par3; this.field_78089_u = par4; this.field_78122_k = new ModelRenderer((ModelBase)this, 0, 0); this.field_78122_k.func_78790_a(-5.0F, 0.0F, -1.0F, 10, 16, 1, par1); this.field_78121_j = new ModelRenderer((ModelBase)this, 24, 0); this.field_78121_j.func_78790_a(-3.0F, -6.0F, -1.0F, 6, 6, 1, par1); this.field_78116_c = new ModelRenderer((ModelBase)this, 0, 0); this.field_78116_c.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, par1); this.field_78116_c.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.field_78114_d = new ModelRenderer((ModelBase)this, 32, 0); this.field_78114_d.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, par1 + 0.5F); this.field_78114_d.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.field_78115_e = new ModelRenderer((ModelBase)this, 16, 16); this.field_78115_e.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 12, 4, par1); this.field_78115_e.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.field_78112_f = new ModelRenderer((ModelBase)this, 40, 16); this.field_78112_f.func_78790_a(-3.0F, -2.0F, -2.0F, 4, 12, 4, par1); this.field_78112_f.func_78793_a(-5.0F, 2.0F + par2, 0.0F); this.field_78113_g = new ModelRenderer((ModelBase)this, 40, 16); this.field_78113_g.field_78809_i = true; this.field_78113_g.func_78790_a(-1.0F, -2.0F, -2.0F, 4, 12, 4, par1); this.field_78113_g.func_78793_a(5.0F, 2.0F + par2, 0.0F); this.field_78123_h = new ModelRenderer((ModelBase)this, 0, 16); this.field_78123_h.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, par1); this.field_78123_h.func_78793_a(-1.9F, 12.0F + par2, 0.0F); this.field_78124_i = new ModelRenderer((ModelBase)this, 0, 16); this.field_78124_i.field_78809_i = true; this.field_78124_i.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, par1); this.field_78124_i.func_78793_a(1.9F, 12.0F + par2, 0.0F); this.bipedHeadg = new ModelRenderer((ModelBase)this, 0, 0); this.bipedHeadg.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.bipedHeadg.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.bipedHeadt = new ModelRenderer((ModelBase)this, 0, 0); this.bipedHeadt.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.bipedHeadt.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.bipedHeadsg = new ModelRenderer((ModelBase)this, 0, 0); this.bipedHeadsg.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.bipedHeadsg.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.bipedHeadssg = new ModelRenderer((ModelBase)this, 0, 0); this.bipedHeadssg.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.bipedHeadssg.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.bipedHeadst = new ModelRenderer((ModelBase)this, 0, 0); this.bipedHeadst.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.bipedHeadst.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.bipedHeadsst = new ModelRenderer((ModelBase)this, 0, 0); this.bipedHeadsst.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.bipedHeadsst.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.bipedHeadv = new ModelRenderer((ModelBase)this, 0, 0); this.bipedHeadv.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.bipedHeadv.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.bipedHeadsv = new ModelRenderer((ModelBase)this, 0, 0); this.bipedHeadsv.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.bipedHeadsv.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.bipedHeadssv = new ModelRenderer((ModelBase)this, 0, 0); this.bipedHeadssv.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.bipedHeadssv.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.bipedHeadgh = new ModelRenderer((ModelBase)this, 0, 0); this.bipedHeadgh.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.bipedHeadgh.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.bipedHeadsgh = new ModelRenderer((ModelBase)this, 0, 0); this.bipedHeadsgh.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.bipedHeadsgh.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.bipedHeadssgh = new ModelRenderer((ModelBase)this, 0, 0); this.bipedHeadssgh.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.bipedHeadssgh.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.bipedHeadnull = new ModelRenderer((ModelBase)this, 0, 0); this.bipedHeadnull.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.bipedHeadnull.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.bipedHeadg2 = new ModelRenderer((ModelBase)this, 0, 0); this.bipedHeadg2.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.bipedHeadg2.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.bipedHeadght = new ModelRenderer((ModelBase)this, 0, 0); this.bipedHeadght.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.bipedHeadght.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.bipedHeadgt = new ModelRenderer((ModelBase)this, 0, 0); this.bipedHeadgt.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.bipedHeadgt.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.bipedHeadgtt = new ModelRenderer((ModelBase)this, 0, 0); this.bipedHeadgtt.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.bipedHeadgtt.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.bipedHeadc7 = new ModelRenderer((ModelBase)this, 0, 0); this.bipedHeadc7.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.bipedHeadc7.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.bipedHeadc8 = new ModelRenderer((ModelBase)this, 0, 0); this.bipedHeadc8.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.bipedHeadc8.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.bipedHeadrad = new ModelRenderer((ModelBase)this, 0, 0); this.bipedHeadrad.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.bipedHeadrad.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.bipedHeadradl2 = new ModelRenderer((ModelBase)this, 0, 0); this.bipedHeadradl2.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.bipedHeadradl2.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.bipedHeadradl = new ModelRenderer((ModelBase)this, 0, 0); this.bipedHeadradl.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.bipedHeadradl.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.bipedHeadssj3 = new ModelRenderer((ModelBase)this, 0, 0); this.bipedHeadssj3.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.bipedHeadssj3.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.bipedHeadssj3l = new ModelRenderer((ModelBase)this, 0, 0); this.bipedHeadssj3l.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.bipedHeadssj3l.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.bipedHeadssj3t = new ModelRenderer((ModelBase)this, 0, 0); this.bipedHeadssj3t.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.bipedHeadssj3t.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.bipedHeadssj3l2 = new ModelRenderer((ModelBase)this, 0, 0); this.bipedHeadssj3l2.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.bipedHeadssj3l2.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.bipedHeadAll = new ModelRenderer((ModelBase)this, 0, 0); this.bipedHeadAll.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, par1 + 0.01F); this.bipedHeadAll.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.goku1 = new ModelRenderer((ModelBase)this, 32, 0); this.goku1.func_78789_a(-1.0F, -10.0F, 0.0F, 4, 4, 4); this.goku1.func_78793_a(0.0F, 0.0F, 0.0F); this.goku1.func_78787_b(128, 64); this.goku1.field_78809_i = true; setRotation(this.goku1, 0.1745329F, 0.0F, -0.4363323F); this.goku2 = new ModelRenderer((ModelBase)this, 32, 0); this.goku2.func_78789_a(-8.0F, -4.5F, 0.0F, 4, 3, 3); this.goku2.func_78793_a(0.0F, 0.0F, 0.0F); this.goku2.func_78787_b(128, 64); this.goku2.field_78809_i = true; setRotation(this.goku2, 0.0F, -0.1745329F, 0.3490659F); this.goku3 = new ModelRenderer((ModelBase)this, 32, 0); this.goku3.func_78789_a(-7.0F, -2.6F, 1.0F, 4, 2, 2); this.goku3.func_78793_a(0.0F, 0.0F, 0.0F); this.goku3.func_78787_b(128, 64); this.goku3.field_78809_i = true; setRotation(this.goku3, 0.0F, -0.2617994F, 0.1943133F); this.goku4 = new ModelRenderer((ModelBase)this, 32, 0); this.goku4.func_78789_a(3.0F, -4.0F, 0.0F, 4, 3, 3); this.goku4.func_78793_a(0.0F, 0.0F, 0.0F); this.goku4.func_78787_b(128, 64); this.goku4.field_78809_i = true; setRotation(this.goku4, 0.0F, 0.1745329F, -0.3490659F); this.goku5 = new ModelRenderer((ModelBase)this, 32, 0); this.goku5.func_78789_a(3.0F, -2.3F, 0.7F, 3, 2, 2); this.goku5.func_78793_a(0.0F, 0.0F, 0.0F); this.goku5.func_78787_b(128, 64); this.goku5.field_78809_i = true; setRotation(this.goku5, 0.0F, 0.1745329F, -0.1151917F); this.goku6 = new ModelRenderer((ModelBase)this, 32, 0); this.goku6.func_78789_a(5.0F, -4.3F, 1.5F, 3, 2, 2); this.goku6.func_78793_a(0.0F, 0.0F, 0.0F); this.goku6.func_78787_b(128, 64); this.goku6.field_78809_i = true; setRotation(this.goku6, 0.0F, 0.3490659F, -0.2617994F); this.goku7 = new ModelRenderer((ModelBase)this, 32, 0); this.goku7.func_78789_a(1.0F, -11.0F, 2.0F, 3, 3, 3); this.goku7.func_78793_a(0.0F, 0.0F, 0.0F); this.goku7.func_78787_b(128, 64); this.goku7.field_78809_i = true; setRotation(this.goku7, 0.3490659F, 0.0F, -0.6108652F); this.goku8 = new ModelRenderer((ModelBase)this, 32, 0); this.goku8.func_78789_a(3.0F, -12.0F, 4.0F, 2, 3, 2); this.goku8.func_78793_a(0.0F, 0.0F, 0.0F); this.goku8.func_78787_b(128, 64); this.goku8.field_78809_i = true; setRotation(this.goku8, 0.5235988F, 0.0F, -0.7853982F); this.goku9 = new ModelRenderer((ModelBase)this, 32, 0); this.goku9.func_78789_a(-9.0F, -4.7F, 1.5F, 3, 2, 2); this.goku9.func_78793_a(0.0F, 0.0F, 0.0F); this.goku9.func_78787_b(128, 64); this.goku9.field_78809_i = true; setRotation(this.goku9, 0.0F, -0.3490659F, 0.2617994F); this.goku10 = new ModelRenderer((ModelBase)this, 32, 0); this.goku10.func_78789_a(-10.0F, -4.8F, 1.0F, 5, 2, 2); this.goku10.func_78793_a(0.0F, 0.0F, 0.0F); this.goku10.func_78787_b(128, 64); this.goku10.field_78809_i = true; setRotation(this.goku10, 0.0F, -0.3839724F, 0.5270894F); this.goku11 = new ModelRenderer((ModelBase)this, 32, 0); this.goku11.func_78789_a(1.0F, -8.0F, 5.0F, 1, 4, 1); this.goku11.func_78793_a(0.0F, 0.0F, 0.0F); this.goku11.func_78787_b(128, 64); this.goku11.field_78809_i = true; setRotation(this.goku11, 0.6806784F, 0.0F, -0.1745329F); this.goku12 = new ModelRenderer((ModelBase)this, 32, 0); this.goku12.func_78789_a(-3.5F, -7.0F, -5.0F, 2, 3, 3); this.goku12.func_78793_a(0.0F, 0.0F, 0.0F); this.goku12.func_78787_b(128, 64); this.goku12.field_78809_i = true; setRotation(this.goku12, 0.0F, 0.0F, 0.4014257F); this.goku13 = new ModelRenderer((ModelBase)this, 32, 0); this.goku13.func_78789_a(-6.2F, -5.5F, -5.0F, 2, 3, 2); this.goku13.func_78793_a(0.0F, 0.0F, 0.0F); this.goku13.func_78787_b(128, 64); this.goku13.field_78809_i = true; setRotation(this.goku13, 0.0F, 0.0F, 0.5235988F); this.goku14 = new ModelRenderer((ModelBase)this, 32, 0); this.goku14.func_78789_a(-7.5F, -4.0F, -5.0F, 1, 3, 2); this.goku14.func_78793_a(0.0F, 0.0F, 0.0F); this.goku14.func_78787_b(128, 64); this.goku14.field_78809_i = true; setRotation(this.goku14, 0.0F, 0.0F, 0.6108652F); this.goku15 = new ModelRenderer((ModelBase)this, 32, 0); this.goku15.func_78789_a(3.2F, -6.5F, -5.0F, 2, 3, 2); this.goku15.func_78793_a(0.0F, 0.0F, 0.0F); this.goku15.func_78787_b(128, 64); this.goku15.field_78809_i = true; setRotation(this.goku15, 0.0F, 0.0F, -0.3490659F); this.goku16 = new ModelRenderer((ModelBase)this, 32, 0); this.goku16.func_78789_a(6.5F, -4.5F, -5.0F, 1, 3, 2); this.goku16.func_78793_a(0.0F, 0.0F, 0.0F); this.goku16.func_78787_b(128, 64); this.goku16.field_78809_i = true; setRotation(this.goku16, 0.0F, 0.0F, -0.6108652F); this.sgoku1 = new ModelRenderer((ModelBase)this, 32, 0); this.sgoku1.func_78789_a(-1.0F, -10.0F, -6.0F, 4, 4, 4); this.sgoku1.func_78793_a(0.0F, 0.0F, 0.0F); this.sgoku1.func_78787_b(128, 64); this.sgoku1.field_78809_i = true; setRotation(this.sgoku1, -0.3141593F, 0.0F, 0.0F); this.sgoku2 = new ModelRenderer((ModelBase)this, 32, 0); this.sgoku2.func_78789_a(-8.0F, -4.5F, -1.0F, 4, 3, 3); this.sgoku2.func_78793_a(0.0F, 0.0F, 0.0F); this.sgoku2.func_78787_b(128, 64); this.sgoku2.field_78809_i = true; setRotation(this.sgoku2, 0.0F, 0.1745329F, 0.5759587F); this.sgoku3 = new ModelRenderer((ModelBase)this, 32, 0); this.sgoku3.func_78789_a(-7.0F, -2.0F, 0.0F, 4, 2, 2); this.sgoku3.func_78793_a(0.0F, 0.0F, 0.0F); this.sgoku3.func_78787_b(128, 64); this.sgoku3.field_78809_i = true; setRotation(this.sgoku3, 0.0F, 0.2617994F, 0.5061455F); this.sgoku4 = new ModelRenderer((ModelBase)this, 32, 0); this.sgoku4.func_78789_a(4.0F, -4.0F, -1.0F, 4, 3, 3); this.sgoku4.func_78793_a(0.0F, 0.0F, 0.0F); this.sgoku4.func_78787_b(128, 64); this.sgoku4.field_78809_i = true; setRotation(this.sgoku4, 0.0F, -0.1745329F, -0.6108652F); this.sgoku5 = new ModelRenderer((ModelBase)this, 32, 0); this.sgoku5.func_78789_a(3.0F, -2.0F, 0.7F, 4, 2, 2); this.sgoku5.func_78793_a(0.0F, 0.0F, 0.0F); this.sgoku5.func_78787_b(128, 64); this.sgoku5.field_78809_i = true; setRotation(this.sgoku5, 0.0F, -0.1745329F, -0.5061455F); this.sgoku6 = new ModelRenderer((ModelBase)this, 32, 0); this.sgoku6.func_78789_a(7.0F, -2.0F, -1.5F, 3, 2, 2); this.sgoku6.func_78793_a(0.0F, 0.0F, 0.0F); this.sgoku6.func_78787_b(128, 64); this.sgoku6.field_78809_i = true; setRotation(this.sgoku6, 0.0F, -0.3490659F, -0.9250245F); this.sgoku7 = new ModelRenderer((ModelBase)this, 32, 0); this.sgoku7.func_78789_a(-0.5F, -12.0F, -6.0F, 3, 3, 3); this.sgoku7.func_78793_a(0.0F, 0.0F, 0.0F); this.sgoku7.func_78787_b(128, 64); this.sgoku7.field_78809_i = true; setRotation(this.sgoku7, -0.4363323F, 0.0F, 0.0F); this.sgoku8 = new ModelRenderer((ModelBase)this, 32, 0); this.sgoku8.func_78789_a(0.0F, -14.0F, -7.0F, 2, 3, 2); this.sgoku8.func_78793_a(0.0F, 0.0F, 0.0F); this.sgoku8.func_78787_b(128, 64); this.sgoku8.field_78809_i = true; setRotation(this.sgoku8, -0.5934119F, 0.0F, 0.0F); this.sgoku9 = new ModelRenderer((ModelBase)this, 32, 0); this.sgoku9.func_78789_a(-10.0F, -2.166667F, -1.5F, 3, 2, 2); this.sgoku9.func_78793_a(0.0F, 0.0F, 0.0F); this.sgoku9.func_78787_b(128, 64); this.sgoku9.field_78809_i = true; setRotation(this.sgoku9, 0.0F, 0.3490659F, 0.8901179F); this.sgoku10 = new ModelRenderer((ModelBase)this, 32, 0); this.sgoku10.func_78789_a(-1.0F, -10.0F, -6.0F, 4, 6, 4); this.sgoku10.func_78793_a(0.0F, 0.0F, 0.0F); this.sgoku10.func_78787_b(128, 64); this.sgoku10.field_78809_i = true; setRotation(this.sgoku10, -0.4363323F, 0.0F, -0.4014257F); this.sgoku11 = new ModelRenderer((ModelBase)this, 32, 0); this.sgoku11.func_78789_a(-0.5F, -12.0F, -6.0F, 5, 4, 3); this.sgoku11.func_78793_a(0.0F, 0.0F, 0.0F); this.sgoku11.func_78787_b(128, 64); this.sgoku11.field_78809_i = true; setRotation(this.sgoku11, -0.5410521F, 0.0F, -0.3665191F); this.sgoku12 = new ModelRenderer((ModelBase)this, 32, 0); this.sgoku12.func_78789_a(-0.5F, -14.0F, -6.0F, 3, 3, 3); this.sgoku12.func_78793_a(0.0F, 0.0F, 0.0F); this.sgoku12.func_78787_b(128, 64); this.sgoku12.field_78809_i = true; setRotation(this.sgoku12, -0.6108652F, 0.0F, -0.2443461F); this.sgoku13 = new ModelRenderer((ModelBase)this, 32, 0); this.sgoku13.func_78789_a(0.0F, -15.4F, -7.0F, 2, 5, 2); this.sgoku13.func_78793_a(0.0F, 0.0F, 0.0F); this.sgoku13.func_78787_b(128, 64); this.sgoku13.field_78809_i = true; setRotation(this.sgoku13, -0.6981317F, 0.0F, -0.122173F); this.sgoku14 = new ModelRenderer((ModelBase)this, 32, 0); this.sgoku14.func_78789_a(-1.5F, -9.0F, -5.0F, 3, 5, 3); this.sgoku14.func_78793_a(0.0F, 0.0F, 0.0F); this.sgoku14.func_78787_b(128, 64); this.sgoku14.field_78809_i = true; setRotation(this.sgoku14, -0.3665191F, 0.0F, 0.4363323F); this.sgoku15 = new ModelRenderer((ModelBase)this, 32, 0); this.sgoku15.func_78789_a(-0.5F, -10.0F, -6.0F, 3, 3, 3); this.sgoku15.func_78793_a(0.0F, 0.0F, 0.0F); this.sgoku15.func_78787_b(128, 64); this.sgoku15.field_78809_i = true; setRotation(this.sgoku15, -0.5410521F, 0.0F, 0.2455096F); this.sgoku16 = new ModelRenderer((ModelBase)this, 32, 0); this.sgoku16.func_78789_a(-1.0F, -12.0F, -6.0F, 3, 3, 3); this.sgoku16.func_78793_a(0.0F, 0.0F, 0.0F); this.sgoku16.func_78787_b(128, 64); this.sgoku16.field_78809_i = true; setRotation(this.sgoku16, -0.5759587F, 0.0F, 0.1396263F); this.sgoku17 = new ModelRenderer((ModelBase)this, 32, 0); this.sgoku17.func_78789_a(-2.0F, -9.0F, -1.0F, 4, 5, 4); this.sgoku17.func_78793_a(0.0F, 0.0F, 0.0F); this.sgoku17.func_78787_b(128, 64); this.sgoku17.field_78809_i = true; setRotation(this.sgoku17, -0.2792527F, 0.0F, 0.0F); this.sgoku18 = new ModelRenderer((ModelBase)this, 32, 0); this.sgoku18.func_78789_a(-1.0F, -10.0F, -1.0F, 4, 5, 4); this.sgoku18.func_78793_a(0.0F, 0.0F, 0.0F); this.sgoku18.func_78787_b(128, 64); this.sgoku18.field_78809_i = true; setRotation(this.sgoku18, -0.2443461F, 0.2617994F, 0.0174533F); this.sgoku19 = new ModelRenderer((ModelBase)this, 32, 0); this.sgoku19.func_78789_a(-4.0F, -11.0F, -1.0F, 4, 6, 4); this.sgoku19.func_78793_a(0.0F, 0.0F, 0.0F); this.sgoku19.func_78787_b(128, 64); this.sgoku19.field_78809_i = true; setRotation(this.sgoku19, -0.2443461F, -0.2617994F, 0.0174533F); this.sgoku20 = new ModelRenderer((ModelBase)this, 32, 0); this.sgoku20.func_78789_a(-2.0F, -13.0F, -1.0F, 3, 5, 4); this.sgoku20.func_78793_a(0.0F, 0.0F, 0.0F); this.sgoku20.func_78787_b(128, 64); this.sgoku20.field_78809_i = true; setRotation(this.sgoku20, -0.1396263F, 0.0F, 0.0F); this.sgoku21 = new ModelRenderer((ModelBase)this, 32, 0); this.sgoku21.func_78789_a(-1.0F, -14.0F, 0.0F, 3, 5, 3); this.sgoku21.func_78793_a(0.0F, 0.0F, 0.0F); this.sgoku21.func_78787_b(128, 64); this.sgoku21.field_78809_i = true; setRotation(this.sgoku21, -0.122173F, 0.1745329F, 0.0F); this.sgoku22 = new ModelRenderer((ModelBase)this, 32, 0); this.sgoku22.func_78789_a(-2.866667F, -13.2F, -0.6666667F, 3, 4, 3); this.sgoku22.func_78793_a(0.0F, 0.0F, 0.0F); this.sgoku22.func_78787_b(128, 64); this.sgoku22.field_78809_i = true; setRotation(this.sgoku22, -0.2443461F, -0.2617994F, 0.0174533F); this.sgoku23 = new ModelRenderer((ModelBase)this, 32, 0); this.sgoku23.func_78789_a(2.466667F, -6.5F, -5.333333F, 2, 3, 3); this.sgoku23.func_78793_a(0.0F, 0.0F, 0.0F); this.sgoku23.func_78787_b(128, 64); this.sgoku23.field_78809_i = true; setRotation(this.sgoku23, 0.0F, 0.0F, -0.4014257F); this.sgoku24 = new ModelRenderer((ModelBase)this, 32, 0); this.sgoku24.func_78789_a(-3.7F, -6.7F, -5.533333F, 2, 3, 3); this.sgoku24.func_78793_a(0.0F, 0.0F, 0.0F); this.sgoku24.func_78787_b(128, 64); this.sgoku24.field_78809_i = true; setRotation(this.sgoku24, 0.0F, 0.0F, 0.3665191F); this.sgoku25 = new ModelRenderer((ModelBase)this, 32, 0); this.sgoku25.func_78789_a(-7.0F, -4.5F, -5.0F, 2, 3, 3); this.sgoku25.func_78793_a(0.0F, 0.0F, 0.0F); this.sgoku25.func_78787_b(128, 64); this.sgoku25.field_78809_i = true; setRotation(this.sgoku25, 0.0F, 0.0F, 0.6806784F); this.sgoku26 = new ModelRenderer((ModelBase)this, 32, 0); this.sgoku26.func_78789_a(5.3F, -4.5F, -5.266667F, 2, 3, 3); this.sgoku26.func_78793_a(0.0F, 0.0F, 0.0F); this.sgoku26.func_78787_b(128, 64); this.sgoku26.field_78809_i = true; setRotation(this.sgoku26, 0.0F, 0.0F, -0.5934119F); this.ssgoku1 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgoku1.func_78789_a(-1.0F, -10.0F, -6.0F, 4, 4, 4); this.ssgoku1.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgoku1, -0.3141593F, 0.0F, 0.0F); this.ssgoku2 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgoku2.func_78789_a(-8.8F, -4.5F, -1.0F, 4, 3, 3); this.ssgoku2.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgoku2, 0.0F, 0.1745329F, 0.6108652F); this.ssgoku3 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgoku3.func_78789_a(-7.3F, -2.0F, 0.0F, 4, 2, 2); this.ssgoku3.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgoku3, 0.0F, 0.2617994F, 0.5410521F); this.ssgoku4 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgoku4.func_78789_a(4.8F, -4.0F, -1.0F, 4, 3, 3); this.ssgoku4.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgoku4, 0.0F, -0.1745329F, -0.6806784F); this.ssgoku5 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgoku5.func_78789_a(3.8F, -2.0F, 0.7F, 4, 2, 2); this.ssgoku5.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgoku5, 0.0F, -0.1745329F, -0.6108652F); this.ssgoku6 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgoku6.func_78789_a(7.8F, -2.0F, -1.5F, 3, 2, 2); this.ssgoku6.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgoku6, 0.0F, -0.3490659F, -0.9599311F); this.ssgoku7 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgoku7.func_78789_a(-0.5F, -12.0F, -6.0F, 3, 3, 3); this.ssgoku7.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgoku7, -0.4014257F, 0.0F, 0.0F); this.ssgoku8 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgoku8.func_78789_a(0.0F, -14.0F, -7.0F, 2, 3, 2); this.ssgoku8.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgoku8, -0.5410521F, 0.0F, 0.0F); this.ssgoku9 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgoku9.func_78789_a(-10.8F, -2.166667F, -1.5F, 3, 2, 2); this.ssgoku9.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgoku9, 0.0F, 0.3490659F, 0.9250245F); this.ssgoku10 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgoku10.func_78789_a(-1.0F, -10.3F, -6.0F, 4, 6, 4); this.ssgoku10.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgoku10, -0.4363323F, 0.0F, -0.3665191F); this.ssgoku11 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgoku11.func_78789_a(-0.5F, -12.3F, -6.0F, 5, 4, 3); this.ssgoku11.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgoku11, -0.5410521F, 0.0F, -0.3316126F); this.ssgoku12 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgoku12.func_78789_a(-0.5F, -14.5F, -6.0F, 3, 3, 3); this.ssgoku12.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgoku12, -0.5934119F, 0.0F, -0.2268928F); this.ssgoku13 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgoku13.func_78789_a(0.0F, -15.4F, -7.0F, 2, 5, 2); this.ssgoku13.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgoku13, -0.6806784F, 0.0F, -0.0698132F); this.ssgoku14 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgoku14.func_78789_a(-1.3F, -9.3F, -5.0F, 3, 5, 3); this.ssgoku14.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgoku14, -0.3665191F, 0.0F, 0.4014257F); this.ssgoku15 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgoku15.func_78789_a(-0.5F, -10.8F, -6.0F, 3, 3, 3); this.ssgoku15.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgoku15, -0.5410521F, 0.0F, 0.2617994F); this.ssgoku16 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgoku16.func_78789_a(-1.0F, -12.8F, -6.0F, 3, 3, 3); this.ssgoku16.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgoku16, -0.5759587F, 0.0F, 0.1745329F); this.ssgoku17 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgoku17.func_78789_a(-2.0F, -9.0F, -1.0F, 4, 5, 4); this.ssgoku17.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgoku17, -0.2792527F, 0.0F, 0.0F); this.ssgoku18 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgoku18.func_78789_a(-1.0F, -10.0F, -1.0F, 4, 5, 4); this.ssgoku18.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgoku18, -0.2443461F, 0.2617994F, 0.0174533F); this.ssgoku19 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgoku19.func_78789_a(-4.0F, -11.0F, -1.0F, 4, 6, 4); this.ssgoku19.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgoku19, -0.2443461F, -0.2617994F, 0.0174533F); this.ssgoku20 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgoku20.func_78789_a(-2.0F, -13.0F, -1.0F, 3, 5, 4); this.ssgoku20.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgoku20, -0.1396263F, 0.0F, 0.0F); this.ssgoku21 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgoku21.func_78789_a(-0.6F, -14.5F, 0.0F, 3, 5, 3); this.ssgoku21.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgoku21, -0.122173F, 0.1745329F, 0.0F); this.ssgoku22 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgoku22.func_78789_a(-2.866667F, -13.2F, -0.6666667F, 3, 4, 3); this.ssgoku22.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgoku22, -0.2443461F, -0.2617994F, 0.0174533F); this.ssgoku23 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgoku23.func_78789_a(-0.5333334F, -9.0F, -6.333333F, 2, 3, 3); this.ssgoku23.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgoku23, -0.1745329F, 0.0F, 0.1919862F); this.ssgoku24 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgoku24.func_78789_a(-3.7F, -6.7F, -5.533333F, 2, 3, 3); this.ssgoku24.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgoku24, 0.0F, 0.0F, 0.3665191F); this.ssgoku25 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgoku25.func_78789_a(-8.2F, -4.1F, -5.0F, 2, 3, 3); this.ssgoku25.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgoku25, 0.0F, 0.0F, 0.6806784F); this.ssgoku26 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgoku26.func_78789_a(5.433333F, -4.5F, -5.266667F, 2, 3, 3); this.ssgoku26.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgoku26, 0.0F, 0.0F, -0.5934119F); this.trunk1 = new ModelRenderer((ModelBase)this, 32, 0); this.trunk1.func_78789_a(4.7F, -6.4F, -4.2F, 4, 6, 3); this.trunk1.func_78793_a(0.0F, 0.0F, 0.0F); this.trunk1.func_78787_b(128, 64); this.trunk1.field_78809_i = true; setRotation(this.trunk1, 0.1745329F, 0.0F, -0.8028515F); this.trunk2 = new ModelRenderer((ModelBase)this, 32, 0); this.trunk2.func_78789_a(-8.733334F, -6.4F, -4.0F, 4, 6, 3); this.trunk2.func_78793_a(0.0F, 0.0F, 0.0F); this.trunk2.func_78787_b(128, 64); this.trunk2.field_78809_i = true; setRotation(this.trunk2, 0.1745329F, 0.0F, 0.8028515F); this.trunk3 = new ModelRenderer((ModelBase)this, 32, 0); this.trunk3.func_78789_a(3.0F, -8.0F, -1.2F, 4, 6, 3); this.trunk3.func_78793_a(0.0F, 0.0F, 0.0F); this.trunk3.func_78787_b(128, 64); this.trunk3.field_78809_i = true; setRotation(this.trunk3, 0.1745329F, -0.0872665F, -0.4014257F); this.trunk4 = new ModelRenderer((ModelBase)this, 32, 0); this.trunk4.func_78789_a(3.0F, -7.6F, 1.6F, 4, 6, 3); this.trunk4.func_78793_a(0.0F, 0.0F, 0.0F); this.trunk4.func_78787_b(128, 64); this.trunk4.field_78809_i = true; setRotation(this.trunk4, 0.1745329F, -0.0174533F, -0.4014257F); this.trunk5 = new ModelRenderer((ModelBase)this, 32, 0); this.trunk5.func_78789_a(-7.0F, -7.6F, 1.8F, 4, 6, 3); this.trunk5.func_78793_a(0.0F, 0.0F, 0.0F); this.trunk5.func_78787_b(128, 64); this.trunk5.field_78809_i = true; setRotation(this.trunk5, 0.1745329F, -0.0174533F, 0.4014257F); this.trunk6 = new ModelRenderer((ModelBase)this, 32, 0); this.trunk6.func_78789_a(-7.0F, -8.0F, -1.2F, 4, 6, 3); this.trunk6.func_78793_a(0.0F, 0.0F, 0.0F); this.trunk6.func_78787_b(128, 64); this.trunk6.field_78809_i = true; setRotation(this.trunk6, 0.1745329F, 0.0872665F, 0.4014257F); this.trunk7 = new ModelRenderer((ModelBase)this, 32, 0); this.trunk7.func_78789_a(4.4F, -7.0F, 0.6F, 4, 5, 3); this.trunk7.func_78793_a(0.0F, 0.0F, 0.0F); this.trunk7.func_78787_b(128, 64); this.trunk7.field_78809_i = true; setRotation(this.trunk7, 0.0F, -0.6457718F, -0.3665191F); this.trunk8 = new ModelRenderer((ModelBase)this, 32, 0); this.trunk8.func_78789_a(-8.4F, -7.0F, 0.6F, 4, 5, 3); this.trunk8.func_78793_a(0.0F, 0.0F, 0.0F); this.trunk8.func_78787_b(128, 64); this.trunk8.field_78809_i = true; setRotation(this.trunk8, 0.0F, 0.6457718F, 0.3665191F); this.trunk9 = new ModelRenderer((ModelBase)this, 32, 0); this.trunk9.func_78789_a(-2.5F, -7.0F, 4.0F, 5, 4, 3); this.trunk9.func_78793_a(0.0F, 0.0F, 0.0F); this.trunk9.func_78787_b(128, 64); this.trunk9.field_78809_i = true; setRotation(this.trunk9, 0.08F, 0.0F, 0.0F); this.strunk1 = new ModelRenderer((ModelBase)this, 32, 0); this.strunk1.func_78789_a(-2.0F, -9.0F, -4.933333F, 6, 3, 4); this.strunk1.func_78793_a(0.0F, 0.0F, 0.0F); this.strunk1.func_78787_b(128, 64); this.strunk1.field_78809_i = true; setRotation(this.strunk1, -0.0872665F, 0.0F, 0.2443461F); this.strunk2 = new ModelRenderer((ModelBase)this, 32, 0); this.strunk2.func_78789_a(-4.0F, -9.0F, -5.0F, 6, 3, 4); this.strunk2.func_78793_a(0.0F, 0.0F, 0.0F); this.strunk2.func_78787_b(128, 64); this.strunk2.field_78809_i = true; setRotation(this.strunk2, -0.0872665F, 0.0F, -0.2443461F); this.strunk3 = new ModelRenderer((ModelBase)this, 32, 0); this.strunk3.func_78789_a(-7.0F, -9.0F, -2.0F, 6, 3, 3); this.strunk3.func_78793_a(0.0F, 0.0F, 0.0F); this.strunk3.func_78787_b(128, 64); this.strunk3.field_78809_i = true; setRotation(this.strunk3, -0.0872665F, 0.0F, 0.1745329F); this.strunk4 = new ModelRenderer((ModelBase)this, 32, 0); this.strunk4.func_78789_a(1.0F, -9.0F, -2.0F, 6, 3, 3); this.strunk4.func_78793_a(0.0F, 0.0F, 0.0F); this.strunk4.func_78787_b(128, 64); this.strunk4.field_78809_i = true; setRotation(this.strunk4, -0.0872665F, 0.0F, -0.1745329F); this.strunk5 = new ModelRenderer((ModelBase)this, 32, 0); this.strunk5.func_78789_a(3.0F, -9.0F, 1.0F, 6, 3, 3); this.strunk5.func_78793_a(0.0F, 0.0F, 0.0F); this.strunk5.func_78787_b(128, 64); this.strunk5.field_78809_i = true; setRotation(this.strunk5, -0.0872665F, 0.0F, -0.3490659F); this.strunk6 = new ModelRenderer((ModelBase)this, 32, 0); this.strunk6.func_78789_a(-9.0F, -9.0F, 1.0F, 6, 3, 3); this.strunk6.func_78793_a(0.0F, 0.0F, 0.0F); this.strunk6.func_78787_b(128, 64); this.strunk6.field_78809_i = true; setRotation(this.strunk6, -0.0872665F, 0.0F, 0.3490659F); this.strunk7 = new ModelRenderer((ModelBase)this, 32, 0); this.strunk7.func_78789_a(-1.0F, -11.46667F, -2.0F, 3, 6, 3); this.strunk7.func_78793_a(0.0F, 0.0F, 0.0F); this.strunk7.func_78787_b(128, 64); this.strunk7.field_78809_i = true; setRotation(this.strunk7, -0.1745329F, 0.0F, -0.5235988F); this.strunk8 = new ModelRenderer((ModelBase)this, 32, 0); this.strunk8.func_78789_a(-2.0F, -11.46667F, -2.0F, 3, 6, 3); this.strunk8.func_78793_a(0.0F, 0.0F, 0.0F); this.strunk8.func_78787_b(128, 64); this.strunk8.field_78809_i = true; setRotation(this.strunk8, -0.1745329F, 0.0F, 0.5235988F); this.strunk9 = new ModelRenderer((ModelBase)this, 32, 0); this.strunk9.func_78789_a(-1.0F, -13.46667F, 0.0F, 3, 8, 3); this.strunk9.func_78793_a(0.0F, 0.0F, 0.0F); this.strunk9.func_78787_b(128, 64); this.strunk9.field_78809_i = true; setRotation(this.strunk9, -0.1745329F, 0.0F, 0.3490659F); this.strunk10 = new ModelRenderer((ModelBase)this, 32, 0); this.strunk10.func_78789_a(-2.0F, -13.46667F, 0.0F, 3, 8, 3); this.strunk10.func_78793_a(0.0F, 0.0F, 0.0F); this.strunk10.func_78787_b(128, 64); this.strunk10.field_78809_i = true; setRotation(this.strunk10, -0.1745329F, 0.0F, -0.3490659F); this.strunk11 = new ModelRenderer((ModelBase)this, 32, 0); this.strunk11.func_78789_a(-3.0F, -4.0F, 5.2F, 4, 3, 3); this.strunk11.func_78793_a(0.0F, 0.0F, 0.0F); this.strunk11.func_78787_b(128, 64); this.strunk11.field_78809_i = true; setRotation(this.strunk11, 0.5934119F, -0.6108652F, 0.0F); this.strunk12 = new ModelRenderer((ModelBase)this, 32, 0); this.strunk12.func_78789_a(-7.0F, -7.0F, -0.9333333F, 3, 3, 4); this.strunk12.func_78793_a(0.0F, 0.0F, 0.0F); this.strunk12.func_78787_b(128, 64); this.strunk12.field_78809_i = true; setRotation(this.strunk12, -0.0872665F, 0.0F, 0.2094395F); this.strunk13 = new ModelRenderer((ModelBase)this, 32, 0); this.strunk13.func_78789_a(4.133333F, -7.0F, -1.0F, 3, 3, 4); this.strunk13.func_78793_a(0.0F, 0.0F, 0.0F); this.strunk13.func_78787_b(128, 64); this.strunk13.field_78809_i = true; setRotation(this.strunk13, -0.0872665F, 0.0F, -0.2443461F); this.strunk14 = new ModelRenderer((ModelBase)this, 32, 0); this.strunk14.func_78789_a(-1.133333F, -4.0F, 5.2F, 4, 3, 3); this.strunk14.func_78793_a(0.0F, 0.0F, 0.0F); this.strunk14.func_78787_b(128, 64); this.strunk14.field_78809_i = true; setRotation(this.strunk14, 0.5934119F, 0.6108652F, 0.0F); this.strunk15 = new ModelRenderer((ModelBase)this, 32, 0); this.strunk15.func_78789_a(-3.133333F, -4.466667F, 4.933333F, 6, 3, 3); this.strunk15.func_78793_a(0.0F, 0.0F, 0.0F); this.strunk15.func_78787_b(128, 64); this.strunk15.field_78809_i = true; setRotation(this.strunk15, 0.5934119F, 0.0F, 0.0F); this.strunk16 = new ModelRenderer((ModelBase)this, 32, 0); this.strunk16.func_78789_a(-1.6F, -11.86667F, 1.0F, 2, 4, 2); this.strunk16.func_78793_a(0.0F, 0.0F, 0.0F); this.strunk16.func_78787_b(128, 64); this.strunk16.field_78809_i = true; setRotation(this.strunk16, -0.2792527F, 0.0F, 0.5235988F); this.strunk17 = new ModelRenderer((ModelBase)this, 32, 0); this.strunk17.func_78789_a(-0.4666667F, -11.86667F, 1.0F, 2, 4, 2); this.strunk17.func_78793_a(0.0F, 0.0F, 0.0F); this.strunk17.func_78787_b(128, 64); this.strunk17.field_78809_i = true; setRotation(this.strunk17, -0.2617994F, 0.0F, -0.5235988F); this.sstrunk1 = new ModelRenderer((ModelBase)this, 32, 0); this.sstrunk1.func_78789_a(-2.0F, -9.0F, -4.933333F, 6, 3, 4); this.sstrunk1.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.sstrunk1, -0.1047198F, 0.0F, 0.2268928F); this.sstrunk2 = new ModelRenderer((ModelBase)this, 32, 0); this.sstrunk2.func_78789_a(-4.0F, -9.0F, -5.0F, 6, 3, 4); this.sstrunk2.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.sstrunk2, -0.1047198F, 0.0F, -0.2268928F); this.sstrunk3 = new ModelRenderer((ModelBase)this, 32, 0); this.sstrunk3.func_78789_a(-11.0F, -7.0F, -2.0F, 6, 3, 3); this.sstrunk3.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.sstrunk3, -0.0872665F, 0.0F, 0.6981317F); this.sstrunk4 = new ModelRenderer((ModelBase)this, 32, 0); this.sstrunk4.func_78789_a(5.0F, -7.0F, -2.0F, 6, 3, 3); this.sstrunk4.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.sstrunk4, -0.0872665F, 0.0F, -0.6981317F); this.sstrunk5 = new ModelRenderer((ModelBase)this, 32, 0); this.sstrunk5.func_78789_a(6.0F, -2.3F, 1.0F, 6, 3, 3); this.sstrunk5.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.sstrunk5, -0.0872665F, 0.0F, -1.37881F); this.sstrunk6 = new ModelRenderer((ModelBase)this, 32, 0); this.sstrunk6.func_78789_a(-12.0F, -2.333333F, 1.0F, 6, 3, 3); this.sstrunk6.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.sstrunk6, -0.0872665F, 0.0F, 1.37881F); this.sstrunk7 = new ModelRenderer((ModelBase)this, 32, 0); this.sstrunk7.func_78789_a(-1.0F, -13.46667F, -2.0F, 3, 6, 3); this.sstrunk7.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.sstrunk7, -0.1745329F, 0.0F, -0.2268928F); this.sstrunk8 = new ModelRenderer((ModelBase)this, 32, 0); this.sstrunk8.func_78789_a(-2.0F, -13.46667F, -2.0F, 3, 6, 3); this.sstrunk8.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.sstrunk8, -0.1570796F, 0.0F, 0.2268928F); this.sstrunk9 = new ModelRenderer((ModelBase)this, 32, 0); this.sstrunk9.func_78789_a(-1.0F, -13.46667F, -1.0F, 3, 8, 3); this.sstrunk9.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.sstrunk9, -0.4363323F, 0.0F, 0.3490659F); this.sstrunk10 = new ModelRenderer((ModelBase)this, 32, 0); this.sstrunk10.func_78789_a(-2.0F, -13.46667F, -1.0F, 3, 8, 3); this.sstrunk10.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.sstrunk10, -0.4363323F, 0.0F, -0.3490659F); this.sstrunk11 = new ModelRenderer((ModelBase)this, 32, 0); this.sstrunk11.func_78789_a(-3.0F, -4.0F, 5.2F, 4, 3, 3); this.sstrunk11.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.sstrunk11, 0.5934119F, -0.6108652F, 0.0F); this.sstrunk12 = new ModelRenderer((ModelBase)this, 32, 0); this.sstrunk12.func_78789_a(-9.0F, -7.0F, -0.9333333F, 3, 3, 4); this.sstrunk12.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.sstrunk12, -0.0872665F, 0.0F, 0.3490659F); this.sstrunk13 = new ModelRenderer((ModelBase)this, 32, 0); this.sstrunk13.func_78789_a(6.0F, -7.0F, -1.0F, 3, 3, 4); this.sstrunk13.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.sstrunk13, -0.0872665F, 0.0F, -0.3490659F); this.sstrunk14 = new ModelRenderer((ModelBase)this, 32, 0); this.sstrunk14.func_78789_a(-1.133333F, -4.0F, 5.2F, 4, 3, 3); this.sstrunk14.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.sstrunk14, 0.5934119F, 0.6108652F, 0.0F); this.sstrunk15 = new ModelRenderer((ModelBase)this, 32, 0); this.sstrunk15.func_78789_a(-3.133333F, -4.466667F, 4.933333F, 6, 3, 3); this.sstrunk15.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.sstrunk15, 0.5934119F, 0.0F, 0.0F); this.sstrunk16 = new ModelRenderer((ModelBase)this, 32, 0); this.sstrunk16.func_78789_a(-2.0F, -11.86667F, 0.0F, 2, 4, 2); this.sstrunk16.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.sstrunk16, -0.5235988F, 0.0F, 0.2617994F); this.sstrunk17 = new ModelRenderer((ModelBase)this, 32, 0); this.sstrunk17.func_78789_a(0.0F, -11.86667F, 0.0F, 2, 4, 2); this.sstrunk17.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.sstrunk17, -0.5235988F, 0.0F, -0.2617994F); this.vegeta1 = new ModelRenderer((ModelBase)this, 32, 0); this.vegeta1.func_78789_a(-1.0F, -10.0F, -6.05F, 4, 4, 4); this.vegeta1.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.vegeta1, -0.3141593F, 0.0F, 0.0F); this.vegeta2 = new ModelRenderer((ModelBase)this, 32, 0); this.vegeta2.func_78789_a(-8.0F, -4.5F, -1.0F, 4, 3, 3); this.vegeta2.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.vegeta2, 0.0F, 0.1745329F, 0.5759587F); this.vegeta3 = new ModelRenderer((ModelBase)this, 32, 0); this.vegeta3.func_78789_a(-7.0F, -2.0F, 0.0F, 4, 2, 2); this.vegeta3.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.vegeta3, 0.0F, 0.2617994F, 0.5061455F); this.vegeta4 = new ModelRenderer((ModelBase)this, 32, 0); this.vegeta4.func_78789_a(4.0F, -4.0F, -1.0F, 4, 3, 3); this.vegeta4.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.vegeta4, 0.0F, -0.1745329F, -0.6108652F); this.vegeta5 = new ModelRenderer((ModelBase)this, 32, 0); this.vegeta5.func_78789_a(3.0F, -2.0F, 0.7F, 4, 2, 2); this.vegeta5.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.vegeta5, 0.0F, -0.1745329F, -0.5061455F); this.vegeta6 = new ModelRenderer((ModelBase)this, 32, 0); this.vegeta6.func_78789_a(7.0F, -2.0F, -1.5F, 3, 2, 2); this.vegeta6.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.vegeta6, 0.0F, -0.3490659F, -0.9250245F); this.vegeta7 = new ModelRenderer((ModelBase)this, 32, 0); this.vegeta7.func_78789_a(-0.5F, -12.0F, -6.0F, 3, 3, 3); this.vegeta7.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.vegeta7, -0.4363323F, 0.0F, 0.0F); this.vegeta8 = new ModelRenderer((ModelBase)this, 32, 0); this.vegeta8.func_78789_a(0.0F, -14.0F, -7.0F, 2, 3, 2); this.vegeta8.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.vegeta8, -0.5934119F, 0.0F, 0.0F); this.vegeta9 = new ModelRenderer((ModelBase)this, 32, 0); this.vegeta9.func_78789_a(-10.0F, -2.166667F, -1.5F, 3, 2, 2); this.vegeta9.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.vegeta9, 0.0F, 0.3490659F, 0.8901179F); this.vegeta10 = new ModelRenderer((ModelBase)this, 32, 0); this.vegeta10.func_78789_a(-1.0F, -10.0F, -6.2F, 4, 6, 4); this.vegeta10.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.vegeta10, -0.4363323F, 0.0F, -0.4014257F); this.vegeta11 = new ModelRenderer((ModelBase)this, 32, 0); this.vegeta11.func_78789_a(-0.5F, -12.0F, -6.0F, 5, 4, 3); this.vegeta11.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.vegeta11, -0.5410521F, 0.0F, -0.3665191F); this.vegeta12 = new ModelRenderer((ModelBase)this, 32, 0); this.vegeta12.func_78789_a(-0.5F, -14.0F, -6.0F, 3, 3, 3); this.vegeta12.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.vegeta12, -0.6108652F, 0.0F, -0.2443461F); this.vegeta13 = new ModelRenderer((ModelBase)this, 32, 0); this.vegeta13.func_78789_a(0.0F, -15.4F, -7.0F, 2, 5, 2); this.vegeta13.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.vegeta13, -0.6981317F, 0.0F, -0.122173F); this.vegeta14 = new ModelRenderer((ModelBase)this, 32, 0); this.vegeta14.func_78789_a(-1.5F, -9.0F, -5.5F, 3, 5, 3); this.vegeta14.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.vegeta14, -0.3665191F, 0.0F, 0.4363323F); this.vegeta15 = new ModelRenderer((ModelBase)this, 32, 0); this.vegeta15.func_78789_a(-0.5F, -10.0F, -6.0F, 3, 3, 3); this.vegeta15.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.vegeta15, -0.5410521F, 0.0F, 0.2455096F); this.vegeta16 = new ModelRenderer((ModelBase)this, 32, 0); this.vegeta16.func_78789_a(-1.0F, -12.0F, -6.0F, 3, 3, 3); this.vegeta16.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.vegeta16, -0.5759587F, 0.0F, 0.1396263F); this.vegeta17 = new ModelRenderer((ModelBase)this, 32, 0); this.vegeta17.func_78789_a(-2.0F, -9.0F, -1.0F, 4, 5, 4); this.vegeta17.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.vegeta17, -0.2792527F, 0.0F, 0.0F); this.vegeta18 = new ModelRenderer((ModelBase)this, 32, 0); this.vegeta18.func_78789_a(-1.0F, -10.0F, -1.0F, 4, 5, 4); this.vegeta18.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.vegeta18, -0.2443461F, 0.2617994F, 0.0174533F); this.vegeta19 = new ModelRenderer((ModelBase)this, 32, 0); this.vegeta19.func_78789_a(-4.0F, -11.0F, -1.0F, 4, 6, 4); this.vegeta19.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.vegeta19, -0.2443461F, -0.2617994F, 0.0174533F); this.vegeta20 = new ModelRenderer((ModelBase)this, 32, 0); this.vegeta20.func_78789_a(-2.0F, -13.0F, -1.0F, 3, 5, 4); this.vegeta20.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.vegeta20, -0.1396263F, 0.0F, 0.0F); this.vegeta21 = new ModelRenderer((ModelBase)this, 32, 0); this.vegeta21.func_78789_a(-1.0F, -14.0F, 0.0F, 3, 5, 3); this.vegeta21.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.vegeta21, -0.122173F, 0.1745329F, 0.0F); this.vegeta22 = new ModelRenderer((ModelBase)this, 32, 0); this.vegeta22.func_78789_a(-2.866667F, -13.2F, -0.6666667F, 3, 4, 3); this.vegeta22.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.vegeta22, -0.2443461F, -0.2617994F, 0.0174533F); this.svegeta1 = new ModelRenderer((ModelBase)this, 32, 0); this.svegeta1.func_78789_a(-1.0F, -10.0F, -6.05F, 4, 4, 4); this.svegeta1.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.svegeta1, -0.3141593F, 0.0F, 0.0F); this.svegeta2 = new ModelRenderer((ModelBase)this, 32, 0); this.svegeta2.func_78789_a(-8.0F, -4.5F, -1.0F, 4, 3, 3); this.svegeta2.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.svegeta2, 0.0F, 0.1745329F, 0.5759587F); this.svegeta3 = new ModelRenderer((ModelBase)this, 32, 0); this.svegeta3.func_78789_a(-7.0F, -2.0F, 0.0F, 4, 2, 2); this.svegeta3.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.svegeta3, 0.0F, 0.2617994F, 0.5061455F); this.svegeta4 = new ModelRenderer((ModelBase)this, 32, 0); this.svegeta4.func_78789_a(4.0F, -4.0F, -1.0F, 4, 3, 3); this.svegeta4.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.svegeta4, 0.0F, -0.1745329F, -0.6108652F); this.svegeta5 = new ModelRenderer((ModelBase)this, 32, 0); this.svegeta5.func_78789_a(3.0F, -2.0F, 0.7F, 4, 2, 2); this.svegeta5.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.svegeta5, 0.0F, -0.1745329F, -0.5061455F); this.svegeta6 = new ModelRenderer((ModelBase)this, 32, 0); this.svegeta6.func_78789_a(7.0F, -2.0F, -1.5F, 3, 2, 2); this.svegeta6.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.svegeta6, 0.0F, -0.3490659F, -0.9250245F); this.svegeta7 = new ModelRenderer((ModelBase)this, 32, 0); this.svegeta7.func_78789_a(-0.5F, -12.0F, -6.0F, 3, 3, 3); this.svegeta7.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.svegeta7, -0.4363323F, 0.0F, 0.0F); this.svegeta8 = new ModelRenderer((ModelBase)this, 32, 0); this.svegeta8.func_78789_a(0.0F, -14.0F, -7.0F, 2, 3, 2); this.svegeta8.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.svegeta8, -0.5934119F, 0.0F, 0.0F); this.svegeta9 = new ModelRenderer((ModelBase)this, 32, 0); this.svegeta9.func_78789_a(-10.0F, -2.166667F, -1.5F, 3, 2, 2); this.svegeta9.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.svegeta9, 0.0F, 0.3490659F, 0.8901179F); this.svegeta10 = new ModelRenderer((ModelBase)this, 32, 0); this.svegeta10.func_78789_a(-1.0F, -10.0F, -6.2F, 4, 6, 4); this.svegeta10.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.svegeta10, -0.4363323F, 0.0F, -0.4014257F); this.svegeta11 = new ModelRenderer((ModelBase)this, 32, 0); this.svegeta11.func_78789_a(-0.5F, -12.0F, -6.0F, 5, 4, 3); this.svegeta11.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.svegeta11, -0.5410521F, 0.0F, -0.3665191F); this.svegeta12 = new ModelRenderer((ModelBase)this, 32, 0); this.svegeta12.func_78789_a(-0.5F, -14.0F, -6.0F, 3, 3, 3); this.svegeta12.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.svegeta12, -0.6108652F, 0.0F, -0.2443461F); this.svegeta13 = new ModelRenderer((ModelBase)this, 32, 0); this.svegeta13.func_78789_a(0.0F, -15.4F, -7.0F, 2, 5, 2); this.svegeta13.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.svegeta13, -0.6981317F, 0.0F, -0.122173F); this.svegeta14 = new ModelRenderer((ModelBase)this, 32, 0); this.svegeta14.func_78789_a(-1.5F, -9.0F, -5.5F, 3, 5, 3); this.svegeta14.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.svegeta14, -0.3665191F, 0.0F, 0.4363323F); this.svegeta15 = new ModelRenderer((ModelBase)this, 32, 0); this.svegeta15.func_78789_a(-0.5F, -10.0F, -6.0F, 3, 3, 3); this.svegeta15.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.svegeta15, -0.5410521F, 0.0F, 0.2455096F); this.svegeta16 = new ModelRenderer((ModelBase)this, 32, 0); this.svegeta16.func_78789_a(-1.0F, -12.0F, -6.0F, 3, 3, 3); this.svegeta16.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.svegeta16, -0.5759587F, 0.0F, 0.1396263F); this.svegeta17 = new ModelRenderer((ModelBase)this, 32, 0); this.svegeta17.func_78789_a(-2.0F, -9.0F, -1.0F, 4, 5, 4); this.svegeta17.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.svegeta17, -0.2792527F, 0.0F, 0.0F); this.svegeta18 = new ModelRenderer((ModelBase)this, 32, 0); this.svegeta18.func_78789_a(-1.0F, -10.0F, -1.0F, 4, 5, 4); this.svegeta18.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.svegeta18, -0.2443461F, 0.2617994F, 0.0174533F); this.svegeta19 = new ModelRenderer((ModelBase)this, 32, 0); this.svegeta19.func_78789_a(-4.0F, -11.0F, -1.0F, 4, 6, 4); this.svegeta19.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.svegeta19, -0.2443461F, -0.2617994F, 0.0174533F); this.svegeta20 = new ModelRenderer((ModelBase)this, 32, 0); this.svegeta20.func_78789_a(-2.0F, -13.0F, -1.0F, 3, 5, 4); this.svegeta20.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.svegeta20, -0.1396263F, 0.0F, 0.0F); this.svegeta21 = new ModelRenderer((ModelBase)this, 32, 0); this.svegeta21.func_78789_a(-1.0F, -14.0F, 0.0F, 3, 5, 3); this.svegeta21.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.svegeta21, -0.122173F, 0.1745329F, 0.0F); this.svegeta22 = new ModelRenderer((ModelBase)this, 32, 0); this.svegeta22.func_78789_a(-2.866667F, -13.2F, -0.6666667F, 3, 4, 3); this.svegeta22.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.svegeta22, -0.2443461F, -0.2617994F, 0.0174533F); this.ssvegeta1 = new ModelRenderer((ModelBase)this, 32, 0); this.ssvegeta1.func_78789_a(-1.0F, -10.0F, -6.05F, 4, 4, 4); this.ssvegeta1.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssvegeta1, -0.3141593F, 0.0F, 0.0F); this.ssvegeta2 = new ModelRenderer((ModelBase)this, 32, 0); this.ssvegeta2.func_78789_a(-8.8F, -4.5F, -1.0F, 4, 3, 3); this.ssvegeta2.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssvegeta2, 0.0F, 0.1745329F, 0.6108652F); this.ssvegeta3 = new ModelRenderer((ModelBase)this, 32, 0); this.ssvegeta3.func_78789_a(-7.3F, -2.0F, 0.0F, 4, 2, 2); this.ssvegeta3.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssvegeta3, 0.0F, 0.2617994F, 0.5410521F); this.ssvegeta4 = new ModelRenderer((ModelBase)this, 32, 0); this.ssvegeta4.func_78789_a(4.8F, -4.0F, -1.0F, 4, 3, 3); this.ssvegeta4.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssvegeta4, 0.0F, -0.1745329F, -0.6806784F); this.ssvegeta5 = new ModelRenderer((ModelBase)this, 32, 0); this.ssvegeta5.func_78789_a(3.8F, -2.0F, 0.7F, 4, 2, 2); this.ssvegeta5.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssvegeta5, 0.0F, -0.1745329F, -0.6108652F); this.ssvegeta6 = new ModelRenderer((ModelBase)this, 32, 0); this.ssvegeta6.func_78789_a(7.8F, -2.0F, -1.5F, 3, 2, 2); this.ssvegeta6.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssvegeta6, 0.0F, -0.3490659F, -0.9599311F); this.ssvegeta7 = new ModelRenderer((ModelBase)this, 32, 0); this.ssvegeta7.func_78789_a(-0.5F, -12.0F, -6.0F, 3, 3, 3); this.ssvegeta7.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssvegeta7, -0.4014257F, 0.0F, 0.0F); this.ssvegeta8 = new ModelRenderer((ModelBase)this, 32, 0); this.ssvegeta8.func_78789_a(0.0F, -14.0F, -7.0F, 2, 3, 2); this.ssvegeta8.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssvegeta8, -0.5410521F, 0.0F, 0.0F); this.ssvegeta9 = new ModelRenderer((ModelBase)this, 32, 0); this.ssvegeta9.func_78789_a(-10.8F, -2.166667F, -1.5F, 3, 2, 2); this.ssvegeta9.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssvegeta9, 0.0F, 0.3490659F, 0.9250245F); this.ssvegeta10 = new ModelRenderer((ModelBase)this, 32, 0); this.ssvegeta10.func_78789_a(-1.0F, -10.3F, -6.3F, 4, 6, 4); this.ssvegeta10.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssvegeta10, -0.4363323F, 0.0F, -0.3665191F); this.ssvegeta11 = new ModelRenderer((ModelBase)this, 32, 0); this.ssvegeta11.func_78789_a(-0.5F, -12.3F, -6.0F, 5, 4, 3); this.ssvegeta11.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssvegeta11, -0.5410521F, 0.0F, -0.3316126F); this.ssvegeta12 = new ModelRenderer((ModelBase)this, 32, 0); this.ssvegeta12.func_78789_a(-0.5F, -14.5F, -6.0F, 3, 3, 3); this.ssvegeta12.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssvegeta12, -0.5934119F, 0.0F, -0.2268928F); this.ssvegeta13 = new ModelRenderer((ModelBase)this, 32, 0); this.ssvegeta13.func_78789_a(0.0F, -15.4F, -7.0F, 2, 5, 2); this.ssvegeta13.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssvegeta13, -0.6806784F, 0.0F, -0.0698132F); this.ssvegeta14 = new ModelRenderer((ModelBase)this, 32, 0); this.ssvegeta14.func_78789_a(-1.3F, -9.3F, -5.5F, 3, 5, 3); this.ssvegeta14.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssvegeta14, -0.3665191F, 0.0F, 0.4014257F); this.ssvegeta15 = new ModelRenderer((ModelBase)this, 32, 0); this.ssvegeta15.func_78789_a(-0.5F, -10.8F, -6.0F, 3, 3, 3); this.ssvegeta15.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssvegeta15, -0.5410521F, 0.0F, 0.2617994F); this.ssvegeta16 = new ModelRenderer((ModelBase)this, 32, 0); this.ssvegeta16.func_78789_a(-1.0F, -12.8F, -6.0F, 3, 3, 3); this.ssvegeta16.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssvegeta16, -0.5759587F, 0.0F, 0.1745329F); this.ssvegeta17 = new ModelRenderer((ModelBase)this, 32, 0); this.ssvegeta17.func_78789_a(-2.0F, -9.0F, -1.0F, 4, 5, 4); this.ssvegeta17.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssvegeta17, -0.2792527F, 0.0F, 0.0F); this.ssvegeta18 = new ModelRenderer((ModelBase)this, 32, 0); this.ssvegeta18.func_78789_a(-1.0F, -10.0F, -1.0F, 4, 5, 4); this.ssvegeta18.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssvegeta18, -0.2443461F, 0.2617994F, 0.0174533F); this.ssvegeta19 = new ModelRenderer((ModelBase)this, 32, 0); this.ssvegeta19.func_78789_a(-4.0F, -11.0F, -1.0F, 4, 6, 4); this.ssvegeta19.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssvegeta19, -0.2443461F, -0.2617994F, 0.0174533F); this.ssvegeta20 = new ModelRenderer((ModelBase)this, 32, 0); this.ssvegeta20.func_78789_a(-2.0F, -13.0F, -1.0F, 3, 5, 4); this.ssvegeta20.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssvegeta20, -0.1396263F, 0.0F, 0.0F); this.ssvegeta21 = new ModelRenderer((ModelBase)this, 32, 0); this.ssvegeta21.func_78789_a(-0.6F, -14.5F, 0.0F, 3, 5, 3); this.ssvegeta21.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssvegeta21, -0.122173F, 0.1745329F, 0.0F); this.ssvegeta22 = new ModelRenderer((ModelBase)this, 32, 0); this.ssvegeta22.func_78789_a(-2.866667F, -13.2F, -0.6666667F, 3, 4, 3); this.ssvegeta22.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssvegeta22, -0.2443461F, -0.2617994F, 0.0174533F); this.gohan1 = new ModelRenderer((ModelBase)this, 32, 0); this.gohan1.func_78789_a(-1.0F, -10.0F, -5.066667F, 4, 4, 4); this.gohan1.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.gohan1, -0.1745329F, 0.0F, 0.0F); this.gohan7 = new ModelRenderer((ModelBase)this, 32, 0); this.gohan7.func_78789_a(-0.5F, -11.0F, -6.0F, 3, 2, 3); this.gohan7.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.gohan7, -0.3665191F, 0.0F, 0.0F); this.gohan8 = new ModelRenderer((ModelBase)this, 32, 0); this.gohan8.func_78789_a(0.0F, -11.0F, -7.0F, 2, 2, 2); this.gohan8.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.gohan8, -0.5585054F, 0.0F, 0.0F); this.gohan10 = new ModelRenderer((ModelBase)this, 32, 0); this.gohan10.func_78789_a(-1.533333F, -10.3F, -5.466667F, 4, 5, 4); this.gohan10.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.gohan10, -0.2617994F, 0.0F, -0.3665191F); this.gohan11 = new ModelRenderer((ModelBase)this, 32, 0); this.gohan11.func_78789_a(-0.5F, -11.3F, -6.0F, 5, 4, 4); this.gohan11.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.gohan11, -0.418879F, 0.0F, -0.3316126F); this.gohan12 = new ModelRenderer((ModelBase)this, 32, 0); this.gohan12.func_78789_a(-0.5F, -12.5F, -6.0F, 3, 3, 3); this.gohan12.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.gohan12, -0.5235988F, 0.0F, -0.2268928F); this.gohan13 = new ModelRenderer((ModelBase)this, 32, 0); this.gohan13.func_78789_a(0.0F, -12.66667F, -7.0F, 2, 4, 2); this.gohan13.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.gohan13, -0.6283185F, 0.0F, -0.0698132F); this.gohan14 = new ModelRenderer((ModelBase)this, 32, 0); this.gohan14.func_78789_a(-1.3F, -9.3F, -5.0F, 3, 5, 3); this.gohan14.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.gohan14, -0.2268928F, 0.0F, 0.4014257F); this.gohan15 = new ModelRenderer((ModelBase)this, 32, 0); this.gohan15.func_78789_a(-0.8333333F, -10.8F, -6.0F, 3, 4, 4); this.gohan15.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.gohan15, -0.4537856F, 0.0F, 0.2617994F); this.gohan16 = new ModelRenderer((ModelBase)this, 32, 0); this.gohan16.func_78789_a(-1.0F, -12.46667F, -6.0F, 3, 4, 3); this.gohan16.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.gohan16, -0.5410521F, 0.0F, 0.1745329F); this.gohan17 = new ModelRenderer((ModelBase)this, 32, 0); this.gohan17.func_78789_a(-2.0F, -9.0F, -1.0F, 4, 5, 4); this.gohan17.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.gohan17, -0.2792527F, 0.0F, 0.0F); this.gohan18 = new ModelRenderer((ModelBase)this, 32, 0); this.gohan18.func_78789_a(-0.8F, -10.0F, -1.0F, 4, 5, 4); this.gohan18.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.gohan18, -0.2443461F, 0.2617994F, 0.0174533F); this.gohan19 = new ModelRenderer((ModelBase)this, 32, 0); this.gohan19.func_78789_a(-3.266667F, -10.0F, -1.0F, 4, 4, 4); this.gohan19.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.gohan19, -0.2443461F, -0.2617994F, 0.0174533F); this.gohan20 = new ModelRenderer((ModelBase)this, 32, 0); this.gohan20.func_78789_a(-2.0F, -12.0F, -1.0F, 3, 4, 4); this.gohan20.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.gohan20, -0.1396263F, 0.0F, 0.0F); this.gohan21 = new ModelRenderer((ModelBase)this, 32, 0); this.gohan21.func_78789_a(-0.6F, -11.5F, 0.0F, 3, 2, 3); this.gohan21.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.gohan21, -0.122173F, 0.1745329F, 0.0F); this.gohan22 = new ModelRenderer((ModelBase)this, 32, 0); this.gohan22.func_78789_a(-2.866667F, -11.53333F, -0.6666667F, 3, 4, 3); this.gohan22.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.gohan22, -0.2443461F, -0.2617994F, 0.0174533F); this.gohan26 = new ModelRenderer((ModelBase)this, 32, 0); this.gohan26.func_78789_a(4.433333F, -6.5F, -5.266667F, 2, 3, 3); this.gohan26.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.gohan26, 0.0F, 0.0F, -0.5934119F); this.sgohan1 = new ModelRenderer((ModelBase)this, 32, 0); this.sgohan1.func_78789_a(-1.0F, -10.0F, -5.066667F, 4, 4, 4); this.sgohan1.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.sgohan1, -0.1745329F, 0.0F, 0.0F); this.sgohan7 = new ModelRenderer((ModelBase)this, 32, 0); this.sgohan7.func_78789_a(-0.5F, -11.0F, -6.0F, 3, 2, 3); this.sgohan7.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.sgohan7, -0.3665191F, 0.0F, 0.0F); this.sgohan8 = new ModelRenderer((ModelBase)this, 32, 0); this.sgohan8.func_78789_a(0.0F, -11.0F, -7.0F, 2, 2, 2); this.sgohan8.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.sgohan8, -0.5585054F, 0.0F, 0.0F); this.sgohan10 = new ModelRenderer((ModelBase)this, 32, 0); this.sgohan10.func_78789_a(-1.533333F, -10.3F, -5.466667F, 4, 5, 4); this.sgohan10.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.sgohan10, -0.2617994F, 0.0F, -0.3665191F); this.sgohan11 = new ModelRenderer((ModelBase)this, 32, 0); this.sgohan11.func_78789_a(-0.5F, -11.3F, -6.0F, 5, 4, 4); this.sgohan11.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.sgohan11, -0.418879F, 0.0F, -0.3316126F); this.sgohan12 = new ModelRenderer((ModelBase)this, 32, 0); this.sgohan12.func_78789_a(-0.5F, -12.5F, -6.0F, 3, 3, 3); this.sgohan12.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.sgohan12, -0.5235988F, 0.0F, -0.2268928F); this.sgohan13 = new ModelRenderer((ModelBase)this, 32, 0); this.sgohan13.func_78789_a(0.0F, -12.66667F, -7.0F, 2, 4, 2); this.sgohan13.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.sgohan13, -0.6283185F, 0.0F, -0.0698132F); this.sgohan14 = new ModelRenderer((ModelBase)this, 32, 0); this.sgohan14.func_78789_a(-1.3F, -9.3F, -5.0F, 3, 5, 3); this.sgohan14.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.sgohan14, -0.2268928F, 0.0F, 0.4014257F); this.sgohan15 = new ModelRenderer((ModelBase)this, 32, 0); this.sgohan15.func_78789_a(-0.8333333F, -10.8F, -6.0F, 3, 4, 4); this.sgohan15.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.sgohan15, -0.4537856F, 0.0F, 0.2617994F); this.sgohan16 = new ModelRenderer((ModelBase)this, 32, 0); this.sgohan16.func_78789_a(-1.0F, -12.46667F, -6.0F, 3, 4, 3); this.sgohan16.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.sgohan16, -0.5410521F, 0.0F, 0.1745329F); this.sgohan17 = new ModelRenderer((ModelBase)this, 32, 0); this.sgohan17.func_78789_a(-2.0F, -9.0F, -1.0F, 4, 5, 4); this.sgohan17.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.sgohan17, -0.2792527F, 0.0F, 0.0F); this.sgohan18 = new ModelRenderer((ModelBase)this, 32, 0); this.sgohan18.func_78789_a(-0.8F, -10.0F, -1.0F, 4, 5, 4); this.sgohan18.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.sgohan18, -0.2443461F, 0.2617994F, 0.0174533F); this.sgohan19 = new ModelRenderer((ModelBase)this, 32, 0); this.sgohan19.func_78789_a(-3.266667F, -10.0F, -1.0F, 4, 4, 4); this.sgohan19.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.sgohan19, -0.2443461F, -0.2617994F, 0.0174533F); this.sgohan20 = new ModelRenderer((ModelBase)this, 32, 0); this.sgohan20.func_78789_a(-2.0F, -12.0F, -1.0F, 3, 4, 4); this.sgohan20.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.sgohan20, -0.1396263F, 0.0F, 0.0F); this.sgohan21 = new ModelRenderer((ModelBase)this, 32, 0); this.sgohan21.func_78789_a(-0.6F, -11.5F, 0.0F, 3, 2, 3); this.sgohan21.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.sgohan21, -0.122173F, 0.1745329F, 0.0F); this.sgohan22 = new ModelRenderer((ModelBase)this, 32, 0); this.sgohan22.func_78789_a(-2.866667F, -11.53333F, -0.6666667F, 3, 4, 3); this.sgohan22.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.sgohan22, -0.2443461F, -0.2617994F, 0.0174533F); this.sgohan26 = new ModelRenderer((ModelBase)this, 32, 0); this.sgohan26.func_78789_a(4.433333F, -6.5F, -5.266667F, 2, 3, 3); this.sgohan26.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.sgohan26, 0.0F, 0.0F, -0.5934119F); this.ssgohan1 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgohan1.func_78789_a(-1.0F, -10.5F, -5.066667F, 4, 4, 4); this.ssgohan1.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgohan1, -0.1745329F, 0.0F, 0.0F); this.ssgohan7 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgohan7.func_78789_a(-0.5F, -11.5F, -6.0F, 3, 3, 3); this.ssgohan7.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgohan7, -0.3665191F, 0.0F, 0.0F); this.ssgohan8 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgohan8.func_78789_a(0.0F, -12.0F, -7.0F, 2, 3, 2); this.ssgohan8.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgohan8, -0.5585054F, 0.0F, 0.0F); this.ssgohan10 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgohan10.func_78789_a(-1.533333F, -10.8F, -5.466667F, 4, 5, 4); this.ssgohan10.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgohan10, -0.2617994F, 0.0F, -0.3665191F); this.ssgohan11 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgohan11.func_78789_a(-0.5F, -11.8F, -6.0F, 5, 4, 4); this.ssgohan11.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgohan11, -0.418879F, 0.0F, -0.3316126F); this.ssgohan12 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgohan12.func_78789_a(-0.5F, -13.0F, -6.0F, 3, 3, 3); this.ssgohan12.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgohan12, -0.5235988F, 0.0F, -0.2268928F); this.ssgohan13 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgohan13.func_78789_a(0.0F, -13.2F, -7.0F, 2, 4, 2); this.ssgohan13.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgohan13, -0.6283185F, 0.0F, -0.0698132F); this.ssgohan14 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgohan14.func_78789_a(-1.3F, -9.8F, -5.0F, 3, 5, 3); this.ssgohan14.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgohan14, -0.2268928F, 0.0F, 0.4014257F); this.ssgohan15 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgohan15.func_78789_a(-0.8333333F, -11.3F, -6.0F, 3, 4, 4); this.ssgohan15.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgohan15, -0.4537856F, 0.0F, 0.2617994F); this.ssgohan16 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgohan16.func_78789_a(-1.0F, -13.0F, -6.0F, 3, 4, 3); this.ssgohan16.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgohan16, -0.5410521F, 0.0F, 0.1745329F); this.ssgohan17 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgohan17.func_78789_a(-2.0F, -9.0F, -1.0F, 4, 5, 4); this.ssgohan17.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgohan17, -0.2792527F, 0.0F, 0.0F); this.ssgohan18 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgohan18.func_78789_a(-0.8F, -10.0F, -1.0F, 4, 5, 4); this.ssgohan18.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgohan18, -0.2443461F, 0.2617994F, 0.0174533F); this.ssgohan19 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgohan19.func_78789_a(-3.266667F, -10.0F, -1.0F, 4, 4, 4); this.ssgohan19.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgohan19, -0.2443461F, -0.2617994F, 0.0174533F); this.ssgohan20 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgohan20.func_78789_a(-2.0F, -12.5F, -1.0F, 3, 4, 4); this.ssgohan20.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgohan20, -0.1396263F, 0.0F, 0.0F); this.ssgohan21 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgohan21.func_78789_a(-0.6F, -12.0F, 0.0F, 3, 3, 3); this.ssgohan21.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgohan21, -0.122173F, 0.1745329F, 0.0F); this.ssgohan22 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgohan22.func_78789_a(-2.866667F, -11.53333F, -0.6666667F, 3, 4, 3); this.ssgohan22.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgohan22, -0.2443461F, -0.2617994F, 0.0174533F); this.ssgohan26 = new ModelRenderer((ModelBase)this, 32, 0); this.ssgohan26.func_78789_a(4.0F, -6.5F, -5.266667F, 2, 4, 3); this.ssgohan26.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssgohan26, 0.0F, 0.0F, -0.5235988F); this.gokuni1 = new ModelRenderer((ModelBase)this, 32, 0); this.gokuni1.func_78789_a(-1.0F, -11.0F, -2.0F, 4, 4, 4); this.gokuni1.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.gokuni1, 0.2268928F, 0.0F, -0.4363323F); this.gokuni2 = new ModelRenderer((ModelBase)this, 32, 0); this.gokuni2.func_78789_a(-8.0F, -5.1F, -1.0F, 4, 2, 2); this.gokuni2.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.gokuni2, 0.0F, -0.2617994F, 0.1745329F); this.gokuni3 = new ModelRenderer((ModelBase)this, 32, 0); this.gokuni3.func_78789_a(-6.0F, -4.6F, -1.0F, 4, 2, 2); this.gokuni3.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.gokuni3, 0.0F, 0.0F, -0.1396263F); this.gokuni4 = new ModelRenderer((ModelBase)this, 32, 0); this.gokuni4.func_78789_a(3.0F, -4.0F, 0.0F, 4, 3, 3); this.gokuni4.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.gokuni4, 0.0F, 0.0F, -0.3490659F); this.gokuni5 = new ModelRenderer((ModelBase)this, 32, 0); this.gokuni5.func_78789_a(3.0F, -3.8F, 0.7F, 3, 2, 2); this.gokuni5.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.gokuni5, 0.0F, 0.0349066F, 0.1815142F); this.gokuni6 = new ModelRenderer((ModelBase)this, 32, 0); this.gokuni6.func_78789_a(6.0F, -4.3F, 0.5F, 3, 2, 2); this.gokuni6.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.gokuni6, 0.0F, 0.0F, -0.2617994F); this.gokuni7 = new ModelRenderer((ModelBase)this, 32, 0); this.gokuni7.func_78789_a(1.0F, -12.0F, 1.266667F, 3, 3, 3); this.gokuni7.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.gokuni7, 0.5235988F, 0.0F, -0.6108652F); this.gokuni8 = new ModelRenderer((ModelBase)this, 32, 0); this.gokuni8.func_78789_a(3.266667F, -13.0F, 4.0F, 2, 3, 2); this.gokuni8.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.gokuni8, 0.7853982F, 0.0F, -0.7853982F); this.gokuni9 = new ModelRenderer((ModelBase)this, 32, 0); this.gokuni9.func_78789_a(-8.733334F, -5.7F, 0.1F, 2, 1, 1); this.gokuni9.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.gokuni9, 0.0F, -0.3490659F, 0.0174533F); this.gokuni10 = new ModelRenderer((ModelBase)this, 32, 0); this.gokuni10.func_78789_a(-11.0F, -4.133333F, 0.0F, 5, 2, 2); this.gokuni10.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.gokuni10, 0.0F, -0.6981317F, 0.4921828F); this.gokuni11 = new ModelRenderer((ModelBase)this, 32, 0); this.gokuni11.func_78789_a(1.066667F, -9.866667F, 1.6F, 1, 3, 1); this.gokuni11.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.gokuni11, 0.1745329F, 0.0F, -0.1745329F); this.gokuni12 = new ModelRenderer((ModelBase)this, 32, 0); this.gokuni12.func_78789_a(5.0F, -4.333333F, 1.7F, 3, 1, 1); this.gokuni12.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.gokuni12, 0.0F, 0.1745329F, -0.4991642F); this.ght1 = new ModelRenderer((ModelBase)this, 32, 0); this.ght1.func_78789_a(-0.4666667F, -10.0F, -1.533333F, 3, 3, 3); this.ght1.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ght1, 0.2443461F, 0.0F, -0.4363323F); this.ght2 = new ModelRenderer((ModelBase)this, 32, 0); this.ght2.func_78789_a(-8.533334F, -6.8F, 0.6F, 5, 2, 2); this.ght2.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ght2, 0.0F, -0.8726646F, 0.2094395F); this.ght3 = new ModelRenderer((ModelBase)this, 32, 0); this.ght3.func_78789_a(-6.0F, -6.6F, 0.0F, 4, 2, 2); this.ght3.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ght3, 0.0F, -0.6867716F, -0.1745329F); this.ght4 = new ModelRenderer((ModelBase)this, 32, 0); this.ght4.func_78789_a(-0.01F, -6.0001F, 2.0F, 4, 5, 4); this.ght4.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ght4, 0.296706F, 0.0F, 0.0F); this.ght5 = new ModelRenderer((ModelBase)this, 32, 0); this.ght5.func_78789_a(4.6F, -7.666667F, 2.7F, 1, 2, 1); this.ght5.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ght5, 0.0F, 0.1745329F, -0.3490659F); this.ght6 = new ModelRenderer((ModelBase)this, 32, 0); this.ght6.func_78789_a(0.5333334F, -8.566667F, 2.1F, 2, 1, 1); this.ght6.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ght6, 0.0F, -0.0349066F, 0.3490659F); this.ght7 = new ModelRenderer((ModelBase)this, 32, 0); this.ght7.func_78789_a(1.2F, -11.0F, 0.1333333F, 2, 3, 2); this.ght7.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ght7, 0.418879F, 0.0F, -0.5934119F); this.ght8 = new ModelRenderer((ModelBase)this, 32, 0); this.ght8.func_78789_a(3.0F, -11.8F, 2.2F, 1, 3, 1); this.ght8.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ght8, 0.6108652F, 0.0F, -0.7679449F); this.ght9 = new ModelRenderer((ModelBase)this, 32, 0); this.ght9.func_78789_a(-8.066667F, -7.6F, 1.833333F, 3, 1, 1); this.ght9.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ght9, 0.0F, -1.047198F, 0.0F); this.ght11 = new ModelRenderer((ModelBase)this, 32, 0); this.ght11.func_78789_a(0.4F, -10.0F, 0.06666667F, 1, 4, 1); this.ght11.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ght11, 0.0523599F, 0.0F, -0.1745329F); this.ght14 = new ModelRenderer((ModelBase)this, 32, 0); this.ght14.func_78789_a(-3.99F, -6.0001F, 2.001F, 4, 5, 4); this.ght14.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ght14, 0.296706F, 0.0F, 0.0F); this.ght16 = new ModelRenderer((ModelBase)this, 32, 0); this.ght16.func_78789_a(7.0F, -5.1F, -0.3666667F, 2, 1, 1); this.ght16.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ght16, 0.0F, -0.7853982F, -0.4363323F); this.goten2 = new ModelRenderer((ModelBase)this, 32, 0); this.goten2.func_78789_a(-8.533334F, -6.8F, 0.6F, 5, 2, 2); this.goten2.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.goten2, 0.0F, -0.8726646F, 0.3141593F); this.goten3 = new ModelRenderer((ModelBase)this, 32, 0); this.goten3.func_78789_a(-6.0F, -6.933333F, 0.0F, 4, 2, 2); this.goten3.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.goten3, 0.0F, -0.6867716F, -0.1745329F); this.goten4 = new ModelRenderer((ModelBase)this, 32, 0); this.goten4.func_78789_a(-0.01F, -6.0001F, 1.1F, 4, 5, 4); this.goten4.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.goten4, 0.1745329F, 0.0F, 0.0F); this.goten5 = new ModelRenderer((ModelBase)this, 32, 0); this.goten5.func_78789_a(4.6F, -7.666667F, 2.7F, 1, 2, 1); this.goten5.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.goten5, 0.0F, 0.1745329F, -0.3490659F); this.goten6 = new ModelRenderer((ModelBase)this, 32, 0); this.goten6.func_78789_a(0.5333334F, -8.566667F, 2.1F, 2, 1, 1); this.goten6.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.goten6, 0.0F, -0.0349066F, 0.3490659F); this.goten9 = new ModelRenderer((ModelBase)this, 32, 0); this.goten9.func_78789_a(-9.066667F, -7.6F, 1.833333F, 3, 1, 1); this.goten9.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.goten9, 0.0F, -1.047198F, 0.122173F); this.goten14 = new ModelRenderer((ModelBase)this, 32, 0); this.goten14.func_78789_a(-3.99F, -6.0001F, 1.1F, 4, 5, 4); this.goten14.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.goten14, 0.1745329F, 0.0F, 0.0F); this.goten16 = new ModelRenderer((ModelBase)this, 32, 0); this.goten16.func_78789_a(7.0F, -5.1F, -0.3666667F, 2, 1, 1); this.goten16.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.goten16, 0.0F, -0.7853982F, -0.4363323F); this.gotent1 = new ModelRenderer((ModelBase)this, 32, 0); this.gotent1.func_78789_a(-0.4666667F, -11.33333F, -1.533333F, 2, 3, 2); this.gotent1.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.gotent1, 0.296706F, 0.0F, -0.2792527F); this.gotent2 = new ModelRenderer((ModelBase)this, 32, 0); this.gotent2.func_78789_a(-10.53333F, -0.8F, -3.4F, 5, 2, 2); this.gotent2.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.gotent2, 0.0F, 0.0F, 1.239184F); this.gotent3 = new ModelRenderer((ModelBase)this, 32, 0); this.gotent3.func_78789_a(-3.133333F, -9.133333F, 3.8F, 4, 4, 2); this.gotent3.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.gotent3, 0.8726646F, 0.2094395F, 0.0F); this.gotent5 = new ModelRenderer((ModelBase)this, 32, 0); this.gotent5.func_78789_a(4.6F, -7.666667F, 2.7F, 1, 2, 1); this.gotent5.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.gotent5, 0.0F, 0.1745329F, -0.3490659F); this.gotent6 = new ModelRenderer((ModelBase)this, 32, 0); this.gotent6.func_78789_a(0.5333334F, -8.566667F, 2.1F, 2, 1, 1); this.gotent6.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.gotent6, 0.0F, -0.0349066F, 0.3490659F); this.gotent7 = new ModelRenderer((ModelBase)this, 32, 0); this.gotent7.func_78789_a(1.2F, -11.0F, 0.1333333F, 2, 4, 2); this.gotent7.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.gotent7, 0.5235988F, 0.0F, -0.2617994F); this.gotent8 = new ModelRenderer((ModelBase)this, 32, 0); this.gotent8.func_78789_a(3.0F, -9.8F, 2.2F, 2, 3, 2); this.gotent8.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.gotent8, 0.8203047F, 0.0F, -0.9250245F); this.gotent9 = new ModelRenderer((ModelBase)this, 32, 0); this.gotent9.func_78789_a(-9.066667F, -4.6F, 0.5F, 5, 2, 2); this.gotent9.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.gotent9, 0.0F, -0.8901179F, 0.4712389F); this.gotent11 = new ModelRenderer((ModelBase)this, 32, 0); this.gotent11.func_78789_a(0.4F, -10.0F, 0.06666667F, 2, 5, 2); this.gotent11.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.gotent11, 0.3665191F, 0.0F, -0.5934119F); this.gotent16 = new ModelRenderer((ModelBase)this, 32, 0); this.gotent16.func_78789_a(7.0F, -5.1F, -0.3666667F, 2, 1, 1); this.gotent16.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.gotent16, 0.0F, -0.7853982F, -0.4363323F); this.hairc71 = new ModelRenderer((ModelBase)this, 32, 15); this.hairc71.func_78789_a(2.0F, -8.0F, -4.5F, 4, 8, 9); this.hairc71.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.hairc71, 0.0F, 0.0174533F, -0.2617994F); this.hairc72 = new ModelRenderer((ModelBase)this, 36, 0); this.hairc72.func_78789_a(-6.0F, -8.0F, -4.5F, 4, 8, 9); this.hairc72.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.hairc72, 0.0F, 0.0F, 0.2617994F); this.hairc81 = new ModelRenderer((ModelBase)this, 32, 15); this.hairc81.func_78789_a(2.133333F, -8.066667F, -4.5F, 3, 8, 9); this.hairc81.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.hairc81, 0.0F, 0.0174533F, -0.0872665F); this.hairc82 = new ModelRenderer((ModelBase)this, 34, 0); this.hairc82.func_78789_a(-6.0F, -8.0F, -4.5F, 4, 8, 9); this.hairc82.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.hairc82, 0.0F, 0.0F, 0.2617994F); this.hairc83 = new ModelRenderer((ModelBase)this, 0, 22); this.hairc83.func_78789_a(-5.0F, -8.466666F, -4.5F, 6, 1, 9); this.hairc83.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.hairc83, 0.0F, 0.0174533F, 0.1745329F); this.radlike1 = new ModelRenderer((ModelBase)this, 32, 0); this.radlike1.func_78789_a(-1.0F, -10.0F, -6.05F, 4, 4, 4); this.radlike1.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlike1, -0.3141593F, 0.0F, 0.0F); this.radlike2 = new ModelRenderer((ModelBase)this, 32, 0); this.radlike2.func_78789_a(-6.8F, -6.5F, -1.0F, 4, 3, 3); this.radlike2.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlike2, 0.0F, 0.1745329F, -0.1396263F); this.radlike3 = new ModelRenderer((ModelBase)this, 32, 0); this.radlike3.func_78789_a(-6.3F, -4.0F, 0.0F, 3, 2, 2); this.radlike3.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlike3, 0.0F, 0.2617994F, -0.1919862F); this.radlike4 = new ModelRenderer((ModelBase)this, 32, 0); this.radlike4.func_78789_a(2.8F, -7.0F, -1.0F, 4, 3, 3); this.radlike4.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlike4, 0.0F, -0.1745329F, 0.1919862F); this.radlike5 = new ModelRenderer((ModelBase)this, 32, 0); this.radlike5.func_78789_a(2.8F, -4.0F, 0.7F, 3, 2, 2); this.radlike5.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlike5, 0.0F, -0.1745329F, 0.1570796F); this.radlike7 = new ModelRenderer((ModelBase)this, 32, 0); this.radlike7.func_78789_a(-1.5F, -11.0F, -8.0F, 3, 3, 3); this.radlike7.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlike7, -0.5934119F, 0.0F, 0.1047198F); this.radlike8 = new ModelRenderer((ModelBase)this, 32, 0); this.radlike8.func_78789_a(-5.0F, -12.0F, -8.0F, 2, 3, 2); this.radlike8.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlike8, -0.6981317F, 0.0F, 0.4363323F); this.radlike10 = new ModelRenderer((ModelBase)this, 32, 0); this.radlike10.func_78789_a(-1.0F, -10.3F, -6.3F, 4, 6, 4); this.radlike10.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlike10, -0.4363323F, 0.0F, -0.3665191F); this.radlike11 = new ModelRenderer((ModelBase)this, 32, 0); this.radlike11.func_78789_a(1.0F, -11.3F, -6.0F, 5, 4, 3); this.radlike11.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlike11, -0.5410521F, 0.0F, -0.4886922F); this.radlike12 = new ModelRenderer((ModelBase)this, 32, 0); this.radlike12.func_78789_a(3.5F, -11.5F, -8.0F, 3, 3, 3); this.radlike12.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlike12, -0.8552113F, 0.0F, -0.6108652F); this.radlike13 = new ModelRenderer((ModelBase)this, 32, 0); this.radlike13.func_78789_a(6.0F, -12.4F, -8.0F, 2, 3, 2); this.radlike13.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlike13, -0.9948377F, 0.0F, -0.7679449F); this.radlike14 = new ModelRenderer((ModelBase)this, 32, 0); this.radlike14.func_78789_a(-1.3F, -9.3F, -5.5F, 3, 5, 3); this.radlike14.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlike14, -0.3665191F, 0.0F, 0.4014257F); this.radlike15 = new ModelRenderer((ModelBase)this, 32, 0); this.radlike15.func_78789_a(-5.5F, -9.8F, -6.0F, 3, 3, 3); this.radlike15.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlike15, -0.5410521F, 0.0F, 0.837758F); this.radlike16 = new ModelRenderer((ModelBase)this, 32, 0); this.radlike16.func_78789_a(-9.0F, -8.533334F, -6.0F, 2, 3, 2); this.radlike16.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlike16, -0.837758F, 0.0F, 1.27409F); this.radlike17 = new ModelRenderer((ModelBase)this, 32, 0); this.radlike17.func_78789_a(-2.0F, -2.0F, 4.0F, 4, 5, 4); this.radlike17.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlike17, 0.4886922F, 0.0F, 0.0F); this.radlike18 = new ModelRenderer((ModelBase)this, 32, 0); this.radlike18.func_78789_a(-1.0F, -5.0F, 5.0F, 4, 5, 4); this.radlike18.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlike18, 0.5061455F, 0.2617994F, 0.0174533F); this.radlike19 = new ModelRenderer((ModelBase)this, 32, 0); this.radlike19.func_78789_a(-4.0F, -6.0F, 5.0F, 4, 6, 4); this.radlike19.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlike19, 0.5235988F, -0.2617994F, 0.0F); this.radlike20 = new ModelRenderer((ModelBase)this, 32, 0); this.radlike20.func_78789_a(-2.4F, -5.2F, 7.0F, 4, 5, 4); this.radlike20.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlike20, 0.6981317F, 0.0F, 0.0F); this.radlike21 = new ModelRenderer((ModelBase)this, 32, 0); this.radlike21.func_78789_a(0.1333333F, -6.5F, 7.533333F, 3, 5, 3); this.radlike21.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlike21, 0.7679449F, 0.1745329F, 0.0F); this.radlike22 = new ModelRenderer((ModelBase)this, 32, 0); this.radlike22.func_78789_a(-2.866667F, -7.2F, 7.333333F, 3, 4, 3); this.radlike22.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlike22, 0.5934119F, -0.2617994F, 0.0F); this.radlike23 = new ModelRenderer((ModelBase)this, 32, 0); this.radlike23.func_78789_a(1.0F, -9.0F, -4.05F, 3, 4, 4); this.radlike23.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlike23, -0.3141593F, 0.0F, -0.8726646F); this.radlike24 = new ModelRenderer((ModelBase)this, 32, 0); this.radlike24.func_78789_a(3.533333F, -10.0F, -4.716667F, 3, 4, 3); this.radlike24.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlike24, -0.5585054F, 0.0F, -1.082104F); this.radlike25 = new ModelRenderer((ModelBase)this, 32, 0); this.radlike25.func_78789_a(3.533333F, -12.0F, -4.716667F, 2, 4, 2); this.radlike25.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlike25, -0.5934119F, 0.0F, -0.8203047F); this.radlike26 = new ModelRenderer((ModelBase)this, 32, 0); this.radlike26.func_78789_a(3.533333F, -9.666667F, -3.116667F, 3, 4, 3); this.radlike26.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlike26, -0.5585054F, 0.0F, -1.396263F); this.radlike27 = new ModelRenderer((ModelBase)this, 32, 0); this.radlike27.func_78789_a(-4.5F, -6.8F, -5.0F, 3, 4, 3); this.radlike27.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlike27, -0.5410521F, 0.0F, 1.047198F); this.radlike28 = new ModelRenderer((ModelBase)this, 32, 0); this.radlike28.func_78789_a(-6.8F, -7.533333F, -5.0F, 3, 4, 3); this.radlike28.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlike28, -0.837758F, 0.0F, 1.308997F); this.radlike29 = new ModelRenderer((ModelBase)this, 32, 0); this.radlike29.func_78789_a(6.0F, -10.2F, -5.0F, 2, 3, 2); this.radlike29.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlike29, -0.7679449F, 0.0F, -1.291544F); this.radlike30 = new ModelRenderer((ModelBase)this, 32, 0); this.radlike30.func_78789_a(-2.433333F, -10.6F, -7.666667F, 3, 3, 3); this.radlike30.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlike30, -0.7330383F, 0.0F, 0.3839724F); this.radlike31 = new ModelRenderer((ModelBase)this, 32, 0); this.radlike31.func_78789_a(-5.466667F, -11.0F, -8.333333F, 2, 3, 2); this.radlike31.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlike31, -0.9424778F, 0.0F, 0.6806784F); this.radlike32 = new ModelRenderer((ModelBase)this, 32, 0); this.radlike32.func_78789_a(-1.4F, -14.0F, -3.0F, 3, 4, 3); this.radlike32.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlike32, -0.4363323F, 0.0F, -0.0349066F); this.radlik6 = new ModelRenderer((ModelBase)this, 32, 0); this.radlik6.func_78789_a(-6.8F, -1.733333F, 3.2F, 3, 6, 3); this.radlik6.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlik6, 0.4363323F, 0.0F, 0.3490659F); this.radlik7 = new ModelRenderer((ModelBase)this, 32, 0); this.radlik7.func_78789_a(4.0F, -3.066667F, 2.6F, 3, 6, 3); this.radlik7.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlik7, 0.4363323F, 0.0F, -0.3490659F); this.radlik15 = new ModelRenderer((ModelBase)this, 32, 0); this.radlik15.func_78789_a(-2.266667F, -3.2F, 5.4F, 4, 4, 4); this.radlik15.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlik15, 0.4363323F, 0.0F, 0.0F); this.radlik1 = new ModelRenderer((ModelBase)this, 32, 0); this.radlik1.func_78789_a(-4.466667F, 6.2F, 4.0F, 3, 3, 2); this.radlik1.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlik1, 0.0872665F, 0.0F, 0.0698132F); this.radlik2 = new ModelRenderer((ModelBase)this, 32, 0); this.radlik2.func_78789_a(2.533333F, 4.2F, 3.0F, 3, 3, 3); this.radlik2.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlik2, 0.1396263F, 0.0F, -0.0872665F); this.radlik3 = new ModelRenderer((ModelBase)this, 32, 0); this.radlik3.func_78789_a(-5.466667F, 4.2F, 3.0F, 3, 3, 3); this.radlik3.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlik3, 0.1396263F, 0.0F, 0.0872665F); this.radlik4 = new ModelRenderer((ModelBase)this, 32, 0); this.radlik4.func_78789_a(-6.133333F, 0.7333333F, 3.0F, 3, 5, 3); this.radlik4.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlik4, 0.2268928F, 0.0F, 0.2094395F); this.radlik5 = new ModelRenderer((ModelBase)this, 32, 0); this.radlik5.func_78789_a(3.266667F, 0.7333333F, 3.0F, 3, 5, 3); this.radlik5.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlik5, 0.2268928F, 0.0F, -0.2094395F); this.radlik8 = new ModelRenderer((ModelBase)this, 32, 0); this.radlik8.func_78789_a(-1.466667F, 6.0F, 4.0F, 3, 5, 4); this.radlik8.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlik8, 0.0872665F, -0.2617994F, 0.0F); this.radlik9 = new ModelRenderer((ModelBase)this, 32, 0); this.radlik9.func_78789_a(-2.466667F, 2.0F, 4.0F, 4, 5, 4); this.radlik9.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlik9, 0.1570796F, -0.2617994F, 0.0F); this.radlik10 = new ModelRenderer((ModelBase)this, 32, 0); this.radlik10.func_78789_a(-2.0F, 7.266667F, 4.0F, 4, 4, 4); this.radlik10.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlik10, 0.0698132F, 0.2617994F, 0.0F); this.radlik11 = new ModelRenderer((ModelBase)this, 32, 0); this.radlik11.func_78789_a(-1.0F, 4.266667F, 4.0F, 4, 4, 4); this.radlik11.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlik11, 0.1047198F, 0.2617994F, 0.0F); this.radlik12 = new ModelRenderer((ModelBase)this, 32, 0); this.radlik12.func_78789_a(-0.9F, 1.266667F, 4.0F, 4, 4, 4); this.radlik12.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlik12, 0.1745329F, 0.2617994F, 0.0F); this.radlik13 = new ModelRenderer((ModelBase)this, 32, 0); this.radlik13.func_78789_a(-1.933333F, 5.0F, 4.0F, 4, 5, 4); this.radlik13.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlik13, 0.1745329F, 0.0F, 0.0F); this.radlik14 = new ModelRenderer((ModelBase)this, 32, 0); this.radlik14.func_78789_a(-1.4F, 8.0F, 5.6F, 3, 5, 3); this.radlik14.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlik14, 0.0872665F, 0.0F, 0.0F); this.radlik16 = new ModelRenderer((ModelBase)this, 32, 0); this.radlik16.func_78789_a(-2.533333F, -2.0F, 3.333333F, 4, 6, 4); this.radlik16.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlik16, 0.3490659F, -0.2617994F, 0.0F); this.radlik17 = new ModelRenderer((ModelBase)this, 32, 0); this.radlik17.func_78789_a(-1.0F, -2.0F, 4.0F, 4, 5, 4); this.radlik17.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlik17, 0.3316126F, 0.2617994F, 0.0F); this.radlik18 = new ModelRenderer((ModelBase)this, 32, 0); this.radlik18.func_78789_a(-2.0F, 1.0F, 4.0F, 4, 5, 4); this.radlik18.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.radlik18, 0.2792527F, 0.0F, 0.0F); this.ssjsan1 = new ModelRenderer((ModelBase)this, 32, 0); this.ssjsan1.func_78789_a(-1.0F, -10.0F, -6.05F, 4, 4, 4); this.ssjsan1.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssjsan1, -0.3141593F, 0.0F, 0.0F); this.ssjsan2 = new ModelRenderer((ModelBase)this, 32, 0); this.ssjsan2.func_78789_a(-6.8F, -6.5F, -1.0F, 4, 3, 3); this.ssjsan2.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssjsan2, 0.0F, 0.1745329F, -0.1396263F); this.ssjsan3 = new ModelRenderer((ModelBase)this, 32, 0); this.ssjsan3.func_78789_a(-6.3F, -4.0F, 0.0F, 3, 2, 2); this.ssjsan3.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssjsan3, 0.0F, 0.2617994F, -0.1919862F); this.ssjsan4 = new ModelRenderer((ModelBase)this, 32, 0); this.ssjsan4.func_78789_a(2.8F, -7.0F, -1.0F, 4, 3, 3); this.ssjsan4.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssjsan4, 0.0F, -0.1745329F, 0.1919862F); this.ssjsan5 = new ModelRenderer((ModelBase)this, 32, 0); this.ssjsan5.func_78789_a(2.8F, -4.0F, 0.7F, 3, 2, 2); this.ssjsan5.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssjsan5, 0.0F, -0.1745329F, 0.1570796F); this.ssjsan7 = new ModelRenderer((ModelBase)this, 32, 0); this.ssjsan7.func_78789_a(-1.5F, -11.0F, -8.0F, 3, 3, 3); this.ssjsan7.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssjsan7, -0.5934119F, 0.0F, 0.1047198F); this.ssjsan8 = new ModelRenderer((ModelBase)this, 32, 0); this.ssjsan8.func_78789_a(-5.0F, -12.0F, -8.0F, 2, 3, 2); this.ssjsan8.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssjsan8, -0.6981317F, 0.0F, 0.4363323F); this.ssjsan10 = new ModelRenderer((ModelBase)this, 32, 0); this.ssjsan10.func_78789_a(-1.0F, -10.3F, -6.3F, 4, 6, 4); this.ssjsan10.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssjsan10, -0.4363323F, 0.0F, -0.3665191F); this.ssjsan11 = new ModelRenderer((ModelBase)this, 32, 0); this.ssjsan11.func_78789_a(1.0F, -11.3F, -6.0F, 5, 4, 3); this.ssjsan11.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssjsan11, -0.5410521F, 0.0F, -0.4886922F); this.ssjsan12 = new ModelRenderer((ModelBase)this, 32, 0); this.ssjsan12.func_78789_a(3.5F, -11.5F, -8.0F, 3, 3, 3); this.ssjsan12.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssjsan12, -0.8552113F, 0.0F, -0.6108652F); this.ssjsan13 = new ModelRenderer((ModelBase)this, 32, 0); this.ssjsan13.func_78789_a(6.0F, -12.4F, -8.0F, 2, 3, 2); this.ssjsan13.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssjsan13, -0.9948377F, 0.0F, -0.7679449F); this.ssjsan14 = new ModelRenderer((ModelBase)this, 32, 0); this.ssjsan14.func_78789_a(-1.3F, -9.3F, -5.5F, 3, 5, 3); this.ssjsan14.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssjsan14, -0.3665191F, 0.0F, 0.4014257F); this.ssjsan15 = new ModelRenderer((ModelBase)this, 32, 0); this.ssjsan15.func_78789_a(-5.5F, -9.8F, -6.0F, 3, 3, 3); this.ssjsan15.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssjsan15, -0.5410521F, 0.0F, 0.837758F); this.ssjsan16 = new ModelRenderer((ModelBase)this, 32, 0); this.ssjsan16.func_78789_a(-9.0F, -8.533334F, -6.0F, 2, 3, 2); this.ssjsan16.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssjsan16, -0.837758F, 0.0F, 1.27409F); this.ssjsan17 = new ModelRenderer((ModelBase)this, 32, 0); this.ssjsan17.func_78789_a(-2.0F, -2.0F, 4.0F, 4, 5, 4); this.ssjsan17.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssjsan17, 0.4886922F, 0.0F, 0.0F); this.ssjsan18 = new ModelRenderer((ModelBase)this, 32, 0); this.ssjsan18.func_78789_a(-1.0F, -5.0F, 5.0F, 4, 5, 4); this.ssjsan18.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssjsan18, 0.5061455F, 0.2617994F, 0.0174533F); this.ssjsan19 = new ModelRenderer((ModelBase)this, 32, 0); this.ssjsan19.func_78789_a(-4.0F, -6.0F, 5.0F, 4, 6, 4); this.ssjsan19.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssjsan19, 0.5235988F, -0.2617994F, 0.0F); this.ssjsan20 = new ModelRenderer((ModelBase)this, 32, 0); this.ssjsan20.func_78789_a(-2.4F, -5.2F, 7.0F, 4, 5, 4); this.ssjsan20.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssjsan20, 0.6981317F, 0.0F, 0.0F); this.ssjsan21 = new ModelRenderer((ModelBase)this, 32, 0); this.ssjsan21.func_78789_a(0.1333333F, -6.5F, 7.533333F, 3, 5, 3); this.ssjsan21.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssjsan21, 0.7679449F, 0.1745329F, 0.0F); this.ssjsan22 = new ModelRenderer((ModelBase)this, 32, 0); this.ssjsan22.func_78789_a(-2.866667F, -7.2F, 7.333333F, 3, 4, 3); this.ssjsan22.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssjsan22, 0.5934119F, -0.2617994F, 0.0F); this.ssjsan23 = new ModelRenderer((ModelBase)this, 32, 0); this.ssjsan23.func_78789_a(1.0F, -9.0F, -4.05F, 3, 4, 4); this.ssjsan23.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssjsan23, -0.3141593F, 0.0F, -0.8726646F); this.ssjsan24 = new ModelRenderer((ModelBase)this, 32, 0); this.ssjsan24.func_78789_a(3.533333F, -10.0F, -4.716667F, 3, 4, 3); this.ssjsan24.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssjsan24, -0.5585054F, 0.0F, -1.082104F); this.ssjsan25 = new ModelRenderer((ModelBase)this, 32, 0); this.ssjsan25.func_78789_a(3.533333F, -12.0F, -4.716667F, 2, 4, 2); this.ssjsan25.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssjsan25, -0.5934119F, 0.0F, -0.8203047F); this.ssjsan26 = new ModelRenderer((ModelBase)this, 32, 0); this.ssjsan26.func_78789_a(3.533333F, -9.666667F, -3.116667F, 3, 4, 3); this.ssjsan26.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssjsan26, -0.5585054F, 0.0F, -1.396263F); this.ssjsan27 = new ModelRenderer((ModelBase)this, 32, 0); this.ssjsan27.func_78789_a(-4.5F, -6.8F, -5.0F, 3, 4, 3); this.ssjsan27.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssjsan27, -0.5410521F, 0.0F, 1.047198F); this.ssjsan28 = new ModelRenderer((ModelBase)this, 32, 0); this.ssjsan28.func_78789_a(-6.8F, -7.533333F, -5.0F, 3, 4, 3); this.ssjsan28.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssjsan28, -0.837758F, 0.0F, 1.308997F); this.ssjsan29 = new ModelRenderer((ModelBase)this, 32, 0); this.ssjsan29.func_78789_a(6.0F, -10.2F, -5.0F, 2, 3, 2); this.ssjsan29.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssjsan29, -0.7679449F, 0.0F, -1.291544F); this.ssjsan30 = new ModelRenderer((ModelBase)this, 32, 0); this.ssjsan30.func_78789_a(-2.433333F, -10.6F, -7.666667F, 3, 3, 3); this.ssjsan30.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssjsan30, -0.7330383F, 0.0F, 0.3839724F); this.ssjsan31 = new ModelRenderer((ModelBase)this, 32, 0); this.ssjsan31.func_78789_a(-5.466667F, -11.0F, -8.333333F, 2, 3, 2); this.ssjsan31.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssjsan31, -0.9424778F, 0.0F, 0.6806784F); this.ssjsan32 = new ModelRenderer((ModelBase)this, 32, 0); this.ssjsan32.func_78789_a(-1.4F, -14.0F, -3.0F, 3, 4, 3); this.ssjsan32.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ssjsan32, -0.4363323F, 0.0F, -0.0349066F); this.long6 = new ModelRenderer((ModelBase)this, 32, 0); this.long6.func_78789_a(-6.8F, -1.733333F, 3.2F, 3, 6, 3); this.long6.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.long6, 0.4363323F, 0.0F, 0.3490659F); this.long7 = new ModelRenderer((ModelBase)this, 32, 0); this.long7.func_78789_a(4.0F, -3.066667F, 2.6F, 3, 6, 3); this.long7.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.long7, 0.4363323F, 0.0F, -0.3490659F); this.long15 = new ModelRenderer((ModelBase)this, 32, 0); this.long15.func_78789_a(-2.266667F, -3.2F, 5.4F, 4, 4, 4); this.long15.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.long15, 0.4363323F, 0.0F, 0.0F); this.long1 = new ModelRenderer((ModelBase)this, 32, 0); this.long1.func_78789_a(-4.466667F, 8.2F, 4.0F, 3, 4, 2); this.long1.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.long1, 0.0872665F, 0.0F, 0.0698132F); this.long2 = new ModelRenderer((ModelBase)this, 32, 0); this.long2.func_78789_a(2.533333F, 4.2F, 3.0F, 3, 5, 3); this.long2.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.long2, 0.1396263F, 0.0F, -0.0872665F); this.long3 = new ModelRenderer((ModelBase)this, 32, 0); this.long3.func_78789_a(-5.466667F, 4.2F, 3.0F, 3, 5, 3); this.long3.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.long3, 0.1396263F, 0.0F, 0.0872665F); this.long4 = new ModelRenderer((ModelBase)this, 32, 0); this.long4.func_78789_a(-6.133333F, 0.7333333F, 3.0F, 3, 5, 3); this.long4.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.long4, 0.2268928F, 0.0F, 0.2094395F); this.long5 = new ModelRenderer((ModelBase)this, 32, 0); this.long5.func_78789_a(3.266667F, 0.7333333F, 3.0F, 3, 5, 3); this.long5.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.long5, 0.2268928F, 0.0F, -0.2094395F); this.long8 = new ModelRenderer((ModelBase)this, 32, 0); this.long8.func_78789_a(-1.466667F, 7.0F, 4.0F, 3, 7, 4); this.long8.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.long8, 0.0872665F, -0.2617994F, 0.0F); this.long9 = new ModelRenderer((ModelBase)this, 32, 0); this.long9.func_78789_a(-2.466667F, 2.0F, 4.0F, 4, 6, 4); this.long9.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.long9, 0.1570796F, -0.2617994F, 0.0F); this.long10 = new ModelRenderer((ModelBase)this, 32, 0); this.long10.func_78789_a(-2.0F, 9.266666F, 4.0F, 4, 5, 4); this.long10.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.long10, 0.0698132F, 0.2617994F, 0.0F); this.long11 = new ModelRenderer((ModelBase)this, 32, 0); this.long11.func_78789_a(-1.0F, 5.266667F, 4.0F, 4, 5, 4); this.long11.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.long11, 0.1047198F, 0.2617994F, 0.0F); this.long12 = new ModelRenderer((ModelBase)this, 32, 0); this.long12.func_78789_a(-0.9F, 1.266667F, 4.0F, 4, 5, 4); this.long12.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.long12, 0.1745329F, 0.2617994F, 0.0F); this.long13 = new ModelRenderer((ModelBase)this, 32, 0); this.long13.func_78789_a(-1.933333F, 6.0F, 4.0F, 4, 6, 4); this.long13.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.long13, 0.1745329F, 0.0F, 0.0F); this.long14 = new ModelRenderer((ModelBase)this, 32, 0); this.long14.func_78789_a(-1.4F, 11.0F, 5.6F, 3, 6, 3); this.long14.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.long14, 0.0872665F, 0.0F, 0.0F); this.long16 = new ModelRenderer((ModelBase)this, 32, 0); this.long16.func_78789_a(-2.533333F, -2.0F, 3.333333F, 4, 6, 4); this.long16.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.long16, 0.3490659F, -0.2617994F, 0.0F); this.long17 = new ModelRenderer((ModelBase)this, 32, 0); this.long17.func_78789_a(-1.0F, -2.0F, 4.0F, 4, 5, 4); this.long17.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.long17, 0.3316126F, 0.2617994F, 0.0F); this.long18 = new ModelRenderer((ModelBase)this, 32, 0); this.long18.func_78789_a(-2.0F, 1.0F, 4.0F, 4, 6, 4); this.long18.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.long18, 0.2792527F, 0.0F, 0.0F); this.tincs1 = new ModelRenderer((ModelBase)this, 32, 0); this.tincs1.func_78789_a(2.866667F, -5.533333F, -6.25F, 2, 4, 1); this.tincs1.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.tincs1, -0.3141593F, 0.0F, -0.4712389F); this.bipedHeadg.func_78792_a(this.bipedHeadAll); this.bipedHeadg.func_78792_a(this.goku1); this.bipedHeadg.func_78792_a(this.goku2); this.bipedHeadg.func_78792_a(this.goku3); this.bipedHeadg.func_78792_a(this.goku4); this.bipedHeadg.func_78792_a(this.goku5); this.bipedHeadg.func_78792_a(this.goku6); this.bipedHeadg.func_78792_a(this.goku7); this.bipedHeadg.func_78792_a(this.goku8); this.bipedHeadg.func_78792_a(this.goku9); this.bipedHeadg.func_78792_a(this.goku10); this.bipedHeadg.func_78792_a(this.goku11); this.bipedHeadg.func_78792_a(this.goku12); this.bipedHeadg.func_78792_a(this.goku13); this.bipedHeadg.func_78792_a(this.goku14); this.bipedHeadg.func_78792_a(this.goku15); this.bipedHeadg.func_78792_a(this.goku16); this.bipedHeadsg.func_78792_a(this.bipedHeadAll); this.bipedHeadsg.func_78792_a(this.sgoku1); this.bipedHeadsg.func_78792_a(this.sgoku2); this.bipedHeadsg.func_78792_a(this.sgoku3); this.bipedHeadsg.func_78792_a(this.sgoku4); this.bipedHeadsg.func_78792_a(this.sgoku5); this.bipedHeadsg.func_78792_a(this.sgoku6); this.bipedHeadsg.func_78792_a(this.sgoku7); this.bipedHeadsg.func_78792_a(this.sgoku8); this.bipedHeadsg.func_78792_a(this.sgoku9); this.bipedHeadsg.func_78792_a(this.sgoku10); this.bipedHeadsg.func_78792_a(this.sgoku11); this.bipedHeadsg.func_78792_a(this.sgoku12); this.bipedHeadsg.func_78792_a(this.sgoku13); this.bipedHeadsg.func_78792_a(this.sgoku14); this.bipedHeadsg.func_78792_a(this.sgoku15); this.bipedHeadsg.func_78792_a(this.sgoku16); this.bipedHeadsg.func_78792_a(this.sgoku17); this.bipedHeadsg.func_78792_a(this.sgoku18); this.bipedHeadsg.func_78792_a(this.sgoku19); this.bipedHeadsg.func_78792_a(this.sgoku20); this.bipedHeadsg.func_78792_a(this.sgoku21); this.bipedHeadsg.func_78792_a(this.sgoku22); this.bipedHeadsg.func_78792_a(this.sgoku23); this.bipedHeadsg.func_78792_a(this.sgoku24); this.bipedHeadsg.func_78792_a(this.sgoku25); this.bipedHeadsg.func_78792_a(this.sgoku26); this.bipedHeadssg.func_78792_a(this.bipedHeadAll); this.bipedHeadssg.func_78792_a(this.ssgoku1); this.bipedHeadssg.func_78792_a(this.ssgoku2); this.bipedHeadssg.func_78792_a(this.ssgoku3); this.bipedHeadssg.func_78792_a(this.ssgoku4); this.bipedHeadssg.func_78792_a(this.ssgoku5); this.bipedHeadssg.func_78792_a(this.ssgoku6); this.bipedHeadssg.func_78792_a(this.ssgoku7); this.bipedHeadssg.func_78792_a(this.ssgoku8); this.bipedHeadssg.func_78792_a(this.ssgoku9); this.bipedHeadssg.func_78792_a(this.ssgoku10); this.bipedHeadssg.func_78792_a(this.ssgoku11); this.bipedHeadssg.func_78792_a(this.ssgoku12); this.bipedHeadssg.func_78792_a(this.ssgoku13); this.bipedHeadssg.func_78792_a(this.ssgoku14); this.bipedHeadssg.func_78792_a(this.ssgoku15); this.bipedHeadssg.func_78792_a(this.ssgoku16); this.bipedHeadssg.func_78792_a(this.ssgoku17); this.bipedHeadssg.func_78792_a(this.ssgoku18); this.bipedHeadssg.func_78792_a(this.ssgoku19); this.bipedHeadssg.func_78792_a(this.ssgoku20); this.bipedHeadssg.func_78792_a(this.ssgoku21); this.bipedHeadssg.func_78792_a(this.ssgoku22); this.bipedHeadssg.func_78792_a(this.ssgoku23); this.bipedHeadssg.func_78792_a(this.ssgoku24); this.bipedHeadssg.func_78792_a(this.ssgoku25); this.bipedHeadssg.func_78792_a(this.ssgoku26); this.bipedHeadt.func_78792_a(this.bipedHeadAll); this.bipedHeadt.func_78792_a(this.trunk1); this.bipedHeadt.func_78792_a(this.trunk2); this.bipedHeadt.func_78792_a(this.trunk3); this.bipedHeadt.func_78792_a(this.trunk4); this.bipedHeadt.func_78792_a(this.trunk5); this.bipedHeadt.func_78792_a(this.trunk6); this.bipedHeadt.func_78792_a(this.trunk7); this.bipedHeadt.func_78792_a(this.trunk8); this.bipedHeadt.func_78792_a(this.trunk9); this.bipedHeadst.func_78792_a(this.bipedHeadAll); this.bipedHeadst.func_78792_a(this.strunk1); this.bipedHeadst.func_78792_a(this.strunk2); this.bipedHeadst.func_78792_a(this.strunk3); this.bipedHeadst.func_78792_a(this.strunk4); this.bipedHeadst.func_78792_a(this.strunk5); this.bipedHeadst.func_78792_a(this.strunk6); this.bipedHeadst.func_78792_a(this.strunk7); this.bipedHeadst.func_78792_a(this.strunk8); this.bipedHeadst.func_78792_a(this.strunk9); this.bipedHeadst.func_78792_a(this.strunk10); this.bipedHeadst.func_78792_a(this.strunk11); this.bipedHeadst.func_78792_a(this.strunk12); this.bipedHeadst.func_78792_a(this.strunk13); this.bipedHeadst.func_78792_a(this.strunk14); this.bipedHeadst.func_78792_a(this.strunk15); this.bipedHeadst.func_78792_a(this.strunk16); this.bipedHeadst.func_78792_a(this.strunk17); this.bipedHeadsst.func_78792_a(this.bipedHeadAll); this.bipedHeadsst.func_78792_a(this.sstrunk1); this.bipedHeadsst.func_78792_a(this.sstrunk2); this.bipedHeadsst.func_78792_a(this.sstrunk3); this.bipedHeadsst.func_78792_a(this.sstrunk4); this.bipedHeadsst.func_78792_a(this.sstrunk5); this.bipedHeadsst.func_78792_a(this.sstrunk6); this.bipedHeadsst.func_78792_a(this.sstrunk7); this.bipedHeadsst.func_78792_a(this.sstrunk8); this.bipedHeadsst.func_78792_a(this.sstrunk9); this.bipedHeadsst.func_78792_a(this.sstrunk10); this.bipedHeadsst.func_78792_a(this.sstrunk11); this.bipedHeadsst.func_78792_a(this.sstrunk12); this.bipedHeadsst.func_78792_a(this.sstrunk13); this.bipedHeadsst.func_78792_a(this.sstrunk14); this.bipedHeadsst.func_78792_a(this.sstrunk15); this.bipedHeadsst.func_78792_a(this.sstrunk16); this.bipedHeadsst.func_78792_a(this.sstrunk17); this.bipedHeadv.func_78792_a(this.bipedHeadAll); this.bipedHeadv.func_78792_a(this.vegeta1); this.bipedHeadv.func_78792_a(this.vegeta2); this.bipedHeadv.func_78792_a(this.vegeta3); this.bipedHeadv.func_78792_a(this.vegeta4); this.bipedHeadv.func_78792_a(this.vegeta5); this.bipedHeadv.func_78792_a(this.vegeta6); this.bipedHeadv.func_78792_a(this.vegeta7); this.bipedHeadv.func_78792_a(this.vegeta8); this.bipedHeadv.func_78792_a(this.vegeta9); this.bipedHeadv.func_78792_a(this.vegeta10); this.bipedHeadv.func_78792_a(this.vegeta11); this.bipedHeadv.func_78792_a(this.vegeta12); this.bipedHeadv.func_78792_a(this.vegeta13); this.bipedHeadv.func_78792_a(this.vegeta14); this.bipedHeadv.func_78792_a(this.vegeta15); this.bipedHeadv.func_78792_a(this.vegeta16); this.bipedHeadv.func_78792_a(this.vegeta17); this.bipedHeadv.func_78792_a(this.vegeta18); this.bipedHeadv.func_78792_a(this.vegeta19); this.bipedHeadv.func_78792_a(this.vegeta20); this.bipedHeadv.func_78792_a(this.vegeta21); this.bipedHeadv.func_78792_a(this.vegeta22); this.bipedHeadsv.func_78792_a(this.bipedHeadAll); this.bipedHeadsv.func_78792_a(this.svegeta1); this.bipedHeadsv.func_78792_a(this.svegeta2); this.bipedHeadsv.func_78792_a(this.svegeta3); this.bipedHeadsv.func_78792_a(this.svegeta4); this.bipedHeadsv.func_78792_a(this.svegeta5); this.bipedHeadsv.func_78792_a(this.svegeta6); this.bipedHeadsv.func_78792_a(this.svegeta7); this.bipedHeadsv.func_78792_a(this.svegeta8); this.bipedHeadsv.func_78792_a(this.svegeta9); this.bipedHeadsv.func_78792_a(this.svegeta10); this.bipedHeadsv.func_78792_a(this.svegeta11); this.bipedHeadsv.func_78792_a(this.svegeta12); this.bipedHeadsv.func_78792_a(this.svegeta13); this.bipedHeadsv.func_78792_a(this.svegeta14); this.bipedHeadsv.func_78792_a(this.svegeta15); this.bipedHeadsv.func_78792_a(this.svegeta16); this.bipedHeadsv.func_78792_a(this.svegeta17); this.bipedHeadsv.func_78792_a(this.svegeta18); this.bipedHeadsv.func_78792_a(this.svegeta19); this.bipedHeadsv.func_78792_a(this.svegeta20); this.bipedHeadsv.func_78792_a(this.svegeta21); this.bipedHeadsv.func_78792_a(this.svegeta22); this.bipedHeadssv.func_78792_a(this.bipedHeadAll); this.bipedHeadssv.func_78792_a(this.ssvegeta1); this.bipedHeadssv.func_78792_a(this.ssvegeta2); this.bipedHeadssv.func_78792_a(this.ssvegeta3); this.bipedHeadssv.func_78792_a(this.ssvegeta4); this.bipedHeadssv.func_78792_a(this.ssvegeta5); this.bipedHeadssv.func_78792_a(this.ssvegeta6); this.bipedHeadssv.func_78792_a(this.ssvegeta7); this.bipedHeadssv.func_78792_a(this.ssvegeta8); this.bipedHeadssv.func_78792_a(this.ssvegeta9); this.bipedHeadssv.func_78792_a(this.ssvegeta10); this.bipedHeadssv.func_78792_a(this.ssvegeta11); this.bipedHeadssv.func_78792_a(this.ssvegeta12); this.bipedHeadssv.func_78792_a(this.ssvegeta13); this.bipedHeadssv.func_78792_a(this.ssvegeta14); this.bipedHeadssv.func_78792_a(this.ssvegeta15); this.bipedHeadssv.func_78792_a(this.ssvegeta16); this.bipedHeadssv.func_78792_a(this.ssvegeta17); this.bipedHeadssv.func_78792_a(this.ssvegeta18); this.bipedHeadssv.func_78792_a(this.ssvegeta19); this.bipedHeadssv.func_78792_a(this.ssvegeta20); this.bipedHeadssv.func_78792_a(this.ssvegeta21); this.bipedHeadssv.func_78792_a(this.ssvegeta22); this.bipedHeadgh.func_78792_a(this.bipedHeadAll); this.bipedHeadgh.func_78792_a(this.gohan1); this.bipedHeadgh.func_78792_a(this.gohan7); this.bipedHeadgh.func_78792_a(this.gohan8); this.bipedHeadgh.func_78792_a(this.gohan10); this.bipedHeadgh.func_78792_a(this.gohan11); this.bipedHeadgh.func_78792_a(this.gohan12); this.bipedHeadgh.func_78792_a(this.gohan13); this.bipedHeadgh.func_78792_a(this.gohan14); this.bipedHeadgh.func_78792_a(this.gohan15); this.bipedHeadgh.func_78792_a(this.gohan16); this.bipedHeadgh.func_78792_a(this.gohan17); this.bipedHeadgh.func_78792_a(this.gohan18); this.bipedHeadgh.func_78792_a(this.gohan19); this.bipedHeadgh.func_78792_a(this.gohan20); this.bipedHeadgh.func_78792_a(this.gohan21); this.bipedHeadgh.func_78792_a(this.gohan22); this.bipedHeadgh.func_78792_a(this.gohan26); this.bipedHeadsgh.func_78792_a(this.bipedHeadAll); this.bipedHeadsgh.func_78792_a(this.sgohan1); this.bipedHeadsgh.func_78792_a(this.sgohan7); this.bipedHeadsgh.func_78792_a(this.sgohan8); this.bipedHeadsgh.func_78792_a(this.sgohan10); this.bipedHeadsgh.func_78792_a(this.sgohan11); this.bipedHeadsgh.func_78792_a(this.sgohan12); this.bipedHeadsgh.func_78792_a(this.sgohan13); this.bipedHeadsgh.func_78792_a(this.sgohan14); this.bipedHeadsgh.func_78792_a(this.sgohan15); this.bipedHeadsgh.func_78792_a(this.sgohan16); this.bipedHeadsgh.func_78792_a(this.sgohan17); this.bipedHeadsgh.func_78792_a(this.sgohan18); this.bipedHeadsgh.func_78792_a(this.sgohan19); this.bipedHeadsgh.func_78792_a(this.sgohan20); this.bipedHeadsgh.func_78792_a(this.sgohan21); this.bipedHeadsgh.func_78792_a(this.sgohan22); this.bipedHeadsgh.func_78792_a(this.sgohan26); this.bipedHeadssgh.func_78792_a(this.bipedHeadAll); this.bipedHeadssgh.func_78792_a(this.ssgohan1); this.bipedHeadssgh.func_78792_a(this.ssgohan7); this.bipedHeadssgh.func_78792_a(this.ssgohan8); this.bipedHeadssgh.func_78792_a(this.ssgohan10); this.bipedHeadssgh.func_78792_a(this.ssgohan11); this.bipedHeadssgh.func_78792_a(this.ssgohan12); this.bipedHeadssgh.func_78792_a(this.ssgohan13); this.bipedHeadssgh.func_78792_a(this.ssgohan14); this.bipedHeadssgh.func_78792_a(this.ssgohan15); this.bipedHeadssgh.func_78792_a(this.ssgohan16); this.bipedHeadssgh.func_78792_a(this.ssgohan17); this.bipedHeadssgh.func_78792_a(this.ssgohan18); this.bipedHeadssgh.func_78792_a(this.ssgohan19); this.bipedHeadssgh.func_78792_a(this.ssgohan20); this.bipedHeadssgh.func_78792_a(this.ssgohan21); this.bipedHeadssgh.func_78792_a(this.ssgohan22); this.bipedHeadssgh.func_78792_a(this.ssgohan26); this.bipedHeadg2.func_78792_a(this.bipedHeadAll); this.bipedHeadg2.func_78792_a(this.gokuni1); this.bipedHeadg2.func_78792_a(this.gokuni2); this.bipedHeadg2.func_78792_a(this.gokuni3); this.bipedHeadg2.func_78792_a(this.gokuni4); this.bipedHeadg2.func_78792_a(this.gokuni5); this.bipedHeadg2.func_78792_a(this.gokuni6); this.bipedHeadg2.func_78792_a(this.gokuni7); this.bipedHeadg2.func_78792_a(this.gokuni8); this.bipedHeadg2.func_78792_a(this.gokuni9); this.bipedHeadg2.func_78792_a(this.gokuni10); this.bipedHeadg2.func_78792_a(this.gokuni11); this.bipedHeadg2.func_78792_a(this.gokuni12); this.bipedHeadght.func_78792_a(this.bipedHeadAll); this.bipedHeadght.func_78792_a(this.ght1); this.bipedHeadght.func_78792_a(this.ght2); this.bipedHeadght.func_78792_a(this.ght3); this.bipedHeadght.func_78792_a(this.ght4); this.bipedHeadght.func_78792_a(this.ght5); this.bipedHeadght.func_78792_a(this.ght6); this.bipedHeadght.func_78792_a(this.ght7); this.bipedHeadght.func_78792_a(this.ght8); this.bipedHeadght.func_78792_a(this.ght9); this.bipedHeadght.func_78792_a(this.ght11); this.bipedHeadght.func_78792_a(this.ght14); this.bipedHeadght.func_78792_a(this.ght16); this.bipedHeadgt.func_78792_a(this.bipedHeadAll); this.bipedHeadgt.func_78792_a(this.goten2); this.bipedHeadgt.func_78792_a(this.goten3); this.bipedHeadgt.func_78792_a(this.goten4); this.bipedHeadgt.func_78792_a(this.goten5); this.bipedHeadgt.func_78792_a(this.goten6); this.bipedHeadgt.func_78792_a(this.goten9); this.bipedHeadgt.func_78792_a(this.goten14); this.bipedHeadgt.func_78792_a(this.goten16); this.bipedHeadgtt.func_78792_a(this.bipedHeadAll); this.bipedHeadgtt.func_78792_a(this.gotent1); this.bipedHeadgtt.func_78792_a(this.gotent2); this.bipedHeadgtt.func_78792_a(this.gotent3); this.bipedHeadgtt.func_78792_a(this.gotent5); this.bipedHeadgtt.func_78792_a(this.gotent6); this.bipedHeadgtt.func_78792_a(this.gotent7); this.bipedHeadgtt.func_78792_a(this.gotent8); this.bipedHeadgtt.func_78792_a(this.gotent9); this.bipedHeadgtt.func_78792_a(this.gotent11); this.bipedHeadgtt.func_78792_a(this.gotent16); this.bipedHeadc7.func_78792_a(this.bipedHeadAll); this.bipedHeadc7.func_78792_a(this.hairc71); this.bipedHeadc7.func_78792_a(this.hairc72); this.bipedHeadc8.func_78792_a(this.bipedHeadAll); this.bipedHeadc8.func_78792_a(this.hairc81); this.bipedHeadc8.func_78792_a(this.hairc82); this.bipedHeadc8.func_78792_a(this.hairc83); this.bipedHeadrad.func_78792_a(this.bipedHeadAll); this.bipedHeadrad.func_78792_a(this.radlike1); this.bipedHeadrad.func_78792_a(this.radlike2); this.bipedHeadrad.func_78792_a(this.radlike3); this.bipedHeadrad.func_78792_a(this.radlike4); this.bipedHeadrad.func_78792_a(this.radlike5); this.bipedHeadrad.func_78792_a(this.radlike7); this.bipedHeadrad.func_78792_a(this.radlike8); this.bipedHeadrad.func_78792_a(this.radlike10); this.bipedHeadrad.func_78792_a(this.radlike11); this.bipedHeadrad.func_78792_a(this.radlike12); this.bipedHeadrad.func_78792_a(this.radlike13); this.bipedHeadrad.func_78792_a(this.radlike14); this.bipedHeadrad.func_78792_a(this.radlike15); this.bipedHeadrad.func_78792_a(this.radlike16); this.bipedHeadrad.func_78792_a(this.radlike18); this.bipedHeadrad.func_78792_a(this.radlike19); this.bipedHeadrad.func_78792_a(this.radlike20); this.bipedHeadrad.func_78792_a(this.radlike21); this.bipedHeadrad.func_78792_a(this.radlike22); this.bipedHeadrad.func_78792_a(this.radlike23); this.bipedHeadrad.func_78792_a(this.radlike24); this.bipedHeadrad.func_78792_a(this.radlike25); this.bipedHeadrad.func_78792_a(this.radlike26); this.bipedHeadrad.func_78792_a(this.radlike27); this.bipedHeadrad.func_78792_a(this.radlike28); this.bipedHeadrad.func_78792_a(this.radlike29); this.bipedHeadrad.func_78792_a(this.radlike30); this.bipedHeadrad.func_78792_a(this.radlike31); this.bipedHeadrad.func_78792_a(this.radlike32); this.bipedHeadradl.func_78792_a(this.radlik1); this.bipedHeadradl.func_78792_a(this.radlik2); this.bipedHeadradl.func_78792_a(this.radlik3); this.bipedHeadradl.func_78792_a(this.radlik4); this.bipedHeadradl.func_78792_a(this.radlik5); this.bipedHeadradl.func_78792_a(this.radlik8); this.bipedHeadradl.func_78792_a(this.radlik9); this.bipedHeadradl.func_78792_a(this.radlik10); this.bipedHeadradl.func_78792_a(this.radlik11); this.bipedHeadradl.func_78792_a(this.radlik12); this.bipedHeadradl.func_78792_a(this.radlik13); this.bipedHeadradl.func_78792_a(this.radlik14); this.bipedHeadradl.func_78792_a(this.radlik18); this.bipedHeadradl2.func_78792_a(this.radlik6); this.bipedHeadradl2.func_78792_a(this.radlik7); this.bipedHeadradl2.func_78792_a(this.radlik15); this.bipedHeadradl2.func_78792_a(this.radlike17); this.bipedHeadradl2.func_78792_a(this.radlik16); this.bipedHeadradl2.func_78792_a(this.radlik17); this.bipedHeadssj3.func_78792_a(this.bipedHeadAll); this.bipedHeadssj3.func_78792_a(this.ssjsan1); this.bipedHeadssj3.func_78792_a(this.ssjsan2); this.bipedHeadssj3.func_78792_a(this.ssjsan3); this.bipedHeadssj3.func_78792_a(this.ssjsan4); this.bipedHeadssj3.func_78792_a(this.ssjsan5); this.bipedHeadssj3.func_78792_a(this.ssjsan7); this.bipedHeadssj3.func_78792_a(this.ssjsan8); this.bipedHeadssj3.func_78792_a(this.ssjsan10); this.bipedHeadssj3.func_78792_a(this.ssjsan11); this.bipedHeadssj3.func_78792_a(this.ssjsan12); this.bipedHeadssj3.func_78792_a(this.ssjsan13); this.bipedHeadssj3.func_78792_a(this.ssjsan14); this.bipedHeadssj3.func_78792_a(this.ssjsan15); this.bipedHeadssj3.func_78792_a(this.ssjsan16); this.bipedHeadssj3.func_78792_a(this.ssjsan18); this.bipedHeadssj3.func_78792_a(this.ssjsan19); this.bipedHeadssj3.func_78792_a(this.ssjsan20); this.bipedHeadssj3.func_78792_a(this.ssjsan21); this.bipedHeadssj3.func_78792_a(this.ssjsan22); this.bipedHeadssj3.func_78792_a(this.ssjsan23); this.bipedHeadssj3.func_78792_a(this.ssjsan24); this.bipedHeadssj3.func_78792_a(this.ssjsan25); this.bipedHeadssj3.func_78792_a(this.ssjsan26); this.bipedHeadssj3.func_78792_a(this.ssjsan27); this.bipedHeadssj3.func_78792_a(this.ssjsan28); this.bipedHeadssj3.func_78792_a(this.ssjsan29); this.bipedHeadssj3.func_78792_a(this.ssjsan30); this.bipedHeadssj3.func_78792_a(this.ssjsan31); this.bipedHeadssj3.func_78792_a(this.ssjsan32); this.bipedHeadssj3l2.func_78792_a(this.long6); this.bipedHeadssj3l2.func_78792_a(this.long7); this.bipedHeadssj3l2.func_78792_a(this.long15); this.bipedHeadssj3l2.func_78792_a(this.ssjsan17); this.bipedHeadssj3l2.func_78792_a(this.long16); this.bipedHeadssj3l2.func_78792_a(this.long17); this.bipedHeadssj3l.func_78792_a(this.long1); this.bipedHeadssj3l.func_78792_a(this.long2); this.bipedHeadssj3l.func_78792_a(this.long3); this.bipedHeadssj3l.func_78792_a(this.long4); this.bipedHeadssj3l.func_78792_a(this.long5); this.bipedHeadssj3l.func_78792_a(this.long8); this.bipedHeadssj3l.func_78792_a(this.long9); this.bipedHeadssj3l.func_78792_a(this.long10); this.bipedHeadssj3l.func_78792_a(this.long11); this.bipedHeadssj3l.func_78792_a(this.long12); this.bipedHeadssj3l.func_78792_a(this.long13); this.bipedHeadssj3l.func_78792_a(this.long14); this.bipedHeadssj3l.func_78792_a(this.long18); this.bipedHeadssj3t.func_78792_a(this.tincs1); this.halo = new ModelRenderer((ModelBase)this, 32, 0); this.halo.func_78789_a(-0.0F, -0.0F, -0.0F, 0, 0, 0); this.halo.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.halo, 0.0F, 0.0F, 0.0F); this.halo1 = new ModelRenderer((ModelBase)this, 32, 0); this.halo1.func_78789_a(-4.0F, -13.0F, -5.0F, 9, 1, 1); this.halo1.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.halo1, 0.0F, 0.0F, 0.0F); this.halo2 = new ModelRenderer((ModelBase)this, 32, 0); this.halo2.func_78789_a(-5.0F, -13.0F, -5.0F, 1, 1, 9); this.halo2.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.halo2, 0.0F, 0.0F, 0.0F); this.halo3 = new ModelRenderer((ModelBase)this, 32, 0); this.halo3.func_78789_a(4.0F, -13.0F, -4.0F, 1, 1, 9); this.halo3.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.halo3, 0.0F, 0.0F, 0.0F); this.halo4 = new ModelRenderer((ModelBase)this, 32, 0); this.halo4.func_78789_a(-5.0F, -13.0F, 4.0F, 9, 1, 1); this.halo4.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.halo4, 0.0F, 0.0F, 0.0F); this.halo.func_78792_a(this.halo1); this.halo.func_78792_a(this.halo2); this.halo.func_78792_a(this.halo3); this.halo.func_78792_a(this.halo4); this.rightarm = new ModelRenderer((ModelBase)this, 40, 16); this.rightarm.func_78790_a(-3.0F, -2.0F, -2.0F, 4, 12, 4, par1 * 0.5F); this.rightarm.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.rightarm, 0.0F, 0.0F, 0.122173F); this.leftarm = new ModelRenderer((ModelBase)this, 40, 16); this.leftarm.field_78809_i = true; this.leftarm.func_78790_a(-1.0F, -2.0F, -2.0F, 4, 12, 4, par1 * 0.5F); this.leftarm.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.leftarm, 0.0F, 0.0F, -0.122173F); this.Brightarm = new ModelRenderer((ModelBase)this, 0, 0); this.Brightarm.func_78790_a(-3.0F, -2.0F, -2.0F, 0, 0, 0, par1 * 0.5F); this.Brightarm.func_78793_a(-5.0F, 2.0F, 0.0F); this.Bleftarm = new ModelRenderer((ModelBase)this, 0, 0); this.Bleftarm.field_78809_i = true; this.Bleftarm.func_78790_a(-1.0F, -2.0F, -2.0F, 0, 0, 0, par1 * 0.5F); this.Bleftarm.func_78793_a(5.0F, 2.0F, 0.0F); this.rightleg = new ModelRenderer((ModelBase)this, 0, 16); this.rightleg.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, par1 * 0.5F); this.rightleg.func_78793_a(-2.0F, 12.0F, 0.0F); setRotation(this.rightleg, 0.0F, 0.0F, 0.0F); this.leftleg = new ModelRenderer((ModelBase)this, 0, 16); this.leftleg.field_78809_i = true; this.leftleg.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, par1 * 0.5F); this.leftleg.func_78793_a(2.0F, 12.0F, 0.0F); setRotation(this.leftleg, 0.0F, 0.0F, 0.0F); this.skirt1 = new ModelRenderer((ModelBase)this, 16, 18); this.skirt1.func_78790_a(-4.0F, 9.0F, -2.0F, 8, 2, 4, par1 * 0.5F); this.skirt1.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.skirt1, 0.0F, 0.0F, 0.0F); this.skirt2 = new ModelRenderer((ModelBase)this, 16, 20); this.skirt2.func_78790_a(-4.0F, 11.0F, -2.0F, 8, 1, 4, par1 * 0.5F); this.skirt2.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.skirt2, 0.0F, 0.0F, 0.0F); this.body = new ModelRenderer((ModelBase)this, 16, 16); this.body.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 4, 4, par1 * 0.5F); this.body.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.body, 0.0F, 0.0F, 0.0F); this.hip = new ModelRenderer((ModelBase)this, 16, 23); this.hip.func_78790_a(-4.0F, 7.0F, -2.0F, 8, 2, 4, par1 * 0.5F); this.hip.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.hip, 0.0F, 0.0F, 0.0F); this.waist = new ModelRenderer((ModelBase)this, 16, 20); this.waist.func_78790_a(-4.0F, 4.0F, -2.0F, 8, 3, 4, par1 * 0.5F); this.waist.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.waist, 0.0F, 0.0F, 0.0F); this.Bbreast = new ModelRenderer((ModelBase)this, 0, 0); this.Bbreast.func_78790_a(-4.0F, 2.266667F, -1.0F, 0, 0, 0, par1 * 0.5F); this.Bbreast.func_78793_a(0.0F, 0.0F, 0.0F); this.breast = new ModelRenderer((ModelBase)this, 17, 18); this.breast.func_78790_a(-4.0F, 2.266667F, -1.0F, 8, 3, 3, par1 * 0.5F); this.breast.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.breast, -0.5235988F, 0.0F, 0.0F); this.Bbreast2 = new ModelRenderer((ModelBase)this, 0, 0); this.Bbreast2.func_78790_a(-4.0F, 2.266667F, -1.0F, 0, 0, 0, par1 * 0.5F); this.Bbreast2.func_78793_a(0.0F, 0.0F, 0.0F); this.breast2 = new ModelRenderer((ModelBase)this, 9, 23); this.breast2.field_78809_i = true; this.breast2.func_78790_a(-4.0F, 2.266667F, -2.0F, 8, 3, 3, par1 * 0.5F); this.breast2.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.breast2, 0.5235988F, 3.141593F, 0.0F); this.bottom = new ModelRenderer((ModelBase)this, 16, 25); this.bottom.func_78790_a(-4.0F, 9.0F, -2.0F, 8, 3, 4, par1 * 0.5F); this.bottom.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.bottom, 0.0F, 0.0F, 0.0F); this.Bbreast.func_78792_a(this.breast); this.Bbreast2.func_78792_a(this.breast2); this.Bleftarm.func_78792_a(this.leftarm); this.Brightarm.func_78792_a(this.rightarm); this.S1rightarm = new ModelRenderer((ModelBase)this, 40, 16); this.S1rightarm.func_78790_a(-3.0F, -2.0F, -2.0F, 4, 12, 4, par1 * 0.5F * 1.001F); this.S1rightarm.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.S1rightarm, 0.0F, 0.0F, 0.122173F); this.S1leftarm = new ModelRenderer((ModelBase)this, 40, 16); this.S1leftarm.field_78809_i = true; this.S1leftarm.func_78790_a(-1.0F, -2.0F, -2.0F, 4, 12, 4, par1 * 0.5F * 1.001F); this.S1leftarm.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.S1leftarm, 0.0F, 0.0F, -0.122173F); this.S1Brightarm = new ModelRenderer((ModelBase)this, 0, 0); this.S1Brightarm.func_78790_a(-3.0F, -2.0F, -2.0F, 0, 0, 0, par1 * 0.5F * 1.001F); this.S1Brightarm.func_78793_a(-5.0F, 2.0F, 0.0F); this.S1Bleftarm = new ModelRenderer((ModelBase)this, 0, 0); this.S1Bleftarm.field_78809_i = true; this.S1Bleftarm.func_78790_a(-1.0F, -2.0F, -2.0F, 0, 0, 0, par1 * 0.5F * 1.001F); this.S1Bleftarm.func_78793_a(5.0F, 2.0F, 0.0F); this.S1rightleg = new ModelRenderer((ModelBase)this, 0, 16); this.S1rightleg.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, par1 * 0.5F * 1.001F); this.S1rightleg.func_78793_a(-2.0F, 12.0F, 0.0F); setRotation(this.S1rightleg, 0.0F, 0.0F, 0.0F); this.S1leftleg = new ModelRenderer((ModelBase)this, 0, 16); this.S1leftleg.field_78809_i = true; this.S1leftleg.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, par1 * 0.5F * 1.001F); this.S1leftleg.func_78793_a(2.0F, 12.0F, 0.0F); setRotation(this.S1leftleg, 0.0F, 0.0F, 0.0F); this.S1skirt1 = new ModelRenderer((ModelBase)this, 16, 18); this.S1skirt1.func_78790_a(-4.0F, 9.0F, -2.0F, 8, 2, 4, par1 * 0.5F * 1.001F); this.S1skirt1.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.S1skirt1, 0.0F, 0.0F, 0.0F); this.S1skirt2 = new ModelRenderer((ModelBase)this, 16, 20); this.S1skirt2.func_78790_a(-4.0F, 11.0F, -2.0F, 8, 1, 4, par1 * 0.5F * 1.001F); this.S1skirt2.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.S1skirt2, 0.0F, 0.0F, 0.0F); this.S1body = new ModelRenderer((ModelBase)this, 16, 16); this.S1body.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 4, 4, par1 * 0.5F * 1.001F); this.S1body.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.S1body, 0.0F, 0.0F, 0.0F); this.S1hip = new ModelRenderer((ModelBase)this, 16, 23); this.S1hip.func_78790_a(-4.0F, 7.0F, -2.0F, 8, 2, 4, par1 * 0.5F * 1.001F); this.S1hip.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.S1hip, 0.0F, 0.0F, 0.0F); this.S1waist = new ModelRenderer((ModelBase)this, 16, 20); this.S1waist.func_78790_a(-4.0F, 4.0F, -2.0F, 8, 3, 4, par1 * 0.5F * 1.001F); this.S1waist.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.S1waist, 0.0F, 0.0F, 0.0F); this.S1Bbreast = new ModelRenderer((ModelBase)this, 0, 0); this.S1Bbreast.func_78790_a(-4.0F, 2.266667F, -1.0F, 0, 0, 0, par1 * 0.5F * 1.001F); this.S1Bbreast.func_78793_a(0.0F, 0.0F, 0.0F); this.S1breast = new ModelRenderer((ModelBase)this, 17, 18); this.S1breast.func_78790_a(-4.0F, 2.266667F, -1.0F, 8, 3, 3, par1 * 0.5F * 1.001F); this.S1breast.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.S1breast, -0.5235988F, 0.0F, 0.0F); this.S1Bbreast2 = new ModelRenderer((ModelBase)this, 0, 0); this.S1Bbreast2.func_78790_a(-4.0F, 2.266667F, -1.0F, 0, 0, 0, par1 * 0.5F * 1.001F); this.S1Bbreast2.func_78793_a(0.0F, 0.0F, 0.0F); this.S1breast2 = new ModelRenderer((ModelBase)this, 9, 23); this.S1breast2.field_78809_i = true; this.S1breast2.func_78790_a(-4.0F, 2.266667F, -2.0F, 8, 3, 3, par1 * 0.5F * 1.001F); this.S1breast2.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.S1breast2, 0.5235988F, 3.141593F, 0.0F); this.S1bottom = new ModelRenderer((ModelBase)this, 16, 25); this.S1bottom.func_78790_a(-4.0F, 9.0F, -2.0F, 8, 3, 4, par1 * 0.5F * 1.001F); this.S1bottom.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.S1bottom, 0.0F, 0.0F, 0.0F); this.S1Bbreast.func_78792_a(this.S1breast); this.S1Bbreast2.func_78792_a(this.S1breast2); this.S1Bleftarm.func_78792_a(this.S1leftarm); this.S1Brightarm.func_78792_a(this.S1rightarm); this.S1bipedHead = new ModelRenderer((ModelBase)this, 0, 0); this.S1bipedHead.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, par1 * 1.001F); this.S1bipedHead.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.S1bipedBody = new ModelRenderer((ModelBase)this, 16, 16); this.S1bipedBody.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 12, 4, par1 * 1.001F); this.S1bipedBody.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.S1bipedRightArm = new ModelRenderer((ModelBase)this, 40, 16); this.S1bipedRightArm.func_78790_a(-3.0F, -2.0F, -2.0F, 4, 12, 4, par1 * 1.001F); this.S1bipedRightArm.func_78793_a(-5.0F, 2.0F + par2, 0.0F); this.S1bipedLeftArm = new ModelRenderer((ModelBase)this, 40, 16); this.S1bipedLeftArm.field_78809_i = true; this.S1bipedLeftArm.func_78790_a(-1.0F, -2.0F, -2.0F, 4, 12, 4, par1 * 1.001F); this.S1bipedLeftArm.func_78793_a(5.0F, 2.0F + par2, 0.0F); this.S1bipedRightLeg = new ModelRenderer((ModelBase)this, 0, 16); this.S1bipedRightLeg.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, par1 * 1.001F); this.S1bipedRightLeg.func_78793_a(-1.9F, 12.0F + par2, 0.0F); this.S1bipedLeftLeg = new ModelRenderer((ModelBase)this, 0, 16); this.S1bipedLeftLeg.field_78809_i = true; this.S1bipedLeftLeg.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, par1 * 1.001F); this.S1bipedLeftLeg.func_78793_a(1.9F, 12.0F + par2, 0.0F); this.Nam = new ModelRenderer((ModelBase)this, 0, 0); this.Nam.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.Nam.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.near1 = new ModelRenderer((ModelBase)this, 24, -2); this.near1.func_78789_a(-3.5F, -6.0F, -4.0F, 0, 4, 2); this.near1.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.near1, -0.4014257F, 0.0F, -0.1745329F); this.near2 = new ModelRenderer((ModelBase)this, 24, -2); this.near2.func_78789_a(3.466667F, -6.0F, -4.0F, 0, 4, 2); this.near2.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.near2, -0.4014257F, 0.0F, 0.1745329F); this.ant1 = new ModelRenderer((ModelBase)this, 24, 4); this.ant1.func_78789_a(0.0F, -5.0F, -8.0F, 1, 1, 2); this.ant1.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ant1, -0.3490659F, -0.4363323F, 0.0F); this.ant2 = new ModelRenderer((ModelBase)this, 24, 4); this.ant2.func_78789_a(0.0F, -8.533334F, -6.2F, 1, 1, 2); this.ant2.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ant2, 0.2094395F, -0.4364196F, 0.0F); this.ant3 = new ModelRenderer((ModelBase)this, 24, 4); this.ant3.func_78789_a(-1.0F, -5.0F, -8.0F, 1, 1, 2); this.ant3.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ant3, -0.3490659F, 0.4363323F, 0.0F); this.ant4 = new ModelRenderer((ModelBase)this, 24, 4); this.ant4.func_78789_a(-1.0F, -8.533334F, -6.2F, 1, 1, 2); this.ant4.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ant4, 0.2094395F, 0.4364196F, 0.0F); this.Nam.func_78792_a(this.ant1); this.Nam.func_78792_a(this.ant2); this.Nam.func_78792_a(this.ant3); this.Nam.func_78792_a(this.ant4); this.Fro = new ModelRenderer((ModelBase)this, 0, 0); this.Fro.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.Fro.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.Fro0 = new ModelRenderer((ModelBase)this, 0, 0); this.Fro0.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.Fro0.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.Fro1 = new ModelRenderer((ModelBase)this, 0, 0); this.Fro1.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.Fro1.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.Fro2 = new ModelRenderer((ModelBase)this, 0, 0); this.Fro2.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.Fro2.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.Fro5 = new ModelRenderer((ModelBase)this, 0, 0); this.Fro5.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.Fro5.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.Fro5b = new ModelRenderer((ModelBase)this, 0, 0); this.Fro5b.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.Fro5b.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.Fro5r = new ModelRenderer((ModelBase)this, 0, 0); this.Fro5r.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.Fro5r.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.Fro5l = new ModelRenderer((ModelBase)this, 0, 0); this.Fro5l.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.Fro5l.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.FroB = new ModelRenderer((ModelBase)this, 0, 0); this.FroB.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 12, 0, 0.02F); this.FroB.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.appule = new ModelRenderer((ModelBase)this, 0, 16); this.appule.func_78789_a(-4.0F, -8.0F, 4.0F, 8, 8, 8); this.appule.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.appule, 0.0F, 0.0F, 0.0F); this.Fhorn2 = new ModelRenderer((ModelBase)this, 8, 6); this.Fhorn2.func_78789_a(1.5F, -11.0F, -3.5F, 2, 4, 2); this.Fhorn2.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.Fhorn2, 0.0F, 0.0F, -0.7853982F); this.Fhorn1 = new ModelRenderer((ModelBase)this, 8, 6); this.Fhorn1.func_78789_a(-3.5F, -11.0F, -3.5F, 2, 4, 2); this.Fhorn1.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.Fhorn1, 0.0F, 0.0F, 0.7853982F); this.Fhorn3 = new ModelRenderer((ModelBase)this, 8, 6); this.Fhorn3.func_78789_a(2.5F, -14.0F, -3.5F, 2, 4, 2); this.Fhorn3.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.Fhorn3, 0.0F, 0.0F, 0.2094395F); this.Fhorn4 = new ModelRenderer((ModelBase)this, 8, 6); this.Fhorn4.func_78789_a(-4.5F, -14.0F, -3.5F, 2, 4, 2); this.Fhorn4.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.Fhorn4, 0.0F, 0.0F, -0.2094395F); this.F2horn1 = new ModelRenderer((ModelBase)this, 16, 6); this.F2horn1.func_78789_a(-3.5F, -11.0F, 6.5F, 2, 4, 2); this.F2horn1.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.F2horn1, 0.0F, 0.0F, 0.7853982F); this.F2horn2 = new ModelRenderer((ModelBase)this, 16, 6); this.F2horn2.func_78789_a(1.5F, -11.0F, 6.5F, 2, 4, 2); this.F2horn2.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.F2horn2, 0.0F, 0.0F, -0.7853982F); this.ftail1 = new ModelRenderer((ModelBase)this, 32, 16); this.ftail1.func_78789_a(-2.0F, 7.0F, 4.0F, 4, 4, 12); this.ftail1.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ftail1, -0.3490659F, 0.0F, 0.0F); this.ftail2 = new ModelRenderer((ModelBase)this, 32, 16); this.ftail2.func_78789_a(-2.0F, 15.0F, 2.0F, 4, 4, 12); this.ftail2.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ftail2, 0.5235988F, 1.33E-5F, 0.0F); this.F5horn1 = new ModelRenderer((ModelBase)this, 8, 6); this.F5horn1.func_78789_a(-4.5F, -8.0F, -6.5F, 2, 6, 2); this.F5horn1.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.F5horn1, -0.6981317F, 0.0F, 1.047198F); this.F5horn2 = new ModelRenderer((ModelBase)this, 8, 6); this.F5horn2.func_78789_a(2.5F, -8.0F, -6.5F, 2, 6, 2); this.F5horn2.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.F5horn2, -0.6981317F, 0.0F, -1.047198F); this.F5horn3 = new ModelRenderer((ModelBase)this, 8, 6); this.F5horn3.func_78789_a(-0.5F, -10.0F, -8.0F, 2, 6, 2); this.F5horn3.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.F5horn3, -0.6981317F, 0.0F, 0.2094395F); this.F5horn4 = new ModelRenderer((ModelBase)this, 8, 6); this.F5horn4.func_78789_a(-1.5F, -10.0F, -8.0F, 2, 6, 2); this.F5horn4.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.F5horn4, -0.6981317F, 0.0F, -0.2094395F); this.F5horn5 = new ModelRenderer((ModelBase)this, 8, 6); this.F5horn5.func_78789_a(-2.5F, -7.0F, -7.2F, 5, 2, 2); this.F5horn5.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.F5horn5, -0.5235988F, 0.0F, 0.0F); this.F5spike1 = new ModelRenderer((ModelBase)this, 0, 6); this.F5spike1.func_78789_a(-6.0F, 1.0F, -1.0F, 1, 5, 2); this.F5spike1.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.F5spike1, 0.0F, 0.0F, -0.5235988F); this.F5spike2 = new ModelRenderer((ModelBase)this, 0, 6); this.F5spike2.func_78789_a(5.0F, 1.0F, -1.0F, 1, 5, 2); this.F5spike2.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.F5spike2, 0.0F, 0.0F, 0.5235988F); this.F5spike3 = new ModelRenderer((ModelBase)this, 8, 38); this.F5spike3.func_78789_a(2.0F, -4.0F, 3.0F, 2, 6, 2); this.F5spike3.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.F5spike3, -0.9773844F, 0.0F, 0.2094395F); this.F5spike4 = new ModelRenderer((ModelBase)this, 8, 38); this.F5spike4.func_78789_a(-4.0F, -4.0F, 3.0F, 2, 6, 2); this.F5spike4.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.F5spike4, -0.9773844F, 0.0F, -0.2094395F); this.ftailS1 = new ModelRenderer((ModelBase)this, 38, 54); this.ftailS1.func_78789_a(-2.0F, -2.0F, 0.0F, 4, 4, 6); this.ftailS1.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ftailS1, -0.5235988F, 0.0F, 0.0F); this.ftailS2 = new ModelRenderer((ModelBase)this, 38, 54); this.ftailS2.func_78789_a(-2.0F, -2.0F, 0.0F, 4, 4, 6); this.ftailS2.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ftailS2, 0.5235988F, 8.727E-4F, 0.0F); this.ftailS3 = new ModelRenderer((ModelBase)this, 38, 54); this.ftailS3.func_78789_a(-2.0F, -2.0F, 0.0F, 4, 4, 6); this.ftailS3.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ftailS3, 0.0F, 0.0F, 0.0F); this.ftailS4 = new ModelRenderer((ModelBase)this, 38, 54); this.ftailS4.func_78789_a(-2.0F, -2.0F, 0.0F, 4, 4, 6); this.ftailS4.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ftailS4, 0.0F, 0.0F, 0.0F); this.ftailS5 = new ModelRenderer((ModelBase)this, 38, 54); this.ftailS5.func_78789_a(-2.0F, -2.0F, 0.0F, 4, 4, 6); this.ftailS5.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ftailS5, 0.0F, 0.0F, 0.0F); this.ftailS6 = new ModelRenderer((ModelBase)this, 38, 54); this.ftailS6.func_78789_a(-2.0F, -2.0F, 0.0F, 4, 4, 6); this.ftailS6.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.ftailS6, 0.0F, 0.0F, 0.0F); this.ftailS5.func_78792_a(this.ftailS6); this.ftailS4.func_78792_a(this.ftailS5); this.ftailS3.func_78792_a(this.ftailS4); this.ftailS2.func_78792_a(this.ftailS3); this.ftailS1.func_78792_a(this.ftailS2); this.FroB.func_78792_a(this.ftailS1); this.FroB.field_78800_c = 2.0F; this.FroB.field_78797_d = 10.0F; this.FroB.field_78798_e = 2.0F; this.ftailS1.field_78800_c = -2.0F; this.ftailS1.field_78797_d = -2.0F; this.ftailS1.field_78798_e = 0.0F; this.ftailS2.field_78800_c = 0.0F; this.ftailS2.field_78797_d = 0.0F; this.ftailS2.field_78798_e = 5.0F; this.ftailS3.field_78800_c = 0.0F; this.ftailS3.field_78797_d = 0.0F; this.ftailS3.field_78798_e = 5.0F; this.ftailS4.field_78800_c = 0.0F; this.ftailS4.field_78797_d = 0.0F; this.ftailS4.field_78798_e = 5.0F; this.ftailS5.field_78800_c = 0.0F; this.ftailS5.field_78797_d = 0.0F; this.ftailS5.field_78798_e = 5.0F; this.ftailS6.field_78800_c = 0.0F; this.ftailS6.field_78797_d = 0.0F; this.ftailS6.field_78798_e = 5.0F; this.fear1 = new ModelRenderer((ModelBase)this, 12, 0); this.fear1.func_78789_a(-5.0F, -5.0F, -3.0F, 1, 3, 2); this.fear1.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.fear1, -0.4014257F, 0.0F, 0.0F); this.fear2 = new ModelRenderer((ModelBase)this, 12, 0); this.fear2.field_78809_i = true; this.fear2.func_78789_a(4.0F, -5.0F, -3.0F, 1, 3, 2); this.fear2.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.fear2, -0.4014257F, 0.0F, 0.0F); this.rightarmshoulder = new ModelRenderer((ModelBase)this, 38, 0); this.rightarmshoulder.func_78789_a(-6.0F, -3.0F, -3.0F, 7, 4, 6); this.rightarmshoulder.func_78793_a(-5.0F, 2.0F, 0.0F); this.rightarmshoulder.func_78787_b(128, 64); this.leftarmshoulder = new ModelRenderer((ModelBase)this, 38, 0); this.leftarmshoulder.field_78809_i = true; this.leftarmshoulder.func_78789_a(-1.0F, -3.0F, -3.0F, 7, 4, 6); this.leftarmshoulder.func_78793_a(5.0F, 2.0F, 0.0F); this.leftarmshoulder.func_78787_b(128, 64); this.Fro0.func_78792_a(this.Fhorn2); this.Fro0.func_78792_a(this.Fhorn1); this.Fro1.func_78792_a(this.Fhorn3); this.Fro1.func_78792_a(this.Fhorn4); this.Fro2.func_78792_a(this.appule); this.Fro2.func_78792_a(this.F2horn1); this.Fro2.func_78792_a(this.F2horn2); this.Fro.func_78792_a(this.fear1); this.Fro.func_78792_a(this.fear2); this.Fro5.func_78792_a(this.F5horn1); this.Fro5.func_78792_a(this.F5horn2); this.Fro5.func_78792_a(this.F5horn3); this.Fro5.func_78792_a(this.F5horn4); this.Fro5.func_78792_a(this.F5horn5); this.Fro5r.func_78792_a(this.F5spike1); this.Fro5l.func_78792_a(this.F5spike2); this.Fro5b.func_78792_a(this.F5spike3); this.Fro5b.func_78792_a(this.F5spike4); this.SaiE = new ModelRenderer((ModelBase)this, 0, 0); this.SaiE.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.SaiE.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.kao = new ModelRenderer((ModelBase)this, 0, 0); this.kao.func_78789_a(-4.0F, -8.0F, -4.005F, 8, 8, 0); this.kao.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.kao, 0.0F, 0.0F, 0.0F); this.SaiE.func_78792_a(this.kao); this.face1 = new ModelRenderer((ModelBase)this, 0, 0); this.face1.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.face1.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.nose = new ModelRenderer((ModelBase)this, 0, 0); this.nose.func_78789_a(-4.0F, -8.0F, -4.006F, 8, 8, 0); this.nose.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.nose, 0.0F, 0.0F, 0.0F); this.face1.func_78792_a(this.nose); this.face2 = new ModelRenderer((ModelBase)this, 0, 0); this.face2.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.face2.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.mouth = new ModelRenderer((ModelBase)this, 0, 0); this.mouth.func_78789_a(-4.0F, -8.0F, -4.007F, 8, 8, 0); this.mouth.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.mouth, 0.0F, 0.0F, 0.0F); this.face2.func_78792_a(this.mouth); this.face5 = new ModelRenderer((ModelBase)this, 0, 0); this.face5.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.face5.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.eyeb = new ModelRenderer((ModelBase)this, 0, 0); this.eyeb.func_78789_a(-4.0F, -8.0F, -4.008F, 8, 8, 0); this.eyeb.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.eyeb, 0.0F, 0.0F, 0.0F); this.face5.func_78792_a(this.eyeb); this.face3 = new ModelRenderer((ModelBase)this, 0, 0); this.face3.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.face3.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.eyel = new ModelRenderer((ModelBase)this, 0, 0); this.eyel.func_78789_a(-4.0F, -8.0F, -4.009F, 8, 8, 0); this.eyel.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.eyel, 0.0F, 0.0F, 0.0F); this.face3.func_78792_a(this.eyel); this.face4 = new ModelRenderer((ModelBase)this, 0, 0); this.face4.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.face4.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.eyer = new ModelRenderer((ModelBase)this, 0, 0); this.eyer.func_78789_a(-4.0F, -8.0F, -4.01F, 8, 8, 0); this.eyer.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.eyer, 0.0F, 0.0F, 0.0F); this.face4.func_78792_a(this.eyer); this.face6 = new ModelRenderer((ModelBase)this, 0, 0); this.face6.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.face6.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.eyew = new ModelRenderer((ModelBase)this, 0, 0); this.eyew.func_78789_a(-4.0F, -8.0F, -4.01F, 8, 8, 0); this.eyew.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.eyew, 0.0F, 0.0F, 0.0F); this.face6.func_78792_a(this.eyew); this.SaiT1 = new ModelRenderer((ModelBase)this, 0, 0); this.SaiT1.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.SaiT1.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.SaiT2 = new ModelRenderer((ModelBase)this, 0, 0); this.SaiT2.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F); this.SaiT2.func_78793_a(0.0F, 0.0F + par2, 0.0F); this.tail1 = new ModelRenderer((ModelBase)this, 32, 48); this.tail1.func_78789_a(-1.0F, -1.0F, 0.0F, 2, 2, 4); this.tail1.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.tail1, -0.5235988F, 0.0F, 0.0F); this.tail2 = new ModelRenderer((ModelBase)this, 32, 48); this.tail2.func_78789_a(-1.0F, -1.0F, 0.0F, 2, 2, 4); this.tail2.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.tail2, 0.5235988F, 8.727E-4F, 0.0F); this.tailS3 = new ModelRenderer((ModelBase)this, 32, 48); this.tailS3.func_78789_a(-1.0F, -1.0F, 0.0F, 2, 2, 4); this.tailS3.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.tailS3, 0.0F, 0.0F, 0.0F); this.tailS4 = new ModelRenderer((ModelBase)this, 32, 48); this.tailS4.func_78789_a(-1.0F, -1.0F, 0.0F, 2, 2, 4); this.tailS4.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.tailS4, 0.0F, 0.0F, 0.0F); this.tailS5 = new ModelRenderer((ModelBase)this, 32, 48); this.tailS5.func_78789_a(-1.0F, -1.0F, 0.0F, 2, 2, 4); this.tailS5.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.tailS5, 0.0F, 0.0F, 0.0F); this.tailS6 = new ModelRenderer((ModelBase)this, 32, 48); this.tailS6.func_78789_a(-1.0F, -1.0F, 0.0F, 2, 2, 4); this.tailS6.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.tailS6, 0.0F, 0.0F, 0.0F); this.tail3 = new ModelRenderer((ModelBase)this, 32, 48); this.tail3.func_78789_a(3.5F, 8.0F, -2.5F, 1, 2, 5); this.tail3.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.tail3, 0.0F, 0.0F, 0.0F); this.tail4 = new ModelRenderer((ModelBase)this, 32, 48); this.tail4.func_78789_a(-4.433333F, 8.0F, -2.5F, 1, 2, 5); this.tail4.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.tail4, 0.0F, 0.0F, 0.0F); this.tail5 = new ModelRenderer((ModelBase)this, 32, 48); this.tail5.func_78789_a(-3.433333F, 8.0F, 1.5F, 7, 2, 1); this.tail5.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.tail5, 0.0F, 0.0F, 0.0F); this.tail6 = new ModelRenderer((ModelBase)this, 32, 48); this.tail6.func_78789_a(-3.433333F, 8.0F, -2.5F, 7, 2, 1); this.tail6.func_78793_a(0.0F, 0.0F, 0.0F); setRotation(this.tail6, 0.0F, 0.0F, 0.0F); this.tailS5.func_78792_a(this.tailS6); this.tailS4.func_78792_a(this.tailS5); this.tailS3.func_78792_a(this.tailS4); this.tail2.func_78792_a(this.tailS3); this.tail1.func_78792_a(this.tail2); this.SaiT1.func_78792_a(this.tail1); this.SaiT2.func_78792_a(this.tail3); this.SaiT2.func_78792_a(this.tail4); this.SaiT2.func_78792_a(this.tail5); this.SaiT2.func_78792_a(this.tail6); this.SaiT1.field_78800_c = 1.0F; this.SaiT1.field_78797_d = 10.0F; this.SaiT1.field_78798_e = 2.0F; this.tail1.field_78800_c = -1.0F; this.tail1.field_78797_d = -1.0F; this.tail1.field_78798_e = 0.0F; this.tail2.field_78800_c = 0.0F; this.tail2.field_78797_d = 0.0F; this.tail2.field_78798_e = 4.0F; this.tailS3.field_78800_c = 0.0F; this.tailS3.field_78797_d = 0.0F; this.tailS3.field_78798_e = 4.0F; this.tailS4.field_78800_c = 0.0F; this.tailS4.field_78797_d = 0.0F; this.tailS4.field_78798_e = 4.0F; this.tailS5.field_78800_c = 0.0F; this.tailS5.field_78797_d = 0.0F; this.tailS5.field_78798_e = 4.0F; this.tailS6.field_78800_c = 0.0F; this.tailS6.field_78797_d = 0.0F; this.tailS6.field_78798_e = 4.0F; if (this.hairall == null) { this.hairall = new ModelRendererJBRA[224]; int hossz; for (hossz = 0; hossz < 4; hossz++) { for (int face = 0; face < 56; face++) { if (this.hairall[hossz + face * 4] == null) { this.hairall[hossz + face * 4] = new ModelRendererJBRA((ModelBase)this, 32, 0); this.hairall[hossz + face * 4].addBox(-1.0F, (hossz == 0) ? -1.0F : 0.0F, -1.0F, 2, 3, 2); this.hairall[hossz + face * 4].setRotationPoint(0.0F, 0.0F, 0.0F); setRotation(this.hairall[hossz + face * 4], 0.0F, 0.0F, 0.0F); }  }  }
/*      */        for (hossz = 0; hossz < 4; hossz++) { for (int face = 0; face < 56; face++) { if (hossz != 3)
/*      */             this.hairall[hossz + face * 4].addChild(this.hairall[hossz + 1 + face * 4]);  }
/*      */          }
/*      */        }
/* 3745 */      } public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) { if (g >= 2) {
/* 3746 */       this.H = this.field_78116_c = this.S1bipedHead;
/* 3747 */       this.RA = this.Brightarm = this.S1Brightarm;
/* 3748 */       this.LA = this.Bleftarm = this.S1Bleftarm;
/* 3749 */       this.RL = this.rightleg = this.S1rightleg;
/* 3750 */       this.LL = this.leftleg = this.S1leftleg;
/* 3751 */       this.B = this.Bbreast = this.S1Bbreast;
/* 3752 */       this.B1 = this.body = this.S1body;
/* 3753 */       this.B2 = this.hip = this.S1hip;
/* 3754 */       this.B3 = this.waist = this.S1waist;
/* 3755 */       this.B4 = this.bottom = this.S1bottom;
/* 3756 */       this.B5 = this.Bbreast2 = this.S1Bbreast2;
/* 3757 */       this.B7 = this.Bbreast2 = this.S1Bbreast2;
/* 3758 */       this.B9 = this.Bbreast2 = this.S1Bbreast2;
/*      */     }
/*      */     else {
/*      */       
/* 3762 */       this.H = this.field_78116_c = this.S1bipedHead;
/* 3763 */       this.RA = this.field_78112_f = this.S1bipedRightArm;
/* 3764 */       this.LA = this.field_78113_g = this.S1bipedLeftArm;
/* 3765 */       this.RL = this.field_78123_h = this.S1bipedRightLeg;
/* 3766 */       this.LL = this.field_78124_i = this.S1bipedLeftLeg;
/* 3767 */       this.B = this.B1 = this.B2 = this.B3 = this.B4 = this.B5 = this.B7 = this.B9 = this.field_78115_e = this.S1bipedBody;
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3773 */     this.H.field_78796_g = par4 / 57.295776F;
/* 3774 */     if (y == 1) {
/* 3775 */       this.H.field_78795_f = par5 / 57.295776F;
/* 3776 */       this.RA.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 2.0F * par2 * 0.5F;
/* 3777 */       this.LA.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F) * 2.0F * par2 * 0.5F;
/*      */     } else {
/* 3779 */       this.H.field_78795_f = par5 / 57.295776F;
/* 3780 */       this.RA.field_78795_f = 0.0F;
/* 3781 */       this.LA.field_78795_f = 0.0F;
/*      */     } 
/* 3783 */     this.RA.field_78808_h = 0.0F;
/* 3784 */     this.LA.field_78808_h = 0.0F;
/* 3785 */     if (y == 1) {
/* 3786 */       this.RL.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F) * 1.4F * par2;
/* 3787 */       this.LL.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.4F * par2;
/*      */     } else {
/* 3789 */       this.RL.field_78795_f = 0.0F;
/* 3790 */       this.LL.field_78795_f = 0.0F;
/*      */     } 
/* 3792 */     this.RL.field_78796_g = 0.0F;
/* 3793 */     this.LL.field_78796_g = 0.0F;
/*      */     
/* 3795 */     if (this.field_78093_q) {
/*      */       
/* 3797 */       this.RA.field_78795_f += -0.62831855F;
/* 3798 */       this.LA.field_78795_f += -0.62831855F;
/* 3799 */       this.RL.field_78795_f = -1.2566371F;
/* 3800 */       this.LL.field_78795_f = -1.2566371F;
/* 3801 */       this.RL.field_78796_g = 0.31415927F;
/* 3802 */       this.LL.field_78796_g = -0.31415927F;
/*      */     } 
/*      */     
/* 3805 */     if (this.field_78119_l != 0)
/*      */     {
/* 3807 */       this.LA.field_78795_f = this.LA.field_78795_f * 0.5F - 0.31415927F * this.field_78119_l;
/*      */     }
/*      */     
/* 3810 */     if (this.field_78120_m != 0)
/*      */     {
/* 3812 */       this.RA.field_78795_f = this.RA.field_78795_f * 0.5F - 0.31415927F * this.field_78120_m;
/*      */     }
/*      */     
/* 3815 */     this.RA.field_78796_g = 0.0F;
/* 3816 */     this.LA.field_78796_g = 0.0F;
/*      */ 
/*      */ 
/*      */     
/* 3820 */     if (this.field_78095_p > -9990.0F) {
/*      */ 
/*      */       
/* 3823 */       float f6 = this.field_78095_p;
/* 3824 */       this.B.field_78796_g = MathHelper.func_76126_a(MathHelper.func_76129_c(f6) * 3.1415927F * 2.0F) * 0.2F;
/* 3825 */       this.B9.field_78796_g = this.B.field_78796_g;
/* 3826 */       this.RA.field_78798_e = MathHelper.func_76126_a(this.B.field_78796_g) * 5.0F;
/* 3827 */       this.RA.field_78800_c = -MathHelper.func_76134_b(this.B.field_78796_g) * 5.0F;
/* 3828 */       this.LA.field_78798_e = -MathHelper.func_76126_a(this.B.field_78796_g) * 5.0F;
/* 3829 */       this.LA.field_78800_c = MathHelper.func_76134_b(this.B.field_78796_g) * 5.0F;
/* 3830 */       this.RA.field_78796_g += this.B.field_78796_g;
/* 3831 */       this.LA.field_78796_g += this.B.field_78796_g;
/* 3832 */       this.LA.field_78795_f += this.B.field_78795_f;
/* 3833 */       f6 = 1.0F - this.field_78095_p;
/* 3834 */       f6 *= f6;
/* 3835 */       f6 *= f6;
/* 3836 */       f6 = 1.0F - f6;
/* 3837 */       float f7 = MathHelper.func_76126_a(f6 * 3.1415927F);
/* 3838 */       float f8 = MathHelper.func_76126_a(this.field_78095_p * 3.1415927F) * -(this.H.field_78795_f - 0.7F) * 0.75F;
/* 3839 */       this.RA.field_78795_f = (float)(this.RA.field_78795_f - f7 * 1.2D + f8);
/* 3840 */       this.RA.field_78796_g += this.B.field_78796_g * 2.0F;
/* 3841 */       this.RA.field_78808_h = MathHelper.func_76126_a(this.field_78095_p * 3.1415927F) * -0.4F;
/*      */     } 
/*      */ 
/*      */     
/* 3845 */     if (this.field_78117_n) {
/*      */       
/* 3847 */       this.B.field_78795_f = 0.5F;
/* 3848 */       this.B9.field_78795_f = this.B.field_78795_f;
/* 3849 */       this.RA.field_78795_f += 0.4F;
/* 3850 */       this.LA.field_78795_f += 0.4F;
/* 3851 */       this.RL.field_78798_e = 4.0F;
/* 3852 */       this.LL.field_78798_e = 4.0F;
/* 3853 */       this.RL.field_78797_d = 9.0F;
/* 3854 */       this.LL.field_78797_d = 9.0F;
/* 3855 */       this.H.field_78797_d = 1.0F;
/*      */     }
/*      */     else {
/*      */       
/* 3859 */       this.B.field_78795_f = 0.0F;
/* 3860 */       this.B9.field_78795_f = this.B.field_78795_f;
/* 3861 */       this.RL.field_78798_e = 0.1F;
/* 3862 */       this.LL.field_78798_e = 0.1F;
/* 3863 */       this.RL.field_78797_d = 12.0F;
/* 3864 */       this.LL.field_78797_d = 12.0F;
/* 3865 */       this.H.field_78797_d = 0.0F;
/*      */     } 
/*      */     
/* 3868 */     this.RA.field_78808_h += MathHelper.func_76134_b(par3 * 0.09F) * 0.05F + 0.05F;
/* 3869 */     this.LA.field_78808_h -= MathHelper.func_76134_b(par3 * 0.09F) * 0.05F + 0.05F;
/* 3870 */     this.RA.field_78795_f += MathHelper.func_76126_a(par3 * 0.067F) * 0.05F;
/* 3871 */     this.LA.field_78795_f -= MathHelper.func_76126_a(par3 * 0.067F) * 0.05F;
/*      */     
/* 3873 */     if (this.field_78118_o) {
/*      */       
/* 3875 */       float f6 = 0.0F;
/* 3876 */       float f7 = 0.0F;
/* 3877 */       this.RA.field_78808_h = 0.0F;
/* 3878 */       this.LA.field_78808_h = 0.0F;
/* 3879 */       this.RA.field_78796_g = -(0.1F - f6 * 0.6F) + this.H.field_78796_g;
/* 3880 */       this.LA.field_78796_g = 0.1F - f6 * 0.6F + this.H.field_78796_g + 0.4F;
/* 3881 */       this.RA.field_78795_f = -1.5707964F + this.H.field_78795_f;
/* 3882 */       this.LA.field_78795_f = -1.5707964F + this.H.field_78795_f;
/* 3883 */       this.RA.field_78795_f -= f6 * 1.2F - f7 * 0.4F;
/* 3884 */       this.LA.field_78795_f -= f6 * 1.2F - f7 * 0.4F;
/* 3885 */       this.RA.field_78808_h += MathHelper.func_76134_b(par3 * 0.09F) * 0.05F + 0.05F;
/* 3886 */       this.LA.field_78808_h -= MathHelper.func_76134_b(par3 * 0.09F) * 0.05F + 0.05F;
/* 3887 */       this.RA.field_78795_f += MathHelper.func_76126_a(par3 * 0.067F) * 0.05F;
/* 3888 */       this.LA.field_78795_f -= MathHelper.func_76126_a(par3 * 0.067F) * 0.05F;
/*      */     } 
/* 3890 */     this.field_78118_o = false; }
/*      */ 
/*      */   
/* 3893 */   public static String sa(String s1, int s2) { return s1.charAt(s2) + ""; }
/* 3894 */   public static int dnsHair1(String s, int n) { return (s.length() > 3) ? Integer.parseInt(sa(s, n)) : 0; }
/* 3895 */   public static int dnsHair2(String s, int n) { return (s.length() > 3) ? Integer.parseInt(sa(s, n) + sa(s, n + 1)) : 0; }
/* 3896 */   public static String dnsHair1set(String s, int n, String w) { return (s.length() > 3) ? (s.substring(0, n) + w + s.substring(n + 1)) : ""; } public static String dnsHair2set(String s, int n, String w) {
/* 3897 */     return (s.length() > 3) ? (s.substring(0, n) + w + s.substring(n + 2)) : "";
/*      */   }
/*      */   
/*      */   public void renderHairsV2(float par1, String hair, float hl, int state, int rg, int pl, int race, RenderJFC renderJFC) {
/* 3901 */     boolean pstrty = false;
/* 3902 */     boolean aura = false;
/* 3903 */     boolean trbo = false;
/* 3904 */     boolean kken = false;
/* 3905 */     boolean trty = false;
/* 3906 */     int trTime = detail ? 2 : 200;
/* 3907 */     int arTime = detail ? 2 : 200;
/*      */ 
/*      */ 
/*      */     
/* 3911 */     if (race == 1 || race == 2) {
/* 3912 */       if (renderJFC.getState(pl) == 0 && state >= 1) {
/* 3913 */         if (renderJFC.getState(pl) != state && renderJFC.getStateChange(pl) < 200) {
/* 3914 */           renderJFC.setStateChange(renderJFC.getStateChange(pl) + trTime, pl);
/*      */         }
/* 3916 */         if (renderJFC.getStateChange(pl) >= 200) {
/* 3917 */           renderJFC.setStateChange(200, pl);
/* 3918 */           renderJFC.setState(state, pl);
/*      */         } 
/* 3920 */       } else if (renderJFC.getState(pl) >= 1 && state == 0) {
/* 3921 */         if ((renderJFC.getState(pl) != state || rg == 0) && renderJFC.getStateChange(pl) > 0) {
/* 3922 */           renderJFC.setStateChange(renderJFC.getStateChange(pl) - trTime, pl);
/*      */         }
/* 3924 */         if (renderJFC.getStateChange(pl) <= 0) {
/* 3925 */           renderJFC.setStateChange(0, pl);
/* 3926 */           renderJFC.setState(state, pl);
/*      */         } 
/* 3928 */       } else if (renderJFC.getState(pl) != state && (renderJFC.getState(pl) == 1 || renderJFC.getState(pl) == 4) && state == 2) {
/* 3929 */         renderJFC.setState(state, pl);
/* 3930 */       } else if (renderJFC.getState(pl) == 0) {
/* 3931 */         if (!detail && renderJFC.getState(pl) == state && rg > 90) {
/* 3932 */           renderJFC.setStateChange(renderJFC.getStateChange(pl) + trTime, pl); if (renderJFC.getStateChange(pl) > 200) renderJFC.setStateChange(200, pl); 
/* 3933 */         } else if (detail && renderJFC.getState(pl) == state && rg > 0 && renderJFC.getStateChange(pl) < rg * 2) {
/* 3934 */           renderJFC.setStateChange(renderJFC.getStateChange(pl) + trTime, pl);
/* 3935 */         } else if (renderJFC.getState(pl) == state) {
/* 3936 */           if (renderJFC.getStateChange(pl) > 0) { renderJFC.setStateChange(renderJFC.getStateChange(pl) - trTime, pl); }
/* 3937 */           else { renderJFC.setStateChange(0, pl); }
/* 3938 */            if (renderJFC.getState2Change(pl) > 0) { renderJFC.setState2Change(renderJFC.getState2Change(pl) - trTime, pl); }
/* 3939 */           else { renderJFC.setState2Change(0, pl); } 
/*      */         } 
/* 3941 */       } else if ((state == 4 && pstrty) || state == 2) {
/* 3942 */         if (!detail && renderJFC.getState(pl) == state && rg > 90)
/* 3943 */         { renderJFC.setState2Change(renderJFC.getState2Change(pl) + trTime, pl); if (renderJFC.getState2Change(pl) > 200) renderJFC.setState2Change(200, pl);  }
/* 3944 */         else if (detail && renderJFC.getState(pl) == state && rg > 0 && renderJFC.getState2Change(pl) < rg * 2)
/* 3945 */         { renderJFC.setState2Change(renderJFC.getState2Change(pl) + trTime, pl); }
/* 3946 */         else if (renderJFC.getState2Change(pl) > 200)
/* 3947 */         { renderJFC.setState2Change(200, pl);
/* 3948 */           renderJFC.setState(state, pl); }
/* 3949 */         else if (renderJFC.getState2Change(pl) > 0) { renderJFC.setState2Change(renderJFC.getState2Change(pl) - trTime, pl); }
/* 3950 */         else if (renderJFC.getState2Change(pl) != 0) { renderJFC.setState2Change(0, pl); } 
/* 3951 */       } else if (renderJFC.getState(pl) != state && (state == 5 || state == 3)) {
/* 3952 */         if (renderJFC.getState2Change(pl) < 200) {
/* 3953 */           renderJFC.setState2Change(renderJFC.getState2Change(pl) + trTime, pl);
/*      */         }
/* 3955 */         if (renderJFC.getState2Change(pl) >= 200) {
/* 3956 */           renderJFC.setState2Change(200, pl);
/* 3957 */           renderJFC.setState(state, pl);
/*      */         } 
/*      */       } 
/*      */     }
/*      */     
/* 3962 */     if ((aura || trty || kken || trbo) && detail) {
/* 3963 */       if (renderJFC.getState(pl) == state && renderJFC.getAuratime(pl) < 50) {
/* 3964 */         if (renderJFC.getAuratime(pl) < 50 && renderJFC.getAuratype(pl) == 0) {
/* 3965 */           renderJFC.setAuratime(renderJFC.getAuratime(pl) + arTime, pl);
/*      */         }
/* 3967 */         if (renderJFC.getAuratime(pl) >= 50) {
/* 3968 */           renderJFC.setAuratype(1, pl);
/*      */         }
/* 3970 */         if (renderJFC.getAuratime(pl) < 20 && renderJFC.getAuratype(pl) == 1) {
/* 3971 */           renderJFC.setAuratype(0, pl);
/*      */         }
/* 3973 */         if (renderJFC.getAuratime(pl) > 0 && renderJFC.getAuratype(pl) == 1) {
/* 3974 */           renderJFC.setAuratime(renderJFC.getAuratime(pl) - arTime, pl);
/*      */         }
/* 3976 */       } else if (renderJFC.getState(pl) == state && state >= 1) {
/* 3977 */         if (renderJFC.getAuratype(pl) < 2) {
/* 3978 */           renderJFC.setAuratype(2, pl);
/*      */         }
/* 3980 */         if (renderJFC.getBendtime(pl) < 50 && renderJFC.getAuratype(pl) == 2) {
/* 3981 */           renderJFC.setBendtime(renderJFC.getBendtime(pl) + arTime, pl);
/*      */         }
/* 3983 */         if (renderJFC.getBendtime(pl) >= 50) {
/* 3984 */           renderJFC.setAuratype(3, pl);
/*      */         }
/* 3986 */         if (renderJFC.getBendtime(pl) < 20 && renderJFC.getAuratype(pl) == 3) {
/* 3987 */           renderJFC.setAuratype(2, pl);
/*      */         }
/* 3989 */         if (renderJFC.getBendtime(pl) > 0 && renderJFC.getAuratype(pl) == 3) {
/* 3990 */           renderJFC.setBendtime(renderJFC.getBendtime(pl) - arTime, pl);
/*      */         }
/*      */       } 
/*      */     } else {
/*      */       
/* 3995 */       if (renderJFC.getAuratype(pl) > 0) {
/* 3996 */         renderJFC.setAuratype(0, pl);
/*      */       }
/* 3998 */       if (renderJFC.getBendtime(pl) > 0) {
/* 3999 */         renderJFC.setBendtime(renderJFC.getBendtime(pl) - 1, pl);
/*      */       }
/* 4001 */       if (renderJFC.getAuratime(pl) > 0) {
/* 4002 */         renderJFC.setAuratime(renderJFC.getAuratime(pl) - 1, pl);
/*      */       }
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 4008 */     GL11.glPushMatrix();
/* 4009 */     GL11.glScalef((0.5F + 0.5F / ModelBipedJFC.f) * ((g <= 1) ? 1.0F : 0.85F), 0.5F + 0.5F / ModelBipedJFC.f, (0.5F + 0.5F / ModelBipedJFC.f) * ((g <= 1) ? 1.0F : 0.85F));
/* 4010 */     GL11.glTranslatef(0.0F, (ModelBipedJFC.f - 1.0F) / ModelBipedJFC.f * (2.0F - ((ModelBipedJFC.f >= 1.5F && ModelBipedJFC.f <= 2.0F) ? ((2.0F - ModelBipedJFC.f) / 2.5F) : ((ModelBipedJFC.f < 1.5F && ModelBipedJFC.f >= 1.0F) ? ((ModelBipedJFC.f * 2.0F - 2.0F) * 0.2F) : 0.0F))), 0.0F);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 4019 */     float[] front = { 0.6F, 0.5F, 0.4F, -0.5F };
/* 4020 */     float[] front2 = { 0.0F, 0.0F, 0.0F, 0.0F };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 4030 */     int[] hairRightPosZ = { 3, 2, 1, 0, 3, 2, 1, 3, 2, 3 };
/* 4031 */     int[] hairRightPosY = { 0, 0, 0, 0, 1, 1, 1, 2, 2, 3 };
/* 4032 */     int[] hairLeftPosZ = { 0, 1, 2, 3, 1, 2, 3, 2, 3, 3 };
/* 4033 */     int[] hairLeftPosY = { 0, 0, 0, 0, 1, 1, 1, 2, 2, 3 };
/* 4034 */     int[] hairBackPosX = { 0, 1, 2, 3, 0, 1, 2, 3, 0, 1, 2, 3, 0, 1, 2, 3 };
/* 4035 */     int[] hairBackPosY = { 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3 };
/* 4036 */     int[] hairTopPosX = { 0, 1, 2, 3, 0, 1, 2, 3, 0, 1, 2, 3, 0, 1, 2, 3 };
/* 4037 */     int[] hairTopPosZ = { 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3 };
/* 4038 */     int[] hairPos = { 0, 4, 14, 24, 40, 56 };
/*      */     
/* 4040 */     String hairdns = hair;
/*      */ 
/*      */ 
/*      */     
/* 4044 */     for (int face = 0; face < 56; face++) {
/*      */       
/* 4046 */       int l = dnsHair2(hairdns, face * 14);
/* 4047 */       if (l != 0) {
/* 4048 */         int X = dnsHair2(hairdns, face * 14 + 2);
/* 4049 */         int Y = dnsHair2(hairdns, face * 14 + 4);
/* 4050 */         int Z = dnsHair2(hairdns, face * 14 + 6);
/* 4051 */         int B = dnsHair2(hairdns, face * 14 + 8);
/* 4052 */         int P = dnsHair2(hairdns, face * 14 + 10);
/* 4053 */         int T = dnsHair2(hairdns, face * 14 + 12);
/* 4054 */         X = (X > 82) ? 82 : ((X < 18) ? 18 : X);
/* 4055 */         Y = (Y > 82) ? 82 : ((Y < 18) ? 18 : Y);
/* 4056 */         Z = (Z > 82) ? 82 : ((Z < 18) ? 18 : Z);
/* 4057 */         B = (B > 82) ? 82 : ((B < 18) ? 18 : B);
/* 4058 */         P = (P > 82) ? 82 : ((P < 18) ? 18 : P);
/* 4059 */         T = (T > 82) ? 82 : ((T < 18) ? 18 : T);
/* 4060 */         float x = (X - 50) * 0.1F;
/* 4061 */         float y = (Y - 50) * 0.1F;
/* 4062 */         float z = (Z - 50) * 0.1F;
/* 4063 */         float b = (B - 50) * 0.1F;
/* 4064 */         float p = (P - 50) * 0.1F;
/* 4065 */         int t = (int)((T - 18) * 1.62F);
/* 4066 */         float Int = t * 0.01F;
/*      */ 
/*      */         
/* 4069 */         float pb = b;
/*      */ 
/*      */ 
/*      */         
/* 4073 */         boolean hpFront = (face >= hairPos[0] && face < hairPos[1]);
/* 4074 */         boolean hpTop = (face >= hairPos[4] && face < hairPos[5]);
/* 4075 */         boolean hpRight = (face >= hairPos[1] && face < hairPos[2]);
/* 4076 */         boolean hpLeft = (face >= hairPos[2] && face < hairPos[3]);
/* 4077 */         boolean hpBack = (face >= hairPos[3] && face < hairPos[4]);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 4084 */         if (renderJFC.getStateChange(pl) > 0 && l > 0) {
/*      */           
/* 4086 */           if (y > -1.0F && y < 1.0F && z > -1.0F && z < 1.0F && hpBack) {
/* 4087 */             x += renderJFC.getStateChange(pl) * Int * ((x < 0.0F) ? -0.01F : 0.01F) * l * 0.01F;
/* 4088 */             x = (x > 3.0F) ? 3.0F : x;
/* 4089 */             x = (x < -3.0F) ? -3.0F : x;
/*      */           } 
/* 4091 */           if (y > -1.0F && y < 1.0F && x > -1.0F && x < 1.0F && !hpBack) {
/*      */ 
/*      */ 
/*      */             
/* 4095 */             z += renderJFC.getStateChange(pl) * Int * ((z < 0.0F) ? -0.01F : 0.01F);
/* 4096 */             z = (z > 3.2F) ? 3.2F : z;
/* 4097 */             z = (z < -3.2F) ? -3.2F : z;
/*      */ 
/*      */ 
/*      */ 
/*      */             
/* 4102 */             if (!hpFront || x < 0.0F) {
/*      */ 
/*      */               
/* 4105 */               x += renderJFC.getStateChange(pl) * Int * 0.01F;
/* 4106 */               x = (x > 0.4F) ? 0.4F : x;
/* 4107 */               x = (x < -0.4F) ? -0.4F : x;
/*      */             } 
/*      */ 
/*      */             
/* 4111 */             if (z > 0.0F)
/*      */             {
/*      */               
/* 4114 */               boolean add = hpTop ? ((hairTopPosZ[face - hairPos[4]] == 0 || hairTopPosZ[face - hairPos[4]] == 2)) : false;
/* 4115 */               boolean add2 = hpTop ? ((face % 4 == 0 || face % 4 == 3)) : false;
/* 4116 */               b += renderJFC.getStateChange(pl) * Int * -0.02F;
/*      */ 
/*      */               
/* 4119 */               b = (b < ((add && add2) ? 0.0F : -0.2F)) ? ((add && add2) ? 0.0F : -0.2F) : b;
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             }
/* 4125 */             else if (z < 0.0F)
/*      */             {
/*      */               
/* 4128 */               boolean add = hpTop ? ((hairTopPosZ[face - hairPos[4]] == 0 || hairTopPosZ[face - hairPos[4]] == 2)) : false;
/* 4129 */               boolean add2 = hpTop ? ((face % 4 == 0 || face % 4 == 3)) : false;
/* 4130 */               b += renderJFC.getStateChange(pl) * Int * 0.02F;
/*      */ 
/*      */               
/* 4133 */               b = (b > ((add && add2) ? 0.0F : 0.2F)) ? ((add && add2) ? 0.0F : 0.2F) : b;
/*      */             
/*      */             }
/*      */ 
/*      */           
/*      */           }
/* 4139 */           else if (y > -1.0F && y < 1.0F) {
/* 4140 */             x += renderJFC.getStateChange(pl) * Int * ((x < 0.0F) ? -0.01F : 0.01F);
/* 4141 */             x = (x > 2.8F) ? 2.8F : x;
/* 4142 */             x = (x < -2.8F) ? -2.8F : x;
/* 4143 */             if (b > 1.5F) {
/* 4144 */               x = (x > 1.5F) ? 1.5F : x;
/* 4145 */               x = (x < -1.5F) ? -1.5F : x;
/* 4146 */               b += renderJFC.getStateChange(pl) * Int * ((b < 0.0F) ? 0.03F : -0.03F);
/* 4147 */               b = (b > 2.8F) ? 2.8F : b;
/* 4148 */               b = (b < -2.8F) ? -2.8F : b;
/*      */             }
/*      */           
/*      */           }
/* 4152 */           else if (x > -1.0F && x < 1.0F) {
/* 4153 */             z += renderJFC.getStateChange(pl) * Int * ((z < 0.0F) ? -0.01F : 0.01F);
/* 4154 */             z = (z > 2.8F) ? 2.8F : z;
/* 4155 */             z = (z < -2.8F) ? -2.8F : z;
/* 4156 */             if (b > 0.0F && z > 0.0F && y < 1.6F) {
/* 4157 */               z = (z > 2.2F) ? 2.2F : z;
/* 4158 */               z = (z < -2.2F) ? -2.2F : z;
/* 4159 */               b += renderJFC.getStateChange(pl) * Int * -0.02F;
/* 4160 */               b = (b > pb) ? pb : b;
/* 4161 */               b = (b < -pb) ? -pb : b;
/*      */             }
/* 4163 */             else if (b > 0.0F && z < 0.0F && y > 0.0F) {
/* 4164 */               z = (z > 2.2F) ? 2.2F : z;
/* 4165 */               z = (z < -2.2F) ? -2.2F : z;
/* 4166 */               b += renderJFC.getStateChange(pl) * Int * -0.02F;
/* 4167 */               b = (b > pb) ? pb : b;
/* 4168 */               b = (b < -pb) ? -pb : b;
/*      */             }
/* 4170 */             else if (y < -1.3F && b > 0.0F) {
/* 4171 */               z = (z > 2.2F) ? 2.2F : z;
/* 4172 */               z = (z < -2.2F) ? -2.2F : z;
/* 4173 */               b += renderJFC.getStateChange(pl) * Int * -0.02F;
/* 4174 */               b = (b < 0.5F) ? 0.5F : b;
/*      */             } 
/*      */           } 
/*      */         } 
/*      */         
/* 4179 */         if (renderJFC.getState2Change(pl) > 0) {
/* 4180 */           if (y > -1.0F && y < 1.0F && x > -1.0F && x < 1.0F && hpFront) {
/*      */             
/* 4182 */             float Int2 = (Int > 0.02F) ? 0.6F : Int;
/* 4183 */             x += renderJFC.getState2Change(pl) * Int2 * 0.01F;
/* 4184 */             x = (x > 0.2F) ? 0.2F : x;
/* 4185 */             x = (x < -0.2F) ? -0.2F : x;
/* 4186 */             z += renderJFC.getState2Change(pl) * Int2 * ((z < 0.0F) ? -0.02F : 0.02F);
/* 4187 */             z = (z > 2.8F) ? 2.8F : z;
/* 4188 */             z = (z < -2.8F) ? -2.8F : z;
/*      */           } 
/*      */ 
/*      */           
/* 4192 */           l = (int)(l + renderJFC.getState2Change(pl) * 0.1F);
/* 4193 */           if (b < 0.0F) {
/* 4194 */             b += renderJFC.getState2Change(pl) * 5.0E-4F;
/* 4195 */             b = (b >= 0.0F) ? 0.2F : b;
/*      */           } 
/* 4197 */           if (b > 0.0F) {
/* 4198 */             b += renderJFC.getState2Change(pl) * -5.0E-4F;
/* 4199 */             b = (b <= 0.0F) ? -0.2F : b;
/*      */           } 
/*      */         } 
/* 4202 */         if (renderJFC.getBendtime(pl) > 0) {
/* 4203 */           z += renderJFC.getBendtime(pl) * ((z < 0.0F) ? -0.0025F : 0.0025F);
/* 4204 */           b += renderJFC.getBendtime(pl) * ((b > 0.0F) ? -0.005F : 0.005F);
/* 4205 */           z = (z > 3.2F) ? 3.2F : z;
/* 4206 */           z = (z < -3.2F) ? -3.2F : z;
/*      */         } 
/* 4208 */         if (renderJFC.getAuratime(pl) > 0) {
/* 4209 */           z += renderJFC.getAuratime(pl) * ((z < 0.0F) ? -0.0025F : 0.0025F);
/* 4210 */           b += renderJFC.getAuratime(pl) * ((b > 0.0F) ? -0.005F : 0.005F);
/* 4211 */           z = (z > 3.2F) ? 3.2F : z;
/* 4212 */           z = (z < -3.2F) ? -3.2F : z;
/*      */         } 
/*      */ 
/*      */ 
/*      */         
/* 4217 */         int lng = 0;
/* 4218 */         setRotation(this.hairall[lng + face * 4], x, y, z);
/* 4219 */         (this.hairall[lng + face * 4]).rotationPointX = -2.999F + ((face < 4) ? (face * 2) : ((face >= 14 && face < 24) ? 7 : ((face >= 24 && face < 40) ? (hairBackPosX[face - 4 - 10 - 10] * 2) : ((face >= 40 && face < 56) ? (hairTopPosX[face - 4 - 10 - 10 - 16] * 2) : -1))));
/*      */ 
/*      */         
/* 4222 */         (this.hairall[lng + face * 4]).rotationPointZ = -3.999F + ((face >= 4 && face < 14) ? (hairRightPosZ[face - 4] * 2 + 1) : ((face >= 14 && face < 24) ? (hairLeftPosZ[face - 4 - 10] * 2 + 1) : ((face >= 24 && face < 40) ? 8.0F : ((face >= 40 && face < 56) ? ((hairTopPosZ[face - 4 - 10 - 10 - 16] * 2) + 0.9F) : 0.0F))));
/*      */ 
/*      */         
/* 4225 */         (this.hairall[lng + face * 4]).rotationPointY = -7.0F + ((face >= 4 && face < 14) ? (hairRightPosY[face - 4] * 2) : ((face >= 14 && face < 24) ? (hairLeftPosY[face - 4 - 10] * 2) : ((face >= 24 && face < 40) ? (hairBackPosY[face - 4 - 10 - 10] * 2) : -0.5F)));
/*      */ 
/*      */         
/* 4228 */         float f = 1.57F;
/* 4229 */         float r = MathHelper.func_76126_a(rot3 * 0.02F) * 0.1F;
/* 4230 */         float r2 = MathHelper.func_76134_b(rot3 * 0.02F) * 0.1F;
/* 4231 */         float r3 = MathHelper.func_76134_b(rot3 * 0.14F) * 0.1F;
/* 4232 */         (this.hairall[1 + face * 4]).rotateAngleY = 0.0F;
/*      */         
/* 4234 */         (this.hairall[1 + face * 4]).rotateAngleX = -0.0F;
/* 4235 */         (this.hairall[2 + face * 4]).rotateAngleY = 0.0F;
/*      */         
/* 4237 */         (this.hairall[2 + face * 4]).rotateAngleX = 0.0F;
/* 4238 */         (this.hairall[3 + face * 4]).rotateAngleY = 0.0F;
/*      */         
/* 4240 */         (this.hairall[3 + face * 4]).rotateAngleX = 0.0F;
/*      */         
/* 4242 */         if (hpTop || hpRight || hpLeft) {
/* 4243 */           int min = hpLeft ? 1 : -1;
/* 4244 */           (this.hairall[1 + face * 4]).rotateAngleZ = min * b * 0.3F * ((p > 0.5F) ? (1.0F - p * 0.3F) : ((p < -0.5F) ? (1.0F + -p * 0.1F) : 1.0F));
/* 4245 */           (this.hairall[2 + face * 4]).rotateAngleZ = min * b * 0.3F;
/* 4246 */           (this.hairall[3 + face * 4]).rotateAngleZ = min * b * 0.3F * ((p > 0.5F) ? (1.0F + p * 0.1F) : ((p < -0.5F) ? (1.0F - -p * 0.3F) : 1.0F));
/*      */         } else {
/*      */           
/* 4249 */           (this.hairall[1 + face * 4]).rotateAngleX = b * 0.3F * ((p > 0.5F) ? (1.0F - p * 0.3F) : ((p < -0.5F) ? (1.0F + -p * 0.1F) : 1.0F));
/* 4250 */           (this.hairall[2 + face * 4]).rotateAngleX = b * 0.3F;
/* 4251 */           (this.hairall[3 + face * 4]).rotateAngleX = b * 0.3F * ((p > 0.5F) ? (1.0F + p * 0.1F) : ((p < -0.5F) ? (1.0F - -p * 0.3F) : 1.0F));
/*      */         } 
/*      */ 
/*      */         
/* 4255 */         (this.hairall[1 + face * 4]).rotationPointX = 0.0F;
/* 4256 */         (this.hairall[1 + face * 4]).rotationPointZ = 0.0F;
/* 4257 */         (this.hairall[1 + face * 4]).rotationPointY = 1.5F;
/* 4258 */         (this.hairall[2 + face * 4]).rotationPointX = 0.0F;
/* 4259 */         (this.hairall[2 + face * 4]).rotationPointZ = 0.0F;
/* 4260 */         (this.hairall[2 + face * 4]).rotationPointY = 2.5F;
/* 4261 */         (this.hairall[3 + face * 4]).rotationPointX = 0.0F;
/* 4262 */         (this.hairall[3 + face * 4]).rotationPointZ = 0.0F;
/* 4263 */         (this.hairall[3 + face * 4]).rotationPointY = 2.5F;
/*      */         
/* 4265 */         GL11.glPushMatrix();
/* 4266 */         GL11.glTranslatef(this.field_78116_c.field_78800_c * par1, this.field_78116_c.field_78797_d * par1, this.field_78116_c.field_78798_e * par1);
/* 4267 */         if (this.field_78116_c.field_78808_h != 0.0F) {
/* 4268 */           GL11.glRotatef(this.field_78116_c.field_78808_h * 57.295776F, 0.0F, 0.0F, 1.0F);
/*      */         }
/* 4270 */         if (this.field_78116_c.field_78796_g != 0.0F) {
/* 4271 */           GL11.glRotatef(this.field_78116_c.field_78796_g * 57.295776F, 0.0F, 1.0F, 0.0F);
/*      */         }
/* 4273 */         if (this.field_78116_c.field_78795_f != 0.0F) {
/* 4274 */           GL11.glRotatef(this.field_78116_c.field_78795_f * 57.295776F, 1.0F, 0.0F, 0.0F);
/*      */         }
/* 4276 */         GL11.glPushMatrix();
/*      */         
/* 4278 */         float[] TypL1 = { 4.0F, 2.0F, 1.5F, 1.0F, 1.0F };
/* 4279 */         boolean[] TypS1 = { false, true, true, true, true };
/* 4280 */         boolean[] TypS2 = { false, false, true, true, true };
/* 4281 */         boolean[] TypS3 = { false, false, false, true, true };
/*      */         
/* 4283 */         float tincs1 = (l < 33.0F) ? (l / 33.0F) : 1.0F;
/* 4284 */         float tincs2 = (l > 33.0F && l < 66.0F) ? ((l - 33.0F) / 33.0F) : ((l < 33.0F) ? 0.0F : 1.0F);
/* 4285 */         float tincs3 = (l > 66.0F) ? ((l - 66.0F) / 33.0F) : ((l < 66.0F) ? 0.0F : 1.0F);
/* 4286 */         (this.hairall[lng + face * 4]).lengthY = 1.0F;
/* 4287 */         (this.hairall[1 + face * 4]).lengthY = tincs1;
/* 4288 */         (this.hairall[2 + face * 4]).lengthY = tincs2;
/* 4289 */         (this.hairall[3 + face * 4]).lengthY = tincs3;
/* 4290 */         (this.hairall[0 + face * 4]).sizeXZ = 1.1F;
/* 4291 */         (this.hairall[1 + face * 4]).sizeXZ = 1.0F;
/* 4292 */         (this.hairall[2 + face * 4]).sizeXZ = 0.9F;
/* 4293 */         (this.hairall[3 + face * 4]).sizeXZ = 0.8F;
/* 4294 */         (this.hairall[1 + face * 4]).showModel = (l > 0.0F);
/* 4295 */         (this.hairall[2 + face * 4]).showModel = (l > 33.0F);
/* 4296 */         (this.hairall[3 + face * 4]).showModel = (l > 66.0F);
/* 4297 */         this.hairall[lng + face * 4].render(par1);
/* 4298 */         GL11.glPopMatrix();
/* 4299 */         GL11.glPopMatrix();
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 4305 */     GL11.glScalef(1.0F, 1.0F, 1.0F);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 4322 */     GL11.glPopMatrix();
/*      */   }
/*      */   
/*      */   public static boolean detail = false;
/*      */   
/*      */   public void renderHairs(float par1, String hair) {
/* 4328 */     float f6 = ModelBipedJFC.f;
/*      */     
/* 4330 */     GL11.glPushMatrix();
/* 4331 */     GL11.glScalef(1.0F / f6 * ((g <= 1) ? 1.0F : 0.7F), 1.0F / f6, 1.0F / f6 * ((g <= 1) ? 1.0F : 0.7F));
/* 4332 */     GL11.glTranslatef(0.0F, (f6 - 1.0F) * 1.5F, 0.0F);
/* 4333 */     if (hair.contains("FR") && 
/* 4334 */       hair.contains("2")) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 4341 */       this.leftarmshoulder.field_78798_e = this.LA.field_78798_e;
/* 4342 */       this.leftarmshoulder.field_78797_d = this.LA.field_78797_d;
/* 4343 */       this.leftarmshoulder.field_78800_c = this.LA.field_78800_c;
/* 4344 */       this.leftarmshoulder.field_78796_g = this.LA.field_78796_g;
/* 4345 */       this.leftarmshoulder.field_78795_f = this.LA.field_78795_f;
/* 4346 */       this.leftarmshoulder.field_78808_h = this.LA.field_78808_h;
/* 4347 */       this.leftarmshoulder.func_78785_a(par1);
/* 4348 */       this.rightarmshoulder.field_78798_e = this.RA.field_78798_e;
/* 4349 */       this.rightarmshoulder.field_78797_d = this.RA.field_78797_d;
/* 4350 */       this.rightarmshoulder.field_78800_c = this.RA.field_78800_c;
/* 4351 */       this.rightarmshoulder.field_78796_g = this.RA.field_78796_g;
/* 4352 */       this.rightarmshoulder.field_78795_f = this.RA.field_78795_f;
/* 4353 */       this.rightarmshoulder.field_78808_h = this.RA.field_78808_h;
/* 4354 */       this.rightarmshoulder.func_78785_a(par1);
/*      */     } 
/*      */     
/* 4357 */     GL11.glPopMatrix();
/* 4358 */     GL11.glPushMatrix();
/* 4359 */     GL11.glScalef(1.0F / f6 * ((g <= 1) ? 1.0F : 0.7F), 1.0F / f6, 1.0F / f6 * ((g <= 1) ? 1.0F : 0.7F));
/* 4360 */     GL11.glTranslatef(0.0F, (f6 - 1.0F) * 1.5F, 0.0F);
/*      */     
/* 4362 */     if (hair.contains("FR")) {
/* 4363 */       if (!hair.contains("nFR")) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 4371 */         GL11.glPushMatrix();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 4387 */         transRot(par1, this.B1);
/* 4388 */         GL11.glScalef(1.0F, 1.0F, 1.0F);
/* 4389 */         this.FroB.func_78785_a(par1);
/*      */         
/* 4391 */         float f = 1.57F;
/* 4392 */         float r = MathHelper.func_76126_a(rot3 * 0.02F) * 0.1F;
/* 4393 */         float r2 = MathHelper.func_76134_b(rot3 * 0.02F) * 0.1F;
/* 4394 */         float r3 = MathHelper.func_76134_b(rot3 * 0.14F) * 0.1F;
/* 4395 */         this.ftailS1.field_78796_g = 0.2F;
/* 4396 */         if (detail)
/* 4397 */           this.ftailS1.field_78796_g += MathHelper.func_76134_b(rot3 * 0.09F) * 0.2F - 0.2F + r; 
/* 4398 */         this.ftailS1.field_78795_f = -0.3F;
/*      */         
/* 4400 */         this.ftailS2.field_78796_g = 0.2F;
/* 4401 */         if (detail)
/* 4402 */           this.ftailS2.field_78796_g += MathHelper.func_76134_b(rot3 * 0.09F) * 0.2F - 0.2F + r2 + r3; 
/* 4403 */         this.ftailS2.field_78795_f = 0.4F;
/*      */         
/* 4405 */         this.ftailS3.field_78796_g = 0.1F;
/* 4406 */         if (detail)
/* 4407 */           this.ftailS3.field_78796_g += MathHelper.func_76134_b(rot3 * 0.09F) * 0.1F - 0.1F + r + r3; 
/* 4408 */         this.ftailS3.field_78795_f = 0.6F;
/* 4409 */         if (detail)
/* 4410 */           this.ftailS3.field_78795_f += MathHelper.func_76126_a(rot3 * 0.09F) * 0.4F + 0.3F; 
/* 4411 */         this.ftailS4.field_78796_g = 0.1F;
/* 4412 */         if (detail)
/* 4413 */           this.ftailS4.field_78796_g += MathHelper.func_76134_b(rot3 * 0.09F) * 0.4F - 0.1F + r2; 
/* 4414 */         this.ftailS4.field_78795_f = 0.3F;
/* 4415 */         if (detail)
/* 4416 */           this.ftailS4.field_78795_f += MathHelper.func_76126_a(rot3 * 0.09F) * 0.1F - 0.2F; 
/* 4417 */         this.ftailS5.field_78796_g = 0.2F;
/* 4418 */         if (detail)
/* 4419 */           this.ftailS5.field_78796_g += MathHelper.func_76134_b(rot3 * 0.09F) * 0.4F - 0.2F + r + r3; 
/* 4420 */         this.ftailS5.field_78795_f = -0.2F;
/* 4421 */         if (detail)
/* 4422 */           this.ftailS5.field_78795_f += MathHelper.func_76126_a(rot3 * 0.09F) * 0.1F - 0.3F; 
/* 4423 */         this.ftailS6.field_78796_g = 0.2F;
/* 4424 */         if (detail)
/* 4425 */           this.ftailS6.field_78796_g += MathHelper.func_76134_b(rot3 * 0.09F) * 0.4F - 0.2F + r2 + r3; 
/* 4426 */         this.ftailS6.field_78795_f = -0.4F;
/* 4427 */         if (detail)
/* 4428 */           this.ftailS6.field_78795_f += MathHelper.func_76126_a(rot3 * 0.09F) * 0.4F - 0.4F; 
/* 4429 */         GL11.glPopMatrix();
/*      */       } 
/* 4431 */       if (hair.contains("4")) {
/* 4432 */         this.Fro5b.field_78796_g = this.B.field_78796_g;
/* 4433 */         this.Fro5b.field_78795_f = this.B.field_78795_f;
/* 4434 */         this.Fro5b.field_78800_c = this.B.field_78800_c;
/* 4435 */         this.Fro5b.field_78797_d = this.B.field_78797_d;
/* 4436 */         this.Fro5b.func_78785_a(par1);
/* 4437 */         this.Fro5r.field_78800_c = this.RA.field_78800_c;
/* 4438 */         this.Fro5r.field_78797_d = this.RA.field_78797_d;
/* 4439 */         this.Fro5r.field_78798_e = this.RA.field_78798_e;
/* 4440 */         this.Fro5r.field_78796_g = this.RA.field_78796_g;
/* 4441 */         this.Fro5r.field_78795_f = this.RA.field_78795_f;
/* 4442 */         this.Fro5r.field_78808_h = this.RA.field_78808_h;
/* 4443 */         this.Fro5r.func_78785_a(par1);
/* 4444 */         this.Fro5l.field_78800_c = this.LA.field_78800_c;
/* 4445 */         this.Fro5l.field_78797_d = this.LA.field_78797_d;
/* 4446 */         this.Fro5l.field_78798_e = this.LA.field_78798_e;
/* 4447 */         this.Fro5l.field_78796_g = this.LA.field_78796_g;
/* 4448 */         this.Fro5l.field_78795_f = this.LA.field_78795_f;
/* 4449 */         this.Fro5l.field_78808_h = this.LA.field_78808_h;
/* 4450 */         this.Fro5l.func_78785_a(par1);
/*      */       } 
/*      */     } 
/* 4453 */     if (hair.contains("SJT1")) {
/* 4454 */       GL11.glPushMatrix();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 4470 */       transRot(par1, this.B1);
/* 4471 */       GL11.glScalef(1.0F, 1.0F, 1.0F);
/* 4472 */       this.SaiT1.func_78785_a(par1);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 4479 */       float r = MathHelper.func_76126_a(rot3 * 0.02F) * 0.1F;
/* 4480 */       float r2 = MathHelper.func_76134_b(rot3 * 0.02F) * 0.1F;
/* 4481 */       float r3 = MathHelper.func_76134_b(rot3 * 0.14F) * 0.1F;
/* 4482 */       this.tail1.field_78796_g = 0.2F;
/* 4483 */       if (detail)
/* 4484 */         this.tail1.field_78796_g += MathHelper.func_76134_b(rot3 * 0.09F) * 0.2F - 0.2F + r; 
/* 4485 */       this.tail1.field_78795_f = -0.3F;
/*      */       
/* 4487 */       this.tail2.field_78796_g = 0.2F;
/* 4488 */       if (detail)
/* 4489 */         this.tail2.field_78796_g += MathHelper.func_76134_b(rot3 * 0.09F) * 0.2F - 0.2F + r2 + r3; 
/* 4490 */       this.tail2.field_78795_f = 0.4F;
/*      */       
/* 4492 */       this.tailS3.field_78796_g = 0.1F;
/* 4493 */       if (detail)
/* 4494 */         this.tailS3.field_78796_g += MathHelper.func_76134_b(rot3 * 0.09F) * 0.1F - 0.1F + r + r3; 
/* 4495 */       this.tailS3.field_78795_f = 0.6F;
/* 4496 */       if (detail)
/* 4497 */         this.tailS3.field_78795_f += MathHelper.func_76126_a(rot3 * 0.09F) * 0.4F + 0.3F; 
/* 4498 */       this.tailS4.field_78796_g = 0.1F;
/* 4499 */       if (detail)
/* 4500 */         this.tailS4.field_78796_g += MathHelper.func_76134_b(rot3 * 0.09F) * 0.4F - 0.1F + r2; 
/* 4501 */       this.tailS4.field_78795_f = 0.3F;
/* 4502 */       if (detail)
/* 4503 */         this.tailS4.field_78795_f += MathHelper.func_76126_a(rot3 * 0.09F) * 0.1F - 0.2F; 
/* 4504 */       this.tailS5.field_78796_g = 0.2F;
/* 4505 */       if (detail)
/* 4506 */         this.tailS5.field_78796_g += MathHelper.func_76134_b(rot3 * 0.09F) * 0.4F - 0.2F + r + r3; 
/* 4507 */       this.tailS5.field_78795_f = -0.2F;
/* 4508 */       if (detail)
/* 4509 */         this.tailS5.field_78795_f += MathHelper.func_76126_a(rot3 * 0.09F) * 0.1F - 0.3F; 
/* 4510 */       this.tailS6.field_78796_g = 0.2F;
/* 4511 */       if (detail)
/* 4512 */         this.tailS6.field_78796_g += MathHelper.func_76134_b(rot3 * 0.09F) * 0.4F - 0.2F + r2 + r3; 
/* 4513 */       this.tailS6.field_78795_f = -0.4F;
/* 4514 */       if (detail) {
/* 4515 */         this.tailS6.field_78795_f += MathHelper.func_76126_a(rot3 * 0.09F) * 0.4F - 0.4F;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 4614 */       GL11.glPopMatrix();
/*      */     } 
/* 4616 */     if (hair.contains("SJT2")) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 4648 */       transRot(par1, this.B1);
/* 4649 */       this.SaiT2.field_78796_g = this.B1.field_78796_g;
/* 4650 */       this.SaiT2.func_78785_a(par1);
/*      */     } 
/* 4652 */     GL11.glPopMatrix();
/*      */     
/* 4654 */     GL11.glPushMatrix();
/* 4655 */     GL11.glScalef((0.5F + 0.5F / f6) * ((g <= 1) ? 1.0F : 0.85F), 0.5F + 0.5F / f6, (0.5F + 0.5F / f6) * ((g <= 1) ? 1.0F : 0.85F));
/* 4656 */     GL11.glTranslatef(0.0F, (f6 - 1.0F) / f6 * (2.0F - ((f6 >= 1.5F && f6 <= 2.0F) ? ((2.0F - f6) / 2.5F) : ((f6 < 1.5F && f6 >= 1.0F) ? ((f6 * 2.0F - 2.0F) * 0.2F) : 0.0F))), 0.0F);
/* 4657 */     if (hair.contains("FR")) {
/* 4658 */       this.Fro.field_78796_g = this.field_78116_c.field_78796_g;
/* 4659 */       this.Fro.field_78795_f = this.field_78116_c.field_78795_f;
/* 4660 */       this.Fro.field_78800_c = this.field_78116_c.field_78800_c;
/* 4661 */       this.Fro.field_78797_d = this.field_78116_c.field_78797_d;
/* 4662 */       this.Fro.func_78785_a(par1);
/*      */       
/* 4664 */       if (hair.contains("0") || hair.contains("2") || hair.contains("1")) {
/* 4665 */         this.Fro0.field_78796_g = this.field_78116_c.field_78796_g;
/* 4666 */         this.Fro0.field_78795_f = this.field_78116_c.field_78795_f;
/* 4667 */         this.Fro0.field_78800_c = this.field_78116_c.field_78800_c;
/* 4668 */         this.Fro0.field_78797_d = this.field_78116_c.field_78797_d;
/* 4669 */         this.Fro0.func_78785_a(par1);
/*      */       } 
/* 4671 */       if (hair.contains("1") || hair.contains("2")) {
/* 4672 */         this.Fro1.field_78796_g = this.field_78116_c.field_78796_g;
/* 4673 */         this.Fro1.field_78795_f = this.field_78116_c.field_78795_f;
/* 4674 */         this.Fro1.field_78800_c = this.field_78116_c.field_78800_c;
/* 4675 */         this.Fro1.field_78797_d = this.field_78116_c.field_78797_d;
/* 4676 */         this.Fro1.func_78785_a(par1);
/*      */       } 
/* 4678 */       if (hair.contains("2")) {
/* 4679 */         this.Fro2.field_78796_g = this.field_78116_c.field_78796_g;
/* 4680 */         this.Fro2.field_78795_f = this.field_78116_c.field_78795_f;
/* 4681 */         this.Fro2.field_78800_c = this.field_78116_c.field_78800_c;
/* 4682 */         this.Fro2.field_78797_d = this.field_78116_c.field_78797_d;
/* 4683 */         this.Fro2.func_78785_a(par1);
/*      */       } 
/* 4685 */       if (hair.contains("4")) {
/* 4686 */         this.Fro5.field_78796_g = this.field_78116_c.field_78796_g;
/* 4687 */         this.Fro5.field_78795_f = this.field_78116_c.field_78795_f;
/* 4688 */         this.Fro5.field_78800_c = this.field_78116_c.field_78800_c;
/* 4689 */         this.Fro5.field_78797_d = this.field_78116_c.field_78797_d;
/* 4690 */         this.Fro5.func_78785_a(par1);
/*      */       } 
/*      */     } 
/*      */     
/* 4694 */     if (hair.contains("N")) {
/* 4695 */       this.Nam.field_78796_g = this.field_78116_c.field_78796_g;
/* 4696 */       this.Nam.field_78795_f = this.field_78116_c.field_78795_f;
/* 4697 */       this.Nam.field_78800_c = this.field_78116_c.field_78800_c;
/* 4698 */       this.Nam.field_78797_d = this.field_78116_c.field_78797_d;
/* 4699 */       this.Nam.func_78785_a(par1);
/*      */     } 
/* 4701 */     if (hair.contains("SJE")) {
/* 4702 */       this.SaiE.field_78796_g = this.field_78116_c.field_78796_g;
/* 4703 */       this.SaiE.field_78795_f = this.field_78116_c.field_78795_f;
/* 4704 */       this.SaiE.field_78800_c = this.field_78116_c.field_78800_c;
/* 4705 */       this.SaiE.field_78797_d = this.field_78116_c.field_78797_d;
/* 4706 */       this.SaiE.func_78785_a(par1);
/*      */     } 
/* 4708 */     if (hair.contains("FACENOSE")) {
/* 4709 */       this.face1.field_78796_g = this.field_78116_c.field_78796_g;
/* 4710 */       this.face1.field_78795_f = this.field_78116_c.field_78795_f;
/* 4711 */       this.face1.field_78800_c = this.field_78116_c.field_78800_c;
/* 4712 */       this.face1.field_78797_d = this.field_78116_c.field_78797_d;
/* 4713 */       this.face1.func_78785_a(par1);
/*      */     } 
/* 4715 */     if (hair.contains("FACEMOUTH")) {
/* 4716 */       this.face2.field_78796_g = this.field_78116_c.field_78796_g;
/* 4717 */       this.face2.field_78795_f = this.field_78116_c.field_78795_f;
/* 4718 */       this.face2.field_78800_c = this.field_78116_c.field_78800_c;
/* 4719 */       this.face2.field_78797_d = this.field_78116_c.field_78797_d;
/* 4720 */       this.face2.func_78785_a(par1);
/*      */     } 
/* 4722 */     if (hair.contains("EYEBROW")) {
/* 4723 */       this.face6.field_78796_g = this.field_78116_c.field_78796_g;
/* 4724 */       this.face6.field_78795_f = this.field_78116_c.field_78795_f;
/* 4725 */       this.face6.field_78800_c = this.field_78116_c.field_78800_c;
/* 4726 */       this.face6.field_78797_d = this.field_78116_c.field_78797_d;
/* 4727 */       this.face6.func_78785_a(par1);
/*      */     } 
/* 4729 */     if (hair.contains("EYEBASE")) {
/* 4730 */       this.face5.field_78796_g = this.field_78116_c.field_78796_g;
/* 4731 */       this.face5.field_78795_f = this.field_78116_c.field_78795_f;
/* 4732 */       this.face5.field_78800_c = this.field_78116_c.field_78800_c;
/* 4733 */       this.face5.field_78797_d = this.field_78116_c.field_78797_d;
/* 4734 */       this.face5.func_78785_a(par1);
/*      */     } 
/* 4736 */     if (hair.contains("EYELEFT")) {
/* 4737 */       this.face3.field_78796_g = this.field_78116_c.field_78796_g;
/* 4738 */       this.face3.field_78795_f = this.field_78116_c.field_78795_f;
/* 4739 */       this.face3.field_78800_c = this.field_78116_c.field_78800_c;
/* 4740 */       this.face3.field_78797_d = this.field_78116_c.field_78797_d;
/* 4741 */       this.face3.func_78785_a(par1);
/*      */     } 
/* 4743 */     if (hair.contains("EYERIGHT")) {
/* 4744 */       this.face4.field_78796_g = this.field_78116_c.field_78796_g;
/* 4745 */       this.face4.field_78795_f = this.field_78116_c.field_78795_f;
/* 4746 */       this.face4.field_78800_c = this.field_78116_c.field_78800_c;
/* 4747 */       this.face4.field_78797_d = this.field_78116_c.field_78797_d;
/* 4748 */       this.face4.func_78785_a(par1);
/*      */     } 
/* 4750 */     if (hair.contains("A11") || hair.contains("B11") || hair.contains("C11") || hair.contains("D11"));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 4757 */     if (hair.contains("A01")) {
/* 4758 */       this.bipedHeadg.field_78796_g = this.field_78116_c.field_78796_g;
/* 4759 */       this.bipedHeadg.field_78795_f = this.field_78116_c.field_78795_f;
/* 4760 */       this.bipedHeadg.field_78800_c = this.field_78116_c.field_78800_c;
/* 4761 */       this.bipedHeadg.field_78797_d = this.field_78116_c.field_78797_d;
/* 4762 */       this.bipedHeadg.func_78785_a(par1);
/*      */     } 
/* 4764 */     if (hair.contains("A02")) {
/* 4765 */       this.bipedHeadt.field_78796_g = this.field_78116_c.field_78796_g;
/* 4766 */       this.bipedHeadt.field_78795_f = this.field_78116_c.field_78795_f;
/* 4767 */       this.bipedHeadt.field_78800_c = this.field_78116_c.field_78800_c;
/* 4768 */       this.bipedHeadt.field_78797_d = this.field_78116_c.field_78797_d;
/* 4769 */       this.bipedHeadt.func_78785_a(par1);
/*      */     } 
/* 4771 */     if (hair.contains("A03")) {
/* 4772 */       this.bipedHeadv.field_78796_g = this.field_78116_c.field_78796_g;
/* 4773 */       this.bipedHeadv.field_78795_f = this.field_78116_c.field_78795_f;
/* 4774 */       this.bipedHeadv.field_78800_c = this.field_78116_c.field_78800_c;
/* 4775 */       this.bipedHeadv.field_78797_d = this.field_78116_c.field_78797_d;
/* 4776 */       this.bipedHeadv.func_78785_a(par1);
/*      */     } 
/* 4778 */     if (hair.contains("A04")) {
/* 4779 */       this.bipedHeadgh.field_78796_g = this.field_78116_c.field_78796_g;
/* 4780 */       this.bipedHeadgh.field_78795_f = this.field_78116_c.field_78795_f;
/* 4781 */       this.bipedHeadgh.field_78800_c = this.field_78116_c.field_78800_c;
/* 4782 */       this.bipedHeadgh.field_78797_d = this.field_78116_c.field_78797_d;
/* 4783 */       this.bipedHeadgh.func_78785_a(par1);
/*      */     } 
/* 4785 */     if (hair.contains("A05")) {
/* 4786 */       this.bipedHeadg2.field_78796_g = this.field_78116_c.field_78796_g;
/* 4787 */       this.bipedHeadg2.field_78795_f = this.field_78116_c.field_78795_f;
/* 4788 */       this.bipedHeadg2.field_78800_c = this.field_78116_c.field_78800_c;
/* 4789 */       this.bipedHeadg2.field_78797_d = this.field_78116_c.field_78797_d;
/* 4790 */       this.bipedHeadg2.func_78785_a(par1);
/*      */     } 
/* 4792 */     if (hair.contains("A06") || hair.contains("B06") || hair.contains("C06")) {
/* 4793 */       this.bipedHeadght.field_78796_g = this.field_78116_c.field_78796_g;
/* 4794 */       this.bipedHeadght.field_78795_f = this.field_78116_c.field_78795_f;
/* 4795 */       this.bipedHeadght.field_78800_c = this.field_78116_c.field_78800_c;
/* 4796 */       this.bipedHeadght.field_78797_d = this.field_78116_c.field_78797_d;
/* 4797 */       this.bipedHeadght.func_78785_a(par1);
/*      */     } 
/* 4799 */     if (hair.contains("A07") || hair.contains("B07") || hair.contains("C07")) {
/* 4800 */       this.bipedHeadgt.field_78796_g = this.field_78116_c.field_78796_g;
/* 4801 */       this.bipedHeadgt.field_78795_f = this.field_78116_c.field_78795_f;
/* 4802 */       this.bipedHeadgt.field_78800_c = this.field_78116_c.field_78800_c;
/* 4803 */       this.bipedHeadgt.field_78797_d = this.field_78116_c.field_78797_d;
/* 4804 */       this.bipedHeadgt.func_78785_a(par1);
/*      */     } 
/* 4806 */     if (hair.contains("A08") || hair.contains("B08") || hair.contains("C08")) {
/* 4807 */       this.bipedHeadgtt.field_78796_g = this.field_78116_c.field_78796_g;
/* 4808 */       this.bipedHeadgtt.field_78795_f = this.field_78116_c.field_78795_f;
/* 4809 */       this.bipedHeadgtt.field_78800_c = this.field_78116_c.field_78800_c;
/* 4810 */       this.bipedHeadgtt.field_78797_d = this.field_78116_c.field_78797_d;
/* 4811 */       this.bipedHeadgtt.func_78785_a(par1);
/*      */     } 
/* 4813 */     if (hair.contains("A09")) {
/* 4814 */       this.bipedHeadc7.field_78796_g = this.field_78116_c.field_78796_g;
/* 4815 */       this.bipedHeadc7.field_78795_f = this.field_78116_c.field_78795_f;
/* 4816 */       this.bipedHeadc7.field_78800_c = this.field_78116_c.field_78800_c;
/* 4817 */       this.bipedHeadc7.field_78797_d = this.field_78116_c.field_78797_d;
/* 4818 */       this.bipedHeadc7.func_78785_a(par1);
/*      */     } 
/* 4820 */     if (hair.contains("A10")) {
/* 4821 */       this.bipedHeadc8.field_78796_g = this.field_78116_c.field_78796_g;
/* 4822 */       this.bipedHeadc8.field_78795_f = this.field_78116_c.field_78795_f;
/* 4823 */       this.bipedHeadc8.field_78800_c = this.field_78116_c.field_78800_c;
/* 4824 */       this.bipedHeadc8.field_78797_d = this.field_78116_c.field_78797_d;
/* 4825 */       this.bipedHeadc8.func_78785_a(par1);
/*      */     } 
/* 4827 */     if (hair.contains("12") || hair.contains("D")) {
/* 4828 */       this.bipedHeadrad.field_78796_g = this.field_78116_c.field_78796_g;
/* 4829 */       this.bipedHeadrad.field_78795_f = this.field_78116_c.field_78795_f;
/* 4830 */       this.bipedHeadrad.field_78800_c = this.field_78116_c.field_78800_c;
/* 4831 */       this.bipedHeadrad.field_78797_d = this.field_78116_c.field_78797_d;
/* 4832 */       this.bipedHeadrad.func_78785_a(par1);
/* 4833 */       this.bipedHeadradl.field_78796_g = this.field_78116_c.field_78796_g;
/* 4834 */       this.field_78116_c.field_78795_f /= 4.0F;
/* 4835 */       this.bipedHeadradl.field_78800_c = this.field_78116_c.field_78800_c;
/* 4836 */       this.bipedHeadradl.field_78797_d = this.field_78116_c.field_78797_d;
/* 4837 */       this.bipedHeadradl.func_78785_a(par1);
/* 4838 */       this.bipedHeadradl2.field_78796_g = this.field_78116_c.field_78796_g;
/* 4839 */       this.field_78116_c.field_78795_f /= 2.0F;
/* 4840 */       this.bipedHeadradl2.field_78800_c = this.field_78116_c.field_78800_c;
/* 4841 */       this.bipedHeadradl2.field_78797_d = this.field_78116_c.field_78797_d;
/* 4842 */       this.bipedHeadradl2.func_78785_a(par1);
/* 4843 */       this.bipedHeadradl2.field_78796_g = this.field_78116_c.field_78796_g;
/* 4844 */       this.field_78116_c.field_78795_f /= 1.2F;
/* 4845 */       this.bipedHeadradl2.field_78800_c = this.field_78116_c.field_78800_c;
/* 4846 */       this.bipedHeadradl2.field_78797_d = this.field_78116_c.field_78797_d;
/* 4847 */       this.bipedHeadradl2.func_78785_a(par1);
/* 4848 */       if (hair.contains("01") || hair.contains("02") || hair.contains("05")) {
/* 4849 */         this.bipedHeadssj3t.field_78796_g = this.field_78116_c.field_78796_g;
/* 4850 */         this.bipedHeadssj3t.field_78795_f = this.field_78116_c.field_78795_f;
/* 4851 */         this.bipedHeadssj3t.field_78800_c = this.field_78116_c.field_78800_c;
/* 4852 */         this.bipedHeadssj3t.field_78797_d = this.field_78116_c.field_78797_d;
/* 4853 */         this.bipedHeadssj3t.func_78785_a(par1);
/*      */       } 
/*      */     } 
/* 4856 */     if (hair.contains("B01") || hair.contains("B05")) {
/* 4857 */       this.bipedHeadsg.field_78796_g = this.field_78116_c.field_78796_g;
/* 4858 */       this.bipedHeadsg.field_78795_f = this.field_78116_c.field_78795_f;
/* 4859 */       this.bipedHeadsg.field_78800_c = this.field_78116_c.field_78800_c;
/* 4860 */       this.bipedHeadsg.field_78797_d = this.field_78116_c.field_78797_d;
/* 4861 */       this.bipedHeadsg.func_78785_a(par1);
/*      */     } 
/* 4863 */     if (hair.contains("B02") || hair.contains("B09") || hair.contains("B10")) {
/* 4864 */       this.bipedHeadst.field_78796_g = this.field_78116_c.field_78796_g;
/* 4865 */       this.bipedHeadst.field_78795_f = this.field_78116_c.field_78795_f;
/* 4866 */       this.bipedHeadst.field_78800_c = this.field_78116_c.field_78800_c;
/* 4867 */       this.bipedHeadst.field_78797_d = this.field_78116_c.field_78797_d;
/* 4868 */       this.bipedHeadst.func_78785_a(par1);
/*      */     } 
/* 4870 */     if (hair.contains("B03")) {
/* 4871 */       this.bipedHeadsv.field_78796_g = this.field_78116_c.field_78796_g;
/* 4872 */       this.bipedHeadsv.field_78795_f = this.field_78116_c.field_78795_f;
/* 4873 */       this.bipedHeadsv.field_78800_c = this.field_78116_c.field_78800_c;
/* 4874 */       this.bipedHeadsv.field_78797_d = this.field_78116_c.field_78797_d;
/* 4875 */       this.bipedHeadsv.func_78785_a(par1);
/*      */     } 
/* 4877 */     if (hair.contains("B04")) {
/* 4878 */       this.bipedHeadsgh.field_78796_g = this.field_78116_c.field_78796_g;
/* 4879 */       this.bipedHeadsgh.field_78795_f = this.field_78116_c.field_78795_f;
/* 4880 */       this.bipedHeadsgh.field_78800_c = this.field_78116_c.field_78800_c;
/* 4881 */       this.bipedHeadsgh.field_78797_d = this.field_78116_c.field_78797_d;
/* 4882 */       this.bipedHeadsgh.func_78785_a(par1);
/*      */     } 
/* 4884 */     if (hair.contains("C01") || hair.contains("C05")) {
/* 4885 */       this.bipedHeadssg.field_78796_g = this.field_78116_c.field_78796_g;
/* 4886 */       this.bipedHeadssg.field_78795_f = this.field_78116_c.field_78795_f;
/* 4887 */       this.bipedHeadssg.field_78800_c = this.field_78116_c.field_78800_c;
/* 4888 */       this.bipedHeadssg.field_78797_d = this.field_78116_c.field_78797_d;
/* 4889 */       this.bipedHeadssg.func_78785_a(par1);
/*      */     } 
/* 4891 */     if (hair.contains("C02") || hair.contains("C09") || hair.contains("C10")) {
/* 4892 */       this.bipedHeadsst.field_78796_g = this.field_78116_c.field_78796_g;
/* 4893 */       this.bipedHeadsst.field_78795_f = this.field_78116_c.field_78795_f;
/* 4894 */       this.bipedHeadsst.field_78800_c = this.field_78116_c.field_78800_c;
/* 4895 */       this.bipedHeadsst.field_78797_d = this.field_78116_c.field_78797_d;
/* 4896 */       this.bipedHeadsst.func_78785_a(par1);
/*      */     } 
/* 4898 */     if (hair.contains("C03")) {
/* 4899 */       this.bipedHeadssv.field_78796_g = this.field_78116_c.field_78796_g;
/* 4900 */       this.bipedHeadssv.field_78795_f = this.field_78116_c.field_78795_f;
/* 4901 */       this.bipedHeadssv.field_78800_c = this.field_78116_c.field_78800_c;
/* 4902 */       this.bipedHeadssv.field_78797_d = this.field_78116_c.field_78797_d;
/* 4903 */       this.bipedHeadssv.func_78785_a(par1);
/*      */     } 
/* 4905 */     if (hair.contains("C04")) {
/* 4906 */       this.bipedHeadssgh.field_78796_g = this.field_78116_c.field_78796_g;
/* 4907 */       this.bipedHeadssgh.field_78795_f = this.field_78116_c.field_78795_f;
/* 4908 */       this.bipedHeadssgh.field_78800_c = this.field_78116_c.field_78800_c;
/* 4909 */       this.bipedHeadssgh.field_78797_d = this.field_78116_c.field_78797_d;
/* 4910 */       this.bipedHeadssgh.func_78785_a(par1);
/*      */     } 
/* 4912 */     GL11.glPopMatrix();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void renderHeadwear(float par1) {
/* 4918 */     float f6 = f;
/* 4919 */     GL11.glPushMatrix();
/* 4920 */     GL11.glScalef((0.5F + 0.5F / f6) * ((g <= 1) ? 1.0F : 0.85F), 0.5F + 0.5F / f6, (0.5F + 0.5F / f6) * ((g <= 1) ? 1.0F : 0.85F));
/* 4921 */     GL11.glTranslatef(0.0F, (f6 - 1.0F) / f6 * (2.0F - ((f6 >= 1.5F && f6 <= 2.0F) ? ((2.0F - f6) / 2.5F) : ((f6 < 1.5F && f6 >= 1.0F) ? ((f6 * 2.0F - 2.0F) * 0.2F) : 0.0F))), 0.0F);
/* 4922 */     this.field_78114_d.field_78796_g = this.field_78116_c.field_78796_g;
/* 4923 */     this.field_78114_d.field_78795_f = this.field_78116_c.field_78795_f;
/* 4924 */     this.field_78114_d.field_78800_c = this.field_78116_c.field_78800_c;
/* 4925 */     this.field_78114_d.field_78797_d = this.field_78116_c.field_78797_d;
/* 4926 */     this.field_78114_d.func_78785_a(par1);
/* 4927 */     GL11.glPopMatrix();
/*      */   }
/*      */   
/*      */   public void renderHalo(float par1) {
/* 4931 */     float f6 = f;
/* 4932 */     GL11.glPushMatrix();
/* 4933 */     GL11.glScalef((0.5F + 0.5F / f6) * ((g <= 1) ? 1.0F : 0.85F), 0.5F + 0.5F / f6, (0.5F + 0.5F / f6) * ((g <= 1) ? 1.0F : 0.85F));
/* 4934 */     GL11.glTranslatef(0.0F, (f6 - 1.0F) / f6 * (2.0F - ((f6 >= 1.5F && f6 <= 2.0F) ? ((2.0F - f6) / 2.5F) : ((f6 < 1.5F && f6 >= 1.0F) ? ((f6 * 2.0F - 2.0F) * 0.2F) : 0.0F))), 0.0F);
/* 4935 */     this.halo.field_78796_g = this.field_78116_c.field_78796_g;
/* 4936 */     this.halo.field_78795_f = this.field_78116_c.field_78795_f;
/* 4937 */     this.halo.field_78800_c = this.field_78116_c.field_78800_c;
/* 4938 */     this.halo.field_78797_d = this.field_78116_c.field_78797_d;
/* 4939 */     this.halo.func_78785_a(par1);
/* 4940 */     GL11.glPopMatrix();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_78110_b(float par1) {
/* 4947 */     float f6 = f;
/* 4948 */     GL11.glPushMatrix();
/* 4949 */     GL11.glScalef((0.5F + 0.5F / f6) * ((g <= 1) ? 1.0F : 0.85F), 0.5F + 0.5F / f6, (0.5F + 0.5F / f6) * ((g <= 1) ? 1.0F : 0.85F));
/* 4950 */     GL11.glTranslatef(0.0F, (f6 - 1.0F) / f6 * (2.0F - ((f6 >= 1.5F && f6 <= 2.0F) ? ((2.0F - f6) / 2.5F) : ((f6 < 1.5F && f6 >= 1.0F) ? ((f6 * 2.0F - 2.0F) * 0.2F) : 0.0F))), 0.0F);
/* 4951 */     this.field_78121_j.field_78796_g = this.field_78116_c.field_78796_g;
/* 4952 */     this.field_78121_j.field_78795_f = this.field_78116_c.field_78795_f;
/* 4953 */     this.field_78121_j.field_78800_c = 0.0F;
/* 4954 */     this.field_78121_j.field_78797_d = 0.0F;
/* 4955 */     this.field_78121_j.func_78785_a(par1);
/* 4956 */     GL11.glPopMatrix();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_78111_c(float par1) {
/* 4964 */     this.field_78122_k.func_78785_a(par1);
/*      */   }
/*      */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JFamilyC-v1.2.18.jar!\JinRyuu\FamilyC\ModelBipedJFC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */