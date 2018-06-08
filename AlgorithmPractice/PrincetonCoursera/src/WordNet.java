import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class WordNet {

    private HashMap<Integer, List<String>> synset = new HashMap<>();
    List<String> iterableNouns = new ArrayList<>();
    private Digraph wordNet;

        // constructor takes the name of the two input files
        public WordNet(String synsets, String hypernyms) {
            In synsetStream = new In(synsets);
            int id = 0;
            while (synsetStream.hasNextLine()) {
                String line = synsetStream.readLine();
                String [] split = line.split(",");
                id = Integer.valueOf(split[0]);
                String [] nouns = split[1].split("_");
                synset.put(id, Arrays.asList(nouns));
            }

            In hypernymStream = new In(hypernyms);
            wordNet = new Digraph(id);
            while (hypernymStream.hasNextLine()) {
                String line2 = hypernymStream.readLine();
                String [] relations = line2.split(",");
                for (String relation : relations) {
                    wordNet.addEdge(Integer.parseInt(relations[0]),Integer.parseInt(relation));
                }
            }
        }

        // returns all WordNet nouns
        public Iterable<String> nouns() {
            synset.values().forEach(iterableNouns::addAll);
            return iterableNouns;

        }

        // is the word a WordNet noun?
        public boolean isNoun(String word) {
            return iterableNouns.contains(word);

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

