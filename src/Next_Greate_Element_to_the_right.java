import java.util.Scanner;
import java.util.Stack;

public class Next_Greate_Element_to_the_right {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr [] = {2,5,3,8,-2,9,2,8};
        Stack<Integer> st = new Stack<>();
        int ar[] = new int[arr.length];
        st.push(arr[arr.length -1 ]);
        ar[arr.length - 1] = -1;
        for(int i = arr.length - 2; i >= 0; i--){
            while(st.size() > 0 && arr[i] >= st.peek())
                st.pop();
            if(st.size() == 0)
                ar[i] = -1;
            else
                ar[i] = st.peek();
            st.push(arr[i]);
        }
        for (int x: ar ) {
            System.out.print(x + " ");
        }
    }
}
