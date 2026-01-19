package utils;

public class ConfigReader {
    
    private static final int DEFAULT_IMPLICIT_WAIT = 10;
    private static final int DEFAULT_EXPLICIT_WAIT = 10;
    
    public static int getImplicitWait() {
        return DEFAULT_IMPLICIT_WAIT;
    }
    
    public static int getExplicitWait() {
        return DEFAULT_EXPLICIT_WAIT;
    }
}
