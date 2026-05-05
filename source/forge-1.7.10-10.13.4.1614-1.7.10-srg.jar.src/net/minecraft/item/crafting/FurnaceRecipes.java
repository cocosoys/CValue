/*    */ package net.minecraft.item.crafting;
/*    */ import java.util.Map;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.init.Items;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemFishFood;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public class FurnaceRecipes {
/* 11 */   private static final FurnaceRecipes field_77606_a = new FurnaceRecipes();
/*    */   
/* 13 */   private Map field_77604_b = new HashMap<Object, Object>();
/* 14 */   private Map field_77605_c = new HashMap<Object, Object>(); private static final String __OBFID = "CL_00000085";
/*    */   
/*    */   public static FurnaceRecipes func_77602_a() {
/* 17 */     return field_77606_a;
/*    */   }
/*    */ 
/*    */   
/*    */   private FurnaceRecipes() {
/* 22 */     func_151393_a(Blocks.field_150366_p, new ItemStack(Items.field_151042_j), 0.7F);
/* 23 */     func_151393_a(Blocks.field_150352_o, new ItemStack(Items.field_151043_k), 1.0F);
/* 24 */     func_151393_a(Blocks.field_150482_ag, new ItemStack(Items.field_151045_i), 1.0F);
/* 25 */     func_151393_a((Block)Blocks.field_150354_m, new ItemStack(Blocks.field_150359_w), 0.1F);
/*    */ 
/*    */     
/* 28 */     func_151396_a(Items.field_151147_al, new ItemStack(Items.field_151157_am), 0.35F);
/* 29 */     func_151396_a(Items.field_151082_bd, new ItemStack(Items.field_151083_be), 0.35F);
/* 30 */     func_151396_a(Items.field_151076_bf, new ItemStack(Items.field_151077_bg), 0.35F);
/* 31 */     func_151393_a(Blocks.field_150347_e, new ItemStack(Blocks.field_150348_b), 0.1F);
/* 32 */     func_151396_a(Items.field_151119_aD, new ItemStack(Items.field_151118_aC), 0.3F);
/* 33 */     func_151393_a(Blocks.field_150435_aG, new ItemStack(Blocks.field_150405_ch), 0.35F);
/* 34 */     func_151393_a(Blocks.field_150434_aF, new ItemStack(Items.field_151100_aR, 1, 2), 0.2F);
/* 35 */     func_151393_a(Blocks.field_150364_r, new ItemStack(Items.field_151044_h, 1, 1), 0.15F);
/* 36 */     func_151393_a(Blocks.field_150363_s, new ItemStack(Items.field_151044_h, 1, 1), 0.15F);
/* 37 */     func_151393_a(Blocks.field_150412_bA, new ItemStack(Items.field_151166_bC), 1.0F);
/* 38 */     func_151396_a(Items.field_151174_bG, new ItemStack(Items.field_151168_bH), 0.35F);
/* 39 */     func_151393_a(Blocks.field_150424_aL, new ItemStack(Items.field_151130_bT), 0.1F);
/*    */     
/* 41 */     for (ItemFishFood.FishType fishType : ItemFishFood.FishType.values()) {
/* 42 */       if (fishType.func_150973_i()) {
/* 43 */         func_151394_a(new ItemStack(Items.field_151115_aP, 1, fishType.func_150976_a()), new ItemStack(Items.field_151101_aQ, 1, fishType.func_150976_a()), 0.35F);
/*    */       }
/*    */     } 
/*    */ 
/*    */ 
/*    */     
/* 49 */     func_151393_a(Blocks.field_150365_q, new ItemStack(Items.field_151044_h), 0.1F);
/* 50 */     func_151393_a(Blocks.field_150450_ax, new ItemStack(Items.field_151137_ax), 0.7F);
/*    */     
/* 52 */     func_151393_a(Blocks.field_150369_x, new ItemStack(Items.field_151100_aR, 1, 4), 0.2F);
/* 53 */     func_151393_a(Blocks.field_150449_bY, new ItemStack(Items.field_151128_bU), 0.2F);
/*    */   }
/*    */   
/*    */   public void func_151393_a(Block p_151393_1_, ItemStack p_151393_2_, float p_151393_3_) {
/* 57 */     func_151396_a(Item.func_150898_a(p_151393_1_), p_151393_2_, p_151393_3_);
/*    */   }
/*    */   
/*    */   public void func_151396_a(Item p_151396_1_, ItemStack p_151396_2_, float p_151396_3_) {
/* 61 */     func_151394_a(new ItemStack(p_151396_1_, 1, 32767), p_151396_2_, p_151396_3_);
/*    */   }
/*    */   
/*    */   public void func_151394_a(ItemStack p_151394_1_, ItemStack p_151394_2_, float p_151394_3_) {
/* 65 */     this.field_77604_b.put(p_151394_1_, p_151394_2_);
/* 66 */     this.field_77605_c.put(p_151394_2_, Float.valueOf(p_151394_3_));
/*    */   }
/*    */   
/*    */   public ItemStack func_151395_a(ItemStack p_151395_1_) {
/* 70 */     for (Map.Entry entry : this.field_77604_b.entrySet()) {
/* 71 */       if (func_151397_a(p_151395_1_, (ItemStack)entry.getKey())) {
/* 72 */         return (ItemStack)entry.getValue();
/*    */       }
/*    */     } 
/*    */     
/* 76 */     return null;
/*    */   }
/*    */   
/*    */   private boolean func_151397_a(ItemStack p_151397_1_, ItemStack p_151397_2_) {
/* 80 */     return (p_151397_2_.func_77973_b() == p_151397_1_.func_77973_b() && (p_151397_2_.func_77960_j() == 32767 || p_151397_2_.func_77960_j() == p_151397_1_.func_77960_j()));
/*    */   }
/*    */   
/*    */   public Map func_77599_b() {
/* 84 */     return this.field_77604_b;
/*    */   }
/*    */   
/*    */   public float func_151398_b(ItemStack p_151398_1_) {
/* 88 */     for (Map.Entry entry : this.field_77605_c.entrySet()) {
/* 89 */       if (func_151397_a(p_151398_1_, (ItemStack)entry.getKey())) {
/* 90 */         return ((Float)entry.getValue()).floatValue();
/*    */       }
/*    */     } 
/* 93 */     return 0.0F;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\item\crafting\FurnaceRecipes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */