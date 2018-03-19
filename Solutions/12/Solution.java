public class Solution {
    public static String intToRoman1(int num) {
        //写法较复杂
        String r = "";
        if (num >= 1000){
            int m = num / 1000;
            for (int i=0; i < m; i++) r += "M";
            num = num % 1000;
        }
        if (num >= 500) {
            int c = (num - 500) / 100;
            if (c == 4) r += "CM";
            else {
                r += "D";
                for (int i=0; i < c; i++) r += "C";
            }
            num = num % 100;
        }
        if (num >= 100) {
            int c = num / 100;
            if (c == 4) r += "CD";
            else {
                for (int i=0; i < c; i++) r += "C";
            }
            num = num % 100;
        }
        if (num >= 50) {
            int x = (num - 50) / 10;
            if (x == 4) r += "XC";
            else {
                r += "L";
                for (int i=0; i < x; i++) r += "X";
            }
            num = num % 10;
        }
        if (num >= 10) {
            int x = num / 10;
            if (x == 4) r += "XL";
            else {
                for (int i=0; i < x; i++) r += "X";
            }
            num = num % 10;
        }
        if (num >= 5) {
            int I = num - 5;
            if (I == 4) r += "IX";
            else {
                r += "V";
                for (int i=0; i < I; i++) r += "I";
            }
            num = 0;
        }
        if (num >= 1) {
            int I = num;
            if (I == 4) r += "IV";
            else {
                for (int i=0; i < I; i++) r += "I";
            }
        }
        return r;
    }

    public static String intToRoman2(int num) {
        String r = "";
        char roman[] = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
        int value[] = {1000, 500, 100, 50, 10, 5, 1};
        for (int i = 0; i < 7; i += 2){
            int x = num / value[i];
            if (x < 4){
                for (int j = 0; j < x; j++) r += roman[i];
            } else if (x == 4){
                r = r + roman[i] + roman[i-1];
            } else if (x < 9){
                r += roman[i-1];
                for (int j = 5; j < x; j++) r += roman[i];
            } else if (x == 9){
                r = r + roman[i] + roman[i-2];
            }
            num = num % value[i];
        }
        return r;
    }

    public static String intToRoman(int num) {
        String r = "";
        String v1[] = {"", "M", "MM", "MMM"};
        String v2[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String v3[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String v4[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return v1[num / 1000] + v2[(num % 1000) / 100] + v3[(num % 100) / 10] + v4[num % 10];
    }
    public static void main(String[] args) {
        System.out.println(intToRoman(1286));
    }
}
