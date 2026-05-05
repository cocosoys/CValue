/*     */ package net.minecraftforge.event.world;
/*     */ 
/*     */ import com.google.common.base.Preconditions;
/*     */ import cpw.mods.fml.common.eventhandler.Cancelable;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class NoteBlockEvent
/*     */   extends BlockEvent
/*     */ {
/*     */   private int noteId;
/*     */   
/*     */   NoteBlockEvent(World world, int x, int y, int z, int meta, int note) {
/*  22 */     super(x, y, z, world, Blocks.noteblock, meta);
/*  23 */     this.noteId = note;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Note getNote() {
/*  32 */     return Note.fromId(this.noteId);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Octave getOctave() {
/*  41 */     return Octave.fromId(this.noteId);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getVanillaNoteId() {
/*  50 */     return this.noteId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNote(Note note, Octave octave) {
/*  61 */     Preconditions.checkArgument((octave != Octave.HIGH || note == Note.F_SHARP), "Octave.HIGH is only valid for Note.F_SHARP!");
/*  62 */     this.noteId = note.ordinal() + octave.ordinal() * 12;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Cancelable
/*     */   public static class Play
/*     */     extends NoteBlockEvent
/*     */   {
/*     */     public NoteBlockEvent.Instrument instrument;
/*     */ 
/*     */ 
/*     */     
/*     */     public Play(World world, int x, int y, int z, int meta, int note, int instrument) {
/*  76 */       super(world, x, y, z, meta, note);
/*  77 */       this.instrument = NoteBlockEvent.Instrument.fromId(instrument);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Cancelable
/*     */   public static class Change
/*     */     extends NoteBlockEvent
/*     */   {
/*     */     public final NoteBlockEvent.Note oldNote;
/*     */     
/*     */     public final NoteBlockEvent.Octave oldOctave;
/*     */ 
/*     */     
/*     */     public Change(World world, int x, int y, int z, int meta, int oldNote, int newNote) {
/*  93 */       super(world, x, y, z, meta, newNote);
/*  94 */       this.oldNote = NoteBlockEvent.Note.fromId(oldNote);
/*  95 */       this.oldOctave = NoteBlockEvent.Octave.fromId(oldNote);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public enum Instrument
/*     */   {
/* 105 */     PIANO,
/* 106 */     BASSDRUM,
/* 107 */     SNARE,
/* 108 */     CLICKS,
/* 109 */     BASSGUITAR;
/*     */ 
/*     */     
/* 112 */     private static final Instrument[] values = values();
/*     */ 
/*     */     
/*     */     static Instrument fromId(int id) {
/* 116 */       return (id < 0 || id > 4) ? PIANO : values[id];
/*     */     }
/*     */ 
/*     */     
/*     */     static {
/*     */     
/*     */     }
/*     */   }
/*     */   
/*     */   public enum Note
/*     */   {
/* 127 */     F_SHARP,
/* 128 */     G,
/* 129 */     G_SHARP,
/* 130 */     A,
/* 131 */     A_SHARP,
/* 132 */     B,
/* 133 */     C,
/* 134 */     C_SHARP,
/* 135 */     D,
/* 136 */     D_SHARP,
/* 137 */     E,
/* 138 */     F;
/*     */     
/* 140 */     private static final Note[] values = values();
/*     */ 
/*     */     
/*     */     static Note fromId(int id) {
/* 144 */       return values[id % 12];
/*     */     }
/*     */ 
/*     */     
/*     */     static {
/*     */     
/*     */     }
/*     */   }
/*     */   
/*     */   public enum Octave
/*     */   {
/* 155 */     LOW,
/* 156 */     MID,
/* 157 */     HIGH;
/*     */ 
/*     */     
/*     */     static Octave fromId(int id) {
/* 161 */       return (id < 12) ? LOW : ((id == 24) ? HIGH : MID);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\event\world\NoteBlockEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */