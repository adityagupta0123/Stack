import java.util.Stack;

public class Stock_Span__Last_Greatest_element {
    public static void main(String[] args) {
        int []arr = {2, 5, 9, 3, 1, 12, 6, 8, 7};
        Stack<Integer> st = new Stack<>();
        int []n = new int[arr.length];
        n[0] = 1;
        st.push(0);

        for (int i = 1; i < arr.length ; i++) {
            while( st.size() > 0 && arr[i] > arr[st.peek()] )
                st.pop();
            if(st.size() == 0)
                n[i] = i+1;
            else
                n[i] = i - st.peek();
            st.push(i);
        }

        for (int x: n) {
            System.out.print(x+" ");
        }

    }
}
