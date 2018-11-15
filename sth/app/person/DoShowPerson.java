package sth.app.person;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Display;
import sth.core.SchoolManager;
import sth.app.person.Label;
import sth.app.person.Message;
import pt.tecnico.po.ui.Input;
import sth.app.exception.NoSuchPersonException;


//FIXME import other classes if needed

/**
 * 4.2.1. Show person.
 */
public class DoShowPerson extends Command<SchoolManager> implements Label{

  //FIXME add input fields if needed
  private Input<Integer> _id;

  /**
   * @param receiver
   */
  public DoShowPerson(SchoolManager receiver) {
    super(Label.SHOW_PERSON, receiver);
    _id=_form.addIntegerInput(_message.requestPersonId());
    //FIXME initialize input fields if needed
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() throws NoSuchPersonException {
      _form.parse();
      try {
        _display.addLine(_receiver.showPerson(id));
    } /*catch (NoSuchPersonException e) {
        throw new NoSuchPersonException(_login.value());
    }*/
  }
    //FIXME implement command
  }

}
