import java.util.Scanner;

public class Palindrome {

  public static void main(String[] args) {

    System.out.println("Enter a string: ");
    Scanner kb = new Scanner(System.in);
    String input = kb.nextLine();
    System.out.println(test(input));
  }

  public static boolean test(String str) {
    SV<Character> stack = new SV<Character>();
    String opp = "";
    for (int i = 0; i < str.length(); i++) {
      stack.push(str.charAt(i));
    }

    while(!stack.isEmpty()) {
      opp += stack.pop();
    }

    return (str.equals(opp));

  }
}
