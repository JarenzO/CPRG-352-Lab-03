
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ArithmeticCalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Load the arithmeticcalculator jsp
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ///Capture the form data for arithmetic terms
        String firstTermForm = request.getParameter("formfirstterm");
        String secondTermForm = request.getParameter("formsecondterm");
        String operationTypeForm = request.getParameter("operation");
        
        request.setAttribute("formfirstterm", firstTermForm);
        request.setAttribute("formsecondterm", secondTermForm);
        
        int firstTerm=0;
        int secondTerm=0;
        String resultcalc="";
        
        
        
        ///Validation 
        //if any of the inputs are invalid the result should be invalid
        try {
            
            firstTerm = Integer.parseInt(firstTermForm);
            secondTerm = Integer.parseInt(secondTermForm);
            
        }catch (NumberFormatException text) {
            
            resultcalc = "invalid";
            request.setAttribute("error", true);
            getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
            return;
        }catch(Exception unexpected) {
            
            resultcalc = "unexpected invalid";
            request.setAttribute("error", true);
            getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
            return;
        }
        
        //Process the valid data
        switch (operationTypeForm) {
            case "+": resultcalc = firstTerm + secondTerm + "";
            case "-": resultcalc = firstTerm - secondTerm + "";
            case "*": resultcalc = firstTerm * secondTerm + "";
            case "%": resultcalc = firstTerm % secondTerm + "";
            
            default: resultcalc = "invalid";
        }
        
        
        
        ///Load the processed data
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
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
            getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
            return;
    }
}
