/*     */ package org.bukkit.craftbukkit.v1_7_R4.inventory;
/*     */ 
/*     */ import com.google.common.base.Strings;
/*     */ import com.google.common.collect.ImmutableList;
/*     */ import com.google.common.collect.ImmutableMap;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import net.minecraft.server.v1_7_R4.NBTBase;
/*     */ import net.minecraft.server.v1_7_R4.NBTTagCompound;
/*     */ import net.minecraft.server.v1_7_R4.NBTTagList;
/*     */ import org.apache.commons.lang.Validate;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.configuration.serialization.DelegateDeserialization;
/*     */ import org.bukkit.inventory.meta.BookMeta;
/*     */ import org.bukkit.inventory.meta.ItemMeta;
/*     */ import org.bukkit.inventory.meta.Repairable;
/*     */ 
/*     */ @DelegateDeserialization(CraftMetaItem.SerializableMeta.class)
/*     */ class CraftMetaBook
/*     */   extends CraftMetaItem implements BookMeta {
/*  22 */   static final CraftMetaItem.ItemMetaKey BOOK_TITLE = new CraftMetaItem.ItemMetaKey("title");
/*  23 */   static final CraftMetaItem.ItemMetaKey BOOK_AUTHOR = new CraftMetaItem.ItemMetaKey("author");
/*  24 */   static final CraftMetaItem.ItemMetaKey BOOK_PAGES = new CraftMetaItem.ItemMetaKey("pages");
/*     */   
/*     */   static final int MAX_PAGE_LENGTH = 256;
/*     */   static final int MAX_TITLE_LENGTH = 65535;
/*     */   private String title;
/*     */   private String author;
/*  30 */   private List<String> pages = new ArrayList<String>();
/*     */   
/*     */   CraftMetaBook(CraftMetaItem meta) {
/*  33 */     super(meta);
/*     */     
/*  35 */     if (!(meta instanceof CraftMetaBook)) {
/*     */       return;
/*     */     }
/*  38 */     CraftMetaBook bookMeta = (CraftMetaBook)meta;
/*  39 */     this.title = bookMeta.title;
/*  40 */     this.author = bookMeta.author;
/*  41 */     this.pages.addAll(bookMeta.pages);
/*     */   }
/*     */   
/*     */   CraftMetaBook(NBTTagCompound tag) {
/*  45 */     super(tag);
/*     */     
/*  47 */     if (tag.hasKey(BOOK_TITLE.NBT)) {
/*  48 */       this.title = tag.getString(BOOK_TITLE.NBT);
/*     */     }
/*     */     
/*  51 */     if (tag.hasKey(BOOK_AUTHOR.NBT)) {
/*  52 */       this.author = tag.getString(BOOK_AUTHOR.NBT);
/*     */     }
/*     */     
/*  55 */     if (tag.hasKey(BOOK_PAGES.NBT)) {
/*  56 */       NBTTagList pages = tag.getList(BOOK_PAGES.NBT, 8);
/*  57 */       String[] pageArray = new String[pages.size()];
/*     */       
/*  59 */       for (int i = 0; i < pages.size(); i++) {
/*  60 */         String page = pages.getString(i);
/*  61 */         pageArray[i] = page;
/*     */       } 
/*     */       
/*  64 */       addPage(pageArray);
/*     */     } 
/*     */   }
/*     */   
/*     */   CraftMetaBook(Map<String, Object> map) {
/*  69 */     super(map);
/*     */     
/*  71 */     setAuthor(CraftMetaItem.SerializableMeta.getString(map, BOOK_AUTHOR.BUKKIT, true));
/*     */     
/*  73 */     setTitle(CraftMetaItem.SerializableMeta.getString(map, BOOK_TITLE.BUKKIT, true));
/*     */     
/*  75 */     Iterable<?> pages = CraftMetaItem.SerializableMeta.<Iterable>getObject(Iterable.class, map, BOOK_PAGES.BUKKIT, true);
/*  76 */     CraftMetaItem.safelyAdd(pages, this.pages, 256);
/*     */   }
/*     */ 
/*     */   
/*     */   void applyToItem(NBTTagCompound itemData) {
/*  81 */     super.applyToItem(itemData);
/*     */     
/*  83 */     if (hasTitle()) {
/*  84 */       itemData.setString(BOOK_TITLE.NBT, this.title);
/*     */     }
/*     */     
/*  87 */     if (hasAuthor()) {
/*  88 */       itemData.setString(BOOK_AUTHOR.NBT, this.author);
/*     */     }
/*     */     
/*  91 */     if (hasPages()) {
/*  92 */       itemData.set(BOOK_PAGES.NBT, (NBTBase)createStringList(this.pages));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   boolean isEmpty() {
/*  98 */     return (super.isEmpty() && isBookEmpty());
/*     */   }
/*     */   
/*     */   boolean isBookEmpty() {
/* 102 */     return (!hasPages() && !hasAuthor() && !hasTitle());
/*     */   }
/*     */ 
/*     */   
/*     */   boolean applicableTo(Material type) {
/* 107 */     switch (type) {
/*     */       case WRITTEN_BOOK:
/*     */       case BOOK_AND_QUILL:
/* 110 */         return true;
/*     */     } 
/* 112 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasAuthor() {
/* 117 */     return !Strings.isNullOrEmpty(this.author);
/*     */   }
/*     */   
/*     */   public boolean hasTitle() {
/* 121 */     return !Strings.isNullOrEmpty(this.title);
/*     */   }
/*     */   
/*     */   public boolean hasPages() {
/* 125 */     return !this.pages.isEmpty();
/*     */   }
/*     */   
/*     */   public String getTitle() {
/* 129 */     return this.title;
/*     */   }
/*     */   
/*     */   public boolean setTitle(String title) {
/* 133 */     if (title == null) {
/* 134 */       this.title = null;
/* 135 */       return true;
/* 136 */     }  if (title.length() > 65535) {
/* 137 */       return false;
/*     */     }
/*     */     
/* 140 */     this.title = title;
/* 141 */     return true;
/*     */   }
/*     */   
/*     */   public String getAuthor() {
/* 145 */     return this.author;
/*     */   }
/*     */   
/*     */   public void setAuthor(String author) {
/* 149 */     this.author = author;
/*     */   }
/*     */   
/*     */   public String getPage(int page) {
/* 153 */     Validate.isTrue(isValidPage(page), "Invalid page number");
/* 154 */     return this.pages.get(page - 1);
/*     */   }
/*     */   
/*     */   public void setPage(int page, String text) {
/* 158 */     if (!isValidPage(page)) {
/* 159 */       throw new IllegalArgumentException("Invalid page number " + page + "/" + this.pages.size());
/*     */     }
/*     */     
/* 162 */     this.pages.set(page - 1, (text == null) ? "" : ((text.length() > 256) ? text.substring(0, 256) : text));
/*     */   }
/*     */   
/*     */   public void setPages(String... pages) {
/* 166 */     this.pages.clear();
/*     */     
/* 168 */     addPage(pages);
/*     */   }
/*     */   
/*     */   public void addPage(String... pages) {
/* 172 */     for (String page : pages) {
/* 173 */       if (page == null) {
/* 174 */         page = "";
/* 175 */       } else if (page.length() > 256) {
/* 176 */         page = page.substring(0, 256);
/*     */       } 
/*     */       
/* 179 */       this.pages.add(page);
/*     */     } 
/*     */   }
/*     */   
/*     */   public int getPageCount() {
/* 184 */     return this.pages.size();
/*     */   }
/*     */   
/*     */   public List<String> getPages() {
/* 188 */     return (List<String>)ImmutableList.copyOf(this.pages);
/*     */   }
/*     */   
/*     */   public void setPages(List<String> pages) {
/* 192 */     this.pages.clear();
/* 193 */     CraftMetaItem.safelyAdd(pages, this.pages, 256);
/*     */   }
/*     */   
/*     */   private boolean isValidPage(int page) {
/* 197 */     return (page > 0 && page <= this.pages.size());
/*     */   }
/*     */ 
/*     */   
/*     */   public CraftMetaBook clone() {
/* 202 */     CraftMetaBook meta = (CraftMetaBook)super.clone();
/* 203 */     meta.pages = new ArrayList<String>(this.pages);
/* 204 */     return meta;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   int applyHash() {
/* 210 */     int original = super.applyHash(), hash = original;
/* 211 */     if (hasTitle()) {
/* 212 */       hash = 61 * hash + this.title.hashCode();
/*     */     }
/* 214 */     if (hasAuthor()) {
/* 215 */       hash = 61 * hash + 13 * this.author.hashCode();
/*     */     }
/* 217 */     if (hasPages()) {
/* 218 */       hash = 61 * hash + 17 * this.pages.hashCode();
/*     */     }
/* 220 */     return (original != hash) ? (CraftMetaBook.class.hashCode() ^ hash) : hash;
/*     */   }
/*     */ 
/*     */   
/*     */   boolean equalsCommon(CraftMetaItem meta) {
/* 225 */     if (!super.equalsCommon(meta)) {
/* 226 */       return false;
/*     */     }
/* 228 */     if (meta instanceof CraftMetaBook) {
/* 229 */       CraftMetaBook that = (CraftMetaBook)meta;
/*     */       
/* 231 */       if (hasTitle() ? (that.hasTitle() && this.title.equals(that.title)) : !that.hasTitle()) if ((hasAuthor() ? (that.hasAuthor() && this.author.equals(that.author)) : !that.hasAuthor()) && (hasPages() ? (that.hasPages() && this.pages.equals(that.pages)) : !that.hasPages()));  return false;
/*     */     } 
/*     */ 
/*     */     
/* 235 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   boolean notUncommon(CraftMetaItem meta) {
/* 240 */     return (super.notUncommon(meta) && (meta instanceof CraftMetaBook || isBookEmpty()));
/*     */   }
/*     */ 
/*     */   
/*     */   ImmutableMap.Builder<String, Object> serialize(ImmutableMap.Builder<String, Object> builder) {
/* 245 */     super.serialize(builder);
/*     */     
/* 247 */     if (hasTitle()) {
/* 248 */       builder.put(BOOK_TITLE.BUKKIT, this.title);
/*     */     }
/*     */     
/* 251 */     if (hasAuthor()) {
/* 252 */       builder.put(BOOK_AUTHOR.BUKKIT, this.author);
/*     */     }
/*     */     
/* 255 */     if (hasPages()) {
/* 256 */       builder.put(BOOK_PAGES.BUKKIT, this.pages);
/*     */     }
/*     */     
/* 259 */     return builder;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\craftbukkit\v1_7_R4\inventory\CraftMetaBook.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */