package views.formdata;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the legal footstyle types.
 * @author Dave
 *
 */
public class FootstyleTypes {
  
  private static String[] types = {"Regular", "Goofy"};
  
  /**
   * Returns a newly initialized List of footstyle types.
   * @return The footstyle type list.
   */
  public static List<String> getTypes() {
    List<String> typeList = new ArrayList<>();
    
    for (String type : types) {
      typeList.add(type);
    }
    
    return typeList;
  }
  
  /**
   * Returns true if footstyleType is a valid footstyle type.
   * @param footstyleType The potential footstyle type.
   * @return True if a valid footstyleType, false otherwise.
   */
  public static boolean isType(String footstyleType) {
    return FootstyleTypes.getTypes().contains(footstyleType);
  }
}
