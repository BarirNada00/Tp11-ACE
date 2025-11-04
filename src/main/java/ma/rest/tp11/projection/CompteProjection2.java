package ma.rest.tp11.projection;

import ma.rest.tp11.entities.Compte;
import ma.rest.tp11.entities.TypeCompte;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "mobile", types = Compte.class)
public interface CompteProjection2 {
    double getSolde();
    TypeCompte getType();
}

