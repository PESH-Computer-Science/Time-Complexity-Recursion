package Week_2;

public class ArraySum_Recursive {
    // Program to recursively calculate the sum of elements in an array.


    // Recursive formula:
    //  Sum of elements from position i to the end of array
    //     = (element at position i) + (sum of elements from position i + 1 to the end of the array)
    //  OR
    //  findSum(position) = ar[position] + findSum(position + 1)
    // Base Case:
    //   our position is at the end of the array - There are no more elements after it so we simply return the
    //    value of the element

    static int findSum(int pos, int[] ar) {
        //End of array
        if (pos == ar.length - 1) return ar[pos];
        // Sum = current position + sum of rest of array (rest of array is from pos+1 to the end)
        return ar[pos] + findSum(pos + 1, ar);
    }

    public static void main(String[] args) {
        int[] ar = {1, 2, 3, 4, 5, 6};

        int sum = findSum(0, ar);
        System.out.println("Sum: " + sum);
    }
}
