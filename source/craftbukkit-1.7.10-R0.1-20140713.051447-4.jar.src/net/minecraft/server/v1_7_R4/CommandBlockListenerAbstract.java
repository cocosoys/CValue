/*     */ package net.minecraft.server.v1_7_R4;
/*     */ 
/*     */ import com.google.common.base.Joiner;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Date;
/*     */ import org.apache.logging.log4j.Level;
/*     */ import org.bukkit.command.Command;
/*     */ import org.bukkit.command.CommandSender;
/*     */ import org.bukkit.command.SimpleCommandMap;
/*     */ import org.bukkit.craftbukkit.v1_7_R4.command.VanillaCommandWrapper;
/*     */ 
/*     */ public abstract class CommandBlockListenerAbstract implements ICommandListener {
/*  15 */   private static final SimpleDateFormat a = new SimpleDateFormat("HH:mm:ss");
/*     */   private int b;
/*     */   private boolean c = true;
/*  18 */   private IChatBaseComponent d = null;
/*  19 */   public String e = "";
/*  20 */   private String f = "@";
/*     */   
/*     */   protected CommandSender sender;
/*     */ 
/*     */   
/*     */   public int g() {
/*  26 */     return this.b;
/*     */   }
/*     */   
/*     */   public IChatBaseComponent h() {
/*  30 */     return this.d;
/*     */   }
/*     */   
/*     */   public void a(NBTTagCompound nbttagcompound) {
/*  34 */     nbttagcompound.setString("Command", this.e);
/*  35 */     nbttagcompound.setInt("SuccessCount", this.b);
/*  36 */     nbttagcompound.setString("CustomName", this.f);
/*  37 */     if (this.d != null) {
/*  38 */       nbttagcompound.setString("LastOutput", ChatSerializer.a(this.d));
/*     */     }
/*     */     
/*  41 */     nbttagcompound.setBoolean("TrackOutput", this.c);
/*     */   }
/*     */   
/*     */   public void b(NBTTagCompound nbttagcompound) {
/*  45 */     this.e = nbttagcompound.getString("Command");
/*  46 */     this.b = nbttagcompound.getInt("SuccessCount");
/*  47 */     if (nbttagcompound.hasKeyOfType("CustomName", 8)) {
/*  48 */       this.f = nbttagcompound.getString("CustomName");
/*     */     }
/*     */     
/*  51 */     if (nbttagcompound.hasKeyOfType("LastOutput", 8)) {
/*  52 */       this.d = ChatSerializer.a(nbttagcompound.getString("LastOutput"));
/*     */     }
/*     */     
/*  55 */     if (nbttagcompound.hasKeyOfType("TrackOutput", 1)) {
/*  56 */       this.c = nbttagcompound.getBoolean("TrackOutput");
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean a(int i, String s) {
/*  61 */     return (i <= 2);
/*     */   }
/*     */   
/*     */   public void setCommand(String s) {
/*  65 */     this.e = s;
/*     */   }
/*     */   
/*     */   public String getCommand() {
/*  69 */     return this.e;
/*     */   }
/*     */   
/*     */   public void a(World world) {
/*  73 */     if (world.isStatic) {
/*  74 */       this.b = 0;
/*     */     }
/*     */     
/*  77 */     MinecraftServer minecraftserver = MinecraftServer.getServer();
/*     */     
/*  79 */     if (minecraftserver != null && minecraftserver.getEnableCommandBlock()) {
/*     */       
/*  81 */       SimpleCommandMap commandMap = minecraftserver.server.getCommandMap();
/*  82 */       Joiner joiner = Joiner.on(" ");
/*  83 */       String command = this.e;
/*  84 */       if (this.e.startsWith("/")) {
/*  85 */         command = this.e.substring(1);
/*     */       }
/*  87 */       String[] args = command.split(" ");
/*  88 */       ArrayList<String[]> commands = (ArrayList)new ArrayList<String>();
/*     */ 
/*     */       
/*  91 */       if (args[0].equalsIgnoreCase("stop") || args[0].equalsIgnoreCase("kick") || args[0].equalsIgnoreCase("op") || args[0].equalsIgnoreCase("deop") || args[0].equalsIgnoreCase("ban") || args[0].equalsIgnoreCase("ban-ip") || args[0].equalsIgnoreCase("pardon") || args[0].equalsIgnoreCase("pardon-ip") || args[0].equalsIgnoreCase("reload")) {
/*     */ 
/*     */         
/*  94 */         this.b = 0;
/*     */         
/*     */         return;
/*     */       } 
/*     */       
/*  99 */       if ((getWorld()).players.isEmpty()) {
/* 100 */         this.b = 0;
/*     */         
/*     */         return;
/*     */       } 
/*     */       
/* 105 */       if (minecraftserver.server.getCommandBlockOverride(args[0])) {
/* 106 */         Command commandBlockCommand = commandMap.getCommand("minecraft:" + args[0]);
/* 107 */         if (commandBlockCommand instanceof VanillaCommandWrapper) {
/* 108 */           this.b = ((VanillaCommandWrapper)commandBlockCommand).dispatchVanillaCommandBlock(this, this.e);
/*     */           
/*     */           return;
/*     */         } 
/*     */       } 
/*     */       
/* 114 */       if (commandMap.getCommand(args[0]) == null) {
/* 115 */         this.b = 0;
/*     */         
/*     */         return;
/*     */       } 
/*     */       
/* 120 */       if (args[0].equalsIgnoreCase("testfor")) {
/* 121 */         if (args.length < 2) {
/* 122 */           this.b = 0;
/*     */           
/*     */           return;
/*     */         } 
/* 126 */         EntityPlayer[] players = PlayerSelector.getPlayers(this, args[1]);
/*     */         
/* 128 */         if (players != null && players.length > 0) {
/* 129 */           this.b = players.length;
/*     */           return;
/*     */         } 
/* 132 */         EntityPlayer player = MinecraftServer.getServer().getPlayerList().getPlayer(args[1]);
/* 133 */         if (player == null) {
/* 134 */           this.b = 0;
/*     */           return;
/*     */         } 
/* 137 */         this.b = 1;
/*     */ 
/*     */         
/*     */         return;
/*     */       } 
/*     */       
/* 143 */       commands.add(args);
/*     */ 
/*     */       
/* 146 */       ArrayList<String[]> newCommands = (ArrayList)new ArrayList<String>();
/* 147 */       for (int i = 0; i < args.length; i++) {
/* 148 */         if (PlayerSelector.isPattern(args[i])) {
/* 149 */           for (int k = 0; k < commands.size(); k++) {
/* 150 */             newCommands.addAll(buildCommands(commands.get(k), i));
/*     */           }
/* 152 */           ArrayList<String[]> temp = commands;
/* 153 */           commands = newCommands;
/* 154 */           newCommands = temp;
/* 155 */           newCommands.clear();
/*     */         } 
/*     */       } 
/*     */       
/* 159 */       int completed = 0;
/*     */ 
/*     */       
/* 162 */       for (int j = 0; j < commands.size(); j++) {
/*     */         try {
/* 164 */           if (commandMap.dispatch(this.sender, joiner.join(Arrays.asList((Object[])commands.get(j))))) {
/* 165 */             completed++;
/*     */           }
/* 167 */         } catch (Throwable exception) {
/* 168 */           if (this instanceof TileEntityCommandListener) {
/* 169 */             TileEntityCommandListener listener = (TileEntityCommandListener)this;
/* 170 */             MinecraftServer.getLogger().log(Level.WARN, String.format("CommandBlock at (%d,%d,%d) failed to handle command", new Object[] { Integer.valueOf((listener.getChunkCoordinates()).x), Integer.valueOf((listener.getChunkCoordinates()).y), Integer.valueOf((listener.getChunkCoordinates()).z) }), exception);
/* 171 */           } else if (this instanceof EntityMinecartCommandBlockListener) {
/* 172 */             EntityMinecartCommandBlockListener listener = (EntityMinecartCommandBlockListener)this;
/* 173 */             MinecraftServer.getLogger().log(Level.WARN, String.format("MinecartCommandBlock at (%d,%d,%d) failed to handle command", new Object[] { Integer.valueOf((listener.getChunkCoordinates()).x), Integer.valueOf((listener.getChunkCoordinates()).y), Integer.valueOf((listener.getChunkCoordinates()).z) }), exception);
/*     */           } else {
/* 175 */             MinecraftServer.getLogger().log(Level.WARN, String.format("Unknown CommandBlock failed to handle command", new Object[0]), exception);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 180 */       this.b = completed;
/*     */     } else {
/*     */       
/* 183 */       this.b = 0;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private ArrayList<String[]> buildCommands(String[] args, int pos) {
/* 189 */     ArrayList<String[]> commands = (ArrayList)new ArrayList<String>();
/* 190 */     EntityPlayer[] players = PlayerSelector.getPlayers(this, args[pos]);
/* 191 */     if (players != null) {
/* 192 */       for (EntityPlayer player : players) {
/* 193 */         if (player.world == getWorld()) {
/*     */ 
/*     */           
/* 196 */           String[] command = (String[])args.clone();
/* 197 */           command[pos] = player.getName();
/* 198 */           commands.add(command);
/*     */         } 
/*     */       } 
/*     */     }
/* 202 */     return commands;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getName() {
/* 207 */     return this.f;
/*     */   }
/*     */   
/*     */   public IChatBaseComponent getScoreboardDisplayName() {
/* 211 */     return new ChatComponentText(getName());
/*     */   }
/*     */   
/*     */   public void setName(String s) {
/* 215 */     this.f = s;
/*     */   }
/*     */   
/*     */   public void sendMessage(IChatBaseComponent ichatbasecomponent) {
/* 219 */     if (this.c && getWorld() != null && !(getWorld()).isStatic) {
/* 220 */       this.d = (new ChatComponentText("[" + a.format(new Date()) + "] ")).addSibling(ichatbasecomponent);
/* 221 */       e();
/*     */     } 
/*     */   }
/*     */   
/*     */   public abstract void e();
/*     */   
/*     */   public void b(IChatBaseComponent ichatbasecomponent) {
/* 228 */     this.d = ichatbasecomponent;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\CommandBlockListenerAbstract.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */