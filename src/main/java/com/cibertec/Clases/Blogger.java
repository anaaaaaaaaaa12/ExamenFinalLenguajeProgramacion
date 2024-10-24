package com.cibertec.Clases;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
	@Table(name = "blogger")
	public class Blogger {

	    @Id
	    private int idBlogger;
	    private String nombreBlogger;
	    private String emailBlogger;

	    @ManyToOne
	    @JoinColumn(name = "idBlog")  
	    private Blogs blog;

	  
	    public int getIdBlogger() {
	        return idBlogger;
	    }

	    public void setIdBlogger(int idBlogger) {
	        this.idBlogger = idBlogger;
	    }

	    public String getNombreBlogger() {
	        return nombreBlogger;
	    }

	    public void setNombreBlogger(String nombreBlogger) {
	        this.nombreBlogger = nombreBlogger;
	    }

	    public String getEmailBlogger() {
	        return emailBlogger;
	    }

	    public void setEmailBlogger(String emailBlogger) {
	        this.emailBlogger = emailBlogger;
	    }

	    public Blogs getBlog() {
	        return blog;
	    }

	    public void setBlog(Blogs blog) {
	        this.blog = blog;
	    }

	    @Override
	    public String toString() {
	        return "Blogger [idBlogger=" + idBlogger + ", nombre=" + nombreBlogger + ", email=" + emailBlogger + ", blog=" + blog + "]";
	    }
	}


