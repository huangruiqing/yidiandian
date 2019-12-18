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

    SingletonEnum() {
        myResource = new MyResource();
    }
    public  MyResource getMyResourceInstance() {
        return myResource;
    }
    class MyResource {
        private String sourceName;

        private MyResource(){}

        public String getSourceName() {
            return sourceName;
        }

        public void setSourceName(String sourceName) {
            this.sourceName = sourceName;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
