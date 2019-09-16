package No_5;

import javax.swing.plaf.synth.SynthTextAreaUI;

public class Solution {
    public static void main(String[] args)
    {
    String s ="cbba";
    String longest = longestPalindrome(s);
    System.out.print(longest);
    }
    /**
     * 此方法是采取动态规划b
     *具体的步骤可以参照leecode官方的解题步骤
     * */
    /*
    public static String longestPalindrome(String s) {
        String longest = "";
        int length=s.length();
        boolean[][] p = new boolean[length][length];
        int max=0;
        for(int len=1;len<=length;len++)//长度从1开始逐一判断
            for(int start=0;start<length;start++)
            {
                int end = start+len-1;
                if(end>=length)break;
                p[start][end]=((len==1||len==2||(p[start+1][end-1]))&&(s.charAt(start)==s.charAt(end)));
                if(p[start][end]&&len>=max)
                {
                    longest=s.substring(start,end+1);
                    max=len;
                }
            }
        return longest;
    }
*/
/**
 * 拓展中心算法
 * 从一个数展开和从两个数之间展开
 * */
/*
public static String longestPalindrome(String s) {
    String longest = "";
    int length=s.length();
    int start=0,end=0;
    int len=0;
    if(length==0)
        return longest;
    for(int i= 0;i<length;i++)
    {
        int len1=expandaround(s,i,i);
        int len2=expandaround(s,i,i+1);
        len=(len1>=len2)?len1:len2;
        if(len>end-start)
        {
            start=i-(len-1)/2;
            end=i+len/2;
        }
    }
    longest=s.substring(start,end+1);
    return longest;
}
public static int expandaround(String s,int start,int end)
{
    //有个问题就是边界处不好处理
    while(end<s.length()&&start>=0&&s.charAt(start)==s.charAt(end))
    {
            start -= 1;
            end+=1;
    }
    return end-start-1;
}
*/
/**
 *采取马拉车算法
 * */
public static String longestPalindrome(String s) {
    String longest = "";
    if(s.length()==0)
        return longest;
   String s1=pre(s);
   int length=s1.length();
   int [] RL= new int[length];//回文串的半径
   for(int i=0;i<length;i++)
       RL[i]=0;
   int MAXRight=0;//所求回文串的达到最右边字符的位置
   int pos=0;//MaxRight对应的回文串的对称轴所在的位置
    int len=0;//回文串的最大半径
    int len_i=0;//回文串最大版半径所在的对称轴位置
for(int i=0;i<length;i++)
{
    if(i<MAXRight) {
        RL[i] = Math.min(RL[2 * pos - i], MAXRight - i);
    }
    else
        RL[i]=1;
    while(i-RL[i]>=0&&i+RL[i]<length&&s1.charAt(i-RL[i])==s1.charAt(i+RL[i]))
        RL[i]+=1;
    if(RL[i]+i-1>MAXRight) {
        MAXRight = RL[i] + i - 1;
        pos = i;
    }
    if(len<RL[i]) {
        len = RL[i];
        len_i=i;
    }
}
if(s1.charAt(len_i)=='#')
{
    longest=s.substring(len_i/2-1-((len-1)/2-1),len_i/2+(len-1)/2);
}
else
{
    longest=s.substring(len_i/2-(len-1)/2,len_i/2+(len-1)/2+1);
}
    return longest;
}
public static String pre(String s)
{

    String s1="";
    for(int i=0;i<s.length();i++)
    {
        s1+="#"+s.charAt(i);
    }
    s1+="#";
    return s1;
}












    /**
    * 这是采取暴力的做法，非常耗时
    *
    * */
/*
    public static boolean isPalindrome(String s)
    {
        int num=s.length();
        int j=num-1;
        int i=0;
        while(i<=num/2)
        {
            char a = s.charAt(i);
            char b = s.charAt(j);
            if(a!=b) return false;
            else
            {
                i++;
                j--;
            }
        }
        return true;
    }
    public static String longestPalindrome(String s) {
        String longest = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String temp = s.substring(i, j);
                if (isPalindrome(temp) == true) {
                    if(longest.length()<temp.length())
                        longest=temp;
                }
            }
        }
        return longest;
    }
*/
}
