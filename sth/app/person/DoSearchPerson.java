package sth.app.person;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;
import sth.core.SchoolManager;

//FIXME import other classes if needed

/**
 * 4.2.4. Search person.
 */
public class DoSearchPerson extends Command<SchoolManager> {

  //FIXME add input fields if needed
  private Input<String> _name;

  /**
   * @param receiver
   */
  public DoSearchPerson(SchoolManager receiver) {
    super(Label.SEARCH_PERSON, receiver);
    _id=_form.addStringInput(_message.requestPersonName());
    //FIXME initialize input fields if needed
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() {
      _form.parse();
    //FIXME implement command
    try{
        String s = _receiver.getPersonByName(String s);
    } catch (NoSuchPersonException e){
        _display.popup(Message.PersonNotFound());
    } finally {
        _display.addLine(s);
    }
  }

}
