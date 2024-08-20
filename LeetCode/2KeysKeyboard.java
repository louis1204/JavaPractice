class Solution {
    public int minSteps(int n) {
        // we'd always want to copy and paste unless it would be bigger than n
        // When we get the highest number, backtrack to see what we need to add to get the value
        // Essentially a base 2 system
        // At each step we can either copy the new string or paste the previous copy
        // Would working backwards help here?
        // Start at 3, continually divide by 2. Each time that is a 2 operation
        // If the number is odd, find the biggest number that is divisible by it
        // If it's prime, then we have to keep adding 1's
        // So we'd have to work our way up to n
        int[] steps = new int[n + 1];
        steps[1] = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                steps[i] = i; // copy and paste i - 1 times
            } else {
                // look at the previous numbers, if divisible, plus the amount of times we divided by
                for (int j = i - 1; j >= 2; j--) {
                    if (i % j == 0) {
                        steps[i] = steps[j] + (i / j); // copy and paste whatever times
                        break;
                    }
                }
            }
        }
        // System.out.println(Arrays.toString(steps));
        return steps[n];
    }

    private boolean isPrime(int n) {
        if (n <= 3) {
            return true;
        }
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
