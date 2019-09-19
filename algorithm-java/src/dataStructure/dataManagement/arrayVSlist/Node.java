package dataStructure.dataManagement.arrayVSlist;

// https://hyeonstorage.tistory.com/258?category=578561

/**
 * 
 * @author shkim
 * 
 * # 단순 연결 리스트에서 사용하는 노드의 기본적인 구조
 * 
 * 
 * - 각 노드는 2가지의 변수로 이루어져 있다.
 * 
 *   1. data 변수
 *     - 실제 저장하는 데이터를 저장하는 변수
 *   
 *   2. nextNode 변수
 *     - 다음 노드를 가리키는 변수
 *   
 * - 감시 노드 (sentinel node)
 *   - 연결 리스트는 첫 번째 노드를 가리키는 시작점이 필요
 *   - 이러한 역할의 노드를 '감시 노드'라고 한다.
 *   - 일반적으로 '헤더'라고 부른다.
 *   - 헤더에는 리스트의 첫 번째 노드를 가리키는 참조자만 존재하며 실제 데이터는 없다.
 *   
 *   - 헤더가 가리키는 노드(nextNode)가 첫 번째 노드이다.
 *   - 첫 번째 노드의 nextNode가 두 번째 노드이다.
 *   - 두 번째 노드의 nextNode가 세 번째 노드가 된다.
 *   - ...
 *   
 *   - 이런 식으로 첫 번째 노드부터 마지막 노드까지 순차적으로 자신의 다음 노드를
 *     가리키는 참조가 있기 때문에 데이터의 삽입과 삭제 시 인접한 노드의 참조값만
 *     바꿔주면 되기 때문에 빠른 속도로 처리가 가능한 것이다.
 *
 */

public class Node {

	private Object data;
	private Node nextNode;
	
	Node(Object data) {
		this.data = data;
		this.nextNode = null;
	}
	
}
