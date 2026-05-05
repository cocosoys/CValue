/*      */ package JinRyuu.DragonBC.common.Npcs;
/*      */ 
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
/*      */ public class ModelDBCZed
/*      */   extends ModelBiped
/*      */ {
/*      */   ModelRenderer head;
/*      */   ModelRenderer body;
/*      */   ModelRenderer rightarm;
/*      */   ModelRenderer leftarm;
/*      */   ModelRenderer rightleg;
/*      */   ModelRenderer leftleg;
/*      */   public ModelRenderer bipedHeadAll;
/*      */   public ModelRenderer bipedHeadg;
/*      */   public ModelRenderer bipedHeadt;
/*      */   public ModelRenderer bipedHeadgh;
/*      */   public ModelRenderer bipedHeadv;
/*      */   public ModelRenderer bipedHeadb;
/*      */   public ModelRenderer bipedHeadt2;
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
/*      */   public ModelRenderer trunk1;
/*      */   public ModelRenderer trunk2;
/*      */   public ModelRenderer trunk3;
/*      */   public ModelRenderer trunk4;
/*      */   public ModelRenderer trunk5;
/*      */   public ModelRenderer trunk6;
/*      */   public ModelRenderer trunk7;
/*      */   public ModelRenderer trunk8;
/*      */   public ModelRenderer trunk9;
/*      */   public ModelRenderer Hair;
/*      */   public ModelRenderer SideHairR3;
/*      */   public ModelRenderer FrontHairL1;
/*      */   public ModelRenderer SideHairL1;
/*      */   public ModelRenderer SideHairL2;
/*      */   public ModelRenderer SideHairL3;
/*      */   public ModelRenderer SideHairR1;
/*      */   public ModelRenderer SideHairR2;
/*      */   public ModelRenderer FrontHairR1;
/*      */   public ModelRenderer FrontHair1;
/*      */   public ModelRenderer FrontHair2;
/*      */   public ModelRenderer BackHair1;
/*      */   public ModelRenderer BackHair2;
/*      */   public ModelRenderer BackHair3;
/*      */   public ModelRenderer HairSpikeR1;
/*      */   public ModelRenderer HairSpikeR2;
/*      */   public ModelRenderer HairSpikeRF1;
/*      */   public ModelRenderer HairspikeB1;
/*      */   public ModelRenderer HairspikeB2;
/*      */   public ModelRenderer HairspikeB3;
/*      */   public ModelRenderer HairSpikeR3;
/*      */   public ModelRenderer HairSpikeLF1;
/*      */   public ModelRenderer HairSpikeL1;
/*      */   public ModelRenderer HairSpikeL2;
/*      */   public ModelRenderer HairSpikeL3;
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
/*      */   public ModelRenderer halo;
/*      */   public ModelRenderer halo1;
/*      */   public ModelRenderer halo2;
/*      */   public ModelRenderer halo3;
/*      */   public ModelRenderer halo4;
/*  146 */   private float F = 1.0F;
/*  147 */   private int t = 0;
/*      */   public ModelDBCZed(int t) {
/*  149 */     this(t, 1.0F);
/*  150 */     this.t = t;
/*      */   }
/*      */   
/*      */   public ModelDBCZed(int t, float f) {
/*  154 */     this();
/*  155 */     this.F = f;
/*      */   }
/*      */ 
/*      */   
/*      */   public ModelDBCZed() {
/*  160 */     this.field_78090_t = 128;
/*  161 */     this.field_78089_u = 64;
/*      */ 
/*      */     
/*  164 */     this.bipedHeadg = new ModelRenderer((ModelBase)this, 0, 0);
/*  165 */     this.bipedHeadg.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F);
/*  166 */     this.bipedHeadg.func_78793_a(0.0F, 0.0F, 0.0F);
/*  167 */     this.bipedHeadg.func_78787_b(128, 64);
/*  168 */     this.bipedHeadt = new ModelRenderer((ModelBase)this, 0, 0);
/*  169 */     this.bipedHeadt.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F);
/*  170 */     this.bipedHeadt.func_78793_a(0.0F, 0.0F, 0.0F);
/*  171 */     this.bipedHeadt.func_78787_b(128, 64);
/*  172 */     this.bipedHeadt2 = new ModelRenderer((ModelBase)this, 0, 0);
/*  173 */     this.bipedHeadt2.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F);
/*  174 */     this.bipedHeadt2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  175 */     this.bipedHeadt2.func_78787_b(128, 64);
/*  176 */     this.bipedHeadv = new ModelRenderer((ModelBase)this, 0, 0);
/*  177 */     this.bipedHeadv.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F);
/*  178 */     this.bipedHeadv.func_78793_a(0.0F, 0.0F, 0.0F);
/*  179 */     this.bipedHeadv.func_78787_b(128, 64);
/*  180 */     this.bipedHeadgh = new ModelRenderer((ModelBase)this, 0, 0);
/*  181 */     this.bipedHeadgh.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F);
/*  182 */     this.bipedHeadgh.func_78793_a(0.0F, 0.0F, 0.0F);
/*  183 */     this.bipedHeadgh.func_78787_b(128, 64);
/*  184 */     this.bipedHeadb = new ModelRenderer((ModelBase)this, 0, 0);
/*  185 */     this.bipedHeadb.func_78790_a(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F);
/*  186 */     this.bipedHeadb.func_78793_a(0.0F, 0.0F, 0.0F);
/*  187 */     this.bipedHeadb.func_78787_b(128, 64);
/*      */     
/*  189 */     this.head = new ModelRenderer((ModelBase)this, 0, 0);
/*  190 */     this.head.func_78789_a(-4.0F, -8.0F, -4.0F, 8, 8, 8);
/*  191 */     this.head.func_78793_a(0.0F, 0.0F, 0.0F);
/*  192 */     this.head.func_78787_b(128, 64);
/*      */ 
/*      */     
/*  195 */     this.body = new ModelRenderer((ModelBase)this, 16, 16);
/*  196 */     this.body.func_78789_a(-4.0F, 0.0F, -2.0F, 8, 12, 4);
/*  197 */     this.body.func_78793_a(0.0F, 0.0F, 0.0F);
/*  198 */     this.body.func_78787_b(128, 64);
/*  199 */     this.rightarm = new ModelRenderer((ModelBase)this, 40, 16);
/*  200 */     this.rightarm.func_78789_a(-3.0F, -2.0F, -2.0F, 4, 12, 4);
/*  201 */     this.rightarm.func_78793_a(-5.0F, 2.0F, 0.0F);
/*  202 */     this.rightarm.func_78787_b(128, 64);
/*  203 */     this.leftarm = new ModelRenderer((ModelBase)this, 40, 16);
/*  204 */     this.leftarm.field_78809_i = true;
/*  205 */     this.leftarm.func_78789_a(-1.0F, -2.0F, -2.0F, 4, 12, 4);
/*  206 */     this.leftarm.func_78793_a(5.0F, 2.0F, 0.0F);
/*  207 */     this.leftarm.func_78787_b(128, 64);
/*  208 */     this.rightleg = new ModelRenderer((ModelBase)this, 0, 16);
/*  209 */     this.rightleg.func_78789_a(-2.0F, 0.0F, -2.0F, 4, 12, 4);
/*  210 */     this.rightleg.func_78793_a(-2.0F, 12.0F, 0.0F);
/*  211 */     this.rightleg.func_78787_b(128, 64);
/*  212 */     this.leftleg = new ModelRenderer((ModelBase)this, 0, 16);
/*  213 */     this.leftleg.field_78809_i = true;
/*  214 */     this.leftleg.func_78789_a(-2.0F, 0.0F, -2.0F, 4, 12, 4);
/*  215 */     this.leftleg.func_78793_a(2.0F, 12.0F, 0.0F);
/*  216 */     this.leftleg.func_78787_b(128, 64);
/*      */ 
/*      */     
/*  219 */     this.goku1 = new ModelRenderer((ModelBase)this, 64, 0);
/*  220 */     this.goku1.func_78789_a(-1.0F, -10.0F, 0.0F, 4, 4, 4);
/*  221 */     this.goku1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  222 */     this.goku1.func_78787_b(128, 64);
/*  223 */     setRotation(this.goku1, 0.1745329F, 0.0F, -0.4363323F);
/*  224 */     this.goku2 = new ModelRenderer((ModelBase)this, 64, 0);
/*  225 */     this.goku2.func_78789_a(-8.0F, -4.5F, 0.0F, 4, 3, 3);
/*  226 */     this.goku2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  227 */     this.goku2.func_78787_b(128, 64);
/*  228 */     setRotation(this.goku2, 0.0F, -0.1745329F, 0.3490659F);
/*  229 */     this.goku3 = new ModelRenderer((ModelBase)this, 64, 0);
/*  230 */     this.goku3.func_78789_a(-7.0F, -2.6F, 1.0F, 4, 2, 2);
/*  231 */     this.goku3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  232 */     this.goku3.func_78787_b(128, 64);
/*  233 */     setRotation(this.goku3, 0.0F, -0.2617994F, 0.1943133F);
/*  234 */     this.goku4 = new ModelRenderer((ModelBase)this, 64, 0);
/*  235 */     this.goku4.func_78789_a(3.0F, -4.0F, 0.0F, 4, 3, 3);
/*  236 */     this.goku4.func_78793_a(0.0F, 0.0F, 0.0F);
/*  237 */     this.goku4.func_78787_b(128, 64);
/*  238 */     setRotation(this.goku4, 0.0F, 0.1745329F, -0.3490659F);
/*  239 */     this.goku5 = new ModelRenderer((ModelBase)this, 64, 0);
/*  240 */     this.goku5.func_78789_a(3.0F, -2.3F, 0.7F, 3, 2, 2);
/*  241 */     this.goku5.func_78793_a(0.0F, 0.0F, 0.0F);
/*  242 */     this.goku5.func_78787_b(128, 64);
/*  243 */     setRotation(this.goku5, 0.0F, 0.1745329F, -0.1151917F);
/*  244 */     this.goku6 = new ModelRenderer((ModelBase)this, 64, 0);
/*  245 */     this.goku6.func_78789_a(5.0F, -4.3F, 1.5F, 3, 2, 2);
/*  246 */     this.goku6.func_78793_a(0.0F, 0.0F, 0.0F);
/*  247 */     this.goku6.func_78787_b(128, 64);
/*  248 */     setRotation(this.goku6, 0.0F, 0.3490659F, -0.2617994F);
/*  249 */     this.goku7 = new ModelRenderer((ModelBase)this, 64, 0);
/*  250 */     this.goku7.func_78789_a(1.0F, -11.0F, 2.0F, 3, 3, 3);
/*  251 */     this.goku7.func_78793_a(0.0F, 0.0F, 0.0F);
/*  252 */     this.goku7.func_78787_b(128, 64);
/*  253 */     setRotation(this.goku7, 0.3490659F, 0.0F, -0.6108652F);
/*  254 */     this.goku8 = new ModelRenderer((ModelBase)this, 64, 0);
/*  255 */     this.goku8.func_78789_a(3.0F, -12.0F, 4.0F, 2, 3, 2);
/*  256 */     this.goku8.func_78793_a(0.0F, 0.0F, 0.0F);
/*  257 */     this.goku8.func_78787_b(128, 64);
/*  258 */     setRotation(this.goku8, 0.5235988F, 0.0F, -0.7853982F);
/*  259 */     this.goku9 = new ModelRenderer((ModelBase)this, 64, 0);
/*  260 */     this.goku9.func_78789_a(-9.0F, -4.7F, 1.5F, 3, 2, 2);
/*  261 */     this.goku9.func_78793_a(0.0F, 0.0F, 0.0F);
/*  262 */     this.goku9.func_78787_b(128, 64);
/*  263 */     setRotation(this.goku9, 0.0F, -0.3490659F, 0.2617994F);
/*  264 */     this.goku10 = new ModelRenderer((ModelBase)this, 64, 0);
/*  265 */     this.goku10.func_78789_a(-10.0F, -4.8F, 1.0F, 5, 2, 2);
/*  266 */     this.goku10.func_78793_a(0.0F, 0.0F, 0.0F);
/*  267 */     this.goku10.func_78787_b(128, 64);
/*  268 */     setRotation(this.goku10, 0.0F, -0.3839724F, 0.5270894F);
/*  269 */     this.goku11 = new ModelRenderer((ModelBase)this, 64, 0);
/*  270 */     this.goku11.func_78789_a(1.0F, -8.0F, 5.0F, 1, 4, 1);
/*  271 */     this.goku11.func_78793_a(0.0F, 0.0F, 0.0F);
/*  272 */     this.goku11.func_78787_b(128, 64);
/*  273 */     setRotation(this.goku11, 0.6806784F, 0.0F, -0.1745329F);
/*  274 */     this.goku12 = new ModelRenderer((ModelBase)this, 64, 0);
/*  275 */     this.goku12.func_78789_a(-3.5F, -7.0F, -5.0F, 2, 3, 3);
/*  276 */     this.goku12.func_78793_a(0.0F, 0.0F, 0.0F);
/*  277 */     this.goku12.func_78787_b(128, 64);
/*  278 */     setRotation(this.goku12, 0.0F, 0.0F, 0.4014257F);
/*  279 */     this.goku13 = new ModelRenderer((ModelBase)this, 64, 0);
/*  280 */     this.goku13.func_78789_a(-6.2F, -5.5F, -5.0F, 2, 3, 2);
/*  281 */     this.goku13.func_78793_a(0.0F, 0.0F, 0.0F);
/*  282 */     this.goku13.func_78787_b(128, 64);
/*  283 */     setRotation(this.goku13, 0.0F, 0.0F, 0.5235988F);
/*  284 */     this.goku14 = new ModelRenderer((ModelBase)this, 64, 0);
/*  285 */     this.goku14.func_78789_a(-7.5F, -4.0F, -5.0F, 1, 3, 2);
/*  286 */     this.goku14.func_78793_a(0.0F, 0.0F, 0.0F);
/*  287 */     this.goku14.func_78787_b(128, 64);
/*  288 */     setRotation(this.goku14, 0.0F, 0.0F, 0.6108652F);
/*  289 */     this.goku15 = new ModelRenderer((ModelBase)this, 64, 0);
/*  290 */     this.goku15.func_78789_a(3.2F, -6.5F, -5.0F, 2, 3, 2);
/*  291 */     this.goku15.func_78793_a(0.0F, 0.0F, 0.0F);
/*  292 */     this.goku15.func_78787_b(128, 64);
/*  293 */     setRotation(this.goku15, 0.0F, 0.0F, -0.3490659F);
/*  294 */     this.goku16 = new ModelRenderer((ModelBase)this, 64, 0);
/*  295 */     this.goku16.func_78789_a(6.5F, -4.5F, -5.0F, 1, 3, 2);
/*  296 */     this.goku16.func_78793_a(0.0F, 0.0F, 0.0F);
/*  297 */     this.goku16.func_78787_b(128, 64);
/*  298 */     setRotation(this.goku16, 0.0F, 0.0F, -0.6108652F);
/*      */ 
/*      */     
/*  301 */     this.gohan1 = new ModelRenderer((ModelBase)this, 64, 0);
/*  302 */     this.gohan1.func_78789_a(-1.0F, -10.0F, -5.066667F, 4, 4, 4);
/*  303 */     this.gohan1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  304 */     setRotation(this.gohan1, -0.1745329F, 0.0F, 0.0F);
/*  305 */     this.gohan7 = new ModelRenderer((ModelBase)this, 64, 0);
/*  306 */     this.gohan7.func_78789_a(-0.5F, -11.0F, -6.0F, 3, 2, 3);
/*  307 */     this.gohan7.func_78793_a(0.0F, 0.0F, 0.0F);
/*  308 */     setRotation(this.gohan7, -0.3665191F, 0.0F, 0.0F);
/*  309 */     this.gohan8 = new ModelRenderer((ModelBase)this, 64, 0);
/*  310 */     this.gohan8.func_78789_a(0.0F, -11.0F, -7.0F, 2, 2, 2);
/*  311 */     this.gohan8.func_78793_a(0.0F, 0.0F, 0.0F);
/*  312 */     setRotation(this.gohan8, -0.5585054F, 0.0F, 0.0F);
/*  313 */     this.gohan10 = new ModelRenderer((ModelBase)this, 64, 0);
/*  314 */     this.gohan10.func_78789_a(-1.533333F, -10.3F, -5.466667F, 4, 5, 4);
/*  315 */     this.gohan10.func_78793_a(0.0F, 0.0F, 0.0F);
/*  316 */     setRotation(this.gohan10, -0.2617994F, 0.0F, -0.3665191F);
/*  317 */     this.gohan11 = new ModelRenderer((ModelBase)this, 64, 0);
/*  318 */     this.gohan11.func_78789_a(-0.5F, -11.3F, -6.0F, 5, 4, 4);
/*  319 */     this.gohan11.func_78793_a(0.0F, 0.0F, 0.0F);
/*  320 */     setRotation(this.gohan11, -0.418879F, 0.0F, -0.3316126F);
/*  321 */     this.gohan12 = new ModelRenderer((ModelBase)this, 64, 0);
/*  322 */     this.gohan12.func_78789_a(-0.5F, -12.5F, -6.0F, 3, 3, 3);
/*  323 */     this.gohan12.func_78793_a(0.0F, 0.0F, 0.0F);
/*  324 */     setRotation(this.gohan12, -0.5235988F, 0.0F, -0.2268928F);
/*  325 */     this.gohan13 = new ModelRenderer((ModelBase)this, 64, 0);
/*  326 */     this.gohan13.func_78789_a(0.0F, -12.66667F, -7.0F, 2, 4, 2);
/*  327 */     this.gohan13.func_78793_a(0.0F, 0.0F, 0.0F);
/*  328 */     setRotation(this.gohan13, -0.6283185F, 0.0F, -0.0698132F);
/*  329 */     this.gohan14 = new ModelRenderer((ModelBase)this, 64, 0);
/*  330 */     this.gohan14.func_78789_a(-1.3F, -9.3F, -5.0F, 3, 5, 3);
/*  331 */     this.gohan14.func_78793_a(0.0F, 0.0F, 0.0F);
/*  332 */     setRotation(this.gohan14, -0.2268928F, 0.0F, 0.4014257F);
/*  333 */     this.gohan15 = new ModelRenderer((ModelBase)this, 64, 0);
/*  334 */     this.gohan15.func_78789_a(-0.8333333F, -10.8F, -6.0F, 3, 4, 4);
/*  335 */     this.gohan15.func_78793_a(0.0F, 0.0F, 0.0F);
/*  336 */     setRotation(this.gohan15, -0.4537856F, 0.0F, 0.2617994F);
/*  337 */     this.gohan16 = new ModelRenderer((ModelBase)this, 64, 0);
/*  338 */     this.gohan16.func_78789_a(-1.0F, -12.46667F, -6.0F, 3, 4, 3);
/*  339 */     this.gohan16.func_78793_a(0.0F, 0.0F, 0.0F);
/*  340 */     setRotation(this.gohan16, -0.5410521F, 0.0F, 0.1745329F);
/*  341 */     this.gohan17 = new ModelRenderer((ModelBase)this, 64, 0);
/*  342 */     this.gohan17.func_78789_a(-2.0F, -9.0F, -1.0F, 4, 5, 4);
/*  343 */     this.gohan17.func_78793_a(0.0F, 0.0F, 0.0F);
/*  344 */     setRotation(this.gohan17, -0.2792527F, 0.0F, 0.0F);
/*  345 */     this.gohan18 = new ModelRenderer((ModelBase)this, 64, 0);
/*  346 */     this.gohan18.func_78789_a(-0.8F, -10.0F, -1.0F, 4, 5, 4);
/*  347 */     this.gohan18.func_78793_a(0.0F, 0.0F, 0.0F);
/*  348 */     setRotation(this.gohan18, -0.2443461F, 0.2617994F, 0.0174533F);
/*  349 */     this.gohan19 = new ModelRenderer((ModelBase)this, 64, 0);
/*  350 */     this.gohan19.func_78789_a(-3.266667F, -10.0F, -1.0F, 4, 4, 4);
/*  351 */     this.gohan19.func_78793_a(0.0F, 0.0F, 0.0F);
/*  352 */     setRotation(this.gohan19, -0.2443461F, -0.2617994F, 0.0174533F);
/*  353 */     this.gohan20 = new ModelRenderer((ModelBase)this, 64, 0);
/*  354 */     this.gohan20.func_78789_a(-2.0F, -12.0F, -1.0F, 3, 4, 4);
/*  355 */     this.gohan20.func_78793_a(0.0F, 0.0F, 0.0F);
/*  356 */     setRotation(this.gohan20, -0.1396263F, 0.0F, 0.0F);
/*  357 */     this.gohan21 = new ModelRenderer((ModelBase)this, 64, 0);
/*  358 */     this.gohan21.func_78789_a(-0.6F, -11.5F, 0.0F, 3, 2, 3);
/*  359 */     this.gohan21.func_78793_a(0.0F, 0.0F, 0.0F);
/*  360 */     setRotation(this.gohan21, -0.122173F, 0.1745329F, 0.0F);
/*  361 */     this.gohan22 = new ModelRenderer((ModelBase)this, 64, 0);
/*  362 */     this.gohan22.func_78789_a(-2.866667F, -11.53333F, -0.6666667F, 3, 4, 3);
/*  363 */     this.gohan22.func_78793_a(0.0F, 0.0F, 0.0F);
/*  364 */     setRotation(this.gohan22, -0.2443461F, -0.2617994F, 0.0174533F);
/*  365 */     this.gohan26 = new ModelRenderer((ModelBase)this, 64, 0);
/*  366 */     this.gohan26.func_78789_a(4.433333F, -6.5F, -5.266667F, 2, 3, 3);
/*  367 */     this.gohan26.func_78793_a(0.0F, 0.0F, 0.0F);
/*  368 */     setRotation(this.gohan26, 0.0F, 0.0F, -0.5934119F);
/*      */     
/*  370 */     this.vegeta1 = new ModelRenderer((ModelBase)this, 32, 0);
/*  371 */     this.vegeta1.func_78789_a(-1.0F, -10.0F, -6.05F, 4, 4, 4);
/*  372 */     this.vegeta1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  373 */     setRotation(this.vegeta1, -0.3141593F, 0.0F, 0.0F);
/*  374 */     this.vegeta2 = new ModelRenderer((ModelBase)this, 32, 0);
/*  375 */     this.vegeta2.func_78789_a(-8.0F, -4.5F, -1.0F, 4, 3, 3);
/*  376 */     this.vegeta2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  377 */     setRotation(this.vegeta2, 0.0F, 0.1745329F, 0.5759587F);
/*  378 */     this.vegeta3 = new ModelRenderer((ModelBase)this, 32, 0);
/*  379 */     this.vegeta3.func_78789_a(-7.0F, -2.0F, 0.0F, 4, 2, 2);
/*  380 */     this.vegeta3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  381 */     setRotation(this.vegeta3, 0.0F, 0.2617994F, 0.5061455F);
/*  382 */     this.vegeta4 = new ModelRenderer((ModelBase)this, 32, 0);
/*  383 */     this.vegeta4.func_78789_a(4.0F, -4.0F, -1.0F, 4, 3, 3);
/*  384 */     this.vegeta4.func_78793_a(0.0F, 0.0F, 0.0F);
/*  385 */     setRotation(this.vegeta4, 0.0F, -0.1745329F, -0.6108652F);
/*  386 */     this.vegeta5 = new ModelRenderer((ModelBase)this, 32, 0);
/*  387 */     this.vegeta5.func_78789_a(3.0F, -2.0F, 0.7F, 4, 2, 2);
/*  388 */     this.vegeta5.func_78793_a(0.0F, 0.0F, 0.0F);
/*  389 */     setRotation(this.vegeta5, 0.0F, -0.1745329F, -0.5061455F);
/*  390 */     this.vegeta6 = new ModelRenderer((ModelBase)this, 32, 0);
/*  391 */     this.vegeta6.func_78789_a(7.0F, -2.0F, -1.5F, 3, 2, 2);
/*  392 */     this.vegeta6.func_78793_a(0.0F, 0.0F, 0.0F);
/*  393 */     setRotation(this.vegeta6, 0.0F, -0.3490659F, -0.9250245F);
/*  394 */     this.vegeta7 = new ModelRenderer((ModelBase)this, 32, 0);
/*  395 */     this.vegeta7.func_78789_a(-0.5F, -12.0F, -6.0F, 3, 3, 3);
/*  396 */     this.vegeta7.func_78793_a(0.0F, 0.0F, 0.0F);
/*  397 */     setRotation(this.vegeta7, -0.4363323F, 0.0F, 0.0F);
/*  398 */     this.vegeta8 = new ModelRenderer((ModelBase)this, 32, 0);
/*  399 */     this.vegeta8.func_78789_a(0.0F, -14.0F, -7.0F, 2, 3, 2);
/*  400 */     this.vegeta8.func_78793_a(0.0F, 0.0F, 0.0F);
/*  401 */     setRotation(this.vegeta8, -0.5934119F, 0.0F, 0.0F);
/*  402 */     this.vegeta9 = new ModelRenderer((ModelBase)this, 32, 0);
/*  403 */     this.vegeta9.func_78789_a(-10.0F, -2.166667F, -1.5F, 3, 2, 2);
/*  404 */     this.vegeta9.func_78793_a(0.0F, 0.0F, 0.0F);
/*  405 */     setRotation(this.vegeta9, 0.0F, 0.3490659F, 0.8901179F);
/*  406 */     this.vegeta10 = new ModelRenderer((ModelBase)this, 32, 0);
/*  407 */     this.vegeta10.func_78789_a(-1.0F, -10.0F, -6.2F, 4, 6, 4);
/*  408 */     this.vegeta10.func_78793_a(0.0F, 0.0F, 0.0F);
/*  409 */     setRotation(this.vegeta10, -0.4363323F, 0.0F, -0.4014257F);
/*  410 */     this.vegeta11 = new ModelRenderer((ModelBase)this, 32, 0);
/*  411 */     this.vegeta11.func_78789_a(-0.5F, -12.0F, -6.0F, 5, 4, 3);
/*  412 */     this.vegeta11.func_78793_a(0.0F, 0.0F, 0.0F);
/*  413 */     setRotation(this.vegeta11, -0.5410521F, 0.0F, -0.3665191F);
/*  414 */     this.vegeta12 = new ModelRenderer((ModelBase)this, 32, 0);
/*  415 */     this.vegeta12.func_78789_a(-0.5F, -14.0F, -6.0F, 3, 3, 3);
/*  416 */     this.vegeta12.func_78793_a(0.0F, 0.0F, 0.0F);
/*  417 */     setRotation(this.vegeta12, -0.6108652F, 0.0F, -0.2443461F);
/*  418 */     this.vegeta13 = new ModelRenderer((ModelBase)this, 32, 0);
/*  419 */     this.vegeta13.func_78789_a(0.0F, -15.4F, -7.0F, 2, 5, 2);
/*  420 */     this.vegeta13.func_78793_a(0.0F, 0.0F, 0.0F);
/*  421 */     setRotation(this.vegeta13, -0.6981317F, 0.0F, -0.122173F);
/*  422 */     this.vegeta14 = new ModelRenderer((ModelBase)this, 32, 0);
/*  423 */     this.vegeta14.func_78789_a(-1.5F, -9.0F, -5.5F, 3, 5, 3);
/*  424 */     this.vegeta14.func_78793_a(0.0F, 0.0F, 0.0F);
/*  425 */     setRotation(this.vegeta14, -0.3665191F, 0.0F, 0.4363323F);
/*  426 */     this.vegeta15 = new ModelRenderer((ModelBase)this, 32, 0);
/*  427 */     this.vegeta15.func_78789_a(-0.5F, -10.0F, -6.0F, 3, 3, 3);
/*  428 */     this.vegeta15.func_78793_a(0.0F, 0.0F, 0.0F);
/*  429 */     setRotation(this.vegeta15, -0.5410521F, 0.0F, 0.2455096F);
/*  430 */     this.vegeta16 = new ModelRenderer((ModelBase)this, 32, 0);
/*  431 */     this.vegeta16.func_78789_a(-1.0F, -12.0F, -6.0F, 3, 3, 3);
/*  432 */     this.vegeta16.func_78793_a(0.0F, 0.0F, 0.0F);
/*  433 */     setRotation(this.vegeta16, -0.5759587F, 0.0F, 0.1396263F);
/*  434 */     this.vegeta17 = new ModelRenderer((ModelBase)this, 32, 0);
/*  435 */     this.vegeta17.func_78789_a(-2.0F, -9.0F, -1.0F, 4, 5, 4);
/*  436 */     this.vegeta17.func_78793_a(0.0F, 0.0F, 0.0F);
/*  437 */     setRotation(this.vegeta17, -0.2792527F, 0.0F, 0.0F);
/*  438 */     this.vegeta18 = new ModelRenderer((ModelBase)this, 32, 0);
/*  439 */     this.vegeta18.func_78789_a(-1.0F, -10.0F, -1.0F, 4, 5, 4);
/*  440 */     this.vegeta18.func_78793_a(0.0F, 0.0F, 0.0F);
/*  441 */     setRotation(this.vegeta18, -0.2443461F, 0.2617994F, 0.0174533F);
/*  442 */     this.vegeta19 = new ModelRenderer((ModelBase)this, 32, 0);
/*  443 */     this.vegeta19.func_78789_a(-4.0F, -11.0F, -1.0F, 4, 6, 4);
/*  444 */     this.vegeta19.func_78793_a(0.0F, 0.0F, 0.0F);
/*  445 */     setRotation(this.vegeta19, -0.2443461F, -0.2617994F, 0.0174533F);
/*  446 */     this.vegeta20 = new ModelRenderer((ModelBase)this, 32, 0);
/*  447 */     this.vegeta20.func_78789_a(-2.0F, -13.0F, -1.0F, 3, 5, 4);
/*  448 */     this.vegeta20.func_78793_a(0.0F, 0.0F, 0.0F);
/*  449 */     setRotation(this.vegeta20, -0.1396263F, 0.0F, 0.0F);
/*  450 */     this.vegeta21 = new ModelRenderer((ModelBase)this, 32, 0);
/*  451 */     this.vegeta21.func_78789_a(-1.0F, -14.0F, 0.0F, 3, 5, 3);
/*  452 */     this.vegeta21.func_78793_a(0.0F, 0.0F, 0.0F);
/*  453 */     setRotation(this.vegeta21, -0.122173F, 0.1745329F, 0.0F);
/*  454 */     this.vegeta22 = new ModelRenderer((ModelBase)this, 32, 0);
/*  455 */     this.vegeta22.func_78789_a(-2.866667F, -13.2F, -0.6666667F, 3, 4, 3);
/*  456 */     this.vegeta22.func_78793_a(0.0F, 0.0F, 0.0F);
/*  457 */     setRotation(this.vegeta22, -0.2443461F, -0.2617994F, 0.0174533F);
/*      */ 
/*      */     
/*  460 */     this.trunk1 = new ModelRenderer((ModelBase)this, 32, 0);
/*  461 */     this.trunk1.func_78789_a(4.7F, -6.4F, -4.2F, 4, 6, 3);
/*  462 */     this.trunk1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  463 */     this.trunk1.func_78787_b(128, 64);
/*  464 */     this.trunk1.field_78809_i = true;
/*  465 */     setRotation(this.trunk1, 0.1745329F, 0.0F, -0.8028515F);
/*  466 */     this.trunk2 = new ModelRenderer((ModelBase)this, 32, 0);
/*  467 */     this.trunk2.func_78789_a(-8.733334F, -6.4F, -4.0F, 4, 6, 3);
/*  468 */     this.trunk2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  469 */     this.trunk2.func_78787_b(128, 64);
/*  470 */     this.trunk2.field_78809_i = true;
/*  471 */     setRotation(this.trunk2, 0.1745329F, 0.0F, 0.8028515F);
/*  472 */     this.trunk3 = new ModelRenderer((ModelBase)this, 32, 0);
/*  473 */     this.trunk3.func_78789_a(3.0F, -8.0F, -1.2F, 4, 6, 3);
/*  474 */     this.trunk3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  475 */     this.trunk3.func_78787_b(128, 64);
/*  476 */     this.trunk3.field_78809_i = true;
/*  477 */     setRotation(this.trunk3, 0.1745329F, -0.0872665F, -0.4014257F);
/*  478 */     this.trunk4 = new ModelRenderer((ModelBase)this, 32, 0);
/*  479 */     this.trunk4.func_78789_a(3.0F, -7.6F, 1.6F, 4, 6, 3);
/*  480 */     this.trunk4.func_78793_a(0.0F, 0.0F, 0.0F);
/*  481 */     this.trunk4.func_78787_b(128, 64);
/*  482 */     this.trunk4.field_78809_i = true;
/*  483 */     setRotation(this.trunk4, 0.1745329F, -0.0174533F, -0.4014257F);
/*  484 */     this.trunk5 = new ModelRenderer((ModelBase)this, 32, 0);
/*  485 */     this.trunk5.func_78789_a(-7.0F, -7.6F, 1.8F, 4, 6, 3);
/*  486 */     this.trunk5.func_78793_a(0.0F, 0.0F, 0.0F);
/*  487 */     this.trunk5.func_78787_b(128, 64);
/*  488 */     this.trunk5.field_78809_i = true;
/*  489 */     setRotation(this.trunk5, 0.1745329F, -0.0174533F, 0.4014257F);
/*  490 */     this.trunk6 = new ModelRenderer((ModelBase)this, 32, 0);
/*  491 */     this.trunk6.func_78789_a(-7.0F, -8.0F, -1.2F, 4, 6, 3);
/*  492 */     this.trunk6.func_78793_a(0.0F, 0.0F, 0.0F);
/*  493 */     this.trunk6.func_78787_b(128, 64);
/*  494 */     this.trunk6.field_78809_i = true;
/*  495 */     setRotation(this.trunk6, 0.1745329F, 0.0872665F, 0.4014257F);
/*  496 */     this.trunk7 = new ModelRenderer((ModelBase)this, 32, 0);
/*  497 */     this.trunk7.func_78789_a(4.4F, -7.0F, 0.6F, 4, 5, 3);
/*  498 */     this.trunk7.func_78793_a(0.0F, 0.0F, 0.0F);
/*  499 */     this.trunk7.func_78787_b(128, 64);
/*  500 */     this.trunk7.field_78809_i = true;
/*  501 */     setRotation(this.trunk7, 0.0F, -0.6457718F, -0.3665191F);
/*  502 */     this.trunk8 = new ModelRenderer((ModelBase)this, 32, 0);
/*  503 */     this.trunk8.func_78789_a(-8.4F, -7.0F, 0.6F, 4, 5, 3);
/*  504 */     this.trunk8.func_78793_a(0.0F, 0.0F, 0.0F);
/*  505 */     this.trunk8.func_78787_b(128, 64);
/*  506 */     this.trunk8.field_78809_i = true;
/*  507 */     setRotation(this.trunk8, 0.0F, 0.6457718F, 0.3665191F);
/*  508 */     this.trunk9 = new ModelRenderer((ModelBase)this, 32, 0);
/*  509 */     this.trunk9.func_78789_a(-2.5F, -7.0F, 4.0F, 5, 4, 3);
/*  510 */     this.trunk9.func_78793_a(0.0F, 0.0F, 0.0F);
/*  511 */     this.trunk9.func_78787_b(128, 64);
/*  512 */     this.trunk9.field_78809_i = true;
/*  513 */     setRotation(this.trunk9, 0.08F, 0.0F, 0.0F);
/*      */ 
/*      */     
/*  516 */     this.HairspikeB1 = new ModelRenderer((ModelBase)this, 51, 47);
/*  517 */     this.HairspikeB1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  518 */     this.HairspikeB1.func_78790_a(-0.9F, -2.3F, -13.8F, 2, 2, 3, 0.0F);
/*  519 */     setRotateAngle(this.HairspikeB1, -0.95609134F, 0.0F, 0.0F);
/*  520 */     this.SideHairL1 = new ModelRenderer((ModelBase)this, 0, 43);
/*  521 */     this.SideHairL1.field_78809_i = true;
/*  522 */     this.SideHairL1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  523 */     this.SideHairL1.func_78790_a(6.9F, -3.5F, -4.0F, 3, 7, 3, 0.0F);
/*  524 */     setRotateAngle(this.SideHairL1, 0.0F, 0.0F, -1.1838568F);
/*  525 */     this.HairSpikeRF1 = new ModelRenderer((ModelBase)this, 37, 40);
/*  526 */     this.HairSpikeRF1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  527 */     this.HairSpikeRF1.func_78790_a(-10.6F, -2.7F, -5.4F, 3, 2, 2, 0.0F);
/*  528 */     setRotateAngle(this.HairSpikeRF1, 0.0F, 0.0F, -0.4553564F);
/*  529 */     this.HairspikeB2 = new ModelRenderer((ModelBase)this, 51, 33);
/*  530 */     this.HairspikeB2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  531 */     this.HairspikeB2.func_78790_a(-0.9F, -1.9F, -13.2F, 2, 2, 3, 0.0F);
/*  532 */     setRotateAngle(this.HairspikeB2, -0.95609134F, 0.0F, 0.0F);
/*  533 */     this.SideHairR1 = new ModelRenderer((ModelBase)this, 0, 43);
/*  534 */     this.SideHairR1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  535 */     this.SideHairR1.func_78790_a(-10.0F, -3.5F, -4.0F, 3, 7, 3, 0.0F);
/*  536 */     setRotateAngle(this.SideHairR1, 0.0F, 0.0F, 1.1838568F);
/*  537 */     this.SideHairL3 = new ModelRenderer((ModelBase)this, 26, 43);
/*  538 */     this.SideHairL3.field_78809_i = true;
/*  539 */     this.SideHairL3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  540 */     this.SideHairL3.func_78790_a(7.8F, -4.3F, 1.3F, 3, 5, 3, 0.0F);
/*  541 */     setRotateAngle(this.SideHairL3, 0.089186326F, 0.0F, -1.1383038F);
/*  542 */     this.FrontHairL1 = new ModelRenderer((ModelBase)this, 38, 32);
/*  543 */     this.FrontHairL1.field_78809_i = true;
/*  544 */     this.FrontHairL1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  545 */     this.FrontHairL1.func_78790_a(7.5F, -2.7F, -5.8F, 2, 5, 2, 0.0F);
/*  546 */     setRotateAngle(this.FrontHairL1, -0.18203785F, 0.0F, -1.1838568F);
/*  547 */     this.BackHair3 = new ModelRenderer((ModelBase)this, 50, 39);
/*  548 */     this.BackHair3.field_78809_i = true;
/*  549 */     this.BackHair3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  550 */     this.BackHair3.func_78790_a(-1.5F, -10.0F, -6.8F, 3, 4, 3, 0.0F);
/*  551 */     setRotateAngle(this.BackHair3, -1.0016445F, 0.5009095F, 0.0F);
/*  552 */     this.HairSpikeR2 = new ModelRenderer((ModelBase)this, 13, 53);
/*  553 */     this.HairSpikeR2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  554 */     this.HairSpikeR2.func_78790_a(-12.3F, -2.4F, -0.8F, 4, 2, 2, 0.0F);
/*  555 */     setRotateAngle(this.HairSpikeR2, 0.0F, 0.0F, -0.31869712F);
/*  556 */     this.HairSpikeR3 = new ModelRenderer((ModelBase)this, 26, 52);
/*  557 */     this.HairSpikeR3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  558 */     this.HairSpikeR3.func_78790_a(-12.1F, -2.7F, 1.8F, 4, 2, 2, 0.0F);
/*  559 */     setRotateAngle(this.HairSpikeR3, 0.0F, 0.0F, -0.22759093F);
/*  560 */     this.FrontHair1 = new ModelRenderer((ModelBase)this, 26, 32);
/*  561 */     this.FrontHair1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  562 */     this.FrontHair1.func_78790_a(-2.3F, -6.1F, -7.4F, 1, 4, 1, 0.0F);
/*  563 */     setRotateAngle(this.FrontHair1, -0.31869712F, 0.0F, 0.18203785F);
/*  564 */     this.HairSpikeL1 = new ModelRenderer((ModelBase)this, 0, 54);
/*  565 */     this.HairSpikeL1.field_78809_i = true;
/*  566 */     this.HairSpikeL1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  567 */     this.HairSpikeL1.func_78790_a(8.1F, -0.7F, -3.2F, 4, 2, 2, 0.0F);
/*  568 */     setRotateAngle(this.HairSpikeL1, 0.0F, 0.0F, 0.31869712F);
/*  569 */     this.Hair = new ModelRenderer((ModelBase)this, 0, 32);
/*  570 */     this.Hair.func_78793_a(0.0F, 0.0F, 0.0F);
/*  571 */     this.Hair.func_78790_a(-4.0F, -9.0F, -4.0F, 8, 1, 8, 0.0F);
/*  572 */     this.FrontHair2 = new ModelRenderer((ModelBase)this, 26, 32);
/*  573 */     this.FrontHair2.field_78809_i = true;
/*  574 */     this.FrontHair2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  575 */     this.FrontHair2.func_78790_a(1.5F, -6.1F, -7.4F, 1, 4, 1, 0.0F);
/*  576 */     setRotateAngle(this.FrontHair2, -0.31869712F, 0.0F, -0.18203785F);
/*  577 */     this.HairSpikeL3 = new ModelRenderer((ModelBase)this, 26, 52);
/*  578 */     this.HairSpikeL3.field_78809_i = true;
/*  579 */     this.HairSpikeL3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  580 */     this.HairSpikeL3.func_78790_a(7.7F, -2.7F, 1.8F, 4, 2, 2, 0.0F);
/*  581 */     setRotateAngle(this.HairSpikeL3, 0.0F, 0.0F, 0.22759093F);
/*  582 */     this.HairSpikeLF1 = new ModelRenderer((ModelBase)this, 37, 40);
/*  583 */     this.HairSpikeLF1.field_78809_i = true;
/*  584 */     this.HairSpikeLF1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  585 */     this.HairSpikeLF1.func_78790_a(7.8F, -2.7F, -5.4F, 3, 2, 2, 0.0F);
/*  586 */     setRotateAngle(this.HairSpikeLF1, 0.0F, 0.0F, 0.4553564F);
/*  587 */     this.HairspikeB3 = new ModelRenderer((ModelBase)this, 51, 33);
/*  588 */     this.HairspikeB3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  589 */     this.HairspikeB3.func_78790_a(-0.9F, -1.9F, -13.2F, 2, 2, 3, 0.0F);
/*  590 */     setRotateAngle(this.HairspikeB3, -0.95609134F, 0.0F, 0.0F);
/*  591 */     this.HairSpikeL2 = new ModelRenderer((ModelBase)this, 13, 53);
/*  592 */     this.HairSpikeL2.field_78809_i = true;
/*  593 */     this.HairSpikeL2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  594 */     this.HairSpikeL2.func_78790_a(8.0F, -2.4F, -0.8F, 4, 2, 2, 0.0F);
/*  595 */     setRotateAngle(this.HairSpikeL2, 0.0F, 0.0F, 0.31869712F);
/*  596 */     this.SideHairL2 = new ModelRenderer((ModelBase)this, 13, 43);
/*  597 */     this.SideHairL2.field_78809_i = true;
/*  598 */     this.SideHairL2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  599 */     this.SideHairL2.func_78790_a(7.5F, -4.0F, -1.2F, 3, 6, 3, 0.0F);
/*  600 */     setRotateAngle(this.SideHairL2, 0.045553092F, 0.0F, -1.1383038F);
/*  601 */     this.FrontHairR1 = new ModelRenderer((ModelBase)this, 38, 32);
/*  602 */     this.FrontHairR1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  603 */     this.FrontHairR1.func_78790_a(-9.2F, -2.7F, -5.8F, 2, 5, 2, 0.0F);
/*  604 */     setRotateAngle(this.FrontHairR1, -0.18203785F, 0.0F, 1.1838568F);
/*  605 */     this.BackHair2 = new ModelRenderer((ModelBase)this, 50, 39);
/*  606 */     this.BackHair2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  607 */     this.BackHair2.func_78790_a(-1.5F, -10.0F, -6.8F, 3, 4, 3, 0.0F);
/*  608 */     setRotateAngle(this.BackHair2, -1.0016445F, -0.5009095F, 0.0F);
/*  609 */     this.SideHairR3 = new ModelRenderer((ModelBase)this, 26, 43);
/*  610 */     this.SideHairR3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  611 */     this.SideHairR3.func_78790_a(-10.9F, -4.3F, 1.3F, 3, 5, 3, 0.0F);
/*  612 */     setRotateAngle(this.SideHairR3, 0.089186326F, 0.0F, 1.1383038F);
/*  613 */     this.SideHairR2 = new ModelRenderer((ModelBase)this, 13, 43);
/*  614 */     this.SideHairR2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  615 */     this.SideHairR2.func_78790_a(-10.5F, -4.0F, -1.2F, 3, 6, 3, 0.0F);
/*  616 */     setRotateAngle(this.SideHairR2, 0.045553092F, 0.0F, 1.1383038F);
/*  617 */     this.HairSpikeR1 = new ModelRenderer((ModelBase)this, 0, 54);
/*  618 */     this.HairSpikeR1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  619 */     this.HairSpikeR1.func_78790_a(-12.2F, -0.7F, -3.2F, 4, 2, 2, 0.0F);
/*  620 */     setRotateAngle(this.HairSpikeR1, 0.0F, 0.0F, -0.31869712F);
/*  621 */     this.BackHair1 = new ModelRenderer((ModelBase)this, 49, 53);
/*  622 */     this.BackHair1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  623 */     this.BackHair1.func_78790_a(-1.5F, -10.2F, -7.4F, 3, 4, 4, 0.0F);
/*  624 */     setRotateAngle(this.BackHair1, -1.0016445F, 0.0F, 0.0F);
/*  625 */     this.BackHair1.func_78792_a(this.HairspikeB1);
/*  626 */     this.FrontHairR1.func_78792_a(this.HairSpikeRF1);
/*  627 */     this.BackHair2.func_78792_a(this.HairspikeB2);
/*  628 */     this.Hair.func_78792_a(this.SideHairR1);
/*  629 */     this.Hair.func_78792_a(this.BackHair3);
/*  630 */     this.SideHairR2.func_78792_a(this.HairSpikeR2);
/*  631 */     this.SideHairR3.func_78792_a(this.HairSpikeR3);
/*  632 */     this.Hair.func_78792_a(this.FrontHair1);
/*  633 */     this.SideHairL1.func_78792_a(this.HairSpikeL1);
/*  634 */     this.Hair.func_78792_a(this.FrontHair2);
/*  635 */     this.SideHairL3.func_78792_a(this.HairSpikeL3);
/*  636 */     this.FrontHairL1.func_78792_a(this.HairSpikeLF1);
/*  637 */     this.BackHair3.func_78792_a(this.HairspikeB3);
/*  638 */     this.SideHairL2.func_78792_a(this.HairSpikeL2);
/*  639 */     this.Hair.func_78792_a(this.FrontHairR1);
/*  640 */     this.Hair.func_78792_a(this.BackHair2);
/*  641 */     this.Hair.func_78792_a(this.SideHairR2);
/*  642 */     this.SideHairR1.func_78792_a(this.HairSpikeR1);
/*  643 */     this.Hair.func_78792_a(this.BackHair1);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  702 */     this.halo = new ModelRenderer((ModelBase)this, 0, 40);
/*  703 */     this.halo.func_78789_a(-0.0F, -0.0F, -0.0F, 0, 0, 0);
/*  704 */     this.halo.func_78793_a(0.0F, 0.0F, 0.0F);
/*  705 */     setRotation(this.halo, 0.0F, 0.0F, 0.0F);
/*  706 */     this.halo1 = new ModelRenderer((ModelBase)this, 0, 40);
/*  707 */     this.halo1.func_78789_a(-4.0F, -13.0F, -5.0F, 9, 1, 1);
/*  708 */     this.halo1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  709 */     setRotation(this.halo1, 0.0F, 0.0F, 0.0F);
/*  710 */     this.halo2 = new ModelRenderer((ModelBase)this, 0, 40);
/*  711 */     this.halo2.func_78789_a(-5.0F, -13.0F, -5.0F, 1, 1, 9);
/*  712 */     this.halo2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  713 */     setRotation(this.halo2, 0.0F, 0.0F, 0.0F);
/*  714 */     this.halo3 = new ModelRenderer((ModelBase)this, 0, 40);
/*  715 */     this.halo3.func_78789_a(4.0F, -13.0F, -4.0F, 1, 1, 9);
/*  716 */     this.halo3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  717 */     setRotation(this.halo3, 0.0F, 0.0F, 0.0F);
/*  718 */     this.halo4 = new ModelRenderer((ModelBase)this, 0, 40);
/*  719 */     this.halo4.func_78789_a(-5.0F, -13.0F, 4.0F, 9, 1, 1);
/*  720 */     this.halo4.func_78793_a(0.0F, 0.0F, 0.0F);
/*  721 */     setRotation(this.halo4, 0.0F, 0.0F, 0.0F);
/*  722 */     this.halo.func_78792_a(this.halo1);
/*  723 */     this.halo.func_78792_a(this.halo2);
/*  724 */     this.halo.func_78792_a(this.halo3);
/*  725 */     this.halo.func_78792_a(this.halo4);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  730 */     this.bipedHeadAll = new ModelRenderer((ModelBase)this, 0, 0);
/*  731 */     this.bipedHeadAll.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.01F);
/*  732 */     this.bipedHeadAll.func_78793_a(0.0F, 0.0F, 0.0F);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  738 */     this.bipedHeadg.func_78792_a(this.bipedHeadAll);
/*  739 */     this.bipedHeadg.func_78792_a(this.goku1);
/*  740 */     this.bipedHeadg.func_78792_a(this.goku2);
/*  741 */     this.bipedHeadg.func_78792_a(this.goku3);
/*  742 */     this.bipedHeadg.func_78792_a(this.goku4);
/*  743 */     this.bipedHeadg.func_78792_a(this.goku5);
/*  744 */     this.bipedHeadg.func_78792_a(this.goku6);
/*  745 */     this.bipedHeadg.func_78792_a(this.goku7);
/*  746 */     this.bipedHeadg.func_78792_a(this.goku8);
/*  747 */     this.bipedHeadg.func_78792_a(this.goku9);
/*  748 */     this.bipedHeadg.func_78792_a(this.goku10);
/*  749 */     this.bipedHeadg.func_78792_a(this.goku11);
/*  750 */     this.bipedHeadg.func_78792_a(this.goku12);
/*  751 */     this.bipedHeadg.func_78792_a(this.goku13);
/*  752 */     this.bipedHeadg.func_78792_a(this.goku14);
/*  753 */     this.bipedHeadg.func_78792_a(this.goku15);
/*  754 */     this.bipedHeadg.func_78792_a(this.goku16);
/*      */ 
/*      */     
/*  757 */     this.bipedHeadt.func_78792_a(this.bipedHeadAll);
/*  758 */     this.bipedHeadt.func_78792_a(this.trunk1);
/*  759 */     this.bipedHeadt.func_78792_a(this.trunk2);
/*  760 */     this.bipedHeadt.func_78792_a(this.trunk3);
/*  761 */     this.bipedHeadt.func_78792_a(this.trunk4);
/*  762 */     this.bipedHeadt.func_78792_a(this.trunk5);
/*  763 */     this.bipedHeadt.func_78792_a(this.trunk6);
/*  764 */     this.bipedHeadt.func_78792_a(this.trunk7);
/*  765 */     this.bipedHeadt.func_78792_a(this.trunk8);
/*  766 */     this.bipedHeadt.func_78792_a(this.trunk9);
/*      */ 
/*      */     
/*  769 */     this.bipedHeadt2.func_78792_a(this.bipedHeadAll);
/*  770 */     this.bipedHeadt2.func_78792_a(this.SideHairL1);
/*  771 */     this.bipedHeadt2.func_78792_a(this.SideHairL3);
/*  772 */     this.bipedHeadt2.func_78792_a(this.FrontHairL1);
/*  773 */     this.bipedHeadt2.func_78792_a(this.Hair);
/*  774 */     this.bipedHeadt2.func_78792_a(this.SideHairL2);
/*  775 */     this.bipedHeadt2.func_78792_a(this.SideHairR3);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  787 */     this.bipedHeadv.func_78792_a(this.bipedHeadAll);
/*  788 */     this.bipedHeadv.func_78792_a(this.vegeta1);
/*  789 */     this.bipedHeadv.func_78792_a(this.vegeta2);
/*  790 */     this.bipedHeadv.func_78792_a(this.vegeta3);
/*  791 */     this.bipedHeadv.func_78792_a(this.vegeta4);
/*  792 */     this.bipedHeadv.func_78792_a(this.vegeta5);
/*  793 */     this.bipedHeadv.func_78792_a(this.vegeta6);
/*  794 */     this.bipedHeadv.func_78792_a(this.vegeta7);
/*  795 */     this.bipedHeadv.func_78792_a(this.vegeta8);
/*  796 */     this.bipedHeadv.func_78792_a(this.vegeta9);
/*  797 */     this.bipedHeadv.func_78792_a(this.vegeta10);
/*  798 */     this.bipedHeadv.func_78792_a(this.vegeta11);
/*  799 */     this.bipedHeadv.func_78792_a(this.vegeta12);
/*  800 */     this.bipedHeadv.func_78792_a(this.vegeta13);
/*  801 */     this.bipedHeadv.func_78792_a(this.vegeta14);
/*  802 */     this.bipedHeadv.func_78792_a(this.vegeta15);
/*  803 */     this.bipedHeadv.func_78792_a(this.vegeta16);
/*  804 */     this.bipedHeadv.func_78792_a(this.vegeta17);
/*  805 */     this.bipedHeadv.func_78792_a(this.vegeta18);
/*  806 */     this.bipedHeadv.func_78792_a(this.vegeta19);
/*  807 */     this.bipedHeadv.func_78792_a(this.vegeta20);
/*  808 */     this.bipedHeadv.func_78792_a(this.vegeta21);
/*  809 */     this.bipedHeadv.func_78792_a(this.vegeta22);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  814 */     this.bipedHeadb.func_78792_a(this.bipedHeadAll);
/*  815 */     this.bipedHeadb.func_78792_a(this.goku12);
/*  816 */     this.bipedHeadb.func_78792_a(this.goku13);
/*  817 */     this.bipedHeadb.func_78792_a(this.goku14);
/*  818 */     this.bipedHeadb.func_78792_a(this.goku15);
/*  819 */     this.bipedHeadb.func_78792_a(this.goku16);
/*      */     
/*  821 */     this.bipedHeadb.func_78792_a(this.vegeta1);
/*  822 */     this.bipedHeadb.func_78792_a(this.vegeta2);
/*  823 */     this.bipedHeadb.func_78792_a(this.vegeta3);
/*  824 */     this.bipedHeadb.func_78792_a(this.vegeta4);
/*  825 */     this.bipedHeadb.func_78792_a(this.vegeta5);
/*  826 */     this.bipedHeadb.func_78792_a(this.vegeta6);
/*  827 */     this.bipedHeadb.func_78792_a(this.vegeta7);
/*  828 */     this.bipedHeadb.func_78792_a(this.vegeta8);
/*  829 */     this.bipedHeadb.func_78792_a(this.vegeta9);
/*  830 */     this.bipedHeadb.func_78792_a(this.vegeta10);
/*  831 */     this.bipedHeadb.func_78792_a(this.vegeta11);
/*  832 */     this.bipedHeadb.func_78792_a(this.vegeta12);
/*  833 */     this.bipedHeadb.func_78792_a(this.vegeta13);
/*  834 */     this.bipedHeadb.func_78792_a(this.vegeta14);
/*  835 */     this.bipedHeadb.func_78792_a(this.vegeta15);
/*  836 */     this.bipedHeadb.func_78792_a(this.vegeta16);
/*  837 */     this.bipedHeadb.func_78792_a(this.vegeta17);
/*  838 */     this.bipedHeadb.func_78792_a(this.vegeta18);
/*  839 */     this.bipedHeadb.func_78792_a(this.vegeta19);
/*  840 */     this.bipedHeadb.func_78792_a(this.vegeta20);
/*  841 */     this.bipedHeadb.func_78792_a(this.vegeta21);
/*  842 */     this.bipedHeadb.func_78792_a(this.vegeta22);
/*      */ 
/*      */ 
/*      */     
/*  846 */     this.bipedHeadgh.func_78792_a(this.bipedHeadAll);
/*  847 */     this.bipedHeadgh.func_78792_a(this.gohan1);
/*  848 */     this.bipedHeadgh.func_78792_a(this.gohan7);
/*  849 */     this.bipedHeadgh.func_78792_a(this.gohan8);
/*  850 */     this.bipedHeadgh.func_78792_a(this.gohan10);
/*  851 */     this.bipedHeadgh.func_78792_a(this.gohan11);
/*  852 */     this.bipedHeadgh.func_78792_a(this.gohan12);
/*  853 */     this.bipedHeadgh.func_78792_a(this.gohan13);
/*  854 */     this.bipedHeadgh.func_78792_a(this.gohan14);
/*  855 */     this.bipedHeadgh.func_78792_a(this.gohan15);
/*  856 */     this.bipedHeadgh.func_78792_a(this.gohan16);
/*  857 */     this.bipedHeadgh.func_78792_a(this.gohan17);
/*  858 */     this.bipedHeadgh.func_78792_a(this.gohan18);
/*  859 */     this.bipedHeadgh.func_78792_a(this.gohan19);
/*  860 */     this.bipedHeadgh.func_78792_a(this.gohan20);
/*  861 */     this.bipedHeadgh.func_78792_a(this.gohan21);
/*  862 */     this.bipedHeadgh.func_78792_a(this.gohan22);
/*  863 */     this.bipedHeadgh.func_78792_a(this.gohan26);
/*      */ 
/*      */     
/*  866 */     this.head.func_78792_a(this.bipedHeadg);
/*  867 */     this.head.func_78792_a(this.bipedHeadt);
/*  868 */     this.head.func_78792_a(this.bipedHeadgh);
/*  869 */     this.head.func_78792_a(this.bipedHeadv);
/*  870 */     this.head.func_78792_a(this.bipedHeadb);
/*  871 */     this.head.func_78792_a(this.bipedHeadt2);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/*  877 */     model.field_78795_f = x;
/*  878 */     model.field_78796_g = y;
/*  879 */     model.field_78808_h = z;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  885 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*  886 */     GL11.glPushMatrix();
/*  887 */     GL11.glScalef(this.F, this.F, this.F);
/*  888 */     GL11.glTranslatef(0.0F, (this.F - 1.0F) * -0.74F, 0.0F);
/*      */ 
/*      */     
/*  891 */     switch (this.t) { case 0:
/*  892 */         this.bipedHeadg.func_78785_a(f5); break;
/*  893 */       case 1: this.bipedHeadgh.func_78785_a(f5); break;
/*  894 */       case 2: this.bipedHeadt.func_78785_a(f5); break;
/*  895 */       case 3: this.bipedHeadv.func_78785_a(f5); break;
/*  896 */       case 4: this.bipedHeadb.func_78785_a(f5); break;
/*  897 */       case 5: this.bipedHeadt2.func_78785_a(f5);
/*      */         break; }
/*      */     
/*  900 */     this.body.func_78785_a(f5);
/*  901 */     this.rightarm.func_78785_a(f5);
/*  902 */     this.leftarm.func_78785_a(f5);
/*  903 */     this.rightleg.func_78785_a(f5);
/*  904 */     this.leftleg.func_78785_a(f5);
/*  905 */     if (entity instanceof EntityMasterJin) renderHalo(0.0625F); 
/*  906 */     GL11.glPopMatrix();
/*      */   }
/*      */ 
/*      */   
/*  910 */   public static float f = 1.0F;
/*  911 */   public static int g = 1;
/*      */ 
/*      */   
/*      */   public void renderHalo(float par1) {
/*  915 */     float f6 = f;
/*  916 */     GL11.glPushMatrix();
/*  917 */     GL11.glScalef((0.5F + 0.5F / f6) * ((g <= 1) ? 1.0F : 0.85F), 0.5F + 0.5F / f6, (0.5F + 0.5F / f6) * ((g <= 1) ? 1.0F : 0.85F));
/*  918 */     GL11.glTranslatef(0.0F, (f6 - 1.0F) / f6 * (2.0F - ((f6 >= 1.5F && f6 <= 2.0F) ? ((2.0F - f6) / 2.5F) : ((f6 < 1.5F && f6 >= 1.0F) ? ((f6 * 2.0F - 2.0F) * 0.2F) : 0.0F))), 0.0F);
/*  919 */     this.halo.field_78796_g = this.bipedHeadt.field_78796_g;
/*  920 */     this.halo.field_78795_f = this.bipedHeadt.field_78795_f;
/*  921 */     this.halo.field_78800_c = this.bipedHeadt.field_78800_c;
/*  922 */     this.halo.field_78797_d = this.bipedHeadt.field_78797_d;
/*  923 */     this.halo.func_78785_a(par1);
/*  924 */     GL11.glPopMatrix();
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/*  929 */     ModelRenderer hr = null;
/*  930 */     switch (this.t) { case 0:
/*  931 */         hr = this.bipedHeadg; break;
/*  932 */       case 1: hr = this.bipedHeadgh; break;
/*  933 */       case 2: hr = this.bipedHeadt; break;
/*  934 */       case 3: hr = this.bipedHeadv; break;
/*  935 */       case 4: hr = this.bipedHeadb; break;
/*  936 */       case 5: hr = this.bipedHeadt2;
/*      */         break; }
/*      */     
/*  939 */     hr.field_78796_g = par4 / 57.295776F;
/*  940 */     hr.field_78795_f = par5 / 57.295776F;
/*      */     
/*  942 */     this.rightarm.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 2.0F * par2 * 0.5F;
/*  943 */     this.leftarm.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F) * 2.0F * par2 * 0.5F;
/*  944 */     this.rightarm.field_78808_h = 0.0F;
/*  945 */     this.leftarm.field_78808_h = 0.0F;
/*  946 */     this.rightleg.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F) * 1.4F * par2;
/*  947 */     this.leftleg.field_78795_f = MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.4F * par2;
/*  948 */     this.rightleg.field_78796_g = 0.0F;
/*  949 */     this.leftleg.field_78796_g = 0.0F;
/*      */     
/*  951 */     if (this.field_78093_q) {
/*      */       
/*  953 */       this.rightarm.field_78795_f += -0.62831855F;
/*  954 */       this.leftarm.field_78795_f += -0.62831855F;
/*  955 */       this.rightleg.field_78795_f = -1.2566371F;
/*  956 */       this.leftleg.field_78795_f = -1.2566371F;
/*  957 */       this.rightleg.field_78796_g = 0.31415927F;
/*  958 */       this.leftleg.field_78796_g = -0.31415927F;
/*      */     } 
/*      */     
/*  961 */     this.rightarm.field_78796_g = 0.0F;
/*  962 */     this.leftarm.field_78796_g = 0.0F;
/*      */ 
/*      */ 
/*      */     
/*  966 */     if (this.field_78095_p > -9990.0F) {
/*      */       
/*  968 */       float var8 = this.field_78095_p;
/*  969 */       this.body.field_78796_g = MathHelper.func_76126_a(MathHelper.func_76129_c(var8) * 3.1415927F * 2.0F) * 0.2F;
/*  970 */       this.rightarm.field_78798_e = MathHelper.func_76126_a(this.body.field_78796_g) * 5.0F;
/*  971 */       this.rightarm.field_78800_c = -MathHelper.func_76134_b(this.body.field_78796_g) * 5.0F;
/*  972 */       this.leftarm.field_78798_e = -MathHelper.func_76126_a(this.body.field_78796_g) * 5.0F;
/*  973 */       this.leftarm.field_78800_c = MathHelper.func_76134_b(this.body.field_78796_g) * 5.0F;
/*  974 */       this.rightarm.field_78796_g += this.body.field_78796_g;
/*  975 */       this.leftarm.field_78796_g += this.body.field_78796_g;
/*  976 */       this.leftarm.field_78795_f += this.body.field_78796_g;
/*  977 */       var8 = 1.0F - this.field_78095_p;
/*  978 */       var8 *= var8;
/*  979 */       var8 *= var8;
/*  980 */       var8 = 1.0F - var8;
/*  981 */       float var9 = MathHelper.func_76126_a(var8 * 3.1415927F);
/*  982 */       float var10 = MathHelper.func_76126_a(this.field_78095_p * 3.1415927F) * -(this.head.field_78795_f - 0.7F) * 0.75F;
/*  983 */       this.rightarm.field_78795_f = (float)(this.rightarm.field_78795_f - var9 * 1.2D + var10);
/*  984 */       this.rightarm.field_78796_g += this.body.field_78796_g * 2.0F;
/*  985 */       this.rightarm.field_78808_h = MathHelper.func_76126_a(this.field_78095_p * 3.1415927F) * -0.4F;
/*      */     } 
/*      */ 
/*      */     
/*  989 */     this.rightarm.field_78808_h += MathHelper.func_76134_b(par3 * 0.09F) * 0.05F + 0.05F;
/*  990 */     this.leftarm.field_78808_h -= MathHelper.func_76134_b(par3 * 0.09F) * 0.05F + 0.05F;
/*  991 */     this.rightarm.field_78795_f += MathHelper.func_76126_a(par3 * 0.067F) * 0.05F;
/*  992 */     this.leftarm.field_78795_f -= MathHelper.func_76126_a(par3 * 0.067F) * 0.05F;
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
/*      */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 1010 */     modelRenderer.field_78795_f = x;
/* 1011 */     modelRenderer.field_78796_g = y;
/* 1012 */     modelRenderer.field_78808_h = z;
/*      */   }
/*      */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\ModelDBCZed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */