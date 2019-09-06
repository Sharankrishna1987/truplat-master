package com.truplat.post.electronic;

public enum ElectronicType {
	
	COMPUTERS_LAPTOPS("1", "Computers & Laptops"),
	MOBILES("2", "Mobiles"),
	TABLETS("3", "Tablets"),
	TELEVISIONS("4", "Televisions"),
	AUDIO_VIDEO_PLAYERS("5", "Audio & Video Players"),
	HARD_DISKS_PRINTERS_MONITORS("6", "Hard Disks, Printers & Monitors"),
	AIR_CONDITIONERS("7", "Air Conditioners"),
	WASHING_MACHINES("8", "Washing Machines"),
	Refrigerators("9", "Refrigerators"),
	COMPUTER_ACCESSORIES("10", "Computer Accessories"),
	CAMERAS_LENSES("11", "Cameras & Lenses"),
	KITCHEN_OTHER_APPLIANCES("12", "Kitchen & Other Appliances"),
	GAMES_ENTERTAINMENT("13", "Games & Entertainment");
	
	private String name;
	private String id;
	
	private ElectronicType(String id, String name) {
		this.name = name;
		this.id = id;
	}
	
	public static String getName(String id) {
		for(ElectronicType type : ElectronicType.values()){
			if(type.id.equals(id)) {
				return type.name;
			}
		}
		return null;
	}
}
