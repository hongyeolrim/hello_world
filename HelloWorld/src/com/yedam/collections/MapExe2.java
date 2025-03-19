package com.yedam.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.yedam.variable.Member;

public class MapExe2 {
	public static void main(String[] args) {

		Map<Member, Integer> map = new HashMap<>();
		map.put(new Member("홍열림", 100), 33);
		map.put(new Member("김마리", 99), 30);
		map.put(new Member("양관식", 60), 29);

		Set<Entry<Member, Integer>> entryset = map.entrySet();

		for (Entry<Member, Integer> entry : entryset) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}
}
