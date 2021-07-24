package application;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;

import application.models.Medicacao;
import application.models.Paciente;
import application.services.MedicacaoRepository;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
@ServletComponentScan
public class RancoApplication {
	
	private static final Logger log = LoggerFactory.getLogger(RancoApplication.class);
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(RancoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(MedicacaoRepository repository) {
	    return (args) -> {
	    	 repository.save(new Medicacao("Dorflex", "Uma vez a cada 8 horas"));
	    	 log.info("Medicação inserida no banco de dados");
	    	 
	    	 Medicacao remedio = repository.findByNome("Dorflex");
	    	 log.info("Achei o Dorflex " + remedio.toString());
	    	 
	    	 Optional<Medicacao> medicacaoO = repository.findById(1l);
	    	 log.info(medicacaoO.get().toString());
	    	 
	    	 medicacaoO.get().setNome("Paracetamol");
	    	 repository.save(medicacaoO.get());
	    	 
	    	 for(Medicacao medicacao : repository.findAll())
	    	 {
	    		 log.info(medicacao.toString());	    		 	    		     		
	    	 }
	    	 repository.deleteById(1l);
	    	 
	    	 for(Medicacao medicacao : repository.findAll())
	    	 {
	    		 log.info(medicacao.toString());	    		 	    		     		
	    	 }
	    };
	}
}
