package huangruiqing;

import java.math.BigDecimal;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
       BigDecimal d =  new BigDecimal("1.0").setScale(2,BigDecimal.ROUND_HALF_UP);
        System.out.println(d.doubleValue());
    }
}
