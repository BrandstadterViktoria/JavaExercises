import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordNet {

    private final HashMap<String, Integer> synset = new HashMap<>();
    private final HashMap<Integer,String> synsetReverse = new HashMap<>();
    private final Digraph wordNet;
    private int distance;
    private SAP sca;

    // constructor takes the name of the two input files
    public WordNet(String synsets, String hypernyms) {
        if (synsets == null || hypernyms == null) {
            throw new IllegalArgumentException("Arg is null.");
        }
        In synsetIn = new In(synsets);
        int id = -1;
        while (synsetIn.hasNextLine()) {
            String line = synsetIn.readLine();
            String[] idAndNouns = line.split(",");
            String nounss = idAndNouns[1];
            synset.put(nounss,++id);
            synsetReverse.put(id, nounss);

        }

        In hypernymIn = new In(hypernyms);
        wordNet = new Digraph(id +1);
        while (hypernymIn.hasNextLine()) {
            String line2 = hypernymIn.readLine();
            List<Integer> relations = new ArrayList<>();
            for (String s : line2.split(",")) {
                relations.add(Integer.parseInt(s));
            }
            for (int i = 1; i < relations.size(); i++) {
                wordNet.addEdge(relations.get(0), relations.get(i));
            }
        }
        sca = new SAP(wordNet);

    }

    // returns all WordNet nouns
    public Iterable<String> nouns() {
        return synset.keySet();

    }

    // is the word a WordNet noun?
    public boolean isNoun(String word) {
        if (word == null) {
            throw new IllegalArgumentException("Arg is illegal");
        }
        for (String s : synset.keySet()) {
            if (s.contains(word)){
                return true;
            }
        }
        return false;

    }

    // distance between nounA and nounB (defined below)
    public int distance(String nounA, String nounB) {
        if (nounA == null || nounB == null || !isNoun(nounA) || !isNoun(nounB)) {
            throw new IllegalArgumentException("Arg illegal");
        }
        sap(nounA, nounB);
        return distance;

    }


    // a synset (second field of synsets.txt) that is the common ancestor of nounA and nounB
    // in a shortest ancestral path (defined below)
    public String sap(String nounA, String nounB) {
        if (nounA == null || nounB == null || !isNoun(nounA) || !isNoun(nounB)) {
            throw new IllegalArgumentException("Arg illegal");
        }
        List <Integer> A = new ArrayList<>();
        List <Integer> B = new ArrayList<>();

        for (String k : synset.keySet()) {
            if (k.contains(nounA)) {
                A.add(synset.get(k));
            }
            if (k.contains(nounB)) {
                B.add(synset.get(k));
            }
        }
        int ancestor = sca.ancestor(A, B);
        distance = sca.length(A,B);
        return synsetReverse.get(ancestor);


    }

    // do unit testing of this class
    public static void main(String[] args) {
        WordNet test = new WordNet("synsets100-subgraph.txt", "hypernyms100-subgraph.txt");
        System.out.println(test.distance("factor_V","prothrombin"));

    }

}

