package tests.android.browserstackTests.drivers;

import com.codeborne.selenide.WebDriverProvider;
import lombok.SneakyThrows;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import tests.android.browserstackTests.config.BrowserstackConfig;

import javax.annotation.Nonnull;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {
        static BrowserstackConfig config = ConfigFactory.create(BrowserstackConfig.class);

        @SneakyThrows
        @Nonnull
        @Override
        public WebDriver createDriver(@Nonnull Capabilities capabilities) {

            MutableCapabilities mutableCapabilities = new MutableCapabilities();
            mutableCapabilities.merge(capabilities);

            mutableCapabilities.setCapability("app", config.appUrl());
            mutableCapabilities.setCapability("device", config.device());
            mutableCapabilities.setCapability("os_version", config.osVersion());
            mutableCapabilities.setCapability("browserstack.user", config.login());
            mutableCapabilities.setCapability("browserstack.key", config.password());
            mutableCapabilities.setCapability("project", config.projectName());
            mutableCapabilities.setCapability("build", config.buildName());
            mutableCapabilities.setCapability("name", config.testName());

            return new RemoteWebDriver(new URL(config.browserstackUrl()), mutableCapabilities);
        }
}
