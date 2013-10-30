package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import views.formdata.SurferFormData;

/**
 * A simple in-memory repository/database for Surfer data.
 * @author Dave
 *
 */
public class SurferDB {
  
  private static Map<String, Surfer> surfers = new HashMap<>();
  
  /**
   * Adds or edits a Surfer object to the database.
   * @param formData The surfer data.
   * @return The newly created surfer.
   */
  public static Surfer addSurfer(SurferFormData formData) {
    
    Surfer surfer = new Surfer(formData.slug, formData.name, formData.home, formData.awards, 
        formData.carouselImgUrl, formData.bioImgUrl, formData.biography, formData.surferType, formData.isEditable);
    
    surfers.put(formData.slug, surfer);
    
    return surfer;
  }
  
  /**
   * Checks if Surfer slug already exists.
   * @param slug The Surfer slug.
   * @return True if slug exists, False otherwise.
   */
  public static boolean slugExists(String slug) {
    if (surfers.containsKey(slug)) {
      return true;
    }
    
    return false;
  }
  
  /**
   * Returns a Surfer instance associated with the passed slug, or throws a RuntimeException if the slug is not found.
   * @param slug The slug.
   * @return The retrieved Surfer object.
   */
  public static Surfer getSurfer(String slug) {
    Surfer surfer = surfers.get(slug);
    
    if (surfer == null) {
      throw new RuntimeException("Passed an invalid slug: " + slug);
    }
    else {
      return surfer;
    }
  }
  
  /**
   * Returns a list containing all defined surfers.
   * @return A list of Surfer objects.
   */
  public static List<Surfer> getSurfers() {
    return new ArrayList<>(surfers.values());
  }
  
  /**
   * Deletes the specified slug from the surfers Map.
   * @param slug The slug to delete.
   */
  public static void deleteSurfer(String slug) {
    Surfer surfer = surfers.get(slug);
    
    if (surfer == null) {
      throw new RuntimeException("Passed an invalid slug: " + slug);
    }
    else {
      surfers.remove(slug);
      
      //Update event database.
      UpdateDB.addUpdate("Delete", getSurfer(slug).getName());
    }
  }
}
