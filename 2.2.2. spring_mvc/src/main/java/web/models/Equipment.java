package web.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Equipment {
    private Long id;
    private String numberPosition;
    private String name;
    private boolean condition;
    @OneToMany
    private Set<Defects> defects;
    @ManyToOne
    private PlaceOfOperation placeOfOperation;
    @ManyToOne
    private ServicePersonnelGroups servicePersonnelGroup;
    @ManyToOne
    private Subgroups subgroup;


    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumberPosition() {
        return numberPosition;
    }

    public void setNumberPosition(String numberPosition) {
        this.numberPosition = numberPosition;
    }

    public boolean isCondition() {
        return condition;
    }

    public void setCondition(boolean condition) {
        this.condition = condition;
    }

    public Set<Defects> getDefects() {
        return defects;
    }

    public void setDefections(Set<Defects> defections) {
        this.defects = defections;
    }

    public void setDefects(Set<Defects> defects) {
        this.defects = defects;
    }

    public PlaceOfOperation getPlaceOfOperation() {
        return placeOfOperation;
    }

    public void setPlaceOfOperation(PlaceOfOperation placeOfOperation) {
        this.placeOfOperation = placeOfOperation;
    }

    public ServicePersonnelGroups getServicePersonnelGroup() {
        return servicePersonnelGroup;
    }

    public void setServicePersonnelGroup(ServicePersonnelGroups servicePersonnelGroup) {
        this.servicePersonnelGroup = servicePersonnelGroup;
    }

    public Subgroups getSubgroup() {
        return subgroup;
    }

    public void setSubgroup(Subgroups subgroup) {
        this.subgroup = subgroup;
    }
}
