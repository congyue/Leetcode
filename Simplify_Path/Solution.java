import java.util.*;
public class Solution {
	public String simplifyPath(String path) {
		int len = path.length();
		if (len < 1)
			return path;

		StringBuilder result = new StringBuilder();
		Stack<String> stack = new Stack<String>();
		//start point to a '/', end point to next '/'
		int start = 0, end = start;
		while(++end < len) {
			//find next '/'
			if (path.charAt(end) != '/')
				continue;
			String segment = path.substring(start, end);
			processSegment(stack, segment);
			start = end;
		}

		//Still have last segment to process
		processSegment(stack,path.substring(start, end));
		//Copy strings from stack to result
		while(!stack.isEmpty())
			result.insert(0, stack.pop());
		//If nothing was in stack, put '/' to result
		//e.g. "/", "/////", "/.", "/../"
		if (result.length() == 0)
			result.append("/");
		return result.toString();
	}

	public void processSegment(Stack<String> stack, String segment) {
		//System.out.println("Evaluating \"" + segment + "\" ...");
		if (segment.equals("/.") || segment.equals("/")) {
			//System.out.println(segment + " is ignored!");
			return;
		}
		else if (segment.equals("/..")) {
			if (!stack.isEmpty()) {
				stack.pop();
				//System.out.println(segment + " is poped out!");
			}
		}
		else {
			stack.push(segment);
			//System.out.println(segment + " is pushed in!");
		}
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		String path = "/a/b/c/..//d/";
		System.out.println("Simplified path of \"" + path + "\" is \"" + solution.simplifyPath(path) + "\"");
	}
}
