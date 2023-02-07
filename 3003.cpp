#include <iostream>
using namespace std;
int main(){
    int i[]={1,1,2,2,2,8};
    int j[6];
    for(int k=0; k<6; k++){
        cin>>j[k];
    }
    for(int k=0; k<6; k++){
        if(i[k]==j[k]){
            cout <<"0 ";
        }
        else if(i[k]<j[k]){
            cout<<i[k]-j[k]<<" ";
        }
        else{
            cout<<i[k]-j[k]<<" ";
        }
    }
}