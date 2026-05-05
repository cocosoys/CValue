/*     */ package JinRyuu.JRMCore.p.YC;
/*     */ 
/*     */ import JinRyuu.JRMCore.JRMCoreH;
/*     */ import JinRyuu.JRMCore.JYearsCH;
/*     */ import JinRyuu.JRMCore.p.BAmh;
/*     */ import cpw.mods.fml.common.network.ByteBufUtils;
/*     */ import cpw.mods.fml.common.network.simpleimpl.IMessage;
/*     */ import cpw.mods.fml.common.network.simpleimpl.MessageContext;
/*     */ import io.netty.buffer.ByteBuf;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.util.ChatComponentText;
/*     */ import net.minecraft.util.IChatComponent;
/*     */ 
/*     */ public class JYearsCP
/*     */   implements IMessage {
/*     */   public int jycdatey;
/*     */   public int jycdatem;
/*     */   public int jycdated;
/*     */   public String jycp;
/*     */   public int jycpy;
/*     */   
/*     */   public JYearsCP() {}
/*     */   
/*     */   public JYearsCP(int jycdatey, int jycdatem, int jycdated, String jycp, int jycpy) {
/*  26 */     this.jycdatey = jycdatey;
/*  27 */     this.jycdatem = jycdatem;
/*  28 */     this.jycdated = jycdated;
/*  29 */     this.jycp = jycp;
/*  30 */     this.jycpy = jycpy;
/*     */   }
/*     */ 
/*     */   
/*     */   public void toBytes(ByteBuf buffer) {
/*  35 */     buffer.writeInt(this.jycdatey);
/*  36 */     buffer.writeShort(this.jycdatem);
/*  37 */     buffer.writeShort(this.jycdated);
/*  38 */     ByteBufUtils.writeUTF8String(buffer, this.jycp);
/*  39 */     buffer.writeInt(this.jycpy);
/*     */   }
/*     */ 
/*     */   
/*     */   public void fromBytes(ByteBuf buffer) {
/*  44 */     this.jycdatey = buffer.readInt();
/*  45 */     this.jycdatem = buffer.readShort();
/*  46 */     this.jycdated = buffer.readShort();
/*  47 */     this.jycp = ByteBufUtils.readUTF8String(buffer);
/*  48 */     this.jycpy = buffer.readInt();
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
/*     */   public static class Handler
/*     */     extends BAmh<JYearsCP>
/*     */   {
/*     */     public IMessage handleClientMessage(EntityPlayer player, JYearsCP m, MessageContext ctx) {
/*  74 */       EntityPlayer Player = player;
/*  75 */       JYearsCH.y = m.jycdatey;
/*  76 */       JYearsCH.m = m.jycdatem;
/*  77 */       JYearsCH.d = m.jycdated;
/*  78 */       JYearsCH.py = m.jycpy;
/*  79 */       if (m.jycp == "::") {
/*  80 */         JYearsCH.p = null;
/*     */       } else {
/*  82 */         JYearsCH.p = m.jycp.toString().replaceAll("::", "").split(":");
/*     */       } 
/*     */       
/*  85 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public IMessage handleServerMessage(EntityPlayer Player, JYearsCP m, MessageContext ctx) {
/*  91 */       if (m.jycpy == 1)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*  99 */         if (Player.field_71071_by.func_146028_b(Items.field_151166_bC))
/* 100 */         { Player.field_71071_by.field_70459_e = true;
/* 101 */           Player.field_71071_by.func_146026_a(Items.field_151166_bC);
/* 102 */           Player.field_71071_by.field_70459_e = false;
/* 103 */           JRMCoreH.setFloat(0, Player, "JRYCAge"); }
/* 104 */         else { Player.func_145747_a((IChatComponent)new ChatComponentText("You need an Emerald to use Rebirth!")); }
/*     */       
/*     */       }
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
/* 135 */       return null;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\p\YC\JYearsCP.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */