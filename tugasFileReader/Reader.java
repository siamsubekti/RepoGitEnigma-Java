package enigma.tugasFileReader;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Reader {
	
	

	public static void main(String[] args) {
		
		try {
			File n = new File("/Users/Enigmacamp/Downloads/adisthya-academy-master/presentation/tugas-file.txt");
			BufferedReader br = new BufferedReader(new FileReader(n));
			while (true) {
				String text = br.readLine();
				if (text == null) {
					break;
				}
			
			System.out.println("================================");
			System.out.println("DATA USER");
			System.out.println("================================");
			System.out.println("id : "+text.substring(0,2));
			System.out.println("username : "+text.substring(2,16));
			System.out.println("email : "+text.substring(16,46));
			System.out.println("phone : "+text.substring(46,60));
			System.out.println("address : "+text.substring(60,114));
			System.out.println("job : "+text.substring(115));
			System.out.println("================================");
			System.out.println("================================");
			
	}
		}catch (Exception e) {
			e.printStackTrace();
//			System.out.println("ini salah");
		}
	}
	
}
