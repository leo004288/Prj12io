package ex04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.TreeSet;

public class Zipcode6 {

	
	
//		4. 한국의 시도명 출력 - 17건
	public static void main(String[] args) throws IOException {
		
		String path   = Zipcode6.class.getResource("").getPath();
		String fname  = "zipcode_utf8.csv";
		File   inFile = new File(path + fname);
		if( !inFile.exists() ) {
			System.out.println(fname + "이 없습니다" + path);
			System.exit(-1);
		}
		
		FileReader     fr = new FileReader(inFile);
		BufferedReader br = new BufferedReader(fr);
		
		br.readLine(); // 제목 스킵
		String Line   = "";
		int    totcnt = 0;
		
		long startTime = System.nanoTime();
		
		HashSet<String> set = new HashSet<>();  // 무작위
		
//		TreeSet<String> set = new TreeSet<>();  // 가나다
		
		while( (Line = br.readLine()) != null ) {
			PostVo vo   = new PostVo(Line);
			String sido = vo.getSido();
//			System.out.println(vo);
			totcnt++;
		}
		
		long endTime = System.nanoTime();
		double execTime = (endTime - startTime)/1000.0/1000.0/1000.0;
		
		br.close();
		fr.close();
		
		for (String sido : set) {
			System.out.println(sido);
		}
		System.out.println(set.size() + "건");
		
		System.out.println("전체자료수:" + totcnt);
		System.out.println("실행시간:" + execTime + "s");
		
	} //

} //
