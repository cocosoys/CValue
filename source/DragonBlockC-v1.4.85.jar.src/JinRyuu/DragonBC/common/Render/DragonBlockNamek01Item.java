/*    */ package JinRyuu.DragonBC.common.Render;
/*    */ 
/*    */ import JinRyuu.DragonBC.common.mod_DragonBC;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DragonBlockNamek01Item
/*    */   extends Item
/*    */ {
/*    */   private Block spawn;
/*    */   
/*    */   public DragonBlockNamek01Item(Block spawn) {
/* 20 */     this.spawn = spawn;
/* 21 */     func_77637_a(mod_DragonBC.DragonBlockC);
/* 22 */     this.field_77777_bU = 7;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getTextureFile() {
/* 30 */     return "jinryuudragonbc:dragonitems1.png";
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_94581_a(IIconRegister iconRegister) {
/* 35 */     this.field_77791_bV = iconRegister.func_94245_a("jinryuudragonbc:" + func_77658_a());
/*    */   }
/*    */   
/*    */   public boolean func_77648_a(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
/* 39 */     if (par3World.func_147439_a(par4, par5, par6) != Blocks.field_150433_aE) {
/*    */       
/* 41 */       if (par7 == 0)
/*    */       {
/* 43 */         par5--;
/*    */       }
/*    */       
/* 46 */       if (par7 == 1)
/*    */       {
/* 48 */         par5++;
/*    */       }
/*    */       
/* 51 */       if (par7 == 2)
/*    */       {
/* 53 */         par6--;
/*    */       }
/*    */       
/* 56 */       if (par7 == 3)
/*    */       {
/* 58 */         par6++;
/*    */       }
/*    */       
/* 61 */       if (par7 == 4)
/*    */       {
/* 63 */         par4--;
/*    */       }
/*    */       
/* 66 */       if (par7 == 5)
/*    */       {
/* 68 */         par4++;
/*    */       }
/*    */       
/* 71 */       if (!par3World.func_147437_c(par4, par5, par6))
/*    */       {
/* 73 */         return false;
/*    */       }
/*    */     } 
/*    */     
/* 77 */     if (!par2EntityPlayer.func_82247_a(par4, par5, par6, par7, par1ItemStack))
/*    */     {
/* 79 */       return false;
/*    */     }
/*    */ 
/*    */     
/* 83 */     if (this.spawn != null && this.spawn.func_149742_c(par3World, par4, par5, par6)) {
/*    */       
/* 85 */       par1ItemStack.field_77994_a--;
/* 86 */       par3World.func_147449_b(par4, par5, par6, this.spawn);
/*    */     } 
/*    */     
/* 89 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Render\DragonBlockNamek01Item.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */