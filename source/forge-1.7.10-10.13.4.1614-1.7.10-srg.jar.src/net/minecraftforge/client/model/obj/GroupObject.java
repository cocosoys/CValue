/*    */ package net.minecraftforge.client.model.obj;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.ArrayList;
/*    */ import net.minecraft.client.renderer.Tessellator;
/*    */ 
/*    */ 
/*    */ public class GroupObject
/*    */ {
/*    */   public String name;
/* 12 */   public ArrayList<Face> faces = new ArrayList<Face>();
/*    */   
/*    */   public int glDrawingMode;
/*    */   
/*    */   public GroupObject() {
/* 17 */     this("");
/*    */   }
/*    */ 
/*    */   
/*    */   public GroupObject(String name) {
/* 22 */     this(name, -1);
/*    */   }
/*    */ 
/*    */   
/*    */   public GroupObject(String name, int glDrawingMode) {
/* 27 */     this.name = name;
/* 28 */     this.glDrawingMode = glDrawingMode;
/*    */   }
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void render() {
/* 34 */     if (this.faces.size() > 0) {
/*    */       
/* 36 */       Tessellator tessellator = Tessellator.instance;
/* 37 */       tessellator.startDrawing(this.glDrawingMode);
/* 38 */       render(tessellator);
/* 39 */       tessellator.draw();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void render(Tessellator tessellator) {
/* 46 */     if (this.faces.size() > 0)
/*    */     {
/* 48 */       for (Face face : this.faces)
/*    */       {
/* 50 */         face.addFaceForRender(tessellator);
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\client\model\obj\GroupObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */