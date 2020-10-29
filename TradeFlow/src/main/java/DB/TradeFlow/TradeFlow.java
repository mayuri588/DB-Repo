package DB.TradeFlow;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import DB.pojo.Trade;

public class TradeFlow implements Runnable{
	Set<Trade> tradeSet = new HashSet<Trade>();;
	LocalDate sysDate = LocalDate.now();
	public TradeFlow() {
		
	}
	
	public boolean insertTrade(Trade trade) throws Exception {
		boolean flag = false;
		
		if(!trade.getMaturityDate().isBefore(sysDate)) {
		if(tradeSet.contains(trade)) {
		for (Trade t: tradeSet) {
			if(t.equals(trade)) {
		if(trade.getVersion()<t.getVersion()){
			throw new Exception();
		}
		else if(trade.getVersion()==t.getVersion()) {
			tradeSet.remove(t);
			tradeSet.add(trade);
			flag = true;
		}
			}
		
	}
		}else {
		tradeSet.add(trade);
		flag = true;
		}
	}
		return flag;
		
	}

	public void run() {
		
		if(!tradeSet.isEmpty()){
			
			for(Trade t: tradeSet) {
				if(t.getMaturityDate().isAfter(sysDate)) {
					Trade updateTrade =  new Trade();
					t.setExpired("Y");
					//updateTrade.setBookId(t.getBookId());
					//updateTrade.setTradeId(t.getTradeId());
					//updateTrade.setCounterPartyId(t.getCounterPartyId());
					//updateTrade.setCreatedDate(t.getCreatedDate());
					//updateTrade.setMaturityDate(t.getMaturityDate());
					//updateTrade.setVersion(t.getVersion());
					//tradeSet.remove(t);
					tradeSet.add(t);
				}
			}
				
			
		}
	}
	
	public void dispaly(){
		System.out.print("Trade Id");
		System.out.print("\t"+"Version");
		System.out.print("\t"+"Counter-Party Id");
		System.out.print("\t"+"Book-Id");
		System.out.print("\t"+"Maturity Date");
		System.out.print("\t"+"Created Date");
		System.out.print("\t"+"Expired");
		
		
		
		
		System.out.print("\n");
		if(!tradeSet.isEmpty()){
			
			for(Trade t : tradeSet) {
				System.out.print(t.getTradeId());
				System.out.print("\t\t"+t.getVersion());
				System.out.print("\t\t"+t.getCounterPartyId());
				System.out.print("\t\t"+t.getBookId());
				System.out.print("\t"+t.getMaturityDate());
				System.out.print("\t"+t.getCreatedDate());
				System.out.print("\t"+t.getExpired());
				
				
				
				
			}
		}
		
	}
	
	public static void main(String args[]) {
		Trade t = new Trade();
		t.setTradeId("T1");
		t.setCounterPartyId("cp-1");
		LocalDate d = LocalDate.now();
		t.setCreatedDate(d);
		t.setBookId("B1");
		t.setExpired("N");
		t.setMaturityDate(d.minusDays(1));
		t.setVersion(1);
		
		Trade t2 = new Trade();
		t2.setTradeId("T1");
		t2.setCounterPartyId("cp-1");
		//LocalDate d = LocalDate.now();
		t2.setCreatedDate(d);
		t2.setBookId("B2");
		t2.setExpired("N");
		t2.setMaturityDate(d.plusDays(2));
		t2.setVersion(1);
		
		TradeFlow flow = new TradeFlow();
		try {
			flow.insertTrade(t);
			flow.insertTrade(t2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Thread thread = new Thread(flow);
		//thread.run();
		thread.start();
		
		flow.dispaly();
		
	}

}
