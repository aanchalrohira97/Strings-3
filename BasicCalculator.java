//soln1 : maintain two stacks currNum and expression
//i go through the stack to evaluate the multiplication and division
//i need to perform operation with the last inputted value, we need to do with a stack
// double digit number -> how will i handle -> (num1 * 10) + num2 {cause working with string}

class Solution {

  public int calculate(String s) {
    //convert string to an array
    //maintain one stack -> num
    //maintain 2 variables currNum and lastSign
    //initially we start traversing, when encountering a number
    //default value of currNum and lastSign is 0 and +
    //another number ->  currNum = (num1 * 10) + num2  & lastSign = +
    //when encountering * or / -> push stack, currNum = 0, lastSign = / or *
    //then another number, perform operation and store in stack with -ve or +ve
    //pop and add everything -> final result

    //forgot to account for spaces
    //TC: O(n), SC: O(n)
    //can we do better? -> optimize space
    //instead of stack have 2 other variables -> calculated and tail
    // calc + curr , calc - curr
    // calc - tail + (tail * curr) , calc - tail + (tail / curr)
    // SC: O(1) -> revisit - on your own

    int currNum = 0;
    char lastSign = '+';
    s = s.trim();
    int calc = 0;
    int tail = 0;
    Stack<Integer> st = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (Character.isDigit(c)) {
        currNum = (currNum * 10) + (c - '0');
      }

      // accounting for last digit, why we did not do else
      if (i == s.length() - 1 || (!Character.isDigit(c) && c != ' ')) {
        if (lastSign == '+') {
          //st.push(currNum);
          calc += currNum;
          tail = currNum;
        } else if (lastSign == '-') {
          //st.push(-currNum);
          calc -= currNum;
          tail = -currNum;
        } else if (lastSign == '*') {
          //int popped = st.pop();
          //st.push(currNum * popped);
          calc = (calc - tail) + (tail * currNum);
          tail = (tail * currNum);
        } else {
          //int popped = st.pop();
          //st.push(popped/ currNum);
          calc = (calc - tail) + (tail / currNum);
          tail = (tail / currNum);
        }
        currNum = 0;
        lastSign = c;
      }
    }

    // int result = 0;
    // while(!st.isEmpty())
    // {
    //     result += st.pop();
    // }
    return calc;
  }
}
