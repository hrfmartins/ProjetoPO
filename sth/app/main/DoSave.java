package sth.app.main;

import java.io.IOException;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;
import sth.core.SchoolManager;

//FIXME import other classes if needed

/**
 * 4.1.1. Save to file under current name (if unnamed, query for name).
 */
public class DoSave extends Command<SchoolManager> {
  Input <String> _fileoutput;

  /**
   * @param receiver
   */
  public DoSave(SchoolManager receiver) {
    super(Label.SAVE, receiver);
    _fileoutput=_form.addStringInput(Message.newSaveAs());
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() {
      _form.parse();
     try{
         _receiver.save(_fileoutput.value());
     } catch(IOException ioe){
         ioe.printStackTrace();

     }catch(ClassNotFoundException cnfe){
         cnfe.printStackTrace();
     }

  }

}
