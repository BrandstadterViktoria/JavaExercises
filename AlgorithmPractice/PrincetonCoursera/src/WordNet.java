import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Collection;


public class WordNet {

    private final HashMap<List<String>, Integer> synset = new HashMap<>();
    private final Digraph wordNet;
    private SAP distanceIterables;
    private List<Integer> A;
    private List<Integer> B;

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
            synset.put(Arrays.asList(idAndNouns[1].split("_")), ++id);
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
    }

    // returns all WordNet nouns
    public Iterable<String> nouns() {
        List<String> iterableNouns = new ArrayList<>();
        synset.keySet().forEach(iterableNouns::addAll);
        return iterableNouns;

    }

    // is the word a WordNet noun?
    public boolean isNoun(String word) {
        if (word == null) {
            throw new IllegalArgumentException("Arg is illegal");
        }
         List<String> iterableNouns = new ArrayList<>();
         iterableNouns.addAll((Collection<? extends String>) nouns());
        return iterableNouns.contains(word);

    }

    // distance between nounA and nounB (defined below)
    public int distance(String nounA, String nounB) {
        if (nounA == null || nounB == null || !isNoun(nounA) || !isNoun(nounB)) {
            throw new IllegalArgumentException("Arg illegal");
        }
        A = new ArrayList<>();
        B = new ArrayList<>();

        for (List<String> list : synset.keySet()) {
            for (String noun : list) {
                if (nounA.equals(noun)) {
                    A.add(synset.get(list));
                }
                if (nounB.equals(noun)) {
                    B.add(synset.get(list));
                }
            }
        }
        distanceIterables = new SAP(wordNet);
        return distanceIterables.length(A, B);
    }


    // a synset (second field of synsets.txt) that is the common ancestor of nounA and nounB
    // in a shortest ancestral path (defined below)
    public String sap(String nounA, String nounB) {
        if (nounA == null || nounB == null || !isNoun(nounA) || !isNoun(nounB)) {
            throw new IllegalArgumentException("Arg illegal");
        }
        return String.valueOf(distanceIterables.ancestor(A, B));

    }

    // do unit testing of this class
    public static void main(String[] args) {
        WordNet test = new WordNet("synsets15.txt","hypernyms15Tree.txt");
        System.out.println(test.isNoun("ten"));
        System.out.println(test.distance("ten","nine"));
        System.out.println(test.sap("ten","nine"));
    }

}

