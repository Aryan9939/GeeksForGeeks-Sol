//{ Driver Code Starts
//Initial Template for Java


import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
	int data;
	Node left;
	Node right;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

class GfG {

	static Node buildTree(String str) {

		if (str.length() == 0 || str.charAt(0) == 'N') {
			return null;
		}

		String ip[] = str.split(" ");
		// Create the root of the tree
		Node root = new Node(Integer.parseInt(ip[0]));
		// Push the root to the queue

		Queue<Node> queue = new LinkedList<>();

		queue.add(root);
		// Starting from the second element

		int i = 1;
		while (queue.size() > 0 && i < ip.length) {

			// Get and remove the front of the queue
			Node currNode = queue.peek();
			queue.remove();

			// Get the current node's value from the string
			String currVal = ip[i];

			// If the left child is not null
			if (!currVal.equals("N")) {

				// Create the left child for the current node
				currNode.left = new Node(Integer.parseInt(currVal));
				// Push it to the queue
				queue.add(currNode.left);
			}

			// For the right child
			i++;
			if (i >= ip.length)
				break;

			currVal = ip[i];

			// If the right child is not null
			if (!currVal.equals("N")) {

				// Create the right child for the current node
				currNode.right = new Node(Integer.parseInt(currVal));

				// Push it to the queue
				queue.add(currNode.right);
			}
			i++;
		}

		return root;
	}

	static void printInorder(Node root) {
		if (root == null)
			return;

		printInorder(root.left);
		System.out.print(root.data + " ");

		printInorder(root.right);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t > 0) {
			String s = br.readLine();
			int target = Integer.parseInt(br.readLine());
			Node root = buildTree(s);

			Solution g = new Solution();
			System.out.println(g.minTime(root, target));
			t--;

		}
	}
}



// } Driver Code Ends


//User function Template for Java

class Solution
{
    /*class Node {
    	int data;
    	Node left;
    	Node right;
    
    	Node(int data) {
    		this.data = data;
    		left = null;
    		right = null;
    	}
    }*/
    private static class Pair{
        int node;
        int time;
        Pair(int node , int time){
            this.node = node;
            this.time = time;
        }
    }
    private static Map<Integer,ArrayList<Integer>> makeGraph(Node root){
        Map<Integer , ArrayList<Integer>> adjList = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node temp = q.poll();
            if(temp.left != null){
                q.add(temp.left);
                if(!adjList.containsKey(temp.data)){
                    adjList.put(temp.data , new ArrayList<>());
                }
                if(!adjList.containsKey(temp.left.data)){
                    adjList.put(temp.left.data , new ArrayList<>());
                }
                adjList.get(temp.data).add(temp.left.data);
                adjList.get(temp.left.data).add(temp.data);
            }
            if(temp.right != null){
                q.add(temp.right);
                if(!adjList.containsKey(temp.data)){
                    adjList.put(temp.data , new ArrayList<>());
                }
                if(!adjList.containsKey(temp.right.data)){
                    adjList.put(temp.right.data , new ArrayList<>());
                }
                adjList.get(temp.data).add(temp.right.data);
                adjList.get(temp.right.data).add(temp.data);
            }
        }
        return adjList;
        
    }
    private static int bfs(int node , Map<Integer , ArrayList<Integer>> adjList){
        Queue<Pair> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        visited.add(node);
        int ans = 0;
        q.add(new Pair(node , 0));
        while(!q.isEmpty()){
            Pair temp = q.poll();
            int tempNode = temp.node;
            int time = temp.time;
            ans = Math.max(ans , time);
            if(adjList.get(tempNode) != null){
                for(int item : adjList.get(tempNode)){
                    if(!visited.contains(item)){
                        visited.add(item);
                        q.add(new Pair(item , time+1));
                    }
                }
            }
        }
        return ans;
    }
    public static int minTime(Node root, int target) 
    {
        Map<Integer,ArrayList<Integer>> adjList =  makeGraph(root);
        int ans = bfs(target , adjList);
        return ans;
    }
}