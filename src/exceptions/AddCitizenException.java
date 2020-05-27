package exceptions;

@SuppressWarnings("serial")
public class AddCitizenException extends CitizenException {
	

	public AddCitizenException(String str) {
		super(str);
	}
	
	public AddCitizenException() {
		super("The Voter isn't adult!");
	}
	
	
	
}
