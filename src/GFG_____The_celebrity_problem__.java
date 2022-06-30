
class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n)
    {
    	Stack<Integer> st = new Stack <>();
    	for(int i=0; i< n; i++){
    	    st.push(i);
    	}
    	
    	while( st.size() >= 2){
    	    int i = st.pop();
    	    int j = st.pop();
    	    
    	    if(M[i][j] == 1){
    	        // if i know j then i is not a celebrity
    	        st.push(j);
    	    } else {
    	        // if i doesn't j then j is not a celebrity
    	        st.push(i);
    	    }
    	}
    	int pot = st.pop();
    	for(int i =0 ; i< n; i++){
    	    if( i != pot ){
    	        if(M[i][pot] == 0 || M[pot][i] == 1){
    	            pot = -1;
    	           return pot;
    	        }
    	    }
    	}
    	
    	return pot;
    }
}
