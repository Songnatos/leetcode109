class Solution {
    public boolean equationsPossible(String[] equations) {
    int[] parent=new int[26];
    for(int i=0;i<26;i++){
        parent[i]=i;
    }
    for(String equation:equations){
        char[] temp=equation.toCharArray();
        if(temp[1]=='='){
            int  index1=temp[0]-'a';
            int  index2=temp[3]-'a';
            union(parent,index1,index2);
        }
    }
        for(String equation:equations){
            char[] temp=equation.toCharArray();
            if(temp[1]=='!'){
                int  index1=temp[0]-'a';
                int  index2=temp[3]-'a';
                if(find(parent,index1)==find(parent,index2)){
                    return false;
                }
            }
        }
        return true;
    }
    public void union(int[] parent,int index1,int index2){
        parent[find(parent, index1)] = find(parent, index2);
    }
    public int find (int[] parent,int index){//还有一种路径压缩
        while(parent[index]!=index){
            parent[index]=parent[parent[index]];
            index=parent[index];
        }
        return index;
    }
}