/*    */ package JinRyuu.DragonBC.common.Items;
/*    */ 
/*    */ import JinRyuu.DragonBC.common.Blocks.BlocksDBC;
/*    */ import JinRyuu.DragonBC.common.mod_DragonBC;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.item.ItemSword;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ItemKatana
/*    */   extends ItemSword
/*    */ {
/*    */   public ItemKatana(Item.ToolMaterial tm) {
/* 21 */     super(tm);
/* 22 */     func_77656_e(300);
/* 23 */     func_77637_a(mod_DragonBC.DragonBlockC);
/*    */   }
/*    */   public String getTextureFile() {
/* 26 */     return "jinryuudragonbc:";
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_94581_a(IIconRegister par1IconRegister) {
/* 31 */     this.field_77791_bV = par1IconRegister.func_94245_a("jinryuudragonbc:" + func_77658_a());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ItemStack onItemRightClick(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
/* 40 */     if (par1ItemStack.func_77960_j() == 15) {
/*    */       
/* 42 */       Block var11 = par3World.func_147439_a(par4, par5, par6);
/*    */ 
/*    */ 
/*    */       
/* 46 */       if (var11 == BlocksDBC.BlockNamekSapling)
/*    */       {
/* 48 */         if (!par3World.field_72995_K)
/*    */         {
/*    */           
/* 51 */           par1ItemStack.field_77994_a--;
/*    */         }
/*    */       }
/*    */     } 
/*    */     
/* 56 */     return par1ItemStack;
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Items\ItemKatana.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */