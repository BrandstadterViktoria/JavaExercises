import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Outcast {

    //not clear: Assume that argument to outcast() contains only valid wordnet nouns (and that it contains at least two such nouns).
    private WordNet wordnet;
    // constructor takes a WordNet object
    public Outcast(WordNet wordnet) {
        this.wordnet = wordnet;
    }

    // given an array of WordNet nouns, return an outcast
    public String outcast(String[] nouns) {
        String outcast = "";
        int furthest = 0;
        for (String noun : nouns) {
            for (String noun1 : nouns) {
                int currentDistance = wordnet.distance(noun, noun1);
                if (currentDistance > furthest) {
                    furthest = currentDistance;
                    outcast = noun;
                }
            }
        }
        return outcast;
    }

    // see test client below
    public static void main(String[] args) {
            WordNet wordnet = new WordNet(args[0], args[1]);
            Outcast outcast = new Outcast(wordnet);
            for (int t = 2; t < args.length; t++) {
                In in = new In("outcast5.txt");
                String[] nouns = in.readAllStrings();
                StdOut.println(args[t] + ": " + outcast.outcast(nouns));

            }
        }
    }


