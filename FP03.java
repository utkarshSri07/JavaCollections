package streamsAndLamdas;

import java.util.Comparator;
import java.util.List;

public class FP03 {
		public static void main(String args[])
		{
//			String[] words= {"Hello","World","Apple","Tomato","Allahabad","Patna"};
			 List<String> str= List.of("Hello","World","Apple","Tomato","Allahabad","Patna");
			sortingWords(str);
		}

		private static void sortingWords(List<String> str) {
			// TODO Auto-generated method stub
			str.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println);
			
			str.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
			
			str.stream().sorted(Comparator.comparing(strs -> strs.length())).forEach(System.out::println);
			
		}
		
		
}
