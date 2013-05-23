package miss.rule;

import miss.message.Message;
import miss.message.Messages;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
// TODO - póki co jest wydmuszka zwracająca kolejno wiadomości
public class Rules {
//    private final Message[] messages;
    private int next = -1;

    private State state;
    
    // mozliwe stany0
    private List<State> states;

    // wszystkie wiadomosci
    private Messages messages;
    
    // wszystkie reguły
    private List<Rule> rules;
    
    // wszystkie przejscia
    private List<Transition> transitions;

    public Rules() {
    	
    }

    public Message getNextMessage(Message received) {
    	
    	if (state == null || state.getId() == 1) {
    		for (Transition trans : transitions ) {
    			if (trans.getStartState() == 1) {
    				state = getStateFromId(trans.getEndState());
	    			for (Rule r : rules) {
						if (1 == r.getState())
							return messages.getMessageFromId(r.getNextMessage());
					}
    			}
    		}
    	} else {
    		for (Transition trans : transitions ) {
    			if (trans.getStartState() == state.getId()) {
    				trans.getVerifier().isConsistent(received);
    				state = getStateFromId(trans.getEndState());
    				for (Rule r : rules) {
    					if (state.getId() == r.getState())
    						return messages.getMessageFromId(r.getNextMessage());
    				}
    			}
    		}
    	}
    	
    	//TODO na podstawie stanu zwracac wiadomosc z Rule
    	
//        next = (next + 1) % messages.length;

//        return messages[next];
    	return messages.getMessages()[0];
    }


    private State getStateFromId(Long id) {
    	for (State state : states) {
    		if (state.getId() == id)
    			return state;
    	}
    	return null;
    }
    
	public List<State> getStates() {
		return states;
	}

    @XmlElement(name = "state")
	public void setStates(List<State> states) {
		this.states = states;
	}

	public Messages getMessages() {
		return messages;
	}

	public void setMessages(Messages messages) {
		this.messages = messages;
	}

	public List<Rule> getRules() {
		return rules;
	}

    @XmlElement(name = "rule")
    public void setRules(List<Rule> rules) {
		this.rules = rules;
	}

	public List<Transition> getTransitions() {
		return transitions;
	}

    @XmlElement(name = "transition")
    public void setTransitions(List<Transition> transitions) {
		this.transitions = transitions;
	}
    
    public State getFirstState() {
    	return states.get(0);
    }

}
