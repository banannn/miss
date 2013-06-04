package miss.participant;

import miss.message.Message;

import java.util.Scanner;
import java.util.logging.Logger;


public class Human extends Participant {

    public static final String OTRZYMANO_WIADOMOŚĆ = "otrzymano wiadomość: ";
    public static final String NIEWŁAŚCIWY_FORMAT_LICZBY = "niewłaściwy format liczby";
    public static final String NIEWŁAŚCIWY_WYBÓR = "niewłaściwy wybór";
    private final Logger log = Logger.getLogger(this.getClass().getName());

    private Scanner scanner;

	public Human() {
		scanner = new Scanner(System.in);
	}

	@Override
	public void addResponse(Message response) {
        super.addResponse(response);
        log.info(OTRZYMANO_WIADOMOŚĆ + response);
	}

	/**
	 * should show list of option to user and wait for input
	 * then return text
	 */
	@Override
	public Message getNextText() {
        for(;;){
            String response = scanner.nextLine();
            try {
                return this.received.parseResponse(response);
            } catch (NumberFormatException e){
                log.warning(NIEWŁAŚCIWY_FORMAT_LICZBY);
            } catch (IndexOutOfBoundsException e){
                log.warning(NIEWŁAŚCIWY_WYBÓR);
            }
        }
	}

}
