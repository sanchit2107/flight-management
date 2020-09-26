package com.capgemini.flightmanagement.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.capgemini.flightmanagement.entity.BookingDetails;


/**
 * @author Sameeksha Janghela
 */
@Repository
public interface BookingDetailsDao extends JpaRepository<BookingDetails, Integer> {

}
