package com.boot.service.db.repositoryimpl;

import com.boot.service.db.mongomodel.EventDetailsModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface EventRepository extends MongoRepository<EventDetailsModel, Long> {

    @Query("{name : ?0}")
    public EventDetailsModel getEventByName(String name);

    @Query(value = " '$and' : [{name: ?0}, {location: ?1} ]}")
    public List<EventDetailsModel> getEventByNameAndLocation(String name, String location);


}
