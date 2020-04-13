package alg.programmers.DFS_BFS_0407_43164;
import java.util.*;
// hashset : 중복된 value 방지
// priorityQueue 순서대로 저장

public class DFS_BFS_0407_43164 {
	public static void main(String[] args) {
		Solution sol = new Solution();
		// String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
		String[][] tickets = { { "DDD", "BBB" }, {"JFK", "DDD"}, { "JFK", "CCC" }, { "ICN", "JFK" }, {"BBB", "JFK"} }; // ICN JFK DDD BBB JFK CCC
		// String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
		String[] answer = sol.solution(tickets); 
		for(String an : answer) {
			System.out.println(an);
		}
	}
}

class Solution {
    public String[] solution(String[][] tickets) {
		String[] answer = {};
		Set<String> hashSet = new HashSet<>();
		Map<String, ArrayList<String>> map = new HashMap<>();
		Map<String, Integer> visitMap = new HashMap<>();
		
		hashSet.add("ICN");
		map.put("ICN", new ArrayList<>());
		visitMap.put("ICN", 0);

		// 공항의 갯수 확인 및 map 초기화
		for(int i = 0; i < tickets.length; i++) {
			hashSet.add(tickets[i][1]);
			map.put(tickets[i][1], new ArrayList<>());
			visitMap.put(tickets[i][1], 0);
		}

		// map에 key, value 입력.
		for(int i = 0; i < tickets.length; i++) {
			ArrayList<String> arrayList = map.get(tickets[i][0]);
			arrayList.add(tickets[i][1]);
			map.put(tickets[i][0], arrayList);		// hashmap에서 꺼낸 arraylist에 바로 저장하면 hashmap 내부의 arraylist에는 적용되지 않는다.
		}

		// 2개 이상의 도착지가 있을 경우 -> 사전순 정렬
		for(String airport : hashSet) {
			if(map.get(airport).size() > 1) {		// 2개 이상의 공항으로 갈 경우 sort
				Collections.sort(map.get(airport));
			}
		}

		String[] airports = new String[tickets.length + 1];
		
		int currAirportIndex = 0;	// 현재 저장된 공항의 순서
		String currAirport = "ICN";

		answer = dfs(map, visitMap, airports, currAirport,  currAirportIndex);
		System.out.println("");
        return answer;
	}

	// visit 배열을 통해 모두 방문하지 못 했다면 Back해야한다.
	public String[] dfs(Map<String, ArrayList<String>> map, Map<String, Integer> visitMap, String[] airports,  String currAirport,  int currAirportIndex) {
		System.out.println("currAirport: " + currAirport);
		airports[currAirportIndex] = currAirport;
		if(currAirportIndex > 0) {
			map.get(airports[currAirportIndex - 1]).remove(currAirport);
		}

		ArrayList<String> destList = map.get(currAirport);
		System.out.println("destList:" + destList);
		System.out.println("visitMap.get: " + visitMap.get(currAirport));
		
		System.out.println("destList.size():" + destList.size());
		for(int i = 0; i < destList.size(); i++) {		// 사전순으로 sort를 이미 했으므로 차례대로 돌린다.
			System.out.println("destList.get("+ i +"): " + destList.get(i));
			airports = dfs(map, visitMap, airports, destList.get(i), currAirportIndex + 1);
			System.out.println("내부 destList.size():" + destList.size());
			if (airports[airports.length - 1] != null) { // 탐색 성공 시.
				System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				break;
			}
		}
		System.out.println("return");
		return airports;
	}
}