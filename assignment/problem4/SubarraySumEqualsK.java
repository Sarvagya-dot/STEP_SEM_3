import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    public static void main(String[] args) {
        int[] firstSample = {1, 1, 1};
        System.out.println(subarraySum(firstSample, 2));

        int[] secondSample = {1, -1, 0};
        System.out.println(subarraySum(secondSample, 0));
    }

    static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSumFrequency = new HashMap<>();
        prefixSumFrequency.put(0, 1);

        int runningSum = 0;
        int subarrayCount = 0;

        for (int currentValue : nums) {
            runningSum += currentValue;
            int neededPrefixSum = runningSum - k;

            subarrayCount += prefixSumFrequency.getOrDefault(neededPrefixSum, 0);
            prefixSumFrequency.put(runningSum, prefixSumFrequency.getOrDefault(runningSum, 0) + 1);
        }

        return subarrayCount;
    }
}
