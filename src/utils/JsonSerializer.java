package utils;

import miss.message.Messages;
import miss.rules.Rules;

import com.google.gson.Gson;

public class JsonSerializer {

	public static String toJson(Messages msgs) {
		Gson gson = new Gson();
		return gson.toJson(msgs, Messages.class);
	}
	
	public static String toJson(Rules rules) {
		Gson gson = new Gson();
		return gson.toJson(rules, Rules.class);
	}
	
}
