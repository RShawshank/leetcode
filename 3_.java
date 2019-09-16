package leecode_3;

import java.util.LinkedList;
public class main
{
    public int lengthOfLongestSubstring(String s)
    {
        int num=0;//记录子串个数的最大数量
        LinkedList<Character> list=new LinkedList();
        char [] arry=s.toCharArray();
        if(s.length()==1)
            return 1;
        else
        {
            for(int i=0;i<arry.length;i++)
            {
                if(list.contains(arry[i])==true)
                {
                    num=list.size()>=num?list.size():num;
                    list.clear();
                }
                list.add(arry[i]);
            }
            return num;
        }
    }
    public static void main(String[] args)
    {
        String s="au";
        main sl=new main();
        sl.lengthOfLongestSubstring(s);
    }
}
