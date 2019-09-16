package No_6;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args)
    {
        String input="ABC";
        int num=1;
        String ouput=convert(input,num);
        System.out.print(ouput);
    }

    /**
     * 这是leecode上提供的方法，和我的方法本质上是没有区别的
     * 但是在一些处理上显得更加好
     *
     *
     * */
    public static String convert(String s, int numRows) {
        if (numRows == 1) return s;
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }
        int currow = 0;
        boolean go = false;
        for (char c : s.toCharArray()) {
            rows.get(currow).append(c);
            if (currow == 0 || currow == numRows - 1) go = !go;
            currow += go ? 1 : -1;
        }
        StringBuilder ret = new StringBuilder();
        for (StringBuilder row:rows)
            ret.append(row);
        return ret.toString();
    }

















/**
 * 二维数组在时间和空间上都不是很讨巧
 * */
/*
    public static String  convert(String s, int numRows) {
        int length=s.length();
    char [][]num=new char[numRows+1][length];
for(int i=0;i<numRows+1;i++)
            for(int j=0;j<length;j++)
    num[i][j]='0';
            if(numRows==1)
                return s;
    int counter=1;
    boolean flag1=false;
    boolean flag2=false;
          for(int j=0;j<length;j++)
    {
        char temp=s.charAt(j);
        num[counter][j]=temp;
        if(counter==1){flag1=true;flag2=false;}
        if(counter==numRows){flag1=false;flag2=true;}
        if(flag1==true) {
            counter++;
        }
        else if(flag2==true)
        {
            counter--;
        }

    }



    char[]output = new char[length];
    int m=0;
          for(int i=1;i<=numRows;i++)
    {
        for(int j=0;j<length;j++)
        {
            if(num[i][j]!='0')
            {
                output[m]=num[i][j];
                m++;
            }
        }
    }
    String out=new String(output);
          return out;
}
*/
}
