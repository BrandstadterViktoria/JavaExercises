import java.util.*;

public class Deck {
    private Random r = new Random();
    private int numberOfCards;
    private List<Card> cards;
    private final String[] colors = {"Heart", "Spade", "Diamond", "Club"};
    private final String[] arrayOfValues = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    private List<String> values;


    public Deck(int numberOfCards) {
        this.numberOfCards = numberOfCards;
        this.cards = new ArrayList<>();
        this.values = new ArrayList<>(Arrays.asList(arrayOfValues));
        fillListOfCards(numberOfCards);
        Collections.shuffle(cards);
    }

    public void fillListOfCards(int numberOfCards) {
        for (int i = 0; i < numberOfCards / 4; i++) {
            cards.add(new Card(colors[0], valueGenerator()));
            cards.add(new Card(colors[1], valueGenerator()));
            cards.add(new Card(colors[2], valueGenerator()));
            cards.add(new Card(colors[3], valueGenerator()));
        }
        if (numberOfCards % 4 >= 0) {
            int reminder = numberOfCards % 4;
            for (int j = 0; j < reminder; j++)
                cards.add(new Card(colors[0], valueGenerator()));
            cards.add(new Card(colors[1], valueGenerator()));
            cards.add(new Card(colors[2], valueGenerator()));
        }
    }

    public String valueGenerator() {
        String randomValue;
        int randomIndex = r.nextInt(values.size());
        randomValue = values.get(randomIndex);
        values.remove(randomIndex);
        return randomValue;
    }

    public Card draw() {
        Card topCard = cards.get(0);
        cards.remove(topCard);
        numberOfCards--;
        return topCard;
    }

    public void deckInformation() {
        int numberOfClubs = 0;
        int numberOfDiamonds = 0;
        int numberOfHearts = 0;
        int numberOfSpades = 0;
        for (int i = 0; i < cards.size(); i++) {
            cards.get(i).getColor();
            if (cards.get(i).getColor() == "Club") {
                numberOfClubs++;
            }
            if (cards.get(i).getColor() == "Diamond") {
                numberOfDiamonds++;
            }
            if (cards.get(i).getColor() == "Heart") {
                numberOfHearts++;
            }
            if (cards.get(i).getColor() == "Spade") {
                numberOfSpades++;
            }
        }
        System.out.println(numberOfCards + "cards - " + numberOfClubs + " Clubs " + numberOfDiamonds + " Diamonds " +
                numberOfHearts + " Hearts " + numberOfSpades + " Spades ");
    }

}
