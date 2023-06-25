package streamsAndLamdas;

import java.util.List;
import java.util.stream.Collectors;

public class FP04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> number = List.of(3,5,6,98,56,43);
		List<Integer> squareNumber = square(number);
		System.out.print(squareNumber);
		
		

	}

	private static List<Integer> square(List<Integer> number) {
		// TODO Auto-generated method stub
		return number.stream().map(x-> x*x).collect(Collectors.toList());
	}

}
// those who return stream are called intermediate operations
// terminal operations are those which return something other than stream they could be 
//anything like int array boolean etc..