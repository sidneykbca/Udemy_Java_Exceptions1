package model.exception;

public class DomainException extends RuntimeException{     // posso usar Exception que o erro ja aparece na ocmpilaçao
	private static final long serialVersionUID = 1L;
	
	public DomainException(String msg) {
		super(msg);							//permitir que possa instanciar essa classe passando uma mensagem, 
												//ficando armazenda dentro dessa exceção
	}
}
