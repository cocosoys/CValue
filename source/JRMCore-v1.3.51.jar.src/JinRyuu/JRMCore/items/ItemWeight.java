/*     */ package JinRyuu.JRMCore.items;
/*     */ 
/*     */ import JinRyuu.JRMCore.JRMCoreH;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class ItemWeight
/*     */   extends Item
/*     */ {
/*  17 */   private float weight = 0.0F;
/*     */ 
/*     */   
/*     */   public ItemWeight(int weight) {
/*  21 */     this.weight = weight;
/*  22 */     this.field_77777_bU = 1;
/*  23 */     func_77656_e(100);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_94581_a(IIconRegister par1IconRegister) {
/*  34 */     this.field_77791_bV = par1IconRegister.func_94245_a(JRMCoreH.tjjrmc + ":" + func_77658_a());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void data() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_77624_a(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List<String> p_77624_3_, boolean p_77624_4_) {
/*  51 */     super.func_77624_a(p_77624_1_, p_77624_2_, p_77624_3_, p_77624_4_);
/*  52 */     float w = JRMCoreH.getItemWeight(p_77624_1_);
/*  53 */     if (w > 0.0F) {
/*  54 */       p_77624_3_.add(JRMCoreH.trl("jrmc", "trainingweight") + ": " + w);
/*     */     } else {
/*  56 */       String[] s = JRMCoreH.trl("jrmc", "trainingweightno").split(";");
/*  57 */       for (int i = 0; i < s.length; i++) {
/*  58 */         p_77624_3_.add(s[i]);
/*     */       }
/*     */     } 
/*     */   }
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
/*     */   
/*     */   public void func_77663_a(ItemStack p_77663_1_, World p_77663_2_, Entity p_77663_3_, int p_77663_4_, boolean p_77663_5_) {
/*  95 */     super.func_77663_a(p_77663_1_, p_77663_2_, p_77663_3_, p_77663_4_, p_77663_5_);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_77622_d(ItemStack p_77622_1_, World p_77622_2_, EntityPlayer p_77622_3_) {
/* 106 */     super.func_77622_d(p_77622_1_, p_77622_2_, p_77622_3_);
/* 107 */     JRMCoreH.addItemWeightStats(p_77622_1_, new Object[] { Integer.valueOf(5) });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_77648_a(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
/* 118 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\items\ItemWeight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */