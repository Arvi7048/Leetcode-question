class Solution {
    public boolean isValid(String s) {
       Stack<Character> stack = new Stack<>();

        // Mapping of closing brackets to opening brackets
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                // Push open brackets onto the stack
                stack.push(c);
            } else {
                // If stack is empty, there's no opening bracket to match
                if (stack.isEmpty()) {
                    return false;
                }

                // Check if the closing bracket matches the top of the stack
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }

        // If stack is empty, all brackets matched properly
        return stack.isEmpty();  
    }
}