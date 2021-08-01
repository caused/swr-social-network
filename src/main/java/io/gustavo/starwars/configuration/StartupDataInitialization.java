package io.gustavo.starwars.configuration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import io.gustavo.starwars.entity.ItemEntity;
import io.gustavo.starwars.repository.ItemRepository;

@Component
public class StartupDataInitialization implements CommandLineRunner{
	
	@Autowired
	private ItemRepository itemRepository;

	@Override
	public void run(String... args) throws Exception {
		var arma = new ItemEntity(1L, "Arma", 4);
		var municao = new ItemEntity(2L, "Munição", 3);
		var agua = new ItemEntity(3L, "Agua", 2);
		var comida = new ItemEntity(4L, "Comida", 1);
		
		itemRepository.saveAll(List.of(arma, municao, agua, comida));
	}

}
