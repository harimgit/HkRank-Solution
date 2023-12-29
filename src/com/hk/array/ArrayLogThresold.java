package com.hk.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class ArrayLogThresold {
/*
 * 4
1 2 50
1 7 70
1 3 20
2 2 17
2
 */
	public static void main(String[] args) {
		List<String> logs = Arrays.asList("1 2 50","1 7 70","1 3 20", "2 2 17");
		System.out.println(processLogs(logs,2));
	}
	
	static List<String> processLogs(List<String> logs, int threshold) {
		Map<String, Integer> map = new HashMap<>();
		List<String> list = new ArrayList<>();
		logs.forEach(log->{
			Set<String> set = new HashSet(Arrays.asList(log.split(" ")));
			set.forEach(value->{
				if(map.containsKey(value)) {
					map.put(value, map.get(value)+1);
				}else {
					map.put(value, 1);
				}
			});
		});
		List<Entry<String, Integer>> entrylist = map.entrySet().stream()
				.sorted(Map.Entry.<String,Integer>comparingByValue().reversed())
				.collect(Collectors.toList());
		return entrylist.stream().filter(entry->entry.getValue()>=threshold).map(entry->entry.getKey()).collect(Collectors.toList());
		
	}

}
