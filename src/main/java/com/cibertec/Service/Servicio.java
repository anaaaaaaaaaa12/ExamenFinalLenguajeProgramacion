package com.cibertec.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.Clases.*;
import com.cibertec.Repository.*;
	
	@Service
	public class Servicio {
		 @Autowired
		    private BlogsRepositorys blogsRepository;

		    
		    public List<Blogger> listarBlogs() {
		        return blogsRepository.findAll();
		    }
		    public Blogs guardarBlog(Blogs blog) {
		        return blogsRepository.saveAll(blog);
		    }

		    public void eliminarBlog(int id) {
		        if (blogsRepository.existsById(id)) {
		            blogsRepository.deleteById(id);
		        } else {
		            throw new IllegalArgumentException("El blog con ID " + id + " no existe.");
		        }
		    }

		    public List<Blogs> buscarPorTitulo(String titulo) {
		        return blogsRepository.findByTituloContaining(titulo);
		    }
			public byte[] exportarBlogsAPDF() {
				// TODO Auto-generated method stub
				return null;
			}
			
		}