package blog.hyeonstorage.dataStructure.dataManagement.array;

// https://hyeonstorage.tistory.com/257?category=578561

/**
 * 
 * @author shkim
 * 
 * 3. 클래스를 이용한 배열 관리
 * 
 *   - 배열을 이용하여 데이터를 관리할 때 데이터의 삽입, 검색, 삭제 등의 기능을
 *     매번 직접 작성할 경우 사용할 때마다 중복되는 작업이 발생한다.
 *   - 배열의 삽입, 검색, 삭제 등의 기능을 하는 클래스를 만들어서 필요할 때 재사용할 수 있다.
 *
 */

public class MyArray {

	private Object[] data;
	private int count;
	
	public MyArray(int maxSize) {
		
		if (maxSize < 0) {
			throw new IllegalArgumentException("Illegal Capacity:" + maxSize);
		}
		
		// 객체 생성 시 받은 maxSize 크기의 배열을 만든다.
		this.data = new Object[maxSize];
		this.count = 0;
		
	}
	
	/**
	 * add
	 * @param obj
	 * 
	 * 배열의 마지막에 obj를 삽입한다.
	 */
	public void add(Object obj) {
		
		if (count >= data.length) {
			throw new ArrayIndexOutOfBoundsException(count + ">= " + data.length);
		}
		
		data[count++] = obj;
		
	}
	
	/**
	 * add
	 * @param index
	 * @param obj
	 * 
	 * index의 위치에 obj를 삽입한다. index 뒤의 데이터는 한칸씩 밀려난다.
	 */
	public void add(int index, Object obj) {
		
		if (count >= data.length) {
			throw new ArrayIndexOutOfBoundsException(count + ">= " + data.length);
		}
		
		for (int i=index; i < count; i++) {
			data[i+1] = data[i];
		}
		
		count++;
		
		data[index] = obj;
		
	}
	
	/**
	 * remove
	 * @param index
	 * 
	 * index 위치의 데이터를 삭제한다. index 뒤의 데이터는 한칸씩 당겨진다.
	 */
	public void remove(int index) {
		
		if (index >= count) {
			throw new ArrayIndexOutOfBoundsException(index + ">=" + count);
		} else if (index < 0) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		
		for (int i=index; i < count-1; i++) {
			data[i] = data[i+1];
		}
		
		count--;
		data[count] = null;
		
	}
	
	/**
	 * remove
	 * @param obj
	 * 
	 * obj를 찾아서 제거한다.
	 */
	public void remove(Object obj) {
		
		int index = find(obj);
		
		remove(index);
		
	}
	
	/**
	 * get
	 * @param index
	 * @return obj
	 * 
	 * index의 데이터를 가져온다.
	 */
	public Object get(int index) {
		
		if (index >= count) {
			throw new ArrayIndexOutOfBoundsException(index + ">=" + count);
		}
		
		return data[index];
		
	}
	
	/**
	 * find
	 * @param obj
	 * @return index
	 * 
	 * 배열에서 obj 를 찾아서 위치 index를 반환한다.
	 */
	public int find(Object obj) {
		
		int index;
		
		for (index=0; index < count; index++) {
			
			if (data[index].equals(obj)) {
				break;
			} else if (index == count-1) {
				index = -1;
				break;
			}
			
		}
		
		return index;
		
	}
	
	/**
	 * toString
	 * 
	 * 배열의 데이터를 출력
	 */
	public String toString() {
		
		StringBuffer str = new StringBuffer("[");
		
		if (count > 0) {
			str.append(data[0]);
		}
		
		for (int i=1; i < count; i++) {
			str.append(", ").append(data[i]);
		}
		
		str.append("]");
		
		return str.toString();
		
	}
	
}
