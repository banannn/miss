package miss.message;

import java.util.List;

public class MultipleChoiceAnswer extends ChoiceAnswer {

    private final List<String> answer;

    MultipleChoiceAnswer(List<String> answer){
        this.answer = answer;
    }

    @Override
    public boolean contains(String item) {
        return answer.contains(item);
    }
}
