package utils;

import java.io.File;

public class FileHelper {
    
    public static boolean waitForFileDownload(String filePath, int timeoutSeconds) {
        File file = new File(filePath);
        int waited = 0;
        
        while (!file.exists() && waited < timeoutSeconds) {
            try {
                Thread.sleep(1000);
                waited++;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return false;
            }
        }
        return file.exists();
    }
    
    public static boolean deleteFile(String filePath) {
        File file = new File(filePath);
        return file.exists() && file.delete();
    }
}
