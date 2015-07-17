import java.io.*;
import java.util.*;

public class quick{
	public static void main(String args[])throws java.io.IOException{
	Quicksort obj=new Quicksort();
	obj.arrayBuilder();
	obj.sort(0,obj.n-1,obj.n);
	System.out.println(obj.a);

		
	}
}

class Quicksort{

	public	int a[];
	public int n;
	public void arrayBuilder()throws java.io.IOException{
	System.out.println("no. of elements you want?");
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	String input;
	input=br.readLine();
	n=Integer.parseInt(input);
	a=new int[n];
	for(int i=0;i<n;i++){
	input=br.readLine();
	a[i]=Integer.parseInt(input);
	}
	System.out.println("array built");
	}
	public void sort(int first,int last,int size){
	if(last-first>0){
	int pivot=first;
	int i=pivot;
	int j;
	for(j=pivot+1;j<size;j++){
	if(a[j]<=a[pivot])
	swap(i+1,j);
	i++;
	}
	swap(pivot,i+1);
	sort(first,i,first-i+1);
	sort(i+2,last,last-i-1);
	}
	else return;
	}
	public void swap(int x,int y){
	int temp;
	temp=a[x];
	a[x]=a[y];
	a[y]=temp;
	}
	
}
	
	
