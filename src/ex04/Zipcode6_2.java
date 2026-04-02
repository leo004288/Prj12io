package ex04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Zipcode6_2 {
	
//		5. 한국의 시도명 출력 - 17건
	public static void main(String[] args) throws IOException {
		
		List<String>  sidoList    = new ArrayList<>();
		List<Integer> sidoCntList = new ArrayList<>();
		
		String path   = Zipcode6_2.class.getResource("").getPath();
		String fname  = "zipcode_utf8.csv";
		File   inFile = new File(path + fname);
		if( !inFile.exists() ) {
			System.out.println(fname + "이 없습니다");
			System.exit(-1);
		}
		
		FileReader     fr = new FileReader(inFile);
		BufferedReader br = new BufferedReader(fr);
		
		br.readLine(); // 제목 스킵
		String line     = "";
		int    totcnt   = 0;    // 전체자료수
		int    pos      = -1;   // 시도 개수
		int    sidoCnt  = 0;    // 시도별 주소
		String prevSido = "";
		
		while( (line = br.readLine()) != null ) {
			PostVo vo   = new PostVo(line);
			String sido = vo.getSido();
			
			if( !sido.equals(prevSido) ) {
				sidoList.add(sido);
				sidoCntList.add(1);
				prevSido = sido;
//				System.out.println(sido);
				pos++;      // 시도 개수
			} else { 
				sidoCnt = sidoCntList.get(pos) + 1;  // 시도별 주소
				sidoCntList.set(pos, sidoCnt);
			}
			totcnt++;
		}
		
		br.close();
		fr.close();
		
		for (int i = 0; i < sidoList.size(); i++) {
			System.out.println(sidoList.get(i) + "=" + sidoCntList.get(i));
		}
		
		System.out.println("도시수:" + (pos + 1));
		System.out.println("전체자료수:" + totcnt);
		
	} //

} //
