package algorithm.java.practise.hxc.algorithm.java.practise.hxc.tree;

import java.util.ArrayList;

/**
 * Created by Kingxc on 2016/10/28 0028.
 * @author :黄鑫晨
 * time :2016-10-28
 * name :树的结点
 */
public class Node<T> {
    private  T data;
    private Node<T> parent; //父节点
    public Node(){}
    private Node<T>leftChild = null; //左孩子
    private  Node<T>rightChild = null; //右孩子
    public int choosed; //是否被选择


    // 返回左节点
    public Node<T>setAndGetLeftChild(Node<T>currentNode){
        if(leftChild!=null)
            return leftChild;
        else {
            leftChild = new Node<>(null);
            leftChild.setParent(currentNode);
            currentNode.setLeftChild(leftChild);
            return currentNode.getLeftChild();
        }
    }
    // 返回左节点
    public Node<T>getLeftChild(){
            return leftChild;
    }
    //设置孩子,由父节点调用
    public void setChild(Node<T>child){
        if(leftChild == null){
            this.leftChild = child;
            this.leftChild.setParent(this);}
        else{
            this.rightChild = child;
            this.rightChild.setParent(this);}

    }
    public void setLeftChild(Node<T>node){
        leftChild=node;
        leftChild.setParent(this);
    }
    public void setRightChild(Node<T>node){
        rightChild=node;
        rightChild.setParent(this);
    }

    // 返回右节点
    public Node<T>setAndGetRightChild(Node<T>currentNode){
        if(rightChild!=null)
            return rightChild;
        else {
            rightChild = new Node<>(null);
            rightChild.setParent(currentNode);
            currentNode.setRightChild(rightChild);
            return rightChild;
        }
    }
    // 返回右节点
    public Node<T>getRightChild(){
            return rightChild;
    }

    public Node(T data){
        this.data = data;
    }
    public Node(T data, Node<T> parent){
        this.data = data;
        this.parent = parent;
    }
    public void setData(T data){
        this.data = data;
    }
    public T getData(){
        try {
            return data;
        }catch (Exception e){
            return null;
        }

    }
    public void setParent(Node<T> parent){
        this.parent = parent;
    }
    public Node<T> getParent(){
        return this.parent;
    }

}
