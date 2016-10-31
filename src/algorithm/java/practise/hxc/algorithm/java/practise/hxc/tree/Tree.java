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

    protected final int DEFAULT_SIZE = 2;
    protected int size;
    protected int count; // 为结点计数
    protected Object[] nodes; //用object装泛型
    protected int time =1;
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

    /**
     * @param currentNode:当前操作的结点
     * @param treenodes：存储n待加入的node的数组
     * @param currentNodeNumber：当前要取出的node的序号
     */
    public void addNode(Node<T>currentNode,ArrayList<Node<T>>treenodes, int currentNodeNumber){
        if(currentNodeNumber<size){
        // 如果当前节点没有被初始化
        if (currentNode.getData() == null){
            currentNode.setData(treenodes.get(currentNodeNumber).getData());
            nodes[currentNodeNumber] = currentNode;
            addNode(currentNode.getParent(),treenodes,currentNodeNumber+1);
        }else{
            // 如果为根节点,
            /**@attention: 注意如果之后数值重复则不能这样判断*/
            if (currentNode.getData()==treenodes.get(0).getData()){
                if(currentNode.getLeftChild() == null){
                    //创建左节点
                    currentNode.setAndGetLeftChild(currentNode);
                    //初始化左节点数据
                    currentNode.getLeftChild().setData(treenodes.get(currentNodeNumber).getData());
                    //继续调用
                    addNode(currentNode,treenodes,currentNodeNumber+1);
                }
                else if(currentNode.getRightChild() == null){
                    //创建右节点
                    currentNode.setAndGetRightChild(currentNode);
                    //初始化左节点数据
                    currentNode.getRightChild().setData(treenodes.get(currentNodeNumber).getData());
                    //继续调用
                    addNode(currentNode,treenodes,currentNodeNumber+1);
                }
                else {
                    //给左节点
                    if(time ==1) {
                        //到左处最深
                        while(currentNode.getLeftChild()!=null){
                            currentNode = currentNode.getLeftChild();
                        }
                        //为空
                        time=0;
                        addNode(currentNode, treenodes, currentNodeNumber);

                    }else {
                        while(currentNode.getRightChild()!=null){
                            currentNode = currentNode.getRightChild();
                        }
                        time=1;
                        addNode(currentNode, treenodes, currentNodeNumber);

                    }
                }
            }
            // 不为根节点
            else{
                //左孩子为空，设置左孩子
                if(currentNode.getLeftChild() == null){
                    //创建左节点
                    currentNode.setAndGetLeftChild(currentNode);
                    //初始化左节点数据
                    currentNode.getLeftChild().setData(treenodes.get(currentNodeNumber).getData());
                    //继续调用
                    addNode(currentNode,treenodes,currentNodeNumber+1);
                }
                else if(currentNode.getRightChild() == null){
                    //创建右节点
                    currentNode.setAndGetRightChild(currentNode);
                    //初始化左节点数据
                    currentNode.getRightChild().setData(treenodes.get(currentNodeNumber).getData());
                    //继续调用
                    addNode(currentNode,treenodes,currentNodeNumber+1);
                }
                else {
                    //自己和自己的左右结点都不为空，对父节点进行操作
                    addNode(currentNode.getParent(),treenodes,currentNodeNumber);
                }
            }
        }}
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
//
//    // 增加一个结点,并指名父节点
//    public void add(Node<T>newNode, Node<T>parent){
//        check();
//        newNode.setParent(this.position(parent));
//        add(newNode);
//        parent.setChild(parent);
//
//    }

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

//    //获取树的深度，只有根节点时为1
//    @SuppressWarnings("unchecked")
//    public int getDepth(){
//
//        int max = 1;
//        if(this.nodes[0] == null){
//            return 0;
//        }
//
//        for(int i=0;i<this.count;i++){
//            int deep = 1;
//            int location = ((Node<T>)(this.nodes[i])).getParent(); // 强转转的是nodes[i]，这样才能调用getParent()
//            while(location != -1 && this.nodes[location] != null){
//                location = ((Node<T>)(this.nodes[location])).getParent();
//                deep++;
//            }
//            if(max < deep){
//                max = deep;
//            }
//        }
//        return max;
//    }

    // 获取整棵树有多少节点
    public int getSize(){
        return this.count;
    }


}
