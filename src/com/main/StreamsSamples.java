package com.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.*;

public class StreamsSamples {

	public static void main(String[] args) {
		List<String> list= new ArrayList<>();
		list.add("Zebra");
		list.add("array");
		list.add("apple");
		
		List<String> fl=list.stream()
				//.filter(p->(null!=p && !p.isEmpty()) && p.equals("ramana"))
				//.distinct()
				.map(String::toUpperCase)
				.sorted()
				.collect(Collectors.toList());
		System.out.println("fl "+fl );
		String ss=list.stream()
				//.map(Object::toString)
				.filter(s->(null!=s && !s.isEmpty()))
				.distinct()
				.collect(Collectors.joining("#"));
		System.out.println("ss "+ss );
		
	list.stream()
				.filter(p->(null!=p && !p.isEmpty()) && p.startsWith("a"))
				.distinct()
				.map(String::toUpperCase)
				.sorted()
				.collect(Collectors.toList())
				.forEach(System.out::println);
	
	Arrays.asList("ra","ab","bc")
		 .stream()
		 //.findFirst()
		 .findAny()
		 .map(String::toUpperCase)
		 .ifPresent(System.out::println);
	
	Stream.of("qq","aa","bb")
	      .map(String::toUpperCase)
		  .forEach(System.out::println);
	
	IntStream.range(1, 8)
			 //.forEach(System.out::println);
			.average()
			.ifPresent(System.out::println);  // 5.0
	
	Stream.of("a1", "a2", "a9")
    .map(s->s.substring(1))
    .mapToInt(Integer::parseInt)
    .max()
    .ifPresent(System.out::println);
    
	IntStream.range(1, 3)
	.mapToObj(i->"Ramana"+i)
	.forEach(System.out::println); 
	
	Stream.of(1.0, 2.0, 3.0)
    .mapToInt(Double::intValue)
    .mapToObj(i -> "a" + i)
    .forEach(System.out::println);
	
	Stream.of("d2", "a2", "b1", "b3", "c")
    .filter(s -> {
        System.out.println("filter: " + s);
        return true;
    })
    .forEach(s -> System.out.println("forEach: " + s));
	
	Stream.of("d2", "a2", "b1", "b3", "c")
	.map(s->{
		 System.out.println("map: " + s);
		 return s.toUpperCase();
	})
	.anyMatch(s->{
		System.out.println("anyMatch: " + s);
		return s.startsWith("A");
	});
	
	Stream.of("d2", "a2", "b1", "b3", "c")
	.map(s->{
		 System.out.println("map new : " + s);
		 return s.toUpperCase();
	})
	.filter(s->{
		System.out.println("filter: " + s);
		return s.startsWith("A");
	})
	.forEach(s->{
		System.out.println("forEach new: " + s);
	});
	
	
	
	Stream.of("d2", "a2", "b1", "b3", "c")

	.filter(s->{
		System.out.println("filter: first :  " + s);
		return s.startsWith("a");
	})
	.map(s->{
		 System.out.println("map new : " + s);
		 return s.toUpperCase();
	})
	.forEach(s->{
		System.out.println("forEach: " + s);
	});
	
	
	Stream.of("d2", "a2", "b1", "b3", "c")
    .sorted((s1, s2) -> {
        System.out.printf("sort: %s; %s\n", s1, s2);
        return s1.compareTo(s2);
    })
    .filter(s -> {
        System.out.println("filter: " + s);
        return s.startsWith("a");
    })
    .map(s -> {
        System.out.println("map: " + s);
        return s.toUpperCase();
    })
    .forEach(s -> System.out.println("forEach: " + s));
	
	
	
	
	Stream.of("d2", "a2", "a3","b1", "b3", "c")
    .filter(s -> {
        System.out.println("filter: optimize the performance: " + s);
        return s.startsWith("a");
    })
    .sorted((s1, s2) -> {
        System.out.printf("sort: optimize the performance  : %s; %s\n", s1, s2);
        return s1.compareTo(s2);
    })
    .map(s -> {
        System.out.println("map: " + s);
        return s.toUpperCase();
    })
    .forEach(s -> System.out.println("forEach: " + s));
	
	
	
    Stream.of("one", "two", "three", "four")
    .filter(e -> e.length() > 3)
    .peek(e -> System.out.println("Filtered value: " + e))
    .map(String::toUpperCase)
    .peek(e -> System.out.println("Mapped value: " + e))
    .collect(Collectors.toList());
	
	}
	
}
