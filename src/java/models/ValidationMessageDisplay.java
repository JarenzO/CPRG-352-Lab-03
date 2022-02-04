
package models;

import java.io.Serializable;

public class ValidationMessageDisplay implements Serializable{
    ///Attributes
    private String errorMessage="";
         
    ///Constructors
    public ValidationMessageDisplay() {}
    
    public ValidationMessageDisplay(String message) {
        this.errorMessage = message;
    }


    ///Setters and Getters
    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    
}
