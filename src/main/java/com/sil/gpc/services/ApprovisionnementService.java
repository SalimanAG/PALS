package com.sil.gpc.services;

import java.sql.Date;
import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.Approvisionnement;
import com.sil.gpc.domains.EcritureComptable;
import com.sil.gpc.domains.Exercice;
import com.sil.gpc.domains.LigneAppro;
import com.sil.gpc.domains.LigneDemandeAppro;
import com.sil.gpc.domains.LigneDemandePrix;
import com.sil.gpc.domains.OpeJournalSetting;
import com.sil.gpc.domains.StockComptaSetting;
import com.sil.gpc.domains.Stocker;
import com.sil.gpc.encapsuleurs.EncapApprovisionnement;
import com.sil.gpc.encapsuleurs.EncapDemandePrix;
import com.sil.gpc.repositories.ApprovisionementRepository;
import com.sil.gpc.repositories.LigneApproRepository;

@Service
public class ApprovisionnementService {

	private final ApprovisionementRepository repo;
	private final LigneApproRepository repo2;
	private final LigneApproService servi2;
	private final StockerService servi3;
	private final LigneDemandeApproService servi4;
	private final StockComptaSettingService servi5;
	private final OpeJournalSettingService servi6;
	private final EcritureComptableService servi7;

	public ApprovisionnementService(ApprovisionementRepository repo, LigneApproRepository repo2, LigneApproService servi2, StockerService servi3, LigneDemandeApproService servi4, StockComptaSettingService servi5, EcritureComptableService servi7, OpeJournalSettingService servi6) {
		super();
		this.repo = repo;
		this.repo2 = repo2;
		this.servi2 = servi2;
		this.servi3 = servi3;
		this.servi4 = servi4;
		this.servi5 = servi5;
		this.servi6 = servi6;
		this.servi7 = servi7;
	}
	
	public Approvisionnement save(Approvisionnement approvisionnement) {
		approvisionnement.setValideAppro(false);	
		
		Integer val = 1, nbrMaxCaract = 6;
		String code = "BA-";
		if(this.repo.findLastNumUsed(approvisionnement.getExercice().getNumExercice()) != null) {
			val = this.repo.findLastNumUsed(approvisionnement.getExercice().getNumExercice());
			val++;
			
		}
		
		approvisionnement.setValeur(val);
		
		code = code+approvisionnement.getExercice().getCodeExercice();
		
		for (int i=0; i<nbrMaxCaract -  (val+"").length(); i++) {
			code+="0";
		}
		
		approvisionnement.setNumAppro(code+val);
		
		if(repo.existsById(approvisionnement.getNumAppro())==false) return this.repo.save(approvisionnement) ;
		
		return null;
		
	}
	
	public Approvisionnement edit(String id, Approvisionnement approvisionnement) {
		
		Approvisionnement entiter = this.repo.getOne(id); 
		if(entiter != null) {
			entiter.setDateAppro(approvisionnement.getDateAppro());
			entiter.setDescriptionAppro(approvisionnement.getDescriptionAppro());
			
			entiter.setExercice(approvisionnement.getExercice());
			entiter.setMagasin(approvisionnement.getMagasin());
			
			return this.repo.save(entiter);
		}
		
		return null;
	}
	
	
	public EncapApprovisionnement editByEncap(String id, EncapApprovisionnement encap) {
		
		List<LigneAppro> lignes = this.repo2.findAll();
		List<LigneAppro> concernedLignes = new ArrayList<LigneAppro>();
		List<LigneAppro> newLignes = new ArrayList<LigneAppro>();
		
		for(int i = 0; i < lignes.size(); i++) {
			if(lignes.get(i).getAppro().getNumAppro().equalsIgnoreCase(id)) {
				concernedLignes.add(lignes.get(i));
			}
		}
		
		for(int i = 0; i < encap.getLigneAppros().size(); i++) {
			boolean added = true;
			LigneAppro enti = null;
			
			for(int j = 0; j < concernedLignes.size(); j++) {
				if(concernedLignes.get(j).getLigneDA().getArticle().getNumArticle() == encap.getLigneAppros().get(i).getLigneDA().getArticle().getNumArticle()) {
					added = false;
					enti = concernedLignes.get(j);
					break;
				}
			}
			
			LigneAppro newer = encap.getLigneAppros().get(i);
			newer.setAppro(repo.getOne(id));
			
			if(added == true) {
				
				this.repo2.save(newer);
			}
			else {
				this.servi2.edit(enti.getIdLigneAppro(), newer);
			}
		}
		
		for(int i = 0; i < concernedLignes.size(); i++) {
			
			boolean removed = true;
			
			for(int j = 0; j < encap.getLigneAppros().size(); j++) {
				if(concernedLignes.get(i).getLigneDA().getArticle().getNumArticle().longValue() == encap.getLigneAppros().get(j).getLigneDA().getArticle().getNumArticle()) {
					removed = false;
					break;
				}
			}
			
			if(removed == true) {
				concernedLignes.get(i).getLigneDA().setSatisfaite(false);
				this.servi4.edit(concernedLignes.get(i).getLigneDA().getIdLigneDA(), concernedLignes.get(i).getLigneDA());
				this.repo2.deleteById(concernedLignes.get(i).getIdLigneAppro());
			}			
			
		}
		
		for(int i = 0; i < encap.getLigneAppros().size(); i++) {			
			this.servi4.edit(encap.getLigneAppros().get(i).getLigneDA().getIdLigneDA(), encap.getLigneAppros().get(i).getLigneDA());
		}
		
		lignes = this.repo2.findAll();
		
		for(int i = 0; i < lignes.size(); i++) {
			if(lignes.get(i).getAppro().getNumAppro().equalsIgnoreCase(id)) {
				newLignes.add(lignes.get(i));
			}
		}
		
		
		return new EncapApprovisionnement(this.edit(id, encap.getApprovisionnement()), newLignes);
	}
	
	
	public Approvisionnement edit3(String id, Approvisionnement approvisionnement) {
		Approvisionnement entiter = this.repo.getOne(id); 
		if(entiter != null && approvisionnement.isValideAppro() != entiter.isValideAppro()) {

			
			
			List<LigneAppro> lignes = this.servi2.getAll();
			List<Stocker> listStocker = this.servi3.getAll();
			
			for(int i = 0; i < lignes.size(); i++) {
				if(lignes.get(i).getAppro().getNumAppro().equalsIgnoreCase(id)) {
					LigneAppro ligApp = lignes.get(i);
					
					boolean stockerFinded = false;
					for(int j = 0; j < listStocker.size(); j++) {
						if(listStocker.get(j).getArticle().getNumArticle() == lignes.get(i).getLigneDA().getArticle().getNumArticle()
								&& listStocker.get(j).getMagasin().getNumMagasin() == entiter.getMagasin().getNumMagasin()) {
							stockerFinded = true;
							
							Stocker newSt = listStocker.get(j);
							
							
							if(approvisionnement.isValideAppro() == true) {
								newSt.setQuantiterStocker(newSt.getQuantiterStocker()-(lignes.get(i).getQuantiteLigneAppro()*lignes.get(i).getLigneDA().getUniter().getPoids()));
								ligApp.setPULigneAppro(newSt.getCmup());
							}else if(approvisionnement.isValideAppro() == false) {
								newSt.setQuantiterStocker(newSt.getQuantiterStocker()+(lignes.get(i).getQuantiteLigneAppro()*lignes.get(i).getLigneDA().getUniter().getPoids()));
								ligApp.setPULigneAppro(Long.valueOf(0));
							}
																					
							this.servi3.edit(listStocker.get(j).getIdStocker(), newSt);
							
							entiter.setValideAppro(approvisionnement.isValideAppro());
							
							break;
						}
					}
					
					this.repo2.save(ligApp);
					
					//Ecritures comptables
					List<OpeJournalSetting> numJournaux = this.servi6.getAll();
					List<StockComptaSetting> paramFamille = this.servi5.getAll();
					
					for (int m=0; m < paramFamille.size(); m++) {
						if(paramFamille.get(m).getFamille().getNumFamille() == ligApp.getLigneDA().getArticle().getFamille().getNumFamille() && paramFamille.get(m).isExportable() == true) {
							List<EcritureComptable> ecriOper = new ArrayList<EcritureComptable>();
							String numJournStock = "";
							String numJournVStock = "";
							
							for(int n=0; n < numJournaux.size(); n++) {
								if(numJournaux.get(n).getOperation().equalsIgnoreCase("STOCK")) {
									numJournStock = numJournaux.get(n).getJournal();
									break;
								}
							}
							
							for(int n=0; n < numJournaux.size(); n++) {
								if(numJournaux.get(n).getOperation().equalsIgnoreCase("V/STOCK")) {
									numJournVStock = numJournaux.get(n).getJournal();
									break;
								}
							}
							
							ecriOper.add(new EcritureComptable(Long.valueOf(0), numJournStock, (Date) Date.from(ligApp.getAppro().getDateAppro().toInstant()), "1", paramFamille.get(m).getCompteStock(), true, ligApp.getLigneDA().getAppro().getService().getCodeService(), "Pour Sortie du magasin "+ligApp.getAppro().getMagasin().getCodeMagasin(), ligApp.getAppro().getNumAppro(), paramFamille.get(m).getFamille()));
							ecriOper.add(new EcritureComptable(Long.valueOf(0), numJournVStock, (Date) Date.from(ligApp.getAppro().getDateAppro().toInstant()), "1", paramFamille.get(m).getCompteVaStock(), false, ligApp.getLigneDA().getAppro().getService().getCodeService(), "Pour Sortie du magasin "+ligApp.getAppro().getMagasin().getCodeMagasin(), ligApp.getAppro().getNumAppro(), paramFamille.get(m).getFamille()));
							
							ecriOper.get(0).setMontantEcri(ligApp.getPULigneAppro()*ligApp.getQuantiteLigneAppro()*ligApp.getLigneDA().getUniter().getPoids());
							ecriOper.get(1).setMontantEcri(ligApp.getPULigneAppro()*ligApp.getQuantiteLigneAppro()*ligApp.getLigneDA().getUniter().getPoids());
							
							this.servi7.save2(ecriOper);
							
							break;
							
						}
						
					}
	
					
					
				}
			}
			
			
			
			return this.repo.save(entiter);
		}
		
		return null;
	}
	
	
	
	public boolean delete(String id) {
		
		Approvisionnement entiter = this.repo.getOne(id);
		if(entiter != null) {
			this.repo.deleteById(id);
		}
		
		return !this.repo.existsById(id);
	}
	
	
	public boolean deleteAApprovisionnement2(String id) {
		
		List<LigneAppro> lignes = this.repo2.findAll();
		
		for(int i = 0; i < lignes.size(); i++) {
			if(lignes.get(i).getAppro().getNumAppro().equalsIgnoreCase(id)) {
				lignes.get(i).getLigneDA().setSatisfaite(false);
				this.servi4.edit(lignes.get(i).getLigneDA().getIdLigneDA(), lignes.get(i).getLigneDA());
				this.repo2.deleteById(lignes.get(i).getIdLigneAppro());
			}
		}
		
		return this.delete(id);
	}
	
	
	public Optional<Approvisionnement> getById(String id){
		
		return this.repo.findById(id);
	}
	
	public List<Approvisionnement> getAll(){
		
		return this.repo.findAll();
	}
	
	public List<Approvisionnement> findByNumAppro(String numAppro){
		
		return this.repo.findByNumAppro(numAppro);
	}
	
	public List<Approvisionnement> findByDateAppro(Date dateAppro){
		
		return this.repo.findByDateAppro(dateAppro);
	}
	
	public List<Approvisionnement> findByDescriptionAppro(String descriptionAppro){
		
		return this.repo.findByDescriptionAppro(descriptionAppro);
	}
	
	public List<Approvisionnement> findByExercice(Exercice exercice){
		
		return this.repo.findByExercice(exercice);
	}


	
}
