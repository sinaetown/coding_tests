import java.util.*;

class Solution {
    
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int gcdA = arrayA[0], gcdB = arrayB[0];
        
        for(int a : arrayA) gcdA = gcd(gcdA, a);
        for(int b : arrayB) gcdB = gcd(gcdB, b);
        
        if(impossible(arrayA, gcdB)){
            if(answer < gcdB) answer = gcdB;
        }
        
        if(impossible(arrayB, gcdA)){
            if(answer < gcdA) answer = gcdA;
        }
       
        return answer;
    }
    
    public boolean impossible(int[] arr, int b){
        for(int a : arr){
            if(a%b == 0) return false;
        }
        return true;
    }
    
    public int gcd(int a, int b){
        if(a%b==0) return b;
        return gcd(b, a%b);
    }
    
}