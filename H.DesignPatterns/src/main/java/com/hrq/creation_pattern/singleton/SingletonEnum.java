package com.hrq.creation_pattern.singleton;

/**
 * @ClassName SingletonEnum
 * @Description
 * @Author huangrq
 * @Date 2019/12/17 11:03
 */
public enum SingletonEnum {

    INSTANCE;

    private MyResource myResource = null;
    private String  name;

    private SingletonEnum() {
        myResource = new MyResource();
    }
    public  MyResource getMyResourceInstance() {
        return myResource;
    }
    public class MyResource {
        private String sourceName;

        private MyResource(){}

        public String getSourceName() {
            return sourceName;
        }

        public void setSourceName(String sourceName) {
            this.sourceName = sourceName;
        }
    }
}
