package me;

import java.util.List;

/**
 * @author WangJ
 */
public class TreeTest {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.add(55);
        tree.add(33);
        tree.add(37);
        tree.add(39);
        tree.add(20);
        tree.add(59);
        tree.add(57);
        tree.add(61);
        tree.add(15);
        tree.add(18);
        System.out.println("删除前");
        System.out.println(tree);
        tree.remove(33);
        System.out.println("删除后");
        System.out.println("前序遍历");
        System.out.println(tree.preOrderTraversal());
        System.out.println("中序遍历");
        System.out.println(tree.inOrderTraversal());
        System.out.println("后序遍历");
        System.out.println(tree.postOrderTraversal());
    }
}
