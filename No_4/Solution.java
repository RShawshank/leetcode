package No_4;

public class Solution {
    public static void main(String[] args)
    {
        int []nums1 ={1,2,4,5,6,8};
        int []nums2={1};
        double result =findMedianSortedArrays(nums1,nums2);
        System.out.println(result);
    }
    /**
     * 可以计算第k小的数是怎么得到的。两组的第k/2进行比较，小的一组的前k/2-1一定是小于中位数的；
     * 所以可以排除。
     * 接下来就计算当前的两个数组中第k-（k/2-1）小的数
     * 考虑两点：
     * 当两组数的个数为奇数时，需要计算k/2和k/2+1小的数
     * 当一组数的个数小于k/2时，需要单独考虑：
     * 即将那组数的最大值与另一组的第k/2进行比较，操作同上。
     * */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2)
    {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int left = (length1+length2+1)/2;
        int right = (length1+length2+2)/2;
        return (getk(nums1,nums2,0,length1-1,0,length2-1,left)+getk(nums1,nums2,0,length2-1,0,length1-1,right))/2;
    }
    public static int getk(int []nums1,int []nums2,int start1,int end1 ,int start2,int end2,int k)
    {
        int len1 = end1-start1+1;
        int len2= end2-start2+1;
        int i = start1+Math.min(len1,k/2)-1;
        int j = start2+Math.min(len2,k/2)-1;
        if(len1>len2)return getk(nums2,nums1,start2,end2,start1,end1,k);
        if(len1==0)return nums2[start2+k-1];
        if(k==1) return Math.min(nums1[start1],nums2[start2]);
        if(nums1[i]>nums2[j])
        {
            return getk(nums1,nums2,start1,end1,j+1,end2,k-(j-start2+1));
        }
        else
        {
            return getk(nums1,nums2,i+1,end1,start2,end2,k-(i-start1+1));
        }
    }



















    /**
     * 本题要求的时间复杂度是log（m+n），所以这里采取的是二分查找
     * 对两个数组进行划分，但是保证划分的左边和右边的数一样多，这样中位数就在划分的数附近。
     * 同时为了进一步得到中位数，还得确定左边的最大数小于等于右边的最小数
     * * */
    /*
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
       int m = nums1.length;
       int n = nums2.length;
       if(m>n)
       {
           return findMedianSortedArrays(nums2,nums1);
       }
       int iMin =0,iMax =m;
        while(iMin<=iMax)
        {
            int i = (iMin+iMax)/2;
            int j = (m+n+1)/2-i;
            if(j!=0&&i!=m&&nums2[j-1]>nums1[i])
            {
                iMin=i+1;
            }
            if(i!=0&&j!=n&&nums1[i-1]>nums2[j])
            {
                iMin=i-1;
            }
            else{
                int maxleft= 0;
                if(i==0) maxleft=nums2[j-1];
                else if(j==0) maxleft=nums1[i-1];
                else maxleft=Math.max(nums1[i-1],nums2[j-1]);
                if((m+n)%2==1)return maxleft;

                int minRight=0;
                if(i==m) minRight=nums2[j];
                else if(j==n)minRight=nums1[i];
                else minRight=Math.min(nums2[j],nums1[i]);
                return (maxleft+minRight)/2.0;
            }
        }
        return 0.0;
    }*/
}

