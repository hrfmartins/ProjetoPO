package sth.app.teaching;

import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;
import sth.core.SchoolManager;
import sth.app.exception.NoSuchDisciplineException;
import sth.app.exception.NoSuchProjectException;
import sth.core.exception.NoSuchProjectIdException;
import sth.core.exception.NoSuchDisciplineIdException;

/**
 * 4.4.2. Close project.
 */
public class DoCloseProject extends sth.app.common.ProjectCommand {
    private Input<String> _discipline;
    private Input<String> _name;
  /**
   * @param receiver
   */
  public DoCloseProject(SchoolManager receiver) {
    super(Label.CLOSE_PROJECT, receiver);
    _discipline=_form.addStringInput(Message.requestDisciplineName());
    _name=_form.addStringInput(Message.requestProjectName());
  }

  /** @see sth.app.common.ProjectCommand#myExecute() */
  @Override
  public final void myExecute() throws DialogException, NoSuchDisciplineIdException, NoSuchProjectIdException {
      _receiver.closeProject(_discipline,_name);
  }


  public final void execute() throws DialogException {
    _form.parse();

    try {
      myExecute();
  } catch (NoSuchProjectIdException nsp) {
      throw new NoSuchProjectException(_discipline,_name);
  } catch (NoSuchDisciplineIdException nsd) {
      throw new NoSuchDisciplineException(_discipline);
    }
  }

 }
