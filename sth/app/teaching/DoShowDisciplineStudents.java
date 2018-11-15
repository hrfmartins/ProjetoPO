package sth.app.teaching;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;
import sth.core.SchoolManager;

//FIXME import other classes if needed

/**
 * 4.4.4. Show course students.
 */
public class DoShowDisciplineStudents extends Command<SchoolManager> {
    private Input<String> _discipline;
  //FIXME add input fields if needed

  /**
   * @param receiver
   */
  public DoShowDisciplineStudents(SchoolManager receiver) {
    super(Label.SHOW_COURSE_STUDENTS, receiver);
    _discipline=_form.addStringInput(Message.requestDisciplineName());
    //FIXME initialize input fields if needed
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() throws DialogException,NoSuchDisciplineIdException {
      form.parse();
      try{
          String s=_receiver.showDisciplineStudents(_discipline);
      }/*catch (NoSuchPersonException | NoSuchDisciplineIdException e){
          _display.popup(Message.PersonNotFound());
      }finally {

      }
      */

    //FIXME implement command
  }

}
