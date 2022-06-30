package web.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Subgroups {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany
    @JoinColumn
    private Set<Equipment> equipments;
    @ManyToOne
    private ServicePersonnelGroups servicePersonnelGroup;

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

    public Set<Equipment> getEquipments() {
        return equipments;
    }

    public void setEquipments(Set<Equipment> equipments) {
        this.equipments = equipments;
    }

    public ServicePersonnelGroups getServicePersonnelGroup() {
        return servicePersonnelGroup;
    }

    public void setServicePersonnelGroup(ServicePersonnelGroups servicePersonnelGroup) {
        this.servicePersonnelGroup = servicePersonnelGroup;
    }
}
