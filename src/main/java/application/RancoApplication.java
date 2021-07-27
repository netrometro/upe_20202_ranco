package application;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;

import application.models.Medicacao;
import application.models.Paciente;
import application.models.Psicologo;
import application.models.enums.TipoDeUsuario;
import application.repositories.MedicacaoRepository;
import application.repositories.PacienteRepository;
import application.repositories.PsicologoRepository;

import java.util.List;
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
	public CommandLineRunner testeMedicacao(MedicacaoRepository repository) {
		return (args) -> {
			repository.save(new Medicacao("Dorflex", "Uma vez a cada 8 horas"));
			log.info("Medicação inserida no banco de dados");

			Optional<Medicacao> remedio = repository.findByNome("Dorflex");
			log.info("Achei o Dorflex " + remedio.toString());

			Optional<Medicacao> medicacaoO = repository.findById(1l);
			log.info(medicacaoO.get().toString());

			medicacaoO.get().setNome("Paracetamol");
			repository.save(medicacaoO.get());

			for (Medicacao medicacao : repository.findAll()) {
				log.info(medicacao.toString());
			}
//			repository.deleteById(1l);

			for (Medicacao medicacao : repository.findAll()) {
				log.info(medicacao.toString());
			}

		};

	}

	@Bean
	public CommandLineRunner testePaciente(PacienteRepository repository) {
		return (args) -> {
			repository.save(new Paciente("Danielle", "Danielle@gmail.com", "beijinho", TipoDeUsuario.PACIENTE));
			log.info("Paciente inserido no banco de dados");

			List<Paciente> pacientes = repository.findByNome("Danielle");
			log.info("lista de usuarios com o nome Danielle: " + pacientes.toString());

			Paciente paciente = repository.findById(2);
			log.info("busca paciente por ID" + paciente.toString());

			paciente.setNome("Maria");
			repository.save(paciente);
			log.info(repository.findByNome("Maria").toString());
			
			repository.deleteById(2L);
			log.info("paciente deletado");

		};

	}

	@Bean
	public CommandLineRunner testePsicologo(PsicologoRepository repository) {
		return (args) -> {
			repository.save(
					new Psicologo("Leonardo", "DaVincci@gmail.com", "mona", TipoDeUsuario.PACIENTE, "12345-6789"));
			log.info("Paciente inserido no banco de dados");

			Optional<Psicologo> psicologo = repository.findBycrp("12345-6789");
			log.info("lista de usuarios com o crp : " + psicologo.toString());

			Optional<Psicologo> psicologoID = repository.findById((long) 3);
			log.info("busca paciente por ID" + psicologoID.toString());

			psicologoID.get().setNome("Franco");
			repository.save(psicologoID.get());
			log.info(repository.findById(3l).toString());
			
			repository.deleteById(3L);
			log.info("psicologo deletado");

		};
	}
}
