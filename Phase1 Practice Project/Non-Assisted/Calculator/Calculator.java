import java.util.*;

public class Calculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char operator;
        double num1, num2, result;
        System.out.println("Enter the First number: "); 
        num1 = input.nextDouble(); 
        System.out.println("Enter the Second number: "); 
        num2 = input.nextDouble(); 
        System.out.println("Choose your Operator: (+,-,* or /)"); 
        operator = input.next().charAt(0); 
        switch (operator) {
            case '+': 
                result=num1+num2; 
                System.out.println(num1+ "+" +num2+ "=" +result); 
                break; 
            case '-': 
                result=num1-num2; 
                System.out.println(num1+ "-" +num2+ "=" +result); 
                break; 
            case '*': 
                result=num1*num2; 
                System.out.println(num1+ "*" +num2+ "=" +result); 
                break; 
            case '/': 
                result=num1/num2; 
                System.out.println(num1+ "/" +num2+ "=" +result); 
                break; 
            default: 
                System.out.println("You have entered an invalid operator"); 
        } 
        input.close(); 
    } 
} 
