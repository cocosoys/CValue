/*    */ package net.minecraft.item;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import net.minecraft.block.BlockJukebox;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.util.IIcon;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class ItemRecord extends Item {
/* 14 */   private static final Map field_150928_b = new HashMap<Object, Object>();
/*    */   public final String field_150929_a;
/*    */   private static final String __OBFID = "CL_00000057";
/*    */   
/*    */   protected ItemRecord(String p_i45350_1_) {
/* 19 */     this.field_150929_a = p_i45350_1_;
/* 20 */     this.field_77777_bU = 1;
/* 21 */     func_77637_a(CreativeTabs.field_78026_f);
/*    */     
/* 23 */     field_150928_b.put(p_i45350_1_, this);
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public IIcon func_77617_a(int p_77617_1_) {
/* 28 */     return this.field_77791_bV;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_77648_a(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
/* 33 */     if (p_77648_3_.func_147439_a(p_77648_4_, p_77648_5_, p_77648_6_) == Blocks.field_150421_aI && p_77648_3_.func_72805_g(p_77648_4_, p_77648_5_, p_77648_6_) == 0) {
/* 34 */       if (p_77648_3_.field_72995_K) return true;
/*    */       
/* 36 */       ((BlockJukebox)Blocks.field_150421_aI).func_149926_b(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_, p_77648_1_);
/* 37 */       p_77648_3_.func_72889_a(null, 1005, p_77648_4_, p_77648_5_, p_77648_6_, Item.func_150891_b(this));
/* 38 */       p_77648_1_.field_77994_a--;
/* 39 */       return true;
/*    */     } 
/* 41 */     return false;
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_77624_a(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List<String> p_77624_3_, boolean p_77624_4_) {
/* 46 */     p_77624_3_.add(func_150927_i());
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public String func_150927_i() {
/* 50 */     return StatCollector.func_74838_a("item.record." + this.field_150929_a + ".desc");
/*    */   }
/*    */ 
/*    */   
/*    */   public EnumRarity func_77613_e(ItemStack p_77613_1_) {
/* 55 */     return EnumRarity.rare;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public static ItemRecord func_150926_b(String p_150926_0_) {
/* 59 */     return (ItemRecord)field_150928_b.get(p_150926_0_);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\item\ItemRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */