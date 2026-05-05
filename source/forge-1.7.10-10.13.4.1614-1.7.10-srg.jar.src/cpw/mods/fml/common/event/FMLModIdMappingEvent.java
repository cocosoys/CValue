/*    */ package cpw.mods.fml.common.event;
/*    */ 
/*    */ import com.google.common.collect.ImmutableList;
/*    */ import com.google.common.collect.Lists;
/*    */ import java.util.Collections;
/*    */ import java.util.Comparator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ 
/*    */ public class FMLModIdMappingEvent extends FMLEvent {
/*    */   public final ImmutableList<ModRemapping> remappedIds;
/*    */   
/* 13 */   public enum RemapTarget { BLOCK, ITEM; }
/*    */   
/*    */   public class ModRemapping {
/*    */     public final int oldId;
/*    */     public final int newId;
/*    */     public final String tag;
/*    */     public final FMLModIdMappingEvent.RemapTarget remapTarget;
/*    */     
/*    */     public ModRemapping(int oldId, int newId, String tag) {
/* 22 */       this.oldId = oldId;
/* 23 */       this.newId = newId;
/* 24 */       this.tag = tag.substring(1);
/* 25 */       this.remapTarget = (tag.charAt(0) == '\001') ? FMLModIdMappingEvent.RemapTarget.BLOCK : FMLModIdMappingEvent.RemapTarget.ITEM;
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public FMLModIdMappingEvent(Map<String, Integer[]> mappings) {
/* 33 */     List<ModRemapping> remappings = Lists.newArrayList();
/* 34 */     for (Map.Entry<String, Integer[]> mapping : mappings.entrySet())
/*    */     {
/* 36 */       remappings.add(new ModRemapping(((Integer[])mapping.getValue())[0].intValue(), ((Integer[])mapping.getValue())[1].intValue(), mapping.getKey()));
/*    */     }
/*    */     
/* 39 */     Collections.sort(remappings, new Comparator<ModRemapping>()
/*    */         {
/*    */           public int compare(FMLModIdMappingEvent.ModRemapping o1, FMLModIdMappingEvent.ModRemapping o2)
/*    */           {
/* 43 */             return (o1.newId < o2.newId) ? -1 : ((o1.newId == o2.newId) ? 0 : 1);
/*    */           }
/*    */         });
/* 46 */     this.remappedIds = ImmutableList.copyOf(remappings);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\event\FMLModIdMappingEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */