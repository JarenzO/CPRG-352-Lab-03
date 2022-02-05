
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Calculation;


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
        
        Calculation calcTerms = new Calculation();
        int resultcalc=0;
        
        
        ///Validation 
        //if inputs are empty
        if( (firstTermForm == null || firstTermForm.equals("") ) 
                && ( secondTermForm == null || secondTermForm.equals("") )) {
            
            getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
            return;
        }
        
        //if any of the inputs are invalid the result should be invalid
        try {
            
            calcTerms.setFirstTerm( Integer.parseInt(firstTermForm) );
            calcTerms.setSecondTerm( Integer.parseInt(secondTermForm) );
            
            
        }catch (NumberFormatException text) {
            
            request.setAttribute("error", true);
            getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
            return;
        }catch(Exception unexpected) {
            
            request.setAttribute("error", true);
            getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
            return;
        }
        
        
        //Process the valid data
        if( operationTypeForm.equals("%") 
                && calcTerms.getFirstTerm() == 0 
                && calcTerms.getSecondTerm() == 0 ) {
            
            request.setAttribute("error", true);
            getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
            return;
        }
        
        switch (operationTypeForm) {
            case "+": resultcalc = calcTerms.getFirstTerm() + calcTerms.getSecondTerm(); break;
            case "-": resultcalc = calcTerms.getFirstTerm() - calcTerms.getSecondTerm(); break;
            case "*": resultcalc = calcTerms.getFirstTerm() * calcTerms.getSecondTerm(); break;
            case "%": resultcalc = calcTerms.getFirstTerm() % calcTerms.getSecondTerm(); break;
            
            default: request.setAttribute("error", true); break;//Check here if all validation is passed but result is invalid
        }
        
        
        
        ///Load the processed data
        calcTerms.setResult(resultcalc);
        request.setAttribute("calculation", calcTerms);
        
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
        return;
    }

}
