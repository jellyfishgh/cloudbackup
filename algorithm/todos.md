# 算法

Leetcode
数字串映射为字符串？
字符串映射为数字串？

翻转二叉树(谷歌的面试题),单向队列;KMP;
lo姐的微博上转发的一些数据结构自己实现及了解其原理和使用场景;
合并两个有序列表;实现diff算法;map 和 hashmap的区别;红黑树;b+树(数据库索引原理?b+树?);
k-groups-reserve,以k个数为单位进行反转;一句话反转单词;对分查找;
大数加法;快排;123组成的数列排序,前后一起扫;记住当前最后一个1和最前一个3的位置;

http://coding-geek.com/
http://coding-geek.com/how-shazam-works/
http://coding-geek.com/how-databases-work/
http://coding-geek.com/the-best-programming-language/
http://blog.jobbole.com/100349/
http://coding-geek.com/how-does-a-hashmap-work-in-java/

字符串中最长回文
LongestBackWriting.java

最长回文
c style：用c的方式解决，本质上只需要start和end差最大时的两个数

 删除字符串中的'b'和“ac"
 字符串遍历一遍
 不能使用额外的空间

字符串的不重复的全排列

- 包含重复字符 vs 不包含重复字符
- 递归实现 vs 非递归实现

> abc acb bac bca cab cba

自定义字符串排序:数字<大写字母<小写字母

1. 分类别
1. 每一个类别总按照字符顺序排序

[快排](http://blog.csdn.net/morewindows/article/details/6684558)

字符串 longString 是否 包含 shortString?

A里面的字符是否都在B里面？
1.依次遍历
2.转换成字典
3.字母映射成->素数后计算乘积


共同好友的算法：遍历，网状图

文章里面的单词统计

Leetcode:
Missing Number


N个孩子的年龄各不相同，排列成一排;年龄大的孩子比邻居分配的糖果多;至少需要多少个糖果

排序只含1、2、3的数组，不能统计个数

排序:<http://www.programgo.com/article/80453403362/>
BubbleSort √

```JavaScript
function bubbleSort(arr) {
    var i = arr.length, j;
    var tempExchangVal;
    while (i > 0) {
        for (j = 0; j < i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                tempExchangVal = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = tempExchangVal;
            }
        }
        i--;
    }
    return arr;
}
```

OddEventSort X // 多处理器,同时处理奇数序列和偶数序列
SelectSort √
InsertSort √
QuickSort √
ShellSort X // Knuth序列,Flamig序列
HeapSort X
MergeSort X

```Java
//希尔排序
	public void shellSort1(){
		int h=knuth();
		int i,j;
		Node temp;
		while(h>0){
			for(i=h;i<count;i++){
				temp=nodes[i];
				j=i;
				while(j>h-1&&temp.compare(nodes[j-h])){
					nodes[j]=nodes[j-h];
					j-=h;
				}
				nodes[j]=temp;				
			}
			h=(h-1)/3;
		}
	}
	public void shellSort2(){
		int i,j;
		Node temp;
		int h=count/2;
		while(h>0){
			for(i=h;i<count;i++){
				temp=nodes[i];
				j=i-h;
				while(j>=0&&temp.compare(nodes[j])){
					nodes[j+h]=nodes[j];
					j-=h;
				}
				nodes[j+h]=temp;
			}
			h/=2;
		}
	}
	//Knuth系列
	private int knuth(){
		int h=1;
		while(h<=count/3){
			h=3*h+1;
		}
		return h;
	}
	/**Flamig序列
	 * if(h<5)h=1;
	 * else h=(5*h-1)/11;	 * 
	 */
		
	//快速排序
	public void quickSort(){
		recQuickSort(0,count-1);
	}
	private void recQuickSort(int left,int right){
		if(right-left<=0)return;
		else{
			Node pivot=nodes[right];
			int partition=partitionIt(left,right,pivot);
			recQuickSort(left,partition-1);
			recQuickSort(partition+1,right);
		}
	}
	private int partitionIt(int left,int right,Node pivot){
		int	 leftPtr=left-1,rightPtr=right+1;
		while(true){
			while(leftPtr<right&&nodes[++leftPtr].compare(pivot));
			while(rightPtr>left&&pivot.compare(nodes[--rightPtr]));
			if(leftPtr>=rightPtr)break;
			else swap(leftPtr,rightPtr);
		}
		swap(leftPtr,right);
		return leftPtr;
	}
		
	//归并排序
	public void mergeSort(){
		Node[]arr=new Node[count];
		remergeSort(arr,0,count-1);
	}
	private void remergeSort(Node[]arr,int lower,int upper){
		if(lower==upper)return;
		else{
			int mid=(lower+upper)/2;
			remergeSort(arr,lower,mid);
			remergeSort(arr,mid+1,upper);
			merge(arr,lower,mid+1,upper);
		}
	}
	private void merge(Node[]arr,int lower,int high,int upper){
		System.out.println("I am merge..."+lower+"--"+high+"--"+upper);
		int j=0;
		int lowerBound=lower;
		int mid=high-1;
		int n=upper-lower+1;
		while(lower<=mid&&high<=upper){
			if(nodes[lower].compare(nodes[high])){
				arr[j++]=nodes[lower++];
			}else{
				arr[j++]=nodes[high++];
			}
		}
		while(lower<=mid)arr[j++]=nodes[lower++];
		while(high<=upper)arr[j++]=nodes[high++];
		for(j=0;j<n;j++)nodes[lowerBound+j]=arr[j];
	}
```