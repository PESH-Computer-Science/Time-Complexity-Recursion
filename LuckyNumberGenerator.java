package Week_2;

import java.util.ArrayList;

public class LuckyNumberGenerator {
    static ArrayList<Integer> al;
    // Generates lucky numbers from 0 to 1000
    //  Use it to solve the lucky number problems on the "List of Problems" (check Google Classroom)

    // Formula:
    //  We can get to new lucky numbers from our current one by doing
    //  luckyNumber * 10 + 4      EX:  47 ==> 47 * 10 + 4 = 474    a new lucky number
    //  luckyNumber * 10 + 7      EX:  47 ==> 47 * 10 + 7 = 477    a new lucky number
    // Base case is if luckyNumber > 100, we don't want to generate any more numbers since it would go over 1000

    // 47
    // 47_  ==>  474
    // 47_  ==>  477

    // 47 * 10 + 4
    // 47 * 10 + 7


    static void generate(int luckyNumber) {
        // We don't want to generate numbers larger than 1000
        if(luckyNumber >= 100)  return;
        // 2 new lucky numbers
        int lucky1 = luckyNumber * 10 + 4;
        int lucky2 = luckyNumber * 10 + 7;

        //Add the lucky numbers to the list
        al.add(lucky1);
        al.add(lucky2);

        //Recursively generate even more lucky numbers with these 2 new ones we just created
        generate(lucky1);
        generate(lucky2);
    }

    public static void main(String[] args) {
        al = new ArrayList<>();
        generate(0);
        System.out.println("Lucky Numbers: " + al.toString());
    }
}
