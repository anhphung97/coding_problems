// Level 4 Problem 2 
// This problem basically asks for maximum flow in a graph
// Below is the implementation of the maximum flow algorithm

import java.util.LinkedList;

public class EscapePods 
{   
    private static int num;
    private static int[] prev;
    private static boolean[] visited;
    
    public static void main(String[] args) 
    {
        // example 1
    	int[] entrances = new int[] {0};
    	int[] exits = new int[] {3};
    	int[][] path = new int[][] {{0, 7, 0, 0}, {0, 0, 6, 0}, {0, 0, 0, 8}, {9, 0, 0, 0}};
    	System.out.println(answer(entrances,exits,path));

        // example 2
        entrances = new int[] {0,1};
        exits = new int[] {4,5};
        path = new int[][] {{0, 0, 4, 6, 0, 0}, {0, 0, 5, 2, 0, 0}, {0, 0, 0, 0, 4, 4},
                            {0, 0, 0, 0, 6, 6}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}};
        System.out.println(answer(entrances,exits,path));
    }

    public static int answer(int[] entrances, int[] exits, int[][] path) 
    {
    	// initialize variables
    	num = path.length + 2;
    	prev = new int[num];
    	visited = new boolean[num];

    	// change multiple entrances, exits to one, create graph
    	int[][] graph = new int[num][num];

    	// update graph
    	for (int i = 0; i < entrances.length; i++)
    	{
    		entrances[i] ++;
    		graph[0][entrances[i]] = Integer.MAX_VALUE;
    	} 
    	for (int i = 0; i < exits.length; i++)
    	{
    		exits[i] ++;
    		graph[exits[i]][num-1] = Integer.MAX_VALUE;
    	}
    	for (int i = 1; i < num-1; i++)
    		for (int j = 1; j < num-1; j++)
    			graph[i][j] = path[i-1][j-1];

    	// create residual graph
    	int[][] residual = new int[num][num];
    	for (int i = 0; i < num; i++)
    		for (int j = 0; j < num; j++)
    			residual[i][j] = graph[i][j];

    	// find max flow from start to end
    	int start = 0;
    	int end = num-1;
    	int max_flow = 0;

    	// keep adding new path
    	while (search(start,end,residual))
    	{
    		// new path found
    		int newPath = Integer.MAX_VALUE;
    		int u = end;
    		while (u != start)
    		{
    			newPath = Math.min(newPath, residual[prev[u]][u]);
    			u = prev[u];
    		}

    		// update residual
    		u = end;
    		while (u != start)
    		{
    			residual[prev[u]][u] -= newPath;
    			residual[u][prev[u]] += newPath;
    			u = prev[u];
    		}

    		// update max
    		max_flow += newPath;
    	}

    	// algorithm terminates
    	return max_flow;
    }


    private static boolean search(int start, int end, int[][] residual)
    {
    	// search path between start and end
    	// reset
    	for (int i = 0; i < num; i++)
    	{
    		prev[i] = -1;
    		visited[i] = false;
    	}

    	// queue to examine
    	LinkedList<Integer> queue = new LinkedList<Integer>();
    	visited[start] = true;
    	queue.addLast(start);

    	// breadth first search
    	while (queue.size() > 0)
    	{
    		int current = queue.removeFirst();

    		// check adjacent nodes
    		for (int i = 0; i < num; i++)
    		{
    			if (residual[current][i] > 0 && !visited[i])
    			{
    				visited[i] = true;
    				prev[i] = current;
    				queue.addLast(i);
    			}	
    		}
    	}

    	// path found
    	if (visited[end])
    		return true;

    	return false;
    }
}










