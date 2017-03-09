import java.util.Random;
import java.util.Scanner;
import java.lang.String;
public class work {
    public static void main (String[] arge){
        System.out.println("*****请输入答题数*****");
        Scanner input =new Scanner(System.in);
        int num = input.nextInt();//答题数
        int right=0;//正确数
        int gb,gy;

        String result="";


        Random r = new Random();

        for(int i=0;i<num;i++){
            int s =r.nextInt(8);

            int a =r.nextInt(10);
            int b =r.nextInt(10)%10+1;

            int x =r.nextInt(10)%10+1;
            int y =r.nextInt(10)%10+1;

            switch(s){
                case 0:System.out.println("-----|"+a+"+"+b+"=?|-----");result=""+(a+b);
                    break;
                case 1:System.out.println("-----|"+a+"-"+b+"=?|-----");result=""+(a-b);
                    break;
                case 2:System.out.println("-----|"+a+"*"+b+"=?|-----");result =""+(a*b);
                    break;
                case 3:System.out.println("-----|"+a+"/"+b+"=?|-----");
                    if(a==0)
                        result="0";
                    else if(b==1)
                        result="b";
                    else
                        result=""+a+"/"+b;
                    break;
                case 4:System.out.println("-----|"+a+"/"+x+"+"+b+"/"+y+"=?|-----");
                    if(a==0)
                    {
                        if(b==0)
                            result="0";
                        else
                            result=b+"/"+y;
                    }
                    else
                    {
                        if(b==0)
                            result=a+"/"+x;
                        else
                        {
                            gb=tf1(x,y);
                            a=gb/x*a;
                            b=gb/y*b;

                            gy=tf2(a+b,gb);
                            result=(a+b)/gy+"/"+gb/gy;
                        }

                    }
                    break;
                case 5:System.out.println("-----|"+a+"/"+x+"-"+b+"/"+y+"=?|-----");
                    if(a==0)
                    {
                        if(b==0)
                            result="0";
                        else
                            result="-"+b+"/"+y;
                    }
                    else
                    {
                        if(b==0)
                            result=a+"/"+x;
                        else
                        {
                            gb=tf1(x,y);
                            a=gb/x*a;
                            b=gb/y*b;

                            gy=tf2(a-b,gb);
                            result=(a-b)/gy+"/"+gb/gy;
                        }
                    }
                    break;
                case 6:System.out.println("-----|"+a+"/"+x+"*"+b+"/"+y+"=?|-----");
                    if(a*b==0)
                        result="0";
                    else
                    {
                        gy=tf2(a*b,x*y);
                        result=a*b/gy+"/"+x*y/gy;

                    }
                    break;
                case 7:System.out.println("-----|"+a+"/"+x+"/"+b+"/"+y+"=?|-----");
                    if(a*y==0)
                        result="0";
                    else
                    {
                        gy=tf2(a*y,b*x);
                        result=a*y/gy+"/"+b*x/gy;

                    }
                    break;
            }
            String answer=input.next();
            System.out.println(answer);
            if(result.equals(answer))
            {
                System.out.println("正确！");
                right++;
            }
            else
                System.out.println("错误！");

        }


    }
    public static int tf1(int p,int q){
        int r,aa=p,bb=q;
        while(q!=0)
        {
            r=p%q;
            p=q;
            q=r;
        }
        int gb=aa*bb/p;
        return gb;
    }
    public static int tf2(int p,int q){
        int r;
        while(q!=0)
        {
            r=p%q;
            p=q;
            q=r;
        }
        return p;
    }
}