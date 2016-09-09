package syntax;

public class SortMoreNo2Dups {
	public static void main(String args[]){
		int[] arr={1, 1, 1, 2, 5, 5, 5, 7, 8, 9, 13, 14, 17, 17, 17};
		int in=1,j,data;
		int count=arr.length;
		System.out.println("count="+count);
		show(arr,count);
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
		show(arr,count);
		int tick=0;
		in=1;
		j=0;
		while(in<count){
			System.out.println("*************"+in+"**************");
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
		show(arr,count);
	}
	public static void show(int[]arr,int count){
		for(int i=0;i<count;i++){
			System.out.print(arr[i]+"\t");
		}
		System.out.println();
	}
}