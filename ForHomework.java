
public class ForHomework {

	public static void main(String[] args) {
		
		int f = 0;
		int d = 2;
		int b = 25;
		int a = 66;
		while (d<=a) {
			if (a%d==0 && b%d==0)
				f=1;
			d++;
		}

System.out.println(f);

	}

}
