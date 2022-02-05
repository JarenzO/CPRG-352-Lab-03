
package models;

import java.io.Serializable;

public class Calculation implements Serializable{
    ///Attributes
    private int firstTerm;
    private int secondTerm;
    private int result;
    
    
    
    ///Constructors
    public Calculation() {}
    
    public Calculation(int userFirstTerm, int userSecondTerm) {
        this.firstTerm = userFirstTerm;
        this.secondTerm = userSecondTerm;
    }
    
    
    
    ///Getters and Setters
    public int getFirstTerm() {
        return firstTerm;
    }

    public void setFirstTerm(int userFirstTerm) {
        this.firstTerm = userFirstTerm;
    }

    public int getSecondTerm() {
        return secondTerm;
    }

    public void setSecondTerm(int userSecondTerm) {
        this.secondTerm = userSecondTerm;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
   
}
