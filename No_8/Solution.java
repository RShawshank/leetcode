package No_8;

public class Solution {
    public static void main(String[] args)
    {

    }
    public int myAtoi(String str) {
        //trim是去掉字符串首尾空格的
       if(str==null||(str.trim().isEmpty()))
           return 0;
       str=str.trim();
        char firstChar=str.charAt(0);
        int flag;
        char sign;
        if(firstChar=='-'||firstChar=='+')
        {
            flag=1;
            sign=firstChar;
        }
        else if(firstChar>='0'&&firstChar<='9')
        {
            flag=0;
            sign='+';
        }
        else
        {
            return 0;
        }
        int ans=0;
        for(int i=flag;i<str.length();i++)
        {
            char c = str.charAt(i);
            if(c<'0'||c>'9')
                break;
            int num=c-'0';
            if((Integer.MAX_VALUE-num)/10<ans)
                return sign=='+'?Integer.MAX_VALUE:Integer.MIN_VALUE;
            ans=ans*10+num;
        }
        return sign=='+'?ans:-ans;
    }
}
