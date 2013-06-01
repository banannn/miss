package miss.parser;

import miss.participant.Participant;

/**
 * Interface for parsers
 * @author adam
 *
 */
public interface Parser {

	public Participant parse(String msgFile, String ruleFile);
	
}
