package fr.formation.formateur.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.formateur.dao.IDisponibiliteDAO;
import fr.formation.formateur.model.Disponibilite;




@ResponseBody
@RestController
@RequestMapping("/formateur/dispo")
@CrossOrigin("*")
public class RestControllerDisponibilite {

	
	//====================================INJECTION=====================================================
	@Autowired
	IDisponibiliteDAO daoDisponiblite;

//	//====================================READ==========================================================
//	@GetMapping("/{id}")
//	public Disponibilite findById(@PathVariable int id) {
//		return this.daoDisponiblite.findById(id).get();
//	}
	
	//====================================READ==========================================================
		@GetMapping("/{id}")
		public List<Disponibilite> findByIdFetch(@PathVariable int id) {
			return this.daoDisponiblite.findByIdFetch(id);
		}
	
	//====================================CREATE==========================================================
	@PostMapping("")
	public Disponibilite save(@RequestBody Disponibilite dispo) {
		this.daoDisponiblite.save(dispo);
		return dispo;
	}
	//====================================UPDATE==========================================================
	
	@PutMapping("/{id}")
	public Disponibilite save(@PathVariable int id, @RequestBody Disponibilite dispo) {
		this.daoDisponiblite.save(dispo);
		return dispo;
	}
	
	//====================================DELETE==========================================================
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		this.daoDisponiblite.deleteById(id);
	}
	
	
	
	
}
