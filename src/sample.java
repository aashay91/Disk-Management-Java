import java.io.IOException;


public class sample {

	public static void main2(String name) {
		// TODO Auto-generated method stub

		System.out.println(name);
		String cmds[] = new String[] {"cmd", "/c", name};
		
		    try {
				Runtime.getRuntime().exec(cmds);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

}
