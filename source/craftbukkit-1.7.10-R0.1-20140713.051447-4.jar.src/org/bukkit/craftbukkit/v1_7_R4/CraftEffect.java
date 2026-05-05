/*    */ package org.bukkit.craftbukkit.v1_7_R4;
/*    */ 
/*    */ import org.apache.commons.lang.Validate;
/*    */ import org.bukkit.Effect;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.block.BlockFace;
/*    */ import org.bukkit.potion.Potion;
/*    */ 
/*    */ public class CraftEffect
/*    */ {
/*    */   public static <T> int getDataValue(Effect effect, T data) {
/* 12 */     switch (effect)
/*    */     { case POTION_BREAK:
/* 14 */         datavalue = ((Potion)data).toDamageValue() & 0x3F;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */         
/* 61 */         return datavalue;case RECORD_PLAY: Validate.isTrue(((Material)data).isRecord(), "Invalid record type!"); datavalue = ((Material)data).getId(); return datavalue;case SMOKE: switch ((BlockFace)data) { case POTION_BREAK: datavalue = 0; return datavalue;case RECORD_PLAY: datavalue = 1; return datavalue;case SMOKE: datavalue = 2; return datavalue;case STEP_SOUND: datavalue = 3; return datavalue;case null: case null: datavalue = 4; return datavalue;case null: datavalue = 5; return datavalue;case null: datavalue = 6; return datavalue;case null: datavalue = 7; return datavalue;case null: datavalue = 8; return datavalue; }  throw new IllegalArgumentException("Bad smoke direction!");case STEP_SOUND: Validate.isTrue(((Material)data).isBlock(), "Material is not a block!"); datavalue = ((Material)data).getId(); return datavalue; }  int datavalue = 0; return datavalue;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\craftbukkit\v1_7_R4\CraftEffect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */