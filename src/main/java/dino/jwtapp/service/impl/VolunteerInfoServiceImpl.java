package dino.jwtapp.service.impl;

import dino.jwtapp.model.VolunteerInfo;
import dino.jwtapp.repository.VolunteerInfoRepository;
import dino.jwtapp.service.VolunteerInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
@Transactional
public class VolunteerInfoServiceImpl implements VolunteerInfoService
{
    private final VolunteerInfoRepository volunteerInfoRepository;

    public VolunteerInfoServiceImpl(VolunteerInfoRepository volunteerInfoRepository)
    {
        this.volunteerInfoRepository = volunteerInfoRepository;
    }

    @Override
    public List<VolunteerInfo> getAllViews()
    {
        List<VolunteerInfo> result = volunteerInfoRepository.findAll();
        log.info("IN getAll - {} volunteers found", result.size());
        return result;
    }
}
