/*    */ package net.minecraft.tileentity;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ import net.minecraft.network.Packet;
/*    */ import net.minecraft.network.play.server.S33PacketUpdateSign;
/*    */ 
/*    */ public class TileEntitySign
/*    */   extends TileEntity {
/* 12 */   public String[] field_145915_a = new String[] { "", "", "", "" };
/*    */ 
/*    */   
/* 15 */   public int field_145918_i = -1;
/*    */   private boolean field_145916_j = true;
/*    */   private EntityPlayer field_145917_k;
/*    */   private static final String __OBFID = "CL_00000363";
/*    */   
/*    */   public void func_145841_b(NBTTagCompound p_145841_1_) {
/* 21 */     super.func_145841_b(p_145841_1_);
/* 22 */     p_145841_1_.func_74778_a("Text1", this.field_145915_a[0]);
/* 23 */     p_145841_1_.func_74778_a("Text2", this.field_145915_a[1]);
/* 24 */     p_145841_1_.func_74778_a("Text3", this.field_145915_a[2]);
/* 25 */     p_145841_1_.func_74778_a("Text4", this.field_145915_a[3]);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_145839_a(NBTTagCompound p_145839_1_) {
/* 30 */     this.field_145916_j = false;
/* 31 */     super.func_145839_a(p_145839_1_);
/* 32 */     for (byte b = 0; b < 4; b++) {
/* 33 */       this.field_145915_a[b] = p_145839_1_.func_74779_i("Text" + (b + 1));
/* 34 */       if (this.field_145915_a[b].length() > 15) this.field_145915_a[b] = this.field_145915_a[b].substring(0, 15);
/*    */     
/*    */     } 
/*    */   }
/*    */   
/*    */   public Packet func_145844_m() {
/* 40 */     String[] arrayOfString = new String[4];
/* 41 */     System.arraycopy(this.field_145915_a, 0, arrayOfString, 0, 4);
/* 42 */     return (Packet)new S33PacketUpdateSign(this.field_145851_c, this.field_145848_d, this.field_145849_e, arrayOfString);
/*    */   }
/*    */   
/*    */   public boolean func_145914_a() {
/* 46 */     return this.field_145916_j;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_145913_a(boolean p_145913_1_) {
/* 50 */     this.field_145916_j = p_145913_1_;
/* 51 */     if (!p_145913_1_) {
/* 52 */       this.field_145917_k = null;
/*    */     }
/*    */   }
/*    */   
/*    */   public void func_145912_a(EntityPlayer p_145912_1_) {
/* 57 */     this.field_145917_k = p_145912_1_;
/*    */   }
/*    */   
/*    */   public EntityPlayer func_145911_b() {
/* 61 */     return this.field_145917_k;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\tileentity\TileEntitySign.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */