
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.*;


public class AgeCalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Load the agecalculator JSP
        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request,response);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ///Capture the user input for an age
        String ageForm = request.getParameter("age");
        int age=0;
        
        ///Validation
        //if the ageInput is empty
        ValidationMessageDisplay message = new ValidationMessageDisplay();
        
        if(ageForm == null || ageForm.equals("")) {
            message.setErrorMessage("You must give your current age");
            request.setAttribute("errorfeedback", message);
            request.setAttribute("error", true);
            
            //Load the form with clarity message
            getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
            return;
        }
       
        //if the ageInput is invalid (text, 0 or negative)
        try {
            age = Integer.parseInt(ageForm);
            
            if(age <= 0) {
            message.setErrorMessage("You must enter a number");
            request.setAttribute("errorfeedback", message);
            request.setAttribute("error", true);
            
            //Load the form with error statement
            getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
            return;
            }
            
        }catch(NumberFormatException text) {
            message.setErrorMessage("You must enter a number");
            request.setAttribute("errorfeedback", message);
            request.setAttribute("error", true);
            
            //Load the form with error statement
            getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
            return;
        
        }catch(Exception e) {
            message.setErrorMessage("Unexpected Error.");
            request.setAttribute("errorfeedback", message);
            request.setAttribute("error", true);
            
            //Load the form with message
            getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
            return;
        }
        
        
        //Finish the capture after validation 
        Age ageInput = new Age(age);
        request.setAttribute("age", ageInput);
        
        
        
        ///Load the captured data 
        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
        return;
    }
    
//    private void errorMessage(HttpServletRequest request, HttpServletResponse response, ValidationMessageDisplay message) throws ServletException, IOException {
//            message.setErrorMessage("You must enter a number");
//            request.setAttribute("errorfeedback", message);
//            request.setAttribute("error", true);
//            
//            //Load the form with error statement
//            getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
//            return;
//    }
}
