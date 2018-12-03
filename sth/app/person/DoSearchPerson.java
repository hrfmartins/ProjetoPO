package sth.app.person;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;
import sth.core.SchoolManager;


/**
 * 4.2.4. Search person.
 */
public class DoSearchPerson extends Command<SchoolManager> {

  private Input<String> _name;

  /**
   * @param receiver
   */
  public DoSearchPerson(SchoolManager receiver) {
    super(Label.SEARCH_PERSON, receiver);
    _name=_form.addStringInput(Message.requestPersonName());
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() {
    _form.parse();
    String list_person[] = _receiver.getPersonByName(_name.value());
    if(list_person!=null){
        for(String person: list_person){
            _display.addLine(person);
        }
    }
    _display.display();

  }

}
