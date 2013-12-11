import models.SurferDB;
import models.UserInfoDB;
import controllers.Application;
import play.GlobalSettings;
import play.Play;
import views.formdata.SurferFormData;

/**
 * Provides initialization code for the Surferpedia application.
 * 
 * @author Dave
 * 
 */
public class Global extends GlobalSettings {

  /**
   * Initialize the system with some sample contacts.
   * 
   * @param app The application.
   */
  public void onStart(play.Application app) {

    Application.adminEmail = Play.application().configuration().getString("admin.email");
    Application.adminPassword = Play.application().configuration().getString("admin.password");

    if (Application.adminEmail == null) {
      System.err.println("The admin email environmental variable was not set correctly.");
    }
    if (Application.adminPassword == null) {
      System.err.println("The admin password environmental variable was not set correctly.");
    }

    UserInfoDB.addUserInfo(UserInfoDB.ADMIN, Application.adminEmail, Application.adminPassword);

    if (SurferDB.getSurfers().isEmpty()) {
      // Males
      SurferDB
          .addSurfer(new SurferFormData(
              "adrianodesouza",
              "Adriano De Souza",
              "Sau Paulo, Brazil",
              "Rip Curl Pro Bells Beach (2013), Rip Curl Pro Portugal (2011), Billabong Pro Rio (2011)",
              "http://tribalpoint.com.br/facecms/uploads/galeria/pj_1304093313.jpg",
              "http://dawf3zk2mt55y.cloudfront.net/wp-content/uploads/2011/01/Profile-Adriano-Desouza.jpg",
              "Adriano De Souza rode his first wave at eight years old and eight years later the surf world would take notice of this young, talented surfer at the Billabong ASP World Junior Championships...",
              "Male", true, "Regular", "Brazil"));
      SurferDB
          .addSurfer(new SurferFormData(
              "cjhoood",
              "CJ Hobgood",
              "Melbourne, Florida",
              "2007 US Open of Surfing",
              "http://www.lat34.org/quick_hits/wp-content/uploads/2008/10/hobgood_cj8331mundaka08cestari_l.jpg",
              "http://image.surfingmagazine.com/f/news/surfing-profiles/31364595+w545+st0/2006-cj-hobgood-lrg.jpg",
              "C.J. entered his first surfing contest in 1989 and made the Open Boys final. He placed second in a national competition the following year.",
              "Male", true, "Goofy", "USA"));
      // Females
      SurferDB
          .addSurfer(new SurferFormData(
              "meganabubo",
              "Megan Abubo",
              "Hartford, Connecticut",
              "2004 WCT Rip Curl Malibu Pro",
              "http://www.lat34.com/_/Photo/_/megan_abubo05hornbaker.jpg",
              "http://farm3.static.flickr.com/2120/2037051178_13ee5c327f.jpg",
              "Growing up in Hawaii, Megan quickly became one of the 'beach boys' and worked her way to a spot on the World Championship Tour ranks in 1998. She has been on the WCT ever since and in 2000 she was runner up for the world title.",
              "Female", true, "Regular", "USA"));
      SurferDB
          .addSurfer(new SurferFormData(
              "serenabrooke",
              "Serena Brooke",
              "Coolangatta Queensland, Australia",
              "Billabong Pro Australia, 1995 Women's Rookie of the Year",
              "http://3.bp.blogspot.com/-ayVU8U4xE_w/T9-cGiDXA3I/AAAAAAAABgo/phpoxj3jlh4/s1600/serenaIndo3.jpg",
              "http://www.news.saltwater-dreaming.com/modules/xcgal/albums/ASP/serena-brooke.jpg",
              "Brooke began to compete in amateur competitions in 1990 where she was crowned the Queensland amateur surfing title as well as the Australian National Title.",
              "Female", true, "Goofy", "Australia"));
      // Groms
      SurferDB
          .addSurfer(new SurferFormData(
              "elliotivarra",
              "Elliot Ivarra",
              "Saint Barthelemy",
              "Quiksilver King of the Groms",
              "http://farm9.staticflickr.com/8177/8071333879_f8f9567017_b.jpg",
              "http://static.quiksilver-europe.com/www/quiksilverlive.com/html/upload/kotg2012/riders/__ID-33--5-elliotivarra.jpg",
              "Elliot Ivarra, 16, was born in Saint Martin, but lives in Saint Barthelemy Island. French surfer Elliot Ivarra won the European final of the Quiksilver King of the Groms in 3 feet fun waves at Ericeira, Portugal.",
              "Grom", true, "Goofy", "French West Indies"));
      SurferDB
          .addSurfer(new SurferFormData(
              "kalanidavid",
              "Kalani David",
              "Haleiwa, Hawaii",
              "2013 Rip Curl Grom Search",
              "http://www.rvca.com/media/transfer/img/tom_0941_2.jpg",
              "http://cdn.surf.transworld.net/wp-content/blogs.dir/443/files/2012/10/Kalani-David.jpg",
              "It’s unlikely old age will be kind to Kalani David. The 14-year-old Costa-Rica-born-Hawaiian-pro-skater-slash-pro-surfer is looking very uncomfortable seated across from me at a roadside eatery in Bali.",
              "Grom", true, "Regular", "USA"));
    }
  }
}
