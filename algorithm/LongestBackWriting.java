package string;

import java.util.ArrayList;
import java.util.List;

/**
 * 字符串中最长回文
 * @author Administrator
 *
 */
public class LongestBackWriting {
	public static void main(String[]args){
		String str="aab";
		BackWriting bw=new BackWriting(str);
		System.out.println(bw.getLbw());
	}
}
class BackWriting{
	private String lbw;
	public BackWriting(String str){
		Section sec=getLongestSec(getBackWrting(str));
		if(sec!=null)lbw=str.substring(sec.getStart(), sec.getEnd());
	}
	public String getLbw(){
		return lbw;
	}
	private List<Section> getBackWrting(String str){
		MyStack ms=new MyStack(str.length());
		ArrayList<Section> list=new ArrayList<Section>();
		char[]arr=str.toCharArray();
		if(arr.length%2==0){
			ms.push(arr[0]);
			int start=0;
			int i=1;
			while(i<arr.length){
				if(ms.size()>0){
					if(ms.peek()==arr[i]){
						ms.pop();
						start--;						
					}else{
						ms.push(arr[i]);
						start++;
					}
					i++;
				}
				if(ms.size()==0){
					list.add(new Section(start+1,i));
					start=i+1;
				}
				i=start;
			}
		}
		return list;
	}
	private Section getLongestSec(List<Section> list){
		if(list.size()>0){
			int index=0;
			Section sec;
			for(int i=0;i<list.size();i++){
				System.out.println(list.get(i));
				sec=list.get(index);
				if(sec.compareTo(list.get(i))<0){
					index=i;
				}
			}
			return list.get(index);
		}else{
			return null;
		}
	}
}
class MyStack{
	private char[]arr;
	private int count;
	public MyStack(int len){
		arr=new char[len];
		count=0;
	}
	public char pop(){
		return arr[--count];
	}
	public char peek(){
		return arr[count-1];
	}
	public void destory(){
		count=0;
	}
	public void push(char c){
		if(count<arr.length){
			arr[count++]=c;
		}
	}
	public int size(){
		return count;
	}
}
class Section implements Comparable<Section>{
	private int start,end;
	public Section(int start,int end){
		this.start=start;
		this.end=end;
	}
	public int getStart(){
		return start;
	}
	public int getEnd(){
		return end;
	}
	@Override
	public int compareTo(Section sec) {
		return (this.end-this.start)-(sec.getEnd()-sec.getStart());
	}
	public String toString(){
		return "(start,end)=("+start+","+end+")";
	}
}