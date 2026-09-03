package SDE_sheet;

public class Q57_uniformArray {
    public boolean uniformArray(int[] nums1) {
        int min=nums1[0];
        boolean alleven=true;
        for(int x:nums1){
            min=Math.min(min,x);
            if(x%2!=0){
                alleven=false;
            }
        }
        if(min%2!=0){
            return true;
        }
        if(alleven){
            return true;
        }
        return false;
    }
}
