package com.my.bookmarker.service;


import com.my.bookmarker.vo.vanilla.Book;
import com.my.bookmarker.vo.vanilla.Genre;
import com.my.bookmarker.vo.vanilla.Writer;

public interface InsertService {
	
	public void insertBook(Book item);
	public void insertGenre(Genre item);
	public void insertWriter(Writer item);

}
