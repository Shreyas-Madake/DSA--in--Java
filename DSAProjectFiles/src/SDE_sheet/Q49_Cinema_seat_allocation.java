package SDE_sheet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Q49_Cinema_seat_allocation {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
                HashMap<Integer,Set<Integer>> map=new HashMap<>();
                for(int[] seat:reservedSeats){
                        int row=seat[0];
                        int col=seat[1];
                        if(col>=2&& col<=9){
                                if(!map.containsKey(row)){
                                        map.put(row,new HashSet<>());
                                    }
                                map.get(row).add(col);
                            }
                    }

                int freerow=n-map.size();
                int ans= freerow*2;

                for(Set<Integer> v:map.values()){
                        boolean left= !v.contains(2) && !v.contains(3) && !v.contains(4) && !v.contains(5);
                        boolean mid= !v.contains(4) && !v.contains(5) && !v.contains(6) && !v.contains(7);
                        boolean right= !v.contains(6) && !v.contains(7) && !v.contains(8) && !v.contains(9);

                        if(left && right){
                                ans+=2;
                            }
                       if(left || mid || right){
                                ans+=1;
                            }

                    }
                return ans;

            }
}
