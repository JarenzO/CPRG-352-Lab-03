
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Age;


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
        String ageForm = request.getParameter("formage");
        int age=0;
        
        
        
        ///Validation
        //if the ageInput is empty
        if(ageForm == null || ageForm.equals("")) {

                errorMessage("You must give your current age.", request, response);
        }
       
        //if the ageInput is invalid (text, 0 or negative)
        try {
            age = Integer.parseInt(ageForm);
            
        }catch(NumberFormatException text) {

                errorMessage("You must enter a number.", request, response);
        }catch(Exception unexpected) {
                
                errorMessage("Unexpected Error.", request, response);
        }
        
        
        //Finish the capture after validation 
        Age ageInput = new Age(age);
        request.setAttribute("age", ageInput);
        
        
        
        ///Load the processed data 
        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
        return;
    }
    
    /**
     * Creates an error message attribute and an error reference for jsp
     * 
     * @param message A message with a solution for the user's error
     * @param request The servlet request object
     * @param response The servlet response object
     * @throws ServletException Something wrong with servlet
     * @throws IOException Failure of IO operation
     */
    private void errorMessage(String message, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.setAttribute("errorfeedback", message);
            request.setAttribute("error", true);
            
            //Load the form with error statement
            getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
            return;
    }
}
