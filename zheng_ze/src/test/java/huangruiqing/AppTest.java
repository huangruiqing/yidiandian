package huangruiqing;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Unit test for simple App.
 */
public class AppTest {

//############# ips ############
    /*
     *  1、 点+星号 搭配 可以匹配多个字符 （.*）
     */
//#############################
    /**
     * 测试 "."
     * . 匹配任意字符
     */
    @Test
    public void test_dian() {
        String regex = ".";//单个任意字符
        String content = "r";
      //  String content = "rr"; // false
        System.out.println(Pattern.matches(regex, content));
    }
    /**
     *  "*" 星号
     *  匹配重复多个
     */
    @Test
    public void test_star() {
        String regex = "r*";//任意字符
        String content = "r";
        System.out.println(Pattern.matches(regex, content));
    }

    /**
     *  ".*"
     *  点+星号 搭配 可以匹配多个字符
     *  例如，zo* 匹配"z"和"zoo"。* 等效于 {0,}。
     */
    @Test
    public void test_dianStar() {
        String regex = ".*";//任意字符
        String content = "fddgr";
        System.out.println(Pattern.matches(regex, content));
    }
    /**
     * ^ 次方符号
     *以 xx 开头
     */
    @Test
    public void test_CiFang() {
        String str = "hello java ,hello me . I like java";
        Matcher m = Pattern.compile("hello").matcher(str);
        while (m.find()) {
            System.out.printf("1:name:%s , 位置[%d - %d] \n", m.group(), m.start(), m.end());
        }
        System.out.println("is match hello start ? " +Pattern.compile("^hello.*").matcher("helloabc").matches());
    }

    /**
     * $
     * 以xx 结尾
     */
    @Test
    public void test_dollar() {
        String str = "hello java ,hello me . I like java";
        Matcher m2 = Pattern.compile("java$").matcher(str);
        while (m2.find()) {
            System.out.printf("2:name:%s , 位置[%d - %d] \n", m2.group(), m2.start(), m2.end());
        }
        System.out.println("is match hello end ? " +Pattern.compile(".*hello$").matcher("abchello").matches());

    }

    /**
      * "+" 数字验证
     * +重复前面匹配或子表达式
     * "zo+"与"zo"和"zoo"匹配，但与"z"不匹配。+ 等效于 {1,}
     */
    @Test
    public void test_plus() {
        String regex = "\\d+";
        String content = "123";
        System.out.println(Pattern.matches(regex, content));
    }
    /**
     *  "?" 问号
     * "零次或一次匹配前面的字符或子表达式。
     * 例如，"do(es)?"匹配"do"或"does"中的"do"。? 等效于 {0,1}。
     */
    @Test
    public void test_wenhao() {
        String regex = "do(w)?";
        String content = "do"; //true
      //  String content = "dow"; //true
     //   String content = "doww"; //false
        System.out.println(Pattern.matches(regex, content));
    }
    /**
     * "d" 数字验证
     */
    @Test
    public void test_d() {
        String regex = "\\d";
        String content = "1";
        System.out.println(Pattern.matches(regex, content));
    }

    /**
     * {n}
     * n 是非负整数。正好匹配 n 次。
     * 例如，"o{2}"与"Bob"中的"o"不匹配，但与"food"中的两个"o"匹配。
     */
    @Test
    public void test_N() {
        String regex = "\\d{2}";
        String content = "12";
        System.out.println("{n}= "+Pattern.matches(regex, content));
        String regex2 = "\\d{2,}";
        String content2 = "123";
        System.out.println("{n,}= "+Pattern.matches(regex2, content2));
    }
    /**
     * "w"
     */
    @Test
    public void test_w() {
        String EXAMPLE_TEST = "This is my small example string which I'm going to use for pattern matching.";
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(EXAMPLE_TEST);
        while (matcher.find()) {
            System.out.print("Start index: " + matcher.start());
            System.out.print(" End index: " + matcher.end() + " ");
            System.out.println("group:" + matcher.group());
        }
        Pattern replace = Pattern.compile("\\s+");
        Matcher matcher2 = replace.matcher(EXAMPLE_TEST);
        System.out.println(matcher2.replaceAll("\t"));
    }

    @Test
    public void testStr11() {
        String str = "99ABeafwe9weqr1";
        String regex = ".*r1$";
        //  String regex = "^[0-9][0-9]AB.*r1$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);
        if (m.matches()) {
            System.out.println("验证通过");
        } else {
            System.out.println("验证不通过");
        }
    }
}
