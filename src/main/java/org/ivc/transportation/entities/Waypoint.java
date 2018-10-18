/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ivc.transportation.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Nesterov Yuriy
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Waypoint implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NonNull
    @Column(nullable = false, length = 1024)
    private String name;
    
    @NonNull
    @Column(nullable = false)
    private Double latitude;
    
    @NonNull
    @Column(nullable = false)
    private Double longitude;
    
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Claim claim;
    
    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    private Work work;
    
    @ManyToMany(mappedBy = "waypoints")
    private List<Distance> distances;
    
    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    private TimedWaypoint timedWaypoint;
    
}
