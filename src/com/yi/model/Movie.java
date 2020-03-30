package com.yi.model;

public class Movie {
	private int mNo;
	private String title;
	private String detail;
	private String time;
	private String file;

	public Movie() {
	}
	

	public int getmNo() {
		return mNo;
	}

	public void setmNo(int mNo) {
		this.mNo = mNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public Movie(int mNo, String title, String detail, String time, String file) {
		super();
		this.mNo = mNo;
		this.title = title;
		this.detail = detail;
		this.time = time;
		this.file = file;
	}


	@Override
	public String toString() {
		return "Movie [mNo=" + mNo + ", title=" + title + ", detail=" + detail + ", time=" + time + ", file=" + file
				+ "]";
	}
	
	

}
