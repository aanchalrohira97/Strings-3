// we want to create a dictionary of words
// less than 20 and everything above 20 repeats itself
// except the 10's multiples and thousands
// trim the word before processing the input
// handle for 0's

// TC: O(1)
// SC: O(1)

class Solution {

  String[] below_20 = {
    "",
    "One",
    "Two",
    "Three",
    "Four",
    "Five",
    "Six",
    "Seven",
    "Eight",
    "Nine",
    "Ten",
    "Eleven",
    "Twelve",
    "Thirteen",
    "Fourteen",
    "Fifteen",
    "Sixteen",
    "Seventeen",
    "Eighteen",
    "Nineteen",
  };

  String[] hundreds = {
    "",
    "",
    "Twenty",
    "Thirty",
    "Forty",
    "Fifty",
    "Sixty",
    "Seventy",
    "Eighty",
    "Ninety",
  };

  String[] thousands = { "", "Thousand", "Million", "Billion" };

  // this function divide number into smaller part and call helper for smaller number.

  // result is appended after every call ansd returned.

  public String numberToWords(int num) {
    if (num == 0) return "Zero";

    String word = "";

    int i = 0;

    // loop till all number is processed, total digit is divided into subpart of 3 digit

    while (num > 0) {
      // check if all the 3 digit is 0

      if (num % 1000 != 0) word =
        helper(num % 1000) + thousands[i] + " " + word;

      num = num / 1000;

      i++;
    }

    return word.trim();
  }

  // helper function for the driver function, it convert 3 digit or lesser  to word.

  public String helper(int num) {
    if (num == 0) return "";
    // when number is lesser than 20

    else if (num < 20) {
      return below_20[num % 20] + " ";
    }
    // when number is lesser than 100 but greater than 19

    else if (num < 100) {
      return hundreds[num / 10] + " " + helper(num % 10);
    }
    //when number is lesser 1000 but greater than 99

    else return below_20[num / 100] + " Hundred " + helper(num % 100);
  }
}
