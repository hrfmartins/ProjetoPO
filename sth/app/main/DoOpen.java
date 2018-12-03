package sth.app.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.*;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;
import sth.core.SchoolManager;

//FIXME import other classes if needed

/**
 * 4.1.1. Open existing document.
 */
public class DoOpen extends Command<SchoolManager> {
    Input <String> _fileoutput;

  /**
   * @param receiver
   */
  public DoOpen(SchoolManager receiver) {
    super(Label.OPEN, receiver);
    _fileoutput=_form.addStringInput(Message.openFile());
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() throws DialogException {
      _form.parse();
    try {
        _receiver.open(_fileoutput.value());

  } catch ( FileNotFoundException fnfe) {
      _display.popup(Message.fileNotFound());
    } catch (ClassNotFoundException | IOException e) {
      e.printStackTrace();
    }
  }

}
