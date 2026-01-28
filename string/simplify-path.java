class Solution {
    public String simplifyPath(String path) {
        char[]chars=path.toCharArray();
        Stack<String> stack=new Stack<>();
        int i=0;
        while(i<chars.length){
            if (chars[i] == '/') {
                i++;
                continue;
            }
            StringBuilder sb = new StringBuilder();
            while (i < chars.length && chars[i] != '/') {
                sb.append(chars[i]);
                i++;
            }

            String token = sb.toString();
            if (token.equals("") || token.equals(".")) {
                continue;
            } else if (token.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(token);
            }
        }
        if(stack.size()==0){
            return "/";
        }
        if (stack.isEmpty()) return "/";

        StringBuilder res = new StringBuilder();
        for (String dir : stack) {
            res.append("/").append(dir);
        }

        return res.toString();
    }
}