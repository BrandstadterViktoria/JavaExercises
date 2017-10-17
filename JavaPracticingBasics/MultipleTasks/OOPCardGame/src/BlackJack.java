public class BlackJack {
    public static void main(String[] args) {
        Deck deck = new Deck(9);
        deck.deckInformation();
        System.out.println(deck.draw());
        deck.deckInformation();
    }
}
