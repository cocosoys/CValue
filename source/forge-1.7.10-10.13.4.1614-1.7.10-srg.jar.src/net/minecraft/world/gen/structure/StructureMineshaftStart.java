/*    */ package net.minecraft.world.gen.structure;
/*    */ 
/*    */ import java.util.Random;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class StructureMineshaftStart
/*    */   extends StructureStart
/*    */ {
/*    */   private static final String __OBFID = "CL_00000450";
/*    */   
/*    */   public StructureMineshaftStart() {}
/*    */   
/*    */   public StructureMineshaftStart(World p_i2039_1_, Random p_i2039_2_, int p_i2039_3_, int p_i2039_4_) {
/* 16 */     super(p_i2039_3_, p_i2039_4_);
/*    */     
/* 18 */     StructureMineshaftPieces.Room room = new StructureMineshaftPieces.Room(0, p_i2039_2_, (p_i2039_3_ << 4) + 2, (p_i2039_4_ << 4) + 2);
/* 19 */     this.field_75075_a.add(room);
/* 20 */     room.func_74861_a(room, this.field_75075_a, p_i2039_2_);
/*    */     
/* 22 */     func_75072_c();
/* 23 */     func_75067_a(p_i2039_1_, p_i2039_2_, 10);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\structure\StructureMineshaftStart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */