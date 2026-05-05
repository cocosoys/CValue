/*    */ package org.bukkit.craftbukkit.v1_7_R4.command;
/*    */ 
/*    */ import java.util.Set;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.Server;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.permissions.PermissibleBase;
/*    */ import org.bukkit.permissions.Permission;
/*    */ import org.bukkit.permissions.PermissionAttachment;
/*    */ import org.bukkit.permissions.PermissionAttachmentInfo;
/*    */ import org.bukkit.permissions.ServerOperator;
/*    */ import org.bukkit.plugin.Plugin;
/*    */ 
/*    */ public abstract class ServerCommandSender implements CommandSender {
/* 15 */   private final PermissibleBase perm = new PermissibleBase((ServerOperator)this);
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isPermissionSet(String name) {
/* 21 */     return this.perm.isPermissionSet(name);
/*    */   }
/*    */   
/*    */   public boolean isPermissionSet(Permission perm) {
/* 25 */     return this.perm.isPermissionSet(perm);
/*    */   }
/*    */   
/*    */   public boolean hasPermission(String name) {
/* 29 */     return this.perm.hasPermission(name);
/*    */   }
/*    */   
/*    */   public boolean hasPermission(Permission perm) {
/* 33 */     return this.perm.hasPermission(perm);
/*    */   }
/*    */   
/*    */   public PermissionAttachment addAttachment(Plugin plugin, String name, boolean value) {
/* 37 */     return this.perm.addAttachment(plugin, name, value);
/*    */   }
/*    */   
/*    */   public PermissionAttachment addAttachment(Plugin plugin) {
/* 41 */     return this.perm.addAttachment(plugin);
/*    */   }
/*    */   
/*    */   public PermissionAttachment addAttachment(Plugin plugin, String name, boolean value, int ticks) {
/* 45 */     return this.perm.addAttachment(plugin, name, value, ticks);
/*    */   }
/*    */   
/*    */   public PermissionAttachment addAttachment(Plugin plugin, int ticks) {
/* 49 */     return this.perm.addAttachment(plugin, ticks);
/*    */   }
/*    */   
/*    */   public void removeAttachment(PermissionAttachment attachment) {
/* 53 */     this.perm.removeAttachment(attachment);
/*    */   }
/*    */   
/*    */   public void recalculatePermissions() {
/* 57 */     this.perm.recalculatePermissions();
/*    */   }
/*    */   
/*    */   public Set<PermissionAttachmentInfo> getEffectivePermissions() {
/* 61 */     return this.perm.getEffectivePermissions();
/*    */   }
/*    */   
/*    */   public boolean isPlayer() {
/* 65 */     return false;
/*    */   }
/*    */   
/*    */   public Server getServer() {
/* 69 */     return Bukkit.getServer();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\craftbukkit\v1_7_R4\command\ServerCommandSender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */