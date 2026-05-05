/*     */ package net.minecraftforge.client.model.techne;
/*     */ 
/*     */ import cpw.mods.fml.common.FMLLog;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.awt.Dimension;
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.zip.ZipEntry;
/*     */ import java.util.zip.ZipException;
/*     */ import java.util.zip.ZipInputStream;
/*     */ import javax.xml.parsers.DocumentBuilder;
/*     */ import javax.xml.parsers.DocumentBuilderFactory;
/*     */ import javax.xml.parsers.ParserConfigurationException;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.client.resources.IResource;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraftforge.client.model.IModelCustom;
/*     */ import net.minecraftforge.client.model.ModelFormatException;
/*     */ import org.w3c.dom.Document;
/*     */ import org.w3c.dom.NamedNodeMap;
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
/*     */ import org.xml.sax.SAXException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class TechneModel
/*     */   extends ModelBase
/*     */   implements IModelCustom
/*     */ {
/*  42 */   public static final List<String> cubeTypes = Arrays.asList(new String[] { "d9e621f7-957f-4b77-b1ae-20dcd0da7751", "de81aa14-bd60-4228-8d8d-5238bcd3caaa" });
/*     */ 
/*     */   
/*     */   private String fileName;
/*     */ 
/*     */   
/*  48 */   private Map<String, byte[]> zipContents = (Map)new HashMap<String, byte>();
/*     */   
/*  50 */   private Map<String, ModelRenderer> parts = new LinkedHashMap<String, ModelRenderer>();
/*  51 */   private String texture = null;
/*  52 */   private Dimension textureDims = null;
/*     */   
/*     */   private int textureName;
/*     */   private boolean textureNameSet = false;
/*     */   
/*     */   public TechneModel(ResourceLocation resource) throws ModelFormatException {
/*  58 */     this.fileName = resource.toString();
/*     */ 
/*     */     
/*     */     try {
/*  62 */       IResource res = Minecraft.getMinecraft().getResourceManager().getResource(resource);
/*  63 */       loadTechneModel(res.getInputStream());
/*     */     }
/*  65 */     catch (IOException e) {
/*     */       
/*  67 */       throw new ModelFormatException("IO Exception reading model format", e);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void loadTechneModel(InputStream stream) throws ModelFormatException {
/*     */     try {
/*  75 */       ZipInputStream zipInput = new ZipInputStream(stream);
/*     */       
/*     */       ZipEntry entry;
/*  78 */       while ((entry = zipInput.getNextEntry()) != null) {
/*     */         
/*  80 */         byte[] data = new byte[(int)entry.getSize()];
/*     */         
/*  82 */         int j = 0;
/*  83 */         while (zipInput.available() > 0 && j < data.length)
/*     */         {
/*  85 */           data[j++] = (byte)zipInput.read();
/*     */         }
/*  87 */         this.zipContents.put(entry.getName(), data);
/*     */       } 
/*     */       
/*  90 */       byte[] modelXml = this.zipContents.get("model.xml");
/*  91 */       if (modelXml == null)
/*     */       {
/*  93 */         throw new ModelFormatException("Model " + this.fileName + " contains no model.xml file");
/*     */       }
/*     */       
/*  96 */       DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
/*  97 */       DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
/*  98 */       Document document = documentBuilder.parse(new ByteArrayInputStream(modelXml));
/*     */       
/* 100 */       NodeList nodeListTechne = document.getElementsByTagName("Techne");
/* 101 */       if (nodeListTechne.getLength() < 1)
/*     */       {
/* 103 */         throw new ModelFormatException("Model " + this.fileName + " contains no Techne tag");
/*     */       }
/*     */       
/* 106 */       NodeList nodeListModel = document.getElementsByTagName("Model");
/* 107 */       if (nodeListModel.getLength() < 1)
/*     */       {
/* 109 */         throw new ModelFormatException("Model " + this.fileName + " contains no Model tag");
/*     */       }
/*     */       
/* 112 */       NamedNodeMap modelAttributes = nodeListModel.item(0).getAttributes();
/* 113 */       if (modelAttributes == null)
/*     */       {
/* 115 */         throw new ModelFormatException("Model " + this.fileName + " contains a Model tag with no attributes");
/*     */       }
/*     */       
/* 118 */       Node modelTexture = modelAttributes.getNamedItem("texture");
/* 119 */       if (modelTexture != null)
/*     */       {
/* 121 */         this.texture = modelTexture.getTextContent();
/*     */       }
/*     */       
/* 124 */       NodeList textureDim = document.getElementsByTagName("TextureSize");
/* 125 */       if (textureDim.getLength() > 0) {
/*     */         
/*     */         try {
/*     */           
/* 129 */           String[] tmp = textureDim.item(0).getTextContent().split(",");
/* 130 */           if (tmp.length == 2)
/*     */           {
/* 132 */             this.textureDims = new Dimension(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]));
/*     */           }
/*     */         }
/* 135 */         catch (NumberFormatException e) {
/*     */           
/* 137 */           throw new ModelFormatException("Model " + this.fileName + " contains a TextureSize tag with invalid data");
/*     */         } 
/*     */       }
/*     */       
/* 141 */       NodeList shapes = document.getElementsByTagName("Shape");
/* 142 */       for (int i = 0; i < shapes.getLength(); i++) {
/*     */         
/* 144 */         Node shape = shapes.item(i);
/* 145 */         NamedNodeMap shapeAttributes = shape.getAttributes();
/* 146 */         if (shapeAttributes == null)
/*     */         {
/* 148 */           throw new ModelFormatException("Shape #" + (i + 1) + " in " + this.fileName + " has no attributes");
/*     */         }
/*     */         
/* 151 */         Node name = shapeAttributes.getNamedItem("name");
/* 152 */         String shapeName = null;
/* 153 */         if (name != null)
/*     */         {
/* 155 */           shapeName = name.getNodeValue();
/*     */         }
/* 157 */         if (shapeName == null)
/*     */         {
/* 159 */           shapeName = "Shape #" + (i + 1);
/*     */         }
/*     */         
/* 162 */         String shapeType = null;
/* 163 */         Node type = shapeAttributes.getNamedItem("type");
/* 164 */         if (type != null)
/*     */         {
/* 166 */           shapeType = type.getNodeValue();
/*     */         }
/* 168 */         if (shapeType != null && !cubeTypes.contains(shapeType)) {
/*     */           
/* 170 */           FMLLog.warning("Model shape [" + shapeName + "] in " + this.fileName + " is not a cube, ignoring", new Object[0]);
/*     */         } else {
/*     */ 
/*     */           
/*     */           try {
/*     */             
/* 176 */             boolean mirrored = false;
/* 177 */             String[] offset = new String[3];
/* 178 */             String[] position = new String[3];
/* 179 */             String[] rotation = new String[3];
/* 180 */             String[] size = new String[3];
/* 181 */             String[] textureOffset = new String[2];
/*     */             
/* 183 */             NodeList shapeChildren = shape.getChildNodes();
/* 184 */             for (int j = 0; j < shapeChildren.getLength(); j++) {
/*     */               
/* 186 */               Node shapeChild = shapeChildren.item(j);
/*     */               
/* 188 */               String shapeChildName = shapeChild.getNodeName();
/* 189 */               String shapeChildValue = shapeChild.getTextContent();
/* 190 */               if (shapeChildValue != null) {
/*     */                 
/* 192 */                 shapeChildValue = shapeChildValue.trim();
/*     */                 
/* 194 */                 if (shapeChildName.equals("IsMirrored")) {
/*     */                   
/* 196 */                   mirrored = !shapeChildValue.equals("False");
/*     */                 }
/* 198 */                 else if (shapeChildName.equals("Offset")) {
/*     */                   
/* 200 */                   offset = shapeChildValue.split(",");
/*     */                 }
/* 202 */                 else if (shapeChildName.equals("Position")) {
/*     */                   
/* 204 */                   position = shapeChildValue.split(",");
/*     */                 }
/* 206 */                 else if (shapeChildName.equals("Rotation")) {
/*     */                   
/* 208 */                   rotation = shapeChildValue.split(",");
/*     */                 }
/* 210 */                 else if (shapeChildName.equals("Size")) {
/*     */                   
/* 212 */                   size = shapeChildValue.split(",");
/*     */                 }
/* 214 */                 else if (shapeChildName.equals("TextureOffset")) {
/*     */                   
/* 216 */                   textureOffset = shapeChildValue.split(",");
/*     */                 } 
/*     */               } 
/*     */             } 
/*     */ 
/*     */             
/* 222 */             ModelRenderer cube = new ModelRenderer(this, Integer.parseInt(textureOffset[0]), Integer.parseInt(textureOffset[1]));
/* 223 */             cube.mirror = mirrored;
/* 224 */             cube.addBox(Float.parseFloat(offset[0]), Float.parseFloat(offset[1]), Float.parseFloat(offset[2]), Integer.parseInt(size[0]), Integer.parseInt(size[1]), Integer.parseInt(size[2]));
/* 225 */             cube.setRotationPoint(Float.parseFloat(position[0]), Float.parseFloat(position[1]) - 23.4F, Float.parseFloat(position[2]));
/*     */             
/* 227 */             cube.rotateAngleX = (float)Math.toRadians(Float.parseFloat(rotation[0]));
/* 228 */             cube.rotateAngleY = (float)Math.toRadians(Float.parseFloat(rotation[1]));
/* 229 */             cube.rotateAngleZ = (float)Math.toRadians(Float.parseFloat(rotation[2]));
/*     */             
/* 231 */             if (this.textureDims != null)
/*     */             {
/* 233 */               cube.setTextureSize((int)this.textureDims.getWidth(), (int)this.textureDims.getHeight());
/*     */             }
/*     */             
/* 236 */             this.parts.put(shapeName, cube);
/*     */           }
/* 238 */           catch (NumberFormatException e) {
/*     */             
/* 240 */             FMLLog.warning("Model shape [" + shapeName + "] in " + this.fileName + " contains malformed integers within its data, ignoring", new Object[0]);
/* 241 */             e.printStackTrace();
/*     */           } 
/*     */         } 
/*     */       } 
/* 245 */     } catch (ZipException e) {
/*     */       
/* 247 */       throw new ModelFormatException("Model " + this.fileName + " is not a valid zip file");
/*     */     }
/* 249 */     catch (IOException e) {
/*     */       
/* 251 */       throw new ModelFormatException("Model " + this.fileName + " could not be read", e);
/*     */     }
/* 253 */     catch (ParserConfigurationException parserConfigurationException) {
/*     */ 
/*     */     
/*     */     }
/* 257 */     catch (SAXException e) {
/*     */       
/* 259 */       throw new ModelFormatException("Model " + this.fileName + " contains invalid XML", e);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void bindTexture() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getType() {
/* 304 */     return "tcn";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderAll() {
/* 310 */     bindTexture();
/*     */     
/* 312 */     for (ModelRenderer part : this.parts.values())
/*     */     {
/* 314 */       part.renderWithRotation(1.0F);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderPart(String partName) {
/* 321 */     ModelRenderer part = this.parts.get(partName);
/* 322 */     if (part != null) {
/*     */       
/* 324 */       bindTexture();
/*     */       
/* 326 */       part.renderWithRotation(1.0F);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderOnly(String... groupNames) {
/* 333 */     bindTexture();
/* 334 */     for (ModelRenderer part : this.parts.values()) {
/*     */       
/* 336 */       for (String groupName : groupNames) {
/*     */         
/* 338 */         if (groupName.equalsIgnoreCase(part.boxName))
/*     */         {
/* 340 */           part.render(1.0F);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderAllExcept(String... excludedGroupNames) {
/* 349 */     for (ModelRenderer part : this.parts.values()) {
/*     */       
/* 351 */       boolean skipPart = false;
/* 352 */       for (String excludedGroupName : excludedGroupNames) {
/*     */         
/* 354 */         if (excludedGroupName.equalsIgnoreCase(part.boxName))
/*     */         {
/* 356 */           skipPart = true;
/*     */         }
/*     */       } 
/* 359 */       if (!skipPart)
/*     */       {
/* 361 */         part.render(1.0F);
/*     */       }
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\client\model\techne\TechneModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */