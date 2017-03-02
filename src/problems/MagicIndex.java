package problems;

public class MagicIndex {

	public static void main(String[] args) {
		int arr[] = { -40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13 };
		System.out.println(findMagicIndexDistinct(arr, 0, arr.length - 1));
	}

	public static int findMagicIndexDistinct(int[] arr, int start, int end) {
		if (start > end) {
			return -1;
		}
		int mid = (start + end) / 2;
		if (arr[mid] == mid) {
			return mid;
		} else if (arr[mid] > mid) {
			return findMagicIndexDistinct(arr, start, mid - 1);
		} else {
			return findMagicIndexDistinct(arr, mid + 1, end);
		}
	}

	public static int findMagicIndex(int[] arr, int start, int end) {
		if (start > end) {
			return -1;
		}
		int mid = (start + end) / 2;
		int midValue = arr[mid];
		if (midValue == mid) {
			return mid;
		}
		
		int leftIndex = Math.min(midValue, mid-1);
		
		int left = findMagicIndex(arr, start, leftIndex);
		
		if (left>=0) {

			return left;
		}
		int rightIndex = Math.max(midValue, mid+1);
		int right = findMagicIndex(arr, rightIndex, end);
		return right;
	}
}
