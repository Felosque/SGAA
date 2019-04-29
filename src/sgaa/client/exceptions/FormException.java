package sgaa.client.exceptions;

public class FormException extends Exception{

	private String message;
	
	public FormException(String pMessage) {
		message = pMessage;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
