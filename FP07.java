package streamsAndLamdas;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FP07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Problem Here we wil pass List of Strings and get A single String as a Output.
		List<String> li= List.of("Aeroplane","Bus","Car","Train","Ship","HollaYouC");
		List<String> course2= List.of("Aeroplane","Bus","Car","Train","Ship","HollaYouC");
		String s=li.stream().collect(Collectors.joining(","));// Each String is seprated by space.
		System.out.println(s);
		
		//flatMap
		
		
		List<String[]> li2= li.stream().map(course -> course.split("")).collect(Collectors.toList());
		System.out.println(li2);
		
		
		List<String> li3=li.stream().map(course -> course.split("")).flatMap(Arrays::stream).collect(Collectors.toList());
		System.out.println(li3);
		
		//getting pair
		
		List<List<String>> li4= li.stream().flatMap(course -> course2.stream().map(courses2 
				-> List.of(course,courses2))).collect(Collectors.toList());
		
		System.out.println(li4);
		
		
		List<List<String>> li5= li.stream().flatMap(course -> course2.stream().map(courses2 
				-> List.of(course,courses2))).filter(list -> !list.get(0).equals(list.get(1))).collect(Collectors.toList());
		
		System.out.println(li5);

		List<List<String>> li6= li.stream().flatMap(course -> course2.stream().filter(courses2 -> courses2.length()==course.length()).map(courses2 
				-> List.of(course,courses2))).filter(list -> !list.get(0).equals(list.get(1))).collect(Collectors.toList());
		
		System.out.println(li6);
	}

}
