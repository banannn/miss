package miss.parser;

import java.io.FileNotFoundException;
import java.io.FileReader;

import utils.MessageElementAdapter;
import utils.VerifierElementAdapter;

import miss.message.Message;
import miss.message.Messages;
import miss.participant.Bot;
import miss.participant.Participant;
import miss.rules.Rules;
import miss.rules.Verifier;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

public class JSONParser implements Parser {

	private Gson gson;
	
	public JSONParser() {
		GsonBuilder builder = new GsonBuilder();
		builder.registerTypeAdapter(Message.class, new MessageElementAdapter());
		builder.registerTypeAdapter(Verifier.class, new VerifierElementAdapter());
		gson = builder.create();
	}
	
	@Override
	public Participant parse(String msgFile, String ruleFile) {
		Messages msg = null;
		Rules rules = null;
		try {
			msg = (Messages)gson.fromJson(new FileReader(msgFile), Messages.class);
			rules = (Rules)gson.fromJson(new FileReader(ruleFile), Rules.class);
			rules.setMessages(msg);
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		} catch (JsonIOException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return new Bot(msg, rules);
	}
	
	
}
