package utils;

import com.google.gson.*;
import com.google.gson.JsonSerializer;
import miss.solver.Solver;

import java.lang.reflect.Type;

public class SolverElementAdapter implements
					JsonSerializer<Solver>, JsonDeserializer<Solver> {

	@Override
	public Solver deserialize(JsonElement json, Type typeOfT,
			JsonDeserializationContext context) throws JsonParseException {
		
		JsonObject jsonObject = json.getAsJsonObject();
        String type = jsonObject.get("type").getAsString();
        JsonElement element = jsonObject.get("properties");
        try {
            return context.deserialize(element, Class.forName("miss.solver." + type));
        } catch (ClassNotFoundException cnfe) {
            throw new JsonParseException("Unknown element type: " + type, cnfe);
        }
	}

	@Override
	public JsonElement serialize(Solver src, Type typeOfSrc,
			JsonSerializationContext context) {
		
		JsonObject result = new JsonObject();
        result.add("type", new JsonPrimitive(src.getClass().getSimpleName()));
        result.add("properties", context.serialize(src, src.getClass()));
        return result;
	}

	
}
