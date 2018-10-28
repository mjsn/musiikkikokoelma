package harjoitustyo.musiikkikokoelma.dao;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class EiLoydyPoikkeus extends RuntimeException {

	public EiLoydyPoikkeus(Exception cause) {
		super(cause);
	}
	
}