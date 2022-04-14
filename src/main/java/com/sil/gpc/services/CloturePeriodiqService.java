package com.sil.gpc.services;

import java.sql.Date;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sil.gpc.domains.CloturePeriodiq;
import com.sil.gpc.repositories.CloturePeriodiqRepository;
import com.sil.gpc.utilities.SalTools;

@Service
public class CloturePeriodiqService {

	private final CloturePeriodiqRepository repo;

	public CloturePeriodiqService(CloturePeriodiqRepository repo) {
		super();
		this.repo = repo;
	}
	
	
	public CloturePeriodiq save(CloturePeriodiq cloturePeriodiq) {
		cloturePeriodiq.setValide(true);
		if(cloturePeriodiq.getDateDebutCloturePer().compareTo(cloturePeriodiq.getDateFinCloturePer()) < 0) {
			List<CloturePeriodiq> liste = this.repo.findAll();
			
			liste.sort(new Comparator<CloturePeriodiq>() {
				@Override
				public int compare(CloturePeriodiq o1, CloturePeriodiq o2) {
					// TODO Auto-generated method stub
					return o2.getDateDebutCloturePer().compareTo(o1.getDateDebutCloturePer());
				}
			});
			//System.out.println(liste);
			int nbrInter = (1*24*60*60*1000) - 1000;
			if(liste.size()>0) {
				Date date1Fin = liste.get(0).getDateFinCloturePer();
				Date date2Deb = cloturePeriodiq.getDateDebutCloturePer();
				System.out.println(((int)(date1Fin.getTime()/nbrInter))+" - "+((int)(date2Deb.getTime()/nbrInter))+" = "+(((int)(date1Fin.getTime()/nbrInter)) - ((int)(date2Deb.getTime()/nbrInter))));
				
				if(((int)(date2Deb.getTime()/nbrInter)) - ((int)(date1Fin.getTime()/nbrInter)) == 1) {
					return this.repo.save(cloturePeriodiq);
				}
				else {
					SalTools.sendErr("Veuillez Bien Choisir la période de cloture");
					return null;
				}
			}
			else {
				return this.repo.save(cloturePeriodiq);
			}
			
		}
		else {
			SalTools.sendErr("Veuillez Bien Choisir la période de cloture");
			return null;
		}
		
	}
	
	public CloturePeriodiq edit(Long id, CloturePeriodiq cloturePeriodiq) {
		
		CloturePeriodiq entiter = this.repo.getOne(id);
		if(entiter != null) {
			entiter.setDateDebutCloturePer(cloturePeriodiq.getDateDebutCloturePer());
			entiter.setDateFinCloturePer(cloturePeriodiq.getDateFinCloturePer());
			entiter.setExercice(cloturePeriodiq.getExercice());
			
			return this.repo.save(entiter);
		}
		
		return null;
	}
	
	
	public CloturePeriodiq validate(Long id, CloturePeriodiq cloturePeriodiq) {
		CloturePeriodiq entiter = this.repo.getOne(id);
		if(entiter != null) {
			List<CloturePeriodiq> liste = this.repo.findAll();
			
			liste.sort(new Comparator<CloturePeriodiq>() {
				@Override
				public int compare(CloturePeriodiq o1, CloturePeriodiq o2) {
					// TODO Auto-generated method stub
					return o2.getDateDebutCloturePer().compareTo(o1.getDateDebutCloturePer());
				}
			});
			
			
			int indexOfPeri = 4;
			
			if(liste.get(0).getIdCloturePer().equals(id)) {
				indexOfPeri = 0;
			}else if(liste.get(1).getIdCloturePer().equals(id)) {
				indexOfPeri = 1;
			} else if(liste.get(2).getIdCloturePer().equals(id)) {
				indexOfPeri = 2;
			} else if(liste.get(3).getIdCloturePer().equals(id)) {
				indexOfPeri = 3;
			}
			
			if(cloturePeriodiq.isValide() == false) {
				
				for (int i = indexOfPeri-1; i > -1; i--) {
					if(liste.get(i).isValide() == true) {
						SalTools.sendErr("Veuillez d'abord annuler les prériodes ayants succédé la période que vous voulez annuler");
						return null;
					}
				}
				
				if(indexOfPeri == 4) {
					SalTools.sendErr("Vous ne pouvez que annuler au plus 4 clôtures périodiques");
					return null;
				}
				
			} else {
				
				if((indexOfPeri+1) < liste.size() && liste.get(indexOfPeri+1).isValide() == false) {
					SalTools.sendErr("Veuillez d'abord valider les prériodes ayants préccédé la période que vous voulez valider");
					return null;
				}
			}
			
			entiter.setValide(cloturePeriodiq.isValide());
			
			return this.repo.save(entiter);
		}
		
		return null;
	}
	
	public boolean delete(Long id) {
		
		CloturePeriodiq entiter = this.repo.getOne(id);
		if(entiter != null) {
			this.repo.deleteById(id);
		}
		
		return !this.repo.existsById(id);
	}
	
	public CloturePeriodiq getById(Long id){
		
		return this.repo.findById(id).get();
	}
	
	public List<CloturePeriodiq> getAll(){
		
		return this.repo.findAll();
	}
	
	public boolean isPeriodeClotured(Date date) {
		boolean cloturer = false;
		
		List<CloturePeriodiq> liste = repo.findAll();
		
		for (int i = 0; i < liste.size(); i++) {
			if((liste.get(i).getDateDebutCloturePer().before(date) || liste.get(i).getDateDebutCloturePer().equals(date))
					&& (liste.get(i).getDateFinCloturePer().after(date) || liste.get(i).getDateFinCloturePer().equals(date))) {
				cloturer = true;				
				break;
			}
		}
		
		return cloturer; 
	}

	
	
	
}
