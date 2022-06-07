package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;

public class AfterThrowingDemoApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO theAccountDAO = context.getBean("accountDAO",AccountDAO.class);
		
		List<Account> theAccounts = null;
		
		try{
			boolean throwException = true;
			theAccounts = theAccountDAO.findAccounts(throwException);
		}
		catch(Exception exc) {
			System.out.println("Exception caught in Main()"+exc.getMessage());
		}

		System.out.println(theAccounts);
		
		context.close();
		
	}

}
