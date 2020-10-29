package DB.TradeFlow;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Test;

import DB.pojo.Trade;

public class TradeMaturityDateTest {

	@Test
	public void insertMaturityDateTest( ) {

	TradeFlow tf = new TradeFlow();
	Trade trade = new Trade();
	Trade trade2 = new Trade();

	trade.setTradeId("T1");
	trade.setCounterPartyId("cp-1");
	LocalDate d = LocalDate.now();
	trade.setCreatedDate(d);
	trade.setBookId("B2");
	trade.setExpired("N");
	trade.setMaturityDate(d.minusDays(1));
	trade.setVersion(1);

	trade2.setTradeId("T1");
	trade2.setCounterPartyId("cp-1");
	//LocalDate d = LocalDate.now();
	trade2.setCreatedDate(d);
	trade2.setBookId("B2");
	trade2.setExpired("N");
	trade2.setMaturityDate(d);
	trade2.setVersion(1);


	try {
		//tf.insertTrade(trade);
		//assertEquals("failed", false, tf.insertTrade(trade));
		//assertEquals("success", true, tf.insertTrade(trade2));
		assertTrue(tf.insertTrade(trade2));
		//assertTrue(tf.insertTrade(trade));
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		
	}
}
