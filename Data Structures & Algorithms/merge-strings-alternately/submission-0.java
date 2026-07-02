class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();

        int n=Math.min(word1.length(), word2.length());
        boolean swapp=true;
        int i=0;
        int w1=0, w2=0;
        while(i<n*2){
            if(swapp){
                result.append(word1.charAt(w1));
                swapp=!swapp;
                w1++;
            
            }
            else{
                result.append(word2.charAt(w2));
                swapp=!swapp;
                w2++;
                

            }
            i++;
        }

         if(word1.length()<word2.length()){
            result.append(word2.substring(i/2,word2.length()));
         }
         else{
            result.append(word1.substring(i/2, word1.length()));
         }

         return result.toString();
    }
}