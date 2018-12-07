package huangruiqing;

import freemarker.template.Configuration;
import freemarker.template.Version;

import java.io.IOException;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        Properties properties =  System.getProperties();
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_28);

        try {
            configuration.getTemplate("classpath:/ftl/template/welcome.ftl", Locale.CHINESE,"UTF8");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(properties.getProperty("user.dir"));
    }
}
