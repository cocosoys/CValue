/*     */ package net.minecraft.util;
/*     */ 
/*     */ import com.google.common.base.Function;
/*     */ import com.google.common.collect.Iterators;
/*     */ import com.google.common.collect.Lists;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ public abstract class ChatComponentStyle implements IChatComponent {
/*  12 */   protected List field_150264_a = Lists.newArrayList();
/*     */   private ChatStyle field_150263_b;
/*     */   private static final String __OBFID = "CL_00001257";
/*     */   
/*     */   public IChatComponent func_150257_a(IChatComponent p_150257_1_) {
/*  17 */     p_150257_1_.func_150256_b().func_150221_a(func_150256_b());
/*  18 */     this.field_150264_a.add(p_150257_1_);
/*  19 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public List func_150253_a() {
/*  24 */     return this.field_150264_a;
/*     */   }
/*     */ 
/*     */   
/*     */   public IChatComponent func_150258_a(String p_150258_1_) {
/*  29 */     return func_150257_a(new ChatComponentText(p_150258_1_));
/*     */   }
/*     */ 
/*     */   
/*     */   public IChatComponent func_150255_a(ChatStyle p_150255_1_) {
/*  34 */     this.field_150263_b = p_150255_1_;
/*     */     
/*  36 */     for (IChatComponent iChatComponent : this.field_150264_a) {
/*  37 */       iChatComponent.func_150256_b().func_150221_a(func_150256_b());
/*     */     }
/*     */     
/*  40 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public ChatStyle func_150256_b() {
/*  45 */     if (this.field_150263_b == null) {
/*  46 */       this.field_150263_b = new ChatStyle();
/*  47 */       for (IChatComponent iChatComponent : this.field_150264_a) {
/*  48 */         iChatComponent.func_150256_b().func_150221_a(this.field_150263_b);
/*     */       }
/*     */     } 
/*  51 */     return this.field_150263_b;
/*     */   }
/*     */ 
/*     */   
/*     */   public Iterator iterator() {
/*  56 */     return Iterators.concat((Iterator)Iterators.forArray((Object[])new ChatComponentStyle[] { this }, ), func_150262_a(this.field_150264_a));
/*     */   }
/*     */ 
/*     */   
/*     */   public final String func_150260_c() {
/*  61 */     StringBuilder stringBuilder = new StringBuilder();
/*     */     
/*  63 */     for (IChatComponent iChatComponent : this) {
/*  64 */       stringBuilder.append(iChatComponent.func_150261_e());
/*     */     }
/*     */     
/*  67 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public final String func_150254_d() {
/*  72 */     StringBuilder stringBuilder = new StringBuilder();
/*     */     
/*  74 */     for (IChatComponent iChatComponent : this) {
/*  75 */       stringBuilder.append(iChatComponent.func_150256_b().func_150218_j());
/*  76 */       stringBuilder.append(iChatComponent.func_150261_e());
/*  77 */       stringBuilder.append(EnumChatFormatting.RESET);
/*     */     } 
/*     */     
/*  80 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   public static Iterator func_150262_a(Iterable p_150262_0_) {
/*  84 */     Iterator iterator = Iterators.concat(Iterators.transform(p_150262_0_.iterator(), new Function()
/*     */           {
/*     */             public Iterator apply(IChatComponent p_apply_1_) {
/*  87 */               return p_apply_1_.iterator();
/*     */             } private static final String __OBFID = "CL_00001258";
/*     */           }));
/*  90 */     iterator = Iterators.transform(iterator, new Function() { private static final String __OBFID = "CL_00001259";
/*     */           
/*     */           public IChatComponent apply(IChatComponent p_apply_1_) {
/*  93 */             IChatComponent iChatComponent = p_apply_1_.func_150259_f();
/*  94 */             iChatComponent.func_150255_a(iChatComponent.func_150256_b().func_150206_m());
/*  95 */             return iChatComponent;
/*     */           } }
/*     */       );
/*  98 */     return iterator;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object p_equals_1_) {
/* 103 */     if (this == p_equals_1_) return true;
/*     */     
/* 105 */     if (p_equals_1_ instanceof ChatComponentStyle) {
/* 106 */       ChatComponentStyle chatComponentStyle = (ChatComponentStyle)p_equals_1_;
/* 107 */       return (this.field_150264_a.equals(chatComponentStyle.field_150264_a) && func_150256_b().equals(chatComponentStyle.func_150256_b()));
/*     */     } 
/*     */     
/* 110 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 115 */     return 31 * this.field_150263_b.hashCode() + this.field_150264_a.hashCode();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 120 */     return "BaseComponent{style=" + this.field_150263_b + ", siblings=" + this.field_150264_a + '}';
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraf\\util\ChatComponentStyle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */