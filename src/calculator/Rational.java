/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package calculator;

import static java.lang.Math.abs;

/**
 *
 * @author jan
 */
public class Rational {
    private int szamlalo;
    private int nevezo;
    
    Rational(int szamlalo, int nevezo) {
        //if (0 == nevezo) 
        //    throw new Exception();
        if (nevezo < 0) {
            szamlalo*=(-1);
            nevezo*=(-1);
        }
        int lnko = abs(LNKO(szamlalo, nevezo));
        this.szamlalo = szamlalo / lnko;
        this.nevezo = nevezo / lnko;
    }
    
    Rational(int szamlalo) {
        this(szamlalo,1);
    }
    
    // 
    public static Rational RealToRational(double d) {
        int nev = 1;
        while ((d%10)!=0) {
            d*=10;
            nev*=10;
        }
        return new Rational(((int)d),nev);
    }
    
    public Rational addition(Rational a) {        
        return new Rational( (this.szamlalo*a.nevezo)+(a.szamlalo*this.nevezo),this.nevezo*a.nevezo);
    }
    
    public Rational subtraction(Rational a) {        
        return new Rational( (this.szamlalo*a.nevezo)-(a.szamlalo*this.nevezo),this.nevezo*a.nevezo);
    }
    
    public Rational multiplication(Rational a) {        
        return new Rational(this.szamlalo*a.szamlalo,this.nevezo*a.nevezo);
    }

    public Rational division(Rational a) {        
        return new Rational(this.szamlalo*a.nevezo,this.nevezo*a.szamlalo);
    }
    
    private int LNKO(int szamlalo, int nevezo) {
        if (nevezo==0) return szamlalo;
        return LNKO(nevezo,szamlalo%nevezo);
    }

    public String toString() {
        if (1 == nevezo) return szamlalo + " ";
        return szamlalo + " / " + nevezo + " ";
    }    

    /*Rational toPower(Rational jobb) {
        
        return 
    }*/
}
