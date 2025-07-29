package edu.java.collection06;

import java.util.Set;
import java.util.TreeMap;

// List<E>, Set<E> : 한 가지 타입의 데이터를 저장할 수 있는 Collection
// Map<K, V>: key-value 상으로 데이터를 저장하는 구조
//			1. key는 중복되지 않는 값만 저장 가능
// 			2. value는 중복된 값도 저장 가능
//			3. 검색, 수정, 삭제할 때 key값을 사용합

// HashMap<K, V>: 검색을 빠르게 하기 위한 Hash 알고리즘이 적용된 Map
// TreeMap<K, V>: 검색을 빠르게 하기 위한 Tree 알고리즘이 적용된 Map
public class CollectionMain06 {

	public static void main(String[] args) {
		TreeMap<Integer, String> map = new TreeMap<Integer, String>();
		
		// Map<K, V>에 데이터 저장: put(Key, Value)
		map.put(16, "손흥민");
		map.put(10, "이강인");
		map.put(20, "황희찬");
		System.out.println(map);
		
		// Map<K, V>의 데이터 검색: get(Key)
		// - 해당 key 값의 value를 리턴
		System.out.println(map.get(16));
		System.out.println(map.get(10));
		System.out.println(map.get(18));
		
		// Map<K, V>에서 데이터를 수정: put(key, value)
		map.put(10, "김민재");
		System.out.println(map.get(10));
		
		// Map<K, V>의 데이터 삭제: remove(Key)
		map.remove(10);
		System.out.println(map);
		
		// Map<K, V>에서 key로만 이루어진 Set을 생성: KeySet()	
		Set<Integer> keySet = map.keySet();
		System.out.println(keySet);
	}

}
