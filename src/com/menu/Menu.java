package com.menu;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Menu {

	public static void main(String[] args) {
		List<Dish> menu=Arrays.asList(
				new Dish("pork",false,800,Dish.Type.MEAT),
				new Dish("beef",false,700,Dish.Type.MEAT),
				new Dish("chicken",false,400,Dish.Type.MEAT),
				new Dish("french friies",true,530,Dish.Type.OTHER),
				new Dish("pizza",true,550,Dish.Type.OTHER),
				new Dish("rice",true,350,Dish.Type.OTHER),
				new Dish("season fruit",true,120,Dish.Type.OTHER),
				new Dish("prawns",false,300,Dish.Type.FIRSH),
				new Dish("salmon",false,450,Dish.Type.FIRSH)
				);
		int cal=300;
		int limit=10;
		List<String> names=menu.stream()
				.filter(d->d.getCalories() > cal)
				.map(Dish::getName)
				.limit(limit)
				.sorted()
				.collect(toList());

		System.out.println("Dish Names: "+names);
		List<Integer> calories=menu.stream()
				//.filter(p->!p.isVegetarian())
				.map(Dish::getCalories)
				.collect(toList());
		System.out.println("calories :: "+calories);


		names=menu.stream()
				.filter(d->{
					//System.out.println("filtering .."+d.getName());
					return d.getCalories() > cal;	
				})
				.map(d->{
					//System.out.println("mapping .."+d.getName());
					return d.getName();
				})
				.limit(limit)
				.sorted()
				.collect(toList());

		System.out.println("Caloris of "+cal+" dishes "+names);

		List <Dish> vegDishes=menu.stream().filter(Dish::isVegetarian).collect(toList());
		System.out.println("vegDishes:: "+vegDishes);
		System.out.println("vegDishes 1st item:: "+vegDishes.get(0).getCalories());


		List<Dish> skipDishes=menu.stream().filter(d->d.getCalories()>cal)
				.skip(4)
				.collect(toList());

		System.out.println("Caloris of "+cal+" skipDishes "+skipDishes);

		List<Dish> firsttwomeats=menu.stream().filter(d->d.getType()==Dish.Type.MEAT)
				.limit(2)
				.collect(toList());
		System.out.println("firsttwomeats:: "+firsttwomeats);

		Optional<String> findFirst= menu.stream().filter(d->d.isVegetarian())
					 .map(Dish::getName)
					 //.skip(2)
					 .findAny();
					 //.findAny();
					 //.findFirst();
		if(findFirst.isPresent()) {
		System.out.println("findFirst:: "+findFirst.get());
		}
		
		int count =menu.stream().map(d->1)
		.reduce(0,(a,b)->a+b);
	
		System.out.println("count :: "+count);
		long countLong=menu.stream().count();
		System.out.println("countLong :: "+countLong);
		
		//Integer

		List<Integer> numbers=Arrays.asList(1,2,3,4,5,6,6);
		numbers.stream().filter(i-> i%2 == 0)
		.distinct()
		.forEach(System.out::println);


		numbers.stream().map(n->n*2)
		.collect(toList());

		boolean anyBoolean = numbers.stream().anyMatch(i->{
			System.out.println("i:: "+i);
			return i%2==0; 
		});

		System.out.println("anyBoolean:: "+anyBoolean);

		boolean allmtaches= numbers.stream().allMatch(i->i/3==0);
		System.out.println("allmtaches:: "+allmtaches);
		
		int m= numbers.stream().reduce(1, (a,b)->{
			System.out.println(a+"::"+b);
			return a*b;
		});
		System.out.println("Multipylication:: "+m);

		Optional<Integer> sum=numbers.stream().reduce((a,b)-> a+b);
		System.out.println("sum :: "+sum.orElse(0));
		
		Optional<Integer> max =numbers.stream().reduce(Integer::max);
		System.out.println("max :: "+max.get());

		Optional<Integer> min =numbers.stream().reduce(Integer::min);
		System.out.println("min :: "+min.get());
		
		// Strings
		List<String> words=Arrays.asList("Java8","Lambda","In","Action");

		List<Integer> interger=words.stream()
				.map(String::length)
				.collect(toList());
		System.out.println("Interger::"+interger);

		List<String> chaList=words.stream().map(w->w.split(""))
				.flatMap(Arrays::stream)
				.distinct()
				.collect(toList());
		System.out.println("Words chaList::"+chaList);

		interger=menu.stream().map(Dish::getName)
				.map(String::length)
				.collect(toList());
		System.out.println("Dish Interger::"+interger);

	}

}
