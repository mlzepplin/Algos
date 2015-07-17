import java.io.*;
import java.lang.*;
public class lcs{

	public static void main(String args[]) throws IOException{


		temp obj = new temp();
		obj.initVars();
		obj.allocArray();
		obj.displayArray();
		obj.arrayUpdate();
		obj.displayArray();
		obj.traverse(8,8);
		//obj.displayString();
	}
}

class temp{
	private int m;
	private int n;
	private String one;
	private String two;
	private String subsequence;
	private int strPositionCount=0;
	private class item{
		public int value;
		public char arrow;
		public item(){
			value = 0;
			arrow = 'n';
		}
	}	
	private item[][] arr;

	void initVars()throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("enter string 1");
		one = br.readLine();
		System.out.println("enter string 2");
		two = br.readLine();
		n=one.length();	
		m=two.length();
	}	
	void allocArray()throws java.lang.NullPointerException{
		arr = new item[m+1][n+1];

		for(int i=0;i<m+1;i++){

			for(int j=0;j<n+1;j++){

				arr[i][j].value = 0;
			}
		}
	}

	void displayArray(){
		for(int i=0;i<m+1;i++){

			for(int j=0;j<n+1;j++){

				System.out.print(arr[i][j].value);
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	void arrayUpdate(){
		for(int i=1;i<m+1;i++){
			for(int j=1;j<n+1;j++){

				if(one.charAt(j-1) == two.charAt(i-1)){

					arr[i][j].value=arr[i-1][j-1].value +1;
					arr[i][j].arrow='d';//diagonal
				}
				else if(arr[i][j-1].value>=arr[i-1][j].value){

					arr[i][j].value = arr[i][j-1].value;
					arr[i][j].arrow = 'l';//left
				}
				else{
					
					arr[i][j].value = arr[i-1][j].value;
					arr[i][j].arrow = 'u';//up

				}
			}
		}
	}
	void traverse(int i,int j){

			//while(arr[i][j].value!=0){

		if(arr[i][j].value == 0){
			return ;
		}

		else if(arr[i][j].arrow == 'd'){
			char c = one.charAt(j-1);
			//subsequence.setCharAt(strPositionCount,c);
			//strPositionCount++;
			System.out.print(c);
			traverse(i-1,j-1);
		}
		else if(arr[i][j].arrow == 'u'){
			traverse(i-1,j);
		}
		else{
			traverse(i,j-1);
		}
	}
	void displayString(){
		System.out.println(subsequence);
	}
}
