import java.io.*;
public class osInjection2 {

	public osInjection2() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args)
		throws IOException {
		
			if(args.length != 1) {
				System.out.println("No arguments");
				System.exit(1);
			}
			
			Runtime runtime = Runtime.getRuntime();
			String[] cmd = new String[3];
			
			
			cmd[0] = "cmd.exe" ;
			
	                cmd[1] = "/C";
	                cmd[2] = "copy " + args[0];
	                
			Process proc = runtime.exec(cmd);
					
			InputStream is = proc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		}
	}
