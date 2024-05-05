import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;


public class GitProfileTest extends BaseTest {

    private final static String URL = "https://github.com/Vladimir-Serebrennikov";

    private Map<String, Object> getExpectedAttributes() {
        return new HashMap<>(){{
            put(GitProfilePage.GENDER, "Male");
            put(GitProfilePage.POSITIVE_NUMBER_OF_REPOSITORIES, true);
            put(GitProfilePage.LOCATION_CITY, "Moscow");
            put(GitProfilePage.POSITIVE_NUMBER_OF_CONTRIBUTION, true);
        }};
    }
    @Test
    public void testCheckAttributesHashMap() throws InterruptedException {
        GitProfilePage gitProfilePage = new GitProfilePage(URL);
        Map<String, Object> expectedAttributes = getExpectedAttributes();
        Map<String, Object> actualAttributes = gitProfilePage.getActualAttributes();
        Assertions.assertEquals(expectedAttributes, actualAttributes);

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .enableLogs(io.qameta.allure.selenide.LogType.BROWSER, Level.SEVERE));
    }
    @Test
    public void testCheckAttributesClass(){
        GitProfilePage gitProfilePage = new GitProfilePage(URL);

        Profile expectedAttributes = new Profile("Male", true, "Moscow",
                true);

        Profile actualAttributes = new Profile(gitProfilePage.getGender(), gitProfilePage.getNumberOfRepositories(),
                gitProfilePage.getLocationCity(), gitProfilePage.getNumberOfContribution());

        Assertions.assertTrue(EqualsBuilder.reflectionEquals(expectedAttributes, actualAttributes));

        Assertions.assertEquals(expectedAttributes.getGender(),
                actualAttributes.getGender());
        Assertions.assertEquals(expectedAttributes.getNumberOfRepositories(),
                actualAttributes.getNumberOfRepositories());
        Assertions.assertEquals(expectedAttributes.getLocationCity(),
                actualAttributes.getLocationCity());
        Assertions.assertEquals(expectedAttributes.getNumberOfContribution(),
                actualAttributes.getNumberOfContribution());
        Assertions.assertEquals(expectedAttributes.getReadyToRelocate(),
                actualAttributes.getReadyToRelocate());

    }

}