package exceptions;

public class NotFoundException extends RuntimeException {


	public NotFoundException(String blogId) {
		super("Il record con id " + blogId + " non è stato trovato");
	}

}
