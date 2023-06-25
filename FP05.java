package streamsAndLamdas;

import java.util.List;
import java.util.function.Function;
//import java.util.stream.Collector;
import java.util.stream.Collectors;

public class FP05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> number = List.of(3,5,6,98,56,43);
		
		List<Integer> sqaredNumber = mapAndCreateNewList(number, x -> x*x);
		
		System.out.print(sqaredNumber);
	}

	private static List<Integer> mapAndCreateNewList(List<Integer> number, Function<Integer, Integer> mappingFunction) {
		
		
				return number.stream()
				.map(mappingFunction)
				.collect(Collectors.toList());
	}

}
