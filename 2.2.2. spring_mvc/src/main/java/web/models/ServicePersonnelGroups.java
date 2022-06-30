package web.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class ServicePersonnelGroups {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany
    @JoinColumn
    private Set<Subgroups> subgroups;
    @OneToMany
    @JoinColumn
    private Set<Equipment> equipments;
    @ManyToMany
    @JoinColumn
    private Set<PlaceOfOperation> placesOfOperations;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Subgroups> getSubgroups() {
        return subgroups;
    }

    public void setSubgroups(Set<Subgroups> subgroups) {
        this.subgroups = subgroups;
    }

    public Set<Equipment> getEquipments() {
        return equipments;
    }

    public void setEquipments(Set<Equipment> equipments) {
        this.equipments = equipments;
    }

    public Set<PlaceOfOperation> getPlacesOfOperations() {
        return placesOfOperations;
    }

    public void setPlacesOfOperations(Set<PlaceOfOperation> placesOfOperations) {
        this.placesOfOperations = placesOfOperations;
    }
}
