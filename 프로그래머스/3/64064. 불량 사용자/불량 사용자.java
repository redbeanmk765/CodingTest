/*
숫자가 안겹치게 리스트를 짜는법?
1 2 3 4 5
2 1 3 4 5 를 구분하는법? >> HashSet equls 로 비교
ban 기준으로 몇개의 user가 가능한지 번호를 담은 arraylist
[1 2 3] [1] [2 3] >> 
*/

import java.util.HashSet;
import java.util.ArrayList;


class Solution {
    
    public static ArrayList<Integer>[] candidates;
    public static int count = 0;
    public static ArrayList<HashSet<Integer>> answers;
    public static String[] user;
    public static String[] ban;
    //HashSet<Integer> tmp = new HashSet<>();
    
    public void init(){
        candidates = new ArrayList[ban.length];
        answers = new  ArrayList<HashSet<Integer>>();
        
        for (int i = 0; i < ban.length; i++) {
            candidates[i] = new ArrayList<>();
        }
    }
    
    public void getCandidates(){
        for(int i = 0 ; i < ban.length ; i++){
            for(int j = 0 ; j < user.length ; j++){
                if(isPossible(user[j], ban[i])){
                    candidates[i].add(j);
                }
            }
        }
    }
    
    public boolean isPossible(String userID, String banID){
        if(userID.length() != banID.length()){
            return false;
        }
        
        for(int i = 0 ; i < userID.length() ; i++){
            char u = userID.charAt(i);
            char b = banID.charAt(i);
            
            if(b == '*'){
                continue;
            }
            
            if(u != b){
                return false;
            }
        }
        return true;
    }
    
    public void dfs(int index, HashSet<Integer> set){
        if(index >= ban.length){
            for(HashSet<Integer> answer : answers){
                if(answer.equals(set)){
                    return;
                }
            }
            HashSet<Integer> tmp = new HashSet<>();
            for(int value : set){
                tmp.add(value);
            }
            answers.add(tmp);
            count++;
        }
        else{
            for(int i = 0 ; i < candidates[index].size() ; i++){
                if(set.add(candidates[index].get(i))){
                    //System.out.print("test");
                    HashSet<Integer> next = new HashSet<>();
                    for(int value : set){
                        next.add(value);
                    }
                    dfs((index+1), next);
                    set.remove(candidates[index].get(i));
                }      
            }
        }
        
        
    }
    
    public int solution(String[] user_id, String[] banned_id) {
        user = user_id;
        ban = banned_id;
        
        init();
        getCandidates();
        
        /*for(ArrayList<Integer> array : candidates){
            for(int num : array){
                System.out.print(num + " ");
            }
            System.out.println();
        }*/
        
        for(int i = 0 ; i < candidates[0].size() ; i++){
            HashSet<Integer> set = new HashSet<>();
            set.add(candidates[0].get(i));
            dfs(1,set);
        }
        return count;
    }
}