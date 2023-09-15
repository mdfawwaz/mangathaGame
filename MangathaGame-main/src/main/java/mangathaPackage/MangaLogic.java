package mangathaPackage;

public class MangaLogic {
	Players player1;
	Players player2;
	Deck deck;
	Card topCard;
	int i;
	
	public MangaLogic(Players player1, Players player2) {
		this.player1 = player1;
		this.player2 = player2;
		deck = new Deck();
		deck.shuffle();
		i = 0;
	}
	
	public boolean Over() {
		topCard = deck.removeTop();
		if(topCard.equals(player1.getCardType()) && (i % 2 == (player1.getCardPosition().equals("in")? 0 :1))) {
			player1.setWin(true);
			return true;
		}
		else if(topCard.equals(player2.getCardType()) && (i % 2 == (player2.getCardPosition().equals("out")? 0 :1))) {
			player2.setWin(true);
			return true;
		}
		i += 1;
		return false;
	}
	
	public Card getTopCard() {
		return topCard;
	}
}
