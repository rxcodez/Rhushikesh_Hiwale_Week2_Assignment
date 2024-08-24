package com.blogPlatform_backend.blog_backend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogPlatform_backend.blog_backend.Entity.BlogData;
import com.blogPlatform_backend.blog_backend.Service.BlogDataService;

@RestController
@RequestMapping("/blogdataApi")
public class BlogDataController {
	@Autowired
	BlogDataService BlogDataService; 
	
	@PostMapping("/savedata")
	public String SaveData(@RequestBody BlogData bd) {
		String msg = BlogDataService.SaveData(bd);
		return msg;
	}
	@PutMapping("/updatedata/{id}")
	public String UpdateData(@RequestBody BlogData bd, @PathVariable int id) {
		String msg = BlogDataService.UpdateData(bd, id);
		return msg;
	}
	@DeleteMapping("/deletedata/{id}")
	public String DeleteData(@PathVariable int id) {
		String msg = BlogDataService.DeleteData(id);
		return msg;
	}
	@GetMapping("/fetchsingleblog/{id}")
	public BlogData FetchSingleBlog(@PathVariable int id) {
		BlogData record = BlogDataService.FetchSignleBlog(id);
		return record;
	}
	@GetMapping("/fetchallblogs")
	public List<BlogData> FetchAllBlogs() {
		List<BlogData> list = BlogDataService.FetchAllBlogs();
		return list;
	}
}