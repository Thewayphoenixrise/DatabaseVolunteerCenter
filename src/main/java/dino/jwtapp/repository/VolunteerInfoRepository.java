package dino.jwtapp.repository;

import dino.jwtapp.model.VolunteerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VolunteerInfoRepository extends JpaRepository<VolunteerInfo, Long>
{
    VolunteerInfo getById(int id);
}
