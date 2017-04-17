
public class test {
	public static long fibby(int n){
		System.out.print(n + "  ");
		if(n == 0){
			return 1;
		}
		return fibby(n/4) + fibby(3*n/4);
	}
	
	public static void sparsetablegen(int start, int end){
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fibby(12));
	}

}
