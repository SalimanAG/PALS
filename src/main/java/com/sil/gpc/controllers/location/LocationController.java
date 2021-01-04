package com.sil.gpc.controllers.location;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sil.gpc.domains.Caisse;
import com.sil.gpc.domains.Contrat;
import com.sil.gpc.domains.Echeance;
import com.sil.gpc.domains.Immeuble;
import com.sil.gpc.services.ContratService;
import com.sil.gpc.services.EcheanceService;
import com.sil.gpc.services.ImmeubleService;
import com.sil.gpc.services.LocataireService;
import com.sil.gpc.services.PrixImmeubleService;
import com.sil.gpc.services.TypeImmeubleService;

@RestController
@RequestMapping(path = "/perfora-gpc/v1/location/")
public class LocationController {

	private final ContratService contratService;
	private final EcheanceService echeanceService;
	private final TypeImmeubleService typeImmeubleService;
	private final ImmeubleService immeubleService;
	private final PrixImmeubleService prixImmeubleService;
	private final LocataireService locataireService;
	
	
	public LocationController(ContratService contratService, EcheanceService echeanceService,
			TypeImmeubleService typeImmeubleService, ImmeubleService immeubleService,
			PrixImmeubleService prixImmeubleService, LocataireService locataireService) {
		super();
		this.contratService = contratService;
		this.echeanceService = echeanceService;
		this.typeImmeubleService = typeImmeubleService;
		this.immeubleService = immeubleService;
		this.prixImmeubleService = prixImmeubleService;
		this.locataireService = locataireService;
	}
	
	
	/*###########################################################
	#############	Partie réservée pour contrat
	###########################################################
	*/
	
	@GetMapping(path = "contrat/list")
	public List<Contrat> getAllContrat(){
		
		return this.contratService.getAll();
	}
	
	@GetMapping(path = "contrat/byCodCon/{id}")
	public Optional<Contrat> getContratById(@PathVariable(name = "id") String id){
		
		return this.contratService.getById(id);
	}
	
	@PostMapping(path = "contrat/list")
	public Contrat createContrat( @RequestBody Contrat contrat) {
		
		return this.contratService.save(contrat);
	}
	
	@PutMapping(path = "contrat/byCodCon/{id}")
	public Contrat updateContrat(@PathVariable(name = "id") String id, @RequestBody Contrat contrat) {
		
		return this.contratService.edit(id, contrat);
	}
	
	@DeleteMapping(path = "contrat/byCodCon/{id}")
	public Boolean deleteContrat(@PathVariable(name = "id") String id) {
		
		return this.contratService.delete(id);
	}
	
	
	/*###########################################################
	#############	Partie réservée pour echeance
	###########################################################
	*/
	
	@GetMapping(path = "echeance/list")
	public List<Echeance> getAllEcheance(){
		
		return this.echeanceService.getAll();
	}
	
	@GetMapping(path = "echeance/byCodEch/{id}")
	public Optional<Echeance> getEcheanceById(@PathVariable(name = "id") Long id){
		
		return this.echeanceService.getById(id);
	}
	
	@PostMapping(path = "echeance/list")
	public Echeance createEcheance( @RequestBody Echeance echeance) {
		
		return this.echeanceService.save(echeance);
	}
	
	@PutMapping(path = "echeance/byCodEch/{id}")
	public Echeance updateEcheance(@PathVariable(name = "id") Long id, @RequestBody Echeance echeance) {
		
		return this.echeanceService.edit(id, echeance);
	}
	
	@DeleteMapping(path = "echeance/byCodEch/{id}")
	public Boolean deleteEcheance(@PathVariable(name = "id") Long id) {
		
		return this.echeanceService.delete(id);
	}
	
	
	
	/*###########################################################
	#############	Partie réservée pour type immeuble
	###########################################################
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*###########################################################
	#############	Partie réservée pour immeuble
	###########################################################
	*/
	
	@GetMapping(path = "immeuble/list")
	public List<Immeuble> getAllImmeuble(){
		
		return this.immeubleService.getAll();
	}
	
	@GetMapping(path = "immeuble/byCodImm/{id}")
	public Optional<Immeuble> getImmeubleById(@PathVariable(name = "id") String id){
		
		return this.immeubleService.getById(id);
	}
	
	@PostMapping(path = "immeuble/list")
	public Immeuble createImmeuble( @RequestBody Immeuble immeuble) {
		
		return this.immeubleService.save(immeuble);
	}
	
	@PutMapping(path = "immeuble/byCodImm/{id}")
	public Immeuble updateImmeuble(@PathVariable(name = "id") String id, @RequestBody Immeuble immeuble) {
		
		return this.immeubleService.edit(id, immeuble);
	}
	
	@DeleteMapping(path = "immeuble/byCodImm/{id}")
	public Boolean deleteImmeuble(@PathVariable(name = "id") String id) {
		
		return this.immeubleService.delete(id);
	}

	
	/*###########################################################
	#############	Partie réservée pour prix immeuble
	###########################################################
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*###########################################################
	#############	Partie réservée pour locataire
	###########################################################
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
