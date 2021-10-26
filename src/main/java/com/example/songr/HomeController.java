package com.example.songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
// it will deal with return values as names of templated unless I add the "ResponseBody annotation to the function
//@RestController   -> it will deal with return values as is
//@RequestMapping("/homecontroller")   // prefix for the controller
public class HomeController {
    @Autowired
    AlbumRespository albumsRepository;


    @RequestMapping("/hello")
    @ResponseBody
    public String showHello(){
        return "Hello";
    }
// http://localhost:8080/hello
    @GetMapping("/hello")  // short form of mapping end points
    @ResponseBody               // to deal with return value as is
    public String getRequestFunction(){
        return "hello word ";
    }

    @GetMapping("/capitalize/{word}")
    @ResponseBody
    public String capitalize( @PathVariable("word") String word){
        return word.toUpperCase(Locale.ROOT);
    }
    @GetMapping("/")
    public String homePage(){
        return ("home.html");
    }

    @GetMapping("/alb") public String getAlbums(Model m ){
             Album album1= new Album("akter","Assala",7,8000,"https://img.discogs.com/ONKqJu0DBO0LkAcCwLT2mWvG42M=/fit-in/300x300/filters:strip_icc():format(jpeg):mode_rgb():quality(40)/discogs-images/A-3044489-1568303220-8398.png.jpg");
             Album album2= new Album("fihajat","nansi",1,700,"https://pbs.twimg.com/profile_images/1413791059604291587/NhxQOLHF_400x400.jpg");
             Album album3= new Album("ya ammar anzal","nasef",19,8,"https://www.egy-press.com/wp-content/uploads/2021/03/%D9%85%D8%B9%D9%84%D9%88%D9%85%D8%A7%D8%AA-%D8%B9%D9%86-%D9%86%D8%A7%D8%B5%D9%8A%D9%81-%D8%B2%D9%8A%D8%AA%D9%88%D9%86-%D9%86%D8%B4%D8%A3%D8%AA%D9%87-%D9%88%D8%A3%D9%84%D8%A8%D9%88%D9%85%D8%A7%D8%AA%D9%87-%D9%88%D8%AD%D9%8A%D8%A7%D8%AA%D9%87-%D8%A7%D9%84%D8%B9%D8%A7%D8%B7%D9%81%D9%8A%D8%A9.jpg");
              List<Album> albumsList= new ArrayList<>();
              albumsList.add(album1);
              albumsList.add(album2);
              albumsList.add(album3);
             m.addAttribute("albumsList",albumsList);
             return ("albums.html");
          }
    @GetMapping("/album")
    public String getAlbums1(Model m ){
        m.addAttribute("albumsList",albumsRepository.findAll());
        return ("albums.html");
    }

    @PostMapping("/addalbums")
    public RedirectView showAlbums(@RequestParam(value= "title") String title,@RequestParam(value= "artist") String artist,@RequestParam(value="length") int length,  @RequestParam(value="songCount") int songCount,@RequestParam(value= "imageUrl") String imageUrl ){
//        try{
            Album newAlbum= new Album(title,artist,songCount,length,imageUrl);
            albumsRepository.save(newAlbum);
            return new RedirectView("/album");
//        }catch(Exception e){
//            return new RedirectView("/error");
//        }


    }


}
