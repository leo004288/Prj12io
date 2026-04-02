package ex04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Zipcode5 {
	

	public static void main(String[] args) throws IOException {
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("검색할시도를 입력하세요:(부산,울산,경남)");
		String    sidos    = in.nextLine(); 
		
		String [] sis      = sidos.trim().split(",");
//		String [] sidoList = new String[sis.length];
		int    [] cnt      = new int[sis.length];
		for (int j = 0; j < sis.length; j++) {
			sis[j]      = sis[j].trim();			
//			sidoList[j] = sis[j];			
			cnt[j]      = 0;
		}

// 		코드    시도 구군 동  번지   번호		
//		ZIPCODE,SIDO,GUGUN,DONG,BUNJI,SEQ
		String path  = Zipcode5.class.getResource("").getPath();
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
		
		while( (line = br.readLine()) !=null ) {
			String [] li = line.trim().split(",");
			String zipcode = li[0].trim();
			String sido    = li[1].trim();
			String gugun   = li[2].trim();
			String dong    = li[3].trim();
			String bunji   = li[4].trim();
			int    seq     = Integer.parseInt(li[5].trim());

			for (int i = 0; i < sis.length; i++) {
				if( sido.equals(sis[i]) ) {
					cnt[i] ++;
				}
			}
			
			
		} // while
		
		for (int i = 0; i < sis.length; i++) {
			System.out.println(sis[i] + ":" + cnt[i] + "건");
		}
		
		br.close();
		fr.close();
		
	}

}
