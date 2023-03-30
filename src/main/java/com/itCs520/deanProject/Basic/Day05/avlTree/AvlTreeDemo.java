package com.itCs520.deanProject.Basic.Day05.avlTree;/*
 *ClassName:AvlTree
 *Description:
 *@Author:deanzhou
 *@Date:2023/3/6 01:52
 */

public class AvlTreeDemo {
    public static void main(String[] args) {
        int[] arr={6,7,8,9,10,11};
        //avl tree
        AVLTree avlTree = new AVLTree();
        //循环添加二叉排序数
        for (int i = 0; i < arr.length ; i++) {
            avlTree.add(new Node(arr[i]));
        }
        //中序遍历二叉排序数
        System.out.println("inOrderTraverse");
        avlTree.inOrderTraverse();

        //未处理前高度 未平衡
        System.out.println("平衡后");
        System.out.println("树的高度："+avlTree.root.height());
        System.out.println("左子树的高度："+avlTree.root.leftHeight());
        System.out.println("右子树的高度："+avlTree.root.rightHeight());
        System.out.println("当前根结点："+avlTree.getRoot());

    }

}


class AVLTree{
    //根结点
    Node root;

    public Node getRoot(){
        return root;
    }
    //添加结点方法
    public void add(Node node){
        if (root == null) {
            root = node; // root is null,则 node即为root结点
        }else{
            root.add(node);
        }
    }

    //search
    public Node search(int value){
//        if (root ==null) return null;
        return root==null ? null: root.search(value);
    }
    //searchParent
    public Node searchParent(int value){
        if (root ==null) return null;
        return root.searchParent(value);
    }

    //删除右子树的最小结点
    public int delRightTreeMin(Node node){
        Node target= node;
        //循环查找左子结点，就会找到最小值
        while (target.left!=null){
            target=target.left;
        }
        //target指向最小结点
        //删除最小结点
        removeNode(target.value);
        return target.value;
    }

    //删除结点
    public void removeNode(int value){
        //1.root is null
        if (root==null){ return;}
        //2.search target Node
        Node targetNode=search(value);
        //2.1 target Node is null
        if (targetNode == null) {return;}
        //2.2 there is one node in BST
        //则root 为null即可
        if (root.left==null && root.right == null) {
            root = null;
            return;
        }
        //3. search the parent node of target node
        Node parentNode = searchParent(value);
        //4.删除结点为叶子结点
        if (targetNode.left == null && targetNode.right ==null){

            //判断该叶子结点为左子结点还是右子结点
            if (parentNode.left != null && parentNode.left.value == value) {
                parentNode.left = null;
                //右子结点
            } else if (parentNode.right != null && parentNode.right.value == value) {
                parentNode.right = null;
            }
            // 4.2删除的为两颗子数结点
        }else if (targetNode.left!=null && targetNode.right!=null){
            //4.2.1 删除右子树的最小结点 / 或者左子树的最大结点
            int minValue = delRightTreeMin(targetNode.right);
            targetNode.value=minValue;
        }else {
            //4.3删除的只有一颗子数结点
            if (targetNode.left!=null) {
                //当只剩下2颗结点时，判断下次删除结点是不是parent结点
                if (parentNode!=null) {
                    //4.3.1 targetNode 是parentNode的左子结点
                    if (parentNode.left.value == value) {
                        parentNode.left = targetNode.left;
                    } else {
                        //4.3.1 targetNode 是parentNode的右子结点
                        parentNode.right = targetNode.left;
                    }
                }else {
                    root = targetNode.left;
                }
            }else {//targetNode 有右子结点
                if (parentNode!=null) {
                    if (parentNode.left.value == value) {
                        //4.3.2.1targetNode 是parentNode的左子结点
                        parentNode.left = targetNode.right;
                        //4.3.2.2targetNode 是parentNode的右子结点
                        parentNode.right = targetNode.right;
                    }
                }else {
                    root = targetNode.right;
                }
            }
        }
    }
    //中序遍历
    public void inOrderTraverse(){
        if (root!=null)
            root.inOrder();
        else
            System.out.println("BST is null");
    }
}
//创建node结点
class Node{
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }


    //leftHeight
    public int leftHeight(){
        if (left==null){
            return 0;
        }
        return left.height();
    }
    //rightHeight
    public int rightHeight(){
        if (right==null){
            return 0;
        }
        return right.height();
    }
    //height
    public int height(){
        return Math.max(left == null ? 0: left.height(), right==null?0: right.height())+1;
    }

    //leftRotate
    private void leftRotate(){
        //1.创建新的结点，以当前根结点为值
        Node newNode = new Node(value);
        //2.把新的结点的左子树设成当前结点的左子树
        newNode.left = left;
        //3.新结点的右子树设置成当前结点的右子树的左子树
        newNode.right = right.left;
        //4.当前结点的值替换成右子结点的值
        value = right.value;
        //5.当前结点的右子树设置成当前结点的右子树的右子树
        right = right.right;
        //6.当前结点的左子树，设置成新的结点
        left = newNode;

    }

    //rightRotate
    private void rightRotate(){
        //1.创建一个新的结点，以当前根结点为值
        Node newNode = new Node(value);
        //2.把新的结点的右子树设成当前结点的右子树
        newNode.right = right;
        //3.新结点的左子树设置成当前结点的左子树的右子树
        newNode.left = left.right;
        //4.当前结点的值替换成左子结点的值
        value = left.value;
        //5.当前结点的左子树设置成当前结点的左子树的左子树
        left = left.left;
        //6.当前结点的右子树，设置成新的结点
        right = newNode;

    }
    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    /**
     * 查找结点的方法
     * @param value
     * @return
     */
    public Node search(int value){
        //1. 当前值即为value
        if (this.value == value) return this;
        //2. value小于当前值
        if (this.value>value){
            //2.1 if leftNode is Null
            if (this.left==null) return null;
            return this.left.search(value);
        }else {
            //3. value大于当前值
            //3.1 if rightNode is null
            if (this.right==null) return null;
            return this.right.search(value);
        }
    }

    /**
     * 查找删除结点的父结点
     */
    public Node searchParent(int value){
        //1. 当前结点为要删除结点父结点
        if ((this.left!=null  && this.left.value == value) ||
                (this.right!=null && this.right.value == value)){
            return this;
        }else {
            //2. this.value > value ，向左子数递归查找
            if (this.value >value && this.left!=null)
                return this.left.searchParent(value);
                //3. this.value < value ，向右子数递归查找
            else if (this.value<value && this.right!=null )
                return this.right.searchParent(value);
                //4. 无父节点
            else
                return null; //没有找到父节点
        }
    }

    //添加结点方法
    //递归的形式添加结点，注意需要满足二叉排序数的要求
    public void add(Node node){
        if (node==null)
            return;

        //判断node的value与root.value的关系
        if (node.value<this.value){
            //当前结点小于根结点
            //当前左子结点是否为null
            if (this.left ==null){
                this.left =node;
            }else {
                this.left.add(node);
            }
        }else if (node.value>this.value){
            //当前结点大于根结点
            //当前右子结点为null
            if (this.right == null){
                this.right=node;
            }else {
                this.right.add(node);
            }
        }
        //添加完结点后，如果条件满足 右子树高度 - 左子树高度 > 1，左旋转
        if (rightHeight() - leftHeight() > 1){
            if (right!=null &&right.leftHeight() > right.rightHeight()){
                //先对右子结点进行右旋
                right.rightRotate();
                //左旋转
                 leftRotate();
        }else {
                //直接左旋转
                leftRotate();
            }
            return;
        }

        //添加完结点后，如果条件满足 左子树高度 - 右子树高度 > 1，右旋转
        if (leftHeight() - rightHeight() > 1){
            if (left!=null &&left.rightHeight() > left.leftHeight()){
                //当前左子结点进行左旋
                left.leftRotate();
                //右旋转
                rightRotate();
            }else {
                //右旋转
                rightRotate();
            }
        }
    }

    //中序遍历
    public void inOrder(){
        //left
        if (this.left!=null){
            this.left.inOrder();
        }
        //root
        System.out.println(this);
        //right
        if (this.right!=null){
            this.right.inOrder();
        }
    }
}

