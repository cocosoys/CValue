/*    */ package net.minecraft.client.resources;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import net.minecraft.client.gui.GuiScreenResourcePacks;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class ResourcePackListEntryFound extends ResourcePackListEntry {
/*    */   private final ResourcePackRepository.Entry field_148319_c;
/*    */   
/*    */   public ResourcePackListEntryFound(GuiScreenResourcePacks p_i45053_1_, ResourcePackRepository.Entry p_i45053_2_) {
/* 10 */     super(p_i45053_1_);
/* 11 */     this.field_148319_c = p_i45053_2_;
/*    */   }
/*    */   private static final String __OBFID = "CL_00000823";
/*    */   
/*    */   protected void func_148313_c() {
/* 16 */     this.field_148319_c.func_110518_a(this.field_148317_a.func_110434_K());
/*    */   }
/*    */ 
/*    */   
/*    */   protected String func_148311_a() {
/* 21 */     return this.field_148319_c.func_110519_e();
/*    */   }
/*    */ 
/*    */   
/*    */   protected String func_148312_b() {
/* 26 */     return this.field_148319_c.func_110515_d();
/*    */   }
/*    */   
/*    */   public ResourcePackRepository.Entry func_148318_i() {
/* 30 */     return this.field_148319_c;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\resources\ResourcePackListEntryFound.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */