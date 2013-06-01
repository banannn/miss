package miss.rules;

import miss.message.Message;
import miss.message.Messages;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class Rules {

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
    	System.out.println(received == null ? "rec null" : "rec not null");
    	long stateId = state == null ? 1l : state.getId();
//    	System.out.println("stateid" + stateId);
    	for (Transition trans : transitions) {
//    		System.out.println("trans " + trans.getStartState() + "-> " + trans.getEndState());
    		if (trans.getStartState() == stateId && trans.getVerifier().isConsistent(received)) {
//    			System.out.println("trans matched" + trans.getStartState() + "-> " + trans.getEndState());
    			state = getStateFromId(trans.getEndState());
    			for (Rule r : rules) {
//    				System.out.println("rule " + r.getState() + " " + r.getNextMessage());
    				if (r.getState() == stateId) {
        				System.out.println("rule matched" + r.getState() + " " + r.getNextMessage());
        				
        				Message m = messages.getMessageFromId(r.getNextMessage());
        				System.out.println( m == null ? "null" : "not null");
        				return m;
    				}
    			}
    		}
    	}
    	
//    	if (state == null || state.getId() == 1) {
//    		for (Transition trans : transitions ) {
//    			if (trans.getStartState() == 1) {
//    				state = getStateFromId(trans.getEndState());
//	    			for (Rule r : rules) {
//						if (1 == r.getState())
//							return messages.getMessageFromId(r.getNextMessage());
//					}
//    			}
//    		}
//    	} else {
//    		for (Transition trans : transitions ) {
//    			if (trans.getStartState() == state.getId()) {
//    				trans.getVerifier().isConsistent(received);
//    				state = getStateFromId(trans.getEndState());
//    				for (Rule r : rules) {
//    					if (state.getId() == r.getState())
//    						return messages.getMessageFromId(r.getNextMessage());
//    				}
//    			}
//    		}
//    	}
    	
    	
//        next = (next + 1) % messages.length;
    	//TODO obsługa braku dopasowania

    	return messages.getMessages()[0];
    }


    private State getStateFromId(long id) {
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
