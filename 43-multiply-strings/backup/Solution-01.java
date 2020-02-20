import java.util.ArrayList;
// Completely wrong. This class works, but I misunderstood the problem.
// this class can add two string, e.g. num1= "12", num2="345";
// result will be a string sum="357"
// But the problem wanna multiply two strings


class Solution {
    public String multiply(String num1, String num2) {
        ArrayList<Integer> val1 = new ArrayList<Integer>();
        ArrayList<Integer> val2 = new ArrayList<Integer>();
        ArrayList<Integer> finalSum = new ArrayList<Integer>();

        String[] s1 = num1.split("");
        String[] s2 = num2.split("");

        int len1 = s1.length;
        int len2 = s2.length;

        for (int k=0; k<len1; k++) {
            val1.add(Integer.parseInt(s1[k]));
        }

        for (int j=0; j<len2; j++) {
            val2.add(Integer.parseInt(s2[j]));
        }

        if (len1 < len2) { // make sure that val1 is the longer one, this will be more convenient
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp = val1;
            val1 = val2;
            val2 = temp;
            len1 = val1.size(); // do not forget to change lens
        }

        extendShortList(len1, val2);
        len2 = len1;


        //finalSum.set(0, 0); // I think this may not be necessary, cause default is 0
        int prevCarry = 0;
        int currentCarry = 0;
        while (len1 > 0) {
            prevCarry = currentCarry;

            int a = val1.get(len1-1);
            int b = val2.get(len2-1);
            int[] sum = sumOneDigit(a, b);
            currentCarry = sum[0];

            finalSum.add(0, (sum[1] + prevCarry)%10);
            if (sum[1] + prevCarry == 10) currentCarry++;

            len1--; // actually len 1 == len 2 now
            len2--; // i am not gonna pop the last element in val1 and val2, len1&2 will not change with that
        }

        if (currentCarry == 1) finalSum.add(0, 1);
        
        String str = "";
        for (int i : finalSum) {
            str += i;
        }
        return str;

    }

    public int[] sumOneDigit(int a, int b) {
        int[] result = new int[2]; // carry and one value
        // by default carry = 0
        result[1] = (a + b) % 10;
        if (a+b >= 10) result[0] = 1;
        return result;
    }

    public void extendShortList(int len1, ArrayList<Integer> val2) { // in-place extend, directly change original val2.
        int len2 = val2.size();
        int gap = len1 - len2;
        for (int k=0; k<gap; k++) {
            val2.add(0, 0);
        }
    }
}