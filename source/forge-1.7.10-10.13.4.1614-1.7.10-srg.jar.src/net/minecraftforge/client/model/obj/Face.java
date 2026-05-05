/*    */ package net.minecraftforge.client.model.obj;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.renderer.Tessellator;
/*    */ import net.minecraft.util.Vec3;
/*    */ 
/*    */ 
/*    */ public class Face
/*    */ {
/*    */   public Vertex[] vertices;
/*    */   public Vertex[] vertexNormals;
/*    */   public Vertex faceNormal;
/*    */   public TextureCoordinate[] textureCoordinates;
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void addFaceForRender(Tessellator tessellator) {
/* 18 */     addFaceForRender(tessellator, 5.0E-4F);
/*    */   }
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void addFaceForRender(Tessellator tessellator, float textureOffset) {
/* 24 */     if (this.faceNormal == null)
/*    */     {
/* 26 */       this.faceNormal = calculateFaceNormal();
/*    */     }
/*    */     
/* 29 */     tessellator.setNormal(this.faceNormal.x, this.faceNormal.y, this.faceNormal.z);
/*    */     
/* 31 */     float averageU = 0.0F;
/* 32 */     float averageV = 0.0F;
/*    */     
/* 34 */     if (this.textureCoordinates != null && this.textureCoordinates.length > 0) {
/*    */       
/* 36 */       for (int j = 0; j < this.textureCoordinates.length; j++) {
/*    */         
/* 38 */         averageU += (this.textureCoordinates[j]).u;
/* 39 */         averageV += (this.textureCoordinates[j]).v;
/*    */       } 
/*    */       
/* 42 */       averageU /= this.textureCoordinates.length;
/* 43 */       averageV /= this.textureCoordinates.length;
/*    */     } 
/*    */ 
/*    */ 
/*    */     
/* 48 */     for (int i = 0; i < this.vertices.length; i++) {
/*    */ 
/*    */       
/* 51 */       if (this.textureCoordinates != null && this.textureCoordinates.length > 0) {
/*    */         
/* 53 */         float offsetU = textureOffset;
/* 54 */         float offsetV = textureOffset;
/*    */         
/* 56 */         if ((this.textureCoordinates[i]).u > averageU)
/*    */         {
/* 58 */           offsetU = -offsetU;
/*    */         }
/* 60 */         if ((this.textureCoordinates[i]).v > averageV)
/*    */         {
/* 62 */           offsetV = -offsetV;
/*    */         }
/*    */         
/* 65 */         tessellator.addVertexWithUV((this.vertices[i]).x, (this.vertices[i]).y, (this.vertices[i]).z, ((this.textureCoordinates[i]).u + offsetU), ((this.textureCoordinates[i]).v + offsetV));
/*    */       }
/*    */       else {
/*    */         
/* 69 */         tessellator.addVertex((this.vertices[i]).x, (this.vertices[i]).y, (this.vertices[i]).z);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public Vertex calculateFaceNormal() {
/* 76 */     Vec3 v1 = Vec3.createVectorHelper(((this.vertices[1]).x - (this.vertices[0]).x), ((this.vertices[1]).y - (this.vertices[0]).y), ((this.vertices[1]).z - (this.vertices[0]).z));
/* 77 */     Vec3 v2 = Vec3.createVectorHelper(((this.vertices[2]).x - (this.vertices[0]).x), ((this.vertices[2]).y - (this.vertices[0]).y), ((this.vertices[2]).z - (this.vertices[0]).z));
/* 78 */     Vec3 normalVector = null;
/*    */     
/* 80 */     normalVector = v1.crossProduct(v2).normalize();
/*    */     
/* 82 */     return new Vertex((float)normalVector.xCoord, (float)normalVector.yCoord, (float)normalVector.zCoord);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\client\model\obj\Face.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */