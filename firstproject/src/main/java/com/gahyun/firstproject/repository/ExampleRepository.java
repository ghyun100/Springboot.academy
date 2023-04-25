package com.gahyun.firstproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gahyun.firstproject.entity.ExampleEntity;

@Repository
public interface ExampleRepository extends JpaRepository<ExampleEntity, Integer>{

    public ExampleEntity findByPk(int pk);
    public List<ExampleEntity> findByExampleColumn3AndExampleColumn2(boolean exampleColumn3, String exampleColumn2);
    public boolean existsByExampleColumn3(boolean exampleColumn3); // 존재하는지 안하는지를 반환

    


}
