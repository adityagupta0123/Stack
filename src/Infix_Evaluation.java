

import java.util.Scanner;
import java.util.Stack;

public class Infix_Evaluation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Stack<Integer> opnds = new Stack<>();
        Stack<Character> optors = new Stack<>();

        for(int i= 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(ch == '('){
              optors.push(ch);
            }else if(Character.isDigit(ch)){
                opnds.push(ch - '0');
            }else if(ch == ')' && opnds.size() > 1){
                while(optors.peek() != '(' ) {
                    char optor = optors.pop();
                    int val2 = opnds.pop();
                    int val1 = opnds.pop();
                    int opv = operation(val1, val2, optor);
                    opnds.push(opv);
                }
                optors.pop();
            }else if(ch == '+' || ch == '-' || ch =='*' || ch == '/'){
                while(optors.size() > 0 && optors.peek() == '(' && precedence(ch) <= precedence(optors.peek()) && opnds.size() > 1){
                    char optor = optors.pop();
                    int val2 = opnds.pop();
                    int val1 = opnds.pop();
                    int opv = operation(val1, val2, optor);
                    opnds.push(opv);
                }
                optors.push(ch);
            }
        }
        while(optors.size() != 0) {
            char optor = optors.pop();
            int val2 = opnds.pop();
            int val1 = opnds.pop();
            int opv = operation(val1, val2, optor);
            opnds.push(opv);
        }
        System.out.println("ans " + opnds.peek());
    }
    public static int precedence( char optors ){
        if(optors == '+')
            return 1;
        else if( optors == '-')
            return 1;
        else if( optors == '*' )
            return 2;
        else
            return 2;
    }
    public static int operation(int val1, int val2 ,char optors ){
        if(optors == '+')
            return val1 + val2;
        else if( optors == '-')
            return val1 - val2;
        else if( optors == '*' )
            return val1 * val2;
        else
            return val1 / val2;
    }
}
