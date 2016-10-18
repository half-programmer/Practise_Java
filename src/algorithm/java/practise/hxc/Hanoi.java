package algorithm.java.practise.hxc;
/**
 * 
 * @author :���γ�
 * @
 *
 */
public class Hanoi {

	public Hanoi(){
		System.out.println("����һ��hanni");
	}
	/**
	 * @param n:����
	 * @param a:��һ��Բ��������
	 * @param b:�ڶ���Բ��������
	 * @param c:������Բ��������
	 */
	public Hanoi(int n, char a, char b, char c){
        hanoi(n, a, b, c);
	}
	/**
	 * @param n
	 * @param a: ��ʼ��
	 * @param b���յ���
	 * @param c����ʱ��
	 */
	public void hanoi(int n,char a, char b, char c){
		if (n>0){
			hanoi(n-1, a, c, b);
			move(n,a,b);
			hanoi(n-1, c, b, a);
		}
	}
	
	public void move(int n, char a, char b){
		System.out.println("��"+n+"��"+a+"����"+b);
	}

	public static void main(String args[]){
		Hanoi hanoi = new Hanoi(3,'a','b','c');
	}

}
