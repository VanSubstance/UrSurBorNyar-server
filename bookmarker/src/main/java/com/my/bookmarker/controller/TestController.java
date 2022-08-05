package com.my.bookmarker.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.my.bookmarker.service.BookService;
import com.my.bookmarker.service.UtilService;
import com.my.bookmarker.service.WriterService;
import com.my.bookmarker.vo.util.GenrePercent;
import com.my.bookmarker.vo.vanilla.Book;

/**
 * Handles requests for the application home page.
 */
@RestController
public class TestController {
	
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@Autowired
	private BookService serviceBook;
	@Autowired
	private UtilService serviceUtil;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value="/book", method= RequestMethod.GET)
	public List<Book> testGet01() {
		return serviceBook.selectBook(null);
	}
	
	@RequestMapping(value="/test/03/{variable}", method= RequestMethod.GET)
	public List<String> testGet02(@PathVariable String variable) {
		List<String> result = new ArrayList<String>();
		result.add("�׽�Ʈ");
		result.add(variable);
		result.add("�Դϴ�");
		return result;
	}
	
	@RequestMapping(value = "/extract", method = RequestMethod.GET)
	public HashMap<String, HashMap<String, Integer>> extractTestAll() {
		
		return serviceUtil.chainBook(serviceBook.selectBook(null));
	}
	
	@RequestMapping(value = "/book/extract", method = RequestMethod.GET)
	public List<GenrePercent> testExtractGenrePercent() {
		return serviceUtil.getGenrePercent(serviceBook.selectBook(null));
	}

	
	
}

