package com.blogPlatform_backend.blog_backend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogPlatform_backend.blog_backend.Entity.BlogData;
import com.blogPlatform_backend.blog_backend.Repository.BlogDataRepository;

@Service
public class BlogDataService {
	@Autowired
	BlogDataRepository BlogDataRepository;
	public String SaveData(BlogData bd) {
		String msg = BlogDataRepository.SaveData(bd);
		if (msg==null) {
			System.out.println("Failed to save the data");
		}
		return msg;
	}
	public String UpdateData(BlogData bd, int id) {
		String msg = BlogDataRepository.UpdateData(bd, id);
		if (msg==null) {
			System.out.println("Failed to update the data");
		}
		return msg;
	}
	public String DeleteData(int id) {
		String msg = BlogDataRepository.DeleteData(id);
		if (msg==null) {
			System.out.println("Failed to delete the data");
		}
		return msg;
	}
	public BlogData FetchSignleBlog(int id) {
		BlogData record = BlogDataRepository.FetchSingleBlog(id);
		if (record==null) {
			System.out.println("Failed to fetch the blog data");
		}
		return record;
	}
	public List<BlogData> FetchAllBlogs() {
		List<BlogData> list = BlogDataRepository.FetchAllBlogs();
		if (list==null) {
			System.out.println("Failed to fetch the data");
		}
		return list;
	}
}
