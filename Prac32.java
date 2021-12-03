//Sort Integers by The Power Value

class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    int[][] arr;
    public int getKth(int lo, int hi, int k) {
        if(lo == hi) {
            return lo;
        }
        arr = new int[hi - lo + 1][2];
        for(int i = lo; i <= hi; i++) {
            findPower(i, i-lo);
        }
        Arrays.sort(arr, (a,b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        //System.out.println(Arrays.deepToString(arr));
        //System.out.println(map);
        return arr[k-1][0];
    }
    
    private void findPower(int num,int index) {
        int count = 1;
        int temp = num;
        while(num > 1) {
            if(map.containsKey(num)) {
                count += map.get(num);
                break;
            } 
            if(num % 2 == 0) {
                num = num / 2;
                count++;
            } else {
                num = 3 * num + 1;
                count++;
            }   
        }
        map.put(temp,count-1);
        arr[index][0] = temp;
        arr[index][1] = count;
    }
}

//Find Duplicate Subtrees

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    HashMap<String, Integer> map = new HashMap<>();
    List<TreeNode> result;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        
        addtoSet(root);
        //System.out.println(map);
        return result;
    }
    private StringBuilder addtoSet(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        
        if(root == null) {
            sb.append("n");
            return sb;
        }
sb.append(root.val).append(",").append(addtoSet(root.left)).append(",").append(addtoSet(root.right));
        
        map.put(sb.toString(),map.getOrDefault(sb.toString(),0) + 1);
        if(map.get(sb.toString()) == 2) {
            result.add(root);
        }
        return sb;
    }
}