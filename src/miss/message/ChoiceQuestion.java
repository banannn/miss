package miss.message;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public abstract class ChoiceQuestion extends Question {

    public static final String COMMA_SPACE = ", ";
    public static final String DOT_SPACE = ". ";
    @XmlElement
    protected final List<String> choices;

    protected  ChoiceQuestion(){
        choices = null;
    }

    public ChoiceQuestion(Long id, List<String> choices) {
        super(id);
        this.choices = choices;
    }

    protected String listChoices() {
        StringBuilder sb = new StringBuilder();
        int counter = 0;
        boolean first = true;
        for (String choice : choices) {
            if (!first) sb.append(COMMA_SPACE);
            sb.append(++counter).append(DOT_SPACE).append(choice);
            first = false;
        }
        return sb.toString();
    }

}
