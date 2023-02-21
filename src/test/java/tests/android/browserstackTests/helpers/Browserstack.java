package tests.android.browserstackTests.helpers;

import static io.restassured.RestAssured.given;
import static java.lang.String.format;
import static tests.android.browserstackTests.helpers.CustomApiListener.withCustomTemplates;

public class Browserstack {
    public static String getVideoUrl(String sessionId) {
        String url = format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

        return given()
                .log().all()
                .filter(withCustomTemplates())
                .auth().basic("akerkekalibekova_hF0PYC", "wqWPhAJyRLLhCYHyqrMV")
                .when()
                .get(url)
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .path("automation_session.video_url");
    }
}
