package com.java.queue;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @Description TODO
 * @Author Liu Xing Xiang
 * @Date 2020/6/10 16:39
 **/
public class Node<E> {
    E e;
    AtomicReference<Node<E>> next;

    public Node(E e, Node<E> next) {
        this.e = e;
        this.next = new AtomicReference<>(next);
    }
}
