package huangruiqing.group;

import java.util.*;

/**
 * @ClassName Match
 * @Description // 一句话描述这个类
 * @Author huangrq
 * @Date 2019/1/17 14:43
 */
public class Match {

    public void merge(List<Integer> hay) {
        Set<Integer> keys = new HashSet<Integer>();
        Map<Integer, Group> groups = new HashMap<Integer, Group>();
        for (Integer each : hay) {
            keys.add(each);
        }
        for (Integer key : keys) {
            groups.put(key, new Group());
        }
        for (Integer each : hay) {
            groups.get(each).getIns().add(each);
        }
        display(groups);
    }

    public void display(Map<Integer, Group> groups) {
        for (Map.Entry<Integer, Group> each : groups.entrySet()) {
            System.err.println("++++++++++++++++++==");
            for (Integer g : each.getValue().getIns()) {
                System.err.println(g);
            }
            System.err.println("+++++++++++++++++++++");
        }
    }

    public static void main(String[] args) {
        List<Integer> hay = new ArrayList<Integer>();
        hay.add(1);
        hay.add(3);
        hay.add(5);
        hay.add(1);
        hay.add(5);
        hay.add(4);
        hay.add(6);
        hay.add(7);
        hay.add(9);
        hay.add(5);
        hay.add(3);
        Match m = new Match();
        m.merge(hay);
    }
}
