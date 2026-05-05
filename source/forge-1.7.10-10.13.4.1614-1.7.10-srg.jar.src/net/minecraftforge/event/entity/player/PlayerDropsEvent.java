/*    */ package net.minecraftforge.event.entity.player;
/*    */ 
/*    */ import cpw.mods.fml.common.eventhandler.Cancelable;
/*    */ import java.util.ArrayList;
/*    */ import net.minecraft.enchantment.EnchantmentHelper;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.item.EntityItem;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.util.DamageSource;
/*    */ import net.minecraftforge.event.entity.living.LivingDropsEvent;
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
/*    */ @Cancelable
/*    */ public class PlayerDropsEvent
/*    */   extends LivingDropsEvent
/*    */ {
/*    */   public final EntityPlayer entityPlayer;
/*    */   
/*    */   public PlayerDropsEvent(EntityPlayer entity, DamageSource source, ArrayList<EntityItem> drops, boolean recentlyHit) {
/* 32 */     super((EntityLivingBase)entity, source, drops, 
/* 33 */         (source.getEntity() instanceof EntityPlayer) ? 
/* 34 */         EnchantmentHelper.getLootingModifier((EntityLivingBase)source.getEntity()) : 0, recentlyHit, 0);
/*    */ 
/*    */     
/* 37 */     this.entityPlayer = entity;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\event\entity\player\PlayerDropsEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */