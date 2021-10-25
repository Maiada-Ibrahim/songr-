package com.example.songr;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@SpringBootTest
class SongrApplicationTests {
	@BeforeEach
	public void pickUp() {
		Album album1 = new Album("akter", "Assala", 7, 8000, "https://img.discogs.com/ONKqJu0DBO0LkAcCwLT2mWvG42M=/fit-in/300x300/filters:strip_icc():format(jpeg):mode_rgb():quality(40)/discogs-images/A-3044489-1568303220-8398.png.jpg");
	}

	@Test
	public void getter() {
		Album album1 = new Album("akter", "Assala", 7, 8000, "https://img.discogs.com/ONKqJu0DBO0LkAcCwLT2mWvG42M=/fit-in/300x300/filters:strip_icc():format(jpeg):mode_rgb():quality(40)/discogs-images/A-3044489-1568303220-8398.png.jpg");
String correct =album1.getTitle();
assertEquals("akter","akter",correct);

		String correct2 =album1.getArtist();
		assertEquals("Assala","Assala",correct2);

		int correct3 =album1.getSongCount();
		assertEquals("akter",7,correct3);

		int correct4 =album1.getLength();
		assertEquals("akter",8000,correct4);

		String correct5 =album1.getImageUrl();
		assertEquals("akter","https://img.discogs.com/ONKqJu0DBO0LkAcCwLT2mWvG42M=/fit-in/300x300/filters:strip_icc():format(jpeg):mode_rgb():quality(40)/discogs-images/A-3044489-1568303220-8398.png.jpg",correct5);

		album1.setTitle("fadia");
		String correct6 =album1.getTitle();
		assertEquals("akter","fadia",correct6);


	}
	@Test
	public void setter() {
		Album album1 = new Album("akter", "Assala", 7, 8000, "https://img.discogs.com/ONKqJu0DBO0LkAcCwLT2mWvG42M=/fit-in/300x300/filters:strip_icc():format(jpeg):mode_rgb():quality(40)/discogs-images/A-3044489-1568303220-8398.png.jpg");
		album1.setTitle("fadia");
		String correct =album1.getTitle();
		assertEquals("akter","fadia",correct);
		album1.setArtist("nseet");
		String correct2 = album1.getArtist();
		assertEquals("Assala","nseet" , correct2);

		album1.setSongCount(9);
		int correct3 = album1.getSongCount();
		assertEquals("akter", 9, correct3);
		album1.setLength(50);
		int correct4 = album1.getLength();
		assertEquals("akter", 50, correct4);

		album1.setImageUrl("https://cdn.ida2at.com/media/2021/01/%D9%81%D8%A7%D8%B6%D9%8A-%D8%B4%D9%88%D9%8A%D8%A9-1.jpg");
		String correct5 = album1.getImageUrl();
		assertEquals("akter", "https://cdn.ida2at.com/media/2021/01/%D9%81%D8%A7%D8%B6%D9%8A-%D8%B4%D9%88%D9%8A%D8%A9-1.jpg", correct5);




	}

}
