package No_11;

public class Solution {
   /* public static void main(String[] args) {
            int []height= {1,8,6,2,5,4,8,3,7};
            System.out.print(maxArea(height));
    }
  /*  public static int maxArea(int[] height) {



    }
    /*
    public static int maxArea(int[] height) {
        int max=0;
        for(int i =0;i<height.length-1;i++)
        {
            for(int j=i+1;j<height.length;j++)
            {
                int temp = (j-i)*Math.min(height[i],height[j]);
                max=Math.max(max,temp);
            }
        }
        return max;
    }
    */
}
