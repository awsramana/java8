package com.trade;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TranMain {

	public static void main(String[] args) {
		Trader laxmi=new Trader("Laxmi","Cumming");
		Trader ramana=new Trader("Ramana","Edison");
		Trader sobhit=new Trader("Sobhit","Jersey City");
		Trader sowmit=new Trader("Sowmit","Cambridge");

		List<Transaction> tranctions=Arrays.asList(
			new Transaction(laxmi,2011,300),
			new Transaction(ramana,2012,1000),
			new Transaction(sobhit,2011,400),
			new Transaction(sobhit,2011,1000),
			new Transaction(sowmit,2012,700),
			new Transaction(sowmit,2012,710)
		);
		
		List<Transaction> trans2011=tranctions.stream()
				   .filter(t->t.getYear()==2011)
				   .sorted(Comparator.comparing(Transaction::getValue))
				   .collect(Collectors.toList());
		System.out.println("trans2011:: "+trans2011);
		
		List<String> cities=tranctions.stream()
		.map(t->t.getTrader().getCity())
		.distinct()
		.collect(Collectors.toList());
		System.out.println("cities :: "+cities);
		
		List<Trader> trader=tranctions.stream()
				  .map(Transaction::getTrader)
				  .filter(t->t.getCity().equals("Cambridge"))
				  .distinct()
				  .sorted(Comparator.comparing(Trader::getName,Comparator.naturalOrder()))
				  .collect(Collectors.toList());
		System.out.println("List Trader:: "+trader);
		
		Set<Trader> setTrader=tranctions.stream()
				  .map(Transaction::getTrader)
				  .filter(t->t.getCity().equals("Cambridge"))
				  .sorted(Comparator.comparing(Trader::getName,Comparator.reverseOrder()))
				  .collect(Collectors.toSet());
		
		System.out.println("SetTrader: "+setTrader);
		
		String strTrader=tranctions.stream()
				.map(t->t.getTrader().getName())
				.distinct()
				.sorted()
				.collect(Collectors.joining());
				//.collect(Collectors.joining("#"));
		System.out.println("strTrader:: "+strTrader);
		boolean bEdison=tranctions.stream()
				  .anyMatch(t->t.getTrader().getCity().equals("Edison"));
				//.allMatch(t->t.getTrader().getCity().equals("Edison"));
		System.out.println("bEdison: "+bEdison);
		
	}

}
