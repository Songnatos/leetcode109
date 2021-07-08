import java.util.Arrays;
import java.util.Collections;

class Solution {
    public boolean isMonotonic(int[] A) {
    if(A.length<3){
        return true;
    }
    boolean bigTosmall=true;
    for(int i=1;i<A.length;i++){
      if(A[i]!=A[i-1]){
          bigTosmall=A[i]>A[i-1];
          break;
      }
    }
    for(int i=1;i<A.length;i++){
            if(A[i]!=A[i-1]){
                if(bigTosmall!=A[i]>A[i-1])
                return false;
            }
        }
    return true;
    }
}