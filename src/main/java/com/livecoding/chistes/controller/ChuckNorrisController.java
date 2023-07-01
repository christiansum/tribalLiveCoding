package com.livecoding.chistes.controller;

import com.livecoding.chistes.dto.ChuckNorrisJokeDTO;
import com.livecoding.chistes.service.ChuckNorrisServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping(value="/chucknorris")
public class ChuckNorrisController {
	private final ChuckNorrisServices chuckNorrisServices;

	public ChuckNorrisController(ChuckNorrisServices chuckNorrisServices) {
		this.chuckNorrisServices = chuckNorrisServices;
	}

	@GetMapping(value={"/","","index"})
	public List<ChuckNorrisJokeDTO> all (){
		return chuckNorrisServices.getAll();
	}


}
