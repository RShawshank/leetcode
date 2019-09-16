package No_13;

public class Solution {
    public static void main(String [] args)
    {
        String s="MCMXCIV";
        System.out.print(romanToInt(s));
    }
    public static int romanToInt(String s) {
        int length=s.length();
        char temp;
        char next;
        int all=0;
        for(int i=0;i<length;i++)
        {
            temp =s.charAt(i);
            if(i+1==length) next = 0;
            else  next =s.charAt(i+1);
            if(temp=='I'&&next=='V')
            {
                all+=4;   i++;
            }
            else if (temp=='I'&&next=='X')
            {
                all+=9;   i++;
            }
            else if(temp=='X'&&next=='L')
            {
                all+=40; i++;
            }
            else if(temp=='X'&&next=='C')
            {
                all+=90; i++;
            }
            else if(temp=='C'&&next=='D')
            {
                all+=400; i++;
            }
            else if(temp=='C'&&next=='M')
            {
                all+=900; i++;
            }
            else {
                switch (temp) {
                    case 'I':
                        all += 1;
                        break;
                    case 'V':
                        all += 5;
                        break;
                    case 'X':
                        all += 10;
                        break;
                    case 'L':
                        all += 50;
                        break;
                    case 'C':
                        all += 100;
                        break;
                    case 'D':
                        all += 500;
                        break;
                    case 'M':
                        all += 1000;
                        break;
                }
            }
        }
        return all;
    }

}
