package com.gahyun.board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gahyun.board.entity.LikyEntity;
import com.gahyun.board.entity.primaryKey.LikyPk;



@Repository
public interface LikyRepository extends JpaRepository<LikyEntity, LikyPk> {
   
    List<LikyEntity> findByBoardNumber(int boardNumber);
    
}