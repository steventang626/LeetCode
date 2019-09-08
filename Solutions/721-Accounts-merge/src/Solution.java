import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Set<String>> graph = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();
        for (List<String> account : accounts) {
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                graph.computeIfAbsent(email, x -> new HashSet<>()).add(account.get(1));
                graph.get(account.get(1)).add(account.get(i));
                emailToName.put(email, name);
            }
        }
        Set<String> visited = new HashSet<>();
        List<List<String>> result = new ArrayList<>();
        for (String email : graph.keySet()) {
            if (!visited.contains(email)) {
                visited.add(email);
                Stack<String> stack = new Stack<>();
                stack.push(email);
                List<String> resultList = new ArrayList<>();
                while (!stack.isEmpty()) {
                    String node = stack.pop();
                    resultList.add(node);
                    for (String neighbor : graph.get(node)) {
                        if (!visited.contains(neighbor)) {
                            stack.push(neighbor);
                            visited.add(neighbor);
                        }
                    }
                }
                Collections.sort(resultList);
                resultList.add(0, emailToName.get(email));
                result.add(resultList);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<String>> accounts = new ArrayList<>();
        String[] listStrings1 = {"John", "johnsmith@mail.com", "john00@mail.com"};
        List<String> list1 = new ArrayList<>(Arrays.asList(listStrings1));
        String[] listStrings2 = {"John", "johnnybravo@mail.com"};
        List<String> list2 = new ArrayList<>(Arrays.asList(listStrings2));
        String[] listStrings3 = {"John", "johnsmith@mail.com", "john_newyork@mail.com"};
        List<String> list3 = new ArrayList<>(Arrays.asList(listStrings3));
        String[] listStrings4 = {"Mary", "mary@mail.com"};
        List<String> list4 = new ArrayList<>(Arrays.asList(listStrings4));
        accounts.add(list1);
        accounts.add(list2);
        accounts.add(list3);
        accounts.add(list4);

        List<List<String>> result = new Solution().accountsMerge(accounts);
        for (List<String> account : result) {
            for (String s : account) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
}
