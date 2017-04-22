import java.util.Random;
import java.util.Scanner;
import java.lang.String;
import java.util.regex.Pattern;
public class work {
    public static void main (String[] arge){
        System.out.println("欢迎使用，输入“#”退出程序");
        System.out.println("*****请输入答题数*****");
        Scanner input =new Scanner(System.in);
        int num = input.nextInt();//答题数
        int right=0;//正确数
        int gb,gy;
        String [] record = new String[100];
        record[0]="";
        String result="";

        Random r = new Random();

        for(int i=0;i<num;i++){
            int s =r.nextInt(9);

            int a =r.nextInt(10);
            int b =r.nextInt(10)%10+1;

            int x =r.nextInt(10)%10+1;
            int y =r.nextInt(10)%10+1;
            while(a==x)  b=r.nextInt(9)+1;
            while(b==y)  x=r.nextInt(9)+1;
            String now=""+a+b;
            String now1=""+b+a;
            for(int j = 0;j < i;j++)
            {
                while(record[j].equals(now) || record[j].equals(now1))
                {
                    a = r.nextInt(10);
                    b = r.nextInt(9)+1;
                    while(a==b)  b=r.nextInt(9)+1;
                    now=""+a+b;
                    now1=""+b+a;
                    j=0;
                }
            }
            record[i]=now;

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
                case 8:System.out.print(a+"/"+x+" + "+b+"=?");
                    System.out.println("（若是分数，请化为a/b的形式）");
                    y=1;
                    gb=tf1(x,y);
                    result=(gb/x*a+gb*b)+"/"+gb;
                    break;
            }
            String answer=input.next();
            while(!isNumeric(answer)){
                System.out.println("输入不合法！请重新输入");
                answer=input.next();
            }
            while(answer.contains("/")){
                int fm0=answer.indexOf("/");
                String fm00=answer.substring(fm0+1);
                if(fm00.compareTo("0")==0){
                    System.out.println("输入错误! 请重新输入");
                    answer=input.next();
                }
                else break;
            }
            if (answer.compareTo("#") == 0) break;
            if(result.equals(answer))
            {
                System.out.println("正确！");
                right++;
            }
            else
                System.out.println("错误！");

        }
        System.out.println("答对"+right+"题，答错"+(num-right)+"题");
        System.out.println("正确率："+(1.0*right/num*100)+"%");

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
    public static boolean isNumeric(String str) {         //判断输入字符是否合法
        Pattern pattern = Pattern.compile("^[0-9]*$");
        if (str.contains("/") && str.contains("-")) {
            str = str.replaceFirst("/", "");
            str = str.replaceFirst("-", "");
        } else if (str.contains("/")) {
            str = str.replaceFirst("/", "");
        } else if (str.contains("-")) {
            str = str.replaceFirst("-", "");
        }
        return pattern.matcher(str).matches();
    }
}