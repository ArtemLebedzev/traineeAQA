package constants;

public class Constants {
    public static class ConfigVariable{
        public static final String PLATFORM_AND_BROWSER = "win_chrome";
        public static final Boolean CLEAR_COOKIES_AND_STORAGE = true;
        public static final Boolean HOLD_BROWSER_OPEN = true;
        public static final String DEFAULT_PAGE = "https://www.mts.by/";
    }

    public static class TimeoutVariable{
        public static final int IMPLICIT_WAIT = 10;
        public static final int EXPLICIT_WAIT = 10;
    }
}
