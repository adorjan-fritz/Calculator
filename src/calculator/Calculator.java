/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package calculator;


/**
 *
 * @author jan
 */
public class Calculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* Teszt
        Rational a = new Rational(1,3);
        System.out.println("a="+a);
        Rational b = new Rational(2,3);
        System.out.println("b="+b);
        System.out.println("a+b="+a.addition(b));
        System.out.println("a-b="+a.subtraction(b));
        System.out.println("a*b="+a.multiplication(b));
        System.out.println("a/b="+a.division(b));
        
        Rational c = new Rational(-2,3); 
        System.out.println("c="+c);
        Rational d = new Rational(30000,-10000); 
        System.out.println("d="+d);
        System.out.println(LengyelFormaraHoz("11 * ( 2 + 54 )"));
        System.out.println(LengyelFormaraKiszamol(LengyelFormaraHoz("11 * ( 2 + 54 )")   ));
        */
        
        CalculatorForm form = new CalculatorForm();
        form.setVisible(true);
        
        
        
    }
    
}
