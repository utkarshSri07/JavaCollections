package streamsAndLamdas;

import java.util.List;

public class FP02 {
	public static void main(String args[])
	{
		
		printEven(List.of(17,78,98,45,87,65,1,78,12,60908));
		
	}

	private static void printEven(List<Integer> number) {
		// TODO Auto-generated method stub
		number.stream()
		.filter( numbers -> numbers%2==0)// Lambda Expression it takes input argument and logic
		.forEach(System.out::println);//method reference
		
	}

}
