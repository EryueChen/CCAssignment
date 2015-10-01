package chapter10;

public class Solution03 {
	//Judge whether the left or the right is still sorted 
	//Use binary search on either or both sides
	public static int search(int[] nums, int left, int right, int target) {
        if (left > right) return -1;
        int mid = (left + right) / 2;
        if (nums[mid] == target) return mid;
        if (nums[left] < nums[mid]) {
            if (target <= nums[mid] && target >= nums[left]) {
                return search(nums, left, mid - 1, target);
            } else {
                return search(nums, mid + 1, right, target);
            }
        } else if (nums[right] > nums[mid]) {
            if (target >= nums[mid] && target <= nums[right]) {
                return search(nums, mid + 1, right, target);
            } else {
                return search(nums, left, mid - 1, target);
            }
        } else if (nums[left] == nums[mid]) {
            if (nums[mid] != nums[right]) {
                return search(nums, mid + 1, right, target);
            } else {
                int result = search(nums, left, mid - 1, target);
                if (result == -1) {
                    return search(nums, mid + 1, right, target);
                } else {
                    return result;
                }
            }
        }
        return -1;
    }
    
    public static int searchInRotated(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target);
    }
	
	public static void main(String[] args) {
		int[] array = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
		System.out.println(searchInRotated(array, 5));
	}

}
