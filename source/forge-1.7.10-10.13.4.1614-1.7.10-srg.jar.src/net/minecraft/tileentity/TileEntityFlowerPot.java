/*    */ package net.minecraft.tileentity;
/*    */ 
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ import net.minecraft.network.Packet;
/*    */ import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
/*    */ 
/*    */ public class TileEntityFlowerPot
/*    */   extends TileEntity
/*    */ {
/*    */   private Item field_145967_a;
/*    */   private int field_145968_i;
/*    */   private static final String __OBFID = "CL_00000356";
/*    */   
/*    */   public TileEntityFlowerPot() {}
/*    */   
/*    */   public TileEntityFlowerPot(Item p_i45442_1_, int p_i45442_2_) {
/* 18 */     this.field_145967_a = p_i45442_1_;
/* 19 */     this.field_145968_i = p_i45442_2_;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_145841_b(NBTTagCompound p_145841_1_) {
/* 25 */     super.func_145841_b(p_145841_1_);
/* 26 */     p_145841_1_.func_74768_a("Item", Item.func_150891_b(this.field_145967_a));
/* 27 */     p_145841_1_.func_74768_a("Data", this.field_145968_i);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_145839_a(NBTTagCompound p_145839_1_) {
/* 32 */     super.func_145839_a(p_145839_1_);
/* 33 */     this.field_145967_a = Item.func_150899_d(p_145839_1_.func_74762_e("Item"));
/* 34 */     this.field_145968_i = p_145839_1_.func_74762_e("Data");
/*    */   }
/*    */ 
/*    */   
/*    */   public Packet func_145844_m() {
/* 39 */     NBTTagCompound nBTTagCompound = new NBTTagCompound();
/* 40 */     func_145841_b(nBTTagCompound);
/* 41 */     return (Packet)new S35PacketUpdateTileEntity(this.field_145851_c, this.field_145848_d, this.field_145849_e, 5, nBTTagCompound);
/*    */   }
/*    */   
/*    */   public void func_145964_a(Item p_145964_1_, int p_145964_2_) {
/* 45 */     this.field_145967_a = p_145964_1_;
/* 46 */     this.field_145968_i = p_145964_2_;
/*    */   }
/*    */   
/*    */   public Item func_145965_a() {
/* 50 */     return this.field_145967_a;
/*    */   }
/*    */   
/*    */   public int func_145966_b() {
/* 54 */     return this.field_145968_i;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\tileentity\TileEntityFlowerPot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */