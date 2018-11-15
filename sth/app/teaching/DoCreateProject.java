package sth.app.teaching;

import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;
import sth.core.SchoolManager;

import sth.core.exception.NoSuchDisciplineIdException;
import sth.core.exception.NoSuchProjectIdException;

/**
 * 4.4.1. Create project.
 */
public class DoCreateProject extends sth.app.common.ProjectCommand {
    private Input<String> _discipline;
    private Input<String> _name;
  /**
   * @param receiver
   */
  public DoCreateProject(SchoolManager receiver) {
    super(Label.CREATE_PROJECT, receiver);
    _discipline=_form.addStringInput(Message.requestDisciplineName());
    _name=_form.addStringInput(Message.requestProjectName());
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void myExecute() throws DialogException, NoSuchDisciplineIdException, NoSuchProjectIdException {
      _form.parse();
      try{
          _receiver.createProject(_discipline,_name);
      }catch (NoSuchPersonException e){
          _display.popup(Message.PersonNotFound());
      }finally {

      }
    //FIXME implement command
  }

}
