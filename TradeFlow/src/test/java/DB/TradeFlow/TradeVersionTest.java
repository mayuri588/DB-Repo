package DB.TradeFlow;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Test;

import DB.pojo.Trade;

public class TradeVersionTest {
	
@Test
	public void insertTradeVersionTest( ) {
	
	TradeFlow tf = new TradeFlow();
	Trade trade = new Trade();
	
	trade.setTradeId("T1");
	trade.setCounterPartyId("cp-1");
	LocalDate d = LocalDate.now();
	trade.setCreatedDate(d);
	trade.setBookId("B2");
	trade.setExpired("N");
	trade.setMaturityDate(d.minusDays(1));
	trade.setVersion(1);
	
	Trade trade2 = new Trade();
	trade2.setTradeId("T1");
	trade2.setCounterPartyId("cp-1");
	//LocalDate d = LocalDate.now();
	trade2.setCreatedDate(d);
	trade2.setBookId("B1");
	trade2.setExpired("N");
	trade2.setMaturityDate(d.minusDays(1));
	trade2.setVersion(0);
	
	try {
		tf.insertTrade(trade);
		assertEquals("success", true, tf.insertTrade(trade2));
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		
	}




}
