/*    */ package net.minecraft.client.renderer.entity;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.entity.ai.EntityMinecartMobSpawner;
/*    */ import net.minecraft.entity.item.EntityMinecart;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderMinecartMobSpawner extends RenderMinecart {
/*    */   protected void func_147910_a(EntityMinecartMobSpawner p_147910_1_, float p_147910_2_, Block p_147910_3_, int p_147910_4_) {
/* 11 */     super.func_147910_a((EntityMinecart)p_147910_1_, p_147910_2_, p_147910_3_, p_147910_4_);
/*    */     
/* 13 */     if (p_147910_3_ == Blocks.field_150474_ac)
/* 14 */       TileEntityMobSpawnerRenderer.func_147517_a(p_147910_1_.func_98039_d(), p_147910_1_.field_70165_t, p_147910_1_.field_70163_u, p_147910_1_.field_70161_v, p_147910_2_); 
/*    */   }
/*    */   
/*    */   private static final String __OBFID = "CL_00001014";
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\renderer\entity\RenderMinecartMobSpawner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */