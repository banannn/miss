package miss.rule;

import java.util.List;

import miss.message.Message;
import miss.message.Messages;

// TODO - póki co jest wydmuszka zwracająca kolejno wiadomości
public class Rules {
//    private final Message[] messages;
    private int next = -1;

    // mozliwe stany0
    private List<State> states;

    // wszystkie wiadomosci
    private Messages messages;
    
    // wszystkie reguły
    private List<Rule> rules;
    
    // wszystkie przejscia
    private List<Transition> transitions;
    
    public Rules(Messages messages) {
        this.messages = messages;
    }

    public Message getNextMessage(Message sent, Message received) {
    	//TODO na podstawie stanu zwracac wiadomosc z Rule
    	
//        next = (next + 1) % messages.length;

//        return messages[next];
    	return messages.getMessages()[0];
    }


	public List<State> getStates() {
		return states;
	}

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

	public void setRules(List<Rule> rules) {
		this.rules = rules;
	}

	public List<Transition> getTransitions() {
		return transitions;
	}

	public void setTransitions(List<Transition> transitions) {
		this.transitions = transitions;
	}
    
    
}
