package com.cibertec.Controllers;
import com.cibertec.Clases.Blogger;
import com.cibertec.Clases.Blogs;
import com.cibertec.Service.Servicio;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;

@Controller
@RequestMapping("/blogs")
public class Controllers {

    @Autowired
    private Servicio blogService;  

   
    @GetMapping
    public String listarBlogs(Model model) {
        List<Blogger> blogs = blogService.listarBlogs();
        model.addAttribute("blogs", blogs);
        return "lista-blogs";  // Vista HTML que mostrará la lista de blogs
    }

    
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevoBlog(Model model) {
        model.addAttribute("blog", new Blogs());
        return "nuevo-blog";  // Vista HTML para crear un nuevo blog
    }

    
    @PostMapping("/guardar")
    public String guardarBlog(@ModelAttribute Blogs blog) {
        blogService.guardarBlog(blog);
        return "redirect:/blogs";  // Redirigir después de guardar
    }

   
    @GetMapping("/eliminar/{id}")
    public String eliminarBlog(@PathVariable int id) {
        try {
            blogService.eliminarBlog(id);
        } catch (IllegalArgumentException e) {
          
            return "redirect:/blogs?error=" + e.getMessage();
        }
        return "redirect:/blogs";  
    }

   
    @GetMapping("/buscar")
    public String buscarBlog(@RequestParam String titulo, Model model) {
        List<Blogs> blogs = blogService.buscarPorTitulo(titulo);
        model.addAttribute("blogs", blogs);
        return "lista-blogs";  
    }

   
    @GetMapping("/reporte/pdf")
    public ResponseEntity<byte[]> exportarPDF() throws JRException, FileNotFoundException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "blogs.pdf");
        byte[] pdfBytes = blogService.exportarBlogsAPDF();  // Método que se implementaría en tu servicio
        return ResponseEntity.ok().headers(headers).body(pdfBytes);
    }

    
}