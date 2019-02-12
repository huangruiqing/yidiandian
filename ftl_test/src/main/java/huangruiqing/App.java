package huangruiqing;

import com.sun.org.apache.bcel.internal.util.ClassPath;
import freemarker.cache.FileTemplateLoader;
import freemarker.cache.TemplateLoader;
import freemarker.cache.WebappTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.Version;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * 使用freemaker 模板引擎
 */
public class App {
    static Template template = null;

    static {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_28);//这里是对应的你使用jar包的版本号：<version>2.3.23</version>
        //第二个参数 为你对应存放.ftl文件的包名
        configuration.setClassForTemplateLoading(App.class, "/freemaker/template");
        try {
            template = configuration.getTemplate("tt.ftl");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws IOException, TemplateException {


        //   String result =  processTemplateIntoString(template,null);
        System.out.println(App.class.getName());
        System.out.println(App.class.getSimpleName());
        System.out.println(App.class.getCanonicalName());
    }

    public static String processTemplateIntoString(Template template, Object model) throws IOException, TemplateException {
        StringWriter result = new StringWriter();
        template.process(model, result);
        return result.toString();
    }

}
