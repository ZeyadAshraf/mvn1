import java.io.FileInputStream;
import java.util.Properties;

public class loadProperties {
    public static Properties userData = LoadProperties("C:\\Users\\kalpg\\IdeaProjects\\mvn1\\src\\test\\java\\userdata.properties");
    
    private static Properties LoadProperties(String fileName) {
        Properties pro = new Properties();
        try (FileInputStream stream = new FileInputStream(fileName)) {
            pro.load(stream);
        } catch (Exception e) {
            System.out.println("Error loading properties: " + e.getMessage());
        }
        return pro;
    }
}