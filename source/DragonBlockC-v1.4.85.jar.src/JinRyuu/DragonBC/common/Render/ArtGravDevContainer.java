/*     */ package JinRyuu.DragonBC.common.Render;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.InventoryPlayer;
/*     */ import net.minecraft.inventory.Container;
/*     */ import net.minecraft.inventory.ICrafting;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.inventory.Slot;
/*     */ import net.minecraft.item.ItemStack;
/*     */ 
/*     */ public class ArtGravDevContainer extends Container {
/*  14 */   private static int INV_START = 1; private static int INV_END = INV_START + 26; private static int HOTBAR_START = INV_END + 1; private static int HOTBAR_END = HOTBAR_START + 8;
/*     */   
/*     */   private ArtGravDevTileEntity tileFurnace;
/*     */   
/*     */   private int lastCookTime;
/*     */   private int lastBurnTime;
/*     */   private int lastItemBurnTime;
/*     */   
/*     */   public ArtGravDevContainer(InventoryPlayer p_i1812_1_, ArtGravDevTileEntity p_i1812_2_) {
/*  23 */     this.tileFurnace = p_i1812_2_;
/*     */     
/*  25 */     func_75146_a(new Slot((IInventory)p_i1812_2_, 0, 5, 53));
/*     */ 
/*     */     
/*  28 */     INV_START = 1;
/*  29 */     INV_END = INV_START; int i;
/*  30 */     for (i = 0; i < 3; i++) {
/*     */       
/*  32 */       for (int j = 0; j < 9; j++) {
/*     */ 
/*     */         
/*  35 */         func_75146_a(new Slot((IInventory)p_i1812_1_, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
/*  36 */         INV_END++;
/*     */       } 
/*     */     } 
/*  39 */     INV_END--;
/*  40 */     HOTBAR_START = INV_END + 1;
/*  41 */     HOTBAR_END = HOTBAR_START;
/*  42 */     for (i = 0; i < 9; i++) {
/*     */ 
/*     */       
/*  45 */       func_75146_a(new Slot((IInventory)p_i1812_1_, i, 8 + i * 18, 142));
/*  46 */       HOTBAR_END++;
/*     */     } 
/*  48 */     HOTBAR_END--;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_75132_a(ICrafting p_75132_1_) {
/*  54 */     super.func_75132_a(p_75132_1_);
/*     */     
/*  56 */     p_75132_1_.func_71112_a(this, 1, this.tileFurnace.furnaceBurnTime);
/*  57 */     p_75132_1_.func_71112_a(this, 2, this.tileFurnace.currentItemBurnTime);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_75142_b() {
/*  65 */     super.func_75142_b();
/*     */     
/*  67 */     for (int i = 0; i < this.field_75149_d.size(); i++) {
/*     */       
/*  69 */       ICrafting icrafting = this.field_75149_d.get(i);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  76 */       if (this.lastBurnTime != this.tileFurnace.furnaceBurnTime)
/*     */       {
/*  78 */         icrafting.func_71112_a(this, 1, this.tileFurnace.furnaceBurnTime);
/*     */       }
/*     */       
/*  81 */       if (this.lastItemBurnTime != this.tileFurnace.currentItemBurnTime)
/*     */       {
/*  83 */         icrafting.func_71112_a(this, 2, this.tileFurnace.currentItemBurnTime);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/*  88 */     this.lastBurnTime = this.tileFurnace.furnaceBurnTime;
/*  89 */     this.lastItemBurnTime = this.tileFurnace.currentItemBurnTime;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_75137_b(int p_75137_1_, int p_75137_2_) {
/* 100 */     if (p_75137_1_ == 1)
/*     */     {
/* 102 */       this.tileFurnace.furnaceBurnTime = p_75137_2_;
/*     */     }
/*     */     
/* 105 */     if (p_75137_1_ == 2)
/*     */     {
/* 107 */       this.tileFurnace.currentItemBurnTime = p_75137_2_;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_75145_c(EntityPlayer p_75145_1_) {
/* 113 */     return this.tileFurnace.func_70300_a(p_75145_1_);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_82846_b(EntityPlayer p_82846_1_, int p_82846_2_) {
/* 121 */     ItemStack itemstack = null;
/* 122 */     Slot slot = this.field_75151_b.get(p_82846_2_);
/*     */     
/* 124 */     if (slot != null && slot.func_75216_d()) {
/*     */       
/* 126 */       ItemStack itemstack1 = slot.func_75211_c();
/* 127 */       itemstack = itemstack1.func_77946_l();
/*     */ 
/*     */       
/* 130 */       if (p_82846_2_ != 0) {
/*     */         
/* 132 */         if (ArtGravDevTileEntity.isItemFuel(itemstack1)) {
/* 133 */           if (!func_75135_a(itemstack1, 0, INV_START, false)) {
/* 134 */             return null;
/*     */           
/*     */           }
/*     */         }
/* 138 */         else if (p_82846_2_ >= INV_START && p_82846_2_ < HOTBAR_START) {
/*     */           
/* 140 */           if (!func_75135_a(itemstack1, HOTBAR_START, HOTBAR_END + 1, false)) {
/* 141 */             return null;
/*     */           
/*     */           }
/*     */         }
/* 145 */         else if (p_82846_2_ >= HOTBAR_START && p_82846_2_ < HOTBAR_END + 1 && 
/* 146 */           !func_75135_a(itemstack1, INV_START, INV_END + 1, false)) {
/* 147 */           return null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       }
/* 162 */       else if (!func_75135_a(itemstack1, INV_START, HOTBAR_END + 1, false)) {
/*     */         
/* 164 */         return null;
/*     */       } 
/*     */       
/* 167 */       if (itemstack1.field_77994_a == 0) {
/*     */         
/* 169 */         slot.func_75215_d((ItemStack)null);
/*     */       }
/*     */       else {
/*     */         
/* 173 */         slot.func_75218_e();
/*     */       } 
/*     */       
/* 176 */       if (itemstack1.field_77994_a == itemstack.field_77994_a)
/*     */       {
/* 178 */         return null;
/*     */       }
/*     */       
/* 181 */       slot.func_82870_a(p_82846_1_, itemstack1);
/*     */     } 
/*     */     
/* 184 */     return itemstack;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Render\ArtGravDevContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */