package io_part;

import java.util.ArrayList;

public class SimpleTable implements TableGenerate{
	static ArrayList<String> list;
	public ArrayList<String> tableWithRowColumn(int row, int column) {
		list = new ArrayList<String>();
		String td = "td";
		String table = "table";
		String tr = "tr";
//		String gtsymbol = "<";
//		String ltsymbol = ">";
//		String slash = "/";
		for (int i = 0; i < row; i++) {
			int ir = i + 1;
			//���<table>��ǩ
			if(i == 0) {
				list.add(ChgSyb.head(table));
				System.out.println(ChgSyb.head(table));
			}
			//���<tr>��ǩ
			list.add("  " + ChgSyb.head(tr));
			System.out.println("%s%s" + ChgSyb.head(tr));
			//��ÿһ�����<td>��</td>��ǩ
			for(int j = 0; j < column; j++) {
				int jc = j + 1;
				list.add("    " + ChgSyb.head(td) + "��" + ir + "��" + jc + "��" + ChgSyb.tail(td));
				System.out.println("    " + ChgSyb.head(td) + "��" + ir + "��" + jc + "��" + ChgSyb.tail(td));
			}
			//���</tr>��ǩ
			list.add("  " + ChgSyb.tail(tr));
			System.out.println("  " + ChgSyb.tail(tr));
			
			if(i == row-1) {
				System.out.println(ChgSyb.tail(table));
				list.add(ChgSyb.tail(table));
			}
		}
		return list;
	}
}
