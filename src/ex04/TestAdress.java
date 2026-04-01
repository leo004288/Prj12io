package ex04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface Ipo {
	void input() throws IOException;
	void process();
	void output();
}
//ZIPCODE,SIDO,GUGUN,DONG,BUNJI,SEQ
class AdVo {
//	
	private String ZIPCODE;
	private String SIDO;
	private String GUGUN;
	private String DONG;
	private String BUNJI;
	private String SEQ;
	
//	
	public AdVo(String zIPCODE, String sIDO, String gUGUN,
			String dONG, String bUNJI, String sEQ) {
		ZIPCODE = zIPCODE;
		SIDO = sIDO;
		GUGUN = gUGUN;
		DONG = dONG;
		BUNJI = bUNJI;
		SEQ = sEQ;
	}
	
//
	public String getZIPCODE() {
		return ZIPCODE;
	}

	public void setZIPCODE(String zIPCODE) {
		ZIPCODE = zIPCODE;
	}

	public String getSIDO() {
		return SIDO;
	}

	public void setSIDO(String sIDO) {
		SIDO = sIDO;
	}

	public String getGUGUN() {
		return GUGUN;
	}

	public void setGUGUN(String gUGUN) {
		GUGUN = gUGUN;
	}

	public String getDONG() {
		return DONG;
	}

	public void setDONG(String dONG) {
		DONG = dONG;
	}

	public String getBUNJI() {
		return BUNJI;
	}

	public void setBUNJI(String bUNJI) {
		BUNJI = bUNJI;
	}

	public String getSEQ() {
		return SEQ;
	}

	public void setSEQ(String sEQ) {
		SEQ = sEQ;
	}

	@Override
	public String toString() {
		return "AdVo [ZIPCODE=" + ZIPCODE + ", SIDO=" + SIDO + ", GUGUN=" + GUGUN + ", DONG=" + DONG + ", BUNJI="
				+ BUNJI + ", SEQ=" + SEQ + "]";
	}
	
	
} //

class Adress implements Ipo{
	
	List<AdVo> adlist = new ArrayList<>();
	
	@Override
	public void input() throws IOException {
		Scanner in = new Scanner(System.in);	
		
		String path  = "D:/dev/java/Prj12io/src/ex04/";
		String fname = "00zipcode_20130201(1).csv";
		
		FileReader fr     = new FileReader(path + fname);
		BufferedReader br = new BufferedReader( fr );
		
		String fname1 = "result.txt";
		FileWriter fw  = new FileWriter(path + fname1); 
		BufferedWriter bw = new BufferedWriter(fw); 
		
		String line = "";
		while( (line = br.readLine() ) != null ) {
			if( line.trim().isEmpty() ) {
//				System.out.println( );
//				break;
				}
			String [] li = line.trim().split(",");
			String ZIPCODE = li[0].trim();
			String SIDO    = li[1].trim();
			String GUGUN   = li[2].trim();
			String DONG    = li[3].trim();
			String BUNJI   = li[4].trim();
			String SEQ     = li[5].trim();
			
			AdVo  advo = new AdVo(
					ZIPCODE,SIDO,GUGUN,DONG,BUNJI,SEQ); 
			
			adlist.add(advo);
			
//			String fmt   = "%d %d %d %d %d %d\n";
//			String msg   = String.format(fmt,
//					ZIPCODE + SIDO + GUGUN + DONG + BUNJI + SEQ);
//			System.out.println(msg);
//			bw.write(msg);
		}
		System.out.println(adlist.size());
			
		br.close();
		bw.close();
		
		fr.close();
		fw.close();
		
	}

	@Override
	public void process() {
		
		
	}

	@Override
	public void output() {
		for (AdVo vo : adlist) {
            System.out.println(vo);
        }
		
	}
	
} //

public class TestAdress {
	public static void main(String[] args) throws IOException {
		Adress a = new Adress();
		a.input();
		a.process();
		a.output();
		
	} //
} //
 