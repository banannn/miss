package miss;

import miss.message.*;
import miss.parser.ParserFactory;
import miss.participant.Participant;
import miss.participant.ParticipantFactory;
import miss.rules.*;
import miss.solver.Constant;
import miss.solver.Solver;
import utils.JsonSerializer;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
	   List<Solver> solvers = new ArrayList<Solver>();
	   List<Transition> transitions = new ArrayList<Transition>();
	   
	   for (long i=1; i<7; i++) {
		   State s = new State();
		   s.setId(i);
		   states.add(s);
		   
		   Constant r = new Constant();
		   r.setNextMessage(i);
		   r.setState(i);
		   solvers.add(r);

           if (i == 4) {
               for (long[] vals : new long[][] { {6l, 5000l}, {5l, 2000l}}) {
                   Transition t = new Transition();
                   t.setEndState(vals[0]);
                   t.setStartState(i);
                   GreaterThanOrEqualVerifier verifier = new GreaterThanOrEqualVerifier();
                   verifier.setValue(new BigDecimal(vals[1]));
                   t.setVerifier(verifier);
                   transitions.add(t);
               }
           }
	   
		   Transition t = new Transition();
		   t.setEndState(i >= 4 ? 1l : i+1);
		   t.setStartState(i);
		   t.setVerifier(new AlwaysTrueVerifier());
		   transitions.add(t);
	   }
	   
	   Rules rr = new Rules();
	   rr.setSolvers(solvers);
	   rr.setStates(states);
	   rr.setTransitions(transitions);
	   PrintWriter out = null;
	   try {
			out = new PrintWriter("resources/solvers.json");
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
