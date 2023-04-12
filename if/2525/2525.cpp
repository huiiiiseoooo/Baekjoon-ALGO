#include <iostream>
using namespace std;

int main(){
    int h,m,settime;
    cin>>h>>m;
    cin>>settime;
    m=m+settime;
    while(m>=60){
            h=h+1;
            m=m-60;
            if(h>=24){
                h=h-24;
            }
    }
    cout<<h<<" "<<m<<endl;

}