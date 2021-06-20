package rest;

import java.util.List;

public class CardService {
	CardDao cardDao = new CardDao();
	 
    public List<Card> getCard() {
        List<Card> cardList = cardDao.getCard();
        return cardList;
    }
    
    public Card saveCard(Card card) {
        Card cardResponse = cardDao.saveCard(card);
        return cardResponse;
    }
    
    public Card getCardForId(String id) {
    	Card card = cardDao.getCardForId(id);
        return card;
    }
}
