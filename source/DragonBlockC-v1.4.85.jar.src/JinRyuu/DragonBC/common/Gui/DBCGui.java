/*    */ package JinRyuu.DragonBC.common.Gui;
/*    */ 
/*    */ import JinRyuu.DragonBC.common.Render.SpacePod01TileEntity;
/*    */ import net.minecraft.client.gui.inventory.GuiContainer;
/*    */ import net.minecraft.entity.player.InventoryPlayer;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraft.util.StatCollector;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DBCGui
/*    */   extends GuiContainer
/*    */ {
/*    */   public DBCGui(InventoryPlayer inventory, SpacePod01TileEntity tile_entity) {
/* 23 */     super(null);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void func_146979_b(int i, int j) {
/* 30 */     this.field_146289_q.func_78276_b("Tutorial Gui", 6, 6, 16777215);
/* 31 */     this.field_146289_q.func_78276_b(StatCollector.func_74838_a("container.inventory"), 6, this.field_147000_g - 96, 16777215);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void func_146976_a(float f, int i, int j) {
/* 38 */     String picture = "/terrain.png";
/*    */     
/* 40 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*    */     
/* 42 */     ResourceLocation tx = new ResourceLocation(picture);
/* 43 */     this.field_146297_k.field_71446_o.func_110577_a(tx);
/*    */     
/* 45 */     int x = (this.field_146294_l - this.field_146999_f) / 2;
/*    */     
/* 47 */     int y = (this.field_146295_m - this.field_147000_g) / 2;
/*    */     
/* 49 */     func_73729_b(x, y, 0, 0, this.field_146999_f, this.field_147000_g);
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Gui\DBCGui.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */