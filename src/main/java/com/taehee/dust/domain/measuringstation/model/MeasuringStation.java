package com.taehee.dust.domain.measuringstation.model;

import com.taehee.dust.common.audit.BaseTimeEntity;
import com.taehee.dust.domain.location.model.Location;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "question")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MeasuringStation extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id")
    private Location location;

    protected MeasuringStation(String name, Location location) {
        this.name = name;
        this.location = location;
    }
}
