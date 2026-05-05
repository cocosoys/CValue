/*    */ package net.minecraft.item;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.item.EntityFireworkRocket;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ import net.minecraft.nbt.NBTTagList;
/*    */ import net.minecraft.util.StatCollector;
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
/*    */ public class ItemFirework
/*    */   extends Item
/*    */ {
/*    */   private static final String __OBFID = "CL_00000031";
/*    */   
/*    */   public boolean func_77648_a(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
/* 35 */     if (!p_77648_3_.field_72995_K) {
/*    */ 
/*    */       
/* 38 */       EntityFireworkRocket entityFireworkRocket = new EntityFireworkRocket(p_77648_3_, (p_77648_4_ + p_77648_8_), (p_77648_5_ + p_77648_9_), (p_77648_6_ + p_77648_10_), p_77648_1_);
/* 39 */       p_77648_3_.func_72838_d((Entity)entityFireworkRocket);
/*    */       
/* 41 */       if (!p_77648_2_.field_71075_bZ.field_75098_d) {
/* 42 */         p_77648_1_.field_77994_a--;
/*    */       }
/* 44 */       return true;
/*    */     } 
/*    */     
/* 47 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_77624_a(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List<String> p_77624_3_, boolean p_77624_4_) {
/* 53 */     if (!p_77624_1_.func_77942_o()) {
/*    */       return;
/*    */     }
/* 56 */     NBTTagCompound nBTTagCompound = p_77624_1_.func_77978_p().func_74775_l("Fireworks");
/* 57 */     if (nBTTagCompound == null) {
/*    */       return;
/*    */     }
/* 60 */     if (nBTTagCompound.func_150297_b("Flight", 99)) {
/* 61 */       p_77624_3_.add(StatCollector.func_74838_a("item.fireworks.flight") + " " + nBTTagCompound.func_74771_c("Flight"));
/*    */     }
/*    */ 
/*    */     
/* 65 */     NBTTagList nBTTagList = nBTTagCompound.func_150295_c("Explosions", 10);
/* 66 */     if (nBTTagList != null && nBTTagList.func_74745_c() > 0)
/*    */     {
/* 68 */       for (byte b = 0; b < nBTTagList.func_74745_c(); b++) {
/* 69 */         NBTTagCompound nBTTagCompound1 = nBTTagList.func_150305_b(b);
/*    */         
/* 71 */         ArrayList<String> arrayList = new ArrayList();
/* 72 */         ItemFireworkCharge.func_150902_a(nBTTagCompound1, arrayList);
/*    */         
/* 74 */         if (arrayList.size() > 0) {
/* 75 */           for (byte b1 = 1; b1 < arrayList.size(); b1++) {
/* 76 */             arrayList.set(b1, "  " + (String)arrayList.get(b1));
/*    */           }
/*    */           
/* 79 */           p_77624_3_.addAll(arrayList);
/*    */         } 
/*    */       } 
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\item\ItemFirework.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */