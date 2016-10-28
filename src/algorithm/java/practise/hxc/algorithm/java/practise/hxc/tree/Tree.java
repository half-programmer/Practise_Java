package algorithm.java.practise.hxc.algorithm.java.practise.hxc.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Kingxc on 2016/10/28 0028.
 * @author :黄鑫晨
 * 创建时间：2016-10-28
 * 说明：树
 */
public class Tree<T> {
    public final int DEFAULT_SIZE = 2;
    private int size;
    private int count; // 为结点计数
    private Object[] nodes; //用object装泛型

    public Tree(){
        size = DEFAULT_SIZE;
        nodes = new Object[size];
        count = 0;
    }
    public Tree(Node<T> root){
        this();
        count = 1;
        nodes[0] = root;
    }
    public  Tree(Node<T>root, int size){
        this.size = size;
        nodes = new Object[size];
        nodes[0] = root;
        count = 1;
    }

    public void addNode(Node<T>currentNode, ArrayList<Node<T>>treenodes){
        int currentParentNodeNumber = 0;
        for(int i=1; i<size; i++){
            //如果左孩子是空
            if(currentNode.getLeftChild() == null){
                // 设置为孩子
                nodes[i] = treenodes.get(i);
                currentNode.setChild((Node<T>) nodes[i]);
            }
            // 如果右孩子是空
            else if(currentNode.getRightChild() == null){
                // 设置为孩子
                nodes[i] = treenodes.get(i);
                currentNode.setChild((Node<T>) nodes[i]);
            }
            else {
                //如果左右都满，将当前节点移动到左孩子

            }
        }
    }
    //传入结点列表并初始化
    // 左孩子序号是当前节点号*2+1，右结点是*2+2
    public Tree(ArrayList<Node<T>>treenodes){
        this.size = treenodes.size();
        nodes = new Object[size];
        nodes[0] = treenodes.get(0); // 初始化根节点

        // 当前父节点
        Node<T>currentParentNode = (Node<T>) nodes[0];
        addNode(currentParentNode, treenodes);

    }


    // 增加一个结点,不指名父节点
    private void add(Node<T> newNode){
        for (int i=0; i<size; i++){
            if(nodes[i] == null) {
                nodes[i] = newNode;
                break;
            }
            count++;
        }
    }

    //深度优先搜索,中序遍历
    public void InOrderVisitTree(Node<T>currentNode){

        // 左孩子
        if(currentNode.getLeftChild()!=null){
            InOrderVisitTree(currentNode.getLeftChild());
        }

        // 输出中点
        System.out.println(currentNode.getData());

        // 右孩子
        if(currentNode.getRightChild() !=null ){
            InOrderVisitTree(currentNode.getRightChild());
        }
    }

    // 检测是否需要扩大树
    private void check(){
        if(this.count >= this.size){
            this.enlarge();
        }
    }
    //扩容，增加一个结点
    public void enlarge(){
        this.size = this.size + this.DEFAULT_SIZE;
        Object[] newNodes = new Object[this.size];
        newNodes = Arrays.copyOf(nodes, this.size);
        Arrays.fill(nodes, null);
        this.nodes = newNodes;
        System.out.println("enlarge");
    }

    // 增加一个结点,并指名父节点
    public void add(Node<T>newNode, Node<T>parent){
        check();
        newNode.setParent(this.position(parent));
        add(newNode);
        parent.setChild(parent);

    }

    //获取节点在数组的存储位置
    public int position(Node<T> node) {
        for (int i = 0; i < this.size; i++) {
            if (nodes[i] == node) {
                return i;
            }
        }
        return -1;
    }

    // 获取整棵树有多少结点
    public int getCount(){
        return count;
    }

    //获取根节点
    //给编译器一条指令，告诉它对被批注的代码元素内部的某些警告保持静默
    @SuppressWarnings("unchecked")
    public Node<T>getRoot(){
        return (Node<T>)nodes[0];
    }

    //获取树的深度，只有根节点时为1
    @SuppressWarnings("unchecked")
    public int getDepth(){

        int max = 1;
        if(this.nodes[0] == null){
            return 0;
        }

        for(int i=0;i<this.count;i++){
            int deep = 1;
            int location = ((Node<T>)(this.nodes[i])).getParent(); // 强转转的是nodes[i]，这样才能调用getParent()
            while(location != -1 && this.nodes[location] != null){
                location = ((Node<T>)(this.nodes[location])).getParent();
                deep++;
            }
            if(max < deep){
                max = deep;
            }
        }
        return max;
    }

    // 获取整棵树有多少节点
    public int getSize(){
        return this.count;
    }


}
