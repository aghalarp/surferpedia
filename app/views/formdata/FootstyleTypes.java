package views.formdata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    Map<String, Boolean> typeMap = new HashMap<>();
    
    for (String type : types) {
      //typeMap.put(type, false);
      typeList.add(type);
    }
    
    return typeList;
  }
  
  /**
   * Returns a Map of footstyle types with the passed footstyleType set to true.
   * Assumes that footstyleType is a legal footstyle type.
   * @param footstyleType The footstyle type.
   * @return The footstyle type list.
   */
  public static List<String> getTypes(String footstyleType) {
    List<String> typeList = FootstyleTypes.getTypes();
    //First checks if footstyleType is a valid type. If it is, then sets that footstyleType to true in the Map.
    if (isType(footstyleType)) {
      typeList.add(footstyleType);
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
