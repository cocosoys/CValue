/*     */ package net.minecraft.client.audio;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class SoundList {
/*   8 */   private final List field_148577_a = Lists.newArrayList(); private boolean field_148575_b;
/*     */   private SoundCategory field_148576_c;
/*     */   private static final String __OBFID = "CL_00001121";
/*     */   
/*     */   public List func_148570_a() {
/*  13 */     return this.field_148577_a;
/*     */   }
/*     */   
/*     */   public boolean func_148574_b() {
/*  17 */     return this.field_148575_b;
/*     */   }
/*     */   
/*     */   public void func_148572_a(boolean p_148572_1_) {
/*  21 */     this.field_148575_b = p_148572_1_;
/*     */   }
/*     */   
/*     */   public SoundCategory func_148573_c() {
/*  25 */     return this.field_148576_c;
/*     */   }
/*     */   
/*     */   public void func_148571_a(SoundCategory p_148571_1_) {
/*  29 */     this.field_148576_c = p_148571_1_;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public static class SoundEntry { private String field_148569_a;
/*  34 */     private float field_148567_b = 1.0F;
/*  35 */     private float field_148568_c = 1.0F;
/*  36 */     private int field_148565_d = 1;
/*  37 */     private Type field_148566_e = Type.FILE; private boolean field_148564_f = false;
/*     */     private static final String __OBFID = "CL_00001122";
/*     */     
/*     */     public String func_148556_a() {
/*  41 */       return this.field_148569_a;
/*     */     }
/*     */     
/*     */     public void func_148561_a(String p_148561_1_) {
/*  45 */       this.field_148569_a = p_148561_1_;
/*     */     }
/*     */     
/*     */     public float func_148558_b() {
/*  49 */       return this.field_148567_b;
/*     */     }
/*     */     
/*     */     public void func_148553_a(float p_148553_1_) {
/*  53 */       this.field_148567_b = p_148553_1_;
/*     */     }
/*     */     
/*     */     public float func_148560_c() {
/*  57 */       return this.field_148568_c;
/*     */     }
/*     */     
/*     */     public void func_148559_b(float p_148559_1_) {
/*  61 */       this.field_148568_c = p_148559_1_;
/*     */     }
/*     */     
/*     */     public int func_148555_d() {
/*  65 */       return this.field_148565_d;
/*     */     }
/*     */     
/*     */     public void func_148554_a(int p_148554_1_) {
/*  69 */       this.field_148565_d = p_148554_1_;
/*     */     }
/*     */     
/*     */     public Type func_148563_e() {
/*  73 */       return this.field_148566_e;
/*     */     }
/*     */     
/*     */     public void func_148562_a(Type p_148562_1_) {
/*  77 */       this.field_148566_e = p_148562_1_;
/*     */     }
/*     */     
/*     */     public boolean func_148552_f() {
/*  81 */       return this.field_148564_f;
/*     */     }
/*     */     
/*     */     public void func_148557_a(boolean p_148557_1_) {
/*  85 */       this.field_148564_f = p_148557_1_;
/*     */     }
/*     */     
/*     */     @SideOnly(Side.CLIENT)
/*  89 */     public enum Type { FILE("file"),
/*  90 */       SOUND_EVENT("event");
/*     */       private final String field_148583_c;
/*     */       private static final String __OBFID = "CL_00001123";
/*     */       
/*     */       Type(String p_i45109_3_) {
/*  95 */         this.field_148583_c = p_i45109_3_;
/*     */       }
/*     */       
/*     */       public static Type func_148580_a(String p_148580_0_) {
/*  99 */         for (Type type : values()) {
/* 100 */           if (type.field_148583_c.equals(p_148580_0_)) return type; 
/*     */         } 
/* 102 */         return null;
/*     */       } }
/*     */      }
/*     */ 
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\audio\SoundList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */