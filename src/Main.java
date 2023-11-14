public class Main {
    public static void main(String[] args) {
        System.out.println(isPalindrom(-1221));
        System.out.println(isPalindrom(707));
        System.out.println(isPalindrom(11212));
        System.out.println("-------------------------");
        System.out.println(isPerfectNumber(6));
        System.out.println(isPerfectNumber(28));
        System.out.println(isPerfectNumber(5));
        System.out.println(isPerfectNumber(-1));
        System.out.println("---------------------------");
        System.out.println(numberToWords(123));
        System.out.println(numberToWords(1010));
        System.out.println(numberToWords(5896));
        System.out.println(numberToWords(-12));
        System.out.println("---------------------------");
        System.out.println(getEvenDigitSum(123456));
        System.out.println("--------------------------------");
        System.out.println(getFirstAndListDigitSum(123456));
        System.out.println("--------------------------------");
        System.out.println(hasSameLastDigit(12, 23, 35, 13, 16, 17));
        System.out.println(hasSameLastDigit(12, 23, 35, 23));
        System.out.println(hasSameLastDigit(12, 23, 35, 13));

    }

    public static boolean isPalindrom(int number) {
        int reverse = 0;
        int num = number;
        while (!(number == 0)) {
            int remainder = number % 10;
            reverse = (reverse * 10) + remainder;
            number = number / 10;
        }
        return reverse == num;
    }

    public static boolean isPerfectNumber(int number) {
        if (number < 0 || number == 1) {
            return false;
        }

        int sum = 1;
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }

        return sum == number;
    }

    public static String numberToWords(int num) {
        if (num < 0) {
            return "Invalid Value";
        }
        char[] digits = String.valueOf(num).toCharArray();
        String numToText = "";
        for (char digit : digits) {
            switch (digit) {
                case '0':
                    numToText += "Zero ";
                    break;
                case '1':
                    numToText += "One ";
                    break;
                case '2':
                    numToText += "Two ";
                    break;
                case '3':
                    numToText += "Three ";
                    break;
                case '4':
                    numToText += "Four ";
                    break;
                case '5':
                    numToText += "Five ";
                    break;
                case '6':
                    numToText += "Six ";
                    break;
                case '7':
                    numToText += "Seven ";
                    break;
                case '8':
                    numToText += "Eight ";
                    break;
                case '9':
                    numToText += "Nine ";
                    break;
            }
        }
        //numToText.replace(numToText.length()-1, "");
        return numToText.trim();
    }

    public static int getEvenDigitSum(int num) {
        num = Math.abs(num);
        int sum = 0;
        char[] digits = String.valueOf(num).toCharArray();
        for (char digit : digits) {
            int parsedDigit = Integer.parseInt(String.valueOf(digit));
            if (parsedDigit % 2 == 0) {
                sum += parsedDigit;
            }
        }
        return sum;
    }

    //1234567 => 1 + 7 = 8
    //123456
    public static int getFirstAndListDigitSum(int num) {
        int lastDigit = num % 10;
        char firstDigitChar = String.valueOf(num).charAt(0);
        int firstDigit = Integer.parseInt(String.valueOf(firstDigitChar));
        //int firstDigit = Integer.parseInt(String.valueOf(num).substring(0,1));
        //System.out.println(firstDigit);
        return firstDigit + lastDigit;
    }

    //12, 23, 35, 16, 17 => false
    //12, 23, 35, 13, 16, 17 => true
    //[2, 3, 5, 3, 6, 7]
    //2, 3, 5, 3, 6, 7
    //3, 5, 3, 6, 7
    public static boolean hasSameLastDigit(int... nums) {
        int[] lastDigits = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            lastDigits[i] = nums[i] % 10;
        }
        //[2, 3, 5, 3, 6, 7] 6
        for (int i = 0; i < lastDigits.length; i++) {
            for (int j = i + 1; j < lastDigits.length; j++) {
                if(lastDigits[i] == lastDigits[j]){
                    return true;
                }
            }
        }
        return false;
    }


}