package blog.hyeonstorage.selectionSort;

// https://hyeonstorage.tistory.com/267?category=578561 - ���� ���� ��� ����

public class Contact implements Comparable {

	private String firstName, lastName, phone;
	
	public Contact(String first, String last, String telephone) {
		
		firstName = first;
		lastName = last;
		phone = telephone;
		
	}
	
	// Comparable �������̽��� �����Լ� compareTo
	// �����͸� ���ϴ� compareTo �Լ��� �����Ѵ�.
	@Override
	public int compareTo(Object other) {
		// TODO Auto-generated method stub
		
		int result;
		
		String otherFirst = ((Contact)other).getFirstName();
		String otherLast = ((Contact)other).getLastName();
		
		// �� ����� lastName�� ������ firstName ��
		if (lastName.equals(otherLast)) {
			result = firstName.compareTo(otherFirst);
		} else {
			result = lastName.compareTo(otherLast);
		}
		
		return result;
	}

	// �̸� ��ȯ
	public String getFirstName() {
		return firstName;
	}
	
	// �� ��ȯ
	public String getLastName() {
		return lastName;
	}
	
	// �ΰ��� ��ü�� ���� �̸��� ��� ��ġ�ϸ� True
	public boolean equals(Object other) {
		return (lastName.equals(((Contact)other).getLastName()) && firstName.equals(((Contact)other).getFirstName()));
	}
	
	public String toString() {
		return lastName + ", " + firstName + "\t" + phone;
	}
	
}
