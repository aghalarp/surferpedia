package views.formdata;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents the legal surfer types.
 * @author Dave
 *
 */
public class SurferTypes {
  
  private static String[] types = {"Male", "Female" , "Grom"};
  
  /**
   * Returns a newly initialized Map of surfer types.
   * @return The surfer type map.
   */
  public static Map<String, Boolean> getTypes() {
    Map<String, Boolean> typeMap = new HashMap<>();
    
    for (String type : types) {
      typeMap.put(type, false);
    }
    
    return typeMap;
  }
  
  /**
   * Returns a Map of surfer types with the passed surferType set to true.
   * Assumes that surferType is a legal surfer type.
   * @param surferType The surfer type.
   * @return The surfer type map.
   */
  public static Map<String, Boolean> getTypes(String surferType) {
    Map<String, Boolean> typeMap = SurferTypes.getTypes();
    //First checks if surferType is a valid type. If it is, then sets that surferType to true in the Map.
    if (isType(surferType)) {
      typeMap.put(surferType, true);
    }
    
    return typeMap;
  }
  
  /**
   * Returns true if surferType is a valid surfer type.
   * @param surferType The potential surfer type.
   * @return True if a valid surferType, false otherwise.
   */
  public static boolean isType(String surferType) {
    return SurferTypes.getTypes().keySet().contains(surferType);
  }
}
