package huangruiqing.Version01.service;

/**
 * 生产者接口
 */
public interface IProducer {

    /**
     * 生产
     */
    void product() throws InterruptedException;

}
