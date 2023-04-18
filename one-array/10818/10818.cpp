#include <iostream>
using namespace std;

int main(){
    int n,min=0,max=0;
    cin>>n;
    int *a=new int[n];
    for(int i=0; i<n; i++){
        cin>>a[i];
    }
    max=min=a[0];
    
    for(int i=0; i<n; i++){
        if(max<a[i]){
            max=a[i];
        }
        if(min>a[i]){
            min=a[i];
        }
    }
    cout<<min<<" "<<max<<endl;
    delete[] a;
}