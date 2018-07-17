package test_part;

import org.junit.Test;

import io_part.SimpleTable;

public class MyTest {
	@Test
	public void run1() {
		SimpleTable st = new SimpleTable();
		st.tableWithRowColumn(3, 3);
	}
}
