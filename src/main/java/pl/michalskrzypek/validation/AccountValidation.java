package pl.michalskrzypek.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import pl.michalskrzypek.entity.Account;

public class AccountValidation implements Validator{

	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return Account.class.equals(arg0);
	}

	public void validate(Object arg0, Errors arg1) {
		// TODO Auto-generated method stub
		
	}

}
