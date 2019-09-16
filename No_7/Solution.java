package No_7;

public class Solution {
    public static void main(String [] args)
    {
        int x=1534236469;
        long z = reverse(x);
        System.out.print(z);
    }
    public static long reverse(int x) {
        long rev=0;
        int pop=0;
        while(x!=0)
        {
            pop=x%10;
            x=x/10;
            rev=rev*10+pop;
            if(rev>Integer.MAX_VALUE||(rev==Integer.MAX_VALUE/10&&pop>Integer.MAX_VALUE%10))return 0;
                if(rev<Integer.MIN_VALUE||(rev==Integer.MIN_VALUE/10&&pop<Integer.MIN_VALUE%10))return 0;

        }
        return rev;
    }
}
