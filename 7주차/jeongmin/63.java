class Solution {

    public boolean isPalidrome(String s){
        String s_filtered=s.replaceAll("[^A-Za-z0-9]","").toLowerCase();

        String s_revered=new StringBuilder(s_filtered).reverse().toString();

        return s_filtered.equals(s_revered);
    }
    public List<List<Integer>> palindromePairs(String[] words) {

        List<List<Integer>> results=new ArrayList<>();

        for(int i=0;i< words.length;i++){
            for(int j=0;j< words.length;j++){
                if(i==j) continue;
                if(isPalidrome(words[i]+words[j])){
                    List<Integer> result=new ArrayList<>(0);
                    result.add(i);
                    result.add(j);
                    results.add(result);
                }
            }

        }
        return results;
    }
}