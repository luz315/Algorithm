import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Set<Integer> losts = new HashSet<>();
        Set<Integer> reserves = new HashSet<>();

        for (int l : lost) {
            losts.add(l);
        }
        for (int r : reserve) {
            reserves.add(r);
        }

        List<Integer> toRemove = new ArrayList<>();
        for (int l : lost) {
            if (reserves.contains(l)) {
                toRemove.add(l);
            }
        }
        for (int l : toRemove) {
            losts.remove(l);
            reserves.remove(l);
        }

        for (int r : reserves) {
            if (losts.contains(r - 1)) {
                losts.remove(r - 1);
            } else if (losts.contains(r + 1)) {
                losts.remove(r + 1);
            }
        }

        return n - losts.size();
    }
}