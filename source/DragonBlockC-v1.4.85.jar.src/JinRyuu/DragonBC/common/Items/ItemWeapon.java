/*     */ package JinRyuu.DragonBC.common.Items;
/*     */ 
/*     */ import JinRyuu.DragonBC.common.Blocks.BlocksDBC;
/*     */ import JinRyuu.DragonBC.common.Render.ppTileEntity;
/*     */ import JinRyuu.DragonBC.common.mod_DragonBC;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.item.ItemSword;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class ItemWeapon extends ItemSword {
/*     */   private int ticker;
/*     */   
/*  20 */   public ItemWeapon(Item.ToolMaterial tm) { super(tm);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  52 */     this.ticker = 0;
/*     */     this.field_77777_bU = 1;
/*     */     func_77637_a(mod_DragonBC.DragonBlockC); }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_77648_a(ItemStack stack, EntityPlayer p, World world, int x, int y, int z, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
/*  60 */     if (world.func_147439_a(x, y, z) != null) {
/*     */       
/*  62 */       if (!world.field_72995_K && this.ticker == 0 && world.func_147439_a(x, y, z).func_149742_c(world, x, y + 1, z)) {
/*     */         
/*  64 */         world.func_147449_b(x, y + 1, z, BlocksDBC.ppBlock);
/*  65 */         for (int i = 2; i < 100 && 
/*  66 */           world.func_147437_c(x, y + i, z); i++) {
/*  67 */           world.func_147449_b(x, y + i, z, BlocksDBC.ppBlock);
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*  73 */         TileEntity tile_entity = world.func_147438_o(x, y + 1, z);
/*  74 */         if (tile_entity instanceof ppTileEntity) {
/*  75 */           ((ppTileEntity)tile_entity).setF();
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*  81 */         this.ticker = 20;
/*     */         
/*  83 */         p.field_71071_by.func_146026_a((Item)this);
/*  84 */         stack.field_77994_a = 0;
/*  85 */         return true;
/*     */       } 
/*  87 */       return false;
/*     */     } 
/*     */ 
/*     */     
/*  91 */     return false;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_94581_a(IIconRegister par1IconRegister) {
/*     */     this.field_77791_bV = par1IconRegister.func_94245_a(JRMCoreH.tjdbcAssts + ":" + func_77658_a());
/*     */   }
/*     */   public void func_77622_d(ItemStack p_77622_1_, World p_77622_2_, EntityPlayer p_77622_3_) {
/*     */     super.func_77622_d(p_77622_1_, p_77622_2_, p_77622_3_);
/*     */   }
/*     */   public ItemStack func_77659_a(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_) {
/* 101 */     return p_77659_1_;
/*     */   }
/*     */   
/*     */   public void func_77663_a(ItemStack p_77663_1_, World p_77663_2_, Entity p_77663_3_, int p_77663_4_, boolean p_77663_5_) {
/*     */     super.func_77663_a(p_77663_1_, p_77663_2_, p_77663_3_, p_77663_4_, p_77663_5_);
/*     */     if (!p_77663_2_.field_72995_K && this.ticker > 0)
/*     */       this.ticker--; 
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Items\ItemWeapon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */