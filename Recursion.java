package Week_2;

public class Recursion {

    //fact(n) --> n!


    // 4! = 4 * 3!
    // n! = n * (n - 1)!

    // Base Case
    // Recursive call
    static int fact(int n){
        if(n == 1) return 1;
        return n * fact(n - 1);
    }

    // nth fibonacci = n-1th fibonacci + n-2nd fibonacci
    // 0 1
    static int fib(int n){
        if(n == 1) return 0;
        if(n == 2) return 1;
        return fib(n-1) + fib(n-2);
    }


    public static void main(String[] args) {
        int n = 10;
        System.out.println(fact(n));

        System.out.println(fib(n));

    }

}
