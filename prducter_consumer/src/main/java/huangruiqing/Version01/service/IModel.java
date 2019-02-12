package huangruiqing.Version01.service;

/**
 * @ClassName IModel
 * @Description // 不同的模型实现中，
 * 生产者、消费者的具体实现也不同，所以需要为模型定义抽象工厂方法
 * @Author huangrq
 * @Date 2019/1/9 17:46
 */
public interface IModel {

    Runnable newRunnableConsumer();

    Runnable newRunnableProducer();

}
