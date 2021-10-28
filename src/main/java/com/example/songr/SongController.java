package com.example.songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class SongController {
    @Autowired
    SongRepository songRepository;

    @Autowired
    AlbumRespository albumsRepository;

    @GetMapping("/songs")
    public String allsongs(Model m){
        m.addAttribute("songs",songRepository.findAll());
        return ("songs.html");
    }
    @GetMapping("/addSong")
    public String addSong (Model m){
        m.addAttribute("albums",albumsRepository.findAll() );
        return "addSong.html";
    }

    @PostMapping("/addSong")
    public RedirectView saveSong(@RequestParam(value="title") String title, @RequestParam(value="length") int length, @RequestParam(value="trackNumber") int trackNumber,@RequestParam(value="id") int albumId  ){
        Album album = albumsRepository.findById(albumId).get();
        Song newSong= new Song(title,length,trackNumber,album);
        album.addSongToAlbum(newSong);
        songRepository.save(newSong);
        return new RedirectView("/songs");

    }
    //------------------------------------------------------------------------------------
@GetMapping("/albums/{id}")
public String showSongs(@PathVariable int id , Model model){
    Album album = albumsRepository.findById(id).orElseThrow();
    List<Song> songs = album.getSongs();
    model.addAttribute("songs" , songs);
    return "songs";
}
@PostMapping("/songs/{albumId}")
public RedirectView addSong(@RequestParam String title , @RequestParam int length
        ,@RequestParam int trackNumber , @PathVariable int albumId){
    Song song = new Song(title , length , trackNumber );
    System.out.println("ALbum id " + albumId);
    Album album = albumsRepository.findById(albumId).orElseThrow();
    song.setAlbum(album);
    songRepository.save(song);
    return new RedirectView("/albums/{albumId}");
}





}
