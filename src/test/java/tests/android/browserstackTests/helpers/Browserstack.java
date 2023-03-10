package tests.android.browserstackTests.helpers;

import org.aeonbits.owner.ConfigFactory;
import tests.android.browserstackTests.config.Config;

import static io.restassured.RestAssured.given;
import static java.lang.String.format;
import static tests.android.browserstackTests.helpers.CustomApiListener.withCustomTemplates;

public class Browserstack {
    static Config config = ConfigFactory.create(Config.class);

    public static String getVideoUrl(String sessionId) {

        String url = format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

        return given()
                .log().all()
                .filter(withCustomTemplates())
                .auth().basic(config.login(), config.password())
                .when()
                .get(url)
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .path("automation_session.video_url");
    }
}
