package co.com.sofkau.horseraces.usecases.game.queries;

import co.com.sofkau.horseraces.repositories.HorseRepository;
import co.com.sofkau.horseraces.repositories.PodiumRepository;

public class GetAllPodiumsUseCase {
        public Object apply(PodiumRepository podiumRepository) {

            return podiumRepository.findAll();

        }
    }

