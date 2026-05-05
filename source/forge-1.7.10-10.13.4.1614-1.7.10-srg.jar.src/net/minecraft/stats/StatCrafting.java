/*    */ package net.minecraft.stats;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.util.IChatComponent;
/*    */ 
/*    */ public class StatCrafting extends StatBase {
/*    */   private final Item field_150960_a;
/*    */   
/*    */   public StatCrafting(String p_i45305_1_, IChatComponent p_i45305_2_, Item p_i45305_3_) {
/* 11 */     super(p_i45305_1_, p_i45305_2_);
/* 12 */     this.field_150960_a = p_i45305_3_;
/*    */   } private static final String __OBFID = "CL_00001470";
/*    */   @SideOnly(Side.CLIENT)
/*    */   public Item func_150959_a() {
/* 16 */     return this.field_150960_a;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\stats\StatCrafting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */