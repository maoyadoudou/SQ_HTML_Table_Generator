package io_part;

public class ChgSyb {
	static String gtsymbol = "<";
	static String ltsymbol = ">";
	static String slash = "/";
	public static String head(String str) {
		return gtsymbol + str + ltsymbol;
	}

	public static String tail(String str) {
		return gtsymbol + slash + str + ltsymbol;
	}
}
