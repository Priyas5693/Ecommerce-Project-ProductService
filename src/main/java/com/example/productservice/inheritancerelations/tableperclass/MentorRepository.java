package com.example.productservice.inheritancerelations.tableperclass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("tpc_mentorRepository")
public interface MentorRepository extends JpaRepository<Mentor,Long> {
    @Override
    Mentor save(Mentor mentor);
}
