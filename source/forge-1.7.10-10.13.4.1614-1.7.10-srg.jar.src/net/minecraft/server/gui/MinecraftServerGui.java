/*     */ package net.minecraft.server.gui;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import javax.swing.JComponent;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollBar;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTextArea;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.border.TitledBorder;
/*     */ import javax.swing.text.Document;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import net.minecraft.server.dedicated.DedicatedServer;
/*     */ 
/*     */ @SideOnly(Side.SERVER)
/*     */ public class MinecraftServerGui extends JComponent {
/*  18 */   private static final Font field_164249_a = new Font("Monospaced", 0, 12);
/*  19 */   private static final Logger field_164248_b = LogManager.getLogger();
/*     */   
/*     */   private DedicatedServer field_120021_b;
/*     */   
/*     */   private static final String __OBFID = "CL_00001789";
/*     */   
/*     */   public static void func_120016_a(DedicatedServer p_120016_0_) {
/*     */     try {
/*  27 */       UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
/*  28 */     } catch (Exception exception) {}
/*     */ 
/*     */     
/*  31 */     MinecraftServerGui minecraftServerGui = new MinecraftServerGui(p_120016_0_);
/*  32 */     JFrame jFrame = new JFrame("Minecraft server");
/*  33 */     jFrame.add(minecraftServerGui);
/*  34 */     jFrame.pack();
/*  35 */     jFrame.setLocationRelativeTo((Component)null);
/*  36 */     jFrame.setVisible(true);
/*  37 */     jFrame.addWindowListener(new WindowAdapter(p_120016_0_) { private static final String __OBFID = "CL_00001791";
/*     */           
/*     */           public void windowClosing(WindowEvent p_windowClosing_1_) {
/*  40 */             this.field_120023_a.func_71263_m();
/*  41 */             while (!this.field_120023_a.func_71241_aa()) {
/*     */               try {
/*  43 */                 Thread.sleep(100L);
/*  44 */               } catch (InterruptedException interruptedException) {
/*  45 */                 interruptedException.printStackTrace();
/*     */               } 
/*     */             } 
/*  48 */             System.exit(0);
/*     */           } }
/*     */       );
/*     */   }
/*     */   
/*     */   public MinecraftServerGui(DedicatedServer p_i2362_1_) {
/*  54 */     this.field_120021_b = p_i2362_1_;
/*  55 */     setPreferredSize(new Dimension(854, 480));
/*     */     
/*  57 */     setLayout(new BorderLayout());
/*     */     try {
/*  59 */       add(func_120018_d(), "Center");
/*  60 */       add(func_120019_b(), "West");
/*  61 */     } catch (Exception exception) {
/*  62 */       field_164248_b.error("Couldn't build server GUI", exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   private JComponent func_120019_b() {
/*  67 */     JPanel jPanel = new JPanel(new BorderLayout());
/*  68 */     jPanel.add(new StatsComponent((MinecraftServer)this.field_120021_b), "North");
/*  69 */     jPanel.add(func_120020_c(), "Center");
/*  70 */     jPanel.setBorder(new TitledBorder(new EtchedBorder(), "Stats"));
/*  71 */     return jPanel;
/*     */   }
/*     */   
/*     */   private JComponent func_120020_c() {
/*  75 */     PlayerListComponent playerListComponent = new PlayerListComponent((MinecraftServer)this.field_120021_b);
/*  76 */     JScrollPane jScrollPane = new JScrollPane(playerListComponent, 22, 30);
/*  77 */     jScrollPane.setBorder(new TitledBorder(new EtchedBorder(), "Players"));
/*     */     
/*  79 */     return jScrollPane;
/*     */   }
/*     */   
/*     */   private JComponent func_120018_d() {
/*  83 */     JPanel jPanel = new JPanel(new BorderLayout());
/*  84 */     JTextArea jTextArea = new JTextArea();
/*  85 */     JScrollPane jScrollPane = new JScrollPane(jTextArea, 22, 30);
/*  86 */     jTextArea.setEditable(false);
/*  87 */     jTextArea.setFont(field_164249_a);
/*     */     
/*  89 */     JTextField jTextField = new JTextField();
/*  90 */     jTextField.addActionListener(new ActionListener(this, jTextField) { private static final String __OBFID = "CL_00001790";
/*     */           
/*     */           public void actionPerformed(ActionEvent p_actionPerformed_1_) {
/*  93 */             String str = this.field_120025_a.getText().trim();
/*  94 */             if (str.length() > 0) {
/*  95 */               this.field_120024_b.field_120021_b.func_71331_a(str, (ICommandSender)MinecraftServer.func_71276_C());
/*     */             }
/*  97 */             this.field_120025_a.setText("");
/*     */           } }
/*     */       );
/*     */     
/* 101 */     jTextArea.addFocusListener(new FocusAdapter(this)
/*     */         {
/*     */           private static final String __OBFID = "CL_00001794";
/*     */           
/*     */           public void focusGained(FocusEvent p_focusGained_1_) {}
/*     */         });
/* 107 */     jPanel.add(jScrollPane, "Center");
/* 108 */     jPanel.add(jTextField, "South");
/* 109 */     jPanel.setBorder(new TitledBorder(new EtchedBorder(), "Log and chat"));
/*     */     
/* 111 */     Thread thread = new Thread(new Runnable(this, jTextArea, jScrollPane) { private static final String __OBFID = "CL_00001793";
/*     */           
/*     */           public void run() {
/*     */             String str;
/* 115 */             while ((str = QueueLogAppender.getNextLogEvent("ServerGuiConsole")) != null) {
/* 116 */               this.field_164251_c.func_164247_a(this.field_164252_a, this.field_164250_b, str);
/*     */             }
/*     */           } }
/*     */       );
/* 120 */     thread.setDaemon(true);
/* 121 */     thread.start();
/*     */     
/* 123 */     return jPanel;
/*     */   }
/*     */   
/*     */   public void func_164247_a(JTextArea p_164247_1_, JScrollPane p_164247_2_, String p_164247_3_) {
/* 127 */     if (!SwingUtilities.isEventDispatchThread()) {
/* 128 */       SwingUtilities.invokeLater(new Runnable(this, p_164247_1_, p_164247_2_, p_164247_3_) { private static final String __OBFID = "CL_00001792";
/*     */             
/*     */             public void run() {
/* 131 */               this.field_164253_d.func_164247_a(this.field_164256_a, this.field_164254_b, this.field_164255_c);
/*     */             } }
/*     */         );
/*     */       
/*     */       return;
/*     */     } 
/* 137 */     Document document = p_164247_1_.getDocument();
/* 138 */     JScrollBar jScrollBar = p_164247_2_.getVerticalScrollBar();
/* 139 */     boolean bool = false;
/*     */     
/* 141 */     if (p_164247_2_.getViewport().getView() == p_164247_1_) {
/* 142 */       bool = (jScrollBar.getValue() + jScrollBar.getSize().getHeight() + (field_164249_a.getSize() * 4) > jScrollBar.getMaximum()) ? true : false;
/*     */     }
/*     */     
/*     */     try {
/* 146 */       document.insertString(document.getLength(), p_164247_3_, null);
/* 147 */     } catch (BadLocationException badLocationException) {}
/*     */     
/* 149 */     if (bool)
/* 150 */       jScrollBar.setValue(2147483647); 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\server\gui\MinecraftServerGui.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */