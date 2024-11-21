package javalab.umc7th_mission.service.region;

import java.util.List;
import javalab.umc7th_mission.domain.Region;
import javalab.umc7th_mission.global.code.ErrorStatus;
import javalab.umc7th_mission.global.exception.GeneralException;
import javalab.umc7th_mission.repository.RegionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class RegionQueryService {

    private final RegionRepository regionRepository;

    @Transactional(readOnly = true)
    public Region getRegionById(Integer regionId) {
        return regionRepository.findById(regionId).orElseThrow(
            () -> new GeneralException(ErrorStatus.REGION_NOT_FOUND));
    }

    @Transactional(readOnly = true)
    public List<Region> getAllRegions() {
        return regionRepository.findAll();
    }
}
