package string;
/**
 * 判断小括号是否完结
 * 不能循环，只能递归
 * @author Administrator
 *
 */
public class ClosedBracket {
	private static char[]arr="abd()eaf(agea)(a)".toCharArray();
	private static int flag=0;
	public static void main(String[]args){
		isClosed(0);
		System.out.println(flag==0);
	}
	private static void isClosed(int start){
		if(start==arr.length){
			return;
		}
		if(arr[start]==')'){
			flag--;
		}
		else if(arr[start]=='('){
			flag++;
		}
		isClosed(++start);
	}
}
