/*    */ package JinRyuu.JRMCore.items;
/*    */ 
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.ItemFood;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.world.IBlockAccess;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraftforge.common.EnumPlantType;
/*    */ import net.minecraftforge.common.IPlantable;
/*    */ import net.minecraftforge.common.util.ForgeDirection;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ItemJRMCSeedFood
/*    */   extends ItemFood
/*    */   implements IPlantable
/*    */ {
/*    */   private final Block theBlockPlant;
/*    */   private final Block soilId;
/*    */   
/*    */   public ItemJRMCSeedFood(int parHealAmount, float parSaturationModifier, Block parBlockPlant, Block parSoilBlock) {
/* 25 */     super(parHealAmount, parSaturationModifier, false);
/* 26 */     this.theBlockPlant = parBlockPlant;
/* 27 */     this.soilId = parSoilBlock;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_77648_a(ItemStack parItemStack, EntityPlayer parPlayer, World parWorld, int parX, int parY, int parZ, int par7, float par8, float par9, float par10) {
/* 36 */     if (par7 != 1)
/*    */     {
/* 38 */       return false;
/*    */     }
/*    */     
/* 41 */     if (parPlayer.func_82247_a(parX, parY + 1, parZ, par7, parItemStack)) {
/*    */ 
/*    */ 
/*    */       
/* 45 */       if (parWorld.func_147439_a(parX, parY, parZ).canSustainPlant((IBlockAccess)parWorld, parX, parY, parZ, ForgeDirection.UP, this) && parWorld
/*    */         
/* 47 */         .func_147437_c(parX, parY + 1, parZ)) {
/*    */ 
/*    */         
/* 50 */         parWorld.func_147449_b(parX, parY + 1, parZ, this.theBlockPlant);
/*    */         
/* 52 */         parItemStack.field_77994_a--;
/* 53 */         return true;
/*    */       } 
/*    */ 
/*    */       
/* 57 */       return false;
/*    */     } 
/*    */ 
/*    */ 
/*    */     
/* 62 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z) {
/* 69 */     return EnumPlantType.Crop;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Block getPlant(IBlockAccess world, int x, int y, int z) {
/* 75 */     return this.theBlockPlant;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int getPlantMetadata(IBlockAccess world, int x, int y, int z) {
/* 81 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public Block getSoilId() {
/* 86 */     return this.soilId;
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\items\ItemJRMCSeedFood.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */