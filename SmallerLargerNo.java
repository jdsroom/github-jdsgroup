/*
Write a java program to find the largest number ‘L’ less than a given number ‘N’ which should not contain digits in given 
number 'N'. For example, If 2867 is the given number, then you should find the largest number less than 2867 such that it 
should not contain digits 2, 8, 6 , 7 in it(irrespective of index). In this case, 1999 will be the answer
*/
import java.util.*;
class SmallerLargerNo 
{
	//This method will provide the resultant output
	public static int smallerLargeNo(int number){
	  int digit;
	  int[] resultArray=intToArray(number);
	  Set<Integer> set=new HashSet();
	  for(int a:resultArray){
	    set.add(a);
	  }
	  for(int i=1;i<resultArray.length;i++){
		  digit=9;
	      while(set.contains(digit)){
		    digit--;
		  }
		  resultArray[i]=digit;
	  }
	  resultArray[0]=resultArray[0]-1;
	  while(resultArray[0]>0&&set.contains(resultArray[0]))
		  resultArray[0]-=1;
	  return arrayToInt(resultArray);
	}

	//this method will convert int to int[]
	public static int[] intToArray(int number){
	  int i=1;
	  int length=Integer.toString(number).length();
	  int[] resultArray=new int[length];
	  while(number!=0){
	   resultArray[length-i]=number%10;
	   number=number/10;
       i++;
	  }
	  return resultArray;
	}
	
	//this method will convert int[] to int
	public static int arrayToInt(int[] array){
	 int i=10;
	 int number=0;
	 for(int a:array){
	  number=number*10+a;
	 }
	  return number;
	}

	public static void main(String[] args) 
	{
		//Testing cases and output for different inputs 
		System.out.println(smallerLargeNo(2867));//o/p->1999
		System.out.println(smallerLargeNo(2869));//o/p->1777
		System.out.println(smallerLargeNo(1869));//o/p->777
		System.out.println(smallerLargeNo(9869));//o/p->7777
		System.out.println(smallerLargeNo(9999));//o/p->8888
		System.out.println(smallerLargeNo(1));//o/p->0
		System.out.println(smallerLargeNo(12));//o/p->9
		System.out.println(smallerLargeNo(19));//o/p->8
		System.out.println(smallerLargeNo(18));//o/p->9
	}
}
