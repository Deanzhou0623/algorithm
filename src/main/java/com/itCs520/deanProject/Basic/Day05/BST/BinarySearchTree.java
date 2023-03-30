package com.itCs520.deanProject.Basic.Day05.BST;/*
 *ClassName:BinarySearchTree
 *Description:
 *@Author:deanzhou
 *@Date:2023/3/2 21:49
 */

public class BinarySearchTree {
    public static void main(String[] args) {
        //test
        int[] arr={7,3,10,12,5,1,9,2};
        BST bst = new BST();
        //循环添加二叉排序数
        for (int i = 0; i < arr.length ; i++) {
            bst.add(new Node(arr[i]));
        }
        //中序遍历二叉排序数
        System.out.println("inOrderTraverse");
        bst.inOrderTraverse();

        //测试删除叶子结点
        bst.removeNode(2);
        bst.removeNode(5);
        bst.removeNode(9);
        bst.removeNode(12);
        bst.removeNode(3);
        bst.removeNode(7);
        bst.removeNode(10);
        bst.removeNode(1);
        System.out.println("删除结点后：");
        bst.inOrderTraverse();
    }
}
//创建二叉排序树
class BST{
    //根结点
    private Node root;
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
