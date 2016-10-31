package algorithm.java.practise.hxc.algorithm.java.practise.hxc.tree;

import java.util.ArrayList;

/**
 * Created by Kingxc on 2016/11/1 0001.
 *
 * @author :黄鑫晨
 *         时间：2016.11.1
 *         描述：最优装载问题
 */
public class BestLoad<T> extends Tree<T> {
    private ArrayList<Node<Integer>> boxes; //集装箱数组
    private int size; //集装箱数
    private Integer boadWeight;//第一艘轮船的载重量
    private Integer currentWeight;//当前载重量
    private Integer bestWeight;//当前最优载重量
    private int remainWeight;//剩余集装箱重量
    private ArrayList<Node<T>> currentX;//当前解
    private ArrayList<Node<T>>  bestX;//当前最优解

    /**
     *
     * @param i
     */
    public void backtrace(Node<T>currentNode) {
        // 到达叶节点
        if (currentNode.getLeftChild() == null && currentNode.getRightChild() == null) {   //i此时的值=叶节点+1
            //当前载重量大于当前最优载重量
            if (currentWeight > bestWeight) {
                // 更新最优解
                ArrayList<Node<T>> bestX = new ArrayList<Node<T>>(currentX);
                bestWeight = currentWeight;
                return;
            }
        }
        // 剩余重量减去当前重量
        remainWeight -=(Integer)currentNode.getData();
        //搜索左子树
        //如果加上以后小于最大载重
        if (currentWeight + (Integer) currentNode.getData() < boadWeight) {   //x[i =1
            currentNode.choosed = 1;
            currentWeight += (Integer) currentNode.getData();
            backtrace(currentNode.getLeftChild());
            currentWeight -= (Integer) currentNode.getData();
        }
        //3.搜索右子树
        if (currentWeight + remainWeight > bestWeight) {
            currentNode.choosed = 0;
            backtrace(currentNode.getRightChild());
        }
        remainWeight += (Integer) currentNode.getData();
    }

    public BestLoad(Node<T> root, int size) {
        this.size = size;
        nodes = new Object[size];
        nodes[0] = root;
        count = 1;
    }

    public void InOrderVisitTree(Node<T> currentNode) {

        // 左孩子
        if (currentNode.getLeftChild() != null) {
            InOrderVisitTree(currentNode.getLeftChild());
        }

        // 如果为根节点
        if (currentNode.getLeftChild() == null && currentNode.getRightChild() == null) {

            System.out.println("Node" + currentNode.getData() + "为根节点");

        }
        //System.out.println(currentNode.getData());

        // 右孩子
        if (currentNode.getRightChild() != null) {
            InOrderVisitTree(currentNode.getRightChild());
        }
    }

    public static void main(String args[]) {
        ArrayList<Node<Integer>> boxes = new ArrayList<Node<Integer>>();
        boxes.add(new Node<Integer>(5));
        boxes.add(new Node<Integer>(2));
        boxes.add(new Node<Integer>(7));
        boxes.add(new Node<Integer>(13));
        boxes.add(new Node<Integer>(20));
        boxes.add(new Node<Integer>(1));
        boxes.add(new Node<Integer>(5));
//
        BestLoad tree = new BestLoad(boxes.get(0), boxes.size());
        tree.addNode(tree.getRoot(), boxes, 1);
        tree.InOrderVisitTree(tree.getRoot());
        tree.backtrace(tree.getRoot());

    }

}
