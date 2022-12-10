package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Train;
import tn.esprit.spring.entities.Voyage;
import tn.esprit.spring.repository.TrainRepository;
import tn.esprit.spring.repository.VoyageRepository;

import java.util.List;

@Service
public class VoyageServiceImpl implements IVoyageService {
    @Autowired
    VoyageRepository voyageRepository;
    @Autowired
    TrainRepository trainRepository;
    @Override
    public void ajouterVoyage(Voyage v) {
        voyageRepository.save(v);
    }

    @Override
    public void modifierVoyage(Voyage v) {
		voyageRepository.save(v);
    }


    public void affecterTrainAVoyage(Long idTrain, Long idVoyage) {

        Train t = trainRepository.findById(idTrain).orElse(null);
        Voyage v = voyageRepository.findById(idVoyage).get();
        v.setTrain(t);
        voyageRepository.save(v);
    }

    @Override
    public List<Voyage> recupererAll() {
        return (List<Voyage>) voyageRepository.findAll();
    }

    @Override
    public Voyage recupererVoyageParId(long idVoyage) {
        return voyageRepository.findById(idVoyage).orElse(null);
    }

    @Override
    public void supprimerVoyage(Voyage v) {
    }

}
