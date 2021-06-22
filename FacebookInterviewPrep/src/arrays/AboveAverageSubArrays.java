package arrays;

/**
 * Abovz-Average Subarrays
You are given an array A containing N integers. Your task is to find all subarrays whose average sum is greater than the average sum of the remaining array elements. You must return the start and end index of each subarray in sorted order.
A subarray that starts at position L1 and ends at position R1 comes before a subarray that starts at L2 and ends at R2 if L1 < L2, or if L1 = L2 and R1 ≤ R2.
Note that we'll define the average sum of an empty array to be 0, and we'll define the indicies of the array (for the purpose of output) to be 1 through N. A subarray that contains a single element will have L1 = R1.
Signature
Subarray[] aboveAverageSubarrays(int[] A)
Input
1 ≤ N ≤ 2,000
1 ≤ A[i] ≤ 1,000,000
Output
A Subarray is an object with two integer fields, left and right, defining the range that a given subarray covers. Return a list of all above-average subarrays sorted as explained above.
Example 1
A = [3, 4, 2]
output = [[1, 2], [1, 3], [2, 2]]
The above-average subarrays are [3, 4], [3, 4, 2], and [4].

def above_average_subarrays(arr: List[int]) -> List[List[int]]:
    if not arr:
        return []
    elif len(arr) == 1:
        return [[1, 1]]

    res = []
    for i in range(1, len(arr) - 1):
        tot = arr[i - 1] + arr[i]
        if is_bigger(arr, i - 1, i, tot / 2):
            res.append([(i - 1) + 1, i + 1])
    res.append([1, len(arr)])
    max_ = max(arr)
    count = 0
    for i in range(len(arr)):
        if max_ <= arr[i]:
            count += 1
    if count <= 1:
        res.append([arr.index(max_) + 1, arr.index(max_) + 1])
    return res


def is_bigger(arr: List[int], idx1: int, idx2: int, target: float) -> bool:
    for i in range(len(arr)):
        if i == idx1 or i == idx2:
            continue
        if arr[i] >= target:
            return False
    return True


class TestAboveAverageSubArrays(TestCase):
    def setUp(self) -> None:
        self.arr_1 = [3, 4, 2]

    def test_above_average_subarrays(self) -> None:
        self.assertListEqual(
            [[1, 2], [1, 3], [2, 2]], above_average_subarrays(self.arr_1)
        )

 *
 * @author gibrancastillo
 *
 */
public class AboveAverageSubArrays {

}
