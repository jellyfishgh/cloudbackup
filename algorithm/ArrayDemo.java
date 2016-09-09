package sortMore;

import java.util.Random;

public class ArrayDemo {
	private int count;
	private int[]arr;
	public ArrayDemo(int max){
		arr=new int[max];
		count=0;
	}
	public int size(){
		return count;
	}
	public int getData(int index){
		return arr[index];
	}
	public double median(){
		return (arr[count/2]+arr[(count-1)/2])/2.0;
	}
	/**
	 * 去除重复项
	 */
	public void noDups1(){
		System.out.println("%% noDups1 %%--去除重复项");
		int j,dup;
		for(int i=1;i<count;i++){
			if(arr[i]==arr[i-1]){
				j=i;
				while(++j<count&&arr[j]==arr[i]);
				dup=j-i;
				while(j<count){
					arr[j-dup]=arr[j];
					j++;
				}
				count-=dup;
			}
		}
	}
	public void noDups2(){
		System.out.println("%% noDups2 %%--取出重复项");
		int in=1,j,data,tick=0;
		while(in<count){
			if(arr[in]==arr[in-1]){
				data=arr[in-1];
				j=in;
				//用不可能出现的值替换掉重复的值
				while(j<count&&arr[j]==data){
					arr[j]=-1;
					j++;
					in++;
				}
			}
			in++;
		}
		in=1;
		j=0;
		while(in<count){
			if(arr[in]==-1){
				tick++;
				j=in+1;
				while(j<count&&arr[j]==-1){
					j++;
					tick++;
				}
				while(j<count&&arr[j]!=-1){
					arr[j-tick]=arr[j];
					j++;
				}
				in=j;
			}else{
				in++;
			}
		}
		count-=tick;
	}
	//最好去除重复，O(N)
	//要去重先排序
	public void noDups3(){
		System.out.println("%% noDups3 %%--取出重复项");
		int i=1,j,data,tick=0;
		while(i<count){
			if(arr[i]==arr[i-1]){
				data=arr[i-1];
				tick++;
				j=i+1;
				while(j<count&&arr[j]==data){
					j++;
					tick++;
				}
				while(j<count&&arr[j]!=arr[j-1]){
					arr[j-tick]=arr[j];
					j++;
				}
				i=j;
			}else{
				i++;
			}
		}
		count-=tick;
	}
	/**
	 * 来回跑的冒泡
	 */
	public void dBubbleSort(){
		int lout=-1,rout=count,in;
		while(lout++<rout--){
			in=lout;
			while(in++<rout)
				if(arr[in]>arr[rout])
					swap(in,rout);
			while(in-->lout)
				if(arr[in]<arr[lout])
					swap(in,lout);
		}
	}
	/**
	 * 奇偶排序
	 */
	public void oddEventSort(){
		while(toSortFromJ(0,count)||toSortFromJ(1,count));
	}
	//for oddEventSort
	private boolean toSortFromJ(int j,int count){
		boolean flag=false;
		while(j<count-1){
			if(arr[j]>arr[j+1]){
				swap(j,j+1);
				if(!flag)flag=true;
			}
			j+=2;
		}
		return flag;
	}
	/**
	 * 交换
	 * For:dBubbleSort(),oddEventSort()
	 */
	private void swap(int i,int j){
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	public void insert(int data){
		if(count>arr.length){
			System.out.println("No more room to store "+data);
		}else{
			arr[count++]=data;
		}
	}
	public void display(){
		int i=0,sum=0;
		while(i<count){
			sum+=arr[i];
			System.out.print(arr[i]+" ");
			i++;
		}
		System.out.println("====count:"+count+"====sum:"+sum);
		isSorted();
	}
	public void randInit(int size){
		if(size>arr.length){
			System.out.println("init() size "+size+" beyond length of arr");
			count=arr.length;
		}else{
			count=size;
		}
		Random rand=new Random();
		for(int i=0;i<count;i++){
			arr[i]=rand.nextInt(count*2);
		}
	}
	private boolean isSorted(){
		int i=count-1;
		while(i>0){
			if(arr[i]<arr[--i]){
				System.out.println("##arr is not sorted##\n");
				return false;
			}
		}
		System.out.println("**arr is sorted**\n");
		return true;
	}
}