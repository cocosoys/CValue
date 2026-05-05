/*     */ package JinRyuu.DragonBC.common.Blocks;
/*     */ 
/*     */ import JinRyuu.DragonBC.common.Worlds.WorldTeleporterDBCTelep;
/*     */ import JinRyuu.JRMCore.JRMCoreH;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.ChatComponentText;
/*     */ import net.minecraft.util.IChatComponent;
/*     */ import net.minecraft.util.StatCollector;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.Teleporter;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class BlockTCPort extends Block {
/*     */   public BlockTCPort() {
/*  24 */     super(Material.field_151573_f);
/*  25 */     func_149722_s();
/*  26 */     func_149752_b(6000000.0F);
/*     */   }
/*     */   
/*     */   public String getTextureFile() {
/*  30 */     return "jinryuudragonbc:";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_149701_w() {
/*  39 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149662_c() {
/*  48 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149686_d() {
/*  56 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149678_a(int par1, boolean par2) {
/*  63 */     return false;
/*     */   }
/*     */   
/*     */   public AxisAlignedBB func_149668_a(World par1World, int par2, int par3, int par4) {
/*  67 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_149747_d(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5) {
/*  75 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149651_a(IIconRegister par1IconRegister) {
/*  81 */     this.field_149761_L = par1IconRegister.func_94245_a("jinryuudragonbc:" + func_149739_a());
/*     */   }
/*     */ 
/*     */   
/*     */   public int idDropped(int par1, Random par2Random, int par3) {
/*  86 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_149670_a(World par1World, int par2, int par3, int par4, Entity par5Entity) {
/*  92 */     if (par5Entity != null && par5Entity instanceof EntityPlayerMP && par5Entity.field_70154_o == null && par5Entity.field_70153_n == null) {
/*     */ 
/*     */       
/*  95 */       EntityPlayerMP playerMP = (EntityPlayerMP)par5Entity;
/*  96 */       if (playerMP.field_71093_bK == 0 && par2 == 77 && par3 == 217 && par4 == 8) {
/*  97 */         short s = JRMCoreH.getShort((EntityPlayer)playerMP, "jrmcHTCTmO");
/*  98 */         short s1 = (short)JRMCoreH.getByte((EntityPlayer)playerMP, "jrmcMsg");
/*  99 */         if (s == 0) {
/* 100 */           playerMP.field_71133_b.func_71203_ab().transferPlayerToDimension(playerMP, 23, (Teleporter)new WorldTeleporterDBCTelep(playerMP.field_71133_b.func_71218_a(23)));
/*     */ 
/*     */           
/* 103 */           playerMP.field_71135_a.func_147364_a(55.0D, 35.0D, 11.0D, 0.0F, 0.0F);
/*     */           
/* 105 */           playerMP.func_71023_q(1);
/* 106 */         } else if (s1 == 0) {
/* 107 */           short m = (short)(s / 120);
/* 108 */           String t1 = JRMCoreH.cly + StatCollector.func_74838_a("dbc.timechamber.waitillenter");
/* 109 */           String t2 = JRMCoreH.cly + StatCollector.func_74838_a("dbc.timechamber.waitillenter.sec");
/* 110 */           String t3 = JRMCoreH.cly + StatCollector.func_74838_a("dbc.timechamber.waitillenter.min");
/* 111 */           String t4 = (m <= 0) ? ("" + (s / 2) + " " + t2) : ("" + m + " " + t3);
/* 112 */           String tf = String.format(JRMCoreH.cldr + t1, new Object[] { JRMCoreH.cldr + t4 });
/* 113 */           playerMP.func_145747_a((IChatComponent)new ChatComponentText(tf));
/* 114 */           JRMCoreH.setByte(1, (EntityPlayer)playerMP, "jrmcMsg");
/*     */         } 
/*     */       } 
/* 117 */       if (playerMP.field_71093_bK == 23 && (par2 == 55 || par2 == 54) && par3 == 35 && par4 == 8) {
/* 118 */         playerMP.field_71133_b.func_71203_ab().transferPlayerToDimension(playerMP, 0, (Teleporter)new WorldTeleporterDBCTelep(playerMP.field_71133_b.func_71218_a(0)));
/*     */ 
/*     */         
/* 121 */         playerMP.field_71135_a.func_147364_a(77.5D, 217.0D, 10.5D, 0.0F, 0.0F);
/*     */         
/* 123 */         playerMP.func_71023_q(1);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Blocks\BlockTCPort.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */