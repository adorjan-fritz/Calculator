/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import static calculator.Rational.RealToRational;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author jan 
 */
public class LengyelForma {

    public static String LengyelFormaraHoz(String s) {
        String x;
        String output = "";
        Stack<String> verem = new Stack<>();
        Map<Character, Integer> operato = new HashMap<>();
        operato.put('=', 0);
        operato.put('+', 1);
        operato.put('-', 1);
        operato.put('*', 2);
        operato.put('/', 2);
        //operato.put('^', 2);

        Scanner scn = new Scanner(s);

        while (scn.hasNext()) {
            //
            if (scn.hasNextInt()) {
                output = output + " " + scn.nextInt();
            } else if (scn.hasNextDouble()) {
                output = output + " " + scn.nextDouble();
            } else {
                x=scn.next();
                if (x.equals(")")) {
                    while (!(verem.peek().equals("("))) {
                        output = output + " " + (verem.pop());
                    }
                    verem.pop();
                } else if (x.equals("(")) {
                    verem.push(x);
                } else if (operato.containsKey(x.charAt(0))) {
                    if (x.equals("=") || x.equals("^")) {
                        while ((!verem.empty()) && !(verem.peek().equals("(")) && (operato.get(verem.peek().charAt(0)) >= operato.get(x.charAt(0))) ) {
                            
                            output = output + " " + (verem.pop());
                        }
                    } else {
                        while ((!verem.empty()) && !(verem.peek().equals("(")) && (operato.get(verem.peek().charAt(0)) > operato.get(x.charAt(0))) ) {
                            output = output + " " + (verem.pop());
                        }
                    }
                    verem.push(x);
                }
            }
        }
        while (!verem.empty()) {
            output = output + " " + (verem.pop());
        }
        return output;
    }
    
    public static Rational LengyelFormaraKiszamol(String s) {
        String x;
        Rational jobb;
        Rational bal;
        Stack<Rational> verem = new Stack<>();
        String oper = "=+-*/^";
        
        Scanner scn = new Scanner(s);
        while(scn.hasNext()) {
            if (scn.hasNextInt()) {
                verem.push(new Rational(scn.nextInt()));
            } else if (scn.hasNextDouble()) {
                verem.push(RealToRational(scn.nextDouble()));
            } else {
                x = scn.next();
                if (oper.contains(x)) {
                    jobb = verem.pop();
                    bal = verem.pop();
                    
                    switch (x){
                        case "+":
                            verem.push(bal.addition(jobb));
                            break;
                        case "-":
                            verem.push(bal.subtraction(jobb));
                            break;
                        case "*":
                            verem.push(bal.multiplication(jobb));
                            break;
                        case "/":
                            verem.push(bal.division(jobb));
                            break;
                        /*case "^":
                            verem.push(bal.toPower(jobb));
                            break;*/
                            
                    }
                        
                }
                
            }
            
        }
        
        return verem.pop();
    }
}
