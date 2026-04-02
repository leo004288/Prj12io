package ex04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Zipcode01 {
	
	public static void main(String[] args) throws IOException {
		
//		ZIPCODE,SIDO,GUGUN,DONG,BUNJI,SEQ
		String path  = Zipcode01.class.getResource("").getPath();
		String fname = "zipcode_utf8.csv";
		File   file  = new File(path + fname);
		
		FileReader     fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		String title = br.readLine();   // 제목스킵
		String line  = "";
		int cnt = 0;
		while( (line = br.readLine()) !=null ) {
			String [] li = line.trim().split(",");
			String zipcode = li[0].trim();
			String sido    = li[1].trim();
			String gugun   = li[2].trim();
			String dong    = li[3].trim();
			String bunji   = li[4].trim();
			int    seq     = Integer.parseInt(li[5].trim());
			
//			1. 전국의 롯데백화점의 갯수 출력
//			135-704,서울,강남구,대치4동 롯데백화점(강남점),,190
//			if( dong.contains("롯데백화점") ) {
			if( dong.indexOf("럭키아파트") > -1 ) {
				String fmt = "[%s] %s %s %s %s %d";
				String addr = String.format(fmt,
						zipcode, sido, gugun, dong, bunji, seq);
				System.out.println(addr);
				cnt++;				
			}
			
		}
		System.out.println(cnt + "건");
		
		br.close();
		fr.close();
		
	}

}
