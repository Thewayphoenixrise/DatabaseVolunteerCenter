package dino.jwtapp.repository;

import dino.jwtapp.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventsRepository extends JpaRepository<Event, Long>
{
    Event findByName(String name);
}
