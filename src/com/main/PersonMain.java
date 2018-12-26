package com.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.vo.Boo;
import com.vo.Foo;
import com.vo.Person;

public class PersonMain {

	public static void main(String[] args) {
		List<Person> persons =Arrays.asList(
			        new Person("Max", 18),
			        new Person("Peter", 23),
			        new Person("Pamela", 23),
			        new Person("David", 12));
		
		Map<Integer,List<Person>> personByAge=persons
		.stream()
		.collect(Collectors.groupingBy(p->p.getAge()));
		
		personByAge.forEach((age, p)-> System.out.format("Age %s: %s\n", age, p));

		
		Double averageAge=persons
		.stream()
		.collect(Collectors.averagingInt(p->p.getAge()));
		
		System.out.println("averageAge: "+averageAge);     // 19.0
		
		IntSummaryStatistics  intSummaryStatistics=persons
		.stream()
		.collect(Collectors.summarizingInt(p->p.getAge()));
		System.out.println("intSummaryStatistics: "+intSummaryStatistics);     // 19.0
		
		String phrase= persons
		.stream()
		.filter(p->p.getAge()>=18)
		.map(p->p.getName())
		.collect(Collectors.joining(" and ", "In India ", " are of legal age."));
		
		System.out.println(phrase);
		
		Map<Integer,String> map=persons
		.stream()
		.collect(Collectors.toMap(p->p.getAge(), p->p.getName(),(p1,p2)->p1+","+p2));
		
		System.out.println(map);
		
		
		Collector<Person, StringJoiner, String> personNameCollector =
			    Collector.of(
			        () -> new StringJoiner(" | "),          // supplier
			        (j, p) -> j.add(p.getName().toUpperCase()),  // accumulator
			        (j1, j2) -> j1.merge(j2),               // combiner
			        StringJoiner::toString);                // finisher
		
		String names=persons.stream().collect(personNameCollector);
		System.out.println(names);
		
		List<Person> filtered=persons.stream()
			.filter(p->p.getName().startsWith("P"))
			.collect(Collectors.toList());
		System.out.println("List filtered: "+filtered);
		
		Set<Person> filteredSet=persons.stream()
				.filter(p->!p.getName().startsWith("P"))
				.collect(Collectors.toSet());
			System.out.println("Set filtered: "+filteredSet);
		
			persons.stream()
			.reduce((p1,p2)->p1.getAge()>p2.getAge()?p1:p2)
			.ifPresent(System.out::println);
		
			
			Person result =
				    persons
				        .stream()
				        .reduce(new Person("", 0), (p1, p2) -> {
				            p1.age += p2.age;
				            p1.name += p2.name;
				            return p1;
				        });

				System.out.format("name=%s; age=%s \n", result.name, result.age);
				
				
				Integer ageSum1 = persons
					    .stream()
					    .reduce(0, (sum, p) -> sum += p.age, (sum1, sum2) -> sum1 + sum2);

					System.out.println(ageSum1);  // 76
					
					Integer ageSum = persons
						    .parallelStream()
						    .reduce(0,
						        (sum, p) -> {
						            System.out.format("accumulator: sum=%s; person=%s\n", sum, p);
						            return sum += p.age;
						        },
						        (sum1, sum2) -> {
						            System.out.format("combiner: sum1=%s; sum2=%s\n", sum1, sum2);
						            return sum1 + sum2;
						        });
					System.out.println(ageSum);  // 76
		//==================
		
			List<Foo> foos=new ArrayList<>();

			/*
			 
			 
			 			// create foos
			IntStream
			    .range(1, 4)
			    .forEach(i -> foos.add(new Foo("Foo" + i)));	
			// create bars
			foos.forEach(f ->
			    IntStream
			        .range(1, 4)
			        .forEach(i -> f.bars.add(new Boo("Bar" + i + " <- " + f.name))));	
			
			foos.stream()
		    .flatMap(f -> f.bars.stream())
		    .forEach(b -> System.out.println(b.name));
			 */
			
			
			IntStream.range(1, 4)
		    .mapToObj(i -> new Foo("Foo" + i))
		    .peek(f -> IntStream.range(1, 4)
		        .mapToObj(i -> new Boo("Bar" + i + " <- "+ f.name))
		        .forEach(f.bars::add))
		    .flatMap(f -> f.bars.stream())
		    .forEach(b -> System.out.println(b.name));
			
			/*
			 Optional.of(new Outer())
    .flatMap(o -> Optional.ofNullable(o.nested))
    .flatMap(n -> Optional.ofNullable(n.inner))
    .flatMap(i -> Optional.ofNullable(i.foo))
    .ifPresent(System.out::println);
			 */
			
	}

}
