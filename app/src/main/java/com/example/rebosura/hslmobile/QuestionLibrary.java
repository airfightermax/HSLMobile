package com.example.rebosura.hslmobile;


/**
 * Created by Rebosura on 3/4/2018.
 */

public class QuestionLibrary {
    public static final String QUIZ_SCORE = "quiz_score";
    private int beginnerScore, intermediateScore, advancedScore;
    private String[] answers = {"Letter G", "Cat", "Dog", "Letter A", "Bird", "Deer", "Letter B", "Elephant", "Letter F", "Giraffe"};
    private String[] advancedAnswers = {"1760", "17th century", "1817", "American School for the Deaf", "1864", "Thomas Hopkins", "Didascalocophus", "Socrates", "1620", "False"};
    private String[][] easyChoices = {
            {"Letter H", "Letter G", "Letter R", "Letter A"},
            {"Cat", "Dog", "Alligator", "Giraffe"},
            {"Bird", "Lion", "Dog", "Cat"},
            {"Letter Z", "Letter A", "Letter D", "Letter S"},
            {"Zebra", "Elephant", "Bird", "Cat"},
            {"Giraffe", "Bird", "Cat", "Deer"},
            {"Letter H", "Letter M", "Letter J", "Letter B"},
            {"Dog", "Mouse", "Elephant", "Lion"},
            {"Letter F", "Letter S", "Letter Q", "Letter A"},
            {"Mouse", "Cat", "Giraffe", "Deer"}
    };

    private String[][] advancedChoices = {
            {"1761", "1750", "1760", "1769"},
            {"1600", "17th Century", "18th Century", "16th Century"},
            {"1820", "1815", "1818", "1817"},
            {"Gallaudet University", "American School for the Deaf", "British Empire School for the Deaf", "Royal Institute for Deaf and Blind Children"},
            {"1864", "1890", "1860", "1865"},
            {"John Hopkins", "Thomas Hopkins", "Juan Pablo Bonet", "George Dalgarno"},
            {"Didascalocophus", "Hippolytus", "Iliad", "Medea"},
            {"Augustus Caesar", "Aristotle", "Socrates", "Plato"},
            {"1620", "1619", "1624", "1630"},
            {"True","False","None of the Above","Both True and False"}
    };
    private int[] easyImages = {
            R.drawable.g,
            R.drawable.cata,
            R.drawable.doga,
            R.drawable.a,
            R.drawable.birda,
            R.drawable.deera,
            R.drawable.b,
            R.drawable.elephanta,
            R.drawable.f,
            R.drawable.giraffea
    };

    private String[] questions = {
            "What letter does this hand sign mean?",
            "What animal does this hand sign represent?",
            "What animal does this hand sign represent?",
            "What letter does this hand sign mean?",
            "What animal does this hand sign represent?",
            "What animal does this hand sign represent?",
            "What letter does this hand sign mean?",
            "What animal does this hand sign represent?",
            "What letter does this hand sign mean?",
            "What animal does this hand sign represent?",
    };

    private String[] advancedQuestions = {
            "When did l’Abbé Charles Michel de l’Épée started his deaf school in Paris?",
            "The recorded history of sign language started as early as",
            "What year did Clerc and Gallaudet founded the American Asylum for the Deaf and Dumb",
            "The American Asylum for the Deaf and Dumb is now called",
            "When was a college for deaf people founded in Washington D.C?",
            "Who did Laurent Clerc went to the United States with to found the American School for the Deaf at Hartford?",
            "What did George Dalgarno publish in 1680?",
            "Who said \"If we hadn't a voice or a tongue, and wanted to express things to one another, wouldn't we try to make signs by moving our hands, head, and the rest of our body, just as dumb people do at present?\"?",
            "When did Juan Pablo Bonet published Reducción de las letras y arte para enseñar a hablar a los mudos?",
            "True of False. Thomas Hopkins published a book in 1692 describing an alphabetic system where pointing to a body part represented the first letter of the part (e.g. Brow=B), and vowels were located on the fingertips as with the other British systems.",
    };
    public String getQuestions(int a){
        String question = questions[a];
        return question;
    }

    public int getEasyImages(int a){
        return easyImages[a];
    }

    public String getAnswers(int a){
        String answer = answers[a];
        return answer;
    }

    public String getchoices(int a, int b){
        String choice = easyChoices[a][b];
        return choice;
    }
    public int getLength(){
        return questions.length;
    }
    public void setBeginnerScore(int a){
        beginnerScore = a;
    }
    public void setIntermediateScore(int a){
        intermediateScore = a;
    }
    public void setAdvancedScore(int a){
        advancedScore = a;
    }
    public int getBeginnerScore(){
        return beginnerScore;
    }

    public String getAdvancedQuestions(int a){
        String question = advancedQuestions[a];
        return question;
    }
    public String getAdvancedChoices(int a, int b){
        String choice = advancedChoices[a][b];
        return choice;
    }
    public String getAdvancedAnswers(int a){
        String answer = advancedAnswers[a];
        return answer;
    }
}

