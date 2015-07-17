import java.io.*;
import java.util.*;

public class Inv{
	public static void main(String args[])throws java.io.IOException{

		Invert obj;
		obj=new Invert();
		obj.array_builder();
		int main_array[]=new int[(obj.n)];
		main_array=obj.partition(obj.x,((obj.n)-1),0);
		System.out.println(main_array);
		System.out.println("number of inversions =" + obj.number_of_inversions);


	}
}
class Invert{
	public int n;
	public int x[];
	public int number_of_inversions=0;
	void array_builder()throws java.io.IOException{
		String s;
		System.out.println("enter array size");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		s=br.readLine();
		n=Integer.parseInt(s);
		x=new int[n];
		System.out.println("enter "+n+" numbers, keep pressing enter");
		for(int i=0;i<n;i++){
			s=br.readLine();
			x[i]=Integer.parseInt(s);
			System.out.println(x[i]);
		}
		System.out.println("done 1");
		for(int i=0;i<n;i++)
		System.out.println(x[i]);
	}
	int[] merge_and_count(int r[],int r_size,int s[],int s_size){
		int i=0;int j=0;int k=0;
		int[] merger=new int[(r_size + s_size)];
		while(i!=r_size || j!=s_size){
			System.out.println("done 2");
			if(i==r_size){
				merger[k]=s[j];
				j++;
				k++;
			}
			else if(j==s_size){
				number_of_inversions++;
				merger[k]=r[i];
				i++;
				k++;
			}
			else if(r[i]<=s[j]){
				System.out.println("done 3");
				merger[k]=r[i];
				i++;
				k++;
			}
			else if(r[i]>s[j]){
				System.out.println("done 4");
				merger[k]=s[j];
				number_of_inversions++;
				j++;
				k++;
			}


		}
		return merger;
	}
	int[] partition(int p[],int high,int low){
		
		if(high==low){
			System.out.println("done 5");
			return p;
		}
		else{
			System.out.println("done 6");

			int middle=(int)(low+(high-low)/2);
			int[] a=new int[(middle-low+1)];
			int[] b=new int[(high-middle)];
			int[] c=new int[(high-low+1)];
			a=partition(p,middle,low);
			for(int i=0;i<a.length;i++)
			System.out.println(a[i]);
			b=partition(p,high,middle+1);
			for(int i=0;i<b.length;i++)
			System.out.println(b[i]);
			c=merge_and_count(a,(middle-low+1),b,(high-middle));
			for(int i=0;i<c.length;i++)
			System.out.println(c[i]);
			return c;

		}
	
	}
}