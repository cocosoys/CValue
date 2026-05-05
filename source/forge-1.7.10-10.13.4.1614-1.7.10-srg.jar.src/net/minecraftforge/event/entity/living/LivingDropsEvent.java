/*    */ package net.minecraftforge.event.entity.living;
/*    */ 
/*    */ import cpw.mods.fml.common.eventhandler.Cancelable;
/*    */ import java.util.ArrayList;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.item.EntityItem;
/*    */ import net.minecraft.util.DamageSource;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Cancelable
/*    */ public class LivingDropsEvent
/*    */   extends LivingEvent
/*    */ {
/*    */   public final DamageSource source;
/*    */   public final ArrayList<EntityItem> drops;
/*    */   public final int lootingLevel;
/*    */   public final boolean recentlyHit;
/*    */   public final int specialDropValue;
/*    */   
/*    */   public LivingDropsEvent(EntityLivingBase entity, DamageSource source, ArrayList<EntityItem> drops, int lootingLevel, boolean recentlyHit, int specialDropValue) {
/* 41 */     super(entity);
/* 42 */     this.source = source;
/* 43 */     this.drops = drops;
/* 44 */     this.lootingLevel = lootingLevel;
/* 45 */     this.recentlyHit = recentlyHit;
/* 46 */     this.specialDropValue = specialDropValue;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\event\entity\living\LivingDropsEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */