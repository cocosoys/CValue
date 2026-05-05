/*    */ package com.avaje.ebeaninternal.server.lucene.cluster;
/*    */ 
/*    */ import com.avaje.ebeaninternal.server.lucene.LIndex;
/*    */ import java.io.DataOutput;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
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
/*    */ 
/*    */ 
/*    */ public class SLuceneClient
/*    */ {
/*    */   private final String serverName;
/*    */   private final LIndex index;
/*    */   private final long localVersion;
/*    */   private long remoteVersion;
/*    */   private final SocketClient client;
/*    */   
/*    */   public SLuceneClient(String serverName, SocketClient client, long localVersion, LIndex index) {
/* 40 */     this.serverName = serverName;
/* 41 */     this.client = client;
/* 42 */     this.localVersion = localVersion;
/* 43 */     this.index = index;
/*    */   }
/*    */   
/*    */   public void setRemoteVersion(long remoteVersion) {
/* 47 */     this.remoteVersion = remoteVersion;
/*    */   }
/*    */   
/*    */   public LIndex getIndex() {
/* 51 */     return this.index;
/*    */   }
/*    */   
/*    */   public void disconnect() {
/* 55 */     this.client.disconnect();
/*    */   }
/*    */   
/*    */   public SocketClient getSocketClient() {
/* 59 */     return this.client;
/*    */   }
/*    */ 
/*    */   
/*    */   private void sendMessageHeader(short msgType, long version) throws IOException {
/* 64 */     this.client.connect();
/* 65 */     this.client.initData();
/*    */     
/* 67 */     DataOutput dataOutput = this.client.getDataOutput();
/* 68 */     dataOutput.writeUTF(this.serverName);
/* 69 */     dataOutput.writeShort(msgType);
/* 70 */     dataOutput.writeUTF(this.index.getName());
/* 71 */     dataOutput.writeLong(version);
/*    */   }
/*    */   
/*    */   private boolean sendMessageHeader2(short msgType, long version) throws IOException {
/* 75 */     sendMessageHeader(msgType, version);
/* 76 */     this.client.getOutputStream().flush();
/* 77 */     return this.client.getDataInput().readBoolean();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean sendObtainCommit() throws IOException {
/* 82 */     return sendMessageHeader2((short)2, this.localVersion);
/*    */   }
/*    */   
/*    */   public void sendRelease() throws IOException {
/* 86 */     sendMessageHeader2((short)3, this.remoteVersion);
/*    */   }
/*    */ 
/*    */   
/*    */   public InputStream sendGetFile(String fileName) throws IOException {
/* 91 */     sendMessageHeader((short)4, this.remoteVersion);
/* 92 */     this.client.getDataOutput().writeUTF(fileName);
/* 93 */     this.client.getOutputStream().flush();
/* 94 */     boolean exists = this.client.getDataInput().readBoolean();
/* 95 */     if (!exists) {
/* 96 */       return null;
/*    */     }
/* 98 */     return this.client.getInputStream();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\lucene\cluster\SLuceneClient.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */