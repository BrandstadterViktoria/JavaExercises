import edu.princeton.cs.algs4.In;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class WordNet {

    private HashMap<Integer, List<String>> synset = new HashMap<>();

        // constructor takes the name of the two input files
        public WordNet(String synsets, String hypernyms) {
            In synsetStream = new In("synset8.txt");
            while (synsetStream.hasNextLine()) {
                String line = synsetStream.readLine();
                String [] split = line.split(",");
                int id = Integer.valueOf(split[0]);
                String [] nouns = split[1].split("_");
                synset.put(id, Arrays.asList(nouns));
            }
        }

        // returns all WordNet nouns
        public Iterable<String> nouns() {

        }

        // is the word a WordNet noun?
        public boolean isNoun(String word) {

        }

        // distance between nounA and nounB (defined below)
        public int distance(String nounA, String nounB) {


        }

        // a synset (second field of synsets.txt) that is the common ancestor of nounA and nounB
        // in a shortest ancestral path (defined below)
        public String sap(String nounA, String nounB) {

        }

        // do unit testing of this class
        public static void main(String[] args) {


    }

}

