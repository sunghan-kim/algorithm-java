package blog.hyeonstorage.dataStructure.dataManagement.array;

// https://hyeonstorage.tistory.com/257?category=578561

/**
 * 
 * @author shkim
 * 
 * 3. Ŭ������ �̿��� �迭 ����
 * 
 *   - �迭�� �̿��Ͽ� �����͸� ������ �� �������� ����, �˻�, ���� ���� �����
 *     �Ź� ���� �ۼ��� ��� ����� ������ �ߺ��Ǵ� �۾��� �߻��Ѵ�.
 *   - �迭�� ����, �˻�, ���� ���� ����� �ϴ� Ŭ������ ���� �ʿ��� �� ������ �� �ִ�.
 *
 */

public class MyArray {

	private Object[] data;
	private int count;
	
	public MyArray(int maxSize) {
		
		if (maxSize < 0) {
			throw new IllegalArgumentException("Illegal Capacity:" + maxSize);
		}
		
		// ��ü ���� �� ���� maxSize ũ���� �迭�� �����.
		this.data = new Object[maxSize];
		this.count = 0;
		
	}
	
	/**
	 * add
	 * @param obj
	 * 
	 * �迭�� �������� obj�� �����Ѵ�.
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
	 * index�� ��ġ�� obj�� �����Ѵ�. index ���� �����ʹ� ��ĭ�� �з�����.
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
	 * index ��ġ�� �����͸� �����Ѵ�. index ���� �����ʹ� ��ĭ�� �������.
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
	 * obj�� ã�Ƽ� �����Ѵ�.
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
	 * index�� �����͸� �����´�.
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
	 * �迭���� obj �� ã�Ƽ� ��ġ index�� ��ȯ�Ѵ�.
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
	 * �迭�� �����͸� ���
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
