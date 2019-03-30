import java.util.ArrayDeque;
import java.util.Scanner;


public class Postfix {

    private Scanner in;

    public Postfix() {
        in = new Scanner(System.in);
    }

    public void run() {

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        System.out.println("Enter an expression in postfix notation, using a space to separate characters.");
        String input = in.nextLine();

        for (int i = 0; i < input.length(); i++) {
            char curChar = input.charAt(i);
            if (curChar != ' ') {
                if (Character.isDigit(curChar)) {
                    int myVal = 0;
                    while (Character.isDigit(curChar)) {
                        myVal = myVal * 10 + curChar - '0';
                        i++;
                        curChar = input.charAt(i);
                    }
                    i--;
                    stack.push(myVal);
                }
                 else {
                    char operator = curChar;
                    int num2 = Integer.parseInt(String.valueOf(stack.pop()));
                    int num1 = Integer.parseInt(String.valueOf(stack.pop()));
                    if (operator == '+') {
                        int sum = num1 + num2;
                        stack.push(sum);
                    }
                    else if (operator == '-') {
                        int dif = num1 - num2;
                        stack.push(dif);
                    }
                    else if (operator == '*') {
                        int prod = num1 * num2;
                        stack.push(prod);
                    }
                    else if (operator == '/') {
                        int quo = num1 / num2;
                        stack.push(quo);
                    }
                }
            }
        }
        System.out.println(stack);
    }

    public static void main(String [] args) {
        Postfix app = new Postfix();
        app.run();
    }
}
