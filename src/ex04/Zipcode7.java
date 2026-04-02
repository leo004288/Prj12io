package ex04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Zipcode7 {
	

	public static void main(String[] args) throws IOException {
		
//		Scanner in = new Scanner(System.in);
		
//		ZIPCODE,SIDO,GUGUN,DONG,BUNJI,SEQ
		String path  = Zipcode7.class.getResource("").getPath();
		String fname = "zipcode_utf8.csv";
		File   file  = new File(path + fname);
		
		FileReader     fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		String title = br.readLine();   // 제목스킵
		String line  = "";
		int cnt = 0;
		
//		System.out.println("동: ");
//		String inAddr = in.nextLine();
		
		while( (line = br.readLine()) !=null ) {
			String [] li = line.trim().split(",");
			String zipcode = li[0].trim();
			String sido    = li[1].trim();
			String gugun   = li[2].trim();
			String dong    = li[3].trim();
			String bunji   = li[4].trim();
			int    seq     = Integer.parseInt(li[5].trim());

			if( dong.indexOf("부전2동") > -1 && sido.indexOf("부산") > -1 ) {
				String fmt = "[%s]";
				String addr = String.format(fmt,
						zipcode);
				System.out.println(addr);
				cnt++;				
			}
			
		}
		System.out.println(cnt + "건");
		
		br.close();
		fr.close();
		
	}

}
