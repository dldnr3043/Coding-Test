#include <iostream>

using namespace std;

int functionD(int n) {
    int a,b,c,d,e;
    
    a = n/10000;
    b = (n%10000)/1000;
    c = (n%1000)/100;
    d = (n%100)/10;
    e = n%10;
    
    return n+a+b+c+d+e;
}

int main()
{
    int ans;
    int n;
    
    for(ans=1;ans<=10000;ans++) {
        for(n=1;n<=10000;n++) {
            if(functionD(n) == ans) break;
        }
        if(n == 10001)
            printf("%d\n", ans);
       // if(ans > 10) break;
    }

    return 0;
}