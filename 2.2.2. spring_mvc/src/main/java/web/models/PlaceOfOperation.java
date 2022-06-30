package web.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class PlaceOfOperation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany
    @JoinColumn
    private Set<ServicePersonnelGroups> servicePersonnelGroups;
    @OneToMany
    @JoinColumn
    private Set<Equipment> equipments;

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

    public Set<ServicePersonnelGroups> getServicePersonnelGroups() {
        return servicePersonnelGroups;
    }

    public void setServicePersonnelGroups(Set<ServicePersonnelGroups> servicePersonnelGroups) {
        this.servicePersonnelGroups = servicePersonnelGroups;
    }

    public Set<Equipment> getEquipments() {
        return equipments;
    }

    public void setEquipments(Set<Equipment> equipments) {
        this.equipments = equipments;
    }
}
