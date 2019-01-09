package huangruiqing.Version01.service.impl;

import huangruiqing.Version01.service.IProducer;

/**
 * @ClassName ProducterImpl
 * @Description //  生产者
 * @Author huangrq
 * @Date 2019/1/9 17:39
 */
public abstract class AbstractProducer implements IProducer, Runnable {

    @Override
    public void run() {
        while (true) {
            try {
                product();
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
