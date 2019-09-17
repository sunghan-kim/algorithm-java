package insertionSort;

public class SortingTest {

	public static void main(String[] args) {
		
		Contact[] friends = new Contact[8];
		
		friends[0] = new Contact("Steve", "Smith", "734-521-1214");
		friends[1] = new Contact("Kelly", "Barnes", "165-132-5654");
        friends[2] = new Contact("Make", "Ball", "223-323-2333");
        friends[3] = new Contact("Mynsu", "Kang", "345-643-3113");
        friends[4] = new Contact("Calm", "Jeremy", "564-323-1645");
        friends[5] = new Contact("Jane", "Moon", "546-413-4543");
        friends[6] = new Contact("Hyun", "Lee", "442-454-3211");
        friends[7] = new Contact("Cream", "Jone", "751-231-5618");
		
        System.out.println("#### Before Sorting ####");
		for (Contact friend : friends) {
			System.out.println(friend);
		}
		
		System.out.println("--------------------------------");

		Sorting.insertionSort(friends);

		System.out.println("#### After Sorting ####");
		for (Contact friend : friends) {
			System.out.println(friend);
		}
		
	}
	
}
