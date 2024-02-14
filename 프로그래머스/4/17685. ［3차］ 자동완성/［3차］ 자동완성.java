import java.util.HashMap;
import java.util.Map;

class Solution {
    
    public class Node{
        Map<Character, Node> childNodes = new HashMap<>();
        boolean isSingular = true;  
    }

    public class Trie{
        Node rootNode = new Node();
    
        public void insert(String word){
            Node curNode = this.rootNode;
        
            for(char letter : word.toCharArray()){
                if(curNode.childNodes.containsKey(letter)){   
                    curNode = curNode.childNodes.get(letter);
                    curNode.isSingular = false;
                }
                else{
                    curNode = curNode.childNodes.merge(letter, new Node(), (a,b) -> b);
                }
            }
        }
    
        public int calculate(String word){
            Node curNode = this.rootNode;
            int count = 0;
            for(int i = 0 ; i < word.length() ; i++){
                curNode = curNode.childNodes.get(word.charAt(i));
                count++;
                if(curNode.isSingular == true){
                    //System.out.println(word.charAt(i));
                    break;
                }
            }
            return (count);
        }
    
    }   
    
    public int solution(String[] words) {
        int answer = 0;
        
        Trie wordTrie = new Trie();
        
        for(String word : words){
            wordTrie.insert(word);
        }
        
        for(String word : words){
            int num = wordTrie.calculate(word);
            //System.out.println(num);
            answer += num;
        }
        
        return answer;
    }
}