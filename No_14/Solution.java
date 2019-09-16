package No_14;

public class Solution {
    public static void main(String[] args) {
        String[] a = {"flow", "flwa"};
        System.out.print(longestCommonPrefix(a));
    }
    public static String longestCommonPrefix(String[] strs) {
    if(strs.length ==0)return"";
    String prefix = strs[0];
   for(int i = 1; i<strs.length;i++)
            while(strs[i].indexOf(prefix) !=0)
    {
        prefix = prefix.substring(0, prefix.length() - 1);
        if (prefix.isEmpty()) return "";
    }
   return prefix;
}
/*
    public static String longestCommonPrefix(String[] strs) {
        int length = strs.length;
        int j,min;
        if(strs.length==0)
            min=0;
        else
            min=strs[0].length();

        for(int i=0;i<length;i++)
        {
             min= (min>strs[i].length())?strs[i].length():min;
        }
        List<Character> output = new ArrayList<Character>();
        int flag_out=0;
        for(j=0; j < min;j++) {
            if(flag_out==1)
                break;
            int flag=1;
            if (length==1)
                output.add(strs[0].charAt(j));
            for (int i = 1; i < length; i++) {
                char temp = strs[0].charAt(j);
                if (temp != strs[i].charAt(j))
                {
                    flag_out=1;
                    break;
                }
                else
                    flag++;
                if(flag==strs.length)
                    output.add(temp);
            }
        }
        if(output.size()==0)
            return "";
        StringBuilder builder = new StringBuilder(output.size());
        for(Character ch:output)
        {
            builder.append(ch);
        }
        return builder.toString();
    }
    */
}
