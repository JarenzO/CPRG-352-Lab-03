
package models;

import java.io.Serializable;

public class Age implements Serializable {
    ///Attributes
    //instance variables
    private int age;
    
    
    
    ///Constructors
    //zero arg
    public Age() {
           age = 0;
    }
    
    //complete
    public Age(int userAge) {
        this.age = userAge;
    }
    
    
    
    ///Getters and Setters
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
}
