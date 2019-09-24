package programmers.sort.usage.copyOfRange;

import java.util.Arrays;

// http://tcpschool.com/java/java_api_arrays


/**
 * 
 * @author shkim
 * 
 * # Arrays 클래스 
 * 
 * 1. java.util 패키지
 * 
 *   - java.util 패키지에는 프로그램을 개발하는 데 사용할 수 있는 유용한 유틸리티 클래스가 다수 포함되어 있습니다.
 *   - 실제로 java.lang 패키지 다음으로 가장 많이 사용되는 패키지가 java.util 패키지입니다.
 *   - 하지만 import 문을 사용하지 않아도 바로 사용할 수 있는 java.lang 패키지와는 달리 
 *     java.util 패키지는 import 문으로 패키지를 불러오고 나서야 클래스 이름만으로 사용할 수 있습니다.
 *     
 * 2. java.util.Arrays 클래스
 * 
 *   - Arrays 클래스에는 배열을 다루기 위한 다양한 메소드가 포함되어 있습니다.
 *   - Arrays 클래스의 모든 메소드는 클래스 메소드(static method)이므로, 객체를 생성하지 않고도 바로 사용할 수 있습니다.
 *   - 이 클래스는 java.util 패키지에 포함되므로, 반드시 import 문으로 java.util 패키지를 불러오고 나서 사용해야 합니다.
 *   
 *   
 *   2.1 copyOfRange() 메소드
 *   
 *     - copyOfRange() 메소드는 전달받은 배열의 특정 범위에 해당하는 요소만을 새로운 배열로 복사하여 반환합니다.
 *     
 *     - 첫 번째 매개변수 : 복사의 대상이 될 원본 배열을 전달받음
 *     - 두 번째 매개변수 : 원본 배열에서 복사할 시작 인덱스를 전달받음
 *     - 세 번째 매개변수 : 마지막으로 복사될 배열 요소의 바로 다음 인덱스를 전달받음
 *     
 *     - 즉, 세 번째 매개변수로 전달된 인덱스 바로 전까지의 배열 요소까지만 복사됩니다.
 *     - 그리고 원본 배열과 같은 타입의 복사된 새로운 배열을 반환합니다.
 *
 */
public class CopyOfRangeUsage {

	public static void main(String[] args) {
		
		int[] arr1 = {1, 2, 3, 4, 5};
		
		int[] arr2 = Arrays.copyOfRange(arr1, 2, 4);
		
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
		
	}
	
}
