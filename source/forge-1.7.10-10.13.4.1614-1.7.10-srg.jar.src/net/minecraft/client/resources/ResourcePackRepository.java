/*     */ package net.minecraft.client.resources;
/*     */ import com.google.common.collect.ImmutableList;
/*     */ import com.google.common.collect.Lists;
/*     */ import com.google.common.collect.Maps;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.Closeable;
/*     */ import java.io.File;
/*     */ import java.io.FileFilter;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import net.minecraft.client.gui.GuiScreenWorking;
/*     */ import net.minecraft.client.renderer.texture.TextureManager;
/*     */ import net.minecraft.client.resources.data.IMetadataSerializer;
/*     */ import net.minecraft.client.resources.data.PackMetadataSection;
/*     */ import net.minecraft.client.settings.GameSettings;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ import net.minecraft.util.HttpUtil;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class ResourcePackRepository {
/*  29 */   protected static final FileFilter field_110622_a = new FileFilter() { private static final String __OBFID = "CL_00001088";
/*     */       
/*     */       public boolean accept(File p_accept_1_) {
/*  32 */         boolean bool1 = (p_accept_1_.isFile() && p_accept_1_.getName().endsWith(".zip")) ? true : false;
/*  33 */         boolean bool2 = (p_accept_1_.isDirectory() && (new File(p_accept_1_, "pack.mcmeta")).isFile()) ? true : false;
/*     */         
/*  35 */         return (bool1 || bool2);
/*     */       } }
/*     */   ;
/*     */   
/*     */   private final File field_110618_d;
/*     */   
/*     */   public final IResourcePack field_110620_b;
/*     */   
/*     */   private final File field_148534_e;
/*     */   
/*     */   public final IMetadataSerializer field_110621_c;
/*     */   
/*     */   private IResourcePack field_148532_f;
/*     */   private boolean field_148533_g;
/*  49 */   private List field_110619_e = Lists.newArrayList();
/*  50 */   private List field_110617_f = Lists.newArrayList(); private static final String __OBFID = "CL_00001087";
/*     */   
/*     */   public ResourcePackRepository(File p_i45101_1_, File p_i45101_2_, IResourcePack p_i45101_3_, IMetadataSerializer p_i45101_4_, GameSettings p_i45101_5_) {
/*  53 */     this.field_110618_d = p_i45101_1_;
/*  54 */     this.field_148534_e = p_i45101_2_;
/*  55 */     this.field_110620_b = p_i45101_3_;
/*  56 */     this.field_110621_c = p_i45101_4_;
/*     */     
/*  58 */     func_110616_f();
/*     */     
/*  60 */     func_110611_a();
/*     */     
/*  62 */     for (String str : p_i45101_5_.field_151453_l) {
/*  63 */       for (Entry entry : this.field_110619_e) {
/*  64 */         if (entry.func_110515_d().equals(str)) {
/*  65 */           this.field_110617_f.add(entry);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void func_110616_f() {
/*  73 */     if (!this.field_110618_d.isDirectory()) {
/*  74 */       this.field_110618_d.delete();
/*  75 */       this.field_110618_d.mkdirs();
/*     */     } 
/*     */   }
/*     */   
/*     */   private List func_110614_g() {
/*  80 */     if (this.field_110618_d.isDirectory()) {
/*  81 */       return Arrays.asList(this.field_110618_d.listFiles(field_110622_a));
/*     */     }
/*     */     
/*  84 */     return Collections.emptyList();
/*     */   }
/*     */   
/*     */   public void func_110611_a() {
/*  88 */     ArrayList<Entry> arrayList = Lists.newArrayList();
/*     */     
/*  90 */     for (File file : func_110614_g()) {
/*  91 */       Entry entry = new Entry(file);
/*     */       
/*  93 */       if (!this.field_110619_e.contains(entry)) {
/*     */         try {
/*  95 */           entry.func_110516_a();
/*  96 */           arrayList.add(entry);
/*  97 */         } catch (Exception exception) {
/*     */           
/*  99 */           arrayList.remove(entry);
/*     */         }  continue;
/*     */       } 
/* 102 */       int i = this.field_110619_e.indexOf(entry);
/* 103 */       if (i > -1 && i < this.field_110619_e.size()) {
/* 104 */         arrayList.add(this.field_110619_e.get(i));
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 109 */     this.field_110619_e.removeAll(arrayList);
/* 110 */     for (Entry entry : this.field_110619_e) {
/* 111 */       entry.func_110517_b();
/*     */     }
/*     */     
/* 114 */     this.field_110619_e = arrayList;
/*     */   }
/*     */   
/*     */   public List func_110609_b() {
/* 118 */     return (List)ImmutableList.copyOf(this.field_110619_e);
/*     */   }
/*     */   
/*     */   public List func_110613_c() {
/* 122 */     return (List)ImmutableList.copyOf(this.field_110617_f);
/*     */   }
/*     */   
/*     */   public void func_148527_a(List p_148527_1_) {
/* 126 */     this.field_110617_f.clear();
/* 127 */     this.field_110617_f.addAll(p_148527_1_);
/*     */   }
/*     */   
/*     */   public File func_110612_e() {
/* 131 */     return this.field_110618_d;
/*     */   }
/*     */   
/*     */   public void func_148526_a(String p_148526_1_) {
/* 135 */     String str = p_148526_1_.substring(p_148526_1_.lastIndexOf("/") + 1);
/* 136 */     if (str.contains("?")) str = str.substring(0, str.indexOf("?")); 
/* 137 */     if (!str.endsWith(".zip"))
/* 138 */       return;  File file = new File(this.field_148534_e, str.replaceAll("\\W", ""));
/* 139 */     func_148529_f();
/* 140 */     func_148528_a(p_148526_1_, file);
/*     */   }
/*     */   
/*     */   private void func_148528_a(String p_148528_1_, File p_148528_2_) {
/* 144 */     HashMap<String, String> hashMap = Maps.newHashMap();
/* 145 */     GuiScreenWorking guiScreenWorking = new GuiScreenWorking();
/* 146 */     hashMap.put("X-Minecraft-Username", Minecraft.func_71410_x().func_110432_I().func_111285_a());
/* 147 */     hashMap.put("X-Minecraft-UUID", Minecraft.func_71410_x().func_110432_I().func_148255_b());
/* 148 */     hashMap.put("X-Minecraft-Version", "1.7.10");
/* 149 */     this.field_148533_g = true;
/*     */     
/* 151 */     Minecraft.func_71410_x().func_147108_a((GuiScreen)guiScreenWorking);
/*     */     
/* 153 */     HttpUtil.func_151223_a(p_148528_2_, p_148528_1_, new HttpUtil.DownloadListener(this) { private static final String __OBFID = "CL_00001089";
/*     */           
/*     */           public void func_148522_a(File p_148522_1_) {
/* 156 */             if (!this.field_148523_a.field_148533_g)
/* 157 */               return;  this.field_148523_a.field_148533_g = false;
/* 158 */             this.field_148523_a.field_148532_f = new FileResourcePack(p_148522_1_);
/* 159 */             Minecraft.func_71410_x().func_147106_B();
/*     */           }
/*     */         },  hashMap, 52428800, (IProgressUpdate)guiScreenWorking, Minecraft.func_71410_x().func_110437_J());
/*     */   }
/*     */   
/*     */   public IResourcePack func_148530_e() {
/* 165 */     return this.field_148532_f;
/*     */   }
/*     */   
/*     */   public void func_148529_f() {
/* 169 */     this.field_148532_f = null;
/* 170 */     this.field_148533_g = false;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public class Entry {
/*     */     private final File field_110523_b;
/*     */     private IResourcePack field_110524_c;
/*     */     private PackMetadataSection field_110521_d;
/*     */     private BufferedImage field_110522_e;
/*     */     private ResourceLocation field_110520_f;
/*     */     private static final String __OBFID = "CL_00001090";
/*     */     
/*     */     private Entry(ResourcePackRepository p_i1295_1_, File p_i1295_2_) {
/* 183 */       this.field_110523_b = p_i1295_2_;
/*     */     }
/*     */     
/*     */     public void func_110516_a() throws IOException {
/* 187 */       this.field_110524_c = this.field_110523_b.isDirectory() ? new FolderResourcePack(this.field_110523_b) : new FileResourcePack(this.field_110523_b);
/*     */       
/* 189 */       this.field_110521_d = (PackMetadataSection)this.field_110524_c.func_135058_a(this.field_110525_a.field_110621_c, "pack");
/*     */       try {
/* 191 */         this.field_110522_e = this.field_110524_c.func_110586_a();
/* 192 */       } catch (IOException iOException) {}
/*     */       
/* 194 */       if (this.field_110522_e == null) {
/* 195 */         this.field_110522_e = this.field_110525_a.field_110620_b.func_110586_a();
/*     */       }
/*     */       
/* 198 */       func_110517_b();
/*     */     }
/*     */     
/*     */     public void func_110518_a(TextureManager p_110518_1_) {
/* 202 */       if (this.field_110520_f == null) {
/* 203 */         this.field_110520_f = p_110518_1_.func_110578_a("texturepackicon", new DynamicTexture(this.field_110522_e));
/*     */       }
/* 205 */       p_110518_1_.func_110577_a(this.field_110520_f);
/*     */     }
/*     */     
/*     */     public void func_110517_b() {
/* 209 */       if (this.field_110524_c instanceof Closeable) {
/* 210 */         IOUtils.closeQuietly((Closeable)this.field_110524_c);
/*     */       }
/*     */     }
/*     */     
/*     */     public IResourcePack func_110514_c() {
/* 215 */       return this.field_110524_c;
/*     */     }
/*     */     
/*     */     public String func_110515_d() {
/* 219 */       return this.field_110524_c.func_130077_b();
/*     */     }
/*     */     
/*     */     public String func_110519_e() {
/* 223 */       return (this.field_110521_d == null) ? (EnumChatFormatting.RED + "Invalid pack.mcmeta (or missing 'pack' section)") : this.field_110521_d.func_152805_a().func_150254_d();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean equals(Object p_equals_1_) {
/* 232 */       if (this == p_equals_1_) return true;
/*     */       
/* 234 */       if (p_equals_1_ instanceof Entry) {
/* 235 */         return toString().equals(p_equals_1_.toString());
/*     */       }
/*     */       
/* 238 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 243 */       return toString().hashCode();
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 248 */       return String.format("%s:%s:%d", new Object[] { this.field_110523_b.getName(), this.field_110523_b.isDirectory() ? "folder" : "zip", Long.valueOf(this.field_110523_b.lastModified()) });
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\resources\ResourcePackRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */