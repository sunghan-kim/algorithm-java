package blog.hyeonstorage.selectionSort;

// https://hyeonstorage.tistory.com/267?category=578561 - 선택 정렬 사용 예제

public class Contact implements Comparable {

	private String firstName, lastName, phone;
	
	public Contact(String first, String last, String telephone) {
		
		firstName = first;
		lastName = last;
		phone = telephone;
		
	}
	
	// Comparable 인터페이스의 구현함수 compareTo
	// 데이터를 비교하는 compareTo 함수를 구현한다.
	@Override
	public int compareTo(Object other) {
		// TODO Auto-generated method stub
		
		int result;
		
		String otherFirst = ((Contact)other).getFirstName();
		String otherLast = ((Contact)other).getLastName();
		
		// 비교 대상의 lastName이 같으면 firstName 비교
		if (lastName.equals(otherLast)) {
			result = firstName.compareTo(otherFirst);
		} else {
			result = lastName.compareTo(otherLast);
		}
		
		return result;
	}

	// 이름 반환
	public String getFirstName() {
		return firstName;
	}
	
	// 성 반환
	public String getLastName() {
		return lastName;
	}
	
	// 두개의 객체의 성과 이름이 모두 일치하면 True
	public boolean equals(Object other) {
		return (lastName.equals(((Contact)other).getLastName()) && firstName.equals(((Contact)other).getFirstName()));
	}
	
	public String toString() {
		return lastName + ", " + firstName + "\t" + phone;
	}
	
}
