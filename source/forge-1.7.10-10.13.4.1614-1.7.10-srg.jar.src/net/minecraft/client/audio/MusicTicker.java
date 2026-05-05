/*    */ package net.minecraft.client.audio;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.Random;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.server.gui.IUpdatePlayerListBox;
/*    */ import net.minecraft.util.MathHelper;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class MusicTicker
/*    */   implements IUpdatePlayerListBox {
/* 14 */   private final Random field_147679_a = new Random();
/*    */   private final Minecraft field_147677_b;
/*    */   private ISound field_147678_c;
/* 17 */   private int field_147676_d = 100;
/*    */   
/*    */   public MusicTicker(Minecraft p_i45112_1_) {
/* 20 */     this.field_147677_b = p_i45112_1_;
/*    */   }
/*    */   private static final String __OBFID = "CL_00001138";
/*    */   
/*    */   public void func_73660_a() {
/* 25 */     MusicType musicType = this.field_147677_b.func_147109_W();
/*    */     
/* 27 */     if (this.field_147678_c != null) {
/* 28 */       if (!musicType.func_148635_a().equals(this.field_147678_c.func_147650_b())) {
/* 29 */         this.field_147677_b.func_147118_V().func_147683_b(this.field_147678_c);
/* 30 */         this.field_147676_d = MathHelper.func_76136_a(this.field_147679_a, 0, musicType.func_148634_b() / 2);
/*    */       } 
/*    */       
/* 33 */       if (!this.field_147677_b.func_147118_V().func_147692_c(this.field_147678_c)) {
/* 34 */         this.field_147678_c = null;
/* 35 */         this.field_147676_d = Math.min(MathHelper.func_76136_a(this.field_147679_a, musicType.func_148634_b(), musicType.func_148633_c()), this.field_147676_d);
/*    */       } 
/*    */     } 
/*    */     
/* 39 */     if (this.field_147678_c == null && this.field_147676_d-- <= 0) {
/* 40 */       this.field_147678_c = PositionedSoundRecord.func_147673_a(musicType.func_148635_a());
/* 41 */       this.field_147677_b.func_147118_V().func_147682_a(this.field_147678_c);
/* 42 */       this.field_147676_d = Integer.MAX_VALUE;
/*    */     } 
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/* 47 */   public enum MusicType { MENU((String)new ResourceLocation("minecraft:music.menu"), 20, 600),
/* 48 */     GAME((String)new ResourceLocation("minecraft:music.game"), 12000, 24000),
/* 49 */     CREATIVE((String)new ResourceLocation("minecraft:music.game.creative"), 1200, 3600),
/* 50 */     CREDITS((String)new ResourceLocation("minecraft:music.game.end.credits"), 2147483647, 2147483647),
/* 51 */     NETHER((String)new ResourceLocation("minecraft:music.game.nether"), 1200, 3600),
/* 52 */     END_BOSS((String)new ResourceLocation("minecraft:music.game.end.dragon"), 0, 0),
/* 53 */     END((String)new ResourceLocation("minecraft:music.game.end"), 6000, 24000);
/*    */     private final ResourceLocation field_148645_h;
/*    */     private final int field_148646_i;
/*    */     private final int field_148643_j;
/*    */     private static final String __OBFID = "CL_00001139";
/*    */     
/*    */     MusicType(ResourceLocation p_i45111_3_, int p_i45111_4_, int p_i45111_5_) {
/* 60 */       this.field_148645_h = p_i45111_3_;
/* 61 */       this.field_148646_i = p_i45111_4_;
/* 62 */       this.field_148643_j = p_i45111_5_;
/*    */     }
/*    */     
/*    */     public ResourceLocation func_148635_a() {
/* 66 */       return this.field_148645_h;
/*    */     }
/*    */     
/*    */     public int func_148634_b() {
/* 70 */       return this.field_148646_i;
/*    */     }
/*    */     
/*    */     public int func_148633_c() {
/* 74 */       return this.field_148643_j;
/*    */     } }
/*    */ 
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\audio\MusicTicker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */