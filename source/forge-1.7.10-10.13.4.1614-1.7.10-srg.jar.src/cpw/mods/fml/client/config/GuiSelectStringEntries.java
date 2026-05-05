/*     */ package cpw.mods.fml.client.config;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.GuiListExtended;
/*     */ import net.minecraft.client.renderer.Tessellator;
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
/*     */ public class GuiSelectStringEntries
/*     */   extends GuiListExtended
/*     */ {
/*     */   public GuiSelectString owningScreen;
/*     */   public Minecraft mc;
/*     */   public IConfigElement configElement;
/*     */   public List<IGuiSelectStringListEntry> listEntries;
/*     */   public final Map<Object, String> selectableValues;
/*  41 */   public int selectedIndex = -1;
/*  42 */   public int maxEntryWidth = 0;
/*     */ 
/*     */ 
/*     */   
/*     */   public GuiSelectStringEntries(GuiSelectString owningScreen, Minecraft mc, IConfigElement configElement, Map<Object, String> selectableValues) {
/*  47 */     super(mc, owningScreen.width, owningScreen.height, (owningScreen.titleLine2 != null) ? ((owningScreen.titleLine3 != null) ? 43 : 33) : 23, owningScreen.height - 32, 11);
/*     */     
/*  49 */     this.owningScreen = owningScreen;
/*  50 */     this.mc = mc;
/*  51 */     this.configElement = configElement;
/*  52 */     this.selectableValues = selectableValues;
/*  53 */     setShowSelectionBox(true);
/*     */     
/*  55 */     this.listEntries = new ArrayList<IGuiSelectStringListEntry>();
/*     */     
/*  57 */     int index = 0;
/*  58 */     List<Map.Entry<Object, String>> sortedList = new ArrayList<Map.Entry<Object, String>>(selectableValues.entrySet());
/*  59 */     Collections.sort(sortedList, new EntryComparator());
/*     */     
/*  61 */     for (Map.Entry<Object, String> entry : sortedList) {
/*     */       
/*  63 */       this.listEntries.add(new ListEntry(this, entry));
/*  64 */       if (mc.fontRenderer.getStringWidth((String)entry.getValue()) > this.maxEntryWidth) {
/*  65 */         this.maxEntryWidth = mc.fontRenderer.getStringWidth(entry.getValue());
/*     */       }
/*  67 */       if (owningScreen.currentValue.equals(entry.getKey()))
/*     */       {
/*  69 */         this.selectedIndex = index;
/*     */       }
/*     */       
/*  72 */       index++;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static class EntryComparator
/*     */     implements Comparator<Map.Entry<Object, String>>
/*     */   {
/*     */     public int compare(Map.Entry<Object, String> o1, Map.Entry<Object, String> o2) {
/*  81 */       int compare = ((String)o1.getValue()).toLowerCase(Locale.US).compareTo(((String)o2.getValue()).toLowerCase(Locale.US));
/*     */       
/*  83 */       if (compare == 0) {
/*  84 */         compare = o1.getKey().toString().toLowerCase(Locale.US).compareTo(o2.getKey().toString().toLowerCase(Locale.US));
/*     */       }
/*  86 */       return compare;
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
/*     */   protected void elementClicked(int index, boolean doubleClick, int mouseX, int mouseY) {
/*  99 */     this.selectedIndex = index;
/* 100 */     this.owningScreen.currentValue = ((IGuiSelectStringListEntry)this.listEntries.get(index)).getValue();
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
/*     */   protected boolean isSelected(int index) {
/* 112 */     return (index == this.selectedIndex);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected int getScrollBarX() {
/* 118 */     return this.width / 2 + this.maxEntryWidth / 2 + 5;
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
/*     */   public int getListWidth() {
/* 130 */     return this.maxEntryWidth + 5;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IGuiSelectStringListEntry getListEntry(int index) {
/* 139 */     return this.listEntries.get(index);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected int getSize() {
/* 145 */     return this.listEntries.size();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isChanged() {
/* 150 */     return (this.owningScreen.beforeValue != null) ? (!this.owningScreen.beforeValue.equals(this.owningScreen.currentValue)) : ((this.owningScreen.currentValue != null));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isDefault() {
/* 155 */     return (this.owningScreen.currentValue != null) ? this.owningScreen.currentValue.equals(this.configElement.getDefault()) : ((this.configElement.getDefault() == null));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void saveChanges() {
/* 161 */     if (this.owningScreen.slotIndex != -1 && this.owningScreen.parentScreen != null && this.owningScreen.parentScreen instanceof GuiConfig && ((GuiConfig)this.owningScreen.parentScreen).entryList
/*     */       
/* 163 */       .getListEntry(this.owningScreen.slotIndex) instanceof GuiConfigEntries.SelectValueEntry) {
/*     */       
/* 165 */       GuiConfigEntries.SelectValueEntry entry = (GuiConfigEntries.SelectValueEntry)((GuiConfig)this.owningScreen.parentScreen).entryList.getListEntry(this.owningScreen.slotIndex);
/*     */       
/* 167 */       entry.setValueFromChildScreen(this.owningScreen.currentValue);
/*     */     } else {
/*     */       
/* 170 */       this.configElement.set(this.owningScreen.currentValue);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static class ListEntry
/*     */     implements IGuiSelectStringListEntry {
/*     */     protected final GuiSelectStringEntries owningList;
/*     */     protected final Map.Entry<Object, String> value;
/*     */     
/*     */     public ListEntry(GuiSelectStringEntries owningList, Map.Entry<Object, String> value) {
/* 180 */       this.owningList = owningList;
/* 181 */       this.value = value;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void drawEntry(int slotIndex, int x, int y, int listWidth, int slotHeight, Tessellator tessellator, int mouseX, int mouseY, boolean isSelected) {
/* 187 */       this.owningList.mc.fontRenderer.drawString(this.value.getValue(), x + 1, y, (slotIndex == this.owningList.selectedIndex) ? 16777215 : 14737632);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean mousePressed(int index, int x, int y, int mouseEvent, int relativeX, int relativeY) {
/* 196 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void mouseReleased(int index, int x, int y, int mouseEvent, int relativeX, int relativeY) {}
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Object getValue() {
/* 209 */       return this.value.getKey();
/*     */     }
/*     */   }
/*     */   
/*     */   public static interface IGuiSelectStringListEntry extends GuiListExtended.IGuiListEntry {
/*     */     Object getValue();
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\client\config\GuiSelectStringEntries.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */