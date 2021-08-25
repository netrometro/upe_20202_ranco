package application.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import application.models.Sentimento;
import application.services.SentimentoCRUDService;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("/api/sentimentos")
@RestController
@Slf4j
public class SentimentoCRUDContoller {
	
	@Autowired
	SentimentoCRUDService sentimentoService;
	
	@GetMapping
	public ResponseEntity<List<Sentimento>> getSentimentos(){
		return ResponseEntity.ok(sentimentoService.findAll());
	}	
	
	@GetMapping("/{id}")
	public ResponseEntity<Sentimento> getSentimento(@PathVariable Long id){
		Sentimento sentimento = sentimentoService.findById(id);
		if (sentimento == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(sentimento);
	}
	
	@PostMapping("/{id}")
	public ResponseEntity<Sentimento> createSentimento(@PathVariable Long id, @Valid @RequestBody Sentimento sentimento){
		try {
			return ResponseEntity.ok(sentimentoService.create(id, sentimento));			
		}catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Sentimento> updateSentimento(@PathVariable long id, @RequestBody Sentimento sentimento){
		Sentimento sentimentos = sentimentoService.update(id, sentimento);
		if(sentimentos == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(sentimentos);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Sentimento> deleteSentimento(@PathVariable long id){
		Sentimento sentimentos = sentimentoService.delete(id);
		if(sentimentos == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(sentimentos);
	}


}
