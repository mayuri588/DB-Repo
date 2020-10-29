package DB.pojo;

import java.time.LocalDate;
import java.util.Date;

public class Trade {
	
	String tradeId;
	Integer version ;
	String counterPartyId;
	String bookId;
	
	LocalDate maturityDate;
	LocalDate createdDate;
	String expired;
	public String getTradeId() {
		return tradeId;
	}
	public void setTradeId(String tradeId) {
		this.tradeId = tradeId;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public String getCounterPartyId() {
		return counterPartyId;
	}
	public void setCounterPartyId(String counterPartyId) {
		this.counterPartyId = counterPartyId;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public LocalDate getMaturityDate() {
		return maturityDate;
	}
	public void setMaturityDate(LocalDate maturityDate) {
		this.maturityDate = maturityDate;
	}
	public LocalDate getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDate d) {
		this.createdDate = d;
	}
	public String getExpired() {
		return expired;
	}
	public void setExpired(String expired) {
		this.expired = expired;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		
		if (obj == this) {
	         return true;
	      }
		
		if (!(obj instanceof Trade)) { 
            return false; 
        } 
		Trade trade = (Trade)obj;
		
		return tradeId.equals(trade.getTradeId()) ;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		 final int prime = 31;
	        int result = 1;
	        result = prime * result
	                + ((tradeId == null) ? 0 : tradeId.hashCode());
	        return result;
	}

}
