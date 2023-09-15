package mangathaPackage;
import java.util.*;
public class Deck {

		static List<Card> cards = new ArrayList<>();
		public Deck() {
		for(int suit = 1 ; suit <= Card.MAX_SUIT ; suit++) {
			for(int rank = 1 ; rank <= Card.MAX_RANK; rank++) {
				cards.add(new Card(rank,suit));
				}
			}
		}
		public void shuffle()
		{
			Collections.shuffle(cards);
		}
		public Card drawRandom() {
			Random randomIndex = new Random();	
			return cards.remove(randomIndex.nextInt(0,cards.size()));
		}
		
		public Card removeTop() {
			if(cards.size() == 0) {
				return new Card(0,0);
			}
			return cards.remove(0);
		}
		
		public Card removeBottom() {
			if(cards.size() == 0) {
				return new Card(0,0);
			}
				return cards.remove(cards.size() - 1);
		}
		
		public void drawTop(Card card) {
			cards.add(card);
			
		}
		public void drawBottom(Card card) {
			cards.add(0,card);	
		}
		
		public String toString() {
			return cards.toString();
			}
	}
	    
	    