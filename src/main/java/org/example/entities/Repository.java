package org.example.entities;

import jakarta.persistence.*;
import org.hibernate.engine.internal.Cascade;

import java.util.Date;
import java.util.List;
import java.util.Map;

//// Entidad A (Propietaria)
//@ManyToMany
//@JoinTable(
//          name = "nombre_tabla_intermedia",
//          joinColumns = @JoinColumn(name = "clave_foranea_entidad_A"),
//          inverseJoinColumns = @JoinColumn(name = "clave_foranea_entidad_B")
//          )
//          private Set<EntidadB> entidadesB;
//
//        // Entidad B (Inversa)
//        @ManyToMany(mappedBy = "entidadesB")
//        private Set<EntidadA> entidadesA;



@Entity
public class Repository {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id_repository;
    @Column
    private String repositoryName;
    @Column
    private String descripcion;
    @Column
    private int lastUpdate;
    @Column
    private float strars;
    @Column
    private String URL;
    @ManyToOne (cascade = CascadeType.PERSIST)
    @JoinColumn (name = "id_user")
    private User id_user;
    @ManyToMany (cascade = CascadeType.PERSIST)
    @JoinTable(
          name = "RepositoryXTag",
          joinColumns = @JoinColumn(name = "id_repository"),
          inverseJoinColumns = @JoinColumn(name = "id_tag")
          )
    private List<Tag> tags;
    @ManyToMany (cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "RepositoryXLanguage",
            joinColumns = @JoinColumn(name = "id_repository"),
            inverseJoinColumns = @JoinColumn(name = "id_language")
    )
    private List<Language> languages;

    public Repository() {
    }

    public Repository(int id_repository, String repositoryName, String descripcion, int lastUpdate, float strars, String URL, User id_user, List<Tag> tags, List<Language> languages) {
        this.id_repository = id_repository;
        this.repositoryName = repositoryName;
        this.descripcion = descripcion;
        this.lastUpdate = lastUpdate;
        this.strars = strars;
        this.URL = URL;
        this.id_user = id_user;
        this.tags = tags;
        this.languages = languages;
    }

    public String getRepositoryName() {
        return repositoryName;
    }

    public void setRepositoryName(String repositoryName) {
        this.repositoryName = repositoryName;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(int lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public float getStrars() {
        return strars;
    }

    public void setStrars(float strars) {
        this.strars = strars;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public User getId_user() {
        return id_user;
    }

    public void setId_user(User id_user) {
        this.id_user = id_user;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

    @Override
    public String toString() {
        return "Repository{" +
                "repositoryName='" + repositoryName + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", lastUpdate=" + lastUpdate +
                ", strars=" + strars +
                ", URL='" + URL + '\'' +
                ", id_user=" + id_user +
                ", tags=" + tags +
                ", languages=" + languages +
                '}';
    }
}
