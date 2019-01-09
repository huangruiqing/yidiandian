package huangruiqing.Version01.service.impl;

import huangruiqing.Version01.service.IConsumer;

/**
 * @ClassName ConsumerImpl
 * @Description 消费者
 * @Author huangrq
 * @Date 2019/1/9 17:39
 */
public abstract class AbstractConsumer implements IConsumer, Runnable {

    @Override
    public void run() {
        while (true) {
            try {
                consumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
