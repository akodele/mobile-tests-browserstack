package tests.android.browserstackTests.config;

import org.aeonbits.owner.Config;

@BrowserstackConfig.LoadPolicy(BrowserstackConfig.LoadType.MERGE)
@org.aeonbits.owner.Config.Sources(
        {"system:properties",
                "classpath:android.properties"})
public interface BrowserstackConfig extends Config {
    @Key("login")
    String login();

    @Key("password")
    String password();

    @Key("browserstackURL")
    String browserstackUrl();

    @Key("appURL")
    String appUrl();

    @Key("device")
    String device();

    @Key("os_version")
    String osVersion();

    @Key("project")
    String projectName();

    @Key("build")
    String buildName();

    @Key("name")
    String testName();
}