package com.projectoFinal.casaDosAnimais.Servicos.Expetion;

public class DataIntegrityException extends RuntimeException {

	
	private static final long serialVersionUID = 1L;
	
	public DataIntegrityException(String msg){
		
		super(msg);
		
	}
	
	public DataIntegrityException(String msg,Throwable caso){
		
		super(msg,caso);
		
		
	}
	
}
