#include <iostream>
using namespace std;

int main(){
    int j,k;
    cin>>j>>k;
    cout<<j*(k%10)<<endl;
    cout<<j*(k%100/10)<<endl;
    cout<<j*(k/100)<<endl;
    cout<<j*k<<endl;
}