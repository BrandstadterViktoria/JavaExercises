package Part_II.Week1_Wordnet;

public class Outcast {

    //not clear: Assume that argument to outcast() contains only valid wordnet nouns (and that it contains at least two such nouns).
    private WordNet wordnet;

    // constructor takes a Part_II.Week1_Wordnet.WordNet object
    public Outcast(WordNet wordnet) {
        this.wordnet = wordnet;
    }

    // given an array of Part_II.Week1_Wordnet.WordNet nouns, return an outcast
    public String outcast(String[] nouns) {
        String outcast = "";
        int furthest = 0;
        for (String noun : nouns) {
            int currentDistance = 0;
            for (String noun1 : nouns) {
                currentDistance += wordnet.distance(noun, noun1);
            }
            if (currentDistance > furthest) {
                furthest = currentDistance;
                outcast = noun;
            }
        }
        return outcast;
    }

    // see test client below
    public static void main(String[] args) {
        WordNet test = new WordNet("synsets15.txt", "hypernyms15Tree.txt");
        Outcast tester = new Outcast(test);
        String[] t = {"two", "twelve", "three", "one"};
        System.out.println(tester.outcast(t));

    }
}


