package mangathaPackage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import jakarta.servlet.annotation.WebServlet;

//import Cards.Card;

public class MangathaGameController {

public List<Card> cards = new ArrayList<>();

public MangathaGameController() {
    for (int suit = 1;suit <= Card.MAX_SUIT; suit++) {
        for (int rank = 1;rank <= Card.MAX_RANK; rank++) {
            cards.add(new Card(rank,suit));
        }
	  }    
	}
@Override
public String toString() {
    return cards.toString();
}

public void shuffle() {
    Collections.shuffle(cards);
}

public Card drawRandom() {
    Random random = new Random();
    return cards.remove(random.nextInt(0,cards.size()));
}

public Card drawTop() {
    if (cards.size() == 0) {
        return new Card(0,0);
    }
    return cards.remove(0);        
}
}

