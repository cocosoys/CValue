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
/*    */ public class MedPodDoor1Item
/*    */   extends Item
/*    */ {
/*    */   private Block spawn;
/*    */   
/*    */   public MedPodDoor1Item(Block spawn) {
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
/*    */   
/*    */   public boolean func_77648_a(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
/* 40 */     if (par3World.func_147439_a(par4, par5, par6) != Blocks.field_150433_aE) {
/*    */       
/* 42 */       if (par7 == 0)
/*    */       {
/* 44 */         par5--;
/*    */       }
/*    */       
/* 47 */       if (par7 == 1)
/*    */       {
/* 49 */         par5++;
/*    */       }
/*    */       
/* 52 */       if (par7 == 2)
/*    */       {
/* 54 */         par6--;
/*    */       }
/*    */       
/* 57 */       if (par7 == 3)
/*    */       {
/* 59 */         par6++;
/*    */       }
/*    */       
/* 62 */       if (par7 == 4)
/*    */       {
/* 64 */         par4--;
/*    */       }
/*    */       
/* 67 */       if (par7 == 5)
/*    */       {
/* 69 */         par4++;
/*    */       }
/*    */       
/* 72 */       if (!par3World.func_147437_c(par4, par5, par6))
/*    */       {
/* 74 */         return false;
/*    */       }
/*    */     } 
/*    */     
/* 78 */     if (!par2EntityPlayer.func_82247_a(par4, par5, par6, par7, par1ItemStack))
/*    */     {
/* 80 */       return false;
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 89 */     if (this.spawn != null && this.spawn.func_149742_c(par3World, par4, par5, par6)) {
/*    */       
/* 91 */       par1ItemStack.field_77994_a--;
/* 92 */       par3World.func_147449_b(par4, par5, par6, this.spawn);
/*    */     } 
/* 94 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Render\MedPodDoor1Item.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */