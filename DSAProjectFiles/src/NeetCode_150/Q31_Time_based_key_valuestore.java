package NeetCode_150;
import java.util.*;
public class Q31_Time_based_key_valuestore {
    public Map<String, List<Pair>> store;

    public Q31_Time_based_key_valuestore() {
        store = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        store.putIfAbsent(key, new ArrayList<>());
        store.get(key).add(new Pair(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if (!store.containsKey(key)) {
            return "";
        }
        List<Pair> list = store.get(key);

        int left = 0, right = list.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid).timestamp <= timestamp) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (right < 0) {
            return "";
        }
        return list.get(right).value;
    }

    class Pair {
        String value;
        int timestamp;

        public Pair(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }
}
}
