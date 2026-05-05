/*     */ package JinRyuu.DragonBC.common.Render;
/*     */ 
/*     */ import JinRyuu.DragonBC.common.Blocks.BlocksDBC;
/*     */ import JinRyuu.DragonBC.common.mod_DragonBC;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemArmor;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SpacePod01Item
/*     */   extends Item
/*     */ {
/*     */   private Block spawnID;
/*     */   
/*     */   public SpacePod01Item(Block par2Block, ItemArmor.ArmorMaterial par2EnumArmorMaterial, int par3, int par4) {
/*  22 */     this.spawnID = BlocksDBC.SpacePod01Block;
/*  23 */     func_77637_a(mod_DragonBC.DragonBlockC);
/*  24 */     this.field_77777_bU = 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTextureFile() {
/*  32 */     return "jinryuudragonbc:dragonitems1.png";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_94581_a(IIconRegister iconRegister) {
/*  38 */     this.field_77791_bV = iconRegister.func_94245_a("jinryuudragonbc:" + func_77658_a());
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean onItemUse1(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
/*  43 */     Block var11 = par3World.func_147439_a(par4, par5, par6);
/*     */     
/*  45 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_77648_a(ItemStack stack, EntityPlayer player, World world, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
/*  50 */     if (par7 == 0) {
/*  51 */       par5--;
/*     */     }
/*     */     
/*  54 */     if (par7 == 1) {
/*  55 */       par5++;
/*     */     }
/*     */     
/*  58 */     if (par7 == 2) {
/*  59 */       par6--;
/*     */     }
/*     */     
/*  62 */     if (par7 == 3) {
/*  63 */       par6++;
/*     */     }
/*     */     
/*  66 */     if (par7 == 4) {
/*  67 */       par4--;
/*     */     }
/*     */     
/*  70 */     if (par7 == 5) {
/*  71 */       par4++;
/*     */     }
/*     */     
/*  74 */     if (!player.func_82247_a(par4, par5, par6, par7, stack)) {
/*  75 */       return false;
/*     */     }
/*     */     
/*  78 */     if (!world.field_72995_K) {
/*     */       
/*  80 */       player.field_71071_by.func_146026_a(this);
/*  81 */       player.field_71071_by.field_70459_e = true;
/*  82 */       player.field_71071_by.field_70459_e = false;
/*  83 */       SpacePod01Entity SpacePod01Entity = new SpacePod01Entity(world);
/*     */       
/*  85 */       SpacePod01Entity.func_70012_b(par4, (par5 + 1), par6, player.field_70177_z, 0.0F);
/*  86 */       world.func_72838_d(SpacePod01Entity);
/*     */     } 
/*     */     
/*  89 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_77659_a(ItemStack stack, World world, EntityPlayer player) {
/*  95 */     if (!world.field_72995_K) {
/*  96 */       Vec3 vec = player.func_70040_Z();
/*  97 */       SpacePod01Entity SpacePod01Entity = new SpacePod01Entity(world);
/*  98 */       SpacePod01Entity.func_70012_b(player.field_70165_t + vec.field_72450_a * 1.5D, player.field_70163_u + 1.0D + vec.field_72448_b * 1.5D, player.field_70161_v + vec.field_72449_c * 1.5D, player.field_70177_z, 0.0F);
/*  99 */       world.func_72838_d(SpacePod01Entity);
/*     */       
/* 101 */       ItemStack[] inv = player.field_71071_by.field_70462_a;
/* 102 */       int id = 0;
/* 103 */       for (ItemStack invStack : inv) {
/* 104 */         if (invStack != null && invStack.equals(stack)) {
/*     */           
/* 106 */           player.field_71071_by.field_70462_a[id] = null;
/*     */           break;
/*     */         } 
/* 109 */         id++;
/*     */       } 
/*     */     } 
/* 112 */     return stack;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Render\SpacePod01Item.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */