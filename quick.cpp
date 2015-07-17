
#include<iostream>
using namespace std;

int partition(int *ar,int first,int last ){
	//PARTITION SUBROUTINEDOES:-MAINTAINS I ON THE LEFTMOST BIGGER_THAN_PIVOT ELEMENT IN THE REST OF THE ARRAY	
	int p,i,j;
	p=ar[first];
	i=first+1;
	for(j=first+1;j<last+1;j++)
	{
		if(ar[j]<p)
		{
			int temp;
			temp=ar[i];
			ar[i]=ar[j];
			ar[j]=temp;

			i++;
		}
	}
	ar[first]=ar[i-1];
	ar[i-1]=p;
	return i-1;
}
void quicksort(int *ar,int first,int last)
{
	int lim;
	if(last-first>0)
	{
		lim=partition(ar,first,last);
		quicksort(ar,first,lim-1);
		quicksort(ar,lim+1,last);
	}

	return ;
}

int main(){

	int	a[9]={6,7,9,5,8,1,4,3,23};
	int i;
	quicksort(a,0,8);
	for(i=0;i<9;i++)
	{
		cout<<a[i];
	}


}
