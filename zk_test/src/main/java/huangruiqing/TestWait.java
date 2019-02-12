package huangruiqing;

/**
 * @ClassName TestWait
 * @Description // 一句话描述这个类
 * @Author huangrq
 * @Date 2018/12/25 16:10
 */
public class TestWait {


    public static void main(String[] args) {
        System.out.println("start...");

        synchronized (TestWait.class) {
            while (true) {
                try {
                    TestWait.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }


}
