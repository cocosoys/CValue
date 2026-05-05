/*    */ package net.minecraft.client.audio;
/*    */ 
/*    */ import com.google.common.collect.Lists;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.List;
/*    */ import java.util.Random;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class SoundEventAccessorComposite implements ISoundEventAccessor {
/* 12 */   private final List field_148736_a = Lists.newArrayList();
/*    */   
/* 14 */   private final Random field_148734_b = new Random();
/*    */   private final ResourceLocation field_148735_c;
/*    */   private final SoundCategory field_148732_d;
/*    */   private double field_148733_e;
/*    */   private double field_148731_f;
/*    */   private static final String __OBFID = "CL_00001146";
/*    */   
/*    */   public SoundEventAccessorComposite(ResourceLocation p_i45120_1_, double p_i45120_2_, double p_i45120_4_, SoundCategory p_i45120_6_) {
/* 22 */     this.field_148735_c = p_i45120_1_;
/* 23 */     this.field_148731_f = p_i45120_4_;
/* 24 */     this.field_148733_e = p_i45120_2_;
/* 25 */     this.field_148732_d = p_i45120_6_;
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_148721_a() {
/* 30 */     int i = 0;
/* 31 */     for (ISoundEventAccessor iSoundEventAccessor : this.field_148736_a) {
/* 32 */       i += iSoundEventAccessor.func_148721_a();
/*    */     }
/* 34 */     return i;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public SoundPoolEntry func_148720_g() {
/* 40 */     int i = func_148721_a();
/*    */     
/* 42 */     if (this.field_148736_a.isEmpty() || i == 0) return SoundHandler.field_147700_a;
/*    */     
/* 44 */     int j = this.field_148734_b.nextInt(i);
/* 45 */     for (ISoundEventAccessor iSoundEventAccessor : this.field_148736_a) {
/* 46 */       j -= iSoundEventAccessor.func_148721_a();
/*    */       
/* 48 */       if (j < 0) {
/* 49 */         SoundPoolEntry soundPoolEntry = (SoundPoolEntry)iSoundEventAccessor.func_148720_g();
/*    */ 
/*    */         
/* 52 */         soundPoolEntry.func_148651_a(soundPoolEntry.func_148650_b() * this.field_148733_e);
/* 53 */         soundPoolEntry.func_148647_b(soundPoolEntry.func_148649_c() * this.field_148731_f);
/*    */         
/* 55 */         return soundPoolEntry;
/*    */       } 
/*    */     } 
/*    */     
/* 59 */     return SoundHandler.field_147700_a;
/*    */   }
/*    */   
/*    */   public void func_148727_a(ISoundEventAccessor p_148727_1_) {
/* 63 */     this.field_148736_a.add(p_148727_1_);
/*    */   }
/*    */   
/*    */   public ResourceLocation func_148729_c() {
/* 67 */     return this.field_148735_c;
/*    */   }
/*    */   
/*    */   public SoundCategory func_148728_d() {
/* 71 */     return this.field_148732_d;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\audio\SoundEventAccessorComposite.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */