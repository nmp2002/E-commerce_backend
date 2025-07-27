package com.ttisv.common.utils;

import java.io.File;
import java.io.FilenameFilter;

public final class CustomFilenameFilter implements FilenameFilter {
	private /* synthetic */ String a;

	public CustomFilenameFilter(final String a) {
		this.a = a;
	}

	@Override
	public final boolean accept(final File file, final String s) {
		return s.endsWith(this.a);
	}
}
