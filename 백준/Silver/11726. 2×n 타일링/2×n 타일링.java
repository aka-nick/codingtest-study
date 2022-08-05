import java.util.*;
interface Main {
static void main(String[] args) {
 Scanner s=new Scanner(System.in);
 int n=s.nextInt(),a=1,b=1,i=1,f;
 while(i++<n){f=(a+b)%10007;a=b;b=f;}
 System.out.println(b);
}
}