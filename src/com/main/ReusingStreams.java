package com.main;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class ReusingStreams {

	public static void main(String[] args) {
		Stream<String> stream =
			    Stream.of("d2", "a2", "b1", "b3", "c")
			        .filter(s -> s.startsWith("a"));
					
		stream.anyMatch(s->true);
	//	stream.noneMatch(s->true);
		
		
		Supplier<Stream<String>> streamSupplier =
			    () -> Stream.of("d2", "a2", "b1", "b3", "c")
			            .filter(s -> s.startsWith("a"));

			streamSupplier.get().anyMatch(s -> {
				System.out.println("anyMatch: " + s);
				return true;
			});   // ok
			streamSupplier.get()
			.noneMatch(s -> {
				System.out.println("noneMatch: " + s);
				return true;
			});  // ok

	}

}
