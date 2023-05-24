package com.itCs520.deanProject.Basic;/*
 *ClassName:Test
 *Description:
 *@Author:deanzhou
 *@Date:2023/4/16 21:15
 */

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.Random;

public class MySet {
    private class Node {
        int val;
        int size; // size of the subtree rooted at this node
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
            this.size = 1;
        }
    }

    private Node root;

    public void insert(int x) {
        root = insert(root, x);
    }

    private Node insert(Node node, int x) {
        if (node == null) {
            return new Node(x);
        }

        if (x < node.val) {
            node.left = insert(node.left, x);
        } else if (x > node.val) {
            node.right = insert(node.right, x);
        }

        node.size = 1 + getSize(node.left) + getSize(node.right);
        return node;
    }

    public boolean contains(int x) {
        return contains(root, x);
    }

    private boolean contains(Node node, int x) {
        if (node == null) {
            return false;
        }

        if (x < node.val) {
            return contains(node.left, x);
        } else if (x > node.val) {
            return contains(node.right, x);
        } else {
            return true;
        }
    }

    public void removeMax(int k) {
        if (k < 1 || k > getSize(root)) {
            return;
        }

        root = removeMax(root, k);
    }

    private Node removeMax(Node node, int k) {
        int rightSize = getSize(node.right);

        if (rightSize >= k) {
            node.right = removeMax(node.right, k);
        } else if (rightSize < k - 1) {
            node.left = removeMax(node.left, k - rightSize - 1);
        } else {
            if (node.right == null) {
                return node.left;
            } else if (node.left == null) {
                return node.right;
            }

            Node temp = node;
            node = findMin(temp.right);
            node.right = removeMin(temp.right);
            node.left = temp.left;
        }

        node.size = 1 + getSize(node.left) + getSize(node.right);
        return node;
    }

    public int size() {
        return getSize(root);
    }

    private int getSize(Node node) {
        return (node == null) ? 0 : node.size;
    }

    private Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            return node.right;
        }

        node.left = removeMin(node.left);
        node.size = 1 + getSize(node.left) + getSize(node.right);
        return node;
    }

    public static void main(String[] args) {
        MySet set = new MySet();
        int n = 10;
        Random rand = new Random();

        // Inserting random numbers from 1 to n
        for (int i = 0; i < n; i++) {
            int x = rand.nextInt(n) + 1;
            set.insert(x);
        }

        System.out.println("Set size: " + set.size());

        // Removing the maximum element 3 times
        for (int i = 0; i < 3; i++) {
            set.removeMax(1);
            System.out.println("Set size after removing maximum element: " + set.size());
        }

    }
}