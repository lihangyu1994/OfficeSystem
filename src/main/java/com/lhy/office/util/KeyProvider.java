package com.lhy.office.util;

import java.util.UUID;

public class KeyProvider {

	public static String getPrimaryKey(){
		return UUID.randomUUID().toString();
	}
}
