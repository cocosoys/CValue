/*    */ package net.minecraft.tileentity;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import net.minecraft.command.server.CommandBlockLogic;
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ import net.minecraft.network.Packet;
/*    */ import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
/*    */ import net.minecraft.util.ChunkCoordinates;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class TileEntityCommandBlock extends TileEntity {
/* 14 */   private final CommandBlockLogic field_145994_a = new CommandBlockLogic(this)
/*    */     {
/*    */       public ChunkCoordinates func_82114_b() {
/* 17 */         return new ChunkCoordinates(this.field_145767_a.field_145851_c, this.field_145767_a.field_145848_d, this.field_145767_a.field_145849_e);
/*    */       }
/*    */       private static final String __OBFID = "CL_00000348";
/*    */       
/*    */       public World func_130014_f_() {
/* 22 */         return this.field_145767_a.func_145831_w();
/*    */       }
/*    */ 
/*    */       
/*    */       public void func_145752_a(String p_145752_1_) {
/* 27 */         super.func_145752_a(p_145752_1_);
/* 28 */         this.field_145767_a.func_70296_d();
/*    */       }
/*    */ 
/*    */       
/*    */       public void func_145756_e() {
/* 33 */         this.field_145767_a.func_145831_w().func_147471_g(this.field_145767_a.field_145851_c, this.field_145767_a.field_145848_d, this.field_145767_a.field_145849_e);
/*    */       }
/*    */       
/*    */       @SideOnly(Side.CLIENT)
/*    */       public int func_145751_f() {
/* 38 */         return 0;
/*    */       }
/*    */       
/*    */       @SideOnly(Side.CLIENT)
/*    */       public void func_145757_a(ByteBuf p_145757_1_) {
/* 43 */         p_145757_1_.writeInt(this.field_145767_a.field_145851_c);
/* 44 */         p_145757_1_.writeInt(this.field_145767_a.field_145848_d);
/* 45 */         p_145757_1_.writeInt(this.field_145767_a.field_145849_e);
/*    */       }
/*    */     };
/*    */ 
/*    */   
/*    */   private static final String __OBFID = "CL_00000347";
/*    */ 
/*    */   
/*    */   public void func_145841_b(NBTTagCompound p_145841_1_) {
/* 54 */     super.func_145841_b(p_145841_1_);
/* 55 */     this.field_145994_a.func_145758_a(p_145841_1_);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_145839_a(NBTTagCompound p_145839_1_) {
/* 60 */     super.func_145839_a(p_145839_1_);
/* 61 */     this.field_145994_a.func_145759_b(p_145839_1_);
/*    */   }
/*    */ 
/*    */   
/*    */   public Packet func_145844_m() {
/* 66 */     NBTTagCompound nBTTagCompound = new NBTTagCompound();
/* 67 */     func_145841_b(nBTTagCompound);
/* 68 */     return (Packet)new S35PacketUpdateTileEntity(this.field_145851_c, this.field_145848_d, this.field_145849_e, 2, nBTTagCompound);
/*    */   }
/*    */   
/*    */   public CommandBlockLogic func_145993_a() {
/* 72 */     return this.field_145994_a;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\tileentity\TileEntityCommandBlock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */