package com.luxoft.repository;

import com.luxoft.model.Wagon;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Getter @Setter
public class WagonRepository {

    private final List<Wagon> wagonList;
}
