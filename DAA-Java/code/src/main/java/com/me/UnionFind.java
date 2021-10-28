package com.me;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * @author zs
 * @date 2021/10/28
 */
public class UnionFind {
    // 样本进来会包一层，叫做元素
    public static class Element<V> {
        public V value;

        public Element(V value) {
            this.value = value;
        }

    }

    public static class UnionFindSet<V> {
        // 元素 元素所对应的东西
        public HashMap<V, Element<V>> elementMap;
        // key  某个元素  value 该元素的父
        public HashMap<Element<V>, Element<V>> fatherMap;
        // key 某个集合的代表元素   value 该集合的大小，也就是代表元素的个数
        public HashMap<Element<V>, Integer> sizeMap;

        // 并查集在初始化的时候要求把所有样本给过来
        public UnionFindSet(List<V> list) {
            elementMap = new HashMap<>();
            fatherMap = new HashMap<>();
            sizeMap = new HashMap<>();
            for (V value : list) {
                Element<V> element = new Element<V>(value);
                elementMap.put(value, element);
                fatherMap.put(element, element);
                sizeMap.put(element, 1);
            }
        }

        // 给定一个ele，往上一直找，把代表元素返回
        private Element<V> findHead(Element<V> element) {
            Stack<Element<V>> path = new Stack<>();
            while (element != fatherMap.get(element)) {
                path.push(element); // 沿途的元素全部加入到栈中
                element = fatherMap.get(element);
            }
            // 将路径扁平化，就是将路径中的元素挂载到father下面
            while (!path.isEmpty()) {
                fatherMap.put(path.pop(), element);
            }
            return element;
        }

        public boolean isSameSet(V a, V b) {
            if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
                return findHead(elementMap.get(a)) == findHead(elementMap.get(b));
            }
            return false;
        }

        public void union(V a, V b) {
            if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
                Element<V> aF = findHead(elementMap.get(a));
                Element<V> bF = findHead(elementMap.get(b));
                if (aF != bF) {
                    Element<V> big = sizeMap.get(aF) >= sizeMap.get(bF) ? aF : bF;
                    Element<V> small = big == aF ? bF : aF;
                    fatherMap.put(small, big);
                    sizeMap.put(big, sizeMap.get(aF) + sizeMap.get(bF));
                    sizeMap.remove(small);
                }
            }
        }

    }
}