package ex04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Zipcode4 {
	

	public static void main(String[] args) throws IOException {
		
//		Scanner in = new Scanner(System.in);
		
//		705-818 대구 남구  대명2동 1817∼1818 11713
// 		코드    시도 구군  동      번지      번호		
//		ZIPCODE SIDO GUGUN DONG    BUNJI     SEQ
		String path  = Zipcode4.class.getResource("").getPath();
		String fname = "zipcode_utf8.csv";
		File   file  = new File(path + fname);
		
		FileReader     fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		String title = br.readLine();   // 제목스킵
		String line  = "";
		String cnt   = "";
//		int cnt = 0;
		
		
//		System.out.println("");
//		String inAddr = in.nextLine();
		
		while( (line = br.readLine()) !=null ) {
			String [] li = line.trim().split(",");
			String zipcode = li[0].trim();
			String sido    = li[1].trim();
			String gugun   = li[2].trim();
			String dong    = li[3].trim();
			String bunji   = li[4].trim();
			int    seq     = Integer.parseInt(li[5].trim());

//			4. 한국의 시도명 출력 - 17건
//			if( sido.indexOf(inAddr) > -1 ) {
//				String fmt = "[%s] %s %s %s %s %d";
//				String addr = String.format(fmt,
//						zipcode, sido, gugun, dong, bunji, seq);
//				System.out.println(addr);
//				cnt++;				
//			}
			
		}
		System.out.println(cnt + "건");
		
		br.close();
		fr.close();
		
	}

}
