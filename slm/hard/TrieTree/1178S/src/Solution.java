import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    TrieNode root;
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
    root=new TrieNode();
    for(String word:words){
        char[] chars=word.toCharArray();
        Arrays.sort(chars);
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<word.length();i++){
            if(i==0||chars[i]!=chars[i-1]){
                sb.append(chars[i]);
            }
        }
        add(root,sb.toString());
    }
    List res=new ArrayList();
    for(String puzzle:puzzles){
        char required=puzzle.charAt(0);
        char[] arr=puzzle.toCharArray();
        Arrays.sort(arr);
        res.add(find(new String(arr),required,root,0));
    }
    return res;
    }
    public void  add(TrieNode root,String word){
        TrieNode cur=root;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(cur.child[ch-'a']==null){
                cur.child[ch-'a']=new TrieNode();
            }
            cur=  cur.child[ch-'a'];
        }
        ++cur.frequency;
    }
    public int find(String puzz,char required,TrieNode root,int pos){
        if(root==null){
            return 0;
        }
        if(pos==7){
            return root.frequency;
        }
        int res=find(puzz,required,root.child[puzz.charAt(pos)-'a'],pos+1);
        if(puzz.charAt(pos)!=required){
            res+=find(puzz,required,root,pos+1);
        }
        return res;
    }
    class TrieNode{
        int frequency;
        TrieNode[] child;
        public TrieNode(){
            frequency=0;
            child=new TrieNode[26];
        }
    }
}
