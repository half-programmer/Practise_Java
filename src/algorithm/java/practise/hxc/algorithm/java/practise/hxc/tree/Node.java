package algorithm.java.practise.hxc.algorithm.java.practise.hxc.tree;

/**
 * Created by Kingxc on 2016/10/28 0028.
 * @author :黄鑫晨
 * time :2016-10-28
 * name :树的结点
 */
public class Node<T> {
    private  T data;
    private int parent; //父节点
    public Node(){}
    private Node<T>leftChild = null; //左孩子
    private  Node<T>rightChild = null; //右孩子



    // 返回左节点
    public Node<T>getLeftChild(){
        return leftChild;
    }
    //设置孩子,由父节点调用
    public void setChild(Node<T>child){
        if(leftChild == null)
            this.leftChild = child;
        else
            this.rightChild = child;
    }

    // 返回右节点
    public Node<T>getRightChild(){
        return rightChild;
    }

    public Node(T data){
        this.data = data;
    }
    public Node(T data, int parent){
        this.data = data;
        this.parent = parent;
    }
    public void setData(T data){
        this.data = data;
    }
    public T getData(){
        return data;
    }
    public void setParent(int parent){
        this.parent = parent;
    }
    public int getParent(){
        return this.parent;
    }

}
