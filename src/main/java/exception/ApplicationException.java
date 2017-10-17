package exception;
/**
 * 自定义异常
 * @author soft01
 *
 */
public class ApplicationException extends RuntimeException{

	public ApplicationException() {
		super();
	}

	public ApplicationException(String message) {
		super(message);
		
	}

}
