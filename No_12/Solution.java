package No_12;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        int i = in.nextInt();
        System.out.printf(intToRoman(i));
    }
    public static String intToRoman(int num) {
        int thousand = num / 1000;
        int hundred = num % 1000 / 100;
        int ten = num % 100 / 10;
        int one = num % 10;
        char[] output = new char[100];
        int now=0;
        if (thousand != 0)
        {
            for (int i = 0; i < thousand; i++)
                output[now++] = 'M';
        }
        if(hundred!=0)
        {
          if(hundred==9)
          {
              output[now++]='C';
              output[now++]='M';
          }
          else if(hundred<9&&hundred>4) {
              output[now++] = 'D';
              int i = hundred - 5;
              while (i != 0) {
                  output[now++] = 'C';
                  i--;
              }
          }
          else if(hundred==4)
          {
              output[now++]='C';
              output[now++]='D';
          }
          else
          {
              for(int i=0;i<hundred;i++)
                  output[now++]='C';
          }
        }
        if(ten!=0)
        {
            if(ten==9) {
                output[now++]='X';
                output[now++]='C';
            }
            else if(ten<9&&ten>4)
            {
                output[now++] = 'L';
                int i = ten - 5;
                while (i != 0) {
                    output[now++] = 'X';
                    i--;
                }
            }
            else if(ten==4)
            {
                output[now++]='X';
                output[now++]='L';
            }
            else
            {
                for(int i=0;i<ten;i++)
                    output[now++]='X';
            }
        }
        if(one!=0){
            if(one==9) {
                output[now++]='I';
                output[now++]='X';
            }
            else if(one<9&&one>4)
            {
                output[now++] = 'V';
                int i = one - 5;
                while (i != 0) {
                    output[now++] = 'I';
                    i--;
                }
            }
            else if(one==4)
            {
                output[now++]='I';
                output[now++]='V';
            }
            else
            {
                for(int i=0;i<one;i++)
                    output[now++]='I';
            }
        }
        String out=new String(output);
        return out;
    }
}
