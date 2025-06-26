package binarysearch.search.middle;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Router3508 模拟了一个带有限内存的网络路由器，其功能如下：
 * 1. 存储数据包（Packet），每个数据包包含 source、destination 和 timestamp；
 * 2. 内部使用 FIFO 队列，超过限制 memoryLimit 后会自动转发最旧数据包；
 * 3. 不允许添加重复数据包（source、destination、timestamp 全相同）；
 * 4. 支持查询：统计指定 destination 且 timestamp ∈ [startTime, endTime] 的数据包数量。
 * 核心设计：
 * - Queue<Packet>：按顺序存储数据包，FIFO；
 * - Set<Packet>：快速判断数据包是否重复（重写 equals 和 hashCode）；
 * - Map<Integer, List<Packet>>：将数据包按 destination 分组，二分查询；
 * 关键方法：
 * - addPacket：尝试添加数据包，若满则转发最旧包；
 * - forwardPacket：弹出队首数据包，并从辅助结构中清理；
 * - getCount：统计某 destination 下符合时间条件的数据包数，使用二分加速查找。
 *
 * @author Canyon
 * @date 2025/06/26
 */
public class Router3508 {
    private static class Packet {
        int source,destination,timestamp ;

        public Packet(int source, int destination,int timestamp) {
            this.source = source;
            this.destination = destination;
            this.timestamp = timestamp;

        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Packet p)) {return false;}
            return source == p.source &&
                    destination == p.destination &&
                    timestamp == p.timestamp ;
        }

        @Override
        public int hashCode() {
            return Objects.hash(source, destination,timestamp);
        }
    }
    private final Queue<Packet> queue;
    private final int size;
    private final HashSet<Packet> set = new HashSet<>();
    private final HashMap<Integer,List<Packet>> map = new HashMap<>();

    public Router3508(int memoryLimit) {
        this.queue = new ArrayBlockingQueue<>(memoryLimit);
        this.size = memoryLimit;
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        Packet packet  = new Packet(source,destination,timestamp);
        if(set.add(packet)){
            if(queue.size()==size){
                forwardPacket();
            }
            queue.offer(packet);
            map.computeIfAbsent(packet.destination, k -> new ArrayList<>()).add(packet);
            return true;
        }
        return false;
    }

    public int[] forwardPacket() {
        if(queue.isEmpty()){
            return new int[]{};
        }
        Packet pack = queue.poll();
        set.remove(pack);
        List<Packet> list = map.get(pack.destination);
        list.remove(pack);
        map.put(pack.destination,list);
        return new int[]{ pack.source, pack.destination,pack.timestamp};
    }

    public int getCount(int destination, int startTime, int endTime) {
        if (queue.isEmpty()){return 0;}
        List<Packet> list = map.get(destination);
        int start = lowerBound(list,startTime);
        int end = lowerBound(list,endTime+1)-1;
        return end - start;
    }

    public int lowerBound(List<Packet> list, int target){
        int right = list.size();
        int left =  -1;
        while (left + 1 < right) {
            int mid = (left+right)>>>1;
            if(list.get(mid).timestamp<target){
                left = mid;
            }else {
                right = mid;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        // 初始化 Router 对象，内存限制为 3
        Router3508 router = new Router3508(3);

        // 对应操作：
        System.out.println(router.addPacket(1, 4, 90));
        System.out.println(router.addPacket(2, 5, 90));
        System.out.println(router.addPacket(1, 4, 90));
        System.out.println(router.addPacket(3, 5, 95));
        System.out.println(router.addPacket(4, 5, 105));

        // 转发一个数据包（FIFO：2,5,90）
        int[] forwarded = router.forwardPacket();
        System.out.println(Arrays.toString(forwarded));

        // 添加新数据包
        System.out.println(router.addPacket(5, 2, 110));

        // 查询 destination = 5，时间范围 [100, 110] 的数据包个数
        System.out.println(router.getCount(5, 100, 110));
    }
}
