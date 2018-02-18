package pl.michalskrzypek.exception;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ExceptionHandler {

	@org.springframework.web.bind.annotation.ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView pageNotFound() {
		
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("title", "Page not found!");
		mv.addObject("errorTitle", "Page not found!");
		mv.addObject("errorDesc", "The page you are looking for is not available.");
		
		return mv;
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView productNotFound() {
		
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("title", "Product not found!");
		mv.addObject("errorTitle", "Product not found!");
		mv.addObject("errorDesc", "The product you are looking for is not available.");
		
		return mv;
	}

	
	@org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
	public ModelAndView exceptionHandler(Exception e) {
		
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("title", "Error!");
		mv.addObject("errorTitle", "Something went wrong...");
		mv.addObject("errorDesc", e.getMessage()+"<br><br>For more details contact administrator.");
		
		return mv;
	}
	

}
