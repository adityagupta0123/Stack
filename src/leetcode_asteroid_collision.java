class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> res = new Stack<>();
        for(int a : asteroids){
            if (a > 0){
                res.push(a);
            } else {
                while( !res.empty() && res.peek() > 0 && res.peek() < Math.abs(a)){
                    res.pop();
                }
               
                if(res.empty() || res.peek() < 0) {
                    res.push(a);
                } else if(res.peek() == Math.abs(a)){
                    res.pop();
                }
            }
        }
        return res.stream().mapToInt(i->i).toArray();        
    }
}
