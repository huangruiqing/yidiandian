package com.hrq.creation_pattern.prototype;

import com.sun.deploy.net.protocol.ProtocolType;

import java.util.HashMap;

/**
 * @ClassName PrototypeManger
 * @Description
 * @Author huangrq
 * @Date 2019/12/18 20:10
 */
public class PrototypeShapeManger {

    private static HashMap<String,Shape> manager = new HashMap<>();

    public PrototypeShapeManger() {
       this.put("circle",new Circle());
       this.put("square",new Square());
    }

    public void put(String id ,Shape  protocolType) {
        manager.put(id,protocolType);
    }
    public Shape get(String id) {
        Shape shape = manager.get(id);
        return (Shape) shape.clone();
    }

}
