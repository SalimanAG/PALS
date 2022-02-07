package com.sil.gpc.services;

import java.sql.Date;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sil.gpc.domains.Exercice;
import com.sil.gpc.repositories.ExerciceRepository;
import com.sil.gpc.utilities.SalTools;

@Service
public class ExerciceService {

	private final ExerciceRepository repo;

	public ExerciceService(ExerciceRepository repo) {
		super();
		this.repo = repo;
	}
	
	@Transactional
	public Exercice save (Exercice exercice) {
		if(exercice.getDateDebut().compareTo(exercice.getDateFin()) < 0) {
			List<Exercice> liste = this.repo.findAll();
			boolean cloture = false;
			for (int i = 0; i < liste.size(); i++) {
				if(liste.get(i).isCloturerExo() == false) {
					cloture = true;
					break;
				}
			}
			if(cloture == false) {
				liste.sort(new Comparator<Exercice>() {
					@Override
					public int compare(Exercice o1, Exercice o2) {
						// TODO Auto-generated method stub
						return o2.getDateDebut().compareTo(o1.getDateDebut());
					}
				});
				//System.out.println(liste);
				int nbrInter = (1*24*60*60*1000) - 1000;
				if(liste.size()>0) {
					Date date1Fin = liste.get(0).getDateFin();
					Date date2Deb = exercice.getDateDebut();
					//System.out.println(((int)(date1Fin.getTime()/nbrInter))+" - "+((int)(date2Deb.getTime()/nbrInter))+" = "+(((int)(date1Fin.getTime()/nbrInter)) - ((int)(date2Deb.getTime()/nbrInter))));
					
					if(((int)(date2Deb.getTime()/nbrInter)) - ((int)(date1Fin.getTime()/nbrInter)) == 1) {
						return this.repo.save(exercice);
					}
					else {
						SalTools.sendErr("Veuillez Bien Choisir la période de l'exercice");
						return null;
					}
				}
				else {
					return this.repo.save(exercice);
				}
			}
			else {
				SalTools.sendErr("Veuillez Vous rassurer que tous les exercices existent sont cloturés");
				return null;
			}
			
		}
		else {
			SalTools.sendErr("Veuillez Bien Choisir la période de l'exercice");
			return null;
		}
	}
	
	public Exercice edit (Long id, Exercice exercice) {
		
		Exercice entiter = this.repo.getOne(id);
		if(entiter != null) {
			entiter.setCodeExercice(exercice.getCodeExercice());
			entiter.setDateDebut(exercice.getDateDebut());
			entiter.setDateFin(exercice.getDateFin());
			entiter.setEtatExo(exercice.getEtatExo());
			entiter.setLibExercice(exercice.getLibExercice());
			entiter.setCloturerExo(exercice.isCloturerExo());
			
			return this.repo.save(entiter);
		}
		
		return null;
	}
	
	public boolean delete(Long id) {
		
		if(this.repo.existsById(id)==true)
			this.repo.deleteById(id);
		
		return !this.repo.existsById(id);
	}
	
	public Optional<Exercice> getById(Long id){
		
		return this.repo.findById(id);
	}
	
	public List<Exercice> getAll(){
		
		return this.repo.findAll();
	}
	
	public List<Exercice> findByCodeExercice(String codeExercice){
		
		return this.findByCodeExercice(codeExercice);
	}
	
	public List<Exercice> findByDateDebut(Date dateDebut){
		
		return this.findByDateDebut(dateDebut);
	}
	
	public List<Exercice> findByDateFin(Date dateFin){
		
		return this.findByDateFin(dateFin);
	}
	
	public List<Exercice> findByEtatExo(String etatExo){
		
		return this.findByEtatExo(etatExo);
	}
	
	public List<Exercice> findByLibExercice(String libExercice){
		
		return this.findByLibExercice(libExercice);
	}
	
	public List<Exercice> findByExoSelectionner(boolean exoSelectionner){
		
		return this.findByExoSelectionner(exoSelectionner);
	}
	
}
