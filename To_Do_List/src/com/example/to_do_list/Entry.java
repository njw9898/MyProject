package com.example.to_do_list;

public class Entry {

	private String title;
	private String date;
	private String level;
	private String content;

	//Constructor
	public Entry () {
		title = "";
		date="";
		level="";
		content="";
	}

	public Entry (String newTitle, String newDate, String newImportantLevel, String newContent) {
		title = newTitle;
		date = newDate;
		level = newImportantLevel;
		content = newContent;
	}
	
	public void setTitle(String newTitle) { title = newTitle; }
	public void setDueDate(String newDate) { date = newDate; }
	public void setLevel(String newLevel) { level = newLevel; }
	public void setContent(String newContent) { content = newContent; }
	
	public String getTitle () { return title; }
	public String getDate () { return date; }
	public String getLevel () { return level; }
	public String getContent () { return content; }
}