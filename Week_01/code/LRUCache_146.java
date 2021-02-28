import sun.awt.geom.AreaOp;

import java.util.HashMap;
import java.util.Map;

/**
 * 采用双向链表+HashMap来实现LRU缓存
 */
public class LRUCache_146 {
    //定义一个双向链表
    class DLinkNode {
        int val;
        int key;
        DLinkNode preNode;
        DLinkNode nextNode;
        public DLinkNode() {}
        public DLinkNode(int val, int key) {
            this.val = val;
            this.key = key;
        }
    }
    //定义缓存类用到的成员变量
    private int size;
    private int capability;
    private Map<Integer, DLinkNode> cache = new HashMap<>();
    //使用伪头部和伪尾部节点
    private DLinkNode head,tail;

    public LRUCache_146(int capacity) {
        this.size = 0;
        this.capability = capacity;
        head = new DLinkNode();
        tail = new DLinkNode();
        head.nextNode = tail;
        tail.preNode = head;
    }

    /**
     * get方法策略：如果key存在就从cache中取出，并在双向链表中将该元素放到头部；
     *             如果key不存在则返回-1
     * @param key
     * @return
     */
    public int get(int key) {
        DLinkNode node = cache.get(key);
        if(node == null) {
            return -1;
        }
        moveToHead(node);
        return node.val;
    }

    /**
     * put方法策略：如果key存在，覆盖原来的值，并在双向链表中将该元素放到头部；
     *             如果key不存在，新建一个键值对放到cache中;
     *             判断是否size是否大于capability，如果大于就执行LRU算法，删除双向链表头部元素并添加新元素
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        DLinkNode node = cache.get(key);
        if(node != null) {
            moveToHead(node);
            node.val = value;
            return;
        }
        DLinkNode newNode = new DLinkNode(value, key);
        cache.put(key, newNode);
        size++;
        //校验是否执行LRU算法
        if(size > capability) {
           DLinkNode tailNode = removeTail();
           cache.remove(tailNode.key);
        }
        addToHead(newNode);
    }

    public void moveToHead(DLinkNode node) {
        addToHead(removeNode(node));
    }

    public DLinkNode removeTail() {
        return removeNode(tail.preNode);
    }

    public DLinkNode removeNode(DLinkNode node) {
        node.preNode.nextNode = node.nextNode;
        node.nextNode.preNode = node.preNode;
        return node;
    }

    public void addToHead(DLinkNode node) {
        node.nextNode = head.nextNode;
        head.nextNode.preNode = node;
        head.nextNode = node;
        node.preNode = head;
    }
}
