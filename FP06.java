package streamsAndLamdas;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Course {
	private String name;
	private String category;
	private int reviewScore;
	private int noOfStudents;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getReviewScore() {
		return reviewScore;
	}

	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
	}

	public int getNoOfStudents() {
		return noOfStudents;
	}

	public void setNoOfStudents(int noOfStudents) {
		this.noOfStudents = noOfStudents;
	}

	public Course(String name, String category, int reviewScore, int noOfStudents) {
		super();
		this.name = name;
		this.category = category;
		this.reviewScore = reviewScore;
		this.noOfStudents = noOfStudents;
	}

	@Override
	public String toString() {
		return "Course [name=" + name + ", category=" + category + ", reviewScore=" + reviewScore + ", noOfStudents="
				+ noOfStudents + "]";
	}

}

public class FP06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Course> courses = List.of(new Course("Android", "Technology", 2, 1050),
				new Course("Spring", "FrameWork", 3, 1100), new Course("IOT", "Technology", 3, 1000),
				new Course("Angular", "FrameWork", 4, 2500), new Course("React", "Library", 2, 1000),
				new Course("Docker", "Technology", 4, 3000));

		// allMatch :-> it is a predicate which will give boolean here it will check
		// whether given condition is applicable all or not.
		// noneMatch :-> follows same as allmatch but can be consider as negation of
		// allMatch;
		// anyMatch :-> is therre is any that matches the given condition
		Predicate<Course> predicateReviewScoreGreater1 = course -> course.getReviewScore() > 1;
		Predicate<Course> predicateReviewScoreGreater5 = course -> course.getReviewScore() > 4;

		System.out.println(courses.stream().allMatch(predicateReviewScoreGreater1));

		System.out.println(courses.stream().noneMatch(predicateReviewScoreGreater5));

		System.out.println(courses.stream().anyMatch(predicateReviewScoreGreater5));

		// Sorting courses and
		Comparator<Course> comparingByNoOfStudentsIncreasing = Comparator.comparing(Course::getNoOfStudents);

		Comparator<Course> comparingByNoOfStudentsDecreaing = Comparator.comparing(Course::getNoOfStudents)
				.thenComparing(Course::getReviewScore).reversed();

		List<Course> assending = courses.stream().sorted(comparingByNoOfStudentsIncreasing)
				.collect(Collectors.toList());
		for (Course c : assending) {
			System.out.println(c);
		}
		System.out.print("Decending Print \n");
		List<Course> decending = courses.stream().sorted(comparingByNoOfStudentsDecreaing).collect(Collectors.toList());
		for (Course c : decending) {
			System.out.println(c);
		}

		// Limit -> Allows you to limit
		System.out.println("-----------------");
		List<Course> UsingLimit = courses.stream().sorted(comparingByNoOfStudentsIncreasing).limit(3)
				.collect(Collectors.toList());
		for (Course c : UsingLimit) {
			System.out.println(c);
		}
		System.out.println("-----------------");
		// Skip :-> it will skip the elements till that range
		List<Course> UsingSkip = courses.stream().sorted(comparingByNoOfStudentsIncreasing).skip(2)
				.collect(Collectors.toList());
		for (Course c : UsingSkip) {
			System.out.println(c);
		}
		// skip and limit combination : here it will skip the first then print limited
		// numbers
		System.out.println("-----------------");
		List<Course> UsingSkipLimit = courses.stream().sorted(comparingByNoOfStudentsIncreasing).skip(1).limit(2)
				.collect(Collectors.toList());
		for (Course c : UsingSkipLimit) {
			System.out.println(c);
		}
		System.out.println("-----------------");
		// takeWhile :It will allow intake of elments unitl the condition is met ,once
		// condition is failed it will stop form there
		List<Course> TakeWhile = courses.stream().takeWhile(course -> course.getNoOfStudents() < 3000)
				.collect(Collectors.toList());
		for (Course c : TakeWhile) {
			System.out.println(c);
		}

//		dropWhile : it will skip the element that matches the condition;
		System.out.println("-----------------");
		List<Course> DropWhile = courses.stream().dropWhile(course -> course.getNoOfStudents() < 2000)
				.collect(Collectors.toList());
		for (Course c : DropWhile) {
			System.out.println(c);
		}
		
		//max
		System.out.println("-----------------");
		System.out.println(courses.stream().max(comparingByNoOfStudentsIncreasing));
		//instead of return null it return optional.empty
		System.out.println("-----------------");
		System.out.println(
				courses.stream().filter(predicateReviewScoreGreater5).findFirst()
				);
		
		System.out.println("-----------------");
		System.out.println(
				courses.stream().filter(predicateReviewScoreGreater1).findFirst()
				);
//		findAny it will return any value with condition applied.
		System.out.println("-----------------");
		System.out.println(
				courses.stream().filter(predicateReviewScoreGreater1).findFirst()
				);
		
		System.out.println("-------SUM----------");
		System.out.println(
				courses.stream().filter(predicateReviewScoreGreater1).
				mapToInt(Course::getNoOfStudents)
				.sum()
				);
		System.out.println("-------Average----------");
		System.out.println(
				courses.stream().filter(predicateReviewScoreGreater1).
				mapToInt(Course::getNoOfStudents)
				.average()
				);
	
		System.out.println("-------Count----------");
		System.out.println(
				courses.stream().filter(predicateReviewScoreGreater1).
				mapToInt(Course::getNoOfStudents)
				.count()
				);
		
	
	System.out.println("-------MIN----------");
	System.out.println(
			courses.stream().filter(predicateReviewScoreGreater1).
			mapToInt(Course::getNoOfStudents)
			.min()
			);
	
	System.out.println("-------Max----------");
	System.out.println(
			courses.stream().filter(predicateReviewScoreGreater1).
			mapToInt(Course::getNoOfStudents)
			.max()
			);
	
	
	System.out.println("-------Grouping By Category----------");
	System.out.println(courses.stream().collect(Collectors.groupingBy(Course :: getCategory)));
	
	System.out.println(courses.stream().collect(Collectors.groupingBy(Course :: getCategory,Collectors.counting())));
	
	}
}
