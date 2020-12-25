import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;

class Solution {
    public String smallestSubsequence(String s) {
        char[] charArray=s.toCharArray();
        int n=charArray.length;
        boolean[] visited=new boolean[26];
        int[] lasted=new int[26];
        for(int i=0;i<n;i++){
            lasted[charArray[i]-'a']=i;
        }
        Deque<Character> Stack=new ArrayDeque<>();

        for(int i=0;i<n;i++){
            if(visited[charArray[i]-'a'])
                continue;
            while(!Stack.isEmpty()&&Stack.peekLast()>charArray[i]&&lasted[Stack.peekLast()-'a']>i){
                char temp= Stack.removeLast();
                visited[temp-'a']=false;
            }
            Stack.offer(charArray[i]);
            visited[charArray[i]-'a']=true;

        }
        StringBuilder res=new StringBuilder();
        while(!Stack.isEmpty()){
            res.append(Stack.pollFirst());
        }
        return res.toString();

    }
}