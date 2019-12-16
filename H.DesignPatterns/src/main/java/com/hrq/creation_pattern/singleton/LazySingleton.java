package com.hrq.creation_pattern.singleton;

/**
 * @ClassName LazySingleton_1
 * @Description ；懒加载模式  会出现线程安全问题
 * @Author huangrq
 * @Date 2019/12/16 20:09
 */
public class LazySingleton {

    //private static LazySingleton instance = null;
    private static volatile LazySingleton instance = null;//改进  在所有线程中同步

    private LazySingleton() {
    } //private 避免类在外部被实例化

    /*public LazySingleton getInstance() {
        if (instance == null) {
            return new LazySingleton();
        }
         return instance;
    }  */
    public static synchronized LazySingleton getInstance() {//改进
        if (instance == null) {
            return new LazySingleton();
        }
        return instance;
    }


}
