package ex04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.TreeSet;

public class Zipcode6_1 {

	
	
//		4. 한국의 시도명 출력 - 17건
	public static void main(String[] args) throws IOException {
		
		String path   = Zipcode6_1.class.getResource("").getPath();
		String fname  = "zipcode_utf8.csv";
		File   inFile = new File(path + fname);
		if( !inFile.exists() ) {
			System.out.println(fname + "이 없습니다");
			System.exit(-1);
		}
		
		FileReader     fr = new FileReader(inFile);
		BufferedReader br = new BufferedReader(fr);
		
		br.readLine(); // 제목 스킵
		String Line   = "";
		int    totcnt = 0;
		String prevSido = "";
		
		long srartTime = System.nanoTime();
		
		int cnt = 0;
		while( (Line = br.readLine()) != null ) {
			PostVo vo   = new PostVo(Line);
			String sido = vo.getSido();
			if( !sido.equals(prevSido) ) {
				prevSido = sido;
				System.out.println(sido);
				cnt++;
			}
//			System.out.println(vo);
			totcnt++;
		}
		
		long endTime = System.nanoTime();
		double execTime = (endTime - srartTime)/1000.0/1000.0/1000.0;
		
		br.close();
		fr.close();
		
		System.out.println("도시수:" + cnt);
		System.out.println("전체자료수:" + totcnt);
		System.out.println("실행시간:" + execTime + "s");
		
	} //

} //
