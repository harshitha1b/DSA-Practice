//Fibonacci Using Recursion
//You are given a number n. You need to find the nth Fibonacci number.
//Platform: GeeksforGeeks

class Solution {
    public int binarysearch(int[] arr, int k) {
        // Code Here
        int n=arr.length;
        int l=0,h=n-1;
        while(l<=h){
            int mid=(l+h)/2;
            if(arr[mid]==k){
                return mid;
            }else if(arr[mid]>k){
                h=mid-1;
                
            }else{
                l=mid+1;
            }
        
       
    }
    return -1;
    }
}
