package com.cibertec.Clases;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
	@Table(name = "blogs")
	public class Blogs {

	    @Id
	    private int idBlog;
	    private String tituloBlog;
	    private String categoriaBlog;

	    @OneToMany(mappedBy = "blog")  
	    private List<Blogger> bloggers;  

	    // Getters y Setters
	    public int getIdBlog() {
	        return idBlog;
	    }

	    public void setIdBlog(int idBlog) {
	        this.idBlog = idBlog;
	    }

	    public String getTituloBlog() {
	        return tituloBlog;
	    }

	    public void setTituloBlog(String tituloBlog) {
	        this.tituloBlog = tituloBlog;
	    }

	    public String getCategoriaBlog() {
	        return categoriaBlog;
	    }

	    public void setCategoriaBlog(String categoriaBlog) {
	        this.categoriaBlog = categoriaBlog;
	    }

	    public List<Blogger> getBloggers() {
	        return bloggers;
	    }

	    public void setBloggers(List<Blogger> bloggers) {
	        this.bloggers = bloggers;
	    }

	    @Override
	    public String toString() {
	        return "Blog [idBlog=" + idBlog + ", titulo=" + tituloBlog + ", categoría=" + categoriaBlog + "]";
	    }
	}

