import java.io.*;

public class FileCopy {
	public static void main(String[] args) throws IOException{
		FileInputStream inp = new FileInputStream("file.txt");
		FileOutputStream cop = new FileOutputStream("copy.txt");
		try {
			
			int c;
			while ((c = inp.read()) != -1) {
				cop.write(c);
			}
			System.out.println("copied the file successfully");
		}
        catch (Exception ex){
            ex.printStackTrace();
        }
		finally {
			if (inp != null) {
				inp.close();
			}
			if (cop != null) {
				cop.close();
			}
		}
	}
}
