/*     */ package net.minecraftforge.fluids;
/*     */ 
/*     */ import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.renderer.RenderBlocks;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.texture.TextureMap;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RenderBlockFluid
/*     */   implements ISimpleBlockRenderingHandler
/*     */ {
/*  21 */   public static RenderBlockFluid instance = new RenderBlockFluid();
/*     */   
/*     */   static final float LIGHT_Y_NEG = 0.5F;
/*     */   
/*     */   static final float LIGHT_Y_POS = 1.0F;
/*     */   static final float LIGHT_XZ_NEG = 0.8F;
/*     */   static final float LIGHT_XZ_POS = 0.6F;
/*     */   static final double RENDER_OFFSET = 0.0010000000474974513D;
/*     */   
/*     */   public float getFluidHeightAverage(float[] flow) {
/*  31 */     float total = 0.0F;
/*  32 */     int count = 0;
/*     */     
/*  34 */     float end = 0.0F;
/*     */     
/*  36 */     for (int i = 0; i < flow.length; i++) {
/*     */       
/*  38 */       if (flow[i] >= 0.875F && end != 1.0F)
/*     */       {
/*  40 */         end = flow[i];
/*     */       }
/*     */       
/*  43 */       if (flow[i] >= 0.0F) {
/*     */         
/*  45 */         total += flow[i];
/*  46 */         count++;
/*     */       } 
/*     */     } 
/*     */     
/*  50 */     if (end == 0.0F) {
/*  51 */       end = total / count;
/*     */     }
/*  53 */     return end;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getFluidHeightForRender(IBlockAccess world, int x, int y, int z, BlockFluidBase block) {
/*  58 */     if (world.getBlock(x, y, z) == block) {
/*     */       
/*  60 */       Block verticalOrigin = world.getBlock(x, y - block.densityDir, z);
/*  61 */       if (verticalOrigin.getMaterial().isLiquid() || verticalOrigin instanceof IFluidBlock)
/*     */       {
/*  63 */         return 1.0F;
/*     */       }
/*     */       
/*  66 */       if (world.getBlockMetadata(x, y, z) == block.getMaxRenderHeightMeta())
/*     */       {
/*  68 */         return 0.875F;
/*     */       }
/*     */     } 
/*  71 */     return (!world.getBlock(x, y, z).getMaterial().isSolid() && world.getBlock(x, y - block.densityDir, z) == block) ? 1.0F : (block.getQuantaPercentage(world, x, y, z) * 0.875F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {}
/*     */ 
/*     */   
/*     */   public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
/*     */     double heightNW, heightSW, heightSE, heightNE;
/*  81 */     if (!(block instanceof BlockFluidBase))
/*     */     {
/*  83 */       return false;
/*     */     }
/*     */     
/*  86 */     Tessellator tessellator = Tessellator.instance;
/*  87 */     int color = block.colorMultiplier(world, x, y, z);
/*  88 */     float red = (color >> 16 & 0xFF) / 255.0F;
/*  89 */     float green = (color >> 8 & 0xFF) / 255.0F;
/*  90 */     float blue = (color & 0xFF) / 255.0F;
/*     */     
/*  92 */     BlockFluidBase theFluid = (BlockFluidBase)block;
/*  93 */     int bMeta = world.getBlockMetadata(x, y, z);
/*     */     
/*  95 */     boolean renderTop = (world.getBlock(x, y - theFluid.densityDir, z) != theFluid);
/*     */     
/*  97 */     boolean renderBottom = (block.shouldSideBeRendered(world, x, y + theFluid.densityDir, z, 0) && world.getBlock(x, y + theFluid.densityDir, z) != theFluid);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 104 */     boolean[] renderSides = { block.shouldSideBeRendered(world, x, y, z - 1, 2), block.shouldSideBeRendered(world, x, y, z + 1, 3), block.shouldSideBeRendered(world, x - 1, y, z, 4), block.shouldSideBeRendered(world, x + 1, y, z, 5) };
/*     */ 
/*     */     
/* 107 */     if (!renderTop && !renderBottom && !renderSides[0] && !renderSides[1] && !renderSides[2] && !renderSides[3])
/*     */     {
/* 109 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 113 */     boolean rendered = false;
/*     */     
/* 115 */     float flow11 = getFluidHeightForRender(world, x, y, z, theFluid);
/*     */     
/* 117 */     if (flow11 != 1.0F) {
/*     */       
/* 119 */       float flow00 = getFluidHeightForRender(world, x - 1, y, z - 1, theFluid);
/* 120 */       float flow01 = getFluidHeightForRender(world, x - 1, y, z, theFluid);
/* 121 */       float flow02 = getFluidHeightForRender(world, x - 1, y, z + 1, theFluid);
/* 122 */       float flow10 = getFluidHeightForRender(world, x, y, z - 1, theFluid);
/* 123 */       float flow12 = getFluidHeightForRender(world, x, y, z + 1, theFluid);
/* 124 */       float flow20 = getFluidHeightForRender(world, x + 1, y, z - 1, theFluid);
/* 125 */       float flow21 = getFluidHeightForRender(world, x + 1, y, z, theFluid);
/* 126 */       float flow22 = getFluidHeightForRender(world, x + 1, y, z + 1, theFluid);
/*     */       
/* 128 */       heightNW = getFluidHeightAverage(new float[] { flow00, flow01, flow10, flow11 });
/* 129 */       heightSW = getFluidHeightAverage(new float[] { flow01, flow02, flow12, flow11 });
/* 130 */       heightSE = getFluidHeightAverage(new float[] { flow12, flow21, flow22, flow11 });
/* 131 */       heightNE = getFluidHeightAverage(new float[] { flow10, flow20, flow21, flow11 });
/*     */     }
/*     */     else {
/*     */       
/* 135 */       heightNW = flow11;
/* 136 */       heightSW = flow11;
/* 137 */       heightSE = flow11;
/* 138 */       heightNE = flow11;
/*     */     } 
/*     */     
/* 141 */     boolean rises = (theFluid.densityDir == 1);
/* 142 */     if (renderer.renderAllFaces || renderTop) {
/*     */       double u1, u2, u3, u4, v1, v2, v3, v4;
/* 144 */       rendered = true;
/* 145 */       IIcon iconStill = getIcon(block.getIcon(1, bMeta));
/* 146 */       float flowDir = (float)BlockFluidBase.getFlowDirection(world, x, y, z);
/*     */       
/* 148 */       if (flowDir > -999.0F)
/*     */       {
/* 150 */         iconStill = getIcon(block.getIcon(2, bMeta));
/*     */       }
/*     */       
/* 153 */       heightNW -= 0.0010000000474974513D;
/* 154 */       heightSW -= 0.0010000000474974513D;
/* 155 */       heightSE -= 0.0010000000474974513D;
/* 156 */       heightNE -= 0.0010000000474974513D;
/*     */ 
/*     */ 
/*     */       
/* 160 */       if (flowDir < -999.0F) {
/*     */         
/* 162 */         u2 = iconStill.getInterpolatedU(0.0D);
/* 163 */         v2 = iconStill.getInterpolatedV(0.0D);
/* 164 */         u1 = u2;
/* 165 */         v1 = iconStill.getInterpolatedV(16.0D);
/* 166 */         u4 = iconStill.getInterpolatedU(16.0D);
/* 167 */         v4 = v1;
/* 168 */         u3 = u4;
/* 169 */         v3 = v2;
/*     */       }
/*     */       else {
/*     */         
/* 173 */         float xFlow = MathHelper.sin(flowDir) * 0.25F;
/* 174 */         float zFlow = MathHelper.cos(flowDir) * 0.25F;
/* 175 */         u2 = iconStill.getInterpolatedU((8.0F + (-zFlow - xFlow) * 16.0F));
/* 176 */         v2 = iconStill.getInterpolatedV((8.0F + (-zFlow + xFlow) * 16.0F));
/* 177 */         u1 = iconStill.getInterpolatedU((8.0F + (-zFlow + xFlow) * 16.0F));
/* 178 */         v1 = iconStill.getInterpolatedV((8.0F + (zFlow + xFlow) * 16.0F));
/* 179 */         u4 = iconStill.getInterpolatedU((8.0F + (zFlow + xFlow) * 16.0F));
/* 180 */         v4 = iconStill.getInterpolatedV((8.0F + (zFlow - xFlow) * 16.0F));
/* 181 */         u3 = iconStill.getInterpolatedU((8.0F + (zFlow - xFlow) * 16.0F));
/* 182 */         v3 = iconStill.getInterpolatedV((8.0F + (-zFlow - xFlow) * 16.0F));
/*     */       } 
/*     */       
/* 185 */       tessellator.setBrightness(block.getMixedBrightnessForBlock(world, x, y, z));
/* 186 */       tessellator.setColorOpaque_F(1.0F * red, 1.0F * green, 1.0F * blue);
/*     */       
/* 188 */       if (!rises) {
/*     */         
/* 190 */         tessellator.addVertexWithUV((x + 0), y + heightNW, (z + 0), u2, v2);
/* 191 */         tessellator.addVertexWithUV((x + 0), y + heightSW, (z + 1), u1, v1);
/* 192 */         tessellator.addVertexWithUV((x + 1), y + heightSE, (z + 1), u4, v4);
/* 193 */         tessellator.addVertexWithUV((x + 1), y + heightNE, (z + 0), u3, v3);
/*     */         
/* 195 */         tessellator.addVertexWithUV((x + 0), y + heightNW, (z + 0), u2, v2);
/* 196 */         tessellator.addVertexWithUV((x + 1), y + heightNE, (z + 0), u3, v3);
/* 197 */         tessellator.addVertexWithUV((x + 1), y + heightSE, (z + 1), u4, v4);
/* 198 */         tessellator.addVertexWithUV((x + 0), y + heightSW, (z + 1), u1, v1);
/*     */       }
/*     */       else {
/*     */         
/* 202 */         tessellator.addVertexWithUV((x + 1), (y + 1) - heightNE, (z + 0), u3, v3);
/* 203 */         tessellator.addVertexWithUV((x + 1), (y + 1) - heightSE, (z + 1), u4, v4);
/* 204 */         tessellator.addVertexWithUV((x + 0), (y + 1) - heightSW, (z + 1), u1, v1);
/* 205 */         tessellator.addVertexWithUV((x + 0), (y + 1) - heightNW, (z + 0), u2, v2);
/*     */         
/* 207 */         tessellator.addVertexWithUV((x + 1), (y + 1) - heightNE, (z + 0), u3, v3);
/* 208 */         tessellator.addVertexWithUV((x + 0), (y + 1) - heightNW, (z + 0), u2, v2);
/* 209 */         tessellator.addVertexWithUV((x + 0), (y + 1) - heightSW, (z + 1), u1, v1);
/* 210 */         tessellator.addVertexWithUV((x + 1), (y + 1) - heightSE, (z + 1), u4, v4);
/*     */       } 
/*     */     } 
/*     */     
/* 214 */     if (renderer.renderAllFaces || renderBottom) {
/*     */       
/* 216 */       rendered = true;
/* 217 */       tessellator.setBrightness(block.getMixedBrightnessForBlock(world, x, y - 1, z));
/* 218 */       if (!rises) {
/*     */         
/* 220 */         tessellator.setColorOpaque_F(0.5F * red, 0.5F * green, 0.5F * blue);
/* 221 */         renderer.renderFaceYNeg(block, x, y + 0.0010000000474974513D, z, getIcon(block.getIcon(0, bMeta)));
/*     */       }
/*     */       else {
/*     */         
/* 225 */         tessellator.setColorOpaque_F(1.0F * red, 1.0F * green, 1.0F * blue);
/* 226 */         renderer.renderFaceYPos(block, x, y + 0.0010000000474974513D, z, getIcon(block.getIcon(1, bMeta)));
/*     */       } 
/*     */     } 
/*     */     
/* 230 */     for (int side = 0; side < 4; side++) {
/*     */       
/* 232 */       int x2 = x;
/* 233 */       int z2 = z;
/*     */       
/* 235 */       switch (side) {
/*     */         case 0:
/* 237 */           z2--; break;
/* 238 */         case 1: z2++; break;
/* 239 */         case 2: x2--; break;
/* 240 */         case 3: x2++;
/*     */           break;
/*     */       } 
/* 243 */       IIcon iconFlow = getIcon(block.getIcon(side + 2, bMeta));
/* 244 */       if (renderer.renderAllFaces || renderSides[side]) {
/*     */         double ty1, tx1, ty2, tx2, tz1, tz2;
/* 246 */         rendered = true;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 255 */         if (side == 0) {
/*     */           
/* 257 */           ty1 = heightNW;
/* 258 */           ty2 = heightNE;
/* 259 */           tx1 = x;
/* 260 */           tx2 = (x + 1);
/* 261 */           tz1 = z + 0.0010000000474974513D;
/* 262 */           tz2 = z + 0.0010000000474974513D;
/*     */         }
/* 264 */         else if (side == 1) {
/*     */           
/* 266 */           ty1 = heightSE;
/* 267 */           ty2 = heightSW;
/* 268 */           tx1 = (x + 1);
/* 269 */           tx2 = x;
/* 270 */           tz1 = (z + 1) - 0.0010000000474974513D;
/* 271 */           tz2 = (z + 1) - 0.0010000000474974513D;
/*     */         }
/* 273 */         else if (side == 2) {
/*     */           
/* 275 */           ty1 = heightSW;
/* 276 */           ty2 = heightNW;
/* 277 */           tx1 = x + 0.0010000000474974513D;
/* 278 */           tx2 = x + 0.0010000000474974513D;
/* 279 */           tz1 = (z + 1);
/* 280 */           tz2 = z;
/*     */         }
/*     */         else {
/*     */           
/* 284 */           ty1 = heightNE;
/* 285 */           ty2 = heightSE;
/* 286 */           tx1 = (x + 1) - 0.0010000000474974513D;
/* 287 */           tx2 = (x + 1) - 0.0010000000474974513D;
/* 288 */           tz1 = z;
/* 289 */           tz2 = (z + 1);
/*     */         } 
/*     */         
/* 292 */         float u1Flow = iconFlow.getInterpolatedU(0.0D);
/* 293 */         float u2Flow = iconFlow.getInterpolatedU(8.0D);
/* 294 */         float v1Flow = iconFlow.getInterpolatedV((1.0D - ty1) * 16.0D * 0.5D);
/* 295 */         float v2Flow = iconFlow.getInterpolatedV((1.0D - ty2) * 16.0D * 0.5D);
/* 296 */         float v3Flow = iconFlow.getInterpolatedV(8.0D);
/* 297 */         tessellator.setBrightness(block.getMixedBrightnessForBlock(world, x2, y, z2));
/* 298 */         float sideLighting = 1.0F;
/*     */         
/* 300 */         if (side < 2) {
/*     */           
/* 302 */           sideLighting = 0.8F;
/*     */         }
/*     */         else {
/*     */           
/* 306 */           sideLighting = 0.6F;
/*     */         } 
/*     */         
/* 309 */         tessellator.setColorOpaque_F(1.0F * sideLighting * red, 1.0F * sideLighting * green, 1.0F * sideLighting * blue);
/*     */         
/* 311 */         if (!rises) {
/*     */           
/* 313 */           tessellator.addVertexWithUV(tx1, y + ty1, tz1, u1Flow, v1Flow);
/* 314 */           tessellator.addVertexWithUV(tx2, y + ty2, tz2, u2Flow, v2Flow);
/* 315 */           tessellator.addVertexWithUV(tx2, (y + 0), tz2, u2Flow, v3Flow);
/* 316 */           tessellator.addVertexWithUV(tx1, (y + 0), tz1, u1Flow, v3Flow);
/*     */           
/* 318 */           tessellator.addVertexWithUV(tx1, y + ty1, tz1, u1Flow, v1Flow);
/* 319 */           tessellator.addVertexWithUV(tx1, (y + 0), tz1, u1Flow, v3Flow);
/* 320 */           tessellator.addVertexWithUV(tx2, (y + 0), tz2, u2Flow, v3Flow);
/* 321 */           tessellator.addVertexWithUV(tx2, y + ty2, tz2, u2Flow, v2Flow);
/*     */         }
/*     */         else {
/*     */           
/* 325 */           tessellator.addVertexWithUV(tx1, (y + 1 - 0), tz1, u1Flow, v3Flow);
/* 326 */           tessellator.addVertexWithUV(tx2, (y + 1 - 0), tz2, u2Flow, v3Flow);
/* 327 */           tessellator.addVertexWithUV(tx2, (y + 1) - ty2, tz2, u2Flow, v2Flow);
/* 328 */           tessellator.addVertexWithUV(tx1, (y + 1) - ty1, tz1, u1Flow, v1Flow);
/*     */           
/* 330 */           tessellator.addVertexWithUV(tx1, (y + 1 - 0), tz1, u1Flow, v3Flow);
/* 331 */           tessellator.addVertexWithUV(tx1, (y + 1) - ty1, tz1, u1Flow, v1Flow);
/* 332 */           tessellator.addVertexWithUV(tx2, (y + 1) - ty2, tz2, u2Flow, v2Flow);
/* 333 */           tessellator.addVertexWithUV(tx2, (y + 1 - 0), tz2, u2Flow, v3Flow);
/*     */         } 
/*     */       } 
/*     */     } 
/* 337 */     renderer.renderMinY = 0.0D;
/* 338 */     renderer.renderMaxY = 1.0D;
/* 339 */     return rendered;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean shouldRender3DInInventory(int modelId) {
/* 344 */     return false;
/*     */   }
/*     */   
/*     */   public int getRenderId() {
/* 348 */     return FluidRegistry.renderIdFluid;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private IIcon getIcon(IIcon icon) {
/* 354 */     if (icon != null) return icon; 
/* 355 */     return (IIcon)((TextureMap)Minecraft.getMinecraft().getTextureManager().getTexture(TextureMap.locationBlocksTexture)).getAtlasSprite("missingno");
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\fluids\RenderBlockFluid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */