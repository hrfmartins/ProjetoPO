package sth.app.person;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Display;
import pt.tecnico.po.ui.Input;
import sth.core.SchoolManager;
import sth.core.exception.BadEntryException;

//FIXME import other classes if needed

/**
 * 4.2.2. Change phone number.
 */
public class DoChangePhoneNumber extends Command<SchoolManager> {
    private Input<Integer> _phoneNumber;

  //FIXME add input fields if needed


  /**
   * @param receiver
   */
  public DoChangePhoneNumber(SchoolManager receiver) {
    super(Label.CHANGE_PHONE_NUMBER, receiver);
    _phoneNumber=_form.addIntegerInput(Message.requestPhoneNumber());
    //FIXME initialize input fields if needed
  }


  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() {
    _form.parse();
    _receiver.setPhoneNumber(_phoneNumber);
  }

}
