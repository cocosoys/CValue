/*    */ package net.minecraft.server.gui;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.Vector;
/*    */ import javax.swing.JList;
/*    */ import net.minecraft.entity.player.EntityPlayerMP;
/*    */ import net.minecraft.server.MinecraftServer;
/*    */ 
/*    */ @SideOnly(Side.SERVER)
/*    */ public class PlayerListComponent extends JList implements IUpdatePlayerListBox {
/*    */   private MinecraftServer field_120015_a;
/*    */   
/*    */   public PlayerListComponent(MinecraftServer p_i2366_1_) {
/* 15 */     this.field_120015_a = p_i2366_1_;
/* 16 */     p_i2366_1_.func_82010_a(this);
/*    */   }
/*    */   private int field_120014_b; private static final String __OBFID = "CL_00001795";
/*    */   
/*    */   public void func_73660_a() {
/* 21 */     if (this.field_120014_b++ % 20 == 0) {
/* 22 */       Vector<String> vector = new Vector();
/* 23 */       for (byte b = 0; b < (this.field_120015_a.func_71203_ab()).field_72404_b.size(); b++) {
/* 24 */         vector.add(((EntityPlayerMP)(this.field_120015_a.func_71203_ab()).field_72404_b.get(b)).func_70005_c_());
/*    */       }
/* 26 */       setListData((Vector)vector);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\server\gui\PlayerListComponent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */