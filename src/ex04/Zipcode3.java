package ex04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Zipcode3 {
	

	public static void main(String[] args) throws IOException {
		
//		Scanner in = new Scanner(System.in);
		
// 		코드    시도 구군 동  번지   번호		
//		ZIPCODE,SIDO,GUGUN,DONG,BUNJI,SEQ
		String path  = Zipcode3.class.getResource("").getPath();
		String fname = "zipcode_utf8.csv";
		File   file  = new File(path + fname);
		if( !file.exists() ) {
			System.out.println(file + "이 없습니다");
			System.exit(-1);  //프로그램 종료 / 파일 읽기전에 해야함
		}
		
		FileReader     fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		String title = br.readLine();   // 제목스킵
		
		String line  = "";
		int cnt1 = 0;
		int cnt2 = 0;
		int cnt3 = 0;
		
		while( (line = br.readLine()) !=null ) {
			String [] li = line.trim().split(",");
			String zipcode = li[0].trim();
			String sido    = li[1].trim();
			String gugun   = li[2].trim();
			String dong    = li[3].trim();
			String bunji   = li[4].trim();
			int    seq     = Integer.parseInt(li[5].trim());

//			3. 부산, 울산, 대구 우편번호
			switch (sido) {
			case "부산" : ++cnt1; break;
			case "대구" : ++cnt2; break;
			case "울산" : ++cnt3; break;
			}
		}
		System.out.println("부산" + cnt1);
		System.out.println("대구" + cnt2);
		System.out.println("울산" + cnt3);
		
		
		br.close();
		fr.close();
		
	}

}
