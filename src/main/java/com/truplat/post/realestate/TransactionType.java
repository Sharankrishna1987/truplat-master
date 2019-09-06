package com.truplat.post.realestate;

public enum TransactionType {
	
	SELL("Sell", "sell"),
	RENT("Rent", "rent");
	
	private String label;
	private String value;
	
	private TransactionType(String label, String value) {
		this.label = label;
		this.value = value;
	}
	
	public static String getLabel(String value) {
		for(TransactionType transactionType : TransactionType.values()){
			if(transactionType.value.equals(value)) {
				return transactionType.label;
			}
		}
		return null;
	}
}
