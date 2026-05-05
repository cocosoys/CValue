package org.bukkit.block;

import org.bukkit.Instrument;
import org.bukkit.Note;

public interface NoteBlock extends BlockState {
  Note getNote();
  
  @Deprecated
  byte getRawNote();
  
  void setNote(Note paramNote);
  
  @Deprecated
  void setRawNote(byte paramByte);
  
  boolean play();
  
  @Deprecated
  boolean play(byte paramByte1, byte paramByte2);
  
  boolean play(Instrument paramInstrument, Note paramNote);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\block\NoteBlock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */