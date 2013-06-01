package miss;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.bind.JAXBException;

import miss.message.DecimalQuestion;
import miss.message.Message;
import miss.message.Messages;
import miss.message.MultipleChoiceQuestion;
import miss.message.Offer;
import miss.message.SingleChoiceQuestion;
import miss.parser.ParserFactory;
import miss.participant.Participant;
import miss.participant.ParticipantFactory;
import miss.rules.AlwaysTrueVerifier;
import miss.rules.Rule;
import miss.rules.Rules;
import miss.rules.State;
import miss.rules.Transition;
import utils.JsonSerializer;

public class App {

    public static void main(String[] args) {
//
        Supervisor supervisor = new Supervisor(getSeller(), getBuyer());
        supervisor.startNegotiations();
//    	createJsons();
    }

    private static Participant getBuyer() {
        return ParticipantFactory.createHuman();
    }

    private static Participant getSeller() {
        try {
            return ParticipantFactory.createBot(
                    "resources/messages.json",
                    "resources/rules.json",
                    ParserFactory.createJsonParser()
            );
        } catch (JAXBException e) {
            e.printStackTrace();
            System.exit(-1);
            return null;
        }
    }

    
   private static void createJsons() {
	   List<State> states = new ArrayList<State>();
	   List<Rule> rules = new ArrayList<Rule>();
	   List<Transition> transitions = new ArrayList<Transition>();
	   
	   for (long i=1; i<7; i++) {
		   State s = new State();
		   s.setId(i);
		   states.add(s);
		   
		   Rule r = new Rule();
		   r.setNextMessage(i);
		   r.setState(i);
		   rules.add(r);
	   
		   Transition t = new Transition();
		   t.setEndState(i==6 ? 1l : i+1);
		   t.setStartState(i);
		   t.setVerifier(new AlwaysTrueVerifier());
		   transitions.add(t);
	   }
	   
	   Rules rr = new Rules();
	   rr.setRules(rules);
	   rr.setStates(states);
	   rr.setTransitions(transitions);
	   PrintWriter out = null;
	   try {
			out = new PrintWriter("resources/rules.json");
			out.print(JsonSerializer.toJson(rr));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			out.flush();
			out.close();
		}
	   
//	   System.out.println(JsonSerializer.toJson(rr));
	   
	   //messages
	   List<Message> msgs = new ArrayList<Message>();
	   
	   Message m1 = new SingleChoiceQuestion(1l, Arrays.asList("BMW","FIAT"));
	   msgs.add(m1);
	   
	   Message m2 = new MultipleChoiceQuestion(2l, Arrays.asList("Alufele","Radio"));
	   msgs.add(m2);
	   
	   Message m3 = new MultipleChoiceQuestion(3l, Arrays.asList("qwe","asd"));
	   msgs.add(m3);
	   
	   Message m4 = new DecimalQuestion(4l, "Jaka jest Twoja maksymalna cena?");
	   msgs.add(m4);
	   
	   Message m5 = new Offer(5l, new BigDecimal(2000));
	   msgs.add(m5);
	   
	   Message m6 = new Offer(6l, new BigDecimal(5000));
	   msgs.add(m6);
	   
	   Messages mm = new Messages();
	   mm.setMessages(msgs.toArray(new Message[msgs.size()]));
	   try {
			out = new PrintWriter("resources/messages.json");
			out.print(JsonSerializer.toJson(mm));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			out.flush();
			out.close();
		}
//	   System.out.println(JsonSerializer.toJson(mm));

   }
}
