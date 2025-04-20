package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ChromeProfileManager {

    /**
     * Launch Chrome with a specific profile and extra config.
     *
     * @param profileName e.g., "Default", "Profile 2"
     * @param headless    run headless if true
     * @return WebDriver
     */
    public static WebDriver getDriverWithProfile(String profileName, boolean headless) {
        ChromeOptions options = new ChromeOptions();

        // Path to Chrome user data
        String userDataDir = Paths.get(System.getProperty("user.home"),
                "AppData", "Local", "Google", "Chrome", "User Data").toString();

        // Create a unique directory for each test run to avoid conflicts
        String uniqueUserDataDir = userDataDir + "_" + UUID.randomUUID().toString();

        options.addArguments("user-data-dir=" + uniqueUserDataDir); // Unique directory for each session
        options.addArguments("profile-directory=" + profileName);

        // Disable detection
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);

        // Optional headless mode
        if (headless) {
            options.addArguments("--headless=new");
            options.addArguments("--window-size=1920,1080");
        }

        // Prevent "Chrome is being controlled" message
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);

        return new ChromeDriver(options);
    }
    
        public static ChromeOptions getOptionsForCI() {
            ChromeOptions options = new ChromeOptions();

            // Required for CI (random temp profile)
            String tmpProfilePath = System.getProperty("java.io.tmpdir") + "/chrome-profile-" + UUID.randomUUID();
            options.addArguments("--user-data-dir=" + tmpProfilePath);
            
            boolean isCI = System.getenv("CI") != null;

            if (isCI) {
                // Use temp profile (as above)
            } else {
                // Use local user-data-dir
                options.addArguments("--user-data-dir=C:/Users/R M/ChromeProfile");
            }
            
            

            options.addArguments("--disable-blink-features=AutomationControlled");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--headless=new"); // headless mode for CI
            options.addArguments("--disable-gpu");
            options.addArguments("--window-size=1920,1080");

            options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
            options.setExperimentalOption("useAutomationExtension", false);

            // Disable password save prompts
            options.setExperimentalOption("prefs", java.util.Map.of(
                "credentials_enable_service", false,
                "profile.password_manager_enabled", false
            ));

            return options;
        }


}
