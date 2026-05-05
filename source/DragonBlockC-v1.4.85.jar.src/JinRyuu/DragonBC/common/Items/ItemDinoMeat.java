/*    */ package JinRyuu.DragonBC.common.Items;
/*    */ 
/*    */ import JinRyuu.DragonBC.common.mod_DragonBC;
/*    */ import JinRyuu.JRMCore.JRMCoreH;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.List;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.init.Items;
/*    */ import net.minecraft.item.ItemFood;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.StatCollector;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class ItemDinoMeat
/*    */   extends ItemFood {
/* 19 */   private float l = 1.0F;
/*    */ 
/*    */ 
/*    */   
/*    */   public ItemDinoMeat(int par2, float f, float l) {
/* 24 */     super(par2, f, true);
/* 25 */     func_77625_d(16);
/* 26 */     func_77637_a(mod_DragonBC.DragonBlockC);
/* 27 */     func_77848_i();
/* 28 */     this.l = l;
/*    */   }
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_77624_a(ItemStack stack, EntityPlayer player, List<String> list, boolean par4) {
/* 34 */     String[] names = { "item.ItemDinoMeat", "item.ItemDinoMeatCooked", "item.ItemDinoMeatBig", "item.ItemDinoMeatCookedBig" };
/* 35 */     int[] values1 = { 10, 20, 15, 30 };
/* 36 */     int[] values2 = { 500, 1000, 750, 1500 };
/*    */     
/* 38 */     for (int i = 0; i < names.length; i++) {
/*    */       
/* 40 */       if (stack.func_77973_b().func_77658_a().equals(names[i])) {
/*    */         
/* 42 */         String text = StatCollector.func_74838_a("dbc.ItemDinoMeat.line1");
/*    */         
/* 44 */         if (text.contains("%1$s")) {
/*    */           
/* 46 */           text = JRMCoreH.trl("dbc.ItemDinoMeat.line1", new Object[] { JRMCoreH.format_lz2(new Object[] { Integer.valueOf(values2[i]) }) });
/*    */         }
/* 48 */         else if (i > 0) {
/*    */           
/* 50 */           text = text.replace("10", "" + values1[i]).replace("500", "" + values2[i]);
/*    */         } 
/* 52 */         list.add(text);
/*    */         return;
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public String getTextureFile() {
/* 60 */     return "jinryuudragonbc:";
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_94581_a(IIconRegister iconRegister) {
/* 66 */     this.field_77791_bV = iconRegister.func_94245_a("jinryuudragonbc:" + func_77658_a());
/*    */   }
/*    */ 
/*    */   
/*    */   public ItemStack func_77654_b(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
/* 71 */     super.func_77654_b(par1ItemStack, par2World, par3EntityPlayer);
/* 72 */     par3EntityPlayer.field_71071_by.func_70441_a(new ItemStack(Items.field_151103_aS));
/* 73 */     return par1ItemStack;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_77849_c(ItemStack par1ItemStack, World par2World, EntityPlayer player) {
/* 78 */     if (!par2World.field_72995_K) {
/*    */       
/* 80 */       int[] PlyrAttrbts = JRMCoreH.PlyrAttrbts(player);
/* 81 */       byte pwr = JRMCoreH.getByte(player, "jrmcPwrtyp");
/* 82 */       byte rce = JRMCoreH.getByte(player, "jrmcRace");
/* 83 */       byte cls = JRMCoreH.getByte(player, "jrmcClass");
/* 84 */       int maxBody = JRMCoreH.stat((Entity)player, 2, pwr, 2, PlyrAttrbts[2], rce, cls, 0.0F);
/* 85 */       int curBody = JRMCoreH.getInt(player, "jrmcBdy");
/* 86 */       int maxEnergy = JRMCoreH.stat((Entity)player, 5, pwr, 5, PlyrAttrbts[5], rce, cls, JRMCoreH.SklLvl_KiBs(player, pwr));
/* 87 */       int curEnergy = JRMCoreH.getInt(player, "jrmcEnrgy");
/* 88 */       int maxStam = JRMCoreH.stat((Entity)player, 2, pwr, 3, PlyrAttrbts[2], rce, cls, 0.0F);
/* 89 */       int curStam = JRMCoreH.getInt(player, "jrmcStamina");
/*    */       
/* 91 */       int body = (int)(curBody + ((maxBody * 0.3F > 500.0F) ? 500.0F : (maxBody * 0.3F)) * this.l);
/* 92 */       JRMCoreH.setInt((body > maxBody) ? maxBody : body, player, "jrmcBdy");
/* 93 */       int en = (int)(curEnergy + ((maxEnergy * 0.2F > 500.0F) ? 500.0F : (maxEnergy * 0.2F)) * this.l);
/* 94 */       JRMCoreH.setInt((en > maxEnergy) ? maxEnergy : en, player, "jrmcEnrgy");
/* 95 */       int st = (int)(curStam + ((maxStam * 0.2F > 500.0F) ? 500.0F : (maxStam * 0.2F)) * this.l);
/* 96 */       JRMCoreH.setInt((st > maxStam) ? maxStam : st, player, "jrmcStamina");
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Items\ItemDinoMeat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */