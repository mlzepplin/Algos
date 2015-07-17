import java.io.*;
import java.util.*;

public class Sol{
	public static void main(String args[])throws java.io.IOException{
		int x=5;
		search w=new search();
		w.array_builder();
		w.rot_index_returner(w.n);
		System.out.println(w.rot_index);
		w.refresh_variables();
		w.modified_binsearch(x);

	}
}

class search{
	public int n;
	private int last_index;
	private int a[];
	public int rot_index;
	private int low=0;
	private int high;
	private int mid;

	void array_builder()throws java.io.IOException{
		String s;
		System.out.println("enter array size");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		s=br.readLine();
		n=Integer.parseInt(s);
		a=new int[n];
		high=last_index=n-1;
		System.out.println("enter "+n+" numbers, keep pressing enter");
		for(int i=0;i<n;i++){
			s=br.readLine();
			a[i]=Integer.parseInt(s);
			System.out.println(a[i]);
		}
		System.out.println("done 1");

	}
	void rot_index_returner(int size){
		if(size==2){
			System.out.println("done 6");
			if(a[high]>=a[low])
				rot_index=high;
			else
				rot_index=low;	
			
		}
		else{
			mid=(int)(low+((high-low)/2));
			System.out.println("done 2");
			if((a[mid]>=a[low]) && (a[mid]<=a[high])){
				System.out.println("done 3");
				rot_index=high;
				break;
			}
			else if((a[mid]>=a[low]) && (a[mid]>a[high])){
				System.out.println("done 4");
				low=mid;
				size=n=high-low+1;
				rot_index_returner(size);
			}
			else if((a[mid]<a[low]) && (a[mid]<=a[high])){
				System.out.println("done 5");
				high=mid;
				size=n=high-low+1;
				rot_index_returner(size);
			}
			
		}
		
	}
	void refresh_variables(){
		low=0;
		high=last_index;
	}
	void binsearch(int x,int size,int first,int last){
		int middle;
		if(size==1){
			if(x==a[last])
				System.out.println("element found !! at index" + first);
			else
				System.out.println("element not found");
		}
		else if(last>first){
		
			middle=first+(last-first)/2;
			if(x==a[middle]){
				System.out.println("element found !! and is at index "+middle);
			}
			else if(x>a[middle]){
				first=middle+1;
				size=last-first+1;
				binsearch(x,size,first,last);
			}
			else{
				last=middle-1;
				size=last-first+1;
				binsearch(x,size,first,last);
			}
		
		}
		else{
			System.out.println("element not found");
		}
	}
	void modified_binsearch(int x){
	
		if((x<a[rot_index]) && (x<=a[last_index])){
			binsearch(x,last_index-rot_index,rot_index+1,last_index);
			
		}
		else if(x>=a[last_index]){
			binsearch(x,rot_index+1,0,rot_index);
		}
		if(x>a[rot_index]){
			System.out.println("number not in array !!");
		}

	}



}