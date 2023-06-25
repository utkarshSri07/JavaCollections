package streamsAndLamdas;

import java.util.List;
// this is functional approach
public class FP01 {
	public static void main(String args[])
	{
		printAllNumberInListFunction(List.of(17,78,98,45,87,65,1,78,12));
		printEven(List.of(17,78,98,45,87,65,1,78,12));
		
	}
	public static boolean isEven(int number)
	{
		return number%2==0;
	}
	public static void print(int a)
	{
		System.out.print(a+"\n");
	}
	
	private static void printEven(List<Integer> number) {
		
		number.stream().
		filter(FP01::isEven) // Filter Only allow Even Numbers
		.forEach(FP01::print);
		
	}
	private static void printAllNumberInListFunction(List<Integer> number) {
		
		number.stream().forEach(FP01::print); // :: <- this is the symbol of method reference
		
	}
}
