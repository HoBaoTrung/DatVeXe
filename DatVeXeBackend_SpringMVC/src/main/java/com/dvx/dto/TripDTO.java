package com.dvx.dto;


import com.dvx.pojo.Seat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TripDTO implements Serializable {
    private Long id;
    private String carImage;
    private String carNumber;
    private String nameCarType;
    private String price;
    private String departureTime;
    private String departureDate;
    private Set<Seat> setSeat;
}