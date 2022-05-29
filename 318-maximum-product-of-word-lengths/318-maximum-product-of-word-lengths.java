// class Solution {
    
//     public boolean check(String s1, String s2){
//         HashMap<Character, Integer> mp1=new HashMap<>();
//         HashMap<Character, Integer> mp2=new HashMap<>();
//         for(int i=0;i<s1.length();i++){
//             char ch=s1.charAt(i);
//             if(!mp1.containsKey(ch)){
//                 mp1.put(ch,1);
//             }
//             else{
//                 mp1.put(ch, mp1.get(ch)+1);
//             }
//         }
//          for(int i=0;i<s2.length();i++){
//             char ch=s2.charAt(i);
//             if(!mp2.containsKey(ch)){
//                 mp2.put(ch,1);
//             }
//             else{
//                 mp2.put(ch, mp2.get(ch)+1);
//             }
//         }
        
        
//         for(int i=0;i<s1.length();i++){
//             char ch=s1.charAt(i);
//             if(mp2.containsKey(ch))
//                 return false;
//         }
        
//         return true;
//     }
//     public int maxProduct(String[] words) {
        
//         int maxi=0;
       
//         for(int i=0;i<words.length;i++){
//             String stri=words[i];
//             for(int j=0;j<words.length;j++){
//                  String strj=words[j];
//                 if(check(stri, strj)){
//                     maxi=Math.max(maxi,stri.length()*strj.length());
                    
//                 }
//             }
//         }
//         return maxi;
//     }
// }









class Solution {

    // TC : O(n2)
    // SC : O(n)
    public  int maxProduct(String[] words) {

        int len = words.length;
        int[] state = new int[len];


        for (int i=0;i<len;i++) {

            state[i] = getStateFromString(words[i]);

        }

        int maxProduct = 0;
        for (int i = 0; i < len; i++)
            for (int j = i + 1; j < len; j++) {
                if ((state[i] & state[j]) == 0) {
                    if(words[i].length() * words[j].length() > maxProduct) {
                        maxProduct = words[i].length() * words[j].length();
                    }
                }
            }
        return maxProduct;
    }

    private int getStateFromString(String s){
        int state = 0;
        for(char c: s.toCharArray()){
            int index = c  -'a';
            state |= 1 << (index);
        }
        return state;
    }
}