package edu.neumont.csc380.Model;

import java.sql.Timestamp;

public class Item {
	
	private int id;
	private String name;
	private String description;
	private Double highestBid;
	private Timestamp startDate;
	private Timestamp endDate;
	private String owner;
	private ItemStatus status;
	private String thumbnail;
	private String image;
	private String placeBid;
	private String edit;
	private String delete;
	private String history;
}
