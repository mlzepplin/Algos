public class OpBin{
	public static void main(String args[]){

	}
}
public class Search{
	public int m;
	public int[] x;
	public int boundary; 
	void array_builder()throws java.io.IOException{
		String s;
		System.out.println("enter array size");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		s=br.readLine();
		m=Integer.parseInt(s);
		x=new int[n];
		System.out.println("enter "+m+" numbers, keep pressing enter");
		for(int i=0;i<m;i++){
			s=br.readLine();
			x[i]=Integer.parseInt(s);
			System.out.println(x[i]);
		}
		//System.out.println("done 1");
	}
	int boundary_getter(){
		int i=0;
		while(x[i]!=0){
			i=2i;
		}
		return i;
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

}