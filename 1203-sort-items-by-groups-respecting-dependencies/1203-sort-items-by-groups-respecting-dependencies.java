class Solution {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        int nextGroupId = m;
        
        // Assign groups to items that don't belong to any group
        for (int itemIndex = 0; itemIndex < n; itemIndex++) {
            if (group[itemIndex] == -1) {
                group[itemIndex] = nextGroupId++;
            }
        }
        
        // Create a graph for items and initialize in-degree arrays
        Map<Integer, List<Integer>> itemGraph = new HashMap<>();
        int[] itemInDegree = new int[n];
        for (int itemIndex = 0; itemIndex < n; itemIndex++) {
            itemGraph.put(itemIndex, new ArrayList<>());
        }
        
        // Create a graph for groups and initialize in-degree arrays
        Map<Integer, List<Integer>> groupGraph = new HashMap<>();
        int[] groupInDegree = new int[nextGroupId];
        for (int groupId = 0; groupId < nextGroupId; groupId++) {
            groupGraph.put(groupId, new ArrayList<>());
        }
        
        // Build item and group graphs and calculate in-degrees
        for (int itemIndex = 0; itemIndex < n; itemIndex++) {
            for (int prevItem : beforeItems.get(itemIndex)) {
                itemGraph.get(prevItem).add(itemIndex);
                itemInDegree[itemIndex]++;
                
                if (group[itemIndex] != group[prevItem]) {
                    groupGraph.get(group[prevItem]).add(group[itemIndex]);
                    groupInDegree[group[itemIndex]]++;
                }
            }
        }
        
        // Perform topological sorting for items and groups
        List<Integer> orderedItems = topologicalSort(itemGraph, itemInDegree);
        List<Integer> orderedGroups = topologicalSort(groupGraph, groupInDegree);
        
        // Handle the case where sorting is not possible
        if (orderedItems.isEmpty() || orderedGroups.isEmpty()) {
            return new int[0];
        }
        
        // Group items by their groups
        Map<Integer, List<Integer>> groupedItems = new HashMap<>();
        for (Integer item : orderedItems) {
            groupedItems.computeIfAbsent(group[item], key -> new ArrayList<>()).add(item);
        }
        
        // Generate the final sorted result
        List<Integer> resultList = new ArrayList<>();
        for (int groupIndex : orderedGroups) {
            resultList.addAll(groupedItems.getOrDefault(groupIndex, new ArrayList<>()));
        }
        
        // Convert the result list to an integer array
        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }
    
    // Helper method for topological sorting
    private List<Integer> topologicalSort(Map<Integer, List<Integer>> graph, int[] inDegree) {
        List<Integer> visited = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        
        // Initialize the stack with nodes having zero in-degree
        for (int node = 0; node < inDegree.length; node++) {
            if (inDegree[node] == 0) {
                stack.push(node);
            }
        }
        
        // Perform topological sorting using DFS and stack
        while (!stack.isEmpty()) {
            Integer current = stack.pop();
            visited.add(current);
            
            for (Integer neighbor : graph.get(current)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    stack.push(neighbor);
                }
            }
        }

        // Check if the sorting was successful
        return visited.size() == graph.size() ? visited : new ArrayList<>();
    }
}
