package app;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.print("Factors: " + factors(10));
    }

    public static String factors(int n) {
        String result = "";
        int prime = 2;
        while(n > 1){
            int count = 0;
            while((n % prime) == 0){
                count++;
                n = n / prime;
            }
            if (count > 1) result += "(" + prime + "**" + count + ")";
            else if(count == 1) result += "(" + prime + ")";

            prime = nextPrime(prime);
        }
        return result;
    }

    public static int nextPrime (int prime) {
        int newPrime = prime + 1;
        while(!checkPrime(newPrime)){
            newPrime++;
        }
        return newPrime;
    }

    public static boolean checkPrime(int n){
        int count = 0;
        for(int i = n; i > 0; i--){
            if((n % i) == 0) count++;
        }
        return count == 2;
    }
}