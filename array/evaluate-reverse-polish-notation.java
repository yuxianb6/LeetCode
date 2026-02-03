class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> numbers=new Stack<>();
        for(int i=0;i<tokens.length;i++){
            if(tokens[i].equals("+")||tokens[i].equals("-")||tokens[i].equals("*")||tokens[i].equals("/")){
                int a=numbers.pop();
                int b=numbers.pop();
                switch(tokens[i]){
                    case "+":
                        numbers.push(b+a);
                        break;
                    case "-":
                        numbers.push(b-a);
                        break;                        
                    case "*":
                        numbers.push(b*a);
                        break;
                    case "/":
                        numbers.push(b/a);
                        break;                }
            }else{
                numbers.push(Integer.parseInt(tokens[i]));
            }
        }
        return numbers.pop();
        
    }
}