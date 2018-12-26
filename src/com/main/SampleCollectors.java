package com.main;

import static java.util.stream.Collectors. joining;
import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.toSet;
import static java.util.stream.Collectors.groupingBy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

public class SampleCollectors {
	public static void main(String[] args) {
		//LIST
		List<String> list=Arrays.asList("a","aa","aaa","Ramana","Katreddy");
		List<String> result=list.stream().collect(toList());
		System.out.println(result);
		//SET
		Set<String> setResult=list.stream().collect(toSet());
		System.out.println(setResult);
		
		//Custom
		List<String> resultLinked =list.stream()
				.filter(s->s.startsWith("a"))
				.map(s->s+" reddy")
				.collect(toCollection(LinkedList::new));
		System.out.println(resultLinked);
		
		//MAP
		Map<String, Integer> mapResult=list.stream().collect(toMap(Function.identity(), String::length));
		System.out.println("mapResult1:: "+mapResult);
		mapResult=list.stream().collect(toMap(Function.identity(), String::length,(i1,i2)->i1));
		System.out.println("mapResult2:: "+mapResult);
		String ss=list.stream().collect(joining(" ","PRE-","-POST"));
		System.out.println("ss:: "+ss);
		Map<Integer, Set<String>> resultGroupBy=list.stream().collect(groupingBy(String::length,toSet()));
		System.out.println("resultGroupBy:: "+resultGroupBy);
	}
}
