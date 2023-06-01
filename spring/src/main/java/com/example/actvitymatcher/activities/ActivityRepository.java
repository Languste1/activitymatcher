package com.example.actvitymatcher.activities;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity, Integer> {

    Activity findByActivityId(Integer activityId);


}
