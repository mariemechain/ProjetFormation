package fr.formation.disponibilite.annexe;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="videoprojecteur")
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@PrimaryKeyJoinColumn(name="VID_ID", referencedColumnName="MAT_ID")
public class VideoProjecteur extends Materiel {

}
