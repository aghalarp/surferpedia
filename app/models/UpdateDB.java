package models;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * In-memory database for Update data.
 * @author Dave
 *
 */
public class UpdateDB {
  
  private static Map<Long, Update> updates = new HashMap<>();
  
  /**
   * Add update events to DB.
   * @param action The action.
   * @param surfer The surfer name.
   * @return The update object.
   */
  public static Update addUpdate(String action, String surfer) {
    Date now = new Date();
    long idVal = updates.size() + 1;
    
    Update update = new Update(idVal, DateFormat.getDateTimeInstance().format(now), action, surfer);
    
    updates.put(idVal, update);
    
    return update;
  }
  
  /**
   * Returns a list containing all Update events.
   * @return A list of Update objects.
   */
  public static List<Update> getUpdates() {
    return new ArrayList<>(updates.values());
  }
}
