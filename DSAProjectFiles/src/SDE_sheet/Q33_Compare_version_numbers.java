package SDE_sheet;

public class Q33_Compare_version_numbers {
    public int compareVersion(String version1, String version2) {
        String version1arr[]= version1.split("\\.");// we uses \\. because . is a special character in regex and we need to escape it and in java we need to escape \ so we use \\. to split the string by . for example 1.0.1 will be split into 1,0,1
        // in normal . string will be split like example 1.0.1 will be split into 1,0,1 but if we use . it will be split into 1,0,1 because . is a special character in regex and we
        String version2arr[]= version2.split("\\.");
        int n1=version1arr.length;
        int n2=version2arr.length;
        int p1=0,p2=0;
        while(p1<n1||p2<n2){
            int num1=(p1<n1)?Integer.parseInt(version1arr[p1]):0;
            int num2=(p2<n2)?Integer.parseInt(version2arr[p2]):0;
            if(num1!=num2){
                return (num1>num2) ? 1:-1;
            }
            p1++;
            p2++;
        }
        return 0;
    }
}
