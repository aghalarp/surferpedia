import models.SurferDB;
import models.UserInfoDB;
import play.Application;
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
  public void onStart(Application app) {

    String adminEmail = Play.application().configuration().getString("admin.email");
    String adminPassword = Play.application().configuration().getString("admin.password");

    UserInfoDB.addUserInfo(UserInfoDB.ADMIN, adminEmail, adminPassword);

    if (SurferDB.getSurfers().isEmpty()) {
      SurferDB
          .addSurfer(new SurferFormData(
              "adrianodesouza",
              "Adriano De Souza",
              "Sau Paulo, Brazil",
              "Rip Curl Pro Bells Beach (2013), Rip Curl Pro Portugal (2011), Billabong Pro Rio (2011)",
              "http://tribalpoint.com.br/facecms/uploads/galeria/pj_1304093313.jpg",
              "http://dawf3zk2mt55y.cloudfront.net/wp-content/uploads/2011/01/Profile-Adriano-Desouza.jpg",
              "Adriano De Souza rode his first wave at eight years old and eight years later the surf world would take notice of this young, talented surfer at the Billabong ASP World Junior Championships...",
              "Male", true, "Regular"));
    }
  }
}
