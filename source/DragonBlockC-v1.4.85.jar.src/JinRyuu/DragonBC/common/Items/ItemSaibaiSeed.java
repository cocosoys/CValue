/*    */ package JinRyuu.DragonBC.common.Items;
/*    */ 
/*    */ import JinRyuu.DragonBC.common.Npcs.EntitySaibaiman;
/*    */ import JinRyuu.DragonBC.common.mod_DragonBC;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.List;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.EnumAction;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ItemSaibaiSeed
/*    */   extends Item
/*    */ {
/*    */   private boolean alwaysEdible;
/*    */   private int ticker;
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_77624_a(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {}
/*    */   
/*    */   public String getTextureFile() {
/*    */     return "jinryuudragonbc:";
/*    */   }
/*    */   
/*    */   public void func_94581_a(IIconRegister iconRegister) {
/*    */     this.field_77791_bV = iconRegister.func_94245_a("jinryuudragonbc:" + func_77658_a());
/*    */   }
/*    */   
/*    */   public ItemSaibaiSeed() {
/* 87 */     this.ticker = 0;
/*    */     func_77656_e(1);
/* 89 */     func_77637_a(mod_DragonBC.DragonBlockC); } public void func_77663_a(ItemStack p_77663_1_, World p_77663_2_, Entity p_77663_3_, int p_77663_4_, boolean p_77663_5_) { if (!p_77663_2_.field_72995_K && this.ticker > 0) this.ticker--;  }
/*    */    public ItemStack func_77654_b(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
/*    */     return par1ItemStack;
/*    */   }
/*    */   public EnumAction func_77661_b(ItemStack par1ItemStack) {
/* 94 */     return EnumAction.none;
/*    */   }
/*    */   
/*    */   public int func_77626_a(ItemStack par1ItemStack) {
/*    */     return 72000;
/*    */   }
/*    */   
/*    */   public boolean func_77648_a(ItemStack stack, EntityPlayer p, World world, int x, int y, int z, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
/*    */     if (world.func_147439_a(x, y, z) != null) {
/*    */       if (!world.field_72995_K && this.ticker == 0) {
/*    */         EntitySaibaiman mr = new EntitySaibaiman(world);
/*    */         mr.func_70029_a(p.field_70170_p);
/*    */         mr.func_70012_b((x + 0.5F), (y + 0.5F), (z + 0.5F), 0.0F, 0.0F);
/*    */         mr.setSpwner((Entity)p);
/*    */         world.func_72838_d((Entity)mr);
/*    */         this.ticker = 20;
/*    */         stack.field_77994_a--;
/*    */         return true;
/*    */       } 
/*    */       return false;
/*    */     } 
/*    */     return false;
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Items\ItemSaibaiSeed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */