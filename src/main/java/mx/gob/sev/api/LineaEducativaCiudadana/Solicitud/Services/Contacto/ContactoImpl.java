package mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Services.Contacto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Models.Contacto;
import mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Repositories.ContactoRepository;

@Service
public class ContactoImpl implements ContactoService{

    @Autowired
    private ContactoRepository contactoRepository;

    @Override
    public List<Contacto> findAll(){
        return (List<Contacto>) this.contactoRepository.findAll();
    }

    @Override
    public Contacto save(Contacto contacto){
        return this.contactoRepository.save(contacto);
    }
    
}
