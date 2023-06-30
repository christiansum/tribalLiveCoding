package com.livecoding.chistes.service;

import com.livecoding.chistes.dto.ChuckNorrisJokeDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

@Service
public class ChuckNorrisServices {
	public List<ChuckNorrisJokeDTO> getAll(){

		String url = "https://api.chucknorris.io/jokes/random";
		RestTemplate restTemplate = new RestTemplate();

		List<ChuckNorrisJokeDTO> listChistes = new ArrayList<>();

		for (int i = 0; i < 25; i++) {
			LinkedHashMap<String, String> chistes = restTemplate.getForObject(url,LinkedHashMap.class);

			LinkedHashMap<String, String> finalChistes = chistes;
			if (!listChistes.stream().anyMatch(ch-> ch.id == finalChistes.get("id"))){
				LinkedHashMap<String, String> chiste1 = new LinkedHashMap<String, String>();
				chiste1.put("id", finalChistes.get("id"));
				chiste1.put("value", finalChistes.get("value"));
				chiste1.put("url", finalChistes.get("url"));
				listChistes.add(chiste1);
			}
		}
		
		return listChistes;
	}
}
