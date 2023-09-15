package mangathaPackage;
public class Players {

    String name;

    int bet=0;

    Card cardType;

    String cardPosition;

    boolean win = false;


    public Players(String name, int bet, Card cardType, String cardPosition) {

        this.name = name;

        this.bet = bet;

        this.cardType = cardType;

        this.cardPosition = cardPosition;
        
        System.out.println("hello");

    }


    public void setWin(boolean win) {

         this.win = win;

         
    }


    public String getName() {

        return name;

    }
    
    public String getCardPosition() {

        return cardPosition;

    }
    
    public int getBet() {

        return bet;

    }


    public Card getCardType() {

        return cardType;

    }




    public boolean getWin() {

        return win;

    }

 

}
