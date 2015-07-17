#include<iostream>
using namespace std;
	
class merge{
	public:
	int *ar;
	void partition(int low,int high){
	if(high-low+1>1){
		int mid=low+(high-low)/2;
		partition(low,mid);
		partition(mid+1,high);
		merge_sub(low,high,mid);
		
		}
	return;
	}
	void merge_sub(int low,int high,int mid){
	int i=low;
	int k=0;
	int j=mid+1;
	int out[high-low+1];//important note: it sannot be out[mid+1] (think why)
	while(i!=mid+1 && j!=high+1){

		if(ar[i]<ar[j]){
		out[k]=ar[i];
		i++;
		k++;
		}
		else{
		out[k]=ar[j];
		j++;
		k++;
		}
	}

	while (i <= mid)
	{
	out[k] = ar[i];
	k++;
	i++;
  	  }

    	while (j <= high)
   	 {
        out[k] = ar[j];
	k++;
	j++;
	}

	for(i=low,j=0;i<(low+k),j<k;i++,j++){
	ar[i]=out[j];
	}
	}
	void display(int size){
	for(int i=0;i<size;i++)
	cout<<ar[i]<<' ';
	}
};
	
int main(){
	int a[9]={1,7,5,30,8,46,2,4,9};
	merge obj;
	obj.ar=a;
	obj.partition(0,8);
	obj.display(9);
}
	
	
