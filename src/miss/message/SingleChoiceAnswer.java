package miss.message;

public class SingleChoiceAnswer extends ChoiceAnswer {

    private final String answer;

    SingleChoiceAnswer(String answer){
        this.answer = answer;
    }

    @Override
    public boolean contains(String item) {
        return item.equals(answer);
    }
}
