package abstraction.ex03CardsWithPower;

public class Card {

    public static int cardPower(String cardRank, String cardSuit) {

        CardRank rank = CardRank.valueOf(cardRank);
        CardSuits cardSuits = CardSuits.valueOf(cardSuit);

        return rank.getRankPower() + cardSuits.getSuitPower();

    }
}
