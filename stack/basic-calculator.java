class Solution {
    public int calculate(String s) {
        char[]chars=s.toCharArray();
        Stack<Integer>number=new Stack<>();
        Stack<Character>op=new Stack<>();
        for(int i=0;i<chars.length;i++){
            if (Character.isDigit(chars[i])) {
                int num = 0;
                while (i < chars.length && Character.isDigit(chars[i])) {
                    num = num * 10 + (chars[i] - '0');
                    i++;
                }
                number.push(num);
                i--; 
            }else if("+-*/".indexOf(chars[i])!= -1){
                op.push(chars[i]);
            }else if(chars[i]==')'){
                int res = 0;
                int b = number.pop();
                while (number.peek() != null) {
                    char oper = op.pop();
                    int a = number.pop();
                    if (oper == '+') res = a + b;
                    else res = a - b;
                    b=res;
                }
                number.pop();
                number.push(b);
            }else if(chars[i]==' '){
                continue;
            }else{
                number.push(null); 
            }
        }
        // 反转栈，使得可以从左到右计算
        Stack<Integer> numTemp = new Stack<>();
        Stack<Character> opTemp = new Stack<>();
        while (!number.isEmpty()) numTemp.push(number.pop());
        while (!op.isEmpty()) opTemp.push(op.pop());

        int res = numTemp.pop();  // 拿到最左边的数
        while (!opTemp.isEmpty()) {
            char oper = opTemp.pop();
            int b = numTemp.pop();
            if (oper == '+') res = res + b;
            else res = res - b;
        }
        return res;

        
        
        
    }
}