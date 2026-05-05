/*    */ package net.minecraft.client.audio;
/*    */ 
/*    */ import com.google.common.collect.Maps;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.Map;
/*    */ import net.minecraft.util.RegistrySimple;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class SoundRegistry extends RegistrySimple {
/*    */   private Map field_148764_a;
/*    */   
/*    */   protected Map func_148740_a() {
/* 14 */     this.field_148764_a = Maps.newHashMap();
/* 15 */     return this.field_148764_a;
/*    */   }
/*    */   private static final String __OBFID = "CL_00001151";
/*    */   public void func_148762_a(SoundEventAccessorComposite p_148762_1_) {
/* 19 */     func_82595_a(p_148762_1_.func_148729_c(), p_148762_1_);
/*    */   }
/*    */   
/*    */   public void func_148763_c() {
/* 23 */     this.field_148764_a.clear();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\audio\SoundRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */