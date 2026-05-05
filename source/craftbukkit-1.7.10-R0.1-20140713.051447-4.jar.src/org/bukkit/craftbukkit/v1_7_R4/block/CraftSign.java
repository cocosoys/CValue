/*    */ package org.bukkit.craftbukkit.v1_7_R4.block;
/*    */ 
/*    */ import net.minecraft.server.v1_7_R4.TileEntitySign;
/*    */ import org.bukkit.block.Block;
/*    */ import org.bukkit.block.Sign;
/*    */ import org.bukkit.craftbukkit.v1_7_R4.CraftWorld;
/*    */ 
/*    */ public class CraftSign extends CraftBlockState implements Sign {
/*    */   private final TileEntitySign sign;
/*    */   private final String[] lines;
/*    */   
/*    */   public CraftSign(Block block) {
/* 13 */     super(block);
/*    */     
/* 15 */     CraftWorld world = (CraftWorld)block.getWorld();
/* 16 */     this.sign = (TileEntitySign)world.getTileEntityAt(getX(), getY(), getZ());
/* 17 */     this.lines = new String[this.sign.lines.length];
/* 18 */     System.arraycopy(this.sign.lines, 0, this.lines, 0, this.lines.length);
/*    */   }
/*    */   
/*    */   public String[] getLines() {
/* 22 */     return this.lines;
/*    */   }
/*    */   
/*    */   public String getLine(int index) throws IndexOutOfBoundsException {
/* 26 */     return this.lines[index];
/*    */   }
/*    */   
/*    */   public void setLine(int index, String line) throws IndexOutOfBoundsException {
/* 30 */     this.lines[index] = line;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean update(boolean force, boolean applyPhysics) {
/* 35 */     boolean result = super.update(force, applyPhysics);
/*    */     
/* 37 */     if (result) {
/* 38 */       this.sign.lines = sanitizeLines(this.lines);
/* 39 */       this.sign.update();
/*    */     } 
/*    */     
/* 42 */     return result;
/*    */   }
/*    */   
/*    */   public static String[] sanitizeLines(String[] lines) {
/* 46 */     String[] astring = new String[4];
/*    */     
/* 48 */     for (int i = 0; i < 4; i++) {
/* 49 */       if (i < lines.length && lines[i] != null) {
/* 50 */         astring[i] = lines[i];
/*    */       } else {
/* 52 */         astring[i] = "";
/*    */       } 
/*    */     } 
/*    */     
/* 56 */     return TileEntitySign.sanitizeLines(astring);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\craftbukkit\v1_7_R4\block\CraftSign.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */