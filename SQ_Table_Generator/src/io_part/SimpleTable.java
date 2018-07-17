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
			//添加<table>标签
			if(i == 0) {
				list.add(ChgSyb.head(table));
				System.out.println(ChgSyb.head(table));
			}
			//添加<tr>标签
			list.add("  " + ChgSyb.head(tr));
			System.out.println("%s%s" + ChgSyb.head(tr));
			//在每一行添加<td>和</td>标签
			for(int j = 0; j < column; j++) {
				int jc = j + 1;
				list.add("    " + ChgSyb.head(td) + "第" + ir + "行" + jc + "列" + ChgSyb.tail(td));
				System.out.println("    " + ChgSyb.head(td) + "第" + ir + "行" + jc + "列" + ChgSyb.tail(td));
			}
			//添加</tr>标签
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
