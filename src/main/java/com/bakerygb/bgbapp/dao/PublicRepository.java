package com.bakerygb.bgbapp.dao;

import com.bakerygb.bgbapp.models.AUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicRepository extends JpaRepository<AUser, Long> {
}
