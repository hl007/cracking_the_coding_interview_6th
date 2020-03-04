package com.company.graph;

// 有序符号表（字典）的API
public interface OrderedSymbolTable<Key,Value> {
    /**
     * 根据key获取value
     * @param key 如果为空，则抛出异常
     * @throws IllegalArgumentException if {@code key} is {@code null}
     * @return val
     */
    Value get(Key key);

    /**
     * 将键值存入表内
     * @param key 如果为空，则抛出异常
     * @param val 若val为空，则删除key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    void put(Key key, Value val);

    /**
     * 删除键值对
     * @param key key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    void delete(Key key);

    /**
     *  表中是否包含该key
     * @param key key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     * @return 是否
     */
    boolean contains(Key key);

    /**
     * 表是否为空
     * @return 是否
     */
    boolean isEmpty();

    /**
     * 表的键值对数
     * @return 数量
     */
    int size();

    /**
     * [lo,hi]之间的键值对数
     * @return 数量
     */
    int size(Key lo, Key hi);

    /**
     * 表中所有键的集合，已排序
     * @return 集合
     */
    Iterable<Key> keys();

    /**
     * [lo,hi]之间的键的集合，已排序
     * @return 集合
     */
    Iterable<Key> keys(Key lo, Key hi);

    /**
     * 最小的key
     * @return key
     */
    Key min();

    /**
     * 最大的key
     * @return key
     */
    Key max();

    /**
     * 小于等于key的最大键（向下取整）
     * @param key 如果为空，则抛出异常
     * @return key
     */
    Key floor(Key key);

    /**
     * 大于等于key的最小键（向上取整）
     * @param key 如果为空，则抛出异常
     * @return key
     */
    Key ceiling(Key key);

    /**
     * 小于key的键的数量
     * @param key 如果为空，则抛出异常
     * @return int
     */
    int rank(Key key);

    /**
     * 排名为k的键
     * @param k k
     * @return key
     */
    Key select(int k);

    /**
     * 删除最小的键
     */
    void deleteMin();

    /**
     * 删除最大的键
     */
    void deleteMax();
}
