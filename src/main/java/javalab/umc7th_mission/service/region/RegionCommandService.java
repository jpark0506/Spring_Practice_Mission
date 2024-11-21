package javalab.umc7th_mission.service.region;

import java.util.List;
import javalab.umc7th_mission.domain.Region;
import javalab.umc7th_mission.domain.Store;
import javalab.umc7th_mission.global.code.ErrorStatus;
import javalab.umc7th_mission.global.exception.GeneralException;
import javalab.umc7th_mission.repository.RegionRepository;
import javalab.umc7th_mission.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class RegionCommandService {

    private final RegionRepository regionRepository;
    private final StoreRepository storeRepository;

    public Integer addStoreToRegion(Integer regionId, Integer storeId) {

        Region region = regionRepository.findById(regionId).orElseThrow(
            () -> new GeneralException(ErrorStatus.REGION_NOT_FOUND));

        Store store = storeRepository.findById(storeId).orElseThrow(
            () -> new GeneralException(ErrorStatus.STORE_NOT_FOUND));

        store.changeRegion(region);

        return store.getId();
    }

    public Region createRegion(String name) {
        Region region = Region.builder()
            .name(name)
            .build();

        return regionRepository.save(region);
    }

    public Integer updateRegion(Integer regionId, String newName) {
        Region region = regionRepository.findById(regionId).orElseThrow(
            () -> new GeneralException(ErrorStatus.REGION_NOT_FOUND));

        region.changeName(newName);

        return region.getId();
    }

    public Boolean deleteRegion(Integer regionId) {
        Region region = regionRepository.findById(regionId).orElseThrow(
            () -> new GeneralException(ErrorStatus.REGION_NOT_FOUND));

        regionRepository.delete(region);

        return true;
    }


}
