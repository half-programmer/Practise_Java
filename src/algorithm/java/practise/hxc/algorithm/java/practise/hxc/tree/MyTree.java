package algorithm.java.practise.hxc.algorithm.java.practise.hxc.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kingxc on 2016/10/28 0028.
 * @author :黄鑫晨
 * 时间：2016-10-28
 * 使用树
 */
public class MyTree<T> {
    public void buildTree(List<T> nodes){

    }
    public static void main(String[] args){
        //初始化箱子的ArrayList
        ArrayList<Node<Integer>>boxes = new ArrayList<Node<Integer>>();
//        for(int i=0; i<20; i++)
//            boxes.add(new Node<Integer>(i));
        boxes.add(new Node<Integer>(5));
        boxes.add(new Node<Integer>(2));
        boxes.add(new Node<Integer>(7));
        boxes.add(new Node<Integer>(13));
        boxes.add(new Node<Integer>(20));
        boxes.add(new Node<Integer>(1));
        boxes.add(new Node<Integer>(5));
       System.out.print("你好丰富的覅");
        Tree tree = new Tree(boxes.get(0),boxes.size());
        tree.addNode(tree.getRoot(),boxes,1);
        tree.InOrderVisitTree(tree.getRoot());


    }
}
