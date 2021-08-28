package com.salareuniao.gerenciador.gerenciadorsalareuniao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salareuniao.gerenciador.gerenciadorsalareuniao.model.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long>{

}
