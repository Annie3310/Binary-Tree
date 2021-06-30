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
//        List list = tree.preOrderTraversal();
//        List list = tree.inOrderTraversal();
        List list = tree.postOrderTraversal();
        System.out.println(list);
    }
}
