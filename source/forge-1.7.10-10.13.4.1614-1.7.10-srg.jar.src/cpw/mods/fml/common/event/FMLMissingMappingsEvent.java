/*     */ package cpw.mods.fml.common.event;
/*     */ 
/*     */ import com.google.common.collect.ImmutableList;
/*     */ import com.google.common.collect.ListMultimap;
/*     */ import cpw.mods.fml.common.ModContainer;
/*     */ import cpw.mods.fml.common.registry.GameData;
/*     */ import cpw.mods.fml.common.registry.GameRegistry;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.item.Item;
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
/*     */ public class FMLMissingMappingsEvent
/*     */   extends FMLEvent
/*     */ {
/*     */   private ListMultimap<String, MissingMapping> missing;
/*     */   private ModContainer activeContainer;
/*     */   
/*     */   public enum Action
/*     */   {
/*  39 */     DEFAULT,
/*     */ 
/*     */ 
/*     */     
/*  43 */     IGNORE,
/*     */ 
/*     */ 
/*     */     
/*  47 */     WARN,
/*     */ 
/*     */ 
/*     */     
/*  51 */     FAIL,
/*     */ 
/*     */ 
/*     */     
/*  55 */     REMAP,
/*     */ 
/*     */ 
/*     */     
/*  59 */     BLOCKONLY; }
/*     */   
/*     */   public static class MissingMapping {
/*     */     public final GameRegistry.Type type;
/*     */     public final String name;
/*     */     public final int id;
/*  65 */     private FMLMissingMappingsEvent.Action action = FMLMissingMappingsEvent.Action.DEFAULT;
/*     */     
/*     */     private Object target;
/*     */     
/*     */     public MissingMapping(String name, int id) {
/*  70 */       this.type = (name.charAt(0) == '\001') ? GameRegistry.Type.BLOCK : GameRegistry.Type.ITEM;
/*  71 */       this.name = name.substring(1);
/*  72 */       this.id = id;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @Deprecated
/*     */     public void setAction(FMLMissingMappingsEvent.Action target) {
/*  80 */       if (target == FMLMissingMappingsEvent.Action.DEFAULT || target == FMLMissingMappingsEvent.Action.REMAP || target == FMLMissingMappingsEvent.Action.BLOCKONLY) throw new IllegalArgumentException();
/*     */       
/*  82 */       this.action = target;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void ignore() {
/*  90 */       this.action = FMLMissingMappingsEvent.Action.IGNORE;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void warn() {
/*  98 */       this.action = FMLMissingMappingsEvent.Action.WARN;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void fail() {
/* 106 */       this.action = FMLMissingMappingsEvent.Action.FAIL;
/*     */     }
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
/*     */     public void remap(Block target) {
/* 119 */       if (this.type != GameRegistry.Type.BLOCK) throw new IllegalArgumentException("Can't remap an item to a block."); 
/* 120 */       if (target == null) throw new NullPointerException("remap target is null"); 
/* 121 */       if (GameData.getBlockRegistry().getId(target) < 0) throw new IllegalArgumentException(String.format("The specified block %s hasn't been registered at startup.", new Object[] { target }));
/*     */       
/* 123 */       this.action = FMLMissingMappingsEvent.Action.REMAP;
/* 124 */       this.target = target;
/*     */     }
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
/*     */     public void remap(Item target) {
/* 137 */       if (this.type != GameRegistry.Type.ITEM) throw new IllegalArgumentException("Can't remap a block to an item."); 
/* 138 */       if (target == null) throw new NullPointerException("remap target is null"); 
/* 139 */       if (GameData.getItemRegistry().getId(target) < 0) throw new IllegalArgumentException(String.format("The specified item %s hasn't been registered at startup.", new Object[] { target }));
/*     */       
/* 141 */       this.action = FMLMissingMappingsEvent.Action.REMAP;
/* 142 */       this.target = target;
/*     */     }
/*     */ 
/*     */     
/*     */     public void skipItemBlock() {
/* 147 */       if (this.type != GameRegistry.Type.ITEM) throw new IllegalArgumentException("Cannot skip an item that is a block"); 
/* 148 */       if (GameData.getBlockRegistry().getRaw(this.id) == null) throw new IllegalArgumentException("Cannot skip an ItemBlock that doesn't have a Block"); 
/* 149 */       this.action = FMLMissingMappingsEvent.Action.BLOCKONLY;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public FMLMissingMappingsEvent.Action getAction() {
/* 155 */       return this.action;
/*     */     }
/*     */ 
/*     */     
/*     */     public Object getTarget() {
/* 160 */       return this.target;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FMLMissingMappingsEvent(ListMultimap<String, MissingMapping> missingMappings) {
/* 168 */     this.missing = missingMappings;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void applyModContainer(ModContainer activeContainer) {
/* 174 */     super.applyModContainer(activeContainer);
/* 175 */     this.activeContainer = activeContainer;
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
/*     */   public List<MissingMapping> get() {
/* 187 */     return (List<MissingMapping>)ImmutableList.copyOf(this.missing.get(this.activeContainer.getModId()));
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
/*     */   public List<MissingMapping> getAll() {
/* 203 */     return (List<MissingMapping>)ImmutableList.copyOf(this.missing.values());
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\event\FMLMissingMappingsEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */