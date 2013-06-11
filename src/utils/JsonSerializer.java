package utils;

import com.google.gson.GsonBuilder;
import miss.message.Message;
import miss.message.Messages;
import miss.rules.Rules;
import miss.rules.Verifier;
import miss.solver.Solver;

public class JsonSerializer {

	public static String toJson(Messages msgs) {
		GsonBuilder builder = new GsonBuilder();
		builder.registerTypeAdapter(Message.class, new MessageElementAdapter());
		return builder.create().toJson(msgs, Messages.class);
	}
	
	public static String toJson(Rules rules) {
		GsonBuilder builder = new GsonBuilder();
		builder.registerTypeAdapter(Verifier.class, new VerifierElementAdapter());
        builder.registerTypeAdapter(Solver.class, new SolverElementAdapter());
        return builder.create().toJson(rules, Rules.class);
	}
	
}
