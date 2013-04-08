package com.utils;

public class RowData {
	public int mId;
	public String mTitle;
	public String mDetail;

	public RowData(int id, String title, String detail) {
		mId = id;
		mTitle = title;
		mDetail = detail;
	}

	@Override
	public String toString() {
		return mId + " " + mTitle + " " + mDetail;
	}
}
