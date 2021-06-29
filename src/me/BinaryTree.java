package me;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree<E extends Comparable<E>> {
    private Node<E> root;
    private Integer size = 0;

    public BinaryTree(E element) {
        root = new Node<>(element);
    }

    public BinaryTree() {
    }

    /**
     * 递归添加元素到树中
     *
     * @param element 要添加的元素
     * @return 无论如何返回 true
     */
    public boolean add(E element) {
        if (root == null) {
            root = new Node<>(element);
            size++;
            return true;
        }
        // TODO 递归添加
        return add(root, element);
    }

    /**
     * add 的执行方法
     *
     * @param node    递归遍历中的当前结点
     * @param element 要添加到树中的数据
     * @return 添加到树中返回 true, 否则继续调用
     */
    private boolean add(Node<E> node, E element) {
        // 如果当前结点中的数据比要添加的数据大, 则应该在树的左子树中查找
        if (node.item.compareTo(element) > 0) {
            Node<E> left = node.left;
            // 如果左子树不为 null, 则将左子树设为当前结点, 继续递归
            // 如果左子树为 null, 则可以将数据插入到此处, 返回 true, 递归结束
            if (left != null) {
                return add(left, element);
            } else {
                size++;
                node.left = new Node<>(null, element, null, node);
                return true;
            }
        } else {
            // 与上面相反
            Node<E> right = node.right;
            if (right != null) {
                return add(right, element);
            } else {
                size++;
                node.right = new Node<>(null, element, null, node);
                return true;
            }
        }
    }

    public boolean remove(E element) {
        // 查找是否存在目标元素, 如果不存在则返回 false
        Node<E> node = containsElement(element);
        if (node == null) {
            return false;
        }
        // 当前结点没有子结点的情况
        if (node.left == null && node.right == null) {
            node.deleteCurrentNode();
            size--;
            return true;
        }
        // 当前结点只有一个子结点的情况
        // 判断当前结点是否只有一个子结点, 如果只有一个子结点, 先判断有左还是右子结点,
        // 再判断当前结点是父结点的左还是右子结点,再将父结点指向当前结点的指针指向当前结点的子结点
        if (node.left == null | node.right == null) {
            Node<E> childNode = node.left == null ? node.right : node.left;
            if (node.item.compareTo(node.father.item) < 0) {
                node.father.left = childNode;
            } else {
                node.father.right = childNode;
            }
            node.deleteCurrentNode();
            size--;
            return true;
        }

        // 当前结点有两个子结点的情况
        // TODO 两个结点的情况下删除结点
        Node currentNode = node;
        node = node.right;
        if (node.left != null) {
            while (true) {
                if (node.left == null) {

                } else {
                    node = node.left;
                }
            }
        } else {

        }
        return false;
    }

    /**
     * 是否存在某个元素
     *
     * @param element 要查找的元素
     * @return 是否存在
     */
    public Node containsElement(E element) {
        return this.containsElement(root, element);
    }

    /**
     * containsElement 的执行方法
     *
     * @param node    当前结点
     * @param element 要查找的元素
     * @return 存在则返回 true, 如果当前结点为空, 说明已经遍历到叶子结点且未找到元素, 返回 false, 这两种情况都不是的情况下继续递归调用自己
     */
    private Node containsElement(Node node, E element) {
        if (node == null) {
            return null;
        }

        if (node.item.equals(element)) {
            return node;
        }

        if (node.item.compareTo(element) > 0) {
            return containsElement(node.left, element);
        } else {
            return containsElement(node.right, element);
        }
    }

    /**
     * 遍历树, 返回集合
     *
     * @return 遍历的集合
     */
    public List getAllNode() {
        List list = new ArrayList();
        getAllNode(list, root, null);
        return list;
    }
    /**
     * TODO 前序,中序,后序 遍历
     */

    /**
     * getAllNode 的层级遍历执行方法
     *
     * @param list  要返回的集合
     * @param left  父结点的左结点
     * @param right 父结点的右结点
     */
    private void getAllNode(List list, Node left, Node right) {
        if (left == null && right == null) {
            return;
        }
        if (left != null) {
            list.add(left.item);
            getAllNode(list, left.left, left.right);
        }
        if (right != null) {
            list.add(right.item);
            getAllNode(list, right.left, right.right);
        }
    }

    /**
     * 暂时没用
     * 判断是否是叶子结点
     *
     * @param node 结点
     * @return 是否是叶子结点
     */
    private boolean isLeaf(Node node) {
        return node.right == null && node.left == null;
    }

    /**
     * 返回树的大小
     *
     * @return 树的大小
     */
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return getAllNode().toString();
    }

    /**
     * 结点内部类
     *
     * @param <E> 结点中的数据
     */
    private class Node<E extends Comparable> {
        Node<E> left;
        E item;
        Node<E> right;
        Node<E> father;

        public Node(E item) {
            this.item = item;
        }

        public Node(Node<E> left, E item, Node<E> right, Node<E> father) {
            this.left = left;
            this.item = item;
            this.right = right;
            this.father = father;
        }

        public void deleteCurrentNode() {
            this.left = null;
            this.item = null;
            this.right = null;
            this.father = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "item=" + item +
                    '}';
        }
    }
}

