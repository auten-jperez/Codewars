package app;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Subsequence: 1 should return: abc, and return: " + lcs("abcdefg", "abc"));
        System.out.println("Subsequence: 2 should return: acf, and return: " + lcs("abcdefg", "acf"));
        System.out.println("Subsequence: 3 should return: 12356, and return: " + lcs("132535365", "123456789"));
        System.out.println("Subsequence: 4 should return: AANA, and return: " + lcs("BANANA", "ATANA"));
        System.out.println("Subsequence: 5 should return: ATATO, and return: " + lcs("BATATO", "PATATO"));
        System.out.println("Subsequence: 6 should return: __, and return: " + lcs("BATATO", ""));
        System.out.println("Subsequence: 7 should return: __, and return: " + lcs("", "PATATO"));
        System.out.println("Subsequence: 8 should return: __, and return: " + lcs("", ""));
        System.out.println("Subsequence: 9 should return: BANANA, and return: " + lcs("BANANA", "BANANA"));
    }

    public static String lcs(String x, String y) {
        if(x.isEmpty() || y.isEmpty()) return "";
        if(x.equals(y)) return x;
        String LCS = checkLCS(x, y);
        return LCS;
    }

    private static String checkLCS(String x, String y) {
        String LCS = "";
        int position = 0;
        while(x.length() > 0 && y.length() > 0){
            if(position == x.length()){
                y = y.substring(1, y.length());
                position = 0;
            }else if(x.charAt(position) == y.charAt(0) && position < x.length()){
                position++;
                LCS += y.charAt(0);
                y = y.substring(1, y.length());
                x = x.substring(position, x.length());
                position = 0;
            }else{
                position++;
            }
        }
        return LCS;
    }
}