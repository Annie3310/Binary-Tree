# Binary-Tree
手写一个二叉树

内部类思路参考 `LinkedList`

### TODO

- 删除节点的替换行为

### 内部类 `Node`
- left 左节点
- right 右节点
- father 父节点
- item 节点的值

### 方法
| 方法                       | 说明                                                         |
| -------------------------- | ------------------------------------------------------------ |
| add(E element)             | 追加节点到树中                                               |
| remove(E element)          | 从树中删除一个节点, 如果该节点没有子节点, 则直接删除该节点, 如果该节点有一个子节点, 则子节点接替该节点的位置, 如果该节点有两个子节点, 则将左子节点中最大的节点替换到当前节点的位置 |
| containsElement(E element) | 是否存在节点                                                 |
| getAllNode()               | 广度遍历全部节点                                             |
| size()                     | 返回树的节点数                                               |
| isLeaf()                   | 判断是否是叶子节点                                           |
| preOrderTraversal()| 前序遍历 |
| inOrderTraversal() | 中序遍历 |
| postOrderTraversal() | 后序遍历 |
