package algorithm.java.practise.hxc;
/**
 * 
 * @author :黄鑫晨
 * @
 *
 */
public class Hanoi {

	public Hanoi(){
		System.out.println("创建一个hanni");
	}
	/**
	 * @param n:盘数
	 * @param a:第一个圆柱的名字
	 * @param b:第二个圆柱的名字
	 * @param c:第三个圆柱的名字
	 */
	public Hanoi(int n, char a, char b, char c){
        hanoi(n, a, b, c);
	}
	/**
	 * @param n
	 * @param a: 起始柱
	 * @param b：终点柱
	 * @param c：临时柱
	 */
	public void hanoi(int n,char a, char b, char c){
		if (n>0){
			hanoi(n-1, a, c, b);
			move(n,a,b);
			hanoi(n-1, c, b, a);
		}
	}
	
	public void move(int n, char a, char b){
		System.out.println("盘"+n+"由"+a+"移向"+b);
	}

	public static void main(String args[]){
		Hanoi hanoi = new Hanoi(3,'a','b','c');
	}

}
