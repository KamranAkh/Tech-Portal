package rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CardDao {
	static HashMap<String, Card> cardMap = new HashMap<String, Card>();
	
	public CardDao() {
	    Card card1 = new Card();
	    card1.setId("1");
	    card1.setNumber("111122223333");
	    card1.setName("USER");
	    card1.setExpiration("08/2024");
	    card1.setCvv("140");
	    
	    cardMap.put("1", card1);
	}

	public Card saveCard(Card card) {
		cardMap.put(card.getNumber(), card);
		return cardMap.get(card.getNumber());
	}
	
	public List<Card> getCard() {
        List<Card> cardList = new ArrayList<Card>(cardMap.values());
        return cardList;
    }
	
	public Card getCardForId(String id) {
        Card card = cardMap.get(id);
        return card;
    }
}
