package sth.core;

//FIXME import other classes if needed

import sth.core.exception.BadEntryException;
import sth.core.exception.NoSuchPersonIdException;

import java.io.IOException;

/**
 * School implementation.
 */
public class School implements java.io.Serializable {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201810051538L;
    private List <Course> _courses;

  //FIXME define object fields (attributes and, possibly, associations)

  //FIXME implement constructors if needed

  /**
   * @param filename
   * @throws BadEntryException
   * @throws IOException
   */
  void importFile(String filename) throws IOException, BadEntryException {
    //FIXME implement text file reader
  }

  /*package*/ Course parseCourse(String course){
    Course cs = new course(course);
    _courses.add(cs);
    }

  //FIXME implement other methods

}
