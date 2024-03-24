import java.util.HashMap;

class Solution {
    public static HashMap<String, Integer> map;
    public static int[] profits;
    
    public void initMap(String[] enroll){
        map = new HashMap<>();
        
        for(int i = 0 ; i < enroll.length ; i++){
            map.put(enroll[i],i);
        }
    }
    
    public void getProfit(String[] referral, String name, int money){
        int index = map.get(name);
        int pay = money / 10;
        int profit = money - pay;
        
        profits[index] += profit;
        
        if(pay < 1) return;
        
        String refer = referral[index];
        
        if(refer.equals("-")) return;

        getProfit(referral, refer, pay);
        
    }
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        profits = new int[enroll.length];
        
        initMap(enroll);
        
        for(int i = 0 ; i < seller.length ; i++){
            getProfit(referral, seller[i], amount[i] * 100);
        }
        

        return profits;
    }
}