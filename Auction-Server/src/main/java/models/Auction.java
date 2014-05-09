package models;

import java.util.ArrayList;
import java.util.HashMap;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Auction {

	HashMap<Item, ArrayList<Bid>> auctions = new HashMap<Item, ArrayList<Bid>>();
	
	public boolean addAuction(Item item){
		boolean itemAdded = false;
		ArrayList<Bid> bids;
		if((bids = auctions.put(item, new ArrayList<Bid>())) == null)
			itemAdded = true;
		else
				auctions.put(item, bids);
		return itemAdded;
	}
	
	public ArrayList<Bid> getBids(Item item){
		return auctions.get(item);
	}
	
	public boolean addBid(Item item,Bid bid){
		boolean bidAdded = false;
		if(bid.getAmount() == 0.0 && bid.getUsername() != null)
		{
			auctions.get(item).add(bid);
			bidAdded = true;
		}
		return bidAdded;
	}
	
	public boolean removeBid(Item item, Bid bid){
		boolean bidRemoved = false;
		
		if(auctions.get(item) != null&&auctions.get(item).contains(bid)){
			auctions.get(item).remove(bid);
			bidRemoved = true;
		}
		return bidRemoved;
	}
	
	public boolean updateItem(Item item, int id){
		boolean itemUpdated = false;
		Item savedItem = null; 
		for(Item i : auctions.keySet()){
			if(i.getId() == id){
				updateAttributes(i, item);
				itemUpdated = true;
			}
		}
		return itemUpdated;
	}
	
	protected Item getItemById(int id){
		for(Item i : auctions.keySet()){
			if(i.getId() == id)
				return i;
		}
		return null;
	}

	private void updateAttributes(Item original, Item update) {
		original.setName(update.getName());
		original.setOwner(update.getOwner());
		original.setStatus(update.getStatus());
	}
}