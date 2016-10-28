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
        for(int i=0; i<10; i++)
            boxes.add(new Node<Integer>(i));
        Tree tree = new Tree(boxes);
        tree.InOrderVisitTree(tree.getRoot());


    }
}
