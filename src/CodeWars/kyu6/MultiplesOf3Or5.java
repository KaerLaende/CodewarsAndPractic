package CodeWars.kyu6;
/*
If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
The sum of these multiples is 23.

Finish the solution so that it returns the sum of all the multiples of 3 or 5 below the number passed in.
Additionally, if the number is negative, return 0 (for languages that do have them).

Note: If the number is a multiple of both 3 and 5, only count it once.
 */


public class MultiplesOf3Or5 {
    public static int test = 10; //answer 23
    public static int solution(int number) {
        int summ=0;
        int[] array = new int[number];
        for (int i = 0; i <array.length-1; i++) {
            array[i]=i+1;
            if (array[i]%3==0||array[i]%5==0){
                summ+=array[i];
            }
        }
        return summ;
    }


    public static void main(String[] args) {
        System.out.println(solution(test));
    }

}
