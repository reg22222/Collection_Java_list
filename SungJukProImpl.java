package sungjuk;
import java.util.*;

import member.Member;

public class SungJukProImpl implements SungJukPro{
	private ArrayList list;
	private Scanner in;
	
	public SungJukProImpl() {
		list = new ArrayList();
		in = new Scanner(System.in);
	}
	@Override
	public void input() {
		System.out.print("이름을 입력 : ");
		String name = in.next();
		System.out.print("국어점수를 입력 : ");
		int kor = in.nextInt();
		System.out.print("영어점수를 입력 : ");
		int eng = in.nextInt();
		SungJuk sj = new SungJuk(name, kor, eng);
		list.add(sj);
	}
	
	protected SungJuk isName(String name) {
		Iterator it = list.iterator();
		while(it.hasNext()) {
			Object obj = it.next();
			SungJuk sj = (SungJuk)obj;
			if (sj.getName().equals(name)) {
				return sj;
			}
		}
		return null;
	}
	
	protected void rank() {
		for(int i=0; i<list.size(); ++i) {
			Object obj1 = list.get(i);
			SungJuk sj1 = (SungJuk)obj1;
			sj1.clearRank();
			for(int j=0; j<list.size(); ++j) {
				Object obj2 = list.get(j);
				SungJuk sj2 = (SungJuk)obj2;
				if (sj1.getTot() < sj2.getTot()) {
					sj1.plusRank();
				}
			}	
		}
	}

	@Override
	public void view() {
		rank();
		Iterator it = list.iterator();
		while(it.hasNext()) {
			Object obj = it.next();
			SungJuk sj = (SungJuk)obj;
			sj.disp();
		}
	}

	@Override
	public void edit() {
		System.out.print("수제할 회원의 이름 : ");
		String name = in.next();
		SungJuk sj = isName(name);
		if (sj == null) {
			System.out.println(name+"님은 저희 학생이 아닙니다.");
		}else {
			System.out.println("현재 "+name+"님의 국어점수는 " + sj.getKor()+"점 입니다.");
			System.out.print("수정하실 국어점수 : ");
			sj.setKor(in.nextInt());
			System.out.println("현재 "+name+"님의 영어점수는 " + sj.getEng()+"점 입니다.");
			System.out.print("수정하실 영어점수 : ");
			sj.setEng(in.nextInt());
			sj.setTot();
			System.out.println(name+" 학생의 정보를 수정하였습니다.");
		}		
	}

	@Override
	public void delete() {
		System.out.print("삭제할 학생의 이름 : ");
		String name = in.next();
		SungJuk sj = isName(name);
		if (sj == null) {
			System.out.println(name+"님은 저희 학생이 아닙니다.");
		}else {
			System.out.println(name+"학생을 삭제합니다.");
			list.remove(sj);
		}
	}

	@Override
	public void exit() {
		System.out.println("프로그램을 종료합니다.");
		System.exit(0);		
	}

}







