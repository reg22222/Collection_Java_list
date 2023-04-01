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
		System.out.print("�̸��� �Է� : ");
		String name = in.next();
		System.out.print("���������� �Է� : ");
		int kor = in.nextInt();
		System.out.print("���������� �Է� : ");
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
		System.out.print("������ ȸ���� �̸� : ");
		String name = in.next();
		SungJuk sj = isName(name);
		if (sj == null) {
			System.out.println(name+"���� ���� �л��� �ƴմϴ�.");
		}else {
			System.out.println("���� "+name+"���� ���������� " + sj.getKor()+"�� �Դϴ�.");
			System.out.print("�����Ͻ� �������� : ");
			sj.setKor(in.nextInt());
			System.out.println("���� "+name+"���� ���������� " + sj.getEng()+"�� �Դϴ�.");
			System.out.print("�����Ͻ� �������� : ");
			sj.setEng(in.nextInt());
			sj.setTot();
			System.out.println(name+" �л��� ������ �����Ͽ����ϴ�.");
		}		
	}

	@Override
	public void delete() {
		System.out.print("������ �л��� �̸� : ");
		String name = in.next();
		SungJuk sj = isName(name);
		if (sj == null) {
			System.out.println(name+"���� ���� �л��� �ƴմϴ�.");
		}else {
			System.out.println(name+"�л��� �����մϴ�.");
			list.remove(sj);
		}
	}

	@Override
	public void exit() {
		System.out.println("���α׷��� �����մϴ�.");
		System.exit(0);		
	}

}







