package Week_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LuckySum {

    // We will use recursion to generate the lucky numbers since there are too many of them.
    static ArrayList<Long> luckynumbersList;

    // If you remember last week when we discussed recursion,
    //  We can generate 2 new luckynumbers from one original
    // by doing luckyNumber * 10 + 4
    // and doing luckyNumber * 10 + 7
    // For more details see the Recursion code I posted under Week 2 or Solution (I think)
    static void generateLucky(int length, long luckyNumber) {
        // Need to stop recursing at some point - When number has more than 10 digits we can stop
        if (length == 10) return;
        // 2 new lucky numbers
        luckynumbersList.add(luckyNumber * 10 + 4);
        luckynumbersList.add(luckyNumber * 10 + 7);
        // Recursively generate more luckynumbers with our new 2 we calculated
        // Don't forget to increase the length of our luckyNumbers by 1 now since we added ad digit (a 4 or a 7)
        generateLucky(length + 1, luckyNumber * 10 + 4);
        generateLucky(length + 1, luckyNumber * 10 + 7);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        luckynumbersList = new ArrayList<>();
        long l = sc.nextLong();
        long r = sc.nextLong();
        // Generate lucky numbers
        generateLucky(0, 0);

        // We need to sort the lucky numbers after generating them
        Collections.sort(luckynumbersList);

        // This will be our answer
        long sum = 0;
        // We are trying to find the position in the luckyNumbers List where the lucky # at that position is greater than
        //  the left value (starting point) of our interval.
        int pos = 0;
        for (int i = 0; i < luckynumbersList.size(); i++) {
            // We found the first lucky number >= to the START of our interval.
            if (luckynumbersList.get(i) >= l) {
                pos = i;
                break;
            }
        }
        // Do the same thing except for the right side.
        //  Note: you could've found pos and pos2 in one for loop instead of 2.
        int pos2 = 0; //
        for (int i = 0; i < luckynumbersList.size(); i++) {
            // We found the first lucky number >= to the END of our interval.
            if (luckynumbersList.get(i) >= r) {
                pos2 = i;
                break;
            }
        }
        // Now we do some math. If the smallest lucky number larger than both our numbers is the same, that means
        //  We can easily calculate their sum
        // README: You NEED a paper and pencil for solving computer science problems
        //  If you haven't attempted finding a pattern in the data, then try making observations on your own before looking at the code below.
        if (pos == pos2) {
            // This is just some math
            // EX:  l = 8, r = 12
            // Interval is :    8   9   10  11  12  13
            // Lucky Numbers:   47  47  47  47  47  47
            // If pos == pos2, the luckynumbers for left and right (8 and 13) are the same
            // So we just find the # of numbers in the interval (r - l + 1) and multiply it by the luckyNumber for the start
            sum = (r - l + 1) * luckynumbersList.get(pos);
        } else {
            // The interval spans over different lucky numbers
            // EX: l = 2  r = 7
            // Interval: 2  3  4  5  6  7
            // Lucky #s: 4  4  4  7  7  7
            // TRY TO FIND A FORMULA ON YOUR OWN BEFORE LOOKING AT THE CODE BELOW
            sum = (luckynumbersList.get(pos) - l + 1) * luckynumbersList.get(pos);
            // To calculate the sum of this interval, we find the difference from l's lucky number to l (# of #s between l and its lucky number)
            //          (Note that all numbers in this interval share the same luckynumber.)
            //  and multiply that by the luckyNumber.
            // Do the similar thing for r's lucky number (that is we are calculating the sum of lucky numbers for  (largest lucky # smaller than r, r)
            sum += luckynumbersList.get(pos2) * (r - luckynumbersList.get(pos2 - 1));

            // We know that the lucky numbers in between r's and l's lucky are full intervals
            for (int i = pos + 1; i <= pos2 - 1; i++)
                sum += (luckynumbersList.get(i) - luckynumbersList.get(i - 1)) * luckynumbersList.get(i);
        }
        // Print answer
        System.out.println(sum);
    }
}
