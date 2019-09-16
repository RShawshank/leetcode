package No_9;

public class Solution {
    public static void main(String[] args)
    {
        int x=10;
        boolean y=isPalindrome(x);
        System.out.print(y);
    }

    public static boolean isPalindrome(int x) {
        int y =  0;
        int z=x;
        if(z<0)
            return false;
        while(z!=0)
        {
            y=y*10+z%10;
            z=z/10;
        }
        if(x==y)
            return true;
        else
            return false;
    }
}
