/*      */ package JinRyuu.JBRA;
/*      */ import JinRyuu.DragonBC.common.Items.ItemsDBC;
/*      */ import JinRyuu.JRMCore.FamilyCH;
/*      */ import JinRyuu.JRMCore.JRMCoreClient;
/*      */ import JinRyuu.JRMCore.JRMCoreConfig;
/*      */ import JinRyuu.JRMCore.JRMCoreGuiScreen;
/*      */ import JinRyuu.JRMCore.JRMCoreH;
/*      */ import JinRyuu.JRMCore.JRMCoreHC;
/*      */ import JinRyuu.JRMCore.JRMCoreHDBC;
/*      */ import JinRyuu.JRMCore.JRMCoreHJBRA;
/*      */ import JinRyuu.JRMCore.JRMCoreHJYC;
/*      */ import JinRyuu.JRMCore.JRMCoreHSAC;
/*      */ import JinRyuu.JRMCore.client.config.jrmc.JGConfigClientSettings;
/*      */ import JinRyuu.JRMCore.i.ExtendedPlayer;
/*      */ import JinRyuu.JRMCore.items.ItemVanity;
/*      */ import JinRyuu.JRMCore.server.config.dbc.JGConfigRaces;
/*      */ import JinRyuu.JRMCore.server.config.dbc.JGConfigUltraInstinct;
/*      */ import JinRyuu.JYearsC.JYearsCConfig;
/*      */ import com.mojang.authlib.GameProfile;
/*      */ import cpw.mods.fml.common.eventhandler.Event;
/*      */ import cpw.mods.fml.relauncher.SideOnly;
/*      */ import java.util.HashMap;
/*      */ import java.util.Random;
/*      */ import java.util.UUID;
/*      */ import net.minecraft.block.Block;
/*      */ import net.minecraft.client.entity.AbstractClientPlayer;
/*      */ import net.minecraft.client.entity.EntityClientPlayerMP;
/*      */ import net.minecraft.client.gui.FontRenderer;
/*      */ import net.minecraft.client.model.ModelBase;
/*      */ import net.minecraft.client.model.ModelBox;
/*      */ import net.minecraft.client.model.ModelRenderer;
/*      */ import net.minecraft.client.renderer.OpenGlHelper;
/*      */ import net.minecraft.client.renderer.RenderBlocks;
/*      */ import net.minecraft.client.renderer.RenderHelper;
/*      */ import net.minecraft.client.renderer.Tessellator;
/*      */ import net.minecraft.client.renderer.entity.RenderBiped;
/*      */ import net.minecraft.client.renderer.entity.RenderPlayer;
/*      */ import net.minecraft.client.renderer.entity.RendererLivingEntity;
/*      */ import net.minecraft.client.renderer.tileentity.TileEntitySkullRenderer;
/*      */ import net.minecraft.entity.Entity;
/*      */ import net.minecraft.entity.EntityLivingBase;
/*      */ import net.minecraft.entity.player.EntityPlayer;
/*      */ import net.minecraft.entity.projectile.EntityArrow;
/*      */ import net.minecraft.init.Items;
/*      */ import net.minecraft.item.EnumAction;
/*      */ import net.minecraft.item.Item;
/*      */ import net.minecraft.item.ItemArmor;
/*      */ import net.minecraft.item.ItemStack;
/*      */ import net.minecraft.nbt.NBTTagCompound;
/*      */ import net.minecraft.nbt.NBTUtil;
/*      */ import net.minecraft.scoreboard.Score;
/*      */ import net.minecraft.scoreboard.ScoreObjective;
/*      */ import net.minecraft.scoreboard.Scoreboard;
/*      */ import net.minecraft.util.MathHelper;
/*      */ import net.minecraft.util.ResourceLocation;
/*      */ import net.minecraft.util.StringUtils;
/*      */ import net.minecraftforge.client.IItemRenderer;
/*      */ import net.minecraftforge.client.MinecraftForgeClient;
/*      */ import net.minecraftforge.client.event.RenderLivingEvent;
/*      */ import net.minecraftforge.client.event.RenderPlayerEvent;
/*      */ import net.minecraftforge.common.MinecraftForge;
/*      */ import org.lwjgl.opengl.GL11;
/*      */ 
/*      */ @SideOnly(Side.CLIENT)
/*      */ public class RenderPlayerJBRA extends RenderPlayer {
/*      */   private static final boolean KO_CAMERA = false;
/*   67 */   private static final ResourceLocation steveTextures = new ResourceLocation("textures/entity/steve.png");
/*   68 */   private static final ResourceLocation fem = new ResourceLocation("jinryuufamilyc:fem.png");
/*   69 */   private static ResourceLocation curSkin = null; private static boolean curSkinUp = false; public ModelBipedDBC modelMain;
/*      */   private int pl;
/*      */   
/*   72 */   byte b(int n) { return (byte)n; }
/*   73 */   byte b(String n) { return Byte.parseByte(n); } int i(String n) {
/*   74 */     return Integer.parseInt(n);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*   79 */   public static HashMap<String, Integer> state = new HashMap<String, Integer>();
/*   80 */   public static HashMap<String, Integer> stateChange = new HashMap<String, Integer>();
/*   81 */   public static HashMap<String, Integer> state2Change = new HashMap<String, Integer>();
/*   82 */   public static HashMap<String, Integer> auratype = new HashMap<String, Integer>();
/*   83 */   public static HashMap<String, Integer> auratime = new HashMap<String, Integer>();
/*   84 */   public static HashMap<String, Integer> bendtime = new HashMap<String, Integer>();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public RenderPlayerJBRA() {
/* 1852 */     this.number_of_lightVerts = 10;
/* 1853 */     this.lightVert = new long[10];
/*      */ 
/*      */     
/* 1856 */     this.lvnm = 10;
/* 1857 */     this.lightVertRotation = new float[10][3]; this.modelMain = new ModelBipedDBC(0.0F); this.field_77045_g = (ModelBase)this.modelMain;
/*      */   }
/*      */   private int JFCgetConfigpt() { return FamilyCConfig.pt; }
/*      */   private float JYCgetConfigpgut() { return JYearsCConfig.pgut; }
/*      */   protected void func_82408_c(AbstractClientPlayer p_82408_1_, int p_82408_2_, float p_82408_3_) { ItemStack itemstack = p_82408_1_.field_71071_by.func_70440_f(3 - p_82408_2_); if (itemstack != null) { Item item = itemstack.func_77973_b(); if (item instanceof ItemArmor) { func_110776_a(RenderBiped.getArmorResource((Entity)p_82408_1_, itemstack, p_82408_2_, "overlay")); GL11.glColor3f(1.0F + getR(), 1.0F + getG(), 1.0F + getB()); }  }  }
/*      */   private static float childScl = 1.0F;
/*      */   private static float age = 0.0F;
/*      */   private static int gen = 1;
/* 1865 */   private static int preg = 0; private static int breast = 0; private String tailAnim; private final int number_of_lightVerts = 10; private long[] lightVert; private int lightLivingTime; private final int lvnm = 10; private float[][] lightVertRotation; public static float childSclGet() { return childScl; } public static float genGet() { return gen; } public void func_130009_a(AbstractClientPlayer par1AbstractClientPlayer, double par2, double par4, double par6, float par8, float par9) { if (JRMCoreH.JYC()) { age = JRMCoreHJYC.JYCAge((EntityPlayer)par1AbstractClientPlayer); childScl = JRMCoreHJYC.JYCsizeBasedOnAge((EntityPlayer)par1AbstractClientPlayer); childScl = 3.0F - childScl * 2.0F; }  if (JRMCoreH.JFC()) { if (JRMCoreH.plyrs != null && JRMCoreH.plyrs.length > 0 && !par1AbstractClientPlayer.func_82150_aj() && JRMCoreH.dnn(1)) for (int pl = 0; pl < JRMCoreH.plyrs.length; pl++) { if (JRMCoreH.plyrs[pl].equals(par1AbstractClientPlayer.func_70005_c_()) && JRMCoreH.data1.length >= JRMCoreH.plyrs.length) { String[] s = JRMCoreH.data1[pl].split(";"); String dns = s[1]; int A = JRMCoreH.dnsGender(dns) + 1; if (A >= 1) gen = 1;  if (A == 2) gen = 2;  if (A == 3) gen = 3;  int pwr = Integer.parseInt(s[2]); if (pwr == 1 && A > 1 && JRMCoreH.dnn(2)) { int race = Integer.parseInt(s[0]); String[] dummy = { "0", "0", "0", "0" }; String[] state = (JRMCoreH.data2 == null) ? dummy : JRMCoreH.data2[pl].split(";"); int State = (pwr == 2 || race == 0) ? 0 : b(state[0]); boolean saiOozar = JRMCoreH.rSai(race) ? ((State == 7 || State == 8)) : false; if (saiOozar) gen = 1;  }  }  }   if (JRMCoreH.plyrs != null && JRMCoreH.plyrs.length > 0 && !par1AbstractClientPlayer.func_82150_aj() && JRMCoreH.dnn(30)) for (int pl = 0; pl < JRMCoreH.plyrs.length; pl++) { if (JRMCoreH.plyrs[pl].equals(par1AbstractClientPlayer.func_70005_c_()) && JRMCoreH.preg.length >= JRMCoreH.plyrs.length) { String s = JRMCoreH.preg[pl]; int i = s.matches("[0-9]+") ? Integer.parseInt(s) : 0; int def = JFCgetConfigpt() * 120; if (i > 1) { preg = (int)((i - def / 2.0F) / def / 2.0F * 0.01F); preg = 100 - preg; preg = (preg > 100) ? 100 : ((preg < 0) ? 0 : preg); } else { preg = 0; }  }  }   if (JRMCoreH.plyrs != null && JRMCoreH.plyrs.length > 0 && !par1AbstractClientPlayer.func_82150_aj() && JRMCoreH.dnn(1)) for (int pl = 0; pl < JRMCoreH.plyrs.length; pl++) { if (JRMCoreH.plyrs[pl].equals(par1AbstractClientPlayer.func_70005_c_()) && JRMCoreH.data1.length >= JRMCoreH.plyrs.length) { String[] s = JRMCoreH.data1[pl].split(";"); String dns = s[1]; breast = JRMCoreH.dnsBreast(dns); }  }   }  ModelBipedDBC.g = gen; ModelBipedDBC.f = childScl; ModelBipedDBC.p = preg; this.modelMain.b = breast; float var10 = 1.0F; GL11.glColor3f(var10 + getR(), var10 + getG(), var10 + getB()); GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F); ItemStack var11 = par1AbstractClientPlayer.field_71071_by.func_70448_g(); this.field_77111_i.field_78120_m = this.modelMain.field_78120_m = (var11 != null) ? JRMCoreHSAC.ah(var11.func_77973_b(), 1) : 0; if (var11 != null && par1AbstractClientPlayer.func_71052_bv() > 0) { EnumAction var12 = var11.func_77975_n(); if (var12 == EnumAction.block) { this.field_77111_i.field_78120_m = this.modelMain.field_78120_m = 3; } else if (var12 == EnumAction.bow) { this.field_77111_i.field_78118_o = this.modelMain.field_78118_o = true; }  }  this.field_77111_i.field_78117_n = this.modelMain.field_78117_n = par1AbstractClientPlayer.func_70093_af(); double var14 = par4; super.func_76986_a(par1AbstractClientPlayer, par2, var14, par6, par8, par9); this.field_77111_i.field_78118_o = this.modelMain.field_78118_o = false; this.field_77111_i.field_78117_n = this.modelMain.field_78117_n = false; this.field_77111_i.field_78120_m = this.modelMain.field_78120_m = 0; } public void func_76986_a(AbstractClientPlayer p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) { this.field_77109_a = (ModelBiped)this.modelMain; this.field_77109_a.field_78116_c = this.modelMain.field_78116_c; this.field_77109_a.field_78114_d = this.modelMain.field_78114_d; this.field_77109_a.field_78113_g = this.modelMain.LA; this.field_77109_a.field_78112_f = this.modelMain.RA; this.field_77109_a.field_78124_i = this.modelMain.LL; this.field_77109_a.field_78123_h = this.modelMain.RL; this.field_77109_a.field_78115_e = this.modelMain.B; if (MinecraftForge.EVENT_BUS.post((Event)new RenderPlayerEvent.Pre((EntityPlayer)p_76986_1_, this, p_76986_9_))) return;  func_130009_a(p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_); MinecraftForge.EVENT_BUS.post((Event)new RenderPlayerEvent.Post((EntityPlayer)p_76986_1_, this, p_76986_9_)); } protected ResourceLocation func_110775_a(AbstractClientPlayer p_110775_1_) { return p_110775_1_.func_110306_p(); } public void lightning(Entity e, int id) { GL11.glPushMatrix();
/* 1866 */     Tessellator tessellator2 = Tessellator.field_78398_a;
/* 1867 */     GL11.glDisable(3553);
/* 1868 */     GL11.glDisable(2896);
/* 1869 */     GL11.glEnable(3042);
/* 1870 */     GL11.glBlendFunc(770, 1);
/* 1871 */     double[] adouble = new double[8];
/* 1872 */     double[] adouble1 = new double[8];
/* 1873 */     double d3 = 0.0D;
/* 1874 */     double d4 = 0.0D;
/*      */     
/* 1876 */     GL11.glTranslatef(0.29F, 0.73F, 0.0F);
/* 1877 */     int k1 = 0;
/* 1878 */     float sc = 0.0F;
/* 1879 */     sc = id / 50.0F;
/* 1880 */     float par = 0.4F;
/* 1881 */     if (sc > par) sc = par; 
/* 1882 */     GL11.glScalef(sc, sc, sc);
/*      */ 
/*      */     
/* 1885 */     for (int i = 0; i < 10; i++) {
/* 1886 */       if (!JRMCoreClient.mc.func_147113_T()) {
/* 1887 */         this.lightVertRotation[i][0] = ((int)(Math.random() * 11.0D) * 36);
/* 1888 */         this.lightVertRotation[i][1] = (float)(Math.random() * 2.0D) - 1.0F;
/* 1889 */         this.lightVertRotation[i][2] = (float)(Math.random() * 2.0D) - 1.0F;
/*      */       } 
/*      */       
/* 1892 */       GL11.glRotated((i * 36), 0.0D, 0.0D, 1.0D);
/* 1893 */       GL11.glRotatef(this.lightVertRotation[i][0], this.lightVertRotation[i][1], this.lightVertRotation[i][2], 0.0F);
/*      */       
/* 1895 */       Random random1 = new Random(this.lightVert[i]);
/* 1896 */       for (int j = 0; j < 3; j++) {
/*      */         
/* 1898 */         int k = 7;
/* 1899 */         int l = 0;
/*      */         
/* 1901 */         if (j > 0)
/*      */         {
/* 1903 */           k = 7 - j;
/*      */         }
/*      */         
/* 1906 */         if (j > 0)
/*      */         {
/* 1908 */           l = k - 2;
/*      */         }
/*      */         
/* 1911 */         double d5 = adouble[k] - d3;
/* 1912 */         double d6 = adouble1[k] - d4;
/*      */         
/* 1914 */         for (int i1 = k; i1 >= l; i1--) {
/*      */           
/* 1916 */           double d7 = d5;
/* 1917 */           double d8 = d6;
/*      */           
/* 1919 */           d5 += (random1.nextInt(31) - 15) * 0.07000000029802322D;
/* 1920 */           d6 += (random1.nextInt(31) - 15) * 0.07000000029802322D;
/*      */ 
/*      */           
/* 1923 */           tessellator2.func_78371_b(5);
/* 1924 */           float f2 = 0.5F;
/* 1925 */           tessellator2.func_78369_a(0.9F * f2, 0.9F * f2, 1.0F * f2, 0.3F);
/* 1926 */           double d9 = 0.1D + k1 * 0.2D;
/*      */           
/* 1928 */           double d10 = 0.1D + k1 * 0.2D;
/*      */           
/* 1930 */           for (int j1 = 0; j1 < 5; j1++) {
/*      */             
/* 1932 */             double d11 = 0.0D - d9;
/* 1933 */             double d12 = 0.0D - d9;
/*      */             
/* 1935 */             if (j1 == 1 || j1 == 2)
/*      */             {
/* 1937 */               d11 += d9 * 2.0D * sc;
/*      */             }
/*      */             
/* 1940 */             if (j1 == 2 || j1 == 3)
/*      */             {
/* 1942 */               d12 += d9 * 2.0D * sc;
/*      */             }
/*      */             
/* 1945 */             double d13 = 0.0D - d10;
/* 1946 */             double d14 = 0.0D - d10;
/*      */             
/* 1948 */             if (j1 == 1 || j1 == 2) {
/* 1949 */               d13 += d10 * 2.0D * sc;
/*      */             }
/*      */             
/* 1952 */             if (j1 == 2 || j1 == 3) {
/* 1953 */               d14 += d10 * 2.0D * sc;
/*      */             }
/* 1955 */             if (i1 < 8) {
/* 1956 */               tessellator2.func_78377_a(d13 + d5 * sc, -((i1 * 1 - 7)) * sc, d14 + d6 * sc);
/* 1957 */               tessellator2.func_78377_a(d11 + d7 * sc, -(((i1 + 1) * 1 - 7)) * sc, d12 + d8 * sc);
/*      */             } 
/*      */           } 
/*      */           
/* 1961 */           tessellator2.func_78381_a();
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/* 1966 */     GL11.glDisable(3042);
/* 1967 */     GL11.glEnable(2896);
/* 1968 */     GL11.glEnable(3553);
/* 1969 */     GL11.glPopMatrix(); }
/*      */   protected void renderEquippedItemsJBRA(AbstractClientPlayer abstractClientPlayer, float par2) { Object data = null; if (JBRAH.JHDS()) { Object temp = JBRAH.skinData((EntityPlayer)abstractClientPlayer); data = (temp != null) ? temp : null; }  ItemStack itemstack = abstractClientPlayer.field_71071_by.func_70440_f(3); boolean doit = true; ItemStack hair = abstractClientPlayer.field_71071_by.func_70440_f(3); if (hair != null) { if (JRMCoreH.DBC()) { doit = true; } else if (JRMCoreH.NC() && itemstack.func_77973_b() instanceof ItemArmor) { if (hair.func_77973_b().func_77658_a().endsWith("Headband")) doit = false;  if (hair.func_77973_b().func_77658_a().replaceAll("item.", "").startsWith("akatsuki")) doit = true;  } else { doit = true; }  } else { doit = true; }  boolean dbc = JRMCoreH.DBC(); boolean nc = JRMCoreH.NC(); boolean saoc = JRMCoreH.SAOC(); if (JRMCoreH.plyrs != null && JRMCoreH.plyrs.length > 0 && !abstractClientPlayer.func_82150_aj() && JRMCoreH.dnn(1) && ((JRMCoreH.dnn(2) && JRMCoreH.dnn(4) && JRMCoreH.dnn(5) && JRMCoreH.dnn(19)) || (!dbc && !saoc && !nc))) for (int pl = 0; pl < JRMCoreH.plyrs.length; pl++) { if (JRMCoreH.plyrs[pl].equals(abstractClientPlayer.func_70005_c_())) { this.pl = abstractClientPlayer.func_145782_y(); String[] s = JRMCoreH.data1[pl].split(";"); String[] dummy = { "0", "0", "0" }; int rg = (JRMCoreH.data4 == null) ? 0 : Integer.parseInt(JRMCoreH.data4[pl].split(";")[0]); String[] state = (JRMCoreH.data2 == null) ? dummy : JRMCoreH.data2[pl].split(";"); String dns = s[1]; int powerType = Integer.parseInt(s[2]); int race = Integer.parseInt(s[0]); int classID = Integer.parseInt(s[3]); int weight = Integer.parseInt(s[5].split(",")[0]); int st = (JRMCoreH.rc_arc(race) && JRMCoreGuiScreen.ufc) ? 6 : ((powerType == 2 || race == 0) ? 0 : b(state[0])); int stY = b(state[0]); boolean saiOozar = JRMCoreH.rSai(race) ? ((st == 7 || st == 8)) : false; int gen = JRMCoreH.dnsGender(dns); int haircol = JRMCoreH.dnsHairC(dns); int hairback = JRMCoreH.dnsHairB(dns); int breast = JRMCoreH.dnsBreast(dns); int skintype = JRMCoreH.dnsSkinT(dns); boolean iau = (JRMCoreH.rc_arc(race) && st == 6); String dnsau = JRMCoreH.data(pl, 16, ""); dnsau = dnsau.contains(";") ? dnsau.substring(1) : (JRMCoreH.plyrs[pl].equals(JBRAClient.mc.field_71439_g.func_70005_c_()) ? dnsau : ""); int bodytype = (skintype == 0) ? JRMCoreH.dnsBodyC1_0(dns) : JRMCoreH.dnsBodyT(dns); int bodycm = (skintype == 0) ? 0 : (iau ? JRMCoreH.dnsauCM(dnsau) : JRMCoreH.dnsBodyCM(dns)); int bodyc1 = (skintype == 0) ? 0 : (iau ? JRMCoreH.dnsauC1(dnsau) : JRMCoreH.dnsBodyC1(dns)); int bodyc2 = (skintype == 0) ? 0 : (iau ? JRMCoreH.dnsauC2(dnsau) : JRMCoreH.dnsBodyC2(dns)); int bodyc3 = (skintype == 0) ? 0 : (iau ? JRMCoreH.dnsauC3(dnsau) : JRMCoreH.dnsBodyC3(dns)); int facen = (skintype == 0) ? 0 : JRMCoreH.dnsFaceN(dns); int facem = (skintype == 0) ? 0 : JRMCoreH.dnsFaceM(dns); int eyes = (skintype == 0) ? 0 : JRMCoreH.dnsEyes(dns); int eyec1 = (skintype == 0) ? 0 : JRMCoreH.dnsEyeC1(dns); int eyec2 = (skintype == 0) ? 0 : JRMCoreH.dnsEyeC2(dns); String[] dat5 = (JRMCoreH.data5 == null) ? dummy : JRMCoreH.data5[pl].split(";"); boolean lg = JRMCoreH.lgndb(pl, race, st); boolean v = JRMCoreH.StusEfctsClient(17, pl); boolean l = JRMCoreH.StusEfctsClient(19, pl); boolean gd = JRMCoreH.StusEfctsClient(20, pl); int hc = haircol; int Hair = hairback; int ultra_instinct_level = 0; boolean ultra_instinct_color = false; if (JRMCoreH.DBC() && l && JGConfigUltraInstinct.CONFIG_UI_LEVELS > 0) { byte id = (JGConfigUltraInstinct.CONFIG_UI_LEVELS < b(state[1])) ? JGConfigUltraInstinct.CONFIG_UI_LEVELS : b(state[1]); ultra_instinct_level = JRMCoreH.state2UltraInstinct(false, id); ultra_instinct_color = JGConfigUltraInstinct.CONFIG_UI_HAIR_WHITE[ultra_instinct_level]; }  int suphcol = ((JRMCoreH.rc_sai(race) || gd) && dbc) ? JRMCoreHDBC.getPlayerColor(0, 0, powerType, race, st, v, lg, l, ultra_instinct_color, gd) : ((dbc && l && ultra_instinct_color) ? JRMCoreHDBC.getPlayerColor(0, 0, powerType, race, st, v, lg, l, ultra_instinct_color, gd) : 0); int supecoll = dbc ? JRMCoreHDBC.getPlayerColor2(1, eyec1, powerType, race, stY, v, lg, l, gd) : eyec1; int supecolr = dbc ? JRMCoreHDBC.getPlayerColor2(1, eyec2, powerType, race, stY, v, lg, l, gd) : eyec2; String[] StE = (JRMCoreH.dat19 == null) ? dummy : JRMCoreH.dat19[pl].split(";"); byte ts = Byte.parseByte(StE[0]); boolean mj = JRMCoreH.StusEfctsClient(12, pl); boolean msk = JRMCoreH.StusEfctsClient(6, pl); ExtendedPlayer props = ExtendedPlayer.get((EntityPlayer)abstractClientPlayer); String dnsH = (props.getHairCode().length() > 5) ? props.getHairCode() : ""; dnsH = JRMCoreH.dnsHairG1toG2(dnsH); int plyrSpc = (skintype == 0) ? 0 : ((JRMCoreH.RaceCustomSkin[race] == 0) ? 0 : ((bodytype >= JRMCoreH.Specials[race]) ? (JRMCoreH.Specials[race] - 1) : bodytype)); if (JRMCoreH.DBC()) { kk2 = JRMCoreH.StusEfctsMe(5); kk = b(state[1]) + 1; if (kk2) { r = kk / 15.0F; g = -(kk / 15.0F); b = -(kk / 15.0F); if (r > 1.0F) r = 1.0F;  if (g < 0.0F) r = 0.0F;  if (b < 0.0F) r = 0.0F;  } else { r = 0.0F; g = 0.0F; b = 0.0F; }  }  GL11.glPushMatrix(); if (race == 5 && dbc) { String[] absorptionData, playerData13 = JRMCoreH.data(JRMCoreH.plyrs[pl], 13, "0;0;0;0,0,0+0").split(";"); if (playerData13.length > 3) { absorptionData = playerData13[3].split(","); } else { absorptionData = "0;0;0;0,0,0+0".split(","); }  (new String[1])[0] = absorptionData[1]; String[] absorptionVisuals = absorptionData[1].contains("+") ? absorptionData[1].split("+") : new String[1]; boolean majinEvil = (st == 1); boolean majinPure = (st == 3 && JGConfigRaces.CONFIG_MAJIN_PURE_PINK_SKIN); if (majinEvil) { haircol = bodycm = 12561588; } else if (majinPure) { haircol = bodycm = 16757199; }  ResourceLocation bdyskn = new ResourceLocation("jinryuudragonbc:cc/majin/" + ((gen == 1) ? "f" : "") + "majin.png"); if (abstractClientPlayer.func_145782_y() == JBRAClient.mc.field_71439_g.func_145782_y()) { this; if (curSkin == null) curSkin = bdyskn;  }  func_110776_a(bdyskn); glColor3f(bodycm); this.modelMain.renderBody(0.0625F); int absorbedRace = Integer.parseInt(absorptionVisuals[0]); if (JRMCoreH.isRaceArcosian(absorbedRace) || JRMCoreH.isRaceNamekian(absorbedRace)) { bdyskn = new ResourceLocation("jinryuudragonbc:cc/majin/" + ((gen == 1) ? "f" : "") + "majin_" + (JRMCoreH.isRaceArcosian(absorbedRace) ? "arco" : "namek") + ".png"); func_110776_a(bdyskn); glColor3f(bodycm); this.modelMain.renderBody(0.0625F); }  func_110776_a(new ResourceLocation("jinryuudragonbc", "cc/majin/" + ((gen == 1) ? "f" : "") + "majinn" + facen + ".png")); glColor3f(bodycm); this.modelMain.renderHairs(0.0625F, "FACENOSE"); func_110776_a(new ResourceLocation("jinryuudragonbc", "cc/majin/" + ((gen == 1) ? "f" : "") + "majinm" + facem + ".png")); glColor3f(bodycm); this.modelMain.renderHairs(0.0625F, "FACEMOUTH"); func_110776_a(new ResourceLocation("jinryuudragonbc", "cc/majin/" + ((gen == 1) ? "f" : "") + "majinb" + eyes + ".png")); GL11.glColor3f(1.0F + getR(), 1.0F + getG(), 1.0F + getB()); this.modelMain.renderHairs(0.0625F, "EYEBASE"); if (supecoll > 0) { func_110776_a(new ResourceLocation("jinryuudragonbc", "cc/majin/" + ((gen == 1) ? "f" : "") + "majinl" + eyes + ".png")); glColor3f((dbc && (JRMCoreH.isRaceMajin(race) || gd || JRMCoreHDBC.godKiUserBase(race, stY) || l)) ? supecoll : eyec1); this.modelMain.renderHairs(0.0625F, "EYELEFT"); }  if (supecolr > 0) { func_110776_a(new ResourceLocation(JRMCoreH.tjdbcAssts, "cc/majin/" + ((gen == 1) ? "f" : "") + "majinr" + eyes + ".png")); glColor3f((dbc && (JRMCoreH.isRaceMajin(race) || gd || JRMCoreHDBC.godKiUserBase(race, stY) || l)) ? supecolr : eyec2); this.modelMain.renderHairs(0.0625F, "EYERIGHT"); }  glColor3f(hc); boolean scouter = false; boolean helmet = false; if (itemstack != null) { Item item = itemstack.func_77973_b(); if (JRMCoreH.DBC() && item instanceof ItemArmor) { ItemArmor itemarmor = (ItemArmor)item; helmet = true; }  }  boolean vanity_head = false; String[][] slot_vanity_num = new String[8][]; int[] slot_van = new int[8]; for (int i = 0; i < 8; i++) { slot_vanity_num[i] = s[8 + i].split(","); slot_van[i] = Integer.parseInt(slot_vanity_num[i][0]); if (!vanity_head && slot_van[i] > 0) { new Item(); Item vanity_check = Item.func_150899_d(slot_van[i]); if (vanity_check instanceof ItemVanity && ((ItemVanity)vanity_check).armorType == 5 && slot_van[i] != Item.func_150891_b(ItemsDBC.Coat_2) && slot_van[i] != Item.func_150891_b(ItemsDBC.Coat)) vanity_head = true;  }  }  slot_vanity_num = new String[8][]; slot_van = new int[8]; String[] absorptionData2 = absorptionData[2].split("-"); if (absorptionData2.length > 0) for (int k = 0; k < absorptionData2.length; k++) { if (absorptionData2[k].contains("+")) { slot_vanity_num[k] = absorptionData2[k].split("\\+"); slot_van[k] = Integer.parseInt(slot_vanity_num[k][0]); }  }   for (int j = 0; j < absorptionData2.length; j++) { if (absorptionData2.length > 0) { if (j <= absorptionData2.length) { slot_vanity_num[j] = absorptionData2[j].split("\\+"); } else { slot_vanity_num[j] = "0+0".split("\\+"); }  slot_van[j] = Integer.parseInt(slot_vanity_num[j][0]); if (!vanity_head && slot_van[j] > 0) { new Item(); Item vanity_check = Item.func_150899_d(slot_van[j]); if (vanity_check instanceof ItemVanity && ((ItemVanity)vanity_check).armorType == 5 && slot_van[j] != Item.func_150891_b(ItemsDBC.Coat_2) && slot_van[j] != Item.func_150891_b(ItemsDBC.Coat)) vanity_head = true;  }  }  }  if (!saiOozar) { boolean dhhwho = JRMCoreConfig.HHWHO ? (((!helmet && !vanity_head) || scouter)) : true; if (Hair == 12 && dhhwho && dnsH.length() > 3) { func_110776_a(new ResourceLocation("jinryuumodscore:gui/normallmajin.png")); if (abstractClientPlayer == JBRAClient.mc.field_71439_g && JRMCoreGuiScreen.hairPreview > 0) st = JRMCoreGuiScreen.hairPreviewStates[JRMCoreGuiScreen.hairPreview];  glColor3f(haircol); this.modelMain.renderHairsV2(0.0625F, dnsH, 0.0F, st, rg, pl, race, this, abstractClientPlayer); } else if (Hair == 10) { func_110776_a(new ResourceLocation("jinryuumodscore:gui/normallmajin.png")); glColor3f(haircol); this.modelMain.renderHairsV2(0.0625F, "005050555050000050505550500000505055505000005050455050000050505250500000505052505000005050555050000050505450500000505052505000005050525050000150433450500000505055505000005050525050000054395050500000505045505000005050475050000050504750500000505047505000015043655050000050504750500000505047505000005050475050000050504750500000544545505000005250505050000052505050500000525050505000005250505050000050505050500000505050505000005050505050000052505050500000525050505000005250505050000052505050500000525050505000005245505050000054505050500000525050505000005252505050000070505050500000705050505000007050505050000070505050500000705050505000347050505050003470505050500000705050505000007050505050000069505050500000695050505000007050505050000070505050500000705050505000007050505050000070505050500020", 0.0F, 0, 0, pl, race, this, abstractClientPlayer); } else if (Hair == 11) { func_110776_a(new ResourceLocation("jinryuumodscore:gui/normallmajin.png")); glColor3f(haircol); this.modelMain.renderHairsV2(0.0625F, "345052545050001250545650500023505041505000345056455050000150505250500001505052505000015050555050000150505450500001505052505000015050525050000150433450500001505055505000015050525050000154395050500001505045505000015050475050000150504750500001505047505000015043655050000150504750500001505047505000015050475050000150504750500001544545505000015250505050003450505050500034505050505000015250505050000150505050500001505050505000015050505050000150505050500001525050505000015050505050000150505050500001525050505000235250505050003450505050500034505050505000235250505050000180501850500034695050505000346950505050000180501950500001805019505000345850505050003463505050500001805018505000018050185050003476505050500034765050505000018050195050003480501850500034505050505000345050505050003480501950500020", 0.0F, 0, 0, pl, race, this, abstractClientPlayer); } else if (dhhwho) {  }  }  } else if (race == 3 && dbc) { boolean ssg = JRMCoreHDBC.godKiUserBase(race, st); if (ssg && v) { bodycm = 16744999; bodyc1 = 15524763; bodyc2 = 12854822; bodyc3 = 0; eyec1 = eyec2 = 13636110; }  func_110776_a(new ResourceLocation("jinryuudragonbc:gui/allw.png")); float h1 = 1.0F; glColor3f(bodycm); this.modelMain.renderHairs(0.0625F, "N"); ResourceLocation bdyskn = new ResourceLocation("jinryuudragonbc:cc/nam/0nam" + plyrSpc + ".png"); if (abstractClientPlayer.func_145782_y() == JBRAClient.mc.field_71439_g.func_145782_y()) { this; if (curSkin == null) curSkin = bdyskn;  }  func_110776_a(bdyskn); glColor3f(bodycm); this.modelMain.renderBody(0.0625F); bdyskn = new ResourceLocation("jinryuudragonbc:cc/nam/1nam" + plyrSpc + ".png"); if (abstractClientPlayer.func_145782_y() == JBRAClient.mc.field_71439_g.func_145782_y()) { this; if (curSkin == null) curSkin = bdyskn;  }  func_110776_a(bdyskn); glColor3f(bodyc1); this.modelMain.renderBody(0.0625F); bdyskn = new ResourceLocation("jinryuudragonbc:cc/nam/2nam" + plyrSpc + ".png"); if (abstractClientPlayer.func_145782_y() == JBRAClient.mc.field_71439_g.func_145782_y()) { this; if (curSkin == null) curSkin = bdyskn;  }  func_110776_a(bdyskn); glColor3f(bodyc2); this.modelMain.renderBody(0.0625F); bdyskn = new ResourceLocation("jinryuudragonbc:cc/nam/3nam" + plyrSpc + ".png"); if (abstractClientPlayer.func_145782_y() == JBRAClient.mc.field_71439_g.func_145782_y()) { this; if (curSkin == null) curSkin = bdyskn;  }  func_110776_a(bdyskn); GL11.glColor3f(h1 + getR(), h1 + getG(), h1 + getB()); this.modelMain.renderBody(0.0625F); func_110776_a(new ResourceLocation("jinryuudragonbc", "cc/nam/4namn" + facen + ".png")); glColor3f(bodycm); this.modelMain.renderHairs(0.0625F, "FACENOSE"); func_110776_a(new ResourceLocation("jinryuudragonbc", "cc/nam/4namm" + facem + ".png")); glColor3f(bodycm); this.modelMain.renderHairs(0.0625F, "FACEMOUTH"); func_110776_a(new ResourceLocation("jinryuudragonbc", "cc/nam/4namb" + eyes + ".png")); GL11.glColor3f(1.0F + getR(), 1.0F + getG(), 1.0F + getB()); this.modelMain.renderHairs(0.0625F, "EYEBASE"); func_110776_a(new ResourceLocation("jinryuudragonbc", "cc/nam/4naml" + eyes + ".png")); glColor3f((JRMCoreH.rc_sai(race) || gd || JRMCoreHDBC.godKiUserBase(race, stY) || l) ? supecoll : eyec1); this.modelMain.renderHairs(0.0625F, "EYELEFT"); func_110776_a(new ResourceLocation("jinryuudragonbc", "cc/nam/4namr" + eyes + ".png")); glColor3f((JRMCoreH.rc_sai(race) || gd || JRMCoreHDBC.godKiUserBase(race, stY) || l) ? supecolr : eyec2); this.modelMain.renderHairs(0.0625F, "EYERIGHT"); func_110776_a(new ResourceLocation("jinryuudragonbc", "cc/nam/4namw" + eyes + ".png")); glColor3f(bodycm); this.modelMain.renderHairs(0.0625F, "EYEBROW"); } else if (race == 4 && dbc) { boolean ssg = JRMCoreHDBC.godKiUserBase(race, st); if (ssg && v) { st = 6; bodycm = 5526612; bodyc1 = 12829635; bodyc3 = 1513239; }  func_110776_a(new ResourceLocation("jinryuudragonbc:cc/arc/" + ((gen == 1) ? "f" : "m") + "/0B" + JRMCoreH.TransFrSkn2[st] + plyrSpc + ".png")); glColor3f(bodycm); this.modelMain.renderHairs(0.0625F, ((ts == 4) ? "n" : "") + "FR" + JRMCoreH.TransFrHrn[st]); func_110776_a(new ResourceLocation("jinryuudragonbc:cc/arc/" + ((gen == 1) ? "f" : "m") + "/1B" + JRMCoreH.TransFrSkn2[st] + plyrSpc + ".png")); glColor3f(bodyc1); this.modelMain.renderHairs(0.0625F, ((ts == 4) ? "n" : "") + "FR" + JRMCoreH.TransFrHrn[st]); ResourceLocation bdyskn = new ResourceLocation("jinryuudragonbc:cc/arc/" + ((gen == 1) ? "f" : "m") + "/1A" + JRMCoreH.TransFrSkn[st] + plyrSpc + ".png"); if (abstractClientPlayer.func_145782_y() == JBRAClient.mc.field_71439_g.func_145782_y()) { this; if (curSkin == null) curSkin = bdyskn;  }  func_110776_a(bdyskn); glColor3f(bodyc1); this.modelMain.renderBody(0.0625F); func_110776_a(new ResourceLocation("jinryuudragonbc:cc/arc/" + ((gen == 1) ? "f" : "m") + "/2B" + JRMCoreH.TransFrSkn2[st] + plyrSpc + ".png")); glColor3f(bodyc2); this.modelMain.renderHairs(0.0625F, ((ts == 4) ? "n" : "") + "FR" + JRMCoreH.TransFrHrn[st]); bdyskn = new ResourceLocation("jinryuudragonbc:cc/arc/" + ((gen == 1) ? "f" : "m") + "/2A" + JRMCoreH.TransFrSkn[st] + plyrSpc + ".png"); if (abstractClientPlayer.func_145782_y() == JBRAClient.mc.field_71439_g.func_145782_y()) { this; if (curSkin == null) curSkin = bdyskn;  }  func_110776_a(bdyskn); glColor3f(bodyc2); this.modelMain.renderBody(0.0625F); func_110776_a(new ResourceLocation("jinryuudragonbc:cc/arc/" + ((gen == 1) ? "f" : "m") + "/3B" + JRMCoreH.TransFrSkn2[st] + plyrSpc + ".png")); glColor3f(bodyc3); this.modelMain.renderHairs(0.0625F, ((ts == 4) ? "n" : "") + "FR" + JRMCoreH.TransFrHrn[st]); bdyskn = new ResourceLocation("jinryuudragonbc:cc/arc/" + ((gen == 1) ? "f" : "m") + "/3A" + JRMCoreH.TransFrSkn[st] + plyrSpc + ".png"); if (abstractClientPlayer.func_145782_y() == JBRAClient.mc.field_71439_g.func_145782_y()) { this; if (curSkin == null) curSkin = bdyskn;  }  func_110776_a(bdyskn); glColor3f(bodyc3); this.modelMain.renderBody(0.0625F); bdyskn = new ResourceLocation("jinryuudragonbc:cc/arc/" + ((gen == 1) ? "f" : "m") + "/0A" + JRMCoreH.TransFrSkn[st] + plyrSpc + ".png"); if (abstractClientPlayer.func_145782_y() == JBRAClient.mc.field_71439_g.func_145782_y()) { this; if (curSkin == null) curSkin = bdyskn;  }  func_110776_a(bdyskn); glColor3f(bodycm); this.modelMain.renderBody(0.0625F); func_110776_a(new ResourceLocation("jinryuudragonbc:cc/arc/" + ((gen == 1) ? "f" : "m") + "/4B" + JRMCoreH.TransFrSkn2[st] + plyrSpc + ".png")); float h1 = 1.0F; GL11.glColor3f(h1 + getR(), h1 + getG(), h1 + getB()); this.modelMain.renderHairs(0.0625F, ((ts == 4) ? "n" : "") + "FR" + JRMCoreH.TransFrHrn[st]); bdyskn = new ResourceLocation("jinryuudragonbc:cc/arc/" + ((gen == 1) ? "f" : "m") + "/4A" + JRMCoreH.TransFrSkn[st] + plyrSpc + ".png"); if (abstractClientPlayer.func_145782_y() == JBRAClient.mc.field_71439_g.func_145782_y()) { this; if (curSkin == null) curSkin = bdyskn;  }  func_110776_a(bdyskn); GL11.glColor3f(h1 + getR(), h1 + getG(), h1 + getB()); this.modelMain.renderBody(0.0625F); func_110776_a(new ResourceLocation("jinryuudragonbc", "cc/arc/" + ((gen == 1) ? "f" : "m") + "/4A" + JRMCoreH.TransFrSkn[st] + plyrSpc + "n" + facen + ".png")); glColor3f(bodyc1); this.modelMain.renderHairs(0.0625F, "FACENOSE"); if (st == 5 && msk) { func_110776_a(new ResourceLocation("jinryuudragonbc", "cc/arc/" + ((gen == 1) ? "f" : "m") + "/0A" + JRMCoreH.TransFrSkn[st] + plyrSpc + "a.png")); glColor3f(bodycm); this.modelMain.renderHairs(0.0625F, "FACEMOUTH"); } else { func_110776_a(new ResourceLocation("jinryuudragonbc", "cc/arc/" + ((gen == 1) ? "f" : "m") + "/4A" + JRMCoreH.TransFrSkn[st] + plyrSpc + "m" + facem + ".png")); glColor3f(bodyc1); this.modelMain.renderHairs(0.0625F, "FACEMOUTH"); }  func_110776_a(new ResourceLocation("jinryuudragonbc", "cc/arc/" + ((gen == 1) ? "f" : "m") + "/4A" + JRMCoreH.TransFrSkn[st] + plyrSpc + "b" + eyes + ".png")); GL11.glColor3f(1.0F + getR(), 1.0F + getG(), 1.0F + getB()); this.modelMain.renderHairs(0.0625F, "EYEBASE"); func_110776_a(new ResourceLocation("jinryuudragonbc", "cc/arc/" + ((gen == 1) ? "f" : "m") + "/4A" + JRMCoreH.TransFrSkn[st] + plyrSpc + "l" + eyes + ".png")); glColor3f((JRMCoreH.rc_sai(race) || gd || JRMCoreHDBC.godKiUserBase(race, stY) || l) ? supecoll : eyec1); this.modelMain.renderHairs(0.0625F, "EYELEFT"); func_110776_a(new ResourceLocation("jinryuudragonbc", "cc/arc/" + ((gen == 1) ? "f" : "m") + "/4A" + JRMCoreH.TransFrSkn[st] + plyrSpc + "r" + eyes + ".png")); glColor3f((JRMCoreH.rc_sai(race) || gd || JRMCoreHDBC.godKiUserBase(race, stY) || l) ? supecolr : eyec2); this.modelMain.renderHairs(0.0625F, "EYERIGHT"); } else { if (!JRMCoreH.isRaceSaiyan(race) || st != 1 || !JRMCoreH.isAprilFoolsModeOn()) {  } else {  }  boolean isAprilFoolsFalseSSJ = true; if (saiOozar) { ResourceLocation bdyskn = new ResourceLocation("jinryuudragonbc:cc/oozaru1.png"); if (abstractClientPlayer.func_145782_y() == JBRAClient.mc.field_71439_g.func_145782_y()) { this; if (curSkin == null) curSkin = bdyskn;  }  func_110776_a(bdyskn); glColor3f((skintype != 0) ? bodycm : 11374471); this.modelMain.renderBody(0.0625F); int tailCol = (race == 2 || bodytype != 0) ? bodytype : 6498048; int j = (st == 0 || st == 7) ? ((skintype == 1) ? bodyc1 : tailCol) : (lg ? 10092390 : 16574610); bdyskn = new ResourceLocation("jinryuudragonbc:cc/oozaru2.png"); func_110776_a(bdyskn); glColor3f(j); this.modelMain.renderBody(0.0625F); func_110776_a(new ResourceLocation("jinryuudragonbc:cc/oozaru0.png")); GL11.glColor3f(1.0F + getR(), 1.0F + getG(), 1.0F + getB()); this.modelMain.renderHairs(0.0625F, "EYEBASE"); glColor3f((skintype != 0) ? bodycm : 11374471); this.modelMain.renderHairs(0.0625F, "OOZARU"); } else if (skintype != 0) { boolean b3; ResourceLocation bdyskn = new ResourceLocation("jinryuumodscore:cc/" + ((gen == 1) ? "f" : "") + "hum.png"); if (abstractClientPlayer.func_145782_y() == JBRAClient.mc.field_71439_g.func_145782_y()) { this; if (curSkin == null)
/*      */                   curSkin = bdyskn;  }  func_110776_a(bdyskn); glColor3f(bodycm); this.modelMain.renderBody(0.0625F); func_110776_a(new ResourceLocation("jinryuumodscore", "cc/" + ((gen == 1) ? "f" : "") + "humn" + facen + ".png")); glColor3f(bodycm); this.modelMain.renderHairs(0.0625F, "FACENOSE"); func_110776_a(new ResourceLocation("jinryuumodscore", "cc/" + ((gen == 1) ? "f" : "") + "humm" + facem + ".png")); glColor3f(bodycm); this.modelMain.renderHairs(0.0625F, "FACEMOUTH"); func_110776_a(new ResourceLocation("jinryuumodscore", "cc/" + ((gen == 1) ? "f" : "") + "humb" + eyes + ".png")); GL11.glColor3f(1.0F + getR(), 1.0F + getG(), 1.0F + getB()); this.modelMain.renderHairs(0.0625F, "EYEBASE"); if (supecoll > 0 && !isAprilFoolsFalseSSJ) { if (powerType == 2 && classID == 1) { func_110776_a(new ResourceLocation(JRMCoreH.tjnc, "cc/cl" + classID + "/" + ((gen == 1) ? "f" : "") + "huml" + eyes + ".png")); glColor3f(15590377); } else if (powerType == 2 && classID == 2 && stY > 0) { func_110776_a(new ResourceLocation(JRMCoreH.tjnc, "cc/cl" + classID + "/" + ((gen == 1) ? "f" : "") + "huml" + eyes + ".png")); glColor3f(13828096); } else { func_110776_a(new ResourceLocation("jinryuumodscore", "cc/" + ((gen == 1) ? "f" : "") + "huml" + eyes + ".png")); glColor3f((dbc && (JRMCoreH.rc_sai(race) || gd || JRMCoreHDBC.godKiUserBase(race, stY) || l)) ? supecoll : eyec1); }  this.modelMain.renderHairs(0.0625F, "EYELEFT"); }  if (supecolr > 0 && !isAprilFoolsFalseSSJ) { if (powerType == 2 && classID == 1) { func_110776_a(new ResourceLocation(JRMCoreH.tjnc, "cc/cl" + classID + "/" + ((gen == 1) ? "f" : "") + "humr" + eyes + ".png")); glColor3f(15590377); } else if (powerType == 2 && classID == 2 && stY > 0) { func_110776_a(new ResourceLocation(JRMCoreH.tjnc, "cc/cl" + classID + "/" + ((gen == 1) ? "f" : "") + "humr" + eyes + ".png")); glColor3f(13828096); } else { func_110776_a(new ResourceLocation(JRMCoreH.tjjrmc, "cc/" + ((gen == 1) ? "f" : "") + "humr" + eyes + ".png")); glColor3f((dbc && (JRMCoreH.rc_sai(race) || gd || JRMCoreHDBC.godKiUserBase(race, stY) || l)) ? supecolr : eyec2); }  this.modelMain.renderHairs(0.0625F, "EYERIGHT"); }  if (gd) { b3 = true; } else if (race == 1 || race == 2) { if (Integer.parseInt(state[0]) != 6) { b3 = false; } else { b3 = true; }  } else { b3 = false; }  func_110776_a(new ResourceLocation("jinryuumodscore", "cc/" + (b3 ? "ssj3eyebrow/" : "") + ((gen == 1) ? "f" : "") + "humw" + eyes + ".png")); if (!b3) { if (l && ultra_instinct_color) { glColor3f(15790320, age); } else if (JRMCoreH.isRaceSaiyan(race) && st != 0 && st != 14 && !isAprilFoolsFalseSSJ) { glColor3f(suphcol); } else { glColor3f(haircol, age); }  } else { GL11.glColor3f(1.0F, 1.0F, 1.0F); }  this.modelMain.renderHairs(0.0625F, "EYEBROW"); }  if (JRMCoreH.rc_sai(race) && dbc) { float f = 1.0F; int tailCol = (race == 2 || bodytype != 0) ? bodytype : 6498048; int j = ((st == 0 || st == 7 || st == 14 || isAprilFoolsFalseSSJ) && !gd) ? ((skintype == 1) ? bodyc1 : tailCol) : suphcol; if (JRMCoreH.rSai(race))
/*      */                 if (j == 6498048 && st == 14) { j = JRMCoreH.isAprilFoolsModeOn() ? 13292516 : 14292268; } else if (st != 14 && l && ultra_instinct_color) { j = 15790320; }   func_110776_a(new ResourceLocation("jinryuudragonbc:gui/allw.png")); glColor3f(j); this.modelMain.renderHairs(0.0625F, (ts == 0 || ts == -1) ? "SJT1" : ((ts == 1) ? "SJT2" : "")); }  float h1 = 1.0F; if (!saiOozar)
/*      */               if (skintype == 0 && gen >= 1) { ResourceLocation bdyskn = abstractClientPlayer.func_110306_p().equals(steveTextures) ? fem : abstractClientPlayer.func_110306_p(); if (abstractClientPlayer.func_145782_y() == JBRAClient.mc.field_71439_g.func_145782_y()) { this; if (curSkin == null)
/*      */                     curSkin = bdyskn;  }  if (JBRAH.JHDS() && JBRAH.getSkinHas(data)) { func_110776_a(JBRAH.getSkinLoc(data)); } else { func_110776_a(bdyskn); }  GL11.glColor3f(h1 + getR(), h1 + getG(), h1 + getB()); this.modelMain.renderBody(0.0625F); } else if (JBRAH.JHDS() && JBRAH.getSkinHas(data) && skintype == 0) { GL11.glColor3f(h1 + getR(), h1 + getG(), h1 + getB()); func_110776_a(JBRAH.getSkinLoc(data)); this.modelMain.renderBody(0.0625F); curSkin = null; }   boolean bc = (gd || ((l ? ultra_instinct_color : (st != 0)) && st != 14 && !isAprilFoolsFalseSSJ)); if ((Hair == 8 || Hair == 9) && (st == 0 || st == 1)) { hc = bc ? suphcol : hc; String s1 = (Hair == 8) ? "c2" : "c1"; func_110776_a(new ResourceLocation("jinryuumodscore:gui/" + s1 + ".png")); } else if (Hair >= 0 && Hair <= 12) { hc = bc ? suphcol : ((st == 14 && JRMCoreH.isAprilFoolsModeOn()) ? 13292516 : hc); String s1 = (st == 0) ? "normall" : "superall"; func_110776_a(new ResourceLocation("jinryuumodscore:gui/" + s1 + ".png")); }  if (bc) { glColor3f(hc); } else { glColor3f(hc, age); }  boolean scouter = false; boolean helmet = false; if (itemstack != null) { Item item = itemstack.func_77973_b(); if (JRMCoreH.DBC() && item instanceof ItemArmor) { ItemArmor itemarmor = (ItemArmor)item; helmet = true; }  }  boolean vanity_head = false; String[][] slot_vanity_num = new String[8][]; int[] slot_van = new int[8]; for (int i = 0; i < 8; i++) { slot_vanity_num[i] = s[8 + i].split(","); slot_van[i] = Integer.parseInt(slot_vanity_num[i][0]); if (!vanity_head && slot_van[i] > 0) { new Item(); Item vanity_check = Item.func_150899_d(slot_van[i]); if (vanity_check instanceof ItemVanity && ((ItemVanity)vanity_check).armorType == 5 && slot_van[i] != Item.func_150891_b(ItemsDBC.Coat_2) && slot_van[i] != Item.func_150891_b(ItemsDBC.Coat))
/*      */                   vanity_head = true;  }  }  if (!saiOozar) { boolean dhhwho = JRMCoreConfig.HHWHO ? (((!helmet && !vanity_head) || scouter)) : true; if (Hair == 12 && dhhwho && dnsH.length() > 3) { func_110776_a(new ResourceLocation("jinryuumodscore:gui/normall.png")); if (abstractClientPlayer == JBRAClient.mc.field_71439_g && JRMCoreGuiScreen.hairPreview > 0)
/*      */                   st = JRMCoreGuiScreen.hairPreviewStates[JRMCoreGuiScreen.hairPreview];  if (st == 6) { this.modelMain.renderHairs(0.0625F, "" + JRMCoreH.HairsT[6] + JRMCoreH.Hairs[0]); } else if (st == 14) { this.modelMain.renderHairsV2(0.0625F, "373852546750347428545480193462285654801934283647478050340147507467501848505072675018255250726750183760656580501822475071675018255050716750189730327158501802475071675018973225673850189765616160501820414547655019545654216550195754542165501920475027655019943669346576193161503065231900475030655019406534276538199465393460501997654138655019976345453950189760494941501897615252415018976354563850189763494736501897614949395018976152523950189763525234501897584749395018976150493850189760545234501897585250415018885445474550189754475041501897545250435018885454523950185143607861501897415874585018514369196150185147768078391865525680565018974356806150188843567861501868396374615018975056805650189750568056501885582374615018975823726150187149568054501877495680565018774950785650189163236961501820", 0.0F, 0, 0, pl, race, this, abstractClientPlayer); } else { this.modelMain.renderHairsV2(0.0625F, dnsH, 0.0F, st, rg, pl, race, this, abstractClientPlayer); }  } else if (Hair == 10) { GL11.glColor3f(h1 + getR(), h1 + getG(), h1 + getB()); if (JBRAH.JHDS() && JBRAH.getSkinHas(data)) { func_110776_a(JBRAH.getSkinLoc(data)); } else { func_110776_a(abstractClientPlayer.func_110306_p()); }  this.modelMain.renderHeadwear(0.0625F); } else if (dhhwho) { if (st == 14) { this.modelMain.renderHairsV2(0.0625F, "373852546750347428545480193462285654801934283647478050340147507467501848505072675018255250726750183760656580501822475071675018255050716750189730327158501802475071675018973225673850189765616160501820414547655019545654216550195754542165501920475027655019943669346576193161503065231900475030655019406534276538199465393460501997654138655019976345453950189760494941501897615252415018976354563850189763494736501897614949395018976152523950189763525234501897584749395018976150493850189760545234501897585250415018885445474550189754475041501897545250435018885454523950185143607861501897415874585018514369196150185147768078391865525680565018974356806150188843567861501868396374615018975056805650189750568056501885582374615018975823726150187149568054501877495680565018774950785650189163236961501820", 0.0F, 0, 0, pl, race, this, abstractClientPlayer); } else { this.modelMain.renderHairs(0.0625F, "" + JRMCoreH.HairsT[st] + JRMCoreH.Hairs[Hair]); }  }  if (st == 14) { int tailCol = (race == 2 || bodytype != 0) ? bodytype : 6498048; tailCol = JRMCoreH.isAprilFoolsModeOn() ? 13292516 : tailCol; int jx = (skintype == 1) ? bodyc1 : tailCol; if (JRMCoreH.rSai(race) && jx == 6498048 && st == 14)
/*      */                   if (JRMCoreH.isAprilFoolsModeOn()) { jx = 13292516; } else { jx = 14292268; }   func_110776_a(new ResourceLocation("jinryuudragonbc:cc/ss4" + ((skintype == 0) ? "a" : "b") + ".png")); glColor3f(jx); this.modelMain.renderBody(0.0625F); }  }  }  if (mj) { func_110776_a(new ResourceLocation("jinryuudragonbc", "textures/misc/m.png")); GL11.glColor3f(1.0F + getR(), 1.0F + getG(), 1.0F + getB()); this.modelMain.renderHairs(0.0625F, "EYERIGHT"); }  if (dbc) { int w = weight; String[] wnam = { "wshell", "whandleg" }; if (w >= 0 && w < wnam.length) { String[] wloc = { "roshiShell", "weightBands" }; func_110776_a(new ResourceLocation("jinryuudragonbc:textures/misc/" + wloc[w] + ".png")); GL11.glColor3f(1.0F + getR(), 1.0F + getG(), 1.0F + getB()); this.modelMain.renderHairs(0.0625F, wnam[w]); }  }  if (JGConfigClientSettings.CLIENT_DA19 && (JRMCoreH.DBC() || JRMCoreH.NC())) { GL11.glPushMatrix(); GL11.glEnable(3042); GL11.glDisable(2896); GL11.glBlendFunc(770, 771); GL11.glAlphaFunc(516, 0.003921569F); GL11.glDepthMask(false); int[] PlyrAttrbts = new int[JRMCoreH.PlyrAttrbts.length]; String[] stri = JRMCoreH.dat14[pl].split(","); for (int i = 0; i < PlyrAttrbts.length; ) { PlyrAttrbts[i] = Integer.parseInt(stri[i]); i++; }  int maxBody = JRMCoreH.stat((Entity)abstractClientPlayer, 2, powerType, 2, PlyrAttrbts[2], race, classID, 0.0F); int curBody = Integer.parseInt(JRMCoreH.data(abstractClientPlayer.func_70005_c_(), 8, "200")); float one = maxBody / 100.0F; int perc = (int)(curBody / one); if (perc < 70) { GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F); func_110776_a(new ResourceLocation("jinryuumodscore:cc/bruises1.png")); this.modelMain.renderBody(0.0625F); }  if (perc < 55) { GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F); func_110776_a(new ResourceLocation("jinryuumodscore:cc/bruises2.png")); this.modelMain.renderBody(0.0625F); }  if (perc < 35) { GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F); func_110776_a(new ResourceLocation("jinryuumodscore:cc/bruises3.png")); this.modelMain.renderBody(0.0625F); }  if (perc < 20) { GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F); func_110776_a(new ResourceLocation("jinryuumodscore:cc/bruises4.png")); this.modelMain.renderBody(0.0625F); }  GL11.glDepthMask(true); GL11.glEnable(2896); GL11.glDisable(3042); GL11.glPopMatrix(); if (JRMCoreH.NC())
/*      */               if (powerType == 2)
/*      */                 if (classID == 1 && stY > 0) { func_110776_a(new ResourceLocation("jinryuunarutoc", "misc/dojutsu/byakugan1_" + eyes + ".png")); GL11.glColor3f(1.0F + getR(), 1.0F + getG(), 1.0F + getB()); this.modelMain.renderHairs(0.0625F, "EYERIGHT"); } else if (classID == 2 && stY > 0) { int doujutsuID = (stY - 1) / 3 + 1; if (doujutsuID < 1) { doujutsuID = 1; } else if (doujutsuID > 3) { doujutsuID = 3; }  func_110776_a(new ResourceLocation("jinryuunarutoc", "misc/dojutsu/sharingan" + doujutsuID + "_" + eyes + ".png")); GL11.glColor3f(1.0F + getR(), 1.0F + getG(), 1.0F + getB()); this.modelMain.renderHairs(0.0625F, "EYERIGHT"); }    }  GL11.glPopMatrix(); doit = false; break; }  }   if (JRMCoreH.plyrs != null && JRMCoreH.plyrs.length > 0 && !abstractClientPlayer.func_82150_aj() && JRMCoreH.dnn(13))
/*      */       for (int pl = 0; pl < JRMCoreH.plyrs.length; pl++) { if (JRMCoreH.plyrs[pl].equals(abstractClientPlayer.func_70005_c_()) && JRMCoreH.aliveState(pl)) { GL11.glPushMatrix(); func_110776_a(new ResourceLocation("jinryuudragonbc:armor/halo.png")); GL11.glColor3f(1.0F + getR(), 1.0F + getG(), 1.0F + getB()); this.modelMain.renderHalo(0.0625F); GL11.glPopMatrix(); break; }  }   if (doit && !abstractClientPlayer.func_82150_aj() && abstractClientPlayer.func_152123_o()) { if (JBRAH.JHDS() && JBRAH.getSkinHas(data)) { func_110776_a(JBRAH.getSkinLoc(data)); } else { func_110776_a(abstractClientPlayer.func_110306_p()); }  GL11.glPushMatrix(); this.modelMain.renderHeadwear(0.0625F); GL11.glPopMatrix(); }  if (abstractClientPlayer.func_145782_y() == JBRAClient.mc.field_71439_g.func_145782_y()) { this; if (curSkin == null) { this; curSkin = (JBRAH.JHDS() && JBRAH.getSkinHas(data)) ? JBRAH.getSkinLoc(data) : abstractClientPlayer.func_110306_p(); }  }  this; if (!curSkinUp)
/* 1981 */       curSkinUp = true;  } public static void hndff(Entity e, boolean b, int id, int idd2) { int id2 = (id == 1) ? 0 : -1;
/* 1982 */     GL11.glPushMatrix();
/*      */     
/* 1984 */     GL11.glEnable(3042);
/* 1985 */     GL11.glDisable(2896);
/* 1986 */     GL11.glBlendFunc(770, 771);
/* 1987 */     GL11.glAlphaFunc(516, 0.003921569F);
/* 1988 */     GL11.glDepthMask(true);
/*      */     
/* 1990 */     GL11.glTranslatef(0.25F, 0.7F, 0.0F);
/*      */ 
/*      */ 
/*      */     
/* 1994 */     float sc = idd2;
/* 1995 */     if (sc < 0.0F) { sc = 0.0F; }
/* 1996 */     else { sc /= 100.0F; }
/* 1997 */      float par = 0.2F;
/* 1998 */     if (sc > par) sc = par; 
/* 1999 */     GL11.glScalef(sc, sc, sc);
/*      */ 
/*      */ 
/*      */     
/* 2003 */     float red = 1.0F, green = 1.0F, blue = 1.0F;
/* 2004 */     if (b) {
/* 2005 */       JRMCoreClient.mc.field_71446_o.func_110577_a(new ResourceLocation(JRMCoreH.tjjrmc + ":allw.png"));
/* 2006 */       GL11.glNormal3f(0.0F, 0.0F, -1.0F);
/*      */     } else {
/* 2008 */       JRMCoreClient.mc.field_71446_o.func_110577_a(new ResourceLocation(JRMCoreH.tjjrmc + ":allw.png"));
/*      */     } 
/* 2010 */     float ex = e.field_70173_aa;
/* 2011 */     float r4 = (MathHelper.func_76134_b(ex / 2.0F) / 3.0F - 0.2F) / 8.0F;
/*      */ 
/*      */     
/* 2014 */     if (gen == 2) {
/* 2015 */       GL11.glRotatef(7.0F, 0.0F, 0.0F, 1.0F);
/*      */     }
/*      */ 
/*      */     
/* 2019 */     GL11.glRotatef(e.field_70173_aa * 45.0F, 1.0F, 1.0F, 1.0F);
/*      */ 
/*      */     
/* 2022 */     if (id == 1) {
/* 2023 */       GL11.glColor4f(0.7F, 0.9F, 1.0F, 0.6F);
/* 2024 */       JRMCoreHJBRA.model1.render();
/*      */     } 
/*      */     
/* 2027 */     if (id == 2) {
/* 2028 */       float sc2 = 2.6F;
/* 2029 */       GL11.glScalef(sc2, sc2, sc2);
/* 2030 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.8F);
/*      */     }
/* 2032 */     else if (id == 1) {
/* 2033 */       float sc2 = 2.6F;
/* 2034 */       GL11.glScalef(sc2, sc2, sc2);
/*      */       
/* 2036 */       GL11.glColor4f(0.7F, 0.9F, 1.0F, 0.3F);
/*      */     } 
/* 2038 */     JRMCoreHJBRA.model1.render();
/*      */ 
/*      */     
/* 2041 */     GL11.glEnable(2896);
/* 2042 */     GL11.glDepthMask(true);
/* 2043 */     GL11.glPopMatrix(); } public static void glColor3f(int c) { float h2 = (c >> 16 & 0xFF) / 255.0F; float h3 = (c >> 8 & 0xFF) / 255.0F; float h4 = (c & 0xFF) / 255.0F; float h1 = 1.0F; float r = h1 * h2, g = h1 * h3, b = h1 * h4; GL11.glColor3f(r + getR(), g + getG(), b + getB()); }
/*      */   public static void glColor3f(int c, float a) { float h2 = (c >> 16 & 0xFF) / 255.0F; float h3 = (c >> 8 & 0xFF) / 255.0F; float h4 = (c & 0xFF) / 255.0F; float h1 = 1.0F; if (JRMCoreH.JYC() && a > (JRMCoreHJYC.JYCgetConfigpls() / 2)) { float lifespan = JRMCoreHJYC.JYCgetConfigpls() * 0.25F; float age = a - JRMCoreHJYC.JYCgetConfigpls() * 0.5F; float grey = 0.8627451F; float percentComplete = age / lifespan; percentComplete = (percentComplete > 1.0F) ? 1.0F : percentComplete; float percentGone = 1.0F - percentComplete; float red = h2 * percentGone + grey * percentComplete; float green = h3 * percentGone + grey * percentComplete; float blue = h4 * percentGone + grey * percentComplete; h2 = red; h3 = green; h4 = blue; }  float r = h1 * h2, g = h1 * h3, b = h1 * h4; GL11.glColor3f(r + getR(), g + getG(), b + getB()); }
/*      */   protected void func_77029_c(AbstractClientPlayer p_77029_1_, float p_77029_2_) { RenderPlayerEvent.Specials.Pre event = new RenderPlayerEvent.Specials.Pre((EntityPlayer)p_77029_1_, this, p_77029_2_); if (MinecraftForge.EVENT_BUS.post((Event)event)) return;  GL11.glColor3f(1.0F + getR(), 1.0F + getG(), 1.0F + getB()); func_85093_e((EntityLivingBase)p_77029_1_, p_77029_2_); ItemStack itemstack = p_77029_1_.field_71071_by.func_70440_f(3); if (itemstack != null && event.renderHelmet) { GL11.glPushMatrix(); this.modelMain.field_78116_c.func_78794_c(0.0625F); if (itemstack.func_77973_b() instanceof net.minecraft.item.ItemBlock) { IItemRenderer customRenderer = MinecraftForgeClient.getItemRenderer(itemstack, IItemRenderer.ItemRenderType.EQUIPPED); boolean is3D = (customRenderer != null && customRenderer.shouldUseRenderHelper(IItemRenderer.ItemRenderType.EQUIPPED, itemstack, IItemRenderer.ItemRendererHelper.BLOCK_3D)); if (is3D || RenderBlocks.func_147739_a(Block.func_149634_a(itemstack.func_77973_b()).func_149645_b())) { float f1 = 0.625F; GL11.glTranslatef(0.0F, -0.25F, 0.0F); GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F); GL11.glScalef(f1, -f1, -f1); }  this.field_76990_c.field_78721_f.func_78443_a((EntityLivingBase)p_77029_1_, itemstack, 0); } else if (itemstack.func_77973_b() == Items.field_151144_bL) { float f1 = 1.0625F; GL11.glScalef(f1, -f1, -f1); GameProfile gameprofile = null; if (itemstack.func_77942_o()) { NBTTagCompound nbttagcompound = itemstack.func_77978_p(); if (nbttagcompound.func_150297_b("SkullOwner", 10)) { gameprofile = NBTUtil.func_152459_a(nbttagcompound.func_74775_l("SkullOwner")); } else if (nbttagcompound.func_150297_b("SkullOwner", 8) && !StringUtils.func_151246_b(nbttagcompound.func_74779_i("SkullOwner"))) { gameprofile = new GameProfile((UUID)null, nbttagcompound.func_74779_i("SkullOwner")); }  }  TileEntitySkullRenderer.field_147536_b.func_152674_a(-0.5F, 0.0F, -0.5F, 1, 180.0F, itemstack.func_77960_j(), gameprofile); }  GL11.glPopMatrix(); }  renderEquippedItemsJBRA(p_77029_1_, p_77029_2_); if (p_77029_1_.func_70005_c_().equals("deadmau5") && p_77029_1_.func_152123_o()) { func_110776_a(p_77029_1_.func_110306_p()); for (int j = 0; j < 2; j++) { float f9 = p_77029_1_.field_70126_B + (p_77029_1_.field_70177_z - p_77029_1_.field_70126_B) * p_77029_2_ - p_77029_1_.field_70760_ar + (p_77029_1_.field_70761_aq - p_77029_1_.field_70760_ar) * p_77029_2_; float f10 = p_77029_1_.field_70127_C + (p_77029_1_.field_70125_A - p_77029_1_.field_70127_C) * p_77029_2_; GL11.glPushMatrix(); GL11.glRotatef(f9, 0.0F, 1.0F, 0.0F); GL11.glRotatef(f10, 1.0F, 0.0F, 0.0F); GL11.glTranslatef(0.375F * (j * 2 - 1), 0.0F, 0.0F); GL11.glTranslatef(0.0F, -0.375F, 0.0F); GL11.glRotatef(-f10, 1.0F, 0.0F, 0.0F); GL11.glRotatef(-f9, 0.0F, 1.0F, 0.0F); float f2 = 1.3333334F; GL11.glScalef(f2, f2, f2); this.field_77109_a.func_78110_b(0.0625F); GL11.glPopMatrix(); }  }  boolean flag = p_77029_1_.func_152122_n(); flag = (event.renderCape && flag); if (flag && !p_77029_1_.func_82150_aj() && !p_77029_1_.func_82238_cc()) { func_110776_a(p_77029_1_.func_110303_q()); GL11.glPushMatrix(); GL11.glTranslatef(0.0F, 0.0F, 0.125F); double d3 = p_77029_1_.field_71091_bM + (p_77029_1_.field_71094_bP - p_77029_1_.field_71091_bM) * p_77029_2_ - p_77029_1_.field_70169_q + (p_77029_1_.field_70165_t - p_77029_1_.field_70169_q) * p_77029_2_; double d4 = p_77029_1_.field_71096_bN + (p_77029_1_.field_71095_bQ - p_77029_1_.field_71096_bN) * p_77029_2_ - p_77029_1_.field_70167_r + (p_77029_1_.field_70163_u - p_77029_1_.field_70167_r) * p_77029_2_; double d0 = p_77029_1_.field_71097_bO + (p_77029_1_.field_71085_bR - p_77029_1_.field_71097_bO) * p_77029_2_ - p_77029_1_.field_70166_s + (p_77029_1_.field_70161_v - p_77029_1_.field_70166_s) * p_77029_2_; float f4 = p_77029_1_.field_70760_ar + (p_77029_1_.field_70761_aq - p_77029_1_.field_70760_ar) * p_77029_2_; double d1 = MathHelper.func_76126_a(f4 * 3.1415927F / 180.0F); double d2 = -MathHelper.func_76134_b(f4 * 3.1415927F / 180.0F); float f5 = (float)d4 * 10.0F; if (f5 < -6.0F) f5 = -6.0F;  if (f5 > 32.0F) f5 = 32.0F;  float f6 = (float)(d3 * d1 + d0 * d2) * 100.0F; float f7 = (float)(d3 * d2 - d0 * d1) * 100.0F; if (f6 < 0.0F) f6 = 0.0F;  float f8 = p_77029_1_.field_71107_bF + (p_77029_1_.field_71109_bG - p_77029_1_.field_71107_bF) * p_77029_2_; f5 += MathHelper.func_76126_a((p_77029_1_.field_70141_P + (p_77029_1_.field_70140_Q - p_77029_1_.field_70141_P) * p_77029_2_) * 6.0F) * 32.0F * f8; if (p_77029_1_.func_70093_af())
/*      */         f5 += 25.0F;  GL11.glRotatef(6.0F + f6 / 2.0F + f5, 1.0F, 0.0F, 0.0F); GL11.glRotatef(f7 / 2.0F, 0.0F, 0.0F, 1.0F); GL11.glRotatef(-f7 / 2.0F, 0.0F, 1.0F, 0.0F); GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F); this.modelMain.func_78111_c(0.0625F); GL11.glPopMatrix(); }  ItemStack itemstack1 = p_77029_1_.field_71071_by.func_70448_g(); boolean m = (itemstack1 != null && event.renderItem); String s = JRMCoreH.data(p_77029_1_.func_70005_c_(), 1, "0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0").split(";")[16]; if (m) { GL11.glPushMatrix(); float fm = 0.0F; if (gen <= 1) { GL11.glScalef(1.0F / childScl, 1.0F / childScl, 1.0F / childScl); GL11.glTranslatef(0.0F, (childScl - 1.0F) * 1.5F, 0.0F); this.modelMain.RA.func_78794_c(0.0625F); fm = 0.0F; }  if (gen >= 2) { GL11.glScalef(1.0F / childScl * ((gen <= 1) ? 1.0F : 0.7F), 1.0F / childScl, 1.0F / childScl * ((gen <= 1) ? 1.0F : 0.7F)); GL11.glTranslatef(0.0F, (childScl - 1.0F) * 1.5F, 0.0F); this.modelMain.RA.func_78794_c(0.0625F); fm = 0.1F; }  float f1 = childScl; GL11.glTranslatef(-0.0625F, 0.4375F, 0.0625F); if (p_77029_1_.field_71104_cf != null)
/*      */         itemstack1 = new ItemStack(Items.field_151055_y);  EnumAction enumaction = null; if (p_77029_1_.func_71052_bv() > 0)
/*      */         enumaction = itemstack1.func_77975_n();  IItemRenderer customRenderer = MinecraftForgeClient.getItemRenderer(itemstack1, IItemRenderer.ItemRenderType.EQUIPPED); boolean is3D = (customRenderer != null && customRenderer.shouldUseRenderHelper(IItemRenderer.ItemRenderType.EQUIPPED, itemstack1, IItemRenderer.ItemRendererHelper.BLOCK_3D)); if (is3D || (itemstack1.func_77973_b() instanceof net.minecraft.item.ItemBlock && RenderBlocks.func_147739_a(Block.func_149634_a(itemstack1.func_77973_b()).func_149645_b()))) { float f2 = 0.5F; GL11.glTranslatef(0.0F, 0.1875F, -0.3125F); f2 *= 0.75F; GL11.glRotatef(20.0F, 1.0F, 0.0F, 0.0F); GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F); GL11.glScalef(-f2, -f2, f2); } else if (itemstack1.func_77973_b() == Items.field_151031_f) { float f2 = 0.625F; GL11.glTranslatef(0.0F, 0.125F, 0.3125F); GL11.glRotatef(-20.0F, 0.0F, 1.0F, 0.0F); GL11.glScalef(f2, -f2, f2); GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F); GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F); } else if (itemstack1.func_77973_b().func_77662_d()) { float f2 = 0.625F; if (itemstack1.func_77973_b().func_77629_n_()) { GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F); GL11.glTranslatef(0.0F, -0.125F, 0.0F); }  if (p_77029_1_.func_71052_bv() > 0 && enumaction == EnumAction.block) { GL11.glTranslatef(0.05F, 0.0F, -0.1F); GL11.glRotatef(-50.0F, 0.0F, 1.0F, 0.0F); GL11.glRotatef(-10.0F, 1.0F, 0.0F, 0.0F); GL11.glRotatef(-60.0F, 0.0F, 0.0F, 1.0F); }  GL11.glTranslatef(0.0F, 0.1875F, 0.0F); GL11.glScalef(f2, -f2, f2); GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F); GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F); } else { float f2 = 0.375F; GL11.glTranslatef(0.25F, 0.1875F, -0.1875F); GL11.glScalef(f2, f2, f2); GL11.glRotatef(60.0F, 0.0F, 0.0F, 1.0F); GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F); GL11.glRotatef(20.0F, 0.0F, 0.0F, 1.0F); }  if (itemstack1.func_77973_b().func_77623_v()) { for (int k = 0; k < itemstack1.func_77973_b().getRenderPasses(itemstack1.func_77960_j()); k++) { int i = itemstack1.func_77973_b().func_82790_a(itemstack1, k); float f12 = (i >> 16 & 0xFF) / 255.0F; float f3 = (i >> 8 & 0xFF) / 255.0F; float f4 = (i & 0xFF) / 255.0F; GL11.glColor4f(f12, f3, f4, 1.0F); this.field_76990_c.field_78721_f.func_78443_a((EntityLivingBase)p_77029_1_, itemstack1, k); }  } else { int k = itemstack1.func_77973_b().func_82790_a(itemstack1, 0); float f11 = (k >> 16 & 0xFF) / 255.0F; float f12 = (k >> 8 & 0xFF) / 255.0F; float f3 = (k & 0xFF) / 255.0F; GL11.glColor4f(f11, f12, f3, 1.0F); this.field_76990_c.field_78721_f.func_78443_a((EntityLivingBase)p_77029_1_, itemstack1, 0); }  GL11.glPopMatrix(); }  MinecraftForge.EVENT_BUS.post((Event)new RenderPlayerEvent.Specials.Post((EntityPlayer)p_77029_1_, this, p_77029_2_)); }
/*      */   private void func_aam(ModelRenderer ra, ModelRenderer la, int id, boolean fp) { if (id == 0 || id == 6) { if ((id == 0) ? JGConfigClientSettings.CLIENT_DA18 : JGConfigClientSettings.instantTransmissionFirstPerson) { GL11.glPushMatrix(); GL11.glEnable(3042); GL11.glBlendFunc(770, 771); GL11.glAlphaFunc(516, 0.003921569F); GL11.glDepthMask(false); GL11.glTranslatef(-0.5F, -0.1F, -0.1F); GL11.glRotatef(40.0F, 0.0F, 0.0F, -1.0F); GL11.glRotatef(80.0F, -1.0F, 0.0F, 0.0F); GL11.glRotatef(((id == 0) ? -20 : 30), 0.0F, 0.0F, 1.0F); }  ra.func_78785_a(0.0625F); if ((id == 0) ? JGConfigClientSettings.CLIENT_DA18 : JGConfigClientSettings.instantTransmissionFirstPerson)
/*      */         GL11.glPopMatrix();  } else if (id == 2 || id == 3) { GL11.glPushMatrix(); GL11.glTranslatef(-0.2F, 0.0F, -0.1F); GL11.glRotatef(10.0F, -1.0F, 0.0F, 0.0F); GL11.glRotatef(20.0F, 0.0F, 0.0F, -1.0F); ra.func_78785_a(0.0625F); GL11.glPopMatrix(); } else if (id == 4 || id == 5) { GL11.glPushMatrix(); GL11.glTranslatef(-0.2F, 0.4F, -0.1F); GL11.glRotatef(10.0F, -1.0F, 0.0F, 0.0F); GL11.glRotatef(20.0F, 0.0F, 0.0F, -1.0F); GL11.glRotatef(40.0F, 0.0F, 0.0F, 1.0F); ra.func_78785_a(0.0625F); GL11.glPopMatrix(); }  }
/*      */   private void func_aam2(ModelRenderer ra, ModelRenderer la, int id, boolean fp) { if (id == 0) { if (JGConfigClientSettings.CLIENT_DA18) { GL11.glPushMatrix(); GL11.glTranslatef(-0.2F, -0.4F, -0.8F); GL11.glRotatef(50.0F, 1.0F, 0.0F, 1.0F); GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F); GL11.glRotatef(20.0F, 0.0F, 0.0F, 1.0F); la.func_78785_a(0.0625F); GL11.glPopMatrix(); }  } else if (id == 3) { GL11.glPushMatrix(); GL11.glTranslatef(0.1F, -0.2F, -0.5F); GL11.glTranslatef(-0.2F, 0.0F, -0.1F); GL11.glRotatef(10.0F, -1.0F, 0.0F, 0.0F); GL11.glRotatef(20.0F, 0.0F, 0.0F, -1.0F); GL11.glRotatef(115.0F, 0.0F, 1.0F, 0.0F); la.func_78785_a(0.0625F); GL11.glPopMatrix(); } else if (id == 5) { GL11.glPushMatrix(); GL11.glTranslatef(-0.2F, -0.4F, -0.8F); GL11.glTranslatef(-0.4F, 0.1F, -0.1F); GL11.glRotatef(42.0F, -1.0F, 0.0F, 0.0F); GL11.glRotatef(10.0F, 0.0F, 0.0F, 1.0F); GL11.glRotatef(115.0F, 0.0F, 1.0F, 0.0F); GL11.glTranslatef(-0.6F, 0.08F, 0.3F); la.func_78785_a(0.0625F); GL11.glPopMatrix(); }  }
/*      */   private void func_aam(int id, boolean s, boolean fp) { if (s) { if (id == 0 || id == 6) { if ((id == 0) ? JGConfigClientSettings.CLIENT_DA18 : JGConfigClientSettings.instantTransmissionFirstPerson) { GL11.glEnable(3042); GL11.glBlendFunc(770, 771); GL11.glAlphaFunc(516, 0.003921569F); GL11.glDepthMask(false); GL11.glTranslatef(-0.5F, -0.1F, -0.1F); GL11.glRotatef(40.0F, 0.0F, 0.0F, -1.0F); GL11.glRotatef(80.0F, -1.0F, 0.0F, 0.0F); GL11.glRotatef(((id == 0) ? -20 : 30), 0.0F, 0.0F, 1.0F); }  } else if (id == 1) { GL11.glTranslatef(-0.2F, -0.4F, -0.8F); GL11.glRotatef(50.0F, 1.0F, 0.0F, 1.0F); GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F); GL11.glRotatef(20.0F, 0.0F, 0.0F, 1.0F); } else if (id == 2 || id == 3) { GL11.glTranslatef(-0.2F, 0.0F, -0.1F); GL11.glRotatef(10.0F, -1.0F, 0.0F, 0.0F); GL11.glRotatef(20.0F, 0.0F, 0.0F, -1.0F); } else if (id == 4 || id == 5) { GL11.glTranslatef(-0.2F, 0.4F, -0.1F); GL11.glRotatef(10.0F, -1.0F, 0.0F, 0.0F); GL11.glRotatef(20.0F, 0.0F, 0.0F, -1.0F); GL11.glRotatef(40.0F, 0.0F, 0.0F, 1.0F); }  } else if (id == 0) { if (JGConfigClientSettings.CLIENT_DA18) { GL11.glTranslatef(-0.2F, -0.4F, -0.8F); GL11.glRotatef(50.0F, 1.0F, 0.0F, 1.0F); GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F); GL11.glRotatef(20.0F, 0.0F, 0.0F, 1.0F); }  } else if (id == 3) { GL11.glTranslatef(0.1F, -0.2F, -0.5F); GL11.glTranslatef(-0.2F, 0.0F, -0.1F); GL11.glRotatef(10.0F, -1.0F, 0.0F, 0.0F); GL11.glRotatef(20.0F, 0.0F, 0.0F, -1.0F); GL11.glRotatef(115.0F, 0.0F, 1.0F, 0.0F); } else if (id == 5) { GL11.glTranslatef(-0.2F, -0.4F, -0.8F); GL11.glTranslatef(-0.4F, 0.1F, -0.1F); GL11.glRotatef(42.0F, -1.0F, 0.0F, 0.0F); GL11.glRotatef(10.0F, 0.0F, 0.0F, 1.0F); GL11.glRotatef(115.0F, 0.0F, 1.0F, 0.0F); GL11.glTranslatef(-0.6F, 0.08F, 0.3F); }  }
/*      */   public void chakra(Entity e, int id) { GL11.glPushMatrix(); GL11.glDepthMask(true); GL11.glEnable(2977); GL11.glEnable(3042); GL11.glBlendFunc(770, 771); GL11.glDisable(2896); int height = 112, width = 32, u = 0, v = 0; float x2 = -66.0F, y2 = -16.0F, z2 = -16.0F; GL11.glTranslatef(0.29F, 0.73F, 0.0F); int k1 = 0; float sc = 0.0F; sc = id; if (sc < 0.0F) { sc = 0.0F; } else { sc /= 800.0F; }  float par = 0.015F; if (sc > par)
/*      */       sc = par;  GL11.glScalef(sc, sc, sc); float alpha = 1.0F; GL11.glColor4f(0.5F, 0.7F, 1.0F, 1.3F - alpha); ResourceLocation tx = new ResourceLocation("jinryuunarutoc:chakra_trail.png"); JRMCoreClient.mc.func_110434_K().func_110577_a(tx); GL11.glRotated(-20.0D, 1.0D, 0.0D, 0.0D); int i_max = 4; GL11.glRotated((e.field_70173_aa * 15.0F), 0.0D, 0.0D, 1.0D); GL11.glRotated(30.0D, 1.0D, 0.0D, 0.0D); for (int i = 0; i < i_max; i++) { GL11.glRotated((i * 360 / i_max), 0.0D, 0.0D, 1.0D); float f = 0.00390625F; float f1 = 0.00390625F; Tessellator tessellator = Tessellator.field_78398_a; tessellator.func_78382_b(); tessellator.func_78374_a(x2, (y2 + 0.0F), z2, ((u + 0) * f), ((v + 0) * f1)); tessellator.func_78374_a(x2, (y2 + height), z2, ((u + 0) * f), ((v + height) * f1)); tessellator.func_78374_a((x2 + width), (y2 + height), z2, ((u + width) * f), ((v + height) * f1)); tessellator.func_78374_a((x2 + width), (y2 + 0.0F), z2, ((u + width) * f), ((v + 0) * f1)); tessellator.func_78381_a(); }  GL11.glDisable(3042); GL11.glDisable(2977); GL11.glDisable(2896); GL11.glPopMatrix(); }
/* 2055 */   public static void kss(Entity e, boolean b, int id, int kf, int ki) { GL11.glPushMatrix();
/*      */     
/* 2057 */     GL11.glEnable(3042);
/* 2058 */     GL11.glDisable(2896);
/* 2059 */     GL11.glBlendFunc(770, 771);
/* 2060 */     GL11.glAlphaFunc(516, 0.003921569F);
/* 2061 */     GL11.glDepthMask(true);
/* 2062 */     float scale = 1.0F;
/* 2063 */     GL11.glScalef(scale, scale, scale);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2068 */     float red = 1.0F, green = 1.0F, blue = 1.0F;
/* 2069 */     String seee = JRMCoreH.StusEfctsClient((EntityPlayer)e);
/*      */     
/* 2071 */     String[] dat5 = JRMCoreH.data(e.func_70005_c_(), 5, "50;0").split(";");
/* 2072 */     int aaa = Integer.parseInt(dat5[0]);
/* 2073 */     int ccc = Integer.parseInt(dat5[1]);
/* 2074 */     String[] a = JRMCoreH.data(e.func_70005_c_(), 1, "0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0").split(";");
/* 2075 */     int rrr = Integer.parseInt(a[0]);
/* 2076 */     String[] st = JRMCoreH.data(e.func_70005_c_(), 2, "0;0").split(";");
/* 2077 */     int sss = Integer.parseInt(st[0]);
/*      */     
/* 2079 */     ccc = (ccc > 0) ? ccc : JRMCoreH.Algnmnt_rc(aaa);
/*      */ 
/*      */     
/* 2082 */     boolean vvv = JRMCoreH.StusEfcts(17, seee);
/* 2083 */     boolean lsaaa = JRMCoreH.lgndb(seee, rrr, sss);
/* 2084 */     boolean ultraInstinctOn = JRMCoreH.StusEfcts(19, seee);
/* 2085 */     boolean GodOfDestructionOn = JRMCoreH.StusEfcts(20, seee);
/* 2086 */     int color = JRMCoreHDBC.getPlayerColor2(2, ccc, 1, rrr, sss, vvv, lsaaa, ultraInstinctOn, GodOfDestructionOn);
/*      */     
/* 2088 */     float alfa = 0.6F, h1 = 1.0F;
/* 2089 */     float h2 = (color >> 16 & 0xFF) / 255.0F;
/* 2090 */     float h3 = (color >> 8 & 0xFF) / 255.0F;
/* 2091 */     float h4 = (color & 0xFF) / 255.0F;
/*      */     
/* 2093 */     red = h1 * h2; green = h1 * h3; blue = h1 * h4;
/* 2094 */     if (red > 1.0F) red = 1.0F; 
/* 2095 */     if (green > 1.0F) green = 1.0F; 
/* 2096 */     if (blue > 1.0F) blue = 1.0F;
/*      */ 
/*      */     
/* 2099 */     GL11.glTranslatef(-0.06F, -0.05F, 0.0F);
/* 2100 */     JRMCoreClient.mc.field_71446_o.func_110577_a(new ResourceLocation(JRMCoreH.tjjrmc + ":allw.png"));
/*      */ 
/*      */ 
/*      */     
/* 2104 */     if (gen == 2) {
/* 2105 */       GL11.glRotatef(7.0F, 0.0F, 0.0F, 1.0F);
/*      */     }
/* 2107 */     if (id == 0) {
/* 2108 */       float scl = kf * 0.02F + ki * 0.02F;
/* 2109 */       GL11.glTranslatef(0.0F, -scl * 0.7F, 0.0F);
/* 2110 */       GL11.glScalef(1.0F, 1.0F + scl, 1.0F);
/* 2111 */       float ex = e.field_70173_aa;
/* 2112 */       float r4 = (MathHelper.func_76134_b(ex / 2.0F) / 3.0F - 0.2F) / 8.0F;
/* 2113 */       GL11.glTranslatef(0.0F, -r4, 0.0F);
/* 2114 */       GL11.glColor4f(red, green, blue, alfa);
/* 2115 */       GL11.glRotatef(ex * 25.0F, 0.0F, 1.0F, 0.0F);
/* 2116 */       JRMCoreHJBRA.model2.render(0.0625F, id);
/*      */       
/* 2118 */       GL11.glTranslatef(0.0F, -0.12F, 0.0F);
/* 2119 */       GL11.glScalef(scale * 1.3F, scale * 1.18F, scale * 1.3F);
/* 2120 */       GL11.glColor4f(red * 0.8F, green * 0.8F, blue * 0.8F, alfa * 0.8F);
/* 2121 */       JRMCoreHJBRA.model2.render(0.0625F, id);
/*      */     } 
/* 2123 */     if (id == 1) {
/*      */       
/* 2125 */       GL11.glTranslatef(0.0F, 0.6F, 0.0F);
/* 2126 */       GL11.glColor4f(red, green, blue, alfa);
/*      */       
/* 2128 */       GL11.glRotatef(-3.0F, 0.0F, 1.0F, 0.0F);
/* 2129 */       GL11.glRotatef(5.0F, 0.0F, 0.0F, 1.0F);
/*      */       
/* 2131 */       GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
/* 2132 */       GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
/* 2133 */       JRMCoreHJBRA.model2.render(0.0625F, id);
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2139 */     GL11.glEnable(2896);
/* 2140 */     GL11.glDepthMask(true);
/* 2141 */     GL11.glPopMatrix(); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void ow(boolean b) {
/* 2149 */     GL11.glPushMatrix();
/*      */     
/* 2151 */     float scale = 1.0F;
/* 2152 */     GL11.glScalef(scale, scale, scale);
/* 2153 */     float f1 = 0.0020714286F;
/* 2154 */     GL11.glScalef(f1, f1, f1);
/* 2155 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*      */     
/* 2157 */     if (b) {
/* 2158 */       JRMCoreClient.mc.func_110434_K().func_110577_a(new ResourceLocation("jinryuujyearsc:watch/hw0.png"));
/* 2159 */       GL11.glNormal3f(0.0F, 0.0F, -1.0F);
/*      */     } else {
/* 2161 */       JRMCoreClient.mc.field_71446_o.func_110577_a(new ResourceLocation("jinryuujyearsc:watch/hw0.png"));
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2168 */     if (gen == 2) {
/* 2169 */       GL11.glRotatef(7.0F, 0.0F, 0.0F, 1.0F);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/* 2174 */     GL11.glTranslatef(-33.0F, 0.0F, 0.0F);
/*      */     
/* 2176 */     GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
/*      */     
/* 2178 */     GL11.glTranslatef(32.0F, 0.0F, 0.0F);
/*      */ 
/*      */ 
/*      */     
/* 2182 */     GL11.glTranslatef(0.0F, 150.0F, 0.0F);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2188 */     JRMCoreHC.dtm(-96.0F, 0.0F, 0, 0, 128.0F, 128.0F, -64.0F);
/*      */     
/* 2190 */     GL11.glRotatef(-90.0F, 0.0F, 1.0F, 0.0F);
/*      */     
/* 2192 */     JRMCoreHC.dtm(-64.0F, 0.0F, 128, 0, 128.0F, 128.0F, -32.0F);
/* 2193 */     GL11.glRotatef(-90.0F, 0.0F, 1.0F, 0.0F);
/* 2194 */     JRMCoreHC.dtm(-32.0F, 0.0F, 128, 0, 128.0F, 128.0F, -64.0F);
/* 2195 */     GL11.glRotatef(-90.0F, 0.0F, 1.0F, 0.0F);
/* 2196 */     JRMCoreHC.dtm(-64.0F, 0.0F, 128, 0, 128.0F, 128.0F, -96.0F);
/* 2197 */     GL11.glRotatef(-90.0F, 0.0F, 1.0F, 0.0F);
/*      */ 
/*      */     
/* 2200 */     GL11.glTranslatef(-104.0F, -70.0F, -65.0F);
/*      */     
/* 2202 */     GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
/* 2203 */     scale = 2.0F;
/* 2204 */     float scaley = 4.0F;
/* 2205 */     GL11.glScalef(scale, scaley, scale);
/*      */ 
/*      */     
/* 2208 */     int s = (int)(JRMCoreClient.mc.field_71439_g.field_70170_p.func_72820_D() % 24000L / 1000L) + 6;
/* 2209 */     int w = (s > 24) ? (s - 24) : s;
/* 2210 */     w = (w == 24) ? 0 : w;
/* 2211 */     int m = (int)(JRMCoreClient.mc.field_71439_g.field_70170_p.func_72820_D() % 24000L - ((int)(JRMCoreClient.mc.field_71439_g.field_70170_p.func_72820_D() % 24000L / 1000L) * 1000));
/* 2212 */     float mi = m / 16.67F;
/* 2213 */     int min = (int)mi;
/* 2214 */     String var34 = ((w < 10) ? ("0" + w) : (String)Integer.valueOf(w)) + ":" + ((min < 10) ? ("0" + min) : (String)Integer.valueOf(min));
/*      */ 
/*      */     
/* 2217 */     FontRenderer fontRenderer = JRMCoreClient.mc.field_71466_p;
/*      */     
/* 2219 */     String n = "" + var34; int nw = fontRenderer.func_78256_a(n);
/* 2220 */     fontRenderer.func_78276_b(n, (int)(-96.0F / scale), -((int)(150.0F / scaley)), 0);
/*      */     
/* 2222 */     GL11.glPopMatrix();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void func_77041_b(AbstractClientPlayer p, float p_77041_2_) {
/* 2231 */     float f1 = 0.9375F;
/*      */     
/* 2233 */     float f2 = 1.0F;
/* 2234 */     float f3 = 1.0F;
/* 2235 */     boolean noC = !JRMCoreH.DBC();
/* 2236 */     if (gen <= 1) f1 = 0.73F + (noC ? 0.2F : 0.0F); 
/* 2237 */     if (gen >= 2) f1 = 0.7F + (noC ? 0.2F : 0.0F);
/*      */ 
/*      */ 
/*      */     
/* 2241 */     if (JRMCoreH.plyrs != null && JRMCoreH.plyrs.length > 0 && !p.func_82150_aj() && JRMCoreH.dnn(2) && JRMCoreH.dnn(1) && JRMCoreH.dnn(3) && JRMCoreH.dnn(14) && JRMCoreH.dnn(10)) {
/* 2242 */       for (int pl = 0; pl < JRMCoreH.plyrs.length; pl++) {
/* 2243 */         if (JRMCoreH.plyrs[pl].equals(p.func_70005_c_()) && JRMCoreH.dat14.length >= JRMCoreH.plyrs.length) {
/*      */           
/* 2245 */           if (JRMCoreH.StusEfctsClient(11, (EntityPlayer)p)) {
/* 2246 */             GL11.glScalef(0.01F, 0.01F, 0.01F);
/*      */             return;
/*      */           } 
/* 2249 */           String[] s = JRMCoreH.data1[pl].split(";");
/* 2250 */           String[] s2 = JRMCoreH.data2[pl].split(";");
/* 2251 */           String s3 = JRMCoreH.data3[pl];
/* 2252 */           String[] s14 = JRMCoreH.dat14[pl].split(",");
/* 2253 */           int[] PlyrAttrbts = new int[JRMCoreH.PlyrAttrbts.length];
/* 2254 */           float f1r = f1;
/* 2255 */           for (int i = 0; i < PlyrAttrbts.length; ) { PlyrAttrbts[i] = Integer.parseInt(s14[i]); i++; }
/*      */           
/* 2257 */           if (JRMCoreH.DBC()) {
/*      */             
/* 2259 */             f1 += JRMCoreHDBC.DBCsizeBasedOnCns2(PlyrAttrbts);
/* 2260 */             int pwr = Integer.parseInt(s[2]);
/* 2261 */             if (!JRMCoreH.isPowerTypeChakra(pwr)) {
/*      */               
/* 2263 */               int race = Integer.parseInt(s[0]);
/* 2264 */               boolean divine = (race == 3) ? JRMCoreH.StusEfctsClient(17, pl) : false;
/* 2265 */               f2 = JRMCoreHDBC.DBCsizeBasedOnRace(b(s[0]), b(s2[0]), divine);
/* 2266 */               f3 = JRMCoreHDBC.DBCsizeBasedOnRace2(b(s[0]), b(s2[0]), divine);
/*      */             } 
/*      */             
/* 2269 */             int cr = Integer.parseInt(JRMCoreH.dat10[pl].split(";")[0]);
/* 2270 */             if (JRMCoreH.rSai(b(s[0])) && (b(s2[0]) == 7 || b(s2[0]) == 8)) { cr = 50; f1 = f1r; }
/*      */ 
/*      */ 
/*      */             
/* 2274 */             float f3a = (f3 - 1.0F) * cr * 0.02F + 1.0F;
/* 2275 */             f3 = (f3a > f3) ? f3 : ((f3 > 1.0F) ? f3a : f3);
/* 2276 */             float f2a = (f2 - 1.0F) * cr * 0.02F + 1.0F;
/* 2277 */             f2 = (f2 > 1.0F) ? f2a : f2;
/* 2278 */             float f1a1 = (f1 - f1r) * ((cr <= 50) ? 0.25F : 0.5F);
/* 2279 */             float f1ac = f1a1 * cr * 0.02F;
/* 2280 */             float f1ao = f1 - f1r - f1a1 + f1ac + f1r;
/* 2281 */             f1 = f1ao;
/*      */           } 
/*      */           
/* 2284 */           if (JRMCoreH.PlyrPwr((EntityPlayer)p) == 1) {
/*      */             
/* 2286 */             String[] d4 = JRMCoreH.data(pl, 4, "0;0;0").split(";");
/* 2287 */             boolean oks = (Integer.parseInt(d4[2]) == 1);
/* 2288 */             boolean w = (JRMCoreH.StusEfctsClient(7, (EntityPlayer)p) || (JRMCoreH.StusEfctsClient(9, (EntityPlayer)p) && s3.contains("1") && !JRMCoreH.StusEfctsClient(4, (EntityPlayer)p)));
/*      */             
/* 2290 */             if (oks) {
/*      */ 
/*      */ 
/*      */ 
/*      */               
/* 2295 */               p.field_70125_A = 0.0F;
/* 2296 */               p.field_70177_z = 0.0F;
/*      */ 
/*      */               
/* 2299 */               GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
/* 2300 */               GL11.glTranslatef(0.0F, 0.8F, -0.1F);
/* 2301 */               ModelBipedDBC.y = 3;
/*      */               break;
/*      */             } 
/* 2304 */             if (p != null && p instanceof EntityPlayer && ExtendedPlayer.get((EntityPlayer)p).getUIAnim() != 0) {
/*      */               
/* 2306 */               float diff = 0.3F;
/* 2307 */               int animation_id = ExtendedPlayer.get((EntityPlayer)p).getUIAnimID();
/*      */               
/* 2309 */               if (animation_id == 0) {
/*      */                 
/* 2311 */                 GL11.glRotatef(-80.0F, 0.0F, 1.0F, 0.0F);
/* 2312 */                 GL11.glTranslatef(0.0F, 0.0F, 0.3F);
/*      */               }
/* 2314 */               else if (animation_id == 1) {
/*      */                 
/* 2316 */                 GL11.glRotatef(80.0F, 0.0F, 1.0F, 0.0F);
/* 2317 */                 GL11.glTranslatef(0.0F, 0.0F, 0.3F);
/*      */               }
/* 2319 */               else if (animation_id == 2) {
/*      */                 
/* 2321 */                 GL11.glRotatef(-40.0F, 0.0F, 1.0F, 0.0F);
/* 2322 */                 GL11.glTranslatef(0.0F, 0.0F, 0.3F);
/*      */               }
/* 2324 */               else if (animation_id == 3) {
/*      */                 
/* 2326 */                 GL11.glRotatef(40.0F, 0.0F, 1.0F, 0.0F);
/* 2327 */                 GL11.glTranslatef(0.0F, 0.0F, 0.3F);
/*      */               } 
/* 2329 */               ModelBipedDBC.y = 4 + animation_id;
/* 2330 */               ModelBipedDBC.animation = ExtendedPlayer.get((EntityPlayer)p).getUIAnim(); break;
/*      */             } 
/* 2332 */             if ((w || s3.contains("1")) && !p.field_70122_E) {
/*      */               
/* 2334 */               GL11.glTranslatef(0.0F, -1.5F, 0.0F);
/* 2335 */               if (w) {
/*      */                 
/* 2337 */                 GL11.glRotatef(p.field_70125_A + 90.0F, 1.0F, 0.0F, 0.0F);
/*      */               }
/*      */               else {
/*      */                 
/* 2341 */                 GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
/*      */               } 
/* 2343 */               ModelBipedDBC.y = 2;
/*      */               
/*      */               break;
/*      */             } 
/* 2347 */             ModelBipedDBC.y = 1;
/*      */           } 
/*      */ 
/*      */           
/*      */           break;
/*      */         } 
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/* 2357 */     GL11.glScalef(f1 * f2 * f3, f1 * f3, f1 * f2 * f3);
/*      */   }
/*      */ 
/*      */   
/*      */   protected void func_96449_a(AbstractClientPlayer p_96449_1_, double p_96449_2_, double p_96449_4_, double p_96449_6_, String p_96449_8_, float p_96449_9_, double p_96449_10_) {
/* 2362 */     if (p_96449_10_ < 100.0D) {
/*      */       
/* 2364 */       Scoreboard scoreboard = p_96449_1_.func_96123_co();
/* 2365 */       ScoreObjective scoreobjective = scoreboard.func_96539_a(2);
/*      */       
/* 2367 */       if (scoreobjective != null) {
/*      */         
/* 2369 */         Score score = scoreboard.func_96529_a(p_96449_1_.func_70005_c_(), scoreobjective);
/*      */         
/* 2371 */         if (p_96449_1_.func_70608_bn()) {
/*      */           
/* 2373 */           func_147906_a((Entity)p_96449_1_, score.func_96652_c() + " " + scoreobjective.func_96678_d(), p_96449_2_, p_96449_4_ - 1.5D, p_96449_6_, 64);
/*      */         }
/*      */         else {
/*      */           
/* 2377 */           func_147906_a((Entity)p_96449_1_, score.func_96652_c() + " " + scoreobjective.func_96678_d(), p_96449_2_, p_96449_4_, p_96449_6_, 64);
/*      */         } 
/*      */         
/* 2380 */         p_96449_4_ += ((func_76983_a()).field_78288_b * 1.15F * p_96449_9_);
/*      */       } 
/*      */     } 
/*      */     
/* 2384 */     super.func_96449_a(p_96449_1_, p_96449_2_, p_96449_4_, p_96449_6_, p_96449_8_, p_96449_9_, p_96449_10_);
/*      */   }
/*      */   
/* 2387 */   private static String dns = JRMCoreH.dns;
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_82441_a(EntityPlayer par1EntityPlayer) {
/* 2392 */     EntityClientPlayerMP acp = JBRAClient.mc.field_71439_g;
/* 2393 */     Object data = null;
/* 2394 */     if (JBRAH.JHDS()) {
/*      */       
/* 2396 */       Object temp = JBRAH.skinData((EntityPlayer)acp);
/* 2397 */       data = (temp != null) ? temp : null;
/*      */     } 
/* 2399 */     float f = 1.0F;
/*      */     
/* 2401 */     GL11.glColor3f(f + getR(), f + getG(), f + getB());
/* 2402 */     GL11.glPushMatrix();
/*      */ 
/*      */     
/* 2405 */     int tick = acp.field_70173_aa;
/* 2406 */     float swing = acp.func_70678_g(tick);
/* 2407 */     float swing2 = MathHelper.func_76126_a(swing * 3.1415927F);
/* 2408 */     float swing3 = MathHelper.func_76126_a(MathHelper.func_76129_c(swing) * 3.1415927F);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2413 */     this.modelMain.field_78095_p = 0.0F;
/* 2414 */     this.modelMain.func_78087_a(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, (Entity)par1EntityPlayer);
/*      */     
/* 2416 */     dns = JRMCoreH.dns;
/* 2417 */     if (dns.length() > 3) {
/*      */       
/* 2419 */       int State = JRMCoreH.State;
/* 2420 */       int race = JRMCoreH.dnsRace(dns);
/* 2421 */       boolean saiOozar = JRMCoreH.rSai(race) ? ((State == 7 || State == 8)) : false;
/* 2422 */       int gen = JRMCoreH.dnsGender(dns);
/* 2423 */       int haircol = JRMCoreH.dnsHairC(dns);
/* 2424 */       int hairback = JRMCoreH.dnsHairB(dns);
/*      */       
/* 2426 */       int breast = JRMCoreH.dnsBreast(dns);
/* 2427 */       int skintype = JRMCoreH.dnsSkinT(dns);
/*      */ 
/*      */       
/* 2430 */       boolean lg = JRMCoreH.lgndb(par1EntityPlayer, race, State);
/*      */ 
/*      */ 
/*      */       
/* 2434 */       boolean iau = (JRMCoreH.rc_arc(race) && State == 6);
/* 2435 */       String dnsau = JRMCoreH.data(16, "");
/* 2436 */       dnsau = dnsau.contains(";") ? dnsau.substring(1) : (par1EntityPlayer.func_70005_c_().equals(JBRAClient.mc.field_71439_g.func_70005_c_()) ? dnsau : "");
/* 2437 */       int bodytype = (skintype == 0) ? JRMCoreH.dnsBodyC1_0(dns) : JRMCoreH.dnsBodyT(dns);
/* 2438 */       int bodycm = (skintype == 0) ? 0 : (iau ? JRMCoreH.dnsauCM(dnsau) : JRMCoreH.dnsBodyCM(dns));
/* 2439 */       int bodyc1 = (skintype == 0) ? 0 : (iau ? JRMCoreH.dnsauC1(dnsau) : JRMCoreH.dnsBodyC1(dns));
/* 2440 */       int bodyc2 = (skintype == 0) ? 0 : (iau ? JRMCoreH.dnsauC2(dnsau) : JRMCoreH.dnsBodyC2(dns));
/* 2441 */       int bodyc3 = (skintype == 0) ? 0 : (iau ? JRMCoreH.dnsauC3(dnsau) : JRMCoreH.dnsBodyC3(dns));
/*      */       
/* 2443 */       int plyrSpc = (skintype == 0) ? 0 : ((JRMCoreH.RaceCustomSkin[race] == 0) ? 0 : ((bodytype >= JRMCoreH.Specials[race]) ? (JRMCoreH.Specials[race] - 1) : bodytype));
/*      */       
/* 2445 */       int[] an = { 1, 0, 2, 0, 0, 3, 0, 1, 1 };
/*      */       
/* 2447 */       boolean instantTransmission = (ExtendedPlayer.get((EntityPlayer)acp).getBlocking() == 2);
/*      */       
/* 2449 */       int id = (ExtendedPlayer.get((EntityPlayer)acp).getBlocking() != 0) ? (instantTransmission ? 6 : 0) : ((ExtendedPlayer.get((EntityPlayer)acp).getAnimKiShoot() != 0) ? (an[ExtendedPlayer.get((EntityPlayer)acp).getAnimKiShoot() - 1] + 2) : -1);
/* 2450 */       if (!JGConfigClientSettings.CLIENT_DA4) id = -1;
/*      */ 
/*      */       
/* 2453 */       if (JRMCoreH.DBC()) {
/*      */         
/* 2455 */         kk2 = JRMCoreH.StusEfctsMe(5);
/* 2456 */         kk = JRMCoreH.State2 + 1;
/* 2457 */         if (kk2) {
/*      */           
/* 2459 */           r = kk / 15.0F; g = -(kk / 15.0F); b = -(kk / 15.0F);
/* 2460 */           if (r > 1.0F) r = 1.0F;  if (g < 0.0F) r = 0.0F;  if (b < 0.0F) r = 0.0F; 
/*      */         } else {
/* 2462 */           r = 0.0F; g = 0.0F; b = 0.0F;
/*      */         } 
/*      */       } 
/*      */       
/* 2466 */       if (JRMCoreH.NC()) {
/*      */         
/* 2468 */         int idd = ExtendedPlayer.get((EntityPlayer)acp).getHandEffect();
/* 2469 */         int idd2 = ExtendedPlayer.get((EntityPlayer)acp).getEffect_used();
/* 2470 */         if (idd2 == -1) idd2 = 0;
/*      */         
/* 2472 */         if (idd == 1) {
/* 2473 */           GL11.glPushMatrix();
/* 2474 */           if (id > -1) {
/* 2475 */             func_aam(id, true, true);
/*      */           }
/* 2477 */           GL11.glTranslatef(-0.7F, 0.2F, 0.0F);
/* 2478 */           chakra((Entity)acp, idd2);
/* 2479 */           hndff((Entity)acp, false, idd, idd2);
/* 2480 */           GL11.glPopMatrix();
/*      */         } 
/* 2482 */         if (idd == 2) {
/* 2483 */           GL11.glPushMatrix();
/* 2484 */           if (id > -1) {
/* 2485 */             func_aam(id, true, true);
/*      */           }
/* 2487 */           GL11.glTranslatef(-0.7F, 0.2F, 0.0F);
/* 2488 */           lightning((Entity)acp, idd2);
/* 2489 */           hndff((Entity)acp, false, idd, idd2);
/* 2490 */           GL11.glPopMatrix();
/*      */         } 
/*      */       } 
/*      */       
/* 2494 */       if (JRMCoreH.DBC()) {
/* 2495 */         String[] s = JRMCoreH.data(acp.func_70005_c_(), 1, "0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0;0").split(";");
/* 2496 */         int pwr = Integer.parseInt(s[2]);
/* 2497 */         if (pwr == 1) {
/* 2498 */           String[] PlyrSkills = JRMCoreH.PlyrSkills((EntityPlayer)acp);
/* 2499 */           int sklkf = JRMCoreH.SklLvl(12, PlyrSkills);
/* 2500 */           int skf = JRMCoreH.SklLvl(15, PlyrSkills);
/*      */           
/* 2502 */           String ss = s[17];
/*      */           
/* 2504 */           boolean v = (JRMCoreH.DBC() && !ss.equals("-1"));
/* 2505 */           GL11.glPushMatrix();
/* 2506 */           if (v && (sklkf > 0 || skf > 0)) {
/* 2507 */             if (id > -1) {
/* 2508 */               func_aam(id, true, true);
/*      */             }
/* 2510 */             GL11.glRotatef(6.0F, 0.0F, 0.0F, 1.0F);
/* 2511 */             GL11.glTranslatef(-0.29F, 0.15F, 0.0F);
/* 2512 */             kss((Entity)acp, false, Integer.parseInt(ss), sklkf, skf);
/*      */           } 
/* 2514 */           GL11.glPopMatrix();
/*      */         } 
/*      */       } 
/*      */ 
/*      */       
/* 2519 */       float h1 = 1.0F;
/* 2520 */       if (race == 5 && JRMCoreH.DBC()) {
/*      */         String[] absorptionData;
/* 2522 */         boolean majinEvil = (State == 1);
/* 2523 */         boolean majinPure = (State == 3 && JGConfigRaces.CONFIG_MAJIN_PURE_PINK_SKIN);
/* 2524 */         if (majinEvil) {
/* 2525 */           haircol = bodycm = 12561588;
/*      */         }
/* 2527 */         else if (majinPure) {
/* 2528 */           haircol = bodycm = 16757199;
/*      */         } 
/*      */         
/* 2531 */         ResourceLocation bdyskn = new ResourceLocation("jinryuudragonbc:cc/majin/" + ((gen == 1) ? "f" : "") + "majin.png");
/* 2532 */         JRMCoreClient.mc.func_110434_K().func_110577_a(bdyskn);
/* 2533 */         glColor3f(bodycm);
/* 2534 */         this.modelMain.func_78087_a(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, (Entity)par1EntityPlayer);
/*      */         
/* 2536 */         if (id == -1) { this.modelMain.RA.func_78785_a(0.0625F); }
/* 2537 */         else { func_aam(this.modelMain.RA, this.modelMain.LA, id, true); }
/*      */ 
/*      */         
/* 2540 */         String[] playerData13 = JRMCoreH.data(par1EntityPlayer.func_70005_c_(), 13, "0;0;0;0,0,0+0").split(";");
/*      */         
/* 2542 */         if (playerData13.length > 3) {
/* 2543 */           absorptionData = playerData13[3].split(",");
/*      */         } else {
/*      */           
/* 2546 */           absorptionData = "0;0;0;0,0,0+0".split(",");
/*      */         } 
/* 2548 */         (new String[1])[0] = absorptionData[1]; String[] absorptionVisuals = absorptionData[1].contains("+") ? absorptionData[1].split("+") : new String[1];
/* 2549 */         int absorbedRace = Integer.parseInt(absorptionVisuals[0]);
/* 2550 */         if (JRMCoreH.isRaceArcosian(absorbedRace) || JRMCoreH.isRaceNamekian(absorbedRace)) {
/*      */           
/* 2552 */           bdyskn = new ResourceLocation("jinryuudragonbc:cc/majin/" + ((gen == 1) ? "f" : "") + "majin_" + (JRMCoreH.isRaceArcosian(absorbedRace) ? "arco" : "namek") + ".png");
/* 2553 */           func_110776_a(bdyskn);
/* 2554 */           glColor3f(bodycm);
/*      */           
/* 2556 */           this.modelMain.func_78087_a(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, (Entity)par1EntityPlayer);
/*      */           
/* 2558 */           if (id == -1) { this.modelMain.RA.func_78785_a(0.0625F); }
/* 2559 */           else { func_aam(this.modelMain.RA, this.modelMain.LA, id, true); }
/*      */         
/*      */         } 
/*      */ 
/*      */ 
/*      */         
/* 2565 */         if (!saiOozar) {
/* 2566 */           if (skintype == 0) {
/* 2567 */             bdyskn = acp.func_110306_p().equals(steveTextures) ? ((gen >= 1) ? fem : steveTextures) : acp.func_110306_p();
/* 2568 */             if (JBRAH.JHDS() && JBRAH.getSkinHas(data)) { JRMCoreClient.mc.func_110434_K().func_110577_a(JBRAH.getSkinLoc(data)); }
/* 2569 */             else { JRMCoreClient.mc.func_110434_K().func_110577_a(bdyskn); }
/* 2570 */              GL11.glColor3f(h1 + getR(), h1 + getG(), h1 + getB());
/* 2571 */             this.modelMain.func_78087_a(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, (Entity)par1EntityPlayer);
/*      */ 
/*      */ 
/*      */             
/* 2575 */             if (id == -1) {
/* 2576 */               this.modelMain.RA.func_78785_a(0.0625F);
/*      */             } else {
/*      */               
/* 2579 */               func_aam(this.modelMain.RA, this.modelMain.LA, id, true);
/*      */             }
/*      */           
/*      */           }
/* 2583 */           else if (JBRAH.JHDS() && JBRAH.getSkinHas(data) && skintype == 0) {
/* 2584 */             GL11.glColor3f(h1 + getR(), h1 + getG(), h1 + getB());
/* 2585 */             JRMCoreClient.mc.func_110434_K().func_110577_a(JBRAH.getSkinLoc(data));
/* 2586 */             this.modelMain.func_78087_a(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, (Entity)par1EntityPlayer);
/* 2587 */             if (id == -1) { this.modelMain.RA.func_78785_a(0.0625F); }
/* 2588 */             else { func_aam(this.modelMain.RA, this.modelMain.LA, id, true);
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */                }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       }
/* 2613 */       else if (race == 3 && JRMCoreH.DBC()) {
/*      */ 
/*      */         
/* 2616 */         boolean v = JRMCoreH.StusEfctsMe(17);
/* 2617 */         boolean ssg = JRMCoreHDBC.godKiUserBase(race, State);
/* 2618 */         if (ssg && v) {
/*      */           
/* 2620 */           bodycm = 16744999;
/* 2621 */           bodyc1 = 15524763;
/* 2622 */           bodyc2 = 12854822;
/* 2623 */           bodyc3 = 0;
/*      */         } 
/*      */ 
/*      */ 
/*      */         
/* 2628 */         ResourceLocation bdyskn = new ResourceLocation("jinryuudragonbc:cc/nam/0nam" + plyrSpc + ".png");
/* 2629 */         JRMCoreClient.mc.func_110434_K().func_110577_a(bdyskn);
/* 2630 */         glColor3f(bodycm);
/* 2631 */         this.modelMain.func_78087_a(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, (Entity)par1EntityPlayer);
/*      */ 
/*      */         
/* 2634 */         if (id == -1) { this.modelMain.RA.func_78785_a(0.0625F); }
/* 2635 */         else { func_aam(this.modelMain.RA, this.modelMain.LA, id, true); }
/*      */ 
/*      */ 
/*      */         
/* 2639 */         bdyskn = new ResourceLocation("jinryuudragonbc:cc/nam/1nam" + plyrSpc + ".png");
/* 2640 */         JRMCoreClient.mc.func_110434_K().func_110577_a(bdyskn);
/* 2641 */         glColor3f(bodyc1);
/* 2642 */         this.modelMain.func_78087_a(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, (Entity)par1EntityPlayer);
/* 2643 */         if (id == -1) { this.modelMain.RA.func_78785_a(0.0625F); }
/* 2644 */         else { func_aam(this.modelMain.RA, this.modelMain.LA, id, true); }
/*      */ 
/*      */ 
/*      */         
/* 2648 */         bdyskn = new ResourceLocation("jinryuudragonbc:cc/nam/2nam" + plyrSpc + ".png");
/* 2649 */         JRMCoreClient.mc.func_110434_K().func_110577_a(bdyskn);
/* 2650 */         glColor3f(bodyc2);
/* 2651 */         this.modelMain.func_78087_a(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, (Entity)par1EntityPlayer);
/* 2652 */         if (id == -1) { this.modelMain.RA.func_78785_a(0.0625F); }
/* 2653 */         else { func_aam(this.modelMain.RA, this.modelMain.LA, id, true); }
/*      */ 
/*      */ 
/*      */         
/* 2657 */         bdyskn = new ResourceLocation("jinryuudragonbc:cc/nam/3nam" + plyrSpc + ".png");
/* 2658 */         JRMCoreClient.mc.func_110434_K().func_110577_a(bdyskn);
/*      */         
/* 2660 */         GL11.glColor3f(h1 + getR(), h1 + getG(), h1 + getB());
/* 2661 */         this.modelMain.func_78087_a(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, (Entity)par1EntityPlayer);
/* 2662 */         if (id == -1) { this.modelMain.RA.func_78785_a(0.0625F); }
/* 2663 */         else { func_aam(this.modelMain.RA, this.modelMain.LA, id, true); }
/*      */ 
/*      */       
/* 2666 */       } else if (race == 4 && JRMCoreH.DBC()) {
/*      */         
/* 2668 */         boolean v = JRMCoreH.StusEfctsMe(17);
/* 2669 */         boolean ssg = JRMCoreHDBC.godKiUserBase(race, State);
/* 2670 */         if (ssg && v) {
/*      */           
/* 2672 */           State = 6;
/* 2673 */           bodycm = 5526612;
/* 2674 */           bodyc1 = 12829635;
/* 2675 */           bodyc3 = 1513239;
/*      */         } 
/*      */         
/* 2678 */         ResourceLocation bdyskn = new ResourceLocation("jinryuudragonbc:cc/arc/" + ((gen == 1) ? "f" : "m") + "/0A" + JRMCoreH.TransFrSkn[State] + plyrSpc + ".png");
/* 2679 */         JRMCoreClient.mc.func_110434_K().func_110577_a(bdyskn);
/* 2680 */         glColor3f(bodycm);
/* 2681 */         this.modelMain.func_78087_a(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, (Entity)par1EntityPlayer);
/* 2682 */         if (id == -1) { this.modelMain.RA.func_78785_a(0.0625F); }
/* 2683 */         else { func_aam(this.modelMain.RA, this.modelMain.LA, id, true); }
/*      */ 
/*      */ 
/*      */         
/* 2687 */         bdyskn = new ResourceLocation("jinryuudragonbc:cc/arc/" + ((gen == 1) ? "f" : "m") + "/1A" + JRMCoreH.TransFrSkn[State] + plyrSpc + ".png");
/* 2688 */         JRMCoreClient.mc.func_110434_K().func_110577_a(bdyskn);
/* 2689 */         glColor3f(bodyc1);
/* 2690 */         this.modelMain.func_78087_a(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, (Entity)par1EntityPlayer);
/* 2691 */         if (id == -1) { this.modelMain.RA.func_78785_a(0.0625F); }
/* 2692 */         else { func_aam(this.modelMain.RA, this.modelMain.LA, id, true); }
/*      */ 
/*      */ 
/*      */         
/* 2696 */         bdyskn = new ResourceLocation("jinryuudragonbc:cc/arc/" + ((gen == 1) ? "f" : "m") + "/2A" + JRMCoreH.TransFrSkn[State] + plyrSpc + ".png");
/* 2697 */         JRMCoreClient.mc.func_110434_K().func_110577_a(bdyskn);
/* 2698 */         glColor3f(bodyc2);
/* 2699 */         this.modelMain.func_78087_a(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, (Entity)par1EntityPlayer);
/* 2700 */         if (id == -1) { this.modelMain.RA.func_78785_a(0.0625F); }
/* 2701 */         else { func_aam(this.modelMain.RA, this.modelMain.LA, id, true); }
/*      */ 
/*      */ 
/*      */         
/* 2705 */         bdyskn = new ResourceLocation("jinryuudragonbc:cc/arc/" + ((gen == 1) ? "f" : "m") + "/3A" + JRMCoreH.TransFrSkn[State] + plyrSpc + ".png");
/* 2706 */         JRMCoreClient.mc.func_110434_K().func_110577_a(bdyskn);
/* 2707 */         glColor3f(bodyc3);
/* 2708 */         this.modelMain.func_78087_a(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, (Entity)par1EntityPlayer);
/* 2709 */         if (id == -1) { this.modelMain.RA.func_78785_a(0.0625F); }
/* 2710 */         else { func_aam(this.modelMain.RA, this.modelMain.LA, id, true); }
/*      */ 
/*      */ 
/*      */         
/* 2714 */         bdyskn = new ResourceLocation("jinryuudragonbc:cc/arc/" + ((gen == 1) ? "f" : "m") + "/4A" + JRMCoreH.TransFrSkn[State] + plyrSpc + ".png");
/* 2715 */         JRMCoreClient.mc.func_110434_K().func_110577_a(bdyskn);
/* 2716 */         GL11.glColor3f(h1 + getR(), h1 + getG(), h1 + getB());
/* 2717 */         this.modelMain.func_78087_a(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, (Entity)par1EntityPlayer);
/* 2718 */         if (id == -1) { this.modelMain.RA.func_78785_a(0.0625F); }
/* 2719 */         else { func_aam(this.modelMain.RA, this.modelMain.LA, id, true); }
/*      */ 
/*      */       
/*      */       } else {
/*      */         
/* 2724 */         if (saiOozar) {
/*      */           
/* 2726 */           ResourceLocation bdyskn = new ResourceLocation("jinryuudragonbc:cc/oozaru1.png");
/* 2727 */           JRMCoreClient.mc.func_110434_K().func_110577_a(bdyskn);
/* 2728 */           glColor3f((skintype != 0) ? bodycm : 11374471);
/* 2729 */           this.modelMain.func_78087_a(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, (Entity)par1EntityPlayer);
/* 2730 */           if (id == -1) { this.modelMain.RA.func_78785_a(0.0625F); }
/* 2731 */           else { func_aam(this.modelMain.RA, this.modelMain.LA, id, true); }
/*      */ 
/*      */           
/* 2734 */           int tailCol = (race == 2 || bodytype != 0) ? bodytype : 6498048;
/* 2735 */           int j = (State == 0 || State == 7) ? ((skintype == 1) ? bodyc1 : tailCol) : (lg ? 10092390 : 16574610);
/*      */           
/* 2737 */           bdyskn = new ResourceLocation("jinryuudragonbc:cc/oozaru2.png");
/* 2738 */           JRMCoreClient.mc.func_110434_K().func_110577_a(bdyskn);
/* 2739 */           glColor3f(j);
/* 2740 */           this.modelMain.func_78087_a(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, (Entity)par1EntityPlayer);
/* 2741 */           if (id == -1) { this.modelMain.RA.func_78785_a(0.0625F); }
/* 2742 */           else { func_aam(this.modelMain.RA, this.modelMain.LA, id, true); }
/*      */ 
/*      */         
/* 2745 */         } else if (skintype != 0) {
/* 2746 */           ResourceLocation bdyskn = new ResourceLocation("jinryuumodscore:cc/" + ((gen == 1) ? "f" : "") + "hum.png");
/* 2747 */           JRMCoreClient.mc.func_110434_K().func_110577_a(bdyskn);
/* 2748 */           glColor3f(bodycm);
/* 2749 */           this.modelMain.func_78087_a(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, (Entity)par1EntityPlayer);
/*      */           
/* 2751 */           if (id == -1) { this.modelMain.RA.func_78785_a(0.0625F); }
/* 2752 */           else { func_aam(this.modelMain.RA, this.modelMain.LA, id, true); }
/*      */         
/*      */         } 
/*      */ 
/*      */         
/* 2757 */         if (!saiOozar) {
/* 2758 */           if (skintype == 0) {
/* 2759 */             ResourceLocation bdyskn = acp.func_110306_p().equals(steveTextures) ? ((gen >= 1) ? fem : steveTextures) : acp.func_110306_p();
/* 2760 */             if (JBRAH.JHDS() && JBRAH.getSkinHas(data)) { JRMCoreClient.mc.func_110434_K().func_110577_a(JBRAH.getSkinLoc(data)); }
/* 2761 */             else { JRMCoreClient.mc.func_110434_K().func_110577_a(bdyskn); }
/* 2762 */              GL11.glColor3f(h1 + getR(), h1 + getG(), h1 + getB());
/* 2763 */             this.modelMain.func_78087_a(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, (Entity)par1EntityPlayer);
/*      */ 
/*      */ 
/*      */             
/* 2767 */             if (id == -1) {
/* 2768 */               this.modelMain.RA.func_78785_a(0.0625F);
/*      */             } else {
/*      */               
/* 2771 */               func_aam(this.modelMain.RA, this.modelMain.LA, id, true);
/*      */             }
/*      */           
/*      */           }
/* 2775 */           else if (JBRAH.JHDS() && JBRAH.getSkinHas(data) && skintype == 0) {
/* 2776 */             GL11.glColor3f(h1 + getR(), h1 + getG(), h1 + getB());
/* 2777 */             JRMCoreClient.mc.func_110434_K().func_110577_a(JBRAH.getSkinLoc(data));
/* 2778 */             this.modelMain.func_78087_a(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, (Entity)par1EntityPlayer);
/* 2779 */             if (id == -1) { this.modelMain.RA.func_78785_a(0.0625F); }
/* 2780 */             else { func_aam(this.modelMain.RA, this.modelMain.LA, id, true); }
/*      */           
/*      */           } 
/*      */ 
/*      */           
/* 2785 */           if (State == 14) {
/* 2786 */             int tailCol = (race == 2 || bodytype != 0) ? bodytype : 6498048;
/* 2787 */             tailCol = JRMCoreH.isAprilFoolsModeOn() ? 13292516 : tailCol;
/* 2788 */             int jx = (skintype == 1) ? bodyc1 : tailCol;
/* 2789 */             if (JRMCoreH.rSai(race) && jx == 6498048 && State == 14)
/*      */             {
/* 2791 */               if (JRMCoreH.isAprilFoolsModeOn()) { jx = 13292516; }
/* 2792 */               else { jx = 14292268; }
/*      */             
/*      */             }
/* 2795 */             JRMCoreClient.mc.func_110434_K().func_110577_a(new ResourceLocation("jinryuudragonbc:cc/ss4" + ((skintype == 0) ? "a" : "b") + ".png"));
/*      */             
/* 2797 */             glColor3f(jx);
/* 2798 */             this.modelMain.func_78087_a(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, (Entity)par1EntityPlayer);
/* 2799 */             if (id == -1) { this.modelMain.RA.func_78785_a(0.0625F); }
/* 2800 */             else { func_aam(this.modelMain.RA, this.modelMain.LA, id, true); }
/*      */           
/*      */           } 
/*      */         } 
/*      */       } 
/*      */       
/* 2806 */       if (JGConfigClientSettings.CLIENT_DA19 && (JRMCoreH.DBC() || JRMCoreH.NC())) {
/* 2807 */         GL11.glPushMatrix();
/* 2808 */         GL11.glEnable(3042);
/* 2809 */         GL11.glDisable(2896);
/* 2810 */         GL11.glBlendFunc(770, 771);
/* 2811 */         GL11.glAlphaFunc(516, 0.003921569F);
/* 2812 */         GL11.glDepthMask(false);
/*      */ 
/*      */         
/* 2815 */         int maxBody = JRMCoreH.stat((Entity)par1EntityPlayer, 2, JRMCoreH.Pwrtyp, 2, JRMCoreH.PlyrAttrbts[2], race, JRMCoreH.Class, 0.0F);
/*      */         
/* 2817 */         int curBody = Integer.parseInt(JRMCoreH.data(par1EntityPlayer.func_70005_c_(), 8, "200"));
/*      */         
/* 2819 */         float one = maxBody / 100.0F;
/* 2820 */         int perc = (int)(curBody / one);
/*      */         
/* 2822 */         if (perc < 70) {
/* 2823 */           GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 2824 */           JRMCoreClient.mc.func_110434_K().func_110577_a(new ResourceLocation("jinryuumodscore:cc/bruises1.png"));
/* 2825 */           if (id == -1) { this.modelMain.RA.func_78785_a(0.0625F); }
/* 2826 */           else { func_aam(this.modelMain.RA, this.modelMain.LA, id, true); }
/*      */         
/* 2828 */         }  if (perc < 55) {
/* 2829 */           GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 2830 */           JRMCoreClient.mc.func_110434_K().func_110577_a(new ResourceLocation("jinryuumodscore:cc/bruises2.png"));
/* 2831 */           if (id == -1) { this.modelMain.RA.func_78785_a(0.0625F); }
/* 2832 */           else { func_aam(this.modelMain.RA, this.modelMain.LA, id, true); }
/*      */         
/* 2834 */         }  if (perc < 35) {
/* 2835 */           GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 2836 */           JRMCoreClient.mc.func_110434_K().func_110577_a(new ResourceLocation("jinryuumodscore:cc/bruises3.png"));
/* 2837 */           if (id == -1) { this.modelMain.RA.func_78785_a(0.0625F); }
/* 2838 */           else { func_aam(this.modelMain.RA, this.modelMain.LA, id, true); }
/*      */         
/* 2840 */         }  if (perc < 20) {
/* 2841 */           GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 2842 */           JRMCoreClient.mc.func_110434_K().func_110577_a(new ResourceLocation("jinryuumodscore:cc/bruises4.png"));
/* 2843 */           if (id == -1) { this.modelMain.RA.func_78785_a(0.0625F); }
/* 2844 */           else { func_aam(this.modelMain.RA, this.modelMain.LA, id, true); }
/*      */         
/* 2846 */         }  GL11.glDepthMask(true);
/* 2847 */         GL11.glEnable(2896);
/* 2848 */         GL11.glDisable(3042);
/* 2849 */         GL11.glPopMatrix();
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2856 */       if (JRMCoreH.JYC())
/*      */       {
/* 2858 */         if (par1EntityPlayer.field_71071_by.func_146028_b(JRMCoreHJYC.JYCgetItemWatch())) {
/*      */           
/* 2860 */           GL11.glPushMatrix();
/*      */           
/* 2862 */           if (id > -1) {
/* 2863 */             func_aam(id, true, true);
/*      */           }
/* 2865 */           GL11.glRotatef(6.0F, 0.0F, 0.0F, 1.0F);
/* 2866 */           GL11.glTranslatef(-0.29F, 0.15F, 0.0F);
/* 2867 */           ow(true);
/* 2868 */           GL11.glPopMatrix();
/*      */         } 
/*      */       }
/*      */ 
/*      */       
/* 2873 */       ItemStack itemstack = par1EntityPlayer.field_71071_by.func_70440_f(2);
/* 2874 */       if (itemstack != null) {
/* 2875 */         Item item = itemstack.func_77973_b();
/* 2876 */         if (item instanceof ItemArmor) {
/* 2877 */           ItemArmor itemarmor = (ItemArmor)item;
/* 2878 */           GL11.glPushMatrix();
/* 2879 */           String dbcarmor = itemarmor.getArmorTexture(itemstack, (Entity)par1EntityPlayer, 2, null);
/* 2880 */           ResourceLocation mcarmor = RenderBiped.getArmorResource((Entity)par1EntityPlayer, itemstack, 1, null);
/* 2881 */           if (dbcarmor != null) dbcarmor = dbcarmor.replace("jbra", "").replace("_dam", ""); 
/* 2882 */           ResourceLocation armor = (dbcarmor != null) ? new ResourceLocation(dbcarmor) : mcarmor;
/* 2883 */           JRMCoreClient.mc.func_110434_K().func_110577_a(armor);
/*      */           
/* 2885 */           GL11.glPushMatrix();
/* 2886 */           if (id > -1) {
/* 2887 */             func_aam(id, true, true);
/*      */           }
/*      */           
/* 2890 */           GL11.glColor3f(1.0F + getR(), 1.0F + getG(), 1.0F + getB());
/* 2891 */           GL11.glScalef(1.0001F, 1.0001F, 1.0001F);
/*      */           
/* 2893 */           if (dbcarmor != null) {
/* 2894 */             this.modelMain.func_78087_a(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, (Entity)par1EntityPlayer);
/* 2895 */             this.modelMain.field_78089_u = 64;
/* 2896 */             this.modelMain.field_78090_t = 128;
/* 2897 */             this.modelMain.RA.func_78785_a(0.0625F);
/*      */           }
/*      */           else {
/*      */             
/* 2901 */             this.modelMain.func_78087_a(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, (Entity)par1EntityPlayer);
/* 2902 */             this.modelMain.RA.func_78785_a(0.0625F);
/*      */           } 
/*      */           
/* 2905 */           GL11.glPopMatrix();
/* 2906 */           GL11.glPopMatrix();
/*      */         } 
/*      */       } 
/*      */       
/* 2910 */       if (race == 3 && JRMCoreH.DBC()) {
/*      */         
/* 2912 */         ResourceLocation bdyskn = new ResourceLocation("jinryuudragonbc:cc/nam/0nam" + plyrSpc + ".png");
/* 2913 */         JRMCoreClient.mc.func_110434_K().func_110577_a(bdyskn);
/* 2914 */         glColor3f(bodycm);
/* 2915 */         this.modelMain.func_78087_a(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, (Entity)par1EntityPlayer);
/*      */ 
/*      */         
/* 2918 */         if (id != -1) func_aam2(this.modelMain.RA, this.modelMain.LA, id, true);
/*      */ 
/*      */         
/* 2921 */         bdyskn = new ResourceLocation("jinryuudragonbc:cc/nam/1nam" + plyrSpc + ".png");
/* 2922 */         JRMCoreClient.mc.func_110434_K().func_110577_a(bdyskn);
/* 2923 */         glColor3f(bodyc1);
/* 2924 */         this.modelMain.func_78087_a(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, (Entity)par1EntityPlayer);
/* 2925 */         if (id != -1) func_aam2(this.modelMain.RA, this.modelMain.LA, id, true);
/*      */ 
/*      */         
/* 2928 */         bdyskn = new ResourceLocation("jinryuudragonbc:cc/nam/2nam" + plyrSpc + ".png");
/* 2929 */         JRMCoreClient.mc.func_110434_K().func_110577_a(bdyskn);
/* 2930 */         glColor3f(bodyc2);
/* 2931 */         this.modelMain.func_78087_a(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, (Entity)par1EntityPlayer);
/* 2932 */         if (id != -1) func_aam2(this.modelMain.RA, this.modelMain.LA, id, true);
/*      */ 
/*      */         
/* 2935 */         bdyskn = new ResourceLocation("jinryuudragonbc:cc/nam/3nam" + plyrSpc + ".png");
/* 2936 */         JRMCoreClient.mc.func_110434_K().func_110577_a(bdyskn);
/*      */         
/* 2938 */         GL11.glColor3f(h1 + getR(), h1 + getG(), h1 + getB());
/* 2939 */         this.modelMain.func_78087_a(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, (Entity)par1EntityPlayer);
/* 2940 */         if (id != -1) func_aam2(this.modelMain.RA, this.modelMain.LA, id, true);
/*      */       
/* 2942 */       } else if (race == 4 && JRMCoreH.DBC()) {
/* 2943 */         ResourceLocation bdyskn = new ResourceLocation("jinryuudragonbc:cc/arc/" + ((gen == 1) ? "f" : "m") + "/0A" + JRMCoreH.TransFrSkn[State] + plyrSpc + ".png");
/* 2944 */         JRMCoreClient.mc.func_110434_K().func_110577_a(bdyskn);
/* 2945 */         glColor3f(bodycm);
/* 2946 */         this.modelMain.func_78087_a(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, (Entity)par1EntityPlayer);
/* 2947 */         if (id != -1) func_aam2(this.modelMain.RA, this.modelMain.LA, id, true);
/*      */ 
/*      */         
/* 2950 */         bdyskn = new ResourceLocation("jinryuudragonbc:cc/arc/" + ((gen == 1) ? "f" : "m") + "/1A" + JRMCoreH.TransFrSkn[State] + plyrSpc + ".png");
/* 2951 */         JRMCoreClient.mc.func_110434_K().func_110577_a(bdyskn);
/* 2952 */         glColor3f(bodyc1);
/* 2953 */         this.modelMain.func_78087_a(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, (Entity)par1EntityPlayer);
/* 2954 */         if (id != -1) func_aam2(this.modelMain.RA, this.modelMain.LA, id, true);
/*      */ 
/*      */         
/* 2957 */         bdyskn = new ResourceLocation("jinryuudragonbc:cc/arc/" + ((gen == 1) ? "f" : "m") + "/2A" + JRMCoreH.TransFrSkn[State] + plyrSpc + ".png");
/* 2958 */         JRMCoreClient.mc.func_110434_K().func_110577_a(bdyskn);
/* 2959 */         glColor3f(bodyc2);
/* 2960 */         this.modelMain.func_78087_a(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, (Entity)par1EntityPlayer);
/* 2961 */         if (id != -1) func_aam2(this.modelMain.RA, this.modelMain.LA, id, true);
/*      */ 
/*      */         
/* 2964 */         bdyskn = new ResourceLocation("jinryuudragonbc:cc/arc/" + ((gen == 1) ? "f" : "m") + "/3A" + JRMCoreH.TransFrSkn[State] + plyrSpc + ".png");
/* 2965 */         JRMCoreClient.mc.func_110434_K().func_110577_a(bdyskn);
/* 2966 */         glColor3f(bodyc3);
/* 2967 */         this.modelMain.func_78087_a(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, (Entity)par1EntityPlayer);
/* 2968 */         if (id != -1) func_aam2(this.modelMain.RA, this.modelMain.LA, id, true);
/*      */ 
/*      */         
/* 2971 */         bdyskn = new ResourceLocation("jinryuudragonbc:cc/arc/" + ((gen == 1) ? "f" : "m") + "/4A" + JRMCoreH.TransFrSkn[State] + plyrSpc + ".png");
/* 2972 */         JRMCoreClient.mc.func_110434_K().func_110577_a(bdyskn);
/*      */         
/* 2974 */         GL11.glColor3f(h1 + getR(), h1 + getG(), h1 + getB());
/* 2975 */         this.modelMain.func_78087_a(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, (Entity)par1EntityPlayer);
/* 2976 */         if (id != -1) func_aam2(this.modelMain.RA, this.modelMain.LA, id, true);
/*      */       
/*      */       } else {
/*      */         
/* 2980 */         if (saiOozar) {
/* 2981 */           ResourceLocation bdyskn = new ResourceLocation("jinryuudragonbc:cc/oozaru1.png");
/* 2982 */           JRMCoreClient.mc.func_110434_K().func_110577_a(bdyskn);
/* 2983 */           glColor3f((skintype != 0) ? bodycm : 11374471);
/* 2984 */           this.modelMain.func_78087_a(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, (Entity)par1EntityPlayer);
/* 2985 */           if (id != -1) func_aam2(this.modelMain.RA, this.modelMain.LA, id, true);
/*      */           
/* 2987 */           int tailCol = (race == 2 || bodytype != 0) ? bodytype : 6498048;
/* 2988 */           int j = (State == 0 || State == 7) ? ((skintype == 1) ? bodyc1 : tailCol) : (lg ? 10092390 : 16574610);
/*      */           
/* 2990 */           bdyskn = new ResourceLocation("jinryuudragonbc:cc/oozaru2.png");
/* 2991 */           JRMCoreClient.mc.func_110434_K().func_110577_a(bdyskn);
/* 2992 */           glColor3f(j);
/* 2993 */           this.modelMain.func_78087_a(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, (Entity)par1EntityPlayer);
/* 2994 */           if (id != -1) func_aam2(this.modelMain.RA, this.modelMain.LA, id, true);
/*      */         
/* 2996 */         } else if (skintype != 0) {
/* 2997 */           ResourceLocation bdyskn = new ResourceLocation("jinryuumodscore:cc/" + ((gen == 1) ? "f" : "") + "hum.png");
/* 2998 */           JRMCoreClient.mc.func_110434_K().func_110577_a(bdyskn);
/* 2999 */           glColor3f(bodycm);
/* 3000 */           this.modelMain.func_78087_a(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, (Entity)par1EntityPlayer);
/* 3001 */           if (id != -1) func_aam2(this.modelMain.RA, this.modelMain.LA, id, true);
/*      */         
/*      */         } 
/*      */         
/* 3005 */         if (!saiOozar) {
/* 3006 */           if (skintype == 0) {
/* 3007 */             ResourceLocation bdyskn = acp.func_110306_p().equals(steveTextures) ? ((gen >= 1) ? fem : steveTextures) : acp.func_110306_p();
/* 3008 */             if (JBRAH.JHDS() && JBRAH.getSkinHas(data)) { JRMCoreClient.mc.func_110434_K().func_110577_a(JBRAH.getSkinLoc(data)); }
/* 3009 */             else { JRMCoreClient.mc.func_110434_K().func_110577_a(bdyskn); }
/*      */             
/* 3011 */             GL11.glColor3f(h1 + getR(), h1 + getG(), h1 + getB());
/* 3012 */             this.modelMain.func_78087_a(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, (Entity)par1EntityPlayer);
/*      */ 
/*      */ 
/*      */             
/* 3016 */             if (id != -1) func_aam2(this.modelMain.RA, this.modelMain.LA, id, true);
/*      */           
/*      */           }
/* 3019 */           else if (JBRAH.JHDS() && JBRAH.getSkinHas(data) && skintype == 0) {
/*      */             
/* 3021 */             GL11.glColor3f(h1 + getR(), h1 + getG(), h1 + getB());
/* 3022 */             JRMCoreClient.mc.func_110434_K().func_110577_a(JBRAH.getSkinLoc(data));
/* 3023 */             this.modelMain.func_78087_a(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, (Entity)par1EntityPlayer);
/* 3024 */             if (id != -1) func_aam2(this.modelMain.RA, this.modelMain.LA, id, true);
/*      */           
/*      */           } 
/* 3027 */           if (State == 14) {
/* 3028 */             int tailCol = (race == 2 || bodytype != 0) ? bodytype : 6498048;
/* 3029 */             tailCol = JRMCoreH.isAprilFoolsModeOn() ? 13292516 : tailCol;
/* 3030 */             int jx = (skintype == 1) ? bodyc1 : tailCol;
/*      */             
/* 3032 */             if (JRMCoreH.rSai(race) && jx == 6498048 && State == 14)
/*      */             {
/* 3034 */               if (JRMCoreH.isAprilFoolsModeOn()) { jx = 13292516; }
/* 3035 */               else { jx = 14292268; }
/*      */             
/*      */             }
/* 3038 */             JRMCoreClient.mc.func_110434_K().func_110577_a(new ResourceLocation("jinryuudragonbc:cc/ss4" + ((skintype == 0) ? "a" : "b") + ".png"));
/*      */             
/* 3040 */             glColor3f(jx);
/* 3041 */             this.modelMain.func_78087_a(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, (Entity)par1EntityPlayer);
/* 3042 */             if (id != -1) func_aam2(this.modelMain.RA, this.modelMain.LA, id, true);
/*      */           
/*      */           } 
/*      */         } 
/*      */       } 
/* 3047 */       if (JGConfigClientSettings.CLIENT_DA19) {
/*      */         
/* 3049 */         GL11.glPushMatrix();
/* 3050 */         GL11.glEnable(3042);
/* 3051 */         GL11.glDisable(2896);
/* 3052 */         GL11.glBlendFunc(770, 771);
/* 3053 */         GL11.glAlphaFunc(516, 0.003921569F);
/* 3054 */         GL11.glDepthMask(false);
/*      */         
/* 3056 */         int maxBody = JRMCoreH.stat((Entity)par1EntityPlayer, 2, JRMCoreH.Pwrtyp, 2, JRMCoreH.PlyrAttrbts[2], race, JRMCoreH.Class, 0.0F);
/*      */         
/* 3058 */         int curBody = Integer.parseInt(JRMCoreH.data(par1EntityPlayer.func_70005_c_(), 8, "200"));
/*      */         
/* 3060 */         float one = maxBody / 100.0F;
/* 3061 */         int perc = (int)(curBody / one);
/*      */         
/* 3063 */         if (perc < 70) {
/* 3064 */           GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 3065 */           JRMCoreClient.mc.func_110434_K().func_110577_a(new ResourceLocation("jinryuumodscore:cc/bruises1.png"));
/* 3066 */           if (id != -1) func_aam2(this.modelMain.RA, this.modelMain.LA, id, true); 
/*      */         } 
/* 3068 */         if (perc < 55) {
/* 3069 */           GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 3070 */           JRMCoreClient.mc.func_110434_K().func_110577_a(new ResourceLocation("jinryuumodscore:cc/bruises2.png"));
/* 3071 */           if (id != -1) func_aam2(this.modelMain.RA, this.modelMain.LA, id, true); 
/*      */         } 
/* 3073 */         if (perc < 35) {
/* 3074 */           GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 3075 */           JRMCoreClient.mc.func_110434_K().func_110577_a(new ResourceLocation("jinryuumodscore:cc/bruises3.png"));
/* 3076 */           if (id != -1) func_aam2(this.modelMain.RA, this.modelMain.LA, id, true); 
/*      */         } 
/* 3078 */         if (perc < 20) {
/* 3079 */           GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 3080 */           JRMCoreClient.mc.func_110434_K().func_110577_a(new ResourceLocation("jinryuumodscore:cc/bruises4.png"));
/* 3081 */           if (id != -1) func_aam2(this.modelMain.RA, this.modelMain.LA, id, true); 
/*      */         } 
/* 3083 */         GL11.glDepthMask(true);
/* 3084 */         GL11.glEnable(2896);
/* 3085 */         GL11.glDisable(3042);
/* 3086 */         GL11.glPopMatrix();
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 3093 */       if (itemstack != null) {
/* 3094 */         Item item = itemstack.func_77973_b();
/* 3095 */         if (item instanceof ItemArmor) {
/* 3096 */           ItemArmor itemarmor = (ItemArmor)item;
/* 3097 */           GL11.glPushMatrix();
/* 3098 */           String dbcarmor = itemarmor.getArmorTexture(itemstack, (Entity)par1EntityPlayer, 2, null);
/* 3099 */           ResourceLocation mcarmor = RenderBiped.getArmorResource((Entity)par1EntityPlayer, itemstack, 1, null);
/* 3100 */           if (dbcarmor != null) dbcarmor = dbcarmor.replace("jbra", "").replace("_dam", ""); 
/* 3101 */           ResourceLocation armor = (dbcarmor != null) ? new ResourceLocation(dbcarmor) : mcarmor;
/* 3102 */           JRMCoreClient.mc.func_110434_K().func_110577_a(armor);
/*      */           
/* 3104 */           if (id == 0 || id == 3 || id == 5) {
/* 3105 */             if (id == 0) {
/* 3106 */               if (JGConfigClientSettings.CLIENT_DA18) {
/* 3107 */                 GL11.glPushMatrix();
/* 3108 */                 func_aam(id, false, true);
/*      */                 
/* 3110 */                 GL11.glColor3f(1.0F + getR(), 1.0F + getG(), 1.0F + getB());
/* 3111 */                 GL11.glScalef(1.0001F, 1.0001F, 1.0001F);
/* 3112 */                 if (dbcarmor != null) {
/* 3113 */                   this.modelMain.func_78087_a(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, (Entity)par1EntityPlayer);
/* 3114 */                   this.modelMain.field_78089_u = 64;
/* 3115 */                   this.modelMain.field_78090_t = 128;
/* 3116 */                   this.modelMain.LA.func_78785_a(0.0625F);
/*      */                 } else {
/*      */                   
/* 3119 */                   this.modelMain.func_78087_a(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, (Entity)par1EntityPlayer);
/* 3120 */                   this.modelMain.LA.func_78785_a(0.0625F);
/*      */                 } 
/* 3122 */                 GL11.glPopMatrix();
/*      */               } 
/*      */             } else {
/*      */               
/* 3126 */               GL11.glPushMatrix();
/* 3127 */               func_aam(id, false, true);
/*      */               
/* 3129 */               GL11.glColor3f(1.0F + getR(), 1.0F + getG(), 1.0F + getB());
/* 3130 */               GL11.glScalef(1.0001F, 1.0001F, 1.0001F);
/* 3131 */               if (dbcarmor != null) {
/* 3132 */                 this.modelMain.func_78087_a(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, (Entity)par1EntityPlayer);
/* 3133 */                 this.modelMain.field_78089_u = 64;
/* 3134 */                 this.modelMain.field_78090_t = 128;
/* 3135 */                 this.modelMain.LA.func_78785_a(0.0625F);
/*      */               } else {
/*      */                 
/* 3138 */                 this.modelMain.func_78087_a(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, (Entity)par1EntityPlayer);
/* 3139 */                 this.modelMain.LA.func_78785_a(0.0625F);
/*      */               } 
/* 3141 */               GL11.glPopMatrix();
/*      */             } 
/*      */           }
/*      */ 
/*      */ 
/*      */           
/* 3147 */           GL11.glPopMatrix();
/*      */         }
/*      */       
/*      */       }
/*      */     
/*      */     }
/*      */     else {
/*      */       
/* 3155 */       this.modelMain.func_78087_a(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, (Entity)par1EntityPlayer);
/* 3156 */       this.modelMain.RA.func_78785_a(0.0625F);
/*      */     } 
/* 3158 */     GL11.glPopMatrix();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void func_85093_e(EntityLivingBase par1EntityLivingBase, float par2) {
/* 3165 */     int i = par1EntityLivingBase.func_85035_bI();
/*      */     
/* 3167 */     if (i > 0) {
/*      */       
/* 3169 */       EntityArrow entityarrow = new EntityArrow(par1EntityLivingBase.field_70170_p, par1EntityLivingBase.field_70165_t, par1EntityLivingBase.field_70163_u, par1EntityLivingBase.field_70161_v);
/* 3170 */       Random random = new Random(par1EntityLivingBase.func_145782_y());
/* 3171 */       RenderHelper.func_74518_a();
/*      */       
/* 3173 */       for (int j = 0; j < i; j++) {
/*      */         
/* 3175 */         GL11.glPushMatrix();
/* 3176 */         ModelRenderer modelrenderer = this.modelMain.func_85181_a(random);
/* 3177 */         ModelBox modelbox = modelrenderer.field_78804_l.get(random.nextInt(modelrenderer.field_78804_l.size()));
/* 3178 */         modelrenderer.func_78794_c(0.0625F);
/* 3179 */         float f1 = random.nextFloat();
/* 3180 */         float f2 = random.nextFloat();
/* 3181 */         float f3 = random.nextFloat();
/* 3182 */         float f4 = (modelbox.field_78252_a + (modelbox.field_78248_d - modelbox.field_78252_a) * f1) / 16.0F;
/* 3183 */         float f5 = (modelbox.field_78250_b + (modelbox.field_78249_e - modelbox.field_78250_b) * f2) / 16.0F;
/* 3184 */         float f6 = (modelbox.field_78251_c + (modelbox.field_78246_f - modelbox.field_78251_c) * f3) / 16.0F;
/* 3185 */         GL11.glTranslatef(f4, f5, f6);
/* 3186 */         f1 = f1 * 2.0F - 1.0F;
/* 3187 */         f2 = f2 * 2.0F - 1.0F;
/* 3188 */         f3 = f3 * 2.0F - 1.0F;
/* 3189 */         f1 *= -1.0F;
/* 3190 */         f2 *= -1.0F;
/* 3191 */         f3 *= -1.0F;
/* 3192 */         float f7 = MathHelper.func_76129_c(f1 * f1 + f3 * f3);
/* 3193 */         entityarrow.field_70126_B = entityarrow.field_70177_z = (float)(Math.atan2(f1, f3) * 180.0D / Math.PI);
/* 3194 */         entityarrow.field_70127_C = entityarrow.field_70125_A = (float)(Math.atan2(f2, f7) * 180.0D / Math.PI);
/* 3195 */         double d0 = 0.0D;
/* 3196 */         double d1 = 0.0D;
/* 3197 */         double d2 = 0.0D;
/* 3198 */         float f8 = 0.0F;
/*      */         
/* 3200 */         GL11.glPopMatrix();
/*      */       } 
/*      */       
/* 3203 */       RenderHelper.func_74519_b();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void func_77033_b(EntityLivingBase p_77033_1_, double p_77033_2_, double p_77033_4_, double p_77033_6_) {
/* 3212 */     if (MinecraftForge.EVENT_BUS.post((Event)new RenderLivingEvent.Specials.Pre(p_77033_1_, (RendererLivingEntity)this, p_77033_2_, p_77033_4_, p_77033_6_)))
/* 3213 */       return;  GL11.glAlphaFunc(516, 0.1F);
/*      */     
/* 3215 */     if (func_110813_b(p_77033_1_)) {
/*      */       
/* 3217 */       float f = 1.6F;
/* 3218 */       float f1 = 0.016666668F * f;
/* 3219 */       double d3 = p_77033_1_.func_70068_e((Entity)this.field_76990_c.field_78734_h);
/* 3220 */       float f2 = p_77033_1_.func_70093_af() ? NAME_TAG_RANGE_SNEAK : NAME_TAG_RANGE;
/*      */       
/* 3222 */       if (d3 < (f2 * f2)) {
/*      */         
/* 3224 */         String s = p_77033_1_.func_145748_c_().func_150254_d();
/* 3225 */         if (JRMCoreH.JFC() && 
/* 3226 */           JRMCoreH.plyrs != null && FamilyCH.famNams != null && FamilyCH.famNams.length >= JRMCoreH.plyrs.length)
/* 3227 */           for (int pl = 0; pl < JRMCoreH.plyrs.length; pl++) {
/* 3228 */             if (JRMCoreH.plyrs[pl].equals(p_77033_1_.func_70005_c_()) && FamilyCH.famNams[pl].length() > 2) {
/* 3229 */               String s1 = FamilyCH.famNams[pl];
/* 3230 */               String[] s2 = s1.contains(",") ? s1.toString().split(",") : null;
/* 3231 */               if (s2 != null) { int i = Integer.parseInt(s2[1]);
/* 3232 */                 s = ((i == 0) ? (s2[0] + " ") : "") + s + ((i == 1) ? (" " + s2[0]) : ""); } 
/*      */             } 
/* 3234 */           }   if (JRMCoreH.DBC()) {
/* 3235 */           String[] d18 = JRMCoreH.data(p_77033_1_.func_70005_c_(), 18, "0;0;0;0;0;0;0;0;0").split(";");
/* 3236 */           String[] fuse = d18[2].split(",");
/* 3237 */           if (fuse.length == 3 && (fuse[0].equalsIgnoreCase(p_77033_1_.func_70005_c_()) || fuse[1].equalsIgnoreCase(p_77033_1_.func_70005_c_())))
/* 3238 */             s = JRMCoreHDBC.f_namgen(fuse[0], fuse[1]); 
/* 3239 */           if (p_77033_1_ instanceof EntityPlayer && JRMCoreH.StusEfctsClient(11, (EntityPlayer)p_77033_1_))
/* 3240 */             s = ""; 
/*      */         } 
/* 3242 */         if (s.length() > 0)
/*      */         {
/* 3244 */           if (p_77033_1_.func_70093_af()) {
/*      */             
/* 3246 */             FontRenderer fontrenderer = func_76983_a();
/* 3247 */             GL11.glPushMatrix();
/* 3248 */             GL11.glTranslatef((float)p_77033_2_ + 0.0F, (float)p_77033_4_ + p_77033_1_.field_70131_O + 0.5F, (float)p_77033_6_);
/* 3249 */             GL11.glNormal3f(0.0F, 1.0F, 0.0F);
/* 3250 */             GL11.glRotatef(-this.field_76990_c.field_78735_i, 0.0F, 1.0F, 0.0F);
/* 3251 */             GL11.glRotatef(this.field_76990_c.field_78732_j, 1.0F, 0.0F, 0.0F);
/* 3252 */             GL11.glScalef(-f1, -f1, f1);
/* 3253 */             GL11.glDisable(2896);
/* 3254 */             GL11.glTranslatef(0.0F, 0.25F / f1, 0.0F);
/* 3255 */             GL11.glDepthMask(false);
/* 3256 */             GL11.glEnable(3042);
/* 3257 */             OpenGlHelper.func_148821_a(770, 771, 1, 0);
/* 3258 */             Tessellator tessellator = Tessellator.field_78398_a;
/* 3259 */             GL11.glDisable(3553);
/* 3260 */             tessellator.func_78382_b();
/* 3261 */             int i = fontrenderer.func_78256_a(s) / 2;
/* 3262 */             tessellator.func_78369_a(0.0F, 0.0F, 0.0F, 0.25F);
/* 3263 */             tessellator.func_78377_a((-i - 1), -1.0D, 0.0D);
/* 3264 */             tessellator.func_78377_a((-i - 1), 8.0D, 0.0D);
/* 3265 */             tessellator.func_78377_a((i + 1), 8.0D, 0.0D);
/* 3266 */             tessellator.func_78377_a((i + 1), -1.0D, 0.0D);
/* 3267 */             tessellator.func_78381_a();
/* 3268 */             GL11.glEnable(3553);
/* 3269 */             GL11.glDepthMask(true);
/* 3270 */             fontrenderer.func_78276_b(s, -fontrenderer.func_78256_a(s) / 2, 0, 553648127);
/* 3271 */             GL11.glEnable(2896);
/* 3272 */             GL11.glDisable(3042);
/* 3273 */             GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 3274 */             GL11.glPopMatrix();
/*      */           }
/*      */           else {
/*      */             
/* 3278 */             func_96449_a(p_77033_1_, p_77033_2_, p_77033_4_, p_77033_6_, s, f1, d3);
/*      */           } 
/*      */         }
/*      */       } 
/*      */     } 
/* 3283 */     MinecraftForge.EVENT_BUS.post((Event)new RenderLivingEvent.Specials.Post(p_77033_1_, (RendererLivingEntity)this, p_77033_2_, p_77033_4_, p_77033_6_));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void func_77039_a(AbstractClientPlayer p_77039_1_, double p_77039_2_, double p_77039_4_, double p_77039_6_) {
/* 3291 */     if (p_77039_1_.func_70089_S() && p_77039_1_.func_70608_bn()) {
/*      */       
/* 3293 */       super.func_77039_a(p_77039_1_, p_77039_2_ + p_77039_1_.field_71079_bU, p_77039_4_ + p_77039_1_.field_71082_cx, p_77039_6_ + p_77039_1_.field_71089_bV);
/*      */     }
/*      */     else {
/*      */       
/* 3297 */       super.func_77039_a(p_77039_1_, p_77039_2_, p_77039_4_, p_77039_6_);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   protected void func_77043_a(AbstractClientPlayer p_77043_1_, float p_77043_2_, float p_77043_3_, float p_77043_4_) {
/* 3303 */     if (p_77043_1_.func_70089_S() && p_77043_1_.func_70608_bn()) {
/*      */       
/* 3305 */       GL11.glRotatef(p_77043_1_.func_71051_bG(), 0.0F, 1.0F, 0.0F);
/* 3306 */       GL11.glRotatef(func_77037_a((EntityLivingBase)p_77043_1_), 0.0F, 0.0F, 1.0F);
/* 3307 */       GL11.glRotatef(270.0F, 0.0F, 1.0F, 0.0F);
/*      */     }
/*      */     else {
/*      */       
/* 3311 */       super.func_77043_a(p_77043_1_, p_77043_2_, p_77043_3_, p_77043_4_);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   protected void func_96449_a(EntityLivingBase p_96449_1_, double p_96449_2_, double p_96449_4_, double p_96449_6_, String p_96449_8_, float p_96449_9_, double p_96449_10_) {
/* 3317 */     func_96449_a((AbstractClientPlayer)p_96449_1_, p_96449_2_, p_96449_4_, p_96449_6_, p_96449_8_, p_96449_9_, p_96449_10_);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void func_77041_b(EntityLivingBase p_77041_1_, float p_77041_2_) {
/* 3326 */     func_77041_b((AbstractClientPlayer)p_77041_1_, p_77041_2_);
/*      */   }
/*      */ 
/*      */   
/*      */   protected void func_82408_c(EntityLivingBase p_82408_1_, int p_82408_2_, float p_82408_3_) {
/* 3331 */     func_82408_c((AbstractClientPlayer)p_82408_1_, p_82408_2_, p_82408_3_);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected int func_77032_a(EntityLivingBase p_77032_1_, int p_77032_2_, float p_77032_3_) {
/* 3339 */     return func_77032_a((AbstractClientPlayer)p_77032_1_, p_77032_2_, p_77032_3_);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected void func_77029_c(EntityLivingBase p_77029_1_, float p_77029_2_) {
/* 3345 */     func_77029_c((AbstractClientPlayer)p_77029_1_, p_77029_2_);
/*      */   }
/*      */ 
/*      */   
/*      */   protected void func_77043_a(EntityLivingBase p_77043_1_, float p_77043_2_, float p_77043_3_, float p_77043_4_) {
/* 3350 */     func_77043_a((AbstractClientPlayer)p_77043_1_, p_77043_2_, p_77043_3_, p_77043_4_);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void func_77039_a(EntityLivingBase p_77039_1_, double p_77039_2_, double p_77039_4_, double p_77039_6_) {
/* 3358 */     func_77039_a((AbstractClientPlayer)p_77039_1_, p_77039_2_, p_77039_4_, p_77039_6_);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_76986_a(EntityLivingBase p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
/* 3369 */     func_76986_a((AbstractClientPlayer)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected ResourceLocation func_110775_a(Entity p_110775_1_) {
/* 3377 */     return func_110775_a((AbstractClientPlayer)p_110775_1_);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
/* 3388 */     func_76986_a((AbstractClientPlayer)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
/*      */   }
/*      */   
/*      */   public int getState(String pl) {
/* 3392 */     return (state.get(pl) == null) ? 0 : ((Integer)state.get(pl)).intValue();
/*      */   }
/*      */   public void setState(int state, String pl) {
/* 3395 */     this; RenderPlayerJBRA.state.put(pl, Integer.valueOf(state));
/*      */   }
/*      */   public int getStateChange(String pl) {
/* 3398 */     return (stateChange.get(pl) == null) ? 0 : ((Integer)stateChange.get(pl)).intValue();
/*      */   }
/*      */   public void setStateChange(int stateChange, String pl) {
/* 3401 */     this; RenderPlayerJBRA.stateChange.put(pl, Integer.valueOf(stateChange));
/*      */   }
/*      */   public int getState2Change(String pl) {
/* 3404 */     return (state2Change.get(pl) == null) ? 0 : ((Integer)state2Change.get(pl)).intValue();
/*      */   }
/*      */   public void setState2Change(int state2Change, String pl) {
/* 3407 */     this; RenderPlayerJBRA.state2Change.put(pl, Integer.valueOf(state2Change));
/*      */   }
/*      */   public int getAuratype(String pl) {
/* 3410 */     return (auratype.get(pl) == null) ? 0 : ((Integer)auratype.get(pl)).intValue();
/*      */   }
/*      */   public void setAuratype(int auratype, String pl) {
/* 3413 */     this; RenderPlayerJBRA.auratype.put(pl, Integer.valueOf(auratype));
/*      */   }
/*      */   public int getAuratime(String pl) {
/* 3416 */     return (auratime.get(pl) == null) ? 0 : ((Integer)auratime.get(pl)).intValue();
/*      */   }
/*      */   public void setAuratime(int auratime, String pl) {
/* 3419 */     this; RenderPlayerJBRA.auratime.put(pl, Integer.valueOf(auratime));
/*      */   }
/*      */   public int getBendtime(String pl) {
/* 3422 */     return (bendtime.get(pl) == null) ? 0 : ((Integer)bendtime.get(pl)).intValue();
/*      */   }
/*      */   public void setBendtime(int bendtime, String pl) {
/* 3425 */     this; RenderPlayerJBRA.bendtime.put(pl, Integer.valueOf(bendtime));
/*      */   }
/*      */   private static boolean kk2 = false;
/* 3428 */   public static int kk = 0;
/* 3429 */   public static float r = 0.0F, g = 0.0F, b = 0.0F;
/* 3430 */   public static float r2 = 0.0F, g2 = 0.0F, b2 = 0.0F;
/* 3431 */   private static float getR() { return r + r2; }
/* 3432 */   private static float getG() { return g + g2; } private static float getB() {
/* 3433 */     return b + b2;
/*      */   }
/*      */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JBRA-Client-v1.6.52.jar!\JinRyuu\JBRA\RenderPlayerJBRA.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */