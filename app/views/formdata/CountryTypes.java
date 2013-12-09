package views.formdata;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import models.Surfer;

/**
 * Represents the legal country types.
 * @author Dave
 *
 */
public class CountryTypes {
  
  /**
   * Returns a newly initialized List of country types.
   * @return The country type list.
   */
  public static List<String> getTypes() {
    List<Surfer> surfers = Surfer.find().all();
    Set<String> countryTypesSet = new HashSet<>();
    
    //Iterate through list of surfers, grab unique country names.
    for (Surfer surfer : surfers) {
      countryTypesSet.add(surfer.getCountry());
    }
    
    //Then convert set to list.
    List<String> countryTypesList = new ArrayList<>(countryTypesSet);
    
    return countryTypesList;
  }
  
  /**
   * Returns true if given country exists in database.
   * @param country The country to lookup.
   * @return True if country exists, false otherwise.
   */
  public static boolean isType(String country) {
    return CountryTypes.getTypes().contains(country);
  }
}
