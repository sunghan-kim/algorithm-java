# 1. Union-Find

## 1.1 Union-Find 란?

- 대표적인 그래프 알고리즘
- 합집합 찾기
- 상호 베타적 집합(Disjoint-set)
- 여러 노드가 존재할 때, 두 개의 노드를 선택해서, 현재 두 노드가 서로 같은 그래프에 속하는 지 판별하는 알고리즘
- 2가지 연산으로 이루어져 있다.
  - `Find` : x가 어떤 집합에 포함되어 있는 지 찾는 연산
  - `Union` : x와 y가 포함되어 있는 집합을 합치는 연산

<br>

## 1.2 Union-Find 구현

- `src/boj/dataStructure/theory/kruskalAlgorithm/UnionFind.java`